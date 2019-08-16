package com.telran.ssuper.manager;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    SessionHelper session;
    AppiumDriver driver;
    WelcomeActivityHelper welcome;




    public void init() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "qa20_class");
        capabilities.setCapability( "platformVersion", "8.0");
        capabilities.setCapability( "automationName", "Appium");
        capabilities.setCapability( "appPackage", "com.example.svetlana.scheduler");
        capabilities.setCapability( "appActivity", ".presentation.splashScreen.SplashScreenActivity");
        capabilities.setCapability( "app", "C:/Users/Marina/Documents/GitHub/vilinski_qa20_newclass/supers-android/src/test/resources/v.0.0.2.apk");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);

        session = new SessionHelper(driver);
//       session.login("marinna2011@ukr.net", "12345Com");
        welcome = new WelcomeActivityHelper(driver);

    }

    public void stop() {
        wd.quit();
    }

    public void pause(int millis) throws InterruptedException {
        Thread.sleep(millis);
    }



  public void click(By locator) {
        wd.findElement(locator).click();
    }



   public void type(By locator, String text) {
        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }





    public void clickOnPlusButtonOnHeader() {
        click(By.cssSelector("[name=add]"));
    }


    public void returnToHomePage() {
        click(By.cssSelector("[href='/']"));
    }


    public SessionHelper getSession() {
        return session;
    }


}
