package Utils;
import App.AppConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
import java.util.concurrent.TimeUnit;

public class InitialDriver {

    public static WebDriver driver = null;
    public static WebDriver getChromeDriver(){
        AppConfig.readProperties();
        System.setProperty("webdriver.chrome.driver", System.getProperty("buildDirectory"));
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return driver;

    }

    public static void closeDriver() {
        driver.close();
    }
}
