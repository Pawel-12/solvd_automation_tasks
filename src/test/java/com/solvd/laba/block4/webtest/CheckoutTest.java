package com.solvd.laba.block4.webtest;

import com.solvd.laba.block4.webtest.pages.*;
import com.zebrunner.carina.core.AbstractTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTest extends AbstractTest {
    private final String testingUsername = "standard_user";
    private final String testingPassword = "secret_sauce";

    @Test
    public void checkoutTest() {
        InventoryPage inventoryPage = new InventoryPage(getDriver());
        inventoryPage.open(testingUsername, testingPassword);

        inventoryPage.getItems().get(0).clickCartButton();
        CartPage cartPage = inventoryPage.getCartIcon().clickCartIcon();
        cartPage.assertPageOpened();

        CheckoutStepOnePage checkoutStepOnePage = cartPage.goToCheckout();
        checkoutStepOnePage.assertPageOpened();

        CheckoutStepTwoPage checkoutStepTwoPage =
                checkoutStepOnePage.continueCheckout("a", "a", "a");

        checkoutStepTwoPage.assertPageOpened();
        CheckoutCompletePage checkoutCompletePage = checkoutStepTwoPage.finishCheckout();

        checkoutCompletePage.assertPageOpened();

        inventoryPage = checkoutCompletePage.goBackToProducts();
        inventoryPage.assertPageOpened();

        Assert.assertEquals("0", inventoryPage.getCartIcon().getItemsNumber());
    }
}
