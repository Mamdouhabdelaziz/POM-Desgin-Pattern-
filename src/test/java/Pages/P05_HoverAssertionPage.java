package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class P05_HoverAssertionPage {
    WebDriver driver;
    public P05_HoverAssertionPage (WebDriver driver) {
        this.driver = driver;
    }

    private final By MsgLoc = By.tagName("h1");

    public void  AssertOnHoverMSg ()
    {
        SoftAssert Soft = new SoftAssert();
       boolean actual = driver.findElement(MsgLoc).isDisplayed();
       Soft.assertTrue(actual);
       Soft.assertAll();

    }
}
