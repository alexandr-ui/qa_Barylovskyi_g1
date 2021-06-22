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
    String email = "1unamewepp-6426@yopmail.com";

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
        logger.info("Clear cookies");
        webDriver.quit();
        logger.info("Close browser");
    }

    @Test
    public void testRegistrationValidByPageObj(){
        registrationPage.openRegistrationPage();
        registrationPage.clickSignIn();
        registrationPage.InputEmailCreate("2unamewepp-6426@yopmail.com");
        registrationPage.submitButtonCreate();
        //another method
        registrationPage.formAccount.click();
        logger.info("Choose title 'Mr'");
        registrationPage.customerFirstNameInput.sendKeys("Alex");
        logger.info("Enter First Name");
        registrationPage.customerLastNameInput.sendKeys("Barilovsky");
        logger.info("Enter Last Name");
        registrationPage.emailInput.clear();
        registrationPage.emailInput.sendKeys("2unamewepp-6426@yopmail.com");
        logger.info("Input email");
        registrationPage.passwordInput.sendKeys("QWErty123");
        logger.info("Input password");
        registrationPage.checkboxNewsLetter.click();
        logger.info("Choose 'Sign up for our newsletter!'");
        registrationPage.checkboxNewsOptin.click();
        logger.info("Choose 'Receive special offers from our partners!'")
        registrationPage.firstNameInput.sendKeys("Alex");
        logger.info("Enter First Name");
        registrationPage.lastNameInput.sendKeys("Barilovsky");
        logger.info("Enter Last Name");
        registrationPage.streetInput.sendKeys("Ocean Street 58");
        logger.info("Enter Street");
        registrationPage.cityInput.sendKeys("Chicago");
        logger.info("Enter City");
        registrationPage.selectState();
        registrationPage.postCodeInput.sendKeys("12345");
        logger.info("Input Post code");
        registrationPage.selectCountry();
        registrationPage.phoneNumberInput.sendKeys("12345678");
        logger.info("Enter phone number");
        registrationPage.aliasInput.sendKeys("2unamewepp-6426@yopmail.com");
        logger.info("Enter alias");
        registrationPage.submitAccount.click();
        logger.info("Click on Submit");
        registrationPage.titleRegisteredAccount.isDisplayed();
        logger.info("Verify if account created");



    }

}
