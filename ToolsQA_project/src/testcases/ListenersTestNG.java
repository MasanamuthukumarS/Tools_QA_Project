package testcases;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.IAnnotationTransformer;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.ITestAnnotation;

public class ListenersTestNG implements ITestListener, IAnnotationTransformer {
	public WebDriver driver;
	
  public void onStart(ITestContext context) {
    System.out.println("onStart method started" + context.getName());
  }

  public void onFinish(ITestContext context) {
    System.out.println("onFinish method started");
  }

  public void onTestStart(ITestResult result) {
    Reporter.log("New Test Started" + result.getName());
  }

  public void onTestSuccess(ITestResult result) {

    System.out.println("onTestSuccess Method " + result.getName());
  }

  public void onTestFailure(ITestResult result) {

    System.out.println("onTestFailure Method" + result.getName());
    
  }

  public void onTestSkipped(ITestResult result) {
    System.out.println("onTestSkipped Method" + result.getName());
  }

  public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    System.out.println("onTestFailedButWithinSuccessPercentage" + result.getName());
  }

  public void transform(ITestAnnotation annotation, Class tesClass,

    Constructor testConstructor, Method testMethod) {

    annotation.setRetryAnalyzer(RetryFailTestCase.class);
  }

}