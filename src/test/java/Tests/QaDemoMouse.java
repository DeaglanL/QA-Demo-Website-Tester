package Tests;

import Pages.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.sun.jna.platform.win32.Wdm;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;



import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class QaDemoMouse {

    private static WebDriver cwD;
    private static ChromeOptions chromeOptions = new ChromeOptions();


    private HomePage hp;
    private DraggablePage dragPage;
    private DroppablePage dropPage;
    private MenuWidgetPage menu;


    //Extent report generation
    private static ExtentReports report;
    private ExtentTest chromeTest;
    private ExtentTest fireffoxtest;
    private ExtentTest ietest;
    private static String reportFilePath = "report.html";



    @BeforeClass
    public static void beforeClass()
    {
        chromeOptions.addArguments("--start-maximized"); //Set chrome to open full screen

        report = new ExtentReports();
        ExtentHtmlReporter extentHtmlReporter = new ExtentHtmlReporter(reportFilePath);
        extentHtmlReporter.config().setReportName("DemoQa.com");
        extentHtmlReporter.config().setDocumentTitle("The demo site test report");
        report.attachReporter(extentHtmlReporter);
    }

    @Before
    public void beforeT()
    {
        cwD = new ChromeDriver(chromeOptions);



        hp = PageFactory.initElements(cwD, HomePage.class);
        dragPage = PageFactory.initElements(cwD,DraggablePage.class);
        dropPage = PageFactory.initElements(cwD,DroppablePage.class);
        menu = PageFactory.initElements(cwD, MenuWidgetPage.class);


        chromeTest = report.createTest("Chrome test");
        fireffoxtest = report.createTest("Firefox test");
        ietest= report.createTest("Internet explorer test");



    }

    @Test
    public void chromeTest() throws IOException {

        //fireFoxTest();
        //ieTest();

        hp.open(cwD);
        chromeTest.log(Status.INFO, "Website opened");

        hp.clickDraggable(cwD);
        chromeTest.log(Status.INFO, "Navigate to draggable page");

        String initialBoxPos = dragPage.getDragBoxPositon(cwD);
        chromeTest.log(Status.INFO, "Click and drag box" + chromeTest.addScreenCaptureFromPath(ScreenShot.take(cwD, "before move")));


        dragPage.clickAndDrag(cwD);

        assertNotEquals("Has not moved", initialBoxPos, dragPage.getDragBoxPositon(cwD));

        if (!initialBoxPos.equals(dragPage.getDragBoxPositon(cwD)))
        {
            chromeTest.log (Status.PASS,"Box Moved"+ chromeTest.addScreenCaptureFromPath(ScreenShot.take(cwD, "after move")));

        }
        else
            chromeTest.fail("Box not moved"+ chromeTest.addScreenCaptureFromPath(ScreenShot.take(cwD, "after move")));


        dragPage.clickDroppable();
        chromeTest.log(Status.INFO, "Navigate to droppable page");

        initialBoxPos = dropPage.getDragBoxPos(cwD);

        dropPage.dragAndDropBox(cwD);

        chromeTest.log(Status.INFO, "Drag and drop box" + chromeTest.addScreenCaptureFromPath(ScreenShot.take(cwD, "before move")));



        assertNotEquals("Has not moved", initialBoxPos, dropPage.getDragBoxPos(cwD));

        if (!initialBoxPos.equals(dropPage.getDragBoxPos(cwD)))
        {
            chromeTest.log (Status.PASS,"Dragged and Dropped" + chromeTest.addScreenCaptureFromPath(ScreenShot.take(cwD, "after move")));
        }
        else
            chromeTest.fail("Box not moved"+ chromeTest.addScreenCaptureFromPath(ScreenShot.take(cwD, "after move")));


        dropPage.clickMenuLink();

        menu.hoverOverHome(cwD);

        menu.moveDownMenu(cwD);

        menu.clickSubMenu();

        menu.hoverOverSubMenuHome(cwD);

        menu.moveDownMenu(cwD);



    }


    @After
    public void afterT()
    {
        cwD.quit();





    }
    @AfterClass
    public static void afterClass()
    {
        report.flush();

    }
}



