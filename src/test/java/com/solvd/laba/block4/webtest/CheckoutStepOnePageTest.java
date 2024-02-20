package com.solvd.laba.block4.webtest;

import com.solvd.laba.block4.webtest.pages.CartPage;
import com.solvd.laba.block4.webtest.pages.CheckoutStepOnePage;
import com.solvd.laba.block4.webtest.pages.InventoryPage;
import com.zebrunner.carina.core.AbstractTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CheckoutStepOnePageTest extends AbstractTest {
    private final String testingUsername = "standard_user";
    private final String testingPassword = "secret_sauce";

    @Test
    public void cancelCheckoutTest() {
        InventoryPage inventoryPage = new InventoryPage(getDriver());
        inventoryPage.open(testingUsername, testingPassword);

        CartPage cartPage = inventoryPage.getCartIcon().clickCartIcon();
        cartPage.assertPageOpened();

        CheckoutStepOnePage checkoutStepOnePage = cartPage.goToCheckout();
        checkoutStepOnePage.assertPageOpened();

        checkoutStepOnePage.cancelCheckout().assertPageOpened();
    }

    @Test(dataProvider = "CorrectCheckoutData")
    public void continueCheckoutTest(String firstname, String lastname, String postalCode) {
        InventoryPage inventoryPage = new InventoryPage(getDriver());
        inventoryPage.open(testingUsername, testingPassword);

        CartPage cartPage = inventoryPage.getCartIcon().clickCartIcon();
        cartPage.assertPageOpened();

        CheckoutStepOnePage checkoutStepOnePage = cartPage.goToCheckout();
        checkoutStepOnePage.assertPageOpened();

        checkoutStepOnePage.continueCheckout(firstname, lastname, postalCode).assertPageOpened();
    }

    @Test(dataProvider = "WrongCheckoutData")
    public void continueCheckoutTestFail(String firstname, String lastname, String postalCode) {
        InventoryPage inventoryPage = new InventoryPage(getDriver());
        inventoryPage.open(testingUsername, testingPassword);

        CartPage cartPage = inventoryPage.getCartIcon().clickCartIcon();
        cartPage.assertPageOpened();

        CheckoutStepOnePage checkoutStepOnePage = cartPage.goToCheckout();
        checkoutStepOnePage.assertPageOpened();

        checkoutStepOnePage.continueCheckout(firstname, lastname, postalCode);

        checkoutStepOnePage.assertPageOpened();
    }

    @DataProvider(parallel = true, name = "CorrectCheckoutData")
    public static Object[][] correctCheckoutData() {
        return new Object[][]{
                {"standard_user", "secret_sauce", "124"},
                {" ", " ", " "},
                {"a", "a", "a"}};
    }

    @DataProvider(parallel = true, name = "WrongCheckoutData")
    public static Object[][] WrongCheckoutData() {
        return new Object[][]{
                {"standard_user", "secret_sauce", ""},
                {"standard_user", "", "124"},
                {"", "secret_sauce", "124"},
                {"", "", "124"},
                {"standard_user", "", ""},
                {"", "secret_sauce", ""}};
    }
}
