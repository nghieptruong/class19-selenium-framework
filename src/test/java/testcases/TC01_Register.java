package testcases;


import base.BaseTest;
import drivers.DriverManager;
import drivers.DriverManagerFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.RegisterPage;
import reports.ExtentReportManager;

import java.util.UUID;

public class TC01_Register extends BaseTest {

    @Test
    public void TC01_Verify_Register_Successfully() {

        driver.get("https://demo1.cybersoft.edu.vn"); // --> home

        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RegisterPage registerPage = new RegisterPage(driver);

        //Pre-condition: User is at Register page (Navigate to Register page)
        logger.info("Pre-condition: User is at Register page (Navigate to Register page)");
        ExtentReportManager.info("Pre-condition: User is at Register page (Navigate to Register page)");
        homePage.getTopNavigationBar().navigateToRegisterPage();

        //Step 1: Enter account textbox
        logger.info("Step 1: Enter account textbox");
        ExtentReportManager.info("Step 1: Enter account textbox");
        String account = UUID.randomUUID().toString();
        String password = "123456";
        String email = account + "@example.com";
        logger.info("Account: " + account);
        logger.info("Email: " + email);

        registerPage.enterAccount(account);

        //Step 2: Enter password
        logger.info("Step 2: Enter password");
        ExtentReportManager.info("Step 2: Enter password");
        registerPage.enterPassword(password);

        //Step 3: Re-enter password
        logger.info("Step 3: Re-enter password");
        ExtentReportManager.info("Step 3: Re-enter password");
        registerPage.enterConfirmPassword(password);

        //Step 4: Enter full name
        logger.info("Step 4: Enter full name");
        ExtentReportManager.info("Step 4: Enter full name");
        registerPage.enterFullName("John Johnson");

        //Step 5: Enter email
        logger.info("Step 5: Enter email");
        ExtentReportManager.info("Step 5: Enter email");
        registerPage.enterEmail(email);

        //Step 6: Click register
        logger.info("Step 6: Click register");
        ExtentReportManager.info("Step 6: Click register");
        registerPage.clickRegister();

        //Step 7: Verify user register successfully
        logger.info("Step 7: Verify user register successfully");
        ExtentReportManager.info("Step 7: Verify user register successfully");
        //VP1 (Verify Point): Verify 'Dang ky thanh cong' message displays
        logger.info("VP1 (Verify Point): Verify 'Dang ky thanh cong' message displays");
        ExtentReportManager.info("VP1 (Verify Point): Verify 'Dang ky thanh cong' message displays");
        String actualRegisterMsg = registerPage.getSuccessMessage();
        Assert.assertEquals(actualRegisterMsg, "Đăng ký thành công123456", "Register Successful Message");

        //Wait dialog disappear
        logger.info("Wait dialog disappear");
        ExtentReportManager.info("Wait dialog disappear");
        registerPage.waitDialogDisappear();

        //VP2: Verify new user login successfully
        logger.info("VP2: Verify new user login successfully");
        ExtentReportManager.info("VP2: Verify new user login successfully");
        //1. Click 'Dang Nhap' link
        logger.info("1. Click 'Dang Nhap' link");
        ExtentReportManager.info("1. Click 'Dang Nhap' link");
        registerPage.getTopNavigationBar().navigateToLoginPage();

        //Low level action (action nho le, 1 hay 2 thao tac)
        //2. Login with registered account
        logger.info("2. Login with registered account");
        ExtentReportManager.info("2. Login with registered account");
        loginPage.login(account, password);

        //VP: Verify 'Dang nhap thanh cong' message displays
        logger.info("VP: Verify 'Dang nhap thanh cong' message displays");
        ExtentReportManager.info("VP: Verify 'Dang nhap thanh cong' message displays");
        String actualLoginMsg = loginPage.getSuccessMessage();
        Assert.assertEquals(actualLoginMsg, "Đăng nhập thành công", "Login Successful Message");

    }
}
