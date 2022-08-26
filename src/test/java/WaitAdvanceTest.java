import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitAdvanceTest {
    private WebDriver driver;


    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost/waitforit.php");
    }

    @Test
    public void waitForInput() {
        driver.findElement(By.id("startWaitForText")).click();
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.attributeToBe(By.id("waitForTextInput"),"value","dary !!!"));

        System.out.println(driver.findElement(By.id("waitForTextInput")).getAttribute("value"));

    }

    @Test
    public void waitForClass() {
        driver.findElement(By.id("startWaitForProperty")).click();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.attributeContains(By.id("waitForProperty"), "class", "error"));
        Assert.assertFalse(driver.findElement(By.id("startWaitForProperty")).isEnabled());

    }

    @Test
    public void waitForDisabled() {
        driver.findElement(By.id("startWaitForProperty")).click();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.attributeContains(By.id("startWaitForProperty"),"disabled",""));
        Assert.assertFalse(driver.findElement(By.id("startWaitForProperty")).isEnabled());

    }


    @After
    public void tearDown() {
        //   driver.quit();
    }

}
