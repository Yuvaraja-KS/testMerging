//File Name: RT_RO_OS_010
//Author: 
//Description of test case: Order Summary  - ECK Mail Delivery
//Date of creation(D/M/Y): 11/3/2014
//Name and date(D/M/Y) of modification: Raveena Singh  09/06/2014

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

public class RT_RO_OS_010 extends CommonFunctions {

	

				String table, tns[];
				String tlimit, username, pwd, ctotal, Uname, Tv_plan, Internet_plan,Phone_plan, current_service;
				int tncount,flag;
				String serAddress, Internet_service, Tv_service, Phone_service;

	public RT_RO_OS_010()
	{
	}

	public RT_RO_OS_010(String s) 
	{
				this.path = s;
				//this.path1 = internet;
				logger.info("RO_OS_010 is intialized");
	}

	public RT_RO_OS_010(String s, String t,String p,String i) {
		this.path = s;
		this.path1 = t;
		this.path2 = p;
		this.path3 = i;

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
      
	    
	   /* File data_tv = new File(this.path1);
	    WorkbookSettings ws_tv = new WorkbookSettings();
	    ws.setLocale(new Locale("er", "ER"));
	    arrcount=0;
	    logger.info("chheck1");
	    Workbook wb_tv = Workbook.getWorkbook(data_tv, ws_tv);
	    Sheet sheet_tv = wb_tv.getSheet(0);

	    
	    File data_phone = new File(this.path2);
	    WorkbookSettings ws_phone = new WorkbookSettings();
	    ws.setLocale(new Locale("er", "ER"));
	    arrcount=0;
	    logger.info("chheck1");
	    Workbook wb_phone = Workbook.getWorkbook(data_phone, ws_phone);
	    Sheet sheet_phone = wb_phone.getSheet(0);
	    
	    File data_internet = new File(this.path3);
	    WorkbookSettings ws_internet = new WorkbookSettings();
	    ws.setLocale(new Locale("er", "ER"));
	    arrcount=0;
	    logger.info("chheck1");
	    Workbook wb_internet = Workbook.getWorkbook(data_internet, ws_internet);
	    Sheet sheet_internet = wb_internet.getSheet(0);

	*/
	  

		
		
	
	


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

                  
		//	tv = sheet2.getCell(12, loc).getContents();
		//	inet = sheet2.getCell(14, loc).getContents();
		//	phone = sheet2.getCell(16, loc).getContents();
	/*			int tv1 = 0, inet1 = 0, phone1 = 0;
				int val = 1;
				int tlim = Integer.parseInt(tlimit);
				tlim *= 60;
				tlimit = Integer.toString(tlim);
				tlimit = tlimit + "000";*/
                 String equipment[]= new String[10];
			// manju variable

		//	String int_plan = tv = sheet2.getCell(26, loc).getContents();
		//	String int_eqipment = sheet2.getCell(32, loc).getContents();
		//	String phone_plan = sheet2.getCell(28, loc).getContents();

		//	inet = sheet2.getCell(20, loc).getContents();
		//	phone = sheet2.getCell(22, loc).getContents();
		//	String cost_current_sevice_input = sheet2.getCell(12, loc).getContents();

			    if (first == 0) {
				logger.info("trying to open the url");
				driver.manage().window().maximize();
				driver.get(url);
				logger.info("Chek if url opened");
				// statusTracker("Pass", " ", " ", " ");
			    }

		try 
				{
			      if(first==0)
				  firstrun(br,driver,username,pwd,ctotal,Uname,serAddress);
				  logger.info("I went to next step");
				 
				  
				
				  
				// If TV is active on the account, select "Add Boxes & channels"
					/*click_element(".//*[@value='customize_tv']",
							driver);
					Thread.sleep(2000);
					if ((driver.findElement(By
							.xpath("//*[@id='js-main-form']/nav/a")).isEnabled())) {
						logger.info("pass1");
						statusTracker("Pass", "For TV active on the account select Add Boxes & channels",
								"TV Add Boxes & channels check box is selected", "TV Add Boxes & channels check box should be selected");
					} else {
						logger.info("fail1");
						statusTracker("Fail", "For TV active on the account select Add Boxes & channels",
								"Add Boxes & channels check box is not selected", "Add Boxes & channels check box should be selected");
					}*/
				  driver.findElement(By.xpath("//*[@name='upgrade_tv']")).click();
					//driver.findElement(By.xpath("//*[@name='select_inet']")).click();
					//driver.findElement(By.xpath("//*[@name='select_phone']")).click();
					
				  
					//Select Continue Button so that User navigates to the TV Select a Plan page.
					click_element("//*[@class='js-next-button blue-button']/span",driver);
					statusTracker(br,driver,"Pass", "clck on Continue button",
							"'Continue button is clicked", "should click continue button");
					Thread.sleep(5000);
					
					// Validating if user has navigated to TV Select a plan page
					if (return_text(".//*[@class='left']/h2/strong",driver).trim().equals("TV Plan"))
						statusTracker(br,driver,"Pass",
								"Click the Continue Button",
								"User is navigated to the TV Configuration page",
								"User should navigate to the TV Configuration page.");
					else
						statusTracker(br,driver,"Fail",
								"Click the Continue Button",
								"User is NOT navigated to the TV Configuration page",
								"User should navigate to the TV Configuration page.");
					
					driver.findElement(By.xpath("//*[@data-enrichedname='Standard TV']/li[5]/div/a")).click();
					Thread.sleep(8000);
					driver.findElement(By.xpath(".//*[@class='tv-equipment']/form/div[2]/header/ul/li[1]/a")).click();
					Thread.sleep(1000);
					driver.findElement(By.xpath(".//*[@class='tv-equipment']/form/div[2]/header/ul/li[1]/a")).click();
					// config_page_Cart_result_updater_TV_Package(driver);
					   Thread.sleep(6000);
					//driver.findElement(By.xpath(".//*[@id='content']/div[3]/div[2]/div/div[2]/div/nav/a[2]")).click();
					   driver.findElement(By.xpath(".//*[@class='js-next-button blue-button right']")).click();
					   Thread.sleep(6000);
					
				
					//click_element(".//*[@id='content']/div[3]/div[2]/div/div[2]/div/div[2]/div/div[2]/div[1]/section/div/div[5]/form/div/header/ul/li[1]/a",
							//driver);
		
					  //Thread.sleep(4000);
	            	 //Select_DropDown(driver, "//*[@data-name='HD Box']", "3");
	                 // Thread.sleep(5000);
					
				  
	                  
	                  
	                  
	              	//click_element(".//*[@class='js-next-button blue-button right']",driver);
		
					  Thread.sleep(6000);
	                  
					// Validating if user has navigated to Installation & Review Order page
						if (return_text(".//*[@class='left']/h2",driver).trim().equals("Choose Installation & Review Order"))
							statusTracker(br,driver,"Pass",
									"Click to navigat to Installation & Review Order",
									"User is navigated to the Installation & Review Order page",
									"User should navigate to the Installation & Review Order page.");
						else
							statusTracker(br,driver,"Fail",
									"Click to navigat to Installation & Review Order",
									"User is NOT navigated to the Installation & Review Order page",
									"User should navigate to the Installation & Review Order page.");
			
	                  
						click_element(".//*[@id='section-mail']/header/label/p/strong ",driver);
						statusTracker(br,driver,"Pass", "Select Mail my Easy Connect Kit(s) to my home. option",
								"Mail my Easy Connect Kit(s) to my home.option is selected", "Mail my Easy Connect Kit(s) to my home.option should be selected");
						Thread.sleep(9000);
	                  
					  
					  
 String one_time_charges=driver.findElement(By.xpath(".//*[@title='One Time Charges']/tfoot/tr/td[2]")).getText();
	             
   String total_monthly_charges=driver.findElement(By.xpath(".//*[@title='Monthly Charges']/tfoot/tr/td[2]")).getText();
 
   String Easy_Connect_Pick_up_Fee=driver.findElement(By.xpath(".//*[@class='services-table']/tbody/tr[1]/td[2]")).getText();
   Thread.sleep(6000);
   
   click_element(".//*[@class='js-next-button blue-button']",driver);
   
   Thread.sleep(6000);
					  

   
  /* 
   //for TV
   int flag=0;
   logger.info("*******************for TV");
   if(driver.findElement(By.xpath(".//*[@id='content']/div[3]/div[2]/div[2]/div/div/div/div[1]/div/div/div[1]/table/tbody/tr[1]/th")).getText().equalsIgnoreCase("TV"))
   {
   
	  
   for(int i=0;i<carttotal1;i++)
   {
                   if(itemname1[i].equalsIgnoreCase(driver.findElement(By.xpath("//*[@class='monthly-charges module']/table/tbody/tr["+(i+2)+"]/td[1]")).getText()))
                                                   {
                                   flag=1;
                                   continue;
                                                   }
                   else
                   {
                                   flag=0;break;
                   }
   }
   if (flag==1)
   {
                   statusTracker("Pass", "All the tv services added is matching", "All the tv services added is matching", "All the tv services added should match");
   }
   else
   {
                   statusTracker("Fail", "All the tv services added is not matching", "All the tv services added is not matching", "All the tv services added should match");
                   
   } */
   
   
					  
					  
				        //verifying total monthly charges!
                      logger.info("************************verifying total monthly charges!**********************");
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
Thread.sleep(6000);

//verifying fees!
logger.info("************************verifying Easy_Connect_Pick_up_Fee fees!**********************");
if(driver.findElement(By.xpath("//*[@class='services-table']/tbody/tr[1]/td[2]")).getText().equalsIgnoreCase(Easy_Connect_Pick_up_Fee)) 
{
logger.info("Easy_Connect_Pick_up_Fee total matching!");
statusTracker(br,driver,"Pass", "Easy_Connect_Pick_up_Fee total matching", "Easy_Connect_Pick_up_Fee total matching", "Easy_Connect_Pick_up_Fee total should match");
}
else
{
logger.info("Easy_Connect_Pick_up_Fee total not matching!");
statusTracker(br,driver,"Fail", "Easy_Connect_Pick_up_Fee total not matching", "Easy_Connect_Pick_up_Fee total not matching", "Easy_Connect_Pick_up_Fee total should match");

}     
Thread.sleep(6000);


//verifying current one time charges!
      logger.info("************************verifying current one time charges!**********************");
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

					  
Thread.sleep(6000);			  
            
	               
						// Validate the Ship Easy Connect Kit Installation Option selected on the Review Order page displays
	                  /*
						if (return_text(".//*[@class='order-details details-block']/div/div[2]/h4",driver).trim().equals("Easy Connect Kit(s)"))
							statusTracker("Pass",
									"Easy Connect Kit Installation Option selected on the Review Order page displays",
									"The Install Option Easy Connect Kit(s) is displayed",
									"The Install Option Easy Connect Kit(s) should be displayed");
						else
							statusTracker("Fail",
									"Easy Connect Kit Installation Option selected on the Review Order page displays",
									"The Install Option Easy Connect Kit(s) is not displayed",
									"The Install Option Easy Connect Kit(s) should be displayed");
						
						
						
						// Validate all equipment included in order for each LOB/LOS configuration is displayed in the In Ship connect kit section
						
						String CurrSer1 =driver.findElement(By.xpath(".//*[@class='order-details details-block']/div/div[2]/h4")).getText();
						String CurrSer2 =driver.findElement(By.xpath(".//*[@class='order-details details-block']/div[1]/div[3]/ul/li")).getText();
						   
						   if ((CurrSer1.equalsIgnoreCase("Easy Connect Kit(s)")))
							   if((CurrSer2.equalsIgnoreCase("TV Equipment")))
							   {
								   logger.info("equipment included in order for each LOB/LOS configuration is displayed in the In easy connect kit section");
								   statusTracker("Pass", "equipment included in order configuration is displayed in the in Easy connect kit section", "Order is in in Easy connect kit section", "Order should be in in Easy connect kit section");
							   }
							   else
							   {
								   logger.info("equipment included in order for each LOB/LOS configuration is not displayed in the in Easy connect kit section");
								   statusTracker("Fail", "equipment included in order configuration is displayed in the in Easy connect kit section", "Order is not in in Easy connect kit section", "Order should be in in Easy connect kit section");
								   
							   }
						   
						   */


if (return_text(".//*[@class='order-details details-block']/div/div[2]/h4",driver).trim().equals("Easy Connect Kit(s)"))
	statusTracker(br,driver,"Pass",
			"Easy Connect Kit Installation Option selected on the Review Order page displays",
			"The Install Option Easy Connect Kit(s) is displayed",
			"The Install Option Easy Connect Kit(s) should be displayed");
else
	statusTracker(br,driver,"Fail",
			"Easy Connect Kit Installation Option selected on the Review Order page displays",
			"The Install Option Easy Connect Kit(s) is not displayed",
			"The Install Option Easy Connect Kit(s) should be displayed");

Thread.sleep(6000);

// Validate all equipment included in order for each LOB/LOS configuration is displayed in the In Ship connect kit section

String CurrSer1 =driver.findElement(By.xpath(".//*[@class='order-details details-block']/div/div[2]/h4")).getText();
Thread.sleep(6000);
String CurrSer2 =driver.findElement(By.xpath(".//*[@class='col rtf']/ul/li")).getText();
   
   if ((CurrSer1.equalsIgnoreCase("Easy Connect Kit(s)")))
	   if((CurrSer2.equalsIgnoreCase("TV Equipment")))
	   {
		   logger.info("equipment included in order for each LOB/LOS configuration is displayed in the In easy connect kit section");
		   statusTracker(br,driver,"Pass", "equipment included in order configuration is displayed in the in Easy connect kit section", "Order is in in Easy connect kit section", "Order should be in in Easy connect kit section");
	   }
	   else
	   {
		   logger.info("equipment included in order for each LOB/LOS configuration is not displayed in the in Easy connect kit section");
		   statusTracker(br,driver,"Fail", "equipment included in order configuration is displayed in the in Easy connect kit section", "Order is not in in Easy connect kit section", "Order should be in in Easy connect kit section");
		   
	   }

   Thread.sleep(6000);

			                //Validate that OrderSummary page displays the same service address displayed in review order page
         //String servAddr = (return_text(".//*[@class='order-details details-block']/div[1]/div[1]/p",driver).replace(Uname,"")).trim();
         //logger.info(" service address :   "+ servAddr);
   String servAddr = driver.findElement(By.xpath(".//*[@class='location']")).getText().trim();
   logger.info(" service address :   "+ servAddr);
   logger.info(" service address from sheet is :   "+ serAddress);
   if(url.contains("beta"))
   {
   if(servAddr.trim().replaceAll(" ", "").equalsIgnoreCase(serAddress.trim().replaceAll(" ", "")))
  	 
   {
  	 logger.info("Service Adress from input sheet:" +serAddress);
                   logger.info("service address is matching!");
                   statusTracker(br,driver,"Pass", "service address is matching", "service address is matching", "service address should match");
                   }
                   else
                   {
                   logger.info("service address is not matching!");
                   statusTracker(br,driver,"Fail", "service address is not matching", "service address is not matching", "service address should match");
                   }
   }
   Thread.sleep(6000);
   //Validate The Mail Delivery Details and requirements to receive the ECK are displayed in the Ship Easy Connect Kit Section
   String CurrSer3 =driver.findElement(By.xpath(".//*[@class='mailToHomeTitle mainHeader']/h4")).getText();
   String CurrSer4 =driver.findElement(By.xpath(".//*[@class='mainHeader mailToHomeSubtitle1']/h5")).getText();
   String CurrSer5 =driver.findElement(By.xpath(".//*[@class='mainHeader mailToHomeSubtitle2']/h5")).getText();
   if ((CurrSer3.equalsIgnoreCase("Easy Connect Kit(s)")))
          if((CurrSer4.equalsIgnoreCase("These Easy Connect Kit(s) will be shipped to you:")))
      	   if((CurrSer5.equalsIgnoreCase("Please note:")))
       		  
       	  
          {
                logger.info(" The Mail Delivery Details and requirements to receive the ECK are displayed in the Ship Easy Connect Kit Section");
                statusTracker(br,driver,"Pass", "The Mail Delivery Details and requirements to receive the ECK are displayed in the Ship Easy Connect Kit Section", "The Mail Delivery Details and requirements to receive the ECK are displayed in the Ship Easy Connect Kit Section", "The Mail Delivery Details and requirements to receive the ECK should be displayed in the Ship Easy Connect Kit Section");
          }
          else
          {
                logger.info("The Mail Delivery Details and requirements to receive the ECK are not displayed in the Ship Easy Connect Kit Section");
                statusTracker(br,driver,"Fail", "The Mail Delivery Details and requirements to receive the ECK are displayed in the Ship Easy Connect Kit Section", "The Mail Delivery Details and requirements to receive the ECK are not displayed in the Ship Easy Connect Kit Section", "The Mail Delivery Details and requirements to receive the ECK should be displayed in the Ship Easy Connect Kit Section");
                
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
   
   // Selecting the check box for the Terms & Conditions
   drive.findElement(By.xpath(".//*[@name='order-choose-TWC']")).click();
   logger.info("Selected the check box Terms & Conditions");
   statusTracker(br,driver,"Pass",
           "Selected the check box Terms & Conditions",
           "Selected the check box Terms & Conditions",
           "Check box Terms & Conditions should be selected");

						        
				           
				}
        
		catch (Exception e)
		 {
		exceptionHandler(br,e, driver);
		                                                                                                      
		 }
		 }
		 finally {
		 wb.close();
		 //wb1.close();
		 driver.close();
		                                                                                                     
		 }
		                                                                                                  
		 }			  
				  
				  
				  
                                                                                            
  }
