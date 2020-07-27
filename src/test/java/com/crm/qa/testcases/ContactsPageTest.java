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

public class ContactsPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	
	
	public ContactsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		contactsPage = new ContactsPage();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToFrame();
		contactsPage = homePage.clickOnContactsLink();
		
	}
	
	@Test(priority = 1)
	public void verifyContactsPageLabel() {
		Assert.assertTrue(contactsPage.verifyContactsLabel(), "contact label is missing on the page");
	}
	
	@Test(priority = 2)
	public void selectSingleContactsTest() {
		contactsPage.selectContactsByName("8888888888 ");
	}
	
	@Test(priority = 3)
	public void selectMultipleContactsTest() {

		contactsPage.selectContactsByName("888888 ");
		contactsPage.selectContactsByName("8888888888 ");
	}
	
//	@DataProvider
//	public Object[][] getCRMTestData() {
//		Object data [][] = TestUtil.getTestData(sheetName);
//		return data;
//	}
	
	
	
	@Test(priority = 4)
	public void validateCreateNEwContactTest() {
		homePage.clickOnNewContactLink();
		contactsPage.createNewContact("Mr.", "Test012", "Test021", "Testing");
		//contactsPage.createNewContact(title, firstname, lastname, company);
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
