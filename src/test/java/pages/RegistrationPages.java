package pages;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.CityComponent;
import pages.components.StateComponent;





import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPages {
    //components
    private final CalendarComponent CalendarComponent = new CalendarComponent();
    private final StateComponent StateComponent = new StateComponent();
    private final CityComponent CityComponent = new CityComponent();
    //locators
    private final SelenideElement
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
            resultsTable = $(".table-responsive"),
            submitButton = $("#submit");

    private String upload = "1.png";


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

    public RegistrationPages setPhoneNumber(String phoneNumber) {
        setPhoneNumber.setValue(phoneNumber);

        return this;
    }

    public RegistrationPages setBirthDate(String day, String month, String year) {
        CalendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationPages setSubjectsInput(String subjects) {
        setSubjectsInput.setValue(subjects).pressEnter();

        return this;
    }

    public RegistrationPages setHobbyInput(String hobbyInput) {
        setHobbyInput.$(Selectors.byText(hobbyInput)).click();

        return this;
    }

    public RegistrationPages uploadPicture() {
        uploadPicture.uploadFromClasspath(upload);

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
    public RegistrationPages clickSubmit (){
     $(submitButton).click();
       return this;
     }

    public RegistrationPages checkRegistrationForm (String confirmTitle){
        checkRegistrationForm.shouldHave(text(confirmTitle));
        return this;
    }

    public RegistrationPages checkForm (String fieldName, String value) {
        resultsTable.$(byText(fieldName))
                .parent().shouldHave(text(value));

        return this;
    }
}














