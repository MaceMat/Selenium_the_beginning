import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class ChooseTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new FirefoxDriver() ;

    }
    @Test
    public void test() {
        String BASE_URL = "http://localhost/vybersi.php";
        driver.get(BASE_URL);
        new Select(driver.findElement(By.className("form-control"))).selectByVisibleText("Diglett");
        System.out.println(driver.findElement(By.xpath("//div/h3")).getText());
        Assert.assertTrue(driver.findElement(By.xpath("//div/h3")).getText().contains("Diglett"));

    }
    @After
    public void tearDown() {


    }

}
