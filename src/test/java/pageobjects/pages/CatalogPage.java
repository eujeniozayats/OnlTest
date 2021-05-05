package pageobjects.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import Framework.CustomWaiter;

import testcases.TestBase;


public class CatalogPage {
    static WebDriver driver = TestBase.driver;
    private final String catalogLocator = "//span[text()='%s']";
    private final String catalogSubLocator = "//div[contains(text(), '%s')]";
    private final String categoryDropDown = "//span[contains(text(), '%s')]";


    public CatalogPage(WebDriver driver) {
        TestBase.driver = driver;
    }

    public WebElement selectElement(String text) {
        return driver.findElement(By.xpath(String.format(catalogLocator, text)));
    }

    public WebElement selectSubElement(String text) {
        return driver.findElement(By.xpath(String.format(catalogSubLocator, text)));
    }

    public WebElement dropdownItem(String text) {
        return driver.findElement(By.xpath(String.format(categoryDropDown, text)));
    }

    public void selectCategory(String category) {
        CustomWaiter.selectElement(selectElement(category));
    }

    public void selectSubCategory(String subCategory) {
        CustomWaiter.selectElement(selectSubElement(subCategory));
    }

    public void selectDropdownItem(String dropItem) {
        CustomWaiter.selectElement(dropdownItem(dropItem));
    }

}