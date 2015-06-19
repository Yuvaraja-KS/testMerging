/* ****************************************************************************************************
File Name: 								RT_TV_007
Author: 								Pradeep
Description of test case: 				Upgrade TV - Validate LOS selections
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

public class RT_TV_007 extends CommonFunctions {

	String table, tns[];
	String tlimit, username, pwd, ctotal, Uname, Tv_plan, Internet_plan,
			Phone_plan, current_service;
	int tncount;
	String serAddress, Internet_service, Tv_service, Phone_service,
			str_Browser;
	String tv_plan_name[];
	String tv_plan_cost[];

	public RT_TV_007() {
	}

	public RT_TV_007(String s) {
		this.path = s;
		logger.info("RT_TV_007...");
	}

	public void execute(String br,WebDriver driver, String url, int loc) throws Exception {
		Page_Phone = "RT_TV_007_";
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

			// If TV is active on the account, select "Upgrade Your Plan"
			click_element("//input[@name='upgrade_tv']", driver);
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
			
			if ((driver.findElement(By
					.xpath("//span[contains(text(), 'Continue')]")).isEnabled()))
			// *[@id='js-main-form']/nav/a
			{

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

			// Select Continue Button so that User navigates to the TV Select a
			// Plan page.
			click_element(".//*[@id='js-main-form']/nav/a/span", driver);
			statusTracker(br,driver, "Pass", "clck on Continue button",
					"'Continue button is clicked",
					"should click continue button");
			Thread.sleep(6000);

			// Validating if user has navigated to TV Select a plan page
			if (return_text(".//*[@class='left']", driver).trim().equals(
					"Choose Your TV Plan"))
				statusTracker(br,driver, "Pass", "Click the Continue Button",
						"User is navigated to the TV Configuration page",
						"User should navigate to the TV Configuration page.");
			else
				statusTracker(br,driver, "Fail", "Click the Continue Button",
						"User is NOT navigated to the TV Configuration page",
						"User should navigate to the TV Configuration page.");

			// Validating if Secondary progress bar should display TV and should
			// be highlighted
			if (return_text(".//*[@class='active']/span", driver).trim()
					.equals("TV"))
				statusTracker(br,driver, 
						"Pass",
						"Validate the secondary progress bar",
						"Secondary progress bar displays TV and will be highlighted",
						"Secondary progress bar should display TV and should be highlighted.");
			else
				statusTracker(br,driver, 
						"Fail",
						"Validate the secondary progress bar",
						"Secondary progress bar will not display TV and will not be highlighted",
						"Secondary progress bar displays TV and will be highlighted");

			// Select "Compare TV Plans" link
			click_element(".//*[@title='Compare TV Plans']", driver);
			Thread.sleep(9000);

			if (return_text("//*[@class='modal-title']", driver)
					.equalsIgnoreCase("Features by TV Plan"))

			{

				statusTracker(br,driver, "Pass", "Compare Plans page is opened",
						"Matches", "Compare Plans page should open");
			} else {
				statusTracker(br,driver, "Fail", "Compare Plans page is not opened",
						"does not Match", "Compare Plans page should open");
			}

			// Select "Close" on Compare TV Plans link
			click_element(
					".//*[@class='ajax-modal modal-window']/div[1]/div[2]",
					driver);
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

			// validating sequence of LOB under current services
			String CurrSer1 = driver
					.findElement(
							By.xpath(".//*[@class='miniCart']/div/section/div[1]/header/ul/li[2]/h6"))
					.getText();
			String CurrSer2 = driver
					.findElement(
							By.xpath(".//*[@class='miniCart']/div/section/div[2]/header/ul/li[2]/h6"))
					.getText();

			if ((CurrSer1.equalsIgnoreCase("TV")))
				if ((CurrSer2.equalsIgnoreCase("Internet"))) {

					statusTracker(br,driver, "Pass",
							"current sequence matches TV Internet Phone",
							"Sequence matches", "Sequence should match");
				} else {

					statusTracker(br,driver, "Fail",
							"current sequence matches TV Internet Phone",
							"Sequence does not match", "Sequence should match");

				}

			// validate information of LOB

			click_element(
					".//*[@class='miniCart']/div/section/div[1]/header/ul/li[2]/h6",
					driver);
			Thread.sleep(4000);

			String TVServ = driver
					.findElement(
							By.xpath(".//*[@class='miniCart']/div/section/div[1]/section/div/ul/li[1]"))
					.getText();
			if (TVServ.compareTo(Tv_service) != 0) {

				statusTracker(br,driver, "Pass", "TV service is same as sheet",
						"Service matches", "Service should match");
			}

			else {
				statusTracker(br,driver, "Fail", "TV service is same as sheet",
						"Service does not match", "Service should match");

			}

			click_element(
					".//*[@class='miniCart']/div/section/div[1]/header/ul/li[2]/h6",
					driver);
			Thread.sleep(4000);
			click_element(
					".//*[@class='miniCart']/div/section/div[2]/header/ul/li[2]/h6",
					driver);
			Thread.sleep(4000);

			String InternetServ = driver
					.findElement(
							By.xpath(".//*[@class='miniCart']/div/section/div[2]/section/div/ul/li[1]/strong"))
					.getText();
			if (InternetServ.compareTo(Internet_service) != 0) {

				statusTracker(br,driver, "Pass", "Internet service is same as sheet",
						"Service matches", "Service should match");
			}

			else {
				statusTracker(br,driver, "Fail", "Internet service is same as sheet",
						"Service does not match", "Service should match");

			}

			click_element(
					".//*[@class='miniCart']/div/section/div[2]/header/ul/li[2]/h6",
					driver);// close dropdown
			Thread.sleep(4000);

			// Verify that all TV plans available in the market display for the

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
							.isDisplayed()))

			{

				statusTracker(br,driver, 
						"Pass",
						"All TV Plans Present and in correct order in new TV customer",
						"All TV Plans Present",
						"All TV Plans should be Present");

			} else {

				statusTracker(br,driver, 
						"Fail",
						"All TV Plans Present and in correct order in new TV customer",
						"All TV Plans not Present",
						"All TV Plans should be Present");
			}
			// end of if

			// validate name, price and time of tv packages

			List<WebElement> myli = driver.findElements(By
					.xpath("//*[@class='plans']/div/header"));
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
						+ cost2[i - 1].substring(3, cost2[i - 1].length() - 24);
				statusTracker(br,driver, " ", "Plan name", plan[i - 1], " ");

				statusTracker(br,driver, " ", "channels", channels[i - 1], " ");

				statusTracker(br,driver, " ", "Cost", cost[i - 1], " ");
			}
			Sheet sheet3 = wb.getSheet("TV_Plans");//RT_TV_007
			int totalcount = 0;
			String dummy = "a";
			int ij = 3;
			int cn = 0;
			do {
				if (dummy != null && dummy.length() > 0) {
					dummy = sheet3.getCell(0, ij).getContents();
					ij++;
					try {
						dummy = sheet3.getCell(0, ij).getContents();
					} catch (Exception e) {
						cn = 1;
					}
					totalcount++; // no. of columns in sheet
				} else {
					cn = 1;
				}

			} while (cn == 0);

			String plan1[] = new String[totalcount];
			String channels1[] = new String[totalcount];
			String cost1[] = new String[totalcount];

			for (int i = 0; i < totalcount; i++) {
				plan1[i] = sheet3.getCell(0, (i + 3)).getContents();
				channels1[i] = sheet3.getCell(1, (i + 3)).getContents();
				cost1[i] = sheet3.getCell(2, (i + 3)).getContents();
				cost1[i] = cost1[i].substring(0, 6);

			}

			if (count1 == totalcount) {
				statusTracker(br,driver, 
						"Pass",
						"Verify if the plan options present in the portal is the same as given from the input file",
						"Count in the portal is the same as given",
						"Count should be the same");
				int cover = 0;
				for (int i = 0; i < count1; i++) {

					if (plan[i].trim().equals(plan1[i].trim())
							&& channels[i].trim().equals(channels1[i].trim())
							&& cost[i].trim().equals(cost1[i].trim())) {
						cover = 0;
					} else {
						cover = 1;
						i = count1;
					}
				}
				if (cover != 1)
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
					driver);
			Thread.sleep(4000);

			click_element(".//*[@class='plans']/div[2]/header/ul/li[1]/a",
					driver);
			Thread.sleep(4000);

			click_element(".//*[@class='plans']/div[3]/header/ul/li[1]/a",
					driver);
			Thread.sleep(4000);

			click_element(".//*[@class='plans']/div[4]/header/ul/li[1]/a",
					driver);
			Thread.sleep(4000);

			click_element(
					".//*[@class='plans']/div[1]/header/ul/li[5]/div/a/span",
					driver);
			Thread.sleep(8000);

			if (driver.findElement(By.xpath(".//*[@class='left']")).getText()
					.equalsIgnoreCase("Customize Your TV Plan")) {

				statusTracker(br,driver, "Pass", "it opens tv customization page!!",
						"it opens tv customization page!!",
						"it should open tv customization page!!r");

			} else {

				statusTracker(br,driver, "Fail",
						"it does not open tv customization page!!",
						"it opens tv customization page!!",
						"it should open tv customization page!!r");
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