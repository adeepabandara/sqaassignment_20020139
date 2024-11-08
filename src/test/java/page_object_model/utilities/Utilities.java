package page_object_model.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import page_object_model.pages.PumaHomePage;

public class Utilities {

    protected WebDriver driver;
    public static final String BASE_URL = "https://us.puma.com/us/en"; // Centralized base URL

    @BeforeMethod
    public void initializeBrowser() {
        driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();

        // Load the base URL at the start of each test
        loadBaseUrl();
    }

    // Method to load the base URL
    public void loadBaseUrl() {
        driver.get(BASE_URL);
    }

    @AfterMethod
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}
