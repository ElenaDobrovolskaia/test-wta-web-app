package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

import static support.TestContext.getActions;
import static support.TestContext.getDriver;

public class MyHikesAndRecommendations extends Header {
    @FindBy(xpath = "//div[@class='module view list highlight backpack-hikes']")
    private WebElement savedHikes;
    private WebElement savedHikeCard(String title) {
        return getDriver().findElement(By.xpath("//a[contains(text(),'"+title+"')]"));
    }
    private WebElement removeHikeButton(String title){
        return getDriver().findElement(By.xpath("//a[contains(text(),'"+title+"')]/../..//div/span[contains(text(),'Remove Hike')]"));
    }

    public List<WebElement> getSavedHikesList(){
        List<WebElement>savedHikes=getDriver().findElements(By.xpath("//div[@class='module view list highlight backpack-hikes']"));
        return savedHikes;
    }
    public MyHikesAndRecommendations removeHikeFromList(String hikeName){
        WebElement hike = savedHikeCard(hikeName);
        getActions().moveToElement(hike).perform();
        click(removeHikeButton(hikeName));
        return new MyHikesAndRecommendations();
    }
}
