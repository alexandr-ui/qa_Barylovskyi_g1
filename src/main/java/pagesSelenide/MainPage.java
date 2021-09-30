package pagesSelenide;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MainPage {

    public SelenideElement column = $("#center_column");
    public ElementsCollection products = $$("#homefeatured li div div h5 a");

    @Step("Get product")
    public void getProducts() {
        if(column.exists()){
            //strict verification
            products.shouldHave(CollectionCondition.itemWithText("Blouse"));
            //not strict verification
            products.filter(Condition.text("Blouse")).shouldHave(CollectionCondition.sizeGreaterThan(0));
        } else {
            products.shouldHave(CollectionCondition.size(0));
        }
    }

    @Step("Click to product {product}")
    public void clickToProduct(String product) {
        products.findBy(Condition.exactText(product)).click();
    }
}
