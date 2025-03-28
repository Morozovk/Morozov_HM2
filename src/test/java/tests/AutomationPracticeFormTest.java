package tests;

import org.junit.jupiter.api.Test;
import pages.PracticeFormPage;


public class AutomationPracticeFormTest extends TestBase {

    PracticeFormPage practiceFormPage = new PracticeFormPage();


    String firstName = "Kir";
    String lastName = "Morozov";
    String email = "morozovk18@mail.ru";
    String number = "0987654321";
    String currentAddress = "Russia, Saint-Petersburg";


    @Test
    void firstTest() {
        practiceFormPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(email)
                .setGender("Male")
                .setUserNumber(number)
                .setDateBirth("23","August","1998")
                .setHobbies("Sports")
                .setHobbies("Music")
                .scrollPage()
                .uploadPhoto("photo.jpg")
                .setCurrentAddress(currentAddress)
                .setState("Haryana")
                .setCity("Karnal")
                .clickSubmit()
                .checkTableValue("Student Name", firstName+ " " + lastName)
                .checkTableValue("Student Email", "morozovk18@mail.ru")
                .checkTableValue("Gender", "Male")
                .checkTableValue("Mobile", "0987654321")
                .checkTableValue("Date of Birth", "23 August,1998")
                .checkTableValue("Hobbies", "Sports, Music")
                .checkTableValue("Picture", "photo.jpg")
                .checkTableValue("Address", currentAddress)
                .checkTableValue("State and City", "Haryana Karnal");
        }

    @Test
    void secondTest() {
        practiceFormPage.openPage()
                        .setFirstName(firstName)
                        .setLastName(lastName)
                        .setUserEmail(email)
                        .setGender("Male")
                        .setUserNumber(number)
                        .setDateBirth("23","August","1998")
                        .scrollPage()
                        .clickSubmit()
//                        .checkTableValue("Student Name", firstName + "/n" + lastName)
//                        .checkTableValue("Student Email", "morozovk18@mail.ru")
//                        .checkTableValue("Gender", "Male")
//                        .checkTableValue("Mobile", "0987654321")
//                        .checkTableValue("Date of Birth", "23 August, 1998")
//                        .checkTableValue("Subjects", "")
//                        .checkTableValue("Hobbies", "Sports, Music")
//                        .checkTableValue("Picture", "photo.jpg")
//                        .checkTableValue("Address", "currentAddress")
//                        .checkTableValue("State and City", "Haryana Karnal")

//                        .checkMinForm(firstName, lastName, email, "Male", number, "23", "August", "1998");
        ;


//        practiceFormPage.tableComponent.checkValue("a", "b");
//        practiceFormPage.checkTableValue("a", "b")
//                .checkTableValue("c", "d");
    }


    @Test
    void thirdTest() {
        practiceFormPage.openPage()
                        .scrollPage()
                        .clickSubmit();
    }

}