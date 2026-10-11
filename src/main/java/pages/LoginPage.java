package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
        sendKeys(byTxtUserLogin, account);
    }

    public void enterPassword(String password) {
        sendKeys(byTxtPasswordLogin, password);
    }

    public void clickLogin() {
        click(byBtnLogin);
    }

    public String getSuccessMessage() {
        String actualLoginMsg = getText(byLblLoginSuccess);
        return actualLoginMsg;
    }

    //High level action (Business action)
    public void login(String account, String password) {
        enterAccount(account);
        enterPassword(password);
        clickLogin();
    }
}
