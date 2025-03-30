package tests;

import org.junit.jupiter.api.Test;
import pages.PracticeFormPage;

import static tests.TestData.*;


public class AutomationPracticeFormTest extends TestBase {

    PracticeFormPage practiceFormPage = new PracticeFormPage();


    @Test
    void fullTest() {
        practiceFormPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(email)
                .setGender(gender)
                .setUserNumber(number)
                .setDateBirth(dayBirth,monthBirth,yearBirth)
                .setHobbies(hobbies)
                .scrollPage()
                .uploadPhoto("photo.jpg")
                .setCurrentAddress(currentAddress)
                .setState(state)
                .setCity(city)
                .clickSubmit()
                .checkTableValue("Student Name", fullName)
                .checkTableValue("Student Email", email)
                .checkTableValue("Gender", gender)
                .checkTableValue("Mobile", number)
                .checkTableValue("Date of Birth", dayOfBirthday)
                .checkTableValue("Hobbies", hobbies)
                .checkTableValue("Picture", "photo.jpg")
                .checkTableValue("Address", currentAddress)
                .checkTableValue("State and City", stateAndCity);
        }

    @Test
    void minimalTest() {
        practiceFormPage.openPage()
                        .setFirstName(firstName)
                        .setLastName(lastName)
                        .setUserEmail(email)
                        .setGender(gender)
                        .setUserNumber(number)
                        .setDateBirth(dayBirth,monthBirth,yearBirth)
                        .scrollPage()
                        .clickSubmit()
                        .checkTableValue("Student Name", fullName)
                        .checkTableValue("Student Email", email)
                        .checkTableValue("Gender", gender)
                        .checkTableValue("Mobile", number)
                        .checkTableValue("Date of Birth", dayOfBirthday);

    }


    @Test
    void negativeTest() {
        practiceFormPage.openPage()
                        .setUserEmail(notCorrectEmail)
                        .scrollPage()
                        .clickSubmit()
                        .checkVisibleTable();
    }

}