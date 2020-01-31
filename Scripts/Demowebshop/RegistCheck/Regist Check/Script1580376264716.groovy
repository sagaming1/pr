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

String fnerror = ''

String lnerror = ''

String pwerror = ''

String pw2error = ''

String emerror = ''

if (WebUI.waitForElementNotPresent(findTestObject('1/register/span_First name is required'), 3) == false) {
    fnerror = 'First name is required'
} else if (WebUI.waitForElementNotPresent(findTestObject('1/register/span_Last name is required'), 3) == false) {
    lnerror = 'Last name is required'
} else if (WebUI.waitForElementNotPresent(findTestObject('1/register/span_Password is required1'), 3) == false) {
    pwerror2 = 'Password is required'
} else if (WebUI.waitForElementNotPresent(findTestObject('1/register/span_The password and confirmation password do not match'), 
    3) == false) {
    pw2error = 'The password and confirmation password do not match'
} else if (WebUI.waitForElementNotPresent(findTestObject('1/register/span_The password should have at least 6 characters1'), 
    3) == false) {
    pwerror = 'The password should have at least 6 characters'
} else if (WebUI.waitForElementNotPresent(findTestObject('1/register/span_Wrong email'), 3) == false) {
    emerror = 'Wrong email'
} else if (WebUI.waitForElementNotPresent(findTestObject('1/register/span_Email is required'), 3) == false) {
    emerror = 'Email is required'
} else if (WebUI.waitForElementNotPresent(findTestObject('1/register/The specified email already exists'), 3) == false) {
    emerror = 'The specified email already exists'
}

//println(fnerror.length())
//println((((fnerror + lnerror) + pwerror) + pw2error) + emerror)

assert ((((fnerror.length() + lnerror.length()) + pwerror.length()) + pw2error.length()) + emerror.length()) == 0

