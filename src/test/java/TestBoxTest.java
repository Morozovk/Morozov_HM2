import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestBoxTest{

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void firstTest() {
        open("/text-box");
        $("#userName").setValue("Ivan");
        $("#userEmail").setValue("Petrov_Ivan@Mail.ru");
        $("#currentAddress").setValue("Russia, Moscow");
        $("#permanentAddress").setValue("Russia, Moscow");
        $("#submit").click();
    }

}