package com.cs_automation.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {

    Properties properties;
    String path = "C:\\Cs_Automation\\Cs_Automation\\Configration\\config.properties";

    // Constructor
    public ReadConfig() {
        properties = new Properties();
        try {
            FileInputStream fis = new FileInputStream(path);
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Get URL
    public String getURL() {
        String value = properties.getProperty("baseurl");
        if (value != null)
            return value;
        else
            throw new RuntimeException("URL not found in config.properties");
    }

    // Get Browser 
    public String getBrowser() {
        String value = properties.getProperty("browser");
        if (value != null)
            return value;
        else
            throw new RuntimeException("Browser not found in config.properties");
    }
}

