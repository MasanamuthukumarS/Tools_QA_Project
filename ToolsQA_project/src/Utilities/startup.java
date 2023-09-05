package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.Reader;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class startup {
	
public static WebDriver driver;
public static Properties prop;

public startup(WebDriver driver,Properties prop)
{
	driver = this.driver;
	prop = this.prop;
}

static
{
	System.setProperty("webdriver.chrome.driver","D:\\seleniumnew\\chrome\\chromedriver.exe");
	
	
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--remote-allow-origins=*");
	
	 driver = new ChromeDriver(options);
	
	File f = new File("C:\\Users\\masanamuthukumars\\eclipse-workspace\\ToolsQA_project\\src\\input.properties");
	FileInputStream fis = null;
	try {
		fis = new FileInputStream(f);
	} catch (FileNotFoundException e2) {
		// TODO Auto-generated catch block
		e2.printStackTrace();
	}

	prop = new Properties();
	try {
		prop.load(fis);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
