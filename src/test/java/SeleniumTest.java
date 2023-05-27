import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;

class SeleniumTest {
    private static WebDriver driver;
    private org.openqa.selenium.By By;

    @BeforeClass
    public static void Setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
    }

    @BeforeAll
    static void setUpAll() {
        //WebDriverManager.chromedriver().setup();
        System.setProperty("web-driver.chrome.driver", "./driver/win/chromedriver.exe");
    }

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
        driver = null;
    }

    @Test
    void shouldTest1() throws InterruptedException {

        driver.get("http://localhost:9999/");
        Thread.sleep(50000);
//        {
//
//            List<WebElement> inputs = driver.findElements(By.tagName("input"));
//            inputs.get(0).sendKeys("Иванов Иван");
//            inputs.get(1).sendKeys("+79099990099");
//            driver.findElement(By.className("checkbox__box")).click();
//            driver.findElement(By.className("button__text")).click();
//            String expected = "Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайщее время.";
//            String actual = driver.findElement(By.className("order-success")).getText();
//            assertEquals(expected, actual);

    }
}




