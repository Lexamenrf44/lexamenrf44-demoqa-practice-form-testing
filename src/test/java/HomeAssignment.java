import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Browsers.CHROME;
import static com.codeborne.selenide.Browsers.OPERA;
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
        $("#currentAddress").setValue("Address");
        $("[id='react-select-3-input']").setValue("Rajasthan").pressEnter();
        $("[id='react-select-4-input']").setValue("Jaiselmer").pressEnter();
        $("[id='submit']").click();

        selenideStudentRegistrationPracticeFormTestCheck();
    }

    void selenideStudentRegistrationPracticeFormTestCheck() {



    }

    @AfterEach
    void after(){
        closeWebDriver();
    }

}