package com.solvd.laba.block4.webtest.pages;

import com.zebrunner.carina.utils.config.Configuration;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public class InventoryPage extends AbstractPage {
    public InventoryPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(Configuration.getRequired("page.url") + "/inventory.html");
    }
}
