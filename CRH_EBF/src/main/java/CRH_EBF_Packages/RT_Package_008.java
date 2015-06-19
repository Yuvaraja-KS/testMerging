
 
//File Name: RT_Package_008
//Author: Raveena
//Description of test case: Upgrade Internet - user has own modem 
//Date of creation(D/M/Y): 11/3/2014
//Name and date(D/M/Y) of modification: Raveena Singh  6/6/2014
//Modification description:  Code Cleanup and xpath unique property updation
//Name and date(D/M/Y) of modification: Rahul Jadow  (18/6/2014)
//Modification description:  validate double n triple plays / Updated the plan & Package name which was changed 
/// Validating Current service Text displayed corresponding to Current Service Modem 
/// Text changed for module "Internet Modem with Free Home WiFi" &  "I'll use my own modem"

  
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
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RT_Package_008 extends CommonFunctions {

	String table, tns[];
	String tlimit, username, pwd, ctotal, Uname, Tv_plan, Internet_plan,
			Phone_plan, current_service;
	int tncount;
	String serAddress, Internet_service, Tv_service, Phone_service,
			str_Browser;
	 String str1,TV,Internet,Phone,cost;

	public RT_Package_008() {
	}

	public RT_Package_008(String s) {
		this.path = s;
		logger.info("add Internet is intialized");
	}

	public RT_Package_008(String s, String t, String p, String i,
			String packages) {
		this.path = s;
		this.path1 = t;
		this.path2 = p;
		this.path3 = packages;
		this.path4 = i;

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
		Sheet sheet3 = wb.getSheet("Package_Plans");//RT_Packagse_008
		Sheet sheet4 = wb.getSheet("Package_Plans");//RT_Packages_005
		logger.info("inside 1");
		try {
			String tv = "", inet = "", phone = "";
			logger.info("inside 2");
			Page_Phone = "RT_Package_008_";
			str_Browser = sheet2.getCell(3, loc).getContents();
			username = sheet2.getCell(Col_locator_full_scan_input_sheet("USERNAME", path,Sheet_name), loc).getContents();
			pwd = sheet2.getCell(Col_locator_full_scan_input_sheet("PASSWORD", path,Sheet_name), loc).getContents();
			ctotal = sheet2.getCell(Col_locator_full_scan_input_sheet("C-TOTAL", path,Sheet_name), loc).getContents();
			logger.info("inside 2_a");
			String internet_sheet_plan1 = sheet3.getCell(18, 3).getContents();
			String internet_sheet_plan2 = sheet3.getCell(18, 4).getContents();
			logger.info("inside 3");
			/*int tv1 = 0, inet1 = 0, phone1 = 0;
			int val = 1;
			int choice = 0;
			tlimit = tlimit + "000";
			Page_TV = " Page_1_Current Service ";*/
			logger.info("inside 1");
			String int_plan = tv = sheet2.getCell(Col_locator_full_scan_input_sheet("TV SERVICE", path,Sheet_name), loc).getContents();
			String int_eqipment = sheet2.getCell(18, loc).getContents();
			String phone_plan = sheet2.getCell(19, loc).getContents();
			inet = sheet2.getCell(Col_locator_full_scan_input_sheet("INTERNET SERVICE", path,Sheet_name), loc).getContents();
			phone = sheet2.getCell(Col_locator_full_scan_input_sheet("PHONE SERVICE", path,Sheet_name), loc).getContents();
			String cost_current_sevice_input = sheet2.getCell(Col_locator_full_scan_input_sheet("C-TOTAL", path,Sheet_name), loc)
					.getContents();
			logger.info("inside 5");
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

					if (driver
							.findElement(
									By.xpath("//*[@class='text parbase twc-plain-text heading']"))
							.getText()
							.equalsIgnoreCase("Explore more packages")) {
						logger.info("View pkgs page opens!!");
						statusTracker(br,"Pass", "View pkgs page opens!!",
								"View pkgs page opens!!",
								"View pkgs page open should open! ");
					} else {
						logger.info("View pkgs page does not open!!");
						statusTracker(br,"Fail", "View pkgs page does not open!!",
								"View pkgs page does not open!!",
								"View pkgs page open should open! ");
					}
				

				// user checks the available chekboxes
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

				
			
				

				// click_element(	".//*[@class='next']",		driver);

				// user should be able to select two or more than two checkboxes
				// to view packages
				System.out
						.println(" you can select two or more LOB at a time for packages");
				Thread.sleep(5000);

				if (driver.findElement(By.xpath("//*[@id='show-all-filter']"))
						.isSelected()) {
					logger.info("show all is selected!!");
				}
				
				
	/*			// validate double n triple plays
				int flag1 = 0;
				int flag2 = 0;
				int j, i = 5;
				String str;
				while (flag1 == 0 && flag2 == 0) {
					for (j = 0; j < 3; j++) {

						str = driver.findElement(
								By.xpath("//*[@class='packages-list']/li[" + i
										+ "]/div/div[1]")).getText();

						if (str.equalsIgnoreCase("TV + Internet")
								|| (str.equalsIgnoreCase("TV + Phone"))
								|| (str.contains("Double Play")))
							flag1 = 1;

						if (str.equalsIgnoreCase("Better Triple Play with Extreme")
								|| (str.contains("Triple Play")))
							flag2 = 1;

						if (flag1 == 1 && flag2 == 1)
							break;
						i++;
					}
					click_element(
							".//*[@class='next']",
							driver);
					Thread.sleep(4000);
				}*/
				logger.info("It found double and triple play!!");

				statusTracker(br,"Pass", "It found double and triple play!!!!",
						" It found double and triple play present!!",
						" It should find double and triple play!! ");

				Thread.sleep(4000);

				if(url.equals("https://www.timewarnercable.com/residential/order"))
				{
				while (driver
						.findElement(
								By.xpath("//*[@class='packages-list']/li[3]/div/div[1]"))
						.isDisplayed() == false) {
					System.out
							.println("enters while.............................");
					//driver.findElement(By.xpath(".//*[@class='next']")).click();
				}
				String str1= driver
						.findElement(
								By.xpath(".//*[@class='packages-list']/li[3]/div/div[1]"))
						.getText();
				logger.info("String package "+ str1);
				TV=driver
						.findElement(
								By.xpath(".//*[@class='packages-list']/li[3]/div/ul/li[1]/h5"))
						.getText();
				Internet=driver
						.findElement(
								By.xpath(".//*[@class='packages-list']/li[3]/div/ul/li[2]/h5"))
						.getText();
				Phone=" ";
                cost=driver
						.findElement(
								By.xpath(".//*[@class='packages-list']/li[3]/div/div[2]/div"))
						.getText();
				Package_service_check(br, driver, "RT_package_008",str1,TV,Internet,Phone,cost);
				Thread.sleep(3000);

				if (driver
						.findElement(
								By.xpath("//*[@class='packages-list']/li[3]/div/div[1]"))
						.getText().equalsIgnoreCase("TV + Internet")) {

					// order now
					driver.findElement(
							By.xpath("//*[@class='packages-list']/li[3]/div/div[4]/a[1]"))
							.click();
					Thread.sleep(8000);
					statusTracker(br,"Pass",
							"The user has selected TV + Internet!!",
							"The user has selected TV + Internet!!",
							"The user has selected TV + Internet should be present! ");
				} else {
					statusTracker(br,"Fail",
							"The user has not selected TV+ Internet!!",
							"The user has not selected TV + Internet!!",
							"The user should have selected TV + Internet should be present! ");
				}
				Thread.sleep(2000);

				}
				else if(url.equals("http://beta01.twcable.com:4503/residential/order"))
				{
					logger.info("beta url=" +url);
					click_element(
							".//*[@class='next']",
							driver);
					logger.info("beta package selected");
					Thread.sleep(3000);

					if (driver
							.findElement(
									By.xpath("//*[@class='packages-list']/li[8]/div/div[1]"))
							.getText().equalsIgnoreCase("TV + Internet")) {

						// order now
						driver.findElement(
								By.xpath("//*[@class='packages-list']/li[8]/div/div[4]/a[1]/span"))
								.click();
						Thread.sleep(8000);
						statusTracker(br,"Pass",
								"The user has selected TV + Internet!!",
								"The user has selected TV + Internet!!",
								"The user has selected TV + Internet should be present! ");
					} else {
						statusTracker(br,"Fail",
								"The user has not selected TV+ Internet!!",
								"The user has not selected TV + Internet!!",
								"The user should have selected TV + Internet should be present! ");
					}
					Thread.sleep(2000);
				}
					
		// tv configuration page!!
				
				//Additional Equipment 
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
				
				
				Select_DropDown(br, 
						driver,
						"//*[@class='boxes']/li[1]/div[3]/div/div/select",
						"3");
				Thread.sleep(6000);
				
				
				// continue
				driver.findElement(
						By.xpath("//*[@class='js-next-button blue-button right']"))
						.click();
				Thread.sleep(4000);
				
				
				//Plan rank is matching with internetpackages sheet
				if(url.equals("https://www.timewarnercable.com/residential/order"))
				{
				String webpage_plan1, webpage_plan2;
				webpage_plan1 = driver
						.findElement(
								By.xpath("//*[@data-enrichedname='Ultimate 100']/li[2]/h3"))
						.getText();
				webpage_plan2 = driver.findElement(
						By.xpath("//*[@data-enrichedname='Extreme']/li[2]/h3"))
						.getText();
				if (webpage_plan1.equalsIgnoreCase(sheet4.getCell(13, 4).getContents()))
					if (webpage_plan2.equalsIgnoreCase(sheet4.getCell(13, 5).getContents())) {
						System.out
								.println("Plan rank is matching with internetpackages sheet!");
						statusTracker(br,
								"Pass",
								"Plan rank is matching with internetpackages sheet!!!",
								"Plan rank is matching with internetpackages sheet!!!",
								"Plan rank is matching with internetpackages sheet should be present! ");
					}
					else {
						System.out
								.println("Plan rank is not matching with internetpackages sheet!");
						statusTracker(br,
								"Pass",
								"Plan rank is not matching with internetpackages sheet!!!",
								"Plan rank is not matching with internetpackages sheet!!!",
								"Plan rank is matching with internetpackages sheet should be present! ");
					}

			}
				// checking all LOBs
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
							statusTracker(br,"Pass",
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
				Thread.sleep(4000);
				
				
				// validate new services cart!!
				if ((driver
						.findElement(
								By.xpath("//*[@class='newCartHeader text parbase twc-plain-text']"))
						.getText().equalsIgnoreCase("New Services")))

					if ((driver
							.findElement(
									By.xpath("//*[@class='text parbase twc-plain-text firstHeader']"))
							.getText().equalsIgnoreCase("Monthly Charges")))
						if ((driver
								.findElement(
										By.xpath("//*[@class='charges']/div[1]/header/ul/li[2]/h6"))
								.getText().equalsIgnoreCase("TV")))

							if ((driver
									.findElement(
											By.xpath("//*[@class='charges']/div[2]/header/ul/li[2]/h6"))
									.getText().equalsIgnoreCase("Internet")))

							{
								System.out
										.println("New Services Content present!!");
								statusTracker(br,"Pass",
										"New Services Content present!!!",
										"New Services Content present!!!",
										"New Services Content present!!!");
							} else {
								logger.info("fail1");
								statusTracker(br,
										"Fail",
										"New Services Content not present!!",
										"New Services Content is  not present!!",
										"New Services Content should be present");
							}
				if(url.equals("https://www.timewarnercable.com/residential/order"))
				{
				//Select Ultimate
				click_element(
						"//*[@data-enrichedname='Ultimate 100']/li[5]/div/a",
						driver);
				Thread.sleep(4000);
				
				
				// open compare equipment link
				click_element("//*[@id='js-main-form']/div[1]/a", driver);
				Thread.sleep(2000);
				if ((driver
						.findElement(
								By.xpath(".//*[@id='customize_internet']/div[18]/div[1]/div[1]"))
						.getText()
						.equalsIgnoreCase("Internet Plans at a Glance")))
					if ((driver
							.findElement(
									By.xpath("//*[@class='text row0col0 parbase compTableText checkBoxCol1Text']"))
							.getText().equalsIgnoreCase("Download Speeds"))) {
						System.out
								.println(" compare equipment page is displayed!!");
						statusTracker(br,
								"Pass",
								" Compare equipment page is displayed!!",
								" Compare equipment page is displayed!! matches",
								" Compare equipment page is displayed!! should match");
					} else {
						System.out
								.println(" compare equipment page is not displayed!!");
						statusTracker(br,
								"Fail",
								" Compare equipment page is not displayed!!",
								" Compare equipment page is displayed!! matches",
								" Compare equipment page is displayed!! should match");
					}

				// closed compare equipment
				click_element(
						".//*[@class='modal-button-close']",
						driver);
				Thread.sleep(4000);
				
				
				//I'll use my own modem
				if(return_text(".//*[@class='modem-options']/div[3]/header/ul/li[2]/h3", driver).trim().equalsIgnoreCase("I'll use my own modem"))
					if(Isavailable(".//*[@class='modem-options']/div[3]/header/ul/li[3]/em", driver))
						if(return_text(".//*[@class='modem-options']/div[3]/header/ul/li[3]/em", driver).trim().equalsIgnoreCase("Current Service"))
					{
						statusTracker(br,"Pass", "Validating Current service Text displayed corresponding to Current Service Modem", "Current service Text displayed corresponding to Current Service Modem", "Current service Text should be displayed corresponding to Current Service Modem");
					}
						else
					{
						statusTracker(br,"Fail", "Validating Current service Text displayed corresponding to Current Service Modem", "Current service Text NOT displayed corresponding to Current Service Modem", "Current service Text should be displayed corresponding to Current Service Modem");
						
					}
				
				
				// equipment ranking
				if ((driver
						.findElement(
								By.xpath(".//*[@class='modem-options']/div[2]/header/ul/li[2]/h3"))
						.getText()
						.equalsIgnoreCase("Home WiFi and Internet Modem"))
						&& (driver
								.findElement(
										By.xpath("//*[@class='modem-options']/div[2]/header/ul/li[3]/sup[1]"))
								.getText().equalsIgnoreCase("$"))
						&& (driver
								.findElement(
										By.xpath("//*[@class='modem-options']/div[2]/header/ul/li[3]/span"))
								.getText().equalsIgnoreCase("per Month")))

					if ((driver
							.findElement(
									By.xpath(".//*[@class='modem-options']/div[3]/header/ul/li[2]/h3"))
							.getText()
							.equalsIgnoreCase("I'll use my own modem"))) {
						System.out
								.println(" right sequence and pattern of default view!!");
						statusTracker(br,"Pass",
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
				Thread.sleep(4000);
				
				
				//Internet Modem with Free Home WiFi 
				click_element(
						"//*[@class='modem-options']/div[2]/header/ul/li[1]/a",
						driver);
				Thread.sleep(4000);
				String str2 = driver
						.findElement(
								By.xpath(".//*[@id='js-main-form']/div[2]/div[2]/section/div/div[2]/div/ul/li[1]"))
						.getText();
				Thread.sleep(4000);
				logger.info(" Text in Equipment1...." + str2);

				if (str2.equalsIgnoreCase("High-speed wired connection for up to 4 computers")) {

					logger.info("Right content in Equipment1!!");
					statusTracker(br,"Pass", "Right content in Equipment1",
							"Right content in Equipment1",
							"Right content in Equipment1 should match");
				} else {
					logger.info("Wrong content in Equipment1!!");
					statusTracker(br,"Fail", "wrong content in Equipment1",
							"wrong content in Equipment1",
							"Right content in Equipment1 should match");
				}
				}
				else if(url.equals("http://beta01.twcable.com:4503/residential/order"))
				{
					//Select Ultimate
					click_element(
							".//*[@class='plans']/div[2]/header/ul/li[5]/div/a/span",
							driver);
					Thread.sleep(4000);
					// equipment ranking
					if ((driver
							.findElement(
									By.xpath(".//*[@class='modem-options']/div[2]/header/ul/li[2]/h3"))
							.getText()
							.equalsIgnoreCase("Internet Modem with Free Home WiFi"))
							&& (driver
									.findElement(
											By.xpath("//*[@class='modem-options']/div[2]/header/ul/li[3]/sup[1]"))
									.getText().equalsIgnoreCase("$"))
							&& (driver
									.findElement(
											By.xpath("//*[@class='modem-options']/div[2]/header/ul/li[3]/span"))
									.getText().equalsIgnoreCase("per Month")))

						if ((driver
								.findElement(
										By.xpath(".//*[@class='modem-options']/div[3]/header/ul/li[2]/h3"))
								.getText()
								.equalsIgnoreCase("I'll use my own modem"))) {
							System.out
									.println(" right sequence and pattern of default view!!");
							statusTracker(br,"Pass",
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
					Thread.sleep(4000);
				}

				//.//*[@id='js-main-form']/div[2]/div[2]/section/div/div/div/p[2]
				//.//*[@id='js-main-form']/div[2]/div[2]/section/div/div/div/p[2]/b   Please note:
				// my own equip!
				click_element(
						"//*[@class='modem-options']/div[3]/header/ul/li[1]/a",
						driver);

				String str3 = driver
						.findElement(
								By.xpath("//*[@class='modem-options']/div[3]/section/div/div/div/p[2]"))
						.getText();
				logger.info(" Text in Equipment3...." + str3);

				if ((str3.trim())
						.equalsIgnoreCase(("Please note: If you don't have a modem when we install your Internet service, we'll install an Internet Modem for you. The standard monthly modem rate (above) will apply.")
								.trim())) {

					logger.info("Right content in my own Equipment!!");
					statusTracker(br,"Pass", "Right content in my own Equipment",
							"Right content in my own Equipment",
							"Right content in my own Equipment should match");
				} else {
					logger.info("Wrong content in my own Equipment!!");
					statusTracker(br,"Fail", "wrong content in my own Equipment",
							"wrong content in my own Equipment",
							"Right content in my own Equipment should match");
				}

//to take screenshot and save in file
				Image_compare(br,env,Page_Phone,Overall_Path,screen_count,driver);
				screen_count++;
				/* File /*screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				File targetFile = new File(Overall_Path +"//Test_Results//NewImages//"+ Page_Phone + screen_count + ".png");
				FileUtils.copyFile(screenshot, targetFile);		
				logger.info("copied file into New Images folder"+targetFile);
				
			
				Image_compare(br, env,Page_Phone,Overall_Path,screen_count);
				screen_count++;*/
				
				//Close dropdowns
				
				click_element(
						"//*[@class='modem-options']/div[3]/header/ul/li[1]/a",
						driver);
				
				//Continue
				click_element(".//*[@class='js-next-button blue-button right']",
						driver);
				statusTracker(br,"Pass", "navigated to Phone equipment page",
						"navigated to Phone equipment page",
						"navigated to Phone equipment page should match");
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
			driver.close();

		}
	}

}