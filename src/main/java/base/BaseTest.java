package base;

import drivers.DriverManager;
import drivers.DriverManagerFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import reports.ExtentReportManager;

import java.lang.reflect.Method;

public class BaseTest {

    protected Logger logger = LogManager.getLogger(getClass());
    protected WebDriver driver;

    @BeforeSuite
    public void beforeSuite() {
        logger.info("Before suite executing...");
        ExtentReportManager.initializeExtentReports();
    }

    @BeforeTest
    public void beforeTest() {
        logger.info("Before test executing...");
    }

    @BeforeMethod
    public void beforeMethod(Method method) {
        logger.info("Before method executing...");
        ExtentReportManager.createTest(method.getName());
        DriverManager driverManager = DriverManagerFactory.getDriverManager("chrome");
        driverManager.createDriver();
        driver = driverManager.getDriver();
        driver.manage().window().maximize(); // maximize browser
    }

    @AfterMethod
    public void afterMethod(ITestResult result) {
        logger.info("After method executing...");
        if(result.getStatus() == ITestResult.FAILURE) {
            ExtentReportManager.captureScreenshot(driver, result.getTestName());
        }
        driver.quit();
    }

    @AfterTest
    public void afterTest() {
        logger.info("After test executing...");
    }

    @AfterSuite
    public void afterSuite() {
        logger.info("After suite executing...");
        ExtentReportManager.flushReports();
    }
}
