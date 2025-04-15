package tests.workWithAllure;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class WorkWithLambda {

    String userName = "Ivan";
    String userEmail = "Petrov_Ivan@Mail.ru";
    String currentAddress = "Russia, Moscow";
    String permanentAddress = "Russia, Saint-Petersburg";
    String fullInfo = " " + userName + " " + userEmail + " " + currentAddress + " " + permanentAddress;

    @Test
    void withListenerTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        step ("Открываем форму", () -> {
            open("https://demoqa.com/text-box");
        });

        step ("Вводим значения в форму" + fullInfo, () -> {
            $("#userName").setValue(userName);
            $("#userEmail").setValue(userEmail);
            $("#currentAddress").setValue(currentAddress);
            $("#permanentAddress").setValue(permanentAddress);
        });

        step("Прокручиваем экран до элемента, тапаем на него", () -> {
            $("#submit").scrollTo();
            $("#submit").click();
        });
    }
}

