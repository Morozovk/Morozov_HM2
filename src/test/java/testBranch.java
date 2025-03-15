import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.bidi.script.LocalValue.setValue;

public class testBranch {
    String userName = "Morozov Kirill";
    String userEmail = "morozovk18@mail.ru";
    String currentAddress = "Russia SPB";
    String permanentAddress = "Russia SAINT-PETERSBURG";
    String firstName = "Kirill";
    String lastName = "Morozov";
    String age = "26";
    String salary = "1000000";
    String departament = "Banking Department";

    @BeforeAll
    static void beforeAll(){
        Configuration.browserSize= "1980x1080";
        Configuration.baseUrl= "https://demoqa.com";
        sleep(15000);
    }

    @Test
    void firstTest(){
        open("/text-box");
        $(".text-center").shouldHave(visible);
        $("#userName").setValue(userName);
        $("#userEmail").setValue(userEmail);
        $("#currentAddress").setValue(currentAddress);
        $("#permanentAddress").setValue(permanentAddress);
        $("[id='submit']").scrollTo().click();
        $("p[id='name']").shouldBe(text(userName));
        $("p[id='email']").shouldBe(text(userEmail));
        $("p[id='currentAddress']").shouldBe(text(currentAddress));
        $("p[id='permanentAddress']").shouldBe(text(permanentAddress));
    }

//    @Test
//    void secondTest(){
//        open("/checkbox");
//        $("[class='text-center']").shouldBe(text("Check Box"));
//        $("[class='rct-option.rct-option-expand-all']").click();
//        $("#rct-title").shouldBe(text("Desktop")).click();
//
//    }

      @Test
      void thirdTest(){
        open("/radio-button");
        $("[class='text-center']").shouldBe(text("Radio Button"));
        $("[class='mb-3']").shouldBe(text("Do you like the site?"));
        $("label[for='yesRadio']").click();
        $("[class='text-success']").shouldHave(text("Yes"));
        $("label[for='impressiveRadio']").click();
        $("[class='text-success']").shouldHave(text("Impressive"));
        $("#noRadio").shouldBe(disabled);
      }

      @Test
      void fourthTest(){
        open("/webtables");
        $("#addNewRecordButton").click();
        $("#registration-form-modal").shouldHave(text("Registration Form"));
        $("#userForm").$("#firstName").setValue(firstName);
        $("#userForm").$("#lastName").setValue(lastName);
        $("#userForm").$("#userEmail").setValue(userEmail);
        $("#userForm").$("#age").setValue(age);
        $("#userForm").$("#salary").setValue(salary);
        $("#userForm").$("#department").setValue(departament);
        $("#userForm").$("#submit").click();
        //$$(".rt-tr-group").filter(visible).shouldHave(texts(firstName, lastName, userEmail, age, salary, departament));

      }
}
