import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ScrollToTest {
    private WebDriver driver;
    JavascriptExecutor js;


    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost/tabulka.php");
        js = (JavascriptExecutor) driver;

    }

    @Test
    public void scrollTotest() {
        WebElement lastRow = driver.findElement(By.xpath("//table//tbody//tr[5]"));
        js.executeScript("arguments[0].scrollIntoView(true)",lastRow);

    }

    @Test
    public void scrollTest() {
        //Scrollovanie cez javascript, pomocou pixelov
        for (int i = 0; i < 4 ; i++) {
            js.executeScript("window.scrollBy(0,200)");

        }

    }

    @Test
    public void scrollToTheEnd() {

        //vypis dlzky stranky v pixeloch
        //System.out.println(js.executeScript("return document.body.scrollHeight"));

        //dlzka stranky ulozena v premennej
        long bodyHeight = (long) js.executeScript("return document.body.scrollHeight");
        //vypis dlzky stranky
        //System.out.println(bodyHeight);
        //prescrollovanie sa na koniec stranky
        js.executeScript("window.scrollBy(0," + bodyHeight + ")");


    }

    @Test
    public void scrollByOnePixelTest() {
        //scrollovanie po jednom pixely az na koniec stranky
        long bodyHeight = (long) js.executeScript("return document.body.scrollHeight");
        for (int i = 0; i < bodyHeight ; i++) {
            js.executeScript("window.scrollBy(0,1)");

        }

    }

    @After
    public void tearDown() {
        //   driver.close();
        //   driver.quit();
    }

}
