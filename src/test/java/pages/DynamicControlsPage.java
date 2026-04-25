package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DynamicControlsPage extends BasePage {

    public static final String TITLE_NAME = "Dynamic Controls";
    public static final String MESSAGE_ENABLE = "It's enabled!";
    public static final String MESSAGE_ITS_GONE = "It's gone!";
    private final By TITLE = By.xpath("//h4[text()='Dynamic Controls']");
    private final By REMOVE_BUTTON = By.xpath("//button[text()='Remove']");
    private final By CHECKBOX = By.id("checkbox");
    private final By MESSAGE = By.id("message");
    private final By INPUT = By.cssSelector("#input-example input");
    private final By ENABLE_BUTTON = By.xpath("//button[text()='Enable']");
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    public DynamicControlsPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(MAIN_URL + "/dynamic_controls");
    }

    public String getTitle() {
        return driver.findElement(TITLE).getText();
    }

    public String getMessageText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(MESSAGE)).getText();
    }

    public void removeButtonClick() {
        driver.findElement(REMOVE_BUTTON).click();
    }

    public boolean isCheckBoxVisible() {
        return driver.findElements(CHECKBOX).isEmpty();
    }

    public boolean isInputEnable() {
        return driver.findElement(INPUT).isEnabled();
    }

    public void enableButtonClick() {
        driver.findElement(ENABLE_BUTTON).click();
    }
}
