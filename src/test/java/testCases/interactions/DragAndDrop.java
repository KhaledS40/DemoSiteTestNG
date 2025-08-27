package testCases.interactions;
import org.testng.annotations.Test;
import pageFactory.interactions.DragAndDropSubTab;
import testComponents.BaseTest;


public class DragAndDrop extends BaseTest{

    DragAndDropSubTab drag;

    @Test
    public void testDragAndDrop(){
        drag = new DragAndDropSubTab(driver);
        drag.clickInteractionsTab();
        drag.moveToDragAndDropSubTab();
        drag.moveToDynamicSidSubTab();
        drag.clickDynamicSidSubTab();
        drag.dragAndDropIcon();
    }
}
