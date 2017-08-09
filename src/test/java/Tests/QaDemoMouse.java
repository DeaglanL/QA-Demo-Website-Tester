package Tests;

import Pages.*;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;

public class QaDemoMouse {

    private static WebDriver wD;
    private static ChromeOptions chromeOptions = new ChromeOptions();

    private HomePage hp;
    private DraggablePage dragPage;


    @BeforeClass
    public static void beforeClass()
    {
        chromeOptions.addArguments("--start-maximized"); //Set chrome to open full screen
    }
    @Before
    public void beforeT()
    {
        wD = new ChromeDriver(chromeOptions); //Initialise webdriver

        hp = PageFactory.initElements(wD, HomePage.class);
        dragPage = PageFactory.initElements(wD,DraggablePage.class);

    }
    @Test
    public void test1()
    {

        hp.open(wD);
        hp.clickDraggable(wD);

        String initialBoxPos = dragPage.getDragBoxPositon(wD);


        Assert.fail("Not implemented");

    }
    @After
    public void afterT()
    {
        wD.quit();

    }
    @AfterClass
    public static void afterClass()
    {

    }
}



