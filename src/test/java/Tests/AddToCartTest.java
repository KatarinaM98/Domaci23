package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

/*
Za prvog usera, na Inventory testirati dodavanje u cart i da li se pojavljuje u cart-u
u gornjem desnom uglu broj. Takodje testirati kada se klikne remove da u cart-u pise 0.

 */
public class AddToCartTest extends BaseTest {
    @Test
    public void addToCart() {

        loginPage.login("standard_user", "secret_sauce");

addToCart();
        WebElement actualNumber = driver.findElement(By.xpath( "//*[@id=\"shopping_cart_container\"]/a/span"));
        String expectedNumber = "1";



        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Assert.assertEquals(actualNumber, expectedNumber);

        addToCart.discard();
        Assert.assertEquals(actualNumber, 0);



        driver.navigate().refresh();

    }


}
