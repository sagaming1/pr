import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.By as By
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
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

WebUI.openBrowser('')

WebUI.navigateToUrl('http://demowebshop.tricentis.com/')

WebUI.maximizeWindow()

WebUI.click(findTestObject('1/a_Log in'))

WebUI.setText(findTestObject('1/input_Email_Email'), '87sxy5u9u2@gmail.com')

WebUI.setText(findTestObject('1/input_Password_Password'), '6j0jfi8hw9')

WebUI.click(findTestObject('1/login'))

WebUI.setText(findTestObject('2/search'), 'diamond')

WebUI.click(findTestObject('2/btn search'))

WebUI.delay(2)

WebUI.click(findTestObject('2/a_Black  White Diamond Heart'))

WebUI.setText(findTestObject('2/input_Qty_addtocart_14EnteredQuantity'), '2')

WebUI.click(findTestObject('2/input_Qty_add-to-cart-button-14'))

WebUI.click(findTestObject('Object Repository/1/span_Shopping cart'))

WebUI.selectOptionByValue(findTestObject('Object Repository/1/select_Select countryUnited StatesCanadaAfg_dd1e54'), '1', 
    true)

WebUI.click(findTestObject('Object Repository/1/input_I agree with the terms of service and_f529a0'))

WebUI.click(findTestObject('Object Repository/1/button_Checkout'))

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

WebUI.delay(2)

not_run: WebUI.deleteAllCookies()

not_run: WebUI.refresh()

