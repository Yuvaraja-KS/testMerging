//File Name: RT_Phone_012
//Author: Shikha Singh
//Description of test case: Customer is eligible to upgrade Phone LOB
//Date of creation(D/M/Y): 11/3/2014
//Name and date(D/M/Y) of modification: Pradeep Shetty / 9/6/2014
//Modification description:
//  a) change the all the xpath’s to unique property 
//  b) Removed all the unwanted print statements & comments.
//  c) Added comments to the steps wherever needed.
//  d) Updated Status tracked if change needed
//  e) Updated as per jagdeesh@Buyflow review comments


package CRH_EBF_Phone;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
import org.openqa.selenium.support.ui.Select;



public class RT_Phone_012 extends CommonFunctions {

	String table, tns[];
	String tlimit, username, pwd, ctotal, Uname, Tv_plan, Internet_plan,
			Phone_plan, current_service;
	int tncount;
	String serAddress, Internet_service, Tv_service, Phone_service;

	public RT_Phone_012() {
	}

	public RT_Phone_012(String s) {
		this.path = s;
		//this.path1 = internet;
	
	}

	public void execute(String br,WebDriver driver,String url, int loc)throws Exception {
		 logger.info("execute is called");
		 int screen_count = 1;
		 File data = new File(this.path);
		WorkbookSettings ws = new WorkbookSettings();
		ws.setLocale(new Locale("er", "ER"));
		//arrcount = 0;
		logger.info("chheck1");
		Workbook wb = Workbook.getWorkbook(data, ws);

	/*	File data1 = new File(this.path1);
		WorkbookSettings ws1 = new WorkbookSettings();
		ws1.setLocale(new Locale("er", "ER"));
		Workbook wb1 = Workbook.getWorkbook(data1, ws1);
*/
		try {
			   Page_Phone="RT_Phone_012_";
			    String tv = "", inet = "", phone = "";
			Sheet sheet2 = wb.getSheet("Phone");

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

		

		if(first==0)
			{
			   logger.info("trying to open the url");
			   driver.manage().window().maximize();
			   driver.get(url);
			   logger.info("Chek if url opened");
			   
			}

	try 
			{
		      if(first==0)
			  firstrun(br,driver,username,pwd,ctotal,Uname,serAddress);
			  logger.info("I went to next step");
			  Thread.sleep(5000);
				// Internet_Phone_lob_verify(br,driver);
				  Phone_lob_click(br,driver);

				  click_element("//*[@class='button-nav ']/a", driver);
				  Thread.sleep(9000);
				  click_element("//*[@class='checkoutCTA']/a", driver);
				  Thread.sleep(5000);
				  
				  Thread.sleep(5000);
				  /*click_element(".//*[@class='content-wrap']/div[9]/a", driver);
				  Thread.sleep(5000);*/
					
				  
				// Check section diplayed in collapsed state
				  if(return_text("//*[@class='text parbase twc-plain-text optionsHeader']", driver).trim().equalsIgnoreCase("Chose one of the following options:"))
				  {statusTracker(br,driver,"Pass", " Validate that Select New or Transfer Phone number  section displays", "Select New or Transfer Phone number section displayed", "Select New or Transfer Phone number section should  be displayed");
				  }
				  else
				  {statusTracker(br,driver,"Fail", " Validate that Select New or Transfer Phone number  section displays", "Select New or Transfer Phone number section not displayed", "Select New or Transfer Phone number section should  be displayed");
				  }
				
				Thread.sleep(5000);

				// New number and existing number check
				if (driver
						.findElement(
								By.xpath(".//*[@class='selectOrTransfer phoneNumberSelect']/div/section/div/form"))
						.isDisplayed()) {
					if (return_text(
							".//*[@for='js-phoneNumber-new']",
							driver).trim().equalsIgnoreCase(
							"I would like a new phone number.")) {
						if (driver
								.findElement(
										By.xpath(".//*[@for='js-phoneNumber-transfer']"))
								.isDisplayed()) {
							statusTracker(br,driver,
									"Pass",
									"Validate that Select New or Transfer Phone number  section displays",
									"Select New or Transfer Phone number  section displays",
									"Select New or Transfer Phone number  section should displays");
						} else {
							statusTracker(br,driver,
									"Fail",
									"Validate that Select New or Transfer Phone number  section displays",
									"Select New or Transfer Phone number  section displays",
									"Select New or Transfer Phone number  section should displays");
						}
					}
				}
			

				// Select Existing number form

				click_element(".//*[@id='js-phoneNumber-transfer']", driver);
				statusTracker(br,driver,"",
						"Select I would like to transfer my current number",
						"", "");
				Thread.sleep(5000);

				page_Cart_One_Time_charge_updater_1(br,driver);
				Thread.sleep(2000);

				if (driver
						.findElement(
								By.xpath("//*[@class='transfer-number general-form']/div[2]"))
						.isDisplayed()
						& return_text(
								"//*[@class='text parbase twc-plain-text currentProviderLabel']",
								driver).trim().equalsIgnoreCase(
								"Current Phone Provider")) {
					if (driver
							.findElement(
									By.xpath("//*[@class='transfer-number general-form']/div[3]"))
							.isDisplayed()
							& return_text(
									".//*[@class='text billingAddressLabel parbase twc-plain-text']",
									driver)
									.trim()
									.equalsIgnoreCase(
											"Billing Address with Your Current Provider:")) {
						statusTracker(br,driver,
								"Pass",
								"Validate that 'Current provider' and 'Billing address on Current Provider' sections are displayed.",
								"Is Displayed", "Should be Displayed");
					} else {
						statusTracker(br,driver,
								"Fail",
								"Validate that 'Current provider' and 'Billing address on Current Provider' sections are displayed.",
								"Is not Displayed", "Should be Displayed");
					}
				}

				Select_DropDown(driver, "//*[@id='current-provider-state']",
						"Florida");
				Thread.sleep(2000);
				field_statusTracker(br,"//*[@id='current-provider-state']",
						"Select current state provider", " Selected", driver);

				driver.findElement(By.xpath("//*[@id='phone-number']"))
						.sendKeys("123-876-7678");
				Thread.sleep(2000);
				field_statusTracker(br,"//*[@id='phone-number']",
						"Enter phone-number", " Entered", driver);

				driver.findElement(By.id("account-number"))
						.sendKeys("23456745");
				Thread.sleep(2000);
				field_statusTracker(br,"//*[@id='account-number']",
						"Enter account-number", " Entered", driver);

				driver.findElement(By.id("account-name")).sendKeys("Dani");
				Thread.sleep(2000);

				field_statusTracker(br,"//*[@id='account-name']",
						"Enter account-name", " Entered", driver);

				driver.findElement(By.id("security-code")).sendKeys("3433");
				Thread.sleep(2000);
				field_statusTracker(br,"//*[@id='security-code']",
						"Enter security-code", " Entered", driver);

				driver.findElement(By.id("address")).sendKeys("4th cross");
				Thread.sleep(2000);

				field_statusTracker(br,"//*[@id='address']", "Enter address",
						" Entered", driver);

				driver.findElement(By.id("apt-type")).sendKeys("#10");
				Thread.sleep(2000);
				field_statusTracker(br,"//*[@id='apt-type']", "Enter apt-type",
						" Entered", driver);

				driver.findElement(By.id("city")).sendKeys("nyc");
				Thread.sleep(2000);
				field_statusTracker(br,"//*[@id='city']", "Enter city",
						" Entered", driver);

				Select_DropDown(driver,
						"//*[@id='current-provider-state-billing']", "Hawaii");
				Thread.sleep(2000);
				field_statusTracker(br,
						"//*[@id='current-provider-state-billing']",
						"Enter current-provider-state-billing", " Selected",
						driver);

				driver.findElement(By.id("zip-code")).sendKeys("23456");
				Thread.sleep(2000);
				field_statusTracker(br,"//*[@id='zip-code']", "Enter zip-code",
						" Entered", driver);

				
				click_element(
						".//*[@class='js-next-button blue-button right']/span",
						driver);
				Thread.sleep(4000);
				System.out
						.println("**************check for current provider*********************");

//check:current provider
				
				if (driver.findElement(By.xpath(".//*[@class='error-module']/div"))
						.isDisplayed()
						&& return_text(
								"//*[@class='error-module']/div/ul/li",
								driver).trim().equalsIgnoreCase(
								"Please choose your current provider."))
					statusTracker(br,driver,
							"Pass",
							"Validate If user does not enter Current Provider, Error message 'Please select your current provider' will appear.",
							"Appears", "Should appear");
				else
					statusTracker(br,driver,
							"Fail",
							"Validate If user does not enter Current Provider, Error message 'Please select your current provider' will appear.",
							"Doesnt Appears", "Should appear");

				Select_DropDown(driver, ".//*[@id='currentProvider']", "CIMCO");
				Thread.sleep(2000);
				field_statusTracker(br,"//*[@id='currentProvider']",
						"Enter currentProvider", " Entered", driver);

				System.out
						.println("**************check for Phone number*********************");

				
				
//check:phone number
				
				driver.findElement(By.xpath("//*[@id='phone-number']")).clear();
			
				driver.findElement(By.xpath("//*[@id='phone-number']"))
						.sendKeys("23-1-234");
			
				Thread.sleep(2000);
				field_statusTracker(br,"//*[@id='phone-number']",
						"Enter phone-number", " Entered", driver);


				click_element(
						".//*[@class='js-next-button blue-button right']/span",
						driver);
				Thread.sleep(4000);

				if (driver.findElement(By.xpath(".//*[@class='error-module']"))
						.isDisplayed()
						&& return_text(
								"//*[@class='error-wrap']/ul/li",
								driver).trim().equalsIgnoreCase(
								"Please enter your phone number in format ###-###-####."))
					statusTracker(br,driver,
							"Pass",
							"Validate If user does not entered phone-number, Error message 'Phone Number is a required field ' will appear.",
							"Appears", "Should appear");
				else
					statusTracker(br,driver,
							"Fail",
							"Validate If user does not entered phone-number, Error message 'Phone Number is a required field ' will appear.",
							"Doesnt Appears", "Should appear");

				
				
				driver.findElement(By.xpath("//*[@id='phone-number']")).clear();

				driver.findElement(By.xpath("//*[@id='phone-number']"))
						.sendKeys("232-871-2234");
				Thread.sleep(2000);
				field_statusTracker(br,"//*[@id='phone-number']",
						"Enter valid phone-number", " Entered", driver);

				System.out
						.println("**************check for current provider state*********************");

				
//check for current provider state
				
				Select selectBox = new Select(driver.findElement(By
						.xpath("//*[@id='current-provider-state']")));
				selectBox.selectByIndex(0);
				statusTracker(br,driver," ", "Enter current provider state",
						" Nothing selected ", "");
				
				JavascriptExecutor jse = (JavascriptExecutor)driver;
				jse.executeScript("scroll(0, 250)"); //y value '250' can be altered


				click_element(
						".//*[@class='js-next-button blue-button right']/span",
						driver);
				Thread.sleep(4000);

				if (driver.findElement(By.xpath(".//*[@class='error-module']"))
						.isDisplayed()
						&& return_text(
								"//*[@class='error-wrap']/ul/li",
								driver).trim().equalsIgnoreCase(
								"Please choose your current provider's state."))
					statusTracker(br,driver,
							"Pass",
							"Validate If user does not enter Current Provider, Error message 'State is a required field ' will appear.",
							"Appears", "Should appear");
				else
					statusTracker(br,driver,
							"Fail",
							"Validate If user does not enter Current Provider, Error message 'State is a required field ' will appear.",
							"Doesnt Appears", "Should appear");

				Select_DropDown(driver, "//*[@id='current-provider-state']",
						"Florida");
				Thread.sleep(2000);
				field_statusTracker(br,"//*[@id='current-provider-state']",
						"Enter current-provider-state", " Selected", driver);

				Thread.sleep(2000);

	//check account number
				
				driver.findElement(By.xpath("//*[@id='account-number']"))
						.clear();
				statusTracker(br,driver," ", "Enter account number",
						" Nothing Entered ", "");

				

				click_element(
						".//*[@class='js-next-button blue-button right']/span",
						driver);
				Thread.sleep(4000);

				if (driver.findElement(By.xpath(".//*[@class='error-module']"))
						.isDisplayed()
						&& return_text(
								"//*[@class='error-wrap']/ul/li",
								driver).trim().equalsIgnoreCase(
								"Please enter your account number."))
					statusTracker(br,driver,
							"Pass",
							"Validate If user does not entered account-number, Error message 'Account-number is a required field ' will appear.",
							"Appears", "Should appear");
				else
					statusTracker(br,driver,
							"Fail",
							"Validate If user does not entered account-number, Error message 'Account-number is a required field ' will appear.",
							"Doesnt Appears", "Should appear");

				driver.findElement(By.id("account-number"))
						.sendKeys("23456745");
				Thread.sleep(2000);
				field_statusTracker(br,"//*[@id='account-number']",
						"Enter account-number", " Entered", driver);
				
//Check:account name
				
				
				driver.findElement(By.xpath("//*[@id='account-name']")).clear();
				statusTracker(br,driver," ", "Enter account Name",
						" Nothing Entered ", "");

				click_element(
						".//*[@class='js-next-button blue-button right']/span",
						driver);
				Thread.sleep(4000);

				if (driver.findElement(By.xpath(".//*[@class='error-module']"))
						.isDisplayed()
						&& return_text(
								"//*[@class='error-wrap']/ul/li",
								driver).trim().equalsIgnoreCase(
								"Please enter the account holder's name."))
					statusTracker(br,driver,
							"Pass",
							"Validate If user does not enter account-name, Error message 'account-name is a required field ' will appear.",
							"Appears", "Should appear");
				else
					statusTracker(br,driver,
							"Fail",
							"Validate If user does not enter account-name, Error message 'account-name is a required field ' will appear.",
							"Doesnt Appears", "Should appear");

				driver.findElement(By.id("account-name")).sendKeys("Ancy");
				Thread.sleep(2000);
				field_statusTracker(br,"//*[@id='account-name']",
						"Enter account-name", " Entered", driver);
				
				
//check for address:
				
				
				driver.findElement(By.xpath("//*[@id='address']")).clear();

				click_element(
						".//*[@class='js-next-button blue-button right']/span",
						driver);
				Thread.sleep(4000);

				if (driver.findElement(By.xpath(".//*[@class='error-module']"))
						.isDisplayed()
						&& return_text(
								"//*[@class='error-wrap']/ul/li",
								driver).trim().equalsIgnoreCase(
								"Please enter your street address."))
					statusTracker(br,driver,
							"Pass",
							"Validate If user does not enter address, Error message 'address is a required field ' will appear.",
							"Appears", "Should appear");
				else
					statusTracker(br,driver,
							"Fail",
							"Validate If user does not enter address, Error message 'address is a required field ' will appear.",
							"Doesnt Appears", "Should appear");

				driver.findElement(By.id("address")).sendKeys("4th cross");
				Thread.sleep(2000);

				field_statusTracker(br,"//*[@id='address']", "Enter address",
						" Entered", driver);
				
				
//Check for city:
				
				
				driver.findElement(By.id("city")).clear();

				click_element(
						".//*[@class='js-next-button blue-button right']/span",
						driver);
				Thread.sleep(4000);

				if (driver.findElement(By.xpath(".//*[@class='error-module']"))
						.isDisplayed()
						&& return_text(
								"//*[@class='error-wrap']/ul/li",
								driver).trim().equalsIgnoreCase(
								"Please enter your city."))
					statusTracker(br,driver,
							"Pass",
							"Validate If user does not enter city, Error message 'city is a required field ' will appear.",
							"Appears", "Should appear");
				else
					statusTracker(br,driver,
							"Fail",
							"Validate If user does not enter city, Error message 'city is a required field ' will appear.",
							"Doesnt Appears", "Should appear");

				driver.findElement(By.id("city")).sendKeys("nyc");
				Thread.sleep(2000);
				field_statusTracker(br,"//*[@id='city']", "Enter city",
						" Entered", driver);
				
				
//check for zip code
				
				driver.findElement(By.id("zip-code")).clear();

				click_element(
						".//*[@class='js-next-button blue-button right']/span",
						driver);
				Thread.sleep(4000);

				if (driver.findElement(By.xpath(".//*[@class='error-module']"))
						.isDisplayed()
						&& return_text(
								"//*[@class='error-wrap']/ul/li",
								driver).trim().equalsIgnoreCase(
								"Please enter your ZIP Code."))
					statusTracker(br,driver,
							"Pass",
							"Validate If user does not enter zip-code, Error message 'zip-code is a required field ' will appear.",
							"Appears", "Should appear");
				else
					statusTracker(br,driver,
							"Fail",
							"Validate If user does not enter zip-code, Error message 'zip-code is a required field ' will appear.",
							"Doesnt Appears", "Should appear");

				driver.findElement(By.id("zip-code")).sendKeys("2345");
				Thread.sleep(2000);
				field_statusTracker(br,"//*[@id='zip-code']", "Enter zip-code",
						" Entered", driver);

				click_element(
						".//*[@class='js-next-button blue-button right']/span",
						driver);
				Thread.sleep(4000);

				if (driver.findElement(By.xpath(".//*[@class='error-module']"))
						.isDisplayed()
						&& return_text(
								"//*[@class='error-wrap']/ul/li",
								driver).trim().equalsIgnoreCase(
								"Please enter your zip code in format #####."))
					statusTracker(br,driver,
							"Pass",
							"Validate If user does not enter valid zip-code, Error message 'Valid zip-code is a required field ' will appear.",
							"Appears", "Should appear");
				else
					statusTracker(br,driver,
							"Fail",
							"Validate If user does not enter valid zip-code, Error message 'Valid zip-code is a required field ' will appear.",
							"Doesnt Appears", "Should appear");

				driver.findElement(By.id("zip-code")).sendKeys("23456");
				Thread.sleep(2000);
				field_statusTracker(br,"//*[@id='zip-code']",
						"Enter valid zip-code", " Entered", driver);

				

//check for state				
				Select selectBox1 = new Select(driver.findElement(By
						.xpath("//*[@id='current-provider-state-billing']")));
				selectBox1.selectByIndex(0);
				statusTracker(br,driver," ", "Enter current provider state",
						" Nothing selected ", "");
				
				
				
				
				
				
				click_element(
						".//*[@class='js-next-button blue-button right']/span",
						driver);
				Thread.sleep(4000);
				
				
				Select_DropDown(driver,
						"//*[@id='current-provider-state-billing']", "Hawaii");
				Thread.sleep(2000);
				
			
				if(url.contains("beta"))
  					 
  				 {String env ="Beta";
  				Image_compare(br,env,Page_Phone,spath,screen_count,driver);

  				logger.info("Beta Environment");
  				 }
  				 else
  				 {
  					 String env ="Prod";
  					Image_compare(br,env,Page_Phone,spath,screen_count,driver);

  				Thread.sleep(15000);
  				logger.info("Prod Environment");
  				
  				 }
				screen_count++;
				
				/*click_element(
						".//*[@class='js-next-button blue-button right']/span",
						driver);
				Thread.sleep(4000);
				
				
				if (driver.findElement(By.xpath("//*[@id='tpv-choose-TWC']"))
						.isSelected()) {
					statusTracker(br,driver,
							"Fail",
							" Validate that User is presented with Time Warner Cable's terms and conditions, defaulted to unchecked ",
							" Is Checked ", " Should be unchecked");
				} else {
					statusTracker(br,driver,
							"Pass",
							" Validate that User is presented with Time Warner Cable's terms and conditions, defaulted to unchecked ",
							" Is UnChecked", "  Should be unchecked");
				}

				DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
				Calendar cal = Calendar.getInstance();
				logger.info(dateFormat.format(cal.getTime()));
				String Date = dateFormat.format(cal.getTime());

				if (driver
						.findElement(
								By.xpath("//*[@class='customer-authorization']/div[4]/div[3]/fieldset[1]"))
						.isDisplayed()
						& driver.findElement(
								By.xpath("//*[@class='customer-authorization']/div[4]/div[3]/fieldset[2]"))
								.isDisplayed()
						& driver.findElement(
								By.xpath("//*[@class='customer-authorization']/div[4]/div[3]/fieldset[3]"))
								.isDisplayed()) {
					statusTracker(br,driver,
							"Pass",
							"'DIgital Signature' 'Date' & 'Date of Birth' Present",
							"Is Present", "Should be present");
					if (return_text(
							"//*[@class='customer-authorization']/div[4]/div[3]/fieldset/span",
							driver).trim().equals(Date)) {
						statusTracker(br,driver,
								"Pass",
								"Dates next to each required digital signature auto populate the date with the current date ",
								"Is Auto populated and matches with the current date ",
								" Should be Auto populated and matches with the current date");
					} else {
						statusTracker(br,driver,
								"Fail",
								" dates next to each required digital signature auto populate the date with the current date",
								"Is not Auto populated and matches with the current date ",
								"Should be Auto populated and matches with the current date ");
					}
				} else {
					statusTracker(br,driver,
							"Fail",
							"'DIgital Signature' 'Date' & 'Date of Birth' Present",
							"Is not Present", "Should be present");
				}

				if (driver
						.findElement(
								By.xpath("//*[@class='customer-authorization']/div[5]/div[3]/fieldset[1]"))
						.isDisplayed()
						& driver.findElement(
								By.xpath("//*[@class='customer-authorization']/div[5]/div[3]/fieldset[2]"))
								.isDisplayed()) {
					statusTracker(br,driver,
							"Pass",
							"'DIgital Signature' 'Date' & 'Date of Birth' Present",
							"Is Present", "Should be present");
					if (return_text(
							".//*[@class='customer-authorization']/div[5]/div[3]/fieldset/span",
							driver).trim().equals(Date)) {
						statusTracker(br,driver,
								"Pass",
								"Dates next to each required digital signature auto populate the date with the current date ",
								"Is Auto populated and matches with the current date ",
								" Should be Auto populated and matches with the current date");
					} else {
						statusTracker(br,driver,
								"Fail",
								" dates next to each required digital signature auto populate the date with the current date",
								"Is not Auto populated and matches with the current date ",
								"Should be Auto populated and matches with the current date ");
					}
				} else {
					statusTracker(br,driver,
							"Fail",
							"'DIgital Signature' 'Date' & 'Date of Birth' Present",
							"Is not Present", "Should be present");
				}

				Select_DropDown(driver, "//*[@id='birth-month']", "February");
				statusTracker(br,driver,"", "Month Entered", "", "");
				Select_DropDown(driver, "//*[@id='birth-date']", "10");
				statusTracker(br,driver,"", "Date Entered", "", "");
				Select_DropDown(driver, "//*[@id='birth-year']", "1950");
				statusTracker(br,driver,"", "Year Entered", "", "");

				driver.findElement(By.xpath("//*[@id='full-name2']")).sendKeys(
						"Account Creation");
				statusTracker(br,driver,"", "Second Full Name Entered", "", "");

				Thread.sleep(2000);

				click_element("//*[@class='arrow']", driver);
				Thread.sleep(6000);
				statusTracker(br,driver,
						"",
						"Continue Clicked without filling the User's Full Name",
						"", "");

				if (return_text("//*[@class='error-wrap']/ul/li[2]", driver)
						.equalsIgnoreCase("Please enter your full name.")) {
					statusTracker(br,driver,
							"Pass",
							"Select the CTA button without entering a digital signature,",
							"User is presented with error message",
							"User should be presented with error message");
				} else {
					statusTracker(br,driver,
							"Fail",
							"Select the CTA button without entering a digital signature,",
							"User is not presented with error message",
							"User should be presented with error message");
				}

				driver.findElement(By.xpath("//*[@id='full-name1']")).sendKeys(
						"Account Creation");
				statusTracker(br,driver,"", "First Full Name Entered", "", "");
				Thread.sleep(2000);

				click_element("//*[@class='arrow']", driver);
				Thread.sleep(6000);
				statusTracker(br,driver,"",
						"Continue Clicked without check box being clicked", "",
						"");

				if (return_text("//*[@class='error-wrap']/ul/li", driver)
						.trim()
						.equalsIgnoreCase(
								"You must read and accept the Consent to Electronic Disclosure in order to continue with your order.")) {
					statusTracker(br,driver,
							"Pass",
							"Select the CTA button without entering a digital signature,",
							"User is presented with error message",
							"User should be presented with error message");
				} else {
					statusTracker(br,driver,
							"Fail",
							"Select the CTA button without entering a digital signature,",
							"User is not presented with error message",
							"User should be presented with error message");
				}

				click_element("//*[@id='tpv-choose-TWC']", driver);
				Thread.sleep(2000);
				if (driver.findElement(By.xpath("//*[@id='tpv-choose-TWC']"))
						.isSelected()) {
					statusTracker(br,driver,
							"Pass",
							" Validate that User is presented with Time Warner Cable's terms and conditions, defaulted to unchecked ",
							" Is UnChecked ", " Should be unchecked");
				} else {
					statusTracker(br,driver,
							"Fail",
							" Validate that User is presented with Time Warner Cable's terms and conditions, defaulted to unchecked ",
							" Is Checked", "  Should be unchecked");
				}
				
				
*/
				
				click_element(".//*[@class='js-next-button blue-button right']/span", driver);
				Thread.sleep(3000);
				driver.findElement(By.linkText("Sign Out")).click();
				Thread.sleep(10000);

				if (Isavailable(".//*[@class='twc-last js-last']/a", driver))
					statusTracker(br,driver,"Pass", "Click on the Sign out button",
							"Customer is Logged Out from the current session.",
							"Customer should Log Out.");
				else
					statusTracker(br,driver,
							"Fail",
							"Click on the Sign out button",
							"Customer is NOT Logged Out from the current session.",
							"Customer should Log Out.");
			} catch (Exception e) {
				exceptionHandler(br,e, driver);
				logger.info("error is : " + e.getMessage());
			}
		} catch (Exception e) {
			exceptionHandler(br,e, driver);

		} finally {
			wb.close();
			//wb1.close();
			driver.close();

		}
	}
}
