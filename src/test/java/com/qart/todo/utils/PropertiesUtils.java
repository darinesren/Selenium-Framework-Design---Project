package com.qart.todo.utils;

import java.io.*;
import java.util.Properties;

public class PropertiesUtils {
    public static Properties loadProperties(String path){

        File file = new File(path);

        try {
            InputStream inputStream = new FileInputStream(file);
            Properties prop=new Properties();
            prop.load(inputStream);
            //  prop.getProperty("baseUrl"); when call excute
            inputStream.close();
            return prop ;

        } catch (FileNotFoundException e) {
            throw new RuntimeException("file is not found");
        } catch (IOException e) {
            throw new RuntimeException("error while loading properties");
        }


    }
}
