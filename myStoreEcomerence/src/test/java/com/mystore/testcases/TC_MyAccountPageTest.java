package com.mystore.testcases;

import com.mystore.pageobject.IndexPage;
import com.mystore.pageobject.MyAccountPage;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

public class TC_MyAccountPageTest extends BaseClass{

    @Test
    public void verifyRegistrationAndLogin(){
        driver.get(url);
        //Logger.info("URL opened");
        IndexPage indexPage=new IndexPage(driver);
        indexPage.clickOnSignIn();
        MyAccountPage myAccountPage=new MyAccountPage(driver);
        myAccountPage.enterCreateEmailAddress("anadd@gmail.com");
        myAccountPage.clickOnCreateButton();


    }
}
