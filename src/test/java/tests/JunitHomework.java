package tests;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@DisplayName("Тесты с использованием Аннотаций")
public class JunitHomework {

    @Tag("GitHub")
    @ValueSource(strings = {
            "selenide", "junit5"
    })
    @ParameterizedTest(name = "Поиск в GitHub репрозиторий с названием {0}")
    void searchTest(String searchValue) {
        open("https://github.com/home");
        $(".search-input-container").click();
        $("#query-builder-query-builder-test").$("#query-builder-test").setValue(searchValue).pressEnter();
        $("[data-testid='results-list']").shouldHave(visible);
    }

    @Tag("Text Box")
    @CsvSource(value = {"Kirill Morozov , morozovk@mail.ru , Russia, Moscow , Russia, Saint-Petersburg",
                        "Mark Pushkin , pushkin@mail.ru , SPB , Kaliningrad"})
    @ParameterizedTest(name = "Тест с регистрацией, где имя пользователя {0}")
    void textBoxTest(String fullName, String email, String currentAddress, String permanentAddress
    ){
        open("https://demoqa.com/text-box");
        $("#userName").setValue(fullName);
        $("#userEmail").setValue(email);
        $("#currentAddress").setValue(currentAddress);
        $("#permanentAddress").setValue(permanentAddress);
        $("#submit").scrollTo().click();
    }

    @Disabled ("Проверка работы аннотации Disabled")
    @Test
    void gitGubSearchTest() {
        open("https://github.com/home");
        $(".HeaderMenu").$(byText("Solutions")).hover();
        $("a[href='https://github.com/enterprise']").click();
        $("#hero-section-brand-heading").shouldHave(text("The AI-powered developer platform"));
    }

    static Stream<Arguments> textGitHubTest() {
        return Stream.of(
                Arguments.of("Kir" , "Kir@mail.ru" , "Russia" , "Saint-Petersburg"),
                Arguments.of("Lina" , "Lina@mail,ru" , "Russia" , "Saint-Petersburg" ,
                        "Plans & pricing"),
                Arguments.of("Miron", "Miron@mail.ru", "UK", "London")
        );
    }
    @ParameterizedTest
    @MethodSource("textGitHubTest")
    void checkButtonGitHubTest(String fullName, String email, String currentAddress, String permanentAddress) {
        {
            open("https://demoqa.com/text-box");
            $("#userName").setValue(fullName);
            $("#userEmail").setValue(email);
            $("#currentAddress").setValue(currentAddress);
            $("#permanentAddress").setValue(permanentAddress);
            $("#submit").scrollTo().click();
        }
    }
}
