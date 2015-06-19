//File Name: RT_Phone_010
//Author: Nithin Ks
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

public class RT_Phone_010 extends CommonFunctions {

	String table, tns[];
	String tlimit, username, pwd, ctotal, Uname, Tv_plan, Internet_plan,
			Phone_plan, current_service;
	int tncount;
	String serAddress, Internet_service, Tv_service, Phone_service,
			str_Browser;

	public RT_Phone_010() {
	}

	public RT_Phone_010(String s) {
		this.path = s;
	//	this.path1 = phone;
		logger.info("Phone is intialized 10...........................");
	}

	public boolean Isavailable(String fxp, WebDriver driver) {
		boolean xy = true;

		try {
			if (driver.findElement(By.xpath(fxp)) != null) {
				logger.info("gone inside");
				logger.info("",true);
				xy = true;
			}
		} catch (Exception e) {
			logger.info(e.getMessage());
			logger.info("",false);
			xy = false;
		}
		return xy;
	}

	public void execute(String br,WebDriver driver,String url, int loc)throws Exception {
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
			String tv = "", inet = "", phone = "";
			Sheet sheet2 = wb.getSheet("Phone");
			Page_Phone="RT_Phone_010_";
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
			
			Page_TV = " Page_1_Current Service ";

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
				logger.info("Chek if url opened");
				// statusTracker(br,driver,"Pass", " ", " ", " ");
			}

			try {
				if (first == 0)
					firstrun(br,driver, username, pwd,  ctotal, Uname,
							serAddress);
				logger.info("I went to next step");

				Thread.sleep(4000);

				Tv_los_verify(br,Tv_plan, Tv_service, driver);
				Thread.sleep(2000);

				//Internet_Phone_lob_verify(br,driver);
				Thread.sleep(2000);

				statusTracker(br,driver,"", "Add Phone", "", "");
				Thread.sleep(2000);

				Phone_lob_click(br,driver);
				Thread.sleep(2000);

		

				if ((driver.findElement(By
						.xpath("//*[@class='button-nav ']/a")).isEnabled())) {
					logger.info("pass1");
					statusTracker(br,driver,"Pass", "Continue button on service page",
							"Enabled", "should be enabled");
				} else {
					logger.info("fail1");
					statusTracker(br,driver,"Fail", "Continue button on service page",
							"Disabled", "should be enabled");
				}

				driver.findElement(By.xpath("//*[@class='button-nav ']/a"))
						.click();
				Thread.sleep(10000);

				//JS//Page_Phone = "Page_2_select_plan_page";
			
				if (return_text(
						".//*[@class='active']/span",
						driver).equals("Phone")) {
					statusTracker(br,driver,"Pass",
							"Validate the secondary progress bar",
							"Phone is displayed in progress bar",
							"Secondary progress bar should display  Phone ");
				} else {
					statusTracker(br,driver,"Fail",
							"Validate the secondary progress bar",
							"Phone is not displayed in progress bar",
							"Secondary progress bar should display Phone ");
				}
				Thread.sleep(2000);

				
				
				if (isElementPresent(
						".//*[@class='miniCart']/div[1]/header",
						driver)) {
					statusTracker(br,driver,"Pass",
							"check current services module is present",
							"current services module is present",
							"current services module should display");
				

					
					if (driver
							.findElement(
									By.xpath(".//*[@class='miniCart']/div[1]/header/ul/li[2]/a"))
							.isDisplayed()) {
						statusTracker(br,driver,
								"Pass",
								"check if The Current Services module is in the default close state ",
								"Current Services module is not in closed state by default",
								"Current Services module should be in closed state by default");
						logger.info(" Yes the list is expanded");
					} else {
						statusTracker(br,driver,
								"Fail",
								"check if The Current Services module is NOT in the default close state ",
								"Current Services module is NOT in closed state by default",
								"Current Services module should be in closed state by default");
						logger.info(" Yes the list is not expanded");
					}

					
					
					
					Page_Internet = "Page_2_select_plan_page_Passed";

					statusTracker(br,driver,"refer_screenshot", " ", " ", " ");

					driver.findElement(
							By.xpath(".//*[@class='checkoutCTA']/a"))
							.click();
					Thread.sleep(10000);
					System.out
							.println("End of second page and entering into third page-1");
					Page_Internet = "Page_3_config_page_started";
					statusTracker(br,driver,"refer_screenshot", " ", " ", " ");

					try {

						if (driver
								.findElement(
										By.xpath("//*[@class='text parbase featureSectionHeader twc-plain-text-p-strong']"))
								.isDisplayed()
								&& driver
										.findElement(
												By.xpath(".//*[@class='text parbase internationalSectionLabel twc-plain-text-p-strong']/p/strong"))
										.isDisplayed()) {
							statusTracker(br,driver,
									"Pass",
									"verify the 'Select optional features and calling plan' is displayed in expanded form",
									"'Select optional features and calling plan' section is displayed in the default expanded state",
									"The details should be as expected");
						} else {
							statusTracker(br,driver,
									"Fail",
									"verify the 'Select optional features and calling plan' is displayed in expanded form",
									"'Select optional features and calling plan' section is not displayed in the default expanded state",
									"The details should be as expected");
						}

						if (driver.findElement(By.xpath(".//*[@data-shortname='No International Calling Plan']"))
								.isSelected()) {
							statusTracker(br,driver,
									"Pass",
									"Validate the default selection is \"I do not want an International Calling Plan\"",
									"The select International calling plan section is expanded, with the default selection being no International Calling plan.",
									"The select International calling plan must be expanded, with the default selection being no International Calling plan.");
						} else {
							statusTracker(br,driver,
									"Fail",
									"Validate the default selection is \"I do not want an International Calling Plan\"",
									"The select International calling plan section is NOT expanded, with the NO default selection being no International Calling plan.",
									"The select International calling plan must be expanded, with the default selection being no International Calling plan.");
						}

						click_PrivateListening(br,driver);
						Thread.sleep(8000);
						config_page_Cart_result_updater_1(br,driver);
						page_Cart_One_Time_charge_updater_1(br,driver);
						Thread.sleep(2000);

						click_VoiceMail(br,driver);
						Thread.sleep(2000);
						config_page_Cart_result_updater_1(br,driver);
						page_Cart_One_Time_charge_updater_1(br,driver);
						Thread.sleep(2000);

						click_GlobalPenny(br,driver);
						Thread.sleep(8000);
					
						
					
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
						
						config_page_Cart_result_updater_1(br,driver);
						page_Cart_One_Time_charge_updater_1(br,driver);
						statusTracker(br,driver,"Pass", "Global Plan Description text is displayed",
								"Global Plan Description text is displayed",
								"Global Plan Description text should be displayed");
						Thread.sleep(3000);

						
						
						click_International(br,driver);
						Thread.sleep(2000);
						
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
						
						config_page_Cart_result_updater_1(br,driver);
						statusTracker(br,driver,"Pass", "International One price Description text is displayed",
								"International One price Description text is displayed",
								"International One price Description text should be displayed");
						page_Cart_One_Time_charge_updater_1(br,driver);
						Thread.sleep(3000);

						// Compare Plan Page check
						driver.findElement(
								By.xpath("//*[@class='modal modalGeneric js-modal-initialized']"))
								.click();
						logger.info("two");

						Thread.sleep(10000);

						String modal_title = driver.findElement(
								By.xpath(".//*[@class='modal-title']"))
								.getText();
						if (modal_title
								.equalsIgnoreCase("International Calling Rates")) {
							statusTracker(br,driver,"Pass", "Click on Compare Plan link",
									"Compare Plan link is clicked",
									"Compare plan link should be clicked");
							logger.info("tHREE" + "");
						} else {
							statusTracker(br,driver,"Fail", "Click on Compare Plan link",
									"Compare Plan link is not clicked",
									"Compare plan link should be clicked");
						}

						driver.findElement(
								By.xpath("//*[@class='modal-button-close']"))
								.click();
						Thread.sleep(5000);
						
						
						

						String Act_config = driver
								.findElement(
										By.xpath("//*[@class='text parbase sectionHeader twc-plain-text']"))
								.getText();
						if (Act_config
								.equalsIgnoreCase("Select Optional Features & Calling Plans")) {
							statusTracker(br,driver,"Pass",
									"Click on close button of Compare Plan",
									"Compare Plan gets closed",
									"Compare plan should get closed");
						} else {
							statusTracker(br,driver,"Fail",
									"Click on close button of Compare Plan",
									"Compare Plan does not gets closed",
									"Compare plan should get closed");
						}

						Thread.sleep(5000);

						
						
			

						// Click Continue to next plan
						/*click_element(".//*[@class='content-wrap']/div[9]/a",
								driver);*/
						Thread.sleep(7000);
						if (driver.findElement(By.id("js-phoneNumber-new"))
								.isDisplayed()
								&& driver.findElement(
										By.id("js-phoneNumber-transfer"))
										.isDisplayed())

						{
							Thread.sleep(2000);
							statusTracker(br,driver,
									"Pass",
									"Check for Add new number and transfer existing number options",
									"Both options are present",
									"BOth options should be present");
						} else {
							statusTracker(br,driver,
									"Fail",
									"Check for Add new number and transfer existing number options",
									"Just one options is present",
									"Both options should be present");
						}

						
						click_element("//*[@id='js-phoneNumber-transfer']",
								driver);
						Thread.sleep(5000);
						if (driver
								.findElement(
										By.xpath("//*[@class='transfer-number general-form']"))
								.isDisplayed()) {
							statusTracker(br,driver,
									"Pass",
									"Transfer number general form gets displayed",
									"Transfer number general form is displayed",
									"Transfer number general form should be displayed");
						} else {
							statusTracker(br,driver,
									"Fail",
									"Transfer number general form gets displayed",
									"Transfer number general form is not displayed",
									"Transfer number general form should be displayed");
						}

						statusTracker(br,driver,"Refer sceenshot", "Checkpoint ", " ",
								" ");
						logger.info("Reached the End Code.............");
						
						
								

					} catch (Exception e) {
						logger.info("error is: " + e.getMessage());
						exceptionHandler(br,e, driver);

					}

				}

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
