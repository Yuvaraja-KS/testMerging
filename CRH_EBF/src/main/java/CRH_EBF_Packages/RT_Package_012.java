
 
//File Name: RT_Package_012
//Author: Pradeep
//Description of test case: Upgrade Phone - User selects a package that includes Phone (do not display LOS selections) 
//Date of creation(D/M/Y): 11/3/2014
//Name and date(D/M/Y) of modification: Raveena Singh  6/6/2014
//Modification description: Code Cleanup and xpath unique property updation
//Name and date(D/M/Y) of modification: Rahul Jadow  (19/6/2014)
//Modification description: Package update / Code Cleanup / Order now, Additional Equipment, Compare Plans, Mini cart updates / RO & Sign out 


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

public class RT_Package_012 extends CommonFunctions {

	String table, tns[];
	String tlimit, username, pwd, ctotal, Uname, Tv_plan, Internet_plan,
			Phone_plan, current_service;
	int tncount;
	String serAddress, Internet_service, Tv_service, Phone_service;
	 String str1,TV,Internet,Phone,cost;
	public RT_Package_012() {
	}

	public RT_Package_012(String s) {
		this.path = s;
		logger.info("View all packages 12 is intialized");
	}

	public RT_Package_012(String s, String t, String p, String i,
			String packages) {
		this.path = s;
		this.path1 = t;
		this.path2 = p;
		this.path3 = packages;
		this.path4 = i;

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
		
		logger.info("chheck1");
		Workbook wb = Workbook.getWorkbook(data, ws);
		Sheet sheet2 = wb.getSheet("Packages");
		String Sheet_name = sheet2.getName();
		try {
			String tv = "", inet = "", phone = "";

		
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
			Page_Phone = "RT_Package_012_";
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
				
				// User clicks on “View All Packages” link on Your Services page
				click_element(
						"//*[@class='js-next-button blue-button center']",
						driver);
				Thread.sleep(25000);

				
				//Explore All Packages
				if (return_text(
						".//*[@class='text parbase twc-plain-text heading']",
						driver).trim().equals("Explore more packages"))
					statusTracker(br,"Pass", "Explore more packages text is present on packages landing page",
							"Explore more packages text is present on packages landing page",
							"Explore more packages text should be present on packages landing page");
				else
					statusTracker(br,
							"Fail",
							"Explore more packages text is NOT present on packages landing page",
							"Explore more packages text is NOT present on packages landing page",
							"Explore more packages text should be present on packages landing page");

				
				
				// Validate if User can see all the Offer type Filter
				String CurrSer1 = driver
						.findElement(
								By.xpath("//*[@for='tv-filter']"))
						.getText();
				String CurrSer2 = driver
						.findElement(
								By.xpath("//*[@for='internet-filter']"))
						.getText();
				String CurrSer3 = driver
						.findElement(
								By.xpath("//*[@for='phone-filter']"))
						.getText();
				String CurrSer4 = driver
						.findElement(
								By.xpath("//*[@id='show-all-filter']"))
						.getText();
				if ((CurrSer1.equalsIgnoreCase("TV")))
					if ((CurrSer2.equalsIgnoreCase("Internet")))
						if ((CurrSer3.equalsIgnoreCase("Phone")))
							if ((CurrSer4.equalsIgnoreCase("All Packages")))

							{
								System.out
										.println("User can see all the Offer type Filter");
								statusTracker(br,
										"Pass",
										"User can see all the Offer type Filter",
										"User is able to view Offer type Filter",
										"User should be able to view Offer type Filter");
							} else {
								System.out
										.println("User can not see all the Offer type Filter");
								statusTracker(br,
										"Fail",
										"User cannot see all the Offer type Filter",
										"User is not able to view Offer type Filter",
										"User should be able to view Offer type Filter");
							}
				Thread.sleep(9000);

				// Verify LOS selection options available must follow regional eligibility and service ability rules.
				

				// Validate if user selects two or more services

				click_element(".//*[@id='tv-filter']", driver);
				Thread.sleep(3000);
				click_element(".//*[@id='internet-filter']", driver);
				Thread.sleep(3000);
				click_element(".//*[@id='phone-filter']", driver);
				Thread.sleep(6000);
	
				
				// Verify if all three LOB’s will be unchecked. Show all can display Triple or Double plays. Rankings will be regionally
				// configurable.
				click_element(".//*[@id='show-all-filter']", driver);
				Thread.sleep(2000);

//to take screenshot and save in file
				Image_compare(br,env,Page_Phone,Overall_Path,screen_count,driver);
				screen_count++;
				/*screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				targetFile = new File(Overall_Path +"//Test_Results//NewImages//"+ Page_Phone + screen_count + ".png");
				FileUtils.copyFile(screenshot, targetFile);		
				logger.info("copied file into New Images folder"+targetFile);
				
			
				Image_compare(br, env,Page_Phone,Overall_Path,screen_count);
				screen_count++;*/
				
				int flag1 = 0;
				int flag2 = 0;
				int j, i = 3;
				String str;
				while (flag1 == 0 && flag2 == 0) {
					for (j = 0; j < 3; j++) {

						str = driver.findElement(
								By.xpath("//*[@class='packages-list']/li[" + i
										+ "]/div/div[1]")).getText();
						if (str.equalsIgnoreCase("TV + Internet + Phone")
								|| (str.equalsIgnoreCase("TV + Phone")))
							flag1 = 1;

						if (str.equalsIgnoreCase("TV + Internet + Phone"))
							flag2 = 1;
							logger.info("str"+ str);
						if (flag1 == 1 && flag2 == 1)
							break;
						i++;
					}
				//	click_element(		".//*[@class='next']",							driver);
				}
				logger.info("It found double and triple play!!");

				statusTracker(br,"Pass", "It found double and triple play!!!!",
						"(4) It found double and triple play present!!",
						"(4) It should find double and triple play!! ");
				
				// Verify User has selected a bundle with Phone LOB.
				while (driver
						.findElement(
								By.xpath("//*[@class='packages-list']/li[6]/div/div[1]"))
						.isDisplayed() == false) {
					System.out
							.println("enters while.............................");
				//	driver.findElement(	By.xpath(".//*[@class='next']")).click();
				}
				
				String str1= driver
						.findElement(
								By.xpath(".//*[@class='packages-list']/li[6]/div/div[1]"))
						.getText();
				logger.info("String package "+ str1);
				TV=driver
						.findElement(
								By.xpath(".//*[@class='packages-list']/li[6]/div/ul/li[1]/h5"))
						.getText();
				Internet=driver
						.findElement(
								By.xpath(".//*[@class='packages-list']/li[6]/div/ul/li[2]/h5"))
						.getText();
				Phone=driver
						.findElement(
								By.xpath(".//*[@class='packages-list']/li[6]/div/ul/li[3]/h5"))
						.getText();
                cost=driver
						.findElement(
								By.xpath(".//*[@class='packages-list']/li[6]/div/div[2]/div"))
						.getText();
				Package_service_check(br, driver, "RT_package_012",str1,TV,Internet,Phone,cost);
				Thread.sleep(3000);
				// order now
				if (driver
						.findElement(
								By.xpath("//*[@class='packages-list']/li[6]/div/div[1]"))
						.getText().equalsIgnoreCase("TV + Internet + Phone")) {
					driver.findElement(
							By.xpath("//*[@class='packages-list']/li[6]/div/div[4]/a[1]/span"))
							.click();
					Thread.sleep(8000);
					statusTracker(br,"Pass",
							"The user has selected Best Triple Play with Ultimate",
							"The user has selected Best Triple Play with Ultimate",
							"The user has selected Best Triple Play with Ultimate");
				} else {
					statusTracker(br,"Fail",
							"The user has not selected Best Triple Play with Ultimate",
							"The user has not selected Best Triple Play with Ultimate",
							"The user should have selected Best Triple Play with Ultimate");
				}
				

				// TV Continue
				
			
				
				//Additional Equipment 
				Thread.sleep(6000);
				driver.findElement(
						By.xpath(".//*[@class='tv-equipment']/form/div[2]/header/ul/li[1]/a"))
						.click();

				if (driver
						.findElement(
								By.xpath("//*[@class='boxes']/li[1]/div[3]/div/div/select"))
						.isDisplayed())
				{
					logger.info("Select dropdown is present!!");
					statusTracker(br,"Pass", "  Select dropdown is present",
							" Match", " Select dropdown is present");
				} else {
					logger.info("Select dropdown is  not present!!");
					statusTracker(br,"Fail", " Select dropdown is  not present",
							"does not Match",
							"  Select dropdown should be present");
				}
				Thread.sleep(6000);
				
				Select_DropDown(br, driver,"//*[@class='boxes']/li[1]/div[3]/div/div/select","3");
				Thread.sleep(3000);
				
				
				// continue
				click_element(
						".//*[@class='js-next-button blue-button right']",
						driver);
				
				Thread.sleep(9000);
				//Internet - Continue
				click_element(
						".//*[@class='js-next-button blue-button right']",
						driver);
				Thread.sleep(9000);

				// Validate that Calling Plans display in the correct ranking,
				// by region.

				String CurrSer13 = driver
						.findElement(
								By.xpath(".//*[@class='content-wrap']/div[6]/header/ul/li[2]/h3"))
						.getText();
				String CurrSer14 = driver
						.findElement(
								By.xpath(".//*[@class='phoneSelectTable selectTable']/div/section/div/div[7]/header/ul/li[2]/h3"))
						.getText();
				if ((CurrSer13.equalsIgnoreCase("Global Penny Phone Plan")))
					if ((CurrSer14.equalsIgnoreCase("International OnePrice®"))) {
						logger.info(" right sequence!!");
						statusTracker(br,
								"Pass",
								"current sequence matches Global Penny Phone Plan International OnePrice®",
								"Sequence matches", "Sequence should match");
					} else {
						logger.info("wrong sequence!!");
						statusTracker(br,
								"Fail",
								"current sequence matches Global Penny Phone Plan International OnePrice®",
								"Sequence does not match",
								"Sequence should match");
					}
				logger.info("valid  ranking of Calling Plans by region");

				
			
				// Select "Compare Plans" link
				click_element(
						".//*[@class='flexibleLink flexibleLink1']/a",
						driver);
				Thread.sleep(9000);

				if (return_text(".//*[@class='modal-title']",
						driver).equalsIgnoreCase("International Calling Rates"))

				{
					logger.info(" Compare Plans page is opened!!");
					statusTracker(br,"Pass", "Compare Plans page is opened",
							"Matches", "Compare Plans page should open");
				} else {
					statusTracker(br,"Fail", "Compare Plans page is not opened",
							"does not Match", "Compare Plans page should open");
				}
				
				logger.info("------------>>> CHECK 1---->> Code reached her--->>");
				// Select "Close" on Compare Plans link
				click_element(
						".//*[@class='modal-button-close']",
						driver);
				Thread.sleep(4000);

				logger.info("------------>>> CHECK 2---->> Code reached her--->>");
				// Validate GPP is identified as the current phone plan on the account
				click_element(
						".//*[@class='miniCart']/div[1]/header/ul/li[2]/a",
						driver);
				Thread.sleep(2000);
				logger.info("------------>>> CHECK 3---->> Code reached her--->>");
				click_element(
						".//*[@class='miniCart']/div[1]/section/div[1]/header/ul/li[1]/a",
						driver);
				Thread.sleep(2000);
				if (return_text(
						".//*[@class='content-wrap']/div[4]/header/ul/li[2]/h3",
						driver).trim().equals("Voicemail"))
					statusTracker(br,
							"Pass",
							"Global Penny Phone Plan is identified as the current phone plan on the account ",
							"Global Penny Phone Plan is displayed in Current Services",
							"Global Penny Phone Plan should be displayed in Current Services");
				else
					statusTracker(br,
							"Fail",
							"Global Penny Phone Plan is in a default open state ",
							"Global Penny Phone Plan is not displayed in Current Services",
							"Global Penny Phone Plan should be displayed in Current Services");
				
				logger.info("------------>>> CHECK 4---->> Code reached her--->>");

				//Mini cart
				String CurrSer6 = driver
						.findElement(
								By.xpath(".//*[@class='content-wrap']/div[6]/header/ul/li[2]/h3"))
						.getText();
				
				logger.info("------------>>> CHECK 5---->> Code reached her--->>");
				if ((CurrSer6.equalsIgnoreCase("Global Penny Phone Plan")))
					 {

						System.out
								.println("GPP has current service text displayed");
						statusTracker(br,
								"Pass",
								"GPP has current service text displayed",
								"GPP is in current service so monthly price and duration is not displayed",
								"GPP is in current service so monthly price and duration should not be displayed");
					} else {
						System.out
								.println(" Error as Global Penny Phone Plan is in current service ");
						statusTracker(br,
								"Fail",
								"GPP has current service text displayed",
								"GPP is in current service so monthly price and duration is displayed",
								"GPP is in current service so monthly price and duration should not be displayed");
					}
				Thread.sleep(4000);
				
				
				

		// Validate the user can expand the Global Penny Phone
				
				// drop down
				click_element(
						".//*[@class='content-wrap']/div[6]/header/ul/li[1]/a",
						driver);
				Thread.sleep(4000);

				
				//Expand Global Penny Phone
				String CurrSer11 = driver
						.findElement(
								By.xpath(".//*[@class='content-wrap']/div[6]/section/div/div/p[3]"))
						.getText();
				String CurrSer8 = driver
						.findElement(
								By.xpath(".//*[@class='content-wrap']/div[6]/header/ul/li[3]"))
						.getText();
				if ((CurrSer11.equalsIgnoreCase("Here's what you get:")))
					if ((CurrSer8.equalsIgnoreCase("$295 per Month")))
				{
					System.out
							.println(" User can expand the Global Penny Phone");
					statusTracker(br,"Pass",
							"User can expand the Global Penny Phone",
							"User can expand the Global Penny Phone",
							"User should be able to expand the Global Penny Phone");
				} else {
					System.out
							.println("User can not expand the Global Penny Phone !!");
					statusTracker(br,"Fail",
							"User can not expand the Global Penny Phone",
							"User can expand the Global Penny Phone",
							"User should be able to expand the Global Penny Phone");
				}
				
				

				// validate that the International One Price name with monthly price and duration is displayed If the user does not
				// currently have the IOP phone plan
				String CurrSer9 = driver
						.findElement(
								By.xpath(".//*[@class='content-wrap']/div[7]/header/ul/li[2]/h3"))
						.getText();
				String CurrSer10 = driver
						.findElement(
								By.xpath(".//*[@class='content-wrap']/div[7]/header/ul/li[3]"))
						.getText();
				if ((CurrSer9.equalsIgnoreCase("International OnePrice®")))
					if ((CurrSer10.equalsIgnoreCase("$1995 per Month")))
					{
						System.out
								.println(" Valid as IOP is not in current service");
						statusTracker(br,
								"Pass",
								"IOP is not in current service",
								"IOP is not in current service so monthly price and duration is displayed",
								"IOP is not in current service so monthly price and duration should not be displayed");
					} else {
						System.out
								.println("Error as IOP is in current service !!");
						statusTracker(br,
								"Fail",
								"IOP is in current service",
								"IOP is in current service so monthly price and duration is not displayed",
								"IOP is in current service so monthly price and duration should not be displayed");
					}
				Thread.sleep(3000);

				
				// Validate the user can expand the IOP
				click_element(
						".//*[@class='content-wrap']/div[7]/header/ul/li[1]/a",
						driver);
				Thread.sleep(4000);

				
				//Expand Global Penny Phone
				String CurrSer12 = driver
						.findElement(
								By.xpath(".//*[@class='content-wrap']/div[6]/section/div/div/p[3]"))
						.getText();
				if ((CurrSer12.equalsIgnoreCase("Here's what you get:")))
				{
					
					statusTracker(br,"Pass", "User can expand the IOP",
							"User can expand the IOP",
							"User should be able to expand the IOP");
				} else {
					logger.info("User can not expand the IOP !!");
					statusTracker(br,"Fail", "User can not expand the IOP",
							"User can expand the IOP",
							"User should be able to expand the IOP");
				}
				logger.info("-------------> User can expand the IOP ------------>");
				
				// Select IOP Plan
				click_element(
						".//*[@data-shortname='International OnePrice®']",
						driver);
				Thread.sleep(2000);
				if ((driver
						.findElement(By
								.xpath(".//*[@for='1-29S0']"))
						.isEnabled())) {
					statusTracker(br,"Pass", "Select IOP plan",
							"IOP plan is selected & gets updated to the cart",
							"IOP plan should be selected & get updated in the cart");
				} else {
					statusTracker(br,"Fail", "Select IOP plan",
							"IOP plan is not selected nor updated in the cart",
							"IOP plan should be selected");

				}
				
				//Mini Cart check
				config_page_Cart_result_updater_Package_TV_Internet_Phone(br, driver);
				Thread.sleep(5000);
				logger.info("Mini Cart checked");
				
				
				// Validate that the "Select New or Transfer Your Phone" section
				// does not display on the Phone configuration page due to the
				// customer being an existing phone customer

				if (Isavailable(
						"//*[@data-pagetype='select or transfer number']",
						drive)) {
					statusTracker(br,
							"Fail",
							"For customer being an existing phone customer",
							"Select New or Transfer Your Phone section is display on the Phone Configuration page",
							"Select New or Transfer Your Phone section should not display on the Phone Configuration page");

				} else {
					statusTracker(br,
							"Pass",
							"For customer being an existing phone customer",
							"Select New or Transfer Your Phones section does not display on the Phone Configuration page",
							"Select New or Transfer Your Phone section should not display on the Phone Configuration page");
				}

				// Validate that the "Digital Phone Customer Authorization"
				// section does not display on the Phone Configuration page due
				// to the customer being an existing phone customer

				if (Isavailable("//*[@data-pagetype='agreements']", drive)) {
					logger.info("fail1");
					statusTracker(br,
							"Fail",
							"For customer being an existing phone customer",
							"Digital Phone Customer Authorization is display on the Phone Configuration page",
							"Digital Phone Customer Authorization should not display on the Phone Configuration page");

				} else {

					logger.info("pass1");
					statusTracker(br,
							"Pass",
							"For customer being an existing phone customer",
							"Digital Phone Customer Authorization is not displayed on the Phone Configuration page",
							"Digital Phone Customer Authorization should not display on the Phone Configuration page");
				}
				Thread.sleep(5000);
				

				// Select IOP Plan
				click_element(
						".//*[@data-shortname='International OnePrice®']",
						driver);
				Thread.sleep(2000);
				if ((driver
						.findElement(By
								.xpath(".//*[@for='1-29S0']"))
						.isEnabled())) {
					logger.info("pass1");
					statusTracker(br,"Pass", "Select IOP plan",
							"IOP plan is selected & gets updated to the cart",
							"IOP plan should be selected & get updated in the cart");
				} else {
					logger.info("fail1");
					statusTracker(br,"Fail", "Select IOP plan",
							"IOP plan is not selected nor updated in the cart",
							"IOP plan should be selected");
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
				
				logger.info("-------------->Phone dropdown closing------------>");
				//Close dropdowns
				click_element(
						".//*[@class='content-wrap']/div[6]/header/ul/li[1]/a",
						driver);
				Thread.sleep(1000);
				click_element(
						".//*[@class='content-wrap']/div[7]/header/ul/li[1]/a",
						driver);
				Thread.sleep(1000);

				
				// Select Continue Button so that User navigates to the Review Order page.
				click_element(
						".//*[@class='js-next-button blue-button right']",
						driver);
				statusTracker(br,"Pass", "click on Continue button",
						"'Continue button is clicked",
						"should click continue button");
				Thread.sleep(6000);
				
				logger.info("-------------->RO page---------->");
				//Review Order page
				if(return_text(".//*[@class='left']/h2", driver).trim().equalsIgnoreCase("Choose Installation & Review Order"))
				{
					statusTracker(br,"Pass", "Validate whether navigated to Review order page", "Navigated to review order page", "It should navigate to review order page");
				}
				else
				{
					statusTracker(br,"Fail", "Validate whether navigated to Review order page", "NOT Navigated to review order page", "It should navigate to review order page");
					
				}
				Thread.sleep(8000);
				
//to take screenshot and save in file
				Image_compare(br,env,Page_Phone,Overall_Path,screen_count,driver);
				screen_count++;
				/*screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				targetFile = new File(Overall_Path +"//Test_Results//NewImages//"+ Page_Phone + screen_count + ".png");
				FileUtils.copyFile(screenshot, targetFile);		
				logger.info("copied file into New Images folder"+targetFile);
				
			
				Image_compare(br, env,Page_Phone,Overall_Path,screen_count);
				screen_count++;*/
				
				
			//Sign Out	
			driver.findElement(By.linkText("Sign Out")).click();
				Thread.sleep(10000);
				
				if (Isavailable(".//*[@class='twc-last js-last']/a", driver))
					statusTracker(br,"Pass",
							"Click on the Sign out button",
							"Customer is Logged Out from the current session.",
							"Customer should Log Out.");
				else
					statusTracker(br,"Fail",
							"Click on the Sign out button",
							"Customer is NOT Logged Out from the current session.",
							"Customer should Log Out.");
				
				

				driver.quit();
			}

			catch (Exception e) {
				exceptionHandler(br, e, driver);

			}
		} finally {
			wb.close();
			driver.close();

		}

	}

}
