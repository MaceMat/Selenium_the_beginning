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

public class WaitForMinions {
    private WebDriver driver;


    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        driver.get("http://localhost/minions.php");
    }

    @Test
    public void waitForMinions() {
        int numberOfMinions = 9;
        driver.findElement(By.xpath("//input[@type ='number']")).sendKeys(String.valueOf(numberOfMinions));
        driver.findElement(By.xpath("//button[contains(@class,'btn-warning')]")).click();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .withMessage("Timeout waiting for minions to be "+numberOfMinions)
                .until(ExpectedConditions.numberOfElementsToBe(By.xpath("//div[@class='minions']//img"),numberOfMinions));

        Assert.assertEquals(numberOfMinions,driver.findElements(By.xpath("//div[@class='minions']//img")).size());
    }

    @After
    public void tearDown() {
      driver.quit();
    }

}
