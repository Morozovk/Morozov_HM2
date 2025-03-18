import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.selector.ByTagAndText;
import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class SelenideReprositorySearch {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void test() {
        open("https://github.com/selenide/selenide");
        $("a[id='wiki-tab']").click();
        $("ul[data-filterable-for='wiki-pages-filter']").find(byCssSelector("button[type='button']")).click();
        $("a[href='/selenide/selenide/wiki/SoftAssertions']").shouldBe(visible).click();
        $("#wiki-content").shouldHave(text("@ExtendWith({SoftAssertsExtension.class})\n" +
                "class Tests {\n" +
                "  @Test\n" +
                "  void test() {\n" +
                "    Configuration.assertionMode = SOFT;\n" +
                "    open(\"page.html\");\n" +
                "\n" +
                "    $(\"#first\").should(visible).click();\n" +
                "    $(\"#second\").should(visible).click();\n" +
                "  }\n" +
                "}"));
    }
}
