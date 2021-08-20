package HomeWork;

import MainTests.MainTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeWork6 extends MainTest {

    @Test
    public void testContactUs() {

        contactUsPage.openMainPage();
        contactUsPage.clickContactUs();
        contactUsPage.selectSubject("2");
        contactUsPage.inputEmail(faker.internet().emailAddress());
        contactUsPage.inputMessage("Send me a discount coupon please");
        contactUsPage.clickSend();
        contactUsPage.verifySuccessText("Your message has been successfully sent to our team.");

    }

}
