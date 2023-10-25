package tests.ui.steps;
import io.qameta.allure.Step;
import pages.SbermarketPage;


public class SbermarketSteps {
    @Step("Удаляем сообщение о cookies")
    public void cookiesRemove(){
        SbermarketPage.cookiesButton.click();
    }
    @Step("Переходим в магазин Metro")
    public void metroClick() {
        SbermarketPage.metroButton.click();
    }
    @Step("Переходим в магазин Auchan")
    public void auchanClick() {
        SbermarketPage.auchanButton.click();
    }
    @Step("Ищем товар {value} в магазине")
    public String Search(String value) {
        SbermarketPage.searchField.setValue(value);
        SbermarketPage.searchButton.click();
        return SbermarketPage.firstProductPrice.getOwnText();
    }
}