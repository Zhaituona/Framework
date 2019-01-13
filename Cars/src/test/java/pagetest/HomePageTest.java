package pagetest;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;

public class HomePageTest extends HomePage {
    HomePage homePage;

    @BeforeMethod
    public void init(){
        homePage= PageFactory.initElements(driver,HomePage.class);
    }
    @Test
    public void carsImageLogo() {
        boolean flag = homePage.validateCarsImage();
        Assert.assertTrue(flag);
    }
    @Test
    public void selectCarTypeDropDown() throws InterruptedException {
        homePage.carTypeDropDown();
        homePage.clickSearchButton();
    }
    @Test
    public void selectCarMakeDropDown(){
        homePage.carMakeDropDown();
        homePage.clickSearchButton();
    }
    @Test
    public void selectCarModelDropDown(){
        homePage.carModelIdDropDown();
        homePage.clickSearchButton();
    }
    @Test
    public void selectCarPriceDropDown(){
        homePage.carPriceDropDown();
        homePage.clickSearchButton();
    }
    @Test
    public void selectCarRadiosDropDown(){
        homePage.radioDropDown();
        homePage.clickSearchButton();
    }
    @Test
    public void clickSearchByBodyStyle(){
        homePage.searchByBodyStyleTag();
    }

    @Test
    public void chooseAllBodyStyleDropDown(){
        homePage.allBodyStyleDropDown();
        homePage.clickSearchButton();
    }
    @Test
    public void chooseCarQuality(){
        homePage.carQualityDropDown();
        homePage.clickSearchButton();
    }
    @Test
    public void chooseCarPrice(){
        homePage.carPrice();
        homePage.clickSearchButton();
    }
    @Test
    public void chooseCarRadius(){
        homePage.setRadiusDropDown();
        homePage.clickSearchButton();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
