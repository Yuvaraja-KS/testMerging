
//File Name: RT_Internet_007
//Author: RAHUL JADOW  
//Description of test case: Upgrade Internet - Validate LOS selections
//Date of creation(D/M/Y): 3/19/2014
//Name and date(D/M/Y) of modification: 
//Modification description: 


package CRH_Internet;

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
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;

public class RT_Internet_007 extends CommonFunctions {

	String table, tns[];
	String tlimit, username, pwd, ctotal, Uname, Tv_plan, Internet_plan,
			Phone_plan, current_service,env;
	int tncount;
	String serAddress, Internet_service, Tv_service, Phone_service,
			str_Browser;

	public RT_Internet_007() {
	}

	public RT_Internet_007(String s) {
		this.path = s;
		logger.info("Add Internet 007 is intialized");
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
			Page_Phone = "RT_Internet_007_";
			str_Browser = sheet2.getCell(Col_locator_full_scan_input_sheet("Browser", path,Sheet_name), loc).getContents();
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

				// If Internet is active on the account, select
				// "Boost your speed"
				click_element(".//*[@ value='upgrade_inet']", driver);
				Thread.sleep(2000);

				// Continue Enabled
				((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1200)");
				Thread.sleep(6000);		
				logger.info("Aashish isEnabled"+Isavailable(".//*[@id='js-main-form']/nav/a",driver));
				
				
					if (Isavailable(".//*[@id='js-main-form']/nav/a",driver)) {
					logger.info("pass");
					statusTracker(br,driver, 
							"Pass",
							"For Internet active on the account select Boost your speed",
							"Internet Boost your speed plan check box is selected",
							"Internet Boost your speed plan check box should be selected");
				} else {
					logger.info("fail");
					statusTracker(br,driver, 
							"Fail",
							"For Internet active on the account select Boost your speed",
							"Internet Boost your speed plan check box is not selected",
							"Internet Boost your speed plan check box should be selected");
				}

				// Select Continue Button so that User navigates to the Internet
				// Select a Plan page.
				click_element("//*[@id='js-main-form']/nav/a/span", driver);
				statusTracker(br,driver, "Pass", "click on Continue button",
						"'Continue button is clicked",
						"should click continue button");
				Thread.sleep(6000);

				// Validating if user has navigated to Internet Select a plan
				// page
				if (return_text(".//*[@class='left']", driver).trim().equals(
						"Choose Your Internet Plan"))
					statusTracker(br,driver, "Pass", "Click the Continue Button",
							"User is navigated to the Internet plan page",
							"User should navigate to the Internet plan page.");
				else
					statusTracker(br,driver, "Fail", "Click the Continue Button",
							"User is NOT navigated to the Internet plan  page",
							"User should navigate to the Internet plan  page.");

				// Validating if progress bar should display Internet
				if (return_text(".//*[@id='content']/div[1]/div/ol/li[1]/div/div/div/ul/li/span", driver).trim().equals(
						"Internet"))
					statusTracker(br,driver, 
							"Pass",
							"Validate the secondary progress bar",
							"Secondary progress bar displays Internet and will be highlighted",
							"Secondary progress bar should display Internet and should be highlighted.");
				else
					statusTracker(br,driver, 
							"Fail",
							"Validate the secondary progress bar",
							"Secondary progress bar will not display Internet and will not be highlighted",
							"Secondary progress bar displays Internet and will be highlighted");

				// Current Services module is closed and displays price in $

				String CurrSer = driver.findElement(
						By.xpath(".//*[@class='sign']")).getText();
				logger.info("price is");
				logger.info(CurrSer);
				logger.info("Testing........01");
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

				// String sAmount = CurrSer.substring(iStartAmount,iEndAmount);

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

				// Current services expand
				click_element(".//*[@class='miniCart']/div/header/ul/li[2]/a",
						driver);
				logger.info(" price read");
				System.out
						.println("validating sequence of LOB under current services");

				// validating sequence of LOB under current services
				String CurrSer1 = driver
						.findElement(
								By.xpath(".//*[@class='collapsible js-expander-initialized']/header/ul/li[2]/h6"))
						.getText();

				if ((CurrSer1.equalsIgnoreCase("Internet"))) {
					logger.info("Right sequence");
					statusTracker(br,driver, "Pass",
							"current sequence matches TV - Internet - Phone",
							"Sequence matches", "Sequence should match");
				} else {
					logger.info("Wrong sequence");
					statusTracker(br,driver, "Fail",
							"current sequence matches TV Internet Phone",
							"Sequence does not match", "Sequence should match");
				}
				System.out
						.println("valid sequence of LOB under current services");


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
//*********************************************************************************************************				
		/*		// Select "Compare Internet Plans" link
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
				Thread.sleep(4000);
				*/
//*********************************************************************************************************
				// Internet plans expand
				click_element(".//*[@class='plans']/div[1]/header/ul/li[1]/a",
						driver);
				Thread.sleep(4000);
				if (return_text(
						".//*[@class='plans']/div[1]/section/div/div[2]/div/p[2]/b",
						driver).equalsIgnoreCase("Here's what you get:")) {
					Thread.sleep(4000);
					logger.info(" Internet plan1 is expanded");
					statusTracker(br,driver, "Pass", "Internet plan1 is expanded",
							"Matches", "Internet plan should expanded");
				} else {
					statusTracker(br,driver, "Fail", "Internet plan is expanded",
							"does not Match",
							"Internet plan is expanded page should expand");
				}

				click_element(".//*[@class='plans']/div[2]/header/ul/li[1]/a",
						driver);
				Thread.sleep(4000);
				if (return_text(
						".//*[@class='plans']/div[2]/section/div/div[2]/div/p[2]/b",
						driver).equalsIgnoreCase("Here’s what you get:")) {
					logger.info(" Internet plan2 is expanded");
					statusTracker(br,driver, "Pass", "Internet plan2 is expanded",
							"Matches", "Internet plan should expanded");
				} else {
					statusTracker(br,driver, "Fail", "Internet plan2 is expanded",
							"does not Match",
							"Internet plan is expanded page should expand");
				}

				click_element(".//*[@class='plans']/div[3]/header/ul/li[1]/a",
						driver);
				Thread.sleep(2000);
				((JavascriptExecutor) driver).executeScript("window.scrollBy(0,600)");
				Thread.sleep(2000);
				
				if (return_text(
						".//*[@class='plans']/div[3]/section/div/div[2]/div/p[2]/b",
						driver).equalsIgnoreCase("Here's what you get:"))

				{
					logger.info(" Internet plan3 is expanded");
					statusTracker(br,driver, "Pass", "Internet plan3 is expanded",
							"Matches", "Internet plan should expanded");
				} else {
					statusTracker(br,driver, "Fail", "Internet plan3 is expanded",
							"does not Match",
							"Internet plan is expanded page should expand");
				}

				logger.info("");

				// validate information of LOB
				JavascriptExecutor jse = (JavascriptExecutor)driver;
				jse.executeScript("scroll(250, 0)");
				// Internet expand
				click_element(
						".//*[@class='collapsible js-expander-initialized']/header/ul/li[1]/a",
						driver);
				Thread.sleep(4000);
				logger.info("");

				// Internet - Standard Internet
				String InternetServ = driver
						.findElement(
								By.xpath(".//*[@class='content-wrap']/ul/li[1]/strong"))
						.getText();
				if (InternetServ.compareTo(Internet_service) != 0) {
					logger.info("Internet service is same as sheet");
					statusTracker(br,driver, "Pass", "Internet service is same as sheet",
							"Service matches", "Service should match");
				} else {
					statusTracker(br,driver, "fail", "Internet service is same as sheet",
							"Service does not match", "Service should match");
				}

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
								
				
				// close dropdown
				click_element(
						".//*[@class='collapsible js-expander-initialized active']/header/ul/li[1]/a",
						driver);
				Thread.sleep(4000);

				// Verify that all Internet plans available in the market
				// display for the new Internet customer
				logger.info("validating Internet plans");
				
				
				List<WebElement> myli = driver
						.findElements(By
								.xpath(".//*[@id='content']/div[3]/div[2]/div/div[2]/div[1]/div[2]/div/div/div/div/header"));
				int count1 = myli.size();
				logger.info(" my list size " + myli.size());
				logger.info("count=" + count1);
				String plan[] = new String[count1];
				String speed[] = new String[count1];
				String cost2[] = new String[count1];
				String cost[] = new String[count1];
				for (int i = 1; i <= count1; i++) {
					plan[i - 1] = driver
							.findElement(
									By.xpath("html/body/section/div[3]/div[2]/div/div[2]/div[1]/div[2]/div/div/div/div["
											+ i + "]/header/ul/li[2]/h3"))
							.getText();
					speed[i - 1] = driver
							.findElement(
									By.xpath("html/body/section/div[3]/div[2]/div/div[2]/div[1]/div[2]/div/div/div/div["
											+ i + "]/header/ul/li[3]"))
							.getText();
					cost2[i - 1] = driver
							.findElement(
									By.xpath("html/body/section/div[3]/div[2]/div/div[2]/div[1]/div[2]/div/div/div/div["
											+ i + "]/header/ul/li[4]"))
							.getText();
					cost[i - 1] = cost2[i - 1].substring(3,
							cost2[i - 1].length() - 26)
							+ "."
							+ cost2[i - 1]
									.substring(cost2[i - 1].length() - 26);
					logger.info("plan name is " + plan[i - 1]);
					statusTracker(br,driver, "Pass", "Plan name", plan[i - 1],
							"Plan name should be displayed");
					logger.info("Speed present are " + speed[i - 1]);
					statusTracker(br,driver, "Pass", "Speed", speed[i - 1],
							"Speed should be displayed");
					logger.info("cost is " + cost[i - 1]);
					statusTracker(br,driver, "Pass", "Cost", cost[i - 1],
							"Cost should be displayed");

				}

				Sheet sheet3 = wb.getSheet("Internet_Plans");//RT_Internet_007
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
				String Speed1[] = new String[totalcount];
				String cost1[] = new String[totalcount];
				logger.info("mf = " + totalcount);
				for (int i = 0; i < totalcount; i++) {
					plan1[i] = sheet3.getCell(0, (i + 3)).getContents();
					Speed1[i] = sheet3.getCell(1, (i + 3)).getContents();
					cost1[i] = sheet3.getCell(2, (i + 3)).getContents();
					logger.info("Plan "
							+ sheet3.getCell(0, (i + 3)).getContents());
					logger.info("Speed "
							+ sheet3.getCell(1, (i + 3)).getContents());
					logger.info("Cost "
							+ sheet3.getCell(2, (i + 3)).getContents());
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

						plan[i] = plan[i].replaceAll(" ", "");
						plan1[i] = plan1[i].replaceAll(" ", "");
						cost[i] = cost[i].replaceAll(" ", "");
						cost1[i] = cost1[i].replaceAll(" ", "");

						logger.info("plan[i] : " + plan[i]);
						logger.info("plan1[i] : " + plan1[i]);
						logger.info("cost[i] :" + cost[i]);
						logger.info("cost1[i] : " + cost1[i]);

						if (plan[i].equalsIgnoreCase(plan1[i])
								&& cost[i].equalsIgnoreCase(cost1[i])) {
							cover = 0;
						} else {
							logger.info("i " + i);
							cover = 1;
							i = count1;

						}
					}
					if (cover == 1) {
						statusTracker(br,driver, 
								"Fail",
								"Verify if the plan, the cost is similar to the details given",
								"The plan details are not as expected",
								"The details should be as expected");
					} else
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
				// end of if
				logger.info("Validated All Internet Plans");


				
				
				// Select Internet Plan
				click_element(
						".//*[@id='content']/div[3]/div[2]/div/div[2]/div[1]/div[2]/div/div/div/div[1]/header/ul/li[5]/div/a",
						driver);
				Thread.sleep(10000);

				// Customize page
				if (driver.findElement(By.xpath(".//*[@class='left']"))
						.getText()
						.equalsIgnoreCase("Choose Installation & Review Order")) {
					logger.info("Choose Installation & Review Order");
					statusTracker(br,driver, "Pass",
							"It opens Internet customization page",
							"it opens Internet customization page",
							"it should open Internet customization page");
				} else {
					logger.info("customization page does not open");
					statusTracker(br,driver, "Fail",
							"It does not open Internet customization page",
							"it opens Internet customization page",
							"it should open Internet customization page");
				}

				driver.quit();
			}

			catch (Exception e) {
				exceptionHandler(br, e, driver);
				logger.info("error is : " + e.getMessage());
			}
		} catch (Exception e) {

			exceptionHandler(br, e, driver);

		} finally {
			wb.close();
			driver.close();

		}

		
	}



}
