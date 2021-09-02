import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

public class Main {
    static WebDriver driver;
    static String browser;

    public static void main(String[] args) throws Exception {
        setBrowser();
        driver = setBrowserConfig(browser);
        runTest(driver);

    }

    public static void setBrowser() {
        browser = "CHROME";
    }

    public static WebDriver setBrowserConfig(String browser) {
        WebDriver driver = null;
        if(browser.equals("CHROME")) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\BS0493\\OneDrive\\Documents\\TestProject\\wt-automation-test\\drivers\\chromedriver.exe");
            driver = new ChromeDriver();
        }
        return driver;
    }

    public static void runTest(WebDriver driver) throws Exception {
        driver.get("https://qatest.marcombox.com/");
        TestCase1 testCase1 = new TestCase1(driver);
        testCase1.init();
        testCase1.run();
        driver.quit();
    }
}
