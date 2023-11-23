package tesco.pages;

import baseitems.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class NoProductFoundPage extends BasePage {

    @FindBy(xpath = "//*[@id='product-list']/div[2]/div[3]/div/div[2]")
    WebElement noResultFoundMessage;

    public NoProductFoundPage(WebDriver driver) {
        super(driver);
    }

    public void validateNoSearchResult(){
        assertTrue(isLoaded());
        assertTrue(noResultFoundMessage.getText().contains("Sajnos nem található"));
    }
    public boolean isLoaded() {
        boolean isLoaded = isLoaded(noResultFoundMessage);
        return isLoaded;
    }
}
