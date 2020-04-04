package week1.day5;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EditLeadAssignment {

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
		//Enter first name
		driver.findElementByXPath("(//span[text()='Advanced']/following::input)[2]").sendKeys("Ramparani");
		//Click Find leads button
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		//Click on first resulting lead
		Thread.sleep(3000);
		//LeadName.click();
	  	driver.findElementByXPath("(//div[@class='x-grid3-cell-inner x-grid3-col-firstName']//a)[1]").click();
		//Verify title of the page
		System.out.println(driver.getTitle());
		//Click Edit
		driver.findElementByLinkText("Edit").click();
		//Change the company name
		WebElement companyname = driver.findElementById("updateLeadForm_companyName");
		companyname.clear();
		companyname.sendKeys("Thoughtworks");
		//update
		driver.findElementByClassName("smallSubmit").click();
		//Confirm the changed name appears
		String cpname = driver.findElementById("viewLead_companyName_sp").getText();
		if(cpname.contains("Thoughtworks"))
		{
			System.out.println("Company name changed: "+cpname);
		}
		else
		{
			System.out.println("company name doesn't changed");
		}
		//Close the browser(Dont log out)
		driver.close();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
