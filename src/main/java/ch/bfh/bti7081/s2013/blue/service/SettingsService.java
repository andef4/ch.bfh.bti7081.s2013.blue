package ch.bfh.bti7081.s2013.blue.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * A Service the get application settings
 * @author andef4
 */
public class SettingsService {

    private static SettingsService instance = null;
    
    public static SettingsService getInstance() {
        if (instance == null) {
            instance = new SettingsService();
        }
        return instance;
    }
    
    private Properties properties;
    
    private SettingsService() {
        properties = new Properties();
        InputStream is  = this.getClass().getResourceAsStream("/settings.properties");
        try {
            properties.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String getSetting(String settingName, String fallback) {
        String ret = properties.getProperty(settingName);
        if (ret == null) {
            ret = fallback;
        }
        return ret;
    }
}
