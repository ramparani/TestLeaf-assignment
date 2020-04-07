package week2.day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EdiLeadXPath {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "drivers./chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		//Launch the browser
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//enter the username
		driver.findElementByXPath("//input[@id='username']").sendKeys("DemoSalesManager");
		//enter the password
		driver.findElementByXPath("//input[@id='password']").sendKeys("crmsfa");
		//click login
		driver.findElementByXPath("//input[@class='decorativeSubmit']").click();
        //Click crm/sfa link
		driver.findElementByXPath("//a[contains(text(),'CRM/SFA')]").click();
		//Click Leads link
		driver.findElementByXPath("//a[text()='Leads']").click();
		//Click Find leads
		driver.findElementByXPath("//a[text()='Find Leads']").click();
		//Enter first name
		driver.findElementByXPath("(//input[@name='firstName'])[3]").sendKeys("Ramparani");
		//Click Find leads button
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		//Click on first resulting lead
		Thread.sleep(3000);
		//LeadName.click();
	  	driver.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a[1]").click();
		//Verify title of the page
		System.out.println(driver.getTitle());
		//Click Edit
		driver.findElementByXPath("//a[text()='Edit']").click();
		//Change the company name
		WebElement companyname = driver.findElementByXPath("//input[@id='updateLeadForm_companyName']");
		companyname.clear();
		companyname.sendKeys("Thoughtworks");
		//update
		driver.findElementByXPath("//input[@name='submitButton'][1]").click();
		//Confirm the changed name appears
		String cpname = driver.findElementByXPath("//span[@id='viewLead_companyName_sp']").getText();
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
