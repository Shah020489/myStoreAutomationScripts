package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {

    WebDriver driver;

    public MyAccountPage(WebDriver d){
        driver=d;
        PageFactory.initElements(d,this);
    }

    @FindBy(id="email_create")
    WebElement email_create_Locator;

    @FindBy(id="SubmitCreate")
    WebElement createButton;

    public void enterCreateEmailAddress(String emailAdres){
       email_create_Locator.sendKeys(emailAdres);
    }

    public void clickOnCreateButton(){
        createButton.click();
    }



}
