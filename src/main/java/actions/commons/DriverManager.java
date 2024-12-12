package actions.commons;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

public class DriverManager {

    public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void getBrowserDriver(String browserName) {
        switch (browserName.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver.set(new ChromeDriver());
                break;
            case "h_chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--headless");
                driver.set(new ChromeDriver(chromeOptions));
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver.set(new FirefoxDriver());
                break;
            case "h_firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--headless");
                driver.set(new FirefoxDriver(firefoxOptions));
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver.set(new EdgeDriver());
                break;
            case "h_edge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--headless");
                driver.set(new EdgeDriver(edgeOptions));
                break;

            default:
                throw new IllegalArgumentException("Browser name not supported: " + browserName);

        }
        driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalVariables.SORT_TIMEOUT));
        driver.get().manage().window().maximize();
        driver.get().get(GlobalVariables.BANK_GURU_REGISTER);
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void closeBrowser() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }

}
