package pageFactory.interactions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class DragAndDropSubTab {

    public WebDriver driver;
    public DragAndDropSubTab(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[contains(text(), 'Interactions ')]")
    WebElement interactionsTab;

    @FindBy(xpath = "//a[contains(text(), 'Drag and Drop ')]")
    WebElement dragAndDropSubTab;

    @FindBy(css = "a[href='Dynamic.html']")
    WebElement dynamiCSidSubTab;

    @FindBy(css = "#angular")
    WebElement angularDragIcon;

    @FindBy(css = "#droparea")
    WebElement dropArea;

    @FindBy(css = "#mongo")
    WebElement mongoDragIcon;

    @FindBy(css = "#node")
    WebElement nodeDragIcon;


    public void clickInteractionsTab() {
        interactionsTab.click();
    }
    public void moveToDragAndDropSubTab() {
        Actions action = new Actions(driver);
        action.moveToElement(dragAndDropSubTab).perform();
    }
    public void moveToDynamicSidSubTab() {
        Actions action = new Actions(driver);
        action.moveToElement(dynamiCSidSubTab).perform();
    }
    public void clickDynamicSidSubTab() {
        dynamiCSidSubTab.click();
    }
    public void dragAndDropIcon() {
        Actions act = new Actions(driver);
        act.dragAndDrop(angularDragIcon, dropArea).perform();
        act.dragAndDrop(mongoDragIcon, dropArea).perform();
        act.dragAndDrop(nodeDragIcon, dropArea).perform();
    }
}
