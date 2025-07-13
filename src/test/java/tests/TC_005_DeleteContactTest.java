package tests;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethods;
import pages.AddContactPage;
import pages.ContactList;
import pages.DeleteContact;
import pages.HomePage;

public class TC_005_DeleteContactTest extends ProjectSpecificationMethods {
	@Test
		public void DeleteContactTest() throws InterruptedException {
		DeleteContact obj5=new DeleteContact(driver);
		HomePage obj2=new HomePage(driver);
		obj2.enterEmail("guviuser282@gmail.com")
		.enterPassword("Sai@12345.")
		.clickLogin();
	
		WebElement deletecont=driver.findElement(By.xpath("//td[text()='kumares D']"));
		deletecont.click();
		obj5.clickDelete();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		 Assert.assertTrue(alertText.toLowerCase().contains("delete this contact"), "Alert message does not confirm deletion");
		 System.out.println("the text is:"+alertText);
		 alert.accept();
		 
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//td[text()='kumares D']")));
	    boolean isContactStillPresent =obj5.isContactStillPresent(deletecont);
	    Assert.assertFalse(isContactStillPresent,"Deleted contact still appears after deletion");
	    System.out.println("Contact is deleted");
	    
		    driver.navigate().refresh();
		    boolean isContactDeleted= obj5.isContactinvisible(By.xpath("//td[text()='kumares D']"));
	        Assert.assertTrue(isContactDeleted, "Deleted contact still appears after page refresh");
	        System.out.println("Contact successfully deleted and not visible after refresh.");
		   
	}}