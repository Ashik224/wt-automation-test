import helpers.TestHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.AssetPage;
import pages.DashboardPage;
import pages.LoginPage;

public class TestCase1 {
    WebDriver driver;
    TestHelper helper;

    LoginPage loginPage;
    DashboardPage dashboardPage;
    AssetPage assetPage;

    public void init() {
//        System.setProperty("webdriver.gecko.driver", "/home/aljubaer/IdeaProjects/AutomationTest/drivers/geckodriver");
        System.setProperty("webdriver.chrome.driver", "/home/aljubaer/IdeaProjects/AutomationTest/drivers/chromedriver");
        driver = new ChromeDriver();
        helper = new TestHelper(driver);
        driver.get("https://qatest.marcombox.com/");
    }

    public void run() throws InterruptedException {
        loginPage = new LoginPage(driver, helper);
        loginPage.textBoxEmail();
        loginPage.buttonSubmitEmail();
        loginPage.textBoxPassword();
        loginPage.buttonLogin();

        dashboardPage = new DashboardPage(driver, helper);
        dashboardPage.dropDownDam();
        dashboardPage.dropDownMenuAsset();

        assetPage = new AssetPage(driver, helper);
        assetPage.buttonUpload();
        assetPage.buttonBrowseUpload();
    }
}
