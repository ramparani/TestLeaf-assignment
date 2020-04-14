package week3.day2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*1) https://erail.in/trains-between-stations/mgr-chennai-ctr-MAS/ksr-bengaluru-SBC
2) Click on Sort on Date
3) Get all the Train Names
   Xpath: //div[@id='divTrainsList']//td[@class=''][2] 
   findElements -> List<WebElement>
4) Create another List using ArrayList (trainNames)
5) for each loop : List<WebElement>
6) You will get each WebElement : get its text 
7) Add the text to your created list (trainNames.add())
8) After the loop ends, sort it
9) Print it with the loop!!*/

public class ListClass {

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
		 List<String> trainNames =new ArrayList<String>();
		
		/* for(int i=0;i<=size-1;i++)
		  {  
			 WebElement trainlist = trains.get(i);
			 String names = trainlist.getText();
			 System.out.println("one" + names);
			 
			 trainNames.add(names);
			 Collections.sort(trainNames);
			 System.out.println(trainNames);
			 
			 }*/
		 
		 for(WebElement a:trains)
		 
		 { 
			 String text = a.getText();
			 trainNames.add(text);
			 
			 
		 }
		 Collections.sort(trainNames);
			System.out.println(trainNames);

			 
	}

}
