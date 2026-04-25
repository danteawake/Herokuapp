package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

    /*
   7. * Hovers - Сделать цепочку из действий: наведение на профиль,
    проверка имени, клик по ссылке, проверка, что нет 404 ошибки. Повторить
    для каждого из профилей. Использовать класс Actions и
    https://stackoverflow.com/questions/17293914/how-to-perform-mouseover-function
    -in-selenium-webdriver-using-java
     */

public class HoversTest extends BaseTest {
    private final By hoversTestPage = By.xpath("//a[contains(@href, 'hovers')]");
    private final By profile = By.className("figure");
    private final By name = By.className("figcaption");

    @Test
    public void checkHovers() {
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(hoversTestPage).click();
        List<WebElement> avatars = driver.findElements(profile);
        for (int i = 0; i < avatars.size(); i++) {
            WebElement avatar = avatars.get(i);
            //наведение на профиль
            actions.moveToElement(avatar).perform();
            WebElement nameWebElement = avatar.findElement(name);
            String expectedName = "name: user" + (i + 1);
            //проверка имени
            softAssert.assertEquals(nameWebElement.findElement(By.tagName("h5")).getText(), expectedName);
            //клик по ссылке
            nameWebElement.findElement(By.tagName("a")).click();
            //проверка, что нет 404 ошибки
            boolean isError = !driver.findElements(By.xpath("//h1[text()='Not Found']")).isEmpty();
            softAssert.assertFalse(isError);
            driver.navigate().back();
            avatars = driver.findElements(profile);
        }
        softAssert.assertAll();
    }
}
