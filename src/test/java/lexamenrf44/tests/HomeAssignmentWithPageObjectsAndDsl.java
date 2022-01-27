package lexamenrf44.tests;

import com.github.javafaker.Faker;
import io.qameta.allure.*;
import lexamenrf44.configuration.BrowserSetup;
import lexamenrf44.pages.RegistrationForm;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static lexamenrf44.constants.ConstantsForRegForm.*;

public class HomeAssignmentWithPageObjectsAndDsl extends BrowserSetup {

    Faker faker = new Faker();
    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String email = faker.internet().emailAddress();
    String address = faker.address().fullAddress();
    String phone = faker.number().digits(10);

    RegistrationForm registrationForm = new RegistrationForm();

    @Owner("abarashkov")
    @Feature("Registration Form")
    @Story("Форма регистрации")
    @DisplayName("Тестирование формы регистрации")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    void studentRegistrationPracticeFormWithPageObjectsTest() {

        step("Открыть форму регистрации", () -> {
            registrationForm.openUrl();
        });

        step("Заполнить поле Имя", () -> {
            registrationForm.enterFirstName(firstName);
        });

        step("Заполнить поле Фамилия", () -> {
            registrationForm.enterLastName(lastName);
        });

        step("Заполнить поле email", () -> {
            registrationForm.enterUserEmail(email);
        });

        step("Выбрать пол", () -> {
            registrationForm.selectUserGender(Gender.MALE);
        });

        step("Заполнить поле мобильный телефон", () -> {
            registrationForm.enterUserPhone(phone);
        });

        step("Заполнить поле Дата Рождения", () -> {
            registrationForm.selectDateOfBirth("26", "November", "1992");
        });

        step("Выбрать интересующие предметы", () -> {
            registrationForm.enterUserSubjects(Subjects.MATH);

            registrationForm.enterUserSubjects(Subjects.ENGLISH);
        });
        step("Выбрать хобби", () -> {
            registrationForm.selectUserHobbies(Hobbies.SPORTS);

            registrationForm.selectUserHobbies(Hobbies.READING);
        });

        step("Заполнить поле адрес проживания", () -> {
            registrationForm.enterUserCurrentAddress(address);
        });

        step("Выбрать страну и город проживания", () -> {
            registrationForm.enterUserState(States.NCR);

            registrationForm.enterUserCity(Cities.DELHI);
        });

        step("Нажать Отправить форму", () -> {
            registrationForm.submitUserRegistrationForm();
        });

        step("Проверка заполненной формы", () -> {
        registrationForm.checkSubmittedFormTable("Student Name", " " + firstName + " " + lastName)
                .checkSubmittedFormTable("Student Email", " " + email)
                .checkSubmittedFormTable("Mobile", " " + phone)
                .checkSubmittedFormTable("Date of Birth", "26 November,1992")
                .checkSubmittedFormTable("Subjects", "Maths," + " " + "English")
                .checkSubmittedFormTable("Hobbies", "Sports," + " " + "Reading")
                .checkSubmittedFormTable("Picture", "image.png")
                .checkSubmittedFormTable("Address", " " + address)
                .checkSubmittedFormTable("State and City", "NCR" + " " + "DELHI");
        });
    }

}