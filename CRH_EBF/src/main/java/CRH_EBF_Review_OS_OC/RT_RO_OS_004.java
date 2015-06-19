
//File Name: RT_RO_OS_004
//Author: Nithin 
//Description of test case: Review Order -Technician appointment 
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

public class RT_RO_OS_004 extends CommonFunctions {

	String table, tns[];
	String tlimit, username, pwd, ctotal, Uname, Tv_plan, Internet_plan,
			Phone_plan, current_service;
	int tncount;
	String serAddress, Internet_service, Tv_service, Phone_service,
			str_Browser;

	public RT_RO_OS_004() {
	}

	public RT_RO_OS_004(String s) {
		this.path = s;
		logger.info("RO_OS_004 is intialized");
	}

	@Override
	public void execute(String br,WebDriver driver, String url, int loc,String Overall_Path,String env) throws Exception {
		int screen_count = 1;
		File data = new File(this.path);
		WorkbookSettings ws = new WorkbookSettings();
		ws.setLocale(new Locale("er", "ER"));
		//arrcount = 0;
		logger.info("chheck1");
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
			Page_Phone="RT_RO_OS_004_";

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

				Internet_lob_click(driver);
				Thread.sleep(2000);

				driver.findElement(By.cssSelector("span.arrow")).click();
				logger.info("clicked continue button on page 1");
				Thread.sleep(8000);

				Page_TV = " Page_2_Plan page ";
				Thread.sleep(15000);
				driver.findElement(
						By.xpath(".//*[@class='plans']/div[3]/header/ul/li[5]/div/a/span"))
						.click();
				Thread.sleep(14000);

				Page_Internet = "Page_3_config_page";

				try {

					config_page_Cart_result_updater_1(br,driver);
					page_Cart_One_Time_charge_updater_1(br,driver);
					Thread.sleep(3000);

					I_will_use_my_modem(driver);
					Thread.sleep(3000);
					config_page_Cart_result_updater_1(br,driver);
					page_Cart_One_Time_charge_updater_1(br,driver);
					Thread.sleep(3000);

					HomeWiFi_InternetModem(driver);
					Thread.sleep(3000);
					config_page_Cart_result_updater_1(br,driver);
					page_Cart_One_Time_charge_updater_1(br,driver);
					Thread.sleep(3000);

					InternetModem(driver);
					Thread.sleep(3000);
					config_page_Cart_result_updater_1(br,driver);
					page_Cart_One_Time_charge_updater_1(br,driver);
					Thread.sleep(3000);

					driver.findElement(By.cssSelector("span.arrow")).click();
					System.out
							.println("clicked continue button on config page");

					Thread.sleep(8000);

					statusTracker(br,driver," ", "Checkpoint", " ", " ");
					Thread.sleep(20000);

					Page_Internet = "Page_4_Review_order_page";

					Internet_ReviewOrder_ChkMonthlyCharges(br,driver);
					Internet_ReviewOrder_ChkOneTimeCharges(br);

					System.out
							.println("Nithin Review Page - Validating the Installation Options - Internet");
					Thread.sleep(20000);

					boolean storePick = Isavailable(
							".//*[@data-name='Store Pickup']", driver);
					boolean eMail = Isavailable(
							".//*[@data-name='Mail to Home']", driver);
					boolean TechInstall = Isavailable(
							".//*[@data-name='Technician Visit']", driver);

					logger.info(storePick + " : " + eMail + " : "
							+ TechInstall);

					logger.info("mon_total : " + mon_total);
					double overallOneTimeCharges = Double.parseDouble(mon_total
							.replace("$", ""));
					logger.info("1");
					if (storePick == true && eMail == true
							&& TechInstall == true) {
						logger.info("All 3 options are available");
						statusTracker(br,driver,
								"Pass",
								"Verify if all the ECK options are displayed in the Review Order Page",
								"All 3 ECK options are displayed",
								"All the 3 ECK options should be present");
						logger.info("1.1");
					} else {
						statusTracker(br,driver,
								"Fail",
								"Verify if all the ECK options are displayed in the Review Order Page",
								"All 3 ECK options are NOT displayed",
								"All the 3 ECK options should be present");
						logger.info("1.2");
					}
					logger.info("1.3");

					// Pick-up
					logger.info("Pick up is enabled");
					if (driver.findElement(
							By.xpath(".//*[@data-name='Store Pickup']"))
							.isSelected()) {
						logger.info("1.4");
						statusTracker(br,driver,
								"Pass",
								"ECK options by Default the Store Option should be selected.",
								"By Default, the Store Option is selected.",
								"Store Option is selected.");

						Internet_ReviewOrder_ECKInstallationOptions(br,"Store",
								overallOneTimeCharges,driver);
						Thread.sleep(4000);

						driver.findElement(
								By.xpath(".//*[@data-name='Mail to Home']"))
								.click();
						Thread.sleep(6000);
					} else
						statusTracker(br,driver,
								"Fail",
								"ECK options by Default the Store Option should be selected.",
								"By Default, the Store Option is NOT selected.",
								"Store Option must be selected selected.");
					logger.info("1.6");
					// Mail
					if (driver.findElement(
							By.xpath(".//*[@data-name='Mail to Home']"))
							.isSelected()) {
						logger.info("Mail is enabled");
						Thread.sleep(8000);
						Internet_ReviewOrder_ECKInstallationOptions(br,"Mail",
								overallOneTimeCharges,driver);

						driver.findElement(
								By.xpath(".//*[@data-name='Technician Visit']"))
								.click();
						
						Thread.sleep(6000);
					}
					// Technician Install
					if (driver.findElement(
							By.xpath(".//*[@data-name='Technician Visit']"))
							.isSelected()) {
						logger.info("Tech is enabled");
						Thread.sleep(6000);

						//Image_compare changes -JS Start
						Image_compare(br,env,Page_Phone,Overall_Path,screen_count,driver);
	                    screen_count++;
	                  //Image_compare changes -JS End
						
						
						Internet_ReviewOrder_ECKInstallationOptions(br,
								"TechInstall", overallOneTimeCharges,driver);
						Thread.sleep(6000);
					}

					Thread.sleep(10000);
					Internet_Capture_ReviewOrder_UponChangeinECK(driver);
					Thread.sleep(8000);

					
					if (Isavailable(".//a[@data-lob='Internet']", drive))
						statusTracker(br,driver,
								"Pass",
								"Edit link should be displayed next to the Internet LOB",
								"Edit Link is displayed",
								"Edit link should be present");
					else
						statusTracker(br,driver,
								"Fail",
								"Edit link should be displayed next to the Internet LOB",
								"Edit Link is NOT displayed",
								"Edit link should be present");

					driver.findElement(
							By.xpath(".//*[@class='js-next-button blue-button']"))
							.click();
					Thread.sleep(8000);
					statusTracker(br,driver," ", "Checkpoint", " ", " ");

					Page_Internet = "Page_5_order_summary_page";
					Thread.sleep(35000);

					Internet_OrderSummary_DetailsValidation(br,Uname, serAddress,driver);
					Thread.sleep(3000);
					Internet_OrderSummary_ChkMonthlyCharges(br);
					Thread.sleep(3000);
					Internet_OrderSummary_ChkOneTimeCharges(br);

					Thread.sleep(2000);
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

					logger.info("reached the end code");

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
