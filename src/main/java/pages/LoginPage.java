package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends CommonPage {

    //Thuoc tinh (private)
    private By byTxtUserLogin;
    private By byTxtPasswordLogin;
    private By byBtnLogin;
    private By byLblLoginSuccess;
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        super(driver);
        this.byTxtUserLogin = By.id("taiKhoan");
        this.byTxtPasswordLogin = By.id("matKhau");
        this.byBtnLogin = By.xpath("//button[span[text()='Đăng nhập']]");
        this.byLblLoginSuccess = By.id("swal2-title");
        this.driver = driver;
    }

    //Phuong thuc (method)
    public void enterAccount(String account) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement txtUserLogin = wait.until(ExpectedConditions.visibilityOfElementLocated(byTxtUserLogin));
        txtUserLogin.sendKeys(account);
    }

    public void enterPassword(String password) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement txtPasswordLogin = wait.until(ExpectedConditions.visibilityOfElementLocated(byTxtPasswordLogin));
        txtPasswordLogin.sendKeys(password);
    }

    public void clickLogin() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement btnLogin = wait.until(ExpectedConditions.elementToBeClickable(byBtnLogin));
        btnLogin.click();
    }

    public String getSuccessMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement lblLoginSuccess = wait.until(ExpectedConditions.visibilityOfElementLocated(byLblLoginSuccess));
        String actualLoginMsg = lblLoginSuccess.getText();
        return actualLoginMsg;
    }

    //High level action (Business action)
    public void login(String account, String password) {
        enterAccount(account);
        enterPassword(password);
        clickLogin();
    }
}
