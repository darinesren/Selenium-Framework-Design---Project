package com.qart.todo.utils;

import java.util.Properties;

public class ConfigUtils {

    Properties properties;
    private static ConfigUtils configUtils;

    private ConfigUtils(){
        String env = System.getProperty("env", "PRODUCATION");
        switch (env) {
            case "PRODUCATION":
                properties = PropertiesUtils.loadProperties("src/test/java/com/qart/todo/config/producation.properties");
                break;
            case "LOCAL":
                properties = PropertiesUtils.loadProperties("src/test/java/com/qart/todo/config/producation.properties");
                break;
            default:
                throw new RuntimeException("env is not support");
        }
     }

    public static ConfigUtils getInstance(){
        if(configUtils == null)
            configUtils=new ConfigUtils();
        return configUtils ;
    }

    public String getBaseUrl(){
        String prop=properties.getProperty("baseUrl");
       if(prop != null) return  prop;
       throw new RuntimeException("could not fine the base url");
    }
    public String getEmail(){
        String prop=properties.getProperty("email");
        if(prop != null) return  prop;
        throw new RuntimeException("could not fine the email");
    }
    public String getPassword(){
        String prop=properties.getProperty("password");
        if(prop != null) return  prop;
        throw new RuntimeException("could not fine the password");
    }



}
