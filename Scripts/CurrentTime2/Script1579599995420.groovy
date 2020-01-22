import java.text.SimpleDateFormat
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.kms.katalon.core.testdata.reader.ExcelFactory

//Google search for SimpleDateFormat for other formats that can be used

String CDATE = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());

String CTIME = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());

println('CurrentDate:'  + CDATE)

println('CurrentTime:' + CTIME)

FileInputStream file = new FileInputStream (new File("D:\\Workspace\\2020\\0120\\demowebshop.xlsx"))
XSSFWorkbook workbook = new XSSFWorkbook(file);
XSSFSheet sheet = workbook.getSheetAt(0);
Object excelFile = ExcelFactory.getExcelDataWithDefaultSheet("D:\\Workspace\\2020\\0120\\demowebshop.xlsx","sheet1", true)
int row = excelFile.getRowNumbers() // 總共有幾行
//println(row)
//'Write data to excel'
sheet.createRow(row+1)

sheet.getRow(row+1).createCell(2).setCellValue(CDATE + " " + CTIME);  //第一行 第一格


file.close();
FileOutputStream outFile =new FileOutputStream(new File("D:\\Workspace\\2020\\0120\\demowebshop.xlsx"));
workbook.write(outFile);
outFile.close();