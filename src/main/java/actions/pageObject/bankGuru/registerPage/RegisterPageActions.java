package actions.pageObject.bankGuru.registerPage;

import actions.commons.BasePage;


public class RegisterPageActions extends BasePage {
    RegisterPageUI registerPageUI;
    public RegisterPageActions(){
        registerPageUI = new RegisterPageUI();
    }
    public void inputToEmailTextBox(String email){
        registerPageUI.emailTextbox.sendKeys(email);
    }

    public void clickSubmitButton(){
        registerPageUI.submitButton.click();
    }

    public String getUserInformation(String value){
        return getWebElement(registerPageUI.textboxInTable,value).getText();
    }

    public void scrollToPageFooter(){
       scrollToBottomPage();
    }


}
