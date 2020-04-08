package week2.day3;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "drivers./chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		//Launch the browser
		driver.get("http://www.leafground.com/pages/Dropdown.html");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//Step 1: Find the dropdown ->webelement
		WebElement drop = driver.findElementById("dropdown1");
		
		//Convert the webelemet to Select
		//Select is a class
		
		Select dd=new Select(drop);
		
		//Interact with Drop down using menthod
		// 3 menthods
		//1. By text- balck in colour
		dd.selectByVisibleText("UFT/QTP");
		
		//2. Value id it is multi lingual
		
		dd.selectByValue("2");
		
		//3. index- count- number start form 0
		
		dd.selectByIndex(4);
		
		
		//I want to select last drop down
		//How to find out how many options are available. becuase if we know how many option then it will be easy
		List<WebElement> options = dd.getOptions();
		
		//find the count of list item-size()
		int count=options.size();
		
		//Seletc the last
		//SInce it is number so index method
		
		dd.selectByIndex(count-1);
		
		//to select multiple items:
		
	WebElement drop2 = driver.findElementByXPath("(//select)[last()]");
	
	Select dd5=new Select(drop2);
		
		boolean mul=dd5.isMultiple();
		System.out.println(mul);
	}

}
