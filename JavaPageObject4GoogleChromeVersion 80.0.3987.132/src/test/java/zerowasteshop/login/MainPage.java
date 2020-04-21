package zerowasteshop.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    private By onlineShopButtonLocator = By.cssSelector("[href=\"https://zws.moscow/\"]");
    private By topMenu = By.className("top-menu-wrapper");

    public void open() {
        driver.get("http://zerowasteshop.moscow/page2867477.html");
    }

    public void getStarted() {
        driver.findElement(onlineShopButtonLocator).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(topMenu));
    }
}
