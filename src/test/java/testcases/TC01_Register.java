package testcases;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.RegisterPage;

import java.util.UUID;

public class TC01_Register {

    @Test
    public void TC01_Verify_Register_Successfully() {

        ChromeOptions options = new ChromeOptions();
        //Tat hien thi automation bar
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);
        WebDriver chromeDriver = new ChromeDriver(options);

        chromeDriver.manage().window().maximize(); // maximize browser
        chromeDriver.get("https://demo1.cybersoft.edu.vn"); // --> home

        HomePage homePage = new HomePage(chromeDriver);
        LoginPage loginPage = new LoginPage(chromeDriver);
        RegisterPage registerPage = new RegisterPage(chromeDriver);

        //Pre-condition: User is at Register page (Navigate to Register page)
        homePage.getTopNavigationBar().navigateToRegisterPage();

        //Step 1: Enter account textbox
        String account = UUID.randomUUID().toString();
        String password = "123456";
        String email = account + "@example.com";
        System.out.println("Account: " + account);
        System.out.println("Email: " + email);

        registerPage.enterAccount(account);

        //Step 2: Enter password
        registerPage.enterPassword(password);

        //Step 3: Re-enter password
        registerPage.enterConfirmPassword(password);

        //Step 4: Enter full name
        registerPage.enterFullName("John Johnson");

        //Step 5: Enter email
        registerPage.enterEmail(email);

        //Step 6: Click register
        registerPage.clickRegister();

        //Step 7: Verify user register successfully
        //VP1 (Verify Point): Verify 'Dang ky thanh cong' message displays
        String actualRegisterMsg = registerPage.getSuccessMessage();
        Assert.assertEquals(actualRegisterMsg, "Đăng ký thành công", "Register Successful Message");

        //Wait dialog disappear
        registerPage.waitDialogDisappear();

        //VP2: Verify new user login successfully
        //1. Click 'Dang Nhap' link
        registerPage.getTopNavigationBar().navigateToLoginPage();

        //Low level action (action nho le, 1 hay 2 thao tac)
        //2. Login with registered account
        loginPage.login(account, password);

        //VP: Verify 'Dang nhap thanh cong' message displays
        String actualLoginMsg = loginPage.getSuccessMessage();
        Assert.assertEquals(actualLoginMsg, "Đăng nhập thành công", "Login Successful Message");

        //Close browser & kill process chromedriver
        chromeDriver.quit();
    }
}
