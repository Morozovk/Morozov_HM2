package tests.workWithAllure;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class StepsFromForm {

    @Step ("Открываем форму")
    public void openPage() {
        open("https://demoqa.com/text-box");
    }

    @Step ("Вводим значения в форму")
    public void setValue(String userName, String userEmail, String currentAddress, String permanentAddress) {
        $("#userName").setValue(userName);
        $("#userEmail").setValue(userEmail);
        $("#currentAddress").setValue(currentAddress);
        $("#permanentAddress").setValue(permanentAddress);
    }

    @Step ("Прокручиваем экран до элемента, тапаем на него")
    public void clickButton() {
        $("#submit").scrollTo();
        $("#submit").click();
    }
}
