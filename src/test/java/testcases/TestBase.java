package testcases;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeOptions;
import utils.ConfigFileReader;

public class TestBase {

    public static WebDriver driver = null;
    public static String browserName;
    public static String projectPath;
    public static ConfigFileReader configFileReader;


    public static void initialize() {
        configFileReader = new ConfigFileReader();
        browserName = configFileReader.getBrowserName();
        projectPath = System.getProperty(configFileReader.getProjectPath());
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);


        if (driver == null) {
            if (browserName.equalsIgnoreCase(configFileReader.getBrowserName())) {
                System.setProperty(configFileReader.getDriverProperty(), projectPath + configFileReader.getDriverDirectory());
                driver = new ChromeDriver();
            }
        }

        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(), TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(configFileReader.getImplicitlyWait(), TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(configFileReader.getURL());

    }

    public static void quit() {

        driver.quit();
        driver = null;

    }


}