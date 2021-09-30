package pagesSelenide;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MyAccountPage {

    public SelenideElement
            accountBtn = $x("//a[@class='account']/span[1]"),
            titleRegisteredAccount = $x("//div[@id='center_column']/h1");

    public String getAccountName() {
        return accountBtn.getText();
    }

    public void getHeaderName(String text) {
        titleRegisteredAccount.shouldHave(Condition.visible);
    }
}
