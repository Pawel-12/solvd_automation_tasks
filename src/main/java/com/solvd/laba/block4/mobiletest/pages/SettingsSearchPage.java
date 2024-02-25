package com.solvd.laba.block4.mobiletest.pages;

import com.zebrunner.carina.utils.android.IAndroidUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SettingsSearchPage extends AbstractPage implements IAndroidUtils {
    @FindBy(id = "com.google.android.settings.intelligence:id/open_search_view_edit_text")
    private ExtendedWebElement searchField;

    public SettingsSearchPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(searchField);
    }

    public void searchFor(String query) {
        searchField.type(query);
    }

    public String getSearchFieldText() {
        return searchField.getText();
    }
}
