package com.solvd.laba.block4.webtest;

import com.solvd.laba.block4.webtest.pages.CartPage;
import com.solvd.laba.block4.webtest.pages.CheckoutStepOnePage;
import com.solvd.laba.block4.webtest.pages.CheckoutStepTwoPage;
import com.solvd.laba.block4.webtest.pages.InventoryPage;
import com.zebrunner.carina.core.AbstractTest;
import org.testng.annotations.Test;

public class CheckoutStepTwoPageTest extends AbstractTest {
    private final String testingUsername = "standard_user";
    private final String testingPassword = "secret_sauce";

    private final String firstname = "Mike";
    private final String lastname = "Sauce";
    private final String postalCode = "123";

    @Test
    public void cancelCheckoutTest() {
        InventoryPage inventoryPage = new InventoryPage(getDriver());
        inventoryPage.open(testingUsername, testingPassword);

        CartPage cartPage = inventoryPage.getCartIcon().clickCartIcon();
        cartPage.assertPageOpened();

        CheckoutStepOnePage checkoutStepOnePage = cartPage.goToCheckout();
        checkoutStepOnePage.assertPageOpened();

        CheckoutStepTwoPage checkoutStepTwoPage = checkoutStepOnePage.continueCheckout(firstname, lastname, postalCode);
        checkoutStepTwoPage.assertPageOpened();

        checkoutStepTwoPage.cancelCheckout().assertPageOpened();
    }

    @Test
    public void finishCheckoutTest() {
        InventoryPage inventoryPage = new InventoryPage(getDriver());
        inventoryPage.open(testingUsername, testingPassword);

        CartPage cartPage = inventoryPage.getCartIcon().clickCartIcon();
        cartPage.assertPageOpened();

        CheckoutStepOnePage checkoutStepOnePage = cartPage.goToCheckout();
        checkoutStepOnePage.assertPageOpened();

        CheckoutStepTwoPage checkoutStepTwoPage = checkoutStepOnePage.continueCheckout(firstname, lastname, postalCode);
        checkoutStepTwoPage.assertPageOpened();

        checkoutStepTwoPage.finishCheckout().assertPageOpened();
    }
}
