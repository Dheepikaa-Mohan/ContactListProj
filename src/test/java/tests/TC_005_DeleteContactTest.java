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
@BeforeTest
public void setup() {
	testName="Delete Contact Test";
	testDescription="Verifies contact can be deleted from contact list";
	testAuthor=" Dheepikaa M G ";

}
	@Test
		public void DeleteContactTest() throws InterruptedException {
		DeleteContact delete=new DeleteContact(driver);
		HomePage homepg=new HomePage(driver);
		homepg.enterEmail("agilan12@gmail.com")
		.enterPassword("agilan@123")
		.clickLogin();
	
		WebElement deletecont=driver.findElement(By.xpath("//td[text()='Agilan A']"));
		deletecont.click();
		delete.clickDelete();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		 Assert.assertTrue(alertText.toLowerCase().contains("delete this contact"), "Alert message does not confirm deletion");
		 System.out.println("the text is:"+alertText);
		 alert.accept();
		 
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//td[text()='Agilan A']")));
	    boolean isContactStillPresent =delete.isContactStillPresent(deletecont);
	    Assert.assertFalse(isContactStillPresent,"Deleted contact still appears after deletion");
	    System.out.println("Contact is deleted");
	     
		 driver.navigate().refresh();
		 boolean isContactDeleted= delete.isContactinvisible(By.xpath("//td[text()='Agilan A']"));
	     Assert.assertTrue(isContactDeleted, "Deleted contact still appears after page refresh");
	     System.out.println("Contact successfully deleted and not visible after refresh.");
		   
	}}