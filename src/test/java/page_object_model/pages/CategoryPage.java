package page_object_model.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.ElementClickInterceptedException;
import page_object_model.utilities.Utilities;

import java.time.Duration;

public class CategoryPage extends BasePage {

    // Elements for the Women category
    @FindBy(xpath = "//span[contains(text(), 'Women') and contains(@class, 'nav-underline')]")
    private WebElement womenCategory;

    @FindBy(xpath = "//a[@data-link-name='Dresses & Skirts']")
    private WebElement dressesAndSkirtsLink;

    @FindBy(xpath = "//*[name()='use' and contains(@href, 'chevron-down.svg#icon')]/ancestor::button")
    private WebElement womenColorDropdownButton;

    @FindBy(xpath = "//span[@class='inline-flex justify-center items-center border w-9 h-9 rounded-full border-puma-black overflow-hidden bg-swatch-red']")
    private WebElement womenRedColorOption;

    // Elements for the Men category
    @FindBy(linkText = "Men")
    private WebElement menCategoryLink;

    @FindBy(xpath = "//a[@href='https://us.puma.com/us/en/men/clothing/hoodies-and-sweatshirts']")
    private WebElement mensSweatshirtsLink;

    public CategoryPage(WebDriver driver) {
        super(driver);
    }

    public void loadHomePage() {
        driver.get(Utilities.BASE_URL);
    }

    // Women category methods
    public void selectWomenDressesAndSkirts() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(womenCategory));
        new Actions(driver).moveToElement(womenCategory).perform();
        wait.until(ExpectedConditions.elementToBeClickable(dressesAndSkirtsLink)).click();
    }

    public void openWomenColorDropdown() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(womenColorDropdownButton)).click();
    }

    public void selectWomenRedColor() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(womenRedColorOption)).click();
    }

    // Men category methods
    public void clickMenCategory() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(menCategoryLink)).click();
    }



}
