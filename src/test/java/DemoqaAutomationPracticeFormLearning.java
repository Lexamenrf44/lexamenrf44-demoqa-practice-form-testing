import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;

import java.io.File;

import static com.codeborne.selenide.Browsers.CHROME;
import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class DemoqaAutomationPracticeFormLearning {

    @BeforeAll
    static void browserOpeningConfiguration() {

        Configuration.browser = CHROME;
        Configuration.fastSetValue = false;
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";

        clearBrowserCookies();

    }

    @Test
    @Order(1)
    void selenideStudentRegistrationPracticeFormFilling() {

        open("/automation-practice-form");

        $("#firstName").setValue("Alexander");
        $("[id=\"lastName\"]").setValue("Barashkov");
        $("[id='userEmail']").setValue("abarashkov@email.ru");
        $("[for='gender-radio-1']").click();
        $("[placeholder='Mobile Number']").setValue("8999888447");
        $("[id='dateOfBirthInput']").click();
        $(byText("November")).click();
        $(byText("1992")).click();
        $("[class*='026']").click();
        $("#subjectsInput").setValue("Computer Science").pressEnter();
        $("#subjectsInput").setValue("English").pressEnter();
        $(byText("Sports")).click();
        File file = new File("src/test/resources/readme.txt");
        $("input[id='uploadPicture']").uploadFile(file);
        $("#currentAddress").setValue("My Address");
        $("[id='react-select-3-input']").setValue("Rajasthan").pressEnter();
        $("[id='react-select-4-input']").setValue("Jaiselmer").pressEnter();
        $("[id='submit']").click();

    }

    @Test
    @Order(2)
    void selenideStudentFilledFormAppearanceChecking() {

        $(byText("Thanks for submitting the form")).should(appear);

    }

    @Test
    @Order(3)
    void selenideStudentFilledFormVisibilityChecking() {

        $(byText("Thanks for submitting the form")).shouldBe(visible);

    }

    @Test
    @Order(4)
    void selenideStudentFilledFormEmailLineVisibilityChecking() {

        $(byText("abarashkov@email.ru")).shouldBe(visible);

    }

    @Test
    @Order(5)
    void selenideStudentFilledFormGenderLineVisibilityChecking() {

        $(byText("Male")).shouldBe(visible);

        }

    @Test
    @Order(6)
    void selenideStudentFilledFormMobilePhoneLineVisibilityChecking() {

        $(byText("8999888447")).shouldBe(visible);

    }

    @Test
    @Order(7)
    void selenideStudentFilledFormDateOfBirthLineVisibilityChecking() {

        $(byText("26 November,1992")).shouldBe(visible);

    }

    @Test
    @Order(8)
    void selenideStudentFilledFormSubjectsLineVisibilityChecking() {

        $(byText("Computer Science, English")).shouldBe(visible);

    }

    @Test
    @Order(9)
    void selenideStudentFilledFormHobbiesLineVisibilityChecking() {

        $(byText("Sports")).shouldBe(visible);

    }

    @Test
    @Order(10)
    void selenideStudentFilledFormUploadedFileLineVisibilityChecking() {

        $(byText("readme.txt")).shouldBe(visible);

    }

    @Test
    @Order(11)
    void selenideStudentFilledFormAddressLineVisibilityChecking() {

        $(byText("My Address")).shouldBe(visible);

    }

    @Test
    @Order(12)
    void selenideStudentFilledFormStateAndCityLineVisibilityChecking() {

        $(byText("Rajasthan Jaiselmer")).shouldBe(visible);

    }

}