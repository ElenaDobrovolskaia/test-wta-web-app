package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

import static support.TestContext.getActions;
import static support.TestContext.getDriver;

public class MyHikesAndRecommendations extends Header {
    @FindBy(css = "div[class$='backpack-hikes']")
    private WebElement savedHikes;
    
    private WebElement savedHikeCard(String title) {
        return getDriver().findElement(By.xpath("//a[contains(text(),'"+title+"')]"));
    }
    private WebElement removeHikeButton(String title){
        //return getDriver().findElement(By.xpath("//a[contains(text(),'"+title+"')]/../..//div/span[contains(text(),'Remove Hike')]"));
        return getDriver().findElement(By.cssSelector("div[data-hikename*='"+title+"']>div>div>div>span[class*='remove']"));
    }

    public List<WebElement> getSavedHikesList(){
        List<WebElement>savedHikes=getDriver().findElements(By.cssSelector("div[class*='backpack']>div:nth-of-type(n)"));
        return savedHikes;
    }
    public MyHikesAndRecommendations removeHikeFromList(String hikeName){
        WebElement hike = savedHikeCard(hikeName);
        getActions().moveToElement(hike).perform();
        click(removeHikeButton(hikeName));
        return new MyHikesAndRecommendations();
    }
}
