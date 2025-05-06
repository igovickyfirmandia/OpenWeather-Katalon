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

//send request to API GET 5 Day Weather Forecast
def response = WS.sendRequest(findTestObject('Object Repository/GET 5 Day Weather Forecast/GET 5 Day Weather Forecast'))

//parsing response JSON
def json = new JsonSlurper().parseText(response.getResponseText())

//assert status code 200
WS.verifyResponseStatusCode(response, 200)

//assert cod = 200
assert json.cod == "200" : "Expected cod to be 200, but got " + json.cod

//get list[0].main data
def listMainData = json.list[0].main

//assert temp is present
assert json.list[0].main.containsKey('temp')
//assert feels_like is present
assert json.list[0].main.containsKey('feels_like')
//assert temp_min is present
assert json.list[0].main.containsKey('temp_min')
//assert temp_max is present
assert json.list[0].main.containsKey('temp_max')
//assert pressure is present
assert json.list[0].main.containsKey('pressure')
//assert sea_level is present
assert json.list[0].main.containsKey('sea_level')
//assert grnd_level is present
assert json.list[0].main.containsKey('grnd_level')
//assert humidity is present
assert json.list[0].main.containsKey('humidity')
//assert temp_kf is present
assert json.list[0].main.containsKey('temp_kf')

//print value temp, feels_like, temp_min, temp_max, pressure, sea_level, grnd_level, humidity, temp_kf
println("temp: " + json.list[0].main.temp)
println("feels_like: " + json.list[0].main.feels_like)
println("temp_min: " + json.list[0].main.temp_min)
println("temp_max: " + json.list[0].main.temp_max)
println("pressure: " + json.list[0].main.pressure)
println("sea_level: " + json.list[0].main.sea_level)
println("grnd_level: " + json.list[0].main.grnd_level)
println("humidity: " + json.list[0].main.humidity)
println("temp_kf: " + json.list[0].main.temp_kf)