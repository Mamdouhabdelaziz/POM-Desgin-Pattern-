package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class P03_AssertionPage {

    WebDriver driver;

    public P03_AssertionPage(WebDriver driver) {
        this.driver = driver;
    }
    private final By LogOutButtonLoc = By.cssSelector("a.button[href='/logout']");
    private final By SuccessMsgLoc = By.id("flash");
    public void AssertSuccessLogin() {
        SoftAssert soft = new SoftAssert();

        boolean logoutDisplayed =
                driver.findElement(LogOutButtonLoc).isDisplayed();
        soft.assertTrue(logoutDisplayed, "Logout button should be displayed");

        boolean successMessage =
                driver.findElement(SuccessMsgLoc)
                        .getText()
                        .contains("You logged into a secure area!");
        soft.assertTrue(successMessage, "Success message should be displayed");

        soft.assertAll();
    }
}
