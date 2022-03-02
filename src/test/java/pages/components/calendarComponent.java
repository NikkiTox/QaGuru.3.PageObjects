package pages.components;

import static com.codeborne.selenide.Selenide.$;

public class calendarComponent {
    public void setDate (String day, String month, String year) {
        $(".react-datepicker__month-select").selectOption("March");
        $(".react-datepicker__year-select").selectOption("1994");
        $("[aria-label$='" + month + " "+ day + "th, " + year + "']").click();

    }
    }