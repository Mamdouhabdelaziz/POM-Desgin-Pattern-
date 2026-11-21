package Feature;

import Pages.P01_HomePage;
import Pages.P04_HoverPage;
import Pages.P05_HoverAssertionPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class F02_Hover {
    WebDriver driver;
    P04_HoverPage HVP ;
    P05_HoverAssertionPage HAP;
    P01_HomePage Hp; ;

    @BeforeMethod
    public void SetUp() {
        driver = new ChromeDriver();

        driver.manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://the-internet.herokuapp.com/");
        HVP = new P04_HoverPage(driver);
        HAP = new P05_HoverAssertionPage(driver);
        Hp = new P01_HomePage(driver);
    }
    @Test  public  void  HoverOnImg ()
    {
        Hp.ClickHover();
        HVP.HoverOnImg();
        HVP.ClickViewProfile();
        HAP.AssertOnHoverMSg();


    }
}
