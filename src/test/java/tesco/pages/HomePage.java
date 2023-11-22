package tesco.pages;

import baseitems.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage{

    //locator for accept cookie button
    @FindBy (xpath = ("//*[@id=\"sticky-bar-cookie-wrapper\"]/span/div/div/div[2]/form[1]/button"))
    WebElement acceptCookiesButton;

    //locator for search field on the homepage
    @FindBy(xpath = "//*[@id='search-input']")
    WebElement searchField;

    //locator for the search button
    @FindBy(css= "#search-form > button")
    WebElement searchButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void acceptCookies() {
        acceptCookiesButton.click();

    }
    public SearchResultPage searchProduct(String productName) {
        wait.until(ExpectedConditions.elementToBeClickable(searchField));
        searchField.sendKeys(productName);
        searchButton.click();
        return new SearchResultPage(driver);
    }
    public boolean isLoaded() {
        return isLoaded(acceptCookiesButton) && isLoaded(searchButton) && isLoaded(searchField);
    }
}
