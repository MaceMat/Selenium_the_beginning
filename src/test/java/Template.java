import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.List;

public class Template {
    private WebDriver driver;



    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        driver.get("http://localhost");
    }

    @Test
    public void test() {

    }

    @After
    public void tearDown() {
     //   driver.close();
     //   driver.quit();
    }

}
