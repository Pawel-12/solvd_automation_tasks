package com.solvd.laba.block4.mobiletest.pages;

import com.zebrunner.carina.utils.android.IAndroidUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class BatterySettingsPage extends AbstractPage implements IAndroidUtils {
    @FindBy(id = "android:id/switch_widget")
    private ExtendedWebElement batteryPercentageSwitch;

    @FindBy(id = "com.android.settings:id/usage_summary")
    private ExtendedWebElement batteryChargeLevelValue;

    public BatterySettingsPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(batteryPercentageSwitch);
    }

    public void switchBatteryPercentage() {
        batteryPercentageSwitch.click();
    }

    public boolean isBatteryPercentageOn() {
        return batteryPercentageSwitch.isChecked();
    }

    public Double getBatteryChargeLevel() {
        return Double.valueOf(batteryChargeLevelValue.getText().replace('%', ' '));
    }
}
