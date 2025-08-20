package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethods;
import pages.AddContactPage;
import pages.ContactList;
import pages.HomePage;

public class TC_008_UiTest extends ProjectSpecificationMethods {
@Test
public void UiTest() throws InterruptedException {
	HomePage obj2=new HomePage(driver);
	ContactList contactpg=new ContactList(driver);
	AddContactPage addcontpge=new AddContactPage(driver);
	obj2.enterEmail("Pranithad@gmail.com")
	.enterPassword("pranitha@123")
	.clickLogin();
	Thread.sleep(2000);
	contactpg.clickContact();
	int yFirstName = addcontpge.textFirstName.getLocation().getY();
    int yLastName = addcontpge.textLastName.getLocation().getY();

    Assert.assertEquals(yFirstName, yLastName, "First and Last Name fields should be aligned horizontally");
    System.out.println("UI alignment test passed.");
    int xStreet1 = addcontpge.textStreet1.getLocation().getX();
    int xStreet2 = addcontpge.textStreet2.getLocation().getX();
    Assert.assertEquals(xStreet1, xStreet2, "Street1 and Street2 fields should be vertically aligned");
}
}
