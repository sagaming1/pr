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

String pwerror = ''

String emerror = ''

if (WebUI.waitForElementNotPresent(findTestObject('1/Login_/span_Please enter a valid email address'), 3) == false) {
    emerror = 'Please enter a valid email address'
} else if (WebUI.waitForElementNotPresent(findTestObject('1/Login_/li_No customer account found'), 3) == false) {
    emerror = 'No customer account found'
} else if (WebUI.waitForElementNotPresent(findTestObject('1/Login_/li_The credentials provided are incorrect'), 3) == false) {
    pwerror = 'The credentials provided are incorrect'
}

//println(fnerror.length())
println(pwerror + emerror)

assert (pwerror.length() + emerror.length()) == 0

