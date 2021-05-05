package Framework;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import testcases.TestBase;

public interface Checkbox {
    final WebDriver driver = TestBase.driver;
    final JavascriptExecutor js = (JavascriptExecutor) TestBase.driver;


    public static void check(WebElement element) {
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(element));
        js.executeScript("arguments[0].scrollIntoView();", element);
        element.click();
        (new WebDriverWait(driver, 10)).until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) TestBase.driver).executeScript("return document.readyState").equals("complete"));
    }
}
