package com.solvd.laba.block4.mobiletest.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class YourInfoPage extends AbstractPage {
    @FindBy(xpath = "(//android.widget.LinearLayout[@resource-id=\"com.google.android.gms:id/list_item\"])[1]")
    private ExtendedWebElement deviceCategory;

    public YourInfoPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(deviceCategory);
    }

    public DeviceSettingsPage openDeviceSettings() {
        deviceCategory.click();
        return new DeviceSettingsPage(getDriver());
    }
}
