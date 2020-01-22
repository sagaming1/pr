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


for (def rowIdx = 0; rowIdx < findTestData('user').getAllData().size(); rowIdx++) {
    WebUI.openBrowser('https://katalon-demo-cura.herokuapp.com/')

    WebUI.click(findTestObject('Object Repository/a_Make Appointment'))

    // 需要注意的是，这里的column和row的值，都是从1开始
    def userName = findTestData('user').getValue(1, rowIdx + 1)

    def password = findTestData('user').getValue(2, rowIdx + 1)

    login(userName, password)

    WebUI.click(findTestObject('Object Repository/button_Login')) 
	
	def ans = WebUI.verifyElementPresent(findTestObject('button_Book Appointment'), 5, FailureHandling.OPTIONAL)
	
	println(rowIdx+1 + "." + ans)
	
	//KeywordLogger log = new KeywordLogger()
	
	//log.logInfo("yourMsg")
	
	//WebUI.closeBrowser()
}



def login(def userName, def password) {
    WebUI.setText(findTestObject('Object Repository/input_Username_username'), userName)

    WebUI.setText(findTestObject('Object Repository/input_Password_password'), password)
}

