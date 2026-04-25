package pages;

import org.openqa.selenium.WebDriver;

public class BasePage {

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    WebDriver driver;
}
