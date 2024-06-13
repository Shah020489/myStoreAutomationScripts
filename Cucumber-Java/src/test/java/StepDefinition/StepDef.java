package StepDefinition;

import PageObject.*;
import Utility.Constant;
import Utility.ReadConfig;
import io.cucumber.java.*;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class StepDef extends BaseClass {

    @Before
    public void setUp() {
        logger = LogManager.getLogger("StepDef");
        readConfig = new ReadConfig();
        String browser = readConfig.getBrowser("browser");

        switch (browser.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "msedge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            default:
                browser = null;
                break;
        }
    }

    @Given("User Launch Chrome browser")
    public void user_launch_chrome_browser() {
        // Write code here that turns the phrase above into concrete actions

        logger.info("User Launch Chrome browser");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        loginPage = new LoginPage(driver);
        addNewCustomerPage = new AddNewCustomerPage(driver);
        searchPage = new SearchPage(driver);
        vendorPage=new VendorPage(driver);
        categoryPageObject=new CategoryPage(driver);

    }

    @When("User opens URL {string}")
    public void user_opens_url(String string) {
        logger.info("User opens URL");
        // Write code here that turns the phrase above into concrete actions
        driver.get(string);

    }

    @When("User enters Email as {string} and Password as {string}")
    public void user_enters_email_as_and_password_as(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions
        loginPage.clearEmailAddress();
        loginPage.enterEmailAddress(string);
        loginPage.clearPassword();
        loginPage.enterPassword(string2);
        logger.info("User enters Email and Password");

    }

    @When("Click on Login")
    public void click_on_login() {
        // Write code here that turns the phrase above into concrete actions
        loginPage.clickOnLoginBtn();
        logger.info("Click on Login Button");

    }

    @Then("Page Title should be {string}")
    public void page_title_should_be(String expectedTitle) {
        // Write code here that turns the phrase above into concrete actions
        String actualTitle = driver.getTitle();
        if (actualTitle.equals(expectedTitle)) {
            Assert.assertTrue(true);
            logger.info("Verify the page title --Passed");
        } else {
            Assert.assertTrue(false);
            logger.warn("page title --Failed");
        }

    }

    @When("User click on Log out link")
    public void user_click_on_log_out_link() {
        // Write code here that turns the phrase above into concrete actions
        loginPage.clickOnLogout();
        logger.info("User click on Log out link");

    }

    @Then("close browser")
    public void close_browser() {
        // Write code here that turns the phrase above into concrete actions

        //driver.quit();
    }

    /**
     * Add a Customer page
     */

    @Then("User can view Dashboad")
    public void user_can_view_dashboad() {
        String actualTitle = addNewCustomerPage.getPageTitle();
        String expectedTitle = "Dashboard / nopCommerce administration";
        if (actualTitle.equals(expectedTitle)) {
            Assert.assertTrue(true);
            logger.info("User can view Dashboad -- Passed");
        } else {
            Assert.assertTrue(false);
            logger.warn("User can view Dashboad --Failed");
        }
    }

    @When("User click on customers Menu")
    public void user_click_on_customers_menu() {

        addNewCustomerPage.clickOnCustomersMenu();
        logger.info("User click on customers Menu");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    @When("click on customers Menu Item")
    public void click_on_customers_menu_item() {
        addNewCustomerPage.clickOnCustomersMenuItem();
        logger.info("User click on customers Menu Item");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    @When("click on Add new button")
    public void click_on_add_new_button() {
        addNewCustomerPage.clickOnAddnew();
        logger.info("clicked on Add new button");

    }

    @Then("User can view Add new customer page")
    public void user_can_view_add_new_customer_page() {
        String actualTitle = addNewCustomerPage.getPageTitle();
        System.out.println(actualTitle);
        String expectedTitle = "Add a new customer / nopCommerce administration";
        if (actualTitle.equals(expectedTitle)) {
            Assert.assertTrue(true);
            logger.info("User can view Add new customer page -- verified title");
        } else {
            Assert.assertTrue(false);
            logger.warn("User can view Add new customer page --Failed title");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @When("User enter customer info")
    public void user_enter_customer_info() {
        String email = generateEnail();
        addNewCustomerPage.enterEmail(email);
        addNewCustomerPage.enterPassword("test1");
        addNewCustomerPage.enterFirstName("Shakeel");
        addNewCustomerPage.enterLastName("Ahmed");
        addNewCustomerPage.enterGender("Male");
        addNewCustomerPage.enterDob("4/2/1989");
        addNewCustomerPage.enterCompanyName("CodeWithShakeel");
        addNewCustomerPage.enterAdminContent("Admin Content");
        addNewCustomerPage.enterManagerOfVendor("Vendor 1");
        logger.info("User entered customer info successfully");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @When("click on Save button")
    public void click_on_save_button() {
        addNewCustomerPage.clickOnSave();
        logger.info("click on Save button");
    }

    @Then("User can view confirmation message {string}")
    public void user_can_view_confirmation_message(String expectedMsg) {

        String bodyTag = driver.findElement(By.tagName("Body")).getText();
        if (bodyTag.contains(expectedMsg)) {
            Assert.assertTrue(true);
            logger.info("User can view confirmation message --Passed");
        } else {
            Assert.assertTrue(false);
            logger.warn("User can view confirmation message -- Failed");
        }
    }

    @When("Enter customer Email")
    public void enter_customer_email() {

        searchPage.enterEmailAddress("victoria_victoria@nopCommerce.com");
    }

    @When("Click on search button")
    public void click_on_search_button() {

        searchPage.clickOnSearchBtn();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Then("User should found Email in the Search table")
    public void user_should_found_email_in_the_search_table() {
        Assert.assertTrue(searchPage.searchCustomerByEmail("victoria_victoria@nopCommerce.com"));
    }

    @When("Enter customer FirstName")
    public void enter_customer_first_name() {
        searchPage.enterFirstName("Victoria");
    }

    @When("Enter customer LastName")
    public void enter_customer_last_name() {
        searchPage.enterLastName("Terces");
    }

    @Then("User should found Name in the Search table")
    public void user_should_found_name_in_the_search_table() {
        Assert.assertTrue(searchPage.searchCustomerByName("Victoria Terces"));
    }

    @Then("User can view Error message {string}")
    public void user_can_view_error_message(String expectedErrorMessage) {
        String actualErrorMessage = addNewCustomerPage.getErrorMessageText();
        if (actualErrorMessage.equals(expectedErrorMessage)) {
            Assert.assertTrue(true);
            logger.info("User can view confirmation message --Passed");
        } else {
            Assert.assertTrue(false);
            logger.warn("User can view confirmation message -- Failed");
        }

    }

    @After
    public void tearDown(Scenario sc) {
        System.out.println("Tear down method executed.");
        if (sc.isFailed() == true) {
            String fileWithPath = "C:\\Learning\\Automation-Sessions\\JavaRevision\\myStoreAutomationScripts\\Cucumber-Java\\Screenshots\\screen.jpg";
            TakesScreenshot screenshot = ((TakesScreenshot) driver);
            File scrFile = screenshot.getScreenshotAs(OutputType.FILE);
            File destFile = new File(fileWithPath);
            try {
                FileUtils.copyFile(scrFile, destFile);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        driver.quit();
    }

    @When("User click on Vendors")
    public void user_click_on_vendors() {
        // Write code here that turns the phrase above into concrete actions
        vendorPage.clickOnVendorSubMenu();
    }
    @Then("User validate Add a new vendor")
    public void user_validate_add_a_new_vendor() {
        // Write code here that turns the phrase above into concrete actions
        String headingText=(vendorPage.getPageHeading()).replace(" ", "");
        if (headingText.equals(Constant.vendorTextHeading)){
            System.out.println("Pass");
        }
        else {
            System.out.println("Failed");
        }

    }
    @When("User clicks on Add New record")
    public void user_clicks_on_add_new_record() {
        // Write code here that turns the phrase above into concrete actions
        vendorPage.clickSaveButtonOnVendorScreen();
    }
    @Then("User receive error message")
    public void user_receive_error_message() {
        // Write code here that turns the phrase above into concrete actions
        String nameError=vendorPage.nameErrorMessage();

        if (nameError.equals(Constant.nameError)){
            Assert.assertTrue(true);
        }
        else {
            Assert.assertTrue(false);
        }
        String emailError= vendorPage.errorMessage();
        if (emailError.equals(Constant.emailError)){
            Assert.assertTrue(true);
        }
        else {
            Assert.assertTrue(false);
        }
    }

    @When("User click on Catalog link")
    public void user_click_on_catalog_link() {
        categoryPageObject.clickOnCatalogLeftMenuLinkLocator();}
    @When("User Click on Manufacturers link")
    public void user_click_on_manufacturers_link() {
        categoryPageObject.clickOnCategoriesLeftMenuLink();
    }

    @Then("Page Heading should be {string}")
    public void page_heading_should_be(String string) {
        String actualHeading=categoryPageObject.getCategoriesHeading();
        if(actualHeading.equals(string)){
            Assert.assertTrue(true);
        }
        else {
            Assert.assertTrue(false);
        }

        categoryPageObject.buttonPresentOnCategories();
    }

}
