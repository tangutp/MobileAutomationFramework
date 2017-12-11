package Configuration;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class BaseConfiguration {

   public WebDriver driver;

    public WebDriver Configuration() throws MalformedURLException {
        File f = new File("src");
        File fs = new File(f, "app-debug.apk");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus_6P_API_25");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.APP,fs.getAbsolutePath());

        driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        return driver;
    }

}
