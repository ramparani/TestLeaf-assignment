package week1.day5;

import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assessment2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//setup chromedriver
		System.setProperty("webdriver.chrome.driver", "drivers./chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		
    //launch site
	driver.get("https://www.redbus.in/");
	//Chennai
	driver.findElementById("src").sendKeys("Chennai");
	Thread.sleep(2000);
	driver.findElementById("src").sendKeys(Keys.TAB);
	//To
	driver.findElementById("dest").sendKeys("Bangalore");
	Thread.sleep(2000);
	driver.findElementById("dest").sendKeys(Keys.TAB);
	//Date
	driver.findElementByXPath("(//span[contains(@class,'fl icon-calendar_icon-new')])[1]").click();
	//Thread.sleep(3000);
	driver.findElementByXPath("(//td[text()='30'])[2]").click(); 
	//Search button
	driver.findElementById("search_btn").click();
	//After 6pm
	driver.findElementByXPath("(//label[@for='dtAfter 6 pm'])[2]").click();
	//Sleeper
	driver.findElementByXPath("//label[text()='SLEEPER']").click();
	//Seats
	driver.findElementByXPath("(//div[contains(@class,'w-15 fl')]//a)[2]").click();
	System.out.println("Seats Checked");
	//Close the browser
	driver.close();
	}

}
