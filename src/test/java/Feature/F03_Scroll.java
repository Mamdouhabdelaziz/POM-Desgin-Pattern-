package  Feature ;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class F03_Scroll {

    WebDriver driver;

    @BeforeMethod
    void setUp()
    {
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/infinite_scroll");
        driver.manage().window().maximize();
    }

    @Test
    void TCA()
    {
       JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 2000)");

        WebElement element = driver.findElement(By.id("target"));
        js.executeScript("arguments[0].scrollIntoView(true);", element);

        js.executeScript(
                "window.scrollTo(0, document.body.scrollHeight)"
        );


    }
}