package pages;

import helpers.TestHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;
    TestHelper helper;

    @FindBy(name = "userName")
        WebElement email;
    @FindBy(css=".sign-in-box-btn._s_LoginOption")
        WebElement submitEmail;
    @FindBy(name = "password")
        WebElement password;
    @FindBy(css = ".sign-in-box-btn._s_Submit")
        WebElement login;

    public LoginPage(WebDriver driver, TestHelper helper) {
        this.driver = driver;
        this.helper = helper;
        PageFactory.initElements(driver, this);
    }

    public void textBoxEmail() throws InterruptedException {
        String userEmail = "ehasanul.haque@wundermanthompson.com";
        helper.waitForVisibility(email);
        email.sendKeys(userEmail);
        helper.maximizeWindow();
    }

    public void buttonSubmitEmail() {
        submitEmail.click();
    }

    public void textBoxPassword() {
        String userPassword = "M@rc0mB0x";
        helper.waitForVisibility(password);
        password.sendKeys(userPassword);
    }

    public void buttonLogin() {
        login.click();
    }
}
