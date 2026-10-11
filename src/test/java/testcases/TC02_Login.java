package testcases;

import base.BaseTest;
import drivers.DriverManager;
import drivers.DriverManagerFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class TC02_Login extends BaseTest {

    @Test
    public void TC02_Verify_Login_Successfully() {

        driver.get("https://demo1.cybersoft.edu.vn");

        String account = "50a4dea9-1f49-4d51-8df7-8058ab3eea39";
        String password = "123456";

        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);

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


    }

}
