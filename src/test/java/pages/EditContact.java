package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecificationMethods;

public class EditContact extends ProjectSpecificationMethods{
//sankari28,Dheeru@123;
	@FindBy(xpath = "//span[@id='phone']")
	private WebElement updatedPhone;

	 @FindBy(css = ".contact-item")
	    public List<WebElement> contactRows;
      @FindBy(xpath="//td[text()='Kumares D']")
       WebElement Name;
      @FindBy(id="edit-contact")
      WebElement editContactButton;
	   @FindBy(xpath="//input[@id=\"lastName\"]") 
	    WebElement lastNameInput;
	    @FindBy(xpath="//input[@id=\"email\"]") 
	    WebElement emailInput;
	    @FindBy(xpath="//input[@id=\"phone\"]") 
	    WebElement phoneInput;

	    @FindBy(xpath = "//button[text()='Submit']") 
	    WebElement submitBtn;
	    @FindBy(xpath = "//button[text()='Cancel']") 
	    WebElement cancelBtn;
  @FindBy(xpath="//span[text()='Validation failed: lastName: Path `lastName` is required.']") 
	    WebElement errorMessage; 

	    public EditContact(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }
public void selectName() {
	Name.click();
}
	    public void updateEmail(String email) {
	        emailInput.clear();
	        emailInput.sendKeys(email);
	    }
	    public void updatePhone(String phone) {
	        phoneInput.clear();
	        phoneInput.sendKeys(phone);
	    }
	    public void clearLastName() {
	        lastNameInput.clear();
	    }
	    public void clickSubmit() {
	        submitBtn.click();
	    }
	    public void clickCancel() {
	        cancelBtn.click();
	    }
	        public void clickEdit() {
	        	editContactButton.click();
	        }
	    public String getErrorText() {
	        return errorMessage.getText();
	    }
	
public String getFirstRowPhone() {
    try {
        return contactRows.get(0).findElements(By.tagName("td")).get(4).getText().trim();
    } catch (NoSuchElementException e) {
        System.out.println("Unable to extract phone number from contact row.");
        return "";
    }}
}



