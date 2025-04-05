package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.TableComponent;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormPage {
    private SelenideElement
            firstNameImput = $("#firstName"),
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
            submitClick = $("#submit");


    private CalendarComponent calendarComponent = new CalendarComponent();
    public TableComponent tableComponent = new TableComponent();


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

    public PracticeFormPage scrollPage() {
        scrollPages.scrollTo();
        return this;
    }

    public PracticeFormPage uploadPhoto(String fileName) {
        fotoImput.uploadFromClasspath(fileName);
        return this;
    }

    public PracticeFormPage setCurrentAddress(String Value) {
        currentAdressImput.setValue(Value);
        return this;
    }

    public PracticeFormPage setState(String Value) {
        stateImput.click();
        stateImput.$(byText(Value)).click();
        return this;
    }

    public PracticeFormPage setCity(String Value) {
        cityImput.click();
        cityImput.$(byText(Value)).click();
        return this;
    }

    public PracticeFormPage clickSubmit() {
        submitClick.click();
        return this;
    }

    public PracticeFormPage checkTableValue(String key, String value) {
        tableComponent.checkValue(key, value);
        return this;
    }

    public PracticeFormPage checkVisibleTable() {
        $(".modal-content").shouldNotBe(visible);
        return this;
    }
}


