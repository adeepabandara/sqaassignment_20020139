package page_object_model.utilities;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

public class ExcelUtils {

    public static Object[][] getExcelData(String filePath, String sheetName) {
        Object[][] data = null;

        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheet(sheetName);
            int rowCount = sheet.getPhysicalNumberOfRows();
            int colCount = sheet.getRow(0).getPhysicalNumberOfCells();

            data = new Object[rowCount - 1][colCount];
            DataFormatter formatter = new DataFormatter();

            Iterator<Row> rowIterator = sheet.iterator();
            rowIterator.next(); // Skip header row

            int i = 0;
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                data[i][0] = formatter.formatCellValue(row.getCell(0)); // Email
                data[i][1] = formatter.formatCellValue(row.getCell(1)); // Password
                data[i][2] = Boolean.parseBoolean(formatter.formatCellValue(row.getCell(2))); // ExpectedResult (true/false)
                i++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }
}
