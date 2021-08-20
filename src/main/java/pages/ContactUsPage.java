package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends MainPage {

    public ContactUsPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(id = "contact-link")
    public WebElement contactUsButton;

    @FindBy(id = "id_contact")
    public WebElement selectSubjectByValue;

    @FindBy(id = "email")
    public WebElement emailInput;

    @FindBy(id = "message")
    public WebElement messageInput;

    @FindBy(id = "submitMessage")
    public WebElement sendButton;

    @FindBy(xpath = "//p[@class='alert alert-success']")
    public WebElement successText;


    public void openMainPage(){
        openUrl("http://automationpractice.com/index.php");
        logger.info("Opened page: http://automationpractice.com");
    }

    public void clickContactUs() {
        webElements.clickOnElement(contactUsButton);
    }

    public void selectSubject(String value) {
        webElements.selectTextInDropDownByValue(selectSubjectByValue, value);
    }

    public void inputEmail(String text) {
        webElements.inputText(emailInput, text);
    }

    public void inputMessage(String text) {
        webElements.inputText(messageInput, text);
    }

    public void clickSend() {
        webElements.clickOnElement(sendButton);
    }

    public void verifySuccessText(String text) {
        webElements.checkTextInElement(successText, text);
    }

}
