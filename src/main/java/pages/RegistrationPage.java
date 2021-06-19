package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends MainPage{

    @FindBy(xpath = "//a[@class='login']")
    private WebElement loginInput;

    @FindBy(id = "email_create")
    private WebElement emailCreateInput;

    @FindBy(xpath = "//button[@id='SubmitCreate']")
    private WebElement submitButtonCreate;

    @FindBy(xpath = "//form[@id='account-creation_form']/div[@class='account_creation']/div[1]/div[1]")
    private WebElement formAccount;

    @FindBy(id = "customer_firstname")
    private WebElement customerFirstNameInput;

    @FindBy(id = "customer_lastname")
    private WebElement customerLastNameInput;

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "passwd")
    private WebElement passwordInput;

    @FindBy(id = "newsletter")
    private WebElement checkboxNewsLetter;

    @FindBy(id = "optin")
    private WebElement checkboxNewsOptin;

    @FindBy(xpath = "//input[@id='firstname']")
    private WebElement firstNameInput;

    @FindBy(xpath = "//input[@id='lastname']")
    private WebElement lastNameInput;

    @FindBy(xpath = "//input[@id='address1']")
    private WebElement streetInput;

    @FindBy(xpath = "//input[@id='city']")
    private WebElement cityInput;

    @FindBy(id = "id_state")
    private WebElement selectStateByValue;

    @FindBy(id = "postcode")
    private WebElement postCodeInput;

    @FindBy(id = "id_country")
    private WebElement selectCountryByValue;

    @FindBy(id = "phone_mobile")
    private WebElement phoneNumberInput;

    @FindBy(id = "alias")
    private WebElement aliasInput;

    @FindBy(id = "submitAccount")
    private WebElement submitAccount;

    @FindBy(id = "//div[@id='center_column']/h1")
    private WebElement titleRegisteredAccount;

    public RegistrationPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void openRegistrationPage(){
        openUrl("http://automationpractice.com/index.php?controller=authentication&back=my-account");
    }

    /**
     *Method click to SignIn Page
     * */

    public void clickSignIn(){
        try{
            loginInput.click();
            logger.info("Click to Sign in");
        } catch(Exception e) {
            logger.error("Can't click to Sign in");
            Assert.fail("Can't click to Sign in");
        }
    }

    /**
     * Method input email
     * @param email
     * */

    public void InputEmailCreate(String email ){
        try{
            emailCreateInput.sendKeys(email);
            logger.info("Input email:   " + email);

        } catch(Exception e){
            logger.error("Can't input email " + email);
            Assert.fail("Can't input email " + email);
        }
    }









}
