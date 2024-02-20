package com.solvd.laba.block4.webtest;

import com.solvd.laba.block4.webtest.pages.InventoryPage;
import com.solvd.laba.block4.webtest.pages.LoginPage;
import com.zebrunner.carina.core.AbstractTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginPageTest extends AbstractTest {
    @Test(dataProvider = "CorrectLoginData")
    public void loginTest(String username, String password) {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.open();
        loginPage.assertPageOpened();

        loginPage.tryLogin(username, password).assertPageOpened();
    }

    @Test(dataProvider = "WrongLoginData")
    public void loginTestFail(String username, String password) {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.open();
        loginPage.assertPageOpened();

        loginPage.tryLogin(username, password);
        loginPage.assertPageOpened();
    }

    @Test()
    public void loginSkipTest() {
        LoginPage loginPage = new LoginPage(getDriver());
        InventoryPage inventoryPage = new InventoryPage(getDriver());

        inventoryPage.open();
        Assert.assertFalse(inventoryPage.isPageOpened(0));
        loginPage.assertPageOpened(0);
    }

    @DataProvider(parallel = true, name = "CorrectLoginData")
    public static Object[][] correctLoginData() {
        return new Object[][]{
                {"standard_user", "secret_sauce"},
                {"problem_user", "secret_sauce"},
                {"performance_glitch_user", "secret_sauce"},
                {"error_user", "secret_sauce"},
                {"visual_user", "secret_sauce"}};
    }

    @DataProvider(parallel = true, name = "WrongLoginData")
    public static Object[][] wrongLoginData() {
        return new Object[][]{
                {"locked_out_user", "secret_sauce"},
                {"problem_user", ""},
                {"", "secret_sauce"},
                {"1234", "1234"},
                {"", ""}};
    }
}
