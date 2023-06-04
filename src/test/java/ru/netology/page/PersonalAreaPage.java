package ru.netology.page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataHelper;


import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;


public class PersonalAreaPage {

    private final String balanceStart = "баланс: ";
    private final String balanceFinish = "р.";
    private static final ElementsCollection cards = $$(".list__item div");
    private final SelenideElement heading = $("[data-test-id=dashboard]");

    public PersonalAreaPage() {
       heading.shouldBe(visible);
    }

    public int getCardBalance (DataHelper.CardInfo cardInfo) {
        var text = cards.findBy(text(cardInfo.getCardNumber().substring(1))).getText();
        return extractBalance(text);
    }

    //public int getCardBalance (int index){
       // var text = cards.get(index).getText();
        //return extractBalance(text);
   //}
    public TranslationPage selectCardToTransfer(DataHelper.CardInfo cardInfo) {
        cards.findBy(text(cardInfo.getCardNumber().substring( 15))).$("button").click();
        return new TranslationPage();
    }

    public int extractBalance(String text) {
        var start = text.indexOf(balanceStart);
        var finish = text.indexOf(balanceFinish);
        var value = text.substring(start + balanceStart.length(), finish);
        return Integer.parseInt(value);
    }
}
