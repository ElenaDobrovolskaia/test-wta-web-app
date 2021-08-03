package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import static support.TestContext.getDriver;

public class WTAHeader extends Page {
    @FindBy(xpath = "//label[@for='search-field']")
    private WebElement siteSearch;

    @FindBy(xpath = "//h2[contains(text(),'My Backpack')]")
    private WebElement myBackpackMenu;
    @FindBy(id = "personaltools-dashboard")
    private WebElement dashboardAccountMenu;
    @FindBy(id = "personaltools-trip-report")
    private WebElement tripReportAccountMenu;
    @FindBy(id = "personaltools-login")
    private WebElement loginAccountMenu;
    @FindBy(id = "personaltools-join")
    private WebElement joinAccountMenu;


    public WTAHeader goToMyBackpack() {
        click(myBackpackMenu);
        return new WTAHeader();
    }
    public WTAHeader goToDashboard() {
        click(dashboardAccountMenu);
        return new WTALogin();
    }
    public WTAHeader goToTripReport() {
        click(tripReportAccountMenu);
        return new WTALogin();
    }
    public WTAHeader goToLogIn() {
        click(loginAccountMenu);
        return new WTALogin();
    }
    public WTAHeader goSignUp() {
        click(joinAccountMenu);
        return new WTALogin();
    }

    public WTAHeader mouseOverElement(String elemName) {
        switch (elemName) {
            case "My Backpack":
                new Actions(getDriver()).moveToElement(getDriver().findElement(By.xpath(elemName))).perform();
                break;
            default:
                throw new RuntimeException("Page not supported");
        }
        return new WTAHeader();
    }




}
