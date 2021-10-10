package SelenideTests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.testng.ScreenShooter;
import com.codeborne.selenide.testng.TextReport;
import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import pagesSelenide.MainPage;
import pagesSelenide.MyAccountPage;
import pagesSelenide.RegistrationPage;
import pagesSelenide.SignInPage;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Configuration.baseUrl;

@Listeners({ScreenShooter.class, TextReport.class})
public class BaseTest {


    public Faker faker = new Faker();
    public SignInPage signInPage = new SignInPage();
    public RegistrationPage registrationPage = new RegistrationPage();
    public MyAccountPage myAccountPage = new MyAccountPage();
    public MainPage mainPage = new MainPage();

    public void setUpBrowser() {
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        // 1 - Allow, 2 - Block, 0 - Default
        prefs.put("profile.default_content_setting_values.notifications", 1);
        options.setExperimentalOption("prefs", prefs);
        options.addArguments("disable-infobars");
        options.addArguments("--window-size=1920,1080");
        WebDriverRunner.setWebDriver(new ChromeDriver(options));
    }

    @BeforeClass
    public void setUp() {
        String RUN_TYPE = "remote";
        switch(RUN_TYPE) {
            case ("local"):
                WebDriverManager.chromedriver().browserVersion("94").setup();
                Configuration.browser = "chrome";
                Configuration.timeout = 8000;
                baseUrl = "http://automationpractice.com/";
                Configuration.screenshots = true;
                Configuration.savePageSource = true;
                Configuration.reopenBrowserOnFail = true;
                ScreenShooter.captureSuccessfulTests = true;
                setUpBrowser();
                Selenide.open(baseUrl);
                break;
            case ("remote"):
                Configuration.remote = "http://localhost:4444/wd/hub";
                Configuration.browserSize = "1920x1080";
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setCapability("browserName", "chrome");
                capabilities.setCapability("browserVersion", "94.0");
                capabilities.setCapability("platform", "LINUX");
                capabilities.setCapability("enableVNC", true);
                capabilities.setCapability("enableVideo", true);
                capabilities.setCapability("enableLog", true);
                Configuration.browserCapabilities = capabilities;
                Selenide.open("http://automationpractice.com/");
                break;
        }
//        Configuration.browser = SelenoidWebDriverProvider.class.getName();
    }

    @AfterClass
    public void tearDown() {
        Selenide.closeWebDriver();
    }

}
