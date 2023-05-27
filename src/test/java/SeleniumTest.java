//import io.github.bonigarcia.wdm.WebDriverManager;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

import static org.testng.AssertJUnit.assertEquals;

class SeleniumTest {
    private static WebDriver driver;
    private org.openqa.selenium.By By;


    @BeforeAll
    static void setDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.get("http://localhost:9999/");
    }

    @AfterEach
    void setDown() {
        driver.quit();
        driver = null;
    }

    @Test
    void shouldTest1() throws InterruptedException {

        driver.get("http://localhost:9999/");
        Thread.sleep(50000);
        {

            List<WebElement> inputs = driver.findElements(By.tagName("input"));
            inputs.get(0).sendKeys("Иванов Иван");
            inputs.get(1).sendKeys("+79099990099");
            driver.findElement(By.className("checkbox__box")).click();
            driver.findElement(By.className("button__text")).click();
            String expected = "Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайщее время.";
            String actual = driver.findElement(By.className("order-success")).getText();
            assertEquals(expected, actual);

        }
    }
}




