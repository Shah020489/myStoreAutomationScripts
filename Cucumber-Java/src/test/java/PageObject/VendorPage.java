package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendorPage {

    WebDriver ldriver;

    public VendorPage(WebDriver rdriver){
        ldriver=rdriver;
        PageFactory.initElements(ldriver,this);
    }

    @FindBy(xpath = "//h1[normalize-space()='Vendors']")
    WebElement headingText;

    ////p[contains(text()= 'Vendors']"
    @FindBy(xpath = "//a[@href='/Admin/Vendor/List']")
    WebElement vendorsLinkLocator;

    @FindBy(css= "button[name='save']")
    WebElement saveBtnLocator;

    @FindBy(id="Email-error")
    WebElement emailErrorMessage;

    @FindBy(id="Name-error")
    WebElement nameErrorMessage;

    @FindBy(css = "a[class='btn btn-primary']")
    WebElement addANewBtn;

    public void clickSaveButtonOnVendorScreen(){
        addANewBtn.click();
        saveBtnLocator.click();
    }

    public String errorMessage(){
        return emailErrorMessage.getText();
    }

    public String nameErrorMessage(){
        return nameErrorMessage.getText();
    }

    public void clickOnVendorSubMenu(){
        vendorsLinkLocator.click();
    }

    public String getPageHeading(){
        return headingText.getText();
    }
}
