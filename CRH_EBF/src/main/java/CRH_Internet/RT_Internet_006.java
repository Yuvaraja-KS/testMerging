
//File Name: RT_Internet_006
//Author: RAHUL JADOW  
//Description of test case: Add Multiple LOB
//Date of creation(D/M/Y): 3/19/2014
//Name and date(D/M/Y) of modification: 
//Modification description: 


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

public class RT_Internet_006 extends CommonFunctions {

	String table, tns[];
	String tlimit, username, pwd, ctotal, Uname, Tv_plan, Internet_plan,
			Phone_plan, current_service,env;
	int tncount;
	
	String serAddress, Internet_service, Tv_service, Phone_service,
			str_Browser;

	public RT_Internet_006() {
	}

	public RT_Internet_006(String s) {
		this.path = s;
		logger.info("Add Internet 006 is intialized");
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
			Page_Phone = "RT_Internet_006_";
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
				logger.info("Check if url opened");
			}
			try {
				if (first == 0)
					firstrun(br, driver, username, pwd,ctotal, Uname,
							serAddress);

				// validationofTWClogo
				Internet_TWClogo(br, driver);
				Thread.sleep(2000);

				// Validation of User Name
				String UserName = driver.findElement(
						By.xpath(".//*[@class='headerUsername']/em")).getText();

				if (UserName.equalsIgnoreCase(Uname)) {
					logger.info("The username matches");
					statusTracker(br,driver, "Pass", "The first and last name", "Matches",
							"Should match");
				} else {
					logger.info("name match fails");
					statusTracker(br,driver, "Fail",
							"The first and last name doesnt match",
							" doesnt Match", "Should match");
				}

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
						By.xpath(".//*[@class='your-services']/div[1]/header/span"))
						.getText().trim();
				System.out
				.println(CurrSer1);
				
				if ((CurrSer1.contains("You currently have Phone")))                          

				{
					System.out
							.println("current service LOBs displayed in Your current service section header");
					statusTracker(br,driver, 
							"Pass",
							"Phone is in Your current service section header",
							"Phone  is displayed in Your current service section header",
							"Phone should displayed in Your current service section header");
				} else {
					System.out
							.println(" current service LOBs is not  display in Your current service section header");
					statusTracker(br,driver, 
							"Fail",
							"Phone is in Your current service section header",
							"TV, Internet, Phone is not displayed in Your current service section header",
							"TV, Internet, Phone should displayed in Your current service section header");
				}

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
					statusTracker(br,driver, "Fail",
							"Continue button on service page is enabled",
							"Enabled", "should be disabled");
				}

				// Verify Phone is active on account, validate LOS
				Tv_los_verify(br, Tv_plan, Tv_service, driver);
				Thread.sleep(2000);

				// Verify if Tv and Internet is not a current LOB, validate the
				// "Starting At Price" and duration
				logger.info("Price Value : "
						+ return_text(
								".//*[@class='services']/li[1]/div[3]/div",
								drive));
				
				((JavascriptExecutor) driver).executeScript("window.scrollBy(0,600)");
				Thread.sleep(2000);
				
				logger.info("Price Value : "
						+ return_text(
								".//*[@class='services']/li[2]/div[3]/div",
								drive));

				// If Int is not active on the account, select to add
				click_element(".//*[@value='select_inet']", driver);
				Thread.sleep(2000);
				if ((driver.findElement(By.xpath(".//*[@value='select_inet']"))
						.isEnabled())) {
					logger.info("int Added");
					statusTracker(br,driver, "Pass",
							"Select checkbox to add Tv as new service",
							"check box is selected",
							"check box should be selected");
				} else {
					logger.info("fail1");
					statusTracker(br,driver, 
							"Fail",
							"Select checkbox to add Tv as new service is not selected",
							"check box is not selected",
							"check box should be selected");
				}
								
				// Add Phone as a new service
				click_element(".//*[@value='select_tv']", driver);
				Thread.sleep(2000);
				if ((driver
						.findElement(By
								.xpath(".//*[@value='select_tv']"))
						.isEnabled())) {
					logger.info("Phone Added");
					statusTracker(br,driver, "Pass",
							"Select checkbox to add Internet as new service",
							"check box is selected",
							"check box should be selected");
				} else {
					System.out
							.println("Select checkbox to add Internet as new service is not selected");
					statusTracker(br,driver, 
							"Fail",
							"Select checkbox to add Internet as new service is not selected",
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
				
				
				// Select Continue Button so that User navigates to the Internet
				// Plan page.
				click_element("//*[@class='arrow']", driver);
				statusTracker(br,driver, "Pass", "click on Continue button",
						"'Continue button is clicked",
						"should click continue button");
				Thread.sleep(6000);

				// Verify customize page is open
				if (driver
						.findElement(
								By.xpath("//*[@id='content']/div[1]/div/ol/li[1]/div/div"))
						.isDisplayed()) {
					logger.info("Customize page is open");
				}
				Thread.sleep(2000);

				// Verify customize page has Tv and Internet
				if (driver
						.findElement(
								By.xpath(".//*[@class='checkout-steps show-sub-steps']/ol/li[1]/div/div/div/ul/li[1]"))
						.isDisplayed())
					if (driver
							.findElement(
									By.xpath(".//*[@class='checkout-steps show-sub-steps']/ol/li[1]/div/div/div/ul/li[2]"))
							.isDisplayed()) {
						System.out
								.println("Customize page has both Tv and Internet tabs");
						statusTracker(br,driver, "Pass",
								"Customize page has both Tv and Internet",
								"Matches", "Should match");
					}

				// Validating if user has navigated to the Tv plan page
				if (return_text(".//*[@class='left']", driver).trim().contains(
						"TV Plan"))
					statusTracker(br,driver, "Pass", "Click the Continue Button",
							"User is navigated to the Tv plan page",
							"User should navigate to the Tv plan page.");
				else
					statusTracker(br,driver, "Fail", "Click the Continue Button",
							"User is NOT navigated to the Tv plan page",
							"User should navigate to the Tv plan page.");

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
			driver.close();

		}
	
		
	}

	

}
