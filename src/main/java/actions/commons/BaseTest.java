package actions.commons;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class BaseTest {
    // Start browser
    public static WebDriver driver;

    public WebDriver getBrowserDriver(String browserName,String url){
            switch (browserName){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                case "edge":{
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                }
            }
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalVariables.SORT_TIMEOUT));
            driver.manage().window().maximize();
            driver.get(url);
            return driver;
    }

}
