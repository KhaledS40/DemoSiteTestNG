package testCases.switchTo;

import org.testng.annotations.Test;
import pageFactory.switchToTab.WindowsSubTabPage;
import testComponents.BaseTest;

public class WindowsTab extends BaseTest {

    WindowsSubTabPage window = new WindowsSubTabPage(driver);

    @Test
    public void testWindowsSubTab() {

        window = new WindowsSubTabPage(driver);

        window.clickSwitchToLink();
        window.clickWindowsSubTab();
        window.clickTabbedWindowsTab();

    }
}
