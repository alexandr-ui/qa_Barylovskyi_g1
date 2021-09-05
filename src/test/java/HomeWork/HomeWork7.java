package HomeWork;

import MainTests.MainTest;
import org.testng.annotations.Test;

public class HomeWork7 extends MainTest {


    @Test
    public void testConverterText() {
        converterPage.openConverterPage();
//        (new WebDriverWait(webDriver, 10))
//                .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(1));
        converterPage.clickOnClose();
        converterPage.verifyTextAboutConverter("Конвертер валют онлайн ");
    }

    @Test
    public void testUSDtoUAH() {
        converterPage.enterAmount("1");
        converterPage.selectCurrency("USD");
        converterPage.verifyAmountUAH("26");
    }

    @Test
    public void testEURtoPLN() {
        converterPage.enterAmount("1");
        converterPage.selectCurrency("EUR");
        converterPage.verifyAmountPLN("4.4");
    }


}
