package tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethods;
import pages.AddContactPage;
import pages.HomePage;
import pages.LoginPage;

public class TC_002_HomePage extends ProjectSpecificationMethods {
	
	@FindBy(xpath="//span[text()='Incorrect username or password']")
	WebElement noUser;
@BeforeTest
	public void setup() throws IOException {
		sheetname="LogInSheet";
	}
	@Test(dataProvider = "readData")
	public static void homepagedata(String Email,String Password,String testType, String expectedMessage) {
		//ProjectSpecificationMethods obj=new ProjectSpecificationMethods();
		//obj.browserLaunchAndUrlLoad("chrome","https://thinking-tester-contact-list.herokuapp.com/");
		new HomePage(driver)
		.enterEmail(Email)
.enterPassword(Password)
.clickLogin()
.validateLogIn(testType,expectedMessage);
//driver.close();
	}
}