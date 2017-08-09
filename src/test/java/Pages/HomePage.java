package Pages;

import Tests.Wait;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.support.FindBy;

public class HomePage {
    WebDriver wD;


    @FindBy(css = "#menu-item-140 a")
    private WebElement findDraggable;

    public void clickDraggable(WebDriver wD)
    {
        Wait.waitToLoad(wD,"#menu-item-140 a");
        findDraggable.click();
    }

    public void open(WebDriver wD)
    {
        wD.navigate().to("http://demoqa.com/");
    }


}
