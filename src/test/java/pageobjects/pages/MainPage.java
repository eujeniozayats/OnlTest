package pageobjects.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import testcases.TestBase;

import utils.Constant;

public class MainPage {
    static WebDriver driver = TestBase.driver;
    private final String myLocator = "//span[text()='%s' and @class='b-main-navigation__text']";
    private JavascriptExecutor js = (JavascriptExecutor) TestBase.driver;
    private WebDriverWait wait = new WebDriverWait(TestBase.driver, 10);


    public MainPage(WebDriver driver) {
        TestBase.driver = driver;
    }

    public WebElement selectElement(String text) {
        return driver.findElement(By.xpath(String.format(myLocator, text)));
    }

    public void openCatalog() {
        SoftAssert softAssertion = new SoftAssert();
        wait.until(ExpectedConditions.elementToBeClickable(selectElement("Каталог")));
        js.executeScript("arguments[0].scrollIntoView();", selectElement("Каталог"));
        selectElement("Каталог").click();
        wait.until(ExpectedConditions.titleIs(Constant.catalogTitle));
        softAssertion.assertEquals(TestBase.driver.getTitle(), Constant.catalogTitle);
        softAssertion.assertAll();

    }
}