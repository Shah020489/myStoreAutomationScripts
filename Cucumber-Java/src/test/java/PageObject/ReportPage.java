package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReportPage {
    WebDriver ldriver;
    public ReportPage(WebDriver rdriver){
        ldriver=rdriver;
        PageFactory.initElements(ldriver,this);

    }
    @FindBy(xpath = "//p[normalize-space()='Reports']")
    WebElement reportLeftMenuLinkLocator;
    @FindBy(xpath = "//p[normalize-space()='Sales summary']")
    WebElement salesSummaryLeftMenuReportLocator;
    @FindBy(xpath = "(//h1[normalize-space()='Sales summary'])[1]")
    WebElement salessummaryHeadingLocator;
    public void clickOnReportLeftMenuLink(){
        reportLeftMenuLinkLocator.click();
    }
    public void clickOnSalesSummaryLeftMenuReport(){
        salesSummaryLeftMenuReportLocator.click();
    }
    public String getSalessummaryHeading(){
        return salessummaryHeadingLocator.getText();
    }



}
