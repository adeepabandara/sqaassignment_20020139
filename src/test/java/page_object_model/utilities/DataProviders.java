package page_object_model.utilities;

import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider(name = "loginData")
    public static Object[][] getLoginData() {
        String filePath = "C:\\Users\\adeepa.bandara_rootc\\Videos\\Puma\\Puma\\src\\main\\resources\\file.xlsx"; // Update with your Excel file path
        return ExcelUtils.getExcelData(filePath, "LoginData"); // Update sheet name if needed
    }
}
