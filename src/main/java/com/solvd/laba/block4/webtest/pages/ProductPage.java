package com.solvd.laba.block4.webtest.pages;

import com.zebrunner.carina.utils.config.Configuration;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public class ProductPage extends AbstractPage {
    public ProductPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(Configuration.getRequired("page.url") + "/inventory-item.html");
    }

    public ProductPage(WebDriver driver, Integer id) {
        super(driver);
        setPageAbsoluteURL(Configuration.getRequired("page.url") + "/inventory-item.html?id="
                + id.toString());
    }
}
