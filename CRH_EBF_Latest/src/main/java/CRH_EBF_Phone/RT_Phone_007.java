//File Name: RT_Phone_007
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

public class RT_Phone_007 extends CommonFunctions {



	String table, tns[];
	String tlimit, username, pwd, ctotal, Uname, Tv_plan, Internet_plan,
			Phone_plan, current_service;
	int tncount;
	String serAddress, Internet_service, Tv_service, Phone_service,
			str_Browser;

	static String testCaseName, passScrShot;

	public String getTestCaseName() {
		return testCaseName;
	}

	public static String getPassScreenshot() {
		return passScrShot;
	}
	
	public RT_Phone_007() {
		testCaseName = this.getClass().getSimpleName();
		try {
			passScrShot = sheet11.getCell(4, Row_locator_full_scan_validation(testCaseName,inputfile,"Phone")).getContents();
		} catch (BiffException e) {
			logger.info(e.getMessage());
		} catch (IOException e) {
			logger.info(e.getMessage());
		}
	}

	public RT_Phone_007(String s) {
		testCaseName = this.getClass().getSimpleName();
		try {
			passScrShot = sheet11.getCell(4, Row_locator_full_scan_validation(testCaseName,inputfile,"Phone")).getContents();
		} catch (BiffException e) {
			logger.info(e.getMessage());
		} catch (IOException e) {
			logger.info(e.getMessage());
		}
		this.path = s;
		//this.path1 = phone;
		logger.info("add Phone is intialized");
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

/*		File data1 = new File(this.path1);
		WorkbookSettings ws1 = new WorkbookSettings();
		ws1.setLocale(new Locale("er", "ER"));
		Workbook wb1 = Workbook.getWorkbook(data1, ws1);*/

		try {
			String tv = "", inet = "", phone = "";
			Sheet sheet2 = wb.getSheet("Phone");
			String Sheet_name = sheet2.getName();
			Page_Phone="RT_Phone_007_";
			str_Browser = sheet2.getCell(Col_locator_full_scan_input_sheet("Browser", path,Sheet_name), loc).getContents();
			 
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

			String int_plan = tv = sheet2.getCell(15, loc).getContents();
			String int_eqipment = sheet2.getCell(18, loc).getContents();
			String phone_plan = sheet2.getCell(19, loc).getContents();
			inet = sheet2.getCell(12, loc).getContents();
			phone = sheet2.getCell(13, loc).getContents();
			String cost_current_sevice_input = sheet2.getCell(8, loc)
					.getContents();
			if (first == 0) {
				logger.info("trying to open the url");
				driver.manage().window().maximize();
				driver.get(url);
				logger.info("Chek if url opened");
			}
			try {
				if (first == 0)
					firstrun(br,driver, username, pwd,  ctotal, Uname,
							serAddress);
		
			
			
				Thread.sleep(20000);
				
			
			// If Phone is active on the account, select "Upgrade Your Plan"
			click_element(".//*[@value='upgrade_phone']",driver);
			Thread.sleep(2000);
			if ((driver.findElement(By.xpath("//*[@class='button-nav ']/a")).isEnabled())) {
				logger.info("pass1");
				statusTracker(br,driver,"Pass", "For Phone active on the account select Upgrade Your Plan",
						"Phone upgrade your plan check box is selected", "Phone upgrade your plan check box should be selected");
			} else {
				logger.info("fail1");
				statusTracker(br,driver,"Fail", "For Phone active on the account select Upgrade Your Plan",
						"Phone upgrade your plan check box is not selected", "Phone upgrade your plan check box should be selected");
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
			
			//Select Continue Button so that User navigates to the Phone Select a Plan page.
			click_element("//*[@class='button-nav ']/a",driver);
			statusTracker(br,driver,"Pass", "click on Continue button","'Continue button is clicked", "should click continue button");
			Thread.sleep(8000);
			
			
			
			// Validating if user has navigated to Phone Select a plan page
			if (return_text(".//*[@class='left']/h2",driver).trim().equals("Choose Your Phone Plan"))
				statusTracker(br,driver,"Pass",
						"Click the Continue Button",
						"User is navigated to the Phone Configuration page",
						"User should navigate to the Phone Configuration page.");
			else
				statusTracker(br,driver,"Fail",
						"Click the Continue Button",
						"User is NOT navigated to the Phone Configuration page",
						"User should navigate to the Phone Configuration page.");	
			
			
			
			
			// Validating if Secondary progress bar should display Phone and should be highlighted
			if (return_text(".//*[@class='active']/span",driver).trim().equals("Phone"))
				statusTracker(br,driver,"Pass",
						"Validate the secondary progress bar",
						"Secondary progress bar displays Phone and will be highlighted",
						"Secondary progress bar should display Phone and should be highlighted.");
			else
				statusTracker(br,driver,"Fail",
						"Validate the secondary progress bar",
						"Secondary progress bar will not display Phone and will not be highlighted",
						"Secondary progress bar displays Phone and will be highlighted");	
			
	 		 // CLick on Plan to expand plan info
			
			driver.findElement(By.xpath(".//*[@data-enrichedname='Home Phone National']/li[2]/h3")).click();
			//driver.findElement(By.xpath(".//*[@class='checkout-plans']/div[2]/div/div/div/div/header/ul/li[2]/h3")).click();
	
			Thread.sleep(8000);
			if (return_text(".//*[@class='rtf']/p[2]",driver).trim().equals("Here’s what you get:"))
			//if (return_text(".//*[@class='checkout-plans']/div/div/section/div/div[2]/div/p[2]",driver).trim().equals("Here’s what you get:"))
				statusTracker(br,driver,"Pass",
						"Click on the plan to display plan info",
						"On expand plan info is displayed",
						"On expand plan info should be displayed");
			else
				statusTracker(br,driver,"Fail",
						"Click on the plan to display plan info",
						"On expand plan info is not displayed",
						"On expand plan info should be displayed");			 
				 
				
//Current Services module is closed and displays price in $
				 
				 
				 String CurrSer =driver.findElement(By.xpath(".//*[@class='price last']/sup")).getText();
				 logger.info("price is");  
				 logger.info(CurrSer);
				 logger.info("Testing........01");
				    String strfind="$";
				    int iSuccess = CurrSer.indexOf(strfind);
				    logger.info("",iSuccess);
				    
				    if(iSuccess<0)
					    {
					    logger.info("price is not present");
					    statusTracker(br,driver,"Fail", "$ sign present in current service monthly charges", "$ not present", "$ should be present");
					    }

				    else
					    {
					    logger.info("$ present");
					    statusTracker(br,driver,"Pass", "$ sign present in current service monthly charges", "$ present", "$ should be present");
					    }	


					    int iStartAmount= iSuccess+1;
					    String per= " ";


					    int iSpace=CurrSer.indexOf(per);
					    int iEndAmount=iSpace-1;
					    logger.info("",iSpace);
					 
					    String sAmount = CurrSer.substring(1,CurrSer.length());
						   logger.info("s amount" +sAmount);
						    
					  
					    
					    if(sAmount.equals(ctotal))
						    {
						    logger.info("Pass");
						    statusTracker(br,driver,"Pass", "current service monthly charges should match as per the user", "Amount matches", "Amount should match");
						    }	
					    
					    else
						    {
						    logger.info("Fail");
						    statusTracker(br,driver,"Fail", "current service monthly charges should match as per the user", "Amount doesnt match", "Amount should match");
						    }
					    
					    
					    
			             // Current services expand
					    click_element(".//*[@class='miniCart']/div/header/ul/li[2]/a",driver);
						 
	                    logger.info(" price read");
	                    logger.info("validating sequence of LOB under current services");
	 
	 
					  //validating sequence of LOB under current services
	                    String CurrSer1 =driver.findElement(By.xpath(".//*[@class='collapsible js-expander-initialized']/header/ul/li[2]/h6")).getText();
					//String CurrSer1 =driver.findElement(By.xpath(".//*[@class='miniCart']/div/section/div[1]/header/ul/li[2]/h6")).getText();
					
							   
							   if ((CurrSer1.equalsIgnoreCase("Phone")))
								  
								   {
									   logger.info("Right sequence");
									   statusTracker(br,driver,"Pass", "current sequence matches TV - Internet - Phone", "Sequence matches", "Sequence should match");
								   }
								   else
								   {
									   logger.info("Wrong sequence");
									   statusTracker(br,driver,"Fail", "current sequence matches TV Internet Phone", "Sequence does not match", "Sequence should match");
									   
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
							   
							   
           
							   
				//Tv expand			   
			   click_element(".//*[@class='miniCart']/div/section/div[1]/header/ul/li[2]/h6",driver);
			   Thread.sleep(4000);
			   logger.info("");
							   
		    // TV - Preferred tv
			String PhoneServ=driver.findElement(By.xpath(".//*[@class='miniCart']/div/section/div[1]/section/div/ul/li[1]")).getText();
							   if (PhoneServ.compareTo(Phone_service)!=0)
							   {
								   logger.info("Phone service is same as sheet");
								   statusTracker(br,driver,"Pass", "phone service is same as sheet", "Service matches", "Service should match");
								}
							   else
							   {
								   statusTracker(br,driver,"fail", "phone service is same as sheet", "Service does not match", "Service should match");   
							   }
							  			 
			//Phone collapse
			click_element(".//*[@class='miniCart']/div/section/div[1]/header/ul/li[2]/h6",driver);
			logger.info("mini cart collapse");
			Thread.sleep(4000);
							   
		/*			
			
			
			
			// Internet - Standard Internet			   
			String InternetServ=driver.findElement(By.xpath(".//*[@class='miniCart']/div/section/div[2]/section/div/ul/li[1]")).getText();
							   if (InternetServ.compareTo(Internet_service)!=0)
							   {
								   logger.info("Internet service is same as sheet");
								   statusTracker(br,driver,"Pass", "Internet service is same as sheet", "Service matches", "Service should match");
								}
							   else
							   {
								   statusTracker(br,driver,"fail", "Internet service is same as sheet", "Service does not match", "Service should match");   
							   }
							   
		   //close dropdown
		   click_element(".//*[@class='miniCart']/div/section/div[2]/header/ul/li[2]/h6",driver);
		   Thread.sleep(4000);		
		   
		   
		   
		 //Phone expand    
			click_element(".//*[@class='miniCart']/div/section/div[3]/header/ul/li[2]/h6",driver);
			Thread.sleep(4000);
			
			// Phone - Standard Internet			   
			String PhoneServ=driver.findElement(By.xpath(".//*[@class='miniCart']/div/section/div[3]/section/div/ul/li[1]")).getText();
							   if (PhoneServ.compareTo(Phone_service)!=0)
							   {
								   logger.info("Phone service is same as sheet");
								   statusTracker(br,driver,"Pass", "Phone service is same as sheet", "Service matches", "Service should match");
								}
							   else
							   {
								   statusTracker(br,driver,"fail", "Phone service is same as sheet", "Service does not match", "Service should match");   
							   }
							   
		   //close dropdown Phone
		   click_element(".//*[@class='miniCart']/div/section/div[3]/header/ul/li[2]/h6",driver);
		   Thread.sleep(4000);
		   
		   */
		  
		   //Verify that all Phone plans available in the market display for the new Phone customer
		   logger.info("validating Phone plans");

		   if ((driver.findElement(By.xpath("//*[@data-enrichedname='Home Phone National']/li[2]/h3")).isDisplayed()))
		   {
				logger.info("Phone Plan Present");
				statusTracker(br,driver,"Pass", "Phone Plan Present and in correct order in new Phone customer", "Phone Plan Present", "Phone Plan should be Present");
												   
			}
			else
			{
				logger.info("Phone plan not present");
				statusTracker(br,driver,"fail", "Phone Plan not Present and in correct order in new Phone customer", "Phone Plan not Present", "Phone Plan should be Present");
			}
		   
	
           		// Select Phone Plan		   
				click_element(".//*[@analyticsname='select phone:1:1:select']",driver);
				Thread.sleep(4000);
                
				// Customize page 
				if(driver.findElement(By.xpath("//*[@class='left']/h2")).getText().equalsIgnoreCase("Customize Your Phone Service"))
				{   
			    logger.info("Customization page opens");
				statusTracker(br,driver,"Pass","it opens phone customization page", "it opens phone customization page", "it should open phone customization page");
				}
				else
					{   
					logger.info("customization page does not open");
				    statusTracker(br,driver,"fail","it does not open phone customization page", "it does not open phone customization page", "it should open phone customization page");
							   }
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

}
