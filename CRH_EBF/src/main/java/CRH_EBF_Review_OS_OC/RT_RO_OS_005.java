
//File Name: RT_RO_OS_005
//Author: Nithin 
//Description of test case: Review Order - Split Install - One time visit
//Date of creation(D/M/Y): 3/14/2014
//Name and date(D/M/Y) of modification: RAHUL JADOW (9/6/2014)
 
//Name and date(D/M/Y) of modification: RAHUL JADOW (27/6/2014)
//Modification description: Failure updates

package CRH_EBF_Review_OS_OC;

import java.io.File;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;

import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class RT_RO_OS_005 extends CommonFunctions {

	String table, tns[];
	String tlimit, username, pwd, ctotal, Uname, Tv_plan, Internet_plan,
			Phone_plan, current_service;
	int tncount;
	String serAddress, Internet_service, Tv_service, Phone_service,
			str_Browser;

	public RT_RO_OS_005() {
	}

	public RT_RO_OS_005(String s) {
		this.path = s;
		logger.info("RO_OS_005 is intialized");
	}

	@Override
	public void execute(String br,WebDriver driver, String url, int loc,String Overall_Path,String env) throws Exception {
		int screen_count = 1;
		File data = new File(this.path);
		WorkbookSettings ws = new WorkbookSettings();
		ws.setLocale(new Locale("er", "ER"));
		//arrcount = 0;
		Workbook wb = Workbook.getWorkbook(data, ws);

		try {
			String tv = "", inet = "", phone = "";
			Sheet sheet2 = wb.getSheet("Review_OS_OC");

			String Sheet_name = sheet2.getName();

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
			
			
			/*int tv1 = 0, inet1 = 0, phone1 = 0;
			int val = 1;
			int tlim = Integer.parseInt(tlimit);
			tlim *= 60;
			tlimit = Integer.toString(tlim);
			tlimit = tlimit + "000";*/
			Page_TV = " Page_1_Current Service ";
			Page_Phone="RT_RO_OS_005_";

			/*
			String int_plan = tv = sheet2.getCell(15, loc).getContents();
			String int_eqipment = sheet2.getCell(18, loc).getContents();
			String phone_plan = sheet2.getCell(19, loc).getContents();
			inet = sheet2.getCell(12, loc).getContents();
			phone = sheet2.getCell(13, loc).getContents();*/
			
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
					firstrun(br,driver, username, pwd, ctotal, Uname,
							serAddress);

				Thread.sleep(5000);

				Tv_los_verify(br,Tv_plan, Tv_service, driver);
				Thread.sleep(2000);

				Internet_Phone_lob_verify(br,driver);
				Thread.sleep(2000);

				TV_Equipment_Click(br,driver);
				Thread.sleep(2000);

				Phone_lob_click(driver);
				Thread.sleep(2000);

				driver.findElement(By.cssSelector("span.arrow")).click();

				Page_TV = " Page_2_TV Plan page";
				statusTracker(br,driver," ", "Checkpoint", " ", " ");
				Thread.sleep(12000);

				click_element(".//*[@data-name='HD-DVR Box and Service']",
						driver);
				Thread.sleep(8000);

				try {

					config_page_Cart_result_updater_1(br,driver);
					page_Cart_One_Time_charge_updater_1(br,driver);
					Thread.sleep(3000);

					driver.findElement(By.cssSelector("span.arrow")).click();
					Page_TV = " Page_2_Phone Plan page";

					Thread.sleep(50000);
					driver.findElement(
							By.xpath(".//*[@class='plans']/div[1]/header/ul/li[5]/div/a"))
							.click();
					Thread.sleep(5000);

					Page_Internet = "Page_3_config_page";
					statusTracker(br,driver," ", "Checkpoint", " ", " ");
					Thread.sleep(10000);

					transfer_number_2_MultipleLOB_Combination(br,driver);
					Thread.sleep(10000);

					Page_Internet = "Page_4_Review_order_page";

					//Image_compare changes -JS Start
					Image_compare(br,env,Page_Phone,Overall_Path,screen_count,driver);
                    screen_count++;
                  //Image_compare changes -JS End
					
					ReviewOrder_TV_ChkMonthlyCharges(br,driver);
					Thread.sleep(5000);
					ReviewOrder_Phone_ChkMonthlyCharges(br,driver);
					Thread.sleep(3000);
					ReviewOrder_ChkOneTimeCharges(br,driver);
					Thread.sleep(3000);
										
					Validate_Visit_Options(br,driver);
					Thread.sleep(3000);

					Thread.sleep(8000);

					Page_Internet = "Page_5_Review_order_page_Passed";
					statusTracker(br,driver,"refer_screenshot", " ", " ", " ");
					driver.findElement(
							By.xpath(".//*[@class='js-next-button blue-button']"))
							.click();
					statusTracker(br,driver," ", "Checkpoint", " ", " ");

					Page_Internet = "Page_5_order_summary_page _started";
					Thread.sleep(30000);

					OrderSummary_TV_ChkMonthlyCharges(br);
					Thread.sleep(3000);
					OrderSummary_Phone_ChkMonthlyCharges(br,driver);
					Thread.sleep(3000);
					Package_OrderSummary_ChkOneTimeCharges(br,driver);
					Thread.sleep(3000);
					OrderSummary_DetailsValidation(br,Uname, serAddress,driver);

										
					statusTracker(br,driver,"", "Checkpoint", "", "");

					driver.findElement(By.linkText("Sign Out")).click();
					Thread.sleep(10000);

					if (Isavailable(".//*[@id='new_form_st_address']", driver))
						statusTracker(br,driver,
								"Pass",
								"Click on the Sign out button",
								"Customer is Logged Out from the current session.",
								"Customer should Log Out.");
					else
						statusTracker(br,driver,
								"Fail",
								"Click on the Sign out button",
								"Customer is NOT Logged Out from the current session.",
								"Customer should Log Out.");

					logger.info("reached the end code............");

				} catch (Exception e) {
					logger.info("error is: " + e.getMessage());
					exceptionHandler(br,e, driver);

				}
			}

			catch (Exception e) {
				exceptionHandler(br,e, driver);
				logger.info("error is : " + e.getMessage());
			}
		} catch (Exception e) {
			exceptionHandler(br,e, driver);

		} finally {
			wb.close();
			driver.close();

		}
	}

}
