package week1.day3;

import org.openqa.selenium.chrome.ChromeDriver;

public class StringDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.setProperty("webdriver.chrome.driver", "drivers./chromedriver.exe");
		
		
		//setup chromedriver
			ChromeDriver driver = new ChromeDriver();	
	    //1.launch site
		driver.get("http://leaftaps.com/opentaps/control/main");
		//getting Title
		System.out.println(driver.getTitle());
		//Maximize the browser
		driver.manage().window().maximize();
		//2.Login
		//Entering username
		driver.findElementById("username").sendKeys("DemoSalesManager");
		//Entering Password
		driver.findElementById("password").sendKeys("crmsfa");
		//Click login
		driver.findElementByClassName("decorativeSubmit").click();
		//3.Click on CRM/SFA
		String text = driver.findElementByTagName("h2").getText();
		
		System.out.println(text);
		String Stext=text.substring(8, text.length());
		System.out.println(Stext);
	}

}
