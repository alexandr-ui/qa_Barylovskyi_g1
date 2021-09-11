package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends MainPage{

    public MyAccountPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//div[@id='center_column']/h1")
    public WebElement titleRegisteredAccount;

    @FindBy(xpath = "//a[@class='account']/span[1]")
    public WebElement accountBtn;

    @Step("Get account name")
    public String getAccountName() {
        return accountBtn.getText();
    }

    @Step("Get header name {text}")
    public void getHeaderName(String text) {
        webElements.isElementPresent(text);
    }

}
