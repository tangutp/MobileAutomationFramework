package Tests;


import Configuration.GetScreenShot;
import DataSet.FrameworkTestData;
import ObjectRepository.ForgotPasswordPageObjects;
import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentXReporter;
import com.aventstack.extentreports.reporter.KlovReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ForgotPasswordTest{

    public WebDriver driver;

    ExtentReports extent;
    ExtentTest test;
    KlovReporter klov;
    ATUTestRecorder recorder;
    ExtentHtmlReporter htmlReporter;

    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss");
    Date date = new Date();
    @BeforeTest
    @Parameters({"deviceName", "platformName", "app", "URL_","extentConfigFile","exportTestSummaryReport","replaceExistingReport","captureVideo"})
    public void InitializeDeviceDriver(String deviceName,String platformName,String app,String URL_,String extentConfigFile,String exportTestSummaryReport,Boolean replaceExistingReport,Boolean captureVideo) throws MalformedURLException, ATUTestRecorderException {

        htmlReporter = new ExtentHtmlReporter(extentConfigFile);
        klov = new KlovReporter();

        klov.initMongoDbConnection("localhost", 27017);
        klov.setProjectName("Request for Quote");
        klov.setReportName("Test Automation Report for Request for Quote Application");
        klov.setKlovUrl("http://localhost");

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setDocumentTitle("AutomationTesting.in Demo Report");
        htmlReporter.config().setReportName("My Own Report");
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setTheme(Theme.DARK);


        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);
        caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "100");
        File file = new File(app);
        caps.setCapability(MobileCapabilityType.APP,file.getAbsolutePath());
        if(captureVideo == true){
            recorder = new ATUTestRecorder("C:\\Users\\tangutp\\Documents\\Testing\\Testing\\ScreenShots\\Videos", "LoginTest_" + dateFormat.format(date), false);
            recorder.start();
        }

        if(platformName.equals("IOS")){
            caps.setCapability("automationName","XCUITest");
        }


        if (platformName.equals("Android")){
            System.out.println("Android Driver");
            driver = new AndroidDriver(new URL(URL_), caps);
        }
        else {
            System.out.println("IOS Driver");
            driver = new IOSDriver(new URL(URL_), caps);
        }
    }

    @Test(groups = "Regression", dataProvider = "ForgotPasswordTestData", dataProviderClass = FrameworkTestData.DataTable.class)
    public void ForgotPasswordTest(String emailID,String Password, String ConfirmPassword){
        test=extent.createTest("ForgotPassword Test");
        ForgotPasswordPageObjects fpo = new ForgotPasswordPageObjects(driver);

        try{
        fpo.submitButtonDisplayed();

        }catch (Exception e){
            fpo.clickForgotPassword();
        }

        fpo.enterEmail(emailID);
        fpo.enterPassword(Password);
        fpo.enterconfirmPassword(ConfirmPassword);
        fpo.clickSubmit();


            if(fpo.sucessMessageAlertText().equalsIgnoreCase("Password successfully changed")){
                test.log(Status.PASS, "Test Passed");
                fpo.acceptAlert();
            }else{
                test.log(Status.PASS, "Test Passed");
                fpo.acceptAlert();
                fpo.clearEmailID();
                fpo.clearPassword();
                fpo.clearConfirmPassword();
            }

    }

    @AfterMethod
    @Parameters({"takeScreenShotForFailedTestCase","takeScreenShotForPassedTestCase"})
    public void getResult(ITestResult result, Boolean takeScreenShotForFailedTestCase, Boolean  takeScreenShotForPassedTestCase) throws IOException {

        if(result.getStatus() == ITestResult.FAILURE){
            if(takeScreenShotForFailedTestCase == true) {
                String res = GetScreenShot.capture(driver, "FAILED");
                test.log(Status.FAIL, result.getThrowable());
                test.log(Status.FAIL, "Snapshot below: " + test.addScreenCaptureFromPath("../ScreenShots/" + res));
            }else{
                test.log(Status.FAIL, result.getThrowable());

            }
        }else{
            if(takeScreenShotForPassedTestCase == true) {
                String res = GetScreenShot.capture(driver, "PASSED");
                test.log(Status.PASS, "Snapshot below: " + test.addScreenCaptureFromPath("../ScreenShots/" + res));
            }else{
                test.log(Status.PASS,"Test Passed");

            }
        }

            }

    @AfterTest
    @Parameters({"captureVideo"})
    public void endReport(Boolean captureVideo) throws ATUTestRecorderException {

        if(captureVideo == true) {
            recorder.stop();
        }
        extent.flush();
        klov.flush();
    }
}
