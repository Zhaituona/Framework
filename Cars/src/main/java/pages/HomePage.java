package pages;

import base.CommonAPI;
import base.CommonClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HomePage extends CommonClass {

    @FindBy(xpath ="//label[@id='profile_menu-avatar']")
    WebElement logInIcon;

    @FindBy(linkText ="Cars for Sale")
    WebElement carsForSaleLink;

    @FindBy(linkText="Sell Your Car")
    WebElement sellYourCarLink;

    @FindBy(linkText ="Service & Repair")
    WebElement serviceAndRepairLink;

    @FindBy(xpath ="//img[contains(@class,'global-nav__logo')]")
    WebElement carsLogo;

    @FindBy(name ="stockType")
    WebElement NewNUsedCarDropDown;

    @FindBy(name ="makeId")
    WebElement carMakeDropDown;

    @FindBy(name ="modelId")
    WebElement carModelDropDown;

    @FindBy(name ="priceMax")
    WebElement priceDropDown;

    @FindBy(name ="radius")
    WebElement radiusDropDown;
    @FindBy(xpath ="//input[@value='Search']")
    WebElement searchButton;

    @FindBy(xpath ="//*[@id=\'root\']/div[2]/section[2]/div[2]/form/ul/li[2]/label")
    WebElement searchByBodyStyle;

    @FindBy(name="bodyStyle")
    WebElement allBodyDropDown;

    @FindBy(name ="stockType")
    WebElement carType;

    @FindBy(name= "priceMax")
    WebElement carPriceDropDown;

    @FindBy(name ="radius")
    WebElement nextRadius;

    @FindBy(linkText = "Research")
    WebElement researchLink;

    @FindBy(linkText= "Videos & Reviews")
    WebElement videosAndReviewsLink;

    public HomePage(){
        PageFactory.initElements(driver,this);
    }

    public boolean verifyLogInIcon(){
       return logInIcon.isDisplayed();
    }

    public String verifyHomePageTitle(){

        return driver.getTitle();
    }
    public CarsForSalePage clickOnCarsForSaleLink() throws InterruptedException {
        Actions act = new Actions(driver);
        act.moveToElement(carsForSaleLink).perform();
        carsForSaleLink.click();
        Thread.sleep(3000);
        WebDriverWait wait = new WebDriverWait(driver,5);
        return new CarsForSalePage();
    }

    public SellYourCarPage clickSellYourCarLink() throws InterruptedException {
        Thread.sleep(3000);
        Actions act = new Actions(driver);
        act.moveToElement(sellYourCarLink).perform();
        sellYourCarLink.click();
        //sellYourCarLink.click();
        return new SellYourCarPage();
    }
    public ServiceAndRepairPage clickServiceAndRepairLink() throws InterruptedException {
        Thread.sleep(3000);
        Actions act = new Actions(driver);
        act.moveToElement(serviceAndRepairLink).perform();
        serviceAndRepairLink.click();
        return new ServiceAndRepairPage();
    }

    public ResearchPage ResearchLink() throws InterruptedException {
        Thread.sleep(3000);
        Actions act = new Actions(driver);
        act.moveToElement(researchLink).perform();
        researchLink.click();
        return new ResearchPage();
    }
    public VideosAndReviewsPage clickVideosAndReviewLink() throws InterruptedException {
        Thread.sleep(3000);
        Actions act = new Actions(driver);
        act.moveToElement(videosAndReviewsLink).perform();
        videosAndReviewsLink.click();
        return new VideosAndReviewsPage();
    }



    public void allBodyStyleDropDown() {
        Select s = new Select(allBodyDropDown);
        int n = 1;
        while (n < 3) {
            allBodyDropDown.click();
            n++;
        }
    }

    public void carQualityDropDown(){
        Select s = new Select(carType);
        for(int k=1; k<3;k++){
            carType.click();
        }
    }
    public void carPrice(){
        Select s = new Select(carPriceDropDown);
        s.selectByValue("35000");
        boolean isSelected = carPriceDropDown.isSelected();
        Assert.assertTrue(isSelected);
    }
    public void setRadiusDropDown(){
        Select s = new Select(nextRadius);
        s.selectByVisibleText("40 Miles from");
        boolean isSelect = nextRadius.isSelected();
        Assert.assertTrue(isSelect);
    }


    public void searchByBodyStyleTag(){

        searchByBodyStyle.click();
    }

    public void carTypeDropDown() throws InterruptedException {
       Select s = new Select(NewNUsedCarDropDown);
       s.selectByValue("28880");
       Thread.sleep(3000);
    }
    public void carMakeDropDown(){
        Select s = new Select(carMakeDropDown);
        s.selectByVisibleText("Aston Martin");
    }
    public void carModelIdDropDown(){
        Select s = new Select(carModelDropDown);
        s.selectByIndex(1);
    }
    public void carPriceDropDown(){
        Select s = new Select(priceDropDown);
        s.selectByValue("35000");
    }
    public void radioDropDown(){
        Select s = new Select(radiusDropDown);
        s.selectByVisibleText("40 Miles from");
    }
    public void clickSearchButton(){
        searchButton.click();
    }
    public boolean validateCarsImage(){

        return carsLogo.isDisplayed();
    }
}
