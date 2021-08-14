package MainTests;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MainPage;
import pages.RegistrationPage;

import java.io.File;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.is;


public class MainTest {
    public WebDriver webDriver;
    public RegistrationPage registrationPage;
    public Logger logger;

    public MainTest() {}

    @Before
    public void setUp(){
        //Setup browser
        File chromeFF = new File("./drivers/chromedriver");
        System.setProperty("webdriver.chrome.driver", chromeFF.getAbsolutePath());
        webDriver = new ChromeDriver();
        registrationPage = new RegistrationPage(webDriver);
        logger = Logger.getLogger(getClass());
//        mainPage = new MainPage(webDriver);
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
        webDriver.manage().deleteAllCookies();
        logger.info("Clear cookies");
        webDriver.quit();
        logger.info("Close browser");
    }

    //Matcher => CoreMatchers
    public void checkAC(String message, boolean actualRes, boolean expectedRes){
        Assert.assertEquals(message, actualRes, is(expectedRes));
    }

}
