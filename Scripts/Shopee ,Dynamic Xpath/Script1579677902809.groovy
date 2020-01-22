import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import java.io.FileInputStream as FileInputStream
import java.io.FileNotFoundException as FileNotFoundException
import java.io.IOException as IOException
import java.util.Date as Date
import org.apache.poi.xssf.usermodel.XSSFCell as XSSFCell
import org.apache.poi.xssf.usermodel.XSSFRow as XSSFRow
import org.apache.poi.xssf.usermodel.XSSFSheet as XSSFSheet
import org.apache.poi.xssf.usermodel.XSSFWorkbook as XSSFWorkbook
import java.lang.String as String
import com.kms.katalon.core.testdata.reader.ExcelFactory as ExcelFactory
import com.kms.katalon.core.testobject.SelectorMethod

WebUI.openBrowser('https://shopee.tw/')

WebUI.setText(findTestObject('Object Repository/Shopee/input__shopee-searchbar-input__input'), 'Switch')

WebUI.click(findTestObject('Shopee/button__btn btn-solid-primary btn--s btn--inline'))

WebUI.click(findTestObject('Object Repository/Shopee/div_'))

WebUI.setText(findTestObject('Object Repository/Shopee/input__shopee-price-range-filter__input'), '5000')

WebUI.click(findTestObject('Object Repository/Shopee/button_'))

for (def Idx = 1; Idx < 6; Idx++) {
    FileInputStream file = new FileInputStream(new File('D:\\Workspace\\2020\\0120\\shopee.xlsx'))

    XSSFWorkbook workbook = new XSSFWorkbook(file)

    XSSFSheet sheet = workbook.getSheetAt(0)

    Object excelFile = ExcelFactory.getExcelDataWithDefaultSheet('D:\\Workspace\\2020\\0120\\shopee.xlsx', 'sheet1', true)

    int row = excelFile.getRowNumbers()// 總共有幾行
	TestObject to = findTestObject("Shopee/Name" + Idx)
	//* get Map with <SelectorMethod, String> pair*
	Map allSelectors = to.getSelectorCollection()
	//println allSelectors.get(SelectorMethod.XPATH)
	 
	//* update the value*
	to.setSelectorValue(SelectorMethod.XPATH, allSelectors.get(SelectorMethod.XPATH) + "//ancestor::a")
	//* println new value of XPATH selector*
	allSelectors = to.getSelectorCollection()
	println allSelectors.get(SelectorMethod.XPATH)
	
	String url = WebUI.getAttribute(to, 'href')
	
    String name = WebUI.getText(findTestObject('Shopee/Name' + Idx))

    String price = WebUI.getText(findTestObject('Shopee/price' + Idx))

    String sale = WebUI.getText(findTestObject('Shopee/sale' + Idx))

    sheet.createRow(row + 1)

    sheet.getRow(row + 1).createCell(0).setCellValue(name) //第一行 第一格

    sheet.getRow(row + 1).createCell(1).setCellValue(price) //第一行 第二格

    sheet.getRow(row + 1).createCell(2).setCellValue(sale)

	sheet.getRow(row + 1).createCell(3).setCellValue(url)
	
    file.close()

    FileOutputStream outFile = new FileOutputStream(new File('D:\\Workspace\\2020\\0120\\shopee.xlsx'))

    workbook.write(outFile)

    outFile.close()

    println(name)
}
//*************************************************************************
//TestObject to = findTestObject("Shopee/Name1")
//* get Map with <SelectorMethod, String> pair*
//Map allSelectors = to.getSelectorCollection()
//println allSelectors.get(SelectorMethod.XPATH)

//* update the value*
//to.setSelectorValue(SelectorMethod.XPATH, allSelectors.get(SelectorMethod.XPATH) + "//ancestor::a")
//* println new value of XPATH selector*
//allSelectors = to.getSelectorCollection()
//println allSelectors.get(SelectorMethod.XPATH)
//String url = WebUI.getAttribute(to, 'href')
//println(url)
//*************************************************************************
//String url = WebUI.getAttribute(findTestObject('Shopee/1'), 'href')
//println(to)