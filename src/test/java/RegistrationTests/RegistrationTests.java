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

    }


    @Test
    public void testRegistrationValid(){

        webDriver.findElement(By.xpath("//a[@class='login']")).click();
        logger.info("Click on 'Sign in'");
        webDriver.findElement(By.id("email_create")).sendKeys(email);
        logger.info("Enter email");
        webDriver.findElement(By.xpath("//button[@id='SubmitCreate']")).click();
        logger.info("Click on 'Submit'");
        //PERSONAL INFORMATION
        webDriver.findElement(By.xpath("//form[@id='account-creation_form']/div[@class='account_creation']/div[1]/div[1]")).click();
        logger.info("Choose title 'Mr'");
        webDriver.findElement(By.id("customer_firstname")).sendKeys("Alex");
        logger.info("Enter First Name");
        webDriver.findElement(By.id("customer_lastname")).sendKeys("Bary");
        logger.info("Enter Last Name");

//        String emailInForm = webDriver.findElement(By.id("email")).getText();
//        if(emailInForm != email){
//            webDriver.findElement(By.id("email")).sendKeys(email);
//            logger.info("Input email");
//        }
        webDriver.findElement(By.id("email")).clear();
        webDriver.findElement(By.id("email")).sendKeys(email);
        logger.info("Input email");

        webDriver.findElement(By.id("passwd")).sendKeys("WGQJrJjX");
        logger.info("Input password");
        webDriver.findElement(By.id("newsletter")).click();
        logger.info("Choose 'Sign up for our newsletter!'");
        webDriver.findElement(By.id("optin")).click();
        logger.info("Choose 'Receive special offers from our partners!'");

        //ADDRESS
        webDriver.findElement(By.xpath("//input[@id='firstname']")).clear();
        webDriver.findElement(By.xpath("//input[@id='firstname']")).sendKeys("Alex");
        logger.info("Enter First Name");
        webDriver.findElement(By.xpath("//input[@id='lastname']")).clear();
        webDriver.findElement(By.xpath("//input[@id='lastname']")).sendKeys("Bary");
        logger.info("Enter Last Name");
        webDriver.findElement(By.xpath("//input[@id='address1']")).sendKeys("Ocean Street 58");
        logger.info("Enter Address");
        webDriver.findElement(By.xpath("//input[@id='city']")).sendKeys("Chicago");
        logger.info("Enter City");
        //another method
        //webDriver.findElement(By.xpath("//div[@id='uniform-id_state']/select[1]/option[@value='13']")).click();
        Select state = new Select(webDriver.findElement(By.id("id_state")));
        state.selectByValue("13");
        logger.info("Select State");
        webDriver.findElement(By.id("postcode")).sendKeys("12345");
        logger.info("Input Post code");
        Select country = new Select(webDriver.findElement(By.id("id_country")));
        country.selectByValue("21");
        logger.info("Select Country");
        webDriver.findElement(By.id("phone_mobile")).sendKeys("1231231243423");
        logger.info("Enter phone number");
        webDriver.findElement(By.id("alias")).clear();
        webDriver.findElement(By.id("alias")).sendKeys("unamewepp-6426@yopmail.com");
        logger.info("Enter alias");
        webDriver.findElement(By.id("submitAccount")).click();
        logger.info("Click on Submit");
        webDriver.findElement(By.xpath("//div[@id='center_column']/h1")).isDisplayed();
        logger.info("Verify if account created");


        //webDriver.quit();



    }


}
