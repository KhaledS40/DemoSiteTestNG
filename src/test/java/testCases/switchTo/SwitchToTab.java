package testCases.switchTo;
import org.testng.annotations.Test;
import pageFactory.switchToTab.SwitchToTabPage;
import pageFactory.switchToTab.WindowsSubTabPage;
import testComponents.BaseTest;
import java.io.IOException;



public class SwitchToTab extends BaseTest {

    SwitchToTabPage switchTo = new SwitchToTabPage(driver);
    WindowsSubTabPage window = new WindowsSubTabPage(driver);

    @Test
    public void switchToTab() throws IOException {

        switchTo = new SwitchToTabPage(driver);
        switchTo.clickSwitchToLink();
        switchTo.clickAlertBox();
        switchTo.clickAlertLink();
        switchTo.clickCancelTab();
        switchTo.clickAlertWithOkCancelLink();
        switchTo.clickTextbox();
        switchTo.clickAlertButtonWindow();
}

    @Test(groups = {"smoke"})
    public void testWindowsSubTab() {

        window = new WindowsSubTabPage(driver);
        window.clickSwitchToLink();
        window.clickWindowsSubTab();
        window.clickTabbedWindowsTab();

    }
}