package com.demoqa.test;

import com.codeborne.selenide.Configuration;
import com.demoqa.page.RegistrationFormPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;


public class RegistretionFormTests {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    String firstNameUser = "Firstname",
            lastNameUser = "Secondname",
            email = "useremail@mail.ma",
            gender = "Female",
            phone = "1234567890",
            yearOfBirth = "1998",
            monthOfbirth = "May",
            dayOfbirth = "16",
            address = "Russia, Spb, 21";
    File file = new File("src/test/resources/testcat.png");


    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";

    }

    @Test
    void successfulSubmitFormTest() {
        registrationFormPage
                .OpenPage()
                .setFirstName(firstNameUser)
                .setLastName(lastNameUser)
                .setEmail(email)
                .setGender(gender)
                .setPhone(phone)
                .setDateOfBirth(dayOfbirth, monthOfbirth, yearOfBirth)
                .setSubject()
                .setHobby()
                .uploadPicturest()
                .setAddress(address)
                .setState()
                .setCity()
                .clickSubmit();


        registrationFormPage
                .checkResultsTableVisible();
        registrationFormPage.checkResult(firstNameUser, lastNameUser, email, gender,
                phone, dayOfbirth, monthOfbirth, yearOfBirth);

    }

}