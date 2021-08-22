import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

import pages.MainPage;
import pages.RegistrationPage;


//import static org.hamcrest.MatcherAssert.assertThat;
//import static org.hamcrest.core.IsEqual.equalTo;

public class Hamcrest {
    private WebDriver webDriver;
    private Logger logger = Logger.getLogger(getClass());

    public RegistrationPage registrationPage;
    public MainPage mainPage;

//    @Before
//    public void setUp(){
//        //Setup browser
//        File ChromeFF = new File("./drivers/chromedriver");
//        System.setProperty("webdriver.chrome.driver", ChromeFF.getAbsolutePath());
//        webDriver = new ChromeDriver();
//        registrationPage = new RegistrationPage(webDriver);
//        mainPage = new MainPage(webDriver);
//        webDriver.manage().window().maximize();
//        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//
//
//    }
//    @After
//    public void tearDown(){
//        //Close chromedriver
//        webDriver.manage().deleteAllCookies();
//        logger.info("Clear cookies");
//        webDriver.quit();
//        logger.info("Close browser");
//    }
//    @Test
//    public void testHamcrest(){
//        registrationPage.openRegistrationPage();
//        registrationPage.clickSignIn();
//        registrationPage.InputEmailCreate("2unamewepp-6426@yopmail.com");
//        registrationPage.submitButtonCreate();
//        registrationPage.formAccount.click();
//        logger.info("Choose title 'Mr'");
//        registrationPage.customerFirstNameInput.sendKeys("Alex");
//        logger.info("Enter First Name");
//        registrationPage.customerLastNameInput.sendKeys("Barilovsky");
//        logger.info("Enter Last Name");
//        registrationPage.passwordInput.sendKeys("QWErty123");
//        logger.info("Input password");
//        registrationPage.streetInput.sendKeys("Ocean Street 58");
//        logger.info("Enter Street");
//        registrationPage.cityInput.sendKeys("Chicago");
//        logger.info("Enter City");
//        registrationPage.postCodeInput.sendKeys("12345");
//        logger.info("Input Post code");
//        registrationPage.phoneNumberInput.sendKeys("12345678");
//        logger.info("Enter phone number");
//        registrationPage.aliasInput.clear();
//        registrationPage.aliasInput.sendKeys("6426@yopmail.com");
//        logger.info("Enter alias");
//        registrationPage.submitAccount.click();
//        logger.info("Click on Register button");
//
//        String alertText = webDriver.findElement(By.xpath("//div[@class='alert alert-danger']/p[1]")).getText();
//        assertThat(alertText, equalTo("There is 1 error"));
//        logger.info("Main alert text is: There is 1 error");
//
//        String errorText1 = webDriver.findElement(By.xpath("//div[@class='alert alert-danger']/ol[1]/li[1]")).getText();
//        assertThat(errorText1, equalTo("This country requires you to choose a State."));
//        logger.info("First error text is: This country requires you to choose a State.");
//    }
}
