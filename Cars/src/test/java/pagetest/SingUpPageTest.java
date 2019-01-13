package pagetest;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SignUpPage;

public class SingUpPageTest extends SignUpPage {
    HomePage homePage;
    SignUpPage signUpPage;
    @BeforeMethod
    public void init(){

        signUpPage= PageFactory.initElements(driver, SignUpPage.class);
    }
    @Test
    public void clickOnSingInButton(){

        signUpPage.clickSignUpButton();
    }
    @Test
    public void userSingIn(){
        signUpPage.clickSignUpButton();
       homePage=signUpPage.singIn();
    }
  //  @AfterMethod
   // public void tearDown(){
     //   driver.quit();
   // }

}
