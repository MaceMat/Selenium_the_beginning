import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class TitleTest {
    private WebDriver driver;
    private final String BASE_URL = "http://localhost";


    @Before
    public void setUp() { driver = new FirefoxDriver();
    }

    @Test
    public void test() throws InterruptedException {
        driver.get(BASE_URL);

        List<WebElement> pages = driver.findElements(By.xpath("//nav//ul/li/a"));
        List<String> pagesUrls = new ArrayList<>();

        for (WebElement page : pages) {
            pagesUrls.add(page.getAttribute("href"));
        }

        for (String pageUrl : pagesUrls) {
            driver.get(pageUrl);
            String expectedTitle = pageUrl.substring(pageUrl.lastIndexOf("/")+1,pageUrl.indexOf(".php"));
            Assert.assertTrue(driver.getTitle().contains(expectedTitle.substring(0,1).toUpperCase() +  expectedTitle.substring(1)));
        }

    }

    @After
    public void tearDown() {
    }

}
