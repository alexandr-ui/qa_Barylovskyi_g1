package pagesSelenide;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class SignInPage {

    public SelenideElement
            loginInput = $x("//a[@class='login']"),
            emailCreateInput = $(By.id("email_create"));

    public void clickToSignIn() {
        loginInput.click();
    }

    public void inputEmailCreate(String email) {
        emailCreateInput.setValue(email);
    }
}
