package com.solvd.laba.block4.webtest.pages;

import com.zebrunner.carina.utils.config.Configuration;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CheckoutStepTwoPage extends AbstractPage {
    @FindBy(css = "button#cancel")
    private ExtendedWebElement cancelButton;

    @FindBy(css = "button#finish")
    private ExtendedWebElement finishButton;

    public CheckoutStepTwoPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(Configuration.getRequired("page.url") + "/checkout-step-two.html");
    }

    public InventoryPage cancelCheckout() {
        cancelButton.click();
        return new InventoryPage(getDriver());
    }

    public CheckoutCompletePage finishCheckout() {
        finishButton.click();
        return new CheckoutCompletePage(getDriver());
    }
}
