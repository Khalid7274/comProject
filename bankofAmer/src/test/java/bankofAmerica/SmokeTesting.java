package bankofAmerica;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;


@Listeners({ListenersForBank.class})
public class SmokeTesting extends Base
{
	
	public WebDriver driver;
	
	@BeforeClass
	public void setup() {
		Base bs= new Base();
		bs.initialize_driver();
		//driver = new ChromeDriver();
		driver = getDriver();
		driver.get("https://www.bankofamerica.com/");
	}
	
	@Test(priority=1)
	@Epic("EP002")
	public void logoTest() {
		boolean disstatus=driver.findElement(By.xpath("//img[@alt='Bank of America Logo']")).isDisplayed();
		Assert.assertEquals(disstatus, true);
	}
	@Test(priority=2)
	@Epic("EP001")
	@Description("To Validate the open account link")
	@Severity(SeverityLevel.CRITICAL)
	public void accountlink() {
		WebElement openaccount=driver.findElement(By.linkText("Open an Account"));
		if(openaccount.isDisplayed()) {
			System.out.println("Open account link is display: " + openaccount.isDisplayed());
		}else {
			System.out.println("Open account link is not display: " + openaccount.isDisplayed());
		}
	}
	@Test(priority=3)
	@Epic("EP001")
	@Description("To Validate the appointment link")
	@Severity(SeverityLevel.CRITICAL)
	public void applink() {
		WebElement openaccount=driver.findElement(By.xpath("//a[@id='apptScheduler']"));
		if(openaccount.isDisplayed()) {
			System.out.println("Appointment link is display: " + openaccount.isDisplayed());
		}else {
			System.out.println("Appointment link is not display: " + openaccount.isDisplayed());
		}
	}
	@Test(priority=4)
	@Epic("EP001")
	@Description("To Validate login")
	@Severity(SeverityLevel.CRITICAL)
	
	public void loginTest() {
		driver.findElement(By.id("onlineId1")).sendKeys("Ali");
		driver.findElement(By.id("passcode1")).sendKeys("Khan12");
		driver.findElement(By.xpath("//span[normalize-space()='Sign In']")).click();
		
		Assert.assertEquals(driver.getTitle(), "Welcome to Bank of America");
	}
	
	@Test(priority=5)
	@Epic("EP001")
	@Feature("login")
	@Description("To Validate the Forgot ID/PassCode")
	@Severity(SeverityLevel.CRITICAL)
	
	public void forgotID() {
		WebElement forgotPass=driver.findElement(By.linkText("Forgot ID/Passcode?"));
		
		if(forgotPass.isDisplayed()) {
			System.out.println("Forgot ID and Passcode link is found");
		}else
		{
			System.out.println("Forgot ID and Passcode link is not found");
		}
	}
	@Test(priority=6)
	@Epic("EP001")
	@Feature("login")
	@Description("To Validate the problem signin")
	@Severity(SeverityLevel.CRITICAL)
	
	public void problemSignIn() {
		WebElement problemSing=driver.findElement(By.linkText("Problem signing in?"));
		
		if(problemSing.isDisplayed()) {
			System.out.println("Problem signing in? is found");
		}else
		{
			System.out.println("Problem signing in? is not found!");
		}
	}
	//Not using Online Banking?
	@Test(priority=7)
	@Epic("EP001")
	@Feature("login")
	@Description("To Validate the Enroll link presence")
	@Severity(SeverityLevel.CRITICAL)
	public void enrollLink() {
		WebElement enrollLin=driver.findElement(By.linkText("Enroll now"));
		
		if(enrollLin.isDisplayed()) {
			System.out.println("Enroll link is found");
		}else
		{
			System.out.println("Enroll link is not found!");
		}
	}
	//Back to home page from login
	@Test(priority=8)
	@Epic("EP001")
	@Description("To validate back to homepage command")
	@Severity(SeverityLevel.CRITICAL)
	public void backtohome() {
		driver.navigate().back();
		String pageTitle=driver.getTitle();
		System.out.println(pageTitle);
		System.out.println("************************************");
		Assert.assertEquals(driver.getTitle(), "Bank of America - Banking, Credit Cards, Loans and Merrill Investing");
	}
	//****Better Money Habits
		@Test(priority=9)
		@Epic("EP002")
		@Feature("Better Money Management")
		@Description("To validate the links for: Retirment, College and Taxes and Incom")
		@Severity(SeverityLevel.NORMAL)
		public void betterMoney() {
			driver.findElement(By.xpath("//span[contains(text(),'Better Money Habits®')]")).click();
			
			//College Text Link
			WebElement taxesLink=driver.findElement(By.xpath("//span[contains(text(),'Taxes & Income')]"));
			
			if(taxesLink.isDisplayed()) {
				System.out.println("Taxes link is found");
			}else
			{
				System.out.println("Taxes link is not found!");
			}
			
			//Retirement Text Link
			WebElement retirLink=driver.findElement(By.xpath("//a[@id='bmhRetirement']"));
			
			if(retirLink.isDisplayed()) {
				System.out.println("Retirment link is found: ");
			}else
			{
				System.out.println("Retirment link is not found!");
			}
			
			//College Text Link
			WebElement collegeLink=driver.findElement(By.xpath("//a[@id='bmhRetirement']"));
			
			if(collegeLink.isDisplayed()) {
				System.out.println("College link is found: ");
			}else
			{
				System.out.println("College link is not found!");
			}
			//find paragraph text 
			String exText=driver.findElement(By.xpath("//p[contains(text(),'Videos and tips to better manage your financial li')]")).getText();
			//Assert.assertTrue(list.size()>0);
			if(driver.getPageSource().contains("Videos and tips to better manage your financial life")==true) {
				System.out.println("Your Expected pargraph is exist. Return: " + exText);
			}else {
				System.out.println("Your Expected pargraph is not exist" + exText);
			}
			//driver.findElement(By.cssSelector("#close-bettermoneyhabits-l1-nav")).click();
		}
		@Test(priority=10)
		@Epic("EP003")
		@Feature("Checking Account")
		@Description("To Validate the checking Account link")
		@Severity(SeverityLevel.CRITICAL)
		public void checkingAccount() {
			driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/section[2]/div[1]/div[1]/div[1]/div[1]/div[1]/nav[1]/ul[1]/li[1]/a[1]/span[3]")).click();
			
			String expectedChecking=driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/section[2]/div[1]/div[1]/div[1]/div[2]/div[1]/section[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/p[1]")).getText();
			
			if(driver.getPageSource().contains("Stay flexible with Bank of")==true) {
				System.out.println("I reached to the expected page. Returnt "+  expectedChecking);
			}else {
				System.out.println("I not able to found the expected page. Returnt "+  expectedChecking);
			}
		}
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
