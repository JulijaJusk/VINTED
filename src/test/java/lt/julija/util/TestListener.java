package lt.julija.util;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TestListener implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result) {
        takeScreenshot();
    }

    private void takeScreenshot() {
        TakesScreenshot screenshot = (TakesScreenshot) Driver.getDriver();
        File fileScreenshot = screenshot.getScreenshotAs(OutputType.FILE);

        LocalDateTime currentDate = LocalDateTime.now();
        DateTimeFormatter dateForm = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss_SSS");

        File newFile = new File("./screenshots/" + currentDate.format(dateForm) + "screenshot.png");

        try {
            FileUtils.copyFile(fileScreenshot, newFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
