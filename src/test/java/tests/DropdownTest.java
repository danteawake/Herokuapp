package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

    /*
    3. Dropdown - Взять все элементы дроп-дауна и проверить их наличие.
    Выбрать первый, проверить, что он выбран, выбрать второй, проверить, что
    он выбран
     */

public class DropdownTest extends BaseTest {
    private final By dropdownPage = By.xpath("//a[contains(@href, 'dropdown')]");
    private final By dropdownXpath = By.xpath("//select[@id='dropdown']");

    @Test
    public void checkDropdown() {
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(dropdownPage).click();
        List<WebElement> optionsDropdown = driver.findElements(By.xpath("//select[@id='dropdown']/option[not(@disabled)]"));
        WebElement firstOption = optionsDropdown.get(0);
        WebElement secondOption = optionsDropdown.get(1);
        WebElement dropdown = driver.findElement(dropdownXpath);
        dropdown.click();
        softAssert.assertEquals(optionsDropdown.size(), 2);
        firstOption.click();
        dropdown.click();
        Assert.assertTrue(firstOption.isSelected());
        dropdown.click();
        secondOption.click();
        Assert.assertTrue(secondOption.isSelected());
        softAssert.assertAll();
    }
}
