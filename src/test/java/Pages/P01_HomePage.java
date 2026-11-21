package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P01_HomePage {
    WebDriver driver;
    public P01_HomePage (WebDriver driver) {
        this.driver = driver;
    }

    private final By FormAuthLoc = By.linkText("Form Authentication");
    private final By HoverLinkLoc = By.linkText("Hovers");

    public void ClickFormAuth()
    {
        driver.findElement(FormAuthLoc).click();
    }
    public void ClickHover ()
    {
     driver.findElement(HoverLinkLoc).click();
    }
}
