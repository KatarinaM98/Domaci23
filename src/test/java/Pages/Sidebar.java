package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Sidebar extends BasePage {

    @FindBy(id = "react-burger-menu-btn")
    private WebElement sidebar;
    @FindBy(id = "logout_sidebar_link")
    private WebElement logoutButton;



    public Sidebar(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void openSidebar(){

       sidebar.click();

    }

    public void logout(){

        logoutButton.click();

    }
}
