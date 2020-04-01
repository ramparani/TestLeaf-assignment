package week1.day2;

import org.openqa.selenium.chrome.ChromeDriver;

public class LeaftapsLogin {

	public static void main(String[] args) {
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
		driver.findElementByLinkText("CRM/SFA").click();
		//4.Click on create lead
		driver.findElementByLinkText("Create Lead").click();
		//5.Enter Mandatory Fields
		driver.findElementById("createLeadForm_companyName").sendKeys("CTS");
		driver.findElementById("createLeadForm_firstName").sendKeys("Ramparani");
		driver.findElementById("createLeadForm_lastName").sendKeys("J");
		//6.Click on create Lead
		driver.findElementByName("submitButton").click();
		//7.Verifying Lead
		System.out.println(driver.getTitle());
		//8.Close the browser
		driver.close();
		
		
		
		
		
		
		

	}

}
