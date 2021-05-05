package pageobjects.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import testcases.TestBase;
import utils.ConfigFileReader;

public class MainPage {
    static WebDriver driver = TestBase.driver;
    private ConfigFileReader configFileReader = new ConfigFileReader();
    private final String myLocator = "//span[text()='%s' and @class='b-main-navigation__text']";
    private JavascriptExecutor js = (JavascriptExecutor) TestBase.driver;
    private WebDriverWait wait = new WebDriverWait(TestBase.driver, configFileReader.getImplicitlyWait());

    public MainPage(WebDriver driver) {
        TestBase.driver = driver;
    }

    public WebElement selectElement(String text) {
        return driver.findElement(By.xpath(String.format(myLocator, text)));
    }

    public void navigateSection(String section) {
        wait.until(ExpectedConditions.elementToBeClickable(selectElement(section)));
        js.executeScript("arguments[0].scrollIntoView();", selectElement(section));
        selectElement(section).click();

    }
}