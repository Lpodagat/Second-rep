package TryMaven;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
public class TestMaven {
	@Parameters({"username","Password"})
	@Test
public void login(String username,String Password) throws InterruptedException

{
	System.out.println("Launching chrome browser");
	System.setProperty("webdriver.chrome.driver","C:\\Program Files (x86)\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	driver.get("https://en.wikipedia.org/w/index.php?title=Special:UserLogin&returnto=Main+Page");
	System.out.println(driver.getTitle());
	
	driver.findElement(By.id("wpName1")).sendKeys(username);
	driver.findElement(By.id("wpPassword1")).sendKeys(Password);
	WebElement e= driver.findElement(By.id("wpLoginAttempt"));
	//explicit wait: time(10sec) and condition(element visibility)
	WebDriverWait w=new WebDriverWait(driver,10);
	w.until(ExpectedConditions.visibilityOf(e));
	//driver.findElement(By.id("wpLoginAttempt")).click();
	e.click();
	
}
}
