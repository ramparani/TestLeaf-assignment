package week1.day5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.*;

public class Assessment1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
System.setProperty("webdriver.chrome.driver", "drivers./chromedriver.exe");
		
		
		//setup chromedriver
			ChromeDriver driver = new ChromeDriver();	
	    //launch site
		driver.get("https://acme-test.uipath.com/account/login");
		//maximize
		//driver.manage().window().maximize();
		//Username and Password
		driver.findElementById("email").sendKeys("kumar.testleaf@gmail.com");
		driver.findElementById("password").sendKeys("leaf@12");
		//Login
		driver.findElementById("buttonLogin").click();
		//Mouse over
 Thread.sleep(3000);
		WebElement mouse = driver.findElement(By.xpath("//button[text()[normalize-space()='Vendors']]"));
		Actions act=new Actions(driver);
		act.moveToElement(mouse).perform();
		System.out.println("Mouse hover performed");
		//Search for vendor
		driver.findElement(By.linkText("Search for Vendor")).click();
		//Enter vendor name
		driver.findElement(By.id("vendorName")).sendKeys("Blue Lagoon");
		//CLick search
		driver.findElement(By.id("buttonSearch")).click();
		//Country
		System.out.println("Country" + driver.findElement(By.xpath("//td[text()='France']")).getText());
		//Logout
		driver.findElement(By.linkText("Log Out")).click();
		driver.close();
		
		
	}

}
