package libs;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.io.File;

public class Utils {

    private Logger logger;

    public Utils() {
        logger = Logger.getLogger(getClass());

    }

    /**
     * Taking screenshot into path
     * @param pathToScreenShot
     * @param webDriver
     * */
    public void screenShot(String pathToScreenShot, WebDriver webDriver) {
        File scrFile = ((TakesScreenshot)webDriver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File( pathToScreenShot));
            logger.info("Screenshot: " + pathToScreenShot);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Hard wait
     * @param
     * */
    public static void hardWait(int second) {
        try {
            Thread.sleep(second);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
