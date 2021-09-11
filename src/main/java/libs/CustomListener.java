package libs;

import io.qameta.allure.Attachment;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class CustomListener extends TestListenerAdapter {

    public CustomListener(){}
    public void onTestStart(ITestResult result) {

    }

    public void onTestSuccess(org.testng.ITestResult result) {

    }

    public void onTestFailure(org.testng.ITestResult result) {

    }

    @Attachment(value = "screenshot", type = "image/png")
    public byte[] screenshot() {
        return new byte[0];
    }

}
