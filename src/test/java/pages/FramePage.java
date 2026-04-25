package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FramePage extends BasePage {

    private final By TITLE = By.cssSelector("h3");
    private final By IFRAME_LINK = By.linkText("iFrame");
    private final By IFRAME_ID = By.id("mce_0_ifr");
    private final By PARAGRAPH = By.tagName("p");

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    public FramePage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(MAIN_URL + "/frames");
    }

    public String getTitle() {
        return driver.findElement(TITLE).getText();
    }

    public void clickIFrameLink() {
        driver.findElement(IFRAME_LINK).click();
    }

    public void switchToFrame() {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(IFRAME_ID));
    }

    public String getFrameText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(PARAGRAPH)).getText();
    }

    public void exitFromFrame() {
        driver.switchTo().defaultContent();
    }
}
