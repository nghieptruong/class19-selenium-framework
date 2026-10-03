package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC02_Login {

    @Test
    public void TC02_Verify_Login_Successfully() {

        ChromeOptions options = new ChromeOptions();
        //Tat hien thi automation bar
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);
        WebDriver chromeDriver = new ChromeDriver(options);

        //khai bao explicit wait
//        WebDriverWait wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(10));
        FluentWait<WebDriver> wait = new FluentWait<>(chromeDriver);
        wait.pollingEvery(Duration.ofSeconds(1));
        wait.withTimeout(Duration.ofSeconds(10));
        wait.ignoring(NotFoundException.class);

        chromeDriver.manage().window().maximize(); // maximize browser
        chromeDriver.get("https://demo1.cybersoft.edu.vn/sign-in");

        String account = "50a4dea9-1f49-4d51-8df7-8058ab3eea39";

        //Step 1. Enter user login
        By byTxtUserLogin = By.id("taiKhoan");
        WebElement txtUserLogin = wait.until(ExpectedConditions.visibilityOfElementLocated(byTxtUserLogin));
        txtUserLogin.sendKeys(account);

        //Step 2. Enter password login
        By byTxtPasswordLogin = By.id("matKhau");
        WebElement txtPasswordLogin = wait.until(ExpectedConditions.visibilityOfElementLocated(byTxtPasswordLogin));
        txtPasswordLogin.sendKeys("123456");

        //Step 3. Click 'Dang Nhap'
        By byBtnLogin = By.xpath("//button[span[text()='Đăng nhập']]");
        WebElement btnLogin = wait.until(ExpectedConditions.elementToBeClickable(byBtnLogin));
        btnLogin.click();

        //Step 4: Verify login successfully
        //VP: Verify 'Dang nhap thanh cong' message displays
        By byLblLoginSuccess = By.id("swal2-title");
        WebElement lblLoginSuccess = wait.until(ExpectedConditions.visibilityOfElementLocated(byLblLoginSuccess));
        String actualLoginMsg = lblLoginSuccess.getText();
        Assert.assertEquals(actualLoginMsg, "Đăng nhập thành công", "Login Successful Message");

        //VP: User displays on the top right

        //Close browser & kill process chromedriver
        chromeDriver.quit();

    }

}
