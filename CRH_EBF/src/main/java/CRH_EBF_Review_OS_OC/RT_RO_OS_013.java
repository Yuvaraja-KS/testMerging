//File Name: RT_RO_OS_013
//Author: 
//Description of test case: Order Summary - T&C's - capture date, version, & timestamp
//Date of creation(D/M/Y): 11/3/2014
//Name and date(D/M/Y) of modification: Raveena Singh  09/06/2014

//Name and date(D/M/Y) of modification: RAHUL JADOW (27/6/2014)
//Modification description: Failure updates
 

package CRH_EBF_Review_OS_OC;


import com.thoughtworks.selenium.Selenium;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.text.DateFormat;
import java.text.ParseException;
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

public class RT_RO_OS_013 extends CommonFunctions {



	String table, tns[];
	String tlimit, username, pwd, ctotal, Uname, Tv_plan, Internet_plan,
			Phone_plan, current_service;
	int tncount;
	String serAddress, Internet_service, Tv_service, Phone_service,
			str_Browser;

	public RT_RO_OS_013() {
	}

	public RT_RO_OS_013(String s) {
		this.path = s;
		logger.info("RO & OS 013 is intialized");
	}

	@Override
	public void execute(String br,WebDriver driver, String url, int loc,String Overall_Path,String env) throws Exception {
		int screen_count = 1;
		File data = new File(this.path);
		WorkbookSettings ws = new WorkbookSettings();
		ws.setLocale(new Locale("er", "ER"));
		//arrcount = 0;
		logger.info("chheck1");
		Workbook wb = Workbook.getWorkbook(data, ws);


		try {
			String tv = "", inet = "", phone = "";
			Sheet sheet2 = wb.getSheet("Review_OS_OC");

			String Sheet_name = sheet2.getName();
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
		/*	
			int tv1 = 0, inet1 = 0, phone1 = 0;
			int val = 1;
			int tlim = Integer.parseInt(tlimit);
			tlim *= 60;
			tlimit = Integer.toString(tlim);
			tlimit = tlimit + "000";*/
			Page_TV = " Page_1_Current Service ";
			Page_Phone="RT_RO_OS_013_";

/*
			String int_plan = tv = sheet2.getCell(15, loc).getContents();
			String int_eqipment = sheet2.getCell(18, loc).getContents();
			String phone_plan = sheet2.getCell(19, loc).getContents();
			inet = sheet2.getCell(12, loc).getContents();
			phone = sheet2.getCell(13, loc).getContents();*/
			String cost_current_sevice_input = sheet2.getCell(Col_locator_full_scan_input_sheet("C-TOTAL", path,Sheet_name), loc)
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

			
				
				//Add Internet
				if ((driver.findElement(By.xpath(".//*[@name='select_inet']")).isEnabled())) 
				{
			    click_element(".//*[@name='select_inet']",driver);
				logger.info("Internet Added");
				statusTracker(br,driver,"Pass", "Select checkbox to add Internet as new service",
						"check box is selected", "check box should be selected");
				}
				else
		        {
				logger.info("fail");
				statusTracker(br,driver,"Fail", "Select checkbox to add Internet as new service",
						"check box is not selected", "check box should be selected");
				}
				
				
				
				//Add Phone
				if ((driver.findElement(By.xpath(".//*[@name='select_phone']")).isEnabled())) 
				{
				click_element(".//*[@name='select_phone']",driver);	
				logger.info("Phone Added");
				statusTracker(br,driver,"Pass", "Select checkbox to add Phone as new service",
						"check box is selected", "check box should be selected");
				}
				else
		        {
				logger.info("fail");
				statusTracker(br,driver,"Fail", "Select checkbox to add Phone as new service",
						"check box is not selected", "check box should be selected");
				}
				
				
				//continue  
				click_element(".//*[@class='js-next-button blue-button']",driver);
				Thread.sleep(5000);
						
				// Validating if user has navigated to Internet Select a plan page
				if (return_text(".//*[@class='left']",driver).trim().equals("Choose Your Internet Plan"))
					{
					logger.info("Navigated to Internet Select a plan page");
					statusTracker(br,driver,"Pass",
							"Click the Continue Button",
							"User is navigated to the Internet Configuration page",
				        	"User should navigate to the Internet Configuration page.");
					}
				else{
					statusTracker(br,driver,"Fail",
							"Click the Continue Button",
							"User is NOT navigated to the Internet Configuration page",
							"User should navigate to the Internet Configuration page.");
				
				     }
				
				
				
				// Validating if Secondary progress bar should display Internet and should be highlighted
				if (return_text(".//*[@class='active']/span",driver).trim().equals("Internet"))
				{
					logger.info("Validated Secondary progress bar displayed");
					statusTracker(br,driver,"Pass",
							"Validate the secondary progress bar",
							"Secondary progress bar displays Internet and will be highlighted",
							"Secondary progress bar should display Internet and should be highlighted.");
				}
				else
				{
					statusTracker(br,driver,"Fail",
							"Validate the secondary progress bar",
							"Secondary progress bar will not display Internet and will not be highlighted",
							"Secondary progress bar displays Internet and will be highlighted");	
				}
				
				
				// Select Internet Plan		   
				click_element(".//*[@class='plans']/div[5]/header/ul/li[5]/div/a/span",driver);
				Thread.sleep(8000);
                
				// Customize page 
				if(driver.findElement(By.xpath("//*[@class='left']/h2")).getText().equalsIgnoreCase("Customize Your Internet Plan"))
				{   
			    logger.info("Customization page opens");
				statusTracker(br,driver,"Pass","it opens phone customization page", "it opens phone customization page", "it should open phone customization page");
				}
				else
					{   
					logger.info("customization page does not open");
				    statusTracker(br,driver,"fail","it does not open phone customization page", "it opens phone customization page", "it should open phone customization page");
				}
				
				
				//Click continue
				click_element(".//*[@class='js-next-button blue-button right']",driver);
				Thread.sleep(4000);	
				
				
				//Select phone
				click_element(".//*[@data-enrichedname='Home Phone National']/li[5]/div/a",driver);
				Thread.sleep(10000);	
				
				//transfer_number_Package(driver);
				//Thread.sleep(12000);
				
				click_element(".//*[@data-shortname='Private Listing']",driver);
				Thread.sleep(10000);
				//Phone Continue to Next step
				click_element(".//*[@class='content-wrap']/div[9]/a",driver);
				logger.info("Continue to Next step");
				Thread.sleep(10000);	

				
				//Radio button - Keep current phone number
				click_element(".//*[@id='js-phoneNumber-transfer']", driver);
				  Thread.sleep(5000);	
				  if(driver.findElement(By.xpath("//*[@class='transfer-number general-form']")).isDisplayed())
							 {
							 statusTracker(br,driver,"Pass", "Transfer number general form gets displayed", "Transfer number general form is displayed", "Transfer number general form should be displayed");
							 }
				  			 else
				  			 { 
							 statusTracker(br,driver,"Fail", "Transfer number general form gets displayed", "Transfer number general form is not displayed", "Transfer number general form should be displayed");
							 }				   
						
				  logger.info("started filling form details");
				  
				  
				// for currentProvider
				// For current-provider-state
				  
				  Select_DropDown(driver, ".//*[@id='currentProvider']", "Blue Casa");
  				  statusTracker(br,driver," ", "Select Current provider", "Selected", "");
  				  
  				  Select_DropDown(driver, ".//*[@id='current-provider-state']", "Florida");
  				  statusTracker(br,driver," ", "Select Current provider State", "Selected", "");
                    
				  
		
			
					
					  			  	
						driver.findElement(By.xpath("//*[@id='phone-number']")).sendKeys("123-876-7678");
						Thread.sleep(2000);
					  	field_statustracker(br,"//*[@id='phone-number']","Enter Phone Number","Phone number is Entered", driver);
					  	Thread.sleep(2000);
					  	driver.findElement(By.id("account-number")).sendKeys("23456745");
					  	Thread.sleep(2000);
					  	field_statustracker(br,"//*[@id='account-number']","Enter Account Number","Account Number is Entered", driver);
					  	Thread.sleep(2000);
					  	driver.findElement(By.id("account-name")).sendKeys("Dani");
					  	field_statustracker(br,"//*[@id='account-name']","Account Name","Account Name is Entered",driver);
					  	Thread.sleep(2000);
					  	driver.findElement(By.id("security-code")).sendKeys("3433");
					  	field_statustracker(br,"//*[@id='security-code']","Enter Security Code","Security Code is Entered", driver);
					  	Thread.sleep(2000);
					  	driver.findElement(By.id("address")).sendKeys("4th cross");
					  	field_statustracker(br,"//*[@id='address']","Enter Address","Address is Entered", driver);
					  	Thread.sleep(2000);
					  	driver.findElement(By.id("apt-type")).sendKeys("#10");
					  	field_statustracker(br,"//*[@id='apt-type']","Enter apt type","Apt Type is Entered", driver);
					  	Thread.sleep(2000);
					  	driver.findElement(By.id("city")).sendKeys("nyc");
					  	field_statustracker(br,"//*[@id='city']","Enter City","City is Entered", driver);
					  	Thread.sleep(2000);
					  	driver.findElement(By.id("zip-code")).sendKeys("23456");
					  	field_statustracker(br,"//*[@id='zip-code']","Enter Zip-Code","Zip Code is Entered", driver);				  	
					  	Thread.sleep(4000);
					  	
					  	
					  	Select_DropDown(driver, ".//*[@id='current-provider-state-billing']", "Idaho");
      				    statusTracker(br,driver," ", "Select Current provider state", "Selected", "");
      				    Thread.sleep(5000);
					  	
				
						
						
					  	
					  	driver.findElement(By.cssSelector("form > div.continue > a")).click();	
					  	Thread.sleep(5000);
					  	logger.info("Continue clicked");
				
					  	
					  //enter first name		  	
					  //select drop down
	    				  
	    				  click_element("//*[@id='tpv-choose-TWC']", driver);
	    				  driver.findElement(By.xpath(".//*[@id='full-name1']")).sendKeys("Account");
	    				  statusTracker(br,driver," ", "First Name", "Entered", "");
	    				  Thread.sleep(2000);
	    				  Select_DropDown(driver, ".//*[@id='birth-month']", "March");
	    				  
	    				  statusTracker(br,driver," ", "Birth-Month", "Selected", "");
	    				  Select_DropDown(driver, ".//*[@id='birth-date']", "11");
	    				  statusTracker(br,driver," ", "Birth-Day", "Selected", "");
	    				  Select_DropDown(driver, ".//*[@id='birth-year']", "1946");
	    				  statusTracker(br,driver," ", "Birth-Year", "Selected", "");
	    				  Thread.sleep(2000);
	    				  driver.findElement(By.xpath(".//*[@id='full-name2']")).sendKeys("Account");
	    				  statusTracker(br,driver," ", "First full name", "Entered", "");
	    				  
	    				  click_element(".//*[@class='arrow']", driver);
	    				  Thread.sleep(10000);
	    				  
				
	
									logger.info("review page");		 
									
									
								/*	//Radio button - Schedule two visits
									if ((driver.findElement(By.xpath(".//*[@id='num-visits2']")).isEnabled())) 
									{
									click_element(".//*[@id='num-visits2']",driver);	
									logger.info("Schedule two visits Radio button selected");
									statusTracker("Pass", "Schedule two visits Radio button selected",
											"check box is selected", "check box should be selected");
									}
									else
							        {
									logger.info("fail");
									statusTracker("Fail", "Schedule two visits Radio button not selected",
											"check box is not selected", "check box should be selected");
									}
										
							*/
									
									
									
						//calender - Internet
									   
	                 		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	                 		Date date = new Date();
	                 	    logger.info("Current Date 1: " + dateFormat.format(date));
	                 		int DD_Value = Integer.parseInt(dateFormat.format(date).substring(3, 5));
	                 		logger.info("DD Value : " + DD_Value);
	                 				   
	                 	select_Firstchoice_Date(br,DD_Value,driver);
						Thread.sleep(9000);
								   
						select_Secondchoice_Date(br,DD_Value,driver);
						Thread.sleep(10000);
								    
					/*			    
				          //calender - Phone 
								    select_Firstchoice_Date1(DD_Value);
								    Thread.sleep(9000);
								    
								    select_Secondchoice_Date1(DD_Value);
								    Thread.sleep(9000);
								   
								  */
				//Review order
								     

								    // RO - Monthly charges                
	                                   String total_monthly_charges=driver.findElement(By.xpath(".//*[@title='Monthly Charges']/tfoot/tr/td[2]")).getText();
	                                   Thread.sleep(8000);
	                                 // RO - One time charges    
	                                   String one_time_charges=driver.findElement(By.xpath(".//*[@title='One Time Charges']/tfoot/tr/td[2]")).getText();    
	                                   Thread.sleep(8000);   
	                                  
						     
	                                   //continue
                                       click_element(".//*[@class='js-next-button blue-button']",driver);
                                       logger.info("Navigated to ORDER SUMMARY PAGE");
                                       Thread.sleep(10000);    
               	
									
                                     //verifying total monthly charges!
                       				logger.info("************************Verifying total monthly charges!**********************");
                       				if(driver.findElement(By.xpath("//*[@class='monthly-charges module']/table/tfoot/tr/td[2]")).getText().equalsIgnoreCase(total_monthly_charges))
                       				{
                       				logger.info("Monthly total matching!");
                       				statusTracker(br,driver,"Pass", "Monthly total matching", "Monthly total matching", "Monthly total should match");
                       				}
                       				else
                       				{
                       				logger.info("Monthly total not matching!");
                       				statusTracker(br,driver,"Fail", "Monthly total not matching", "Monthly total not matching", "Monthly total should match");
                       				 
                       				}
                       				 
                       				
                       				//verifying current one time charges!
                       			      logger.info("************************Verifying current one time charges!**********************");
                       			if(driver.findElement(By.xpath("//*[@title='One Time Charges']/tfoot/tr/td[2]")).getText().equalsIgnoreCase(one_time_charges))
                       			{
                       			logger.info("one_time_charges total matching!");
                       			statusTracker(br,driver,"Pass", "one_time_charges total matching", "one_time_charges total matching", "one_time_charges total should match");
                       			}
                       			else
                       			{
                       			logger.info("one_time_charges total not matching!");
                       			statusTracker(br,driver,"Fail", "one_time_charges total not matching", "one_time_charges total not matching", "one_time_charges total should match");
                       			 
                       			}   		
									
									//Technician Installation option displays - OS
									if (return_text(".//*[@class='mainHeader appointmentTitle']",driver).trim().equals("Installation Details"))
									{
									logger.info("Technician Installation option displays");
									statusTracker(br,driver,"Pass",
											"Technician Installation option displays",
											"Technician Installation option displayed",
								        	"Technician Installation option should be displayed");
									}
								else{
									statusTracker(br,driver,"Fail",
											"Technician Installation option not displayed",
											"Technician Installation option is not displayed",
								        	"Technician Installation option should be displayed");
								        }
									Thread.sleep(5000);
		
						
									//Order summary
									
									{	String Actual_ServiceAddress = "";
									  	String Expected_ServiceAddress = "";
									  	String FirstDateTime = "";
										String SecondDateTime = "";
										//String FirstDateTime1 = "";
									  	logger.info("Calling Package_OrderSummary_DetailsValidation");
									  	
									  	
									  	
									  /*// TV- Internet installation requests display above Phone installation requests	 
										  		if ((return_text(".//*[@class='paragraphMerge installationLOB1']/p/strong[1]",drive).trim()).equals("Internet")
														&& (return_text(".//*[@class='paragraphMerge installationLOB1']/p/strong[2]",drive).trim()).equals("Installation Preferences:")) 
										  		{
													statusTracker(
															"Pass",
															"TV- Internet installation requests display above Phone installation requests",
															"TV- Internet installation requests is display above Phone installation requests",
															"TV- Internet installation requests should be displayed above Phone installation requests");
												} else
													statusTracker(
															"Fail",
															"TV- Internet installation requests is not displayed above Phone installation requests",
															"TV- Internet installation requests is not displayed above Phone installation requests",
															"TV- Internet installation requests should be displayed above Phone installation requests");

												logger.info("First Date & Time : "+ return_text(".//*[@class='paragraphMerge firstVisitSchedule1']/p",drive).replace(":00", "").trim());
												logger.info("Second Date & Time : "+ return_text(".//*[@class='firstVisitSchedule2 paragraphMerge']/p",drive).replace(":00", "").trim());

												
												//Your First Choice

												if ((return_text(".//*[@id='content']/div[3]/div[2]/div[2]/div/div/div/div[2]/div[1]/div[4]/div[1]/div/p/strong",drive).trim()).equals("Your First Choice:"))
														{
													statusTracker(
															"Pass",
															"Order Summary Page - Validation First Install Date & Time Details.",
															"Order Summary Page - Validation First Install Date & Time Details.",
															"First Install Date & Time Details are same, as per the Review Order page");
												} else
													statusTracker(
															"Fail",
															"Order Summary Page - First Install Date & Time Details is not displayed",
															"Order Summary Page - First Install Date & Time Details is not displayed",
															"Order Summary Page - First Install Date & Time Details is not displayed");
												
												
												
                                               //Your Second Choice
												if ((return_text(".//*[@id='content']/div[3]/div[2]/div[2]/div/div/div/div[2]/div[1]/div[4]/div[2]/div/p/strong",drive).trim()).equals("Your Second Choice:"))
												{
											statusTracker(
													"Pass",
													"Order Summary Page - Validation Second Install Date & Time Details.",
													"Order Summary Page - Validation Second Install Date & Time Details.",
													"Second Install Date & Time Details are same, as per the Review Order page");
										} else
											statusTracker(
													"Fail",
													"Order Summary Page - Second Install Date & Time Details is not displayed",
													"Order Summary Page - Second Install Date & Time Details is not displayed",
													"Order Summary Page - Second Install Date & Time Details is not displayed");
												
											
										  	}
										  	
										  	
										  	//Phone installation requests displays below TV- Internet installation requests
										  		if ((return_text(".//*[@class='paragraphMerge installationLOB2']/p/strong[1]",drive).trim()).equals("Phone")
														&& (return_text(".//*[@class='paragraphMerge installationLOB2']/p/strong[2]",drive).trim()).equals("Installation Preferences:")) 
										  		{
													statusTracker(
															"Pass",
															"Phone installation requests displays below TV- Internet installation requests",
															"Phone installation requests displays below TV- Internet installation requests",
															"Phone installation requests should be displayed below TV- Internet installation requests");
												} else
													statusTracker(
															"Fail",
															"Phone installation requests is not displayed below TV- Internet installation requests",
															"Phone installation requests is not displayed below TV- Internet installation requests",
															"Phone installation requests should be displayed below TV- Internet installation requests");
										  	
												logger.info("First Date & Time : "+ return_text(".//*[@class='secondVisitSchedule1 paragraphMerge']/p",drive).replace(":00", "").trim());
												logger.info("Second Date & Time : "+ return_text(".//*[@class='secondVisitSchedule2 paragraphMerge']/p",drive).replace(":00", "").trim());

						*/
									  	if(return_text(".//*[@class='paragraphMerge installationLOB1']/p",drive).trim().contains("Internet"))
										  	
										  	
									  	{
									  	
									  /*	if(return_text(".//*[@id='content']/div[3]/div[2]/div[2]/div/div/div/div[2]/div[1]/h5[1]/div/p",drive).trim().equals("Internet Installation Preferences:"))
										  		{
													statusTracker(
															"Pass",
															"TV- Internet installation requests display above Phone installation requests",
															"TV- Internet installation requests is display above Phone installation requests",
															"TV- Internet installation requests should be displayed above Phone installation requests");
												} else
													statusTracker(
															"Fail",
															"TV- Internet installation requests is not displayed above Phone installation requests",
															"TV- Internet installation requests is not displayed above Phone installation requests",
															"TV- Internet installation requests should be displayed above Phone installation requests");

												logger.info("First Date & Time : "+ return_text(".//*[@class='paragraphMerge firstVisitSchedule1']/p",drive).replace(":00", "").trim());
												logger.info("Second Date & Time : "+ return_text(".//*[@class='firstVisitSchedule2 paragraphMerge']/p",drive).replace(":00", "").trim());
*/
												
												//Your First Choice

												if ((return_text(".//*[@class='paragraphMerge firstVisitSchedule1']/p/strong",drive).trim()).equals("Your First Choice:"))
														{
													statusTracker(br,driver,
															"Pass",
															"Order Summary Page - Validation First Install Date & Time Details.",
															"Order Summary Page - Validation First Install Date & Time Details.",
															"First Install Date & Time Details are same, as per the Review Order page");
												} else
													statusTracker(br,driver,
															"Fail",
															"Order Summary Page - First Install Date & Time Details is not displayed",
															"Order Summary Page - First Install Date & Time Details is not displayed",
															"Order Summary Page - First Install Date & Time Details is not displayed");
												
												
												
                                               //Your Second Choice
												if ((return_text(".//*[@class='firstVisitSchedule2 paragraphMerge']/p/strong",drive).trim()).equals("Your Second Choice:"))
												{
											statusTracker(br,driver,
													"Pass",
													"Order Summary Page - Validation Second Install Date & Time Details.",
													"Order Summary Page - Validation Second Install Date & Time Details.",
													"Second Install Date & Time Details are same, as per the Review Order page");
										} else
											statusTracker(br,driver,
													"Fail",
													"Order Summary Page - Second Install Date & Time Details is not displayed",
													"Order Summary Page - Second Install Date & Time Details is not displayed",
													"Order Summary Page - Second Install Date & Time Details is not displayed");
												
											
										  	
										  	
										  	
										  /*	//Phone installation requests displays below TV- Internet installation requests
										  		if ((return_text(".//*[@id='content']/div[3]/div[2]/div[2]/div/div/div/div[2]/div[1]/h5[2]/div/p/strong[1]",drive).trim()).equals("Phone")
														&& (return_text(".//*[@id='content']/div[3]/div[2]/div[2]/div/div/div/div[2]/div[1]/h5[2]/div/p/strong[2]",drive).trim()).equals("Installation Preferences:")) 
										  		{
													statusTracker(
															"Pass",
															"Phone installation requests displays below TV- Internet installation requests",
															"Phone installation requests displays below TV- Internet installation requests",
															"Phone installation requests should be displayed below TV- Internet installation requests");
												} else
													statusTracker(
															"Fail",
															"Phone installation requests is not displayed below TV- Internet installation requests",
															"Phone installation requests is not displayed below TV- Internet installation requests",
															"Phone installation requests should be displayed below TV- Internet installation requests");
										  	
												logger.info("First Date & Time : "+ return_text(".//*[@class='secondVisitSchedule1 paragraphMerge']/p",drive).replace(":00", "").trim());
												logger.info("Second Date & Time : "+ return_text(".//*[@class='secondVisitSchedule2 paragraphMerge']/p",drive).replace(":00", "").trim());
*/
									  	}
									  	
									  	
									  	
									  	
									  	
									 /* 	else
									  	
										  	if(return_text(".//*[@id='content']/div[3]/div[2]/div[2]/div/div/div/div[2]/div[1]/h5[1]/div/p",drive).trim().equals("Phone Installation Preferences:"))
									  		{
												statusTracker(
														"Pass",
														"Phone installation requests display above Phone installation requests",
														"Phone installation requests is display above Phone installation requests",
														"Phone installation requests should be displayed above Phone installation requests");
											} else
												statusTracker(
														"Fail",
														"Phone installation requests is not displayed above Phone installation requests",
														"Phone installation requests is not displayed above Phone installation requests",
														"Phone installation requests should be displayed above Phone installation requests");

											logger.info("First Date & Time : "+ return_text(".//*[@class='paragraphMerge firstVisitSchedule1']/p",drive).replace(":00", "").trim());
											logger.info("Second Date & Time : "+ return_text(".//*[@class='firstVisitSchedule2 paragraphMerge']/p",drive).replace(":00", "").trim());

											
											//Your First Choice

											if ((return_text(".//*[@class='paragraphMerge firstVisitSchedule1']/p/strong",drive).trim()).equals("Your First Choice:"))
													{
												statusTracker(
														"Pass",
														"Order Summary Page - Validation First Install Date & Time Details.",
														"Order Summary Page - Validation First Install Date & Time Details.",
														"First Install Date & Time Details are same, as per the Review Order page");
											} else
												statusTracker(
														"Fail",
														"Order Summary Page - First Install Date & Time Details is not displayed",
														"Order Summary Page - First Install Date & Time Details is not displayed",
														"Order Summary Page - First Install Date & Time Details is not displayed");
											
											
											
                                           //Your Second Choice
											if ((return_text(".//*[@class='firstVisitSchedule2 paragraphMerge']/p/strong",drive).trim()).equals("Your Second Choice:"))
											{
										statusTracker(
												"Pass",
												"Order Summary Page - Validation Second Install Date & Time Details.",
												"Order Summary Page - Validation Second Install Date & Time Details.",
												"Second Install Date & Time Details are same, as per the Review Order page");
									} else
										statusTracker(
												"Fail",
												"Order Summary Page - Second Install Date & Time Details is not displayed",
												"Order Summary Page - Second Install Date & Time Details is not displayed",
												"Order Summary Page - Second Install Date & Time Details is not displayed");
											
										*/
									  	
									  	
									  	
									 /* 	//Phone installation requests displays below TV- Internet installation requests
									  		if ((return_text(".//*[@id='content']/div[3]/div[2]/div[2]/div/div/div/div[2]/div[1]/h5[2]/div/p/strong[1]",drive).trim()).equals("Internet")
													&& (return_text(".//*[@id='content']/div[3]/div[2]/div[2]/div/div/div/div[2]/div[1]/h5[2]/div/p/strong[2]",drive).trim()).equals("Installation Preferences:")) 
									  		{
												statusTracker(
														"Pass",
														"Internet installation requests displays below TV- Internet installation requests",
														"Internet installation requests displays below TV- Internet installation requests",
														"Internet installation requests should be displayed below TV- Internet installation requests");
											} else
												statusTracker(
														"Fail",
														"Internet installation requests is not displayed below TV- Internet installation requests",
														"Internet installation requests is not displayed below TV- Internet installation requests",
														"Internet installation requests should be displayed below TV- Internet installation requests");
									  	
											logger.info("First Date & Time : "+ return_text(".//*[@class='secondVisitSchedule1 paragraphMerge']/p",drive).replace(":00", "").trim());
											logger.info("Second Date & Time : "+ return_text(".//*[@class='secondVisitSchedule2 paragraphMerge']/p",drive).replace(":00", "").trim());
*/
									  	}
									
									//submit order
									click_element(".//*[@class='js-next-button blue-button']",driver);	
									
									Thread.sleep(7000);
			
	                         //Terms and Conditions error message
									if ((driver.findElement(By.xpath(".//*[@id='js-terms-form']/div/div/div[4]/div")).isEnabled())) 
									{
									
									logger.info("Terms and Conditions error message displayed");
									statusTracker(br,driver,"Pass", "Terms and Conditions error message displayed",
											"Terms and Conditions error message displayed", "Terms and Conditions error message displayed");
									}
									else
							        {
									logger.info("fail");
									statusTracker(br,driver,"Fail", "Terms and Conditions error message is not displayed",
											"Terms and Conditions error message is not displayed", "Terms and Conditions error message should be displayed");
									}
									   try{
								           if (driver.findElement(By.partialLinkText("No thanks")).isDisplayed())
								          //  if (isElementPresent(".//*[@class='fsrDialogs']",driver))
								              {
								                     //JS closing Feedback
								                     logger.info("Closing feedback Pop-up");
								                     //click_element(".//*[@class='fsrCloseBtn']",driver);
								                     driver.findElement(By.partialLinkText("No thanks")).click();
								                     Thread.sleep(20000);
								             }   else
								                     logger.info("No Feedback Pop-ups found");
								           
								              
								              if (isElementPresent(".//*[contains(@id,'lpInviteLayer')]/div",driver))
								              {
								                     //JS closing chat box
								                     logger.info("Closing chat Pop-up");
								                     click_element(".//*[contains(@id,'lpInviteLayer')]/div/a[2]/img",driver);
								                     Thread.sleep(20000);
								              }      else
								                     logger.info("No chat Pop-ups found");
								           } catch (Exception e) {
								                     exceptionHandler(br,e, driver);
								           }

		
										   
									 //Image_compare changes -JS Start
										Image_compare(br,env,Page_Phone,Overall_Path,screen_count,driver);
					                    screen_count++;
					                  //Image_compare changes -JS End
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
