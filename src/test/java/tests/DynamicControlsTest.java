package tests;

import org.testng.annotations.Test;

import static org.testng.AssertJUnit.*;


public class DynamicControlsTest extends BaseTest {

    @Test
    public void enableDisableButtonsCheck() {
        dynamicControlsPage.open();
        assertEquals("Dynamic Controls", dynamicControlsPage.getTitle());
        dynamicControlsPage.removeButtonClick();
        assertEquals("It's gone!", dynamicControlsPage.getMessageText());
        assertTrue("Чекбокс не пропал", dynamicControlsPage.isCheckBoxVisible());
        assertFalse("Поле ввода должно быть заблокировано", dynamicControlsPage.isInputEnable());
        dynamicControlsPage.enableButtonClick();
        assertEquals("It's enabled!", dynamicControlsPage.getMessageText());
        assertTrue("Поле ввода должно быть доступно", dynamicControlsPage.isInputEnable());
    }
}
