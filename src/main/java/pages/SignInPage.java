package pages;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends MainPage{

    //взаимодействие с вебдрайвером
    public SignInPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//a[@class='login']")
    private WebElement loginInput;

    @FindBy(id = "email_create")
    private WebElement emailCreateInput;


    /**
     *Method click to SignIn Page
     * */
    @Step("Click to SignIn page")
    public void clickSignIn(){
        webElements.clickOnElement(loginInput);
    }

    /**
     * Method input email
     * @param email
     * */

    @Step("Input email {email}")
    public void InputEmailCreate(String email) {
        webElements.inputText(emailCreateInput, email);
    }




}
