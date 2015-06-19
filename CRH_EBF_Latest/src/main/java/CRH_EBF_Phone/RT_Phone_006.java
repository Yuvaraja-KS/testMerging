//File Name: RT_Phone_006
//Author: Rahul Jadow
//Description of test case: Customer is eligible to upgrade Phone LOB
//Date of creation(D/M/Y): 11/3/2014
//Name and date(D/M/Y) of modification: Pradeep Shetty / 5/6/2014
//Modification description:
//  a) change the all the xpath’s to unique property 
//  b) Removed all the unwanted print statements & comments.
//  c) Added comments to the steps wherever needed.
//  d) Updated Status tracked if change needed

package CRH_EBF_Phone;


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
import java.io.IOException;
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
import jxl.read.biff.BiffException;

public class RT_Phone_006 extends CommonFunctions {

	

	String table, tns[];
	String tlimit, username, pwd, ctotal, Uname, Tv_plan, Internet_plan,
			Phone_plan, current_service;
	int tncount;
	String serAddress, Internet_service, Tv_service, Phone_service,
			str_Browser;

	static String testCaseName, passScrShot;

	public String getTestCaseName() {
		return testCaseName;
	}

	public static String getPassScreenshot() {
		return passScrShot;
	}
	
	public RT_Phone_006() {
		testCaseName = this.getClass().getSimpleName();
		try {
			passScrShot = sheet11.getCell(4, Row_locator_full_scan_validation(testCaseName,inputfile,"Phone")).getContents();
		} catch (BiffException e) {
			logger.info(e.getMessage());
		} catch (IOException e) {
			logger.info(e.getMessage());
		}
	}

	public RT_Phone_006(String s) {
		testCaseName = this.getClass().getSimpleName();
		try {
			passScrShot = sheet11.getCell(4, Row_locator_full_scan_validation(testCaseName,inputfile,"Phone")).getContents();
		} catch (BiffException e) {
			logger.info(e.getMessage());
		} catch (IOException e) {
			logger.info(e.getMessage());
		}
		this.path = s;
		//this.path1 = phone;
		logger.info("add Phone is intialized");
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
			Page_Phone="RT_Phone_006_";
			String tv = "", inet = "", phone = "";
			Sheet sheet2 = wb.getSheet("Phone");
			String Sheet_name = sheet2.getName();
			Page_Phone="RT_Phone_006_";
			str_Browser = sheet2.getCell(Col_locator_full_scan_input_sheet("Browser", path,Sheet_name), loc).getContents();
			 
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
		 
			Page_TV = " Page_1_Current Service ";

			// manju variable
			String int_plan = tv = sheet2.getCell(15, loc).getContents();
			String int_eqipment = sheet2.getCell(18, loc).getContents();
			String phone_plan = sheet2.getCell(19, loc).getContents();
			inet = sheet2.getCell(12, loc).getContents();
			phone = sheet2.getCell(13, loc).getContents();
			String cost_current_sevice_input = sheet2.getCell(8, loc)
					.getContents();
			if (first == 0) {
				logger.info("trying to open the url");
				driver.manage().window().maximize();
				driver.get(url);
				logger.info("Check if url opened");
			}
			try {
				if (first == 0)
					firstrun(br,driver, username, pwd,  ctotal, Uname,
							serAddress);
				

				// Validation of current service monthly charge and $ sign
				String CurrSer = driver
						.findElement(
								By.xpath("//*[@class='sub-header black-header']/span"))
						.getText();
				logger.info(CurrSer);
				String strfind = "$";
				int iSuccess = CurrSer.indexOf(strfind);
				logger.info("",iSuccess);

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
				logger.info("",iSpace);

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

				
				// Validation of continue button (disabled)
				if (driver.findElement(
						By.xpath("//*[@class='button-nav ']/a")).isEnabled()) {
					logger.info("Fail");
					statusTracker(br,driver,"Pass", "Continue button on service page",
							"Disabled", "Should be disabled");
				} else {
					logger.info("Pass");
					statusTracker(br,driver,"fail", "Continue button on service page",
							"Enabled", "should be disabled");
				}

				
			
				//Verify Internet is active on account, validate LOS 
				Internet_los_verify(br,Internet_plan,Internet_service,driver);
				Thread.sleep(2000);
				
			
				
				//Verify if Tv & phone is not a current LOB, validate the "Starting At Price" and duration
				logger.info("Price Value : "+ return_text(".//*[@class='services']/li[1]/div[3]/div",drive));
				logger.info("Price Value : "+ return_text(".//*[@class='services']/li[2]/div[3]/div",drive));
				
				
				// If Tv is not active on the account, select to add
				
				click_element(".//*[@name='select_tv']",driver);
					//click_element(".//*[@class='services']/li[1]/div[3]/label/input",driver);
					Thread.sleep(2000);
					if ((driver.findElement(By.xpath(".//*[@name='select_tv']")).isEnabled())) 
					{
					logger.info("Tv Added");
					statusTracker(br,driver,"Pass", "Select checkbox to add Tv as new service",
							"check box is selected", "check box should be selected");
					}
					else
					{	
					logger.info("fail1");
					statusTracker(br,driver,"Fail", "Select checkbox to add Tv as new service",
							"check box is not selected", "check box should be selected");
			        }
				
					
					
				// Add Phone as a new service
					click_element(".//*[@name='select_phone']",driver);
					Thread.sleep(2000);
					if ((driver.findElement(By.xpath(".//*[@name='select_phone']")).isEnabled())) 
					{
					logger.info("Phone Added");
					statusTracker(br,driver,"Pass", "Select checkbox to add Phone as new service",
							"check box is selected", "check box should be selected");
					}
					else
			        {
					logger.info("fail2");
					statusTracker(br,driver,"Fail", "Select checkbox to add Phone as new service",
							"check box is not selected", "check box should be selected");
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
					
						//Select Continue Button so that User navigates to the Internet Plan page.
						click_element("//*[@class='button-nav ']/a/span",driver);
						statusTracker(br,driver,"Pass", "click on Continue button",
						        "'Continue button is clicked", "should click continue button");
						Thread.sleep(8000);
						
						
						// Verify customize page is open
						if (driver.findElement(By.xpath("//*[@class='step-list']/li[1]/div/div")).isDisplayed())
						{
							logger.info("Customize page is open");
						}
                        Thread.sleep(2000);
		
                        // Verify customize page has TV and phone
                        if (driver.findElement(By.xpath(".//*[@class='sub-steps']/ul/li[1]")).isDisplayed())
                        if (driver.findElement(By.xpath(".//*[@class='sub-steps']/ul/li[2]")).isDisplayed())
		                {
			            logger.info("Customize page has both TV and phone tabs");
			            statusTracker(br,driver,"Pass", "Customize page has both TV and phone","Matches", "Should match");
		                }
					
						// Validating if user has navigated to the Tv plan page
						if (return_text(".//*[@class='left']/h2",driver).trim().equals("Choose Your TV Plan"))
							statusTracker(br,driver,"Pass",
									"Click the Continue Button",
									"User is navigated to the TV Configuration page",
									"User should navigate to the TV Configuration page.");
						else
							statusTracker(br,driver,"Fail",
									"Click the Continue Button",
									"User is NOT navigated to the TV Configuration page",
									"User should navigate to the TV Configuration page.");
						
						
						
					
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
			       
			catch (Exception e) {
				exceptionHandler(br,e, driver);
				logger.info("error is : " + e.getMessage());
			}
		} catch (Exception e) {
			exceptionHandler(br,e, driver);

		} finally {
			wb.close();
			//wb1.close();
			driver.close();

		}
	}

}
