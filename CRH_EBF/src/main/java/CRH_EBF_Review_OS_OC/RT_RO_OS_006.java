
//File Name: RT_RO_OS_006
//Author: Shikha 
//Description of test case: Review Order - Split Install - 2 time visit
//Date of creation(D/M/Y): 3/14/2014
//Name and date(D/M/Y) of modification: RAHUL JADOW (9/6/2014)
 
//Name and date(D/M/Y) of modification: RAHUL JADOW (27/6/2014)
//Modification description: Failure updates

package CRH_EBF_Review_OS_OC;

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

public class RT_RO_OS_006 extends CommonFunctions {

	String table, tns[];
	String tlimit, username, pwd, ctotal, Uname, Tv_plan, Internet_plan,
			Phone_plan, current_service;
	int tncount;
	String serAddress, Internet_service, Tv_service, Phone_service;

	public RT_RO_OS_006() {
	}

	public RT_RO_OS_006(String s) {
		this.path = s;
		logger.info("RO_OS_006 is intialized");
	}

	@Override
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

	@Override
	public void execute(String br,WebDriver driver, String url, int loc,String Overall_Path,String env) throws Exception {
		int screen_count = 1;
		File data = new File(this.path);
		WorkbookSettings ws = new WorkbookSettings();
		ws.setLocale(new Locale("er", "ER"));
		//arrcount = 0;
		logger.info("chheck1");
		Workbook wb = Workbook.getWorkbook(data, ws);

		try {
			String tv = "", inet = "", phone = "";
			Sheet sheet2 = wb.getSheet("Review_OS_OC");
			String Sheet_name = sheet2.getName();
			
			
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
/*
			int tv1 = 0, inet1 = 0, phone1 = 0;
			int val = 1;
			int tlim = Integer.parseInt(tlimit);
			tlim *= 60;
			tlimit = Integer.toString(tlim);
			tlimit = tlimit + "000";
*/

			if (first == 0) {
				logger.info("trying to open the url");
				driver.manage().window().maximize();
				driver.get(url);
				logger.info("Chek if url opened");
			}

			try {
				if (first == 0)
					firstrun(br,driver, username, pwd, ctotal, Uname,
							serAddress);
				logger.info("I went to next step");
				{

					// click on upgrade Internet option
					click_element(".//*[@name='select_inet']", driver);
					statusTracker(br,driver," ", "User clicks on add Internet option",
							"clicked", "");
					Thread.sleep(3000);

					// Click on Phone LOB
					click_element(".//*[@name='select_phone']", driver);
					statusTracker(br,driver," ", "User clicks on add Phone option",
							"clicked", "");
					Thread.sleep(3000);

					// click on continue
					click_element("//*[@id='js-main-form']/nav/a", driver);
					statusTracker(br,driver," ", "User clicks on Continue",
							"Navigated to plan page", "");
					Thread.sleep(8000);

					// click on standard internet
					click_element(
							"//*[@data-enrichedname='Standard']/li[5]/div/a",
							driver);
					statusTracker(br,driver," ", "User clicks internet plan", "clicked",
							"");
					Thread.sleep(8000);

					// Continue
					click_element(
							".//*[@class='js-next-button blue-button right']/span",
							driver);
					Thread.sleep(8000);

					// click on home phone
					click_element(
							".//*[@class='plans']/div/header/ul/li[5]/div/a/span",
							driver);
					Thread.sleep(8000);
					//click_element(
							//".//*[@id='content']/div[3]/div[2]/div/div[2]/div[1]/div[2]/div/div/div/div/header/ul/li[5]/div/a",
							//driver);
					//Thread.sleep(8000);

					// click continue
					click_element("//*[@data-shortname='Global Penny Phone Plan']", driver);
					Thread.sleep(2000);

					click_element(
							".//*[@class='collapsible active page-collapsible js-expander-initialized']/section/div/div[9]",
							driver);
					Thread.sleep(3000);

					click_element(".//*[@id='js-phoneNumber-transfer']", driver);
					statusTracker(br,driver," ", "Click on Phone Transfer", "Clicked", "");
					Thread.sleep(3000);

					Select_DropDown(driver, ".//*[@id='currentProvider']",
							"Blue Casa");
					statusTracker(br,driver," ", "Select Current provider", "Selected",
							"");

					Select_DropDown(driver,
							".//*[@id='current-provider-state']", "Florida");
					statusTracker(br,driver," ", "Select Current provider State",
							"Selected", "");

					driver.findElement(By.xpath(".//*[@id='phone-number']"))
							.sendKeys("878-342-3878");
					statusTracker(br,driver," ", "Enter Phone Number", "Entered", "");
					driver.findElement(By.xpath(".//*[@id='account-number']"))
							.sendKeys("987829880983");
					statusTracker(br,driver," ", "Enter Account Number", "Entered", "");
					driver.findElement(By.xpath(".//*[@id='account-name']"))
							.sendKeys("Ancy");
					statusTracker(br,driver," ", "Enter Account Name", "Entered", "");
					driver.findElement(By.xpath(".//*[@id='security-code']"))
							.sendKeys("8793");
					statusTracker(br,driver," ", "Enter Security code", "Entered", "");
					driver.findElement(By.xpath(".//*[@id='address']"))
							.sendKeys("2nd stage");
					statusTracker(br,driver," ", "Enter Address", "Entered", "");
					driver.findElement(By.xpath(".//*[@id='apt-type']"))
							.sendKeys("3rd floor");
					statusTracker(br,driver," ", "Enter Apt_type", "Entered", "");

					driver.findElement(By.xpath(".//*[@id='city']")).sendKeys(
							"nyc");
					statusTracker(br,driver," ", "Enter City", "Entered", "");
					driver.findElement(By.xpath(".//*[@id='zip-code']"))
							.sendKeys("345243");
					statusTracker(br,driver," ", "Enter ZipCode", "Entered", "");

					Select_DropDown(driver,
							".//*[@id='current-provider-state-billing']",
							"Idaho");
					statusTracker(br,driver," ", "Select Current provider state",
							"Selected", "");

					click_element(
							"//*[@class='collapsible page-collapsible js-expander-initialized active']/section/div/form/div[3]/a",
							driver);
					Thread.sleep(3000);

					// select drop down
					click_element("//*[@name='tpv-choose-TWC']", driver);
					driver.findElement(By.xpath(".//*[@id='full-name1']"))
							.sendKeys("Account");
					statusTracker(br,driver," ", "First Name", "Entered", "");
					Thread.sleep(2000);
					Select_DropDown(driver, ".//*[@id='birth-month']", "March");

					statusTracker(br,driver," ", "Birth-Month", "Selected", "");
					Select_DropDown(driver, ".//*[@id='birth-date']", "11");
					statusTracker(br,driver," ", "Birth-Day", "Selected", "");
					Select_DropDown(driver, ".//*[@id='birth-year']", "1946");
					statusTracker(br,driver," ", "Birth-Year", "Selected", "");
					Thread.sleep(2000);
					driver.findElement(By.xpath(".//*[@id='full-name2']"))
							.sendKeys("Account");
					statusTracker(br,driver," ", "First full name", "Entered", "");

					click_element(".//*[@class='arrow']", driver);
					Thread.sleep(10000);

					// validate display of review order page
					if (return_text(".//*[@class='left']/h2", driver)
							.equalsIgnoreCase(
									"Choose Installation & Review Order")) {
						statusTracker(br,driver,
								"Pass",
								"User finishes the LOS configuration and selects the continue CTA.  ",
								"User is displayed with Review order page",
								"User should be displayed with Review order page");
					} else {
						statusTracker(br,driver,
								"Fail",
								"User finishes the LOS configuration and selects the continue CTA.  ",
								"User is displayed with Review order page",
								"User should be displayed with Review order page");
					}

					if (return_text(
							".//*[@class='text parbase twc-plain-text all-in-one-visit-text']",
							driver)
							.trim()
							.equalsIgnoreCase(
									"Schedule one visit to install all my services at one time.")
							&& driver.findElement(
									By.xpath(".//*[@id='num-visits1']"))
									.isDisplayed()) {
						statusTracker(br,driver,
								"Pass",
								"Verify that  First installment options section displays on the Review Order Page.",
								"Is Displayed", "Should be displayed");
					} else {
						statusTracker(br,driver,
								"Fail",
								"Verify that  First installment options section displays on the Review Order Page.",
								"Is not Displayed", "Should be displayed");
					}

					if (return_text(
							".//*[@class='text parbase twc-plain-text second-visit-text']",
							driver)
							.trim()
							.equalsIgnoreCase(
									"Schedule two visits to install my other services before my Phone service.")
							&& driver.findElement(
									By.xpath(".//*[@id='num-visits2']"))
									.isDisplayed()) {
						statusTracker(br,driver,
								"Pass",
								"Verify that  Second  installment options section displays on the Review Order Page.",
								"Is Displayed", "Should be displayed");
					} else {
						statusTracker(br,driver,
								"Fail",
								"Verify that  Second installment options section displays on the Review Order Page.",
								"Is not Displayed", "Should be displayed");
					}

					click_element(".//*[@id='num-visits2']", driver);
					if (driver.findElement(By.xpath(".//*[@id='num-visits2']"))
							.isSelected()) {
						statusTracker(br,driver,
								"Pass",
								"Select second technician installation option via radio button",
								"Is Selected", "Should be selected");
					} else {
						statusTracker(br,driver,
								"Fail",
								"Select Second technician installation option via radio button",
								"Is not Selected", "Should be selected");
					}

					click_element(".//*[@id='num-visits1']", driver);
					if (driver.findElement(By.xpath(".//*[@id='num-visits1']"))
							.isSelected()) {
						statusTracker(br,driver,
								"Pass",
								"Select First technician installation option via radio button",
								"Is Selected", "Should be selected");
					} else {
						statusTracker(br,driver,
								"Fail",
								"Select First technician installation option via radio button",
								"Is not Selected", "Should be selected");
					}

					click_element(".//*[@id='num-visits2']", driver);
					
					//Image_compare changes -JS Start
					Image_compare(br,env,Page_Phone,Overall_Path,screen_count,driver);
                    screen_count++;
                  //Image_compare changes -JS End
					
					statusTracker(br,driver," ", "Split install option selected", "", "");

					if (return_text(".//*[@class='date'][1]/h5", driver)
							.trim()
							.equalsIgnoreCase(
									"Installation 1: TV and/or Internet Service")
							&& driver.findElement(
									By.xpath(".//*[@class='date'][1]"))
									.isDisplayed()) {
						statusTracker(br,driver,
								"Pass",
								"Verify the First Installation section displays the LOBs being installed in the header",
								"First Installation section displays the LOBs being installed in the header",
								"Should be selected");
					} else {
						statusTracker(br,driver,
								"Fail",
								"Verify the First Installation section displays the LOBs being installed in the header",
								"First Installation section displays the LOBs is not being installed in the header",
								"Should be selected");
					}

					Thread.sleep(8000);

					// Calendar
					DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
					Date date = new Date();
					logger.info("Current Date 1: "
							+ dateFormat.format(date));
					int DD_Value = Integer.parseInt(dateFormat.format(date)
							.substring(3, 5));
					logger.info("DD Value : " + DD_Value);

					select_Firstchoice_Date(br,DD_Value,driver);
					Thread.sleep(7000);

					select_Secondchoice_Date(br,DD_Value,driver);
					Thread.sleep(7000);

					select_Firstchoice_Date1(br,DD_Value,driver);
					Thread.sleep(7000);

					select_Secondchoice_Date1(br,DD_Value,driver);
					Thread.sleep(8000);

					if (Isavailable(".//*[@class='monthly-charges module']",
							driver))
						statusTracker(br,driver,
								"Pass",
								"Verify Monthly charges section is displayed separately.",
								"Monthly charges section is displayed separately",
								" Monthly charges section should be displayed separately");
					else
						statusTracker(br,driver,
								"Fail",
								"Verify Monthly charges section is displayed separately",
								" Monthly charges section is not displayed separately",
								"Monthly charges section should be displayed separately");

					
					// Check for Monthly charges option
					Package_ReviewOrder_Internet_ChkMonthlyCharges(br);
					Thread.sleep(3000);

					if (Isavailable(".//*[@class='one-time-charges module']",
							driver))
						statusTracker(br,driver,
								"Pass",
								"Verify One Time charges section is displayed separately.",
								"One Time charges section is displayed separately",
								" One Time charges section should be displayed separately");
					else
						statusTracker(br,driver,
								"Fail",
								"Verify One Time charges section is displayed separately",
								"One Time Monthly charges section is not displayed separately",
								"MOne Time charges section should be displayed separately");

					
					// Check for one time charges option
					Package_ReviewOrder_ChkOneTimeCharges(br);
					Thread.sleep(3000);

					if (Isavailable(".//*[@data-lob='Internet']", driver))
						statusTracker(br,driver,
								"Pass",
								"Verify an 'edit' link next to each LOB in which services is being added displays",
								"Edit is displayed", " Should be displayed");
					else
						statusTracker(br,driver,
								"Fail",
								"Verify an 'edit' link next to each LOB in which services is being added displays",
								" Edit is not displayed", "Should be displayed");

					if (driver.findElement(
							By.xpath(".//*[@data-lob='Internet']")).isEnabled())
						statusTracker(br,driver,
								"Pass",
								"Verify an 'edit' link next to each LOB in which services is Enabled",
								"Edit is Enabled", " Should be Enabled");
					else
						statusTracker(br,driver,
								"Fail",
								"Verify an 'edit' link next to each LOB in which services is Enabled",
								" Edit is not Enabled", "Should be Enabled");

					
					// edit for internet
					driver.findElement(By.xpath(".//*[@data-lob='Internet']"))
							.click();
					Thread.sleep(8000);
					{
						if (return_text(
								".//*[@class='parsys bf-head-par']/div/header/div/div[1]/h2",
								driver).trim().equalsIgnoreCase(
								"Choose Your Internet Plan"))
							statusTracker(br,driver,
									"Pass",
									"Verify that on clicking the 'edit' link user is taken back to the internet configuration page",
									"On clicking the 'edit' link user is taken back to the configuration page",
									" Should be taken back to the configuration page");
						else
							statusTracker(br,driver,
									"Fail",
									"Verify that on clicking the 'edit' link user is taken back to the internet configuration page",
									" On clicking the 'edit' link user is taken back to the configuration page",
									"Should be taken back to the configuration page");
					}
					

					// Return back on RO page
					click_element(
							"//*[@data-enrichedname='Standard']/li[5]/div/a",
							driver);
					Thread.sleep(8000);

					
					// Continue
					if(url.contains("beta"))
					{
						click_element(
							".//*[@class='js-next-button blue-button right']/span",
							driver);
					Thread.sleep(8000);
					}
					// edit for phone
					driver.findElement(By.xpath(".//*[@data-lob='Phone']"))
							.click();
					Thread.sleep(4000);
					{
						if (return_text(
								".//*[@class='text parbase sectionHeader twc-plain-text']/p",
								driver).trim().equalsIgnoreCase(
								"Select Optional Features & Calling Plans"))
							statusTracker(br,driver,
									"Pass",
									"Verify that on clicking the 'edit' link user is taken back to the phone configuration page",
									"On clicking the 'edit' link user is taken back to the configuration page",
									" Should be taken back to the configuration page");
						else
							statusTracker(br,driver,
									"Fail",
									"Verify that on clicking the 'edit' link user is taken back to the phone  configuration page",
									" On clicking the 'edit' link user is taken back to the configuration page",
									"Should be taken back to the configuration page");
					}
					
					// return on RO page
					// click continue
					click_element(".//*[@data-shortname='Global Penny Phone Plan']", driver);
					Thread.sleep(2000);

					click_element(
							".//*[@class='collapsible active page-collapsible js-expander-initialized']/section/div/div[9]/a",
							driver);
					Thread.sleep(3000);

					click_element(
							"//*[@class='collapsible page-collapsible js-expander-initialized active']/section/div/form/div[3]/a",
							driver);
					Thread.sleep(3000);

					
					// select drop down
					
					click_element("//*[@name='tpv-choose-TWC']", driver);

					driver.findElement(By.xpath(".//*[@id='full-name1']"))
							.sendKeys("Account");
					Thread.sleep(2000);
					Select_DropDown(driver, ".//*[@id='birth-month']", "March");
					Select_DropDown(driver, ".//*[@id='birth-date']", "11");
					Select_DropDown(driver, ".//*[@id='birth-year']", "1946");
					Thread.sleep(2000);
					driver.findElement(By.xpath(".//*[@id='full-name2']"))
							.sendKeys("Account");

					click_element(".//*[@class='arrow']", driver);
					Thread.sleep(10000);

					// Calendar
					select_Firstchoice_Date(br,DD_Value,driver);
					Thread.sleep(11000);

					select_Secondchoice_Date(br,DD_Value,driver);
					Thread.sleep(11000);

					click_element(
							".//*[@class='js-next-button blue-button right']",
							driver);
					statusTracker(br,driver," ", "Click on RO continue button ",
							"clicked", "");

					Thread.sleep(8000);

					if (driver.findElement(
							By.xpath(".//*[@class='step-list']/li[3]"))
							.isDisplayed())
						statusTracker(br,driver,
								"Pass",
								"Verify that User is navigated to order summary page",
								"User is navigated to order summary page",
								"Should be navigated");
					else
						statusTracker(br,driver,
								"Fail",
								"Verify that User is not navigated to order summary page",
								"User is navigated to order summary page",
								"Should be navigated");

					// Logout

					Thread.sleep(3000);
					driver.findElement(By.linkText("Sign Out")).click();
					Thread.sleep(10000);


				}
			}

			catch (Exception e) {
				exceptionHandler(br,e, driver);
				logger.info("error is : " + e.getMessage());
			}
		} catch (Exception e) {
			exceptionHandler(br,e, driver);

		} finally {
			wb.close();
			driver.close();

		}

	}
}
