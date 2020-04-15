package week3.day3;


import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SetClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "drivers./chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		//Launch the browser
		driver.get("https://erail.in/trains-between-stations/mgr-chennai-ctr-MAS/ksr-bengaluru-SBC");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//click on sort date
		 boolean selected = driver.findElementById("chkSelectDateOnly").isSelected();
		 if(selected==true)
			 driver.findElementById("chkSelectDateOnly").click();
		 //Get all train names
		 List<WebElement> trains = driver.findElementsByXPath("//div[@id='divTrainsList']//td[@class=''][2]");
		 int size = trains.size();
		 Set<String> trainNames =new HashSet<String>();
		 
		 for(WebElement et:trains)
		 
		 {trainNames.add(et.getText());
		 }
		 System.out.println(trainNames);
		 
		 //to confirm if no duplicated
		 
		 if(trains.size()==trainNames.size())
			 
		 {
			 
			 System.out.println("No Duplicates");
		 }
		 
		 else
			 
		 {System.out.println("Duplicates Exists");}
			 
			 
		 
		 
	}

}
