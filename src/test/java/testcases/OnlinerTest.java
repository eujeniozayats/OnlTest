package testcases;

import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import pageobjects.menu.menuNavigation;
import pageobjects.pages.CatalogPage;
import pageobjects.pages.MainPage;
import pageobjects.pages.SearchResultsPage;

import utils.ConfigFileReader;


public class OnlinerTest {
    static menuNavigation menu;
    static CatalogPage catalogPage;
    static MainPage mainPage;
    static SearchResultsPage search;
    static SoftAssert softAssert;
    static ConfigFileReader configFileReader;


    @BeforeClass

    public void setup() {
        TestBase.initialize();
    }


    @Test
    @Parameters({"catDir", "brand", "testPrice", "resolution", "minDiagonal", "maxDiagonal"})
    public void getToSearchResult(String catDir, String brand, String price,
                                  String resolution, String minDiagonal, String maxDiagonal) {
        configFileReader = new ConfigFileReader();
        softAssert = new SoftAssert();
        mainPage = new MainPage((TestBase.driver));
        mainPage.navigateSection(catDir);

        catalogPage = new CatalogPage(TestBase.driver);
        catalogPage.selectCategory("Электроника");
        catalogPage.selectSubCategory("Телевидение");
        catalogPage.selectDropdownItem("Телевизоры");
        softAssert.assertEquals(TestBase.driver.getTitle(), "Телевизор купить в Минске");


        menu = new menuNavigation(TestBase.driver);
        menu.selectCheckbox(brand);
        menu.setPrice(price);
        menu.selectCheckbox(resolution);
        menu.selectCheckbox(minDiagonal);
        menu.selectCheckbox(maxDiagonal);
        menu.WaitTillResultLoad();

        search = new SearchResultsPage(TestBase.driver);
        search.validateSearchList(search.titleResultsList, brand);
        search.validateSearchList(search.descriptionResultsList, resolution);
        search.validateSearchPrices(search.descriptionResultsPrice, price);
        search.validateSearchInches(search.descriptionResultsList, minDiagonal, maxDiagonal);
    }


    @AfterClass
    public void tearDown() {
        softAssert.assertAll();
        TestBase.quit();
    }
}

