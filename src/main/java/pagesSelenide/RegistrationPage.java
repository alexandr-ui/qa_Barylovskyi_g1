package pagesSelenide;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import model.Account;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class RegistrationPage {

    public SelenideElement
            submitButtonCreate = $x("//button[@id='SubmitCreate']"),
            formAccount = $x("//form[@id='account-creation_form']/div[@class='account_creation']/div[1]/div[1]"),
            genderMr = $x("//input[@id='id_gender1']"),
            genderMrs = $x("//input[@id='id_gender2']"),
            customerFirstNameInput = $(By.id("customer_firstname")),
            customerLastNameInput = $(By.id("customer_lastname")),
            emailInput = $(By.id("email")),
            passwordInput = $(By.id("passwd")),
            dayDropDown = $(By.id("days")),
            monthDropDown = $(By.id("months")),
            yearDropDown = $(By.id("years")),
            checkboxNewsLetter = $(By.id("newsletter")),
            checkboxNewsOptin = $(By.id("optin")),
            firstNameInput = $x("//input[@id='firstname']"),
            lastNameInput = $x("//input[@id='lastname']"),
            companyName = $(By.id("company")),
            addressByDefault = $(By.id("address1")),
            addressLine = $(By.id("address2")),
            cityInput = $x("//input[@id='city']"),
            selectStateByValue = $(By.id("id_state")),
            postCodeInput = $(By.id("postcode")),
            selectCountryByValue = $(By.id("id_country")),
            phoneNumberInput = $(By.id("phone_mobile")),
            aliasInput = $(By.id("alias")),
            submitAccount = $(By.id("submitAccount"));


    /**
     * Method submit button
     * */
    @Step("Submit button create")
    public void submitButtonCreate(){
        submitButtonCreate.click();
    }

    @Step("Input form account}")
    public void inputFormAccount(){
        formAccount.click();
    }

    @Step("Select gender {gender}")
    public void selectGender(String gender) {
        if (gender.equals("1")) {
            genderMr.selectRadio(gender);
        } else {
            genderMrs.selectRadio(gender);
        }
    }

    @Step("Input customer first name {firstName}")
    public void inputCustomerFirstName(String firstName){
        customerFirstNameInput.setValue(firstName);
    }

    @Step("Input customer lst name {lastName}")
    public void inputCustomerLastName(String lastName){
        customerLastNameInput.setValue(lastName);
    }

    @Step("Input email {email}")
    public void inputEmail(String email){
        emailInput.setValue(email);
    }

    @Step("Input password {password}")
    public void inputPassword(String password) {
        passwordInput.setValue(password);
    }

    @Step("Select birthday {day}")
    public void selectBirthDay(String day) {
        dayDropDown.selectOptionByValue(day);
    }

    @Step("Select birth month {month}")
    public void selectBirthMonth(String month) {
        monthDropDown.selectOptionByValue(month);
    }

    @Step("Select birth year {year}")
    public void selectBirthYear(String year) {
        yearDropDown.selectOptionByValue(year);
    }

    @Step("Click checkbox newsletter")
    public void clickCheckboxNewsLetter() {
        checkboxNewsLetter.click();
    }

    @Step("Click checkbox news option")
    public void clickCheckboxNewsOption() {
        checkboxNewsOptin.click();
    }

    @Step("Input first name {firstName}")
    public void inputFirstName(String firstName) {
        firstNameInput.setValue(firstName);
    }

    @Step("Input lst name {lastName}")
    public void inputLastName(String lastName) {
        lastNameInput.setValue(lastName);
    }

    @Step("Input company {company}")
    public void inputCompany(String company) {
        companyName.setValue(company);
    }

    @Step("input Address by default {address}")
    public void inputAddressByDefault(String address) {
        addressByDefault.setValue(address);
    }

    @Step("Input address line {address}")
    public void inputAddressLine(String address) {
        addressLine.setValue(address);
    }

    @Step("Input City {city}")
    public void inputCity(String city) {
        cityInput.setValue(city);
    }

    @Step("Input state {state}")
    public void selectState(String value){
        selectStateByValue.selectOptionByValue(value);
    }

    @Step("Input postcode {code}")
    public void inputPostCode(String code) {
        postCodeInput.setValue(code);
    }

    @Step("Select country {value}")
    public void selectCountry(String value){
        selectCountryByValue.selectOptionByValue(value);
    }

    @Step("Input phone number {number}")
    public void inputPhoneNumber(String number) {
        phoneNumberInput.setValue(number);
    }

    @Step("Input alias {alias}")
    public void inputAlias(String alias) {
        aliasInput.setValue(alias);
    }

    @Step("Click Submit account")
    public void clickSubmitAccount() {
        submitAccount.click();
    }


    @Step ("Registration user")
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
