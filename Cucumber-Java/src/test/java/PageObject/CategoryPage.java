package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CategoryPage {

    WebDriver ldriver;

    public CategoryPage(WebDriver rdriver){
        ldriver=rdriver;
        PageFactory.initElements(rdriver,this);
    }

    @FindBy (xpath = "//p[normalize-space()='Catalog']")
    WebElement catalogLeftMenuLinkLocator;

    @FindBy(xpath = "//p[normalize-space()='Categories']")
    WebElement categoriesLeftMenuLinkLocator;
    @FindBy(xpath = "//h1[@class='float-left']")
    WebElement categoriesHeadingLocator;

    @FindBy(xpath = "//a[normalize-space()='Add new']")
    WebElement categoriesAddNewButtonLocator;

    @FindBy(xpath = "//button[normalize-space()='Export'][1]")
    WebElement categoriesExportButtonLocator;

    @FindBy(xpath = "//button[normalize-space()='Import'][1]")
    WebElement categoriesImportButtonLocator;

    @FindBy(xpath = "//button[normalize-space()='Delete (selected)'][1]")
    WebElement categoriesDeleteButtonLocator;

    @FindBy(xpath = "//input[@id='SearchCategoryName']")
    WebElement searchCategoryNameTextFieldLoctor;

    @FindBy(xpath = "//button[@id='search-categories']")
    WebElement searchCategoryButtonLocator;

    public void clickOnCatalogLeftMenuLinkLocator(){
        catalogLeftMenuLinkLocator.click();
    }

    public void clickOnCategoriesLeftMenuLink(){
        categoriesLeftMenuLinkLocator.click();
    }

    public String getCategoriesHeading(){
       return categoriesHeadingLocator.getText();
    }

    public void buttonPresentOnCategories(){
        categoriesAddNewButtonLocator.isDisplayed();
        categoriesExportButtonLocator.isDisplayed();
        categoriesImportButtonLocator.isDisplayed();
        categoriesDeleteButtonLocator.isDisplayed();
    }



}
