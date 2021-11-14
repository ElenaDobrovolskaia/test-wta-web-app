package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static support.TestContext.getDriver;

public class MyTripReports extends Header{
   
    public List<WebElement> getMyTripReportsList(){
        List<WebElement> myTripReports=getDriver().findElements(By.cssSelector("#trip-reports>div>div:nth-of-type(n)"));
        return myTripReports;
    }
    
}
