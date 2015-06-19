//File Name: RT_Phone_001
//Author: Rahul Jadow
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
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;

public class RT_Phone_001 extends CommonFunctions {

	

	String table, tns[];
	String tlimit, username, pwd, ctotal, Uname, Tv_plan, Internet_plan,
			Phone_plan, current_service;
	int tncount;
	String serAddress, Internet_service, Tv_service, Phone_service,
			str_Browser;

	public RT_Phone_001() {
	}

	public RT_Phone_001(String s) {
		this.path = s;
		//this.path1 = phone;
		logger.info("add Phone is intialized");
	}

	public void execute(String br,WebDriver driver,String url, int loc)throws Exception {
		int screen_count = 1;
		File data = new File(this.path);
		WorkbookSettings ws = new WorkbookSettings();
		ws.setLocale(new Locale("er", "ER"));
		//arrcount = 0;
		logger.info("chheck");
		Workbook wb = Workbook.getWorkbook(data, ws);
		
/*		File data1 = new File(this.path1);
		WorkbookSettings ws1 = new WorkbookSettings();
		ws1.setLocale(new Locale("er", "ER"));
		Workbook wb1 = Workbook.getWorkbook(data1, ws1);*/

		try {
			String tv = "", inet = "", phone = "";
			Sheet sheet2 = wb.getSheet("Phone");
			Page_Phone="RT_Phone_001_";
			String Sheet_name = sheet2.getName();
			
			str_Browser = sheet2.getCell(Col_locator_full_scan_input_sheet("Browser", path,Sheet_name), loc).getContents();
			logger.info("chheckme");
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
		
			Page_TV = " Page_1_Current Service ";

			
			
			if (first == 0) {
				logger.info("trying to open the url");
				driver.manage().window().maximize();
				driver.get(url);
				logger.info("Check if url opened");
			}
			try {
				if (first == 0)
					firstrun(br,driver, username, pwd, ctotal, Uname,
							serAddress);

			
				//validationofTWClogo
				Phone_TWClogo(br,driver);
				Thread.sleep(8000);
				
				//Validation of User Name
				Phone_Username(br,driver,loc);
				Thread.sleep(8000);
				
			
		

				// Validation of current service monthly charge and $ sign
				String CurrSer = driver
						.findElement(
								By.xpath("//*[@class='sub-header black-header']/span"))
						.getText();
				logger.info(CurrSer);
				String strfind = "$";
				int iSuccess = CurrSer.indexOf(strfind);
				logger.info("",iSuccess);

				if (iSuccess == 0) {
					logger.info("$ not present");
					statusTracker(br,driver,
							"Fail",
							"$ sign present in current service monthly charges",
							"$ not present", "$ should be present");
				}

				else {
					logger.info("$ present");
					statusTracker(br,driver,
							"Pass",
							"$ sign present in current service monthly charges",
							"$ present", "$ should be present");
				}

				int iStartAmount = iSuccess + 1;
				String per = "per";

				int iSpace = CurrSer.indexOf(per);
				int iEndAmount = iSpace - 1;
				logger.info("",iSpace);

				String sAmount = CurrSer.substring(iStartAmount, iEndAmount);
				logger.info(ctotal);
				logger.info(sAmount);

				if (sAmount.equals(ctotal)) {
					logger.info("Pass");
					statusTracker(br,driver,
							"Pass",
							"Current service monthly charges should match as per the user",
							"Amount matches", "Amount should match");
				}

				else {
					logger.info("Fail");
					statusTracker(br,driver,
							"Fail",
							"Current service monthly charges should match as per the user",
							"Amount doesnt match", "Amount should match");
				}

				// Validation of continue button (disabled)
				if (driver.findElement(
						By.xpath("//*[@class='button-nav ']/a")).isEnabled()) {
					logger.info("Pass");
					statusTracker(br,driver,"Pass", "Continue button on service page",
							"Disabled", "should be disabled");
					
				} else {
					logger.info("Fail");
					statusTracker(br,driver,"Fail", "Continue button on service page",
							"Enabled", "Should be disabled");
				}

				
				Thread.sleep(2000);
				
				//Verify TV_LOB
				//Tv_Internet_lob_verify(br,driver);
				Thread.sleep(5000);
				
	
				

				//Upgrade Phone
				
				driver.findElement(By.xpath(".//*[@name='upgrade_phone']")).click();
				Thread.sleep(2000);
				statusTracker(br,driver,"Pass", "user Clicks upgrade Phone Option ", "Clicked", "Should be clicked");
			
					if ((driver.findElement(By.xpath("//*[@class='button-nav ']/a")).isEnabled())) 
					{logger.info("pass1");
					 statusTracker(br,driver,"Pass","Continue button on service page","Enabled", "should be enabled");
					} else 
					{logger.info("fail1");
					 statusTracker(br,driver,"Fail","Continue button on service page","Disabled", "should be enabled");
					}
				
				driver.findElement(By.xpath("//*[@class='button-nav ']/a")).click();
				logger.info("clicked continue button on page 1");
				Thread.sleep(8000);
				
				logger.info("Simply Click");

				if(return_text(".//*[@class='left']", driver).equalsIgnoreCase("Choose Your Phone Plan"))
				{
					statusTracker(br,driver,"Pass", "Validate the CTA button is active and selectable to continue to the next page", "Active and clickable", "Should be Active and clickable");
				}
				else
				{statusTracker(br,driver,"Fail", "Validate the CTA button is active and selectable to continue to the next page", "It is not Active and clickable", "Should be Active and clickable");
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

				
				logger.info("End of test case1");
				
				Thread.sleep(3000);
				driver.findElement(By.linkText("Sign Out")).click();
				Thread.sleep(10000);
				driver.quit();
				
				
				
			}	
				

			catch (Exception e) {
				exceptionHandler(br,e, driver);
				logger.info("error is : " + e.getMessage());
			}
		} catch (Exception e) {
			exceptionHandler(br,e, driver);

		} finally {
			wb.close();	
			driver.close();

		}
	}

	private void Phone_Username(WebDriver driver, String uname2) {
		
		
	}

}
