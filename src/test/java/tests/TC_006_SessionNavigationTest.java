package tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.ProjectSpecificationMethods;
import pages.ContactList;
import pages.HomePage;
import pages.LoginPage;

public class TC_006_SessionNavigationTest extends ProjectSpecificationMethods{
	
	
	@Test(priority=0)
 public void testLogoutRedirectsToLoginPage() throws InterruptedException {
		
		HomePage obj2=new HomePage(driver);
		obj2.enterEmail("Pranithad@gmail.com")
		.enterPassword("pranitha@123")
		.clickLogin();
		Thread.sleep(2000);
		ContactList obj3=new ContactList(driver);
		obj3.logout();
		Assert.assertTrue(obj2.isLoginPageDisplayed(), "Login page should be visible");
	}
		
	@Test(priority = 1)
	public void testLoginStateOnRefresh() throws InterruptedException {
		ContactList obj3=new ContactList(driver);
		HomePage obj2=new HomePage(driver);
		obj2.enterEmail("Pranithad@gmail.com")
		.enterPassword("pranitha@123")
		.clickLogin();
		Thread.sleep(5000);
		driver.navigate().refresh();
        Assert.assertTrue(obj3.isContactListDisplayed(), "User should stay logged in after refresh");
		System.out.println("Page is refreshed");
	}
	
@Test(priority = 2)
public void testBackNavigationAfterLogout() throws InterruptedException {
	ContactList obj3=new ContactList(driver);
	HomePage obj2=new HomePage(driver);
	obj2.enterEmail("Pranithad@gmail.com")
	.enterPassword("pranitha@123")
	.clickLogin();
   obj3.logout();
  Thread.sleep(2000);
    driver.navigate().back();
    driver.navigate().refresh();
    Assert.assertTrue(obj2.isLoginPageDisplayed(), "Back button should not return user to contact list");
}
}


































