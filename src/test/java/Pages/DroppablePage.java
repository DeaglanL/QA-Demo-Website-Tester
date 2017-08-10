package Pages;

import Tests.Wait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class DroppablePage {

    Actions a;

    @FindBy(css = "#draggableview p")
    private WebElement findDragBox;

    @FindBy(css = "#droppableview")
    private WebElement dropBox;


    public String getDragBoxPos(WebDriver wD)
    {
        Wait.waitToLoad(wD,"#draggableview p");

        return findDragBox.getLocation().toString();
    }

    public String getDropBoxText(WebDriver wD)
    {
        Wait.waitToLoad(wD, "#draggableview p");
        return findDragBox.getText();
    }

    public void dragAndDropBox(WebDriver wD)
    {
        a = new Actions(wD);

        a.clickAndHold(findDragBox).moveToElement(dropBox).release().perform();
    }



}
