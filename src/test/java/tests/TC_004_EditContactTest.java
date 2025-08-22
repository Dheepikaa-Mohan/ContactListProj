package tests;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import base.ProjectSpecificationMethods;
import pages.AddContactPage;
import pages.EditContact;
import pages.HomePage;

public class TC_004_EditContactTest extends ProjectSpecificationMethods {
	@BeforeTest
	public void setup() {
		testName="Edit Contact Test";
		testDescription="Testing the Edit functionality of the application";
		testAuthor=" Dheepikaa M G ";
	}
	        @Test(priority = 0)
	        public void editContactTest() throws InterruptedException {
	        	HomePage homepg=new HomePage(driver);
	    		homepg.enterEmail("sankari28@gmail.com")
	    		.enterPassword("Dheeru@123")
	    		.clickLogin();
	    		driver.findElement(By.xpath("//td[text()='Kumares D']")).click();
	        	 EditContact editContact = new EditContact(driver);
	        	 
	        	 editContact.clickEdit();
	        	Thread.sleep(5000);
	        	 editContact.updatePhone("9962080562");
	        	 editContact.clickSubmit();
	        	 WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
	        	 WebElement updatedPhone = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id=\"phone\"]")));

	             
	        	Assert.assertEquals(updatedPhone.getText(), "9962080562", "Phonenum not updated correctly");
	        	System.out.println("The value is: " + driver.findElement(By.xpath("//span[@id='phone']")).getText());

	        	
	        }
	        
		@Test(priority = 1)
		public void verifyEditCancelRetainsOriginalDetails() throws InterruptedException {
		    HomePage homepg = new HomePage(driver);
		    homepg.enterEmail("sankari28@gmail.com")
		        .enterPassword("Dheeru@123")
		        .clickLogin();

		    EditContact editContact = new EditContact(driver);
		    String originalPhone =driver.findElement(By.xpath("//td[text()='9962080562']")).getText();
		    editContact.selectName();
		 
		    editContact.clickEdit();
		    Thread.sleep(2000);
		    editContact.updatePhone("1234554321");
		    editContact.clickCancel();
            Thread.sleep(5000);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement phoneAfterCancel = driver.findElement(By.xpath("//span[text()='9962080562']"));
            
		    Assert.assertEquals(phoneAfterCancel.getText(), originalPhone, "Phone number should remain unchanged after cancel");
		    System.out.println("Cancel edit worked as expected.");
		
		}

		@Test(priority = 2)
		public void verifyMissingLastNameTriggersValidationError() throws InterruptedException {
		    HomePage homepg = new HomePage(driver);
		    homepg.enterEmail("sankari28@gmail.com")
		        .enterPassword("Dheeru@123")
		        .clickLogin();

		    EditContact editContact = new EditContact(driver);
		    editContact.selectName();
		    editContact.clickEdit();
		    Thread.sleep(2000);
		    editContact.clearLastName();
		    editContact.updatePhone("5432165432");
		    editContact.clickSubmit();
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
 WebElement errorMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Validation failed')]")));

		    Assert.assertTrue(errorMsg.getText().contains("lastName"), "Expected validation error for missing last name");
		    System.out.println("Validation error shown as expected: " + errorMsg.getText());
		}

}