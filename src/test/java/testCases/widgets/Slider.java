package testCases.widgets;
import org.testng.annotations.Test;
import pageFactory.widgets.SliderSubTab;
import testComponents.BaseTest;



public class Slider extends BaseTest {

    SliderSubTab slider;

    @Test
    public void Sliderlink(){

        slider = new SliderSubTab(driver);
        slider.hoverAndClickWidgetsTab();
        slider.clickSliderSubTab();
        slider.clickSliderBar();
        //slider.takeScreenShotOfBar();

        System.out.println("this is slider");


    }
}
