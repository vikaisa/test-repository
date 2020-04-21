package zerowasteshop.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(className = "co-form-controls")
    private WebElement container;

    private By submitButtonLocator = By.cssSelector("[type=\"submit\"]");
    private By logoutButton = By.cssSelector("[href=\"/client_account/exit\"]");
    private By signInErrorBox = By.className("co-notice--danger");

    public void fillEmailField(String email) {
        emailInput.sendKeys(email);
    }

    public void fillPasswordField(String password) {
        passwordInput.sendKeys(password);
    }

    public void submitLoginInfo() {
        container.findElement(submitButtonLocator).click();
    }

    public void checkSignInSuccess() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(logoutButton));
    }

    public void checkSignInFailed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(signInErrorBox));
    }
}
