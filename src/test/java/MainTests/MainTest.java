package MainTests;

import com.github.javafaker.Faker;
import libs.Utils;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
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
    private String pathToScreenShot;
    public Utils utils = new Utils();
    public Faker faker;

    public MainTest() {}

    @Rule
    public TestName testName = new TestName();

    @Before
    public void setUp(){
        File file = new File("");
        pathToScreenShot = file.getAbsolutePath() + "\\resources\\screenshot\\" +
                this.getClass().getPackage().getName() + "\\" +
                this.getClass().getSimpleName() + "\\" + this.testName.getMethodName() + ".png";

        //Setup browser
        File chromeFF = new File("./drivers/chromedriver");
        System.setProperty("webdriver.chrome.driver", chromeFF.getAbsolutePath());
        webDriver = new ChromeDriver();
        registrationPage = new RegistrationPage(webDriver);
        faker = new Faker();
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
        if (!(webDriver == null)) {
            utils.screenShot(pathToScreenShot, webDriver);
        }
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
