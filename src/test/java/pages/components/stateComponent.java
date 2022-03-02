package pages.components;

import com.codeborne.selenide.Selectors;

import static com.codeborne.selenide.Selenide.$;

public class stateComponent {
    public static void setState(String state) {
        $("#state").click();
        $("#stateCity-wrapper").$(Selectors.byText(state)).click();
    }
}


