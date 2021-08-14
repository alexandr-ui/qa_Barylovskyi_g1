package pages;

import org.junit.Assert;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage extends MainPage{

    @FindBy(xpath = "//a[@class='login']")
    private WebElement loginInput;

    @FindBy(id = "email_create")
    private WebElement emailCreateInput;

    @FindBy(xpath = "//button[@id='SubmitCreate']")
    private WebElement submitButtonCreate;

    @FindBy(xpath = "//form[@id='account-creation_form']/div[@class='account_creation']/div[1]/div[1]")
    public WebElement formAccount;

    @FindBy(id = "customer_firstname")
    public WebElement customerFirstNameInput;

    @FindBy(id = "customer_lastname")
    public WebElement customerLastNameInput;

    @FindBy(id = "email")
    public WebElement emailInput;

    @FindBy(id = "passwd")
    public WebElement passwordInput;

    @FindBy(id = "newsletter")
    public WebElement checkboxNewsLetter;

    @FindBy(id = "optin")
    public WebElement checkboxNewsOptin;

    @FindBy(xpath = "//input[@id='firstname']")
    public WebElement firstNameInput;

    @FindBy(xpath = "//input[@id='lastname']")
    public WebElement lastNameInput;

    @FindBy(xpath = "//input[@id='address1']")
    public WebElement streetInput;

    @FindBy(xpath = "//input[@id='city']")
    public WebElement cityInput;

    @FindBy(id = "id_state")
    public WebElement selectStateByValue;

    @FindBy(id = "postcode")
    public WebElement postCodeInput;

    @FindBy(id = "id_country")
    public WebElement selectCountryByValue;

    @FindBy(id = "phone_mobile")
    public WebElement phoneNumberInput;

    @FindBy(id = "alias")
    public WebElement aliasInput;

    @FindBy(id = "submitAccount")
    public WebElement submitAccount;

    @FindBy(xpath = "//div[@id='center_column']/h1")
    public WebElement titleRegisteredAccount;

    public RegistrationPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void openRegistrationPage(){
        openUrl("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        logger.error("Opened page: http://automationpractice.com");
    }

    /**
     *Method click to SignIn Page
     * */

    public void clickSignIn(){
        webElements.clickOnElement(loginInput);
    }

    /**
     * Method input email
     * @param email
     * */

    public void InputEmailCreate(String email) {
        webElements.inputText(emailCreateInput, email);
    }

    /**
     * Method submit button
     * */
    public void submitButtonCreate(){
        webElements.clickOnElement(submitButtonCreate);
    }

    public void inputFormAccount(){
        webElements.clickOnElement(formAccount);
    }

    public void inputCustomerFirstName(String firstName){
        webElements.inputText(customerFirstNameInput, firstName);
    }

    public void inputCustomerLastName(String lastName){
        webElements.inputText(customerLastNameInput, lastName);
    }

    public void inputEmail(String email){
        webElements.inputText(emailInput, email);
    }

    public void inputPassword(String password) {
        webElements.inputText(passwordInput, password);
    }

    public void clickCheckboxNewsLetter() {
        webElements.clickOnElement(checkboxNewsLetter);
    }

    public void clickCheckboxNewsOption() {
        webElements.clickOnElement(checkboxNewsOptin);
    }

    public void inputFirstName(String firstName) {
        webElements.inputText(firstNameInput, firstName);
    }

    public void inputLastName(String lastName) {
        webElements.inputText(lastNameInput, lastName);
    }

    public void inputStreet(String street){
        webElements.inputText(streetInput, street);
    }

    public void inputCity(String city) {
        webElements.inputText(cityInput, city);
    }

    public void selectState(){
        try{
            Select state = new Select(selectStateByValue);
            state.selectByValue("13");
            logger.info("State '13' is selected");
        } catch(Exception e){
            logger.error("State can't be selected");
        }
    }

    public void inputPostCode(String code) {
        webElements.inputText(postCodeInput, code);
    }

    public void selectCountry(){
        try{
            Select country = new Select(selectCountryByValue);
            country.selectByValue("21");
            logger.info("Country 21 is selected");
        } catch(Exception e){
            logger.error("Country can't be selected");
        }
    }

    public void inputPhoneNumber(String number) {
        webElements.inputText(phoneNumberInput, number);
    }

    public void inputAlias(String alias) {
        webElements.inputText(aliasInput, alias);
    }

    public void clickSubmitAccount() {
        webElements.clickOnElement(submitAccount);
    }

    public void isDisplayedTextByXpath(String text) {
        webElements.isElementPresent(text);
    }









}
