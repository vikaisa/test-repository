package zerowasteshop.login;

import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import zerowasteshop.webDriverSettings.WebDriverSettings;

public class Login extends WebDriverSettings {
    @Test
    public void login() {
        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
        mainPage.open();
        mainPage.getStarted();

        OnlineShopPage onlineShopPage = PageFactory.initElements(driver, OnlineShopPage.class);
        onlineShopPage.openLoginPage();

        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.fillEmailField("somemod@top-mails.net");
        loginPage.fillPasswordField("Test123");
        loginPage.submitLoginInfo();
        loginPage.checkSignInSuccess();
    }

    @Test
    public void loginFailed() {
        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
        mainPage.open();
        mainPage.getStarted();

        OnlineShopPage onlineShopPage = PageFactory.initElements(driver, OnlineShopPage.class);
        onlineShopPage.openLoginPage();

        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.fillEmailField("safssf@asfsf.fas");
        loginPage.fillPasswordField("asfasfs");
        loginPage.submitLoginInfo();
        loginPage.checkSignInFailed();
    }
}
