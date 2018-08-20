package App.Model;
import App.AppConfig;
import Utils.InitialDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BaseElement extends InitialDriver {
    public WebElement pageBody;

    public WebDriver BaseElement(){
        return InitialDriver.getChromeDriver();
    }
}
