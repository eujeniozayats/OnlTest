package pageobjects.menu;

import pageobjects.pages.SearchResultsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import testcases.TestBase;

public class menuNavigation {
    private final WebDriver driver = TestBase.driver;
    private final JavascriptExecutor js = (JavascriptExecutor) TestBase.driver;
    private final WebDriverWait wait = new WebDriverWait(TestBase.driver, 20);


    public menuNavigation(WebDriver driver) {

        TestBase.driver = driver;
    }

    public WebElement checkBox(String text) {
        String checkboxLocator = "//li/label[@class='schema-filter__checkbox-item']/span[text()='%s']";
        return driver.findElement(By.xpath(String.format(checkboxLocator, text)));
    }

    public WebElement priceToField() {
        String priceLocator = "//input[@class='schema-filter-control__item schema-filter__number-input schema-filter__number-input_price'][@placeholder='до']";
        return driver.findElement(By.xpath(priceLocator));
    }

    public void setPrice(String price) {
        wait.until(ExpectedConditions.elementToBeClickable(priceToField()));
        priceToField().sendKeys(price);
    }

    void waitForLoad(WebDriver driver) {
        wait.until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
    }

    public void selectCheckbox(String checkboxName) {
        wait.until(ExpectedConditions.elementToBeClickable(checkBox(checkboxName)));
        js.executeScript("arguments[0].scrollIntoView();", checkBox(checkboxName));
        checkBox(checkboxName).click();
        SearchResultsPage search = new SearchResultsPage(TestBase.driver);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='schema-product__title']")));
        wait.until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) TestBase.driver).executeScript("return document.readyState").equals("complete"));



    }

    public void selectLastCheckbox(String checkboxName) {
        wait.until(ExpectedConditions.elementToBeClickable(checkBox(checkboxName)));
        js.executeScript("arguments[0].scrollIntoView();", checkBox(checkboxName));
        checkBox(checkboxName).click();
        SearchResultsPage search = new SearchResultsPage(TestBase.driver);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='schema-product__title']")));
        wait.until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) TestBase.driver).executeScript("return document.readyState").equals("complete"));
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='schema-product__description']")));
        wait.until(ExpectedConditions. stalenessOf(element));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='schema-product__description']"))).getText();


    }


}