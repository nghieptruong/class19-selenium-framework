package pages.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

import java.time.Duration;

public class TopNavigationBar extends BasePage {

    private By byLnkRegister;
    private By byLnkLogin;
    private WebDriver driver;

    public TopNavigationBar(WebDriver driver) {
        super(driver);
        this.byLnkRegister = By.xpath("//a[h3[text()='Đăng Ký']]");
        this.byLnkLogin = By.xpath("//a[h3[text()='Đăng Nhập']]");
        this.driver = driver;
    }

    public void navigateToLoginPage() {
        click(byLnkLogin);
    }

    public void navigateToRegisterPage() {
        click(byLnkRegister);
    }
}
