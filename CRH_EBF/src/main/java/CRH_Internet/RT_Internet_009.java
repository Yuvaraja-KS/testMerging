
//File Name: RT_Internet_009
//Author: PRADEEP   
//Description of test case: Add Internet LOS Selection
//Date of creation(D/M/Y): 3/19/2014
//Name and date(D/M/Y) of modification: RAHUL JADOW (6/6/2014)
//Modification description: Close Mini cart Within Current Services, select close button on LOB(s)


package CRH_Internet;

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
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;

public class RT_Internet_009 extends CommonFunctions {

	String table, tns[];
	String tlimit, username, pwd, ctotal, Uname, Tv_plan, Internet_plan,
			Phone_plan, current_service, env;
	int tncount;
	String serAddress, Internet_service, Tv_service, Phone_service;

	public RT_Internet_009() {
	}

	public RT_Internet_009(String s) {
		this.path = s;
		logger.info("Add Internet 009 is intialized");
	}

	public boolean Isavailable(String fxp, WebDriver driver) {
		boolean xy = true;
		try {
			if (driver.findElement(By.xpath(fxp)) != null) {
				logger.info("gone inside");
				logger.info("{}",true);
				xy = true;
			}
		} catch (Exception e) {
			logger.info(e.getMessage());
			logger.info("{}",false);
			xy = false;
		}
		return xy;
	}

	public void execute(String br, WebDriver driver, String url, int loc) throws Exception {
		int screen_count = 1;
		File data = new File(this.path);
		WorkbookSettings ws = new WorkbookSettings();
		ws.setLocale(new Locale("er", "ER"));
		//arrcount = 0;
		logger.info("chheck1");
		Workbook wb = Workbook.getWorkbook(data, ws);

		try {
			String tv = "", inet = "", phone = "";
			Sheet sheet2 = wb.getSheet("Internet");
			String Sheet_name = sheet2.getName();
			tlimit = sheet2.getCell(6, loc).getContents();
			username = sheet2.getCell(Col_locator_full_scan_input_sheet("USERNAME", path,Sheet_name), loc).getContents();
			pwd = sheet2.getCell(Col_locator_full_scan_input_sheet("PASSWORD", path,Sheet_name), loc).getContents();
			ctotal = sheet2.getCell(Col_locator_full_scan_input_sheet("C-TOTAL", path,Sheet_name), loc).getContents();
			Uname = sheet2.getCell(Col_locator_full_scan_input_sheet("ACCOUNT NAME", path,Sheet_name), loc).getContents();
			serAddress = sheet2.getCell(11, loc).getContents();
			Tv_service = sheet2.getCell(Col_locator_full_scan_input_sheet("TV SERVICE", path,Sheet_name), loc).getContents();
			Internet_service = sheet2.getCell(Col_locator_full_scan_input_sheet("INTERNET SERVICE", path,Sheet_name), loc).getContents();
			Phone_service = sheet2.getCell(Col_locator_full_scan_input_sheet("PHONE SERVICE", path,Sheet_name), loc).getContents();
			Tv_plan = sheet2.getCell(Col_locator_full_scan_input_sheet("TV PLAN", path,Sheet_name), loc).getContents();
			Internet_plan = sheet2.getCell(Col_locator_full_scan_input_sheet("INTERNET PLAN", path,Sheet_name), loc).getContents();
			Phone_plan = sheet2.getCell(Col_locator_full_scan_input_sheet("PHONE PLAN", path,Sheet_name), loc).getContents();
			Page_Phone = "RT_Internet_009_";

			/*int tv1 = 0, inet1 = 0, phone1 = 0;
			int val = 1;
			int tlim = Integer.parseInt(tlimit);
			tlim *= 60;
			tlimit = Integer.toString(tlim);
			tlimit = tlimit + "000";*/

			if (first == 0) {
				logger.info("trying to open the url");
				driver.manage().window().maximize();
				driver.get(url);
				logger.info("Chek if url opened");
			}

			try {
				if (first == 0)
					firstrun(br, driver, username, pwd,ctotal, Uname,
							serAddress);

				// If Internet is not active on the account, select to add
				// Internet
				Internet_lob_verify(br, driver);
				Thread.sleep(2000);
				
				
				click_element(".//*[@value='select_inet']", driver);
				Thread.sleep(2000);
				
				//to take screenshot and save in file
				try{
		               if (isElementPresent(".//*[contains(text(),'No thanks')]/div",driver))
		                      {
		                         //JS closing Feedback
		                         logger.info("Closing feedback Pop-up");
		                         click_element(".//*[contains(text(),'No thanks')]/div)",driver);
		                                             Thread.sleep(20000);
		                 }   else
		                         logger.info("No Feedback Pop-ups found");
		               
		                  
		                  if (isElementPresent(".//*[contains(@id,'lpInviteLayer')]/div",driver))
		                  {
		                         //JS closing chat box
		                         logger.info("Closing chat Pop-up");
		                         click_element(".//*[contains(@id,'lpInviteLayer')]/div/a[2]/img",driver);
		                         Thread.sleep(20000);
		                  }      else
		                         logger.info("No chat Pop-ups found");
		               } catch (Exception e) {
		                         exceptionHandler(br, e, driver);
		               }
				File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				File targetFile = new File(spath +"//Test_Results//NewImages//"+ Page_Phone + screen_count + ".png");
				FileUtils.copyFile(screenshot, targetFile);		
				logger.info("copied file into New Images folder"+targetFile);
				
			
				if(url.contains("beta"))
                    
                {
                env = "Beta";
                Image_compare(br,env,Page_Phone,spath,screen_count,driver);
                //Image_compare(br,driver, spath+"//Test_Results//StandardImages_Beta//RT_Internet_EBF//RT_Internet_EBF_012_1.png",spath+"//Test_Results//NewImage//RT_Internet_EBF_012_1.png");
               Thread.sleep(5000);
               logger.info("Beta Environment");
               }
               else
               {
            	env = "Prod" ;
                Image_compare(br,env,Page_Phone,spath,screen_count,driver);   
               //Image_compare(br,driver, spath+"//Test_Results//StandardImages_Prod//RT_Internet_EBF//RT_Internet_EBF_012_1.png",spath+"//Test_Results//NewImage//RT_Internet_EBF_012_1.png");
               Thread.sleep(5000);
               logger.info("Prod Environment");
               
               }
				screen_count++;
				
				((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1200)");
				Thread.sleep(6000);		
				logger.info("Aashish isEnabled"+Isavailable(".//*[@id='js-main-form']/nav/a",driver));
				
				
					if (Isavailable(".//*[@id='js-main-form']/nav/a",driver)) {
					logger.info("pass1");
					statusTracker(br,driver, 
							"Pass",
							"For Internet is not active on the account, select to add Internet",
							"check box is selected",
							"check box should be selected");
				} else {
					logger.info("fail1");
					statusTracker(br,driver, 
							"Fail",
							"For Internet is not active on the account, select to add Internet",
							"check box is not selected",
							"check box should be selected");
				}
				
				
				// Select Continue Button so that User navigated to the Internet
				// Configuration page
				click_element("//*[@id='js-main-form']/nav/a/span", driver);
				statusTracker(br,driver, "Pass", "clck on Continue button",
						"'Continue button is clicked",
						"should click continue button");
				Thread.sleep(8000);

				// Validate User is directed to "Select a Plan" Internet page
				if (return_text(".//*[@class='left']", driver).trim().equals(
						"Choose Your Internet Plan"))
					statusTracker(br,driver, "Pass", "Click the Continue Button",
							"User is directed to Select a Plan Internet page",
							"User should be directed to Select a Plan Internet page");
				else
					statusTracker(br,driver, 
							"Fail",
							"Click the Continue Button",
							"User is not directed to Select a Plan Internet page",
							"User should be directed to Select a Plan Internet page");


	//**************************************************************************************************			
		//	Commented Nimy/Aashish
				
				/*// Select "Compare Internet Plans" link
				click_element(".//*[@title='Compare Internet Plans']", driver);
				Thread.sleep(9000);

				if (return_text(".//*[@class='modal-title-wrapper']", driver)
						.equalsIgnoreCase("Internet Plans at a Glance"))

				{
					logger.info(" Compare Plans page is opened!!");
					statusTracker(br,driver, "Pass", "Compare Plans page is opened",
							"Matches", "Compare Plans page should open");
				} else {
					statusTracker(br,driver, "Fail", "Compare Plans page is not opened",
							"does not Match", "Compare Plans page should open");
				}

				// Select "Close" on Compare TV Plans link
				click_element(".//*[@class='modal-button-close']", driver);
				Thread.sleep(4000);*/
	//**************************************************************************************************			
				// Verify the current services module is closed, showing only the monthly total
				String CurrSer1 = driver
						.findElement(
								By.xpath(".//*[@class='text parbase currentCartHeader twc-plain-text']"))
						.getText();
				String CurrSer2 = driver
						.findElement(
								By.xpath(".//*[@class='text parbase twc-plain-text monthlyTotalHeader']"))
						.getText();
				String CurrSer3 = driver.findElement(
						By.xpath(".//*[@class='price last']/sup")).getText();
				if ((CurrSer1.equalsIgnoreCase("Current Services")))
					if ((CurrSer2.equalsIgnoreCase("Monthly Total")))
						if ((CurrSer3.equalsIgnoreCase("$38.75")))

						{
							System.out
									.println(" current services module is closed showing only the monthly total");
							statusTracker(br,driver, 
									"Pass",
									"current services module is closed showing only the monthly total",
									"current services module is showing only the monthly total",
									"current services module should show only the monthly total");
						} else {
							System.out
									.println("current services module is not closed, & not showing only the monthly total !!");
							statusTracker(br,driver, 
									"Fail",
									"current services module is closed showing only the monthly total",
									"current services module is not showing only the monthly total",
									"current services module should show only the monthly total");
						}
				Thread.sleep(4000);

				// Verify that the monthly total is the correct monthly total on
				// the account
				String CurrSer = driver.findElement(
						By.xpath(".//*[@class='price last']/sup")).getText();
				logger.info("price is");
				logger.info(CurrSer);
				logger.info("Testing............................01");
				String strfind = "$";
				int iSuccess = CurrSer.indexOf(strfind);
				logger.info("{}",iSuccess);

				if (iSuccess < 0) {
					logger.info("price is not present");
					statusTracker(br,driver, 
							"Fail",
							"$ sign present in current service monthly charges",
							"$ not present", "$ should be present");
				}

				else {
					logger.info("$ present");
					statusTracker(br,driver, 
							"Pass",
							"$ sign present in current service monthly charges",
							"$ present", "$ should be present");
				}

				int iStartAmount = iSuccess + 1;
				String per = " ";

				int iSpace = CurrSer.indexOf(per);
				int iEndAmount = iSpace - 1;
				logger.info("{}",iSpace);

				String sAmount = CurrSer.substring(1, CurrSer.length());
				logger.info("s amount" + sAmount);

				if (sAmount.equals(ctotal)) {
					logger.info("Pass");
					statusTracker(br,driver, 
							"Pass",
							"current service monthly charges should match as per the user",
							"Amount matches", "Amount should match");
				}

				else {
					logger.info("Fail");
					statusTracker(br,driver, 
							"Fail",
							"current service monthly charges should match as per the user",
							"Amount doesnt match", "Amount should match");
				}
				logger.info(" price read!");

				// Select the Current Services expand arrow
				click_element(".//*[@class='miniCart']/div/header/ul/li[2]/a",
						driver);
				Thread.sleep(4000);

				// Verify LOBs on the account are displayed in the correct order
				// under current service
				scrollToElement(".//*[@class='miniCart']/div/section/div[1]/header/ul/li[2]/h6",driver);
				String CurrSer4 = driver
						.findElement(
								By.xpath(".//*[@class='miniCart']/div/section/div[1]/header/ul/li[2]/h6"))
						.getText();
			//	String CurrSer5 = driver.findElement(By.xpath(".//*[@class='miniCart']/div/section/div[2]/header/ul/li[2]/h6")).getText();

			if ((CurrSer4.equalsIgnoreCase("TV")))
				//	if ((CurrSer5.equalsIgnoreCase("Phone")))

					{
						System.out
								.println(" LOBs on the account are displayed in the correct order under current service");
						statusTracker(br,driver, 
								"Pass",
								"LOBs on the account are displayed in the correct order under current service",
								"LOBs on the account is displayed in the correct order under current service",
								"LOBs on the account should be displayed in the correct order under current service");
					} else {
						System.out
								.println("LOBs on the account are  not displayed in the correct order under current service");
						statusTracker(br,driver, 
								"Fail",
								"LOBs on the account are displayed in the correct order under current service",
								"LOBs on the account is not displayed in the correct order under current service",
								"LOBs on the account should be displayed in the correct order under current service");

					}

				// Within Current Services, select expand button on LOB(s)
				click_element(
						".//*[@class='miniCart']/div/section/div[1]/header/ul/li[2]/h6",
						driver);
				Thread.sleep(4000);
			//	click_element(".//*[@class='miniCart']/div/section/div[2]/header/ul/li[2]/h6",driver);
			//	Thread.sleep(4000);

				// Within Current Services, validate the equipment Information
				String CurrSer6 = driver
						.findElement(
								By.xpath(".//*[@class='miniCart']/div/section/div[1]/header/ul/li[2]/h6"))
						.getText();
				String CurrSer7 = driver
						.findElement(
								By.xpath(".//*[@class='miniCart']/div/section/div[1]/section/div/ul/li[1]"))
						.getText();
				
				if ((CurrSer6.equalsIgnoreCase("TV")))
					if ((CurrSer7.equalsIgnoreCase("Starter TV")))
						

						{
							System.out
									.println(" validate the equipment Information");
							statusTracker(br,driver, 
									"Pass",
									"validate the equipment Information",
									"The equipment information displayed is matching the equipments on the test account",
									"The equipment information displayed should match the equipments on the test account");
						} else {
							System.out
									.println("Error-validate the equipment Information");
							statusTracker(br,driver, 
									"Fail",
									"validate the equipment Information",
									"The equipment information displayed is not matching the equipments on the test account",
									"The equipment information displayed should match the equipments on the test account");

						}
	/*		String CurrSer8 = driver
						.findElement(
								By.xpath(".//*[@class='miniCart']/div[1]/section/div[2]/header/ul/li[1]/a"))
						.getText();
						
				String CurrSer9 = driver
						.findElement(
								By.xpath(".//*[@class='miniCart']/div[1]/section/div[2]/section/div/ul/li[1]/strong"))
						.getText();
*/
				if ((CurrSer6.equalsIgnoreCase("Phone")))
					if ((CurrSer7.equalsIgnoreCase("Home Phone State")))
						

						{
							System.out
									.println(" validate the equipment Information");
							statusTracker(br,driver, 
									"Pass",
									"validate the equipment Information",
									"The equipment information displayed is matching the equipments on the test account",
									"The equipment information displayed should match the equipments on the test account");
						} else {
							System.out
									.println("Error-validate the equipment Information");
							statusTracker(br,driver, 
									"Fail",
									"validate the equipment Information",
									"The equipment information displayed is not matching the equipments on the test account",
									"The equipment information displayed should match the equipments on the test account");

						}
		//Close Mini cart	
				
				// Within Current Services, select close button on LOB(s)
				click_element(
						".//*[@class='miniCart']/div/section/div[1]/header/ul/li[2]/h6",
						driver);

				if (url.equalsIgnoreCase("https://www.timewarnercable.com/residential/order	"))
				{
				click_element(
						".//*[@class='miniCart']/div[1]/section/div[2]/header/ul/li[1]/a",
						driver);
				}
			//	click_element(".//*[@class='miniCart']/div/section/div[2]/header/ul/li[2]/h6",driver);
				click_element(
						".//*[@class='text parbase currentCartHeader twc-plain-text']",
						driver);
				statusTracker(br,driver, 
						"Pass",
						"Closed Mini cart Within Current Services, selected close button on LOB(s)",
						"Closed Mini cart Within Current Services, selected close button on LOB(s)",
						"Should Close Mini cart Within Current Services, select close button on LOB(s)");
				Thread.sleep(2000);
					


				// Verify that plan(s) name, speed in Mbps, price, and duration
				// on the plan upgrade page are correct
				int count1 = return_size(".//*[@class='plans']/div", driver);
				logger.info("count" + count1);
				statusTracker(br,driver, "", "Plans Present", "", "");
				String plan[] = new String[count1];
				String speed[] = new String[count1];
				String cost[] = new String[count1];
				for (int i = 1; i <= count1; i++) {
					plan[i - 1] = return_text(
							"html/body/section/div[3]/div[2]/div/div[2]/div[1]/div[2]/div/div/div/div["
									+ i + "]/header/ul/li[2]", driver);
					speed[i - 1] = return_text(
							"html/body/section/div[3]/div[2]/div/div[2]/div[1]/div[2]/div/div/div/div["
									+ i + "]/header/ul/li[3]", driver);
					cost[i - 1] = return_text(
							"html/body/section/div[3]/div[2]/div/div[2]/div[1]/div[2]/div/div/div/div["
									+ i + "]/header/ul/li[4]", driver);

					logger.info("Plan name "
							+ return_text(
									"html/body/section/div[3]/div[2]/div/div[2]/div[1]/div[2]/div/div/div/div["
											+ i + "]/header/ul/li[2]", driver));
					statusTracker(br,driver, 
							"Pass",
							"Plan name",
							return_text(
									"html/body/section/div[3]/div[2]/div/div[2]/div[1]/div[2]/div/div/div/div["
											+ i + "]/header/ul/li[2]", driver),
							"Plan name should be diaplayed");
					logger.info("Speed "
							+ return_text(
									"html/body/section/div[3]/div[2]/div/div[2]/div[1]/div[2]/div/div/div/div["
											+ i + "]/header/ul/li[3]", driver));
					statusTracker(br,driver, 
							"Pass",
							"Speed",
							return_text(
									"html/body/section/div[3]/div[2]/div/div[2]/div[1]/div[2]/div/div/div/div["
											+ i + "]/header/ul/li[3]", driver),
							"Speed should be diaplayed");
					logger.info("Cost "
							+ return_text(
									"html/body/section/div[3]/div[2]/div/div[2]/div[1]/div[2]/div/div/div/div["
											+ i + "]/header/ul/li[4]", driver));
					statusTracker(br,driver, 
							"Pass",
							"Cost",
							return_text(
									"html/body/section/div[3]/div[2]/div/div[2]/div[1]/div[2]/div/div/div/div["
											+ i + "]/header/ul/li[4]", driver),
							"Cost should be diaplayed");
				}

				Sheet sheet3 = wb.getSheet("Internet_Plans");//RT_Internet_009
				int totalcount = 0;
				String dummy = "a";
				int ij = 3;
				int cn = 0;
				do {
					if (dummy != null && dummy.length() > 0) {
						dummy = sheet3.getCell(10, ij).getContents();
						ij++;
						try {
							dummy = sheet3.getCell(10, ij).getContents();
						} catch (Exception e) {
							cn = 1;
						}
						totalcount++;
					} else {
						cn = 1;
					}
				} while (cn == 0);

				String plan1[] = new String[totalcount];
				String speed1[] = new String[totalcount];
				String cost1[] = new String[totalcount];
				logger.info("mf" + totalcount);
				for (int i = 0; i < totalcount; i++) {
					plan1[i] = sheet3.getCell(10, (i + 3)).getContents();
					speed1[i] = sheet3.getCell(11, (i + 3)).getContents();
					cost1[i] = sheet3.getCell(12, (i + 3)).getContents();
					logger.info("Plan "
							+ sheet3.getCell(10, (i + 3)).getContents());
					logger.info("Speed "
							+ sheet3.getCell(11, (i + 3)).getContents());
					logger.info("Cost "
							+ sheet3.getCell(12, (i + 3)).getContents());
				}

				for (int i = 1; i <= count1; i++) {
					speed[i - 1] = speed[i - 1].replaceAll("[^\\d]", "");
					speed[i - 1] = speed[i - 1] + "Mbps";
					logger.info(speed[i - 1]);

					cost[i - 1] = cost[i - 1].substring(0, 15);
					cost[i - 1] = cost[i - 1].replaceAll("[^\\d]", "");
					cost[i - 1] = cost[i - 1].substring(0,
							cost[i - 1].length() - 2)
							+ "."
							+ cost[i - 1].substring(cost[i - 1].length() - 2);
					logger.info(cost[i - 1]);
				}
				logger.info("count countina " + count1 + totalcount);
				if (count1 == totalcount) {
					statusTracker(br,driver, 
							"Pass",
							"Verify if the plan options present in the portal is the same as given from the input file",
							"Count in the portal is the same as given",
							"Count should be the same");
					int cover = 0;
					for (int i = 0; i < count1; i++) {
						logger.info(plan[i] + plan1[i] + speed[i]
								+ speed1[i] + cost[i] + cost1[i]);

						if (plan[i].equals(plan1[i])
								&& speed[i].equals(speed1[i])
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
								"Verify if the plan, speed and the cost is similar to the details given",
								"The plan details are not as expected",
								"The details should be as expected");
					else
						statusTracker(br,driver, 
								"Pass",
								"Verify if the plan, speed and the cost is similar to the details given",
								"The plan details are as expected",
								"The details should be as expected");
				} else
					statusTracker(br,driver, 
							"Fail",
							"Verify if the options present in the portal is the same as given",
							"Count is not proper in the portal: " + count1,
							"Count should be the same");

				// Select the expand arrow within each plan
				click_element(".//*[@class='plans']/div[1]/header/ul/li[1]/a",
						driver);
				Thread.sleep(6000);

				
				
				
				if (return_text(
						".//*[@class='plans']/div[1]/section/div/div[2]/div/p[2]",
						driver).equalsIgnoreCase("Here’s what you get:"))
					
				{
					logger.info(" Additional content Displayed!!");
					statusTracker(br,driver, "Pass", "Additional content Displayed",
							"Matches", "Additional content should be Displayed");
				} else {
					statusTracker(br,driver, "Fail", "Additional content Displayed",
							"does not Match",
							"Additional content should be Displayed");

				}
				// Close
				click_element(".//*[@class='plans']/div[1]/header/ul/li[1]/a",
						driver);
				Thread.sleep(4000);

				// Expand
				click_element(".//*[@class='plans']/div[2]/header/ul/li[1]/a",
						driver);
				Thread.sleep(9000);
				if (return_text(
						".//*[@class='plans']/div[2]/section/div/div[2]/div/p[2]",
						driver).equalsIgnoreCase("Here’s what you get:"))
					
				{
					logger.info(" Additional content Displayed!!");
					statusTracker(br,driver, "Pass", "Additional content Displayed",
							"Matches", "Additional content should be Displayed");
				} else {
					statusTracker(br,driver, "Fail", "Additional content Displayed",
							"does not Match",
							"Additional content should be Displayed");

				}
				// Close
				click_element(".//*[@class='plans']/div[2]/header/ul/li[1]/a",
						driver);
				Thread.sleep(4000);

				// Expand
				click_element(".//*[@class='plans']/div[3]/header/ul/li[1]/a",
						driver);
				Thread.sleep(9000);

				
				String a = return_text(
						".//*[@class='plans']/div[3]/section/div/div[2]/div/p[2]",
						driver);
				System.out.println("AS CHeck" +a);
				
				 
				
				if (return_text(
						".//*[@class='plans']/div[3]/section/div/div[2]/div/p[2]",
						driver).equalsIgnoreCase("Here's what you get:"))

				{
					logger.info(" Additional content Displayed!!");
					statusTracker(br,driver, "Pass", "AAAAAdditional content Displayed",
							"Matches", "Additional content should be Displayed");
				} else {
					statusTracker(br,driver, "Fail", "AAAAAdditional content Displayed",
							"does not Match",
							"Additional content should be Displayed");

				}
				// Close
				click_element(".//*[@class='plans']/div[3]/header/ul/li[1]/a",
						driver);
				Thread.sleep(4000);

				// Expand
				click_element(".//*[@class='plans']/div[4]/header/ul/li[1]/a",
						driver);
				Thread.sleep(9000);
				if (return_text(
						".//*[@class='plans']/div[4]/section/div/div[2]/div/p[2]",
						driver).equalsIgnoreCase("Here’s what you get:"))

				{
					logger.info(" Additional content Displayed!!");
					statusTracker(br,driver, "Pass", "Additional content Displayed",
							"Matches", "Additional content should be Displayed");
				} else {
					statusTracker(br,driver, "Fail", "Additional content  Displayed",
							"does not Match",
							"Additional content should be Displayed");

				}
				// Close
				click_element(".//*[@class='plans']/div[4]/header/ul/li[1]/a",
						driver);
				Thread.sleep(4000);

				// Expand
				/*click_element(".//*[@class='plans']/div[5]/header/ul/li[1]/a",
						driver);
				Thread.sleep(9000);
				if (return_text(
						".//*[@class='plans']/div[5]/section/div/div[2]/div/p[2]",
						driver).equalsIgnoreCase("Here's what you get:"))

				{
					logger.info(" Additional content Displayed!!");
					statusTracker(br,driver, "Pass", "Additional content Displayed",
							"Matches", "Additional content should be Displayed");
				} else {
					statusTracker(br,driver, "Fail", "Additional content Displayed",
							"does not Match",
							"Additional content should be Displayed");

				}
				// Close
				click_element(".//*[@class='plans']/div[5]/header/ul/li[1]/a",
						driver);*/
				Thread.sleep(4000);

				// Expand
				/*click_element(".//*[@class='plans']/div[6]/header/ul/li[1]/a",
						driver);
				Thread.sleep(9000);

				if (return_text(
						".//*[@class='plans']/div[6]/section/div/div[2]/div/p[2]",
						driver).equalsIgnoreCase("Here’s what you get:"))

				{
					logger.info(" Additional content Displayed!!");
					statusTracker(br,driver, "Pass", "Additional content Displayed",
							"Matches", "Additional content should be Displayed");
				} else {
					statusTracker(br,driver, "Fail", "Additional content Displayed",
							"does not Match",
							"Additional content should be Displayed");
				}*/
				
				// Close
				
 //to take screenshot and save in file
				try{
		               if (isElementPresent(".//*[contains(text(),'No thanks')]/div",driver))
		                      {
		                         //JS closing Feedback
		                         logger.info("Closing feedback Pop-up");
		                         click_element(".//*[contains(text(),'No thanks')]/div)",driver);
		                                             Thread.sleep(20000);
		                 }   else
		                         logger.info("No Feedback Pop-ups found");
		               
		                  
		                  if (isElementPresent(".//*[contains(@id,'lpInviteLayer')]/div",driver))
		                  {
		                         //JS closing chat box
		                         logger.info("Closing chat Pop-up");
		                         click_element(".//*[contains(@id,'lpInviteLayer')]/div/a[2]/img",driver);
		                         Thread.sleep(20000);
		                  }      else
		                         logger.info("No chat Pop-ups found");
		               } catch (Exception e) {
		                         exceptionHandler(br, e, driver);
		               }
				screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				targetFile = new File(spath +"//Test_Results//NewImages//"+ Page_Phone + screen_count + ".png");
				FileUtils.copyFile(screenshot, targetFile);		
				logger.info("copied file into New Images folder"+targetFile);
				
			
if(url.contains("beta"))
                    
                {
                env = "Beta";
                Image_compare(br,env,Page_Phone,spath,screen_count,driver);
                //Image_compare(br,driver, spath+"//Test_Results//StandardImages_Beta//RT_Internet_EBF//RT_Internet_EBF_012_1.png",spath+"//Test_Results//NewImage//RT_Internet_EBF_012_1.png");
               Thread.sleep(5000);
               logger.info("Beta Environment");
               }
               else
               {
            	env = "Prod" ;
                Image_compare(br,env,Page_Phone,spath,screen_count,driver);   
               //Image_compare(br,driver, spath+"//Test_Results//StandardImages_Prod//RT_Internet_EBF//RT_Internet_EBF_012_1.png",spath+"//Test_Results//NewImage//RT_Internet_EBF_012_1.png");
               Thread.sleep(5000);
               logger.info("Prod Environment");
               
               }
				screen_count++;
				
				//click_element(".//*[@class='plans']/div[6]/header/ul/li[1]/a",
						//driver);
				Thread.sleep(4000);

				
				
				// Select a plan by clicking the CTA associated with the level
				// of service.
				click_element(
						".//*[@id='content']/div[3]/div[2]/div/div[2]/div[1]/div[2]/div/div/div/div[1]/header/ul/li[5]/div/a",
						driver);
				Thread.sleep(20000);
				statusTracker(br,driver, "Pass",
						"New Internet Plan is added to cart ",
						"Added to cart",
						"New Internet Plan should be added to cart ");
				

				/*if (return_text(
						".//*[@class='miniCart']/div[2]/section/div[1]/div/section/div/table/tbody/tr[1]/td[1]/strong",
						driver).equalsIgnoreCase("Preferred TV"))*/
				if (return_text(
						".//*[@class='miniCart']/div[2]/section/div[1]/div/section/div/table/tbody/tr[1]/td[1]/strong",
						driver).equalsIgnoreCase("Ultimate 300"))	

				{
					logger.info(" New Internet Plan is added to cart");
					statusTracker(br,driver, "Pass",
							"New Internet Plan is added to cart ",
							"Added to cart",
							"New Internet Plan should be added to cart ");
				} else {
					statusTracker(br,driver, "Fail",
							"New Internet Plan is added to cart ",
							"Not added to cart",
							"New Internet Plan should be added to cart ");
				}

				driver.quit();

			}

			catch (Exception e) {
				logger.info("Error in app is : " + e.getMessage());
				exceptionHandler(br, e, driver);

			}
		} finally {
			wb.close();
			driver.close();

		}

	}

	


}
