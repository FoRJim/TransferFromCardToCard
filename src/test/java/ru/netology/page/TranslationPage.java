package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataHelper;

import static com.codeborne.selenide.Selenide.$;

public class TranslationPage {
    private final SelenideElement topUpButton = $("[data-test-id=action-deposit]");
    private final SelenideElement amountInput = $("[data-test-id=amount] input");
    private final SelenideElement fromInput = $("[data-test-id=from] input");
    private final SelenideElement transferButton = $("[data-test-id=action-transfer]");

    public TranslationPage() {
        transferButton.shouldBe(Condition.visible);
    }

    public void moneyTransfer (String amountToTransfer, DataHelper.CardInfo cardInfo) {
        amountInput.setValue(amountToTransfer);
        fromInput.setValue(cardInfo.getCardNumber());
        transferButton.click();
    }

    public PersonalAreaPage validMoneyTransfer (String amountToTransfer, DataHelper.CardInfo cardInfo) {
        moneyTransfer(amountToTransfer, cardInfo);
        return new PersonalAreaPage();
    }
}
