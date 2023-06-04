package ru.netology.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.page.LoginPage;
import ru.netology.page.PersonalAreaPage;

import java.util.Locale;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.netology.data.DataHelper.*;

public class MoneyTransferTest {
    LoginPage loginPage;
    PersonalAreaPage personalAreaPage;

    @BeforeEach
    void loginToYourPersonalAccount() {
        var loginPage = open("http://localhost:9999", LoginPage.class);
        var authInfo = DataHelper.getAuthInfo();
        var verificationPage = loginPage.validLogin(authInfo);
        var verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        personalAreaPage =  verificationPage.validVerify(verificationCode);
    }

    @Test
    void shouldTransferMoneyBetweenOwnCards() {
        var firstCardInfo = getFirstCardInfo();
        var secondCardInfo = getSecondCardInfo();
        var firstCardBalance = personalAreaPage.getCardBalance(firstCardInfo);
        var secondCardBalance = personalAreaPage.getCardBalance(secondCardInfo);
        var amount = generateValidAmount(firstCardBalance);
        var expectedBalanceFirstCard = firstCardBalance - amount;
        var expectedBalanceSecondCard = secondCardBalance + amount;
        var transferPage = personalAreaPage.selectCardToTransfer(secondCardInfo);
        personalAreaPage = transferPage.validMoneyTransfer(String.valueOf(amount), firstCardInfo);
        var actualBalanceFirstCard = personalAreaPage.getCardBalance(firstCardInfo);
        var actualBalanceSecondCard = personalAreaPage.getCardBalance(secondCardInfo);
        assertEquals(expectedBalanceFirstCard, actualBalanceFirstCard);
        assertEquals(expectedBalanceSecondCard, actualBalanceSecondCard);
    }
}
