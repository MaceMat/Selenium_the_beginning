import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AlertTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new FirefoxDriver() ;

    }
    @Test
    public void test() {
        String BASE_URL = "http://localhost/redalert.php";
        driver.get(BASE_URL);

        //alert1
        driver.findElement(By.id("alert1")).click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        driver.findElement(By.xpath("//div[@class = 'result']/h1")).getText();

        //alert2
        driver.findElement(By.id("alert2")).click();
        Alert alert1 = driver.switchTo().alert();
        Assert.assertEquals("Second alert!", alert1.getText());
        alert1.dismiss();
        Assert.assertEquals("Negative", driver.findElement(By.xpath("//div[@class = 'result']/h1")).getText());

        //alert3
        driver.findElement(By.id("alert3")).click();
        Alert alert2 = driver.switchTo().alert();
        alert2.sendKeys("Yuri");
        alert2.accept();
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class = 'result']/h1")).getText().contains("Yuri"));



    }
    @After
    public void tearDown() {


    }

}
