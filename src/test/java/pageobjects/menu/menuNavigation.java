package pageobjects.menu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import testcases.TestBase;
import Framework.Checkbox;
import Framework.CustomWaiter;

public class menuNavigation {
    private final WebDriver driver = TestBase.driver;
    private String checkboxLocator = "//li/label[@class='schema-filter__checkbox-item']/span[text()='%s']";
    private String priceLocator = "//input[@class='schema-filter-control__item schema-filter__number-input schema-filter__number-input_price'][@placeholder='до']";
    private By schemaTitle = By.xpath("//div[@class='schema-product__title']");


    public menuNavigation(WebDriver driver) {

        TestBase.driver = driver;
    }


    public WebElement checkBox(String text) {
        return driver.findElement(By.xpath(String.format(checkboxLocator, text)));
    }

    public WebElement priceToField() {
        return driver.findElement(By.xpath(priceLocator));
    }

    public void setPrice(String price) {
        CustomWaiter.sendValue(priceToField(), price);
    }

    public void selectCheckbox(String checkboxName) {
        Checkbox.check(checkBox(checkboxName));
    }

    public void WaitTillResultLoad() {
        CustomWaiter.waitTillElementNotStale(schemaTitle);
    }

}