package tests;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import base.ProjectSpecificationMethods;
import pages.ContactList;
import pages.HomePage;
import pages.LoginPage;

public class TC_006_SessionNavigationTest extends ProjectSpecificationMethods{
	@BeforeTest
	public void setup() {
		testName="Session Navigation Test";
		testDescription="This test  verifies user session behavior during navigation between pages. ";
		testAuthor=" Dheepikaa M G ";
	}
	
	@Test(priority=0)
 public void testLogoutRedirectsToLoginPage() throws InterruptedException {
		
		HomePage homepg=new HomePage(driver);
		homepg.enterEmail("Pranithad@gmail.com")
		.enterPassword("pranitha@123")
		.clickLogin();
		Thread.sleep(2000);
		ContactList clist=new ContactList(driver);
		clist.logout();
		Assert.assertTrue(homepg.isLoginPageDisplayed(), "Login page should be visible");
	}
		
	@Test(priority = 1)
	public void testLoginStateOnRefresh() throws InterruptedException {
		ContactList clist=new ContactList(driver);
		HomePage homepg=new HomePage(driver);
		homepg.enterEmail("Pranithad@gmail.com")
		.enterPassword("pranitha@123")
		.clickLogin();
		Thread.sleep(5000);
		driver.navigate().refresh();
        Assert.assertTrue(clist.isContactListDisplayed(), "User should stay logged in after refresh");
		System.out.println("Page is refreshed");
	}
	
@Test(priority = 2)
public void testBackNavigationAfterLogout() throws InterruptedException {
	ContactList clist=new ContactList(driver);
	HomePage homepg=new HomePage(driver);
	homepg.enterEmail("Pranithad@gmail.com")
	.enterPassword("pranitha@123")
	.clickLogin();
	clist.logout();
  Thread.sleep(2000);
    driver.navigate().back();
    driver.navigate().refresh();
    Assert.assertTrue(homepg.isLoginPageDisplayed(), "Back button should not return user to contact list");
}
}


































