package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.ProjectSpecificationMethods;

public class SignUpPage extends ProjectSpecificationMethods {
public SignUpPage (WebDriver driver) {
	this.driver=driver;
}
	public SignUpPage enterFirstName(String firstname) {
		driver.findElement(By.id("firstName")).sendKeys(firstname);
		return this;
	}
	public SignUpPage enterLastName( String lastname) {
		driver.findElement(By.id("lastName")).sendKeys(lastname);
		return this;
	}
	public SignUpPage enterEmail(String email) {
		driver.findElement(By.id("email")).sendKeys(email);
		return this;
	}
	public SignUpPage enterPassword(String pass) {
		driver.findElement(By.id("password")).sendKeys(pass);
		return this;
	}
	public ContactList clickSubmit() {
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		return new ContactList(driver);
	}
}