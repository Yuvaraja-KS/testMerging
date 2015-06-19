//File Name: RT_Phone_009
//Author: Shikha Singh
//Description of test case: Customer is eligible to upgrade Phone LOB
//Date of creation(D/M/Y): 11/3/2014
//Name and date(D/M/Y) of modification: Pradeep Shetty / 5/6/2014
//Modification description:
//  a) change the all the xpath’s to unique property 
//  b) Removed all the unwanted print statements & comments.
//  c) Added comments to the steps wherever needed.
//  d) Updated Status tracked if change needed


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
import java.io.IOException;
import java.io.PrintStream;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import org.apache.bcel.generic.Select;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.read.biff.BiffException;

public class RT_Phone_009 extends CommonFunctions{
	
	

    String table, tns[];
    String tlimit,username,pwd,ctotal,Uname,Tv_plan,Internet_plan,Phone_plan,current_service;
    int tncount;
	String serAddress, Internet_service,Tv_service,Phone_service;

	static String testCaseName, passScrShot;

	public String getTestCaseName() {
		return testCaseName;
	}

	public static String getPassScreenshot() {
		return passScrShot;
	}
	
	public RT_Phone_009() {
		testCaseName = this.getClass().getSimpleName();
		try {
			passScrShot = sheet11.getCell(4, Row_locator_full_scan_validation(testCaseName,inputfile,"Phone")).getContents();
		} catch (BiffException e) {
			logger.info(e.getMessage());
		} catch (IOException e) {
			logger.info(e.getMessage());
		}
	}

	public RT_Phone_009(String s) {
		testCaseName = this.getClass().getSimpleName();
		try {
			passScrShot = sheet11.getCell(4, Row_locator_full_scan_validation(testCaseName,inputfile,"Phone")).getContents();
		} catch (BiffException e) {
			logger.info(e.getMessage());
		} catch (IOException e) {
			logger.info(e.getMessage());
		}
		this.path = s;
		//this.path1 = internet;
		logger.info("add phone is intialized");
	}

	public void execute(String br,WebDriver driver,String url, int loc)throws Exception {
	
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
				Workbook wb1 = Workbook.getWorkbook(data1, ws1);*/

			    try {
			    Page_Phone="RT_Phone_009_";
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
				   //statusTracker(br,driver,"Pass", " ", " ", " ");
				}
			try 
			{
		      if(first==0)
			  firstrun(br,driver,username,pwd,ctotal,Uname,serAddress);
			  logger.info("I went to next step");
			  Thread.sleep(9000);
			  //Internet_Phone_lob_verify(br,driver);
			  Phone_lob_click(br,driver);
			  
			  click_element("//*[@class='button-nav ']/a", driver);
			  Thread.sleep(9000);
			  click_element("//*[@class='checkoutCTA']/a", driver);
			  Thread.sleep(9000);
			  
			  
//Validate Feature section: is displayed
			  if(driver.findElement(By.xpath(".//*[@class='phoneSelectTable selectTable']/div/section/div")).isDisplayed())
			  {statusTracker(br,driver,"Pass","Validate that a features section displays", "Features section displayed", "Features section should get displayed");
			  }
			  else
			  {statusTracker(br,driver,"Fail","Validate that a features section displays", "Features section not displayed", "Features section should get displayed");
			  }
			  
//Validate Feature addons: offers
			 
			  if(return_text("//*[@class='content-wrap']/div[3]/header/ul/li[2]/h3", driver).trim().equalsIgnoreCase("Private Listing") & return_text("//*[@id='content']/div[3]/div[2]/div/div[2]/div/div[2]/div/div/div[1]/div/section/div/div[4]/header/ul/li[2]/h3", driver).trim().equalsIgnoreCase("Voicemail"))
			  {statusTracker(br,driver,"Pass", "Validate that Phone Add Ons  in the Phone Features section display", "Is Displayed", "Should be displayed");
			  }
			  else
			  {statusTracker(br,driver,"Pass", "Validate that Phone Add Ons in the Phone Features section display", "Is not Displayed", "Should be displayed");
			  }
			  
			  
			  
			  if(return_text("//*[@class='content-wrap']/div[3]/header/ul/li[2]/h3", driver).trim().equalsIgnoreCase("Private Listing"))
			  {
				  if(driver.findElement(By.xpath(".//*[@class='content-wrap']/div[3]/header/ul/li[3]")).isDisplayed() & return_text("//*[@class='content-wrap']/div[3]/header/ul/li[3]/span", driver).trim().equalsIgnoreCase("per Month"))
				  {
					  if(!driver.findElement(By.xpath(".//*[@class='content-wrap']/div[3]/header/ul/li[4]/label/input")).isSelected())
					  {statusTracker(br,driver,"Pass", " Private Listing add on with monthly price,duration and Checkbox is displayed in the Phone Features section of the page", "Is present", "Should be present");
					  }
					  else
					  {statusTracker(br,driver,"Fail", " Private Listing add on with monthly price,duration and Checkbox is displayed in the Phone Features section of the page", "Is not present", "Should be present");
					  }
				  }
			  }
			  
			  if(return_text("//*[@class='content-wrap']/div[4]/header/ul/li[2]/h3", driver).trim().equalsIgnoreCase("Voicemail"))
			  {
				  if(driver.findElement(By.xpath("//*[@class='content-wrap']/div[4]/header/ul/li[3]")).isDisplayed() & return_text("//*[@class='content-wrap']/div[4]/header/ul/li[3]/span", driver).trim().equalsIgnoreCase("per Month"))
				  {
					  if(!driver.findElement(By.xpath(".//*[@class='content-wrap']/div[4]/header/ul/li[4]/label/input")).isSelected())
					  {statusTracker(br,driver,"Pass", " Voicemail add on with monthly price,duration and Checkbox is displayed in the Phone Features section of the page", "Is present", "Should be present");
					  }
					  else
					  {statusTracker(br,driver,"Fail", " Voicemail add on with monthly price,duration and Checkbox is displayed in the Phone Features section of the page", "Is not present", "Should be present");
					  }
				  }
			  }
			  
	//click Privatelistening		  
			  click_element("//*[@class='content-wrap']/div[3]/header/ul/li[1]/a", driver);
			  Thread.sleep(2000);
	//Show more: private listening
			  if(driver.findElement(By.xpath(".//*[@class='content-wrap']/div[3]/section/div/div/p[2]")).isDisplayed())
			  {statusTracker(br,driver,"Pass", " Validate the user can expand the Private Listing section for a more detailed description", "Detailed information displayed", "Should be displayed");
			  }
			  else
			  {statusTracker(br,driver,"Fail", "Validate the user can expand the Private Listing section for a more detailed description", "Detailed information not displayed", "Should be displayed");
			  }
			  click_element("//*[@class='content-wrap']/div[3]/header/ul/li[1]/a", driver);
			  Thread.sleep(2000);
	//click voicemail		  
			  click_element("//*[@class='content-wrap']/div[4]/header/ul/li[1]/a", driver);
			  Thread.sleep(2000);
	//Show more: voicemail
			  if(driver.findElement(By.xpath(".//*[@class='content-wrap']/div[4]/section/div/div/p[2]")).isDisplayed())
			  {statusTracker(br,driver,"Pass", " Validate the user can expand the Voicemail section for a more detailed description", "Detailed information displayed", "Should be displayed");
			  }
			  else
			  {statusTracker(br,driver,"Fail", "Validate the user can expand the Voicemail section for a more detailed description", "Detailed information not displayed", "Should be displayed");
			  }
				
			  click_element("//*[@class='content-wrap']/div[4]/header/ul/li[1]/a", driver);
			  Thread.sleep(2000);
			  
			  
			  
			  
//checked: PrivateListening			  
			  click_element(".//*[@class='content-wrap']/div[3]/header/ul/li[4]/label/input", driver);
			  statusTracker(br,driver,"", "Private Listing Selected", "", "");
			  Thread.sleep(6000);
//CartCheck
			  config_page_Cart_result_updater_1(br,driver);
			 
			  page_Cart_One_Time_charge_updater_1(br,driver);
			  
//Unchecked: PrivateListening	
			  logger.info("Selected");
			 driver.findElement(By.xpath(".//*[@class='content-wrap']/div[3]/header/ul/li[4]/label/input")).click();
			  Thread.sleep(6000);
			  
			  
			
//checked: VoiceMail			  
			  click_element(".//*[@class='content-wrap']/div[4]/header/ul/li[4]/label/input", driver);
			  statusTracker(br,driver,"", "Voicemail Selected", "", "");
			   Thread.sleep(6000);
//CartCheck
			  config_page_Cart_result_updater_1(br,driver);
			  page_Cart_One_Time_charge_updater_1(br,driver);
//Unchecked: voiceMail			  
			  click_element(".//*[@class='content-wrap']/div[4]/header/ul/li[4]/label/input", driver);
			  Thread.sleep(6000);
			  
//selected both add ons			  
			  click_element(".//*[@class='content-wrap']/div[3]/header/ul/li[4]/label/input", driver);
			  Thread.sleep(6000);
			  click_element(".//*[@class='content-wrap']/div[4]/header/ul/li[4]/label/input", driver);
			  Thread.sleep(6000);
			  statusTracker(br,driver,"", "Private Listing and Voicemail, Both Selected", "", "");
// cart check
			  config_page_Cart_result_updater_1(br,driver);
			  page_Cart_One_Time_charge_updater_1(br,driver);
			  Thread.sleep(7000);
			
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
			  
			  
			/*  click_element(".//*[@class='content-wrap']/div[9]/a", driver);
			  if(driver.findElement(By.xpath("//*[@class='content-wrap']/form/div[1]")).isDisplayed())
			  {statusTracker(br,driver,"Pass", " Continue to next step button is clicked", "Takes to next section", "Should take to next section");
			  }
			  else
			  {statusTracker(br,driver,"Fail", "Continue to next step button is clicked", "Doesnt Takes to next section", "Should take to next section");
			  }*/
			 
			  
			  
		                
		Thread.sleep(3000);
		driver.findElement(By.linkText("Sign Out")).click();
		Thread.sleep(10000);
		
		if (Isavailable(".//*[@class='twc-last js-last']/a", driver))
			statusTracker(br,driver,"Pass",
					"Click on the Sign out button",
					"Customer is Logged Out from the current session.",
					"Customer should Log Out.");
		else
			statusTracker(br,driver,"Fail",
					"Click on the Sign out button",
					"Customer is NOT Logged Out from the current session.",
					"Customer should Log Out.");
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
