package page_object_model.tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page_object_model.pages.LoginPage;
import page_object_model.pages.PumaHomePage;
import page_object_model.utilities.DataProviders;
import page_object_model.utilities.Utilities;

public class LoginTest extends Utilities {

    @Test(dataProvider = "loginData", dataProviderClass = DataProviders.class)
    public void testLogin(String email, String password, boolean shouldPass) {
        SoftAssert softAssert = new SoftAssert();

        PumaHomePage homePage = PageFactory.initElements(driver, PumaHomePage.class);
        homePage.loadHomePage();

        homePage.openAccountDropdown();

        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.goToLoginPage();

        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (shouldPass) {
            boolean isLoggedIn = checkSuccessfulLogin();
            softAssert.assertTrue(isLoggedIn, "Expected login to pass, but it failed for: " + email);
        } else {
            boolean isLoginFailed = checkFailedLogin();
            softAssert.assertTrue(isLoginFailed, "Expected login to fail, but it passed for: " + email);
        }

        softAssert.assertAll();
    }

    private boolean checkSuccessfulLogin() {
        return true;
    }

    private boolean checkFailedLogin() {

        return true; // Replace with actual condition
    }
}
