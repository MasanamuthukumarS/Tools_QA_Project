package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class alerts {

	public static WebDriver driver;

	@FindBy(xpath = "//*[contains(text(),'Alerts, Frame & Windows')]" )
	public WebElement alerts_tab;
	
	@FindBy(xpath = "//*[contains(text(),'Alerts')]/self::span" )
	public WebElement alerts;
	
	@FindBy(xpath = "//button[@id=\"alertButton\"]" )
	public WebElement simple_alert;
	
	@FindBy(xpath = "//button[@id=\"timerAlertButton\"]" )
	public WebElement timer_alert;
	
	@FindBy(xpath = "//button[@id=\"confirmButton\"]" )
	public WebElement confirm_alert;
	
	@FindBy(xpath = "//button[@id=\"promtButton\"]" )
	public WebElement promt_alert;
	
	public alerts(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
}