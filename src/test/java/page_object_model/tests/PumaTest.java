package page_object_model.tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import page_object_model.pages.PumaHomePage;
import page_object_model.utilities.Utilities;

public class PumaTest extends Utilities {

    @Test
    public void test_searchBlackShoesAndFilterByMen() {
        PumaHomePage homePage = PageFactory.initElements(driver, PumaHomePage.class);
        homePage.loadHomePage();

        homePage.openSearchSection();
        homePage.typeSearchText("black shoes");
        homePage.clickSearchButton();

        homePage.openGenderDropdown();
        homePage.selectMenCheckbox();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        homePage.closeGenderDropdown();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        homePage.scrollToViewResults();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
