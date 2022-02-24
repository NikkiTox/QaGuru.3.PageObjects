package pages;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.CityComponent;
import pages.components.StateComponent;


import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPages {
    //components
    private CalendarComponent calendarComponent = new CalendarComponent();
    private StateComponent StateComponent = new StateComponent();
    private CityComponent CityComponent = new CityComponent();
    //locators
    private SelenideElement
            headerTitle = $(".practice-form-wrapper"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genterWrapperButton = $("#genterWrapper"),
            phoneNumberInput = $("#userNumber"),
            setSubjectsInput = $("#subjectsInput"),
            setHobbyInput = $("#hobbiesWrapper"),
            uploadPicture = $("#uploadPicture"),
            setCurrentAdress = $("#currentAddress"),
            chooseStateInput = $("#stateCity-wrapper"),
            chooseCityInput = $("#stateCity-wrapper"),
            submitButton = $("#submit"),

            resultsTable = $(".table-responsive");



    //actions
    public RegistrationPages openPage() {
        open("/automation-practice-form");
        headerTitle.shouldHave(text("Student Registration Form"));

        return this;
    }

    public RegistrationPages setFirstNameInput(String firstName) {
        firstNameInput.setValue(firstName);

        return this;
    }

    public RegistrationPages setLastNameInput(String lastName) {
        lastNameInput.setValue(lastName);

        return this;
    }

    public RegistrationPages userEmailInput(String userEmail) {
        userEmailInput.setValue(userEmail);

        return this;
    }

    public RegistrationPages genterWrapperButton(String chooseGender) {
        genterWrapperButton.$(byText(chooseGender)).click();

        return this;
    }

    public RegistrationPages phoneNumberInput(String phoneNumber) {
        phoneNumberInput.setValue(phoneNumber);

        return this;
    }

    public RegistrationPages setBirthDate(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationPages setSubjectsInput(String subjects) {
        setSubjectsInput.setValue(subjects).pressEnter();

        return this;
    }

    public RegistrationPages setHobbyInput(String hobbyInput) {
        setHobbyInput.$(Selectors.byText("Music")).click();

        return this;
    }

    public RegistrationPages uploadPicture(String upload) {
        uploadPicture.uploadFile(new File("src/test/resources/1.png"));

        return this;
    }

    public RegistrationPages setCurrentAddress(String currentAddress){
        setCurrentAdress.setValue(currentAddress);

        return this;
    }
    public RegistrationPages chooseStateInput (String chooseState){
        StateComponent.setState(chooseState);
        return this;
    }
    public RegistrationPages chooseCityInput (String chooseCity){
        CityComponent.setCity(chooseCity);
        return this;
    }
    public RegistrationPages submitButton (String submit){
        submitButton.click();
        return this;
    }

    //public void setFirstNameInput(SelenideElement firstNameInput) {
    //    this.firstNameInput = firstNameInput;
   // }

    public RegistrationPages checkForm (String fieldName, String value) {
        resultsTable.$(byText(fieldName))
                .parent().shouldHave(text(value));

        return this;
    }
}














