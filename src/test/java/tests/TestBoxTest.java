package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestBoxTest extends TestBase {

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