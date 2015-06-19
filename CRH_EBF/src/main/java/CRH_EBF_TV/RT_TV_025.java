/* ****************************************************************************************************
File Name: 								RT_TV_025
Author: 								Nithin K.S
Description of test case: 				TV - Add International Channels Ala Carte
Date of creation(D/M/Y): 				03/06/2014
Name and date(D/M/Y) of modification: 	Nithin K.S - 11/06/2014
Modification description: 				Modified to the efficient Xpath, wherever applicable.
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

public class RT_TV_025 extends CommonFunctions {

	String table, tns[];
	String tlimit, username, pwd, ctotal, Uname, Tv_plan, Internet_plan,
			Phone_plan, current_service;
	int tncount;
	String serAddress, Internet_service, Tv_service, Phone_service,
			str_Browser;

	public RT_TV_025() {
	}

	public RT_TV_025(String s) {
		this.path = s;
		logger.info("RT_TV_025...");
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
			Page_Phone = "RT_TV_025_";
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
			Page_TV = " Page_1_Current Service ";

			// manju variable
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

				Internet_Phone_lob_verify(br,driver);
				Thread.sleep(2000);

				Tv_los_verify(br,Tv_plan, Tv_service, driver);
				Thread.sleep(2000);

				TV_Equipment_Click(br,driver);
				Thread.sleep(5000);

				// CLick on continue button to navigate to the next page
				driver.findElement(By.cssSelector("span.arrow")).click();
				
				Page_TV = " Page_2_Plan page ";
				Thread.sleep(8000);
				
				if (return_text(".//*[@class='left']", driver).trim().equals(
						"Customize Your TV Plan"))
					statusTracker(br,driver, "Pass", "Click the Continue Button",
							"User is navigated to the TV Configuration page",
							"User should navigate to the TV Configuration page.");
				else
					statusTracker(br,driver, 
							"Fail",
							"Click the Continue Button",
							"User is NOT navigated to the TV Configuration page",
							"User should navigate to the TV Configuration page.");

				Thread.sleep(2000);

				if (Isavailable(
						".//*[@id='content']/div[3]/div[2]/div/div[2]/div/div[2]/div/div[2]/div[2]/header/ul/li[2]/h3",
						driver))
					statusTracker(br,driver, 
							"Pass",
							"Verify the Add Premium Channels section",
							"Add Premium Channels section is displayed in the default collapsed state",
							"Add Premium Channels section Should be in default collapsed state");
				else
					statusTracker(br,driver, 
							"Fail",
							"verify the Add Premium Channels section",
							"Add Premium Channels section is not  displayed in the default collapsed state",
							"Add Premium Channels section Should be in default collapsed state");

				Customization_TV_OpenChannel();

				Thread.sleep(2000);

				Customization_TV_addInternationalChannels(br,driver);

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
				
				driver.findElement(By.cssSelector("span.arrow")).click();
				Thread.sleep(20000);

				if (return_text(
						".//*[@class='installOptionsWrapper section']/header/h3/div",
						driver).trim().equals("Review Your New Services"))
					statusTracker(br,driver, "Pass", "Click the Continue Button",
							"User is navigated to the Review Order page",
							"User should navigate to the Review Order page.");
				else
					statusTracker(br,driver, "Fail", "Click the Continue Button",
							"User is NOT navigated to the Review Order page",
							"User should navigate to the Review Order page.");

				 //to take screenshot and save in file
				
				screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				targetFile = new File(spath +"//Test_Results//NewImages//"+ Page_Phone + screen_count + ".png");
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
				
				EBF_Logout(br,driver);
			}

			catch (Exception e) {
				exceptionHandler(br, e, driver);
				logger.info("RT_TV_025 - Error is : " + e.getMessage());
			}
		} catch (Exception e) {
			exceptionHandler(br, e, driver);

		} finally {
			wb.close();
			driver.quit();

		}
	}

}