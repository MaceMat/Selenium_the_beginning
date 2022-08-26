import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.List;

public class NavigaciaTest {
    private WebDriver driver;
    private final String BASE_URL = "http://localhost";

    @Before
    public void setUp() { driver = new FirefoxDriver();
    }

    @Test
    public void test() throws InterruptedException {
        String expectedClass = "active";
        List<String> pages = new ArrayList<>();
        pages.add("vybersi");
        pages.add("clickmebaby");
        pages.add("tabulka");
        pages.add("redalert");
        pages.add("zjavenie");
        pages.add("kalkulacka");
        pages.add("xpathtrainingcenter");

        for (String page : pages) {
            driver.get(BASE_URL + "/" + page+".php");
            Assert.assertTrue(driver.findElement(By.xpath("//li[a/@href='" + page + ".php']"))
                    .getAttribute("class").contains(expectedClass));
        }

    }

    @After
    public void tearDown() {
    }

}
