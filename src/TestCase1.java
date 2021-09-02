import helpers.TestHelper;
import org.openqa.selenium.WebDriver;
import pages.*;
import pages.asset.AssetPage;
import pages.asset.FileDetailsPage;
import pages.asset.FileUploadPage;

public class TestCase1 {
    WebDriver driver;
    TestHelper helper;

    LoginPage loginPage;
    DashboardPage dashboardPage;
    AssetPage assetPage;
    FileDetailsPage fileDetailsPage;
    FileUploadPage fileUploadPage;

    public TestCase1(WebDriver driver) {
        this.driver = driver;
    }

    public void init() {
        helper = new TestHelper(driver);
    }

    public void run() throws Exception {
        loginPage = new LoginPage(driver, helper);
        loginPage.textBoxEmail();
        loginPage.buttonSubmitEmail();
        loginPage.textBoxPassword();
        loginPage.buttonLogin();

        dashboardPage = new DashboardPage(driver, helper);
        dashboardPage.dropDownDam();
        dashboardPage.dropDownMenuAsset();

        assetPage = new AssetPage(driver, helper);
        assetPage.clickUpload();
        assetPage.clickBrowse();

        fileUploadPage = new FileUploadPage(driver, helper);
        fileUploadPage.setTitleField();
        fileUploadPage.clickChooseType();
        fileUploadPage.selectOptionImage();
        fileUploadPage.clickSaveUpload();
        fileUploadPage.waitForProcessing();

        String fileTitle = fileUploadPage.getTitle();
        assetPage.checkFileTitle(fileTitle);
        String fileName = assetPage.getFileName();
        assetPage.checkFileName(fileName);
        String fileType = fileUploadPage.getType();
        assetPage.checkFileType(fileType);

        fileDetailsPage = new FileDetailsPage(driver, helper);
        fileDetailsPage.clickFileDetails();
        fileDetailsPage.updateTitle();
        fileDetailsPage.clickSave();
        fileDetailsPage.clickClose();

        String updatedFileTitle = fileDetailsPage.getTitle();
        assetPage.checkFileTitle(updatedFileTitle);
        assetPage.clickSelectFile();
        assetPage.clickShare();

        helper.waitForSomeTime(7000);
    }
}
