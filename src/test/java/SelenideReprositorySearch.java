import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SelenideReprositorySearch {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        sleep(10000);
    }

    @Test
    void test() {
        open("https://github.com/selenide/selenide");
        element("a[id='wiki-tab']").click();
        element("ul[data-filterable-for='wiki-pages-filter']").find(byCssSelector("button[type='button']")).click();
        element("a[href='/selenide/selenide/wiki/SoftAssertions']").shouldBe(visible).click();
        element("a[id='user-content-3-using-junit5-extend-test-class']").scrollTo().hover().shouldBe(visible);
        element(byText("3. Using JUnit5 extend test class:")).shouldBe(visible);
    }
}
