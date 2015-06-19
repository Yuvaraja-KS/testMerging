 
//File Name: RT_Package_006
//Author: Nithin
//Description of test case: Add Internet - PKG offer - Configure offer equipment (not Included)
//Date of creation(D/M/Y): 11/3/2014
//Name and date(D/M/Y) of modification: Raveena Singh  6/6/2014
//Modification description:  Code Cleanup and xpath unique property updation
//Name and date(D/M/Y) of modification: RAHUL JADOW  (66/6/2014)
//Modification description:  Packages name changes and few failures fixed  

package CRH_EBF_Packages;

import java.io.File;
import java.util.Locale;

import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

//import CommonFunctions;

public class RT_Package_006 extends CommonFunctions {
	String table, tns[];
	String tlimit, username, pwd, ctotal, Uname, Tv_plan, Internet_plan,
			Phone_plan, current_service;
	int tncount;
	String serAddress, Internet_service, Tv_service, Phone_service,
			str_Browser;

	public RT_Package_006() {
	}

	public RT_Package_006(String s) {
		this.path = s;
		logger.info("View all Package 006 is intialized");
	}

	public void execute(String br, WebDriver driver, String url, int loc,String Overall_Path,String env) throws Exception {
		int screen_count = 1;
		Page_Phone = "RT_Package_006_";
		File data = new File(this.path);
		WorkbookSettings ws = new WorkbookSettings();
		ws.setLocale(new Locale("er", "ER"));
		
		Workbook wb = Workbook.getWorkbook(data, ws);

		try {
			String tv = "", inet = "", phone = "";
			Sheet sheet2 = wb.getSheet("Packages");
			String Sheet_name = sheet2.getName();
			str_Browser = sheet2.getCell(3, loc).getContents();
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
				if (first == 0) {
					firstrun(br, driver, username, pwd,ctotal, Uname,
							serAddress);
				}
				
				Page_Internet = "Page_1_Current services_started";
				

					
				Thread.sleep(5000);
				
	//to take screenshot and save in file
				Image_compare(br,env,Page_Phone,Overall_Path,screen_count,driver);
				screen_count++;
				/* File /*screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				File targetFile = new File(Overall_Path +"//Test_Results//NewImages//"+ Page_Phone + screen_count + ".png");
				FileUtils.copyFile(screenshot, targetFile);		
				logger.info("copied file into New Images folder"+targetFile);
				
			
				Image_compare(br, env,Page_Phone,Overall_Path,screen_count);
				screen_count++;*/

				if (Isavailable(
						"//*[@class='js-next-button blue-button center']",
						driver))
					statusTracker(br, 
							"Pass",
							"User clicks on “View All Packages” link on Your Services page.",
							"User is able to view all packages on this page.",
							"User should be able to view all packages on this page. ");
				else
					statusTracker(br, 
							"Fail",
							"User clicks on “View All Packages” link on Your Services page.",
							"User is NOT able to view all packages on this page.",
							"User should be able to view all packages on this page. ");
				Thread.sleep(2000);
				
				
				click_element(
						"//*[@class='js-next-button blue-button center']",
						driver);

				Thread.sleep(5000);
				click_element(".//*[@id='tv-filter']", driver);
				click_element(".//*[@id='internet-filter']", driver);
				click_element(".//*[@id='phone-filter']", driver);
				click_element(".//*[@id='show-all-filter']", driver);
				if (Isavailable(".//*[@id='tv-filter']", driver)
						&& Isavailable(".//*[@id='internet-filter']", driver)
						&& Isavailable(".//*[@id='phone-filter']", driver)
						&& Isavailable(".//*[@id='show-all-filter']", driver))
					statusTracker(br, 
							"Pass",
							"The user has four (4) check boxes that can be selected in the Offer type Filter.",
							"User is be able to select two or more services.",
							"User should be able to select two or more services.");
				else
					statusTracker(br, 
							"Fail",
							"The user has four (4) check boxes that can be selected in the Offer type Filter.",
							"User is NOT able to select two or more services.",
							"User should be able to select two or more services.");

				Thread.sleep(8000);
				if(url.equals("https://www.timewarnercable.com/residential/order"))
				{
				if (Isavailable(
						"//*[@class='packages-list']/li[2]/div/div[4]/a[1]",
						driver))
					statusTracker(br, 
							"Pass",
							"Select the package click on the \"Order No\"",
							"User is navigated to the TV Configuration page. (TV Select a plan page is skipped)",
							"User must be navigated to the TV Configuration page.");
				else
					statusTracker(br, 
							"Fail",
							"Select the package click on the \"Order No\"",
							"User is NOT navigated to the TV Configuration page. (TV Select a plan page is NOT skipped)",
							"User must be navigated to the TV Configuration page.");

				
				click_element(
						"//*[@class='packages-list']/li[2]/div/div[4]/a[1]",
						driver);
				Thread.sleep(8000);
				}
				else if(url.equals("http://beta01.twcable.com:4503/residential/order"))
				{
					logger.info("beta url=" +url);
					click_element(
							".//*[@class='next']",
							driver);
					Thread.sleep(3000);
					if (Isavailable(
							".//*[@class='packages-list']/li[9]/div/div[1]",
							driver))
						statusTracker(br, 
								"Pass",
								"Select the package click on the \"Order No\"",
								"User is navigated to the TV Configuration page. (TV Select a plan page is skipped)",
								"User must be navigated to the TV Configuration page.");
					else
						statusTracker(br, 
								"Fail",
								"Select the package click on the \"Order No\"",
								"User is NOT navigated to the TV Configuration page. (TV Select a plan page is NOT skipped)",
								"User must be navigated to the TV Configuration page.");
					Thread.sleep(3000);
					click_element(
							".//*[@class='packages-list']/li[9]/div/div[4]/a[1]/span",
							driver);
					logger.info("beta package selected");
				}
				Thread.sleep(3000);
				Page_Internet = "Page_2_select_plan_page_started";
				
				Thread.sleep(8000);

				if (return_text(
						"//*[@class='active']/span",
						driver).equals("TV")) {
					statusTracker(br, "Pass",
							"Validate the secondary progress bar",
							"TV is displayed in progress bar",
							"Secondary progress bar should display TV ");
				} else {
					statusTracker(br, "Fail",
							"Validate the secondary progress bar",
							"TV is not displayed in progress bar",
							"Secondary progress bar should display TV ");
				}

				Thread.sleep(10000);
				PackageAmount = Double.parseDouble(return_text(
						".//*[@class='charges']/table[1]/tbody/tr/td[2]",
						driver).replace("$", ""));

				if (return_text(
						".//*[@class='charges']/table[1]/tbody/tr/td[2]",
						driver).equals("$89.99")) {
					statusTracker(br, "Pass",
							"Validate the Package price displayed is correct",
							"Package price displayed is corrrect",
							"Package price should be displayed properly ");
				} else {

					statusTracker(br, "Fail",
							"Validate the Package price displayed is correct",
							"Package price displayed is not corrrect",
							"Package price should be displayed properly ");

				}
				Thread.sleep(3000);
				click_element(".//*[@class='js-next-button blue-button right']", driver);

				if (return_text(
						".//*[@class='sub-steps']/ul/li[2]/span",
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
				Thread.sleep(12000);

				if (isElementPresent(
						".//*[@class='text parbase currentCartHeader twc-plain-text']",
						driver)) {
					statusTracker(br, "Pass",
							"check current services module is present",
							"current services module is present",
							"current services module should display");
					Thread.sleep(6000);
					System.out
							.println("check the condition:"
									+ Isavailable(
											".//*[@class='miniCart']/div[1]/header/ul",
											driver));
					Thread.sleep(6000);


					
					if (isElementPresent(
							".//*[@class='miniCart']/div[1]/header",
							driver))

					{
						statusTracker(br, 
								"Pass",
								"check if The Current Services module is in the default close state ",
								"Current Services module is not in closed state by default",
								"Current Services module should be in closed state by default");
						logger.info(" Yes the list is expanded");
					} else {
						statusTracker(br, 
								"Fail",
								"check if The Current Services module is NOT in the default close state ",
								"Current Services module is NOT in closed state by default",
								"Current Services module should be in closed state by default");
						logger.info(" Yes the list is not expanded");
					}
					Thread.sleep(3000);
				}

				// Compare

				driver.findElement(By.linkText("Compare Internet Plans"))
						.click();
				Thread.sleep(4000);
				if (driver.findElement(By.xpath("//*[@class='modal-title']"))
						.isDisplayed()) {
					statusTracker(br, 
							"Pass",
							"Verify if a popup is displayed when clicking on compare internet plans",
							"Popup is displayed", "Popup should be displayed");
					click_CSS_Element("div.modal-button-close", driver);
					Thread.sleep(1000);
				}

				Page_Internet = "Page_2_select_plan_page_Passed";
				

				driver.findElement(
						By.xpath("//*[@data-enrichedname='Extreme']/li[5]/div/a"))
						.click();
				Thread.sleep(10000);
				System.out
						.println("End of second page and entering into third page-1");
				Page_Internet = "Page_3_config_page_started";
				

				try {
					Thread.sleep(2000);
					
					
					click_element("//*[@class='modal js-modal-initialized']",
							driver);
					Thread.sleep(4000);
					if (return_text("//*[@class='modal-title']", driver)
							.equalsIgnoreCase("Internet Plans at a Glance")) {
						statusTracker(br, "Pass",
								"Compare Internet plans is clicked",
								"compare Internet plans page is displayed",
								"Should be displayed");
					} else {
						statusTracker(br, "Fail",
								"Compare Internet plans is clicked",
								"compare Internet plans page is not displayed",
								"Should be displayed");
					}

					click_element("//*[@class='modal-button-close']", driver);
					Thread.sleep(4000);

					logger.info("started calling the phone config");
					Thread.sleep(10000);
					click_element(".//*[@class='charges']/div[1]/header/ul/li[1]/a",
							driver);
					
					config_page_Cart_result_updater_Internet_Package(br, driver);
					Thread.sleep(3000);
					page_Cart_One_Time_charge_updater_Package1(br, driver);
					Thread.sleep(3000);
					
					

					//to take screenshot and save in file
					Image_compare(br,env,Page_Phone,Overall_Path,screen_count,driver);
					screen_count++;
					/*screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
					targetFile = new File(Overall_Path +"//Test_Results//NewImages//"+ Page_Phone + screen_count + ".png");
					FileUtils.copyFile(screenshot, targetFile);		
					logger.info("copied file into New Images folder"+targetFile);
					
				
					Image_compare(br, env,Page_Phone,Overall_Path,screen_count);
					screen_count++;*/
					Thread.sleep(3000);
					if(url.equals("https://www.timewarnercable.com/residential/order"))
					{
					Package_I_will_use_my_modem(br, driver);
					Thread.sleep(3000);
					config_page_Cart_result_updater_Internet_Package(br, driver);
					Thread.sleep(3000);
					page_Cart_One_Time_charge_updater_Package1(br, driver);
					Thread.sleep(3000);

					//to take screenshot and save in file
					
					/*screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
					targetFile = new File(Overall_Path +"//Test_Results//NewImages//"+ Page_Phone + screen_count + ".png");
					FileUtils.copyFile(screenshot, targetFile);		
					logger.info("copied file into New Images folder"+targetFile);
					
				
					Image_compare(br, env,Page_Phone,Overall_Path,screen_count);
					screen_count++;*/
					}
					Thread.sleep(3000);
					Package_HomeWiFi_InternetModem(br, driver);
					Thread.sleep(3000);
					
					config_page_Cart_result_updater_Internet_Package(br, driver);
					Thread.sleep(3000);
					//Package_Validate_AlreadyIncludedServices("Home WiFi");
					Thread.sleep(3000);
					page_Cart_One_Time_charge_updater_Package1(br, driver);
					Thread.sleep(3000);

					//to take screenshot and save in file
					
					/*screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
					targetFile = new File(Overall_Path +"//Test_Results//NewImages//"+ Page_Phone + screen_count + ".png");
					FileUtils.copyFile(screenshot, targetFile);		
					logger.info("copied file into New Images folder"+targetFile);
					
				
					Image_compare(br, env,Page_Phone,Overall_Path,screen_count);
					screen_count++;*/
					
					

					driver.findElement(By.cssSelector("span.arrow")).click();

				} catch (Exception e) {
					logger.info("error is: " + e.getMessage());
					exceptionHandler(br, e, driver);

				}
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