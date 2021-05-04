package testcases;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeOptions;
import utils.Constant;

public class TestBase {

    public static WebDriver driver = null;
    public static String browserName = Constant.browserName;
    public static String projectPath = System.getProperty(Constant.projectPath);


    public static void initialize() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);


        if (driver == null) {
            if (browserName.equalsIgnoreCase(Constant.browserName)) {
                System.setProperty(Constant.driverProperty, projectPath + Constant.driverDirectory);
                driver = new ChromeDriver();
            }
        }

        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Constant.implicitlyWait, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(Constant.implicitlyWait, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(Constant.URL);

    }

    public static void quit() {

        driver.quit();
        driver = null;

    }


}