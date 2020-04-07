package week2.day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class DelLeadXPath {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
				System.setProperty("webdriver.chrome.driver", "drivers./chromedriver.exe");
				ChromeDriver driver = new ChromeDriver();
				//Launch the browsers
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
			    //Click on Phone
				driver.findElementByXPath("(//em[@class='x-tab-left'])[2]").click();
				//Enter number
				driver.findElementByXPath("//input[@name='phoneNumber']").sendKeys("1234");
				//Click Find leads
				driver.findElementByXPath("//button[text()='Find Leads']").click();
				Thread.sleep(3000);
				//Capture Lead ID of first resulting lead
				WebElement name = driver.findElementByXPath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a)[1]");
				String fname = name.getText();
				System.out.println(fname);
			    //Click First Resulting lead
				driver.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a[1]").click();
				//Delete the lead
				driver.findElementByXPath("//a[text()='Delete']").click();
				//Click Find leads
				driver.findElementByXPath("//a[text()='Find Leads']").click();
				//Enter captured lead ID
				driver.findElementByXPath("//input[@name='id']").sendKeys(fname);
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


