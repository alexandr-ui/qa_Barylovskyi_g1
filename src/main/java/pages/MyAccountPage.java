package pages;

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

    public String getAccountName() {
        return accountBtn.getText();
    }

    public void getHeaderName(String text) {
        webElements.isElementPresent(text);
    }

}
