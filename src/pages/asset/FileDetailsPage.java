package pages.asset;

import helpers.TestHelper;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FileDetailsPage {
    WebDriver driver;
    TestHelper helper;

    @FindBy(css = "tbody tr:nth-child(1) td:nth-child(2)")
        WebElement fileDetails;
    @FindBy(css = ".control-group:nth-child(3) input")
        WebElement textBoxTitle;
    @FindBy(linkText = "Save")
        WebElement buttonSave;
    @FindBy(css = ".gritter-without-image .alert-info")
        WebElement popUpMsg;
    @FindBy(css = ".list-item-actionpanel ._s_Close.close")
        WebElement buttonClose;

    By popUpMsgBy = By.cssSelector(".gritter-without-image .alert-info");
    By textBoxTitleBy = By.cssSelector(".control-group:nth-child(3) input");

    String updatedTitleString = "QA Automation Engineer";

    public FileDetailsPage(WebDriver driver, TestHelper helper) {
        this.driver = driver;
        this.helper = helper;
        PageFactory.initElements(driver, this);
    }

    public void clickFileDetails() {
        fileDetails.click();
    }

    public void updateTitle() throws InterruptedException {
        helper.waitForSomeTime(3500);
        helper.waitForPresence(textBoxTitleBy);
        textBoxTitle.clear();
        textBoxTitle.sendKeys(updatedTitleString);
    }

    public void clickSave() {
        buttonSave.click();
        helper.waitForPresence(popUpMsgBy);
        String retrievedMsg = popUpMsg.getText();
        String msg = "You have successfully modified the item.";
        Assert.assertEquals(retrievedMsg, msg);
    }

    public void clickClose() {
        helper.waitForPopupToGoAway(popUpMsgBy);
        buttonClose.click();
    }

    public String getTitle() {
        return updatedTitleString;
    }
}
