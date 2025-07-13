package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.ProjectSpecificationMethods;

public class DeleteContact extends ProjectSpecificationMethods {
@FindBy(xpath="//button[text()='Delete Contact']")
WebElement btnDelete;
public DeleteContact (WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
}


public ContactList clickDelete() {
	btnDelete.click();
	return new ContactList(driver);
}
	public boolean isContactStillPresent(WebElement element) {
	    try {
	        return element.isDisplayed();
	    } catch (NoSuchElementException | StaleElementReferenceException e) {
	        return false;
	    }
	}


	public boolean isContactinvisible(By xpath) {
		    try {
		        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		        return wait.until(ExpectedConditions.invisibilityOfElementLocated(xpath));
		    } catch (TimeoutException e) {
		        return false;
		    }
	}}
