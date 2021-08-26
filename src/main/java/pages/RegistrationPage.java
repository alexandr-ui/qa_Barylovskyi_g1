package pages;

import model.Account;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends MainPage{

    @FindBy(xpath = "//button[@id='SubmitCreate']")
    private WebElement submitButtonCreate;

    @FindBy(xpath = "//form[@id='account-creation_form']/div[@class='account_creation']/div[1]/div[1]")
    public WebElement formAccount;

    @FindBy(id = "id_gender1")
    public WebElement genderMr;

    @FindBy(id = "id_gender2")
    public WebElement genderMrs;

    @FindBy(id = "customer_firstname")
    public WebElement customerFirstNameInput;

    @FindBy(id = "customer_lastname")
    public WebElement customerLastNameInput;

    @FindBy(id = "email")
    public WebElement emailInput;

    @FindBy(id = "passwd")
    public WebElement passwordInput;

    @FindBy(id = "days")
    public WebElement dayDropDown;

    @FindBy(id = "months")
    public WebElement monthDropDown;

    @FindBy(id = "years")
    public WebElement yearDropDown;

    @FindBy(id = "newsletter")
    public WebElement checkboxNewsLetter;

    @FindBy(id = "optin")
    public WebElement checkboxNewsOptin;

    @FindBy(xpath = "//input[@id='firstname']")
    public WebElement firstNameInput;

    @FindBy(xpath = "//input[@id='lastname']")
    public WebElement lastNameInput;

    @FindBy(id = "company")
    public WebElement companyName;

    @FindBy(id = "address1")
    public WebElement addressByDefault;

    @FindBy(id = "address2")
    public WebElement addressLine;

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

    public RegistrationPage(WebDriver webDriver) {
        super(webDriver);
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

    public void selectGender(String gender) {
        if (gender.equals("Mr.")) {
            webElements.clickRadioButton(genderMr, gender);
        } else {
            webElements.clickRadioButton(genderMrs, gender);
        }
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

    public void selectBirthDay(String day) {
        webElements.selectTextInDropDownByValue(dayDropDown, day);
    }

    public void selectBirthMonth(String month) {
        webElements.selectTextInDropDownByValue(monthDropDown, month);
    }

    public void selectBirthYear(String year) {
        webElements.selectTextInDropDownByValue(yearDropDown, year);
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

    public void inputCompany(String company) {
        webElements.inputText(companyName, company);
    }

    public void inputAddressByDefault(String address) {
        webElements.inputText(addressByDefault, address);
    }

    public void inputAddressLine(String address) {
        webElements.inputText(addressLine, address);
    }

    public void inputStreet(String street){
        webElements.inputText(addressByDefault, street);
    }

    public void inputCity(String city) {
        webElements.inputText(cityInput, city);
    }

    public void selectState(String value){
        webElements.selectTextInDropDownByValue(selectStateByValue, value);
    }

    public void inputPostCode(String code) {
        webElements.inputText(postCodeInput, code);
    }

    public void selectCountry(String value){
//        try{
//            Select country = new Select(selectCountryByValue);
//            country.selectByValue("21");
//            logger.info("Country 21 is selected");
//        } catch(Exception e){
//            logger.error("Country can't be selected");
//        }
        webElements.selectTextInDropDownByValue(selectCountryByValue, value);
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

    public void registrationUser(Account account) {
        selectGender(account.getGender());
        inputCustomerFirstName(account.getFirstCustomerName());
        inputCustomerLastName(account.getLastCustomerName());
        inputEmail(account.getEmail());
        inputPassword(account.getPass());
        selectBirthDay(account.getDay());
        selectBirthMonth(account.getMonth());
        selectBirthYear(account.getYear());
        inputFirstName(account.getFirstName());
        inputLastName(account.getLastName());
        inputCompany(account.getCompany());
        inputAddressByDefault(account.getAddress1());
        inputAddressLine(account.getAddress2());
        inputCity(account.getCity());
        selectState(account.getState());
        inputPostCode(account.getPostcode());
        selectCountry(account.getCountry());
        inputPhoneNumber(account.getPhone_mobile());
        inputAlias(account.getAlias());
    }









}
