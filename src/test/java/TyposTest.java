import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

    /*
   5. Typos - Проверить соответствие параграфа орфографии
    Локатор: By.tagName(“p”)
     */

public class TyposTest {
    private final By typosPage = By.xpath("//a[contains(@href, 'typos')]");

    @Test
    public void checkTypos() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--incognito");
        options.addArguments("--disable-notifications");

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        SoftAssert softAssert = new SoftAssert();

        driver.findElement(typosPage).click();
        for (int i = 0; i < 10; i++) {
            String text = driver.findElements(By.tagName("p")).get(1).getText();
            softAssert.assertEquals(text, "Sometimes you'll see a typo, other times you won't.");
            driver.navigate().refresh();
        }

        driver.quit();
        softAssert.assertAll();
    }
}
