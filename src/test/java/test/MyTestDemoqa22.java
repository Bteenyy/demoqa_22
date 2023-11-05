package test;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import utils.EnteredDataRegComponent;

import static io.qameta.allure.Allure.step;

public class MyTestDemoqa22 extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    EnteredDataRegComponent dataReg = new EnteredDataRegComponent();

    @Tag("simple")
    @Test
    void demoqaTest() {
        step("Open form", () -> {
            registrationPage.openPage()
                    .fixBanReg();
        });
        step("Fill form", () -> {
            registrationPage.openPage()
                    .fixBanReg()
                    .setFirstName(dataReg.firstName)
                    .setLastName(dataReg.lastName)
                    .setUserEmail(dataReg.userEmail)
                    .setGender(dataReg.gender)
                    .setUserNumber(dataReg.userNumber)
                    .setDateOfB(dataReg.dayOfB, dataReg.monthCalendar, dataReg.yearCalendar)
                    .setSubjectsInput(dataReg.subjectsInput)
                    .setHobbiesInput(dataReg.hobbiesInput)
                    .setPicturesInput(dataReg.picturesInput)
                    .setAddressInput(dataReg.addressInput)
                    .setStateInput(dataReg.stateInput)
                    .setCityInput(dataReg.cityInput)
                    .finishTest();
        });
        step("Verify results", () -> {
            registrationPage.checkResult("Student Name", dataReg.firstName + " " + dataReg.lastName)
                    .checkResult("Student Email", dataReg.userEmail)
                    .checkResult("Gender", dataReg.gender)
                    .checkResult("Mobile", dataReg.userNumber)
                    .checkResult("Date of Birth", dataReg.dayOfB + " " + dataReg.monthCalendar + "," + dataReg.yearCalendar)
                    .checkResult("Subjects", dataReg.subjectsInput)
                    .checkResult("Hobbies", dataReg.hobbiesInput)
                    .checkResult("Picture", dataReg.picturesInput)
                    .checkResult("Address", dataReg.addressInput)
                    .checkResult("State and City", dataReg.stateInput + " " + dataReg.cityInput);
        });
    }
}
