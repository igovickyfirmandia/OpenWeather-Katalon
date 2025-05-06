# OpenWeatherMap-Automated API Test with Katalon

## Project Description
This project performs Automated API Test using Katalon Studio for OpenWeatherMap, includes 5 Days Weather Forecast & Air Pollution in Jakarta Selatan

## Requirements
1. Katalon Studio
2. OpenWeatherMap API
   * API Geocoding - to get the longitutde, latitude, & location ID
     ```markdown
     http://api.openweathermap.org/geo/1.0/direct?q={city name},{state code},{country code}&limit={limit}&appid={API key}
   * API 5 Days Weather Forecast - to get the 5 days weather forecast
     ```markdown
     http://api.openweathermap.org/data/2.5/forecast?lat={lat}&lon={lon}&appid={API key}
   * API Air Pollution - to get air pollution data
     ```markdown
     http://api.openweathermap.org/data/2.5/air_pollution?lat={lat}&lon={lon}&appid={API key}

## Run the Test
1. Clone this repo & open the project in Katalon Studio
2. In Profiles -> default, change the value of `appid` using your own API Key generated from OpenWeatherMap
3. Run the tes using the Test Suite in Katalon Studio
4. The Test Suite already contain test cases GET Geocoding, GET 5 Day Weather Forecast, & GET Air Pollution

## The Report
If Test Suite run smoothly and no error occured, the test report should generated automatically. Check the test report:
 ```markdown
    Your OpenWeatherMap-Katalon folder -> Reports -> [Timestamp Folder] -> report.html
```

## The Project Structure
Project Structure:
```markdown
├── Object Repository
│   └── GET Geocoding, GET 5 Day Weather Forecast, GET Air Pollution
├── Test Cases
│   └── GET Geocoding
│   └── GET 5 Day Weather Forecast
│   └── GET Air Pollution
├── Test Suites
│   └── Open Weather Suite (runs all 3 tests in sequence)
├── Profiles
│   └── default (contains GlobalVariables: basic_URL, appid, q, limit, latitude, longitude)
├── Reports
│   └── [Generated after test run, saved in Report Folder]
```
