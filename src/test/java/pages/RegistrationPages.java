package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPages {
        //components
    private CalendarComponent calendarComponent = new CalendarComponent()
        //locators
    private SelenideElement
                headerTitle = $(".practice-form-wrapper"),
                firstNameInput = $("#firstName"),
                lastNameInput = $("#lastName"),
                userEmailInput = $("#userEmail"),
                genterWrapperButton = $("#genterWrapper"),
                phoneNumberInput = $("#userNumber"),
                subjectsInput = $("#subjectsInput"),


                resultsTable = $(".table-responsive");






        //actions
    public RegistrationPages openPage(){
        open("/automation-practice-form");
        headerTitle.shouldHave(text("Student Registration Form"));

        return this;
    }
    public RegistrationPages setFirstNameInput(String firstName){
        firstNameInput.setValue(firstName);

        return this;
    }
    public RegistrationPages setLastNameInput(String lastName){
        lastNameInput.setValue(lastName);

        return this;
    }
    public RegistrationPages userEmailInput(String userEmail){
        userEmailInput.setValue(userEmail);

        return this;
    }
    public RegistrationPages genterWrapperButton (String chooseGender){
        genterWrapperButton.$(byText(chooseGender)).click();

        return this;
    }
    public RegistrationPages phoneNumberInput (String phoneNumber){
        phoneNumberInput.setValue(phoneNumber);

        return this;
    }
    public void setBirthDate (String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendarComponent.setDate(day, month, year);
    }

    public RegistrationPages checkForm (String fieldName, String value) {
        resultsTable.$(byText(fieldName))
                .parent().shouldHave(text(value));

        return this;
    }
}




