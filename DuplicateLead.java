package week1.day4;

//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

public class DuplicateLead {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
	System.setProperty("webdriver.chrome.driver", "drivers./chromedriver.exe");
		
		
		//setup chromedriver
			ChromeDriver driver = new ChromeDriver();	
	    //launch site
		driver.get("http://leaftaps.com/opentaps/control/main");
		//maximize
		driver.manage().window().maximize();
		//Enter Username and password
		driver.findElementById("username").sendKeys("DemoSalesManager");
		driver.findElementById("password").sendKeys("crmsfa");
		//Click Login
		driver.findElementByClassName("decorativeSubmit").click();
	//	
		//click CRM/SFA
		driver.findElementByLinkText("CRM/SFA").click();
		//Click Leads
		driver.findElementByLinkText("Leads").click();
		//Click Find Leads
		driver.findElementByLinkText("Find Leads").click();
		//Click Email
		driver.findElementByLinkText("Email").click();
		//Enter Email
		driver.findElementByName("emailAddress").sendKeys("ramparani.j@gmail.com");
		//Click FInd Leads button
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		//Capture first name
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(3000);
		//System.out.println(driver.findElementByXPath("(//a[@href='/crmsfa/control/viewLead?partyId=10049'])[3]").getText());
		String Firstname = driver.findElementByXPath("(//div[@class='x-grid3-cell-inner x-grid3-col-firstName']//a)[1]").getText();
		System.out.println(Firstname);
		//*[@id="ext-gen890"]//*[@id="ext-gen890"]
		//click first resulting lead
		driver.findElementByXPath("(//div[@class='x-grid3-cell-inner x-grid3-col-firstName']//a)[1]").click();
		//Click Duplicate lead
		driver.findElementByLinkText("Duplicate Lead").click();
		//Verify the title as Duplicate lead
		System.out.println(driver.getTitle());
		//Click create lead
		driver.findElementByName("submitButton").click();
		String Duplicate = driver.findElementById("viewLead_firstName_sp").getText();
		//System.out.println(Duplicate);
		//Verifying the name
		if(Duplicate.equals(Firstname))
		{ 
			System.out.println("Same Name");
		}
		else
		{System.out.println("Diff name");}
	}

}
