package RegistrationTests;

import MainTests.MainTest;
import org.testng.annotations.Test;


public class RegistrationTest extends MainTest {

    @Test
    public void testRegistrationValidByPageObj(){
        registrationPage.openRegistrationPage();
        registrationPage.clickSignIn();
        registrationPage.InputEmailCreate(faker.internet().emailAddress());
        registrationPage.submitButtonCreate();
        //another method
        registrationPage.inputFormAccount();
        registrationPage.inputCustomerFirstName("Alex");
        registrationPage.inputCustomerLastName("Barilovsky");
        registrationPage.inputEmail(faker.internet().emailAddress());
        registrationPage.inputPassword("QWErty123");
        registrationPage.clickCheckboxNewsLetter();
        logger.info("Choose 'Sign up for our newsletter!'");
        registrationPage.clickCheckboxNewsOption();
        logger.info("Choose 'Receive special offers from our partners!'");
        registrationPage.inputFirstName("Alex");
        registrationPage.inputLastName("Barilovsky");
        registrationPage.inputStreet("Ocean Street 58");
        registrationPage.inputCity("Chicago");
        registrationPage.selectState("13");
        registrationPage.inputPostCode("12345");
        registrationPage.selectCountry("21");
        registrationPage.inputPhoneNumber("12345678");
        registrationPage.inputAlias(faker.internet().emailAddress());
        registrationPage.clickSubmitAccount();
        registrationPage.titleRegisteredAccount.isDisplayed();
        logger.info("Verify if account created");
//        checkAC("Text is present",
//                registrationPage.titleRegisteredAccount.isDisplayed(), true);



    }

}