/* ****************************************************************************************************
File Name: 								RT_TV_015
Author: 								Shika
Description of test case: 				TV Boxes - box not included (new cust)
Date of creation(D/M/Y): 				03/06/2014
Name and date(D/M/Y) of modification: 	Nithin K.S - 10/06/2014
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

public class RT_TV_015 extends CommonFunctions {

	private static final int List = 0;
	String table, tns[];
	String tlimit, username, pwd, ctotal, Uname, Tv_plan, Internet_plan,
			Phone_plan, current_service;
	int tncount;
	String serAddress, Internet_service, Tv_service, Phone_service;

	public RT_TV_015() {
	}

	public RT_TV_015(String s) {
		this.path = s;
		logger.info("RT_TV_015");
	}

	public boolean Isavailable(String fxp, WebDriver driver) {
		boolean xy = true;
		try {
			if (driver.findElement(By.xpath(fxp)) != null) {
				xy = true;
			}
		} catch (Exception e) {
			logger.info("Isavailable Exception : " + e.getMessage());
			xy = false;
		}
		return xy;
	}

	public void execute(String br,WebDriver driver, String url, int loc) throws Exception {
		
		int screen_count = 1;
		File data = new File(this.path);
		WorkbookSettings ws = new WorkbookSettings();
		ws.setLocale(new Locale("er", "ER"));
	//	arrcount = 0;
		Workbook wb = Workbook.getWorkbook(data, ws);

		try {
			Page_Phone = "RT_TV_015_";
			String tv = "", inet = "", phone = "";
			Sheet sheet2 = wb.getSheet("TV");
			String Sheet_name = sheet2.getName();
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
			if (first == 0) {

				driver.manage().window().maximize();
				driver.get(url);

			}

			try {
				if (first == 0)
					firstrun(br,driver, username, pwd,ctotal, Uname,
							serAddress);

				{
					driver.findElement(By.xpath(".//*[@name='upgrade_tv']")).click();
			
					Thread.sleep(2000);
					driver.findElement(By.xpath("//*[@class='arrow']")).click();
					Thread.sleep(8000);
					driver.findElement(
							By.xpath(".//*[@id='content']/div[3]/div[2]/div/div[2]/div[1]/div[2]/div/div/div/div[2]/header/ul/li[5]/div/a/span"))
							.click();
					Thread.sleep(10000);
					/*driver.findElement(
							By.xpath("//*[@class='modal js-modal-initialized']"))
							.click();
					Thread.sleep(8000);
					// Compare Plan
					if (return_text("//*[@class='modal-title']", driver).trim()
							.equalsIgnoreCase("Equipment Comparison")) {
						statusTracker(br,driver, 
								"Pass",
								"Select the Compare Boxes link",
								"A pop up displays with a chart comparing the TV Boxes",
								"A pop up should get display with a chart comparing the TV Boxes");
					} else {
						statusTracker(br,driver, 
								"Fail",
								"Select the Compare Boxes link",
								"A pop up displays with a chart comparing the TV Boxes",
								"A pop up doesnt get display with a chart comparing the TV Boxes");
					}
					driver.findElement(
							By.xpath("//*[@class='modal-button-close']"))
							.click();
					Thread.sleep(8000);
					if (return_text(
							"//*[@id='content']/div[3]/div[2]/div/div[2]/div/div[2]/div/div[2]/div[1]/header/ul/li[2]/h3",
							driver).trim().equalsIgnoreCase(
							"Select Your Equipment")) {
						statusTracker(br,driver, 
								"Pass",
								"Close the Compare Boxes link",
								" Compare Boxes window closes and the TV configuration page is displayed",
								" Compare Boxes window should close and the TV configuration page should be displayed");
					} else {
						statusTracker(br,driver, 
								"Fail",
								"Close the Compare Boxes link",
								" Compare Boxes window closes and the TV configuration page is displayed",
								" Compare Boxes window should close and the TV configuration page should be displayed");
					}
*/
					// Tv Equipment
					if (driver.findElement(
							By.xpath("//*[@class='tv-equip-box']"))
							.isDisplayed()) {
						statusTracker(br,driver, 
								"Pass",
								"Validate the Primary Equipment section is hidden",
								"Primary equipment section is displayed",
								"Primary equipment section should not be displayed");
					} else {
						statusTracker(br,driver, 
								"Fail",
								"Validate the Primary Equipment section is not hidden",
								"Primary equipment section is not displayed",
								"Primary equipment section should not be displayed");
						statusTracker(br,driver, "", "Expand the TV boxes section",
								"Clicked", " ");
					}

					/*driver.findElement(By.xpath("//*[@value='1-2BRW']"))
							.click();
					Thread.sleep(5000);
					statusTracker(br,driver, 
							"",
							"Tv Equipment Click",
							"Clicked the cable card option in Primary equipment section",
							" ");
					config_page_Cart_result_updater_1(br,driver);
					Thread.sleep(2000);
					page_Cart_One_Time_charge_updater_1(br,driver);
					Thread.sleep(2000);*/
					
					 //to take screenshot and save in file
					
					
				
					
					
				
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
					
					// Additional Equipment
					if (driver
							.findElement(
									By.xpath(".//*[@id='content']/div[3]/div[2]/div/div[2]/div/div[2]/div/div[2]/div[1]/section/div/div[4]/form/div[2]/header/ul/li[2]/h3"))
							.isDisplayed()) {
						statusTracker(br,driver, 
								"Fail",
								"Validate the additional boxes section appears on the TV Configuration page",
								"Additional boxes section s in collapsed state",
								"Additional boxes section should not appears on the TV Configuration page");
					} else {
						statusTracker(br,driver, 
								"Pass",
								"Validate the additional boxes section appears on the TV Configuration page",
								"Additional boxes section is not in collapsed state",
								"Additional boxes section should not appears on the TV Configuration page");
					}
					// Expand Additional boxes
					/*driver.findElement(
							By.xpath("//*[@id='content']/div[3]/div[2]/div/div[2]/div/div[2]/div/div[2]/div[1]/section/div/div[4]/form/div[2]/header/ul/li[1]/a"))
							.click();
					statusTracker(br,driver, "", "Expand the Additional boxes section",
							"Clicked", " ");
					Thread.sleep(5000);*/
					// validation for cable_cart
					if (driver
							.findElement(
									By.xpath("//*[@class='detail-view js-view-more js-viewMore-initialized']/h4"))
							.isDisplayed()) {
						statusTracker(br,driver, 
								"Pass",
								"Validate the cable cards  section appears at the bottom of the additional boxes section",
								"Cable cards  section appears at the bottom of the additional boxes section",
								"Cable cards  section should appears at the bottom of the additional boxes section");
					} else {
						statusTracker(br,driver, 
								"Pass",
								"Validate the cable cards  section appears at the bottom of the additional boxes section",
								"Cable cards  section appears at the bottom of the additional boxes section",
								"Cable cards  section should appears at the bottom of the additional boxes section");
					}
					config_page_Cart_result_updater_1(br,driver);
					Thread.sleep(2000);
					page_Cart_One_Time_charge_updater_1(br,driver);
					Thread.sleep(2000);

					driver.findElement(By.xpath("//*[@class='arrow']")).click();
					Thread.sleep(10000);
					if (Isavailable("//*[@class='wrap']/div/h2", driver)) {
						statusTracker(br,driver, 
								"Pass",
								"Validate the CTA button is active and selectable to continue to the next page",
								"Active and clickable",
								"Should be Active and clickabl");
					} else {
						statusTracker(br,driver, 
								"Fail",
								"Validate the CTA button is active and selectable to continue to the next page",
								"It is not Active and clickable",
								"Should be Active and clickabl");
					}

					 //to take screenshot and save in file.
					
				
					
				
				
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
				}

				EBF_Logout(br,driver);

			}

			catch (Exception e) {
				exceptionHandler(br, e, driver);
				logger.info("RT_TV_015 Error is : " + e.getMessage());
			}
		} catch (Exception e) {
			exceptionHandler(br, e, driver);
		} finally {
			wb.close();
			driver.quit();

		}
	}
}
