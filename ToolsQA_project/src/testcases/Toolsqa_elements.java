package testcases;

import org.testng.annotations.Test;

import Utilities.startup;
import pages.buttons_element;
import pages.checkbox_element;
import pages.radiobutton_element;
import pages.textbox_element;
import pages.webtables_element;

import org.testng.annotations.BeforeTest;

import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Toolsqa_elements {
	
		public static WebDriver driver;
		public static Properties prop;

	@Test(priority=0)
	public void textbox() 
  {	  	
		String url = prop.getProperty("url");
		String Fullname = prop.getProperty("Fullname");
		String Mail = prop.getProperty("Mail");
		String CurrentAddress = prop.getProperty("CurrentAddress");
		String PermanentAddress = prop.getProperty("PermanentAddress");
		textbox_element obj = new textbox_element(driver);
		driver.get(url);
		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		obj.elements.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		obj.textbox.click();
		js.executeScript("window.scrollBy(0,250)", "");
		obj.fullname.sendKeys(Fullname);
		obj.mail.sendKeys(Mail);
		obj.currentaddress.sendKeys(CurrentAddress);
		obj.permanentaddress.sendKeys(PermanentAddress);
		obj.submitbutton.click();
  }
  
  @Test(priority=1)
  public void checkbox() 
  {
	  	checkbox_element obj = new checkbox_element(driver);
	  	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  	obj.checkbox.click();
	  	obj.expand.click();	
	  	obj.check.click();
	  	int i=1;
	  	
	  	for(WebElement temp:obj.result)
		 {
	  		String names = temp.getText();
	  		System.out.println(i+"."+names);
		  	i++;
		 }	  
  }
  
  @Test(priority=2)
  public void radiobutton()
  {
	  radiobutton_element obj = new radiobutton_element(driver);
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  obj.radiobutton.click();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  obj.yesbutton.click();  
	  String expected_result = "You have selected Yes";
	  String Acual_result = obj.result.getText();
	  Assert.assertEquals(Acual_result, expected_result);
  }
  
  @Test(priority=3)
  public void webtables()
  {
	  String editable_name=prop.getProperty("Editable_name");
	  String editable_dep=prop.getProperty("Editable_dep");
	  webtables_element obj = new webtables_element(driver);
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  JavascriptExecutor js = (JavascriptExecutor) driver;
	  js.executeScript("window.scrollBy(0,350)", "");	
	  obj.webtable.click();
	  obj.searchbox.sendKeys(editable_name);
	  obj.edit.click();
	  obj.dep.clear();
	  obj.dep.sendKeys(editable_dep);
	  obj.submit.submit();
	  String expected_result = "Banking";
	  String Acual_result = obj.verification.getText();
	  Assert.assertEquals(Acual_result, expected_result);
  }
  
  @Test(priority=4)
  public void buttons()
  {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,350)", "");
	buttons_element obj = new buttons_element(driver);
	obj.buttons.click();
	Actions action = new Actions(driver);
	action.doubleClick(obj.double_click).perform();
	action.contextClick(obj.right_click).perform();
	js.executeScript("window.scrollBy(0,350)", "");
	obj.click.click();
	String doubleclick_exp = "You have done a double click";
	String doubleclick_act = obj.doubleclick_result.getText();
	String rightclick_exp = "You have done a right click";
	String rightclick_act = obj.rightclick_result.getText();
	String click_exp = "You have done a dynamic click";
	String click_act = obj.dynamic_click_result.getText();
	Assert.assertEquals(doubleclick_act, doubleclick_exp);
	Assert.assertEquals(rightclick_act, rightclick_exp);
	Assert.assertEquals(click_act, click_exp);
  }
	  
  @BeforeTest
  public void beforeTest() 
  {
	  startup driverstartup = new startup(driver ,  prop);
	  this.driver = driverstartup.driver;
	  this.prop = driverstartup.prop;
  }
  
  @AfterTest
  public void afterTest() {
	  //driver.close();
  }
}