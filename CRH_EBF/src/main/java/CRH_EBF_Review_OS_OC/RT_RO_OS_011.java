

//File Name: RT_RO_OS_011
//Author: 
//Description of test case: Order Summary  - tech install - capture install requests
//Date of creation(D/M/Y): 11/3/2014
//Name and date(D/M/Y) of modification: Raveena Singh  09/06/2014

//Name and date(D/M/Y) of modification: RAHUL JADOW  (19/06/2014)
//Modification description: Code Cleanup
//Name and date(D/M/Y) of modification: RAHUL JADOW (27/6/2014)
//Modification description: Failure updates


package CRH_EBF_Review_OS_OC;

import com.thoughtworks.selenium.Selenium;
/*import jxl.Workbook;
 import jxl.write.Label;
 import jxl.write.WritableSheet;
 import jxl.write.WritableWorkbook;*/









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

public class RT_RO_OS_011 extends CommonFunctions {

	

				String table, tns[];
				String tlimit, username, pwd, ctotal, Uname, Tv_plan, Internet_plan,Phone_plan, current_service;
				int tncount,flag;
				String serAddress, Internet_service, Tv_service, Phone_service;

	public RT_RO_OS_011()
	{
	}

	public RT_RO_OS_011(String s) 
	{
				this.path = s;
				logger.info("RO_OS_011 is intialized");
	}

	public RT_RO_OS_011(String s, String t,String p,String i) {
	

	}
	@Override
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

	@Override
	public void execute(String br,WebDriver driver, String url, int loc,String Overall_Path,String env) throws Exception 
	{
		int screen_count = 1;
	    File data = new File(this.path);
	    WorkbookSettings ws = new WorkbookSettings();
	    ws.setLocale(new Locale("er", "ER"));
	   // arrcount=0;
	    logger.info("chheck1");
	    Workbook wb = Workbook.getWorkbook(data, ws);
	    Sheet sheet2 = wb.getSheet("Review_OS_OC");

			    try {
				String tv = "", inet = "", phone = "";
				
				
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

/*
				int tv1 = 0, inet1 = 0, phone1 = 0;
				int val = 1;
				int tlim = Integer.parseInt(tlimit);
				tlim *= 60;
				tlimit = Integer.toString(tlim);
				tlimit = tlimit + "000";*/
				String equipment[]= new String[10];



			    if (first == 0) {
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
				 
			
				  
	                //Add Phone
	                if ((driver.findElement(By.xpath("//*[@name='select_phone']")).isEnabled())) 
	                {
	                click_element("//*[@name='select_phone']",driver);    
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

	                //Select phone
	                click_element(".//*[@data-enrichedname='Home Phone National']/li[5]/div/a",driver);
	                Thread.sleep(10000); 
	                
	                click_element("//*[@data-shortname='Private Listing']",driver);
					Thread.sleep(10000);
					//Phone Continue to Next step
					click_element("//*[@class='content-wrap']/div[9]/a",driver);
					logger.info("Continue to Next step");
					Thread.sleep(10000);
				  
	                //Phone Continue to Next step
	                //click_element(".//*[@class='content-wrap']/div[9]/a",driver);
	                //logger.info("Continue to Next step");
	               // Thread.sleep(6000);    

	              //Radio button - Keep current phone number
	                click_element("//*[@id='js-phoneNumber-transfer']", driver);
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
	                          Thread.sleep(3000);
	                       
	                          
	                          Select_DropDown(driver, ".//*[@id='current-provider-state-billing']", "Idaho");
	        				  statusTracker(br,driver," ", "Select Current provider state", "Selected", "");
	        				  Thread.sleep(5000);
	                  
	                          driver.findElement(By.cssSelector("form > div.continue > a")).click();    
	                          Thread.sleep(7000);
	                          logger.info("Continue clicked");
	                
	                          
	                     //Select check box              
	                  
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

                                   
                          
                 			      //Calendar 
                 				   
                 				   DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
                 				   Date date = new Date();
                 				   logger.info("Current Date 1: " + dateFormat.format(date));
                 				   int DD_Value = Integer.parseInt(dateFormat.format(date).substring(3, 5));
                 				   logger.info("DD Value : " + DD_Value);
                 				  /*elect_Firstchoice_Date_new(DD_Value);
              					Thread.sleep(7000);

              					select_Secondchoice_Date_new(DD_Value);
              					Thread.sleep(7000);*/
                 				  Thread.sleep(7000);
                 				  select_Firstchoice_Date(br,DD_Value,driver);
                                  Thread.sleep(9000);
                                  
                                   select_Secondchoice_Date(br,DD_Value,driver);
                                   Thread.sleep(10000);

				  
                                // RO - Monthly charges                
                                   String total_monthly_charges=driver.findElement(By.xpath(".//*[@title='Monthly Charges']/tfoot/tr/td[2]")).getText();
                                   Thread.sleep(8000);
                                 // RO - One time charges    
                                   String one_time_charges=driver.findElement(By.xpath(".//*[@title='One Time Charges']/tfoot/tr/td[2]")).getText();    
                                   Thread.sleep(8000);   
                                // RO - Fee            
                                   String Service_installation_fee=driver.findElement(By.xpath(".//*[@class='services-table']/tbody/tr[1]/td[2]")).getText();   
                                   
                                                     //continue
                                                     click_element("//*[@class='js-next-button blue-button']",driver);
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
                                 
                               //verifying fees!
                                 logger.info("************************verifying Service_installation fee fees!**********************");
                                 if(driver.findElement(By.xpath("//*[@class='services-table']/tbody/tr[1]/td[2]")).getText().equalsIgnoreCase(Service_installation_fee)) 
                                 {
                                 logger.info("Service_installation fee total matching!");
                                 statusTracker(br,driver,"Pass", "Service_installation fee total matching", "Service_installation fee total matching", "Service_installation fee total should match");
                                 }
                                 else
                                 {
                                 logger.info("Service_installation fee total not matching!");
                                 statusTracker(br,driver,"Fail", "Service_installation fee total not matching", "Service_installation fee total not matching", "Service_installation fee total should match");

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
                             if (return_text(".//*[@class='mainHeader appointmentTitle']/h4",driver).trim().equals("Installation Details"))
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
                             Thread.sleep(8000);
                             
   //Validate that OrderSummary page displays the same service address displayed in review order page
    //String servAddr = (return_text(".//*[@class='order-details details-block']/div[1]/div[1]/p",driver).replace(Uname,"")).trim();
   // logger.info(" service address :   "+ servAddr);
                             String servAddr = driver.findElement(By.xpath(".//*[@class='location']")).getText().trim();
                             logger.info(" service address :   "+ servAddr);
                             logger.info(" service address from sheet is :   "+ serAddress);

   /*  if(servAddr.trim().replaceAll(" ", "").equalsIgnoreCase(serAddress.trim().replaceAll(" ", "")))
    	 
     {
    	 logger.info("Service Adress from input sheet:" +serAddress);
                     logger.info("service address is matching!");
                     statusTracker("Pass", "service address is matching", "service address is matching", "service address should match");
                     }
                     else
                     {
                     logger.info("service address is not matching!");
                     statusTracker("Fail", "service address is not matching", "service address is not matching", "service address should match");
                     }
*/
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
     
     
   //Validate the LOB(s) scheduled for install display in the Installation Details section
     
     String CurrSer1 =driver.findElement(By.xpath(".//*[@class='mainHeader appointmentTitle']/h4")).getText();
     String CurrSer2 =driver.findElement(By.xpath(".//*[@class='paragraphMerge firstVisitSchedule1']/p/strong")).getText();
     String CurrSer3 =driver.findElement(By.xpath(".//*[@class='firstVisitSchedule2 paragraphMerge']/p/strong")).getText();
     if ((CurrSer1.equalsIgnoreCase("Installation Details")))
            if((CurrSer2.equalsIgnoreCase("Your First Choice:")))
         	   if((CurrSer3.equalsIgnoreCase("Your Second Choice:")))
         		  
         	  
            {
                  logger.info(" scheduled for install display in configurable text above the date and time selections");
                  statusTracker(br,driver,"Pass", "scheduled for install display in configurable text above the date and time selections", "scheduled for install display in configurable text is displayed above the date and time selections", "scheduled for install display in configurable text should display above the date and time selections");
            }
            else
            {
                  logger.info("scheduled for install display in configurable text  is not above the date and time selections");
                  statusTracker(br,driver,"fail", "scheduled for install display in configurable text above the date and time selections", "scheduled for install display in configurable text is not displayed above the date and time selections", "scheduled for install display in configurable text should display above the date and time selections");
                  
            }

     Thread.sleep(4000);
     
     Validating_OrderSummary_DateDetails(br,driver);
     Thread.sleep(3000);
				           
				}
      
		catch (Exception e)
		 {
		exceptionHandler(br,e, driver);
		                                                                                                      
		 }
		 }
		 finally {
		 wb.close();
		 driver.close();
		                                                                                                     
		 }
		                                                                                                  
		 }			  
				  
				  
				  
}			