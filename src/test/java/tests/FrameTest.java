package tests;

import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class FrameTest extends BaseTest {

    @Test
    public void checkTextInsideFrame() {
        framePage.open();
        assertEquals("Frames", framePage.getTitle());
        framePage.clickIFrameLink();
        assertEquals("An iFrame containing the TinyMCE WYSIWYG Editor", framePage.getTitle());
        framePage.switchToFrame();
        assertEquals("Your content goes here.", framePage.getFrameText());
    }
}
