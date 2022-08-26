import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class XpathTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new FirefoxDriver() ;

    }
    @Test
    public void test() {
        String BASE_URL = "http://localhost/tabulka.php";
        driver.get(BASE_URL);
        driver.findElement(By.xpath("//table/tbody/tr[6]/td[3]"));

    }
    @After
    public void tearDown() {


    }

}
