package MainTests;

import com.github.javafaker.Faker;
import libs.Utils;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.MainPage;
import pages.RegistrationPage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.is;

@RunWith(value = Parameterized.class)

public abstract class MainTest {

    public WebDriver webDriver;
    public RegistrationPage registrationPage;
    public Logger logger = Logger.getLogger(getClass());;
    private String pathToScreenShot;
    public Utils utils = new Utils();
    public Faker faker = new Faker();
    private String browser;

    public MainTest(String browser) {
        this.browser = browser;
    }

        public MainTest() {}

    @Parameterized.Parameters
    public static Collection testData() throws IOException {
        return Arrays.asList(new Object[][]{
                {"chrome"},
                {"firefox"}
        });
    }

    @Rule
    public TestName testName = new TestName();

    @Before
    public void setUp() throws IOException{


        MainPage mainPage = new MainPage(webDriver);

        //Setup browser
        if ("chrome".equals(browser)) {
            logger.info(browser + " will be started");
            File chromeFF = new File("./drivers/chromedriver");
            System.setProperty("webdriver.chrome.driver", chromeFF.getAbsolutePath());
            webDriver = new ChromeDriver();
        }
        else if ("firefox".equals(browser)){
            logger.info(browser + " will be started");
            File fireFox = new File("./drivers/geckodriver");
            System.setProperty("webdriver.gecko.driver", fireFox.getAbsolutePath());
            webDriver = new FirefoxDriver();
        }
        logger.info(browser + " is started");
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        File file = new File("");
        pathToScreenShot = file.getAbsolutePath() + "/resources/screenshot/" +
                this.getClass().getPackage().getName() + "/" +
                this.getClass().getSimpleName() + "/" + this.testName.getMethodName() + ".png";

        registrationPage = new RegistrationPage(webDriver);

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
            webDriver.manage().deleteAllCookies();
            logger.info("Clear cookies");
            webDriver.quit();
            logger.info("Close browser");
        }
    }


    //Matcher => CoreMatchers
    public void checkAC(String message, boolean actualRes, boolean expectedRes){
        Assert.assertEquals(message, actualRes, is(expectedRes));
    }

}
