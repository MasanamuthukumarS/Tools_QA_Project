package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class frames_tab 
{
	public static WebDriver driver;

	@FindBy(xpath = "//*[contains(text(),'Frames')]/parent::li[@id=\"item-2\"]" )
	public WebElement Frames;
	
	@FindBy(xpath = "//*[contains(text(),'This is a sample page')]" )
	public WebElement firstframe;
	
	@FindBy(xpath = "//*[contains(text(),'This is a sample page')]" )
	public WebElement secondframe;
	
public frames_tab(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}	
}