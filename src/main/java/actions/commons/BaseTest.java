package actions.commons;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.time.Duration;

public class BaseTest {
    // Start browser
    public static final Logger log = LogManager.getLogger(BaseTest.class);

    @BeforeSuite
    public void deleteAllFileInAllureResult(){
        log.info("delete file ne");
        File filesList[] = new File(GlobalVariables.PROJECT_DIR+ File.separator +"allure-results").listFiles();
        if (filesList.length != 0) {
            for (int i = 0; i < filesList.length; i++) {
                if (filesList[i].isFile() && !filesList[i].getName().equals("environment.properties")) {
                    new File(filesList[i].toString()).delete();
                }
            }
        }
    }

}
