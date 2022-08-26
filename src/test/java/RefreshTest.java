import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RefreshTest {
    private WebDriver driver;
    private final String BASE_URL = "http://localhost/clickmebaby.php";


    @Before
    public void setUp() { driver = new FirefoxDriver();
    }

    @Test
    public void test() throws InterruptedException {
        driver.get(BASE_URL);
        for (int i = 0; i < 5; i++) {
            driver.findElement(By.id("clickMe")).click();

        }
        Assert.assertEquals("5", driver.findElement(By.id("clicks")).getText());
        driver.navigate().refresh();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofNanos(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("clicks")));
        Assert.assertEquals("0", driver.findElement(By.id("clicks")).getText());

    }

    @After
    public void tearDown() {
    }

}
