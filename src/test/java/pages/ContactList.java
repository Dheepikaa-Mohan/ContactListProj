package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.ProjectSpecificationMethods;

public class ContactList extends ProjectSpecificationMethods {
	@FindBy(xpath="//button[@id=\"logout\"]")
	WebElement logoutButton;
	@FindBy(id="add-contact")
WebElement NewContact;	
	@FindBy(xpath="//span[text()='Incorrect username or password']")
	WebElement noUser;
public ContactList(WebDriver driver) {
	this.driver=driver;
	 PageFactory.initElements(driver, this);
}
public void validateSignIn(String testType,String expectedMessage) {
	if(testType.equals("ValidInput")) {
	String actualText=driver.findElement(By.xpath("//button[text()='Add a New Contact']")).getText();
	Assert.assertEquals(actualText, expectedMessage);
	}
	if(testType.equals("ExistingEmail")) {
		String actualText=driver.findElement(By.xpath("//span[text()='Email address is already in use']")).getText();
		Assert.assertEquals(actualText, expectedMessage);
		}
	if(testType.equals("InvalidInput")) {
		String actualText=driver.findElement(By.xpath("//span[text()='User validation failed: email: Email is invalid, password: Path `password` is required.']")).getText();
		Assert.assertEquals(actualText, expectedMessage);
	}
	if(testType.equals("InvalidEmail")) {
		String actualText=driver.findElement(By.xpath("//span[text()='User validation failed: email: Email is invalid']")).getText();
		Assert.assertEquals(actualText, expectedMessage);
	}
}
public void validateLogIn(String testType, String expectedMessage) {
	if(testType.equals("ValidEmailValidPassword")) {
	String actualText=driver.findElement(By.xpath("//p[text()='Click on any contact to view the Contact Details']")).getText();
	Assert.assertEquals(actualText, expectedMessage);
System.out.println("Login successful");
	}
	if(testType.equals("ValidEmailInvalidPassword") || testType.equals("InvalidEmailInvalidPassword") || testType.equals("InvalidEmailValidPassword"))
{
	String actualText1=noUser.getText();
	Assert.assertEquals(actualText1, expectedMessage);
}
	 if(testType.equals("PasswordFieldMask")) {
		WebElement passwordField = driver.findElement(By.id("password"));
String fieldType = passwordField.getAttribute("type");
Assert.assertEquals(fieldType, "password", "Password field is not masked!");
	}
}
public void logout() {
	logoutButton.click();
}
public AddContactPage clickContact() {
	NewContact.click();
	return new AddContactPage(driver);
}
public boolean isContactListDisplayed() {
	    try {
	        WebElement heading = driver.findElement(By.xpath("//h1[text()='Contact List']"));
	        return heading.isDisplayed();
	    } catch (NoSuchElementException e) {
	        return false;
	    }
	}
}










