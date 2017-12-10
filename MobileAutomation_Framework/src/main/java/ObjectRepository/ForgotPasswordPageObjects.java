package ObjectRepository;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPasswordPageObjects {


    WebDriver driver;

    public ForgotPasswordPageObjects(WebDriver driver) {
        // TODO Auto-generated constructor stub
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @FindBy(xpath = "")
    @AndroidFindBy(xpath = "//android.widget.Button[@text='FORGOT PASSWORD']")
    WebElement forgotPassword;

    @FindBy(xpath = "")
    @AndroidFindBy(id = "com.test.myapplication:id/forgotPassActivity_email_ET")
    WebElement email;

    @FindBy(xpath = "")
    @AndroidFindBy(id = "com.test.myapplication:id/forgotPassActivity_password_ET")
    WebElement password;

    @FindBy(xpath = "")
    @AndroidFindBy(id = "com.test.myapplication:id/forgotPassActivity_confirmPassword_ET")
    WebElement cnfmpassword;

    @FindBy(xpath = "")
    @AndroidFindBy(xpath = "//android.widget.Button[@text='SUBMIT']")
    WebElement submit;

    @FindBy(xpath = "")
    @AndroidFindBy(xpath = "//android.widget.Button[@text='OK']")
    WebElement ok;

    @FindBy(xpath = "")
    @AndroidFindBy(id = "android:id/message")
    WebElement sucessMessage;

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
    public void clickForgotPassword(){
        forgotPassword.click();
    }
    public void clickSubmit(){
        submit.click();
    }

    public Boolean submitButtonDisplayed(){
        return submit.isDisplayed();
    }

    public void acceptAlert(){
        ok.click();
    }

    public String sucessMessageAlertText(){

        String s =sucessMessage.getText();

        return s;
    }

    public void clearEmailID(){
        email.clear();
    }
    public void clearPassword(){
        password.clear();
    }
    public void clearConfirmPassword(){
        cnfmpassword.clear();
    }


}
