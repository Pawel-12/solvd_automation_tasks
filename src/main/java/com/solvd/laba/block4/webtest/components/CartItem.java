package com.solvd.laba.block4.webtest.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CartItem extends AbstractUIObject {
    @FindBy(css = " div.inventory_item_name")
    private ExtendedWebElement nameElement;

    @FindBy(css = " div.inventory_item_desc")
    private ExtendedWebElement descriptionElement;

    @FindBy(css = " div.inventory_item_price")
    private ExtendedWebElement priceElement;

    @FindBy(css = " button.cart_button")
    private ExtendedWebElement removeButton;

    public CartItem(WebDriver driver) {
        super(driver);
    }

    public CartItem(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void clickCartButton() {
        removeButton.click();
    }

    public String getName() {
        return nameElement.getText();
    }

    public String getDescription() {
        return descriptionElement.getText();
    }

    public String getPrice() {
        return priceElement.getText().substring(1);
    }

    public void clickName() {
        nameElement.click();
    }
}
