package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class SbermarketPage {
    public static SelenideElement metroButton = $x("//a[@href='/metro']/picture/..");
    public static SelenideElement searchField = $x("//input[@data-qa='suggester_header_form_input']");
    public static SelenideElement searchButton = $x("//button[@data-qa='suggester_header_form_search_button']");
    public static SelenideElement firstProductLabel = $x("//div[contains(@class, 'ProductsGrid')]//div[contains(@class, 'ProductCard')][1]//h3");
}
