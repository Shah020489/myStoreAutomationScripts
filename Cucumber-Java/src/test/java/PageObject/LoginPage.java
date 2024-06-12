package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver ldriver;

    public LoginPage(WebDriver rdriver){
        ldriver=rdriver;
        PageFactory.initElements(rdriver,this);
    }


    @FindBy(id = "Email")
    WebElement emailLocator;

    @FindBy(id="Password")
    WebElement passwordLocator;

    @FindBy(css = "button[type='submit']")
    WebElement loginBtnLocator;


    @FindBy(linkText = "Logout")
    WebElement linkTextLocator;

    public void enterEmailAddress(String address){
        emailLocator.sendKeys(address);
    }

    public void enterPassword(String pass){
        passwordLocator.sendKeys(pass);
    }

    public void clickOnLoginBtn(){
        loginBtnLocator.click();
    }

    public void clearEmailAddress(){
        emailLocator.clear();
    }
    public void clearPassword(){
        passwordLocator.clear();
    }
    public void clickOnLogout(){
        linkTextLocator.click();
    }

}
