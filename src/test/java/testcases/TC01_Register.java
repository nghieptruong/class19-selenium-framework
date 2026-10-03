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
import java.util.UUID;

public class TC01_Register {

    @Test
    public void TC01_Verify_Register_Successfully() {

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
        chromeDriver.get("https://demo1.cybersoft.edu.vn/sign-up");

        //Step 1: Enter account textbox
        By byAccountTextbox = By.id("taiKhoan");
        WebElement accountTextbox = wait.until(ExpectedConditions.visibilityOfElementLocated(byAccountTextbox));

        String account = UUID.randomUUID().toString();
        String email = account + "@example.com";
        System.out.println("Account: " + account);
        System.out.println("Email: " + email);

        accountTextbox.sendKeys(account);

        //Step 2: Enter password
        By byTxtPassword = By.name("matKhau");
        WebElement txtPassword = wait.until(ExpectedConditions.visibilityOfElementLocated(byTxtPassword));
        txtPassword.sendKeys("123456");

        //Step 3: Re-enter password
        By byTxtConfirmPassword = By.id("confirmPassWord");
        WebElement txtConfirmPassword = wait.until(ExpectedConditions.visibilityOfElementLocated(byTxtConfirmPassword));
        txtConfirmPassword.sendKeys("123456");

        //Step 4: Enter full name
        By byTxtFullname = By.id("hoTen");
        WebElement txtFullName = wait.until(ExpectedConditions.visibilityOfElementLocated(byTxtFullname));
        txtFullName.sendKeys("John Johnson");

        //Step 5: Enter email
        By byTxtEmail = By.id("email");
        WebElement txtEmail = wait.until(ExpectedConditions.visibilityOfElementLocated(byTxtEmail));
        txtEmail.sendKeys(email);

        //Step 6: Click register
        By byBtnRegister = By.xpath("//button[span[text()='Đăng ký']]");
        WebElement btnRegister = wait.until(ExpectedConditions.elementToBeClickable(byBtnRegister));
        btnRegister.click();

        //Step 7: Verify user register successfully
        //VP1 (Verify Point): Verify 'Dang ky thanh cong' message displays
        By byLblRegisterSuccess = By.id("swal2-title");
        WebElement lblRegisterSuccess = wait.until(ExpectedConditions.visibilityOfElementLocated(byLblRegisterSuccess));
        String actualRegisterMsg = lblRegisterSuccess.getText();
        Assert.assertEquals(actualRegisterMsg, "Đăng ký thành công", "Register Successful Message");

        //Wait dialog disappear
        wait.until(ExpectedConditions.invisibilityOfElementLocated(byLblRegisterSuccess));

        //VP2: Verify new user login successfully
        //1. Click 'Dang Nhap' link
        By byLnkLogin = By.xpath("//a[h3[text()='Đăng Nhập']]");
        WebElement lnkLogin = wait.until(ExpectedConditions.visibilityOfElementLocated(byLnkLogin));
        lnkLogin.click();

        //2. Enter user login
        By byTxtUserLogin = By.id("taiKhoan");
        WebElement txtUserLogin = wait.until(ExpectedConditions.visibilityOfElementLocated(byTxtUserLogin));
        txtUserLogin.sendKeys(account);

        //3. Enter password login
        By byTxtPasswordLogin = By.id("matKhau");
        WebElement txtPasswordLogin = wait.until(ExpectedConditions.visibilityOfElementLocated(byTxtPasswordLogin));
        txtPasswordLogin.sendKeys("123456");

        //4. Click 'Dang Nhap'
        By byBtnLogin = By.xpath("//button[span[text()='Đăng nhập']]");
        WebElement btnLogin = wait.until(ExpectedConditions.elementToBeClickable(byBtnLogin));
        btnLogin.click();

        //VP: Verify 'Dang nhap thanh cong' message displays
        By byLblLoginSuccess = By.id("swal2-title");
        WebElement lblLoginSuccess = wait.until(ExpectedConditions.visibilityOfElementLocated(byLblLoginSuccess));
        String actualLoginMsg = lblLoginSuccess.getText();
        Assert.assertEquals(actualLoginMsg, "Đăng nhập thành công", "Login Successful Message");

        //Close browser & kill process chromedriver
        chromeDriver.quit();
    }
}
