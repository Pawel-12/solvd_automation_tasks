package com.solvd.laba.block4.webtest.components;

import com.solvd.laba.block4.webtest.pages.CartPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartIcon extends AbstractUIObject {
    @FindBy(css = " .shopping_cart_link")
    private ExtendedWebElement cartLink;

    @FindBy(css = " .shopping_cart_badge")
    private ExtendedWebElement itemsNumber;

    public ShoppingCartIcon(WebDriver driver) {
        super(driver);
    }

    public ShoppingCartIcon(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public CartPage clickCartIcon() {
        cartLink.click();
        return new CartPage(getDriver());
    }

    public String getItemsNumber() {
        if (itemsNumber.isPresent())
            return itemsNumber.getText();
        else return "0";
    }
}
