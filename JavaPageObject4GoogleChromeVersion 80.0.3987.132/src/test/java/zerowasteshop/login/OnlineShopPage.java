package zerowasteshop.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OnlineShopPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public OnlineShopPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    @FindBy(className = "top-menu-wrapper")
    private WebElement header;

    private By loginButtonLocator = By.cssSelector("[href=\"/client_account/login\"]");
    private By loginButtonContainer = By.className("co-form-controls");


    public void openLoginPage() {
        header.findElement(loginButtonLocator).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(loginButtonContainer));
    }
}
