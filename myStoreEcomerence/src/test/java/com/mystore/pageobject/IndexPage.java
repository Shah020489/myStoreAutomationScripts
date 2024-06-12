package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage {

    //1. create an object of webdriver

    WebDriver driver;
    public IndexPage(WebDriver d){
        driver=d;
        PageFactory.initElements(d,this);
    }
    //Identify Webelement
    @FindBy(linkText = "Sign in")
    WebElement signIn;

    public void clickOnSignIn(){
        signIn.click();
    }





}
