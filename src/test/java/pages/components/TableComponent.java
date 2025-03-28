package pages.components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class TableComponent {

    public TableComponent checkValue(String key, String value) {
        $(".modal-content").$(byText(key)).parent().shouldHave(text(value));
        return this;
    }
}
