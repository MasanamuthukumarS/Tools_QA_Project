package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class checkbox_element 
{
	public static WebDriver driver;

	@FindBy(xpath = "//*[contains(text(),'Check Box')]" )
	public WebElement checkbox;

	@FindBy(xpath = "//button[@aria-label=\"Expand all\"]" )
	public WebElement expand;

	@FindBy(xpath = "//*[contains(text(),'Home')]" )
	public WebElement check;

	@FindBy(xpath = "//span[@class=\"text-success\"]" )
	public List<WebElement> result;

public checkbox_element(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}
}