package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InventoryPage extends BasePage {

    @FindBy(name = "add-to-cart-sauce-labs-backpack")
    private WebElement addToCartButton;

    @FindBy(xpath = "//*[@id=\"shopping_cart_container\"]/a")
    private WebElement shoppingCart;

    @FindBy(xpath = "//*[@id=\"shopping_cart_container\"]/a/span")
    private WebElement shoppingCartNumber;

    @FindBy(xpath = "//*[@id=\"remove-sauce-labs-backpack\"]")
    private WebElement removeButton;


    public InventoryPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void addToCart(){

       addToCartButton.click();

    }

    public void discard(){

        removeButton.click();

    }
}


