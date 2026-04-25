package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UploadPage extends BasePage {

    public static final String TITLE_NAME = "File Uploader";
    public static final String ABSOLUTE_PATH = "C:\\Users\\dante\\OneDrive\\Desktop\\Текстовый документ (4).txt";
    public static final String FILE_NAME = "Текстовый документ (4).txt";
    private final By TITLE = By.xpath("//h3[text()='File Uploader']");
    private final By FILE_INPUT = By.id("file-upload");
    private final By SUBMIT_BUTTON = By.id("file-submit");
    private final By UPLOADED_FILENAME = By.id("uploaded-files");
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    public UploadPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(MAIN_URL + "/upload");
    }

    public String getTitle() {
        return driver.findElement(TITLE).getText();
    }

    public void uploadFile(String absolutePath) {
        driver.findElement(FILE_INPUT).sendKeys(absolutePath);
        driver.findElement(SUBMIT_BUTTON).click();
    }

    public String getUploadedFileName() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(UPLOADED_FILENAME)).getText();
    }
}
