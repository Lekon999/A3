import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SeleniumTest {
    private WebDriver driver;
    private org.openqa.selenium.By By;

    @BeforeAll
        static void setUpAll () {
            System.setProperty("web-driver.chrome.driver", "./driver/win/chromedriver.exe");
        }
        @BeforeEach
        void setUp () {
            driver = new ChromeDriver();
        }
        @AfterEach
        void tearDown () {
            driver.quit();
            driver = null;
        }

        @Test
        void shouldTest1 () {

            driver.get("http://localhost:9999");
            {
                driver.findElement(By).sendKeys("Василий");
                driver.findElement(By).sendKeys("+79090909999");
                driver.findElement(By).click();
                driver.findElement(By).click();
                String expected = "Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайщее время.";
                String actual = driver.findElement(By).getText();
                assertEquals (expected, actual);

            }

        }

    }


