package lexamenrf44.pages;

import com.codeborne.selenide.SelenideElement;
import lexamenrf44.components.Calendar;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationForm {

    SelenideElement firstNameInput = $("#firstName"),
                    lastNameInput = $("#lastName"),
                    emailInput = $("#userEmail"),
                    genderRadio = $("#genterWrapper"),
                    phoneInput = $("#userNumber"),
                    subjectsInput = $("#subjectsInput"),
                    hobbiesInput = $("#hobbiesWrapper"),
                    pictureInput = $("#uploadPicture"),
                    currentAddressInput = $("#currentAddress"),
                    stateInput = $("#react-select-3-input"),
                    cityInput = $("#react-select-4-input"),
                    submitButton = $("#submit"),

                    submittedFormTable = $(".table-responsive");



    public RegistrationForm openUrl() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));

        return this;
    }

    public RegistrationForm enterFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationForm enterLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationForm enterUserEmail(String email) {
        emailInput.setValue(email);

        return this;
    }

    public RegistrationForm selectUserGender (String gender) {
        genderRadio.find(byText(gender)).click();

        return this;
    }

    public RegistrationForm enterUserPhone(String phone) {
        phoneInput.setValue(phone);

        return this;
    }

    public RegistrationForm selectDateOfBirth(String month, String year, String day) {
        new Calendar().setDate(month, year, day);

        return this;
    }

    public RegistrationForm enterUserSubjects (String subject) {
        subjectsInput.setValue(subject).pressEnter();

        return this;
    }

    public RegistrationForm selectUserHobbies (String hobby) {
        hobbiesInput.find(byText(hobby)).click();

        return this;
    }

    public RegistrationForm uploadUserPictureFile (String fileName) {
        pictureInput.uploadFromClasspath(fileName);

        return this;
    }

    public RegistrationForm enterUserCurrentAddress (String address) {
        currentAddressInput.setValue(address);

        return this;
    }

    public RegistrationForm enterUserState (String state) {
        stateInput.setValue(state).pressEnter();

        return this;
    }

    public RegistrationForm enterUserCity (String city) {
        cityInput.setValue(city).pressEnter();

        return this;
    }

    public RegistrationForm submitUserRegistrationForm () {
        submitButton.click();

        return this;
    }

    public RegistrationForm checkSubmittedFormTable (String key, String value) {
        submittedFormTable.$(byText(key))
                .parent().shouldHave(text(value));

        return this;
    }

}
