package tests;

import org.junit.jupiter.api.Test;
import pages.PracticeFormPage;


public class AutomationPracticeForm extends TestBase {

    PracticeFormPage practiceFormPage = new PracticeFormPage();


    String firstName = "Kir";
    String lastName = "Morozov";
    String email = "morozovk18@mail.ru";
    String number = "0987654321";
    String currentAdress = "Russia, Saint-Petersburg";


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
                        .scrollpage()
                        .uploadFoto()
                        .setCurrentAdress(currentAdress)
                        .setState("Haryana")
                        .setCity("Karnal")
                        .clickSubmit()
                        .checkMaxForm(firstName,lastName,email,"Male",number,"23","August","1998",
                        "Sports", "Music", currentAdress, "Haryana", "Karnal");
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
                .scrollpage()
                .clickSubmit()
                .checkMinForm(firstName,lastName,email,"Male",number,"23","August","1998");
    }


    @Test
    void thirdTest() {
        practiceFormPage.openPage()
                .scrollpage()
                .clickSubmit();
    }

}