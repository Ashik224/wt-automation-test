package pages;

import helpers.TestHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {
    WebDriver driver;
    TestHelper helper;

    By damWait = By.cssSelector(".container-fluid ul[id='appList'] li.dropdown:nth-last-child(4)");
    @FindBy(css = ".container-fluid ul[id='appList'] li.dropdown:nth-last-child(4)")
        WebElement dam;
    @FindBy(xpath = "//a[text() = 'Assets']")
        WebElement damOptionAsset;

    public DashboardPage(WebDriver driver, TestHelper helper) {
        this.driver = driver;
        this.helper = helper;
        PageFactory.initElements(driver, this);
    }

    public void dropDownDam() {
        helper.waitForPresence(damWait);
        dam.click();
    }

    public void dropDownMenuAsset() {
        helper.waitForVisibility(damOptionAsset);
        if(damOptionAsset.isDisplayed()) {
            damOptionAsset.click();
        }
    }
}
