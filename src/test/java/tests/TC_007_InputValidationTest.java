package tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethods;
import pages.AddContactPage;
import pages.ContactList;
import pages.HomePage;
public class TC_007_InputValidationTest extends ProjectSpecificationMethods{
	@BeforeTest
	public void setup() throws IOException {
		sheetname="InputVal";
}
	
	@Test(dataProvider = "readData")
	public static void inputValidationtest(String firstName,String lastName,String dob,String email,String phone,String address1,String address2,String city,String state,String postalCode,String country,String testType,String expectedMessage) {
		HomePage obj2=new HomePage(driver);
		obj2.enterEmail("gowri@gmail.com")
		.enterPassword("gowri@12345")
		.clickLogin();
	
		ContactList obj3=new ContactList(driver);
		obj3.clickContact();
		AddContactPage obj4=new AddContactPage(driver);
	
		obj4.enterFirstName(firstName)
		.enterLastName(lastName)
		.enterDOB(dob)
		.enterEmail(email)
		.enterPhone(phone)
		.enterAddress(address1,address2,city,state,postalCode,country)
	.clickSubmit();
		 TC_007_InputValidationTest testObj1 = new TC_007_InputValidationTest();
		    testObj1.InputValidation(testType, expectedMessage);
	}
	
	public void InputValidation(String testType,String expectedMessage) {
		if(testType.equals("MaxCharacterLimit")) {
			String actualText=driver.findElement(By.xpath("//span[contains(text(), 'Contact validation failed: firstName') and contains(text(), 'maximum allowed length')]")).getText();
			Assert.assertEquals(actualText, expectedMessage);
			System.out.println("Value is:" +actualText);
			}
			if(testType.equals("VerifyEmojiInAddress")) {
			String actualText=driver.findElement(By.xpath("//td[text()='Saral Tamilselvan']")).getText();
			Assert.assertEquals(actualText, expectedMessage);
			System.out.println("Result is:"+actualText);
			}
	}}

