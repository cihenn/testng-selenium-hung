package testcase.bankGuru;

import actions.commons.BaseTest;
import actions.commons.DriverManager;
import actions.pageObject.bankGuru.registerPage.RegisterPageActions;
import com.github.dockerjava.api.model.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Register extends BaseTest {
    WebDriver driver;
    RegisterPageActions registerPageActions;
    String userName;
    String password;

    @BeforeClass
    public void beforeClass() {
        DriverManager.getBrowserDriver("chrome");
        registerPageActions = new RegisterPageActions();
    }

    @Test
    public void Create_new_account() throws InterruptedException {
        registerPageActions.inputToEmailTextBox("doanvanhungcntt@gmail.com");
        registerPageActions.clickSubmitButton();
        Thread.sleep(1000);
        userName = registerPageActions.getUserInformation("User ID :");
        password = registerPageActions.getUserInformation("Password :");
        System.out.println("user name is: " + userName + " and password is: " + password);

        registerPageActions.scrollToPageFooter();
        Thread.sleep(5000);
    }

    @AfterClass
    public void afterClass(){
        DriverManager.closeBrowser();
    }
}
