package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class SearchPageObject extends MainPageObject{

      protected static  String
            SEARCH_INT_ELEMENT,
            SEARCH_INPUT,
            SEARCH_CANCEL_BUTTON,
            SEARCH_RESULT_BY_SUBSTRING_TPL,
            SEARCH_RESULT_ELEMENT,
            SEARCH_EMPTY_RESULT_ELEMENT;

    public SearchPageObject(RemoteWebDriver driver)
    {
        super(driver);
    }
    private  static String getResultSearchElement(String substring){
        return SEARCH_RESULT_BY_SUBSTRING_TPL.replace("{SUBSTRING}", substring);
    }

    public void initSearchInput(){
        this.waitForElementPresent(SEARCH_INT_ELEMENT,"Cannot find search input after clicking search init element", 5);
        this.waitForElementAndClick(SEARCH_INT_ELEMENT,"Cannot find and click search init element", 5);
    }
    public void typeSearchLine(String search_line){
        this.waitForElementAndSendKeys(SEARCH_INPUT, search_line,"Cannot find and type into search input", 5);
     }
    public void waitForSearchResult(String substring)
    {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementPresent(search_result_xpath,"Cannot find search result with substring " + substring);
    }

    public void waitForCancelButtonToAppear()
    {
        this.waitForElementPresent(SEARCH_CANCEL_BUTTON, "Cannot find search cancel button", 5 );
    }

    public void waitForCancelButtonToDisappear()
    {
        this.waitForElementNotPresent(SEARCH_CANCEL_BUTTON, "Search cancel button is still present", 5 );
    }

    public void clickCancelSeartch()
    {
        this.waitForElementAndClick(SEARCH_CANCEL_BUTTON, "Cannot find and click search cancel button", 5 );
    }
    public void clickByArticleWithSubstring(String substring)
    {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementAndClick(search_result_xpath,"Cannot find and click search result with substring " + substring, 5);
    }

    public int getAmountOfFoundArticles(){

       this.waitForElementPresent(
               SEARCH_RESULT_ELEMENT,
                "Cannot find anything by the request ",
                30
        );
    return this.getAmountOfElements(SEARCH_RESULT_ELEMENT);
    }
    public void  waitForEmptyResultsLabel()
    {
        this.waitForElementPresent(SEARCH_EMPTY_RESULT_ELEMENT, "Cannot find empty result element", 15);
    }

    public void assertThereIsNoResultOfSearch()
    {
        this.assertElementNotPresent(SEARCH_RESULT_ELEMENT,"We supposed not to find any results");
    }


}
