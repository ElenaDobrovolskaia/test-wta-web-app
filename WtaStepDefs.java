package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.*;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.*;


public class WtaStepDefs {

    Map<String,String>user=getData("user");

    @Given("I open {string} page")
    public void iOpenPage(String page) {
        switch (page) {
            case "WTA":
                new WTALanding().open();
                break;
            default:
                throw new RuntimeException("Page not supported");
        }
    }

    @Then("I navigate to {string} menu")
    public void iNavigateToMenu(String menuName) {
        switch (menuName) {
            case "My Backpack":
                new WTALanding()
                        .goToMyBackpack();
                break;
            default:
                throw new RuntimeException("Menu not supported");

        }
    }

    @Then("I choose a {string} element in menu")
    public void iChooseAElementInMenu(String menuItem) {
        switch (menuItem) {
            case "Dashboard":
                new WTAHeader()
                        .goToDashboard();
                break;
            case "Write a Trip Report":
                new WTAHeader()
                        .goToTripReport();
                break;
            case "Log In":
                new WTAHeader()
                        .goToLogIn();
                break;
            case "Sign Up":
                new WTAHeader()
                        .goSignUp();
                break;
            default:
                throw new RuntimeException("Menu item not supported");
        }
    }

    @Then("fill out required fields except for Captcha")
    public void fillOutRequiredFieldsExceptForCaptcha() {
        Map<String, String> newAccount = getData("user");
        new WTARegister().createAccount(newAccount);
    }
    @Then("I fill out all fields except for {string}")
    public void iFillOutAllFieldsExceptFor(String field) {
        Map<String,String> userData=getData("user");
        new WTARegister().fillAllFieldsExceptForOne(userData,field);


    }

    @Then("I verify error message appears")
    public void iVerifyErrorMessageAppears() {
        Map<String, String> err = getData("errors");
        assertThat(new WTARegister().isPortalErrorMessageVisible()).isTrue();
        assertThat(new WTARegister().isErrorMessageVisible("captcha"));
    }

    @Then("I verify that appeared error message next to {string} field is equal to {string}")
    public void iVerifyThatAppearedErrorMessageNextToFieldIsEqualTo(String field, String errMessage) {
        String actualErrMessage=new WTARegister().getErrorText(field);
        assertThat(actualErrMessage).isEqualTo(errMessage);
    }


    @And("I submit the form")
    public void iSubmitTheForm() {
        new WTARegister().submit();
    }


    @Then("I uncheck {string} checkbox")
    public void iUncheckCheckbox(String checkBox) {
        if (!new WTARegister().getCheckBoxStatus(checkBox).equals(null)){
            new WTARegister().clickUnsubscribe(checkBox);
        }
    }

    @Then("I verify that error message next to {string} is not present")
    public void iVerifyThatErrorMessageNextToIsNotPresent(String checkbox) {
        assertThat(new WTARegister().isErrorMessageVisible(checkbox)).isFalse();
    }
}
