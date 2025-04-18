package tests.workWithJenkins;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.PracticeFormPage;
import utils.TestData;

import java.util.Map;

import static io.qameta.allure.Allure.step;

public class WorkWithJenkins {

        @BeforeAll()
        static void beforeAll() {
                Configuration.browserSize = "1920x1080";
                Configuration.baseUrl = "https://demoqa.com";
                Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
                SelenideLogger.addListener("allure", new AllureSelenide());

                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                        "enableVNC", true,
                        "enableVideo", true
                ));
                Configuration.browserCapabilities = capabilities;

        }

        @AfterEach
        void addAttachments() {
                Attach.screenshotAs("Last screenshot");
                Attach.pageSource();
                Attach.browserConsoleLogs();
                Attach.addVideo();

        }


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

        @Test
        @Tag("All_Test")
        @Tag("Full_Test")
        void fullTest() {

                step ("Открываем форму", () -> {
                        practiceFormPage.openPage();
                });

                step ("Вводим значиния", () -> {
                        practiceFormPage.setFirstName(firstName)
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
                                .setCity(city);
                });

                step ("Кликаем по кнопке Submit", () -> {
                        practiceFormPage.clickSubmit();
                });

                step ("проверяем ранее заполненные данные", () -> {
                        practiceFormPage.checkTableValue("Student Name", firstName + " " + lastName)
                                .checkTableValue("Student Email", email)
                                .checkTableValue("Gender", gender)
                                .checkTableValue("Mobile", number)
                                .checkTableValue("Date of Birth", dayBirth + " " + monthBirth + "," + yearBirth)
                                .checkTableValue("Hobbies", hobbies)
                                .checkTableValue("Picture", uploadPhoto)
                                .checkTableValue("Address", currentAdress)
                                .checkTableValue("State and City", state + " " + city);;
                });
        }

        @Test
        @Tag("All_Test")
        @Tag("Short_Test")
        void minimalTest() {
                practiceFormPage.openPage()
                        .setFirstName(firstName)
                        .setLastName(lastName)
                        .setUserEmail(email)
                        .setGender(gender)
                        .setUserNumber(number)
                        .setDateBirth(dayBirth, monthBirth, yearBirth)
                        .scrollPage()
                        .clickSubmit()
                        .checkTableValue("Student Name", firstName + " " + lastName)
                        .checkTableValue("Student Email", email)
                        .checkTableValue("Gender", gender)
                        .checkTableValue("Mobile", number)
                        .checkTableValue("Date of Birth", dayBirth + " " + monthBirth + "," + yearBirth);
        }


        @Test
        @Tag("All_Test")
        @Tag("Negative_Test")
        void negativeTest() {
                practiceFormPage.openPage()
                        .setUserEmail(testData.notCorrectEmail)
                        .scrollPage()
                        .clickSubmit()
                        .checkVisibleTable();
        }

    }
