package test;
import App.branch.pages.TeamPage;
import App.google.GoogleHomePage;
import Utils.InitialDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TeamPageTest {
    private GoogleHomePage googleHomePage;
    private TeamPage teamPage;
    private String searchValue = "Branch";
    @BeforeClass(alwaysRun = true)
    public void initialization() {
         googleHomePage =  new GoogleHomePage();
         teamPage = googleHomePage.search(searchValue)
                       .clickOnBranch()
                       .clickOnTeamLink();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown(){
        InitialDriver.closeDriver();
    }

    @Test(groups = {"Teams"})
    public void noOfEmpMatchBetweenAllAndOtherTabs(){
            Assert.assertEquals(teamPage.sumOfEmployeeInTeamsExceptAll(), teamPage.countEmpInTeam("All"));
    }

    @Test(groups = {"Teams"})
    public void matchEmpNameBetweenAllAndOtherTabs() {
        Assert.assertTrue(teamPage.verifyNameFromAllToOtherTeams());
    }

    @Test(groups = {"Teams"})
    public void matchDeptBetweenAllAndOtherTabs() {
        Assert.assertTrue(teamPage.verifyDeptFromAllToOtherTeams());
    }

    @Test(groups = {"Teams"})
    public void verifyIfAllTeamsHasEmpPhotos() {
        Assert.assertTrue(teamPage.verifyIfAllTeamsHasEmpPhotos());
    }

    @Test(groups = {"Teams"})
    public void checkIfEmployeeHasGitHubLink(){
        Assert.assertTrue(teamPage.checkGitHubLinkOfEmp("Engineering", "Dmitri Gaskin"));
    }


}
