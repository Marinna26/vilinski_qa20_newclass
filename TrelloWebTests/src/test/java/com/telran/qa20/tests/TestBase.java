package com.telran.qa20.tests;

import com.telran.qa20.manager.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.*;



public class TestBase {


    static ApplicationManager app = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));

    @BeforeSuite
    public void setUp() throws InterruptedException {
        app.init();
    }

    @AfterSuite
    public void tearDown() {
        app.stop();
    }

}

