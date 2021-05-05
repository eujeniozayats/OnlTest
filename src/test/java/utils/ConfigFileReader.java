package utils;

import java.security.Key;
import java.util.Properties;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class ConfigFileReader {

    private Properties properties;
    private final String propertyFilePath= "src/test/resources/config.properties";


    public ConfigFileReader(){
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
        }
    }

    public String getBrowserName(){
        String browserName = properties.getProperty("browserName");
        if(browserName!= null) return browserName;
        else throw new RuntimeException("browserName not specified in the Configuration.properties file.");
    }

    public long getImplicitlyWait() {
        String implicitlyWait = properties.getProperty("implicitlyWait");
        if(implicitlyWait != null) return Long.parseLong(implicitlyWait);
        else throw new RuntimeException("implicitlyWait not specified in the Configuration.properties file.");
    }

    public String getURL() {
        String URL = properties.getProperty("URL");
        if(URL != null) return URL;
        else throw new RuntimeException("url not specified in the Configuration.properties file.");
    }
    public String getProjectPath() {
        String projectPath = properties.getProperty("projectPath");
        if(projectPath != null) return projectPath;
        else throw new RuntimeException("projectPath not specified in the Configuration.properties file.");
    }
    public String getDriverDirectory() {
        String driverDirectory = properties.getProperty("driverDirectory");
        if(driverDirectory != null) return driverDirectory;
        else throw new RuntimeException("driverDirectory not specified in the Configuration.properties file.");
    }
    public String getDriverProperty() {
        String driverProperty = properties.getProperty("driverProperty");
        if(driverProperty != null) return driverProperty;
        else throw new RuntimeException("driverProperty not specified in the Configuration.properties file.");
    }



}