package tests.ui.tests;

import io.qameta.allure.*;
import com.codeborne.selenide.Configuration;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.ui.steps.SbermarketSteps;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

@Epic("UI тесты")
@Feature("Reqres тесты")
@Story("Search price")
public class SbermarketTests {
    private SbermarketSteps sbermarketSteps;

    @BeforeClass(alwaysRun = true)
    void beforeClass() {
        sbermarketSteps = new SbermarketSteps();
    }

    @Description(value = "Запуск драйвера chrome")
    @BeforeMethod
    public void beforeMethod() {
        Configuration.startMaximized = true;
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver118");
        open("https://sbermarket.ru/");
        sbermarketSteps.cookiesRemove();
    }

    @AfterMethod
    public void afterMethod() {
        closeWebDriver();
    }

    @Test(description = "Поиск и сравнение цен на товары в разных магазинах")
    public void searchTest() {
        String productName = "Чиабатта";
        sbermarketSteps.metroClick();
        String priceMetro = sbermarketSteps.search(productName);

        open("https://sbermarket.ru/");
        sbermarketSteps.auchanClick();
        String priceAuchan = sbermarketSteps.search(productName);
        Assert.assertNotEquals(priceMetro, priceAuchan, "Цены совпадают");
    }
}
