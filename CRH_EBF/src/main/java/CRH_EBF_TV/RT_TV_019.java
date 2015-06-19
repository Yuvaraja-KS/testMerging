/* ****************************************************************************************************
File Name: 								RT_TV_019
Author: 								Shika
Description of test case: 				Checkout with No Box
Date of creation(D/M/Y): 				03/06/2014
Name and date(D/M/Y) of modification: 	Nithin K.S - 10/06/2014
Modification description: 				Modified to the efficient Xpath, wherever applicable.
 ******************************************************************************************************* */
package CRH_EBF_TV;

//import com.opera.core.systems.scope.protos.EcmascriptProtos.EvalResult.Status;
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

public class RT_TV_019 extends CommonFunctions {

	private static final int List = 0;
	String table, tns[];
	String tlimit, username, pwd, ctotal, Uname, Tv_plan, Internet_plan,
			Phone_plan, current_service;
	int tncount;
	String serAddress, Internet_service, Tv_service, Phone_service;

	public RT_TV_019() {
	}

	public RT_TV_019(String s) {
		this.path = s;
		logger.info("RT_TV_019...");
	}

	public boolean Isavailable(String fxp, WebDriver driver) {
		boolean xy = true;
		try {
			if (driver.findElement(By.xpath(fxp)) != null) {
				xy = true;
			}
		} catch (Exception e) {
			logger.info(e.getMessage());
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
			Page_Phone = "RT_TV_019_";
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
					//TV_lob_click(driver);
					driver.findElement(By.xpath(".//*[@value='select_tv']")).click();
					Thread.sleep(2000);
					
					 //to take screenshot and save in file
					
					File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
					File targetFile = new File(spath +"//Test_Results//NewImages//"+ Page_Phone + screen_count + ".png");
					FileUtils.copyFile(screenshot, targetFile);		
					logger.info("copied file into New Images folder"+targetFile);
					
				
					if(url.contains("beta"))
						 
					 {
					String env="Beta";
					Image_compare(br,env,Page_Phone,Overall_Path,screen_count,driver);
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
							
					driver.findElement(By.xpath("//*[@class='arrow']")).click();
					Thread.sleep(8000);
				click_element("//*[@id='content']/div[3]/div[2]/div/div[2]/div[1]/div[2]/div/div/div/div[6]/header/ul/li[5]/div/a/span",
							driver);
			
					Thread.sleep(8000);
					if (driver.findElement(By.xpath("//*[@class='rtf']"))
							.isDisplayed()) {
						statusTracker(br,driver, 
								"Pass",
								"Validate that a message displays indicating the user's current equipment",
								"Message displayed",
								"Message should be displayed");
					} else {
						statusTracker(br,driver, 
								"Fail",
								"Validate that a message displays indicating the user's current equipment",
								"Message not displayed",
								"Message should be displayed");
					}

					if (driver.findElement(
							By.xpath("//*[@class='tv-equip-box']"))
							.isDisplayed()) {
						statusTracker(br,driver, 
								"Pass",
								"Validate the Primary Equipment section is open",
								"Primary equipment section is  displayed",
								"Primary equipment section should  be displayed");
					} else {
						statusTracker(br,driver, 
								"Fail",
								"Validate the Primary Equipment section is open",
								"Primary equipment section is not displayed",
								"Primary equipment section should be displayed");
					}
					// Add Equipment
					if (driver.findElement(By.xpath(".//*[@name='inc-box']"))
							.isDisplayed()) {
						statusTracker(br,driver, 
								"Pass",
								"Validate the radio buttons present for all the add equipment options",
								"Radio button for add equipment options present",
								"Radio Button Should be present");
					} else {
						statusTracker(br,driver, 
								"Fail",
								"Validate the radio buttons present for all the add equipment options",
								"Radio button for add equipment options not present",
								"Radio Button Should be present");
					}
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
					// Additional Equipment expand
					driver.findElement(
							By.xpath("//*[@id='content']/div[3]/div[2]/div/div[2]/div/div[2]/div/div[2]/div[1]/section/div/div[4]/form/div[2]/header/ul/li[1]/a"))
							.click();
					statusTracker(br,driver, "", "Expand the Additional boxes section",
							"Clicked", " ");
					Thread.sleep(5000);

					String Equip_name1[] = new String[10];
					List<WebElement> myli_equip = driver.findElements(By
							.xpath("//*[@class='tv-equip-box']/h4"));
					
					int No_of_TvEquipment = myli_equip.size();
					for (int i = 0; i < 4; i++) {
						Equip_name1[i] = driver
								.findElement(
										By.xpath("//*[@id='content']/div[3]/div[2]/div/div[2]/div/div[2]/div/div[2]/div[1]/section/div/div[4]/form/div[1]/section/div/ul/li["
												+ (i + 1) + "]/h4")).getText();
						logger.info(" Tv Equipment:" + Equip_name1[i]);
						statusTracker(br,driver, " ", "cart details", "eqipment name is: "
								+ Equip_name1[i] + " and item cost is: "
								+ Equip_name1[i],
								"selected eqipment should be added to cart");
						if ((Equip_name1[i]).trim().equals(
								"CableCARD™ with Tuning Adapter")
								|| (Equip_name1[i]).trim().equals("HD Box")
								|| (Equip_name1[i]).trim().equals("HD-DVR Box and Service")
								|| (Equip_name1[i]).trim().equals("Digital Transport Adapter")) {
							statusTracker(br,driver, 
									"Pass",
									"Validate the options in the TV Equipment section",
									"Present", "Should be present");
						} else {
							statusTracker(br,driver, 
									"Fail",
									"Validate the options in the TV Equipment section",
									"Not Present", "Should be present");
						}
					}

					config_page_Cart_result_updater_1(br,driver);
					Thread.sleep(2000);
					page_Cart_One_Time_charge_updater_1(br,driver);
					Thread.sleep(2000);
					// click_element("//*[@id='nobox']", driver);
					//statusTracker(br,driver, " ", "I dont want any box selected", "", "");

					Thread.sleep(2000);
			//		config_page_Cart_result_updater_1(driver);
					Thread.sleep(2000);
			//		page_Cart_One_Time_charge_updater_1(driver);
					Thread.sleep(2000);

					 //to take screenshot and save in file
					
					screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
					targetFile = new File(spath+"//Test_Results//NewImages//"+ Page_Phone + screen_count + ".png");
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
					
					driver.findElement(By.xpath("//*[@class='arrow']")).click();
					Thread.sleep(12000);

					
					if (return_text("//*[@class='wrap']/div/h2", driver)
							.equalsIgnoreCase(
									"Choose Installation & Review Order")) {
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

					Thread.sleep(3000);
					
 //to take screenshot and save in file
					
					
					
				
					if(url.contains("beta"))
						 
					 {
						String env="Beta";
						Image_compare(br,env,Page_Phone,Overall_Path,screen_count,driver);
					Thread.sleep(15000);
					logger.info("Beta Environment");
					 }
					 else
					 {
						 String env="Prod";
						 Image_compare(br,env,Page_Phone,Overall_Path,screen_count,driver);
					Thread.sleep(15000);
					logger.info("Prod Environment");
					
					 }
					screen_count++;
					
					
					driver.findElement(By.linkText("Sign Out")).click();
					Thread.sleep(10000);

					if (Isavailable(".//*[@class='twc-last js-last']/a", driver))
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

				}

				driver.quit();

			}

			catch (Exception e) {
				exceptionHandler(br, e, driver);
				logger.info("RT_TV_019 Error is : " + e.getMessage());
			}
		} catch (Exception e) {
			exceptionHandler(br, e, driver);
		} finally {
			wb.close();
			driver.quit();

		}
	}
}
