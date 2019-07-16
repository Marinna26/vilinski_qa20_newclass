package com.telran.qa20.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardCreationTests extends  TestBase{
    @BeforeMethod
    public void ensurePreconditions() throws InterruptedException {
        if(!app.getSession().isUserLoggedIn()){
            app.getSession().login("marinna2011@ukr.net", "12345Com");
        }
    }

    @Test
    public void testBoardCreationFromHeader() throws InterruptedException {
        int before = app.getBoard().getPersonalBoardsCount();
        app.clickOnPlusButtonOnHeader();
        app.getBoard().selectCreateBoardFromDropDown();
        app.pause(7000);
        app.getBoard().typeBoardName("qa20" + System.currentTimeMillis());
        app.getBoard().confirmBoardCreation();
        app.pause(10000);
        app.returnToHomePage();
        app.pause(7000);

        int after = app.getBoard().getPersonalBoardsCount();
        Assert.assertEquals(after, before +1);
    }


}
