import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertFalse;

public class MyFirstTest extends TestBase {

  @Test
  public void login() {
    driver.navigate().to("http://zws.moscow/");
    driver.findElement(By.className("client-account-link")).click();
    driver.findElement(By.id("email")).sendKeys("somemod@top-mails.net");
    driver.findElement(By.id("password")).sendKeys("Test123");
    driver.findElement(By.name("commit")).click();
    driver.findElement(By.cssSelector("[href=\"/client_account/exit\"]"));
  }

  @Test
  public void checkTable() {
    driver.navigate().to("https://www.tutu.ru/");
    driver.findElement(By.linkText("Москва — Санкт-Петербург")).sendKeys(Keys.RETURN);
    assertFalse(areElementsPresent(By.name("XXX")));
    WebElement table = driver.findElement(By.tagName("table"));
    List<WebElement> rows = table.findElements(By.className("index__card___3qyQy"));
    for (WebElement row : rows) {
      List<WebElement> cells = row.findElements(By.tagName("td"));
      System.out.println(cells.get(2).getText());
    }
  }

  @Test
  public void checkShipping() {
    driver.navigate().to("https://www.longchamp.com/");
    List<WebElement> countriesList = driver.findElements(By.cssSelector("div.float-gr--4-2 li"));
    for (WebElement country : countriesList) {
      List<WebElement> noShipping = country.findElements(By.tagName("span"));
      if (noShipping.size() == 0) {
        System.out.println(country.getText());
      }
    }
  }

  @Test
  public void dropdownMenu() throws InterruptedException {
    driver.navigate().to("https://www.sberbank.ru/ru/s_m_business/bankingservice/cards/digital");
    Actions action = new Actions(driver);
    WebElement menu = driver.findElement(By.cssSelector("ul.lg-menu-legal__list li:first-child"));
    action.moveToElement(menu).build().perform();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    action.moveToElement(driver.findElement(By.linkText("Начать бизнес со Сбербанком"))).click().build().perform();
    driver.findElement(By.cssSelector("div.start__title.h1.m-xs-0"));
    Thread.sleep(1000);
  }

  @Test
  public void fillForm() throws InterruptedException {
    driver.navigate().to("https://www.sberbank.ru/ru/s_m_business/bankingservice/cards/digital");
    driver.findElement(By.cssSelector("button.b-btn.b-btn-block.js-section-card-anchor")).click();
    WebElement  phoneNumber = driver.findElement(By.name("phone"));
    phoneNumber.sendKeys("1111111111");
    Thread.sleep(1000);
    driver.findElement(By.name("client")).sendKeys(Keys.RETURN);
    phoneNumber.clear();
    Thread.sleep(1000);
  }
}




