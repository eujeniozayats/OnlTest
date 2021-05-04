package testcases;

import org.testng.annotations.*;
import pageobjects.menu.menuNavigation;
import pageobjects.pages.CatalogPage;
import pageobjects.pages.MainPage;
import pageobjects.pages.SearchResultsPage;


public class OnlinerTest {
    static menuNavigation menu;
    static CatalogPage catalogPage;
    static MainPage mainPage;
    static SearchResultsPage search;


    @BeforeClass

    public void setup() {
        TestBase.initialize();
    }


    @Test
    @Parameters({"brand", "testPrice", "resolution", "40inch", "50inch"})
    public void getToSearchResult(String brand, String price,
                                  String resolution, String inch40, String inch50) {

        mainPage = new MainPage((TestBase.driver));
        mainPage.openCatalog();

        catalogPage = new CatalogPage(TestBase.driver);
        catalogPage.selectCategory("Электроника");
        catalogPage.selectSubCategory("Телевидение");
        catalogPage.selectDropdownItem("Телевизоры");

        menu = new menuNavigation(TestBase.driver);
        menu.selectCheckbox(brand);
        menu.setPrice(price);
        menu.selectCheckbox(resolution);
        menu.selectCheckbox(inch40);
        menu.selectCheckbox(inch50);
        /*try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/

        search = new SearchResultsPage(TestBase.driver);
        search.validateSearchList(search.titleResultsList, brand);
        search.validateSearchList(search.descriptionResultsList, resolution);
        search.validateSearchPrices(search.descriptionResultsPrice, price);
        search.validateSearchInches(search.descriptionResultsList, inch40, inch50);
    }


    @AfterClass
    public void tearDown() {
        TestBase.quit();
    }
}

