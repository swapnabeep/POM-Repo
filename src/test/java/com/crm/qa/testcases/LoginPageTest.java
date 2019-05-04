package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	
	LoginPage loginPage;// 3. this object is created to call all the static and non static methods or variables of LoginPage class
	HomePage homePage;
	
	//1.constructor of Login Page Test
	public LoginPageTest() {
		super(); //keyword calls super class(Test Base) constructor to initialize the properties. it is compulsory to call super class constructor
		
	}
	
	@BeforeTest
	public void setUp() {
		//2. call initialization method from Test Base class
		initialization();
		//3. create login page class object
		loginPage= new LoginPage();
		
	}
	//Sequence of Execution
	//1. super keyword will call the super class constructor and all the properties will be initialized using Test Base constructor and properties methods
	//2. it moves to setUp method and call the initialization method and then it will launch the browser and execute the initialization method
	//3. creating login page class constructor
	
	@Test(priority=1)
	public void loginPageTitleTest() {
		String Actual=loginPage.validateLoginPageTitle();// we are calling the non-static method validateLoginPageTitle using the LoginPage class object
		System.out.println(Actual);
		System.out.println(Actual.length());
		String Expected="CRMPRO  - CRM software for customer relationship management, sales, and support.";
		System.out.println(Expected);
		System.out.println(Expected.length());
		Assert.assertEquals(Actual, Expected);
		
		
	}
	
	@Test(priority=2)
	public void crmLogoImageTest() {
		boolean flag= loginPage.validateCRMImage();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void loginTest() {
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
    
	}
}

