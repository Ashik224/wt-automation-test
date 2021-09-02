package pages;

import helpers.TestHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AssetPage {
    WebDriver driver;
    TestHelper helper;

    By uploadWait = By.linkText("Upload");
    @FindBy(linkText = "Upload")
        WebElement upload;

//    By browseWait = By.cssSelector("input[name='file'][type='file']");
//    @FindBy(xpath = "//input[@name('file')]")
//        WebElement browseUpload;

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
    public void buttonBrowseUpload() throws InterruptedException {
        String imageUrl = "/home/aljubaer/Downloads/photo.jpeg";
        System.out.println("Purbe");
//        helper.waitForPresence(browseWait);
//        helper.waitForVisibility(browseUpload);
//        System.out.println("Pore");
//        browseUpload.sendKeys("/home/aljubaer/Desktop/photo.jpeg");
//        if(browseUpload.isDisplayed()) {
//            System.out.println("Helloooo");
//        }
        Thread.sleep(1000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].value='/home/aljubaer/Desktop/photo.jpeg'", browseUpload);
//        js.executeScript("arguments[0].click()", browseUpload);
        driver.findElement(By.xpath("//input[@name('file)]")).click();
//        browseUpload.click();
        System.out.println("Hiiiiii");
    }
}
