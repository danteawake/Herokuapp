package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class ContextMenuPage extends BasePage {

    public static final String TITLE_NAME = "Context Menu";
    public static final String HOT_SPOT_TEXT = "You selected a context menu";
    private final By TITLE = By.xpath("//h3[text()='Context Menu']");
    private final By HOTSPOT = By.id("hot-spot");
    Actions actions = new Actions(driver);

    public ContextMenuPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(MAIN_URL + "/context_menu");
    }

    public String getTitle() {
        return driver.findElement(TITLE).getText();
    }

    public String getHotSpotText() {
        Alert alert = driver.switchTo().alert();
        return alert.getText();
    }

    public void alertPerform() {
        actions.contextClick(driver.findElement(HOTSPOT)).perform();
    }

    public void alertClose() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
}
