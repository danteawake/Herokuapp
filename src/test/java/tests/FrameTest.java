package tests;

import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;
import static pages.FramePage.*;

public class FrameTest extends BaseTest {

    @Test
    public void checkTextInsideFrame() {
        framePage.open();
        assertEquals(TITLE_1_NAME, framePage.getTitle());
        framePage.clickIFrameLink();
        assertEquals(TITLE_2_NAME, framePage.getTitle());
        framePage.switchToFrame();
        assertEquals(FRAME_TEXT, framePage.getFrameText());
    }
}
