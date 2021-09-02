package pages.asset;

import helpers.FileUploader;
import helpers.TestHelper;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

public class AssetPage {
    WebDriver driver;
    TestHelper helper;

    @FindBy(linkText = "Upload")
        WebElement upload;
    @FindBy(css = "input[name='file']")
        WebElement browseUpload;
    @FindBy(css = ".upload")
        WebElement clickUpload;
    @FindBy(css = "tbody tr:nth-child(1) td:nth-child(1) .select-icon-check")
        WebElement buttonSelectFile;
    @FindBy(css = "modal-header > h3")
        WebElement uploadFilesText;
    @FindBy(css = "tbody tr:nth-child(1) td:nth-child(2) .file-name")
        WebElement fileNameText;
    @FindBy(css = "tbody tr:nth-child(1) td:nth-child(4)")
        WebElement fileTypeField;
    @FindBy(linkText = "Share")
        WebElement buttonShare;

    By uploadWait = By.linkText("Upload");

    FileUploader uploader;

    public AssetPage(WebDriver driver, TestHelper helper) {
        this.driver = driver;
        this.helper = helper;
        PageFactory.initElements(driver, this);
    }

    public void clickUpload() throws InterruptedException {
        helper.waitForSomeTime(2000);
        helper.waitForPresence(uploadWait);
        upload.click();
    }

    public void clickBrowse() throws Exception {
        helper.waitForVisibility(clickUpload);
        clickUpload.click();
        helper.waitForSomeTime(2000);
        uploader = new FileUploader();
        uploader.upload();
    }

    public void checkFileTitle(String sourceTitle) throws InterruptedException {
        WebElement titleInTable = driver.findElement(By.cssSelector("tbody tr:nth-child(1) td:nth-child(3)"));
        String retrievedTitle = titleInTable.getText();
        Assert.assertEquals(retrievedTitle, sourceTitle);
    }

    public  void checkFileName(String sourceFileName) {
        String retrievedFileName = fileNameText.getText();
        Assert.assertEquals(retrievedFileName, sourceFileName);
    }

    public void checkFileType(String sourceType) {
        String fileType = fileTypeField.getText();
        Assert.assertEquals(fileType, sourceType);
    }

    public void clickSelectFile() {
        buttonSelectFile.click();
    }

    public void clickShare() {
        if(buttonShare.isEnabled()) {
            buttonShare.click();
        }
    }

    public String getFileName() {
        return "image1.jpg";
    }
}
