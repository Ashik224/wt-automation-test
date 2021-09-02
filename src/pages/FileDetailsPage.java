package pages;

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

    By textBoxTitleBy = By.cssSelector(".control-group:nth-child(3) input");
    @FindBy(css = ".control-group:nth-child(3) input")
        WebElement textBoxTitle;

    @FindBy(linkText = "Save")
        WebElement buttonSave;

    By popUpMsgBy = By.cssSelector(".gritter-without-image .alert-info");
    @FindBy(css = ".gritter-without-image .alert-info")
        WebElement popUpMsg;

    @FindBy(css = ".list-item-actionpanel ._s_Close.close")
        WebElement buttonClose;

    public FileDetailsPage(WebDriver driver, TestHelper helper) {
        this.driver = driver;
        this.helper = helper;
        PageFactory.initElements(driver, this);
    }

    public void clickFileDetails() {
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].click()", fileDetails);
        fileDetails.click();
    }

    public void updateTitle() {
        helper.waitForPresence(textBoxTitleBy);
        textBoxTitle.clear();
        textBoxTitle.sendKeys("QA Automation Engineer");
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
}
