package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class textbox_element 
{
	public static WebDriver driver;

	@FindBy(xpath = "//*[contains(text(),'Elements')]/parent::div" )
	public WebElement elements;

	@FindBy(xpath = "//div[@class=\"element-list collapse show\"]/descendant::li[@class=\"btn btn-light \"][1]" )
	public WebElement textbox;
	
	@FindBy(xpath = "//input[@placeholder=\"Full Name\"]" )
	public WebElement fullname;

	@FindBy(xpath = "//input[@placeholder=\"name@example.com\"]" )
	public WebElement mail;

	@FindBy(xpath = "//textarea[@placeholder=\"Current Address\"]" )
	public WebElement currentaddress;

	@FindBy(xpath = "//textarea[@id=\"permanentAddress\"]" )
	public WebElement permanentaddress;

	@FindBy(xpath = "//button[@id=\"submit\"]" )
	public WebElement submitbutton;

public textbox_element(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}	
}