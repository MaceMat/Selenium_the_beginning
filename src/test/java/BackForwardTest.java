import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BackForwardTest {
    private WebDriver driver;
    private final String BASE_URL = "http://localhost/registracia.php";

    @Before
    public void setUp() { driver = new FirefoxDriver();
    }

    @Test
    public void test() throws InterruptedException {
        driver.get(BASE_URL);
        String email = "brano@manohy.sk";
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.xpath("//a[@href = 'zenaalebomuz.php']")).click();
        driver.navigate().back();
        Assert.assertEquals(email, driver.findElement(By.name("email")).getAttribute("value"));

        driver.navigate().forward();
        Assert.assertTrue(driver.findElement(By.xpath("//img[@src= 'img/conchita.jpg']")).isDisplayed());

    }

    @After
    public void tearDown() {
    }

}
