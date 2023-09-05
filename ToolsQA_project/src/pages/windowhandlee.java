package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class windowhandlee 
{
	public static WebDriver driver;

	@FindBy(xpath = "//*[contains(text(),'Browser Windows')]" )
	public WebElement browserwindow;

	@FindBy(xpath = "//button[@id=\"tabButton\"]" )
	public WebElement newtab;

	@FindBy(xpath = "//button[@id=\"windowButton\"]" )
	public WebElement newwindow;

	@FindBy(xpath = "//button[@id=\"messageWindowButton\"]" )
	public WebElement messagewindow;

	@FindBy(xpath = "//h1[@id=\"sampleHeading\"]" )
	public WebElement newtabmessage;

	@FindBy(xpath = "//h1[@id=\"sampleHeading\"]" )
	public WebElement newwindowmessage;

	@FindBy(xpath = "//*[contains(text(),'Knowledge increases by sharing but not by saving. Please share this website with your friends and in your organization.')]" )
	public WebElement newindowmessage1;

public windowhandlee(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}
}