package com.solvd.laba.block4.webtest.components;

import com.solvd.laba.block4.webtest.pages.LoginPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SideMenu extends AbstractUIObject {
    @FindBy(css = " button#react-burger-menu-btn")
    private ExtendedWebElement openButton;

    @FindBy(css = " button#react-burger-cross-btn")
    private ExtendedWebElement closeButton;

    @FindBy(css = " a#inventory_sidebar_link")
    private ExtendedWebElement inventoryLink;

    @FindBy(css = " a#about_sidebar_link")
    private ExtendedWebElement aboutLink;

    @FindBy(css = " a#logout_sidebar_link")
    private ExtendedWebElement logoutLink;

    @FindBy(css = " a#reset_sidebar_link")
    private ExtendedWebElement resetLink;

    public SideMenu(WebDriver driver) {
        super(driver);
    }

    public SideMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public LoginPage logout() {
        openButton.click();
        logoutLink.click();
        return new LoginPage(getDriver());
    }
}
