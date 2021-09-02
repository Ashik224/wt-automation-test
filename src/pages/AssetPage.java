package pages;

import helpers.TestHelper;
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

    By uploadWait = By.linkText("Upload");
    @FindBy(linkText = "Upload")
        WebElement upload;

    By browseWait = By.cssSelector("input[name='file']");
    @FindBy(css = "input[name='file']")
        WebElement browseUpload;

    @FindBy(css = ".upload")
    WebElement clickUpload;

    @FindBy(css = ".controls input")
        WebElement title;

    @FindBy(css = ".controls select")
        WebElement chooseType;

    @FindBy(css = ".controls select > option:nth-child(4)")
        WebElement optionImage;

    @FindBy(css = "._s_UploadSave")
        WebElement saveAndUpload;

    @FindBy(css = "tbody tr:nth-child(1) td:nth-child(1) .select-icon-check")
        WebElement buttonSelectFile;

    By titleWait = By.cssSelector("tbody tr:nth-child(1) td:nth-child(3)");
//    @FindBy(css = "tbody tr:nth-child(1) td:nth-child(3)")
//        WebElement titleInTable;

    By uploadFileTextWait = By.cssSelector("modal-header > h3");
    @FindBy(css = "modal-header > h3")
        WebElement uploadFilesText;

    @FindBy(css = "tbody tr:nth-child(1) td:nth-child(2) .file-name")
        WebElement fileNameText;

    @FindBy(css = "tbody tr:nth-child(1) td:nth-child(4)")
        WebElement fileTypeText;

    @FindBy(linkText = "Share")
        WebElement buttonShare;

    By checkWaitBy = By.xpath("//*[text() = 'Processing file']");
    @FindBy(xpath = "//*[text() = 'Processing file']")
        WebElement checkWait;

    public AssetPage(WebDriver driver, TestHelper helper) {
        this.driver = driver;
        this.helper = helper;
        PageFactory.initElements(driver, this);
    }

    public void buttonUpload() throws InterruptedException {
        Thread.sleep(2000);
        helper.waitForPresence(uploadWait);
        upload.click();
        System.out.println("Pass kore gese");
    }
    public void buttonBrowseUpload() throws InterruptedException, IOException {
        helper.waitForVisibility(clickUpload);
        clickUpload.click();
        Thread.sleep(3000);
        Runtime.getRuntime().exec("C:\\Users\\BS0493\\OneDrive\\Documents\\SelSetup\\FileUpload.exe");

    }

    public void setTitle() {
        String strTitle = "QA Automation";
        helper.waitForVisibility(title);
        title.sendKeys(strTitle);
    }

    public void clickChooseType() {
        chooseType.click();
    }

    public void selectOptionImage() {
        helper.waitForVisibility(optionImage);
        optionImage.click();
    }

    public void submitUploadButton() {
        helper.waitForVisibility(saveAndUpload);
        saveAndUpload.click();
    }

    public void waitForProcessing() throws InterruptedException {
        helper.waitForInvisibility(uploadFileTextWait);
        helper.waitForPresence(checkWaitBy);
        helper.waitForSomeTime(3000);
    }

    public void checkTitle() throws InterruptedException {
//        WebDriverWait wait = new WebDriverWait(driver, 30);
//        wait.until(ExpectedConditions.invisibilityOfElementLocated(uploadFileTextWait));

//        Thread.sleep(7000);
        WebElement titleInTable = driver.findElement(By.cssSelector("tbody tr:nth-child(1) td:nth-child(3)"));
        String value = titleInTable.getText();
        System.out.println("Val: "+ value);
    }

    public  void checkFileName() {
        String imgName = fileNameText.getText();
        System.out.println("FIle name: "+ imgName);
    }

    public void checkFileType() {
        String fileType = fileTypeText.getText();
        System.out.println("File Type: "+ fileType);
    }

    public void clickSelectFile() {
        buttonSelectFile.click();
    }

    public void clickShare() {
        if(buttonShare.isEnabled()) {
            buttonShare.click();
        }
    }
}
