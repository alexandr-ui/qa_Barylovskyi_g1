package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConverterPage extends MainPage{

    public ConverterPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//body/div[3]/div[2]/div[1]/div[1]/ul[1]/li[5]/a[1]")
    public WebElement menuConverterButton;

    @FindBy(xpath = "//div[@class='widget widget-section_info']")
    public WebElement textAboutConverter;

    @FindBy(xpath = "//div[@class=' outer']")
    public WebElement closeButton;

    @FindBy(xpath = "//img[@src='images/close.png']")
    public WebElement imageCloseButton;

    @FindBy(xpath = "//input[@id='currency_amount']")
    public WebElement currencyAmount;

    @FindBy(xpath = "//p[@id='UAH']/input[1]")
    public WebElement resultUAH;

    @FindBy(xpath = "//p[@id='PLN']/input[1]")
    public WebElement resultPLN;

    @FindBy(xpath = "//select[@name='converter_currency']")
    public WebElement currencySelect;



    public void openConverterPage() {
        openUrl("https://finance.i.ua/converter/");
    }

    public void verifyTextAboutConverter(String text) {
        webElements.verifyTextIsPresent(textAboutConverter, text);
    }

    public void clickOnClose() {
        webDriver.switchTo().frame(1);
        if(webElements.isElementPresent(closeButton)) {
            webElements.clickOnElement(closeButton);
            logger.info("Banner was closed");
            }
        if(webElements.isElementPresent(imageCloseButton)) {
            webElements.clickOnElement(imageCloseButton);
            logger.info("Banner was closed (image)");
        }
        webDriver.switchTo().defaultContent();
    }

    public void enterAmount(String text) {
        webElements.inputText(currencyAmount, text);
    }

    public void verifyAmountUAH(String text) {
        System.out.println("1 usd is: " + resultUAH.getAttribute("value") + " UAH");
        webElements.verifyValueIsPresent(resultUAH, text);
    }

    public void selectCurrency(String text) {
        webElements.selectTextInDropDownByValue(currencySelect, text);
    }

    public void verifyAmountPLN(String text) {
        System.out.println("1 EUR is: " + resultPLN.getAttribute("value") + " PLN");
        webElements.verifyValueIsPresent(resultPLN, text);
    }

}
