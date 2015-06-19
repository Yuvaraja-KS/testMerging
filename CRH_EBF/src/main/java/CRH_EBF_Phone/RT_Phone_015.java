//File Name: RT_Phone_015
//Author: Pradeep Shetty
//Description of test case: Customer is eligible to upgrade Phone LOB
//Date of creation(D/M/Y): 11/3/2014
//Name and date(D/M/Y) of modification: Pradeep Shetty / 6/6/2014
//Modification description:
//  a) change the all the xpath’s to unique property 
//  b) Removed all the unwanted print statements & comments.
//  c) Added comments to the steps wherever needed.
//  d) Updated Status tracked if change needed


package CRH_EBF_Phone;



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

public class RT_Phone_015 extends CommonFunctions {

	

				String table, tns[];
				String tlimit, username, pwd, ctotal, Uname, Tv_plan, Internet_plan,Phone_plan, current_service;
				int tncount;
				String serAddress, Internet_service, Tv_service, Phone_service;

	public RT_Phone_015()
	{
	}

	public RT_Phone_015(String s) 
	{
				this.path = s;
				//this.path1 = internet;
				logger.info("add Phone is intialized");
	}

	public boolean Isavailable(String fxp, WebDriver driver) 
	{
		        boolean xy = true;
			    try {
				if (driver.findElement(By.xpath(fxp)) != null) 
				{
				logger.info("gone inside");
				logger.info("",true);
				xy = true;
				}
			    } catch (Exception e) {
				logger.info(e.getMessage());
				logger.info("",false);
				xy = false;
			    }
			    return xy;
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
				Workbook wb1 = Workbook.getWorkbook(data1, ws1);*/

			    try {
			    Page_Phone="RT_Phone_015_";
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

				 

			    if (first == 0) {
				logger.info("trying to open the url");
				driver.manage().window().maximize();
				driver.get(url);
				logger.info("Chek if url opened");
				// statusTracker(br,driver,"Pass", " ", " ", " ");
			    }

		try 
				{
			      if(first==0)
				  firstrun(br,driver,username,pwd,ctotal,Uname,serAddress);
				  logger.info("I went to next step");
				 
				  
				//Verify Phone is active on account, validate LOS 
				  Phone_los_verify(br,Phone_plan,Phone_service,driver);
					Thread.sleep(4000);
				  
					// If Phone is active on the account, select "Add feature"
					click_element(".//*[@name='upgrade_phone']",
							driver);
					Thread.sleep(2000);
				//	click_element(".//*[@class='current services']/li/div[3]/ul/li[2]/label/input",			driver);
					
					if ((driver.findElement(By
							.xpath("//*[@class='button-nav ']/a")).isEnabled())) {
						logger.info("pass1");
						statusTracker(br,driver,"Pass", "For Phone active on the account select Add feature",
								"Add feature check box is selected", "Add feature check box should be selected");
					} else {
						logger.info("fail1");
						statusTracker(br,driver,"Fail", "For Phone active on the account select Add feature",
								"Add feature check box is not selected", "Add feature check box should be selected");
					}  
				  
					
					
					//Select Continue Button so that User navigates to Phone Configuration Page page
					click_element("//*[@class='button-nav ']/a",driver);
					statusTracker(br,driver,"Pass", "clck on Continue button",
							"'Continue button is clicked", "should click continue button");
					Thread.sleep(6000);
					
					if (return_text(".//*[@class='left']/h2/strong",driver).trim().equals("Phone Plan"))
						statusTracker(br,driver,"Pass",
								"Click the Continue Button",
								"User is navigated to the Choose Phone plan page",
								"User should navigate to the Choose Phone plan page");
					else
						statusTracker(br,driver,"Fail",
								"Click the Continue Button",
								"User is NOT navigated to the Choose Phone plan page",
								"User should navigate to the Choose Phone plan page");
					
					
					JavascriptExecutor jsx = (JavascriptExecutor)driver;
					jsx.executeScript("window.scrollBy(0,450)", "");
					
					  //Click to navigate to Customize your phone service page
					click_element(".//*[@class='checkoutCTA']/a/span",driver);
					statusTracker(br,driver,"Pass", "clck on Select button",
							"'Select button is clicked", "should click Select button");
					Thread.sleep(10000);
					
					
					
					// Validating if user has navigated to Phone Configuration Page page
					if (return_text(".//*[@class='left']/h2",driver).trim().equals("Customize Your Phone Service"))
						statusTracker(br,driver,"Pass",
								"Click the Continue Button",
								"User is navigated to the Phone Configuration page",
								"User should navigate to the Phone Configuration page");
					else
						statusTracker(br,driver,"Fail",
								"Click the Continue Button",
								"User is NOT navigated to the Phone Configuration page",
								"User should navigate to the Phone Configuration page");
					/*
					if ((driver.findElement(By
							.xpath(".//*[@class='arrow']")).isEnabled())) {
						logger.info("verify the Continue button is enabled");
						statusTracker(br,driver,"Pass", "Continue button is enabled",
								"Continue button is enabled", "Continue button is enabled should be enabled");
					} else {
						logger.info("fail1");
						statusTracker(br,driver,"Fail", "Continue button is not enabled",
								"Continue button is not enabled", "Continue button is not enabled");
					}  
				*/
				  
					//  validate that a International Plan  section displays
					if (return_text(".//*[@class='content-wrap']/div[5]/h4/div/p/strong",driver).trim().equals("Select an International Calling Plan (choose one)"))
						statusTracker(br,driver,"Pass",
								"International Plan section",
								"International Plan section is displayed",
								"International Plan section should be displayed");
					else
						statusTracker(br,driver,"Fail",
								"International Plan section",
								"International Plan section is not displayed",
				                "International Plan section should be displayed");
					
				//  Validate that the International Calling plan is displayed in a default open state.
					if (return_text(".//*[@class='content-wrap']/div[6]/header/ul/li[2]/h3",driver).trim().equals("Global Penny Phone Plan"))
						statusTracker(br,driver,"Pass",
								"Global Penny Phone Plan is in a default open state ",
								"Global Penny Phone Plan is displayed in a default open state",
								"Global Penny Phone Plan should be displayed in a default open state");
					else
						statusTracker(br,driver,"Fail",
								"Global Penny Phone Plan is in a default open state ",
								"Global Penny Phone Plan is not displayed in a default open state",
								"Global Penny Phone Plan should be displayed in a default open state");
					
					
					if (return_text(".//*[@class='content-wrap']/div[7]/header/ul/li[2]/h3",driver).trim().equals("International OnePrice®"))
						statusTracker(br,driver,"Pass",
								"International OnePrice® is in a default open state ",
								"International OnePrice® is displayed in a default open state",
								"International OnePrice®should be displayed in a default open state");
					else
						statusTracker(br,driver,"Fail",
								"International OnePrice® is in a default open state ",
								"International OnePrice® is not displayed in a default open state",
								"International OnePrice® should be displayed in a default open state");
					
					
					
					
					// Validate that Calling Plans display in the correct ranking, by region. 
					
					String CurrSer1 =driver.findElement(By.xpath(".//*[@class='content-wrap']/div[6]/header/ul/li[2]/h3")).getText();
                    String CurrSer2 =driver.findElement(By.xpath(".//*[@class='content-wrap']/div[7]/header/ul/li[2]/h3")).getText();
                    if ((CurrSer1.equalsIgnoreCase("Global Penny Phone Plan")))
                           if((CurrSer2.equalsIgnoreCase("International OnePrice®")))
                           {
                                 logger.info(" right sequence!!");
                                 statusTracker(br,driver,"Pass", "current sequence matches Global Penny Phone Plan International OnePrice®", "Sequence matches", "Sequence should match");
                           }
                           else
                           {
                                 logger.info("wrong sequence!!");
                                 statusTracker(br,driver,"Fail", "current sequence matches Global Penny Phone Plan International OnePrice®", "Sequence does not match", "Sequence should match");
                                 
                           }
                    logger.info("valid  ranking of Calling Plans by region");  

					
                 // Select  "Compare Plans" link
					 //click_element(".//*[@class='content-wrap']/div[5]/ul/li/div/a",driver);
					 logger.info("Compare page plan clicked"); 
					 Thread.sleep(9000);
					 

					 	
			//Select "Close" on Compare Plans link
				//click_element(".//*[@class='modal-title-wrapper']/div[2]",driver);
						 Thread.sleep(4000);
						 
					
					
					//Validate the user can expand the Global Penny Phone
		                    
		                    
		               	 click_element(".//*[@class='content-wrap']/div[6]/header/ul/li[2]/h3",driver);
		    			 Thread.sleep(4000);
	

		    			 String CurrSer6 =driver.findElement(By.xpath(".//*[@class='content-wrap']/div[6]/section/div/div/p[3]")).getText();
		                 
		                    if ((CurrSer6.equalsIgnoreCase("Here's what you get:")))
		                     
		                           {
		                                 logger.info(" User can expand the Global Penny Phone ");
		                                 statusTracker(br,driver,"Pass", "User can expand the Global Penny Phone", "User can expand the Global Penny Phone", "User should be able to expand the Global Penny Phone");
		                           }
		                           else
		                           {
		                                 logger.info("User can not expand the Global Penny Phone !!");
		                                 statusTracker(br,driver,"Fail", "User can not expand the Global Penny Phone", "User can expand the Global Penny Phone", "User should be able to expand the Global Penny Phone");
		                                 
		                           }
		                    
		                    //validate that the International One Price name with monthly price and duration is displayed If the user does not currently have the IOP phone plan
		                    
		                    String CurrSer7 =driver.findElement(By.xpath(".//*[@class='content-wrap']/div[6]/header/ul/li[2]/h3")).getText();
		                    String CurrSer8 =driver.findElement(By.xpath(".//*[@class='content-wrap']/div[7]/header/ul/li[2]/h3")).getText();
		                    String CurrSer9 =driver.findElement(By.xpath(".//*[@class='content-wrap']/div[7]/header/ul/li[3]")).getText();
		                    if ((CurrSer7.equalsIgnoreCase("Global Penny Phone Plan")))
		                           if((CurrSer8.equalsIgnoreCase("International OnePrice®")))
		                        	   if((CurrSer9.equalsIgnoreCase("$1995 per Month")))
		                           {
		                                 logger.info(" Valid as IOP is not in current service  ");
		                                 statusTracker(br,driver,"Pass", "IOP is not in current service", "IOP is not in current service so monthly price and duration is displayed", "IOP is not in current service so monthly price and duration should not be displayed");
		                           }
		                           else
		                           {
		                                 logger.info("Error as IOP is in current service !!");
		                                 statusTracker(br,driver,"Fail", "IOP is in current service", "IOP is in current service so monthly price and duration is not displayed", "IOP is in current service so monthly price and duration should not be displayed");
		                                 
		                           }
					
		                    Thread.sleep(3000);    
		                    
		                    
		                  //Validate the user can expand the IOP
		                    
		                    
			               	 click_element(".//*[@class='content-wrap']/div[7]/header/ul/li[1]/a",driver);//drop down
			    			 Thread.sleep(4000);
		

			    			 String CurrSer10 =driver.findElement(By.xpath(".//*[@class='content-wrap']/div[7]/section/div/div/div[3]")).getText();
			                 
			                   if ((CurrSer10.equalsIgnoreCase("Here's what you get:")))
			                     
			                           {
			                                 logger.info(" User can expand the IOP ");
			                                 statusTracker(br,driver,"Pass", "User can expand the IOP", "User can expand the IOP", "User should be able to expand the IOP");
			                           }
			                           else
			                           {
			                                 logger.info("User can not expand the IOP !!");
			                                 statusTracker(br,driver,"Fail", "User can not expand the IOP", "User can expand the IOP", "User should be able to expand the IOP");
			                                 
			                           }
			                   
			                   
			          
			                 //  Select IOP Plan 
				    				click_element(".//*[@class='content-wrap']/div[7]/header/ul/li[4]/label",driver);
				    				Thread.sleep(2000);

				    					logger.info("pass1");
				    					statusTracker(br,driver,"Pass", "Select IOP plan",
				    							"IOP plan is selected & gets updated to the cart", "IOP plan should be selected & get updated in the cart");
				    					
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
				    			
			                 //Select Continue Button so that User navigates to the Review Order page.
			   				click_element(".//*[@id='content']/div[3]/div[2]/div/div[2]/div/nav/a[2]",driver);
			   				logger.info("RO page is diaplayed");
			   				statusTracker(br,driver,"Pass", "clck on Continue button",
			   						"'Continue button is clicked", "should click continue button");
			   				Thread.sleep(10000);
			   		
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