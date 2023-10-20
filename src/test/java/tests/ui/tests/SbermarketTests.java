package tests.ui.tests;

import com.codeborne.selenide.Configuration;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.ui.steps.SbermarketSteps;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class SbermarketTests {
    private SbermarketSteps sbermarketSteps;

    @BeforeClass(alwaysRun = true)
    void beforeClass() {
        sbermarketSteps = new SbermarketSteps();
    }

    @BeforeMethod
    public void beforeMethod() {
        Configuration.startMaximized = true;
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver118");
        open("https://sbermarket.ru/");
    }

    @AfterMethod
    public void afterMethod() {
        closeWebDriver();
    }

    @Test(description = "Поиск")
    public void searchTest() {
        String productNameExp = "Яблоки сезонные";
        String productNameActual = sbermarketSteps.search(productNameExp);
        Assert.assertEquals(productNameActual, productNameExp, "Названия не совпадают");
    }
}
