package Pages;

        import Tests.Wait;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;

        import org.openqa.selenium.interactions.Actions;
        import org.openqa.selenium.support.FindBy;

public class DraggablePage {

    Actions a;

    @FindBy(css = "#draggable")
    private WebElement findDragObject;

    @FindBy(css = "#menu-item-141 > a:nth-child(1)")
    private WebElement findDroppable;

    public String getDragBoxPositon(WebDriver wD)
    {
        Wait.waitToLoad(wD,"#draggable");

        return findDragObject.getLocation().toString();
    }

    public void  clickAndDrag(WebDriver wD)
    {
        a = new Actions(wD);

        a.clickAndHold(findDragObject).moveByOffset(1160, 1170).release().perform();
    }

    public void clickDroppable()
    {
        findDroppable.click();
    }
}
