import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class JavaScriptExecutor {
    private WebDriver driver;



    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost/tabulka.php");
    }

    @Test
    public void testHighLight() {
        List<WebElement> rows = driver.findElements(By.xpath("//table//tbody//tr"));

        for (WebElement row : rows) {
            if (row.getText().contains("Alfonz")){
                highLight(row);
            }
        }
    }

    private void highLight(WebElement row) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].style.border='3px solid red'", row);
    }

    @After
    public void tearDown() {
     //   driver.close();
     //   driver.quit();
    }

}
