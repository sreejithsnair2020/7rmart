package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import constant.Constant;

public class ExcelUtility 
{

	static FileInputStream f;

	static XSSFWorkbook wb;

	static XSSFSheet sh; 

	public static String getStringData(int a,int b,String sheet)throws IOException // a reprdesent row value 7 B REPRESENT CELL VALUE IN SHEET

	{

		String filePath = Constant.TESTDATAFILE; //class name dot method name
		f=new FileInputStream(filePath); //class to get details from he file

		wb=new XSSFWorkbook(f); // class to get details from the work book
 
		sh=wb.getSheet(sheet); // METOD USED TO GET VALUES FROM SHEET

		XSSFRow r=sh.getRow(a);

		XSSFCell c=r.getCell(b);

		return c.getStringCellValue(); // this methos is used to get string value as output

	}
	
	public static String getIntegerData(int a,int b, String sheet) throws IOException

	{
		String filePath = Constant.TESTDATAFILE;  //class name method name

		f=new FileInputStream(filePath);

		wb=new XSSFWorkbook(f);

		sh=wb.getSheet(sheet);

		XSSFRow r=sh.getRow(a);

		XSSFCell c=r.getCell(b);

		int x=(int) c.getNumericCellValue(); // method used to get numeric value

		return String.valueOf(x); //convert any dayta type to string

	}
	
	public static String getTimeData(int rowIndex, int cellIndex, String sheetName) throws IOException {
        String filePath = Constant.TESTDATAFILE;

        try (FileInputStream f = new FileInputStream(filePath);
             XSSFWorkbook wb = new XSSFWorkbook(f)) {

            XSSFSheet sh = wb.getSheet(sheetName);
            XSSFRow row = sh.getRow(rowIndex);

            if (row == null) return "";
            XSSFCell cell = row.getCell(cellIndex);
            if (cell == null) return "";

            if (cell.getCellType() == CellType.NUMERIC && DateUtil.isCellDateFormatted(cell)) {
                Date date = cell.getDateCellValue();

                // ⏰ Change format as needed (HH:mm:ss → 24hr, hh:mm a → 12hr with AM/PM)
                SimpleDateFormat sdf = new SimpleDateFormat("hh:mm a");
                return sdf.format(date);
            } else {
                return cell.toString(); // fallback
            }
        }
    }


	}

	
