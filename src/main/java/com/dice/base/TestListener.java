package com.dice.base;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

/**
 * Created by asok on 5/15/2018.
 */
public class TestListener extends TestListenerAdapter {
    @Override
    public void onTestSuccess(ITestResult testResultr) {
        System.out.println(testResultr.getTestContext().getCurrentXmlTest().getName() + " Test Success\n");
    }

    @Override
    public void onTestFailure(ITestResult testResultr) {
        System.out.println(testResultr.getTestContext().getCurrentXmlTest().getName() + " Test Failure");
    }

    @Override
    public void onStart(ITestContext testContext) {
        System.out.println(testContext.getCurrentXmlTest().getName() + " Test Start");
    }

    @Override
    public void onFinish(ITestContext testContext) {
        System.out.println(testContext.getCurrentXmlTest().getName() + " Test Finish");
    }
}
