package testCases.widgets;
import org.testng.annotations.Test;
import pageFactory.widgets.AccordionSubTab;
import testComponents.BaseTest;
public class Accordion extends BaseTest {



    AccordionSubTab accordion ;

    @Test
    public void TestAccordion(){

        accordion = new AccordionSubTab(driver);
        accordion.hoverAndClickWidgetsTab();
        accordion.clickOnAccordion();
        accordion.clickOnReadability();
        accordion.clickOnSingleLineCoding();
        accordion.clickOnMethodChaining();
        accordion.clickOnCrossBrowserTesting();
    }
}
