package pages.asset;

import helpers.TestHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ShareFilePage {
    WebDriver driver;
    TestHelper helper;

    public ShareFilePage(WebDriver driver, TestHelper helper) {
        this.driver = driver;
        this.helper = helper;
        PageFactory.initElements(driver, this);
    }
}
