import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AutomationPracticeForm {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.holdBrowserOpen = true;
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
        $("#subjectsInput").setValue("Programming");
        $("#hobbies-checkbox-1 + label").click();
        $("#hobbies-checkbox-3 + label").click();
        $("#submit").scrollTo();
        File file = new File("src/test/resources/foto.jpg");
        $("#uploadPicture").uploadFile(file);
        $("#currentAddress").setValue("Russia, Saint-Petersburg");
        $("#state").click();
        $("#state").$(byText("Haryana")).click();
        $("#city").click();
        $("#city").$(byText("Karnal")).click();
        $("#submit").click();
    }
}