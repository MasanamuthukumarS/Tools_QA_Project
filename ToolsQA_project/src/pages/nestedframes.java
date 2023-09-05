package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class nestedframes 
{
	public static WebDriver driver;

	@FindBy(xpath = "//*[contains(text(),'Nested Frames')]" )
	public WebElement nestedFrames;
	
	@FindBy(xpath = "//iframe[@srcdoc=\"<p>Child Iframe</p>\"]" )
	public WebElement iframe;
	
	@FindBy(xpath = "//*[contains(text(),'Parent frame')]" )
	public WebElement parentframe;
	
	@FindBy(xpath = "//*[contains(text(),'Child Iframe')]" )
	public WebElement childframe;
	
	public nestedframes(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}	
}