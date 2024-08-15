package actions.pageObject.bankGuru.registerPage;

import actions.commons.BasePage;
import io.qameta.allure.Step;


public class RegisterPageActions extends BasePage {
    RegisterPageUI registerPageUI;
    public RegisterPageActions(){
        registerPageUI = new RegisterPageUI();
    }
    @Step("Input to Email Text box Value: {0}")
    public void inputToEmailTextBox(String email){
        log.info("Input to Email textbox value: " + email);
        registerPageUI.emailTextbox.sendKeys(email);
    }
    @Step("Click to Submit button")
    public void clickSubmitButton(){
        registerPageUI.submitButton.click();
    }

    @Step("Get user information of {0} text box")
    public String getUserInformation(String value){
        return getWebElement(registerPageUI.TEXTBOX_IN_TABLE,value).getText();
    }
    @Step("Scroll to page footer")
    public void scrollToPageFooter(){
       scrollToBottomPage();
    }


}
