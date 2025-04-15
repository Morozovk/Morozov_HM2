package tests.workWithAllure;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;



public class WorkWithStep {

    String userName = "Ivan";
    String userEmail = "Petrov_Ivan@Mail.ru";
    String currentAddress = "Russia, Moscow";
    String permanentAddress = "Russia, Saint-Petersburg";

    @Test
    void withStepsTest() {
        StepsFromForm step = new StepsFromForm();
        SelenideLogger.addListener("allure", new AllureSelenide());

        step.openPage();
        step.setValue(userName, userEmail,currentAddress,permanentAddress);
        step.clickButton();
    }
}
