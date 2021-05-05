package Framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import testcases.TestBase;
import utils.ConfigFileReader;

public interface CustomWaiter {
    final WebDriver driver = TestBase.driver;
    final ConfigFileReader reader = new ConfigFileReader();


    public static void waitTillElementNotStale(By by) {
        (new WebDriverWait(driver, reader.getImplicitlyWait())).until(ExpectedConditions.presenceOfElementLocated(by));
        WebElement element = (new WebDriverWait(driver, reader.getImplicitlyWait())).until(ExpectedConditions.presenceOfElementLocated(by));
        (new WebDriverWait(driver, reader.getImplicitlyWait())).until(ExpectedConditions.stalenessOf(element));
        (new WebDriverWait(driver, reader.getImplicitlyWait())).until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public static void sendValue(WebElement element, String value) {
        (new WebDriverWait(driver, reader.getImplicitlyWait())).until(ExpectedConditions.elementToBeClickable(element));
        element.sendKeys(value);
    }

    public static void selectElement(WebElement element) {
        (new WebDriverWait(driver, reader.getImplicitlyWait())).until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }


}
