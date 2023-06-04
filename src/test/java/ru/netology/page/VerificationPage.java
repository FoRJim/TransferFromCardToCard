package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataHelper;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class VerificationPage {

    private final SelenideElement enterCode = $("[data-test-id=code] input");
    private final SelenideElement enterButtonVerify = $ ("[data-test-id=action-verify]");

    public VerificationPage() {
        enterCode.shouldBe(visible);
    }

    public  PersonalAreaPage validVerify(DataHelper.VerificationCode verificationCode){
        enterCode.setValue(verificationCode.getCode());
        enterButtonVerify.click();
        return new PersonalAreaPage();
    }
}
