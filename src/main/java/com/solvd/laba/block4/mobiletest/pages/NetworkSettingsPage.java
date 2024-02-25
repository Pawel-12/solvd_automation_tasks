package com.solvd.laba.block4.mobiletest.pages;

import com.zebrunner.carina.utils.android.IAndroidUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class NetworkSettingsPage extends AbstractPage implements IAndroidUtils {
    @FindBy(id = "android:id/switch_widget")
    private ExtendedWebElement airplaneModeSwitch;

    public NetworkSettingsPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(airplaneModeSwitch);
    }

    public void switchAirplaneMode() {
        airplaneModeSwitch.click();
    }

    public boolean isAirplaneModeOn() {
        return airplaneModeSwitch.isChecked();
    }
}
