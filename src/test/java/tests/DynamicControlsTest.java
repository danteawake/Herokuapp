package tests;

import org.testng.annotations.Test;

import static org.testng.AssertJUnit.*;
import static pages.DynamicControlsPage.*;


public class DynamicControlsTest extends BaseTest {

    @Test
    public void enableDisableButtonsCheck() {
        dynamicControlsPage.open();
        assertEquals(TITLE_NAME, dynamicControlsPage.getTitle());
        dynamicControlsPage.removeButtonClick();
        assertEquals(MESSAGE_ITS_GONE, dynamicControlsPage.getMessageText());
        assertTrue("Чекбокс не пропал", dynamicControlsPage.isCheckBoxVisible());
        assertFalse("Поле ввода должно быть заблокировано", dynamicControlsPage.isInputEnable());
        dynamicControlsPage.enableButtonClick();
        assertEquals(MESSAGE_ENABLE, dynamicControlsPage.getMessageText());
        assertTrue("Поле ввода должно быть доступно", dynamicControlsPage.isInputEnable());
    }
}
