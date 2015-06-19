
 
//File Name: RT_Package_003	Add TV- user selects package offer w with highest TV LOS - skip page logic
//Author: Pradeep
//Description of test case: 
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

public class RT_Package_003 extends CommonFunctions {
	String table, tns[];
	String tlimit, username, pwd, ctotal, Uname, Tv_plan, Internet_plan,
			Phone_plan, current_service;
	int tncount;
	String serAddress, Internet_service, Tv_service, Phone_service;
    String str1,TV,Internet,Phone,cost;
	public RT_Package_003() {
	}

	public RT_Package_003(String s) {
		this.path = s;
		logger.info("View all Package 003 is intialized");
	}

	public RT_Package_003(String s, String t, String p, String i,
			String packages) 
	{
		this.path = s;
		this.path1 = t;
		this.path2 = p;
		this.path3 = packages;
		this.path4 = i;
		logger.info("View all Package 003 is intialized");
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
		//Sheet sheet2 = wb.getSheet("Packages_Input");

		//statusTracker(br, "Pass", "RT_Package_Test_004", "RT_Package_Test_007",path1);

		logger.info("Package_003");

		try {
			String tv = "", inet = "", phone = "";
			Sheet sheet2 = wb.getSheet("Packages");
			String Sheet_name = sheet2.getName();
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
			Page_Phone = "RT_Package_003_";

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
				
				//to take screenshot and save in file
				Image_compare(br,env,Page_Phone,Overall_Path,screen_count,driver);
				screen_count++;
				/* File /*screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				File targetFile = new File(Overall_Path +"//Test_Results//NewImages//"+ Page_Phone + screen_count + ".png");
				FileUtils.copyFile(screenshot, targetFile);		
				logger.info("copied file into New Images folder"+targetFile);
				
			
				Image_compare(br, env,Page_Phone,Overall_Path,screen_count);
				screen_count++;*/
				
				
				// User clicks on View All Packages link on Your Services page
				click_element(
						".//*[@class='js-next-button blue-button center']",
						driver);
				Thread.sleep(25000);

				if (return_text(
						".//*[@class='text parbase twc-plain-text heading']",
						driver).trim().equalsIgnoreCase("Explore more Packages"))
					statusTracker(br, "Pass", "Click View Available Packages",
							"User is directed to Explore All Packages page",
							"User should be directed to Explore All Packages page");
				else
					statusTracker(br, 
							"Fail",
							"Click View Available Packages",
							"User is not directed to Explore All Packages page",
							"User should be directed to Explore All Packages page");

				
				// Validate if User can see all the Offer type Filter
				String CurrSer1 = driver
						.findElement(
								By.xpath(".//*[@for='tv-filter']"))
						.getText();
				String CurrSer2 = driver
						.findElement(
								By.xpath(".//*[@for='internet-filter']"))
						.getText();
				String CurrSer3 = driver
						.findElement(
								By.xpath(".//*[@for='phone-filter']"))
						.getText();
				String CurrSer4 = driver
						.findElement(
								By.xpath(".//*[@for='show-all-filter']"))
						.getText();
				logger.info("CurrSer1 "+ CurrSer1);
				logger.info("CurrSer2 "+ CurrSer2);
				logger.info("CurrSer3 "+ CurrSer3);
				logger.info("CurrSer4 "+ CurrSer4);
				
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
										"User can see all the Offer type Filter",
										"User is not able to view Offer type Filter",
										"User should be able to view Offer type Filter");
							}
				Thread.sleep(9000);

	//to take screenshot and save in file
				Image_compare(br,env,Page_Phone,Overall_Path,screen_count,driver);
				screen_count++;
				/*screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				targetFile = new File(Overall_Path +"//Test_Results//NewImages//"+ Page_Phone + screen_count + ".png");
				FileUtils.copyFile(screenshot, targetFile);		
				logger.info("copied file into New Images folder"+targetFile);
				
			
				Image_compare(br, env,Page_Phone,Overall_Path,screen_count);
				screen_count++;*/
				
				// eligibility and service ability rules.
				
				// Validate if user selects two or more services

			
				click_element(".//*[@id='tv-filter']", driver);
	
				Thread.sleep(4000);
				click_element(".//*[@id='internet-filter']", driver);
				Thread.sleep(4000);
				click_element(".//*[@id='phone-filter']", driver);
				Thread.sleep(4000);
				click_element(".//*[@id='show-all-filter']", driver);
				Thread.sleep(8000);

	/*		
				int flag1 = 0;
				int flag2 = 0;
				int j, i = 5;
				String str;
				while (flag1 == 0 && flag2 == 0) {
					for (j = 0; j < 3; j++) {

						str = driver.findElement(
								By.xpath("//*[@class='packages-list']/li[" + i
										+ "]/div/div[1]")).getText();

						if (str.equalsIgnoreCase("SignatureHome")
								|| (str.equalsIgnoreCase("TV + Internet"))
								|| (str.contains("Double Play")))
							flag1 = 1;

						if (str.equalsIgnoreCase("TV + Internet + Phone")
								|| (str.contains("Triple Play")))
							flag2 = 1;

						if (flag1 == 1 && flag2 == 1)
							break;
						i++;
					}
				//	click_element(".//*[@class='next']", driver);
				}

				logger.info("It found double and triple play!!");

				statusTracker(br, "Pass", "It found double and triple play!!!!",
						" It found double and triple play present!!",
						"It should find double and triple play!! ");
				Thread.sleep(4000);

				// Select a package with the highest level of Internet Service
				// and select the "Order Now" CTA
*/
				/*while (driver
						.findElement(
								By.xpath("//*[@class='packages-list']/li[3]/div/div[1]"))
						.isDisplayed() == false) {
					Thread.sleep(2000);
					System.out
							.println("enters while.............................");
				//	driver.findElement(By.xpath(".//*[@class='next']")).click();
					Thread.sleep(3000);
				}*/
				if(url.equals("https://www.timewarnercable.com/residential/order"))
				{
				String str1= driver
						.findElement(
								By.xpath(".//*[@class='packages-list']/li[3]/div/div[1]"))
						.getText();
				logger.info("String package "+ str1);
				TV=driver
						.findElement(
								By.xpath(".//*[@id='content']/div[3]/div[3]/div[1]/div/div/div[2]/div/div[4]/div[1]/ul/li[3]/div/ul/li[1]/h5"))
						.getText();
				Internet=driver
						.findElement(
								By.xpath(".//*[@id='content']/div[3]/div[3]/div[1]/div/div/div[2]/div/div[4]/div[1]/ul/li[3]/div/ul/li[2]/h5"))
						.getText();
				Phone=" ";
                cost=driver
						.findElement(
								By.xpath(".//*[@id='content']/div[3]/div[3]/div[1]/div/div/div[2]/div/div[4]/div[1]/ul/li[3]/div/div[2]/div"))
						.getText();
				Package_service_check(br, driver, "RT_package_003",str1,TV,Internet,Phone,cost);
				Thread.sleep(3000);

				
				if (driver
						.findElement(
								By.xpath(".//*[@class='packages-list']/li[3]/div/div[1]"))
						.getText().equalsIgnoreCase("TV + Internet")

						&& driver
								.findElement(
										By.xpath(".//*[@class='packages-list']/li[3]/div/ul/li[2]/h5"))
								.getText()
								.equalsIgnoreCase("Extreme Internet"))
				{
					driver.findElement(By.xpath(".//*[@class='packages-list']/li[3]/div/div[4]/a[1]/span")).click();// order now
					Thread.sleep(12000);
					statusTracker(br, 
							"Pass",
							"Select a package with the highest level of Internet Service",
							"The user has selected Ultimate Internet",
							"The user should select Ultimate Internet");
				} else {
					statusTracker(br, 
							"Fail",
							"Select a package with the highest level of Internet Service",
							"The user has not selected Ultimate Internet",
							"The user should have selected Ultimate Internet");
				}
				Thread.sleep(4000);
				}
				else if(url.equals("http://beta01.twcable.com:4503/residential/order"))
				{
					logger.info("beta url=" +url);
					click_element(
							".//*[@class='next']",
							driver);
					logger.info("beta package selected");
					
					if (driver
							.findElement(
									By.xpath(".//*[@class='packages-list']/li[8]/div/div[1]"))
							.getText().equalsIgnoreCase("TV + Internet")

							&& driver
									.findElement(
											By.xpath(".//*[@class='packages-list']/li[8]/div/ul/li[2]/h5"))
									.getText()
									.equalsIgnoreCase("Extreme Internet"))
					{
						driver.findElement(By.xpath(".//*[@class='packages-list']/li[8]/div/div[4]/a[1]/span")).click();// order now
						Thread.sleep(12000);
						statusTracker(br, 
								"Pass",
								"Select a package with the highest level of Internet Service",
								"The user has selected Ultimate Internet",
								"The user should select Ultimate Internet");
					} else {
						statusTracker(br, 
								"Fail",
								"Select a package with the highest level of Internet Service",
								"The user has not selected Ultimate Internet",
								"The user should have selected Ultimate Internet");
					}
					Thread.sleep(4000);
				}
				
				// TV progress bar
				if (return_text(
						"//*[@class='active']/span",
						driver).equals("TV")) {
					logger.info("land on TV config page");
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
				
				driver.quit();

			}

			catch (Exception e) {
				logger.info("test error message 003 is:"
						+ e.getMessage());
				exceptionHandler(br, e, driver);

			}
		} finally {
			wb.close();
			driver.close();

		}

	}

}
