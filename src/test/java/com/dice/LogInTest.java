package com.dice;

import com.dice.base.BaseTest;
import com.dice.base.CsvDataProvider;
import com.dice.pages.LogInPage;
import com.dice.pages.ProfilePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

/**
 * Created by asok on 5/11/2018.
 */
public class LogInTest extends BaseTest {

    @Test(dataProvider = "CsvDataProvider", dataProviderClass = CsvDataProvider.class, priority = 1, groups = { "positive" })
    public void positiveLoginTest(Map<String, String> testData) {
        LogInPage logInPage = new LogInPage(driver, log);
        String expectedPageTitle = "Seeker Dashboard - Profile";
        String correctProfileName = "Andrey Sokolenko";
        String email = testData.get("email");
        String password = testData.get("password");

        // Open dice login page
        logInPage.openLoginPage();

        // Fill up email and login
        logInPage.fillUpEmailAndPassword(email, password);

        // Push Sign In button and wait for page profile to load
        ProfilePage profilePage = logInPage.pushSignInButton();
        profilePage.waitForProfilePageToLoad();

        //Verify title
        String actualTitle = profilePage.getTitle();
        Assert.assertTrue(expectedPageTitle.equals(actualTitle),
                "Page title is not expected.\nExpected: " + expectedPageTitle + "\nActual: " + actualTitle + ". ");

        //verify correct name of profile
        Assert.assertTrue(profilePage.isCorrectProfileLoaded(correctProfileName), "Profile name is not expected.");
    }

    @Test(dataProvider = "CsvDataProvider", dataProviderClass = CsvDataProvider.class, priority = 2, groups = { "negative" })
    public void negativeLoginTest(Map<String, String> testData) {
        String expectedErrorMessage = "Email and/or password incorrect.";
        String testNumber = testData.get("no");
        String email = testData.get("email");
        String password = testData.get("password");
        String description = testData.get("description");

        log.info("Test No #" + testNumber + " for " + description + " Where\nEmail " + email + "\nPassword " + password);

        LogInPage logInPage = new LogInPage(driver, log);

        // Open dice login page
        logInPage.openLoginPage();

        // Fill up email and login
        logInPage.fillUpEmailAndPassword(email, password);

        // Push Sign In button
        logInPage.pushSignInButton();

        String errorMessage = logInPage.getLogInErrorMessage();
        Assert.assertTrue(errorMessage.contains(expectedErrorMessage),
                "Error message is not expected.\nExpected: " + expectedErrorMessage + "\nActual: " + errorMessage + ".\n");
    }
}
