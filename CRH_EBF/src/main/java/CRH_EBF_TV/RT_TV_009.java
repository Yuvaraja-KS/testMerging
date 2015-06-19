/* ****************************************************************************************************
File Name: 								RT_TV_009
Author: 								Raveena
Description of test case: 				TV Boxes - User current equipment compatible
Date of creation(D/M/Y): 				03/06/2014
Name and date(D/M/Y) of modification: 	Nithin K.S - 09/06/2014
Modification description: 				Modified to the efficient Xpath, wherever applicable.
Name and date(D/M/Y) of modification: 	RAHUL JADOW - 20/06/2014
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

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.support.ui.Select;
//import org.apache.bcel.generic.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import junit.framework.Test;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;

public class RT_TV_009 extends CommonFunctions {

	String table, tns[];
	String tlimit, username, pwd, ctotal, Uname, Tv_plan, Internet_plan,
			Phone_plan, current_service;
	int tncount;
	String serAddress, Internet_service, Tv_service, Phone_service,
			str_Browser, Tv_equipment;
	String tv_plan_name[];
	String tv_plan_cost[];

	public RT_TV_009() {
	}

	public RT_TV_009(String s) {
		this.path = s;
		logger.info("RT_TV_009...");
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
			Page_Phone = "RT_TV_009_";
			String Sheet_name = sheet2.getName();
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
			Tv_equipment = sheet2.getCell(Col_locator_full_scan_input_sheet("TV EQUIPMENT", path,Sheet_name), loc).getContents();
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

				click_element(
						"//input[@name='upgrade_tv']",
						driver);
				Thread.sleep(2000);
				
						
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
				
				Thread.sleep(2000);
				click_element("//span[contains(text(), 'Continue')]", driver);
				Thread.sleep(4000);

					click_element(
						"//a[contains(text(),'Compare TV Plans')]",
						driver);
				Thread.sleep(9000);

				if (return_text(".//*[@id='select_tv']/div[17]/div[1]", driver)
						.equalsIgnoreCase("Features by TV Plan"))

				{
					
					statusTracker(br,driver, "Pass", "Compare Plans page is opened",
							"Matches", "Compare Plans page should open");
				} else {
					statusTracker(br,driver, "Fail", "Compare Plans page is not opened",
							"does not Match", "Compare Plans page should open");
				}

				click_element(".//*[@class='modal-button-close']",
						driver);// close
	
				Thread.sleep(4000);

				click_element(
						"//*[@id='content']/div[3]/div[2]/div/div[2]/div[1]/div[2]/div/div/div/div[1]/header/ul/li[5]/div/a",
						driver);// select plan
				Thread.sleep(9000);
				statusTracker(br,driver, "Pass", "Compare Plans page is opened",
						"Matches", "Compare Plans page should open");
				
				if (driver
						.findElement(
								By.xpath("//*[@id='content']/div[3]/div[2]/div/div[2]/div/div[2]/div/div[2]/div[1]/section/div/div[4]/form/div[1]/header/ul/li[2]/h3"))
						.isDisplayed()) {
					
					statusTracker(br,driver, "Pass", "Tv Equipment text is present",
							"Matches", "Tv Equipment text should be present");
				}

				else {
					
					statusTracker(br,driver, "Fail", "Tv Equipment text is not  present",
							"does not Match",
							"Tv Equipment text should be present");
				}

				if (driver
						.findElement(
								By.xpath("//*[@class='tv-equip-box']/h4"))
						.getText().equalsIgnoreCase(Tv_equipment))

				{
					
					statusTracker(br,driver, "Pass", "Tv Equipment is  matching!",
							"Matches", "Tv Equipment should match");
				}

				else {
					
					statusTracker(br,driver, "Fail", "Tv Equipment is  matching!",
							"does not Match", "Tv Equipment should match");
				}

				if (driver
						.findElement(
								By.xpath("//*[@id='content']/div[3]/div[2]/div/div[2]/div/div[2]/div/div[2]/div[1]/section/div/div[4]/form/div[2]/header/ul/li[2]/h3"))
						.isDisplayed()) {
					
					statusTracker(br,driver, "Pass",
							"additonal Equipment text is present", "Matches",
							"additonal Equipment text should be present");
				}

				else {
					
					statusTracker(br,driver, "Fail",
							"additonal Equipment text is not  present",
							"does not Match",
							"additonal Equipment text should be present");
				}

				click_element(
						"//*[@id='content']/div[3]/div[2]/div/div[2]/div/div[2]/div/div[2]/div[1]/section/div/div[4]/form/div[2]/header/ul/li[1]/a",
						driver);// drop down
				Thread.sleep(4000);

				if ((driver
						.findElement(
								By.xpath("//*[@id='content']/div[3]/div[2]/div/div[2]/div/div[2]/div/div[2]/div[1]/section/div/div[4]/form/div[2]/section/div/ul/li[1]/h4"))
						.getText().equalsIgnoreCase("HD Box"))
						|| (driver
								.findElement(
										By.xpath("//*[@id='content']/div[3]/div[2]/div/div[2]/div/div[2]/div/div[2]/div[1]/section/div/div[4]/form/div[2]/section/div/ul/li[2]/h4"))
								.getText()
								.equalsIgnoreCase("HD-DVR Box and Service")))

				{
					
					statusTracker(br,driver, "Pass",
							"additonal Equipment boxes is present", "Matches",
							"additonal Equipment boxes should be present");

				} else {
					statusTracker(br,driver, "Fail",
							"additonal Equipment boxes is not present",
							"does not Match",
							"additonal Equipment boxes should be present");
				}

				if (driver
						.findElement(
								By.xpath("//*[@id='content']/div[3]/div[2]/div/div[2]/div/div[2]/div/div[2]/div[1]/section/div/div[4]/form/div[2]/section/div/ul/li[1]/div[3]/div/div/select"))
						.isDisplayed())
					if (driver
							.findElement(
									By.xpath("//*[@id='content']/div[3]/div[2]/div/div[2]/div/div[2]/div/div[2]/div[1]/section/div/div[4]/form/div[2]/section/div/ul/li[1]/div[3]/div/div/div[1]"))
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
				String str = (driver
						.findElement(By
								.xpath("//*[@id='content']/div[3]/div[2]/div/div[2]/div/div[2]/div/div[2]/div[1]/section/div/div[4]/form/div[2]/section/div/ul/li[3]/div/h4"))
						.getText());

				
				if (driver
						.findElement(
								By.xpath("//*[@id='content']/div[3]/div[2]/div/div[2]/div/div[2]/div/div[2]/div[1]/section/div/div[4]/form/div[2]/section/div/ul/li[3]/div/h4"))
						.getText().equalsIgnoreCase(str)) {
					statusTracker(br,driver, "Pass", "  Cable card option found here",
							" Match", "  Cable card option should be there");

				}

				else {
					
					statusTracker(br,driver, "Fail", " No Cable card option found here",
							"does not Match",
							"  Cable card option should be there");

				}

				Thread.sleep(4000);
				click_element(
						"//*[@id='content']/div[3]/div[2]/div/div[2]/div/div[2]/div/div[2]/div[1]/section/div/div[4]/form/div[2]/section/div/ul/li[3]/div/h4/a",
						driver);// drop down

				if (driver
						.findElement(
								By.xpath("//*[@id='content']/div[3]/div[2]/div/div[2]/div/div[2]/div/div[2]/div[1]/section/div/div[4]/form/div[2]/section/div/ul/li[3]/div/div/div[3]/div[2]/select"))
						.isDisplayed())

				{
					
					statusTracker(br,driver, "Pass", "  Select dropdown is present",
							" Match", " Select dropdown is present");
				} else {
					
					statusTracker(br,driver, "Fail", " Select dropdown is  not present",
							"does not Match",
							"  Select dropdown should be present");
				}
				Thread.sleep(4000);
				Select_DropDown(driver, "//*[@data-name='HD Box']", "3");
				Thread.sleep(5000);

						
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
				
				
				//config_page_Cart_result_updater_1(br,driver);

				Thread.sleep(2000);
				
				EBF_Logout(br,driver);

			}// try(inner)

			catch (Exception e) {
				exceptionHandler(br, e, driver);
				logger.info("RT_TV_009 Error is : " + e.getMessage());
			}
		} catch (Exception e) {
			exceptionHandler(br, e, driver);

		} finally {
			wb.close();
			driver.quit();

		}

	}

}
