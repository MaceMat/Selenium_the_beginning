import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class KalkulackaTest {
    private WebDriver driver;
    private final String BASE_URL = "http://localhost/kalkulacka.php";


    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get(BASE_URL);
    }

    @Test
    public void testCount() {
        driver.findElement(By.id("firstInput")).clear();
        driver.findElement(By.id("firstInput")).sendKeys("5");
        driver.findElement(By.id("secondInput")).clear();
        driver.findElement(By.id("secondInput")).sendKeys("5");
        driver.findElement(By.id("count")).click();
        Assert.assertEquals("10", driver.findElement(By.id("result")).getText());

        driver.findElement(By.id("firstInput")).clear();
        driver.findElement(By.id("firstInput")).sendKeys("35");
        driver.findElement(By.id("secondInput")).clear();
        driver.findElement(By.id("secondInput")).sendKeys("35");
        driver.findElement(By.id("count")).click();
        Assert.assertEquals("70", driver.findElement(By.id("result")).getText());

        driver.findElement(By.id("firstInput")).clear();
        driver.findElement(By.id("firstInput")).sendKeys("-6");
        driver.findElement(By.id("secondInput")).clear();
        driver.findElement(By.id("secondInput")).sendKeys("10");
        driver.findElement(By.id("count")).click();
        Assert.assertEquals("4", driver.findElement(By.id("result")).getText());

        driver.findElement(By.id("firstInput")).clear();
        driver.findElement(By.id("firstInput")).sendKeys("852");
        driver.findElement(By.id("secondInput")).clear();
        driver.findElement(By.id("secondInput")).sendKeys("-850");
        driver.findElement(By.id("count")).click();
        Assert.assertEquals("2", driver.findElement(By.id("result")).getText());

        driver.findElement(By.id("firstInput")).clear();
        driver.findElement(By.id("firstInput")).sendKeys("456");
        driver.findElement(By.id("secondInput")).clear();
        driver.findElement(By.id("secondInput")).sendKeys("85");
        driver.findElement(By.id("count")).click();
        Assert.assertEquals("541", driver.findElement(By.id("result")).getText());

    }

    @Test
    public void testDeduct() {
        driver.findElement(By.id("firstInput")).clear();
        driver.findElement(By.id("firstInput")).sendKeys("852");
        driver.findElement(By.id("secondInput")).clear();
        driver.findElement(By.id("secondInput")).sendKeys("-850");
        driver.findElement(By.id("count")).click();
        Assert.assertEquals("2", driver.findElement(By.id("result")).getText());

        driver.findElement(By.id("firstInput")).clear();
        driver.findElement(By.id("firstInput")).sendKeys("456");
        driver.findElement(By.id("secondInput")).clear();
        driver.findElement(By.id("secondInput")).sendKeys("85");
        driver.findElement(By.id("count")).click();
        Assert.assertEquals("541", driver.findElement(By.id("result")).getText());
    }

    @After
    public void tearDown() {
     //   driver.close();
     //   driver.quit();
    }

}
