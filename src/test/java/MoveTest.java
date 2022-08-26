import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class MoveTest {
    private WebDriver driver;
    private final String BASE_URL = "http://localhost/moveme.php";


    @Before
    public void setUp() { driver = new FirefoxDriver();
    }

    @Test
    public void test() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get(BASE_URL);
        WebElement head = driver.findElement(By.id("donald"));
        WebElement tree = driver.findElement(By.id("tree"));


        Actions actions = new Actions(driver);
        actions.dragAndDrop(head, tree).build().perform();

        WebElement hooo = driver.findElement(By.xpath("//div[contains(@class,'succes')]/h2"));
        Assert.assertTrue(hooo.isDisplayed());
        Assert.assertEquals("HOOO HOOOOO !!!!", hooo.getText());

    }

    @After
    public void tearDown() {
     //   driver.close();
       driver.quit();
    }

}
