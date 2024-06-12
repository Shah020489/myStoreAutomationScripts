package com.mystore.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
    Properties properties;
    String path="C:\\Learning\\Automation-Sessions\\JavaRevision\\myStoreAutomationScripts\\myStoreEcomerence\\Configuration\\config.properties";

    public ReadConfig() throws FileNotFoundException {
        properties=new Properties();
        FileInputStream fis=new FileInputStream(path);
        try {
            properties.load(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getBaseUrl(){
        String value= properties.getProperty("baseurl");
        if (value!=null)
            return value;
        else
            throw new RuntimeException("URL is not found in properties files");
    }

    public String getBrowser(){
        String value= properties.getProperty("browser");
        if (value!=null)
            return value;
        else
            throw new RuntimeException("Browser is not found in properties files");
    }

}
