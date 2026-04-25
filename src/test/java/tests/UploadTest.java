package tests;

import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class UploadTest extends BaseTest {

    @Test
    public void uploadFileNameCheck() {
        uploadPage.open();
        assertEquals("File Uploader", uploadPage.getTitle());
        uploadPage.uploadFile("C:\\Users\\dante\\OneDrive\\Desktop\\Текстовый документ (4).txt");
        assertEquals("Текстовый документ (4).txt", uploadPage.getUploadedFileName());
    }
}
