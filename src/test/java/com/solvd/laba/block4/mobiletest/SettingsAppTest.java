package com.solvd.laba.block4.mobiletest;

import com.solvd.laba.block4.mobiletest.pages.*;
import com.zebrunner.carina.core.AbstractTest;
import io.appium.java_client.android.nativekey.AndroidKey;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class SettingsAppTest extends AbstractTest {
    /**
     * Check if opening search works
     * 1. Click searchWidget on SettingsPage, result: SettingsSearchPage opens and keyboard is shown
     * 2. Type search query, result: searchField shows inputted text
     **/
    @Test(dataProvider = "SearchData")
    public void searchTest(List<AndroidKey> keys, String query) {
        SettingsPage settingsPage = new SettingsPage(getDriver());
        settingsPage.assertPageOpened();

        SettingsSearchPage settingsSearchPage = settingsPage.openSettingsSearch();
        settingsSearchPage.assertPageOpened();

        new FluentWait<>(settingsSearchPage.isKeyboardShown())
                .pollingEvery(Duration.ofMillis(50))
                .withTimeout(Duration.ofSeconds(4));

        Assert.assertTrue(settingsSearchPage.isKeyboardShown());
        settingsSearchPage.pressKeyboardKeys(keys);

        Assert.assertEquals(settingsSearchPage.getSearchFieldText(), query);
    }

    @DataProvider(parallel = true, name = "SearchData")
    public static Object[][] searchData() {
        return new Object[][]{
                {List.of(AndroidKey.W, AndroidKey.I, AndroidKey.F, AndroidKey.I), "wifi"}};
    }

    /**
     * Check if switching airplane mode works
     * 1. Click network settings category on SettingsPage, result: NetworkSettingsPage opens
     * 2. Click airplane mode switch, result: switch changes airplane mode status
     **/
    @Test
    public void airplaneModeSwitchTest() {
        SettingsPage settingsPage = new SettingsPage(getDriver());
        settingsPage.assertPageOpened();

        NetworkSettingsPage networkSettingsPage = settingsPage.openNetworkSettings();
        networkSettingsPage.assertPageOpened();

        networkSettingsPage.switchAirplaneMode();

        //Assert.assertFalse(networkSettingsPage.isWifiEnabled());
        Assert.assertEquals(networkSettingsPage.isAirplaneModeOn(), networkSettingsPage.isAirplaneModeEnabled());
    }

    /**
     * Check if switching battery percentage works
     * 1. Click battery settings category on SettingsPage, result: BatterySettingsPage opens
     * 2. Click  battery percentage switch, result: switch changes state
     **/
    @Test
    public void batteryPercentageSwitchTest() {
        SettingsPage settingsPage = new SettingsPage(getDriver());
        settingsPage.assertPageOpened();

        BatterySettingsPage batterySettingsPage = settingsPage.openBatterySettings();
        batterySettingsPage.assertPageOpened();

        var switchState = batterySettingsPage.isBatteryPercentageOn();
        batterySettingsPage.switchBatteryPercentage();

        Assert.assertNotEquals(switchState, batterySettingsPage.isBatteryPercentageOn());
    }

    /**
     * Check if battery settings display correct charge level
     * 1. Click battery settings category on SettingsPage, result: BatterySettingsPage opens
     * 2. Assert displayed value is same as actual
     **/
    @Test
    public void batteryChargeLevelDisplayTest() {
        SettingsPage settingsPage = new SettingsPage(getDriver());
        settingsPage.assertPageOpened();

        BatterySettingsPage batterySettingsPage = settingsPage.openBatterySettings();
        batterySettingsPage.assertPageOpened();

        Assert.assertEquals(batterySettingsPage.getBatteryChargeLevel(), batterySettingsPage.getBatteryInfo().getLevel() * 100);
    }

    /**
     * Check if changing device name works
     * 1. Click user icon on SettingsPage, result: YourInfoPage opens
     * 2. Click device setting category on YourInfoPage, result: DeviceSettingsPage opens
     * 3. Click device name category, result: text prompt appears
     * 4. Delete old name
     * 5. Type new name
     * 6. Accept current prompt and next one
     * 7. Confirm name has changed
     **/
    @Test(dataProvider = "DeviceNamesData")
    public void changeDeviceNameTest(String name) {
        SettingsPage settingsPage = new SettingsPage(getDriver());
        settingsPage.assertPageOpened();

        YourInfoPage yourInfoPage = settingsPage.openYourInfoPage();
        yourInfoPage.assertPageOpened();

        DeviceSettingsPage deviceSettingsPage = yourInfoPage.openDeviceSettings();
        deviceSettingsPage.assertPageOpened();

        deviceSettingsPage.changeDeviceName(name);

        Assert.assertEquals(deviceSettingsPage.getDeviceName(), name);
    }

    @DataProvider(parallel = true, name = "DeviceNamesData")
    public static Object[] deviceNamesData() {
        return new Object[]{
                "test",
                "test2"};
    }
}