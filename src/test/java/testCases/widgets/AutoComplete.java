package testCases.widgets;
import org.testng.annotations.Test;
import pageFactory.widgets.AutoCompleteSubTab;
import testComponents.BaseTest;
import java.io.IOException;



public class AutoComplete extends BaseTest {

    AutoCompleteSubTab auto ;

    @Test
    public void autoComplete() throws IOException {

        auto = new AutoCompleteSubTab(driver);
        auto.hoverAndClickWidgetsTab();
        auto.clickAutoCompleteSubTab();
        auto.enterText("hello dear");
    }
}
