package pages.components;

import com.codeborne.selenide.Selectors;

import static com.codeborne.selenide.Selenide.$;

public class cityComponent {
    public static void setCity (String city){
        $("#city").click();
        $("#stateCity-wrapper").$(Selectors.byText(city)).click();
    }
}
