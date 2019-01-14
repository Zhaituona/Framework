package pagetest;

import base.CommonClass;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SignUpPage;

public class SingUpPageTest extends CommonClass {
    HomePage homePage;
    SignUpPage signUpPage;

    public SingUpPageTest(){
        super();
    }
    @BeforeMethod
    public void setUp(){
        initialization();
        homePage=new HomePage();
        signUpPage= new SignUpPage();
    }
    @Test
    public void clickOnSingInButton(){
        homePage.clickSearchButton();
        //signUpPage.clickSignUpButton();
    }
    @Test
    public void userSingIn(){
        signUpPage.clickSignUpButton();
       homePage=signUpPage.singIn();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
   }

}
