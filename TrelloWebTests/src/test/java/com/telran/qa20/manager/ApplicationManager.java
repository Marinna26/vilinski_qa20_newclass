package com.telran.qa20.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    Board board;
    SessionHelper session;
    WebDriver wd;
    Teams teams;

    public void init() throws InterruptedException {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.get("https://trello.com");
        session = new SessionHelper(wd);
       session.login("marinna2011@ukr.net", "12345Com");

       board = new Board(wd);
       teams = new Teams(wd);
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

    public Board getBoard() {
        return board;
    }

    public Teams getTeams() {
        return teams;
    }
}
