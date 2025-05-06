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
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import groovy.json.JsonSlurper

//send request to API GET Air Pollution
def response = WS.sendRequest(findTestObject('Object Repository/GET Air Pollution/GET Air Pollution'))

//parsing response JSON
def json = new JsonSlurper().parseText(response.getResponseText())

//assert status code 200
WS.verifyResponseStatusCode(response, 200)

//assert lon & lat is present
assert json.coord.containsKey('lon')
assert json.coord.containsKey('lat')

//get list[0].components
def listComponents = json.list[0].components

//assert list[0].components contains co/no/no2/o3/so2/pm2_5/pm10/nh3
assert listComponents.containsKey('co')
assert listComponents.containsKey('no')
assert listComponents.containsKey('no2')
assert listComponents.containsKey('o3')
assert listComponents.containsKey('so2')
assert listComponents.containsKey('pm2_5')
assert listComponents.containsKey('pm10')
assert listComponents.containsKey('nh3')

//print the value
println("co: " + listComponents.co)
println("no: " + listComponents.no)
println("no2: " + listComponents.no2)
println("o3: " + listComponents.o3)
println("so2: " + listComponents.so2)
println("pm2_5: " + listComponents.pm2_5)
println("pm10: " + listComponents.pm10)
println("nh3: " + listComponents.nh3)

