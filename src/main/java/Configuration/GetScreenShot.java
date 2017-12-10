package Configuration;


import java.io.File;
import java.io.IOException;
import java.security.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class GetScreenShot {

    public static String capture(WebDriver driver,String screenShotName) throws IOException
    {

        Date d = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss");
        String dateStr = dateFormat.format(d);


//        TakesScreenshot ts = (TakesScreenshot)driver;
//        File source = ts.getScreenshotAs(OutputType.FILE);
        String dest1 = screenShotName  + "_" + dateStr + ".jpg";
        String dest = "C:\\Users\\tangutp\\Documents\\Testing\\Testing\\ScreenShots\\"+ dest1;

//        File destination = new File(dest);
//        FileUtils.copyFile(source, destination);


        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File(dest));
        return dest1;
    }
}