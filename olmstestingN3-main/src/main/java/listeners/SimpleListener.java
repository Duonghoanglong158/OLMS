package listeners;

import drivers.DriverFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.sql.Driver;
import java.util.Date;

public class SimpleListener implements ITestListener {
    private static final Logger logger = LogManager.getLogger(SimpleListener.class);

    public void onTestStart(org.testng.ITestResult result) {
        logger.info("Test case started: {}", result.getName());

    }

    public void onTestSuccess(org.testng.ITestResult result) {
        logger.info("Test case passed: {}", result.getName());
    }

    public void onTestFailure(org.testng.ITestResult result) {
        System.out.println("Screenshot captured for test case: " + result.getName());

        Object currentClass = result.getInstance();
        WebDriver driver = DriverFactory.getDriver();

        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            Date date = new Date();
            String filePath = "." + File.separator + "screenshots" + File.separator + result.getName() +"_"+date.getTime()+ ".png";
            File destFile = new File(filePath);
            destFile.getParentFile().mkdirs();

            FileHandler.copy(srcFile, destFile);
            System.out.println("Screenshot saved: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onTestSkipped(org.testng.ITestResult result) {
        logger.warn("Test case skipped: {}", result.getName());
        if (result.getThrowable() != null) {
            logger.warn("Reason for skip: {}", result.getThrowable().getMessage());
        }
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        logger.warn("Test case failed but within success percentage: {}", result.getName());
    }

    public void onTestFailedWithTimeout(ITestResult result) {
        logger.error("Test case failed due to timeout: {}", result.getName());
    }

    public void onStart(org.testng.ITestContext context) {
        logger.info("Test suite started: {}", context.getName());
    }

    public void onFinish(org.testng.ITestContext context) {
        logger.info("Test suite finished: {}", context.getName());
    }
}
