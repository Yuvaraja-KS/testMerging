
//File Name: RT_Internet_011
//Author: RAVEENA    
//Description of test case: Upgrade Internet - current equipment compatible with offer
//Date of creation(D/M/Y): 3/19/2014
//Name and date(D/M/Y) of modification: RAHUL JADOW (6/6/2014)
//Modification description: No need to check both upgrade Internet, add equipment /  verify the Current service text on modem


package CRH_Internet;

import java.io.File;
import java.util.Locale;

import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RT_Internet_011 extends CommonFunctions {

	String table, tns[];
	String tlimit, username, pwd, ctotal, Uname, Tv_plan, Internet_plan,
			Phone_plan, current_service;
	int tncount;
	String serAddress, Internet_service, Tv_service, Phone_service,
			str_Browser;

	public RT_Internet_011() {
	}

	public RT_Internet_011(String s) {
		this.path = s;
		logger.info("Add Internet 011 is intialized");
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
			Page_Phone = "RT_Internet_011_";
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

			String tv_equipment = sheet2.getCell(Col_locator_full_scan_input_sheet("PHONE PLAN", path,Sheet_name), loc).getContents();
			String tv_equipment2 = sheet2.getCell(20, loc).getContents();
			String int_equipment = sheet2.getCell(18, loc).getContents();

			String phone_equipment = sheet2.getCell(19, loc).getContents();
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

				// Upgrading Internet - Boost your speed
				click_element(".//*[@value='upgrade_inet']", driver);
				Thread.sleep(8000);
				
				// Continue
				click_element(".//*[@class='arrow']", driver);
				Thread.sleep(8000);

				// validating Internet page
				logger.info("validating internet configuration page");
				if ((driver
						.findElement(
								By.xpath("//*[@id='content']/div[1]/div/ol/li[1]/div/div/span"))
						.getText().equalsIgnoreCase("1"))) {
					logger.info("Configuration page");
					statusTracker(br,driver, "Pass", "Configuration page",
							"Configuration page is present!!",
							"Configuration page should be present");
				} else {
					logger.info("fail1");
					statusTracker(br,driver, "Fail", "Configuration page not present",
							"Configuration page is  not present",
							"Configuration page should be present");
				}

				
				// validate secondary progress bar
				logger.info("validate secondary progress bar");
				if (Isavailable(".//*[@class='active']/span", driver)) 
				{
				statusTracker(br,driver, "Pass",
						"Validate the secondary progress bar",
						"The secondary progress bar present",
						"The secondary progress bar should be present");
			} 
				else 
				{
				statusTracker(br,driver, "Fail",
						"Validateed the secondary progress bar NOT present",
						"The secondary progress bar not present",
						"The secondary progress bar should be present");
			}

				
				// select
				click_element(
						"//*[@id='content']/div[3]/div[2]/div/div[2]/div[1]/div[2]/div/div/div/div[1]/header/ul/li[5]/div/a",
						driver);
				Thread.sleep(14000);

				String CurrSer = driver.findElement(
						By.xpath("//*[@class='price last']/sup")).getText();
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

				Thread.sleep(4000);

				// validate new services cart!!

				// new services equip
				if ((driver
						.findElement(
								By.xpath("//*[@class='newCartHeader text parbase twc-plain-text']"))
						.getText().equalsIgnoreCase("New Services"))) {
					logger.info("New Services Content present!!");
					statusTracker(br,driver, "Pass", "New Services Content present!!!",
							"New Services Content present!!!",
							"New Services Content present!!!");
				} else {
					logger.info("fail1");
					statusTracker(br,driver, "Fail", "New Services Content not present!!",
							"New Services Content is  not present!!",
							"New Services Content should be present");
				}

				// Monthly charges
				if ((driver
						.findElement(
								By.xpath("//*[@class='text parbase twc-plain-text firstHeader']"))
						.getText().equalsIgnoreCase("Monthly Charges"))) {
					statusTracker(br,driver, "Pass", "Monthly charges present",
							"Monthly charges present",
							"Monthly charges should be present");
				}

				else {
					logger.info("Fail");
					statusTracker(br,driver, "Fail", "Monthly charges NOT present",
							"Monthly charges NOT present",
							"Monthly charges should be present");
				}

				// Validating monthly total
				logger.info("Validating monthly total");
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

				// validating sequence of LOB under current services
				click_element(".//*[@class='miniCart']/div/header/ul/li[2]/a",
						driver);
				Thread.sleep(2000);
				String CurrSer1 = driver
						.findElement(
								By.xpath(".//*[@class='miniCart']/div/section/div[1]/header/ul/li[2]/h6"))
						.getText();
				System.out
						.println("currSer1...................................."
								+ CurrSer1);


				Thread.sleep(4000);
				if ((CurrSer1.equalsIgnoreCase("Internet")))
					{
						logger.info("right sequence!!");
						statusTracker(br,driver, "Pass",
								"current sequence matches Internet",
								"Sequence matches", "Sequence should match");
					} else {
						logger.info("wrong sequence!!");
						statusTracker(br,driver, "Fail",
								"current sequence matches Internet",
								"Sequence does not match",
								"Sequence should match");

					}

				// Internet
				click_element(
						".//*[@class='miniCart']/div/section/div[1]/header/ul/li[2]/h6",
						driver);
				Thread.sleep(4000);

				String TvPl = driver
						.findElement(
								By.xpath(".//*[@class='miniCart']/div/section/div[1]/section/div/ul/li[1]"))
						.getText();

				Thread.sleep(2000);
				String TvEqui1 = driver
						.findElement(
								By.xpath(".//*[@class='miniCart']/div/section/div[1]/section/div/ul/li[2]"))
						.getText();
				Thread.sleep(2000);
				logger.info("tv equip:" + TvEqui1 + " \n" );

				
				// Internet
				click_element(
						".//*[@class='miniCart']/div/section/div[1]/header/ul/li[2]/h6",
						driver);
				Thread.sleep(2000);

				//Close current services
				click_element(".//*[@class='miniCart']/div/header/ul/li[2]/a",
						driver);
				Thread.sleep(8000);

				String confMesg = driver.findElement(
						By.xpath("//*[@class='rtf']/p[1]")).getText();

				if ((confMesg.trim()
						.equalsIgnoreCase("Your plan includes one outlet and requires a modem for Internet service."))) {

					logger.info(" configuration page is displayed!!");
					statusTracker(br,driver, "Pass", "configuration page is displayed!!",
							"configuration page is displayed!! matches",
							"configuration page is displayed!! should match");

				} else {
					System.out
							.println(" configuration page is not displayed!!");
					statusTracker(br,driver, "Fail",
							"configuration page is not displayed!!",
							"configuration page is displayed!! matches",
							"configuration page is displayed!! should match");

				}

				// open compare equipment link
				click_element(".//*[@title='Compare Internet Plans']", driver);

				if ((driver.findElement(
						By.xpath(".//*[@class='modal-title-wrapper']"))
						.getText()
						.equalsIgnoreCase("Equipment by Internet Plan")))

					if ((driver
							.findElement(
									By.xpath("//*[@class='text row0col0 parbase compTableText checkBoxCol1Text']"))
							.getText()
							.equalsIgnoreCase("Internet Modem with Free Home WiFi")))

					{
						System.out
								.println(" compare equipment page is displayed");
						statusTracker(br,driver, 
								"Pass",
								" compare equipment page is displayed!!",
								" compare equipment page is displayed!! matches",
								" compare equipment page is displayed!! should match");

					} else {
						System.out
								.println(" compare equipment page is not displayed");
						statusTracker(br,driver, "Fail",
								" compare equipment page is not displayed",
								" compare equipment page is displayed matches",
								" compare equipment page is displayed should match");

					}

				click_element(".//*[@class='modal-button-close']", driver);

				
				
				if ((driver
						.findElement(
								By.xpath("//*[@id='js-main-form']/div[2]/div[1]/header/ul/li[2]/h3"))
						.getText().equalsIgnoreCase("Internet Modem")))

					if ((driver
							.findElement(
									By.xpath("//*[@id='js-main-form']/div[2]/div[2]/header/ul/li[2]/h3"))
							.getText()
							.equalsIgnoreCase("Internet Modem with Free Home WiFi")))
					{
							System.out
									.println("right sequence and pattern of default view");
							statusTracker(br,driver, 
									"Pass",
									"right sequence and pattern of default view",
									"Sequence matches", "Sequence should match");
						} 
					else {
							logger.info("wrong sequence!!");
							statusTracker(br,driver, 
									"Fail",
									"right sequence and pattern of default view does not match",
									"Sequence does not match",
									"Sequence should match");
						}
				Thread.sleep(4000);
				
				
				// validate whether default equipment is selected!!
				logger.info("validate whether default equipment!!");

				// validating current equipment
				logger.info("current equipment " + tv_equipment);
				
				//Current services should display
				if ((driver
						.findElement(
								By.xpath(".//*[@id='js-main-form']/div[2]/div[1]/header/ul/li[3]/em"))
						.getText()
						.equalsIgnoreCase("Current Service")))
				{
					System.out
							.println("Current Service is displayed");
					statusTracker(br,driver, 
							"Pass",
							"Current Service is displayed",
							"Current Service page is displayed matches",
							"Current Servicee is displayed should match");
				} else {
					System.out
							.println("Current Service is not displayed");
					statusTracker(br,driver, "Fail",
							"Current Service is not displayed",
							"Current Service is displayed matches",
							"Current Service is displayed should match");
				}

				// validating on clicking dropdown of each equipment, more info can be seen
				System.out
						.println("validating on clicking dropdown of each equipment, more info can be seen!!");
				Thread.sleep(4000);

				click_element(
						"//*[@id='js-main-form']/div[2]/div[1]/header/ul/li[1]/a",
						driver);
				Thread.sleep(4000);
				String str1 = driver
						.findElement(
								By.xpath(".//*[@class='modem-options']/div[1]/section/div/div/div/ul/li[1]"))
						.getText();
				Thread.sleep(4000);
				logger.info(" Text in Equipment1...." + str1);

				if (str1.equalsIgnoreCase("A secure, reliable high-speed connection")) {

					logger.info("Right content in Equipment1!!");
					statusTracker(br,driver, "Pass", "Right content in Equipment1",
							"Right content in Equipment1",
							"Right content in Equipment1 should match");
				} else {

					logger.info("Wrong content in Equipment1!!");
					statusTracker(br,driver, "Fail", "wrong content in Equipment1",
							"wrong content in Equipment1",
							"Right content in Equipment1 should match");

				}

				click_element(
						"//*[@id='js-main-form']/div[2]/div[2]/header/ul/li[1]/a",
						driver);

				String str2 = driver
						.findElement(
								By.xpath(".//*[@class='modem-options']/div[2]/section/div/div/div/p[1]"))
						.getText();
				logger.info(" Text in Equipment2...." + str2);

				if (str2.equalsIgnoreCase("Work, surf and play in any room. Ideal for homes with multiple devices that need a fast, wireless Internet home network. Connect computers, tablets, smartphones and other WiFi-enabled devices.")) {

					logger.info("Right content in Equipment2!!");
					statusTracker(br,driver, "Pass", "Right content in Equipment2",
							"Right content in Equipment2",
							"Right content in Equipment2 should match");
				} else {

					logger.info("Wrong content in Equipment2!!");
					statusTracker(br,driver, "Fail", "wrong content in Equipment2",
							"wrong content in Equipment2",
							"Right content in Equipment2 should match");

				}

				
				// close all dropdowns
				click_element(
						"//*[@id='js-main-form']/div[2]/div[2]/header/ul/li[1]/a",
						driver);

				click_element(
						"//*[@id='js-main-form']/div[2]/div[1]/header/ul/li[1]/a",
						driver);

				// Click continue
				click_element(
						".//*[@class='js-next-button blue-button']",
						driver);
				Thread.sleep(10000);

				
				//validate display of review order page
				   if(return_text(".//*[@class='left']/h2", driver).equalsIgnoreCase("Choose Installation & Review Order"))
					{statusTracker(br,driver, "Pass", "User finishes the LOS configuration and selects the continue CTA",
							"User is displayed with Review order page" , "User should be displayed with Review order page");
					}
					else
					{statusTracker(br,driver, "Fail", "User finishes the LOS configuration and selects the continue CTA",
							"User is displayed with Review order page" , "User should be displayed with Review order page");
					}
				  
	   
				//Sign out   
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
			}

			catch (Exception e) {
				exceptionHandler(br, e, driver);

			}
		} finally {
			wb.close();
			// wb1.close();
			driver.close();

		}

	
	}

	
}
