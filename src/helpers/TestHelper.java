package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestHelper {
    WebDriverWait wait;
    WebDriver driver;
    public TestHelper(WebDriver driver) {
        wait = new WebDriverWait(driver, 30);
        this.driver = driver;
    }
    public WebDriverWait getWebDriverWait() {
        return wait;
    }
    public void waitForVisibility(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public void waitForPresence(By by) {
        getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(by));
    }
    public void waitForInvisibility(By by) {
        getWebDriverWait().until(ExpectedConditions.invisibilityOfElementLocated(by));
    }
    public void waitForPopupToGoAway(By by) {
        waitForInvisibility(by);
    }

    public void waitForSomeTime(long miliSecs) throws InterruptedException {
        Thread.sleep(miliSecs);
    }

    public void maximizeWindow() {
        driver.manage().window().maximize();
    }

}
