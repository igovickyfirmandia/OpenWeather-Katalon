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

//send request to API GET 5 Day Weather Forecast
def response = WS.sendRequest(findTestObject('Object Repository/GET 5 Day Weather Forecast/GET 5 Day Weather Forecast'))

//parsing response JSON
def slurper = new JsonSlurper()
def jsonResponse = slurper.parseText(response.getResponseBodyContent())

//assert status code 200
WS.verifyResponseStatusCode(response, 200)

//assert cod = 200
assert jsonResponse.cod == "200" : "Expected cod to be 200, but got " + jsonResponse.cod

//get list[0].main data
def listMainData = jsonResponse.list[0].main

// ✅ 2. Assert setiap field
assertThat(listMainData.temp).isNotNull()
assertThat(listMainData.feels_like).isNotNull()
assertThat(listMainData.temp_min).isNotNull()
assertThat(listMainData.temp_max).isNotNull()
assertThat(listMainData.pressure).isNotNull()
assertThat(listMainData.sea_level).isNotNull()
assertThat(listMainData.grnd_level).isNotNull()
assertThat(listMainData.humidity).isNotNull()
assertThat(listMainData.temp_kf).isNotNull()

// (Optional) Cetak nilainya ke console untuk debugging
println "Temp: ${mainData.temp}"
println "Feels Like: ${mainData.feels_like}"
println "Temp Min: ${mainData.temp_min}"
println "Temp Max: ${mainData.temp_max}"
println "Pressure: ${mainData.pressure}"
println "Sea Level: ${mainData.sea_level}"
println "Ground Level: ${mainData.grnd_level}"
println "Humidity: ${mainData.humidity}"
println "Temp KF: ${mainData.temp_kf}"