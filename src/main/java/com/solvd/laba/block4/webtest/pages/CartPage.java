package com.solvd.laba.block4.webtest.pages;

import com.solvd.laba.block4.webtest.components.CartItem;
import com.zebrunner.carina.utils.config.Configuration;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends AbstractPage {

    @FindBy(css = "div.cart_item")
    private List<CartItem> items;
    @FindBy(css = "button#continue-shopping")
    private ExtendedWebElement continueButton;

    @FindBy(css = "button#checkout")
    private ExtendedWebElement checkoutButton;

    public CartPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(Configuration.getRequired("page.url") + "/cart.html");
    }

    public InventoryPage continueShopping() {
        continueButton.click();
        return new InventoryPage(getDriver());
    }

    public CheckoutStepOnePage goToCheckout() {
        checkoutButton.click();
        return new CheckoutStepOnePage(getDriver());
    }
}
