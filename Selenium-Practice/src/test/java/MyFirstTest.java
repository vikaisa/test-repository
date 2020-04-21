import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;

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
}




