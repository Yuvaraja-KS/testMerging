
 
//File Name: RT_Package_005
//Author: Rahul Jadow
//Description of test case: Add/Upgrade Internet -customer selects package offer & presented with upgrade options
//Date of creation(D/M/Y): 11/3/2014
//Name and date(D/M/Y) of modification: Raveena Singh  6/6/2014
//Modification description:  Code Cleanup and xpath unique property updation
//Name and date(D/M/Y) of modification: Rahul Jadow  18/6/2014
//Modification description: validate Additional equipments on TV configuration page (CableCARD™ with Tuning Adapter) /  RO page and Signout.
//Name and date(D/M/Y) of modification: RAHUL JADOW  (66/6/2014)
//Modification description:  Packages name changes and few failures fixed

package CRH_EBF_Packages;

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

public class RT_Package_005 extends CommonFunctions {

	String table, tns[];
	String tlimit, username, pwd, ctotal, Uname, Tv_plan, Internet_plan,
			Phone_plan, current_service;
	int tncount;
	String serAddress, Internet_service, Tv_service, Phone_service;

	public RT_Package_005() {
	}

	public RT_Package_005(String s) {
		this.path = s;
		logger.info("View all Package 005 is intialized");
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

	public void execute(String br, WebDriver driver, String url, int loc,String Overall_Path,String env) throws Exception {
		int screen_count = 1;
		File data = new File(this.path);
		WorkbookSettings ws = new WorkbookSettings();
		ws.setLocale(new Locale("er", "ER"));
		Workbook wb = Workbook.getWorkbook(data, ws);
		logger.info("Package_005");
		try {

			logger.info(" reached first stage");
			String tv = "", inet = "", phone = "";
			Sheet sheet2 = wb.getSheet("Packages");
			String Sheet_name = sheet2.getName();
			Page_Phone = "RT_Package_005_";

			tlimit = sheet2.getCell(6, loc).getContents();
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
			String cost_current_sevice_input = sheet2.getCell(Col_locator_full_scan_input_sheet("C-TOTAL", path,Sheet_name), loc)
					.getContents();
			String cost_New_sevice_input = sheet2.getCell(Col_locator_full_scan_input_sheet("Package Price", path,Sheet_name), loc)
					.getContents();

			if (first == 0) {
				logger.info("trying to open the url");
				driver.manage().window().maximize();
				driver.get(url);
				logger.info("Chek if url opened");
			}

			try {
				if (first == 0) {
					firstrun(br, driver, username, pwd,ctotal, Uname,
							serAddress);
				}
				logger.info("I went to next step");

	//to take screenshot and save in file
				Image_compare(br,env,Page_Phone,Overall_Path,screen_count,driver);
				screen_count++;
				/* File /*screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				File targetFile = new File(Overall_Path +"//Test_Results//NewImages//"+ Page_Phone + screen_count + ".png");
				FileUtils.copyFile(screenshot, targetFile);		
				logger.info("copied file into New Images folder"+targetFile);
				
			
				Image_compare(br, env,Page_Phone,Overall_Path,screen_count);
				screen_count++;*/
				
				{

					// Click on View Allpackage
					Thread.sleep(6000);
					click_element(
							"//*[@class='js-next-button blue-button center']",
							driver);
					Thread.sleep(6000);

					// click tv & internet

					click_element(".//*[@id='tv-filter']", driver);
					Thread.sleep(6000);
					click_element(".//*[@id='internet-filter']", driver);
					Thread.sleep(6000);
					click_element(".//*[@id='phone-filter']", driver);
					Thread.sleep(6000);

					// Verify if all three LOB’s will be unchecked. Show all can
					// display Triple or Double plays. Rankings will be regionally
					// configurable.

					click_element(".//*[@id='show-all-filter']", driver);
					Thread.sleep(6000);

					// click on order
					logger.info("I went to next step1");
					/*click_element(
							".//*[@id='content']/div[3]/div[3]/div[1]/div/div/div[2]/div/a[1]",
							driver);*/
					Thread.sleep(6000);
					logger.info("I went to next step2");
					/*click_element(
							".//*[@id='content']/div[3]/div[3]/div[1]/div/div/div[2]/div/a[1]",
							driver);*/
					Thread.sleep(6000);
					logger.info("I went to next step3");
					
					if (url.contains("beta")){
						click_element(
								".//*[@class='packages-list']/li[2]/div/div[4]/a[1]",
								driver);
					}
					else {
					click_element(
							".//*[@class='packages-list']/li[6]/div/div[4]/a[1]",
							driver);
					}
					Thread.sleep(6000);
					
					//validate TV equipments on TV configuration page
					logger.info("I went to next step4");
					Thread.sleep(6000);

					if (return_text(
							".//*[@class='active']/span",
							driver).equals("TV")) {
						statusTracker(br, "Pass",
								"Validate the secondary progress bar",
								"TV is displayed in progress bar",
								"Secondary progress bar should display  TV ");
					} else {
						statusTracker(br, "Fail",
								"Validate the secondary progress bar",
								"TV is not displayed in progress bar",
								"Secondary progress bar should display TV ");
					}

					Thread.sleep(6000);

					
				//if(return_text(".//*[@id='content']/div[3]/div[2]/div/div[2]/div/div[2]/div/div[2]/div[1]/section/div/div[4]/form/div[1]/section/div/ul/li[1]/h4", driver).trim().equalsIgnoreCase("Whole House Package for 2 TVs"))
					if(return_text(".//*[@class='tv-equipment']/form/div[1]/section/div/ul/li[1]/h4", driver).trim().equalsIgnoreCase("Enhanced DVR Box with Free Whole House Service"))
					
						//if(return_text(".//*[@class='primary-equipment collapsible page-collapsible inner-collapse active js-expander-initialized']/section/div/ul/li[2]/h4", driver).trim().equalsIgnoreCase("HD-DVR Box and Service"))
						//	if(return_text("//*[@class='primary-equipment collapsible page-collapsible inner-collapse active js-expander-initialized']/section/div/ul/li[3]/h4", driver).trim().equalsIgnoreCase("CableCARD™ with Tuning Adapter"))
						//		if(return_text("//*[@class='primary-equipment collapsible page-collapsible inner-collapse active js-expander-initialized']/section/div/ul/li[4]/h4", driver).trim().equalsIgnoreCase("I don't want a box"))
								{
									logger.info("All Tv Equipments displayed in order!!"  );
									statusTracker(br, "Pass", "Validate the Tv Equipments are displayed in Tv configuration page", "Tv Equipments are displayed in Tv configuartion page", "Tv Equipments should be displayed in Tv configuration page");
									
								}
								else
								{
									logger.info("All Tv Equipments NOT displayed in order!!");
									statusTracker(br, "Fail", "Validate the Tv Equipments are displayed in Tv configuration page", "Tv Equipments are NOT displayed in Tv configuartion page", "Tv Equipments should be displayed in Tv configuration page");
								
								}
				
				

					click_element(".//*[@class='tv-equipment']/form/div[2]/header/ul/li[1]/a", driver);
					Thread.sleep(6000);
					
					if (url.contains("beta")){	
						
						
					//validate Additional equipments on TV configuration page
					if(return_text(".//*[@class='tv-equipment']/form/div[2]/section/div/ul/li[1]/h4", driver).trim().equalsIgnoreCase("HD Box"))
						logger.info("----1-----");
						if(return_text(".//*[@class='tv-equip-box'][2]/div/h4", driver).trim().equalsIgnoreCase("Enhanced DVR Box (0) Show More"))
							logger.info("----2-----");
							if(return_text(".//*[@class='tv-equip-box'][3]/div/h4", driver).trim().equalsIgnoreCase("CableCARD™ with Tuning Adapter (0) Show More"))
								{
									logger.info("All Additional Equipments displayed in order!!");
									statusTracker(br, "Pass", "Validate the Additional Equipments are displayed in Tv configuration page", "Additional Equipments are displayed in Tv configuartion page", "Additional Equipments should be displayed in Tv configuration page");
									
								}
								else
								{
									logger.info("All Tv Equipments NOT displayed in order!!");
									statusTracker(br, "Fail", "Validate the Additional Equipments are displayed in Tv configuration page", "Additional Equipments are NOT displayed in Tv configuartion page", "Additional Equipments should be displayed in Tv configuration page");
								
								}
					}
					else if (url.equalsIgnoreCase("https://www.timewarnercable.com/residential/order"))
					{
						
						if(return_text(".//*[@class='tv-equipment']/form/div[2]/section/div/ul/li[1]/h4", driver).trim().equalsIgnoreCase("HD Box"))
							logger.info("----1-----");
							if(return_text(".//*[@id='content']/div[3]/div[2]/div/div[2]/div/div[2]/div/div[2]/div[1]/section/div/div[4]/form/div[2]/section/div/ul/li[2]/h4", driver).trim().equalsIgnoreCase("HD-DVR Box and Service"))
								logger.info("----2-----");
								if(return_text(".//*[@id='content']/div[3]/div[2]/div/div[2]/div/div[2]/div/div[2]/div[1]/section/div/div[4]/form/div[2]/section/div/ul/li[3]/div/h4", driver).trim().equalsIgnoreCase("CableCARD™ with Tuning Adapter (0) Show More"))
									{
										logger.info("All Additional Equipments displayed in order!!");
										statusTracker(br, "Pass", "Validate the Additional Equipments are displayed in Tv configuration page", "Additional Equipments are displayed in Tv configuartion page", "Additional Equipments should be displayed in Tv configuration page");
										
									}
									else
									{
										logger.info("All Tv Equipments NOT displayed in order!!");
										statusTracker(br, "Fail", "Validate the Additional Equipments are displayed in Tv configuration page", "Additional Equipments are NOT displayed in Tv configuartion page", "Additional Equipments should be displayed in Tv configuration page");
									
									}
						
					}

					
					Thread.sleep(6000);
					Select_DropDown(br, driver, "//*[@data-name='HD Box']", "2");
					Thread.sleep(6000);
					
					// Click TV continue
					click_element(".//*[@class='js-next-button blue-button right']", driver);
					Thread.sleep(6000);
					

				// Internet plan page verification
					if (return_text(
							".//*[@class='active']/span",
							driver).equals("Internet")) {
						statusTracker(br, "Pass",
								"Validate the secondary progress bar",
								"Internet is displayed in progress bar",
								"Secondary progress bar should display  Internet ");
					} else {
						statusTracker(br, "Fail",
								"Validate the secondary progress bar",
								"Internet is not displayed in progress bar",
								"Secondary progress bar should display Internet ");
					}

					Thread.sleep(6000);

					// step 2: Current service should be displayed and should
					// not be expanded
					if (isElementPresent(
							".//*[@class='miniCart']/div/header/ul/li[2]/a",
							driver)) {
						statusTracker(br, "Pass",
								"check current services module is present",
								"current services module is present",
								"current services module should display");
					}

					else {
						statusTracker(br, 
								"Fail",
								" check current services module is NOT present",
								"current services module is not present",
								"current services module should display");
					}
					Thread.sleep(6000);

					// Step3 Monthly total displayed
					cost_current_sevice_input = "$" + cost_current_sevice_input;
					logger.info("cost_current_sevice_input is "
							+ cost_current_sevice_input);
					String current_service_app_cost = return_text(
							"//*[@class='price last']", driver);
					logger.info(return_text("//*[@class='price last']",
							driver));
					if (cost_current_sevice_input
							.equals(current_service_app_cost)) {
						statusTracker(br, 
								"Pass",
								" Verify that monthly total is the correct ",
								"monthly total displayed is matching with input sheet",
								"monthly total displayed should match with input sheet");

					} else {
						statusTracker(br, 
								"Fail",
								" Verify that monthly total is the correct ",
								"monthly total displayed is not matching with input sheet",
								"monthly total displayed should match with input sheet");
					}

					Thread.sleep(6000);

					// Verify that the New Services cart includes the package
					// chosen from the packages page

					// Name
					if (driver
							.findElement(
									By.xpath(".//*[@class='bundle']/tbody/tr/td/strong/div"))
							.getText().equalsIgnoreCase("Package Price")) {
						logger.info("New Services module is included in the package");
						statusTracker(br, 
								"Pass",
								"check if The New Services module is included in the package  ",
								"New Services module is included in the package",
								"New Services module should be included in the package");
					} else {
						logger.info("New Services module is not included in the package");
						statusTracker(br, 
								"Fail",
								"check if The New Services module is not included in the package  ",
								"New Services module is not included in the package",
								"New Services module should not included in the package");
					}

					// Duration
					if (driver
							.findElement(
									By.xpath(".//*[@class='bundle']/tbody/tr/td/em"))
							.getText()
							.equalsIgnoreCase("per Month for 12 Months")) {
						logger.info("New Services Duration is included in the package");
						statusTracker(br, 
								"Pass",
								"check if The New Services Duration is included in the package  ",
								"New Services Duration is included in the package",
								"New Services Duration should be included in the package");
					} else {
						logger.info("New Services Duration is not included in the package");
						statusTracker(br, 
								"Fail",
								"check if The New Services Duration is not included in the package  ",
								"New Services Duration is not included in the package",
								"New Services Duration should not included in the package");
					}

					// New Services Monthly Charges displayed
					cost_New_sevice_input = "$" + cost_New_sevice_input;
					logger.info("cost_New_sevice_input is "
							+ cost_New_sevice_input);
					String New_service_app_cost = return_text(
							".//*[@class='charges']/table[2]/tbody/tr/td[2]",
							driver);
					logger.info(return_text(
									".//*[@class='charges']/table[2]/tbody/tr/td[2]",
									driver));
					if (cost_New_sevice_input.equals(New_service_app_cost)) {
						statusTracker(br, 
								"Pass",
								" Verify that monthly charges is the correct ",
								"monthly charges displayed is matching with input sheet",
								"monthly charges displayed should match with input sheet");

					} else {
						statusTracker(br, 
								"Fail",
								" Verify that monthly charges is the correct ",
								"monthly charges displayed is not matching with input sheet",
								"monthly charges displayed should match with input sheet");
					}

				// Plan Speed & Cost
					int count1 = return_size(
							".//*[@class='plans']/div/header/ul",
							driver);
					logger.info("count" + count1);
					statusTracker(br, "", "Plans Present", "", "");
					String plan[] = new String[count1];
					String speed[] = new String[count1];
					String cost[] = new String[count1];
					for (int i = 1; i <= count1; i++) {
						plan[i - 1] = return_text(
								"//*[@class='plans']/div["+ i + "]/header/ul/li[2]/h3", driver);
						speed[i - 1] = return_text(
								"//*[@class='plans']/div["+ i + "]/header/ul/li[3]/p/b", driver);
						cost[i - 1] = return_text(
								"//*[@class='plans']/div["+ i + "]/header/ul/li[4]", driver);

						System.out
								.println("Plan name "
										+ return_text(
												"//*[@class='plans']/div["+ i + "]/header/ul/li[2]/h3",
												driver));
						statusTracker(br, 
								"Pass",
								"Plan name",
								return_text(
										"//*[@class='plans']/div["+ i + "]/header/ul/li[2]/h3",
										driver), "Plan name should be present ");
						System.out
								.println("Speed "
										+ return_text(
												"//*[@class='plans']/div["+ i + "]/header/ul/li[3]/p/b",
												driver));
						statusTracker(br, 
								"Pass",
								"Speed",
								return_text(
										"//*[@class='plans']/div["+ i + "]/header/ul/li[3]/p/b",
										driver), "Speed should be present");
						System.out
								.println("Cost "
										+ return_text(
												"//*[@class='plans']/div["+ i + "]/header/ul/li[4]",
												driver));
						statusTracker(br, 
								"Pass",
								"Cost",
								return_text(
										"//*[@class='plans']/div["+ i + "]/header/ul/li[4]",
										driver), "Cost should be present");
					}

					// Additional costs
					String Addcost = driver
							.findElement(
									By.xpath("//*[@class='plans']/div[2]/header/ul/li[4]"))
							.getText();

					if ((Addcost.equalsIgnoreCase("Add $1000 per Month for 12 Months"))) {
						System.out
								.println("Additional costs is Present : Add $10.00 per Month for 12 Months");
						statusTracker(br, 
								"Pass",
								"Additional costs is associated with upgraded services in the package  ",
								"Additional costs is associated with upgraded services in the package",
								"Additional costs should be associated with upgraded services in the package");
					} else {
						System.out
								.println("Additional costs is not associated with upgraded services in the package");
						statusTracker(br, 
								"Fail",
								"Additional costs is not associated with upgraded services in the package  ",
								"Additional costs is not associated with upgraded services in the package",
								"Additional costs should be associated with upgraded services in the package");
					}

					// Select Internet Plan
					driver.findElement(
							By.xpath("//*[@data-name='Ultimate 50']/li[5]/div/a"))
							.click();
					Thread.sleep(14000);
					System.out
							.println("End of second page and entering into third page");
				}

				// Validating if user has navigated to the Customize your
				// Internet plan page
				if (return_text(
						".//*[@class='buyFlowHeader section']/header/div/div[1]/h2",
						driver).trim().equals("Customize Your Internet Plan")) {
					System.out
							.println("Customize Your Internet Plan is Displayed");
					statusTracker(br, 
							"Pass",
							"Click the Continue Button",
							"User is navigated to the Customize your Internet plan page",
							"User should navigate to the Customize your Internet plan page");
				} else {
					System.out
							.println("Customize Your Internet Plan is not Displayed");
					statusTracker(br, 
							"Fail",
							"Click the Continue Button",
							"User is NOT navigated to the Customize your Internet plan page",
							"User should navigate to the Customize your Internet plan page");
				}

	//to take screenshot and save in file
				Image_compare(br,env,Page_Phone,Overall_Path,screen_count,driver);
				screen_count++;
				/*screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				targetFile = new File(Overall_Path +"//Test_Results//NewImages//"+ Page_Phone + screen_count + ".png");
				FileUtils.copyFile(screenshot, targetFile);		
				logger.info("copied file into New Images folder"+targetFile);
				
			
				Image_compare(br, env,Page_Phone,Overall_Path,screen_count);
				screen_count++;*/
				
				//Continue
				click_element(".//*[@class='js-next-button blue-button right']", driver);
				Thread.sleep(8000);
				if (return_text(
						".//*[@class='buyFlowHeader section']/header/div/div[1]/h2",
						driver).trim().equals("Customize Your Phone Service")) {
					System.out
							.println("Customize Your Phone Service is Displayed");
					statusTracker(br, 
							"Pass",
							"Click the Continue Button",
							"User is navigated to the Customize your Phone Service page",
							"User should navigate to the Customize your Phone Service page");
				} else {
					System.out
							.println("Customize Your Phone Service is not Displayed");
					statusTracker(br, 
							"Fail",
							"Click the Continue Button",
							"User is NOT navigated to the Customize your Phone Service page",
							"User should navigate to the Customize your Phone Service page");
				}
				Thread.sleep(1000);
				
				if (url.equalsIgnoreCase("https://www.timewarnercable.com/residential/order"))
				{
				click_element(".//*[@class='continue']/a", driver);
				Thread.sleep(1000);
				click_element(".//*[@class='continue']/a", driver);
				Thread.sleep(1000);
				driver.findElement(By.xpath(".//*[@id='full-name1']")).sendKeys("Jagadesh");
				Thread.sleep(1000);
				
				
				WebElement my_select_birthmonth = driver.findElement(By
						.xpath("//*[@id='birth-month']"));
				my_select_birthmonth.click();
				List<WebElement> my_li_bm = my_select_birthmonth.findElements(By
						.tagName("option"));

				int size_drop_bm = my_li_bm.size();
				logger.info("",size_drop_bm);
				for (int i = 0; i < size_drop_bm; i++) {
					if (my_li_bm.get(i).getText().equals("June")) {
						my_li_bm.get(i).sendKeys("June");
						// field_statusTracker(br, "//*[@id='birth-month']","Select Month","Month is Selected",
						// driver);
						break;
					}

				}
				Thread.sleep(6000);

				WebElement my_select_birthday = driver.findElement(By
						.xpath("//*[@id='birth-date']"));
				my_select_birthday.click();
				List<WebElement> my_li_bd = my_select_birthday.findElements(By
						.tagName("option"));

				int size_drop_bd = my_li_bd.size();
				logger.info("",size_drop_bd);

				for (int i = 0; i < size_drop_bd; i++) {
					if (my_li_bd.get(i).getText().equals("5")) {
						my_li_bd.get(i).sendKeys("5");
						// field_statusTracker(br, "//*[@id='birth-date']","Birth date is selected","Birth Date is Entered",
						// driver);
						break;
					}

				}
				Thread.sleep(6000);
				WebElement my_select_birthyear = driver.findElement(By
						.xpath("//*[@id='birth-year']"));
				my_select_birthyear.click();
				List<WebElement> my_li_by = my_select_birthyear.findElements(By
						.tagName("option"));

				int size_drop_by = my_li_by.size();
				logger.info("",size_drop_by);
				for (int i = 0; i < size_drop_by; i++) {
					if (my_li_by.get(i).getText().equals("1950")) {
						my_li_by.get(i).sendKeys("1950");
						// field_statusTracker(br, "//*[@id='birth-year']","Select Year","Birth year is selected",
						// driver);
						break;
					}

				}
				Thread.sleep(6000);
				driver.findElement(By.xpath("//*[@id='full-name2']")).sendKeys(
						"Wideband");
				// field_statusTracker(br, "//*[@id='full-name2']","Enter Full Name","Full Name is Entered",
				// driver);
				}
				Thread.sleep(6000);
				
				click_element(".//*[@class='js-next-button blue-button right']", driver);
				Thread.sleep(8000);

				//Review Order page
				if(return_text(".//*[@class='left']/h2", driver).trim().equalsIgnoreCase("Choose Installation & Review Order"))
				{
					statusTracker(br, "Pass", "Validate whether navigated to Review order page", "Navigated to review order page", "It should navigate to review order page");
				}
				else
				{
					statusTracker(br, "Fail", "Validate whether navigated to Review order page", "NOT Navigated to review order page", "It should navigate to review order page");
					
				}
				
				Thread.sleep(8000);
				
			//Sign Out	
			driver.findElement(By.linkText("Sign Out")).click();
				Thread.sleep(10000);
				
				if (Isavailable(".//*[@class='twc-last js-last']/a", driver))
					statusTracker(br, "Pass",
							"Click on the Sign out button",
							"Customer is Logged Out from the current session.",
							"Customer should Log Out.");
				else
					statusTracker(br, "Fail",
							"Click on the Sign out button",
							"Customer is NOT Logged Out from the current session.",
							"Customer should Log Out.");
			    
			
				
				
				driver.quit();
			}

			catch (Exception e) {
				exceptionHandler(br, e, driver);
				logger.info("test error message 005 is:"	+ e.getMessage());
			}
		} catch (Exception e) {
			exceptionHandler(br, e, driver);

		}

		finally {
			wb.close();
			driver.close();

		}
	}
}
