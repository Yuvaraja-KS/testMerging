/* ****************************************************************************************************
File Name: 								RT_TV_021
Author: 								Shikha
Description of test case: 				Add Premium Channel Alacarte
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

public class RT_TV_021 extends CommonFunctions {

	private static final int List = 0;
	String table, tns[];
	String tlimit, username, pwd, ctotal, Uname, Tv_plan, Internet_plan,
			Phone_plan, current_service;
	int tncount;
	String serAddress, Internet_service, Tv_service, Phone_service;

	public RT_TV_021() {
	}

	public RT_TV_021(String s) {
		this.path = s;
		logger.info("RT_TV_021....");
	}

	public boolean Isavailable(String fxp, WebDriver driver) {
		boolean xy = true;
		try {
			if (driver.findElement(By.xpath(fxp)) != null) {
				xy = true;
			}
		} catch (Exception e) {
			logger.info("Isavailable error message : " + e.getMessage());
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
			Page_Phone = "RT_TV_021_";
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
					TV_lob_click(driver);
					Thread.sleep(2000);
					driver.findElement(By.xpath("//*[@class='arrow']")).click();
					Thread.sleep(8000);
					click_element(
							".//*[@id='content']/div[3]/div[2]/div/div[2]/div[1]/div[2]/div/div/div/div[1]/header/ul/li[5]/div/a/span",
							driver);
					Thread.sleep(10000);
					driver.findElement(
							By.xpath("//*[@class='tv-equipment']/form/div[2]/header/ul/li[1]/a"))
							.click();
					statusTracker(br,driver, "", "Expand the Additional boxes section",
							"Clicked", " ");
					Thread.sleep(5000);
					
					driver.findElement(By.xpath(".//*[@id='content']/div[3]/div[2]/div/div[2]/div/div[2]/div/div[2]/div[2]/header/ul/li[2]/h3")).click();
					Thread.sleep(5000);
					
					
					if (driver.findElement(By.xpath("//*[@href='#prem']"))
							.isDisplayed()) {
						statusTracker(br,driver, 
								"Fail",
								"The Premium channel section in the default collapsed state",
								"The Premium channel section is not in the default collapsed state",
								"The Premium channel section should be in the default collapsed state");
					} else {
						statusTracker(br,driver, 
								"Pass",
								"The Premium channel section in the default collapsed state",
								"The Premium channel section is in the default collapsed state",
								"The Premium channel section should be in the default collapsed state");
					}
					click_element(
							"//*[@id='content']/div[3]/div[2]/div/div[2]/div/div[2]/div/div[2]/div[2]/header/ul/li[1]/a",
							driver);
					String prem_channel[] = new String[10];
					List<WebElement> myli_prem_channel = driver.findElements(By
							.xpath("//*[@class='tab-nav']/li"));

					int No_of_prem_channel = myli_prem_channel.size();
					for (int i = 0; i < No_of_prem_channel; i++) {
						prem_channel[i] = driver
								.findElement(
										By.xpath("//*[@id='content']/div[3]/div[2]/div/div[2]/div/div[2]/div/div[2]/div[2]/section/div/div[2]/div/div[1]/ul/li["
												+ (i + 1) + "]/a")).getText();

						statusTracker(br,driver, " ", "cart details", "eqipment name is: "
								+ prem_channel[i] + " and item cost is: "
								+ prem_channel[i],
								"selected eqipment should be added to cart");
						if ((prem_channel[i]).trim().equals("Premiums")
								|| (prem_channel[i]).trim().equals("Sports")
								|| (prem_channel[i]).trim().equals("Variety")
								|| (prem_channel[i]).trim().equals(
										"International")
								|| (prem_channel[i]).trim().equals("Adult")) {
							statusTracker(br,driver, 
									"Pass",
									"Validate the options in the premium channel section section",
									"Present", "Should be present");
						} else {
							statusTracker(br,driver, 
									"Fail",
									"Validate the options in the TV Equipment section",
									"Not Present", "Should be present");
						}
					}
					if (driver.findElement(By.xpath(".//*[@ class='rtf']"))
							.isDisplayed()) {
						statusTracker(br,driver, 
								"Pass",
								"Validate the Premium Channel tab is the default display",
								"Premium Channel tab is the default display",
								"Premium Channel tab should be the default display");
					} else {
						statusTracker(br,driver, 
								"Fail",
								"Validate the Premium Channel tab is the default display",
								"Premium Channel tab is not the default display",
								"Premium Channel tab should be the default display");
					}

					if (driver.findElement(
							By.xpath("//*[@class='prem premium-channels']"))
							.isDisplayed()) {
						if (driver
								.findElement(
										By.xpath("//*[@class='specialPremiums special-premiums']"))
								.isDisplayed()) {
							statusTracker(br,driver, 
									"Pass",
									" Validate If special premium offers are available, the channels pertaining to the available offer(s) will be displayed in their own section",
									"Special Premium Channel Promos should be displayed in their own section right under the channel category tabs",
									"Special Premium Channel Promos are displayed in their own section right under the channel category tabs");
						} else {
							statusTracker(br,driver, 
									"Fail",
									" Validate If special premium offers are available, the channels pertaining to the available offer(s) will be displayed in their own section. ",
									"Special Premium Channel Promos are not displayed in their own section right under the channel category tabs",
									"Special Premium Channel Promos should be displayed in their own section right under the channel category tabs");
						}

						click_element(
								".//*[@id='1-3CEN9-1-2AW3-1']/td[1]/input",
								driver);
						Thread.sleep(5000);

						/*config_page_Cart_result_updater_1(driver);
						Thread.sleep(2000);
						page_Cart_One_Time_charge_updater_1(driver);
						Thread.sleep(5000);*/

						click_element(
								".//*[@id='1-3CEN9-1-2AXB-5']/td[1]/input",
								driver);
						Thread.sleep(5000);

						config_page_Cart_result_updater_1(br,driver);
						Thread.sleep(2000);
						page_Cart_One_Time_charge_updater_1(br,driver);
						Thread.sleep(5000);

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
						
						driver.findElement(By.xpath("//*[@class='arrow']"))
								.click();
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
				}
				driver.quit();
			} catch (Exception e) {
				exceptionHandler(br, e, driver);
				logger.info("RT_TV_021 Error is : " + e.getMessage());
			}
		} catch (Exception e) {
			exceptionHandler(br, e, driver);
		} finally {
			wb.close();
			driver.quit();

		}
	}
}
