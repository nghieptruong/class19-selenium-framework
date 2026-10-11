package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
        sendKeys(byAccountTextbox, account);
    }

    public void enterPassword(String password) {
        sendKeys(byTxtPassword, password);
    }

    public void enterConfirmPassword(String password) {
        sendKeys(byTxtConfirmPassword, password);
    }

    public void enterFullName(String fullName) {
        sendKeys(byTxtFullname, fullName);
    }

    public void enterEmail(String email) {
        sendKeys(byTxtEmail, email);
    }

    public void clickRegister() {
        click(byBtnRegister);
    }

    public String getSuccessMessage() {
        String actualLoginMsg = getText(byLblRegisterSuccess);
        return actualLoginMsg;
    }

    public void waitDialogDisappear() {
        waitInvisibilityOfElemementLocated(byLblRegisterSuccess);
    }
}
