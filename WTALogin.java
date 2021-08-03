package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Map;

public class WTALogin extends WTAHeader {

    @FindBy(xpath = "//input[@id='__ac_name']")
    private WebElement email;
    @FindBy(xpath = "//input[@id='__ac_password']")
    private WebElement password;
    @FindBy(xpath = "//input[@class='context go-button']")
    private WebElement loginButton;


    public WTALanding login(Map<String, String> user) {
        fill(email,user.get("email"));
        fill(password,user.get("password"));
        click(loginButton);
        return new WTALanding();
    }

    public void login(String username, String password) {
        this.email.sendKeys(username);
        this.password.sendKeys(password);
        loginButton.click();
    }


}
