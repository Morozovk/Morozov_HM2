package tests;

import org.junit.jupiter.api.Test;
import pages.PracticeFormPage;



public class AutomationPracticeFormTest extends TestBase {

    PracticeFormPage practiceFormPage = new PracticeFormPage();
    TestData testData = new TestData();

    @Test
    void fullTest() {
        practiceFormPage.openPage()
                .setFirstName(testData.getFirstName())
                .setLastName(testData.getLastName())
                .setUserEmail(testData.getEmail())
                .setGender(testData.getGender())
                .setUserNumber(testData.getNumber())
                .setDateBirth(testData.getDayBirth(),testData.getMonthBirth(),testData.getYearBirth())
                .setHobbies(testData.getHobbies())
                .scrollPage()
                .uploadPhoto("photo.jpg")
                .setCurrentAddress(testData.getCurrentAddress())
                .setState(testData.getState())
                .setCity(testData.getSelectCity(testData.getState()))
                .clickSubmit()
                .checkTableValue("Student Name", testData.fullName)
                .checkTableValue("Student Email", testData.getEmail())
                .checkTableValue("Gender", testData.getGender())
                .checkTableValue("Mobile", testData.getNumber())
                .checkTableValue("Date of Birth", testData.dayOfBirthday)
                .checkTableValue("Hobbies", testData.getHobbies())
                .checkTableValue("Picture", "photo.jpg")
                .checkTableValue("Address", testData.getCurrentAddress())
                .checkTableValue("State and City", testData.stateAndCity);
        }

    @Test
    void minimalTest() {
        practiceFormPage.openPage()
                        .setFirstName(testData.getFirstName())
                        .setLastName(testData.getLastName())
                        .setUserEmail(testData.getEmail())
                        .setGender(testData.getGender())
                        .setUserNumber(testData.getNumber())
                        .setDateBirth(testData.getDayBirth(),testData.getMonthBirth(),testData.getYearBirth())
                        .scrollPage()
                        .clickSubmit()
                        .checkTableValue("Student Name", testData.fullName)
                        .checkTableValue("Student Email", testData.getEmail())
                        .checkTableValue("Gender", testData.getGender())
                        .checkTableValue("Mobile", testData.getNumber())
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