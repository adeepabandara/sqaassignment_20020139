package page_object_model.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//a[@role='menuitem' and text()='My Account']")
    private WebElement myAccountLink;

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(className = "roi-cookie-start")
    private WebElement cookieBanner;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void closeCookieBannerIfPresent() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            if (cookieBanner.isDisplayed()) {
                cookieBanner.click();
                WebElement dismissButton = cookieBanner.findElement(By.xpath(".//button[contains(text(), 'Accept')]"));
                if (dismissButton.isDisplayed()) {
                    dismissButton.click();
                }
                wait.until(ExpectedConditions.invisibilityOf(cookieBanner));
            }
        } catch (Exception e) {

        }
    }

    public void goToLoginPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(myAccountLink)).click();
    }

    public void enterEmail(String email) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(emailField)).sendKeys(email);
    }


    public void enterPassword(String password) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(passwordField)).sendKeys(password + Keys.RETURN);

    }
}
