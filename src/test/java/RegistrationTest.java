import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class RegistrationTest {
    private WebDriver driver;
    private final String BASE_URL = "http://localhost/registracia.php";

    private String validEmail = "brano@manohy.sk";
    private String validName = "brano";
    private String validSurname = "peres";

    @Before
    public void setUp() { driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get(BASE_URL);
    }

    @Test
    public void testMissingAllInputs() {
        driver.findElement(By.id("checkbox")).click();

        driver.findElement(By.xpath("//button[@type= 'submit']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class, 'alert-danger')]")).isDisplayed());

    }

    @Test
    public void testMissingPassword() {
        driver.findElement(By.id("checkbox")).click();
        driver.findElement(By.name("email")).sendKeys(validEmail);
        driver.findElement(By.name("name")).sendKeys(validName);
        driver.findElement(By.name("surname")).sendKeys(validSurname);

        driver.findElement(By.xpath("//button[@type= 'submit']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class, 'alert-danger')]")).isDisplayed());

    }

    @Test
    public void testPasswordMissMach() {
        driver.findElement(By.id("checkbox")).click();

        driver.findElement(By.name("email")).sendKeys(validEmail);
        driver.findElement(By.name("name")).sendKeys(validName);
        driver.findElement(By.name("surname")).sendKeys(validSurname);

        driver.findElement(By.name("password")).sendKeys("blud8523");
        driver.findElement(By.name("password-repeat")).sendKeys("katarinka");

        driver.findElement(By.xpath("//button[@type= 'submit']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class, 'alert-danger')]")).isDisplayed());

    }

    @Test
    public void testMissingRobotCheckbox() {
        driver.findElement(By.name("email")).sendKeys(validEmail);
        driver.findElement(By.name("name")).sendKeys(validName);
        driver.findElement(By.name("surname")).sendKeys(validSurname);

        driver.findElement(By.name("password")).sendKeys("blud8523");
        driver.findElement(By.name("password-repeat")).sendKeys("katarinka");

        driver.findElement(By.xpath("//button[@type= 'submit']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class, 'alert-danger')]")).isDisplayed());

    }

    @Test
    public void testSuccessRegistration() {
        driver.findElement(By.name("email")).sendKeys(validEmail);
        driver.findElement(By.name("name")).sendKeys(validName);
        driver.findElement(By.name("surname")).sendKeys(validSurname);

        driver.findElement(By.name("password")).sendKeys("katarinka");
        driver.findElement(By.name("password-repeat")).sendKeys("katarinka");

        driver.findElement(By.id("checkbox")).click();

        driver.findElement(By.xpath("//button[@type= 'submit']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class,'alert-succes')]")).isDisplayed());

    }

    @Test
    public void testInputErrorBorder() {
        String expectedClass = "has-error";
        driver.findElement(By.xpath("//button[@type= 'submit']")).click();
        List<WebElement> formDivs = driver.findElements(By.xpath("//div[input]"));

        for (WebElement formDiv : formDivs) {
            Assert.assertTrue(formDiv.getAttribute("class").contains(expectedClass));
        }

        Assert.assertTrue(driver.findElement(By.xpath("//div[label[input[@id='checkbox']]]"))
                .getAttribute("class")
                .contains(expectedClass));

    }

    @After
    public void tearDown() {
     //   driver.close();
        driver.quit();
    }

}
