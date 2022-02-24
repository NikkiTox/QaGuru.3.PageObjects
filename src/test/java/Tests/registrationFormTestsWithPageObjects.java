package Tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class registrationFormTestsWithPageObjects extends TestBase {

    RegistrationPages registrationPages = new RegistrationPages();
    String firstName = "Testing First Name";
    String lastName = "Testing Last Name";
    String userEmail = "Testmail@test.com";
    String Gender = "Male";
    String phoneNumber = "1234567888";
    String subjects = "Commerce";
    String hobby = "Music";
    String picture = "1.png";
    String address = "Testograd";
    String state = "NCR";
    String city = "Delhi";
    String button = "Submit";

    @Test
    void successFillTest() {
        registrationPages.openPage()
                .setFirstNameInput(firstName)
                .setLastNameInput(lastName)
                .userEmailInput(userEmail)
                .genterWrapperButton(Gender)
                .phoneNumberInput(phoneNumber)
                .setBirthDate("5", "March", "1994")
                .setSubjectsInput(subjects)
                .setHobbyInput(hobby)
                .uploadPicture(picture)
                .setCurrentAddress(address)
                .chooseStateInput(state)
                .chooseCityInput(city)
                .submitButton(button);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        registrationPages
                .checkForm("Student Name", "Testing First Name Testing Last Name")
                .checkForm("Student Email", "Testmail@test.com")
                .checkForm("Gender", "Male")
                .checkForm("Mobile", "1234567888")
                .checkForm("Date of Birth", "Commerce")
                .checkForm("Subjects", "Music")
                .checkForm("Picture", "Picture")
                .checkForm("Address", "Testograd")
                .checkForm("State and City", "NCR" + "Delhi");

    }
}