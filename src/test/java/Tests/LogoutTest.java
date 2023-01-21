package Tests;

import Pages.Sidebar;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest{
    /*
    Testirati logout dugme, da li vas na klik vrati na originalni url i kada odete
     sa driver.get na https://www.saucedemo.com/inventory.html da li pise poruka:
      “Epic sadface: You can only access '/inventory.html' when you are logged in.”

     */
    @Test
    public void logOut() {

        loginPage.login("standard_user", "secret_sauce");
        logOut();
        String actualLink = driver.getCurrentUrl();
        String expectedLink = "https://www.saucedemo.com/";
        Assert.assertEquals(actualLink, expectedLink);
        driver.get("https://www.saucedemo.com/inventory.html");
        WebElement message = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3"));
        String expectedMessage = "Epic sadface: You can only access '/inventory.html' when you are logged in.";
        Assert.assertEquals(message, expectedMessage);

        driver.navigate().refresh();

    }
}
