import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

    /*
   6. * Sortable Data Tables - Проверить содержимое нескольких (3-5) ячеек
    таблицы. Использовать xpath типа //table//tr[1]//td[1] - получение первой
    ячейки из первого ряда первой таблицы и так далее
     */

public class SortableDataTablesTest {
    private final By sortableDataTablesTestPage = By.xpath("//a[contains(@href, 'tables')]");

    @Test
    public void checkSortableDataTables() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--incognito");
        options.addArguments("--disable-notifications");
        options.addArguments("--start-maximized");

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(sortableDataTablesTestPage).click();

        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        List<List<WebElement>> tableData = new ArrayList<>();

        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            tableData.add(cells);
        }

        Assert.assertEquals(tableData.get(0).get(0).getText(), "Smith");
        Assert.assertEquals(tableData.get(1).get(1).getText(), "Frank");
        Assert.assertEquals(tableData.get(2).get(2).getText(), "jdoe@hotmail.com");
        Assert.assertEquals(tableData.get(3).get(3).getText(), "$50.00");

        //Таблица
        System.out.println("----------------------------------------------------------------------------------------------------------");
        String format = "| %-12s | %-12s | %-25s | %-10s | %-30s |%n";
        System.out.printf(format, "Last Name", "First Name", "Email", "Due", "Web Site");
        System.out.println("----------------------------------------------------------------------------------------------------------");
        for (List<WebElement> row : tableData) {
            System.out.printf(format,
                    row.get(0).getText(),
                    row.get(1).getText(),
                    row.get(2).getText(),
                    row.get(3).getText(),
                    row.get(4).getText()
            );
        }
        System.out.println("----------------------------------------------------------------------------------------------------------");

        driver.quit();
    }
}
