package pages.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TopNavigationBar {

    private By byLnkRegister;
    private By byLnkLogin;
    private WebDriver driver;

    public TopNavigationBar(WebDriver driver) {
        this.byLnkRegister = By.xpath("//a[h3[text()='Đăng Ký']]");
        this.byLnkLogin = By.xpath("//a[h3[text()='Đăng Nhập']]");
        this.driver = driver;
    }

    public void navigateToLoginPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement lnkLogin = wait.until(ExpectedConditions.visibilityOfElementLocated(byLnkLogin));
        lnkLogin.click();
    }

    public void navigateToRegisterPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement lnkRegister = wait.until(ExpectedConditions.visibilityOfElementLocated(byLnkRegister));
        lnkRegister.click();
    }
}
