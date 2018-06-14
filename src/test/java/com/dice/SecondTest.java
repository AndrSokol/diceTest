package com.dice;

import com.dice.base.BaseTest;
import org.testng.annotations.Test;

/**
 * Created by asok on 5/11/2018.
 */
public class SecondTest extends BaseTest{

    @Test
    public void secondTestMethod(){
        driver.get("http://www.google.com");
        System.out.println("Second test succeeded");
    }
}
