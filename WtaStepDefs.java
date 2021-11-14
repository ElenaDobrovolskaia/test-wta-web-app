package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebElement;
import pages.*;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.*;


public class WtaStepDefs {

    Map<String, String> user = getData("user");

    @Given("I open {string} page")
    public void iOpenPage(String page) {
        switch (page) {
            case "WTA":
                new Landing().open();
                break;
            default:
                throw new RuntimeException("Page not supported");
        }
    }

    @Then("I navigate to {string} menu")
    public void iNavigateToMenu(String menuName) {
        switch (menuName) {
            case "My Backpack":
                new Header().goToMyBackpack();
                break;
            case "Our Work":
                new Header().goToOurWork();
                break;
            case "Go Outside":
                new Header().goToGoOutside();
                break;
            case "Get Involved":
                new Header().goToGetInvolved();
                break;
            case "Donate":
                new Header().goToDonate();
                break;
            default:
                throw new RuntimeException("Menu not supported");

        }
    }

    @Then("I choose a {string} element in menu")
    public void iChooseAElementInMenu(String menuItem) {
        switch (menuItem) {
            case "Dashboard":
                new Header().goToDashboard();
                break;
            case "Trip Reports":
                new Header().goToTripReports();
                break;
            case "Log In":
                new Header().goToLogIn();
                break;
            case "Sign Up":
                new Header().goSignUp();
                break;
            case "Hiking Guide":
                new Header().goToHikingGuide();
                break;
            case "Write a Trip Report":
                new Header().goToWriteTripReport();
                break;
            default:
                throw new RuntimeException("Menu item not supported");
        }
    }

    @Then("fill out required fields except for Captcha")
    public void fillOutRequiredFieldsExceptForCaptcha() {
        Map<String, String> newAccount = getData("user");
        new Register().createAccount(newAccount);
    }

    @Then("I fill out all fields except for {string}")
    public void iFillOutAllFieldsExceptFor(String field) {
        Map<String, String> userData = getData("user");
        new Register().fillAllFieldsExceptForOne(userData, field);


    }

    @Then("I verify error message appears")
    public void iVerifyErrorMessageAppears() {
        Map<String, String> err = getData("errors");
        assertThat(new Register().isPortalErrorMessageVisible()).isTrue();
        assertThat(new Register().isErrorMessageVisible("captcha"));
    }

    @Then("I verify that appeared error message next to {string} field is equal to {string}")
    public void iVerifyThatAppearedErrorMessageNextToFieldIsEqualTo(String field, String errMessage) {
        String actualErrMessage = new Register().getErrorText(field);
        assertThat(actualErrMessage).isEqualTo(errMessage);
    }


    @And("I submit the form")
    public void iSubmitTheForm() {
        new Register().submit();
    }


    @Then("I uncheck {string} checkbox")
    public void iUncheckCheckbox(String checkBox) {
        if (!new Register().getCheckBoxStatus(checkBox).equals(null)) {
            new Register().clickUnsubscribe(checkBox);
        }
    }

    @Then("I verify that error message next to {string} is not present")
    public void iVerifyThatErrorMessageNextToIsNotPresent(String checkbox) {
        assertThat(new Register().isErrorMessageVisible(checkbox)).isFalse();
    }


    @Then("I should see the page {string}")
    public void iShouldSeeThePage(String page) {
        if (page.equals("Donate")) {
            assertThat(new Donate().getParagraph()).containsIgnoringCase(page);
        } else {
            assertThat(new Header().getTitle()).containsIgnoringCase(page);
        }
    }

    @When("I mouse over to {string} menu")
    public void iMouseOverToMenu(String menuName) {
        new Header().mouseOverElement(menuName);
    }

    @And("I type name of desired hike in search field")
    public void iTypeNameOfDesiredHikeInSearchField() {
        Map<String, String> hikeName = getData("testData");
        new HikingGuide().typeHikeName(hikeName.get("hike"));
    }

    @When("I click search button")
    public void iClickSearchButton() {
        new HikingGuide().pushSearchButton();
    }

    @Then("I verify search result is contained sought trail")
    public void iVerifySearchResultIsContainedSoughtTrail() {
        Map<String, String> expectedSearchResult = getData("testData");
        boolean isSearchResultReady = new HikingGuide().isSearchResultVisible(expectedSearchResult.get("hike"));
        assertThat(isSearchResultReady).isTrue();
        assertThat(new HikingGuide().getActualSearchResult(expectedSearchResult.get("hike"))).containsIgnoringCase(expectedSearchResult.get("hike"));
    }

    @Then("I move to trail page")
    public void iMoveToTrailPage() {
        Map<String, String> hikeName = getData("testData");
        new HikingGuide().goToHikePage(hikeName.get("hike"));
    }

    @When("I save hike to my backpack")
    public void iSaveHikeToMyBackpack() {
        new HikingGuide().saveHikeToMyBackpack();
    }

    @Then("I login")
    public void iLogin() {
        Map<String, String> accountCredentials = getData("account");
        new Login().login(accountCredentials);
    }


    @Then("I verify that hike was successfully saved")
    public void iVerifyThatHikeWasSuccessfullySaved() {
        Map<String, String> hikeName = getData("testData");
        new Header().goToMyAccount();
        new Backpack().goToMyHikesAndRecommendations();
        List<WebElement> savedHikesList = new MyHikesAndRecommendations().getSavedHikesList();
        assertThat(savedHikesList.contains(hikeName));
        new MyHikesAndRecommendations().removeHikeFromList(hikeName.get("hike"));
    }

    @Then("I write trip report")
    public void iWriteTripReport() {
        Map<String, String> hikeToReport = getData("testData");
        new TripReportAdd().typeShortHikeName(hikeToReport.get("shortName"))
                           .chooseDesiredHike(hikeToReport.get("hike"))
                           .goToDateField()
                           .pickYear(hikeToReport.get("year"))
                           .pickMonth(hikeToReport.get("month"))
                           .pickDate(hikeToReport.get("date"))
                           .selectTypeOfHike(hikeToReport.get("typeOfHike"))
                           .checkInFlowersBlooming()
                           .checkInHikingWithKids()
                           .selectRoadConditions(hikeToReport.get("roadConditions"))
                           .selectBugStatus(hikeToReport.get("bugStatus"))
                           .selectSnowConditions(hikeToReport.get("snowConditions"))
                           .selectTrailConditions(hikeToReport.get("trailConditions"))
                           .fullTripReport(hikeToReport.get("tripReport"))
                           .uploadPhoto()
                           .submitTripReport();
    }

    @And("I verify that trip report was saved successfully")
    public void iVerifyThatTripReportWasSavedSuccessfully() {
        Map<String, String> data = getData("testData");
        new Header().goToMyAccount();
        new Backpack().goToMyTripReports();
        List<WebElement> myTripReportsList = new MyTripReports().getMyTripReportsList();
        assertThat(myTripReportsList.contains(data.get("hike")));

    }
}

