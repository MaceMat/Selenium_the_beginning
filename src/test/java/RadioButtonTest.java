import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class RadioButtonTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new FirefoxDriver() ;

    }
    @Test
    public void test() {
        String BASE_URL = "http://localhost/zenaalebomuz.php";
        driver.get(BASE_URL);

        driver.findElement(By.xpath("//input[@value ='wurst']")).click();
        Assert.assertEquals("It's wurst",driver.findElement(By.xpath("//h1[@class ='description text-center']")).getText());
        Assert.assertTrue(driver.findElement(By.xpath("//input[@value ='wurst']")).isSelected());
        Assert.assertFalse(driver.findElement(By.xpath("//input[@value ='conchita']")).isSelected());


    }
    @After
    public void tearDown() {


    }

}
