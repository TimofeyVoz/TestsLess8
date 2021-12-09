package lib.ui;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import org.openqa.selenium.remote.RemoteWebDriver;


abstract public class NavigationUI extends MainPageObject {

    protected static String
    MY_LISTS_LINK,
    OPEN_NAVIGATION;

    public NavigationUI(RemoteWebDriver driver) {
        super(driver);
    }

    public void openNavigation() throws InterruptedException {
        if(Platform.getInstance().isMw()){
            Thread.sleep(400);
            this.waitForElementAndClick(OPEN_NAVIGATION,"Cannot find and click open navigation button", 5);
        }else{
            System.out.println("Method openNavigation() does nothing for platform " + Platform.getInstance().getPlatformVar());
        }
    }


    public void clickMyLists() throws InterruptedException {

        if(Platform.getInstance().isMw()){
            Thread.sleep(40);
            this.tryClickElementWithFewAttempts(
                    MY_LISTS_LINK,
                    "Cannot find navigation button to My list",
                    10
            );
        }else {
        this.waitForElementAndClick(
               MY_LISTS_LINK,
                "Cannot find navigation button to My list",
                5
        );
    }
    }
}