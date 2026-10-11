package drivers;

public class DriverManagerFactory {

    public static DriverManager getDriverManager(String browser) {
        switch(browser.toLowerCase()) {
            case "chrome":
                return new ChromeDriverManager();
            case "firefox":
                return new FirefoxDriverManager();
            case "edge":
                return new EdgeDriverManager();
            case "safari":
                return new SafariDriverManager();
            default:
                return null;
        }
    }
}
