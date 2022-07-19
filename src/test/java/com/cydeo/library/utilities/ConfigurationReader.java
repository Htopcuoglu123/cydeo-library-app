package com.cydeo.library.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
    //1-Create properties object
    //2-We made this private so it is inaccessible from outside
    //3-We made it static because static runs first,and before everything else,
    // and we will use this object under static method
    private static Properties properties=new Properties();
   //having static block because static runs first,and before everything else,
    static {
        try {
            //Create FileInputStream object to open file as a stream in Java memory
            FileInputStream file = new FileInputStream("configuration.properties");
            //Load "properties" object with the "file" we opened using FileInputStream
            properties.load(file);
        } catch (IOException e) {
            System.out.println("File not found in ConfigurationReader class");
            e.printStackTrace();
        }
    }
    public static String getProperty(String keyword){
       return properties.getProperty(keyword);
    }
}
