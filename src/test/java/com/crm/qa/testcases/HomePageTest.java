package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	
	//1. create a HomePageTest class constructor
	public HomePageTest(){
		super();//calls the base class constructor to initialize the objects
	}

	@BeforeMethod
	public void setup() {
		initialization();// driver will be initialized launching the browser
		testUtil= new TestUtil();
		contactsPage= new ContactsPage();
		loginPage= new LoginPage();// using this object reference login method is called
		homePage= loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest() {
		String homePageTitle= homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "CRMPRO");
		
	}
	
	@Test(priority=2)
	public void verifyUserNameTest() {
		testUtil.switchToFrame();
		Assert.assertTrue(homePage.verifyCorrectUserName());
	}
	
	@Test(priority=3)
	public void verifyContactsLinkTest() {
		testUtil.switchToFrame();
		contactsPage=homePage.clickOnContactsLink();
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
