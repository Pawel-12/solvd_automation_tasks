package com.solvd.laba.block4.mobiletest.pages;

import com.zebrunner.carina.utils.android.IAndroidUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import io.appium.java_client.android.nativekey.AndroidKey;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class DeviceSettingsPage extends AbstractPage implements IAndroidUtils {
    @FindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.android.settings:id/recycler_view\"]/android.widget.LinearLayout[2]")
    private ExtendedWebElement deviceNameCategory;

    @FindBy(xpath = "//android.widget.EditText[@resource-id=\"android:id/edit\"]")
    private ExtendedWebElement nameTextInput;

    public DeviceSettingsPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(deviceNameCategory);
    }

    public void changeDeviceName(String name) {
        deviceNameCategory.click();
        longPress(nameTextInput);

        pressKeyboardKey(AndroidKey.DEL);

        nameTextInput.type(name);

        ExtendedWebElement okButton = findExtendedWebElement(By.id("android:id/button1"));
        okButton.click();
        okButton.click();
    }

    public String getDeviceName() {
        return findExtendedWebElement(By.xpath("//android.widget.TextView[@resource-id=\"android:id/summary\"][1]")).getText();
    }
}
