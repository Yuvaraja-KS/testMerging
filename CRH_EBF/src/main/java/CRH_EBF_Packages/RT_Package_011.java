
 
//File Name: RT_Package_011
//Author: Manjunatha / Rahul
//Description of test case: Add Phone - User selects a package that includes Phone (do not display LOS selections)
//Date of creation(D/M/Y): 11/3/2014
//Name and date(D/M/Y) of modification: Raveena Singh  6/6/2014
//Modification description:  Code Cleanup and xpath unique property updation 
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

public class RT_Package_011 extends CommonFunctions {
	String table, tns[];
	String tlimit, username, pwd, ctotal, Uname, Tv_plan, Internet_plan,
			Phone_plan, current_service;
	int tncount;
	String serAddress, Internet_service, Tv_service, Phone_service;

	public RT_Package_011() {
	}

	public RT_Package_011(String s) {
		this.path = s;
		logger.info("View all Package 011 is intialized");
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
		try {

			logger.info(" reached first stage");
			String tv = "", inet = "", phone = "";
			Sheet sheet2 = wb.getSheet("Packages");
			String Sheet_name = sheet2.getName();
			Page_Phone = "RT_Package_011_";

			
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
			logger.info("comming her_a");
			/*int tv1 = 0, inet1 = 0, phone1 = 0;
			int val = 1;
			int tlim = Integer.parseInt(tlimit);
			tlim *= 60;
			tlimit = Integer.toString(tlim);
			tlimit = tlimit + "000";*/
			logger.info("comming her");
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
					Page_Internet = "Page_1_Current services_started";

					// Click on view Allpackage
					Thread.sleep(5000);
					click_element(
							"//*[@class='js-next-button blue-button center']",
							driver);
					Thread.sleep(5000);
					logger.info("checkboxes");
					click_element(
							".//*[@id='tv-filter']",
							driver);
					click_element(
							".//*[@id='internet-filter']",
							driver);
					click_element(
							".//*[@id='phone-filter']",
							driver);
					Thread.sleep(8000);
					click_element("//*[@id='show-all-filter']", driver);
					Thread.sleep(8000);

					// click on order
					click_element(
							"//*[@class='packages-list']/li[5]/div/div[4]/a[1]",
							driver);
					Thread.sleep(10000);
				    click_element(".//*[@class='tv-equipment']/form/div[2]/header/ul/li[1]/a", driver);
					Thread.sleep(10000);
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
						statusTracker(br,"Fail",
								" Select dropdown is  not present",
								"does not Match",
								"  Select dropdown should be present");
					}

					// Dropdown
					WebElement mywe_drop_Equip_add1 = driver
							.findElement(By
									.xpath("//*[@class='boxes']/li[1]/div[3]/div/div/select"));
					mywe_drop_Equip_add1.click();
					Thread.sleep(2000);
					List<WebElement> my_drop_add1 = mywe_drop_Equip_add1
							.findElements(By.tagName("option"));
					int size_drop_add1 = my_drop_add1.size();
					for (int i = 0; i < size_drop_add1; i++) {
						if (my_drop_add1.get(i).getText().equals("3")) {
							if (my_drop_add1.get(i).getText().equals("3"))
								;
							{
								my_drop_add1.get(i).click();
								statusTracker(br,"", "More equipment selected",
										"selected", " ");
							}
							break;
						}
					}

					Thread.sleep(4000);

					// Click TV continue
					click_element(".//*[@class='js-next-button blue-button right']", driver);
					Thread.sleep(8000);
					if(url.equals("https://www.timewarnercable.com/residential/order"))
					{
					// Internet - selected first option
					driver.findElement(
							By.xpath(".//*[@data-enrichedname='Extreme']/li[5]/div/a"))
							.click();
					Thread.sleep(10000);
					System.out
							.println("End of second page and entering into third page-1");
				}
					Page_Internet = "Page_3_config_page_started";
					try {
						if(url.equals("https://www.timewarnercable.com/residential/order"))
						{
						Thread.sleep(2000);
						// click on compare plan
						click_element(
								"//*[@class='modal js-modal-initialized']",
								driver);
						Thread.sleep(4000);
						if (return_text("//*[@class='modal-title']", driver)
								.equalsIgnoreCase("Internet Plans at a Glance")) {
							statusTracker(br,"Pass",
									"Compare Internet plans is clicked",
									"compare Internet plans page is displayed",
									"Should be displayed");
						} else {
							statusTracker(br,
									"Fail",
									"Compare Internet plans is NOT clicked",
									"compare Internet plans page is not displayed",
									"Should be displayed");
						}

						click_element("//*[@class='modal-button-close']",
								driver);
						Thread.sleep(4000);
						}
						logger.info("started calling the phone config");
						Thread.sleep(10000);
						
						click_element(".//*[@class='charges']/div[1]/header/ul/li[1]/a",
								driver);
						Thread.sleep(3000);
						
						config_page_Cart_result_updater_Internet_Package(br, driver);
						page_Cart_One_Time_charge_updater_Package1(br, driver);
						Thread.sleep(3000);

						I_will_use_my_modem(br, driver);
						Thread.sleep(3000);
						
						click_element(".//*[@class='charges']/div[1]/header/ul/li[1]/a",
								driver);
						Thread.sleep(3000);
						
						config_page_Cart_result_updater_Internet_Package(br, driver);
						page_Cart_One_Time_charge_updater_Package1(br, driver);
						Thread.sleep(3000);
						InternetModem(br, driver);
						Thread.sleep(3000);
						
						click_element(".//*[@class='charges']/div[1]/header/ul/li[1]/a",
								driver);
						Thread.sleep(2000);
						
						config_page_Cart_result_updater_Internet_Package(br, driver);
						page_Cart_One_Time_charge_updater_Package1(br, driver);
						Thread.sleep(3000);

						driver.findElement(By.cssSelector("span.arrow"))
								.click();
						System.out
								.println("clicked continue button on config page");

						Thread.sleep(8000);
						logger.info("review page");
						Thread.sleep(20000);

						Page_Internet = "Page_3_internet_config_page_Passed";
						System.out
								.println("------------ End of page 3 phone config started----------------");
						Page_Internet = "Page_4_phone_config__page_started";
						
						// Phone progress bar
						if (return_text(
								"//*[@class='active']/span",
								driver).equals("Phone")) {
							statusTracker(br,"Pass",
									"Validate the secondary progress bar",
									"Phone is displayed in progress bar",
									"Secondary progress bar should display Phone ");
						} else {
							statusTracker(br,"Fail",
									"Validate the secondary progress bar",
									"Phone is not displayed in progress bar",
									"Secondary progress bar should display Phone ");
						}

						logger.info("its changing");
						if (driver
								.findElement(
										By.xpath(".//*[@class='phoneSelectTable selectTable']/div/header/ul/li[2]/h3/div/p"))
								.isDisplayed()) {
							logger.info("Pass");
							statusTracker(br,
									"Pass",
									"verify the 'Select optional features and calling plan' is displayed in expanded form",
									"'Select optional features and calling plan' section is displayed in the default expanded state",
									"The details should be as expected");
						} else {
							logger.info("Fail");
							statusTracker(br,
									"Fail",
									"verify the 'Select optional features and calling plan' is displayed in expanded form",
									"'Select optional features and calling plan' section is not displayed in the default expanded state",
									"The details should be as expected");
						}
						if(url.equals("https://www.timewarnercable.com/residential/order"))
						{
						transfer_number_Package(br, driver);

						statusTracker(br," ", "Checkpoint", " ", " ");
						Thread.sleep(12000);
						System.out
								.println("---------------- ENd of page 4 review page started-------------------------");
						Thread.sleep(12000);
						
						//to take screenshot and save in file
						Image_compare(br,env,Page_Phone,Overall_Path,screen_count,driver);
						screen_count++;
						/*screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
						targetFile = new File(Overall_Path +"//Test_Results//NewImages//"+ Page_Phone + screen_count + ".png");
						FileUtils.copyFile(screenshot, targetFile);		
						logger.info("copied file into New Images folder"+targetFile);
						
					
						Image_compare(br, env,Page_Phone,Overall_Path,screen_count);
						screen_count++;*/
						}
						logger.info("reached the end code");

						driver.quit();

					} catch (Exception e) {
						logger.info("error is: " + e.getMessage());
						exceptionHandler(br, e, driver);

					}

				}
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
