package steps;

import browser.BrowserType;
import browser.DriverInitializer;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import tesco.pages.HomePage;
import tesco.pages.SearchResultPage;

import java.time.Duration;

import static browser.Settings.TESCO_URL;

public class TescoSteps {

    WebDriver driver;

    @Before
    public void openBrowser() {
        driver = DriverInitializer.initDriver(BrowserType.CHROME_SELENIUM_MGR);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();

    }

    @After
    public void cleanup() {
        driver.quit();
   }

    @Given("I open home page")
    public void iOpenHomePage() {
        driver.get(TESCO_URL);

    }

    @And("I accept cookies")
    public void iAcceptCookies() {
        HomePage homePage = new HomePage(driver);
        homePage.acceptCookies();

    }

    @When("I search for {string}")
    public void iSearchForProduct(String nameOfProduct) {
        HomePage homePage = new HomePage(driver);
        homePage.searchProduct(nameOfProduct);

    }

    @Then("product is displayed that contains {string}")
    public void productDisplayed(String displayedProduct) {
        SearchResultPage searchResultPage = new SearchResultPage(driver);
        searchResultPage.validateSearchResultName(displayedProduct);
    }
}
/*
    @Then("the search function does nothing and stays on the same page")
    public void emptyInputSearch() {
    }

    @Then("a message is displayed that the search didn't find anything")
    public void noProductFoundMessage() {
    }

}

 */
