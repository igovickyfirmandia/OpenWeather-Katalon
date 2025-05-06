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

//send request to API GET Geocoding
def response = WS.sendRequest(findTestObject('Object Repository/GET Geocoding/GET Geocoding'))

//parsing response JSON
def json = new JsonSlurper().parseText(response.getResponseText())

//get lon, lat
def latitude = json[0].lat
def longitude = json[0].lon

//get ID Jakarta Selatan for assertion
def idJaksel = json[0].local_names.id

//set value to global variable
GlobalVariable.latitude = latitude
GlobalVariable.longitude = longitude

//assert
println("Latitude: " + latitude)
println("Longitude: " + longitude)
println("idJaksel: " + idJaksel)

//assert status code 200
WS.verifyResponseStatusCode(response, 200)
