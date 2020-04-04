package week1.day5;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DelLeadAssignment {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers./chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		//Launch the browser
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//enter the username
		driver.findElementById("username").sendKeys("DemoSalesManager");
		//enter the password
		driver.findElementById("password").sendKeys("crmsfa");
		//click login
		driver.findElementByClassName("decorativeSubmit").click();
        //Click crm/sfa link
		driver.findElementByLinkText("CRM/SFA").click();
		//Click Leads link
		driver.findElementByLinkText("Leads").click();
		//Click Find leads
		driver.findElementByLinkText("Find Leads").click();
	    //Click on Phone
		driver.findElementByLinkText("Phone").click();
		//Enter number
		driver.findElementByName("phoneNumber").sendKeys("1234");
		//Click Find leads
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		Thread.sleep(3000);
		//Capture Lead ID of first resulting lead
		WebElement name = driver.findElementByXPath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a)[1]");
		String fname = name.getText();
		System.out.println(fname);
	    //Click First Resulting lead
		driver.findElementByXPath("(//div[@class='x-grid3-cell-inner x-grid3-col-firstName']//a)[1]").click();
		//Delete the lead
		driver.findElementByClassName("subMenuButtonDangerous").click();
		//Click Find leads
		driver.findElementByLinkText("Find Leads").click();
		//Enter captured lead ID
		driver.findElementByName("id").sendKeys(fname);
		//Click Find leads
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		//No Records to display 
		String noRecord = driver.findElementByXPath("//div[text()='No records to display']").getText();
		//System.out.println(noRecord);
		if(noRecord.contains("No records"))
		{
			System.out.println("Verified: "+noRecord);
			
		}
		else
		{System.out.println("Not Verified");}
		//close the browser
		driver.close();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
