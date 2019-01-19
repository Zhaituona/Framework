package pagetest;

import base.CommonClass;
import base.Util;
import dataXles.MyDataReader;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SignUpPage;

import java.io.File;

public class SingUpPageTest extends CommonClass {
    HomePage homePage;
    SignUpPage signUpPage;
   // String sheetName= "Sheet1";

    public SingUpPageTest(){
        super();
    }
    @BeforeMethod
    public void setUp(){
        initialization();
        homePage=new HomePage();
        signUpPage= new SignUpPage();
    }
   @Test(priority = 1)
    public void clickOnSingInButton(){
        homePage.clickSearchButton();
        //signUpPage.clickSignUpButton();
    }
//    @DataProvider
//    public Object[][] getCarsTestData(){
//        Object data[][]= Util.getTestData("Sheet1");
//        return data;
//    }

    @DataProvider(name="DP")
    public Object[][] getTestData() throws Exception{
        File filepath = new File("C://Users//Elzat//IdeaProjects//Auto3//Cars//dataProvide.xlsx");
        MyDataReader dr = new MyDataReader();
        //Show me where is data file
        dr.setExcelFile(filepath.getAbsolutePath());
        String[][] data = dr.getExcelSheetData("Sheet1");
        return data;
    }

    @Test(priority = 2,dataProvider = "DP")
        public void createNewAccountTest(String email,String password,String confirmPassword ){
        signUpPage.clickSignUpButton();
        signUpPage.createNewAccount(email,password,confirmPassword);
    }
    @Test(priority = 3)
    public void userSingIn(){
        signUpPage.clickSignUpButton();
       homePage=signUpPage.singIn();
    }
    @Test(priority = 4)
    public void  invalidEmailSignInTest(){
        signUpPage.clickSignUpButton();
        String errorMassage=  signUpPage.invalidEmailSignIn();
        Assert.assertEquals(errorMassage,"Please enter your email address.");
    }
    @Test(priority = 5)
    public void withoutPasswordSignInTest(){
        signUpPage.clickSignUpButton();
        String errorMassage = signUpPage.withoutPasswordSignIn();
        Assert.assertEquals(errorMassage,"Please enter your password.");
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
   }

}
