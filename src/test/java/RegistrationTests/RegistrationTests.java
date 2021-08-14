package RegistrationTests;



import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.support.ui.Select;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MainPage;
import pages.RegistrationPage;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class RegistrationTests {

    public WebDriver webDriver;
    private Logger logger = Logger.getLogger(getClass());
    String email = "2undumewepp-642617@yopmail.com";

    public RegistrationPage registrationPage;
    public MainPage mainPage;



    @Before
    public void setUp(){
        //Setup browser
        File chromeFF = new File("./drivers/chromedriver");
        System.setProperty("webdriver.chrome.driver", chromeFF.getAbsolutePath());
        webDriver = new ChromeDriver();
        registrationPage = new RegistrationPage(webDriver);
        mainPage = new MainPage(webDriver);
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        try{
            webDriver.get("http://automationpractice.com");
            logger.info("Open URL - http://automationpractice.com");
        } catch(Exception e){
            logger.error("Can't open browser");
            Assert.fail("Can't open browser");
        }

    }

    @After
    public void tearDown(){
        //Close chromedriver
        webDriver.manage().deleteAllCookies();
//        logger.info("Clear cookies");
//        webDriver.quit();
//        logger.info("Close browser");
    }

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



    }

}
