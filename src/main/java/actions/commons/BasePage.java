package actions.commons;

import actions.pageObject.bankGuru.commonPage.CommonPage;
import actions.pageObject.bankGuru.commonPage.CommonUI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Time;
import java.time.Duration;
import java.util.List;

public class BasePage {
    private final int shotTimeOut = GlobalVariables.SORT_TIMEOUT;
    private final int longTimeOut = GlobalVariables.LONG_TIMEOUT;

    protected Logger log = LogManager.getLogger(getClass());

    protected By getByDynamicXpath(String locator, String... value) {
        if (locator.startsWith("xpath=") || locator.startsWith("Xpath=") || locator.startsWith("XPATH=")) {
            log.info("Dynamic xpath is: " +String.format(locator.substring(6), (Object[]) value));
            return By.xpath(String.format(locator.substring(6), (Object[]) value));
        } else {
            throw new RuntimeException("not valid Xpath String");
        }
    }

    protected By getByLocator(String locator) {
        By by;
        if (locator.startsWith("id=") || locator.startsWith("Id=") || locator.startsWith("ID=")) {
            by = By.id(locator.substring(3));
        } else if (locator.startsWith("css=") || locator.startsWith("Css=") || locator.startsWith("CSS=")) {
            by = By.cssSelector(locator.substring(4));
        } else if (locator.startsWith("class=") || locator.startsWith("Class=") || locator.startsWith("CLASS=")) {
            by = By.className(locator.substring(6));
        } else if (locator.startsWith("text=") || locator.startsWith("Text=") || locator.startsWith("TEXT=")) {
            by = By.linkText(locator.substring(5));
        } else if (locator.startsWith("xpath=") || locator.startsWith("Xpath=") || locator.startsWith("XPATH=")) {
            by = By.xpath(locator.substring(6));
        } else {
            throw new RuntimeException("Don't have type of locator of wrong format");
        }
        return by;
    }

    protected WebElement getWebElement(String locator) {
        return DriverManager.getDriver().findElement(getByLocator(locator));
    }


    protected WebElement getWebElement(String locator, String... dynamicValues) {
        return DriverManager.getDriver().findElement(getByDynamicXpath(locator, dynamicValues));
    }

    protected List<WebElement> getWebElements(String locator) {
        return DriverManager.getDriver().findElements(getByLocator(locator));
    }

    protected void openUrl(String url) {
        DriverManager.getDriver().get(url);
    }

    protected void getPageUrl(String url) {
        DriverManager.getDriver().getCurrentUrl();
    }

    protected void clickToElement(String locator) {
        getWebElement(locator).click();
    }

    protected void clickToElement(String locator, String... dynamicValues) {
        getWebElement(locator, dynamicValues).click();
    }

    protected void clickToElement(WebElement element) {
        element.click();
    }

    protected void inputToElement(String locator, String valueInput) {
        getWebElement(locator).sendKeys(valueInput);
    }

    protected void inputToElement(String locator, String valueInput, String... dynamicValues) {
        getWebElement(locator, dynamicValues).sendKeys(valueInput);
    }

    protected void inputToElement(WebElement element, String valueInput) {
        element.sendKeys(valueInput);
    }

    protected String getElementText(String locator) {
        return getWebElement(locator).getText();
    }

    protected String getElementText(String locator, String... dynamicValues) {
        return getWebElement(locator, dynamicValues).getText();
    }

    protected String getElementText(WebElement element) {
        return element.getText();
    }

    protected String getElementValue(String locator) {
        return getWebElement(locator).getAttribute("value");
    }

    protected String getElementValue(String locator, String... dynamicValues) {
        return getWebElement(locator, dynamicValues).getAttribute("value");
    }

    protected String getElementValue(WebElement element) {
        return element.getAttribute("value");
    }

    protected String getElementByAttribute(String locator, String attribute) {
        return getWebElement(locator).getAttribute(attribute);
    }

    protected String getElementByAttribute(String locator, String attribute, String... dynamicValues) {
        return getWebElement(locator, dynamicValues).getAttribute(attribute);
    }

    protected String getElementByAttribute(WebElement element, String attribute) {
        return element.getAttribute(attribute);
    }

    protected WebElement waitForElementVisible(String locator) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(shotTimeOut));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(locator)));
    }

    protected WebElement waitForElementVisible(String locator, String... dynamicValues) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(shotTimeOut));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(getByDynamicXpath(locator, dynamicValues)));
    }

    protected void waitForElementInVisible(String locator, String... dynamicValues) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(shotTimeOut));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(getByDynamicXpath(locator, dynamicValues)));
    }


    protected boolean isElementDisplay(String locator) {
        try {
            return getWebElement(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    protected boolean isElementDisplay(String locator, String... dynamicValues) {
        try {
            return getWebElement(locator, dynamicValues).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    protected void hoverMouseToElement(String locator) {
        Actions action = new Actions(DriverManager.getDriver());
        action.moveToElement(getWebElement(locator));
    }

    protected void hoverMouseToElement(String locator, String... dynamicValues) {
        Actions action = new Actions(DriverManager.getDriver());
        action.moveToElement(getWebElement(locator, dynamicValues));
    }

    protected boolean isElementEnable(String locator) {
        return getWebElement(locator).isEnabled();
    }

    protected boolean isElementEnable(String locator, String... dynamicValues) {
        return getWebElement(locator, dynamicValues).isEnabled();
    }

    protected boolean isElementSelected(String locator) {
        return getWebElement(locator).isSelected();
    }

    protected boolean isElementSelected(String locator, String... dynamicValues) {
        return getWebElement(locator, dynamicValues).isSelected();
    }

    protected void switchToFrame(String locator) {
        DriverManager.getDriver().switchTo().frame(getWebElement(locator));
    }

    protected void switchToDefaultContent() {
        DriverManager.getDriver().switchTo().defaultContent();
    }

    protected void pressKeyToElement(String locator, String value) {
        Actions action = new Actions(DriverManager.getDriver());
        action.sendKeys(getWebElement(locator), value).perform();
    }

    protected void scrollToBottomPage() {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) DriverManager.getDriver();
        jsExecutor.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }

    protected void clickToElementByJS(String locator) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) DriverManager.getDriver();
        jsExecutor.executeScript("arguments[0].click();", getWebElement(locator));
    }

    protected void waitForElementClickable(String locator) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(shotTimeOut));
        wait.until(ExpectedConditions.elementToBeClickable(getByLocator(locator)));
    }

    protected void uploadMultipleFiles(String... fileName) {

        String fullNameFile = "";
        for (String file : fileName) {
            fullNameFile = fullNameFile + GlobalVariables.UPLOAD_FILE_FOLDER + file + "\n";
        }
        getWebElement(CommonUI.UPLOAD_FILE).sendKeys(fullNameFile.trim());
    }

    protected boolean isElementNotDisplayed(String locator){
        List<WebElement> elements = getWebElements(locator);
        if(elements.isEmpty()){
            return true;
        }else if (!elements.get(0).isDisplayed()){
            return true;
        }else {
            return false;
        }
    }


}
