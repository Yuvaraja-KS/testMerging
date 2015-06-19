

//File Name: RT_RO_OS_008
//Author: RAHUL JADOW
//Description of test case: Order Summary -No Install Required
//Date of creation(D/M/Y): 19/6/2014
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

public class RT_RO_OS_008 extends CommonFunctions {

	

				String table, tns[];
				String tlimit, username, pwd, ctotal, Uname, Tv_plan, Internet_plan,Phone_plan, current_service;
				int tncount;
				String serAddress, Internet_service, Tv_service, Phone_service;

	public RT_RO_OS_008()
	{
	}

	public RT_RO_OS_008(String s) 
	{
				this.path = s;
				logger.info("RO_OS_008 is intialized");
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
				tlimit = tlimit + "000";
	*/

				if (first == 0) {
					logger.info("trying to open the url");
					driver.manage().window().maximize();
					driver.get(url);
					logger.info("Chek if url opened");
				}

				try {
					if (first == 0)
						firstrun(br,driver, username, pwd, ctotal, Uname,
								serAddress);
				  logger.info("I went to next step");
				  {
					  
	/*click on upgrade TV option
					  
				  click_element(".//*[@name='upgrade_inet']", driver);
				  statusTracker("Pass", "User clicks on Upgrade Internet option", "clicked", "User should click on Upgrade Internet option");
				  Thread.sleep(3000);*/
					  
					  click_element(".//*[@value='select_inet']", driver);
					  statusTracker(br,driver,"Pass", "User clicks on Add Internet option", "clicked", "User should click on add Internet option");
					  Thread.sleep(3000);
				  
	//click on continue
				  
				  click_element(".//*[@class='js-next-button blue-button']", driver);
				  statusTracker(br,driver,"Pass", "User clicks on Continue", "Navigated to plan page", "Should Navigate to plan page");
				  Thread.sleep(8000);
				  
	//click on standard internet
				  
				  click_element(".//*[@data-enrichedname='Standard']/li[5]/div/a/span", driver);
				  statusTracker(br,driver,"Pass", "User clicks internet plan", "clicked", "User should click internet plan");
				  Thread.sleep(25000);
				  
		  
				  //Select I'll use my own modem 
				  click_element(".//*[@data-name='My Own Modem']", driver);
				  Thread.sleep(10000);
				  
				  click_element(".//*[@class='arrow']", driver);
				  Thread.sleep(8000);
				  
				  
					//validate display of review order page
				   if(return_text(".//*[@class='left']/h2", driver).equalsIgnoreCase("Choose Installation & Review Order"))
					{statusTracker(br,driver,"Pass", "User finishes the LOS configuration and selects the continue CTA.  ","User is displayed with Review order page" , "User should be displayed with Review order page");
					}
					else
					{statusTracker(br,driver,"Fail", "User finishes the LOS configuration and selects the continue CTA.  ","User is displayed with Review order page" , "User should be displayed with Review order page");
					}

	  
				  //I have my own equipment and don't need further installation assistance. 
				  if(return_text(".//*[@class='collapsible active js-expander-initialized']/header/label/p/strong", driver).equalsIgnoreCase("I have my own equipment and don't need further installation assistance."))
					{statusTracker(br,driver,"Pass", "Verify text 'I have my own equipment and don't need further installation assistance.' is displayed - NO INSTALL",
							"Verify text 'I have my own equipment and don't need further installation assistance.' is displayed - NO INSTALL" , 
							"Verify text 'I have my own equipment and don't need further installation assistance.' should be displayed - NO INSTALL");
					}
					else
					{statusTracker(br,driver,"Fail", "Verify text 'I have my own equipment and don't need further installation assistance.' is NOT displayed - NO INSTALL",
							"Verify text 'I have my own equipment and don't need further installation assistance.' is NOT displayed - NO INSTALL" , 
							"Verify text 'I have my own equipment and don't need further installation assistance.' should be displayed - NO INSTALL");
					}
				  
				  
				  //Free 
				  if(return_text(".//*[@id='section-no-installation']/header/label/span[1]", driver).equalsIgnoreCase("Free"))
					{
					  statusTracker(br,driver,"Pass", "Verify text FREE is displayed for 'I have my own equipment and don't need further installation assistance.'",
							"Verify text FREE is displayed for 'I have my own equipment and don't need further installation assistance.'" , 
							"Verify text FREE should be displayed for 'I have my own equipment and don't need further installation assistance.'");
					}
					else
					{
						statusTracker(br,driver,"Fail", "Verify text FREE is NOT displayed for 'I have my own equipment and don't need further installation assistance.'",
							"Verify text FREE is NOT displayed for 'I have my own equipment and don't need further installation assistance.'" , 
							"Verify text FREE should be displayed for 'I have my own equipment and don't need further installation assistance.'");
					}
				  
			   
				   
	//Check for Monthly charges option
				   Package_ReviewOrder_Internet_ChkMonthlyCharges(br);
				   Thread.sleep(3000);

					  
				   //MC
				   if(Isavailable(".//*[@class='monthly-charges module']", driver))
					   statusTracker(br,driver,"Pass", "Verify Monthly charges section is displayed separately.", "Monthly charges section is displayed separately", " Monthly charges section should be displayed separately");
				   else
					   statusTracker(br,driver,"Fail", "Verify Monthly charges section is displayed separately", " Monthly charges section is not displayed separately", "Monthly charges section should be displayed separately");
				   	
				   //OC
				   if(Isavailable(".//*[@class='one-time-charges module']", driver))
					   statusTracker(br,driver,"Pass", "Verify One Time charges section is displayed separately.", "One Time charges section is displayed separately", " One Time charges section should be displayed separately");
				   else
					   statusTracker(br,driver,"Fail", "Verify One Time charges section is displayed separately", "One Time Monthly charges section is not displayed separately", "MOne Time charges section should be displayed separately");
	
				   	
				   	
	//Check for one time charges option		   
				   Package_ReviewOrder_ChkOneTimeCharges(br);
				   Thread.sleep(3000);
				   
				//No Edit link displayed
				if(driver.findElement(By.xpath(".//*[@data-lob='Internet']/span")).isDisplayed())
						  statusTracker(br,driver,"Pass", "No Edit link is displayed", "No Edit link is displayed", "Edit link should not displayed");
					   else
						   statusTracker(br,driver,"Fail", "No Edit link is NOT displayed", "No Edit link is NOT displayed", "Edit link should not displayed");
					   				

	//Continue RO page		  
					  click_element(".//*[@class='js-next-button blue-button']", driver);
					  Thread.sleep(8000);

					  
					  if(driver.findElement(By.xpath(".//*[@class='active']/div/div/span")).getText().equals("3"))
					     statusTracker(br,driver,"Pass", "Verify that User is navigated to order summary page", "User is navigated to order summary page", "Should be navigated");
					  else
						  statusTracker(br,driver,"Fail", "Verify that User is not navigated to order summary page", "User is navigated to order summary page", "Should be navigated");
					    
				  
						//Review Order page
						if(return_text(".//*[@class='left']/h2", driver).trim().equalsIgnoreCase("Order Summary"))
						{
							statusTracker(br,driver,"Pass", "Validated text is displayed on Order Summary page",
									"Validated text is displayed on Order Summary page", "Validated text should displayed on Order Summary page");
						}
						else
						{
							statusTracker(br,driver,"Fail", "Validated text is NOT displayed on Order Summary page",
									"Validated text is NOT displayed on Order Summary page", "Validated text should displayed on Order Summary page");
							
						}
						Thread.sleep(8000);
						
						
						//Order summary monthly charges
						Package_OrderSummary_Internet_ChkMonthlyCharges(br,driver);
						Thread.sleep(3000);		
						
						
						Package_OrderSummary_ChkOneTimeCharges(br,driver);
						Thread.sleep(3000);	
						
						//verifying current one time charges!
						String one_time_charges=driver.findElement(By.xpath(".//*[@class='one-time-charges module']/table/tfoot/tr/td[2]")).getText();  
						if(driver.findElement(By.xpath(".//*[@class='one-time-charges module']/table/tfoot/tr/td[2]")).getText().equalsIgnoreCase(one_time_charges))
							{
							logger.info("Total One time charges :" + one_time_charges);
							logger.info("One time charges total matching on Order Confirmation Page");
							statusTracker(br,driver,"Pass", "One time charges total matching on Order Confirmation Page", 
									"One time charges total matching on Order Confirmation Page", 
									"One time charges total should match on Order Confirmation Page");
							}
							else
							{
							logger.info("one_time_charges total not matching!");
							statusTracker(br,driver,"Fail", "One time charges total NOT matching on Order Confirmation Page", 
									"One time charges total NOT matching on Order Confirmation Page", 
									"One time charges total should match on Order Confirmation Page");
							 
							}   		
							Thread.sleep(3000);	  
						
						   //T&C	
						driver.findElement(By.xpath("//*[@id='order-choose-TWC']")).click();

									
						if(driver.findElement(By.xpath("//*[@id='order-choose-TWC']")).isSelected())
						{
							 logger.info("T&C checkbox selected successfully");
							 statusTracker(br,driver,"Pass", "T&C checkbox selected successfully", 
									 "T&C checkbox selected successfully", "T&C checkbox should be selected successfully");
						}
							else
						{
							 logger.info("textbox is not present");
							 statusTracker(br,driver,"Fail", "T&C checkbox NOT selected successfully", 
									 "T&C checkbox NOT selected successfully", "T&C checkbox should be selected successfully");
						}
						Thread.sleep(2000);
						
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
/*
						//submit order
						click_element(".//*[@class='js-next-button blue-button']",driver);	
						Thread.sleep(10000);	
						
						
						//Your Order Summary page
						  if ((driver.findElement(By.xpath(".//*[@class='confirmationWrapper section']/header/h3/div"))).getText().equalsIgnoreCase("Your Order Summary")) 
					      {			
						         logger.info("Validated that the Your Order Summary section is displayed in Order Confirmation Page");	
						         statusTracker("Pass", "Validated that the Your Order Summary section is displayed in Order Confirmation Page",
											"Validated that the Your Order Summary section is displayed in Order Confirmation Page", 
											"Validated that the Your Order Summary section should be displayed in Order Confirmation Page");
								    } 
						         else {
						         statusTracker("Fail", "Validated that the Your Order Summary section is NOT displayed in Order Confirmation Page",
											"Validated that the Your Order Summary section is NOT displayed in Order Confirmation Page", 
											"Validated that the Your Order Summary section should be displayed in Order Confirmation Page");
									}		
					          Thread.sleep(2000);	
					          
					          
						//In the Your New Services section, verify that an order number has been generated
						if (Isavailable(".//*[@class='orderDetails']",driver)) 
						{			
						logger.info("Validated that the New Services section is displayed in Order Confirmation Page");	
						statusTracker("Pass", "Validated that the New Services section is displayed in Order Confirmation Page",
								"Validated that the New Services section is displayed in Order Confirmation Page", 
								"Validated that the New Services section should be displayed in Order Confirmation Page");
					    } 
						else {
						statusTracker("Fail", "Validated that the New Services section is NOT displayed in Order Confirmation Page",
								"Validated that the New Services section is NOT displayed in Order Confirmation Page", 
								"Validated that the New Services section should be displayed in Order Confirmation Page");
						}
						*/
						Thread.sleep(2000);
									

					//Sign Out	
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
				   
				}
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
