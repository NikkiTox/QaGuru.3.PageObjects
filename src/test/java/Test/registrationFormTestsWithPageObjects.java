package Test;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selectors;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPages;
import pages.components.CalendarComponent;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class registrationFormTestsWithPageObjects {

    RegistrationPages registrationPages  = new RegistrationPages();
    String firstName = "Testing First Name";
    String lastName = "Testing Last Name";
    String userEmail = "Testmail@test.com";
    String Gender = "Male";
    String phoneNumber = "35554556589";

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void successFillTest() {
        registrationPages.openPage()
                .setFirstNameInput(firstName)
                .setLastNameInput(lastName)
                .userEmailInput(userEmail)
                .genterWrapperButton(Gender)
                .phoneNumberInput(phoneNumber);
        registrationPages.setBirthDate("5","March","1994");


        $("#subjectsInput").setValue("Commerce").pressEnter();
        $("#hobbiesWrapper").$(Selectors.byText("Music")).click();
        $("#uploadPicture").uploadFile (new File("src/test/resources/1.png"));
        $("#currentAddress").setValue("Testograd");
        $("#state").scrollTo().click();
        $("#stateCity-wrapper").$(Selectors.byText("Rajasthan")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(Selectors.byText("Jaipur")).click();
        $("#submit").click();
        $("#example-modal-sizes-title-lg").shouldHave
                (Condition.text("Thanks for submitting the form"));
        registrationPages
                .checkForm("Student Name", "Testing First Name Testing Last Name")
                .checkForm("Student Email", "Testmail@test.com")
                .checkForm("Gender", "Male")


    }
}