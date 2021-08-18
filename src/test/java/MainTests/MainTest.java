package MainTests;

import com.github.javafaker.Faker;
import org.apache.log4j.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import pages.RegistrationPage;

import java.io.File;
import java.util.concurrent.TimeUnit;



public class MainTest {
    public WebDriver webDriver;
    public RegistrationPage registrationPage;
    public Logger logger;
    public Faker faker;

    public MainTest() {}

    @Parameters("browser")

    @BeforeClass
    public void setUp(){

        //Setup browser

            File chromeFF = new File("./drivers/chromedriver");
            System.setProperty("webdriver.chrome.driver", chromeFF.getAbsolutePath());
            webDriver = new ChromeDriver();
            webDriver.manage().window().maximize();
            webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            registrationPage = new RegistrationPage(webDriver);
            faker = new Faker();
            logger = Logger.getLogger(getClass());


        try{
            webDriver.get("http://automationpractice.com");
            logger.info("Open URL - http://automationpractice.com");
        } catch(Exception e){
            logger.error("Can't open browser");
            Assert.fail("Can't open browser");
        }
    }

    @AfterClass
    public void tearDown(){
        if (!(webDriver == null)) {
            webDriver.manage().deleteAllCookies();
            logger.info("Clear cookies");
            webDriver.quit();
            logger.info("Close browser");
        }
    }


}


