package clindox.com.utils;

import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import static org.apache.poi.ss.usermodel.CellType.STRING;


public class ExcelReader {

    String FilePath;
    Workbook workbook;

    public  ExcelReader(String excelFilePath) throws Exception
    {
        FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
        workbook = new XSSFWorkbook(inputStream);

    }

    public List<String> getWorksheets()
    {
        int numberOfSheets = workbook.getNumberOfSheets();
        List<String> sheets = new ArrayList<String>();
        for (int i = 0; i < numberOfSheets; i++)
        {
            Sheet aSheet = workbook.getSheetAt(i);
            sheets.add(aSheet.getSheetName());
            System.out.println(aSheet.getSheetName());
        }
        return sheets;
    }

    private Sheet getWorkSheet(String SheetName)
    {
        return workbook.getSheet(SheetName);
    }

    public Object getCellValue(Cell cell) {
        DataFormatter formatter = new DataFormatter();
        switch (cell.getCellTypeEnum()) {
            case STRING:
                return cell.getStringCellValue();

            case BOOLEAN:
                return cell.getBooleanCellValue();

            case NUMERIC:
                return cell.getNumericCellValue();

        }
        return null;
    }

    public String getStringCellValue(Cell cell) {

        return cell.getStringCellValue();

    }

    public int  getRowCount(String SheetName)
    {
        Sheet sh = workbook.getSheet(SheetName);
        return sh.getLastRowNum();
    }

    public List<String> getData(String  SheetName , int rowno)
    {

        Sheet sh = workbook.getSheet(SheetName);
        int cols = sh.getRow(rowno).getLastCellNum();

        List<String> rowData =  new ArrayList<String>();

        for (int i=0;i<cols;i++)
        {
            Cell cell = sh.getRow(rowno).getCell(i);
            try {
                String celldata = getCellValue(cell).toString();
                celldata = celldata.replace(".0","");
                rowData.add(celldata);
            }catch (Exception ex)
            {
                rowData.add("");
            }
        }

        return rowData;
    }
}
