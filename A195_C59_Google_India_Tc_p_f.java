package assertion_programs;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class A195_C59_Google_India_Tc_p_f 
{

	@Test
	public void google_search()
	{
		ChromeDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		
		WebElement search = driver.findElement(By.name("q"));
		search.sendKeys("india" +Keys.ENTER);
		
		String url=driver.getCurrentUrl();
		Assert.assertEquals(url.contains("india"), true,"check again once");
	
	
	}
}
