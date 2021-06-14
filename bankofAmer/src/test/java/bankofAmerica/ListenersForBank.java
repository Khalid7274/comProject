package bankofAmerica;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import io.qameta.allure.Attachment;


public class ListenersForBank implements ITestListener{

	private static String getTestMethodName(ITestResult result) {
		return result.getMethod().getConstructorOrMethod().getName();
	}

	
	@Attachment(value = "Screenshot", type="image/png")
		public byte[] saveScreenshotOnFailure(WebDriver driver) {
			return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		}
	
	
	
	@Attachment(value = "{0}", type="text/plain")
	
		public static String saveTextLog(String message) {
		return message;
	}

	public void onStart(ITestContext context) {
		System.out.println("I am onStart method" + context.getName());
		context.setAttribute("WebDriver", Base.getDriver());
	}

	public void onFinish(ITestContext context) {
		System.out.println("I am in onFinish method" + context.getName());
	}
	
	public void onTestStart(ITestResult result) {
		System.out.println("I am onTestStart method" + getTestMethodName(result) + " start");
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("I am onTestSucess method" + getTestMethodName(result) + " succeed");
	}
	//on Test Failure 
	public void onTestFailure(ITestResult result) {
		System.out.println("I am onTestFailure method" + getTestMethodName(result) + " faild");
		saveScreenshotOnFailure(Base.getDriver());
		saveTextLog(result.getMethod().getConstructorOrMethod().getName());
	}
	public void onTestSkipped(ITestResult result) {
		System.out.println("I am onTestSkipped method" + getTestMethodName(result) + " skipped");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("Test faild but it's on sucess percentage" + getTestMethodName(result) + "success ratio");
	}	
}
