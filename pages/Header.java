package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import static support.TestContext.getDriver;

public class Header extends Page {
    @FindBy(xpath = "//label[@for='search-field']")
    private WebElement siteSearch;
    @FindBy(xpath = "//h2[contains(text(),'My Backpack')]")
    private WebElement myBackpackMenu;
    @FindBy(xpath = "//a[@id='portrait']")
    private WebElement myAccountIcon;
    @FindBy(id = "personaltools-dashboard")
    private WebElement dashboardAccountMenu;
    @FindBy(id = "personaltools-trip-report")
    private WebElement tripReportAccountMenu;
    @FindBy(id = "personaltools-login")
    private WebElement loginAccountMenu;
    @FindBy(id = "personaltools-join")
    private WebElement joinAccountMenu;
    @FindBy(xpath = "//li[@id='portaltab-our-work']/a")
    private WebElement ourWorkMenu;
    @FindBy(xpath = "//li[@id='portaltab-go-outside']/a")
    private WebElement goOutsideMenu;
    @FindBy(xpath = "//li[@id='portaltab-get-involved']/a")
    private WebElement getInvolvedMenu;
    @FindBy(xpath = "//li[@id='portaltab-donate']/a")
    private WebElement donate;
    @FindBy(xpath = "//li[@id='portaltab-go-outside']//span[contains(text(), 'Hiking Guide')]")
    private WebElement hikingGuide;

    public Header goToMyAccount(){
        click(myAccountIcon);
        return new Backpack();
    }
    public Header goToMyBackpack() {
        click(myBackpackMenu);
        return new Header();
    }
    public Header goToDashboard() {
        click(dashboardAccountMenu);
        return new Login();
    }
    public Header goToTripReport() {
        click(tripReportAccountMenu);
        return new Login();
    }
    public Header goToLogIn() {
        click(loginAccountMenu);
        return new Login();
    }
    public Header goSignUp() {
        click(joinAccountMenu);
        return new Login();
    }
    public Header goToGoOutside() {
        click(goOutsideMenu);
        return new OurWork();
    }

    public Header goToOurWork() {
        click(ourWorkMenu);
        return new GoOutside();
    }
    public Header goToGetInvolved() {
        click(getInvolvedMenu);
        return new GetInvolved();
    }
    public Donate goToDonate() {
        click(donate);
        return new Donate();
    }
    public Header goToHikingGuide() {
        click(hikingGuide);
        return new HikingGuide();
    }

    public Header mouseOverElement(String elemName) {
        switch (elemName) {
            case "Go Outside":
                new Actions(getDriver()).moveToElement(goOutsideMenu).perform();
                break;
            default:
                throw new RuntimeException("Page not supported");
        }
        return new Header();
    }
    public String getTitle(){
        String title=getDriver().getTitle();
        return title;
    }
}
