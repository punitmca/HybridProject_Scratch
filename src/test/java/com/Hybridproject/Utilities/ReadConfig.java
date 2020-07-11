package com.Hybridproject.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

    Properties pro;

    public ReadConfig()
    {
        File src = new File("./Configuration/config.properties");

        try {
            FileInputStream fis = new FileInputStream(src);
            pro = new Properties();
            pro.load(fis);
        } catch (Exception e) {
            System.out.println("Exception is " + e.getMessage());
        }
    }

    public String getApplicationURL()
    {
        String url=pro.getProperty("baseURL");
        System.out.println("Url is"+url);
        return url;
    }

    public String getUsername()
    {
        String username=pro.getProperty("username");
        return username;
    }

    public String getPassword()
    {
        String password=pro.getProperty("pwd");
        return password;
    }

    public String getChromePath()
    {

        String chrome=pro.getProperty("chromepath");
        return chrome;

    }



    public String getIEPath()
    {
        String iepath=pro.getProperty("iepath");
        return iepath;
    }

    public String getFirefoxPath()
    {
        String firefoxpath=pro.getProperty("firefox");
        return firefoxpath;
    }


}


