package assertion_programs;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class A196_C59_LoginAmazon_PorF
{
@Test
public void AmazonLoginPassorFail() throws EncryptedDocumentException, IOException
{
	FileInputStream file = new FileInputStream("C:\\Users\\LENOVO\\eclipse-workspace\\Selenium_Assignments\\DDT\\loginsheet.xlsx");
	Workbook w1=WorkbookFactory.create(file);
	String un = NumberToTextConverter.toText(w1.getSheet("amazonlogin").getRow(0).getCell(0).getNumericCellValue());
	String pw= w1.getSheet("amazonlogin").getRow(0).getCell(1).getStringCellValue();
	
	ChromeDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://www.amazon.in");
	driver.manage().window().maximize();
	
	WebElement acccountslist = driver.findElement(By.xpath("(//span[@class='nav-line-1 nav-progressive-content'] )[2]"));
	Actions a1=new Actions(driver);
	a1.moveToElement(acccountslist).perform();
	
	WebElement signin=driver.findElement(By.linkText("Sign in"));
	signin.click();
	
	WebElement email=driver.findElement(By.name("email"));
	email.sendKeys(un + Keys.ENTER);

	WebElement password=driver.findElement(By.id("ap_password"));
	password.sendKeys(pw + Keys.ENTER);
	
	WebElement acccountslistclick = driver.findElement(By.xpath("(//span[@class='nav-line-1 nav-progressive-content'] )[2]"));
	acccountslistclick.click();
	
	
	String compare= driver.getCurrentUrl();
	Assert.assertEquals(compare.contains("homepage"), true, "your TC is fail please check once");
	
	
}
	
}
