package testcase.bankGuru;

import actions.commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Register extends BaseTest {
    WebDriver driver;
    @BeforeClass
    public void beforeClass(){
        driver= getBrowserDriver("chrome","https://demo.guru99.com/");
        // note account - pw :
        //mngr585044-tEsYjAb
    }
    @Test
    public void TC_01(){

    }
}
