import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class TabulkaTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new FirefoxDriver() ;

    }
    @Test
    public void test() {
        String BASE_URL = "http://localhost/tabulka.php";
        driver.get(BASE_URL);

        /*
        Vyhladanie riadkov v tabulke a overenie
        int rows = Integer.parseInt(driver.findElement(By.xpath("//table/tbody/tr[last()]/td[1]")).getText());
        for (int i = 1; i < rows; i++ ) {
            Assert.assertFalse(driver.findElement(By.xpath("//table/tbody/tr["+ i +"]/td[3]")).getText().isEmpty());
        */

        //Vyhladanie pomocou Listu a WebElementu

        List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));
        for (WebElement row : rows) {
            Assert.assertFalse(row.findElement(By.xpath("./td[3]")).getText().isEmpty());

        }




    }

    @After
    public void tearDown() {


    }

}
