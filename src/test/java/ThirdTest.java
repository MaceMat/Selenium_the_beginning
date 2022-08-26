import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ThirdTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new FirefoxDriver() ;

    }
    @Test
    public void test() {
        String BASE_URL = "http://localhost/registracia.php";
        driver.get(BASE_URL);
        driver.findElement(By.xpath("//form/div[1]/input")).sendKeys("brano@peres.sk");
        driver.findElement(By.xpath("//form/div[2]/input")).sendKeys("Brano");
        driver.findElement(By.xpath("//form/div[3]/input")).sendKeys("Peres");
        driver.findElement(By.xpath("//form/div[4]/input")).sendKeys("123456");
        driver.findElement(By.xpath("//form/div[5]/input")).sendKeys("123456");

    }
    @After
    public void tearDown() {


    }

}
