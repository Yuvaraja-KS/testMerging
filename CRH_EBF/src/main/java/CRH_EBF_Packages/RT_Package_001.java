 
//File Name: RT_Package_001
//Author: 
//Description of test case: Add/Upgrade TV - customer selects package offer & presented with upgrade options
//Date of creation(D/M/Y): 11/3/2014
//Name and date(D/M/Y) of modification: Raveena Singh  6/6/2014

  

package CRH_EBF_Packages;

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

public class RT_Package_001 extends CommonFunctions {
	String table, tns[];
	String tlimit, username, pwd, ctotal, Uname, Tv_plan, Internet_plan,
			Phone_plan, current_service;
	int tncount;
	String serAddress, Internet_service, Tv_service, Phone_service,
			str_Browser;

	public RT_Package_001() {
	}

	public RT_Package_001(String s) {
		this.path = s;
	}
	public void execute(String br, WebDriver driver, String url, int loc,String Overall_Path,String env) throws Exception {
		
		int screen_count = 1;
		File data = new File(this.path);
		WorkbookSettings ws = new WorkbookSettings();
		ws.setLocale(new Locale("er", "ER"));
		
		Workbook wb = Workbook.getWorkbook(data, ws);

		try {
			String tv = "", inet = "", phone = "";
			Sheet sheet2 = wb.getSheet("Packages");
			String Sheet_name = sheet2.getName();

			str_Browser = sheet2.getCell(3, loc).getContents();
			tlimit = sheet2.getCell(6, loc).getContents();
			username = sheet2.getCell(Col_locator_full_scan_input_sheet("USERNAME", path,Sheet_name), loc).getContents();
			logger.info("UN"+username);
			pwd = sheet2.getCell(Col_locator_full_scan_input_sheet("PASSWORD", path,Sheet_name), loc).getContents();
			logger.info("PW"+pwd);
			ctotal = sheet2.getCell(Col_locator_full_scan_input_sheet("C-TOTAL", path,Sheet_name), loc).getContents();
			logger.info("PW"+ctotal);
			Uname = sheet2.getCell(Col_locator_full_scan_input_sheet("ACCOUNT NAME", path,Sheet_name), loc).getContents();
			serAddress = sheet2.getCell(Col_locator_full_scan_input_sheet("SERVICE ADDRESS", path,Sheet_name), loc).getContents();
			Tv_service = sheet2.getCell(Col_locator_full_scan_input_sheet("TV SERVICE", path,Sheet_name), loc).getContents();
			Internet_service = sheet2.getCell(Col_locator_full_scan_input_sheet("INTERNET SERVICE", path,Sheet_name), loc).getContents();
			Phone_service = sheet2.getCell(Col_locator_full_scan_input_sheet("PHONE SERVICE", path,Sheet_name), loc).getContents();
			Tv_plan = sheet2.getCell(Col_locator_full_scan_input_sheet("TV PLAN", path,Sheet_name), loc).getContents();
			Internet_plan = sheet2.getCell(Col_locator_full_scan_input_sheet("INTERNET PLAN", path,Sheet_name), loc).getContents();
			Phone_plan = sheet2.getCell(Col_locator_full_scan_input_sheet("PHONE PLAN", path,Sheet_name), loc).getContents();
			logger.info("Phone_Plan"+Phone_plan);
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
			Page_Phone = "RT_Package_001_";
			
			logger.info("entereeee");

			
			if (first == 0) {
				logger.info("trying to open the url");
				driver.manage().window().maximize();
				driver.get(url);
				logger.info("Chek if url opened");
			
			}

			try {

				logger.info("Package_001");

				if (first == 0) {
					firstrun(br, driver, username, pwd,ctotal, Uname,
							serAddress);
				}
				Page_Internet = "Page_1_Current services_started";

				Thread.sleep(5000);

				if (Isavailable(
						"//*[@class='js-next-button blue-button center']",
						driver))
					statusTracker(br, 
							"Pass",
							"User clicks on “View All Packages” link on Your Services page.",
							"User is able to view all packages on this page.",
							"User should be able to view all packages on this page. ");
				else
					statusTracker(br, 
							"Fail",
							"User clicks on “View All Packages” link on Your Services page.",
							"User is NOT able to view all packages on this page.",
							"User should be able to view all packages on this page. ");

						
				Thread.sleep(2000);
				click_element(
						"//*[@class='js-next-button blue-button center']",
						driver);

				Thread.sleep(5000);
				click_element(".//*[@id='tv-filter']", driver);
				click_element(".//*[@id='internet-filter']", driver);

								
				if (Isavailable(".//*[@id='tv-filter']", driver)
						&& Isavailable(".//*[@id='internet-filter']", driver)
						&& Isavailable(".//*[@id='phone-filter']", driver)
						&& Isavailable(".//*[@id='show-all-filter']", driver))
					statusTracker(br, 
							"Pass",
							"The user has four (4) check boxes that can be selected in the Offer type Filter.",
							"User is be able to select two or more services.",
							"User should be able to select two or more services.");
				else
					statusTracker(br, 
							"Fail",
							"The user has four (4) check boxes that can be selected in the Offer type Filter.",
							"User is NOT able to select two or more services.",
							"User should be able to select two or more services.");

				Thread.sleep(8000);
				
				//to take screenshot and save in file
				Image_compare(br,env,Page_Phone,Overall_Path,screen_count,driver);
				screen_count++;
				/* File /*screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				File targetFile = new File(Overall_Path +"//Test_Results//NewImages//"+ Page_Phone + screen_count + ".png");
				FileUtils.copyFile(screenshot, targetFile);		
				logger.info("copied file into New Images folder"+targetFile);
				
			
				Image_compare(br,env,Page_Phone,Overall_Path,screen_count);
				logger.info("img cmprsn done");
				screen_count++;*/
				
				if (Isavailable(
						".//*[@class='packages-list']/li[1]/div/div[4]/a[1]/span",
						driver))
					statusTracker(br, 
							"Pass",
							"Select the Lowest package click on the \"Order No\"",
							"User is navigated to the TV Configuration page. (TV Select a plan page is skipped)",
							"User must be navigated to the TV Configuration page.");
				else
					statusTracker(br, 
							"Fail",
							"Select Lowest package click on the \"Order No\"",
							"User is NOT navigated to the TV Configuration page. (TV Select a plan page is NOT skipped)",
							"User must be navigated to the TV Configuration page.");
				
				JavascriptExecutor jsx1 = (JavascriptExecutor)driver;
				jsx1.executeScript("window.scrollBy(0,450)", "");
				
				JavascriptExecutor jsx = (JavascriptExecutor)driver;
				jsx.executeScript("window.scrollBy(0,450)", "");
				
				click_element(".//*[@class='packages-list']/li[1]/div/div[4]/a[1]/span",
						driver);
				Page_Internet = "Page_2_select_plan_page_started";
				
				Thread.sleep(8000);
				Thread.sleep(8000);

	//to take screenshot and save in file
				Image_compare(br,env,Page_Phone,Overall_Path,screen_count,driver);
				screen_count++;
				/*screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				targetFile = new File(Overall_Path +"//Test_Results//NewImages//"+ Page_Phone + screen_count + ".png");
				FileUtils.copyFile(screenshot, targetFile);		
				logger.info("copied file into New Images folder"+targetFile);
				
			
				Image_compare(br, env,Page_Phone,Overall_Path,screen_count);
				screen_count++;*/
				
				// TV progress bar
				if (return_text(
						"//*[@class='active']/span",
						driver).equals("TV")) {
					statusTracker(br, "Pass",
							"Validate the secondary progress bar",
							"TV is displayed in progress bar",
							"Secondary progress bar should display TV ");
				} else {
					statusTracker(br, "Fail",
							"Validate the secondary progress bar",
							"TV is not displayed in progress bar",
							"Secondary progress bar should display TV ");
				}

				driver.quit();
			}

			catch (Exception e) {
				exceptionHandler(br, e, driver);
				logger.info("error is : " + e.getMessage());
			}

		} catch (Exception e) {
			exceptionHandler(br, e, driver);

		}

		finally {
			wb.close();
			driver.close();

		}

	}

}