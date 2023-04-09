package userInterface.common;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.SelectOption;
import org.testng.Assert;

import java.util.logging.Logger;

public class UICommonUtils extends PlaywrightDriver {
    private Logger log = Logger.getLogger(String.valueOf(this.getClass()));

    public UICommonUtils(){
        super();
        log.info("UI common utility constructor called");

    }

    public  void click(String locatorKey) {

        try {
            getPage().locator(PlaywrightDriver.OR.getProperty(locatorKey)).click();
            log.info("Clicking on an Element : " + locatorKey);
        } catch (Throwable t) {
            log.warning("Error while clicking on an Element : " + t.getMessage());
            Assert.fail(t.getMessage());
        }
    }

    public  boolean isElementPresent(String locatorKey) {
        try {
            getPage().waitForSelector(OR.getProperty(locatorKey), new Page.WaitForSelectorOptions().setTimeout(2000));
            log.info("Finding an Element : " + locatorKey);
            return true;
        } catch (Throwable t) {
            return false;
        }

    }

    public  void type(String locatorKey, String value) {
        try {
            getPage().locator(OR.getProperty(locatorKey)).fill(value);
            log.info("Typing in an Element : " + locatorKey + " and entered the value as :" + value);
        } catch (Throwable t) {
            log.warning("Error while typing in an Element : " + t.getMessage());
            Assert.fail(t.getMessage());
        }
    }

    public  void select(String locatorKey, String value) {
        try {
            getPage().selectOption(OR.getProperty(locatorKey),new SelectOption().setLabel(value));
            log.info("Selecting an Element : " + locatorKey + " and selected the value as :" + value);
        } catch (Throwable t) {
            log.warning("Error while Selecting an Element : " + t.getMessage());
            Assert.fail(t.getMessage());
        }
    }
}
