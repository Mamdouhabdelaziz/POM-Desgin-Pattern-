package Feature;

import Pages.P01_HomePage;
import Pages.P02_LoginPage;
import Pages.P03_AssertionPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ThreadGuard;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.time.Duration;
//@Listeners(TestNGListeners.CustomListeners.class)

public class F01_Login {
    ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();
    WebDriver driver;
    P01_HomePage Hp;
    P02_LoginPage Lp;
    P03_AssertionPage Ap;

    @BeforeMethod
    public void SetUp() {
        driver = ThreadGuard.protect(new ChromeDriver());
        driverThreadLocal.set(driver);

        driverThreadLocal.get().get("https://the-internet.herokuapp.com/");

        Hp = new P01_HomePage( driverThreadLocal.get());
        Lp = new P02_LoginPage( driverThreadLocal.get());
        Ap = new P03_AssertionPage( driverThreadLocal.get());

    }

    @Test
    public void validLogin() {
        Hp.ClickFormAuth();
        Lp.Login("tomsmith", "SuperSecretPassword!");
        Ap.AssertSuccessLogin();
    }

    @Test
    public void InvalidPasswordLogin() {
        Hp.ClickFormAuth();
        Lp.Login("tomsmith", "12345");
        Lp.AssertFailureLogin();
    }
    @Test
    public void InvalidUserNameLogin() {
        Hp.ClickFormAuth();
        Lp.Login("Mohamed", "SuperSecretPassword!");
        Lp.AssertFailureLogin();
    }

    @AfterMethod
    public void CleanUp() {
        if (driverThreadLocal.get() != null) {
            driverThreadLocal.get().quit();
        }
    }
}