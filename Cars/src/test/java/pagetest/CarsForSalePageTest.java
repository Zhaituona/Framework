package pagetest;

import base.CommonClass;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CarsForSalePage;
import pages.HomePage;
import pages.LogInPage;

public class CarsForSalePageTest extends CommonClass {
    LogInPage logInPage;
    HomePage homePage;
    CarsForSalePage carsForSalePage;

    public CarsForSalePageTest(){
        super();
    }
    @BeforeMethod
    // cause every test is indivisual so for verify we have to login to the homepage , so set this as before method
    public void setUp(){
        initialization();
        //  util = new Util();
        logInPage =new LogInPage();
        //homePage= PageFactory.initElements(driver,HomePage.class);
        carsForSalePage = new CarsForSalePage();
        logInPage.clickSingIn();
        logInPage.clickLogInLink();
        homePage= logInPage.logIn(prop.getProperty("email"),prop.getProperty("password"));
    }
    @Test
    public void verifyAdvancedSearchLabelTest(){
       Assert.assertTrue( carsForSalePage.verifyAdvanceSearchLabel());
    }
    @Test
    public void verifySearchByMakeLabelTest(){
      Assert.assertTrue(carsForSalePage.verifySearchByMakeLabel());
    }

    @Test
    public void verifySearchByBodyStyleLabelTest(){
      Assert.assertTrue(carsForSalePage.verifySearchByBodyStyleLabel());
    }
    @Test
    public void chooseCarModuleTest(){
        carsForSalePage.chooseCarModule();
        carsForSalePage.clickOnSearchButton();
    }
    @Test
    public void selectUserCarDropDownTest(){
        carsForSalePage.selectUserCarDropDown();
        carsForSalePage.clickOnSearchButton();
    }
    @Test
    public void selectCarBrandTest(){
        carsForSalePage.selectCarBrand();
        carsForSalePage.clickOnSearchButton();
    }



    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
