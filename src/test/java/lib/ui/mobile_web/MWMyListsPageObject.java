package lib.ui.mobile_web;

import lib.ui.MyListsPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWMyListsPageObject extends MyListsPageObject {
    static {
        ARTICLE_BY_TITLE_TPL = "xpath://ul[contains(@class,'watchlist')]//h3[contains(text(),'{TITLE}')]";
        REMOVE_FROM_SAVE_BUTTON="xpath://*[@id='mw-content-text']/ul/li[contains(@title,'{TITLE}')]/a[contains(@href,'unwatch')]";


    }
    public MWMyListsPageObject(RemoteWebDriver driver)
    {
        super(driver);
    }

}
