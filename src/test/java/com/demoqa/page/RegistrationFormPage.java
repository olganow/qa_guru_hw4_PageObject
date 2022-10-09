package com.demoqa.page;

import com.codeborne.selenide.SelenideElement;
import com.demoqa.page.components.CalendarComponent;
import com.demoqa.page.components.ResultsTableComponent;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormPage {
    private CalendarComponent calendarComponent = new CalendarComponent();
    private ResultsTableComponent resultsTableComponent = new ResultsTableComponent();
    private File file = new File("src/test/resources/testcat.png");
    private final static String TITLE_TEXT = "Thanks for submitting the form";
    private String
            yearOfBirth = "1998",
            monthOfbirth = "May",
            dayOfbirth = "16";

    // Element
    private SelenideElement
            firstNameInput = $("#firstName"),
            secondNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genderInput = $("#genterWrapper"),
            phoneInput = $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            monthOfBirthInput = $(".react-datepicker__month-select"),
            yearOfBirthInput = $(".react-datepicker__year-select"),
            dayOfBirthInput = $(".react-datepicker__day--0" + dayOfbirth),
            subjectInput = $("#subjectsInput"),
            hobbyInput = $("#hobbiesWrapper"),
            pictureUpload = $x("//input[@id='uploadPicture']"),
            addressInput = $("#currentAddress"),
            stateInput = $("#react-select-3-input"),
            cityInput = $("#react-select-4-input"),
            submitButton = $("#submit");


    //Actions
    public RegistrationFormPage OpenPage() {
        open("https://demoqa.com/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixeban').remove()");
        return this;
    }

//    public void setFirstName(String value) {
//        firstNameInput.setValue(value);
//    }

    public RegistrationFormPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationFormPage clearFirstName(String value) {
        firstNameInput.clear();
        return this;
    }

    public RegistrationFormPage setLastName(String value) {
        secondNameInput.setValue(value);
        return this;
    }

    public RegistrationFormPage setEmail(String value) {
        emailInput.setValue(value);
        return this;
    }

    public RegistrationFormPage setGender(String value) {
        genderInput.$(byText(value)).click();
        return this;
    }

    public RegistrationFormPage setPhone(String value) {
        phoneInput.setValue(value);

        return this;
    }

    public RegistrationFormPage setDateOfBirth(String day, String month, String year) {
        dateOfBirthInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationFormPage setSubject() {
        subjectInput.setValue("Economics").pressEnter();
        subjectInput.setValue("Biology").scrollTo().pressEnter();

        return this;
    }

    public RegistrationFormPage setHobby() {
        hobbyInput.$(byText("Sports")).click();
        hobbyInput.$(byText("Music")).click();

        return this;
    }

    public RegistrationFormPage uploadPicturest() {
        pictureUpload.uploadFile(file);

        return this;
    }

    public RegistrationFormPage setAddress(String address) {
        addressInput.scrollIntoView(true).setValue(address);

        return this;
    }

    public RegistrationFormPage setState() {
        stateInput.setValue("Uttar Pradesh").pressEnter();

        return this;
    }

    public RegistrationFormPage setCity() {
        cityInput.setValue("Lucknow").pressEnter();

        return this;
    }

    public RegistrationFormPage clickSubmit() {
        submitButton.scrollIntoView(true).click();

        return this;
    }

    public RegistrationFormPage checkResultsTableVisible() {
        resultsTableComponent.checkVisible();

        return this;
    }

    public RegistrationFormPage checkResult(String firstNameUser, String lastNameUser, String email, String gender,
                                            String phone, String dayOfbirth, String monthOfbirth, String yearOfBirth) {
        resultsTableComponent.checkResult(firstNameUser, lastNameUser, email, gender,
                phone, dayOfbirth, monthOfbirth, yearOfBirth);

        return this;
    }

}
