package lexamenrf44.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationForm {

    SelenideElement firstNameInput = $("#firstName"),
                    lastNameInput = $("#lastName");

    public void openUrl() {
        open("/automation-practice-form");
    }

    public void typeFirstName(String value) {
        firstNameInput.setValue(value);
    }

    public void typeLastName(String value) {
        lastNameInput.setValue(value);
    }

}