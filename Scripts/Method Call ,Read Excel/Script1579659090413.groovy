import org.openqa.selenium.remote.server.DriverFactory as DriverFactory
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
import com.kms.katalon.core.testdata.reader.ExcelFactory as ExcelFactory

Object excelFile = ExcelFactory.getExcelDataWithDefaultSheet('D:\\Workspace\\2020\\0120\\user.xlsx', 'sheet1', true)

println(excelFile.getRowNumbers())

for (def rowIdx = 0; rowIdx < excelFile.getRowNumbers(); rowIdx++) {
    WebUI.openBrowser('https://katalon-demo-cura.herokuapp.com/')

    WebUI.click(findTestObject('Object Repository/a_Make Appointment'))

    // 需要注意的是，这里的column和row的值，都是从1开始
    def userName = excelFile.internallyGetValue(0, rowIdx)

    def password = excelFile.internallyGetValue(1, rowIdx)

    login(userName, password)

    WebUI.click(findTestObject('Object Repository/button_Login'))

    def ans = WebUI.verifyElementPresent(findTestObject('button_Book Appointment'), 5, FailureHandling.OPTIONAL) 
	 
	WebUI.takeScreenshot()
	
	//println(rowIdx+1 + "." + ans)
    //KeywordLogger log = new KeywordLogger()
    //log.logInfo("yourMsg")
    //WebUI.closeBrowser()
}



def login(def userName, def password) {
    WebUI.setText(findTestObject('Object Repository/input_Username_username'), userName)

    WebUI.setText(findTestObject('Object Repository/input_Password_password'), password)
}

