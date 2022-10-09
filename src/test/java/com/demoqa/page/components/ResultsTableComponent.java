package com.demoqa.page.components;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ResultsTableComponent {

    private final static String TITLE_TEXT = "Thanks for submitting the form";

    public ResultsTableComponent checkVisible() {
        $(".modal-dialog").should(Condition.appear);
        $("#example-modal-sizes-title-lg").shouldHave(text(TITLE_TEXT));

        return this;
    }

    public ResultsTableComponent checkResult(String firstNameUser, String lastNameUser, String email, String gender,
                                             String phone, String dayOfbirth, String monthOfbirth, String yearOfBirth) {
        $x("//td[text()='Student Name']").parent().shouldHave(text(firstNameUser + " " + lastNameUser));
        $x("//td[text()='Student Email']").parent().shouldHave(text(email));
        $x("//td[text()='Gender']").parent().shouldHave(text(gender));
        $x("//td[text()='Mobile']").parent().shouldHave(text(phone));
        $x("//td[text()='Date of Birth']").parent().shouldHave(text(dayOfbirth + " " + monthOfbirth + ","
                + yearOfBirth));
        $x("//td[text()='Subjects']").parent().shouldHave(text("Economics, Biology"));
        $x("//td[text()='Hobbies']").parent().shouldHave(text("Sports"));
        $x("//td[text()='Picture']").parent().shouldHave(text("testcat.png"));
        $x("//td[text()='Address']").parent().shouldHave(text("Russia, Spb, 21"));
        $x("//td[text()='State and City']").parent().shouldHave(text("Uttar Pradesh Lucknow"));

        return this;
    }
}
