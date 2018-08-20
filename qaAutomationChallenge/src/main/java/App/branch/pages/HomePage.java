package App.branch.pages;

import App.Model.BaseElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePage extends BaseElement {
    public WebElement pageBody, footer, teamLink, bottomFooter;
    public Actions actions;

public  HomePage(){
        actions = new Actions(driver);
        pageBody = driver.findElement(By.xpath("//body[@data-spy='scroll']"));
        footer = pageBody.findElement(By.tagName("footer"));
        teamLink = footer.findElement(By.xpath("//a[@data-element-tag='team']"));
        bottomFooter = footer.findElement(By.className("clearfix"));
}

public TeamPage clickOnTeamLink(){
        actions.moveToElement(bottomFooter).perform();
        teamLink.click();
        return new TeamPage();
}

}
