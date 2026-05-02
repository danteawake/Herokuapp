package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.time.Duration;

    /*
   5. Typos - Проверить соответствие параграфа орфографии
    Локатор: By.tagName(“p”)
     */

public class TyposTest extends BaseTest {
    private final By typosPage = By.xpath("//a[contains(@href, 'typos')]");

    @Test
    public void checkTypos() {
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(typosPage).click();
        for (int i = 0; i < 10; i++) {
            String text = driver.findElements(By.tagName("p")).get(1).getText();
            softAssert.assertEquals(text, "Sometimes you'll see a typo, other times you won't.");
            driver.navigate().refresh();
        }
        softAssert.assertAll();
    }
}
