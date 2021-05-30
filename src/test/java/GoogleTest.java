import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class GoogleTest {
    private WebDriver webDriver;

    @Test
    public void testGoogleSearch(){
        //Setup browser
        File ChromeFF = new File("./drivers/chromedriver");
        System.setProperty("webdriver.chrome.driver", ChromeFF.getAbsolutePath());
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        webDriver.get("https://google.com");
        webDriver.findElement(By.xpath("//input[@class=\"gLFyf gsfi\"]")).sendKeys("prog.kiev.ua");
        webDriver.findElement(By.xpath("//input[@class=\"gNO89b\"]")).click();


        //Close chromedriver
        webDriver.quit();
    }


}
