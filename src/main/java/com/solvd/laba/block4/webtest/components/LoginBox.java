package com.solvd.laba.block4.webtest.components;

import com.solvd.laba.block4.webtest.pages.InventoryPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginBox extends AbstractUIObject {
    @FindBy(css = " #user-name")
    private ExtendedWebElement usernameField;

    @FindBy(css = " #password")
    private ExtendedWebElement passwordField;

    @FindBy(css = " #login-button")
    private ExtendedWebElement loginButton;

    public LoginBox(WebDriver driver) {
        super(driver);
    }

    public LoginBox(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public InventoryPage tryLogin(String username, String password) {
        usernameField.type(username);
        passwordField.type(password);
        loginButton.click();

        return new InventoryPage(getDriver());
    }
}
