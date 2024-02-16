package com.solvd.laba.block4.webtest;

import com.solvd.laba.block4.webtest.pages.InventoryPage;
import com.solvd.laba.block4.webtest.pages.LoginPage;
import com.zebrunner.carina.core.AbstractTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginPageTest extends AbstractTest {
    @Test(dataProvider = "DP1")
    public void loginTest(String username, String password) {
        LoginPage page = new LoginPage(getDriver());
        page.open();
        page.assertPageOpened();

        page.tryLogin(username, password).assertPageOpened();
    }

    @Test(dataProvider = "DP2")
    public void loginTestFail(String username, String password) {
        LoginPage page = new LoginPage(getDriver());
        page.open();
        page.assertPageOpened();

        page.tryLogin(username, password);
        page.assertPageOpened();
    }

    @Test()
    public void loginSkipTest() {
        LoginPage loginPage = new LoginPage(getDriver());
        InventoryPage inventoryPage = new InventoryPage(getDriver());

        inventoryPage.open();
        loginPage.assertPageOpened();
    }

    @DataProvider(parallel = true, name = "DP1")
    public static Object[][] dataprovider() {
        return new Object[][]{
                {"standard_user", "secret_sauce"},
                {"problem_user", "secret_sauce"},
                {"performance_glitch_user", "secret_sauce"},
                {"error_user", "secret_sauce"},
                {"visual_user", "secret_sauce"}};
    }

    @DataProvider(parallel = true, name = "DP2")
    public static Object[][] dataprovider2() {
        return new Object[][]{
                {"locked_out_user", "secret_sauce"},
                {"problem_user", ""},
                {"", "secret_sauce"},
                {"1234", "1234"},
                {"", ""}};
    }
}
