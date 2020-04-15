package com.automation.pages;

import com.automation.utilities.ConfigurationReader;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends AbstractBasePageDONT_TOUCH {
//new

    @FindBy(css = "[placeholder='Login']")
    private WebElement username;

    @FindBy(css = "[placeholder='Password']")
    private WebElement password;

    @FindBy(linkText = "Forgot your password?")
    private WebElement forgotPassword;

    public void login(){
        String usernameValue = ConfigurationReader.getProperty("user1");
        String passwordValue = ConfigurationReader.getProperty("password");

        username.sendKeys(usernameValue);
        password.sendKeys(passwordValue, Keys.ENTER);
    }

    public void login(String usernameValue, String passwordValue){
        username.sendKeys(usernameValue);
        password.sendKeys(passwordValue, Keys.ENTER);
    }

    public WebElement forgotPasswordBtn(){
        return forgotPassword;
    }

}
