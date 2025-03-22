import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormPage {
    private static SelenideElement firstNameImput = $("#firstName"),
                                   lastNameInput = $("#lastName"),
                                   userEmailInput = $("#userEmail"),
                                   genderImput = $("#genterWrapper"),
                                   userNumberInput = $("#userNumber");
                                   //dateOfBirthInput = $("#dateOfBirthInput"),


public void openPage() {
    open("/automation-practice-form");
    $(".text-center").shouldHave(text("Practice Form"));
    }

public PracticeFormPage setFirstName(String Value) {
        firstNameImput.setValue(Value);
        return this;
}

public PracticeFormPage setLastName(String Value) {
        lastNameInput.setValue(Value);
        return this;
}

public PracticeFormPage setUserEmail(String Value) {
        userEmailInput.setValue(Value);
        return this;
}

public PracticeFormPage setGender(String Value) {
        genderImput.$(byText(Value)).click();
        return this;
}

public PracticeFormPage setUserNumber(String Value) {
        userNumberInput.setValue(Value);
        return this;
}

//public PracticeFormPage setDateOfBirthDay(String Value){
//        dateOfBirthInput.$(".react-datepicker__year-select").selectOptionByValue("1998");
//        $(".react-datepicker__month-select").selectOption("August");
//        $(".react-datepicker__day.react-datepicker__day--023.react-datepicker__day--weekend").click();;
//        return this;
//}

}
