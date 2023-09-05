package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class sliders 
{
	public static WebDriver driver;

	@FindBy(xpath = "//*[contains(text(),'Alerts, Frame & Windows')]" )
	public WebElement alerts;

	@FindBy(xpath = "//*[contains(text(),'Widgets')]" )
	public WebElement widgets;

	@FindBy(xpath = "//*[contains(text(),'Slider')]/ancestor::li" )
	public WebElement slider;

	@FindBy(xpath = "//input[@class=\"range-slider range-slider--primary\"]" )
	public WebElement sliderpoint;

public sliders(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}
}