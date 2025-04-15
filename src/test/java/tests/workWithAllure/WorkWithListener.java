package tests.workWithAllure;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WorkWithListener {
    @Test
    void withListenerTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        open("https://demoqa.com/text-box");
        $("#userName").setValue("Ivan");
        $("#userEmail").setValue("Petrov_Ivan@Mail.ru");
        $("#currentAddress").setValue("Russia, Moscow");
        $("#permanentAddress").setValue("Russia, Moscow");
        $("#submit").scrollTo();
        $("#submit").click();
    }
}
