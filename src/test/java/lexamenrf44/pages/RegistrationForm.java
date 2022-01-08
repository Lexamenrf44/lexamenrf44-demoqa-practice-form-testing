package lexamenrf44.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationForm {

    SelenideElement firstNameInput = $("#firstName"),
                    lastNameInput = $("#lastName");

    public RegistrationForm openUrl() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));

        return this;
    }

    public RegistrationForm typeFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationForm typeLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

}
