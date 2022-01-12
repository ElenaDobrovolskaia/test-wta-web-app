package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Donate extends Header {
    @FindBy(xpath = "//small[contains(text(),'Donate')]")
    private WebElement donationMethodLabel;

    public String getPartialContent(){
        String label=donationMethodLabel.getText();
        return label;
    }
}
