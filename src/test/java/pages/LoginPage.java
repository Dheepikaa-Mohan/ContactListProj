package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecificationMethods;

public class LoginPage extends ProjectSpecificationMethods {
	@FindBy(id = "email")
    WebElement emailfield;

    @FindBy(id = "password")
    WebElement passwordfield;

    @FindBy(xpath="//button[text()='Submit']")
    WebElement loginButton;
    
   public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
   public LoginPage enterEmail(String emailId) {
       emailfield.clear();
       emailfield.sendKeys(emailId);
       return this;
       
   }

   public LoginPage enterPassword(String pass) {
       passwordfield.clear();
       passwordfield.sendKeys(pass);
       return this;
   }

   public void clickLogin() {
       loginButton.click();
      // return new ContactList(driver);
   }
   public boolean isLoginPageDisplayed() {
       return loginButton.isDisplayed();
   }
}


