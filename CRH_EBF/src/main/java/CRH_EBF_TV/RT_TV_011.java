/* ****************************************************************************************************
File Name: 								RT_TV_011
Author: 								Raveena
Description of test case: 				TV Boxes - new LOB WH offer 
Date of creation(D/M/Y): 				03/06/2014
Name and date(D/M/Y) of modification: 	Nithin K.S - 09/06/2014
Modification description: 				Modified to the efficient Xpath, wherever applicable.
Name and date(D/M/Y) of modification: 	RAHUL JADOW - 23/06/2014
Modification description: 				Modified xpaths for steps failing
 ******************************************************************************************************* */
package CRH_EBF_TV;

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
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;

public class RT_TV_011 extends CommonFunctions {

	String table, tns[];
	String tlimit, username, pwd, ctotal, Uname, Tv_plan, Internet_plan,
			Phone_plan, current_service;
	int tncount;
	String serAddress, Internet_service, Tv_service, Phone_service,
			str_Browser;

	public RT_TV_011() {
	}

	public RT_TV_011(String s) {
		this.path = s;
		logger.info("RT_TV_011...");
	}

	public void execute(String br,WebDriver driver, String url, int loc) throws Exception {
	
		int screen_count = 1;
		File data = new File(this.path);
		WorkbookSettings ws = new WorkbookSettings();
		ws.setLocale(new Locale("er", "ER"));
	//	arrcount = 0;
		Workbook wb = Workbook.getWorkbook(data, ws);

		try {
			String tv = "", inet = "", phone = "";
			Sheet sheet2 = wb.getSheet("TV");
			String Sheet_name = sheet2.getName();
			Page_Phone = "RT_TV_011_";
			str_Browser = sheet2.getCell(3, loc).getContents();
		//	tlimit = sheet2.getCell(6, loc).getContents();
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
			
			int tv1 = 0, inet1 = 0, phone1 = 0;
			int val = 1;
/*			int tlim = Integer.parseInt(tlimit);
			tlim *= 60;
			tlimit = Integer.toString(tlim);
			tlimit = tlimit + "000";
*/
			String int_plan = tv = sheet2.getCell(Col_locator_full_scan_input_sheet("TV PLAN", path,Sheet_name), loc).getContents();
			String int_eqipment = sheet2.getCell(Col_locator_full_scan_input_sheet("TV EQUIPMENT", path,Sheet_name), loc).getContents();
			String phone_plan = sheet2.getCell(19, loc).getContents();
			inet = sheet2.getCell(Col_locator_full_scan_input_sheet("TV SERVICE", path,Sheet_name), loc).getContents();
			phone = sheet2.getCell(Col_locator_full_scan_input_sheet("INTERNET SERVICE", path,Sheet_name), loc).getContents();
			String cost_current_sevice_input = sheet2.getCell(Col_locator_full_scan_input_sheet("PASSWORD", path,Sheet_name), loc)
					.getContents();
			if (first == 0) {

				driver.manage().window().maximize();
				driver.get(url);

			}
			try {
				if (first == 0)
					firstrun(br,driver, username, pwd,ctotal, Uname,
							serAddress);

				Tv_los_verify(br,Tv_plan, Tv_service, driver);

				if (driver
						.findElement(
								By.xpath("//*[@name='select_tv']"))
						.getText().equalsIgnoreCase("TV")) {
					click_element(
							"//*[@name='select_tv']",
							driver); // select tv plan
					statusTracker(br,driver, "Pass", "Compare Plans page is opened",
							"Matches", "Compare Plans page should open");
					Thread.sleep(2000);
				}
				
				 //to take screenshot and save in file
				
				File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				File targetFile = new File(spath +"//Test_Results//NewImages//"+ Page_Phone + screen_count + ".png");
				FileUtils.copyFile(screenshot, targetFile);		
				logger.info("copied file into New Images folder"+targetFile);
				
				if(url.contains("beta"))
					 
				 {
				String env="Beta";Image_compare(br,env,Page_Phone,Overall_Path,screen_count,driver);
				Thread.sleep(15000);
				logger.info("Beta Environment");
				 }
				 else
				 {
				String env="Prod";Image_compare(br,env,Page_Phone,Overall_Path,screen_count,driver);
				Thread.sleep(15000);
				logger.info("Prod Environment");
				
				 }
				screen_count++;
				
				
				click_element("//span[contains(text(), 'Continue')]", driver); // continue
				Thread.sleep(5000);
				
				// select tv plan
				click_element("//span[contains(text(), 'Compare TV Plans')]", driver);
				statusTracker(br,driver, "Pass", "Compare Plans page is opened",
						"Matches", "Compare Plans page should open");
				// Select "Close" on Compare TV Plans link
				click_element(".//*[@class='modal-button-close']",
						driver);
						
				Thread.sleep(4000);
				click_element(
						".//*[@id='js-main-form']/ul/li[1]/div[3]/label/input",
						driver);
				click_element(
						".//*[@id='js-main-form']/nav/a",
						driver);
				
				click_element(
						".//*[@id='content']/div[3]/div[2]/div/div[2]/div[1]/div[2]/div/div/div/div[1]/header/ul/li[1]/a",
						driver);
				
				Thread.sleep(10000);
				if (driver
						.findElement(
								By.xpath(".//*[@id='content']/div[3]/div[2]/div/div[2]/div[1]/div[2]/div/div/div/div[1]/section/div/div[2]/div"))
						.isDisplayed()) {
					System.out
							.println("Wholehouse service text is displayed here!");
				} else {
					System.out
							.println(" Wholehouse service text is displayed here");
				}

				click_element(
						".//*[@id='content']/div[3]/div[1]/div/header/div/div[2]/a",
						driver);
				Thread.sleep(2000);

			if (return_text("//*[@class='modal-title']", driver)
						.equalsIgnoreCase("Compare TV Plans"))

				{

					statusTracker(br,driver, "Pass", "Compare Plans page is opened",
							"Matches", "Compare Plans page should open");
				} else {
					statusTracker(br,driver, "Fail",
							"Compare equipment page is not opened",
							"does not Match", "Compare Plans page should open");
				}

				click_element(".//*[@class='modal-button-close']",
						driver);
				Thread.sleep(4000);

				//to take screenshot and save in file
				
				screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				targetFile = new File(spath +"//Test_Results//NewImages//"+ Page_Phone + screen_count + ".png");
				FileUtils.copyFile(screenshot, targetFile);		
				logger.info("copied file into New Images folder");
				logger.info("screen count :" + screen_count +"  " + targetFile);
								
				if(url.contains("beta"))
					 
				 {
				String env="Beta";Image_compare(br,env,Page_Phone,Overall_Path,screen_count,driver);
				Thread.sleep(15000);
				logger.info("Beta Environment");
				 }
				 else
				 {
				String env="Prod";Image_compare(br,env,Page_Phone,Overall_Path,screen_count,driver);
				Thread.sleep(15000);
				logger.info("Prod Environment");
				
				 }
				screen_count++;
				
				
				// validating TV equipment section
				if (driver
						.findElement(
								By.xpath("//*[@id='content']/div[3]/div[2]/div/div[2]/div/div[2]/div/div[2]/div[1]/section/div/div[4]/form/div[1]/header/ul/li[2]/h3"))
						.isDisplayed()) {

					statusTracker(br,driver, "Pass", "Tv Equipment text is present",
							"Matches", "Tv Equipment text should be present");
					click_element(
							"//*[@id='content']/div[3]/div[2]/div/div[2]/div/div[2]/div/div[2]/div[1]/section/div/div[4]/form/div[1]/header/ul/li[1]/a",
							driver);

				}

				else {

					statusTracker(br,driver, "Fail", "Tv Equipment text is not  present",
							"does not Match",
							"Tv Equipment text should be present");
				}

				// validating $ and per month

				if (driver
						.findElement(
								By.xpath("//*[@id='content']/div[3]/div[2]/div/div[2]/div/div[2]/div/div[2]/div[1]/section/div/div[4]/form/div[1]/section/div/ul/li/div[1]/div/sup[1]"))
						.getText().equals("$")) {
					if (driver
							.findElement(
									By.xpath("//*[@id='content']/div[3]/div[2]/div/div[2]/div/div[2]/div/div[2]/div[1]/section/div/div[4]/form/div[1]/section/div/ul/li/div[1]/div/span"))
							.getText().equals("per Month")) {

						statusTracker(br,driver, "Pass",
								"price and time  text is present", "Matches",
								"price and time  text should be present");

					}

					else {

						statusTracker(br,driver, "Fail",
								"price and time  is not  present",
								"does not Match",
								"price and time  should be present");
					}
				}

				click_element(
						"//*[@id='content']/div[3]/div[2]/div/div[2]/div/div[2]/div/div[2]/div[1]/section/div/div[4]/form/div[1]/header/ul/li[1]/a",
						driver);
				Thread.sleep(4000);
				// validating additional equipment

				if (driver
						.findElement(
								By.xpath("//*[@id='content']/div[3]/div[2]/div/div[2]/div/div[2]/div/div[2]/div[1]/section/div/div[4]/form/div[2]/header/ul/li[2]/h3"))
						.isDisplayed()) {

					statusTracker(br,driver, "Pass",
							"additional  Equipment text is present", "Matches",
							"additional  Equipment text should be present");
					click_element(
							"//*[@id='content']/div[3]/div[2]/div/div[2]/div/div[2]/div/div[2]/div[1]/section/div/div[4]/form/div[2]/header/ul/li[1]/a",
							driver);

				}

				else {
					statusTracker(br,driver, "Fail",
							"additional  Equipment text is not  present",
							"does not Match",
							"additional  Equipment text should be present");
				}
/*
			if (driver
						.findElement(
								By.xpath("//*[@id='content']/div[3]/div[2]/div/div[2]/div/div[2]/div/div[2]/div[1]/section/div/div[4]/form/div[2]/section/div/ul/li[1]/div[1]/div/sup[1]"))
						.getText().equals("$")) {
				
				
					if (driver
							.findElement(
									By.xpath(".//*[@id='content']/div[3]/div[2]/div/div[2]/div/div[2]/div/div[2]/div[1]/section/div/div[4]/form/div[2]/section/div/ul/li[1]/div[1]/div/span"))
							.getText().equals("per Month")) {

						statusTracker(br,driver, "Pass",
								"price and time  text is present", "Matches",
								"price and time  text should be present");

					}

					else {

						statusTracker(br,driver, "Fail",
								"price and time  is not  present",
								"does not Match",
								"price and time  should be present");
					}
				}
				
			*/
				
				click_element(".//*[@id='content']/div[3]/div[2]/div/div[2]/div/div[2]/div/div[2]/div[1]/section/div/div[4]/form/div[2]/section/div/ul/li[2]/div/h4/a",driver);
				
				if (driver
						.findElement(
								By.xpath(".//*[@id='content']/div[3]/div[2]/div/div[2]/div/div[2]/div/div[2]/div[1]/section/div/div[4]/form/div[2]/section/div/ul/li[2]/div/div/div[2]/div/sup[1]"))
						.getText().equals("$")) {
				
				
					if (driver
							.findElement(
									By.xpath(".//*[@id='content']/div[3]/div[2]/div/div[2]/div/div[2]/div/div[2]/div[1]/section/div/div[4]/form/div[2]/section/div/ul/li[2]/div/div/div[2]/div/span"))
							.getText().equals("per Month")) {
						
						

						statusTracker(br,driver, "Pass",
								"price and time  text is present", "Matches",
								"price and time  text should be present");

					}

					else {

						statusTracker(br,driver, "Fail",
								"price and time  is not  present",
								"does not Match",
								"price and time  should be present");
					}
				}
				
				
			
				Thread.sleep(2000);
				
				if (driver
						.findElement(
								By.xpath(".//*[@id='content']/div[3]/div[2]/div/div[2]/div/div[2]/div/div[2]/div[1]/section/div/div[4]/form/div[2]/section/div/ul/li[2]/div/div/div[3]/div[2]/select"))
						.isDisplayed())
					
					if (driver
							.findElement(
									By.xpath(".//*[@id='content']/div[3]/div[2]/div/div[2]/div/div[2]/div/div[2]/div[1]/section/div/div[4]/form/div[2]/section/div/ul/li[2]/div/div/div[3]/div[2]/div[1]"))
							.getText().equals("$")) {

						statusTracker(br,driver, "Pass", "select quantity box is present",
								"Matches",
								"select quantity box should be present");
					}

					else

					{
						statusTracker(br,driver, "Fail",
								"select quantity box is not present",
								"does not Match",
								"select quantity box should be present");
					}
				
				click_element("//span[contains(text(), 'Continue')]", driver);
				
				
				explicit_Wait(5);
				
				if(driver.findElement(By.xpath(".//*[@id='js-page-errors']/div/ul/li")).isDisplayed())
				{
					if(driver.findElement(By.xpath(".//*[@id='js-page-errors']/div/ul/li")).getText().equalsIgnoreCase("You must have at least two boxes to take advantage of Whole House service. At least one of those boxes must be a DVR. Please add another box to your cart before continuing."))
					{
						statusTracker(br,driver, "Pass", "Clicked the continue button without providing the quantity",
								"Error message is displayed & correct",
								"Error message should be displayed");
					}
					else
						statusTracker(br,driver, "Fail", "Clicked the continue button without providing the quantity",
								"Error message is NOT displayed & correct",
								"Error message should be displayed");
				}
				
				Thread.sleep(6000);
				Select_DropDown(driver, ".//*[@data-name='Enhanced DVR Box']", "3");
				Thread.sleep(7000);

				config_page_Cart_result_updater_1(br,driver);
				Thread.sleep(6000);
				
				click_element(
						"//*[@id='content']/div[3]/div[2]/div/div[2]/div/div[2]/div/div[2]/div[1]/section/div/div[4]/form/div[2]/header/ul/li[1]/a",
						driver);
				Thread.sleep(2000);
				
				//to take screenshot and save in file
				
				screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				targetFile = new File(spath +"//Test_Results//NewImages//"+ Page_Phone + screen_count + ".png");
				FileUtils.copyFile(screenshot, targetFile);		
				logger.info("copied file into New Images folder");
				logger.info("screen count :" + screen_count +"  " + targetFile);
								
				if(url.contains("beta"))
					 
				 {
				String env="Beta";Image_compare(br,env,Page_Phone,Overall_Path,screen_count,driver);
				Thread.sleep(15000);
				logger.info("Beta Environment");
				 }
				 else
				 {
				String env="Prod";Image_compare(br,env,Page_Phone,Overall_Path,screen_count,driver);
				Thread.sleep(15000);
				logger.info("Prod Environment");
				
				 }
				screen_count++;
				
				click_element("//span[contains(text(),'Continue')]", driver);
				
				explicit_Wait(8);
				
				if (driver.findElement(By.xpath("//div[@class='left']/h2")).getText().equals("Choose Installation & Review Order"))
				{
					statusTracker(br,driver, "Pass", "  Clicked Continue and should be navigated to RO Page",
							" Its navigated to RO Page", " Should be navigated to RO Page");
				} 
				else 
				{
					statusTracker(br,driver, "Pass", "  Clicked Continue and should be navigated to RO Page",
							" Its NOT navigated to RO Page", " Should be navigated to RO Page");
				}
				
				//to take screenshot and save in file
				
				screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				targetFile = new File(spath +"//Test_Results//NewImages//"+ Page_Phone + screen_count + ".png");
				FileUtils.copyFile(screenshot, targetFile);		
				logger.info("copied file into New Images folder");
				logger.info("screen count :" + screen_count +"  " + targetFile);
								
				if(url.contains("beta"))
					 
				 {
				String env="Beta";Image_compare(br,env,Page_Phone,Overall_Path,screen_count,driver);
				Thread.sleep(15000);
				logger.info("Beta Environment");
				 }
				 else
				 {
				String env="Prod";Image_compare(br,env,Page_Phone,Overall_Path,screen_count,driver);
				Thread.sleep(15000);
				logger.info("Prod Environment");
				
				 }
				screen_count++;

				EBF_Logout(br,driver);
			}

			catch (Exception e) {
				exceptionHandler(br, e, driver);
				logger.info("RT_TV_011 Error is : " + e.getMessage());
			}
		} catch (Exception e) {
			exceptionHandler(br, e, driver);

		} finally {
			wb.close();
			driver.quit();

		}
	}
}
