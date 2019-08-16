package com.telran.ssuper.tests;

import org.testng.annotations.Test;

public class WelcomeScreenTest extends TestBase{
    @Test
    public void welcomeScreenSwipeTest(){
        app.getWelcome().swipeScreen();
    }
}
