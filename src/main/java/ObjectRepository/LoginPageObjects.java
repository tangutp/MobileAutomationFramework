package ObjectRepository;

import Configuration.BaseConfiguration;
import DataSet.FrameworkTestData;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;

public class LoginPageObjects{
           WebDriver driver;

        public LoginPageObjects(WebDriver driver) {
            // TODO Auto-generated constructor stub
            this.driver = driver;
            PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        }


       @FindBy(xpath = "")
        @AndroidFindBy(id = "com.test.myapplication:id/loginActivity_email_ET")
        WebElement emailID;

        @FindBy(xpath = "")
        @AndroidFindBy(id = "com.test.myapplication:id/loginActivity_password_ET")
        WebElement password;

        @FindBy(xpath = "")
        @AndroidFindBy(xpath = "//android.widget.Button[@text='LOGIN']")
        WebElement login;

        @FindBy(xpath = "")
        @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text ='SUCCESS')]")
        WebElement sucessAlert;

        @FindBy(xpath = "")
        @AndroidFindBy(xpath = "//android.widget.Button[@text='OK']")
        WebElement ok;

        @FindBy(xpath = "")
        @AndroidFindBy(xpath = "//android.widget.TextView[@text='This email is not Registered']")
        WebElement emailNotRegisteredAlert;

        @FindBy(xpath = "")
        @AndroidFindBy(xpath = "//android.widget.TextView[@text='Logged into App']")
        WebElement homePage;




        public String enterEmailID(String s){
            emailID.sendKeys(s);
            return s;
        }

        public void clearEmailID(){
            emailID.clear();

        }

        public String enterPassword(String p){
            password.sendKeys(p);
            return p;
        }

        public void clearPassword(){
            password.clear();

        }
        public void click(){
            login.click();
        }

        public String acceptSuccessAlert(){

            System.out.println("Inside Sucess Alert");
            System.out.println(sucessAlert.getText());
//            Alert a = driver.switchTo().alert();
//            String alert = a.getText();
       return sucessAlert.getText();
                }

        public void acceptAlert(){
            ok.click();
        }

        public String verifyHomePage(){
            return homePage.getText();
            }

        public Boolean emailNotRegisteredAlert(){
            return emailNotRegisteredAlert.isDisplayed();
        }


    }
