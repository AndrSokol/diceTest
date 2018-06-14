package com.dice.pages;

import com.dice.base.BasePageObject;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



/**
 * Created by asok on 5/11/2018.
 */
public class LogInPage extends BasePageObject<LogInPage> {
    private static final String URL = "https://www.dice.com/dashboard/login";

    private By emailField = By.xpath("//*[@id='email']");
    private By passwordField = By.xpath("//*[@id='password']");
    private By signInButton = By.xpath("//button[.='Sign In ']");
    private By errorMessage = By.xpath("//*[@data-automation-id='login-failure-help-message']");

    public LogInPage(WebDriver driver, Logger log){
        super(driver, log);
    }

    public void openLoginPage(){
        getPage(URL);
    }

    public void fillUpEmailAndPassword(String email, String password){
        log.info("Filling in Email and Password");
        type(email, emailField);
        type(password, passwordField);
    }

    public ProfilePage pushSignInButton(){
        log.info("Clicking on Sigh In button");
        click(signInButton);
        return new ProfilePage(driver, log);
    }

    public String getLogInErrorMessage() {
        log.info("Getting Log In error message");
        waitForVisabilityOf(errorMessage, 10);
        return getText(errorMessage);
    }
}
