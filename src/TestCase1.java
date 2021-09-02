import helpers.TestHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.AssetPage;
import pages.DashboardPage;
import pages.FileDetailsPage;
import pages.LoginPage;

import java.io.IOException;

public class TestCase1 {
    WebDriver driver;
    TestHelper helper;

    LoginPage loginPage;
    DashboardPage dashboardPage;
    AssetPage assetPage;
    FileDetailsPage fileDetailsPage;

    public void init() {
//        System.setProperty("webdriver.gecko.driver", "C:\\Users\\BS0493\\OneDrive\\Documents\\SelSetup\\geckodriver.exe");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\BS0493\\OneDrive\\Documents\\SelSetup\\chromedriver.exe");
        driver = new ChromeDriver();
        helper = new TestHelper(driver);
        driver.get("https://qatest.marcombox.com/");
    }

    public void run() throws InterruptedException, IOException {
        loginPage = new LoginPage(driver, helper);
        loginPage.textBoxEmail();
        loginPage.buttonSubmitEmail();
        loginPage.textBoxPassword();
        loginPage.buttonLogin();
//
        dashboardPage = new DashboardPage(driver, helper);
        dashboardPage.dropDownDam();
        dashboardPage.dropDownMenuAsset();
//
        assetPage = new AssetPage(driver, helper);
        assetPage.buttonUpload();
        assetPage.buttonBrowseUpload();
        assetPage.setTitle();
        assetPage.clickChooseType();
        assetPage.selectOptionImage();
        assetPage.submitUploadButton();
        assetPage.waitForProcessing();
        assetPage.checkTitle();
        assetPage.checkFileName();
        assetPage.checkFileType();

        fileDetailsPage = new FileDetailsPage(driver, helper);
        fileDetailsPage.clickFileDetails();
        fileDetailsPage.updateTitle();
        fileDetailsPage.clickSave();
        fileDetailsPage.clickClose();

        assetPage.checkTitle();
        assetPage.clickSelectFile();
        assetPage.clickShare();
    }
}
