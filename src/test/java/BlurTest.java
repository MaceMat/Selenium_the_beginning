import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BlurTest {
    private WebDriver driver;



    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost/waitforit.php");
    }

    @Test
    public void testBlur() {
        driver.findElement(By.id("waitForBlur")).sendKeys("Brano ma nohy");
        ((JavascriptExecutor) driver).executeScript("arguments[0].blur()",driver.findElement(By.id("waitForBlur")));
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.attributeToBe(driver.findElement(By.id("waitForBlur")),"value","blured!"));

    }

    @After
    public void tearDown() {
     //   driver.close();
     //   driver.quit();
    }

}
