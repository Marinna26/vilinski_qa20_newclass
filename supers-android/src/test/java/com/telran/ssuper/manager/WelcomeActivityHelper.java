package com.telran.ssuper.manager;

import io.appium.java_client.AppiumDriver;

public class WelcomeActivityHelper extends HelperBase{
    public WelcomeActivityHelper(AppiumDriver driver) {
        super(driver);

    }
    public void swipeScreen() throws InterruptedException {
        Thread.sleep(5000);
        app.getWelcome.swipeLeft();
    }
}
