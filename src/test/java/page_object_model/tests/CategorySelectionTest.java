package page_object_model.tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import page_object_model.pages.CategoryPage;
import page_object_model.utilities.Utilities;

public class CategorySelectionTest extends Utilities {

    @Test
    public void testSelectWomenDressesAndOpenColorDropdown() {
        CategoryPage categoryPage = PageFactory.initElements(driver, CategoryPage.class);
        categoryPage.loadHomePage();
        categoryPage.selectWomenDressesAndSkirts();
        categoryPage.openWomenColorDropdown();
    }

    @Test
    public void testSelectMensSweatshirts() {
        CategoryPage categoryPage = PageFactory.initElements(driver, CategoryPage.class);
        categoryPage.loadHomePage();
        categoryPage.clickMenCategory();
   
    }
}
