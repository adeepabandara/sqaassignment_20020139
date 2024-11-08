package page_object_model.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page_object_model.utilities.Utilities;

import java.time.Duration;

public class PumaHomePage extends Utilities {

    public PumaHomePage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(id = "account-button")
    private WebElement accountButton;


    @FindBy(xpath = "//div[contains(@class, 'opacity-100') and text()='Search']")
    private WebElement searchSection;

    @FindBy(name = "Search")
    private WebElement searchBox;

    @FindBy(css = "button[data-test-id='search-flyout-form-submit']")
    private WebElement searchButton;

    @FindBy(xpath = "//*[name()='use' and contains(@href, 'chevron-down.svg#icon')]/ancestor::button")
    private WebElement genderDropdownButton;

    @FindBy(css = "label[for='Men']")
    private WebElement menLabel;

    @FindBy(xpath = "//*[name()='use' and contains(@href, 'close.svg#icon')]/ancestor::button")
    private WebElement closeDropdownButton;

    public void loadHomePage() {
        loadBaseUrl();
    }

    public void openAccountDropdown() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(accountButton)).click();
    }


    public void openSearchSection() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(searchSection)).click();
    }

    public void typeSearchText(String searchText) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(searchBox)).sendKeys(searchText);
    }

    public void clickSearchButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
    }

    public void openGenderDropdown() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(genderDropdownButton)).click();
    }

    public void selectMenCheckbox() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(menLabel)).click();
    }

    public void closeGenderDropdown() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(closeDropdownButton)).click();
    }


    public void scrollToViewResults() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500)");
    }
}
