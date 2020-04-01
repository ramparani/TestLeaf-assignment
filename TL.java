package week1.day3;

import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	System.setProperty("webdriver.chrome.driver", "drivers./chromedriver.exe");
		
		
		//setup chromedriver
			ChromeDriver driver = new ChromeDriver();	
	    //launch site
		driver.get("http://www.leafground.com/pages/Edit.html");
		
		driver.findElementById("email").sendKeys("ramparani.j@gmail.com");
		driver.findElementByXPath("//*[@id=\"contentblock\"]/section/div[2]/div/div/input").sendKeys("ramparani.j@gmail.com",Keys.TAB);
		driver.findElementByName("username").getAttribute("value");
		driver.findElementByXPath("//*[@id=\"contentblock\"]/section/div[4]/div/div/input").clear();
		boolean ena=driver.findElementByXPath("//*[@id=\"contentblock\"]/section/div[5]/div/div/input").isEnabled();
		System.out.println(ena);
	 
	 
				
		
	}

}
