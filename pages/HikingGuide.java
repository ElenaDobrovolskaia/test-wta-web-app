package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static support.TestContext.getDriver;

public class HikingGuide extends Header {
    @FindBy(name = "title")
    private WebElement inputHikeSearch;
    @FindBy(name = "filter")
    private WebElement searchButton;
    @FindBy(xpath = "//span[contains(text(),'Save Hike to')]/../../button")
    private WebElement saveToMyBackpack;

    private WebElement searchResultCard(String title) {
        return getDriver().findElement(By.xpath("//span[contains(text(),'"+title+"')]"));
    }

    public HikingGuide saveHikeToMyBackpack() {
        click(saveToMyBackpack);
        return new HikingGuide();
    }

    public HikingGuide typeHikeName(String hikeName) {
        fill(inputHikeSearch,hikeName);
        return new HikingGuide();
    }
    public HikingGuide pushSearchButton() {
        click(searchButton);
        return new HikingGuide();
    }
    public HikingGuide goToHikePage(String hikeName) {
        click(searchResultCard(hikeName));
        return new HikingGuide();
    }

    public String getActualSearchResult(String hikeName){
        String result=searchResultCard(hikeName).getText();
        return result;
    }

    public boolean isSearchResultVisible(String title) {
        try {
            return searchResultCard(title).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }




}
