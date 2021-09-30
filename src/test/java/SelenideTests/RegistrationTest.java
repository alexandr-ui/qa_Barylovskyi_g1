package SelenideTests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.testng.TextReport;
import dataproviders.RegistrationPageDataProvider;
import model.Account;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pagesSelenide.SignInPage;

public class RegistrationTest extends BaseTest{

    @Test(dataProvider = "registerNewUser", dataProviderClass = RegistrationPageDataProvider.class)
     public void testCreateNewAccount(Account userAccount) {
        signInPage.clickToSignIn();
        signInPage.inputEmailCreate(faker.internet().emailAddress());

        registrationPage.submitButtonCreate();
        registrationPage.registrationUser(userAccount);
        registrationPage.clickSubmitAccount();

        myAccountPage.titleRegisteredAccount.isDisplayed();
//        myAccountPage.titleRegisteredAccount.shouldHave(Condition.visible);
        myAccountPage.getHeaderName("My account");
//        myAccountPage.getAccountName().contains(userAccount.getFirstCustomerName());
        Assert.assertEquals(myAccountPage.getAccountName(),
                userAccount.getFirstCustomerName() + " " + userAccount.getLastCustomerName());
    }

    @Test
    public void testFindProduct() {
        mainPage.getProducts();
        mainPage.clickToProduct("Blouse");

    }
}
