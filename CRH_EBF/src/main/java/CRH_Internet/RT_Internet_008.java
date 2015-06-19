
//File Name: RT_Internet_008
//Author: SHIKHA   
//Description of test case: Upgrade Internet - Skip Logic
//Date of creation(D/M/Y): 3/19/2014
//Name and date(D/M/Y) of modification: RAHUL JADOW (6/6/2014)
//Modification description: Changed user account to skip the Internet config page / Navigation to next page with sign out.


package CRH_Internet;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RT_Internet_008 extends CommonFunctions {

	String table, tns[];
	String tlimit, username, pwd, ctotal, Uname, Tv_plan, Internet_plan,
			Phone_plan, current_service,env;
	int tncount;
	String serAddress, Internet_service, Tv_service, Phone_service,
			Internet_eqipment, Phone_Phone_eqipment, TV_eqipment;

	public RT_Internet_008() {
	}

	public RT_Internet_008(String s) {
		this.path = s;
		logger.info("Add Internet 008 is intialized");
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
		wb.getNumberOfSheets();
		logger.info("No of sheet............:" + wb.getNumberOfSheets());

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
			TV_eqipment = sheet2.getCell(18, loc).getContents();
			Internet_eqipment = sheet2.getCell(19, loc).getContents();
			Phone_Phone_eqipment = sheet2.getCell(20, loc).getContents();
			
			Page_Phone = "RT_Internet_008_";

			tv = sheet2.getCell(Col_locator_full_scan_input_sheet("TV SERVICE", path,Sheet_name), loc).getContents();
			inet = sheet2.getCell(Col_locator_full_scan_input_sheet("INTERNET SERVICE", path,Sheet_name), loc).getContents();
			phone = sheet2.getCell(Col_locator_full_scan_input_sheet("PHONE SERVICE", path,Sheet_name), loc).getContents();
			/*int tv1 = 0, inet1 = 0, phone1 = 0;
			int val = 1;
			int tlim = Integer.parseInt(tlimit);
			tlim *= 60;
			tlimit = Integer.toString(tlim);
			tlimit = tlimit + "000";*/

			String int_plan = tv = sheet2.getCell(Col_locator_full_scan_input_sheet("TV PLAN", path,Sheet_name), loc).getContents();
			String int_eqipment = sheet2.getCell(Col_locator_full_scan_input_sheet("INTERNET PLAN", path,Sheet_name), loc).getContents();
			String phone_plan = sheet2.getCell(Col_locator_full_scan_input_sheet("PHONE PLAN", path,Sheet_name), loc).getContents();

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

				click_element(".//*[@ value='upgrade_inet']", driver);
				statusTracker(br,driver, "Pass", "Clicked: Upgrade Internet",
						"Clicked: Upgrade Internet",
						"Should Click : Upgrade Internet");
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
				
				
				click_element("//*[@class='arrow']", driver);
				Thread.sleep(8000);

				if (Isavailable(".//*[@class='left']", driver)) {
					statusTracker(br,driver, 
							"Pass",
							"Validate User is directed to Select a Plan Internet Page",
							" User is directed to Select a Plan Internet Page",
							" User should be directed to Select a Plan Internet Page");
				} else {
					statusTracker(br,driver, 
							"Fail",
							"Validate User is directed to Select a Plan Internet Page",
							" User is not directed to Select a Plan Internet Page",
							" User should be directed to Select a Plan Internet Page");
				}

				if (Isavailable("//*[@class='active']", driver))
					if (return_text("//*[@class='active']/span", driver).trim()
							.equalsIgnoreCase("Internet")) {
						statusTracker(br,driver, "Pass",
								"Validate the secondary progress bar",
								"The secondary progress bar present",
								"The secondary progress bar should be present");
					} else {
						statusTracker(br,driver, "Fail",
								"Validate the secondary progress bar",
								"The secondary progress bar not present",
								"The secondary progress bar should be present");
					}

				// Compare Internet plans
				click_element("//*[@class='right']/a", driver);
				Thread.sleep(5000);

				if (return_text(".//*[@ class='modal-title']", driver).trim()
						.equalsIgnoreCase("Internet Plans at a Glance"))
				// if (return_text("//*[@class='active']/span", driver).trim()
				// .equalsIgnoreCase("Internet"))
				{
					statusTracker(br,driver, 
							"Pass",
							"Validate that on clicking  Compare Internet plans link displays the correct content upon clicking the link",
							" Compare Internet plans link displays the correct content upon clicking the link",
							"Compare Internet plans link displays the correct content upon clicking the link");
				} else {
					statusTracker(br,driver, 
							"Fail",
							"Validate that on clicking  Compare Internet plans link displays the correct content upon clicking the link",
							"Compare Internet plans link displays the correct content upon clicking the link",
							"Compare Internet plans link displays the correct content upon clicking the link");
				}

				click_element("//*[@class='modal-button-close']", driver);
				Thread.sleep(5000);

				if (Isavailable(".//*[@class='left']", driver)) {
					statusTracker(br,driver, "Pass",
							"Compare Internet plan link will get close",
							" Compare Internet plan link gets closed",
							"Compare Internet plan link should get closed");
				} else {
					statusTracker(br,driver, "Fail",
							"Compare Internet plan link will get close",
							" Compare Internet plan link doesnt gets closed",
							" Compare Internet plan link should get closed");
				}

				if (Isavailable(
						".//*[@class='collapsible js-expander-initialized']",
						driver)) {
					statusTracker(br,driver, "Pass",
							"Verify the current services module is closed",
							"Current services module is closed",
							"Current services module should be closed");
				} else {
					statusTracker(br,driver, "Fail",
							"Verify the current services module is closed",
							"Current services module is not closed",
							"Current services module should be closed");
				}

				click_element(".//*[@class='miniCart']/div/header/ul/li[2]/a",
						driver);
				statusTracker(br,driver, "Pass", "Clicked : Current service arrow",
						"Clicked : Current service arrow",
						"Should Click : Current service arrow");

				ctotal = "$" + ctotal;
				logger.info("cost_current_sevice_input is " + ctotal);
				String current_service_app_cost = return_text(
						"//*[@class='price last']", driver);

				logger.info(return_text("//*[@class='price last']",
						driver));
				if (ctotal.equals(current_service_app_cost)) {
					statusTracker(br,driver, 
							"Pass",
							" Verify that monthly total is correct ",
							"monthly total displayed is matching with input sheet",
							"monthly total displayed should match with input sheet");

				} else {
					statusTracker(br,driver, 
							"Fail",
							" Verify that monthly total is correct ",
							"monthly total displayed is not matching with input sheet",
							"monthly total displayed should match with input sheet");
				}

				// Step 4:Within Current Services, select expand button
				click_element(".//*[@class='miniCart']/div/header/ul/li[2]/a",
						driver);
				Thread.sleep(3000);

				// Step 5: Verify the plan under current services are matching
				// with input sheet
				String[] x_cur = new String[6];
				String[] x_excel = new String[6];
				x_excel[1] = inet;
				x_excel[2] = phone;
				int ver_1 = 0;
				int li_cur_size = return_size(
						"//*[@class='collapsible js-expander-initialized']/header",
						driver);
				logger.info("number of current service present "
						+ li_cur_size);

				for (int i = 1; i <= li_cur_size; i++) {
					x_cur[i] = return_text(
							"//*[@class='collapsible js-expander-initialized']["
									+ i + "]/header/ul/li[2]/h6", driver);
					logger.info("text present in app  " + x_cur[i]);
					logger.info("text present in excell " + x_excel[i]);
					if (x_excel[i].equals(x_cur[i])) {

						logger.info("text present are " + x_cur[i]);
						ver_1++;
					}

				}

				if ((ver_1) == li_cur_size) {
					statusTracker(br,driver, 
							"Pass",
							" Verify LOBs on the account are displayed in the correct order",
							"The LOBs on the account are displayed in the correct order.",
							"The LOBs on the account should be displayed in correct order");
				} else {
					statusTracker(br,driver, 
							"Fail",
							" Verify LOBs on the account are displayed in the correct order",
							"The LOBs on the account are not displayed in the correct.",
							"The LOBs on the account should be displayed in correct order");
				}

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

				Sheet sheet3 = wb.getSheet("Internet_Plans");//RT_Internet_008
				int totalcount = 0;
				String dummy = "a";
				int ij = 3;
				int cn = 0;
				do {
					if (dummy != null && dummy.length() > 0) {
						dummy = sheet3.getCell(5, ij).getContents();
						ij++;
						try {
							dummy = sheet3.getCell(5, ij).getContents();
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
					plan1[i] = sheet3.getCell(5, (i + 3)).getContents();
					Speed1[i] = sheet3.getCell(6, (i + 3)).getContents();
					cost1[i] = sheet3.getCell(7, (i + 3)).getContents();
					logger.info("Plan "
							+ sheet3.getCell(5, (i + 3)).getContents());
					logger.info("Speed "
							+ sheet3.getCell(6, (i + 3)).getContents());
					logger.info("Cost "
							+ sheet3.getCell(7, (i + 3)).getContents());
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

				click_element(
						".//*[@class='collapsible page-collapsible two-rows js-expander-initialized'][1]/header/ul/li[1]",
						driver);
				Thread.sleep(2000);

				click_element(
						".//*[@class='collapsible page-collapsible two-rows js-expander-initialized'][1]/header/ul/li[1]",
						driver);
				Thread.sleep(2000);
/*nan
				click_element(
						".//*[@class='collapsible page-collapsible two-rows js-expander-initialized'][1]/header/ul/li[1]",
						driver);
				Thread.sleep(2000);
*/
				if (Isavailable("//*[@class='content-wrap']", driver)) {
					statusTracker(br,driver, "Pass",
							"Select the Expand arrow within each plan",
							"Additional contents gets dispalyed ",
							"Additional contents gets dispalyed");
				} else {
					statusTracker(br,driver, "Fail",
							"Select the Expand arrow within each plan",
							"Additional contents doesnt gets dispalyed ",
							"Additional contents gets dispalyed");
				}

			click_element(
						".//*[@class='collapsible page-collapsible two-rows js-expander-initialized active'][1]/header/ul/li[1]/a",
						driver);
				Thread.sleep(2000);

				click_element(
						".//*[@class='collapsible page-collapsible two-rows js-expander-initialized active'][1]/header/ul/li[1]/a",
						driver);
				Thread.sleep(2000);
				/*nan
				click_element(
						".//*[@class='collapsible page-collapsible two-rows js-expander-initialized active'][1]/header/ul/li[1]/a",
						driver);
				Thread.sleep(2000);
		*/		
	//Select Ulimate plan
				
		click_element(".//*[@id='content']/div[3]/div[2]/div/div[2]/div[1]/div[2]/div/div/div/div[1]/header/ul/li[5]/div/a/span",driver);
		Thread.sleep(18000);
		
		//validate display of review order page
		   if(return_text(".//*[@class='left']/h2", driver).equalsIgnoreCase("Customize Your Internet Plan"))
			{statusTracker(br,driver, "Pass", "User finishes the LOS configuration and selects the continue CTA",
					"User is displayed with Customize Your Internet Plan page" , "User should be displayed with Customize Your Internet Plan page");
			}
			else
			{statusTracker(br,driver, "Fail", "User finishes the LOS configuration and selects the continue CTA",
					"User is not displayed with Customize Your Internet Plan page" , "User should be displayed with Customize Your Internet Plan page");
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
				
			scrollToElementByLinkText("Sign Out",driver);
				driver.findElement(By.linkText("Sign Out")).click();
				Thread.sleep(10000);
				if (Isavailable(".//*[@class='twc-last js-last']/a", driver))
					statusTracker(br,driver, "Pass", "Click on the Sign out button",
							"Customer is Logged Out from the current session.",
							"Customer should Log Out");
				else
					statusTracker(br,driver, 
							"Fail",
							"Click on the Sign out button",
							"Customer is NOT Logged Out from the current session.",
							"Customer should Log Out");

				
				driver.quit();
			} catch (Exception e) {
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
