package pageobjects.pages;

import org.openqa.selenium.*;
import org.testng.asserts.SoftAssert;
import testcases.TestBase;

import java.util.List;

public class SearchResultsPage {

    public SearchResultsPage(WebDriver driver) {
        TestBase.driver = driver;
    }

    public List<WebElement> titleResultsList = TestBase.driver.findElements(By.xpath("//div[@class='schema-product__title']"));
    public List<WebElement> descriptionResultsList = TestBase.driver.findElements(By.xpath("//div[@class='schema-product__description']"));
    public List<WebElement> descriptionResultsPrice = TestBase.driver.findElements(By.xpath("//a[@class='schema-product__price-value schema-product__price-value_primary']"));

    public void validateSearchList(List<WebElement> listToValidate, String stringToValidate) {
        SoftAssert softAssertion = new SoftAssert();

        for (int i = 0; i < listToValidate.size(); i++) {
            softAssertion.assertTrue(listToValidate.get(i).getText().contains(stringToValidate), "Item validation failed at instance " + i + ".");
            softAssertion.assertAll();
            System.out.println(listToValidate.get(i).getText());
        }
    }

    public void validateSearchPrices(List<WebElement> listToValidate, String price) {
        SoftAssert softAssertion = new SoftAssert();

        for (int i = 0; i < listToValidate.size(); i++) {
            softAssertion.assertTrue(Integer.parseInt(listToValidate.get(i).getText().replaceAll(".{6}$|^от ", "")) <= Integer.parseInt(price), "Price validation failed at instance " + i + ".");
            softAssertion.assertAll();
        }

    }

    public void validateSearchInches(List<WebElement> listToValidate, String minInch, String maxInch) {
        SoftAssert softAssertion = new SoftAssert();

        for (int i = 0; i < listToValidate.size(); i++) {
            int parsedInt = Integer.parseInt(listToValidate.get(i).getText().substring(0, 2));
            if (parsedInt < Integer.parseInt(maxInch.substring(0, maxInch.length() - 1)) | parsedInt > Integer.parseInt(minInch.substring(0, minInch.length() - 1))) {
                softAssertion.assertTrue(true, "Pass");

            } else softAssertion.fail("Wrong screen resolution");

            softAssertion.assertAll();
        }

    }
}
