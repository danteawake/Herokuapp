package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

    /*
    8. * Notification Messages - кликнуть на кнопку, дождаться появления
    нотификации, проверить соответствие текста ожиданиям
     */

public class NotificationMessageTest extends BaseTest{
    private final By pageLink = By.xpath("//a[contains(@href, 'notification_message')]");
    private final By clickHere = By.linkText("Click here");
    private final By message = By.id("flash");

    @Test
    public void checkNotificationMessage() {
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(pageLink).click();
        for (int i = 0; i < 10; i++) {
            driver.findElement(clickHere).click();
            String messageText = driver.findElement(message).getText();
            boolean isSuccess = messageText.contains("Action successful");
            softAssert.assertTrue(isSuccess);
        }
        softAssert.assertAll();
    }
}