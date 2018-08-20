package App.google;
import App.Model.BaseElement;
import org.openqa.selenium.*;

import static App.AppConfig.HOST_MAIN;

public class GoogleHomePage extends BaseElement{
    private WebElement pageBody,searchBar,
            searchButton;

    public GoogleHomePage(){
        driver = BaseElement();
        driver.navigate().to(HOST_MAIN);
        pageBody = driver.findElement(By.id("viewport"));
        searchBar = pageBody.findElement(By.xpath("//input[@title='Search']"));
        searchButton = pageBody.findElement(By.xpath("//input[@value='Google Search']"));
    }

    public GoogleSearchPage search(String val){
        this.searchBar.sendKeys(val);
        this.searchButton.submit();
        return new GoogleSearchPage();
    }
}