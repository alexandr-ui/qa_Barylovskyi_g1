package RegistrationTests;

import MainTests.MainTest;
import dataproviders.RegistrationPageDataProvider;
import io.qameta.allure.*;
import model.Account;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class RegistrationTest extends MainTest {

    @BeforeMethod
    public void SetUpLink() {
        try{
            webDriver.get("http://automationpractice.com");
            logger.info("Open URL - http://automationpractice.com");
        } catch(Exception e){
            logger.error("Can't open browser");
            Assert.fail("Can't open browser");
        }
    }

    @AfterMethod
    public void ClearCookies() {
        webDriver.manage().deleteAllCookies();
        logger.info("Clear cookies");
    }

//    @Epic(value = "Registration")
//    @Story(value = "User can register for method 1")
//    @Description(value = "Test registration new user")
//    @Issue(value = "https/jira.com/12345")
//    @TmsLinks({@TmsLink(value = "TL-100"), @TmsLink(value = "TL-200")})
//    @Link(value = "Link", url = "https://github.com/allure-framework")
//    @Owner(value = "Oleksandr")
//    @Severity(value = SeverityLevel.CRITICAL)
//    @Test
//    public void testRegistrationValidByPageObj(){
//        signInPage.clickSignIn();
//        signInPage.InputEmailCreate(faker.internet().emailAddress());
//
//        registrationPage.submitButtonCreate();
//        registrationPage.inputFormAccount();
//        registrationPage.inputCustomerFirstName("Alex");
//        registrationPage.inputCustomerLastName("Barilovsky");
//        registrationPage.inputEmail(faker.internet().emailAddress());
//        registrationPage.inputPassword("QWErty123");
//        registrationPage.clickCheckboxNewsLetter();
//        logger.info("Choose 'Sign up for our newsletter!'");
//        registrationPage.clickCheckboxNewsOption();
//        logger.info("Choose 'Receive special offers from our partners!'");
//        registrationPage.inputFirstName("Alex");
//        registrationPage.inputLastName("Barilovsky");
//        registrationPage.inputAddressByDefault( "Ocean Street 58");
//        registrationPage.inputCity("Chicago");
//        registrationPage.selectState("13");
//        registrationPage.inputPostCode("12345");
//        registrationPage.selectCountry("21");
//        registrationPage.inputPhoneNumber("12345678");
//        registrationPage.inputAlias(faker.internet().emailAddress());
//        registrationPage.clickSubmitAccount();
//
//        myAccountPage.titleRegisteredAccount.isDisplayed();
//        myAccountPage.getHeaderName("My account");
//        logger.info("Verify if account created");
//
//    }

    @Epic(value = "Registration")
    @Story(value = "User can register for method 2")
    @Description(value = "Test registration new user")
    @Issue(value = "https/jira.com/12345")
    @TmsLink(value = "TL-876")
    @Link(value = "Link", url = "https://github.com/allure-framework")
    @Owner(value = "Oleksandr")
    @Severity(value = SeverityLevel.NORMAL)
    @Test(dataProvider = "registerNewUser", dataProviderClass = RegistrationPageDataProvider.class)
    public void testCreateNewAccount(Account userAccount) {
        signInPage.clickSignIn();
        signInPage.InputEmailCreate(faker.internet().emailAddress());
        registrationPage.submitButtonCreate();
        registrationPage.registrationUser(userAccount);
        registrationPage.clickSubmitAccount();
        myAccountPage.titleRegisteredAccount.isDisplayed();
        myAccountPage.getHeaderName("My account");
//        myAccountPage.getAccountName().contains(userAccount.getFirstCustomerName());
        Assert.assertEquals(myAccountPage.getAccountName(),
                userAccount.getFirstCustomerName() + " " + userAccount.getLastCustomerName());

    }

}