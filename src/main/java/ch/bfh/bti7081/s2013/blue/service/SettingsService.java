package ch.bfh.bti7081.s2013.blue.service;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
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
        BufferedInputStream is;
        try {
            is = new BufferedInputStream(new FileInputStream("settings.properties"));
            properties.load(is);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getSetting(String settingName, String fallback) {
        String ret = properties.getProperty(settingName);
        if (ret == null) {
            ret = fallback;
        }
        return fallback;
    }
}
