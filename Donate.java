package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Donate extends Header {
    @FindBy(xpath = "//strong[contains(text(),'Donate')]")
    private WebElement paragraph;
    public Donate(){
        url="https://give.wta.org/give/343832/#!/donation/checkout";
    }
    public String getParagraph(){
        String title=paragraph.getText();
        return title;
    }
}
