import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SelenideReprositorySearch {
    @BeforeAll
    static void beforeAll (){
        Configuration.browserSize = "1920x1080";
        sleep(10000);
    }

    @Test
    void test() {
        open("https://github.com");
        $(".search-input").$(".flex-1").click();
        $("#query-builder-test").setValue("Selenide").pressEnter();
        $(".search-match").click();
        $$("ul li").findBy(text("Wiki")).click();
        $$("ul li").findBy(text("Soft assertions")).shouldHave(text("Soft assertions"));
        $$("ul li").findBy(text("Soft assertions")).click();
    }
}
