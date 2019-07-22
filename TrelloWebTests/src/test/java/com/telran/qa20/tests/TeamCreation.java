
        package com.telran.qa20.tests;

        import com.telran.qa20.model.Team;
        import org.testng.annotations.BeforeMethod;
        import org.testng.annotations.Test;

public class TeamCreation extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() throws InterruptedException {
        if(!app.getSession().isUserLoggedIn())
            app.getSession().login("narishka@walla.com", "202010Zxc");
    }


    @Test
    public void createTeam() throws InterruptedException {
        int before= app.getTeams().getTeamsCount();

        app.clickOnPlusButtonOnHeader();
        app.getTeams().selectTeamGroup();

        app.getTeams().fillTeamForm(new Team()
                .withTeamName("QA-20" + System.currentTimeMillis())
                .withTeamDescription("description qa20"));

        app.getSession().pause(7000);
        app.getTeams().submitCreateTeam();
        app.returnToHomePage();


        //int after = app.getTeams().getTeamsCount();
        // Assert.assertEquals(after,before+1);

    }

}