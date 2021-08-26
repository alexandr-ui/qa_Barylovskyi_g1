package MainTests;

import com.github.javafaker.Faker;
import libs.Utils;
import org.apache.log4j.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import pages.ContactUsPage;
import pages.MyAccountPage;
import pages.RegistrationPage;
import pages.SignInPage;

import java.io.File;
import java.util.concurrent.TimeUnit;



public class MainTest {
    public WebDriver webDriver;
    public RegistrationPage registrationPage;
    public ContactUsPage contactUsPage;
    public SignInPage signInPage;
    public MyAccountPage myAccountPage;
    public Logger logger;
    public Faker faker;

    public Utils utils = new Utils();
    private String pathToScreenShot;
    public MainTest() {}

    //анотация @Parameters в которой указываем browser, который берем из параметров в testng.xml
    @Parameters("browser")

    @BeforeClass(alwaysRun = true)
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


    @AfterClass
    public void tearDown(ITestContext testContext){
        if (!(webDriver == null)) {
            utils.screenShot(pathToScreenShot, webDriver);
            webDriver.manage().deleteAllCookies();
            logger.info("Clear cookies");
            webDriver.quit();
            logger.info("Close browser");
        }
    }


}


