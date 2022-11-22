package vTiger.ContactsTests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.GenericLibrary.BaseClass;
import vTiger.GenericLibrary.ExcelFileLibrary;
import vTiger.GenericLibrary.JavaLibrary;
import vTiger.GenericLibrary.PropertyFileLibrary;
import vTiger.GenericLibrary.WebDriverLibrary;
import vTiger.ObjectRepository.ContactsInfoPage;
import vTiger.ObjectRepository.ContactsPage;
import vTiger.ObjectRepository.CreateNewContactPage;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.LoginPage;

@Listeners(vTiger.GenericLibrary.ListenerImplementationLibrary.class)
public class CreateContactTest extends BaseClass {
	
	@Test(groups = "smokeSuite")
	public void createContactTest() throws IOException
	 {

		//Step 2: read all the required data
		String LASTNAME = eLib.readDataFromExcel("Contacts", 1, 2)+jLib.getRandomNumber();
		
		//Step 5: Navigate to Contacts Link
		HomePage hp = new HomePage(driver);
		hp.clickContactsLnk();
		
		
		//Step 6: Navigate to create Contact Look up image
		ContactsPage cp = new ContactsPage(driver);
		cp.clickOnCreateContactImg();
		
		//Step 7: create contact with mandatory details and save
		CreateNewContactPage ccp = new CreateNewContactPage(driver);
		ccp.createNewContact(LASTNAME);
	
		
		//Step 8: Validate
		ContactsInfoPage cip = new ContactsInfoPage(driver);
		String contactHeader = cip.getContactHeader();
		System.out.println(contactHeader);
		Assert.assertTrue(contactHeader.contains(LASTNAME));
		

	}
	
//	@Test(groups = {"regressionSuite","smokeSuite"})
//	public void createContactDemotest()
//	{
//		System.out.println("demo test");
//		
//	}
//
//	
//	@Test
//	public void createContactWithLaedSource()
//	{
//		System.out.println("laed source");
//		
//	}
//	
//	@Test
//	public void createContactWithLeadSourceAndOrg()
//	{
//		System.out.println("lead Source with org");
//		
//	}
}
