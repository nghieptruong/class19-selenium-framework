package pages;

import org.openqa.selenium.WebDriver;
import pages.components.TopNavigationBar;

public class CommonPage extends BasePage {

    private TopNavigationBar topNavigationBar;

    public CommonPage(WebDriver driver) {
        super(driver);
        this.topNavigationBar = new TopNavigationBar(driver);
    }

    public TopNavigationBar getTopNavigationBar() {
        return this.topNavigationBar;
    }
}
