//File Name: RT_Phone_014
//Author: Shikha Singh
//Description of test case: Customer is eligible to upgrade Phone LOB
//Date of creation(D/M/Y): 11/3/2014
//Name and date(D/M/Y) of modification: Pradeep Shetty / 6/6/2014
//Modification description:
//  a) change the all the xpath’s to unique property 
//  b) Removed all the unwanted print statements & comments.
//  c) Added comments to the steps wherever needed.
//  d) Updated Status tracked if change needed




package CRH_EBF_Phone;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;

import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class RT_Phone_014 extends CommonFunctions{
	
	

    String table, tns[];
    String tlimit,username,pwd,ctotal,Uname,Tv_plan,Internet_plan,Phone_plan,current_service;
    int tncount;
	String serAddress, Internet_service,Tv_service,Phone_service;
	
	public RT_Phone_014() {
	}

	public RT_Phone_014(String s) {
		this.path = s;
		//this.path1 = internet;
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
		
			/*	File data1 = new File(this.path1);
				WorkbookSettings ws1 = new WorkbookSettings();
				ws1.setLocale(new Locale("er", "ER"));
				Workbook wb1 = Workbook.getWorkbook(data1, ws1);*/

			    try {
			    Page_Phone="RT_Phone_014_";
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
			      Thread.sleep(5000);
			      
			  	JavascriptExecutor jsx = (JavascriptExecutor)driver;
				jsx.executeScript("window.scrollBy(0,450)", "");

			      //Internet_Phone_lob_verify(br,driver);
				  Phone_lob_click(br,driver);
				  
				  click_element("//*[@class='button-nav ']/a", driver);
				  Thread.sleep(8000);
				  click_element("//*[@class='checkoutCTA']/a", driver);
				  Thread.sleep(8000);
				  click_element("//*[@class='continue']", driver);
				  Thread.sleep(3000);

//Expand the section		
				
				  //click_element("//*[@id='content']/div[3]/div[2]/div/div[2]/div/div[2]/div/div/div[1]/div/section/div/div[9]/a", driver);
				  statusTracker(br,driver,"", "Expand the Select New or Transfer Phone number section", "", "");
				  
				  Thread.sleep(4000);
				  
//New number and existing number check	
				  			if(driver.findElement(By.xpath(".//*[@class='selectOrTransfer phoneNumberSelect']/div/section/div/form")).isDisplayed())
					  		{
						  	if(return_text(".//*[@for='js-phoneNumber-new']", driver).trim().equalsIgnoreCase("I would like a new phone number."))
						  	{	  
							  if(driver.findElement(By.xpath(".//*[@for='js-phoneNumber-transfer']")).isDisplayed())
							  {
								  statusTracker(br,driver,"Paas", "Validate that Select New or Transfer Phone number  section displays", "Select New or Transfer Phone number  section displays", "Select New or Transfer Phone number  section should displays");
							  }
							  else
							  {statusTracker(br,driver,"Fail", "Validate that Select New or Transfer Phone number  section displays", "Select New or Transfer Phone number  section displays", "Select New or Transfer Phone number  section should displays");
							  }
						  	}				  
					  		}			  
				  			if(driver.findElement(By.xpath("//*[@class='authorization-wrapper authorization']/div/section/div/form/div")).isDisplayed())
				            {statusTracker(br,driver,"Fail", " The Digital Phone Authorization section is displayed in a default collapsed state. ", " The Digital Phone Authorization section is  displayed in a default collapsed state. ", " The Digital Phone Authorization section should be displayed in a default collapsed state. ");
							}
							else
							{statusTracker(br,driver,"Pass", " The Digital Phone Authorization section is displayed in a default collapsed state. ", " The Digital Phone Authorization section is not displayed in a default collapsed state. ", " The Digital Phone Authorization section should be displayed in a default collapsed state. ");
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
				  			
				  			
			/*	  			click_element(".//*[@id='js-phoneNumber-transfer']", driver);
				            statusTracker(br,driver,"", "Select I would like to transfer my current number", "", "");
				            Thread.sleep(5000);
		            
				            
				            Select_DropDown(driver,".//*[@id='currentProvider']","CIMCO");
				            field_statusTracker(br,driver,".//*[@id='currentProvider']", "Enter Customer Provider",
				    				"Customer Provider is Entered", driver);
				            
				            Select_DropDown(driver,"//*[@id='current-provider-state']","Florida");
				            field_statusTracker(br,driver,"//*[@id='current-provider-state']", "Enter current-provider-stater",
				    				"current-provider-stater is Entered", driver);
				            
				            
				            driver.findElement(By.xpath("//*[@id='phone-number']")).sendKeys(
				    				"123-876-7678");				            
				    		field_statusTracker(br,driver,"//*[@id='phone-number']", "Enter Phone Number",
				    				"Phone number is Entered", driver);
				    		Thread.sleep(2000);
				    		
				    		driver.findElement(By.id("account-number")).sendKeys("23456745");
				    		field_statusTracker(br,driver,"//*[@id='account-number']",
				    				"Enter Account Number", "Account Number is Entered", driver);
				    		Thread.sleep(2000);
				    		
				    		driver.findElement(By.id("account-name")).sendKeys("Dani");
				    		field_statusTracker(br,driver,"//*[@id='account-name']", "Account Name",
				    				"Account Name is Entered", driver);
				    		Thread.sleep(2000);
				    		
				    		driver.findElement(By.id("security-code")).sendKeys("3433");
				    		field_statusTracker(br,driver,"//*[@id='security-code']", "Enter Security Code",
				    				"Security Code is Entered", driver);
				    		Thread.sleep(2000);
				    		
				    		driver.findElement(By.id("address")).sendKeys("4th cross");
				    		field_statusTracker(br,driver,"//*[@id='address']", "Enter Address",
				    				"Address is Entered", driver);
				    		Thread.sleep(2000);
				    		
				    		driver.findElement(By.id("apt-type")).sendKeys("#10");
				    		field_statusTracker(br,driver,"//*[@id='apt-type']", "Enter apt type",
				    				"Apt Type is Entered", driver);
				    		
				    		Thread.sleep(2000);
				    		driver.findElement(By.id("city")).sendKeys("nyc");
				    		field_statusTracker(br,driver,"//*[@id='city']", "Enter City", "City is Entered",
				    				driver);
				    		Thread.sleep(2000);
				    		
				            Select_DropDown(driver,"//*[@id='current-provider-state-billing']","Hawaii");
				            field_statusTracker(br,driver,"//*[@id='current-provider-state-billing']", "Enter current-provider-state-billing",
				    				"current-provider-state-billing is Entered", driver);
				            
				            driver.findElement(By.id("zip-code")).sendKeys("23456");
				    		field_statusTracker(br,driver,"//*[@id='zip-code']", "Enter Zip-Code",
				    				"Zip Code is Entered", driver);
				    		Thread.sleep(2000);
				            
				  */          
				        click_element("//*[@class='content-wrap']/form/div[3]/a", driver);    
				        Thread.sleep(4000);
				        
				        
				        
		/*		        
				         if(driver.findElement(By.xpath("//*[@id='tpv-choose-TWC']")).isSelected())
				         {statusTracker(br,driver,"Fail", " Validate that User is presented with Time Warner Cable's terms and conditions, defaulted to unchecked ", " Is Checked ", " Should be unchecked");
						 }
						 else
						 {statusTracker(br,driver,"Pass", " Validate that User is presented with Time Warner Cable's terms and conditions, defaulted to unchecked ", " Is UnChecked", "  Should be unchecked");
						 }			
		       
				 */           
				         DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
				         Calendar cal = Calendar.getInstance();
				         logger.info(dateFormat.format(cal.getTime()));  
				         String Date=dateFormat.format(cal.getTime());
				         
				         if(driver.findElement(By.xpath(".//*[@class='customer-authorization']/div[4]/div[3]/fieldset[1]")).isDisplayed() & driver.findElement(By.xpath("//*[@class='wrapper authorizations-tpv']/div[3]/fieldset[2]")).isDisplayed() & driver.findElement(By.xpath("//*[@class='wrapper authorizations-tpv']/div[3]/fieldset[3]")).isDisplayed() ){
				        	 statusTracker(br,driver,"Pass", "'Digital Signature' 'Date' & 'Date of Birth' Present", "Is Present", "Should be present");
				        	 if(return_text(".//*[@class='wrapper authorizations-tpv']/div[3]/fieldset[1]/span", driver).trim().equals(Date))
					         {statusTracker(br,driver,"Pass", "Dates next to each required digital signature auto populate the date with the current date ", "Is Auto populated and matches with the current date ", " Should be Auto populated and matches with the current date");
							 }
							 else
							 {statusTracker(br,driver,"Fail", " dates next to each required digital signature auto populate the date with the current date", "Is not Auto populated and matches with the current date ", "Should be Auto populated and matches with the current date ");
							 }
				         }
				         else
				         {statusTracker(br,driver,"Fail", "'DIgital Signature' 'Date' & 'Date of Birth' Present", "Is not Present", "Should be present");
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
						//	screen_count++; 
					         
				
				         if(driver.findElement(By.xpath("//*[@class='wrapper authorizations-e911']/div[3]/fieldset[1]")).isDisplayed() & driver.findElement(By.xpath("//*[@class='wrapper authorizations-e911']/div[3]/fieldset[2]")).isDisplayed()){
				        	 statusTracker(br,driver,"Pass", "'DIgital Signature' 'Date' & 'Date of Birth' Present", "Is Present", "Should be present");
				        	 if(return_text("//*[@class='wrapper authorizations-e911']/div[3]/fieldset[1]/span", driver).trim().equals(Date))
					         {statusTracker(br,driver,"Pass", "Dates next to each required digital signature auto populate the date with the current date ", "Is Auto populated and matches with the current date ", " Should be Auto populated and matches with the current date");
							 }
							 else
							 {statusTracker(br,driver,"Fail", " dates next to each required digital signature auto populate the date with the current date", "Is not Auto populated and matches with the current date ", "Should be Auto populated and matches with the current date ");
							 }
				         }
				         else
				         {statusTracker(br,driver,"Fail", "'DIgital Signature' 'Date' & 'Date of Birth' Present", "Is not Present", "Should be present");
				         }   
				            
				          Select_DropDown(driver, "//*[@id='birth-month']", "February");
				          statusTracker(br,driver,"", "Month Entered", "", "");
			              Select_DropDown(driver, "//*[@id='birth-date']", "10");	
			              statusTracker(br,driver,"", "Date Entered", "", "");
			              Select_DropDown(driver, "//*[@id='birth-year']", "1950");
			              statusTracker(br,driver,"", "Year Entered", "", "");
			              
			              
			              driver.findElement(By.xpath("//*[@id='full-name2']")).sendKeys("Account Creation");
			              statusTracker(br,driver,"", "Second Full Name Entered", "", "");
			              
				          Thread.sleep(2000); 
				            
				          click_element("//*[@class='arrow']", driver); 
				          Thread.sleep(6000);
				          statusTracker(br,driver,"", "Continue Clicked without filling the User's Full Name", "", "");
				    /*      
				           if(return_text("//*[@class='error-wrap']/ul/li[2]", driver).equalsIgnoreCase("Please enter your full name."))
				           {statusTracker(br,driver,"Pass", "Select the CTA button without entering a digital signature,", "User is presented with error message", "User should be presented with error message");
				           }
				           else
				           {statusTracker(br,driver,"Fail", "Select the CTA button without entering a digital signature,", "User is not presented with error message", "User should be presented with error message");
				           }
				   */         
				            
				          driver.findElement(By.xpath("//*[@id='full-name1']")).sendKeys("Account Creation");
				          statusTracker(br,driver,"", "First Full Name Entered", "", "");
				          Thread.sleep(2000);
				            
				          click_element("//*[@class='arrow']", driver); 
				          Thread.sleep(6000);
				          statusTracker(br,driver,"", "Continue Clicked without check box being clicked", "", "");
			              
			              
				          /*         
			            
				           if(return_text("//*[@class='error-wrap']/ul/li", driver).trim().equalsIgnoreCase("You must read and accept the Consent to Electronic Disclosure in order to continue with your order."))
				           {statusTracker(br,driver,"Pass", "Select the CTA button without entering a digital signature,", "User is presented with error message", "User should be presented with error message");
				           }
				           else
				           {statusTracker(br,driver,"Fail", "Select the CTA button without entering a digital signature,", "User is not presented with error message", "User should be presented with error message");
				           }
			            
			                
				           click_element("//*[@id='tpv-choose-TWC']", driver);
				           Thread.sleep(2000);
				           if(driver.findElement(By.xpath("//*[@id='tpv-choose-TWC']")).isSelected())
					         {statusTracker(br,driver,"Pass", " Validate that User is presented with Time Warner Cable's terms and conditions, defaulted to unchecked ", " Is UnChecked ", " Should be unchecked");
							 }
							 else
							 {statusTracker(br,driver,"Fail", " Validate that User is presented with Time Warner Cable's terms and conditions, defaulted to unchecked ", " Is Checked", "  Should be unchecked");
							 }	
			           */   
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[contains(text(), 'Sign Out')]")).click();
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
				  //    wb1.close();
				      driver.close();
				     
				    }
				  }
}
