package DataSet;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FrameworkTestData {

    public static class DataTable {

        XSSFWorkbook workbook = null;
        XSSFSheet sheet = null;
        XSSFRow row = null;
        XSSFCell cell = null;

        @DataProvider(name="LoginTestData")
        public Object[][] getLoginCellData() throws IOException {

            File inputfile = new File("C:\\Users\\tangutp\\Documents\\MobileAutomation\\src\\main\\java\\Utilities");
            File source = new File(inputfile, "TestData.xlsx");
            FileInputStream fis = new FileInputStream(source.getAbsolutePath());
            workbook = new XSSFWorkbook(fis);
            sheet = workbook.getSheet("LoginTestData");

            int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum() + 1;
            int colCount = sheet.getRow(0).getLastCellNum();

            System.out.println("Row Count is: " + rowCount + " *** Column count is: " + colCount);

            Object data[][] = new Object[rowCount - 1][colCount];
            for (int rNum = 2; rNum <= rowCount; rNum++) {
                for (int cNum = 0; cNum < colCount; cNum++) {
                    System.out.println(getCellData("LoginTestData", cNum, rNum) + " ");
                    data[rNum - 2][cNum] = getCellData("LoginTestData", cNum, rNum);
                }
            }
            System.out.println("\n");
            return data;
        }

        @DataProvider(name="ForgotPasswordTestData")
        public Object[][] getFPData() throws IOException {

            File inputfile = new File("C:\\Users\\tangutp\\Documents\\MobileAutomation\\src\\main\\java\\Utilities");
            File source = new File(inputfile, "TestData.xlsx");
            FileInputStream fis = new FileInputStream(source.getAbsolutePath());
            workbook = new XSSFWorkbook(fis);
            sheet = workbook.getSheet("ForgotPasswordTestData");

            int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum() + 1;
            int colCount = sheet.getRow(0).getLastCellNum();

            System.out.println("Row Count is: " + rowCount + " *** Column count is: " + colCount);

            Object data[][] = new Object[rowCount - 1][colCount];
            for (int rNum = 2; rNum <= rowCount; rNum++) {
                for (int cNum = 0; cNum < colCount; cNum++) {
                    System.out.println(getCellData("ForgotPasswordTestData", cNum, rNum) + " ");
                    data[rNum - 2][cNum] = getCellData("ForgotPasswordTestData", cNum, rNum);
                }
            }
            System.out.println("\n");
            return data;
        }

        public String getCellData(String sheetName, int colNum, int rowNum) {

            try {

                if (rowNum <= 0)
                    return "";

                int index = workbook.getSheetIndex(sheetName);
                if (index == -1)
                    return "";
                sheet = workbook.getSheetAt(index);
                row = sheet.getRow(rowNum - 1);

                if (row == null)
                    return "";

                cell = row.getCell(colNum);

                if (cell == null)
                    return "";

                if (cell.getCellType() == cell.CELL_TYPE_STRING)
                    return cell.getStringCellValue();

                else if (cell.getCellType() == cell.CELL_TYPE_NUMERIC || cell.getCellType() == cell.CELL_TYPE_FORMULA) {
                    String cellText = String.valueOf(cell.getNumericCellValue());
                    return cellText;
                } else if (cell.getCellType() == cell.CELL_TYPE_BLANK)
                    return "";
                else
                    return String.valueOf(cell.getBooleanCellValue());
            } catch (Exception e) {
                e.printStackTrace();
                return "Row" + rowNum + "or Column" + colNum + "Does not exist";
            }


        }
    }
}
