package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

import static support.TestContext.getDriver;

public class Backpack extends Header{
    @FindBy(xpath = "//h1[contains(text(), 'My Hikes')]")
    private WebElement myHikesAndRecommendations;
    @FindBy (xpath = "//h1[contains(text(),'My Trip Reports')]")
    private WebElement myTripReports;

    private WebElement savedHike(String title) {
        return getDriver().findElement(By.xpath("//a[contains(text(),'" + title + "')]"));
    }
    public MyHikesAndRecommendations goToMyHikesAndRecommendations(){
        click(myHikesAndRecommendations);
        return new MyHikesAndRecommendations();
    }
    public MyTripReports goToMyTripReports(){
        click(myTripReports);
        return new MyTripReports();
    }

}
