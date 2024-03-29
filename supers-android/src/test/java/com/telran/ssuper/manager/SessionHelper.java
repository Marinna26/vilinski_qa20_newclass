package com.telran.ssuper.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends HelperBase{
    public SessionHelper(WebDriver driver) {
        super(driver);
    }
    public boolean isUserLoggedIn() {
        return isElementPresent2(By.cssSelector("[href='/']"));
    }

    public void clickLoginButton() {
        click(By.cssSelector("[href='/login']"));
    }
    public void login(String email, String pwd) throws InterruptedException {
        clickLoginButton();
        fillLoginForm(email, pwd); //"elena.telran@yahoo.com", "12345.com"
        pause(3000);
        confirmLogin();
        pause(10000);
    }

    public void confirmLogin() {
        click(By.id("//*[@id='login_btn']"));
    }

    public void fillLoginForm(String email, String password) {
        type(By.id("log_email_input"), email);
        type(By.name("log_password_input"), password);
    }
}
