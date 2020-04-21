package zerowasteshop.webDriverSettings;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;


public class WebDriverSettings {
    public WebDriver driver;

    @Before
    public void setUp() {
        //System.setProperty("webdriver.chrome.driver", "/Users/victoria.isaycheva/Downloads/chromedriver");

        driver = new SafariDriver();


        driver.manage().window().setSize(new Dimension(1000, 700));
    }

    @After
    public void close() {
        driver.quit();
    }
}
