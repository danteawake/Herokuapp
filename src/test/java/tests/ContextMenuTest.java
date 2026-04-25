package tests;

import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;
import static pages.ContextMenuPage.HOT_SPOT_TEXT;
import static pages.ContextMenuPage.TITLE_NAME;

public class ContextMenuTest extends BaseTest {

    @Test
    public void textValidation() {
        contextMenuPage.open();
        assertEquals(TITLE_NAME, contextMenuPage.getTitle());
        contextMenuPage.alertPerform();
        assertEquals(HOT_SPOT_TEXT, contextMenuPage.getHotSpotText());
        contextMenuPage.alertClose();
    }
}
