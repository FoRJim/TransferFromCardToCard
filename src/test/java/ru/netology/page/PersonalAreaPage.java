package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;


import static com.codeborne.selenide.Selenide.$;

public class PersonalAreaPage {

    private SelenideElement personalArea = $("[data-test-id=dashboard]");

    public PersonalAreaPage() {
        personalArea.shouldBe(Condition.visible);
    }
}
