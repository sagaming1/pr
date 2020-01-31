import org.openqa.selenium.By as By
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import org.openqa.selenium.remote.server.DriverFactory as DriverFactory
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.chrome.ChromeDriver as ChromeDriver
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import internal.GlobalVariable as GlobalVariable
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
import groovy.time.TimeCategory as TimeCategory
import java.text.SimpleDateFormat as SimpleDateFormat

Object excelFile = ExcelFactory.getExcelDataWithDefaultSheet('D:\\Workspace\\2020\\0120\\demo.xlsx', 'sheet1', true)

for (def rowIdx = 0; rowIdx < excelFile.getRowNumbers(); rowIdx++) {
	
	def account = excelFile.internallyGetValue(0, rowIdx)

	def password = excelFile.internallyGetValue(1, rowIdx)
	
	WebUI.openBrowser('')

	WebUI.navigateToUrl('http://demowebshop.tricentis.com/')

	WebUI.maximizeWindow()

	WebUI.click(findTestObject('Object Repository/1/a_Register'))

	WebUI.click(findTestObject('Object Repository/1/input_Gender_Gender'))

	WebUI.setText(findTestObject('Object Repository/1/input_First name_FirstName'), '')

	WebUI.setText(findTestObject('Object Repository/1/input_Last name_LastName'), 'bb')

	WebUI.setText(findTestObject('Object Repository/1/input_Email_Email'), account)

	WebUI.setText(findTestObject('Object Repository/1/input_Password_Password'), password)

	WebUI.setText(findTestObject('Object Repository/1/input_Confirm password_ConfirmPassword'), password)

	WebUI.click(findTestObject('Object Repository/1/input__register-button'))

	WebUI.callTestCase(findTestCase('Demowebshop/RegistCheck/First name is required'), [:], FailureHandling.OPTIONAL)

	
}


