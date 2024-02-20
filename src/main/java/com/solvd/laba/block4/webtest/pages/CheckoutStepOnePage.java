package com.solvd.laba.block4.webtest.pages;

import com.zebrunner.carina.utils.config.Configuration;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CheckoutStepOnePage extends AbstractPage {
    @FindBy(css = "input#first-name")
    private ExtendedWebElement firstnameField;

    @FindBy(css = "input#last-name")
    private ExtendedWebElement lastnameField;

    @FindBy(css = "input#postal-code")
    private ExtendedWebElement postalCodeField;

    @FindBy(css = "button#cancel")
    private ExtendedWebElement cancelButton;

    @FindBy(css = "input#continue")
    private ExtendedWebElement continueButton;

    public CheckoutStepOnePage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(Configuration.getRequired("page.url") + "/checkout-step-one.html");
    }

    public CartPage cancelCheckout() {
        cancelButton.click();
        return new CartPage(getDriver());
    }

    public CheckoutStepTwoPage continueCheckout(String firstname, String lastname, String postalCode) {
        firstnameField.type(firstname);
        lastnameField.type(lastname);
        postalCodeField.type(postalCode);

        continueButton.click();
        return new CheckoutStepTwoPage(getDriver());
    }
}
