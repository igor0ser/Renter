package com.epam.renter.properties;

import java.util.ResourceBundle;

public class Config {

	private static Config instance;
	private ResourceBundle resource;
	private static final String BUNDLE_NAME = "com.epam.renter.properties.config";
	public static final String WELCOME = "WELCOME";
    public static final String ERROR_LOGIN = "ERROR_LOGIN";
    public static final String MY_APPS = "MY_APPS";
    public static final String THANK_YOU = "THANK_YOU";
    public static final String ERROR_DB = "ERROR_DB";
    public static final String ADMIN_WELCOME = "ADMIN_WELCOME";
    
    

    public static Config getInstance() {
        if (instance == null) {
            instance = new Config();
            instance.resource = ResourceBundle.getBundle(BUNDLE_NAME);
        }
        return instance;
    }
	
	   private Config() {
	    }
	   public String getProperty(String key) {
	        return (String) resource.getObject(key);
	    }

}
