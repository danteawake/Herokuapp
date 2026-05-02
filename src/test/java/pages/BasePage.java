package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {

    protected final String MAIN_URL = "https://the-internet.herokuapp.com/";
    protected final By FOOTER = By.id("page-footer");
    protected final By FOOTER_LINK = By.xpath("//a[text()='Elemental Selenium']");

    private final By H1_WELCOME = By.className("heading");
    private final By H2_EXAMPLES = By.xpath("<h2>Available Examples</h2>");
    private final By TABS = By.cssSelector("ul li");

    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
}
