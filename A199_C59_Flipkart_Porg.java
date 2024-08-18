package assertion_programs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class A199_C59_Flipkart_Porg
{
@Test
public void tshirts() throws InterruptedException
{
	ChromeDriver driver = new ChromeDriver();
	driver.get("https://www.flipkart.com/");
	driver.manage().window().maximize();
	
	WebElement fashion= driver.findElement(By.linkText("Fashion"));
	fashion.click();
	
	Thread.sleep(3000);
	WebElement Men= driver.findElement(By.xpath("//span[.='Men']"));
	Men.click();
    Thread.sleep(3000);
	WebElement tshirts= driver.findElement(By.linkText("T-Shirts"));
	tshirts.click();
	Thread.sleep(3000);
    WebElement LowToHigh= driver.findElement(By.xpath("(//div[@class='zg-M3Z'])[1]"));
	LowToHigh.click();
	
	String title = driver.getCurrentUrl();
	Assert.assertEquals(title.contains("T-Shirts&sort=price_asc"), true, "Please check again");
}

}
