package Pages;


import Tests.Wait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class MenuWidgetPage {

    Actions a;

    @FindBy(css = "#navigate ul li:nth-child(1) a")
    private WebElement home;

    public void hoverOverHome(WebDriver wD)
    {
        a = new Actions(wD);
        Wait.waitToLoad(wD, "#navigate ul li:nth-child(1) a");

        a.moveToElement(home).perform();


    }

    public void moveDownMenu(WebDriver wD)
    {
        a = new Actions(wD);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        a.moveByOffset(0,35).perform();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        a.moveByOffset(0,35).perform();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        a.moveByOffset(0,35).perform();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        a.moveByOffset(0,35).perform();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        a.moveByOffset(0,35).perform();
}
}
