package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.hamcrest.CoreMatchers.is;


public class WebElements {
    // общие страницы и взаиможейтвие
    WebDriver webDriver;
    Logger logger;

    public WebElements(WebDriver webDriver) {
        this.webDriver = webDriver;
        logger = Logger.getLogger(getClass());
    }

    /**
     * Method inputs text to WebElement
     * @param element
     * @param text
     * */
    public void inputText(WebElement element, String text) {
        try {
            element.clear();
            element.sendKeys(text);
            logger.info(text + " was inputed");
        } catch (Exception e){
            logger.error("Can't work with element " + text);
            Assert.fail("Can't work with element " + text);

        }
    }

    /**
     * Method click element button
     * @param element
     * */

    public void clickOnElement(WebElement element) {
        try {
            element.click();
            logger.info("Element was clicked " + element);
        } catch (Exception e) {
            logger.error("Can't work with element " + element);
            Assert.fail("Can't work with element " + element);
        }
    }

    public boolean isElementPresent(String locatorWithText) {
        try {
            return webDriver.findElement(By.xpath(locatorWithText)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isElementPresent(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void checkTextInElement(String xpath, String text) {
        try {
            String textFormElement = webDriver.findElement(By.xpath(xpath)).getText();
            Assert.assertThat("Text in element is matched", textFormElement, is(text));
        } catch (Exception e) {
            logger.error("In element can't check text" + text);
            Assert.fail("In element can't check text" + text);
        }
    }

}
