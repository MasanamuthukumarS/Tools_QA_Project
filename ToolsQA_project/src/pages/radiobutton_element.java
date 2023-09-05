package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class radiobutton_element 
{
	public static WebDriver driver;

	@FindBy(xpath = "//*[contains(text(),'Radio Button')]" )
	public WebElement radiobutton;

	@FindBy(xpath = "//label[@for=\"yesRadio\"]" )
	public WebElement yesbutton;

	@FindBy(xpath = "//*[contains(text(),'Yes')]/parent::p" )
	public WebElement result;

public radiobutton_element(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}	
}