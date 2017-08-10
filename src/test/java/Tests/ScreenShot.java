package Tests;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenShot {

    public static String take(WebDriver wD, String fileName)  {
        File scrFile = ((TakesScreenshot)wD).getScreenshotAs(OutputType.FILE);
        String pathname = System.getProperty("user.dir") + File.separatorChar + fileName +".jpg";
        try {
            FileUtils.copyFile(scrFile, new File(pathname));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("File Saved at: " + pathname);
        return pathname;

    }
}

