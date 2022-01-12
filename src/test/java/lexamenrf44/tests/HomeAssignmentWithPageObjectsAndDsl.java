package lexamenrf44.tests;

import com.github.javafaker.Faker;
import lexamenrf44.pages.RegistrationForm;
import org.junit.jupiter.api.Test;

import static lexamenrf44.constants.ConstantsForRegForm.*;

public class HomeAssignmentWithPageObjectsAndDsl {

    Faker faker = new Faker();
    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String email = faker.internet().emailAddress();
    String address = faker.address().fullAddress();
    String phone = faker.number().digits(10);

    RegistrationForm registrationForm = new RegistrationForm();

    @Test
    void studentRegistrationPracticeFormWithPageObjectsTest() {

        registrationForm.openUrl()
                        .enterFirstName(firstName)
                        .enterLastName(lastName)
                        .enterUserEmail(email)
                        .selectUserGender(Gender.MALE)
                        .enterUserPhone(phone)
                        .selectDateOfBirth( "26", "November", "1992")
                        .enterUserSubjects(Subjects.MATH)
                        .enterUserSubjects(Subjects.ENGLISH)
                        .selectUserHobbies(Hobbies.SPORTS)
                        .selectUserHobbies(Hobbies.READING)
                        .uploadUserPictureFile("img/image.png")
                        .enterUserCurrentAddress(address)
                        .enterUserState(States.NCR)
                        .enterUserCity(Cities.DELHI)
                        .submitUserRegistrationForm();


        registrationForm.checkSubmittedFormTable("Student Name", " " + firstName + " " + lastName)
                        .checkSubmittedFormTable("Student Email", " " + email)
                        .checkSubmittedFormTable("Mobile", " " + phone)
                        .checkSubmittedFormTable("Date of Birth", "26 November,1992");

    }
}