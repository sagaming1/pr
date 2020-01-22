import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.lang.String
import com.kms.katalon.core.testdata.reader.ExcelFactory

String chars = "abcdefghijklmnopqrstuvwxyz0123456789"

def account = CustomKeywords.'random.randomString'(chars, 10)
def password = CustomKeywords.'random.randomString'(chars, 10)
println account

FileInputStream file = new FileInputStream (new File("D:\\Workspace\\2020\\0120\\demowebshop.xlsx"))
XSSFWorkbook workbook = new XSSFWorkbook(file);
XSSFSheet sheet = workbook.getSheetAt(0);
Object excelFile = ExcelFactory.getExcelDataWithDefaultSheet("D:\\Workspace\\2020\\0120\\demowebshop.xlsx","sheet1", true)
int row = excelFile.getRowNumbers() // 總共有幾行
//println(row)
//'Write data to excel'
sheet.createRow(row+1)

sheet.getRow(row+1).createCell(0).setCellValue(account);  //第一行 第一格
sheet.getRow(row+1).createCell(1).setCellValue(password); //第一行 第二格

file.close();
FileOutputStream outFile =new FileOutputStream(new File("D:\\Workspace\\2020\\0120\\demowebshop.xlsx"));
workbook.write(outFile);
outFile.close();