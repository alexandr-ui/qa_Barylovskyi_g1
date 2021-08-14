package pages;
import libs.WebElements;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static org.hamcrest.CoreMatchers.is;

public class MainPage {

    WebDriver webDriver;
    Logger logger;
    WebElements webElements;

    public MainPage(WebDriver webDriver){
        this.webDriver = webDriver;
        logger = Logger.getLogger(getClass());
        webElements = new WebElements(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    /**
     * Method open urls
     * @param url
     * */
    public void openUrl(String url){
        try{
            webDriver.get(url);
            logger.info("Page was opened: " + url);
        }catch (Exception e){
            e.printStackTrace();
            logger.error("Page can't be opened" + url);
            Assert.fail("page can't be opened" + url);

        }
    }

    public void checkTitle(String expectedTitle){
        try{
            Assert.assertThat("Title not matched", webDriver.getTitle(), is(expectedTitle ));
        } catch (Exception e) {
            logger.error("Cannot find title " + expectedTitle);
            Assert.fail("Cannot find title " + expectedTitle);
        }
    }


}
