import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class SemaforTest {
    private WebDriver driver;
    private final String BASE_URL = "http://localhost/semafor.php";


    @Before
    public void setUp() { driver = new FirefoxDriver();
    }

    @Test
    public void test() throws InterruptedException {
        String expectedGreen = "rgb(10, 129, 0)";
        String expectedRed = "rgb(205, 58, 63)";
        String expectedOrange = "rgb(191, 111, 7)";

        driver.get(BASE_URL);
        WebElement trafficLight = driver.findElement(By.className("light"));
        String actualRedColor = trafficLight.getCssValue("background-color");
        Assert.assertEquals(expectedRed, actualRedColor);

        Actions action = new Actions(driver);
        action.moveToElement(trafficLight).build().perform();

        String actualGreenColor = trafficLight.getCssValue("background-color");
        Assert.assertEquals(expectedGreen, actualGreenColor);

        action.clickAndHold(trafficLight).build().perform();
        String actualOrangeColor = trafficLight.getCssValue("background-color");
        Assert.assertEquals(expectedOrange, actualOrangeColor);

    }

    @After
    public void tearDown() {
        //driver.close();
        driver.quit();
    }

}
