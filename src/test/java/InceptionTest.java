import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class InceptionTest {
    private WebDriver driver;



    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost/inception.php");
    }

    @Test
    public void testDeeper() {
        String parentWindow = driver.getWindowHandle();
        driver.findElement(By.id("letsGoDeeper")).click();
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.numberOfWindowsToBe(2));
        for (String handle : driver.getWindowHandles() ) {
            driver.switchTo().window(handle);
        }
        driver.findElement(By.xpath("//input[1]")).sendKeys("sangala je nevinny");
        driver.close();

        driver.switchTo().window(parentWindow);
        driver.findElement(By.id("letsGoDeeper")).click();

    }

    @After
    public void tearDown() {
     //   driver.close();
     //   driver.quit();
    }

}
