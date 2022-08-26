import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;

import java.util.ArrayList;
import java.util.List;

public class ColourTest {
    private WebDriver driver;
    private final String BASE_URL = "http://localhost/stroopeffect.php";

    @Before
    public void setUp() { driver = new FirefoxDriver();
    }

    @Test
    public void test() throws InterruptedException {
        driver.get(BASE_URL);
        String fontSize = driver.findElement(By.xpath("//div[1]/h2")).getCssValue("font-size");
        String rgba = driver.findElement(By.xpath("//div[2]/h1[1]")).getCssValue("color");
        String hexcolor = Color.fromString(rgba).asHex();
        Assert.assertEquals("20px", fontSize);
        Assert.assertEquals("#ff0e0e", hexcolor);

    }

    @After
    public void tearDown() {
    }

}
