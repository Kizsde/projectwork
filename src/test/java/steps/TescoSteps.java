package steps;

import browser.BrowserType;
import browser.DriverInitializer;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.time.Duration;

import static browser.Settings.TESCO_URL;

public class TescoSteps {

    WebDriver driver;

    @Before
    public void openBrowser() {
        driver = DriverInitializer.initDriver(BrowserType.CHROME_SELENIUM_MGR);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    @Given("I open Tesco page")
    public void iOpenTescoPage() {
        driver.get(TESCO_URL);
    }

    @And("I accept cookies")
    public void iAcceptCookies() {
        By cookieButton = By.xpath("//button[text()='Minden cookie elfogadása']");
        driver.findElement(cookieButton).click();
    }

    @When("I search for {string}")
    public void iSearchForProduct(String productName) {
        By searchForProductField = By.id("search-input");
        driver.findElement(searchForProductField).sendKeys(productName);
        driver.findElement(By.cssSelector("button.search-bar__submit")).click();
    }

    @Then("products are displayed that contain {string}")
    public void productsDisplayed(String arg0) {
    }

    @Then("the search function does nothing and stays on the same page")
    public void emptyInputSearch() {
    }

    @Then("a message is displayed that the search didn't find anything")
    public void noProductFoundMessage() {
    }

}
