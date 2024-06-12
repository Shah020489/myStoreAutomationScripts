package com.mystore.testcases;

import com.mystore.utilities.ReadConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import org.testng.log4testng.Logger;
import java.io.FileNotFoundException;
import java.time.Duration;

public class BaseClass {

    ReadConfig readConfig;

    {
        try {
            readConfig = new ReadConfig();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static WebDriver driver;
    public static Logger logger;
    String url=readConfig.getBaseUrl();
    String browser=readConfig.getBrowser();

    @BeforeClass
    public void setup(){

        switch (browser.toLowerCase()){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver=new ChromeDriver();
                break;
            case "msedge":
                WebDriverManager.edgedriver().setup();
                driver=new EdgeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver=new FirefoxDriver();
                break;
            default:
                driver=null;
                break;
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //for logging
        logger= (Logger) LogManager.getLogger("MyStore");

    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }



}
