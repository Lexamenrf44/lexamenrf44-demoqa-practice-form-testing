/*

Помни!

Хороший код - это код, в котором много комментариев от автора,
написанные с целью, чтобы любой, кто открыл его, смог понять,
что в нём происходит, и что нужно делать в тот или иной момент.

*/

// Импортируемые плагины, необходимые для осуществления тех или иных операций

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

// Наименование class(-а) совпадает с наименованием файла с расширением .java

public class HomeAssignment {

    /*

    Перед каждым выполнением тестирования - будут задействованы следующие конфигурации

    */

    @BeforeEach

    // Запустить браузер со следующими параметрами

    void browserOpeningConfiguration() {

        // Запускать в браузере "opera"
        Configuration.browser = "opera";

        // Очищать браузер от 'куки'
//        clearBrowserCookies();

        // Перед выполнением - открывать заданную страницу
        open("https://demoqa.com/automation-practice-form");
    }

    @Test

    /*

    Во время выполнения тестирования полей - будут задействованы таймауты (в миллисекундах),
    с целью убедиться, что каждое вызванное поле было заполнено без проишествий

    */

    // Вызывается метод, цель которого заполнять искомые поля, названный как 'selenideStudentRegistrationPracticeFormTest'
    // Наименование метода задано в произвольном порядке
    // Можно придумать своё название

    void selenideStudentRegistrationPracticeFormTest() {

        /* В появившейся форме заполняем поля */

        // Name

        // FirstName
        $("#firstName").setValue("Alexander"); // знак '#' используется с целью сокращения

        sleep(3000); // Ожидание 3000 миллисекунд

        // LastName
        $("#lastName").setValue("Barashkov");

        sleep(3000);

        // Email
        $("#userEmail").setValue("abarashkov@email.ru");

        sleep(3000);

        // Gender
        $(byText("Male")).click();

        sleep(3000);

        // .pressEnter()

    }
}