package page_object_model.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class PumaSearchResultsPage extends BasePage {

    @FindBy(xpath = "//input[@type='checkbox' and @name='Free Shipping']")
    private WebElement freeShippingCheckbox;

    @FindBy(xpath = "//div[contains(@class, 'product-tile')]")
    private WebElement firstProduct;

    public PumaSearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public void selectFreeShippingCheckbox() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(freeShippingCheckbox)).click();
    }

    public void clickFirstProduct() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(firstProduct)).click();
    }
}
