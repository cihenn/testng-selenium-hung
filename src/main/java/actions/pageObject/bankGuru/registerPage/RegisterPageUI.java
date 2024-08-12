package actions.pageObject.bankGuru.registerPage;

import actions.commons.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPageUI {

    public RegisterPageUI(){
        PageFactory.initElements(DriverManager.getDriver(),this);
    }

    @FindBy(xpath = "//input[@name='emailid']")
    public WebElement emailTextbox;

    @FindBy(xpath = "//input[@type='submit' and @name='btnLogin']")
    public WebElement submitButton;

    //User ID :  , Password :
    public String textboxInTable = "Xpath=//tr//td[text()='%s']/following-sibling::td";

}
