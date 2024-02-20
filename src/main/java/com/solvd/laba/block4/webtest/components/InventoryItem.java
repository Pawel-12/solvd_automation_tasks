package com.solvd.laba.block4.webtest.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class InventoryItem extends AbstractUIObject {
    @FindBy(css = " img.inventory_item_img")
    private ExtendedWebElement imageElement;

    @FindBy(css = " div.inventory_item_name")
    private ExtendedWebElement nameElement;

    @FindBy(css = " div.inventory_item_desc")
    private ExtendedWebElement descriptionElement;

    @FindBy(css = " div.inventory_item_price")
    private ExtendedWebElement priceElement;

    @FindBy(css = " button.btn_inventory")
    private ExtendedWebElement addToCartButton;

    public InventoryItem(WebDriver driver) {
        super(driver);
    }

    public InventoryItem(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void clickCartButton() {
        addToCartButton.click();
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

    public void clickImage() {
        imageElement.click();
    }
}
