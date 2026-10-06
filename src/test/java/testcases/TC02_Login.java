package testcases;

import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;

public class TC02_Login {

    @Test
    public void TC02_Verify_Login_Successfully() {

        ChromeOptions options = new ChromeOptions();
        //Tat hien thi automation bar
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);
        WebDriver chromeDriver = new ChromeDriver(options);

        chromeDriver.manage().window().maximize(); // maximize browser
        chromeDriver.get("https://demo1.cybersoft.edu.vn");

        String account = "50a4dea9-1f49-4d51-8df7-8058ab3eea39";
        String password = "123456";

        HomePage homePage = new HomePage(chromeDriver);
        LoginPage loginPage = new LoginPage(chromeDriver);

        //Pre-condition: User is at Login page (navigate to Login page)
        homePage.getTopNavigationBar().navigateToLoginPage();

        //Step 1. Enter user login
        loginPage.enterAccount(account);

        //Step 2. Enter password login
        loginPage.enterPassword(password);

        //Step 3. Click 'Dang Nhap'
        loginPage.clickLogin();

        //Step 4: Verify login successfully
        //VP: Verify 'Dang nhap thanh cong' message displays
        String actualLoginMsg = loginPage.getSuccessMessage();
        Assert.assertEquals(actualLoginMsg, "Đăng nhập thành công", "Login Successful Message");

        //VP: User displays on the top right

        //Close browser & kill process chromedriver
        chromeDriver.quit();

    }

}
