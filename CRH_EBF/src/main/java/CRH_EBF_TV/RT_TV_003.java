/* ****************************************************************************************************
File Name: 								RT_TV_003
Author: 								Pradeep
Description of test case: 				User has 2 or more existing services on account and is eligible to upgrade at least 2 services
Date of creation(D/M/Y): 				03/06/2014
Name and date(D/M/Y) of modification: 	Nithin K.S - 06/06/2014
Modification description: 				Modified to the effiecient Xpath, wherever applicable.
 ******************************************************************************************************* */
package CRH_EBF_TV;

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

public class RT_TV_003 extends CommonFunctions {

	String table, tns[];
	String tlimit, username, pwd, ctotal, Uname, Tv_plan, Internet_plan,
			Phone_plan, current_service;
	int tncount;
	String serAddress, Internet_service, Tv_service, Phone_service;

	public RT_TV_003() {
	}

	public RT_TV_003(String s) {
		this.path = s;
		logger.info("RT_TV_003...");
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

		Page_Phone = "RT_TV_003_";
		int screen_count = 1;
		File data = new File(this.path);
		WorkbookSettings ws = new WorkbookSettings();
		ws.setLocale(new Locale("er", "ER"));
		//arrcount = 0;

		Workbook wb = Workbook.getWorkbook(data, ws);

		try {
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
		//	int tlim = Integer.parseInt(tlimit);
		//	tlim *= 60;
		//	tlimit = Integer.toString(tlim);
		//	tlimit = tlimit + "000";

			if (first == 0) {

				driver.manage().window().maximize();
				driver.get(url);
			}

			try {

				if (first == 0)
					Page_Phone = "RT_TV_003_";
logger.info("firtst run called");
				firstrun(br,driver, username, pwd,ctotal, Uname,
						serAddress);

				String UserName = driver.findElement(
						By.xpath(".//*[@class='headerUsername']/em")).getText();
				Thread.sleep(3000);
				if (UserName.equals(Uname)) {

					statusTracker(br,driver, "Pass", "The first and last name", "Matches",
							"Should match");
				} else {

					statusTracker(br,driver, "Fail",
							"The first and last name doesnt match",
							"Doesnt Match", "Should match");
				}

				String parentWin = driver.getWindowHandle();
				click_element(".//*[@class='img desktop']", driver);
				Thread.sleep(10000);

				Set<String> Win = driver.getWindowHandles();
				Iterator<String> Itr = Win.iterator();

				String MainWin = Itr.next();
				String TabWin = Itr.next();
				driver.switchTo().window(TabWin);

				String subWinTitle = "Cable TV, High Speed Internet & Home Phone Service | Time Warner Cable";
				Thread.sleep(5000);
				String subActitle = driver.getTitle();

				Thread.sleep(8000);

				if (subWinTitle.equals(subActitle)) {
					statusTracker(br,driver, "Pass",
							"TWC Logo is clickable and opens in new tab",
							"Clickable and opens in new tab",
							"Should be Clickable and should open in new tab");
				} else {
					statusTracker(br,driver, "Fail",
							"TWC Logo is clickable and opens in new tab",
							"Its NOT clickable",
							"Should be Clickable and should open in new tab");
				}

				Thread.sleep(8000);
				driver.switchTo().window(parentWin);
				Thread.sleep(8000);
				driver.switchTo().window(parentWin);
				String parWinTitle = "Current Services | Time Warner Cable";
				String parActitle = driver.getTitle();

				if (parWinTitle.equals(parActitle)) {
					statusTracker(br,driver, 
							"Pass",
							"User navigates to the parent window: current service page",
							"Navigates to parent page",
							"Should be able to navigate back to parent page");
				} else {
					statusTracker(br,driver, 
							"Fail",
							"User navigates to the parent window: current service page",
							"Doesnt navigates to parent page",
							"Should be able to navigate back to parent page");
				}

				Thread.sleep(12000);

				String CurrSer = driver.findElement(
						By.xpath("//*[@class='sub-header black-header']/span"))
						.getText();

				String strfind = "$";
				int iSuccess = CurrSer.indexOf(strfind);

				if (iSuccess == 0) {

					statusTracker(br,driver, 
							"Fail",
							"$ sign present in current service monthly charges",
							"$ not present", "$ should be present");
				}

				else {

					statusTracker(br,driver, 
							"Pass",
							"$ sign present in current service monthly charges",
							"$ present", "$ should be present");

				}
				int iStartAmount = iSuccess + 1;
				String per = "per";

				int iSpace = CurrSer.indexOf(per);
				int iEndAmount = iSpace - 1;

				String sAmount = CurrSer.substring(iStartAmount, iEndAmount);

				if (sAmount.equals(ctotal)) {

					statusTracker(br,driver, 
							"Pass",
							"Current service monthly charges should match as per the user",
							"Amount matches", "Amount should match");
				}

				else {

					statusTracker(br,driver, 
							"Fail",
							"Current service monthly charges should match as per the user",
							"Amount doesnt match", "Amount should match");
				}
				Tv_los_verify(br,Tv_plan, Tv_service, driver);
				Thread.sleep(4000);

				click_element(
						".//*[@id='js-main-form']/div/ul/li[1]/div[3]/ul/li[1]/label/input",
						driver);
				Thread.sleep(2000);
				if ((driver.findElement(By
						.xpath("//*[@analyticsname='current services:1:1:continue']")).isEnabled())) {

					statusTracker(br,driver, 
							"Pass",
							"For TV active on the account select Upgrade Your Plan",
							"TV upgrade your plan check box is selected",
							"TV upgrade your plan check box should be selected");
				} else {

					statusTracker(br,driver, 
							"Fail",
							"For TV active on the account select Upgrade Your Plan",
							"TV upgrade your plan check box is not selected",
							"TV upgrade your plan check box should be selected");
				}

				Internet_los_verify(br,Internet_plan, Internet_service, driver);
				Thread.sleep(4000);

				click_element(
						".//*[@id='js-main-form']/ul/li/div[3]/label",
						driver);
				Thread.sleep(2000);
				if ((driver.findElement(By
						.xpath("//*[@analyticsname='current services:1:1:continue']")).isEnabled())) {

					statusTracker(br,driver, 
							"Pass",
							"For Phone active on the account select Upgrade Your Plan",
							"Phone upgrade your plan check box is selected",
							"Phone upgrade your plan check box should be selected");
				} else {

					statusTracker(br,driver, 
							"Fail",
							"For Phone active on the account select Upgrade Your Plan",
							"Phone upgrade your plan check box is not selected",
							"Phone upgrade your plan check box should be selected");
				}

				//Phone_lob_verify(driver);
				Phone_los_verify(br,Phone_plan, Phone_service, driver);
                Thread.sleep(4000);
             
                          
                //to take screenshot and save in file
				
				File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				File targetFile = new File(spath +"////Test_Results////NewImages////"+ Page_Phone + screen_count + ".png");
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
                
                
                
				Thread.sleep(4000);

				click_element("//*[@id='js-main-form']/nav/a/span", driver);
				statusTracker(br,driver, "Pass", "clck on Continue button",
						"'Continue button is clicked",
						"should click continue button");
				Thread.sleep(5000);

				// Validating if user has navigated to TV Select a plan page
				if (return_text(".//*[@class='left']", driver).trim().equals(
						"Choose Your TV Plan"))
					statusTracker(br,driver, "Pass", "Click the Continue Button",
							"User is navigated to the TV Configuration page",
							"User should navigate to the TV Configuration page.");
				else
					statusTracker(br,driver, 
							"Fail",
							"Click the Continue Button",
							"User is NOT navigated to the TV Configuration page",
							"User should navigate to the TV Configuration page.");
				
				EBF_Logout(br,driver);

			}

			catch (Exception e) {
				exceptionHandler(br, e, driver);
				logger.info("RT_TV_003 Error is : " + e.getMessage());
			}
		} catch (Exception e) {
			exceptionHandler(br, e, driver);

		} finally {
			wb.close();
			driver.quit();

		}
	}

}
