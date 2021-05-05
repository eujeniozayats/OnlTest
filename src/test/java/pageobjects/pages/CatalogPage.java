package pageobjects.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import testcases.TestBase;


public class CatalogPage {
    static WebDriver driver = TestBase.driver;
    private final JavascriptExecutor js = (JavascriptExecutor) TestBase.driver;
    private final WebDriverWait wait = new WebDriverWait(TestBase.driver, 10);


    public CatalogPage(WebDriver driver) {
        TestBase.driver = driver;
    }

    public WebElement selectElement(String text) {
        String catalogLocator = "//span[text()='%s']";
        return driver.findElement(By.xpath(String.format(catalogLocator, text)));
    }

    public WebElement selectSubElement(String text) {
        String catalogSubLocator = "//div[contains(text(), '%s')]";
        return driver.findElement(By.xpath(String.format(catalogSubLocator, text)));
    }

    public WebElement dropdownItem(String text) {
        String categoryDropDown = "//span[contains(text(), '%s')]";
        return driver.findElement(By.xpath(String.format(categoryDropDown, text)));
    }

    public void selectCategory(String category) {
        wait.until(ExpectedConditions.elementToBeClickable(selectElement(category)));
        selectElement(category).click();
    }

    public void selectSubCategory(String subCategory) {
        wait.until(ExpectedConditions.elementToBeClickable(selectSubElement(subCategory)));
        selectSubElement(subCategory).click();

    }

    public void selectDropdownItem(String dropItem) {
        wait.until(ExpectedConditions.elementToBeClickable(dropdownItem(dropItem)));
        dropdownItem(dropItem).click();
    }
}