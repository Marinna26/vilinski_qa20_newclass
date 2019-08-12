package com.telran.qa20.manager;

import com.telran.qa20.model.Team;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class Teams extends HelperBase{

    public Teams(WebDriver driver) {
        super(driver);
    }
    public void selectTeamGroup() {
        click(By.xpath(" //button[@data-test-id='header-create-team-button']"));
        //button[@data-test-id='header-create-team-button']
    }
    public void typeTeamName(String teamName) {
        click(By.cssSelector("[data-test-id='header-create-team-name-input']"));
        wd.findElement(By.cssSelector("[data-test-id='header-create-team-name-input']")).clear();
        wd.findElement(By.cssSelector("[data-test-id='header-create-team-name-input']")).sendKeys(teamName);
    }
    public int getTeamsCount() {
        return wd.findElements(By.xpath("//div[@class='_2SmDbz1bYpPjKK']")).size();

    }
    public void submitCreateTeam() {
        click(By.xpath("//button[@data-test-id='header-create-team-submit-button']"));
    }

    public void fillTeamForm(Team team) {
        typeTeamName(team.getTeamName());
        typeTeamDescription(team.getTeamDescription());
    }

    public void typeTeamDescription(String teamDescription) {
        type(By.cssSelector("[name = desc]"), teamDescription);
    }


     /*public void changePhoto() throws InterruptedException, AWTException {
        wd.findElement(By.cssSelector(".js-open-header-member-menu")).click();
        wd.findElement(By.xpath("//a[@data-test-id='header-member-menu-profile']")).click();
        Actions actions = new Actions(wd);
        WebElement photo = wd.findElement(By.xpath("//button[@class='_2e97X7K2YRLv4Q']"));
        actions.moveToElement(photo).click().perform();
        pause(2000);


        Robot robot = new Robot();
        String filePath = "C/2.jpg";
        wd.findElement(By.xpath("//button[@class='_1YROXclZyiVJEd']")).click();

        pause(2000);
        StringSelection stringSelection = new StringSelection("C:\\Users\\Marina\\Documents\\GitHub\\vilinski_qa20_newclass\\TrelloWebTests\\src\\test\\resources\\2.jpg");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection,null);
        pause(1000);

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);

        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);

        pause(1000);
        robot.keyPress(KeyEvent.VK_ENTER);
        pause(3000);

    }*/


}

