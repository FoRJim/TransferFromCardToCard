package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import ru.netology.data.DataHelper;

public class VerificationPage {

    @FindBy (css = "[data-test-id=code] input")
    private SelenideElement enterCode;
    @FindBy (css = "[data-test-id=action-verify]")
    private SelenideElement enterButtonVerify;

    public VerificationPage() {
        enterCode.shouldBe(Condition.visible);
    }

    public  PersonalAreaPage validVerify(DataHelper.VerificationCode verificationCode){
        enterCode.setValue(verificationCode.getCode());
        enterButtonVerify.click();
        return new PersonalAreaPage();
    }
}
