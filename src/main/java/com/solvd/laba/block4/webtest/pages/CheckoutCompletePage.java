package com.solvd.laba.block4.webtest.pages;

import com.zebrunner.carina.utils.config.Configuration;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CheckoutCompletePage extends AbstractPage {
    @FindBy(css = "button#back-to-products")
    private ExtendedWebElement backToProductsButton;

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(Configuration.getRequired("page.url") + "/checkout-complete.html");
    }

    public InventoryPage goBackToProducts() {
        backToProductsButton.click();
        return new InventoryPage(getDriver());
    }
}
