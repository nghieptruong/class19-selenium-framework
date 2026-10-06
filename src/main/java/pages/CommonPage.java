package pages;

import org.openqa.selenium.WebDriver;
import pages.components.TopNavigationBar;

public class CommonPage {

    private TopNavigationBar topNavigationBar;

    public CommonPage(WebDriver driver) {
        this.topNavigationBar = new TopNavigationBar(driver);
    }

    public TopNavigationBar getTopNavigationBar() {
        return this.topNavigationBar;
    }
}
