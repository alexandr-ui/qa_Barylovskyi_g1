package SelenideTests;

import com.codeborne.selenide.*;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;

public class GoogleTestWithSelenide extends BaseTest{

    @Test
    public void testGoogleWithSelenide() {
        Selenide.open(baseUrl);
        $(By.name("q")).val("Selenide").pressEnter();
        $$x("//*[@href='https://selenide.org/']")
                .filter(Condition.visible)
                .shouldHave(CollectionCondition.size(2));
//                .shouldHave(CollectionCondition.texts("1", "2", "3"));
        $x("//a[@href='https://selenide.org/']")
                .shouldBe(Condition.visible)
                .shouldHave(Condition.text("Selenide: concise UI tests in Java"));
        $x("//a[@href='https://selenide.org/']").shouldHave(Condition.exactText("Selenide: concise UI"));

//        $("").uploadFile(new File("csv.doc"));

//        $(byText("Text")).shouldHave(Condition.visible);
//        $(withText("Sele")).shouldHave(Condition.text("Selenide"));
//
//        $("div").parent();
//        $("a").closest("div");
//        $("div").find(By.name("q"));
    }
}
