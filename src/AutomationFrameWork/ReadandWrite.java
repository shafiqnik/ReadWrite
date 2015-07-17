/**
 * Simple Selenium automation tool to login to a portal
 * Read credentials from a file
 * Select specific frames
 * Click on tabs
 * Search for a string
 */

package AutomationFrameWork;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertSame;

import org.junit.Test;


public class ReadandWrite {
	
	private static WebDriver driver = null;
	private static WebElement element = null;
	
	private static String uname  = "qatest";
	private static String pword = "test";
	private static String xpath = "/html/body/form/table/tbody/tr[3]/td[2]/table/tbody/tr[3]/td[2]/table/tbody/tr[3]/td[3]/input";
	private static String file = "C:/Temp/asdf.txt";
	
	
	@SuppressWarnings("static-access")
	
	public static void main(String [] args) throws IOException{
		
		
		
		driver = new FirefoxDriver();
	//	System.setProperty("webdriver.Firefox.driver","C:/Program Files (x86)/Mozilla Firefox/firefox.exe");
		website();
	
		
		//click on various tabs
		String[] tabs = {"BeaconMgr", "AcctMgr", "IncidentMgr", "ReportMgr","DealerMgr" };
		for (int i = 0; i<tabs.length; i++){
			selectTab(tabs[i]);
		}
		
		searchBeacon("1234"); 
		
	    List mylist = new ArrayList();
		String str = driver.getPageSource();
		
		mylist.add(str);   //not needed
		
						
				
				
		if(str.equals("Partner Portal")){
			System.out.println("yessss");
			
		}
		else
		{
			System.out.println("not equal");
		}
		
		Assert.assertFalse(str, false);
		
	}
	

	
public static void website() throws IOException{
	
	
	ReadFile rf = new ReadFile(file);
	int command = rf.readLines();
	
	//load credientials from a text file	
	String website = rf.myRead().get(0).toString();
	String uname = rf.myRead().get(1).toString();  //gets the user name from the file
	String pword = rf.myRead().get(2).toString();  //gets the password fromt the file.
	
	
	
	driver.get(website);
	
	 wait(10);
	
	 driver.findElement(By.name("uname")).sendKeys(uname);
	 wait(5);
	 driver.findElement(By.name("pword")).sendKeys(pword);
	 driver.findElement(By.xpath(xpath)).click();
	
	
}



//wait for i number of seconds
public static void wait(int i){
	
	driver.manage().timeouts().implicitlyWait(i, TimeUnit.SECONDS);
	
}


//Finds items by their tagName 
public static void findTag(String s){
	
	List<WebElement> links = driver.findElements(By.tagName(s));
	int noButton = links.size();
	System.out.println("list of tags "+noButton);
	
	if(noButton>0){
		for(WebElement link:links)
			System.out.println(link.getText());
	}
	
}

//this method returns NullPointException
public static void findById(String myid){
	
	try{
		List<WebElement> label = element.findElements(By.id(myid));
	
		int noLabel = label.size();
		if(noLabel == 0){
			System.out.println("no label = 0");
		}
		else{
		
			System.out.println("no label is not 0 "+myid);
		
		}
	}
	catch(NullPointerException e){
		System.out.println("null point excpetion error");
		
	}
}

	
//find by xpath
public static void findXpath(String s){
	driver.findElement(By.xpath(s));
}




public static int openFile(String s) throws IOException{
	
			ReadFile rf = new ReadFile("C:/Temp/asdf.txt");
			int command = rf.readLines();
			
			System.out.println("arraylist "+rf.myRead().get(0).toString());
			rf.OpenFile();
			return command;
	}




/**selects tabs from Partner Portal and clicks on them.

Beacon Manager tab id = BeaconMgr
Account Manager tab id = AcctMgr
Incident Manager tab id = IncidentMgr
Reports tab  id = ReportMgr
Adminstration tab id = DealerMgr


**/
	
public static void selectTab(String s){
	
	
    if(driver.getPageSource().contains("gmms_main")){
    	
	driver.switchTo().frame(driver.findElement(By.name("gmms_main"))).findElement(By.name(s)).click();
    }
    else
    {
    	
    	driver.findElement(By.name(s)).click();
    }
	
}


//Search for a beacon
public static void searchBeacon(String s){
	
	driver.get("http://beta.dp.contigo.com/customer/main.php");
	driver.switchTo().frame(driver.findElement(By.name("dphead"))).findElement(By.name("searchstr")).sendKeys(s);
	Select dropdown = new Select(driver.findElement(By.name("category")));
	dropdown.selectByValue("beacon");
	driver.findElement(By.xpath("/html/body/table/tbody/tr[4]/td[2]/table/tbody/tr/td[3]/input")).click();
	
}
	



}
