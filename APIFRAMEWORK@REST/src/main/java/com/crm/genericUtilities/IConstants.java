package com.crm.genericUtilities;

import static io.restassured.RestAssured.baseURI;

public interface IConstants 
{
	String filePath="./src/test/resources/commondata.properties";
	String excelPath="./src/test/resources/Sdet37TestData.xlsx";
	String chromePath=".\\src\\main\\resources\\chromedriver.exe";
	String chromeKey="webdriver.chrome.driver";
	String DbUrl="jdbc:mysql://localhost:3306/";
	String DBUsername="root";
	String DBPassword="root";
	int implicitlyWaitDuration=10;
	int explicitWaitDuration=20;
	int scriptTimeOutDuration=10;
	String appUserName="rmgyantra";
	String appPassword="rmgy@9999";
	String RmgUri="http://localhost:8084/";
	
}
