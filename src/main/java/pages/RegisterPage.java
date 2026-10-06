package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage extends CommonPage {

    private By byAccountTextbox;
    private By byTxtPassword;
    private By byTxtConfirmPassword;
    private By byTxtFullname;
    private By byTxtEmail;
    private By byBtnRegister;
    private By byLblRegisterSuccess;
    private WebDriver driver;

    public RegisterPage(WebDriver driver) {
        super(driver);
        this.byAccountTextbox = By.id("taiKhoan");
        this.byTxtPassword = By.name("matKhau");
        this.byTxtConfirmPassword = By.id("confirmPassWord");
        this.byTxtFullname = By.id("hoTen");
        this.byTxtEmail = By.id("email");
        this.byBtnRegister = By.xpath("//button[span[text()='Đăng ký']]");
        this.byLblRegisterSuccess = By.id("swal2-title");
        this.driver = driver;
    }

    public void enterAccount(String account) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement accountTextbox = wait.until(ExpectedConditions.visibilityOfElementLocated(byAccountTextbox));
        accountTextbox.sendKeys(account);
    }

    public void enterPassword(String password) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement passwordTextbox = wait.until(ExpectedConditions.visibilityOfElementLocated(byTxtPassword));
        passwordTextbox.sendKeys(password);
    }

    public void enterConfirmPassword(String password) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement confirmPasswordTextbox = wait.until(ExpectedConditions.visibilityOfElementLocated(byTxtConfirmPassword));
        confirmPasswordTextbox.sendKeys(password);
    }

    public void enterFullName(String fullName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement fullnameTextbox = wait.until(ExpectedConditions.visibilityOfElementLocated(byTxtFullname));
        fullnameTextbox.sendKeys(fullName);
    }

    public void enterEmail(String email) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement emailTextbox = wait.until(ExpectedConditions.visibilityOfElementLocated(byTxtEmail));
        emailTextbox.sendKeys(email);
    }

    public void clickRegister() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement btnRegister = wait.until(ExpectedConditions.visibilityOfElementLocated(byBtnRegister));
        btnRegister.click();
    }

    public String getSuccessMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement lblLoginSuccess = wait.until(ExpectedConditions.visibilityOfElementLocated(byLblRegisterSuccess));
        String actualLoginMsg = lblLoginSuccess.getText();
        return actualLoginMsg;
    }

    public void waitDialogDisappear() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(byLblRegisterSuccess));
    }
}
