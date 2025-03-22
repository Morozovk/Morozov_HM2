package pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ex.Strings;
import org.openqa.selenium.devtools.v132.css.model.Value;
import pages.components.CalendarComponent;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormPage {
    private static SelenideElement firstNameImput = $("#firstName"),
                                   lastNameInput = $("#lastName"),
                                   userEmailInput = $("#userEmail"),
                                   genderImput = $("#genterWrapper"),
                                   userNumberInput = $("#userNumber"),
                                   calendarInput = $("#dateOfBirthInput"),
                                   hobbiesInput = $("#hobbiesWrapper"),
                                   scrollPages = $("#submit"),
                                   fotoImput = $("#uploadPicture"),
                                   currentAdressImput = $("#currentAddress"),
                                   stateImput = $("#state"),
                                   cityImput = $("#city"),
                                   submitClick = $("#submit"),
                                   formCheck = $(".modal-content");

    CalendarComponent calendarComponent = new CalendarComponent();
    File file = new File("src/test/resources/foto.jpg");



public PracticeFormPage openPage() {
    open("/automation-practice-form");
    $(".text-center").shouldHave(text("Practice Form"));
    return this;
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

public PracticeFormPage setDateBirth(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
}

public PracticeFormPage setHobbies(String Value) {
        hobbiesInput.$(byText(Value)).click();
        return this;
}

public PracticeFormPage scrollpage() {
        scrollPages.scrollTo();
        return this;
}

public PracticeFormPage uploadFoto() {
        fotoImput.uploadFromClasspath("foto.jpg");
        return this;
}

public PracticeFormPage setCurrentAdress(String Value) {
        currentAdressImput.setValue(Value);
        return this;
}

public PracticeFormPage setState(String Value){
        stateImput.click();
        stateImput.$(byText(Value)).click();
        return this;
}

public PracticeFormPage setCity(String Value){
        cityImput.click();
        cityImput.$(byText(Value)).click();
        return this;
}

public PracticeFormPage clickSubmit(){
        submitClick.click();
        return this;
}

public PracticeFormPage checkMaxForm(String firstName, String lastName, String email, String gender,
                                  String number, String day, String month, String year, String hobbies, String hobbies2, String currentAdress,
                                  String state, String city)  {
        formCheck.shouldHave(text("Thanks for submitting the form"))
                 .shouldHave(text(firstName))
                 .shouldHave(text(lastName))
                 .shouldHave(text(email))
                 .shouldHave(text(gender))
                 .shouldHave(text(number))
                 .shouldHave(text(day))
                 .shouldHave(text(month))
                 .shouldHave(text(year))
                 .shouldHave(text(hobbies))
                 .shouldHave(text(hobbies2))
                 .shouldHave(text(currentAdress))
                 .shouldHave(text("foto.jpg"))
                 .shouldHave(text(state))
                 .shouldHave(text(city));
                 return this;
        }


public PracticeFormPage checkMinForm(String firstName, String lastName, String email, String gender,
                                             String number, String day, String month, String year)  {
                formCheck.shouldHave(text("Thanks for submitting the form"))
                        .shouldHave(text(firstName))
                        .shouldHave(text(lastName))
                        .shouldHave(text(email))
                        .shouldHave(text(gender))
                        .shouldHave(text(number))
                        .shouldHave(text(day))
                        .shouldHave(text(month))
                        .shouldHave(text(year));
                return this;
        }
}


