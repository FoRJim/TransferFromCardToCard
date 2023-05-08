package ru.netology.page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import ru.netology.data.DataHelper;

import static com.codeborne.selenide.Selenide.page;


public class LoginPage {
    @FindBy(css = "[data-test-id=login] input")
    private SelenideElement enterLogin;
    @FindBy (css = "[data-test-id=password] input")
    private  SelenideElement enterPassword;
    @FindBy (css = "[data-test-id=action-login]")
    private SelenideElement enterButton;

    public VerificationPage validLogin(DataHelper.AuthInfo info) {
        enterLogin.setValue(info.getLogin());
        enterPassword.setValue(info.getPassword());
        enterButton.click();
        return page(VerificationPage.class);
    }
}
