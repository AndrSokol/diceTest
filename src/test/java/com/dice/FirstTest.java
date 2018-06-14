package com.dice;

import com.dice.base.BaseTest;
import org.testng.annotations.Test;

/**
 * Created by asok on 5/11/2018.
 */
public class FirstTest extends BaseTest{

    @Test
    public void firstTestMethod(){
        driver.get("http://www.apache-maven.ru");
        System.out.println("First test succeeded");
    }
}
