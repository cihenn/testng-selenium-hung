package actions.reportConfig;

import actions.reportConfig.AllureManager;
import com.aventstack.extentreports.Status;
import lombok.extern.java.Log;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class TestListener implements ITestListener {
    Logger log = LogManager.getLogger(this.getClass());
    public String getTestName(ITestResult result){
        return result.getTestName() !=null ? result.getTestName(): result.getMethod().getConstructorOrMethod().getName();
    }

    public String getTestDescription(ITestResult result){
        return result.getMethod().getDescription() != null ? result.getMethod().getDescription() : getTestName(result);
    }

    @Override
    public void onStart(ITestContext context) {
        ExtentReportManager.getExtentReports().createTest(context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        log.info("Eng testing " + context.getName());
        ExtentReportManager.getExtentReports().flush();
    }

    @Override
    public void onTestStart(ITestResult result) {
        log.info("Running testcase "+ result.getName());

        //Bắt đầu ghi 1 TCs mới vào extent report
        ExtentTestManager.saveToReport(getTestName(result), getTestDescription(result));
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        log.info("Testcase " +result.getName()+ "is passed.");

        //Extent report
        ExtentTestManager.logMessage(Status.PASS,result.getName() + "is passed.");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        log.error("Test case" +result.getName() + "is failed");


        log.error("Test case " + result.getName() + " is failed");
        log.error(result.getThrowable().toString());
        AllureManager.saveTextLog(result.getName() + "is failed");
        AllureManager.saveScreenshotPNG();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
    }


}
