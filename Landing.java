package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Landing extends Header {
    public Landing() {
        url = "https://www.wta.org/";
    }

    @FindBy(xpath="//h1[contains(text(),'Powered by Hikers')]")
    private WebElement PoweredByHikersBanner;




}
