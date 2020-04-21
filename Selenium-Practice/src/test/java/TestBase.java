import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class TestBase {

    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
    //Для паралелльного запуска (сокращает время проведения тестов): для каждого потока будет создаваться отдельный экземпляр браузера и драйвера
    //вспомогательный класс ThreadLocal: создаем переменную tlDriver, хранящую инфу о драйверах, привязанных к разным потокам,
    //и инициализируем ее
    public WebDriver driver;
    //Переменная driver будет инициализироваться перед каждым тестовым методом
    public WebDriverWait wait;
    //Добавляем static - делаем драйвер синглтоном, т.е. объявляем его глобальным
    //private Object HasCapabilities;

    public boolean areElementsPresent (By locator) {
      return driver.findElements(locator).size() > 0;
    }
    //Проверка наличия элемента

    @Before
    public void start() {
        if (tlDriver.get() != null) {
            driver = tlDriver.get();
            wait = new WebDriverWait(driver, 10);
            return;
        }
        //Этот фрагмент кода будет выполняться, если с текущим потоком уже ассоциирован какой-то ранее запущенный драйвер
      //if (driver != null) {
        //return;
      //}
      //Проверка, инициализирован ли браузер: если равен null, инициализируем, если уже инициализрован, ничего не делаем
      //Использовать тот же самый браузер многократно, не запуская каждый раз новый экземпляр,
      // для сокращения времени выполнения тестов

      //System.setProperty("webdriver.chrome.driver", "/Users/victoria.isaycheva/Downloads/chromedriver");
      //третий способ, куда положить вспомогательный исполняемый файл
        DesiredCapabilities caps = new DesiredCapabilities();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-fullscreen");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        tlDriver.set(driver);
        //Созданный экземпляр драйвера привязываем к текущему потоку
        //System.out.println(((HasCapabilities) driver).getCapabilities());
        wait = new WebDriverWait(driver, 10);

        Runtime.getRuntime().addShutdownHook(
                new Thread(() -> { driver.quit(); driver = null; }));
    //фрагмент кода,который должен быть выполнен в самом конце
    }

    @After
    public void stop() {
        //driver.quit();
        //driver = null;
        //Не нужно пытаться остановить драйвер после каждого тестого метода, он должен останавливаться только в самом конце
        //Но JUnit такой возможности не предлагает
    }
}
