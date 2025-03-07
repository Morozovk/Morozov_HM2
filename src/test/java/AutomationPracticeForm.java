import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class AutomationPracticeForm {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void firstTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Kirill");
        $("#lastName").setValue("Morozov");
        $("#userEmail").setValue("Morozov_kirill@mail.ru");
        $(".custom-control-label").click();
        $("#userNumber").setValue("88003555555");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOptionByValue("1998");
        $(".react-datepicker__month-select").selectOption("August");
        $(".react-datepicker__day.react-datepicker__day--023.react-datepicker__day--weekend").click();
        $("#hobbies-checkbox-1 + label").click();
        $("#hobbies-checkbox-3 + label").click();
        $("#submit").scrollTo();
        File file = new File("src/test/resources/foto.jpg");
        $("#uploadPicture").uploadFromClasspath("foto.jpg");
        $("#currentAddress").setValue("Russia, Saint-Petersburg");
        $("#state").click();
        $("#state").$(byText("Haryana")).click();
        $("#city").click();
        $("#city").$(byText("Karnal")).click();
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Kirill Morozov"));
        $(".table-responsive").shouldHave(text("Morozov_kirill@mail.ru"));
        $(".table-responsive").shouldHave(text("Male"));
        $(".table-responsive").shouldHave(text("8800355555"));
        $(".table-responsive").shouldHave(text("23 August,1998"));
        $(".table-responsive").shouldHave(text("Sports, Music"));
        $(".table-responsive").shouldHave(text("foto.jpg"));
        $(".table-responsive").shouldHave(text("Russia, Saint-Petersburg"));
        $(".table-responsive").shouldHave(text("Haryana Karnal"));
    }

}