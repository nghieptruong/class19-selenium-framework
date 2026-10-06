package pages;

import constants.ConstantTimeout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    private WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriverWait getWebDriverWait(long timeout) {
        return new WebDriverWait(driver, Duration.ofSeconds(timeout));
    }

    public WebElement waitVisibilityOfElementLocated(By locator, long timeout) {
        WebDriverWait wait = getWebDriverWait(timeout);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitVisibilityOfElementLocated(By locator) {
        return waitVisibilityOfElementLocated(locator, ConstantTimeout.DEFAULT_TIMEOUT);
    }

    public WebElement waitClickable(By locator, long timeout) {
        WebDriverWait wait = getWebDriverWait(timeout);
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public WebElement waitClickable(By locator) {
        return waitClickable(locator, ConstantTimeout.DEFAULT_TIMEOUT);
    }

    public void sendKeys(By locator, String value, long timeout) {
        WebElement element = waitVisibilityOfElementLocated(locator, timeout);
        element.sendKeys(value);
    }

    public void sendKeys(By locator, String value) {
        sendKeys(locator, value, ConstantTimeout.DEFAULT_TIMEOUT);
    }

    public void click(By locator, long timeout) {
        WebElement element = waitClickable(locator, timeout);
        element.click();
    }

    public void click(By locator) {
        click(locator, ConstantTimeout.DEFAULT_TIMEOUT);
    }
}
