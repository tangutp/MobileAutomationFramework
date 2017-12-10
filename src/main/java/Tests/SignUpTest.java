package Tests;

import Configuration.BaseConfiguration;
import ObjectRepository.SignUpPageObjects;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class SignUpTest extends BaseConfiguration {

    @BeforeTest
    public void initializeDriver() throws MalformedURLException {
        driver = Configuration();
    }

    @Test(groups = "Smoke")
    public void SignUp(){

        SignUpPageObjects spo = new SignUpPageObjects(driver);
        spo.signup.click();
        spo.enterName("PavanKumarTa");
        spo.enterEmail("pavan@gmail.com");
        spo.enterPassword("123456");
        spo.enterconfirmPassword("123456");
        spo.signup.click();

    }
}
