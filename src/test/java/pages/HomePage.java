package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import base.ProjectSpecificationMethods;


public class HomePage extends ProjectSpecificationMethods{
	@FindBy(id = "email")
    WebElement emailfield;

    @FindBy(id = "password")
    WebElement passwordfield;

    @FindBy(xpath="//button[text()='Submit']")
    WebElement loginButton;
    
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		 PageFactory.initElements(driver, this);
	}
public SignUpPage clickSignUp() {
	
	driver.findElement(By.xpath("//button[text()='Sign up']")).click();
	return new SignUpPage(driver);
}
public HomePage enterEmail(String emailId) {
    emailfield.clear();
    emailfield.sendKeys(emailId);
    return this;
}

public HomePage enterPassword(String pass) {
    passwordfield.clear();
    passwordfield.sendKeys(pass);
    return this;
}

public ContactList clickLogin() {
    loginButton.click();
    return new ContactList(driver);
}
public boolean isLoginPageDisplayed() {
    try {
        return loginButton.isDisplayed();
    } catch (NoSuchElementException e) {
        return false;
    }
}
}

