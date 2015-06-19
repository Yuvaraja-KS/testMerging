//File Name: RT_Phone_011
//Author: Shikha Singh
//Description of test case: Customer is eligible to upgrade Phone LOB
//Date of creation(D/M/Y): 11/3/2014
//Name and date(D/M/Y) of modification: Pradeep Shetty / 9/6/2014
//Modification description:
//  a) change the all the xpath’s to unique property 
//  b) Removed all the unwanted print statements & comments.
//  c) Added comments to the steps wherever needed.
//  d) Updated Status tracked if change needed
//  e) Updated as per jagdeesh@Buyflow review comments

package CRH_EBF_Phone;

import com.thoughtworks.selenium.Selenium;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.io.File;
import java.io.PrintStream;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import org.apache.bcel.generic.Select;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;



public class RT_Phone_011 extends CommonFunctions{
	
	

    String table, tns[];
    String tlimit,username,pwd,ctotal,Uname,Tv_plan,Internet_plan,Phone_plan,current_service;
    int tncount;
	String serAddress, Internet_service,Tv_service,Phone_service;
	
	public RT_Phone_011() {
	}

	public RT_Phone_011(String s) {
		this.path = s;
	//	this.path1 = internet;
		logger.info("add phone is intialized");
	}

	public void execute(String br,WebDriver driver,String url, int loc)throws Exception {
		// logger.info("execute is called");
				int screen_count = 1;		
				File data = new File(this.path);
				WorkbookSettings ws = new WorkbookSettings();
				ws.setLocale(new Locale("er", "ER"));
				//arrcount = 0;
				logger.info("chheck1");
				Workbook wb = Workbook.getWorkbook(data, ws);
		
				/*File data1 = new File(this.path1);
				WorkbookSettings ws1 = new WorkbookSettings();
				ws1.setLocale(new Locale("er", "ER"));
				Workbook wb1 = Workbook.getWorkbook(data1, ws1);
*/
			    try {
			    Page_Phone="RT_Phone_011_";
			    String tv = "", inet = "", phone = "";
				Sheet sheet2 = wb.getSheet("Phone");

				String Sheet_name = sheet2.getName();
				 
				username = sheet2.getCell(Col_locator_full_scan_input_sheet("USERNAME", path,Sheet_name), loc).getContents();
				pwd = sheet2.getCell(Col_locator_full_scan_input_sheet("PASSWORD", path,Sheet_name), loc).getContents();
				ctotal = sheet2.getCell(Col_locator_full_scan_input_sheet("C-TOTAL", path,Sheet_name), loc).getContents();
				Uname = sheet2.getCell(Col_locator_full_scan_input_sheet("ACCOUNT NAME", path,Sheet_name), loc).getContents();
				serAddress = sheet2.getCell(Col_locator_full_scan_input_sheet("SERVICE ADDRESS", path,Sheet_name), loc).getContents();
				Tv_service = sheet2.getCell(Col_locator_full_scan_input_sheet("TV SERVICE", path,Sheet_name), loc).getContents();
				Internet_service = sheet2.getCell(Col_locator_full_scan_input_sheet("INTERNET SERVICE", path,Sheet_name), loc).getContents();
				Phone_service = sheet2.getCell(Col_locator_full_scan_input_sheet("PHONE SERVICE", path,Sheet_name), loc).getContents();
				Tv_plan = sheet2.getCell(Col_locator_full_scan_input_sheet("TV PLAN", path,Sheet_name), loc).getContents();
				Internet_plan = sheet2.getCell(Col_locator_full_scan_input_sheet("INTERNET PLAN", path,Sheet_name), loc).getContents();
				Phone_plan = sheet2.getCell(Col_locator_full_scan_input_sheet("PHONE PLAN", path,Sheet_name), loc).getContents();

				

			if(first==0)
				{
				   logger.info("trying to open the url");
				   driver.manage().window().maximize();
				   driver.get(url);
				   logger.info("Chek if url opened");
				   
				}

		try 
				{
			      if(first==0)
				  firstrun(br,driver,username,pwd,ctotal,Uname,serAddress);
				  logger.info("I went to next step");
				  Thread.sleep(8000);
				  
				  JavascriptExecutor jse = (JavascriptExecutor)driver;
				  jse.executeScript("scroll(0, 250)"); //y value '250' can be altered

				 // Internet_Phone_lob_verify(br,driver);
				  Phone_lob_click(br,driver);
				  
				  click_element("//*[@class='button-nav ']/a", driver);
				  Thread.sleep(8000);
				  click_element("//*[@class='checkoutCTA']/a", driver);
				  Thread.sleep(8000);
				  
				 // driver.findElement(By.xpath(".//*[@class='content-wrap']/div[9]/a")).click();
				  
				  Thread.sleep(3000);
//section displayed
					  if(return_text("//*[@class='text parbase twc-plain-text optionsHeader']", driver).trim().equalsIgnoreCase("Chose one of the following options:"))
					  {statusTracker(br,driver,"Pass", " Validate that Select New or Transfer Phone number  section displays", "Select New or Transfer Phone number section displayed", "Select New or Transfer Phone number section should  be displayed");
					  }
					  else
					  {statusTracker(br,driver,"Fail", " Validate that Select New or Transfer Phone number  section displays", "Select New or Transfer Phone number section not displayed", "Select New or Transfer Phone number section should  be displayed");
					  }
				  Thread.sleep(4000);
				  
//New number and existing number check	
				  			if(driver.findElement(By.xpath(".//*[@class='selectOrTransfer phoneNumberSelect']/div/section/div/form")).isDisplayed())
					  		{
						  	if(return_text(".//*[@for='js-phoneNumber-new']", driver).trim().equalsIgnoreCase("I would like a new phone number."))
						  	{	  
							  if(driver.findElement(By.xpath(".//*[@for='js-phoneNumber-transfer']")).isDisplayed())
							  {
								  statusTracker(br,driver,"Pass", "Validate that Select New or Transfer Phone number  section displays", "Select New or Transfer Phone number  section displays", "Select New or Transfer Phone number  section should displays");
							  }
							  else
							  {statusTracker(br,driver,"Fail", "Validate that Select New or Transfer Phone number  section displays", "Select New or Transfer Phone number  section is not displayed", "Select New or Transfer Phone number  section should displays");
							  }
						  	}				  
					  		}			  
							
						
							if(url.contains("beta"))
              					 
              				 {String env ="Beta";
              				Image_compare(br,env,Page_Phone,spath,screen_count,driver);

              				Thread.sleep(15000);
              				logger.info("Beta Environment");
              				 }
              				 else
              				 {
              					 String env ="Prod";
              					Image_compare(br,env,Page_Phone,spath,screen_count,driver);

              				Thread.sleep(15000);
              				logger.info("Prod Environment");
              				
              				 }
							screen_count++;		
				  	
				  		//New number option selected & select continue	
		            click_element(".//*[@for='js-phoneNumber-new']", driver);
		            statusTracker(br,driver,"Pass", "Validate that Select New or Transfer Phone number  section is selected", "Select New or Transfer Phone number  section", " New or Transfer Phone number  section should be selected");
		            
		    		Thread.sleep(5000);
		   
			           /* if(driver.findElement(By.xpath(".//*[@class='customer-authorization']")).isDisplayed())
			            {statusTracker(br,driver,"Paas", "The user is prompted to go to the next section, Authorization section", "The user is prompted to go to the next section", "The user shpuld be prompted to go to the next section.");
						}
						else
						{statusTracker(br,driver,"Fail", "The user is prompted to go to the next section, Authorization section", "The user is not prompted to go to the next section, Authorization section", "The user should be prompted to go to the next section.");
						}*/
			            
		                
		Thread.sleep(3000);
		statusTracker(br,driver,"Pass", "Validate that Select New or Transfer Phone number  section displays", "Select New or Transfer Phone number  section displays", "Select New or Transfer Phone number  section should displays");
		
	
		if(url.contains("beta"))
				 
			 {String env ="Beta";
			 Image_compare(br,env,Page_Phone,spath,screen_count,driver);

			Thread.sleep(15000);
			logger.info("Beta Environment");
			 }
			 else
			 {
				 String env ="Prod";
				 Image_compare(br,env,Page_Phone,spath,screen_count,driver);

			Thread.sleep(15000);
			logger.info("Prod Environment");
			
			 }
		screen_count++;
		
		
		
		
		if (Isavailable(".//*[@class='js-next-button blue-button right']/span", driver))
			
			statusTracker(br,driver,"Pass",
					"Click on the Sign out button",
					"Customer is Logged Out from the current session.",
					"Customer should Log Out.");
		else
			statusTracker(br,driver,"Fail",
					"Click on the Sign out button",
					"Customer is NOT Logged Out from the current session.",
					"Customer should Log Out.");
		
		  driver.findElement(By.linkText("Sign Out")).click();
			 Thread.sleep(15000);
		
		          driver.quit();
		   
				}
		
					catch (Exception e)
				    {
				                  exceptionHandler(br,e,driver);
				                  logger.info("error is : "+e.getMessage());
				     }
				    }
				    catch (Exception e)
				    {
				                exceptionHandler(br,e, driver);
				      
				    }
				    finally {
				      wb.close();
				     
				      driver.close();
				     
				    }
				  }
}
