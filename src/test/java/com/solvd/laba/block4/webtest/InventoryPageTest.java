package com.solvd.laba.block4.webtest;

import com.solvd.laba.block4.webtest.components.InventoryItem;
import com.solvd.laba.block4.webtest.pages.InventoryPage;
import com.zebrunner.carina.core.AbstractTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class InventoryPageTest extends AbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private final String testingUsername = "standard_user";
    private final String testingPassword = "secret_sauce";

    @Test
    public void logoutTest() {
        InventoryPage inventoryPage = new InventoryPage(getDriver());
        inventoryPage.open(testingUsername, testingPassword);

        inventoryPage.getSideMenu().logout().assertPageOpened();
    }

    @Test
    public void openCartTest() {
        InventoryPage inventoryPage = new InventoryPage(getDriver());
        inventoryPage.open(testingUsername, testingPassword);

        inventoryPage.getCartIcon().clickCartIcon().assertPageOpened();
    }

    @Test
    public void sortingByNameTest() {
        InventoryPage inventoryPage = new InventoryPage(getDriver());
        inventoryPage.open(testingUsername, testingPassword);

        List<String> itemsNotSorted = inventoryPage.getItems().stream().map(InventoryItem::getName).toList();
        LOGGER.info("Not sorted = " + itemsNotSorted + "\n");

        List<String> itemsSorted = inventoryPage.sortProducts(0).stream().map(InventoryItem::getName).toList();
        Assert.assertEquals(itemsNotSorted.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList()), itemsSorted);
        LOGGER.info("Sorted ascending = " + itemsSorted + "\n");

        itemsSorted = inventoryPage.sortProducts(1).stream().map(InventoryItem::getName).toList();
        Assert.assertEquals(itemsNotSorted.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()), itemsSorted);
        LOGGER.info("Sorted descending = " + itemsSorted + "\n");
    }

    @Test
    public void sortingByPriceTest() {
        InventoryPage inventoryPage = new InventoryPage(getDriver());
        inventoryPage.open(testingUsername, testingPassword);

        List<Double> itemsNotSorted = inventoryPage.getItems().stream().map(i -> Double.valueOf(i.getPrice())).toList();
        LOGGER.info("Not sorted = " + itemsNotSorted + "\n");

        List<Double> itemsSorted = inventoryPage.sortProducts(2).stream().map(i -> Double.valueOf(i.getPrice())).toList();
        Assert.assertEquals(itemsNotSorted.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList()), itemsSorted);
        LOGGER.info("Sorted ascending = " + itemsSorted + "\n");

        itemsSorted = inventoryPage.sortProducts(3).stream().map(i -> Double.valueOf(i.getPrice())).toList();
        Assert.assertEquals(itemsNotSorted.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()), itemsSorted);
        LOGGER.info("Sorted descending = " + itemsSorted + "\n");
    }

    @Test
    public void openingProductPagesTest() {
        InventoryPage inventoryPage = new InventoryPage(getDriver());
        inventoryPage.open(testingUsername, testingPassword);

        String urlImage;
        String urlName;

        var items = inventoryPage.getItems();

        for (int i = 0; i < items.size(); i++) {
            items.get(i).clickImage();
            urlImage = getDriver().getCurrentUrl();

            getDriver().navigate().back();
            items = inventoryPage.getItems();

            items.get(i).clickName();
            urlName = getDriver().getCurrentUrl();

            getDriver().navigate().back();
            items = inventoryPage.getItems();

            LOGGER.info("Checking " + urlName + " == " + urlImage + '\n');
            Assert.assertEquals(urlImage, urlName);
        }
    }

    @Test
    public void addingToCartTest() {
        InventoryPage inventoryPage = new InventoryPage(getDriver());
        inventoryPage.open(testingUsername, testingPassword);

        var items = inventoryPage.getItems();

        for (var item : items)
            item.clickCartButton();

        LOGGER.info("Items selected = " + (items.size()) + ", number displayed = " + inventoryPage.getCartIcon().getItemsNumber() + '\n');
        Assert.assertEquals(String.valueOf(items.size()), inventoryPage.getCartIcon().getItemsNumber());

        for (int i = items.size() - 1; i >= 0; i--) {
            items.get(i).clickCartButton();
            LOGGER.info("Items selected = " + i + ", number displayed = " + inventoryPage.getCartIcon().getItemsNumber() + '\n');
            Assert.assertEquals(String.valueOf(i), inventoryPage.getCartIcon().getItemsNumber());
        }
    }
}
