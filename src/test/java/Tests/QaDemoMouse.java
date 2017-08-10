package Tests;

import Pages.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class QaDemoMouse {

    private static WebDriver cwD;
    private static ChromeOptions chromeOptions = new ChromeOptions();

    private static WebDriver iEwD;

    private static WebDriver fFwD;

    private HomePage hp;
    private DraggablePage dragPage;
    private DroppablePage dropPage;


    //Extent report generation
    private static ExtentReports report;
    private ExtentTest chromeTest;
    private ExtentTest fireffoxtest;
    private ExtentTest ietest;
    private static String reportFilePath = "report.html";


    private int counter;

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
        //cwD = new ChromeDriver(chromeOptions);

        fFwD = new FirefoxDriver();

        //iEwD = new InternetExplorerDriver();





        hp = PageFactory.initElements(fFwD, HomePage.class);
        dragPage = PageFactory.initElements(fFwD,DraggablePage.class);
        dropPage = PageFactory.initElements(fFwD,DroppablePage.class);

        chromeTest = report.createTest("Chrome test");
        fireffoxtest = report.createTest("Firefox test");
        ietest= report.createTest("Internet explorer test");



    }

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


        //assertEquals("Website not updated", dropPage.getDropBoxText(wD), "Dropped!");





    }

    @Test
    public void fireFoxTest() throws IOException {

        hp.open(fFwD);
        fireffoxtest.log(Status.INFO, "Website opened");

        hp.clickDraggable(fFwD);
        fireffoxtest.log(Status.INFO, "Navigate to draggable page");

        String initialBoxPos = dragPage.getDragBoxPositon(fFwD);
        fireffoxtest.log(Status.INFO, "Click and drag box" + fireffoxtest.addScreenCaptureFromPath(ScreenShot.take(fFwD, "before move")));


        dragPage.clickAndDrag(fFwD);

        assertNotEquals("Has not moved", initialBoxPos, dragPage.getDragBoxPositon(fFwD));

        if (!initialBoxPos.equals(dragPage.getDragBoxPositon(fFwD)))
        {
            fireffoxtest.log (Status.PASS,"Box Moved"+ fireffoxtest.addScreenCaptureFromPath(ScreenShot.take(fFwD, "after move")));

        }
        else
            fireffoxtest.fail("Box not moved"+ fireffoxtest.addScreenCaptureFromPath(ScreenShot.take(fFwD, "after move")));


        dragPage.clickDroppable();
        fireffoxtest.log(Status.INFO, "Navigate to droppable page");

        initialBoxPos = dropPage.getDragBoxPos(fFwD);

        dropPage.dragAndDropBox(fFwD);

        fireffoxtest.log(Status.INFO, "Drag and drop box" + fireffoxtest.addScreenCaptureFromPath(ScreenShot.take(fFwD, "before move")));



        assertNotEquals("Has not moved", initialBoxPos, dropPage.getDragBoxPos(fFwD));

        if (!initialBoxPos.equals(dropPage.getDragBoxPos(fFwD)))
        {
            fireffoxtest.log (Status.PASS,"Dragged and Dropped" + fireffoxtest.addScreenCaptureFromPath(ScreenShot.take(fFwD, "after move")));
        }
        else
            fireffoxtest.fail("Box not moved"+ fireffoxtest.addScreenCaptureFromPath(ScreenShot.take(fFwD, "after move")));


        //assertEquals("Website not updated", dropPage.getDropBoxText(wD), "Dropped!");



    }

    public void ieTest() throws IOException {

        hp.open(iEwD);
        ietest.log(Status.INFO, "Website opened");

        hp.clickDraggable(iEwD);
        ietest.log(Status.INFO, "Navigate to draggable page");

        String initialBoxPos = dragPage.getDragBoxPositon(iEwD);
        ietest.log(Status.INFO, "Click and drag box" + ietest.addScreenCaptureFromPath(ScreenShot.take(iEwD, "before move")));


        dragPage.clickAndDrag(iEwD);

        assertNotEquals("Has not moved", initialBoxPos, dragPage.getDragBoxPositon(iEwD));

        if (!initialBoxPos.equals(dragPage.getDragBoxPositon(iEwD)))
        {
            ietest.log (Status.PASS,"Box Moved"+ ietest.addScreenCaptureFromPath(ScreenShot.take(iEwD, "after move")));

        }
        else
            ietest.fail("Box not moved"+ ietest.addScreenCaptureFromPath(ScreenShot.take(iEwD, "after move")));


        dragPage.clickDroppable();
        ietest.log(Status.INFO, "Navigate to droppable page");

        initialBoxPos = dropPage.getDragBoxPos(iEwD);

        dropPage.dragAndDropBox(iEwD);

        ietest.log(Status.INFO, "Drag and drop box" + ietest.addScreenCaptureFromPath(ScreenShot.take(iEwD, "before move")));



        assertNotEquals("Has not moved", initialBoxPos, dropPage.getDragBoxPos(iEwD));

        if (!initialBoxPos.equals(dropPage.getDragBoxPos(iEwD)))
        {
            ietest.log (Status.PASS,"Dragged and Dropped" + ietest.addScreenCaptureFromPath(ScreenShot.take(iEwD, "after move")));
        }
        else
            ietest.fail("Box not moved"+ ietest.addScreenCaptureFromPath(ScreenShot.take(iEwD, "after move")));


        //assertEquals("Website not updated", dropPage.getDropBoxText(wD), "Dropped!");

    }

    @After
    public void afterT()
    {
        //cwD.quit();
        fFwD.quit();
        //iEwD.quit();
        counter++;



    }
    @AfterClass
    public static void afterClass()
    {
        report.flush();

    }
}



