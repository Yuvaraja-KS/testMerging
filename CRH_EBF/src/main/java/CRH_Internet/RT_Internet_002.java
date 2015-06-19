
//File Name: RT_Internet_002
//Author: RAHUL JADOW 
//Description of test case: Customer is eligible to add features & configurations - Internet
//Date of creation(D/M/Y): 3/19/2014
//Name and date(D/M/Y) of modification: RAHUL JADOW - 6/6/2014
//Modification description: check for TV/Internet LOS plan in current service & Minor changes


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

public class RT_Internet_002 extends CommonFunctions {

	String table, tns[];
	String tlimit, username, pwd, ctotal, Uname, Tv_plan, Internet_plan,
			Phone_plan, current_service,env;
	int tncount;
	String serAddress, Internet_service, Tv_service, Phone_service,
			str_Browser;

	public RT_Internet_002() {
	}

	public RT_Internet_002(String s) {
		this.path = s;
		logger.info("Add Internet 002 is intialized");
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
			Page_Phone = "RT_Internet_002_";
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
			String cost_current_sevice_input = sheet2.getCell(Col_locator_full_scan_input_sheet("C-TOTA", path,Sheet_name), loc)
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
				// validationofTWClogo
				Internet_TWClogo(br, driver);
				Thread.sleep(2000);
				
			
	
				
				// Validation of current service monthly charge and $ sign
				String CurrSer = driver.findElement(
						By.xpath("//*[@class='sub-header black-header']/span"))
						.getText();
				logger.info(CurrSer);
				String strfind = "$";
				int iSuccess = CurrSer.indexOf(strfind);
				logger.info("{}",iSuccess);

				if (iSuccess == 0) {
					logger.info("$ not present");
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
				String per = "per";

				int iSpace = CurrSer.indexOf(per);
				int iEndAmount = iSpace - 1;
				logger.info("{}",iSpace);

				String sAmount = CurrSer.substring(iStartAmount, iEndAmount);
				logger.info(ctotal);
				logger.info(sAmount);

				if (sAmount.equals(ctotal)) {
					logger.info("Pass");
					statusTracker(br,driver, 
							"Pass",
							"Current service monthly charges should match as per the user",
							"Amount matches", "Amount should match");
				}

				else {
					logger.info("Fail");
					statusTracker(br,driver, 
							"Fail",
							"Current service monthly charges should match as per the user",
							"Amount doesnt match", "Amount should match");
				}

				
				// Validate the Your Services section header displays current
				// LOBs on account
				String CurrSer1 = driver.findElement(
						By.xpath("//*[@class='sub-header black-header']/span"))
						.getText();
				if ((CurrSer1.contains("You currently have Internet.")))

				{
					System.out
							.println("Internet is in Your current service section header");
					statusTracker(br,driver, 
							"Pass",
							"Internet is in Your current service section header",
							"Internet  is displayed in Your current service section header",
							"Internet should displayed in Your current service section header");
				} else {
					System.out
							.println("Internet is NOT displayed in Your current service section header");
					statusTracker(br,driver, 
							"Fail",
							"Internet is in Your current service section header",
							"Internet  is not displayed in Your current service section header",
							"Internet should displayed in Your current service section header");
				}

				
				// Verify Internet is active on account, validate LOS
				Internet_los_verify(br, Internet_plan, Internet_service, driver);
				logger.info("Internet is active on account");
				Thread.sleep(4000);
				
				//check for TV/Internet LOS plan in current service
				Tv_Phone_LOS(br, Tv_plan, Tv_service, Phone_plan, Phone_service, driver);
				logger.info("TV & ph is active on account");
				Thread.sleep(4000);
				
				
				// Validation of continue button (disabled)
				((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1200)");
				Thread.sleep(6000);		
				logger.info("Aashish isEnabled"+Isavailable(".//*[@id='js-main-form']/nav/a",driver));
				
				
					if (Isavailable(".//*[@id='js-main-form']/nav/a",driver)) {
					logger.info("Pass");
					statusTracker(br,driver, "Pass", "Continue button on service page",
							"Disabled", "Should be disabled");
				} else {
					logger.info("Fail");
					statusTracker(br,driver, "Fail", "Continue button on service page",
							"Enabled", "should be disabled");
				}

				JavascriptExecutor jse = (JavascriptExecutor)driver;
				jse.executeScript("scroll(250, 0)");
				Thread.sleep(2000);
				
				// Add Internet equipment
				click_element(".//*[@value='customize_inet']", driver);
				Thread.sleep(2000);
				if ((driver.findElement(By
						.xpath(".//*[@id='js-main-form']/nav/a")).isEnabled())) {
					logger.info("Internet equipment selected");
					statusTracker(br,driver, "Pass",
							"Select checkbox to add Internet equipment",
							"check box is selected",
							"check box should be selected");
				} else {
					logger.info("Select checkbox to add Internet equipment is not selected");
					statusTracker(br,driver, 
							"Fail",
							"Select checkbox to add Internet equipment is not selected",
							"check box is not selected",
							"check box should be selected");
				}

				Thread.sleep(2000);
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
			logger.info("Aashish Check 456"+spath);
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
				
				// Check Enabled
				
				
				((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1200)");
				Thread.sleep(6000);		
				logger.info("Aashish isEnabled"+Isavailable(".//*[@id='js-main-form']/nav/a",driver));
				
				
					if (Isavailable(".//*[@id='js-main-form']/nav/a",driver)) {
					logger.info("Pass1");
					statusTracker(br,driver, "Pass", "Continue button on service page",
							"Enabled", "should be enabled");
				} else {
					logger.info("fail1");
					statusTracker(br,driver, "Fail", "Continue button NOT present on service page",
							"Disabled", "should be enabled");
				}
				Thread.sleep(8000);

				// CLick on continue button to navigate to the next page
				
				click_element(".//*[@id='js-main-form']/nav/a/span", driver);
				logger.info("clicked continue button on page 1");
				Thread.sleep(2000);
				

				String Page_Internet = " Page_2_Plan page ";
				Thread.sleep(8000);
				logger.info("Available YN : "
						+ Isavailable(".//*[@class='left']", driver));

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

				Thread.sleep(3000);
				
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
				
				scrollToElementByLinkText("Sign Out",driver);
				driver.findElement(By.linkText("Sign Out")).click();
				Thread.sleep(10000);
				
				
				
				driver.quit();

				
			}

			catch (Exception e) {
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


