package week3.day3;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;

import org.openqa.selenium.chrome.ChromeDriver;

public class WHAssignment {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "drivers./chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		//Launch the browser
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
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
		//merge leads
		driver.findElementByLinkText("Merge Leads").click();
		Thread.sleep(2000);		
		//From Lead
		driver.findElementByXPath("(//a)[37]").click();
				
		Set<String> winHan = driver.getWindowHandles();
		System.out.println(winHan.size());
		List <String> list = new ArrayList <String>(winHan);
		System.out.println("List Count: "+list.size());
	
				
		//Switch to Find Lead 	
		driver.switchTo().window(list.get(1));
			
		//find the lead 
		driver.findElementByXPath("//input[@name='firstName']").sendKeys("Gopi");
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		Thread.sleep(3000);
		
		//click on the first result
		driver.findElementByXPath("//a[@class='linktext']").click();
								
		//Switch back to first/parent window
		driver.switchTo().window(list.get(0));
				
		// Lead window
		driver.findElementByXPath("(//a)[38]").click();
		Set<String> winHan1 = driver.getWindowHandles();
		System.out.println(winHan1.size());
		List <String> list1 = new ArrayList <String>(winHan1);
		System.out.println(list1.size());
				
		//Switch to second(FInd lead) window	
		driver.switchTo().window(list1.get(1));
				
		//find the lead 
		driver.findElementByXPath("//input[@name='firstName']").sendKeys("Ram");
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		Thread.sleep(3000);
		
		 //click on the first result		
		driver.findElementByXPath("//a[@class='linktext']").click();
				
		//Switch back to parent window
		driver.switchTo().window(list1.get(0));
				
		//Click on Merge Button
		driver.findElementByLinkText("Merge").click();
				
		//Switch to Alert window
		Alert alert = driver.switchTo().alert();
				
		//Click on OK
		alert.accept();
					
		//confirm the merge 
				
		driver.findElementByLinkText("Find Leads").click();
		driver.findElementByXPath("//input[@name='id']").sendKeys("10095");
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		String text = driver.findElementByXPath("//div[@class='x-paging-info']").getText();	
		System.out.println("Successfully merged: "+text);
				
		 
	}

}
