package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class P04_HoverPage {

    WebDriver driver;
    public P04_HoverPage (WebDriver driver) {
        this.driver = driver;
    }



    private final By ImgLoc = By.xpath("//img[@src=\"/img/avatar-blank.jpg\"][1]");
    private final By ViewProfileLoc = By.cssSelector("a[href=\"/users/1\"]");

    public void HoverOnImg ()
    {
        Actions act = new Actions(driver);
        WebElement imageLoc = driver.findElement(ImgLoc);
        act.moveToElement(imageLoc).perform();


    }
    public void ClickViewProfile ()
    {
        driver.findElement(ViewProfileLoc).click();


    }
}
