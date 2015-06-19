

//File Name: RT_Phone_016
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

public class RT_Phone_016 extends CommonFunctions {

	

				String table, tns[];
				String tlimit, username, pwd, ctotal, Uname, Tv_plan, Internet_plan,Phone_plan, current_service;
				int tncount;
				String serAddress, Internet_service, Tv_service, Phone_service;

	public RT_Phone_016()
	{
	}

	public RT_Phone_016(String s) 
	{
				this.path = s;
			//	this.path1 = internet;
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
			    Page_Phone="RT_Phone_016_";
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
				  
					// If Phone is active on the account, select "Upgrade & Add feature"
					click_element(".//*[@value='upgrade_phone']",
							driver);
					Thread.sleep(2000);
					
					
			//		click_element(".//*[@class='current services']/li/div[3]/ul/li[2]/label/input",driver);
					
					if ((driver.findElement(By
							.xpath("//*[@class='button-nav ']/a")).isEnabled())) {
						logger.info("pass1");
						statusTracker(br,driver,"Pass", "For Phone active on the account select Upgrade & Add feature",
								"Upgrade & Add feature check box is selected", "Upgrade & Add feature check box should be selected");
					} else {
						logger.info("fail1");
						statusTracker(br,driver,"Fail", "For Phone active on the account select Upgrade & Add feature",
								"Upgrade & Add feature check box is not selected", "Upgrade & Add feature check box should be selected");
					}  
					
					
					  
					//Select Continue Button so that User navigates to Choose Phone plan page
					click_element("//*[@class='button-nav ']/a",driver);
					statusTracker(br,driver,"Pass", "clck on Continue button",
							"'Continue button is clicked", "should click continue button");
					Thread.sleep(8000);
					
					
					
					
					// Validating if user has navigated to Choose Phone plan page
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
					
					
					  //Click to navigate to Customize your phone service page
					click_element(".//*[@class='checkoutCTA']/a/span",driver);
					statusTracker(br,driver,"Pass", "clck on Select button",
							"'Select button is clicked", "should click Select button");
					Thread.sleep(10000);
					
					

					// Validating if user has navigated to Phone Configuration Page where Phone features displayed
					if (return_text(".//*[@class='phoneSelectTable selectTable']/div/header/ul/li/h3/div/p",driver).trim().equals("Select Optional Features & Calling Plans"))
						statusTracker(br,driver,"Pass",
								"Click the Continue Button",
								"User is navigated to the Phone Configuration page",
								"User should navigate to the Phone Configuration page");
					else
						statusTracker(br,driver,"Fail",
								"Click the Continue Button",
								"User is NOT navigated to the Phone Configuration page",
								"User should navigate to the Phone Configuration page");			
					
					//validate that a International Plan  section displays within the Features section
					String CurrSer1 =driver.findElement(By.xpath(".//*[@class='phoneSelectTable selectTable']/div/header/ul/li/h3/div/p")).getText();
                    String CurrSer2 =driver.findElement(By.xpath(".//*[@class='content-wrap']/div[5]/h4/div/p/strong")).getText();
                    if ((CurrSer1.equalsIgnoreCase("Select Optional Features & Calling Plans")))
                           if((CurrSer2.equalsIgnoreCase("Select an International Calling Plan (choose one)")))
                           {
                                 logger.info(" right sequence!!");
                                 statusTracker(br,driver,"Pass", "International Plan  section displays within the Features section", "Sequence matches", "Sequence should match");
                           }
                           else
                           {
                                 logger.info("wrong sequence!!");
                                 statusTracker(br,driver,"Fail", "International Plan  section displays within the Features section", "Sequence does not match", "Sequence should match");
                                 
                           }
                    logger.info("International Plan  section displays within the Features section");
				
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
                    
                    
		//Validate that the "Select New or Transfer Your Phone" section does not display on the Phone configuration page due to the customer being an existing phone customer 
				  
                    if (Isavailable("//*[@data-pagetype='select or transfer number']", drive))
                    {
                    	logger.info("fail1");
						statusTracker(br,driver,"Fail", "For customer being an existing phone customer",
								"Select New or Transfer Your Phone section is display on the Phone Configuration page", "Select New or Transfer Your Phone section should not display on the Phone Configuration page");
                   
					} else {

                    
                    	logger.info("pass1");
						statusTracker(br,driver,"Pass", "For customer being an existing phone customer",
								"Select New or Transfer Your Phones ection does not display on the Phone Configuration page", "Select New or Transfer Your Phone section should not display on the Phone Configuration page");
					}    
				  
				  
				  
				  
                  //Validate that the "Digital Phone Customer Authorization" section does not display on the Phone Configuration page due to the customer being an existing phone customer
  				  
  				  
                     if (Isavailable("//*[@data-pagetype='agreements']", drive))
                    {
                    	logger.info("fail1");
						statusTracker(br,driver,"Fail", "For customer being an existing phone customer",
								"Digital Phone Customer Authorization is display on the Phone Configuration page","Digital Phone Customer Authorization should not display on the Phone Configuration page");
                   
					} else {

                    
                    	logger.info("pass1");
						statusTracker(br,driver,"Pass", "For customer being an existing phone customer",
								"Digital Phone Customer Authorization is not displayed on the Phone Configuration page","Digital Phone Customer Authorization should not display on the Phone Configuration page");
					}    
				  	  
				  
                    Thread.sleep(5000);		
				  
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