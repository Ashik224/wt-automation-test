package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestHelper {
    WebDriverWait wait;
    public TestHelper(WebDriver driver) {
        wait = new WebDriverWait(driver, 30);
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

}
