 
//File Name: RT_Package_007
//Author: Raveena
//Description of test case: Upgrade Internet - current equipment compatible with offer
//Date of creation(D/M/Y): 11/3/2014
//Name and date(D/M/Y) of modification: Raveena Singh  6/6/2014
//Modification description:  Code Cleanup and xpath unique property updation
//Name and date(D/M/Y) of modification: Rahul Jadow  18/6/2014
//Modification description:  Changed the appropriate package / compare equipment link xpaths updated / validating current services text / Validating Mini cart /  RO page and Signout
//Name and date(D/M/Y) of modification: RAHUL JADOW  (66/6/2014)
//Modification description:  Packages name changes and few failures fixed  

package CRH_EBF_Packages;

import java.io.File;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;

import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RT_Package_007 extends CommonFunctions {

	String table, tns[];
	String tlimit, username, pwd, ctotal, Uname, Tv_plan, Internet_plan,
			Phone_plan, current_service;
	int tncount;
	String serAddress, Internet_service, Tv_service, Phone_service,
			str_Browser;

	public RT_Package_007() {
	}

	public RT_Package_007(String s) {
		this.path = s;
		logger.info("View all Package 007 is intialized");
	}

	public RT_Package_007(String s, String t, String p, String i,
			String packages) {
		this.path = s;
		this.path1 = t;
		this.path2 = p;
		this.path3 = packages;
		this.path4 = i;

	}

	public void execute(String br, WebDriver driver, String url, int loc,String Overall_Path,String env) throws Exception {
		int screen_count = 1;
		Page_Phone = "RT_Package_007_";
		File data = new File(this.path);
		WorkbookSettings ws = new WorkbookSettings();
		ws.setLocale(new Locale("er", "ER"));
		
		Workbook wb = Workbook.getWorkbook(data, ws);
		Sheet sheet2 = wb.getSheet("Packages");
		String Sheet_name = sheet2.getName();
		try {
			String tv = "", inet = "", phone = "";

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
			int choice = 0;
			int tlim = Integer.parseInt(tlimit);
			tlim *= 60;
			tlimit = Integer.toString(tlim);
			tlimit = tlimit + "000";*/
			Page_TV = " Page_1_Current Service ";
			// manju variable
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

//to take screenshot and save in file
				Image_compare(br,env,Page_Phone,Overall_Path,screen_count,driver);
				screen_count++;
				/* File /*screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				File targetFile = new File(Overall_Path +"//Test_Results//NewImages//"+ Page_Phone + screen_count + ".png");
				FileUtils.copyFile(screenshot, targetFile);		
				logger.info("copied file into New Images folder"+targetFile);
				
			
				Image_compare(br, env,Page_Phone,Overall_Path,screen_count);
				screen_count++;*/
				
				//View all packages
				driver.findElement(
						By.xpath("//*[@class='js-next-button blue-button center']"))
						.click();
				Thread.sleep(8000);

				//Select & Order
				if (driver
						.findElement(
								By.xpath(".//*[@class='directions text parbase twc-plain-text']"))
						.getText().equalsIgnoreCase("Select two or more services:"))
					
                //Explore more packages
					if (driver
							.findElement(
									By.xpath("//*[@class='text parbase twc-plain-text heading']"))
							.getText()
							.equalsIgnoreCase("Explore more packages")) {
						logger.info("View pkgs page opens!!");
						statusTracker(br, "Pass", "View pkgs page opens!!",
								"View pkgs page opens!!",
								"View pkgs page open should open! ");
					} else {
						logger.info("View pkgs page does not open!!");
						statusTracker(br, "Fail", "View pkgs page does not open!!",
								"View pkgs page does not open!!",
								"View pkgs page open should open! ");

					}
				
				

				// user checks the available checkboxes
				if ((driver.findElement(By
						.xpath(".//*[@class='filter-options']/ul/li/input"))
						.isDisplayed())
						&& ((driver
								.findElement(
										By.xpath("//*[@for='tv-filter']"))
								.getText().equalsIgnoreCase("TV"))))

					if (driver.findElement(
							By.xpath("//*[@id='internet-filter']"))
							.isDisplayed()
							&& ((driver
									.findElement(
											By.xpath("//*[@for='internet-filter']"))
									.getText().equalsIgnoreCase("Internet"))))

						if (driver.findElement(
								By.xpath("//*[@id='phone-filter']"))
								.isDisplayed()
								&& ((driver
										.findElement(
												By.xpath("//*[@for='phone-filter']"))
										.getText().equalsIgnoreCase("Phone"))))

							if (driver.findElement(
									By.xpath("//*[@id='show-all-filter']"))
									.isDisplayed()
									&& ((driver
											.findElement(
													By.xpath("//*[@for='show-all-filter']"))
											.getText()
											.equalsIgnoreCase("All Packages")))) {
								System.out
										.println("The user has four (4) check boxes that can be selected in the Offer type Filter.!!");
								statusTracker(br, 
										"Pass",
										"The user has four (4) check boxes that can be selected in the Offer type Filter.!!",
										"(4) check boxes present!!",
										"(4) check boxes should be present! ");
							} else {
								System.out
										.println("The user does not have four (4) check boxes that can be selected in the Offer type Filter.!!");
								statusTracker(br, 
										"Pass",
										"The user  does not have four (4) check boxes that can be selected in the Offer type Filter.!!",
										"(4) check boxes not present!!",
										"(4) check boxes should be present! ");

							}
				Thread.sleep(6000);
				
				
				// validating double and triple plays - Selected TV + Internet
				/*int flag1 = 0;
				int flag2 = 0;
				int j, i = 2;
				String str;
				while (flag1 == 0 && flag2 == 0) {
					for (j = 0; j < 3; j++) {

						str = driver.findElement(
								By.xpath("//*[@class='packages-list']/li[" + i
										+ "]/div/div[1]")).getText();

						if (str.equalsIgnoreCase("TV + Internet + Phone")
								|| (str.equalsIgnoreCase("TV + Phone")))
							flag1 = 1;

						if (str.equalsIgnoreCase("TV + Internet"))
							flag2 = 1;

						if (flag1 == 1 && flag2 == 1)
							break;
						i++;
					}
					//click_element(".//*[@class='next']",driver);
				}
*/
				logger.info("It found double and triple play!!");

				statusTracker(br, "Pass", "It found double and triple play!!!!",
						" It found double and triple play present!!",
						" It should find double and triple play!! ");

				Thread.sleep(6000);
/*
				while (driver
						.findElement(
								By.xpath("//*[@class='packages-list']/li[9]/div/div[1]"))
						.isDisplayed() == false) {
					System.out
							.println("enters while.............................");
					driver.findElement(
							By.xpath(".//*[@class='next']"))
							.click();
				}*/
				driver.findElement(
						By.xpath(".//*[@class='next']"))
						.click();

				Thread.sleep(6000);

				
				if (driver
						.findElement(
								By.xpath(".//*[@class='packages-list']/li[9]/div/div[1]"))
						.getText().equalsIgnoreCase("TV + Internet"))

				{

					// order now
					driver.findElement(
							By.xpath(".//*[@class='packages-list']/li[9]/div/div[4]/a[1]"))
							.click();

					Thread.sleep(6000);

					
					statusTracker(br, "Pass",
							"The user has selected TV + Internet!!",
							"The user has selected TV + Internet!!",
							"The user has selected TV + Internet should be present! ");
				} else {
					statusTracker(br, "Fail",
							"The user has not selected TV+ Internet!!",
							"The user has not selected TV + Internet!!",
							"The user should have selected TV + Internet should be present! ");

				}
				Thread.sleep(6000);
				//Select continue TV equipment
				driver.findElement(
						By.xpath("//*[@class='js-next-button blue-button right']"))
						.click();
				Thread.sleep(6000);
				
				// Current services is closed and displays only monthly total
				System.out
						.println("Current services is closed and displays only monthly total");

				String CurrSer = driver
						.findElement(
								By.xpath(".//*[@class='price last']/sup"))
						.getText();
				logger.info("price is");
				logger.info(CurrSer);
				logger.info("Testing............................01");
				String strfind = "$";
				int iSuccess = CurrSer.indexOf(strfind);
				logger.info("",iSuccess);

				if (iSuccess < 0) {
					logger.info("price is not present");
					statusTracker(br, 
							"Fail",
							"$ sign present in current service monthly charges",
							"$ not present", "$ should be present");
				}

				else {
					logger.info("$ present");
					statusTracker(br, 
							"Pass",
							"$ sign present in current service monthly charges",
							"$ present", "$ should be present");
				}

				int iStartAmount = iSuccess + 1;
				String per = " ";

				int iSpace = CurrSer.indexOf(per);
				int iEndAmount = iSpace - 1;
				logger.info("",iSpace);

				String sAmount = CurrSer.substring(1, CurrSer.length());
				logger.info("s amount" + sAmount);

				if (sAmount.equals(ctotal)) {
					logger.info("Pass");
					statusTracker(br, 
							"Pass",
							"current service monthly charges should match as per the user",
							"Amount matches", "Amount should match");
				}

				else {
					logger.info("Fail");
					statusTracker(br, 
							"Fail",
							"current service monthly charges should match as per the user",
							"Amount doesnt match", "Amount should match");
				}
				
				
				// Current services dropdown
				click_element(
						".//*[@class='miniCart']/div[1]/header/ul/li[2]/a",
						driver);

				logger.info(" price read!");

				// validating sequence of LOB under current services
				String CurrSer1 = driver
						.findElement(
								By.xpath(".//*[@class='miniCart']/div[1]/section/div[1]/header/ul/li[2]/h6"))
						.getText();
				if ((CurrSer1.equalsIgnoreCase("Internet"))) {
					logger.info("current services matches Internet");
					statusTracker(br, "Pass",
							"current services matches Internet",
							"current services matches Internet", "current services should match Internet");
				} else {
					logger.info("wrong sequence!!");
					statusTracker(br, "Fail",
							"current services matches does not display Internet",
							"current services matches does not display Internet", "current services should match Internet");

				}
				
				//validating minicart with modem
				click_element(".//*[@class='miniCart']/div[1]/section/div[1]/header/ul/li[1]/a", driver);
				Thread.sleep(4000);
				if(return_text(".//*[@class='miniCart']/div[1]/section/div[1]/section/div/ul/li[2]", driver).trim().equalsIgnoreCase("TWC Modem"))
				{
					statusTracker(br, "Pass", "Validating TWC Modem is displayed in minicart", "TWC Modem is displayed in minicart", "TWC Modem should be displayed in minicart");
				}
				else
				{
						statusTracker(br, "Fail", "Validating TWC Modem is displayed in minicart", "TWC Modem is NOT displayed in minicart", "TWC Modem should be displayed in minicart");
				}	
				System.out
						.println("valid sequence of LOB under current services");
				
		
			//	JavascriptExecutor executor = (JavascriptExecutor)driver;
			//	executor.executeScript(findElement(By.xpath(".//*[@title='Compare Internet Plans']")).click());
					
				// open compare equipment link
				click_element(".//*[@title='Compare Internet Plans']", driver);

				if ((driver
						.findElement(
								By.xpath(".//*[@class='modal-title']"))
						.getText()
						.equalsIgnoreCase("Internet Plans at a Glance")))

					if ((driver
							.findElement(
									By.xpath("//*[@class='text row0col0 parbase compTableText checkBoxCol1Text']"))
							.getText()
							.equalsIgnoreCase("Download Speeds")))

					{
						System.out
								.println("compare equipment page is displayed!!");
						statusTracker(br, 
								"Pass",
								" compare equipment page is displayed!!",
								" compare equipment page is displayed!! matches",
								" compare equipment page is displayed!! should match");

					} else {
						System.out
								.println("compare equipment page is not displayed!!");
						statusTracker(br, 
								"Fail",
								" compare equipment page is not displayed!!",
								" compare equipment page is displayed!! matches",
								" compare equipment page is displayed!! should match");

					}

				// closed compare equipment
				click_element(
						".//*[@class='modal-button-close']",
						driver);
				Thread.sleep(6000);
				
				

				// validating secondary progress bar!
				logger.info("validating secondary progress bar!");

				if (driver.findElement(By.xpath("//*[@class='sub-steps']"))
						.isDisplayed())

					if (driver
							.findElement(
									By.xpath("//*[@class='sub-steps']/ul/li[1]/span"))
							.getText().equalsIgnoreCase("TV"))
						if (driver
								.findElement(
										By.xpath("//*[@class='active']/span"))
								.getText().equalsIgnoreCase("Internet")) {
							System.out
									.println("All LOBs are present in correct order!");
							statusTracker(br, "Pass",
									"All LOBs are present in correct order!!!",
									"All LOBs are present in correct order!!!",
									"All LOBs are present in correct order should be present! ");

						}

						else {

							System.out
									.println("All LOBs are not present in correct order!");
							statusTracker(br, 
									"Fail",
									"All LOBs are not present in correct order!!!",
									"All LOBs are present in correct order!!!",
									"All LOBs are present in correct order should be present! ");

						}

				// validating equipment ranking
			/*	if ((driver
						.findElement(
								By.xpath("//*[@class='modem-options']/div[1]/header/ul/li[2]/h3"))
						.getText().equalsIgnoreCase("Internet Modem"))
						&& (driver
								.findElement(
										By.xpath("//*[@class='modem-options']/div[1]/header/ul/li[3]/sup[1]"))
								.getText().equalsIgnoreCase("$"))
						&& (driver
								.findElement(
										By.xpath("//*[@class='modem-options']/div[1]/header/ul/li[3]/span"))
								.getText().equalsIgnoreCase("per Month")))

					if ((driver
							.findElement(
									By.xpath("//*[@class='modem-options']/div[2]/header/ul/li[2]/h3"))
							.getText()
							.equalsIgnoreCase("Home WiFi and Internet Modem")))
						if ((driver
								.findElement(
										By.xpath("//*[@class='modem-options']/div[3]/header/ul/li[2]/h3"))
								.getText()
								.equalsIgnoreCase("I'll use my own modem"))) {

							System.out
									.println(" right sequence and pattern of default view!!");
							statusTracker(br, 
									"Pass",
									"right sequence and pattern of default view",
									"Sequence matches", "Sequence should match");
						} else {
							logger.info("wrong sequence!!");
							statusTracker(br, 
									"Fail",
									"right sequence and pattern of default view does not match",
									"Sequence does not match",
									"Sequence should match");

						}
				*/
				//Select Ultimate
				driver.findElement(
						By.xpath("//*[@data-enrichedname='Ultimate 50']/li[5]/div/a"))
						.click();
				System.out
				.println("Upgrading the Intenet Plan...................................");
				Thread.sleep(6000);

				
				//validating current services text 
				if(return_text("//*[@class='modem-options']/div[1]/header/ul/li[2]/h3", driver).trim().equalsIgnoreCase("Internet Modem"))
					if(Isavailable(".//*[@class='modem-options']/div[1]/header/ul/li[3]/em", driver))
						if(return_text(".//*[@class='modem-options']/div[1]/header/ul/li[3]/em", driver).trim().equalsIgnoreCase("Current Service"))
					{
						statusTracker(br, "Pass", "Validating Current service Text displayed corresponding to Current Service Modem", "Current service Text displayed corresponding to Current Service Modem", "Current service Text should be displayed corresponding to Current Service Modem");
					}
						else
					{
						statusTracker(br, "Fail", "Validating Current service Text displayed corresponding to Current Service Modem", "Current service Text NOT displayed corresponding to Current Service Modem", "Current service Text should be displayed corresponding to Current Service Modem");
						
					}
				
				
				// validating content of each equipment
				click_element(
						"//*[@class='modem-options']/div[1]/header/ul/li[1]/a",
						driver);
				Thread.sleep(4000);
				String str1 = driver
						.findElement(
								By.xpath("//*[@class='modem-options']/div[1]/section/div/div[2]/div/ul/li[1]"))
						.getText();
				Thread.sleep(4000);
				logger.info(" Text in Equipment1...." + str1);

				if (str1.equalsIgnoreCase("A secure, reliable high-speed connection")) {

					logger.info("Right content in Equipment1!!");
					statusTracker(br, "Pass", "Right content in Equipment1",
							"Right content in Equipment1",
							"Right content in Equipment1 should match");
				} else {

					logger.info("Wrong content in Equipment1!!");
					statusTracker(br, "Fail", "wrong content in Equipment1",
							"wrong content in Equipment1",
							"Right content in Equipment1 should match");

				}
				Thread.sleep(6000);
				
//to take screenshot and save in file
				Image_compare(br,env,Page_Phone,Overall_Path,screen_count,driver);
				screen_count++;
				/*screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				targetFile = new File(Overall_Path +"//Test_Results//NewImages//"+ Page_Phone + screen_count + ".png");
				FileUtils.copyFile(screenshot, targetFile);		
				logger.info("copied file into New Images folder"+targetFile);
				
			
				Image_compare(br, env,Page_Phone,Overall_Path,screen_count);
				screen_count++;*/
				
				//Internet Modem with Free Home WiFi 
				click_element(
						"//*[@class='modem-options']/div[2]/header/ul/li[1]/a",
						driver);

				String str2 = driver
						.findElement(
								By.xpath("//*[@class='modem-options']/div[2]/section/div/div[2]/div/p[1]"))
						.getText();
				logger.info(" Text in Equipment2...." + str2);

				if (str2.equalsIgnoreCase("Work, surf and play in any room. Ideal for homes with multiple devices that need a fast, wireless Internet home network. Connect computers, tablets, smartphones and other WiFi-enabled devices.")) {

					logger.info("Right content in Equipment2!!");
					statusTracker(br, "Pass", "Right content in Equipment2",
							"Right content in Equipment2",
							"Right content in Equipment2 should match");
				} else {

					logger.info("Wrong content in Equipment2!!");
					statusTracker(br, "Fail", "wrong content in Equipment2",
							"wrong content in Equipment2",
							"Right content in Equipment2 should match");

				}
				Thread.sleep(5000);

	
				
				// close all dropdowns
				click_element(
						"//*[@class='modem-options']/div[2]/header/ul/li[1]/a",
						driver);

				click_element(
						"//*[@class='modem-options']/div[1]/header/ul/li[1]/a",
						driver);
				
				//Valadate Mini cart
				config_page_Cart_result_updater_Internet_Package_TV_Internet(br, driver);
				Thread.sleep(5000);
				
				//Continue
				click_element(
						"//*[@class='js-next-button blue-button right']",
						driver);
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
				logger.info("error is : " + e.getMessage());
			}
		} catch (Exception e) {
			exceptionHandler(br, e, driver);

		} finally {
			wb.close();
			// wb1.close();
			driver.close();

		}
	}

}
