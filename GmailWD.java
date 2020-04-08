package week1.day2;

import org.openqa.selenium.chrome.ChromeDriver;

public class GmailWD {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.setProperty("webdriver.chrome.driver", "drivers./chromedriver.exe");
		
		
		//setup chromedriver
			ChromeDriver driver = new ChromeDriver();	
	    //launch site
		driver.get("https://gmail.com");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		//System.out.println(driver.getPageSource());
		driver.navigate().refresh();
		driver.close();
		
	}

}
