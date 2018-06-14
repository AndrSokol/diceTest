package com.dice.pages;

import com.dice.base.BasePageObject;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by asok on 5/11/2018.
 */
public class ProfilePage extends BasePageObject<ProfilePage> {
    private By editProfileBytton = By.xpath("//button[@id='editProfile']");
    private By advancedSearchButton = By.xpath("//*[@id='advanced-search-link']");
    private By profileContactNameText = By.xpath("//*[contains(concat(' ',@class,' '),' profile-contact-name ')]");

    public ProfilePage(WebDriver driver, Logger log){
        super(driver, log);
    }

    public void waitForProfilePageToLoad(){
        log.info("Waiting for profile page to load");
        waitForVisabilityOf(editProfileBytton);
        waitForVisabilityOf(advancedSearchButton, 10);
    }

    public boolean isCorrectProfileLoaded(String correctProfileName){
        if(getText(profileContactNameText).equals(correctProfileName)){
            return true;
        }
        return false;
    }
}
