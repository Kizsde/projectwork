package tesco.pages;

import baseitems.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchResultPage extends BasePage {

    @FindBy(css = "#tile-2005110144574 > div.product-details--wrapper > h3 > a > span")
    WebElement searchResultName;


    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public void validateSearchResultName(String nameOfProduct){
        assertTrue(isLoaded());
        assertTrue(searchResultName.getText().contains(nameOfProduct));
    }

    public boolean isLoaded() {
        boolean isLoaded = isLoaded(searchResultName);
        return isLoaded;
    }
}
