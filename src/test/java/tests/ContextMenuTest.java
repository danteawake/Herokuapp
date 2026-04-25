package tests;

import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class ContextMenuTest extends BaseTest{

    @Test
    public void textValidation(){
        contextMenuPage.open();
        assertEquals("Context Menu",contextMenuPage.getTitle());
        contextMenuPage.alertPerform();
        assertEquals("You selected a context menu",contextMenuPage.getHotSpotText());
        contextMenuPage.alertClose();
    }
}
