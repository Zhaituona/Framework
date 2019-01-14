package pages;

import base.CommonAPI;
import base.CommonClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage extends CommonClass {
    @FindBy(xpath ="//a[@data-linkname='header-sign-up']")
    WebElement signUpButton;
    @FindBy(xpath ="//input[@type='text']")
    WebElement emailField;

    @FindBy(xpath ="//input[@type='password']")
    WebElement passwordField;

    @FindBy(xpath ="//input[@ng-model='$ctrl.user.confirm']")
    WebElement confirmPasswordField;

    @FindBy(xpath ="/html/body/div[2]/section/cars-profiles-lsp/cui-tabs/div/ul[2]/li[2]/div/cars-signup-form/div/div[3]/form/button")
    WebElement signUpClick;

    public SignUpPage(){

        PageFactory.initElements(driver,this);
    }

    public HomePage singIn(){
        emailField.sendKeys("zaytuna128@gmail.com");
        passwordField.sendKeys("zana195726");
        confirmPasswordField.sendKeys("zana195726");
        signUpClick.click();
        return new HomePage();
    }

    public void clickSignUpButton(){

        signUpButton.click();
    }
}
