package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class buttons_element {

	public static WebDriver driver;

	@FindBy(xpath = "//*[contains(text(),'Buttons')]" )
	public WebElement buttons;
	
	@FindBy(xpath = "//button[@id=\"doubleClickBtn\"]" )
	public WebElement double_click;
	
	@FindBy(xpath = "//button[@id=\"rightClickBtn\"]" )
	public WebElement right_click;

	@FindBy(xpath = "//button[@id=\"rightClickBtn\"]/following::div[1]/child::button" )
	public WebElement click;
	
	@FindBy(xpath = "//p[@id=\"doubleClickMessage\"]" )
	public WebElement doubleclick_result;
	
	@FindBy(xpath = "//p[@id=\"rightClickMessage\"]" )
	public WebElement rightclick_result;
	
	@FindBy(xpath = "//p[@id=\"dynamicClickMessage\"]" )
	public WebElement dynamic_click_result;
	
	public buttons_element(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
}