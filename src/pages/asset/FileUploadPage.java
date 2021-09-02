package pages.asset;

import helpers.TestHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FileUploadPage {
    WebDriver driver;
    TestHelper helper;

    @FindBy(css = ".controls input")
        WebElement title;
    @FindBy(css = ".controls select")
        WebElement chooseType;
    @FindBy(css = ".controls select > option:nth-child(4)")
        WebElement optionImage;
    @FindBy(css = "._s_UploadSave")
        WebElement saveAndUpload;

    By uploadFileTextWait = By.cssSelector("modal-header > h3");
    By checkWaitBy = By.xpath("//*[text() = 'Processing file']");

    String fileTitleValue;
    String fileTypeValue;

    public FileUploadPage(WebDriver driver, TestHelper helper) {
        this.driver = driver;
        this.helper = helper;
        PageFactory.initElements(driver, this);
    }
    public void setTitleField() {
        fileTitleValue = "QA Automation";
        helper.waitForVisibility(title);
        title.sendKeys(fileTitleValue);
    }

    public void clickChooseType() {
        chooseType.click();
    }

    public void selectOptionImage() {
        helper.waitForVisibility(optionImage);
        optionImage.click();
        fileTypeValue = optionImage.getText();
    }

    public void clickSaveUpload() {
        helper.waitForVisibility(saveAndUpload);
        saveAndUpload.click();
    }

    public void waitForProcessing() throws InterruptedException {
        helper.waitForInvisibility(uploadFileTextWait);
        helper.waitForPresence(checkWaitBy);
        helper.waitForSomeTime(3000);
    }

    public String getTitle() {
        return fileTitleValue;
    }

    public String getType() {
        return fileTypeValue;
    }
}
