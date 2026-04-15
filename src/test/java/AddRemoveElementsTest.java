import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

/*
1. Add/Remove Elements - добавить 2 элемента, удалить элемент,
проверить количество элементов DELETE
Локаторы xpath:
a. By.xpath("//button[text()='Add Element']")
b. By.xpath("//button[text()='Delete']")
 */

public class AddRemoveElementsTest {
    private final By addButtonLocator = By.xpath("//button[text()='Add Element']");
    private final By deleteButtonLocator = By.xpath("//button[text()='Delete']");
    private final By addRemovePage = By.xpath("//a[contains(@href, 'add_remove_elements')]");

    @Test
    public void checkAddRemoveElement() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--incognito");
        options.addArguments("--disable-notifications");

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(addRemovePage).click();
        driver.findElement(addButtonLocator).click();
        driver.findElement(addButtonLocator).click();

        int size1 = driver.findElements(deleteButtonLocator).size();
        Assert.assertEquals(size1, 2);

        driver.findElements(deleteButtonLocator).get(1).click();

        int size2 = driver.findElements(deleteButtonLocator).size();
        Assert.assertEquals(size2, 1);

        driver.quit();
    }
}
