package tests;

import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;
import static pages.UploadPage.*;

public class UploadTest extends BaseTest {

    @Test
    public void uploadFileNameCheck() {
        uploadPage.open();
        assertEquals(TITLE_NAME, uploadPage.getTitle());
        uploadPage.uploadFile(ABSOLUTE_PATH);
        assertEquals(FILE_NAME, uploadPage.getUploadedFileName());
    }
}
