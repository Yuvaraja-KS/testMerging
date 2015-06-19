
//File Name: RT_Internet_012
//Author: RAVEENA    
//Description of test case: Upgrade Internet - user has own modem 
//Date of creation(D/M/Y): 3/19/2014
//Name and date(D/M/Y) of modification: RAHUL JADOW (6/6/204)
//Modification description: Verified the Current service (I’ll use my own modem) / Navigate to RO page and sign out.


package CRH_Internet;

import java.io.File;
import java.util.Locale;

import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class RT_Internet_012 extends CommonFunctions {

	String table, tns[];
	String tlimit, username, pwd, ctotal, Uname, Tv_plan, Internet_plan,
			Phone_plan, current_service;
	int tncount;
	String env;
	String serAddress, Internet_service, Tv_service, Phone_service,
			str_Browser;

	public RT_Internet_012() {
	}

	public RT_Internet_012(String s) {
		this.path = s;
		logger.info("Add Internet 012 is intialized");
	}

	public void execute(String br, WebDriver driver, String url, int loc) throws Exception {
		int screen_count = 1;
		File data = new File(this.path);
		WorkbookSettings ws = new WorkbookSettings();
		ws.setLocale(new Locale("er", "ER"));
		//arrcount = 0;
		logger.info("chheck1");
		Workbook wb = Workbook.getWorkbook(data, ws);

		try {
			String tv = "", inet = "", phone = "";
			Sheet sheet2 = wb.getSheet("Internet");
			String Sheet_name = sheet2.getName();
			Page_Phone = "RT_Internet_012_";
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


				
				click_element(
						".//*[@value='customize_inet']",
						driver);
				Thread.sleep(2000);
//to take screenshot and save in file
				
				File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				File targetFile = new File(spath +"\\Test_Results\\NewImages\\"+ Page_Phone + screen_count + ".png");
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
				
				
				((JavascriptExecutor) driver).executeScript("window.scrollBy(0,600)");
				Thread.sleep(2000);
				
				
				click_element("//*[@id='js-main-form']/nav/a", driver);
				Thread.sleep(8000);

				//validating Internet page
				logger.info("validating internet configuration page");
				if ((driver
						.findElement(
								By.xpath("//*[@id='content']/div[1]/div/ol/li[1]/div/div/span"))
						.getText().equalsIgnoreCase("1"))) {
					logger.info("Configuration page!!");
					statusTracker(br,driver, "Pass", "Configuration page!!",
							"Configuration page is present!!",
							"Configuration page should be present!!");
				} else {
					logger.info("fail1");
					statusTracker(br,driver, "Fail", "Configuration page not present!!",
							"Configuration page is  not present!!",
							"Configuration page should be present");
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
				
				// validate secondary progress bar
				if ((driver
						.findElement(By.xpath(" .//*[@class='active']/span"))
						.getText().equalsIgnoreCase("Internet")))

				{
					logger.info("LOB displayed!!");
				}

				else
					System.out
							.println("LOB not displayed in secondary progress bar!!");


				// internet equipment page
				// verify current services shows only monthly total in collapsed state
				if ((driver
						.findElement(
								By.xpath(".//*[@class='text parbase currentCartHeader twc-plain-text']"))
						.getText().equalsIgnoreCase("Current Services")))
					if ((driver
							.findElement(
									By.xpath(".//*[@class='text parbase twc-plain-text monthlyTotalHeader']"))
							.getText().equalsIgnoreCase("Monthly Total")))
						if ((driver.findElement(
								By.xpath(".//*[@id='content']/div[3]/div[2]/div/div[1]/div/div/div/div[1]/header/table/tbody/tr/td[2]/sup"))
								.getText().equalsIgnoreCase("$43.98")))
						{
							System.out
									.println("current services shows only monthly total in collapsed state!!!!");
							statusTracker(br,driver, 
									"Pass",
									"current services shows only monthly total in collapsed state!!!!",
									"current services shows only monthly total in collapsed state is present!!",
									"current services shows only monthly total in collapsed state! should be present!!");
						} else {
							System.out
									.println("current services does not show only monthly total in collapsed state!!");
							statusTracker(br,driver, 
									"Fail",
									"current services does not show only monthly total in collapsed state!!",
									"current services does not show only monthly total in collapsed state",
									"Configuration page should be present");
						}
				
				
				// validate new services cart!!
				if ((driver
						.findElement(
								By.xpath(".//*[@id='content']/div[3]/div[2]/div/div[1]/div/div/div/div[2]/header/ul/li/h4/div"))
						.getText().equalsIgnoreCase("New Services")))
					if ((driver
							.findElement(
									By.xpath("//*[@class='text parbase twc-plain-text firstHeader']"))
							.getText().equalsIgnoreCase("Monthly Charges")))
					{
						logger.info("New Services Content present!!");
						statusTracker(br,driver, "Pass",
								"New Services Content present!!!",
								"New Services Content present!!!",
								"New Services Content present!!!");
					} else {
						logger.info("fail1");
						statusTracker(br,driver, "Fail",
								"New Services Content not present!!",
								"New Services Content is  not present!!",
								"New Services Content should be present");
					}

				
				// validating monthly total!!
				String CurrSer = driver.findElement(
						By.xpath(".//*[@class='price last']/sup")).getText();
				logger.info("price is");
				logger.info(CurrSer);
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

		
				
//****************************************************************************************************************
/* Commented by Aashish/Nimy
				// open compare equipment link
				click_element("//*[@title='Compare Internet Plans']", driver);
				Thread.sleep(4000);

				if ((driver
						.findElement(
								By.xpath(".//*[@class='modal-title-wrapper']"))
						.getText()
						.equalsIgnoreCase("Equipment by Internet Plan")))

					if ((driver
							.findElement(
									By.xpath("//*[@class='text row0col0 parbase compTableText checkBoxCol1Text']"))
							.getText()
							.equalsIgnoreCase("Internet Modem with Free Home WiFi")))

					{
						System.out
								.println("compare equipment page is displayed!!");
						statusTracker(br,driver, 
								"Pass",
								" compare equipment page is displayed!!",
								" compare equipment page is displayed!! matches",
								" compare equipment page is displayed!! should match");

					} else {
						System.out
								.println(" compare equipment page is not displayed!!");
						statusTracker(br,driver, 
								"Fail",
								" compare equipment page is not displayed!!",
								" compare equipment page is displayed!! matches",
								" compare equipment page is displayed!! should match");

					}

				// Close
				click_element(
						".//*[@class='modal-button-close']",
						driver);
*/				
//****************************************************************************************************************		
				
                //Internet Modem
				if ((driver
						.findElement(
								By.xpath("//*[@id='js-main-form']/div[2]/div[1]/header/ul/li[2]/h3"))
						.getText().equalsIgnoreCase("Internet Modem"))) {
						
						logger.info("AasCheck 1");
												
						/*&& (driver
								.findElement(
										By.xpath(".//*[@id='js-main-form']/div[2]/div[1]/header/ul/li[3]/sup[1]"))
								.getText().equalsIgnoreCase("$"))
						&& (driver
								.findElement(
										By.xpath("//*[@id='js-main-form']/div[2]/div[1]/header/ul/li[3]/span"))
								.getText().equalsIgnoreCase("per Month")))*/
					
					/*	if(driver
								.findElement(
										By.xpath("//*[@id='js-main-form']/div[2]/div[2]/header/ul/li[2]/h3"))
								.getText()
								.equalsIgnoreCase("Home WiFi and Wireless Gateway"))
									logger.info("AasCheck 2");
						if(driver
								.findElement(
										By.xpath("//*[@id='js-main-form']/div[2]/div[2]/header/ul/li[3]/sup[1]"))
								.getText().equalsIgnoreCase("$"))
									logger.info("AasCheck 3");
						if(driver
								.findElement(
										By.xpath("//*[@id='js-main-form']/div[2]/div[2]/header/ul/li[3]/span"))
								.getText().equalsIgnoreCase("per Month"))
									logger.info("AasCheck 4");*/
							
                //Home WiFi and Internet Modem
					if ((driver
							.findElement(
									By.xpath("//*[@id='js-main-form']/div[2]/div[2]/header/ul/li[2]/h3"))
							.getText()
							.equalsIgnoreCase("Home WiFi and Wireless Gateway"))
								
							&& (driver
									.findElement(
											By.xpath("//*[@id='js-main-form']/div[2]/div[2]/header/ul/li[3]/sup[1]"))
									.getText().equalsIgnoreCase("$"))
							&& (driver
									.findElement(
											By.xpath("//*[@id='js-main-form']/div[2]/div[2]/header/ul/li[3]/span"))
									.getText().equalsIgnoreCase("per Month")))
					
 
						
						//I'll use my own modem
						/*if ((driver
								.findElement(
										By.xpath("//*[@id='js-main-form']/div[2]/div[3]/header/ul/li[2]/h3"))
								.getText()
								.equalsIgnoreCase("I'll use my own modem")))*/
						
						{

							System.out
									.println(" right sequence and pattern of default view!!");
							statusTracker(br,driver, 
									"Pass",
									"right sequence and pattern of default view",
									"Sequence matches", "Sequence should match");
						} else {
							logger.info("wrong sequence!!");
							statusTracker(br,driver, 
									"Fail",
									"right sequence and pattern of default view does not match",
									"Sequence does not match",
									"Sequence should match");
						}
				}
						
				if(return_text(".//*[@id='js-main-form']/div[2]/div[1]/header/ul/li[3]/em", driver).trim().equalsIgnoreCase("Current Service"));

				{
					logger.info("Current service");


				statusTracker(br,driver, "Pass", "Internet Modem text displayed", "text displayed",
						"Internet Modem text should display");

				}	
				
			//Internet Modem - Expand
				click_element(
						"//*[@id='js-main-form']/div[2]/div[1]/header/ul/li[1]/a",
						driver);
				Thread.sleep(4000);
				String str1 = driver
						.findElement(
								By.xpath(".//*[@class='modem-options']/div[1]/section/div/div/div/ul/li[1]"))
						.getText();
				Thread.sleep(4000);
				logger.info(" Text in Equipment1...." + str1);

				if (str1.equalsIgnoreCase("A secure, reliable high-speed connection")) {

					logger.info("Right content in Equipment1!!");
					statusTracker(br,driver, "Pass", "Right content in Equipment1",
							"Right content in Equipment1",
							"Right content in Equipment1 should match");
				} else {

					logger.info("Wrong content in Equipment1!!");
					statusTracker(br,driver, "Fail", "wrong content in Equipment1",
							"wrong content in Equipment1",
							"Right content in Equipment1 should match");

				}

			//Home WiFi and Internet Modem - Expand
				click_element(
						"//*[@id='js-main-form']/div[2]/div[2]/header/ul/li[1]/a",
						driver);

				((JavascriptExecutor) driver).executeScript("window.scrollBy(0,600)");
				Thread.sleep(2000);
				
				String str2 = driver
						.findElement(
								By.xpath(".//*[@id='js-main-form']/div[2]/div[2]/section/div/div[2]/div/p[1]"))
						.getText();
				logger.info(" Text in Equipment2...." + str2);

				if (str2.equalsIgnoreCase("Work, surf and play in any room. Ideal for homes with multiple devices that need a fast Home WiFi network. Connect computers, tablets, smartphones and other WiFi-enabled devices.")) {

					logger.info("Right content in Equipment2!!");
					statusTracker(br,driver, "Pass", "Right content in Equipment2",
							"Right content in Equipment2",
							"Right content in Equipment2 should match");
				} else {

					logger.info("Wrong content in Equipment2!!");
					statusTracker(br,driver, "Fail", "wrong content in Equipment2",
							"wrong content in Equipment2",
							"Right content in Equipment2 should match");

				}

				
				//I'll use my own modem - Expand
				/*click_element(
						"//*[@id='js-main-form']/div[2]/div[3]/header/ul/li[1]/a",
						driver);

				String str3 = driver
						.findElement(
								By.xpath(".//*[@class='modem-options']/div[3]/section/div/div/div/p[1]"))
						.getText();
				logger.info(" Text in Equipment3...." + str3);

				if (str3.contains("Shop around and choose the modem that's best for you. To ensure your modem will work with Time Warner Cable's Internet service, please")) {

					logger.info("Right content in Equipment3");
					statusTracker(br,driver, "Pass", "Right content in Equipment3",
							"Right content in Equipment3",
							"Right content in Equipment3 should match");
				} else {

					logger.info("Wrong content in Equipment3");
					statusTracker(br,driver, "Fail", "wrong content in Equipment3",
							"wrong content in Equipment3",
							"Right content in Equipment3 should match");

				}*/

				//close all dropdowns
				/*click_element(
						"//*[@id='js-main-form']/div[2]/div[3]/header/ul/li[1]/a",
						driver);
*/
				click_element(
						"//*[@id='js-main-form']/div[2]/div[2]/header/ul/li[1]/a",
						driver);

				click_element(
						"//*[@id='js-main-form']/div[2]/div[1]/header/ul/li[1]/a",
						driver);
				
				
				// Click continue
				click_element(
						".//*[@id='content']/div[3]/div[2]/div/div[2]/div/nav/a[2]/span",
						driver);
				Thread.sleep(12000);

				
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

			catch (Exception e) {
				exceptionHandler(br, e, driver);

			}
		} finally {
			wb.close();
			driver.close();

		}

	
		
	}

	
}
