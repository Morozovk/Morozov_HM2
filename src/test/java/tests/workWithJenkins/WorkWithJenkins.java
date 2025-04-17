package tests.workWithJenkins;

import org.junit.jupiter.api.Test;
import pages.PracticeFormPage;
import tests.TestBase;
import utils.TestData;

public class WorkWithJenkins extends TestBase{

        PracticeFormPage practiceFormPage = new PracticeFormPage();
        TestData testData = new TestData();

        String firstName = testData.getFirstName();
        String lastName = testData.getLastName();
        String email = testData.getEmail();
        String gender = testData.getGender();
        String number = testData.getNumber();
        String dayBirth = testData.getDayBirth();
        String monthBirth = testData.getMonthBirth();
        String yearBirth = testData.getYearBirth();
        String hobbies = testData.getHobbies();
        String currentAdress = testData.getCurrentAddress();
        String state = testData.getState();
        String city = testData.getSelectCity(state);
        String uploadPhoto = "photo.jpg";
        String subject = "English";

        @Test
        void fullTest() {
            practiceFormPage.openPage()
                    .setFirstName(firstName)
                    .setLastName(lastName)
                    .setUserEmail(email)
                    .setGender(gender)
                    .setUserNumber(number)
                    .setDateBirth(dayBirth, monthBirth, yearBirth)
                    .setHobbies(hobbies)
                    .scrollPage()
                    .uploadPhoto(uploadPhoto)
                    .setCurrentAddress(currentAdress)
                    .setState(state)
                    .setCity(city)
                    .clickSubmit()
                    .checkTableValue("Student Name", firstName + " " + lastName)
                    .checkTableValue("Student Email", email)
                    .checkTableValue("Gender", gender)
                    .checkTableValue("Mobile", number)
                    .checkTableValue("Date of Birth", dayBirth + " " + monthBirth + "," + yearBirth)
                    .checkTableValue("Hobbies", hobbies)
                    .checkTableValue("Picture", uploadPhoto)
                    .checkTableValue("Address", currentAdress)
                    .checkTableValue("State and City", state + " " + city);
        }
    }
