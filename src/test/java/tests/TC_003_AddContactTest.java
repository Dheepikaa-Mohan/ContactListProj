package tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethods;
import pages.AddContactPage;
import pages.ContactList;
import pages.HomePage;

public class TC_003_AddContactTest extends ProjectSpecificationMethods {
	
	
@BeforeTest
	public void setup() throws IOException {
		sheetname="AddContact";
		testName="Add Contact Test";
		testDescription="Testing the application using adding contacts with different values";
		testAuthor=" Dheepikaa M G ";
}
	@Test(dataProvider = "readData")
	public static void addContactTest(String firstName,String lastName,String dob,String email,String phone,String address1,String address2,String city,String state,String postalCode,String country,String testType,String expectedMessage) {
		new HomePage(driver)
		.enterEmail("guviuser282@gmail.com")
		.enterPassword("Sai@12345.")
		.clickLogin();
	
		ContactList clist=new ContactList(driver);
		clist.clickContact();
		AddContactPage addcpage=new AddContactPage(driver);
	
		addcpage.enterFirstName(firstName)
		.enterLastName(lastName)
		.enterDOB(dob)
		.enterEmail(email)
		.enterPhone(phone)
		.enterAddress(address1,address2,city,state,postalCode,country)
	.clickSubmit();
		 TC_003_AddContactTest testObj = new TC_003_AddContactTest();
		    testObj.ValidateAddContact(testType, expectedMessage);
		   
	}
	public void ValidateAddContact(String testType,String expectedMessage) {
		if(testType.equals("ContactIsAdded")) {
			String actualText=driver.findElement(By.xpath("//td[text()='Sai Madhi']")).getText();
			Assert.assertEquals(actualText, expectedMessage);
			System.out.println("Value is:" +actualText);}
			if(testType.equals("EmptyField")) {
			String actualText=driver.findElement(By.xpath("//span[text()='Contact validation failed: firstName: Path `firstName` is required., lastName: Path `lastName` is required.']")).getText();
			Assert.assertEquals(actualText, expectedMessage);
			System.out.println("Result is:"+actualText);
			}
			if(testType.equals("InvalidPhoneNumber")) {
				String actualText=driver.findElement(By.xpath("//span[text()='Contact validation failed: phone: Phone number is invalid']")).getText();
				Assert.assertEquals(actualText, expectedMessage);
				System.out.println("Result:" +actualText);}
			
	if(testType.equals("duplicateContact")) {
		 List<WebElement> contactElements = driver.findElements(
		            By.xpath("//td[text()='sai123@gmail.com']")) ;
		  
		        int actualCount = contactElements.size();
		        int expectedCount = 2;
		        Assert.assertEquals(actualCount, expectedCount,
		                "Expected 2 contacts with the same email, but found " + actualCount);
		        System.out.println("value is:"+actualCount);
		    }
	}
}
	