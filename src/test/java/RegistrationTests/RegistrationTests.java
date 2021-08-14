package RegistrationTests;

import MainTests.MainTest;
import org.junit.Test;
import pages.MainPage;
import pages.RegistrationPage;


public class RegistrationTests extends MainTest {

    String email = "2undumewtepp-642617@yopmail.com";

    @Test
    public void testRegistrationValidByPageObj(){
        registrationPage.openRegistrationPage();
        registrationPage.clickSignIn();
        registrationPage.InputEmailCreate(email);
        registrationPage.submitButtonCreate();
        //another method
        registrationPage.inputFormAccount();
        registrationPage.inputCustomerFirstName("Alex");
        registrationPage.inputCustomerLastName("Barilovsky");
        registrationPage.inputEmail(email);
        registrationPage.inputPassword("QWErty123");
        registrationPage.clickCheckboxNewsLetter();
        logger.info("Choose 'Sign up for our newsletter!'");
        registrationPage.clickCheckboxNewsOption();
        logger.info("Choose 'Receive special offers from our partners!'");
        registrationPage.inputFirstName("Alex");
        registrationPage.inputLastName("Barilovsky");
        registrationPage.inputStreet("Ocean Street 58");
        registrationPage.inputCity("Chicago");
        registrationPage.selectState();
        registrationPage.inputPostCode("12345");
        registrationPage.selectCountry();
        registrationPage.inputPhoneNumber("12345678");
        registrationPage.inputAlias(email);
        registrationPage.clickSubmitAccount();
        registrationPage.titleRegisteredAccount.isDisplayed();
        logger.info("Verify if account created");
        checkAC("Text is present",
                registrationPage.titleRegisteredAccount.isDisplayed(), true);



    }

}
