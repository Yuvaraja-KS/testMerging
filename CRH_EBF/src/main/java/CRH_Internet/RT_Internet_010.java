
//File Name: RT_Internet_010
//Author: RAHUL JADOW   
//Description of test case: Add Internet - Configure offer equipment
//Date of creation(D/M/Y): 3/19/2014
//Name and date(D/M/Y) of modification: RAHUL JADOW (6/6/204)
//Modification description: Close Current services module/ TWC wifi checked with Radio button while validating / Validating landing to RO page & signing off 


package CRH_Internet;

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
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;

public class RT_Internet_010 extends CommonFunctions {

	String table, tns[];
	String tlimit, username, pwd, ctotal, Uname, Tv_plan, Internet_plan,
			Phone_plan, current_service;
	int tncount;
	String serAddress, Internet_service, Tv_service, Phone_service,
			str_Browser, env;

	public RT_Internet_010() {
	}

	public RT_Internet_010(String s) {
		this.path = s;
		logger.info("Add Internet 010 is intialized");
	}

	public void execute(String br, WebDriver driver, String url, int loc) throws Exception {
		int screen_count = 1;
		File data = new File(this.path);
		WorkbookSettings ws = new WorkbookSettings();
		ws.setLocale(new Locale("er", "ER"));
		//arrcount = 0;
		Workbook wb = Workbook.getWorkbook(data, ws);

		try {
			String tv = "", inet = "", phone = "";
			Sheet sheet2 = wb.getSheet("Internet");
			String Sheet_name = sheet2.getName();
			str_Browser = sheet2.getCell(Col_locator_full_scan_input_sheet("Browser", path,Sheet_name), loc).getContents();
			tlimit = sheet2.getCell(6, loc).getContents();
			username = sheet2.getCell(Col_locator_full_scan_input_sheet("USERNAME", path,Sheet_name), loc).getContents();
			pwd = sheet2.getCell(Col_locator_full_scan_input_sheet("PASSWORD", path,Sheet_name), loc).getContents();
			ctotal = sheet2.getCell(Col_locator_full_scan_input_sheet("C-TOTAL", path,Sheet_name), loc).getContents();
			Uname = sheet2.getCell(Col_locator_full_scan_input_sheet("ACCOUNT NAME", path,Sheet_name), loc).getContents();
			serAddress = sheet2.getCell(11, loc).getContents();
			Tv_service = sheet2.getCell(Col_locator_full_scan_input_sheet("TV SERVICE", path,Sheet_name), loc).getContents();
			Internet_service = sheet2.getCell(Col_locator_full_scan_input_sheet("INTERNET SERVICE", path,Sheet_name), loc).getContents();
			Phone_service = sheet2.getCell(Col_locator_full_scan_input_sheet("PHONE SERVICE", path,Sheet_name), loc).getContents();
			Tv_plan = sheet2.getCell(Col_locator_full_scan_input_sheet("TV PLAN", path,Sheet_name), loc).getContents();
			Internet_plan = sheet2.getCell(Col_locator_full_scan_input_sheet("INTERNET PLAN", path,Sheet_name), loc).getContents();
			Phone_plan = sheet2.getCell(Col_locator_full_scan_input_sheet("PHONE PLAN", path,Sheet_name), loc).getContents();
			/*int tv1 = 0, inet1 = 0, phone1 = 0;
			int val = 1;
			int tlim = Integer.parseInt(tlimit);
			tlim *= 60;
			tlimit = Integer.toString(tlim);
			tlimit = tlimit + "000";*/
			Page_TV = " Page_1_Current Service ";

			Page_Phone = "RT_Internet_010_";
			String int_plan = tv = sheet2.getCell(Col_locator_full_scan_input_sheet("TV SERVICE", path,Sheet_name), loc).getContents();
			String int_eqipment = sheet2.getCell(18, loc).getContents();
			String phone_plan = sheet2.getCell(19, loc).getContents();
			inet = sheet2.getCell(Col_locator_full_scan_input_sheet("INTERNET SERVICE", path,Sheet_name), loc).getContents();
			phone = sheet2.getCell(Col_locator_full_scan_input_sheet("PHONE SERVICE", path,Sheet_name), loc).getContents();
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
					firstrun(br, driver, username, pwd,ctotal, Uname,
							serAddress);

				logger.info("AAshish Check 1");
				// Add Internet as a new service
				click_element(
						".//*[@value='customize_inet']",
						driver);
				logger.info("AAshish Check 2");
				
				Thread.sleep(2000);
				if ((driver
						.findElement(By
								.xpath(".//*[@value='customize_inet']"))
						.isEnabled())) {
					logger.info("Internet Added");
					statusTracker(br,driver, "Pass",
							"Select checkbox to add Internet equ as current service ",
							"check box is selected",
							"check box should be selected");
				} else {
					logger.info("fail2");
					statusTracker(br,driver, "Fail",
							"Select checkbox to add Internet equ as current service",
							"check box is not selected",
							"check box should be selected");
				}

 //to take screenshot and save in file
				try{
		               if (isElementPresent(".//*[contains(text(),'No thanks')]/div",driver))
		                      {
		                         //JS closing Feedback
		                         logger.info("Closing feedback Pop-up");
		                         click_element(".//*[contains(text(),'No thanks')]/div)",driver);
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
		                         exceptionHandler(br, e, driver);
		               }
				File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				File targetFile = new File(spath +"//Test_Results//NewImages//"+ Page_Phone + screen_count + ".png");
				FileUtils.copyFile(screenshot, targetFile);		
				logger.info("copied file into New Images folder"+targetFile);
				
			
if(url.contains("beta"))
                    
	if(url.contains("beta"))
        
    {
    env = "Beta";
    Image_compare(br,env,Page_Phone,spath,screen_count,driver);
    //Image_compare(br,driver, spath+"//Test_Results//StandardImages_Beta//RT_Internet_EBF//RT_Internet_EBF_012_1.png",spath+"//Test_Results//NewImage//RT_Internet_EBF_012_1.png");
   Thread.sleep(5000);
   logger.info("Beta Environment");
   }
   else
   {
	env = "Prod" ;
    Image_compare(br,env,Page_Phone,spath,screen_count,driver);   
   //Image_compare(br,driver, spath+"//Test_Results//StandardImages_Prod//RT_Internet_EBF//RT_Internet_EBF_012_1.png",spath+"//Test_Results//NewImage//RT_Internet_EBF_012_1.png");
   Thread.sleep(5000);
   logger.info("Prod Environment");
   
   }
	screen_count++;
				
				((JavascriptExecutor) driver).executeScript("window.scrollBy(0,600)");
				Thread.sleep(2000);
	
				
				// Select Continue Button so that User navigates to the Phone
				// Select a Plan page.
				click_element("//*[@id='js-main-form']/nav/a/span", driver);
				statusTracker(br,driver, "Pass", "click on Continue button",
						"'Continue button is clicked",
						"should click continue button");
				Thread.sleep(5000);

				// Validating if user has navigated to Internet Select a plan
				// page
				if (return_text(".//*[@class='left']", driver).trim().equals(
						"Customize Your Internet Plan"))
					statusTracker(br,driver, 
							"Pass",
							"Click the Continue Button",
							"User is navigated to the Internet Configuration page",
							"User should navigate to the Internet Configuration page.");
				else
					statusTracker(br,driver, 
							"Fail",
							"Click the Continue Button",
							"User is NOT navigated to the Internet Configuration page",
							"User should navigate to the Internet Configuration page.");

				// Validating if Secondary progress bar should display Internet
				// and should be highlighted
				if (return_text(".//*[@id='content']/div[1]/div/ol/li[1]/div/div/div/ul/li/span", driver).trim().equals(
						"Internet"))
					statusTracker(br,driver, 
							"Pass",
							"Validate the secondary progress bar",
							"Secondary progress bar displays Internet and will be highlighted",
							"Secondary progress bar should display Internet and should be highlighted.");
				else
					statusTracker(br,driver, 
							"Fail",
							"Validate the secondary progress bar",
							"Secondary progress bar will not display Internet and will not be highlighted",
							"Secondary progress bar displays Internet and will be highlighted");

				

				
				// Customize page
				if (driver.findElement(By.xpath("//*[@class='left']"))
						.getText()
						.equalsIgnoreCase("Customize Your Internet Plan")) {
					logger.info("Customization page opens");
					statusTracker(br,driver, "Pass", "it opens phone customization page",
							"it opens phone customization page",
							"it should open phone customization page");
				} else {
					logger.info("customization page does not open");
					statusTracker(br,driver, "fail",
							"it does not open phone customization page",
							"it opens phone customization page",
							"it should open phone customization page");
				}
				Thread.sleep(14000);
				
				
				
				// Current Services module is closed and displays price in $
				String CurrSer = driver.findElement(
						By.xpath(".//*[@class='price last']/sup")).getText();
				logger.info("price is");
				logger.info(CurrSer);
				logger.info("Testing......01");
				String strfind = "$";
				int iSuccess = CurrSer.indexOf(strfind);
				logger.info("{}",iSuccess);

				if (iSuccess < 0) {
					logger.info("price is not present");
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
				String per = " ";

				int iSpace = CurrSer.indexOf(per);
				int iEndAmount = iSpace - 1;
				logger.info("{}",iSpace);

				String sAmount = CurrSer.substring(1, CurrSer.length());
				logger.info("s amount" + sAmount);


				if (sAmount.equals(ctotal)) {
					logger.info("Pass");
					statusTracker(br,driver, 
							"Pass",
							"current service monthly charges should match as per the user",
							"Amount matches", "Amount should match");
				}

				else {
					logger.info("Fail");
					statusTracker(br,driver, 
							"Fail",
							"current service monthly charges should match as per the user",
							"Amount doesnt match", "Amount should match");
				}

				
				// Current services expand
				click_element(".//*[@class='miniCart']/div/header/ul/li[2]/a",
						driver);
				logger.info(" Price read");
				System.out
						.println("Validating sequence of LOB under current services");
				Thread.sleep(4000);

				// validating sequence of LOB under current services
				String CurrSer1 = driver
						.findElement(
								By.xpath(".//*[@class='miniCart']/div/section/div[1]/header/ul/li[2]/h6"))
						.getText();

				if ((CurrSer1.equalsIgnoreCase("Internet"))) {
					logger.info("Right sequence");
					statusTracker(br,driver, "Pass",
							"current sequence matches TV",
							"Sequence matches", "Sequence should match");
				} else {
					logger.info("Wrong sequence");
					statusTracker(br,driver, "Fail",
							"current sequence matches TV",
							"Sequence does not match", "Sequence should match");

				}
				System.out
						.println("Valid sequence of LOB under current services");

				
		// validate information of LOB
				
				// Internet expand
				click_element(
						".//*[@class='miniCart']/div/section/div[1]/header/ul/li[2]/h6",
						driver);
				Thread.sleep(4000);
				

				// TV - internet
				String IntServ = driver
						.findElement(
								By.xpath(".//*[@class='miniCart']/div[1]/section/div[1]/section/div/ul/li[1]"))
						.getText();
				if (IntServ.compareTo(Internet_service) != 0) {
					logger.info("TV service is same as sheet");
					statusTracker(br,driver, "Pass", "TV service is same as sheet",
							"Service matches", "Service should match");
				} else {
					statusTracker(br,driver, "fail", "TV service is same as sheet",
							"Service does not match", "Service should match");
				}

				// Int - Other eqip1
				String int1Serv = driver
						.findElement(
								By.xpath(".//*[@class='miniCart']/div[1]/section/div[1]/section/div/ul/li[2]"))
						.getText();
				if (IntServ.compareTo(Internet_service) != 0) {
					System.out
							.println("Int service TWC modem same as sheet");
					statusTracker(br,driver, "Pass",
							"int service TWC modem is same as sheet",
							"Service matches", "Service should match");
				} else {
					statusTracker(br,driver, "fail",
							"int service TWC modem same as sheet",
							"Service does not match", "Service should match");
				}
				
 //to take screenshot and save in file
				try{
		               if (isElementPresent(".//*[contains(text(),'No thanks')]/div",driver))
		                      {
		                         //JS closing Feedback
		                         logger.info("Closing feedback Pop-up");
		                         click_element(".//*[contains(text(),'No thanks')]/div)",driver);
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
		                         exceptionHandler(br, e, driver);
		               }
				screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				targetFile = new File(spath +"//Test_Results//NewImages//"+ Page_Phone + screen_count + ".png");
				FileUtils.copyFile(screenshot, targetFile);		
				logger.info("copied file into New Images folder"+targetFile);
				
			
				if(url.contains("beta"))
                    
                {
                env = "Beta";
                Image_compare(br,env,Page_Phone,spath,screen_count,driver);
                //Image_compare(br,driver, spath+"//Test_Results//StandardImages_Beta//RT_Internet_EBF//RT_Internet_EBF_012_1.png",spath+"//Test_Results//NewImage//RT_Internet_EBF_012_1.png");
               Thread.sleep(5000);
               logger.info("Beta Environment");
               }
               else
               {
            	env = "Prod" ;
                Image_compare(br,env,Page_Phone,spath,screen_count,driver);   
               //Image_compare(br,driver, spath+"//Test_Results//StandardImages_Prod//RT_Internet_EBF//RT_Internet_EBF_012_1.png",spath+"//Test_Results//NewImage//RT_Internet_EBF_012_1.png");
               Thread.sleep(5000);
               logger.info("Prod Environment");
               
               }
				screen_count++;

				/*
				// Tv - Other eqip2
				String TV2Serv = driver
						.findElement(
								By.xpath(".//*[@class='miniCart']/div[1]/section/div[1]/section/div/ul/li[3]"))
						.getText();
				if (IntServ.compareTo(Internet_service) != 0) {
					System.out
							.println("Int service 3 whole house services is same as sheet");
					statusTracker(br,driver, 
							"Pass",
							"Int service 3 whole house services is same as sheet",
							"Service matches", "Service should match");
				} else {
					statusTracker(br,driver, 
							"fail",
							"Int service is 3 whole house services same as sheet",
							"Service does not match", "Service should match");
				}

				// Tv - Other eqip3
				String TV3Serv = driver
						.findElement(
								By.xpath(".//*[@class='miniCart']/div[1]/section/div[1]/section/div/ul/li[4]"))
						.getText();
				if (IntServ.compareTo(Internet_service) != 0) {
					System.out
							.println("Int service TWC modem is same as sheet");
					statusTracker(br,driver, "Pass",
							"Int service Digital box is same as sheet",
							"Service matches", "Service should match");
				} else {
					statusTracker(br,driver, 
							"fail",
							"Int service is 3 whole house services same as sheet",
							"Service does not match", "Service should match");
				}
*/
				// Int collapse
				click_element(
						".//*[@class='miniCart']/div/section/div[1]/header/ul/li[2]/h6",
						driver);
				logger.info("Int colapse");
				statusTracker(br,driver, 
						"Pass",
						"Close Current services - Int collapse",
						"Close Current services - Int collapse", "Should Close Current services - Int collapse");
				Thread.sleep(4000);

				//Close Current services
				// Current services expand
				click_element(".//*[@class='miniCart']/div/header/ul/li[2]/a",
						driver);
				statusTracker(br,driver, 
						"Pass",
						"Close Current services",
						"Close Current services", "Should Close Current services");
				
				
				// Verify that Internet plan available in the market display for
				// the new Internet customer
				System.out
						.println("Validated information of LOB Internet plan");

				// Verify that all Internet plans available in the market
				// display for the new Internet customer
				logger.info("Validating Internet plans");

	
//*********************************************************************************************************				
				
				/*// Select "Compare Internet Plans Equipment" link
				
				
				
				click_element(".//*[@title='Compare Internet Plans']", driver);
				Thread.sleep(5000);

				if (return_text(
						".//*[@class='modal-title']", driver)
						.equalsIgnoreCase("Internet Plans at a Glance")) {
					System.out
							.println(" Compare Internet Plans page is opened");
					statusTracker(br,driver, "Pass",
							"Compare Internet Plans page is opened", "Matches",
							"Compare Internet Plans page should open");
				} else {
					statusTracker(br,driver, "Fail",
							"Compare Internet Plans page is not opened",
							"does not Match",
							"Compare Internet Plans page should open");
				}

				// Select "Close" on Compare Internet Plans Equipment link
				click_element(
						".//*[@class='modal-button-close']",
						driver);
				Thread.sleep(4000);*/
				
			
//*********************************************************************************************************	

				// Verify Internet plan Equipment
				if ((driver
						.findElement(By
								.xpath(".//*[@id='js-main-form']/div[2]/div[1]/header/ul/li[2]/h3"))
						.isDisplayed())
						|| (driver
								.findElement(By
										.xpath(".//*[@id='js-main-form']/div[2]/div[2]/header/ul/li[2]/h3"))
								.isDisplayed())) {
						
					logger.info("All Internet Plans Equipment Present");
					statusTracker(br,driver, 
							"Pass",
							"All Internet Plans Equipment Present and in correct order in new Internet customer",
							"All Internet Plans Present",
							"All Internet Plans should be Present");

				} else {
					logger.info("All Internet Plans are not Present");
					statusTracker(br,driver, 
							"fail",
							"All Internet Plans Equipment Present and in correct order in new Internet customer",
							"All Internet Plans not Present",
							"All Internet Plans should be Present");
				}
				// end of if
				logger.info("Validated All Internet Plan Equipment");


				// Internet Equipment
				if (driver
						.findElement(
								By.xpath(".//*[@class='blue-button checked js-inputButton-initialized']"))
						.isDisplayed()) {
					statusTracker(br,driver, 
							"Pass",
							"Validate the radio buttons clicked for equipment options",
							"Radio button for add equipment options present",
							"Radio Button Should be present");
				} else {
					statusTracker(br,driver, 
							"Fail",
							"Validate the radio buttons clicked for add equipment options",
							"Radio button for add equipment options not present",
							"Radio Button Should be present");
				}
if(return_text(".//*[@id='js-main-form']/div[2]/div[1]/header/ul/li[3]/em", driver).trim().equalsIgnoreCase("Current Service"));

{
	logger.info("Current service");


statusTracker(br,driver, "Pass", "Internet Modem text displayed", "text displayed",
		"Internet Modem text should display");

}	

 
			

			// Click select
				click_element(
						".//*[@class='blue-button checked js-inputButton-initialized']",
						driver);
				Thread.sleep(4000);

				// click expand - Internet modem
				click_element(
						".//*[@id='js-main-form']/div[2]/div[1]/header/ul/li[1]/a",
						driver);
				Thread.sleep(3000);
				{
					logger.info("Internet Modem Expand");
					statusTracker(br,driver, "Pass", "Internet Modem Expand", "Expanded",
							"Internet modem Expanded");
				}
				// close Internet
				click_element(
						".//*[@id='js-main-form']/div[2]/div[1]/header/ul/li[1]/a",
						driver);
				Thread.sleep(3000);

				// click expand - Internet Home WiFi and Internet Modem
				click_element(
						".//*[@id='js-main-form']/div[2]/div[2]/header/ul/li[1]/a",
						driver);
				Thread.sleep(3000);
				
				{
					System.out
							.println("Internet Home WiFi and Internet Modem Expand");
					statusTracker(br,driver, "Pass", "Internet Modem Expand", "Expanded",
							"Home WiFi and Internet Modem Expanded");
				}
				
				// close Internet
				click_element(
						".//*[@id='js-main-form']/div[2]/div[2]/header/ul/li[1]/a",
						driver);
				Thread.sleep(3000);
/*
				
				// click expand - Internet I'll use my own modem
				click_element(
						".//*[@id='js-main-form']/div[2]/div[3]/header/ul/li[1]/a",
						driver);
				Thread.sleep(3000);
				{
					logger.info("Internet I'll use my own modem Expand");
					statusTracker(br,driver, "Pass",
							"Internet I'll use my own modem Expand",
							"Expanded", "I'll use my own modem Expanded");
				}
				// close Internet
				click_element(
						".//*[@id='js-main-form']/div[2]/div[3]/header/ul/li[1]/a",
						driver);
				Thread.sleep(3000);
*/
				
				
				// Click select radio button - Home wifi 
				click_element(
						".//*[@id='js-main-form']/div[2]/div[2]/header/ul/li[4]/label",
						driver);
				statusTracker(br,driver, "Pass", "Home WiFi and Wireless Gateway",
						"User selects Home WIFI and internet modem" , "User should be selected with Home WiFi and Wireless Gateway");
				Thread.sleep(4000);
				
 //to take screenshot and save in file
				
				screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				targetFile = new File(spath +"\\Test_Results\\NewImages\\"+ Page_Phone + screen_count + ".png");
				FileUtils.copyFile(screenshot, targetFile);		
				logger.info("copied file into New Images folder"+targetFile);
				
			
				if(url.contains("beta"))
                    
                {
                env = "Beta";
                Image_compare(br,env,Page_Phone,spath,screen_count,driver);
                //Image_compare(br,driver, spath+"//Test_Results//StandardImages_Beta//RT_Internet_EBF//RT_Internet_EBF_012_1.png",spath+"//Test_Results//NewImage//RT_Internet_EBF_012_1.png");
               Thread.sleep(5000);
               logger.info("Beta Environment");
               }
               else
               {
            	env = "Prod" ;
                Image_compare(br,env,Page_Phone,spath,screen_count,driver);   
               //Image_compare(br,driver, spath+"//Test_Results//StandardImages_Prod//RT_Internet_EBF//RT_Internet_EBF_012_1.png",spath+"//Test_Results//NewImage//RT_Internet_EBF_012_1.png");
               Thread.sleep(5000);
               logger.info("Prod Environment");
               
               }
				screen_count++;
				// Click select radio button - Own modem
				

				// Click continue
				click_element(
						".//*[@id='content']/div[3]/div[2]/div/div[2]/div/nav/a[2]/span",
						driver);
				
				Thread.sleep(10000);

				
				//validate display of review order page
				   if(return_text(".//*[@class='left']/h2", driver).equalsIgnoreCase("Choose Installation & Review Order"))
					{statusTracker(br,driver, "Pass", "User finishes the LOS configuration and selects the continue CTA",
							"User is displayed with Review order page" , "User should be displayed with Review order page");
					}
					else
					{statusTracker(br,driver, "Fail", "User finishes the LOS configuration and selects the continue CTA",
							"User is displayed with Review order page" , "User should be displayed with Review order page");
					}
				  
				   //to take screenshot and save in file
					
					screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
					targetFile = new File(spath +"//Test_Results//NewImages//"+ Page_Phone + screen_count + ".png");
					FileUtils.copyFile(screenshot, targetFile);		
					logger.info("copied file into New Images folder"+targetFile);
					
				
if(url.contains("beta"))
	                    
	                {
	                env = "Beta";
	                Image_compare(br,env,Page_Phone,spath,screen_count,driver);
	                //Image_compare(br,driver, spath+"//Test_Results//StandardImages_Beta//RT_Internet_EBF//RT_Internet_EBF_012_1.png",spath+"//Test_Results//NewImage//RT_Internet_EBF_012_1.png");
	               Thread.sleep(5000);
	               logger.info("Beta Environment");
	               }
	               else
	               {
	            	env = "Prod" ;
	                Image_compare(br,env,Page_Phone,spath,screen_count,driver);   
	               //Image_compare(br,driver, spath+"//Test_Results//StandardImages_Prod//RT_Internet_EBF//RT_Internet_EBF_012_1.png",spath+"//Test_Results//NewImage//RT_Internet_EBF_012_1.png");
	               Thread.sleep(5000);
	               logger.info("Prod Environment");
	               
	               }
					screen_count++;
				   
				//Sign out   
					scrollToElementByLinkText("Sign Out",driver);
					driver.findElement(By.linkText("Sign Out")).click();
					Thread.sleep(10000);
					if (Isavailable(".//*[@class='twc-last js-last']/a", driver))
						statusTracker(br,driver, "Pass", "Click on the Sign out button",
								"Customer is Logged Out from the current session.",
								"Customer should Log Out");
					else
						statusTracker(br,driver, 
								"Fail",
								"Click on the Sign out button",
								"Customer is NOT Logged Out from the current session.",
								"Customer should Log Out");
					
					
				driver.quit();	
			} 
			catch (Exception e) 
			{
				exceptionHandler(br, e, driver);
				logger.info("error is : " + e.getMessage());
			}
		} catch (Exception e) {

			exceptionHandler(br, e, driver);

		} finally {
			wb.close();
			// wb1.close();
			driver.close();

		}
	
	}


}
