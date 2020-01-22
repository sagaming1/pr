import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.By as By
import org.openqa.selenium.Keys as Keys

import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.remote.server.DriverFactory
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.chrome.ChromeDriver as ChromeDriver
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
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

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
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
import groovy.time.TimeCategory
import java.text.SimpleDateFormat
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.kms.katalon.core.testdata.reader.ExcelFactory


String CDATE = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());

String CTIME = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());

String chars = 'abcdefghijklmnopqrstuvwxyz0123456789'

def Date = new Date()
def account = CustomKeywords.'random.randomString'(chars, 10)

def password = CustomKeywords.'random.randomString'(chars, 10)

WebUI.openBrowser('')

WebUI.navigateToUrl('http://demowebshop.tricentis.com/')

WebUI.maximizeWindow()

WebUI.click(findTestObject('Object Repository/1/a_Register'))

WebUI.click(findTestObject('Object Repository/1/input_Gender_Gender'))

WebUI.setText(findTestObject('Object Repository/1/input_First name_FirstName'), 'AA')

WebUI.setText(findTestObject('Object Repository/1/input_Last name_LastName'), 'BB')

WebUI.setText(findTestObject('Object Repository/1/input_Email_Email'), account + '@gmail.com')

WebUI.setText(findTestObject('Object Repository/1/input_Password_Password'), password)

WebUI.setText(findTestObject('Object Repository/1/input_Confirm password_ConfirmPassword'), password)

WebUI.click(findTestObject('Object Repository/1/input__register-button'))

WebUI.click(findTestObject('Object Repository/1/input_Your registration completed_button-1 _c43114'))

WebUI.click(findTestObject('Object Repository/1/input_Unique Asian-influenced imprint wraps_3d4071'))

DriverFactory.getWebDriver().findElement(By.xpath('//body')).sendKeys(Keys.HOME)

WebUI.click(findTestObject('Object Repository/1/span_Shopping cart'))

WebUI.selectOptionByValue(findTestObject('Object Repository/1/select_Select countryUnited StatesCanadaAfg_dd1e54'), '1', 
    true)

WebUI.click(findTestObject('Object Repository/1/input_I agree with the terms of service and_f529a0'))

WebUI.click(findTestObject('Object Repository/1/button_Checkout'))

WebUI.selectOptionByValue(findTestObject('Object Repository/1/select_Select countryUnited StatesCanadaAfg_dd1e54 (1)'), 
    '1', true)

WebUI.setText(findTestObject('Object Repository/1/input_City_BillingNewAddressCity'), 'qq')

WebUI.setText(findTestObject('Object Repository/1/input_Address 1_BillingNewAddressAddress1'), 'ww')

WebUI.setText(findTestObject('Object Repository/1/input_Zip  postal code_BillingNewAddressZip_81c3c6'), 'ee')

WebUI.setText(findTestObject('Object Repository/1/input_Phone number_BillingNewAddressPhoneNumber'), 'rr')

WebUI.click(findTestObject('Object Repository/1/input_Fax number_button-1 new-address-next-_2f210c'))

WebUI.delay(2)

WebUI.click(findTestObject('1/2continue'))

WebUI.delay(2)

WebUI.click(findTestObject('1/3continue'))

WebUI.delay(2)

WebUI.click(findTestObject('1/4continue'))

WebUI.delay(2)

WebUI.click(findTestObject('1/5continue'))

WebUI.delay(2)

WebUI.click(findTestObject('1/confirm'))

FileInputStream file = new FileInputStream (new File("D:\\Workspace\\2020\\0120\\demowebshop.xlsx"))
XSSFWorkbook workbook = new XSSFWorkbook(file);
XSSFSheet sheet = workbook.getSheetAt(0);
Object excelFile = ExcelFactory.getExcelDataWithDefaultSheet("D:\\Workspace\\2020\\0120\\demowebshop.xlsx","sheet1", true)
int row = excelFile.getRowNumbers() // 總共有幾行
//println(row)
//'Write data to excel'
sheet.createRow(row+1)

sheet.getRow(row+1).createCell(0).setCellValue(account + "@gmail.com");  //第row+1行 第一格
sheet.getRow(row+1).createCell(1).setCellValue(password); //第row+1行 第二格
sheet.getRow(row+1).createCell(2).setCellValue(CDATE + " " + CTIME);

file.close();
FileOutputStream outFile =new FileOutputStream(new File("D:\\Workspace\\2020\\0120\\demowebshop.xlsx"));
workbook.write(outFile);
outFile.close();

