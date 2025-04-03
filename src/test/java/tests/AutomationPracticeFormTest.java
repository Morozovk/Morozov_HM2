package tests;

import org.junit.jupiter.api.Test;
import pages.PracticeFormPage;



public class AutomationPracticeFormTest extends TestBase {

    PracticeFormPage practiceFormPage = new PracticeFormPage();
    TestData testData = new TestData();

    @Test
    void fullTest() {
        practiceFormPage.openPage()
                .setFirstName(testData.firstName())
                .setLastName(testData.lastName())
                .setUserEmail(testData.email())
                .setGender(testData.gender())
                .setUserNumber(testData.number())
                .setDateBirth(testData.dayBirth(),testData.monthBirth(),testData.yearBirth())
                .setHobbies(testData.hobbies())
                .scrollPage()
                .uploadPhoto("photo.jpg")
                .setCurrentAddress(testData.currentAddress())
                .setState(testData.state())
                .setCity(testData.city)
                .clickSubmit()
                .checkTableValue("Student Name", testData.fullName)
                .checkTableValue("Student Email", testData.email())
                .checkTableValue("Gender", testData.gender())
                .checkTableValue("Mobile", testData.number())
                .checkTableValue("Date of Birth", testData.dayOfBirthday)
                .checkTableValue("Hobbies", testData.hobbies())
                .checkTableValue("Picture", "photo.jpg")
                .checkTableValue("Address", testData.currentAddress())
                .checkTableValue("State and City", testData.stateAndCity);
        }

    @Test
    void minimalTest() {
        practiceFormPage.openPage()
                        .setFirstName(testData.firstName())
                        .setLastName(testData.lastName())
                        .setUserEmail(testData.email())
                        .setGender(testData.gender())
                        .setUserNumber(testData.number())
                        .setDateBirth(testData.dayBirth(),testData.monthBirth(),testData.yearBirth())
                        .scrollPage()
                        .clickSubmit()
                        .checkTableValue("Student Name", testData.fullName)
                        .checkTableValue("Student Email", testData.email())
                        .checkTableValue("Gender", testData.gender())
                        .checkTableValue("Mobile", testData.number())
                        .checkTableValue("Date of Birth", testData.dayOfBirthday);

    }


    @Test
    void negativeTest() {
        practiceFormPage.openPage()
                        .setUserEmail(testData.notCorrectEmail)
                        .scrollPage()
                        .clickSubmit()
                        .checkVisibleTable();
    }

}