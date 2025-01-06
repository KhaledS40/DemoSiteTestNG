package testCases.switchTo;

import org.testng.annotations.Test;

import pageFactory.switchToTab.FramesSubTab;
import testComponents.BaseTest;

public class Frames extends BaseTest {
	
	FramesSubTab frame1 = new FramesSubTab(driver);
	
	@Test
	public void testFrameTab() {
		
		frame1 = new FramesSubTab(driver);
		
		frame1.clickSwitchToLink();
		frame1.clickOnFramesTab();
		frame1.enterTextInFrameBox();
		frame1.clickOnIframWithinIframe();
		frame1.enterTextInNestedFrameBox();
	}
}
