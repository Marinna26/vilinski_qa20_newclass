package com.telran.ssuper.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginRegistrationTest extends TestBase{
    @Test
    public void testLogin(){
        app.getSession().fillLoginForm("telran+11@gmail.com", "Aa1234567");
        app.getSession().closeKeyBoard();
        app.getSession().confirmLogin();
        app.pause(4000);

       // Assert.assertFalse(app.getSession().isElementPresent(By.xpath("")));
    }
}
