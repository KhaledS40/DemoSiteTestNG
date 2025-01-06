package pageFactory.widgets;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class SliderSubTab {

    public WebDriver driver;

    public SliderSubTab(WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".dropdown-toggle[href='Widgets.html']")
    WebElement widgetTab;

    @FindBy(css = "a[href='Slider.html']")
    WebElement sliderSubTab;

    @FindBy(css = "#slider")
    WebElement sliderBar;


    public void hoverAndClickWidgetsTab(){

        widgetTab.click();
    }

    public void clickSliderSubTab() {

        sliderSubTab.click();
    }

    public void clickSliderBar() {

        sliderBar.click();
    }

    public void takeScreenShotOfBar() throws IOException {

        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        Files.copy(file.toPath(), new File("C:\\Users\\Khaled\\OneDrive\\Documents\\Jobs\\screenshot.jpg").toPath());
    }
}
