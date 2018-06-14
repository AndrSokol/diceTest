package com.dice.base;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

/**
 * Created by asok on 5/11/2018.
 */
public class BaseTest {
    protected WebDriver driver;
    protected Logger log;

    @BeforeClass(alwaysRun = true)
    protected void setUpClass(ITestContext ctx){
        String testName = ctx.getCurrentXmlTest().getName();
        log = Logger.getLogger(testName);
    }

    @Parameters({"browser"})
    @BeforeMethod(alwaysRun = true)
    protected void setUp(String browser){
        log.info("Method set up");
        driver = BrowserFactory.getDriver(browser, log);
    }

    @AfterMethod(alwaysRun = true)
    protected void tearDown(){
        log.info("Method tear down");
        driver.quit();
    }
}
