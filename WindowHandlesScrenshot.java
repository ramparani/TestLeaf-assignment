package week3.day3;



import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandlesScrenshot {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "drivers./chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		//Launch the browser
		driver.get("http://www.leafground.com/pages/Window.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElementById("home").click();
		
		//1st wiondow title because window ctrl is in 1st window
		System.out.println("First Window tite: "+driver.getTitle());
		
		//Window ref- to find the reference of windows
		String firstWindow = driver.getWindowHandle();
		System.out.println("First Window Ref: "+firstWindow);//return unique ref ,so for each session it differs
		
		
		//WAYYYYY 1 --  it is only mostly applicaple for real time
		
		//But need to switch to 2nd window. so below funtion helps
		//Switch to window
		
		Set<String> secWindow = driver.getWindowHandles();
		System.out.println("all windows ref: "+secWindow);
		//here we need to use the 2nd ref id but in set we cannot find using get(). So here we create Empty List and copy  the value from set to list
		List<String> list=new ArrayList<String>(secWindow);
		System.out.println("Count of List size after copying Set: "+list.size());
		String ref2 = list.get(1);
		System.out.println("2nd window ref: "+ref2);
		//Switch to window
		driver.switchTo().window(ref2);
		System.out.println("Second Window tite: "+driver.getTitle());
		
		//Taking snapshot
		File sreen = driver.getScreenshotAs(OutputType.FILE);
		File dest = new File("./snaps/snap.png");
		FileUtils.copyFile(sreen, dest);
		
		
		//WAYYYY 2
		
		//For each loop it iterated and finally the window control will be last window.. the below appraoch is to switch to last window
		//This is for last window
		Set<String> secWindow1 = driver.getWindowHandles();
		for(String eachWin: secWindow1)
		{
			System.out.println("both win ref: "+eachWin);
			driver.switchTo().window(eachWin);
		}
		System.out.println("Last Window tite: "+driver.getTitle());
		
		
		//WAYYYY 2- to switch to middle window or particular window
		int i=1;
		Set<String> secWindow2 = driver.getWindowHandles();
		for(String eachWin: secWindow2)
		{
			System.out.println("both win ref: "+eachWin);
			driver.switchTo().window(eachWin);
			if(i==5) {break;}
			i++;
		}
		System.out.println("Last Window tite: "+driver.getTitle());
		
		
		//WAYYYY 3- Using Iterable
		Set<String> secWindow3 = driver.getWindowHandles();
		Iterator<String> iterator = secWindow3.iterator();
		iterator.next();
		System.out.println("First Window: "+driver.getTitle());//-- navigate to 1st one similarly for iteratoring to next using again iterator.next()
		iterator.next();
		System.out.println("Second Window: "+driver.getTitle());
		
		
		//if we need to go to first window means going to parent window
		driver.switchTo().window(firstWindow); //First window ref already stored
		
		//driver.close(); -- it will close the active Window.class so 2 close both window
		driver.quit();
		
		//even after close the 2nd window it wont go to 1st window bcoz the 2nd window has ctrl which is closed so ctrl is gone
		
		//Take snapshot 
		
	}

}
