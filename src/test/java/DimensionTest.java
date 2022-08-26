import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DimensionTest {
    private WebDriver driver;
    private final String BASE_URL = "http://localhost/moveme.php";


    @Before
    public void setUp() { driver = new FirefoxDriver();
    }

    @Test
    public void test() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get(BASE_URL);
        Assert.assertTrue(driver.findElement(By.xpath("//img[@id= 'donald']")).isDisplayed());

    }

    @After
    public void tearDown() {
    }

}
