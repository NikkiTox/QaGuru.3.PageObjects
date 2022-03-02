package pages;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import pages.components.calendarComponent;
import pages.components.cityComponent;
import pages.components.stateComponent;



import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class registrationPages {
    //components
    private pages.components.calendarComponent calendarComponent = new calendarComponent();
    private stateComponent StateComponent = new stateComponent();
    private cityComponent CityComponent = new cityComponent();
    //locators
    private SelenideElement
            headerTitle = $(".practice-form-wrapper"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genterWrapperButton = $("#genterWrapper"),
            setPhoneNumber = $("#userNumber"),
            setSubjectsInput = $("#subjectsInput"),
            setHobbyInput = $("#hobbiesWrapper"),
            uploadPicture = $("#uploadPicture"),
            setCurrentAdress = $("#currentAddress"),
            checkRegistrationForm = $("#example-modal-sizes-title-lg"),
            resultsTable = $(".table-responsive");



    //actions
    public registrationPages openPage() {
        open("/automation-practice-form");
        headerTitle.shouldHave(text("Student Registration Form"));

        return this;
    }

    public registrationPages setFirstNameInput(String firstName) {
        firstNameInput.setValue(firstName);

        return this;
    }

    public registrationPages setLastNameInput(String lastName) {
        lastNameInput.setValue(lastName);

        return this;
    }

    public registrationPages userEmailInput(String userEmail) {
        userEmailInput.setValue(userEmail);

        return this;
    }

    public registrationPages genterWrapperButton(String chooseGender) {
        genterWrapperButton.$(byText(chooseGender)).click();

        return this;
    }

    public registrationPages setPhoneNumber(String phoneNumber) {
        setPhoneNumber.setValue(phoneNumber);

        return this;
    }

    public registrationPages setBirthDate(String day, String month, String year) {
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public registrationPages setSubjectsInput(String subjects) {
        setSubjectsInput.setValue(subjects).pressEnter();

        return this;
    }

    public registrationPages setHobbyInput(String hobbyInput) {
        setHobbyInput.$(Selectors.byText(hobbyInput)).click();

        return this;
    }

    public registrationPages uploadPicture(String upload) {
        uploadPicture.uploadFromClasspath("1.png");

        return this;
    }

    public registrationPages setCurrentAddress(String currentAddress){
        setCurrentAdress.setValue(currentAddress);

        return this;
    }
    public registrationPages chooseStateInput (String chooseState){
        StateComponent.setState(chooseState);
        return this;
    }
    public registrationPages chooseCityInput (String chooseCity){
        CityComponent.setCity(chooseCity);
        return this;
    }

    public registrationPages checkRegistrationForm (String confirmTitle){
        checkRegistrationForm.shouldHave(text(confirmTitle));
        return this;
    }

    public registrationPages checkForm (String fieldName, String value) {
        resultsTable.$(byText(fieldName))
                .parent().shouldHave(text(value));

        return this;
    }
}














