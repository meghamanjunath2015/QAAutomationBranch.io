package App.google;

import App.Model.BaseElement;
import App.branch.pages.HomePage;
import com.sun.webkit.WebPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleSearchPage extends BaseElement{
    public WebElement pageLink;
    public GoogleSearchPage(){
        WebDriver _driver = driver;
        pageBody = driver.findElement(By.id("center_col"));
    }

    public HomePage clickOnBranch(){
        pageLink = pageBody.findElement(By.cssSelector("a[href='https://branch.io/']"));
        pageLink.click();
        return new HomePage();
    }
}
