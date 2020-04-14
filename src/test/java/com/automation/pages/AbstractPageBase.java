package com.automation.pages;

import com.automation.utilities.BrowserUtilities;
import com.automation.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//This class will be extended by page classes
//Ant common webElements/locators can be stored here
//S
public abstract class AbstractPageBase {
protected WebDriver driver= Driver.getDriver();
protected WebDriverWait wait=new WebDriverWait(driver,15);
@FindBy(css = "#user-name")
protected WebElement currentUser;//this user name is same for all pages when we login

public AbstractPageBase(){
    PageFactory.initElements(driver,this);
}


    public String getCurrentUserName(){
        BrowserUtilities.waitForPageToLoad(10);
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#user-menu>a")));
        wait.until(ExpectedConditions.visibilityOf(currentUser));
        return currentUser.getText().trim();
    }

//Below method is for Vytrack Navigation,.
    //provides tab name and module name to navigate
    //tabName==dashboards, Fleet, Customers
    //moduleName==Vehicles,Vehicles Odometer, Vehicles Costs

public void navigateTo(String tabName, String moduleName){

    String tabNameXpath = "//span[@class='title title-level-1' and contains(text(),'" + tabName + "')]";
    String moduleXpath = "//span[@class='title title-level-2' and text()='" + moduleName + "']";

    WebElement tabElement = driver.findElement(By.xpath(tabNameXpath));
    WebElement moduleElement = driver.findElement(By.xpath(moduleXpath));

    Actions actions=new Actions(driver);
    BrowserUtilities.wait(4);

    actions.moveToElement(tabElement).
            pause(2000).
            click(moduleElement).
            build().perform();
    BrowserUtilities.wait(4);
}

}
