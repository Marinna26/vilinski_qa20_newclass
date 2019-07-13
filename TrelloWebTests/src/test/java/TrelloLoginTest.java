import org.testng.annotations.Test;

public class TrelloLoginTest extends  TestBase{
    @Test
    public void loginTest() throws InterruptedException {
        app.clickLoginButton();
        app.fillLoginForm("marinna2011@ukr.net", "12345Сom");
        app.pause(3000);
        app.confirmLogin();
        app.pause(10000);

    }

}
