package CucumberFramework.stepFiles;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class Login {

	WebDriver driver;

	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
		this.driver = new ChromeDriver();
		this.driver.manage().window().maximize();
		this.driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		this.driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
		}
	
	@Before
	public void setup_firefox() {
		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\aa78137\\Desktop\\CucumberFramework\\CucumberFramework\\src\\test\\java\\CucumberFramework\\Resources\\geckodriver.exe");
		FirefoxOptions firefoxOptions = new FirefoxOptions();
		firefoxOptions.setCapability("marionette", true);
		this.driver = new FirefoxDriver(firefoxOptions);
		this.driver.manage().window().maximize();
		this.driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS); 	
		this.driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
		}
	@After
	public void exit() {
		//this.driver.manage().deleteAllCookies();
		//this.driver.quit();
		//this.driver=null;
	}

	@Given("^User navigates to stack overflow website$")
	public void user_navigates_to_stack_overflow_website() throws Throwable {
		Thread.sleep(3000);
		driver.get("https://stackoverflow.com/");
	
	}

	@And("^User clicks on the Login button$")
	public void user_clicks_on_the_Login_button() throws Throwable {
		Thread.sleep(30000);
		driver.findElement(By.xpath("//a[text()='Log In']")).click();
		Thread.sleep(30000);
	}

	@And("^User enters a valid username$")
	public void user_enters_a_valid_username() throws Throwable {
		Thread.sleep(30000);
		driver.findElement(By.name("email")).sendKeys("autotestudemy@mail.com");
		}

	@And("^User enters a valid password$")
	public void user_enters_a_valid_password() throws Throwable {
		Thread.sleep(30000);
	driver.findElement(By.name("password")).sendKeys("Password321!");
	}

	@When("^User clicks on Login button$")
	public void user_clicks_on_Login_button() throws Throwable {
		Thread.sleep(30000);
		driver.findElement(By.name("submit-button")).click();
	}

	@Then("^User should be taken to the successful login page$")
	public void user_should_be_taken_to_the_successful_login_page() throws Throwable {
		WebElement askQuestion = driver.findElement(By.xpath("//a[contains(text(),'Ask Question')]"));
		Thread.sleep(30000);
		Assert.assertEquals(true, askQuestion.isDisplayed());
		
	}

}
