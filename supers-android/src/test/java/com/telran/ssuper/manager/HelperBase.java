package com.telran.ssuper.manager;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import java.awt.*;

public class HelperBase {
    AppiumDriver driver;


    public HelperBase(AppiumDriver driver) {
        this.driver = driver;
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public void type(By locator, String text) {
        if(text!=null) {
            click(locator);
            driver.findElement(locator).clear();
            driver.findElement(locator).sendKeys(text);
        }
    }

    public void pause(int millis) throws InterruptedException {
        Thread.sleep(millis);
    }
    public boolean isElementPresent(By locator){
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isElementPresent2(By locator){
        return  driver.findElements(locator).size()>0;
    }

    public void closeKeyBoard(){
        driver.hideKeyboard();
    }

    public void swipeLeft(){
        TouchAction action = new TouchAction(driver);
        Dimension size = driver.manage().window().getSize();

        int y = size.height/2;
        int startX = (int) (size.width*0.8);
        int stopX = (int) (size.width*0.2);

        action.press(PointOption.point(startX, y))

                .moveTo(PointOption.point(stopX, y))
                .release().perform();
    }

    public void swipeRirht(){
        TouchAction action = new TouchAction(driver);
        Dimension size = driver.manage().window().getSize();

        int y = size.height/2;
        int startX = (int) (size.width*0.2);
        int stopX = (int) (size.width*0.8);

        action.press(PointOption.point(startX, y))

                .moveTo(PointOption.point(stopX, y))
                .release().perform();
    }
    public void swipeUp(){
        TouchAction action = new TouchAction(driver);
        Dimension size = driver.manage().window().getSize();

        int x = size.width/2;
        int startY = (int) (size.height*0.8);
        int stopY = (int) (size.height*0.2);

        action.press(PointOption.point(x, startY))
                .moveTo(PointOption.point(x, stopY))
                .release().perform();

    }
}
