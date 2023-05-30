package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataHelper;

import static com.codeborne.selenide.Selenide.$;

public class VerificationPage {

    private SelenideElement enterCode = $("[data-test-id=code] input");
    private SelenideElement enterButtonVerify = $ ("[data-test-id=action-verify]");

    public VerificationPage() {
        enterCode.shouldBe(Condition.visible);
    }

    public  PersonalAreaPage validVerify(DataHelper.VerificationCode verificationCode){
        enterCode.setValue(verificationCode.getCode());
        enterButtonVerify.click();
        return new PersonalAreaPage();
    }
}
