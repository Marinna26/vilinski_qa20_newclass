import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardCreationTests extends  TestBase{
    @BeforeMethod
    public void ensurePreconditions() throws InterruptedException {
        if(!isUserLoggedIn()){
            login("marinna2011@ukr.net", "12345Com");
        };
    }

    @Test
    public void testBoardCreationFromHeader() throws InterruptedException {
        int before = getPersonalBoardsCount();
        clickOnPlusButtonOnHeader();
        selectCreateBoardFromDropDown();
        pause(7000);
        typeBoardName("qa20" + System.currentTimeMillis());
        confirmBoardCreation();
        pause(10000);
        returnToHomePage();
        pause(7000);

        int after = getPersonalBoardsCount();
        Assert.assertEquals(after, before +1);
    }


}
