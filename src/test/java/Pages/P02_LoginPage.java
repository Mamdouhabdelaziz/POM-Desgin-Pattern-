package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class P02_LoginPage {
    WebDriver driver;
    public P02_LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By UserNameLoc = By.id("username");
    private final By PasswordLoc = By.name("password");
    private final By ButtonLoginLoc = By.cssSelector("button.radius");
    private final By FailureMsgLoc = By.cssSelector("#flash.error");

    public void Login(String UN, String PW) {
        driver.findElement(UserNameLoc).sendKeys(UN);
        driver.findElement(PasswordLoc).sendKeys(PW);
        driver.findElement(ButtonLoginLoc).click();
    }
    public void AssertFailureLogin() {
        boolean failureMessage =
                driver.findElement(FailureMsgLoc)
                        .getText()
                        .contains("Your password is invalid!");

        Assert.assertTrue(
                failureMessage,
                "Invalid password error message should be displayed"
        );
    }
}
