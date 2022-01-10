package lexamenrf44.components;

import static com.codeborne.selenide.Selenide.$;
import static java.lang.String.format;

public class Calendar {

    public void setDate(String month, String year, String day) {

        $("[id='dateOfBirthInput']").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        String dayLocator = format("[aria-label$=%s %sth, %s]", month, year, day);
        $(dayLocator).click();

}

}
