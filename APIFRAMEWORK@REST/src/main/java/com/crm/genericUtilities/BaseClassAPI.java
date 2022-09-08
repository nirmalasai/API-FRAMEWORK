package com.crm.genericUtilities;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseClassAPI {
	public DataBaseUtility dLib=new DataBaseUtility();
	public RestAssuredLibrary rLib=new RestAssuredLibrary();

	/**
	 * connecting to database
	 */
	@BeforeSuite
	public void dbConfig()
	{
		dLib.connectToDB("projects");   
//		baseURI="http://localhost";
//		port=8084;
	}
	
	/**
	 * close database configuration
	 */
	@AfterSuite
	public void closeDBconfig()
	{
		dLib.closeDB();
	}

}
