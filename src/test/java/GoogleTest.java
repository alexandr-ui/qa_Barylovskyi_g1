//import org.junit.After;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.apache.log4j.Logger;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//import java.io.File;
//import java.util.concurrent.TimeUnit;
//
//public class GoogleTest {
//    private WebDriver webDriver;
//    private Logger logger = Logger.getLogger(getClass());
//
//    @Before
//    public void setUp(){
//        //Setup browser
//        File ChromeFF = new File("./drivers/chromedriver");
//        System.setProperty("webdriver.chrome.driver", ChromeFF.getAbsolutePath());
//        webDriver = new ChromeDriver();
//        webDriver.manage().window().maximize();
//        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//
//        try {
//            webDriver.get("https://google.com");
//            logger.info("Open URL - https://google.com");
//        } catch(Exception e){
//            logger.error("Can't open browser");
//            Assert.fail("Can't open browser");
//        }
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
//
//    @Test
//    public void testGoogleSearch(){
//
//        webDriver.findElement(By.xpath("//input[@class=\"gLFyf gsfi\"]")).sendKeys("assert junit 4");
//        logger.info("Enter 'assert junit 4' in a search field");
//        webDriver.findElement(By.xpath("//input[@class=\"gNO89b\"]")).click();
//        logger.info("Click on 'Google Search' button");
//
//        String header1 = webDriver.findElement(By.xpath("//div[@id='search']/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/a[1]/h3[1]")).getText();
//        Assert.assertEquals("Assert (JUnit API)", header1);
//        logger.info("Header in the first search result: 'Assert (JUnit API)'");
//
//        String linkSearch1 = webDriver.findElement(By.xpath("//div[@id='search']/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/a[1]")).getAttribute("href");
//        Assert.assertEquals("https://junit.org/junit4/javadoc/4.8/org/junit/Assert.html", linkSearch1);
//        logger.info("Link in the first search result: https://junit.org/junit4/javadoc/4.8/org/junit/Assert.html");
//    }
//
//
//}
