package tests.ui.steps;

;

import pages.SbermarketPage;

public class SbermarketSteps {
    public String search(String value) {
        SbermarketPage.metroButton.click();
        SbermarketPage.searchField.setValue(value);
        SbermarketPage.searchButton.click();
        return SbermarketPage.firstProductLabel.getText();
    }
}
