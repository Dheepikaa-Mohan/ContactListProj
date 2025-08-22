package tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethods;
import pages.HomePage;



public class TC_001_SignUpTest extends ProjectSpecificationMethods {
	
	@BeforeTest
	public void setup() throws IOException {
		sheetname="SignUpSheet";
		testName="SignUp Test";
		testDescription="Testing the signIn functionality of the application with valid and invalid credentials";
		testAuthor=" Dheepikaa M G ";

	}
@Test(dataProvider = "readData")
	public void signuptest(String firstName,String lastName,String email,String password,String testType,String expectedMessage) {
new HomePage(driver)
.clickSignUp()
.enterFirstName(firstName)
.enterLastName(lastName)
.enterEmail(email)
.enterPassword(password)
.clickSubmit()
.validateSignIn(testType,expectedMessage);
	}
}