package ObjectRepository;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPageObjects {


        WebDriver driver;

        public SignUpPageObjects(WebDriver driver) {
            this.driver = driver;
            PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        }


        @FindBy(xpath = "")
        @AndroidFindBy(xpath = "//android.widget.EditText[@text='Name']")
        @iOSFindBy(xpath = "")
        public WebElement name;

        @FindBy(xpath = "")
        @AndroidFindBy(xpath = "//android.widget.EditText[@text='Email Address']")
        @iOSFindBy(xpath = "")
        public WebElement email;

        @FindBy(xpath = "")
        @AndroidFindBy(xpath = "//android.widget.EditText[@text='Password']")
        @iOSFindBy(xpath = "")
        public WebElement password;

        @FindBy(xpath = "")
        @AndroidFindBy(xpath = "//android.widget.EditText[@text='Confirm Password']")
        @iOSFindBy(xpath = "")
        public WebElement cnfmpassword;

        @FindBy(xpath = "")
        @AndroidFindBy(xpath = "//android.widget.Button[@text='SIGN UP']")
        @iOSFindBy(xpath = "")
        public WebElement signup;

        @FindBy(xpath = "")
        @AndroidFindBy(xpath = "//android.widget.Button[contains(@text,'ALREADY REGISTERED')")
        @iOSFindBy(xpath = "")
        public WebElement alreadyRegisteredClickLogin;


        public String enterName(String s) {
            name.sendKeys(s);
            return s;
        }

        public String enterEmail(String s) {
            email.sendKeys(s);
            return s;
        }

        public String enterPassword(String s) {
            password.sendKeys(s);
            return s;
        }

        public String enterconfirmPassword(String s) {
            cnfmpassword.sendKeys(s);
            return s;
        }

        public void clickSignUp() {
            signup.click();
        }

        public void clickAlreadyRegistered() {
            alreadyRegisteredClickLogin.click();
        }

    }

