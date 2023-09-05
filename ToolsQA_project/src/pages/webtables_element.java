package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class webtables_element 
{
	public static WebDriver driver;

	@FindBy(xpath = "//*[contains(text(),'Web Tables')]" )
	public WebElement webtable;

	@FindBy(xpath = "//input[@placeholder=\"Type to search\"]" )
	public WebElement searchbox;

	@FindBy(xpath = "//span[@class=\"mr-2\"]" )
	public WebElement edit;

	@FindBy(xpath = "//input[@id=\"department\"]" )
	public WebElement dep;

	@FindBy(xpath = "//button[@id=\"submit\"]" )
	public WebElement submit;

	@FindBy(xpath = "//div[@class=\"rt-tr -odd\"]/child::div[6]" )
	public WebElement verification;

public webtables_element(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}
}