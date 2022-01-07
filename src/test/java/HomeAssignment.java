import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Browsers.CHROME;
import static com.codeborne.selenide.Browsers.OPERA;
import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class HomeAssignment {

    @BeforeEach
    void browserOpeningConfiguration() {

        Configuration.browser = OPERA;
        Configuration.fastSetValue = false;
        Configuration.browserSize = "1920x1080";

        clearBrowserCookies();

        open("https://demoqa.com/automation-practice-form");
    }

    @Test
    void selenideStudentRegistrationPracticeFormTest() {

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

        $(byText("Thanks for submitting the form")).should(appear);
        $(byText("Thanks for submitting the form")).shouldBe(visible);
        $(byText("abarashkov@email.ru")).shouldBe(visible);
        $(byText("Male")).shouldBe(visible);
        $(byText("8999888447")).shouldBe(visible);
        $(byText("26 November,1992")).shouldBe(visible);
        $(byText("Computer Science, English")).shouldBe(visible);
        $(byText("Sports")).shouldBe(visible);
        $(byText("readme.txt")).shouldBe(visible);
        $(byText("My Address")).shouldBe(visible);
        $(byText("Rajasthan Jaiselmer")).shouldBe(visible);

    }
}