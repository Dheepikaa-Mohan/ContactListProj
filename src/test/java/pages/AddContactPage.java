package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecificationMethods;

public class AddContactPage extends ProjectSpecificationMethods{
	@FindBy(xpath="//input[@id=\"firstName\"]")
	public WebElement textFirstName;
    @FindBy(xpath="//input[@id=\"lastName\"]") 
     public WebElement textLastName;
    @FindBy(xpath="//input[@id=\"birthdate\"]") 
    WebElement textDOB;
    @FindBy(xpath="//input[@id=\"email\"]") 
    WebElement textEmail;
    @FindBy(xpath="//input[@id=\"phone\"]")
    WebElement textPhone;
    @FindBy(xpath="//input[@id=\"street1\"]") 
    public WebElement textStreet1;
    @FindBy(xpath="//input[@id=\"street2\"]") 
    public WebElement textStreet2;
    @FindBy(xpath="//input[@id=\"city\"]") 
    WebElement textCity;
    @FindBy(xpath="//input[@id=\"stateProvince\"]") 
    WebElement textState;
    @FindBy(xpath="//input[@id=\"postalCode\"]")
    WebElement textPostal;
    @FindBy(xpath="//input[@id=\"country\"]")
    WebElement textCountry;
    
    @FindBy(xpath ="//button[@id=\"submit\"]")
    WebElement btnSubmit;
    @FindBy(xpath ="//button[@id=\"cancel\"]") 
    WebElement btnCancel;
    public AddContactPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public AddContactPage enterFirstName(String firstName) {
        textFirstName.clear();
        textFirstName.sendKeys(firstName);
        return this;
    }

    public AddContactPage enterLastName(String lastName) {
        textLastName.clear();
        textLastName.sendKeys(lastName);
        return this;
    }

    public AddContactPage enterDOB(String dob) {
        textDOB.clear();
        textDOB.sendKeys(dob);
        return this;
    }

    public AddContactPage enterEmail(String email) {
        textEmail.clear();
        textEmail.sendKeys(email);
        return this;
    }

    public AddContactPage enterPhone(String phone) {
        textPhone.clear();
        textPhone.sendKeys(phone);
        return this;
    }

    public AddContactPage enterAddress(String street1, String street2, String city,
                                       String state, String postalCode, String country) {
        textStreet1.clear();
        textStreet1.sendKeys(street1);
        textStreet2.clear();
        textStreet2.sendKeys(street2);
        textCity.clear();
        textCity.sendKeys(city);
        textState.clear();
        textState.sendKeys(state);
        textPostal.clear();
        textPostal.sendKeys(postalCode);
        textCountry.clear();
        textCountry.sendKeys(country);
        return this;
    }
    public ContactList clickSubmit() {
        btnSubmit.click();
        return new ContactList(driver);
	
    }
public ContactList clickCancel() {
	btnCancel.click();
	return new ContactList(driver);
}}
