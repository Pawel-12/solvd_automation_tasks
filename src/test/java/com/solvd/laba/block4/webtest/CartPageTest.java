package com.solvd.laba.block4.webtest;

import com.solvd.laba.block4.webtest.pages.CartPage;
import com.solvd.laba.block4.webtest.pages.CheckoutStepOnePage;
import com.solvd.laba.block4.webtest.pages.InventoryPage;
import com.zebrunner.carina.core.AbstractTest;
import org.testng.annotations.Test;

public class CartPageTest extends AbstractTest {
    private final String testingUsername = "standard_user";
    private final String testingPassword = "secret_sauce";

    @Test
    public void continueShoppingTest() {
        InventoryPage inventoryPage = new InventoryPage(getDriver());
        inventoryPage.open(testingUsername, testingPassword);

        CartPage cartPage = inventoryPage.getCartIcon().clickCartIcon();
        cartPage.assertPageOpened();

        inventoryPage = cartPage.continueShopping();
        inventoryPage.assertPageOpened();
    }

    @Test
    public void goToCheckoutTest() {
        InventoryPage inventoryPage = new InventoryPage(getDriver());
        inventoryPage.open(testingUsername, testingPassword);

        CartPage cartPage = inventoryPage.getCartIcon().clickCartIcon();
        cartPage.assertPageOpened();

        CheckoutStepOnePage checkoutStepOnePage = cartPage.goToCheckout();
        checkoutStepOnePage.assertPageOpened();
    }
}
