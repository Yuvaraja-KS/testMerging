/* ****************************************************************************************************
File Name: 								RT_TV_008
Author: 								Raveena
Description of test case: 				Add TV - Validate LOS Selections
Date of creation(D/M/Y): 				03/06/2014
Name and date(D/M/Y) of modification: 	Nithin K.S - 09/06/2014
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

import junit.framework.Test;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;

public class RT_TV_008 extends CommonFunctions {

	// shikha variable added

	String table, tns[];
	String tlimit, username, pwd, ctotal, Uname, Tv_plan, Internet_plan,
			Phone_plan, current_service;
	int tncount;
	String serAddress, Internet_service, Tv_service, Phone_service,
			str_Browser;
	String tv_plan_name[];
	String tv_plan_cost[];

	public RT_TV_008() {
	}

	public RT_TV_008(String s) {
		this.path = s;
		logger.info("RT_TV_008...");
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
			Page_Phone = "RT_TV_008_";
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
			if (first == 0)
				firstrun(br,driver, username, pwd,ctotal, Uname,
						serAddress);

			// Add TV - Validate LOS Selections

			Tv_lob_verify(br,driver);

			click_element("//input[@name='select_tv']", driver);
			Thread.sleep(8000);
			statusTracker(br,driver, "Pass", "Select TV", "TV is selected",
					"Should be selected");
			
				
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
			
			
			click_element("//*[@analyticsname='current services:1:1:continue']", driver);
			Thread.sleep(5000);

			if (driver
					.findElement(
							By.xpath("//*[@class='buyFlowHeader section']/header/div/div[1]/h2"))
					.isDisplayed())
				if (driver
						.findElement(
								By.xpath("//*[@class='checkout-steps show-sub-steps']/ol/li[1]/div/div"))
						.isDisplayed())
					if (driver
							.findElement(
									By.xpath("//*[@class='checkout-steps show-sub-steps']/ol/li[2]/div/div"))
							.isDisplayed())
						if (driver
								.findElement(
										By.xpath("//*[@class='checkout-steps show-sub-steps']/ol/li[3]/div/div"))
								.isDisplayed())
							if (driver
									.findElement(
											By.xpath("//*[@class='checkout-steps show-sub-steps']/ol/li[4]/div/div"))
									.isDisplayed()) {

							}

			Thread.sleep(4000);

			if (driver.findElement(
					By.xpath("//*[@class='sub-steps']/ul/li/span"))
					.isDisplayed()) {

				statusTracker(br,driver, "Pass", "Check for service address", "Matches",
						"Should match");
			}

			// select Compare plans(Ravz) select plan page
/*
			click_element(".//*[@title='Compare TV Plans']", driver);

			Thread.sleep(9000);

			if (return_text("//*[@class='modal-title']", driver)

			.equalsIgnoreCase("Features by TV Plan")) {

				statusTracker(br,driver, "Pass", "Check for service address", "Matches",

				"Should match");

			} else {

				statusTracker(br,driver, "Fail", "Check for service address",

				"does not Match", "Should match");

			}

			Thread.sleep(2000);

			Thread.sleep(2000);

			// Select "Close" on Compare TV Plans link
			click_element(".//*[@class='ajax-modal modal-window']/div[1]/div[2]",driver);
*/
			Thread.sleep(4000);

			// Current Services module is closed and displays price in $
			String CurrSer = driver.findElement(
					By.xpath(".//*[@class='price last']/sup")).getText();
			String strfind = "$";
			int iSuccess = CurrSer.indexOf(strfind);

				if (iSuccess < 0) {

				statusTracker(br,driver, "Fail",
						"$ sign present in current service monthly charges",
						"$ not present", "$ should be present");
			}

			else {

				statusTracker(br,driver, "Pass",
						"$ sign present in current service monthly charges",
						"$ present", "$ should be present");
			}

			int iStartAmount = iSuccess + 1;
			String per = " ";

			int iSpace = CurrSer.indexOf(per);
			int iEndAmount = iSpace - 1;

			String sAmount = CurrSer.substring(1, CurrSer.length());

			if (sAmount.equals(ctotal)) {

				statusTracker(br,driver, 
						"Pass",
						"current service monthly charges should match as per the user",
						"Amount matches", "Amount should match");
			}

			else {

				statusTracker(br,driver, 
						"Fail",
						"current service monthly charges should match as per the user",
						"Amount doesnt match", "Amount should match");
			}

			click_element(".//*[@class='miniCart']/div/header/ul/li[2]/a",
					driver);

			String CurrSer1 = driver
					.findElement(
							By.xpath(".//*[@class='miniCart']/div/section/div[1]/header/ul/li[2]/h6"))
					.getText();
			String CurrSer2 = driver
					.findElement(
							By.xpath(".//*[@class='miniCart']/div/section/div[2]/header/ul/li[2]/h6"))
					.getText();

			if ((CurrSer1.equalsIgnoreCase("Internet")))
				if ((CurrSer2.equalsIgnoreCase("Phone"))) {

					statusTracker(br,driver, 
							"Pass",
							"Current Services Sequence matches TV Internet Phone",
							"Sequence matches", "Sequence should match");
				} else {

					statusTracker(br,driver, 
							"Fail",
							"Current Services Sequence matches TV Internet Phone",
							"Sequence does not match", "Sequence should match");

				}

				
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
			
			// validate information of LOB(Ravz)

			click_element(
					".//*[@class='miniCart']/div/section/div[1]/header/ul/li[2]/h6",
					driver);
			statusTracker(br,driver, 
					"Pass",
					"Current Services Sequence matches TV Internet Phone",
					"Sequence matches", "Sequence should match");
			Thread.sleep(4000);

			String interServ = driver
					.findElement(
							By.xpath(" .//*[@class='miniCart']/div/section/div[1]/section/div/ul/li[1]/strong"))
					.getText();

			click_element(
					".//*[@class='miniCart']/div/section/div[2]/header/ul/li[2]/h6",
					driver);
			Thread.sleep(4000);

			String PhoneServ = driver
					.findElement(
							By.xpath(".//*[@class='miniCart']/div/section/div[2]/section/div/ul/li[1]/strong"))
					.getText();
			if (PhoneServ.compareTo(Phone_service) != 0) {

				statusTracker(br,driver, "Pass", "Phone service is same as sheet",
						"Service matches", "Service should match");
			}

			else {
				statusTracker(br,driver, "Fail", "Phone service is same as sheet",
						"Service does not match", "Service should match");

			}

			click_element(
					".//*[@class='miniCart']/div/section/div[2]/header/ul/li[2]/h6",
					driver);// close dropdown
			Thread.sleep(4000);

			click_element(".//*[@class='miniCart']/div/header/ul/li[2]/a",
					driver);// Collapse Current Services
			Thread.sleep(4000);

			if ((driver.findElement(By
					.xpath("//*[@class='plans']/div[1]/header/ul/li[2]"))
					.isDisplayed())
					|| (driver
							.findElement(By
									.xpath("//*[@class='plans']/div[2]/header/ul/li[2]"))
							.isDisplayed())
					|| (driver
							.findElement(By
									.xpath("//*[@class='plans']/div[3]/header/ul/li[2]"))
							.isDisplayed())
					|| (driver
							.findElement(By
									.xpath("//*[@class='plans']/div[4]/header/ul/li[2]"))
							.isDisplayed())) {

				statusTracker(br,driver, 
						"Pass",
						"All TV Plans Present and in correct order in new TV customer",
						"All TV Plans Present",
						"All TV Plans should be Present");
			}

			else {

				statusTracker(br,driver, 
						"Fail",
						"All TV Plans Present and in correct order in new TV customer",
						"All TV Plans not Present",
						"All TV Plans should be Present");
			}

			List<WebElement> myli = driver.findElements(By
					.xpath(".//*[@class='plans']/div/header"));
			int count1 = myli.size();
			String plan[] = new String[count1];
			String channels[] = new String[count1];
			String cost2[] = new String[count1];
			String cost[] = new String[count1];
			for (int i = 1; i <= count1; i++) {
				plan[i - 1] = driver
						.findElement(
								By.xpath("html/body/section/div[3]/div[2]/div/div[2]/div[1]/div[2]/div/div/div/div["
										+ i + "]/header/ul/li[2]/h3"))
						.getText();
				channels[i - 1] = driver
						.findElement(
								By.xpath("html/body/section/div[3]/div[2]/div/div[2]/div[1]/div[2]/div/div/div/div["
										+ i + "]/header/ul/li[3]/p[1]/a"))
						.getText();
				cost2[i - 1] = driver
						.findElement(
								By.xpath("html/body/section/div[3]/div[2]/div/div[2]/div[1]/div[2]/div/div/div/div["
										+ i + "]/header/ul/li[4]")).getText();
				cost[i - 1] = cost2[i - 1].substring(0,
						cost2[i - 1].length() - 26)
						+ "."
						+ cost2[i - 1].substring(cost2[i - 1].length() - 26);
				statusTracker(br,driver, " ", "Plan name", plan[i - 1], " ");
				statusTracker(br,driver, " ", "channels", channels[i - 1], " ");
				statusTracker(br,driver, " ", "Cost", cost[i - 1], " ");
			}
			Sheet sheet3 = wb.getSheet("TV_Plans");//RT_TV_008
			int totalcount = 0;
			String dummy = "a";
			int ij = 3;
			int cn = 0;
			do {
				logger.info("Dummy :::"+dummy);
				if (dummy != null && dummy.length() > 0) {
					//dummy = sheet3.getCell(0, ij).getContents();
					//logger.info("Dummy 111111:"+dummy);
					//ij++;
					try {
						dummy = sheet3.getCell(4, ij).getContents();
						totalcount++;
						logger.info("Dummy 222211111:"+dummy);
						logger.info("total count::"+totalcount);
						ij++;
					} catch (Exception e) {
						
						cn = 1;
					}
				
					//totalcount++; // no. of columns in sheet
				} else {
					cn = 1;
				}
			} while (cn == 0);
			logger.info("cn  "+cn);
			logger.info("toatal count "+totalcount);
			String plan1[] = new String[totalcount];
			String channels1[] = new String[totalcount];
			String cost1[] = new String[totalcount];

			for (int i = 0; i < totalcount; i++) {
				plan1[i] = sheet3.getCell(4, (i + 3)).getContents();
				channels1[i] = sheet3.getCell(5, (i + 3)).getContents();
				cost1[i] = sheet3.getCell(6, (i + 3)).getContents();

			}

			if (count1 == totalcount) {
				statusTracker(br,driver, 
						"Pass",
						"Verify if the plan options present in the portal is the same as given from the input file",
						"Count in the portal is the same as given",
						"Count should be the same");
				int cover = 0;
				for (int i = 0; i < count1; i++) {

					if (plan[i].equals(plan1[i])
							&& channels[i].equals(channels1[i])
							&& cost[i].equals(cost1[i])) {
						cover = 0;
					} else {
						cover = 1;
						i = count1;
					}
				}
				if (cover == 1)
					statusTracker(br,driver, 
							"Fail",
							"Verify if the plan, the cost is similar to the details given",
							"The plan details are not as expected",
							"The details should be as expected");
				else
					statusTracker(br,driver, 
							"Pass",
							"Verify if the plan, the cost is similar to the details given",
							"The plan details are as expected",
							"The details should be as expected");
			} else
				statusTracker(br,driver, 
						"Fail",
						"Verify if the options present in the portal is the same as given",
						"Count is not proper in the portal: " + count1,
						"Count should be the same");

			// validating channels list opens!
			click_element("//*[@class='plans']/div[1]/header/ul/li[3]/p[1]/a",
					driver);
			Thread.sleep(4000);
			if (return_text("//*[@class='modal-title']", driver)
					.equalsIgnoreCase("Preferred TV Lineup")) {

				{

					statusTracker(br,driver, "Pass", "it opened channels list!!",
							"it opened channels list!!",
							"it should open channels list!!r");
				}
			}

			else {

				statusTracker(br,driver, "Fail", "it opened channels list!!",
						"it didnt open channels list!!",
						"it should open channels list!!r");
			}

			click_element(".//*[@class='modal-button-close']", driver);
			Thread.sleep(4000);

			click_element(".//*[@class='plans']/div[1]/header/ul/li[1]/a",
					driver); // dropdown1
			Thread.sleep(4000);

			click_element(".//*[@class='plans']/div[2]/header/ul/li[1]/a",
					driver); // dropdown2
			Thread.sleep(4000);

			click_element(".//*[@class='plans']/div[3]/header/ul/li[1]/a",
					driver); // dropdown3
			Thread.sleep(4000);

			click_element(".//*[@class='plans']/div[4]/header/ul/li[1]/a",
					driver); // dropdown4
			Thread.sleep(4000);

			click_element(".//*[@class='plans']/div[1]/header/ul/li[3]/p/a",
					driver);

			if (return_text("//div[contains(text(), 'Preferred TV Lineup')]",
					driver).equals("Preferred TV Lineup")) {

				statusTracker(br,driver, "Pass", "Click on 200+ Channel",
						"It Clicked & validated",
						"It should be clicked & validated");
			} else {

				statusTracker(br,driver, "Fail", "Click on 200+ Channel",
						"It Clicked & NOT validated",
						"It should be clicked & validated");
			}

			explicit_Wait(4);

			click_element(".//*[@class='modal-button-close']", driver);

			explicit_Wait(4);

			// validate customization page
			click_element(".//*[@class='plans']/div[1]/header/ul/li[5]/div/a",
					driver); // select

			explicit_Wait(10);

			if (driver.findElement(By.xpath(".//*[@id='content']/div[3]/div[1]/div/header/div/div[1]/h2"))
					.getText().equalsIgnoreCase("Customize Your TV Plan")) {

				statusTracker(br,driver, "Pass", "It opens tv customization page!!",
						"its navigating to tv customization page!!",
						"it should navigate to tv customization page!!");
			} else {

				statusTracker(br,driver, "Fail", "It opens tv customization page!!",
						"its NOT navigating to tv customization page!!",
						"it should navigate to tv customization page!!");
			}

			EBF_Logout(br,driver);
		}

		catch (Exception e) {
			exceptionHandler(br, e, driver);

		} finally {
			wb.close();
			driver.quit();
		}
	}
}
