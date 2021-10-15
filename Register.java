package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Map;

import static support.TestContext.getDriver;

public class Register extends Header {
    @FindBy (id="form-fullname")
    private WebElement screenName;
    @FindBy (id="form-first_name")
    private WebElement firstName;
    @FindBy (id="form-last_name")
    private WebElement lastName;
    @FindBy (id="form-email")
    private WebElement formEmail;
    @FindBy (id="form-postal_code")
    private WebElement zipCode;
    @FindBy (id = "form-trailnews_signup-0")
    private WebElement trailNewsSignUp;
    @FindBy (id = "form-trailaction_signup-0")
    private WebElement trailTrailActionSignUp;
    @FindBy (id = "form-actions-register")
    private WebElement registerButton;
    @FindBy (xpath="//dd[contains(text(),'There were errors.')]")
    private WebElement errorMessage;

    private WebElement errorCard(String title) {
        return getDriver().findElement(By.xpath("//div[@id='formfield-form-" + title + "']//div[@class='error']"));
    }

    public Register createAccount(Map<String,String> user){
        fill(screenName, user.get("screenName"));
        fill(firstName, user.get("firstName"));
        fill(lastName, user.get("lastName"));
        fill(formEmail, user.get("email"));
        fill(zipCode, user.get("zip"));
        return new Register();
    }
    public Register fillAllFieldsExceptForOne(Map<String,String> user, String fieldName){

        WebElement nameField=getDriver(). findElement(By.xpath("//input[@id='form-"+fieldName+"']"));
        fill(screenName, user.get("screenName"));
        fill(firstName, user.get("firstName"));
        fill(lastName, user.get("lastName"));
        fill(formEmail, user.get("email"));
        fill(zipCode, user.get("zip"));
        nameField.clear();
        return new Register();
    }
    public Register submit(){
        registerButton.click();
        return new Register();
    }

    public boolean isErrorMessageVisible(String title) {
        try {
            return errorCard(title).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    public boolean isPortalErrorMessageVisible() {
        try {
            return errorMessage.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    public String getErrorText(String title) {
        return errorCard(title).getText();
    }
    public String getCheckBoxStatus(String checkBoxName){
        return getDriver().findElement(By.xpath("//input[@id='form-" + checkBoxName + "_signup-0']")).getAttribute("value");
    }
    public Register clickUnsubscribe(String checkBoxName){
        WebElement checkBox=getDriver().findElement(By.xpath("//input[@name='form." + checkBoxName + "_signup:list']"));
        checkBox.click();
        return new Register();
    }










}
