package libs;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


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
     * @param  element
     * @param text
     * */
    public void inputText(WebElement element, String text) {
        try {
            element.clear();
            element.sendKeys(text);
            logger.info(text + " was entered");
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

    /**
     * Method click element Radio button
     * @param element
     * @param text
     * */
    public void clickRadioButton(WebElement element, String text) {
        try{
            boolean status = element.isDisplayed();
            if (status) {
                logger.info("Checkbox is initially checked");
            } else {
                element.click();
                logger.info("Element has been clicked " + text);
            }

        } catch(Exception e) {
            logger.error("Can't work with Element " + text);
            Assert.fail("Can't work with Element " + text);
        }
    }

    public boolean isElementPresent(String locatorWithText) {
        try {
            return webDriver.findElement(By.xpath(locatorWithText)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Method check select text in dropdown
     * @param dropdown
     * @param text
     * */
    public void selectTextInDropDownByValue(WebElement dropdown, String text) {
        try {
            Select optionsFromDropDown = new Select(dropdown);
//            optionsFromDropDown.selectByVisibleText(text);
            optionsFromDropDown.selectByValue(text);
            logger.info("DropDown By Value was selected " + text);
        } catch (Exception e) {
            logger.error("Can't work with DropDown");
            Assert.fail("Can't work with DropDown");
        }
    }

    public boolean isElementPresent(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }

    }

    public void checkTextInElement(WebElement element, String text) {
        try {
            String textFormElement = element.getText();
            Assert.assertEquals(textFormElement, text);
        } catch (Exception e) {
            logger.error("In element can't check text " + text);
            Assert.fail("In element can't check text " + text);
        }
    }

    public void verifyTextIsPresent(WebElement element, String text) {
        try {
            String textFormElement = element.getText();
            Assert.assertTrue(textFormElement.contains(text));
        } catch (Exception e) {
            logger.error("In element can't check text " + text);
            Assert.fail("In element can't check text " + text);
        }
    }

    public void verifyValueIsPresent(WebElement element, String text) {
        try {
            String textFormElement = element.getAttribute("value");
            Assert.assertTrue(textFormElement.contains(text));
        } catch (Exception e) {
            logger.error("In element can't check text " + text);
            Assert.fail("In element can't check text " + text);
        }
    }

}
