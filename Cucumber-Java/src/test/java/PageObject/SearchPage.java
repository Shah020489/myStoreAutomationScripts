package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchPage {

    public WebDriver ldriver;

    public SearchPage(WebDriver rdriver){
        ldriver=rdriver;
        PageFactory.initElements(rdriver,this);
    }

    @FindBy(id="SearchEmail")
    WebElement searchEmailLocator;

    @FindBy(id="search-customers")
    WebElement searchCustomerBtnLocator;

    //@FindBy(xpath = "//div[contains(@class,'row')]//div[contains(@class,'col-md-12')]")
    @FindBy(xpath = "//table[@class='table table-bordered table-hover table-striped dataTable no-footer'][1]")
    WebElement searchResultGridLocator;

    @FindBy(xpath = "//table[@id='customers-grid']//tbody/tr")
    List<WebElement> tableRows;

    @FindBy(xpath = "//table[@id='customers-grid']//tbody/tr[1]/td")
    List<WebElement> tableColumns;



    @FindBy(xpath = "//table[@class='table table-bordered table-hover table-striped dataTable no-footer']")
    WebElement searchResultGrid;

    @FindBy(id="SearchFirstName")
    WebElement searchFirstNameLocator;

    @FindBy(id="SearchLastName")
    WebElement searchLastNameLocator;


    public void enterEmailAddress(String email){
        searchEmailLocator.sendKeys(email);
    }

    public void clickOnSearchBtn(){
        searchCustomerBtnLocator.click();


    }

    public void enterFirstName(String firstName){
        searchFirstNameLocator.sendKeys(firstName);
    }

    public void enterLastName(String lastName){
        searchLastNameLocator.sendKeys(lastName);
    }

    public boolean searchCustomerByEmail(String email){
        boolean found=false;
        //Totat number of rows

        int ttlRows=tableRows.size();
        //Total number of columbs

        int ttlColumns=tableColumns.size();

        for (int i=1;i<=ttlRows;i++){
            System.out.println("i " +i);
            WebElement webElemente_mail_Actual=ldriver.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr["+i+"]/td[2]"));
            String actualEmail=webElemente_mail_Actual.getText();
            System.out.println(actualEmail);

            if (actualEmail.equals(email))
                found=true;
            break;
        }

        return found;


    }

    public boolean searchCustomerByName(String name){
        boolean found=false;
        //Totat number of rows

        int ttlRows=tableRows.size();
        //Total number of columbs

        int ttlColumns=tableColumns.size();

        for (int i=1;i<=ttlRows;i++){
            System.out.println("i " +i);
            WebElement webElemente_mail_Actual=ldriver.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr["+i+"]/td[3]"));
            String actualFullName=webElemente_mail_Actual.getText();
            System.out.println(actualFullName);

            if (actualFullName.equals(name))
                found=true;
            break;
        }

        return found;


    }


}
