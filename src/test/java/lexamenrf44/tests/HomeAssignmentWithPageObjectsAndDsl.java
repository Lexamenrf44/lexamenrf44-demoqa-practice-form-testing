package lexamenrf44.tests;

import com.codeborne.selenide.Configuration;
import lexamenrf44.constants.ConstantsForRegForm;
import lexamenrf44.pages.RegistrationForm;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Browsers.OPERA;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.clearBrowserCookies;
import static lexamenrf44.constants.ConstantsForRegForm.*;

public class HomeAssignmentWithPageObjectsAndDsl {

    RegistrationForm registrationForm = new RegistrationForm();

    @BeforeEach
    void browserOpeningConfiguration() {

        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browser = OPERA;
        Configuration.fastSetValue = false;
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;

        clearBrowserCookies();
    }

    @Test
    void studentRegistrationPracticeFormWithPageObjectsTest() {

        registrationForm.openUrl()
                        .enterFirstName("Alexander")
                        .enterLastName("Barashkov")
                        .enterUserEmail("abarashkov@email.ru")
                        .selectUserGender(Gender.MALE)
                        .enterUserPhone("8889997711")
                        .enterUserSubjects(Subjects.MATH)
                        .enterUserSubjects(Subjects.ENGLISH)
                        .selectUserHobbies(Hobbies.SPORTS)
                        .selectUserHobbies(Hobbies.READING)
                        .uploadUserPictureFile("img/image.png")
                        .enterUserCurrentAddress("My current address")
                        .enterUserState(States.NCR)
                        .enterUserCity(Cities.DELHI);

        /*

        $("[id='dateOfBirthInput']").click();
        $(byText("November")).click();
        $(byText("1992")).click();
        $("[class*='026']").click();
        $("[id='react-select-3-input']").setValue("Rajasthan").pressEnter();
        $("[id='react-select-4-input']").setValue("Jaiselmer").pressEnter();
        //$("[id='submit']").click();

         */

        registrationForm.checkSubmittedFormTable("Student Name", "Alexander Barashkov")
                        .checkSubmittedFormTable("Student Email", "a@a.com")
                        .checkSubmittedFormTable("Gender", "MALE")
                        .checkSubmittedFormTable("Mobile", "")
                        .checkSubmittedFormTable("Date of Birth", "")
                        .checkSubmittedFormTable("Subjects", "")
                        .checkSubmittedFormTable("Hobbies", "")
                        .checkSubmittedFormTable("Picture", "")
                        .checkSubmittedFormTable("Address", "")
                        .checkSubmittedFormTable("State and City", "");

        $(byText("Thanks for submitting the form")).should(appear);
        $(byText("Thanks for submitting the form")).shouldBe(visible);
        $(byText("abarashkov@email.ru")).shouldBe(visible);
        $(byText("Male")).shouldBe(visible);
        $(byText("8999888447")).shouldBe(visible);
        $(byText("26 November,1992")).shouldBe(visible);
        $(byText("Computer Science, English")).shouldBe(visible);
        $(byText("Sports")).shouldBe(visible);
        $(byText("txt/readme.txt")).shouldBe(visible);
        $(byText("My Address")).shouldBe(visible);
        $(byText("Rajasthan Jaiselmer")).shouldBe(visible);

    }
}