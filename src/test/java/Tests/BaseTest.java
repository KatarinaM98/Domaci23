package Tests;

import Pages.InventoryPage;
import Pages.LoginPage;
import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public abstract class BaseTest {

    protected WebDriver driver;
    protected WebDriverWait driverWait;
    protected LoginPage loginPage;
    protected InventoryPage addToCart;

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "D:\\Google driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        loginPage = new LoginPage(driver, driverWait);
        addToCart = new InventoryPage(driver, driverWait);
    }

    @BeforeMethod
    public void beforeMethod(){
        driver.get("https://www.saucedemo.com/");
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
