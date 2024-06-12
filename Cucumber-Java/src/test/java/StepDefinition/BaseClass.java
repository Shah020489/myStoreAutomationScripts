package StepDefinition;

import PageObject.AddNewCustomerPage;
import PageObject.LoginPage;
import PageObject.SearchPage;
import PageObject.VendorPage;
import Utility.ReadConfig;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.util.Properties;
import java.util.Random;

/**Parent class */
public class BaseClass {
    public WebDriver driver;
    public LoginPage loginPage;
    public AddNewCustomerPage addNewCustomerPage;
    public SearchPage searchPage;
    public Logger logger;
    public ReadConfig readConfig;

    public VendorPage vendorPage;
    public String generateEnail() {
        String[] domains = {"example.com", "mail.com", "test.com", "myemail.com", "domain.com"};
        String alphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();

        // Generate a random username of 8 characters
        StringBuilder username = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            int index = random.nextInt(alphaNumericString.length());
            username.append(alphaNumericString.charAt(index));
        }

        // Select a random domain
        String domain = domains[random.nextInt(domains.length)];

        // Construct the email address
        return username.toString() + "@" + domain;


    }
}
