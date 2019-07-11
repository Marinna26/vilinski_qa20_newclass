import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class TrelloLoginTest extends  TestBase{
    @Test
    public void loginTest() throws InterruptedException {
        clickLoginButton();
        fillLoginForm("marinna2011@ukr.net", "12345Сom");
        pause(3000);
        confirmLogin();
        pause(10000);

    }

}
