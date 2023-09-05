package testcases;

import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.Dimension;

import Utilities.startup;
import dev.failsafe.Timeout;
import io.opentelemetry.exporter.logging.SystemOutLogExporter;
import pages.alerts;
import pages.frames_tab;
import pages.nestedframes;
import pages.sliders;
import pages.windowhandlee;

public class alerts_frame_windowns {

	public static WebDriver driver;
	public static Properties prop;
 
  @Test(priority=0)
  public void alert()
  {
	  String url = prop.getProperty("url");
	  driver.get(url);
	  driver.manage().window().maximize();
	  JavascriptExecutor js = (JavascriptExecutor) driver;
	  js.executeScript("window.scrollBy(0,350)", "");
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	  alerts obj = new alerts(driver);
	  obj.alerts_tab.click();
	  obj.alerts.click();
	  obj.simple_alert.click();
	  driver.switchTo().alert().accept();
	  try 
	  {
          obj.timer_alert.click();
          WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
          wait.until(ExpectedConditions.alertIsPresent());
          Alert unexpected = driver.switchTo().alert();
          unexpected.accept();
          System.out.println("Unexpected alert accepted");
	  }
	  catch (Exception e) 
	  {
          System.out.println("unexpected alert not present");
      }
	  obj.confirm_alert.click();
	  driver.switchTo().alert().dismiss();
	  obj.promt_alert.click();
	  driver.switchTo().alert().sendKeys("Hello");
	  driver.switchTo().alert().accept();
  }
  
  @Test(priority=1)
  public void frames()
  {  
	  JavascriptExecutor js = (JavascriptExecutor) driver;
	  js.executeScript("window.scrollBy(0,350)", "");
	  frames_tab obj = new frames_tab(driver);
	  js.executeScript("window.scrollBy(0,500)", "");
	  obj.Frames.click();
	  driver.switchTo().frame("frame1");
	  String first_act = obj.firstframe.getText();
	  driver.switchTo().defaultContent();
	  js.executeScript("window.scrollBy(0,400)", "");
	  driver.switchTo().frame("frame2");
	  String second_act = obj.secondframe.getText();
	  driver.switchTo().defaultContent();
	  String frame_exp = "This is a sample page";
	  Assert.assertEquals(first_act, frame_exp);
	  Assert.assertEquals(second_act, frame_exp);
	  System.out.println(first_act);
	  System.out.println(second_act);
  }
 
  @Test(priority=2)
  public void nested_frames()
  {
	  nestedframes obj = new nestedframes(driver);	  
	  obj.nestedFrames.click();
	  JavascriptExecutor js = (JavascriptExecutor) driver;
	  js.executeScript("window.scrollBy(0,-100)", "");
	  driver.switchTo().frame("frame1");
	  String parent_actual = obj.parentframe.getText();
	  driver.switchTo().frame(obj.iframe);
	  String child_actual = obj.childframe.getText();
	  String parent_exp = "Parent frame"; 
	  String child_exp = "Child Iframe"; 
	  driver.switchTo().defaultContent();
	  Assert.assertEquals(parent_actual, parent_exp);
	  Assert.assertEquals(child_actual, child_exp);
  }
  
  @Test(priority=3)
  public void windowhandling()
  {
	  windowhandlee obj = new windowhandlee(driver);
	  obj.browserwindow.click();
	  obj.newtab.click();
	  String mainwindow = driver.getWindowHandle();
	  Set<String>s=driver.getWindowHandles();
	  Iterator<String> I1= s.iterator();

	  while(I1.hasNext())
	  {
		  String child_window=I1.next();
	  		if(!mainwindow.equals(child_window))
	  		{
	  			driver.switchTo().window(child_window);
	  			System.out.println(driver.switchTo().window(child_window).getTitle());
	  			String newtab = obj.newtabmessage.getText();
	  			String expected_newtab = "This is a sample page";
	  			driver.close();
	  		}
	  	driver.switchTo().window(mainwindow);
	  }
	  
	  obj.newwindow.click();
	  Set<String> s1=driver.getWindowHandles();
	  Iterator<String> I2= s1.iterator();
	  
	  while(I2.hasNext())
	  {
		  String child_window1=I2.next();
		  if(!mainwindow.equals(child_window1))
		  {
			  driver.switchTo().window(child_window1);
			  System.out.println(driver.switchTo().window(child_window1).getTitle());
			  String newtab = obj.newtabmessage.getText();
			  String expected_newtab = "This is a sample page";
			  driver.close();
		  }
	  }
	  driver.switchTo().window(mainwindow);
  }
	  
  @Test(priority=4)
  public void slider()
  {
	sliders obj = new sliders(driver);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,350)", "");
	obj.alerts.click();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	obj.widgets.click();
	obj.slider.click();
	obj.sliderpoint.click();
	Actions point = new Actions(driver);
	
	for(int i=100;i>=0;i--)
	{
		Action action = point.sendKeys(Keys.ARROW_LEFT).build();
		action.perform();
	}
	
	for(int i=0;i<=100;i++)
	{
		Action action = point.sendKeys(Keys.ARROW_RIGHT).build();
		action.perform();	
	}
}
  
  @BeforeTest
  public void beforeTest() {
	  startup driverstartup = new startup(driver ,  prop);
	  this.driver = driverstartup.driver;
	  this.prop = driverstartup.prop;
  }

  @AfterTest
  public void afterTest() 
  {
	  driver.close();
  }
}
