package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

    /*
    2. Checkboxes - проверить, что первый чекбокс unchecked, отметить
    первый чекбокс, проверить что он checked. Проверить, что второй чекбокс
    checked, сделать uncheck, проверить, что он unchecked
     */

public class CheckboxesTest extends BaseTest {
    private final By checkboxesPage = By.xpath("//a[contains(@href, 'checkboxes')]");
    private final By checkbox = By.cssSelector("[type=checkbox]");

    @Test
    public void checkCheckboxes() {
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(checkboxesPage).click();
        List<WebElement> checkboxes = driver.findElements(checkbox);
        WebElement firstCheckbox = checkboxes.get(0);
        WebElement secondCheckbox = checkboxes.get(1);
        softAssert.assertFalse(firstCheckbox.isSelected());
        firstCheckbox.click();
        Assert.assertTrue(firstCheckbox.isSelected());
        Assert.assertTrue(secondCheckbox.isSelected());
        secondCheckbox.click();
        Assert.assertFalse(secondCheckbox.isSelected());
        softAssert.assertAll();
    }
}
