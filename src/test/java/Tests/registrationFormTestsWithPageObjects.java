package Tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selenide.*;

public class registrationFormTestsWithPageObjects extends TestBase {

    RegistrationPages registrationPages = new RegistrationPages();
    String firstName = "Testing First Name";
    String lastName = "Testing Last Name";
    String userEmail = "Testmail@test.com";
    String Gender = "Male";
    String phoneNumber = "1234567888";
    String day = "5";
    String dayCheck = "05";
    String month = "March";
    String year = "1994";
    String subjects = "Commerce";
    String hobby = "Music";
    String picture = "1.png";
    String address = "Testograd";
    String state = "NCR";
    String city = "Delhi";
    String button = "Submit";
    String checkTitle = "Thanks for submitting the form";
    @Test
    void successFillTest() {
        registrationPages.openPage()
                .setFirstNameInput(firstName)
                .setLastNameInput(lastName)
                .userEmailInput(userEmail)
                .genterWrapperButton(Gender)
                .phoneNumberInput(phoneNumber)
                .setBirthDate(day, month, year)
                .setSubjectsInput(subjects)
                .setHobbyInput(hobby)
                .uploadPicture(picture)
                .setCurrentAddress(address)
                .chooseStateInput(state)
                .chooseCityInput(city)
                .submitButton(button)
                .checkRegistrationForm(checkTitle);
        registrationPages
                .checkForm("Student Name", firstName +" "+lastName)
                .checkForm("Student Email", userEmail)
                .checkForm("Gender", Gender)
                .checkForm("Mobile", phoneNumber)
                .checkForm("Date of Birth", dayCheck + " " + month + "," + year)
                .checkForm("Subjects", subjects)
                .checkForm("Hobbies", hobby)
                .checkForm("Picture", picture)
                .checkForm("Address", address)
                .checkForm("State and City", state + " " + city);

    }
}