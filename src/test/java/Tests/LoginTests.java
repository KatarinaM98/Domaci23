package Tests;

import Tests.BaseTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

/*
Testirati Login za sva prva tri usera (standard_user, locked_out_user, problem_user).
 Za drugog i treceg samo proveriti da li se pojavljuje poruka da se nije uspesno ulogovao.
 */


public class LoginTests extends BaseTest {

    @Test
    public void loginValidDataTest1() {

        loginPage.login("standard_user", "secret_sauce");

        String actualLink = driver.getCurrentUrl();
        Assert.assertTrue(actualLink.contains("/inventory.html"));

        driver.navigate().refresh();

    }

    @Test
    public void loginValidDataTest2() throws InterruptedException {


        loginPage.login("locked_out_user", "secret_sauce");

        String actualLink = driver.getCurrentUrl();
        Assert.assertTrue(actualLink.contains("/inventory.html"));
        WebElement actualMessage = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3/text()"));
        String expectedMessage = "Epic sadface: Sorry, this user has been locked out.";
        Assert.assertEquals(actualMessage, expectedMessage);
        Thread.sleep(3500);
        driver.navigate().refresh();

    }

    @Test
    public void loginValidDataTest3() throws InterruptedException {


        loginPage.login("problem_user", "secret_sauce");

        String actualLink = driver.getCurrentUrl();
        Assert.assertTrue(actualLink.contains("/inventory.html"));
        WebElement actualMessage = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3/text()"));
        String expectedMessage = "Epic sadface: Sorry, this user has been locked out.";
        Assert.assertEquals(actualMessage, expectedMessage);
        Thread.sleep(3500);
        driver.navigate().refresh();

    }
}
