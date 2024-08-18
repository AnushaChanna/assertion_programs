package assertion_programs;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LaunchFlipkart_ClickFashion_MensCategoryClickTShirts_SortByPriceHightoLow 
{
	@Test
	public void flipkart() throws InterruptedException
	{
	ChromeDriver driver=new ChromeDriver();
	driver.get("https://www.flipkart.com/");
	driver.manage().window().maximize();
	
	WebElement fashion= driver.findElement(By.linkText("Fashion"));
	fashion.click();
	Thread.sleep(2000);
	
	WebElement Men= driver.findElement(By.xpath("//span[.='Men']"));
	Men.click();
	
	Thread.sleep(2000);
	WebElement tshirts= driver.findElement(By.linkText("T-Shirts"));
	tshirts.click();
	
	Thread.sleep(2000);
	WebElement price=driver.findElement(By.xpath("(//div[@class='zg-M3Z'])[1]"));
	price.click();
	
	String title=driver.getCurrentUrl();
	Assert.assertEquals(title.contains("T-Shirts&sort=price_asc"), true,"Please check again");
	}
}