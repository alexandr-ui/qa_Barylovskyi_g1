package MainTests;

import com.github.javafaker.Faker;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import libs.CustomListener;
import libs.Utils;
import org.apache.log4j.Logger;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;
import pages.*;

import java.io.File;
import java.util.concurrent.TimeUnit;


@Listeners({CustomListener.class})
public class  MainTest {
    public WebDriver webDriver;
    public RegistrationPage registrationPage;
    public ContactUsPage contactUsPage;
    public ConverterPage converterPage;
    public SignInPage signInPage;
    public MyAccountPage myAccountPage;
    public Logger logger;
    public Faker faker;

    public Utils utils = new Utils();
    private String pathToScreenShot;
    public MainTest() {}

    //анотация @Parameters в которой указываем browser, который берем из параметров в testng.xml
    @BeforeClass(alwaysRun = true)
    @Parameters("browser")
    @Step("Set up browser options  {browser}")
    public void setUp(@Optional("chrome") String browser){
        //Setup browser
        if (browser.toLowerCase().equals("chrome")) {
            File chrome = new File("./drivers/chromedriver");
            System.setProperty("webdriver.chrome.driver", chrome.getAbsolutePath());
            webDriver = new ChromeDriver();
        } else if (browser.toLowerCase().equals("firefox")) {
            File firefox =  new File("./drivers/geckodriver");
            System.setProperty("webdriver.gecko.driver", firefox.getAbsolutePath());
            webDriver = new FirefoxDriver();
        }
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        registrationPage = new RegistrationPage(webDriver);
        contactUsPage = new ContactUsPage(webDriver);
        converterPage = new ConverterPage(webDriver);
        signInPage = new SignInPage(webDriver);
        myAccountPage = new MyAccountPage(webDriver);

        faker = new Faker();
        logger = Logger.getLogger(getClass());


        File file = new File("");
        pathToScreenShot = file.getAbsolutePath() + "/resources/screenshot/" +
                this.getClass().getPackage().getName() + "/" +
                this.getClass().getSimpleName() + ".png";


        try{
            webDriver.get("http://automationpractice.com");
            logger.info("Open URL - http://automationpractice.com");
        } catch(Exception e){
            logger.error("Can't open browser");
            Assert.fail("Can't open browser");
        }
    }

    @Step("Tear down browser options and testContext {testContext}")
    @AfterClass
    public void tearDown(ITestContext git ){
        if (!(webDriver == null)) {
            screenshot();
            utils.screenShot(pathToScreenShot, webDriver);
            webDriver.manage().deleteAllCookies();
            logger.info("Clear cookies");
            webDriver.quit();
            logger.info("Close browser");
        }
    }

    @Attachment(value = "screenshot", type = "image/png")
    public byte[] screenshot() {
        return ((TakesScreenshot)webDriver).getScreenshotAs(OutputType.BYTES);
    }

}


