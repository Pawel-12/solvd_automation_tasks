package com.solvd.laba.block4.mobiletest.pages;

import com.zebrunner.carina.utils.android.IAndroidUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SettingsPage extends AbstractPage implements IAndroidUtils {

    @FindBy(id = "com.android.settings:id/search_action_bar_title")
    private ExtendedWebElement searchWidget;
    @FindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.android.settings:id/recycler_view\"]/android.widget.LinearLayout")
    private List<ExtendedWebElement> categories;

    @FindBy(id = "com.android.settings:id/account_avatar")
    private ExtendedWebElement userIcon;

    public SettingsPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(searchWidget);
    }

    public SettingsSearchPage openSettingsSearch() {
        searchWidget.click();
        return new SettingsSearchPage(getDriver());
    }

    private void openCategory(int index) {
        categories.get(index).click();
    }

    public BatterySettingsPage openBatterySettings() {
        openCategory(4);
        return new BatterySettingsPage(getDriver());
    }

    public NetworkSettingsPage openNetworkSettings() {
        openCategory(0);
        return new NetworkSettingsPage(getDriver());
    }

    public YourInfoPage openYourInfoPage() {
        userIcon.click();
        return new YourInfoPage(getDriver());
    }
}
