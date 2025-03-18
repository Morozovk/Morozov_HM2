import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.DragAndDropOptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDrop {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void firstTest() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        $("#column-a").shouldHave(text("a"));
        $("#column-b").shouldHave(text("b"));
        WebElement sourceElement = $("#column-a");
        WebElement targetElement = $("#column-b");
        actions().moveToElement($(sourceElement)).clickAndHold().moveToElement(targetElement).release().perform();
        $("#column-a").shouldHave(text("b"));
        $("#column-b").shouldHave(text("a"));
    }

    @Test
    void secondTest() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        $("#column-a").shouldHave(text("a"));
        $("#column-b").shouldHave(text("b"));
        $("#column-a").dragAndDrop(DragAndDropOptions.to("#column-b"));
        $("#column-a").shouldHave(text("b"));
        $("#column-b").shouldHave(text("a"));
    }
}
