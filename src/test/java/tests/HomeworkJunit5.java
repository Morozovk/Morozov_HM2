package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


//public class HomeworkJunit5 {
//    @CsvSource(value = {
//            "Selenide, selenide",
//            "morozov_hm2, Morozov_HM2",
//            "junit, junit5"
//    })
//    @ParameterizedTest(name = "Проверка поиска в GitHub {0} и с результатом {1}")
//    void checkGitHubSearchTest(String inputText, String checkText) {
//        open("https://github.com/home");
//        $(".header-search-button").click();
//        $("#query-builder-test").setValue(inputText).pressEnter();
//        $(".search-match").shouldHave(text("selenide/selenide == $0-appium"));
//    }
//}
