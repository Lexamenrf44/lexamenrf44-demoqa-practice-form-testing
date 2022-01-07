import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class HomeAssignment {
    @Test
    void selenideSearchTest() {
        open("https://demoqa.com/automation-practice-form");
        $("[name=q]").setValue("selenide").pressEnter();
        $("[id=search]").shouldHave(text("selenide.org"));
    }
}