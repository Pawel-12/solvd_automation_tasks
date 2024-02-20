package com.solvd.laba.block4.webtest.pages;

import com.solvd.laba.block4.webtest.components.InventoryItem;
import com.solvd.laba.block4.webtest.components.ShoppingCartIcon;
import com.solvd.laba.block4.webtest.components.SideMenu;
import com.zebrunner.carina.utils.config.Configuration;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class InventoryPage extends AbstractPage {
    @FindBy(css = ".inventory_item")
    private List<InventoryItem> items;

    @FindBy(xpath = "//select[@class=\"product_sort_container\"]")
    private ExtendedWebElement productSortSelect;

    @FindBy(css = "div#shopping_cart_container")
    private ShoppingCartIcon cartIcon;

    @FindBy(css = "div#menu_button_container")
    private SideMenu sideMenu;

    public InventoryPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(Configuration.getRequired("page.url") + "/inventory.html");
    }

    public void open(String username, String password) {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.open();
        loginPage.assertPageOpened();

        loginPage.tryLogin(username, password).assertPageOpened();
    }

    public List<InventoryItem> getItems() {
        return items;
    }

    public ShoppingCartIcon getCartIcon() {
        return cartIcon;
    }

    public SideMenu getSideMenu() {
        return sideMenu;
    }

    public List<InventoryItem> sortProducts(int index) {
        productSortSelect.select(index);
        return items;
    }
}
