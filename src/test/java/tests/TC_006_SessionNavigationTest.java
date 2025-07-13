package tests;


import org.testng.Assert;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethods;
import pages.ContactList;
import pages.HomePage;
import pages.LoginPage;

public class TC_006_SessionNavigationTest extends ProjectSpecificationMethods{
	
	
	@Test
 public void testLogoutRedirectsToLoginPage() {
		
		HomePage obj2=new HomePage(driver);
		obj2.enterEmail("Pranithad@gmail.com")
		.enterPassword("pranitha@123")
		.clickLogin();
		ContactList obj3=new ContactList(driver);
		obj3.logout();
		//HomePage homePage = new HomePage(driver);
		Assert.assertTrue(obj2.isLoginPageDisplayed(), "Login page should be visible");
	}
		
	@Test
	public void testLoginStateOnRefresh() throws InterruptedException {
		ContactList obj3=new ContactList(driver);
		HomePage obj2=new HomePage(driver);
		obj2.enterEmail("Pranithad@gmail.com")
		.enterPassword("pranitha@123")
		.clickLogin();
		Thread.sleep(5000);
		driver.navigate().refresh();
		//ContactList obj3=new ContactList(driver);
        Assert.assertTrue(obj3.isContactListDisplayed(), "User should stay logged in after refresh");
		System.out.println("Page is refreshed");
	}

@Test
public void LoginRequiredToAccessContactList() {
	HomePage obj2=new HomePage(driver);
    driver.get("https://thinking-tester-contact-list.herokuapp.com/contact-list");
    Assert.assertTrue(obj2.isLoginPageDisplayed(), "Should redirect to login page if not logged in");
}



@Test
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




