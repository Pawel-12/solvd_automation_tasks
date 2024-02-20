package com.solvd.laba.block4.webtest.pages;

import com.solvd.laba.block4.webtest.components.LoginBox;
import com.zebrunner.carina.utils.config.Configuration;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {
    @FindBy(css = "div.login-box")
    private LoginBox loginBox;

    public LoginPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(Configuration.getRequired("page.url"));
    }

    public InventoryPage tryLogin(String username, String password) {
        return loginBox.tryLogin(username, password);
    }
}
