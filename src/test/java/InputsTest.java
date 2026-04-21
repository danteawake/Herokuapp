import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

    /*
    4. Inputs - Проверить на возможность ввести различные цифровые и
    не цифровые значения, используя Keys.ARROW_UP И
    Keys.ARROW_DOWN
     */

public class InputsTest {
    private final By inputsPage = By.xpath("//a[contains(@href, 'inputs')]");
    private final By inputField = By.tagName("input");
    private String en = "abcdefghijklmnopqrstuvwxyz";
    private String ru = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
    private String specialChars = "!@#$%^&*()_+-=[]{}|;':\",./<>?`~";

    @Test
    public void checkInputs() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--incognito");
        options.addArguments("--disable-notifications");

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        SoftAssert softAssert = new SoftAssert();

        driver.findElement(inputsPage).click();
        WebElement input = driver.findElement(inputField);

        input.sendKeys(Keys.ARROW_UP);
        input.sendKeys(Keys.ARROW_UP);
        input.sendKeys(Keys.ARROW_UP);
        softAssert.assertEquals(input.getAttribute("value"), "3");

        input.sendKeys(Keys.ARROW_DOWN);
        input.sendKeys(Keys.ARROW_DOWN);
        input.sendKeys(Keys.ARROW_DOWN);
        input.sendKeys(Keys.ARROW_DOWN);
        Assert.assertEquals(input.getAttribute("value"), "-1");

        input.clear();
        input.sendKeys(en); //остается "e", не понял как поймать автотестом
        Assert.assertEquals(input.getAttribute("value"), "");

        input.clear();
        input.sendKeys(ru);
        Assert.assertEquals(input.getAttribute("value"), "");

        input.clear();
        input.sendKeys(specialChars);  //остается "+-,"
        Assert.assertEquals(input.getAttribute("value"), "");

        driver.quit();
        softAssert.assertAll();
    }
}
