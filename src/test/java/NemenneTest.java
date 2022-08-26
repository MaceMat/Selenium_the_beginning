import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NemenneTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new FirefoxDriver() ;

    }
    @Test
    public void test() {
        String BASE_URL = "http://localhost/nemenne.php";
        driver.get(BASE_URL);

        Assert.assertFalse(driver.findElement(By.xpath("//input[@value = 'Eva Mazikova']")).isEnabled());
        Assert.assertFalse(driver.findElement(By.id("sel1")).isEnabled());
        Assert.assertTrue(driver.findElement(By.id("sel2")).isEnabled());

        Assert.assertFalse(driver.findElement(By.id("sel2")).findElement(By.xpath("./option[1]")).isEnabled());
        Assert.assertFalse(driver.findElement(By.id("sel2")).findElement(By.xpath("./option[2]")).isEnabled());
        Assert.assertTrue(driver.findElement(By.id("sel2")).findElement(By.xpath("./option[3]")).isEnabled());

        Assert.assertFalse(driver.findElement(By.xpath("//button[contains(@class, 'btn-danger')]")).isEnabled());
        Assert.assertTrue(driver.findElement(By.xpath("//button[contains(@class, 'btn-succes')]")).isEnabled());

    }
    @After
    public void tearDown() {


    }

}
