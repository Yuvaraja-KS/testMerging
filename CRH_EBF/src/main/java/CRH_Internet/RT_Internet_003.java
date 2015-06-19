
//File Name: RT_Internet_003
//Author: SHIKHA  
//Description of test case: Upgrade Multiple LOB
//Date of creation(D/M/Y): 3/19/2014
//Name and date(D/M/Y) of modification: 
//Modification description: 


package CRH_Internet;

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

public class RT_Internet_003 extends CommonFunctions {

	String table, tns[];
	String tlimit, username, pwd, ctotal, Uname, Tv_plan, Internet_plan,
			Phone_plan, current_service,env;
	int tncount;
	String serAddress, Internet_service, Tv_service, Phone_service;

	public RT_Internet_003() {
	}

	public RT_Internet_003(String s) {
		this.path = s;
		logger.info("Add Internet 003 is intialized");
	}

	public boolean Isavailable(String fxp, WebDriver driver) {
		boolean xy = true;
		try {
			if (driver.findElement(By.xpath(fxp)) != null) {
				logger.info("gone inside");
				logger.info("{}",true);
				xy = true;
			}
		} catch (Exception e) {
			logger.info(e.getMessage());
			logger.info("{}",false);
			xy = false;
		}
		return xy;
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
			
			Page_Phone = "RT_Internet_003_";

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

				// validationofTWClogo
				Internet_TWClogo(br,driver);
				Thread.sleep(2000);

				// Validation of User Name
				String UserName = driver
						.findElement(
								By.xpath(".//*[@class='headerUsername']/em"))
						.getText().trim();

				logger.info(Uname);
				if (UserName.equals(Uname)) {
					logger.info(Uname);
					statusTracker(br,driver, "Pass", "The first and last name", "Matches",
							"Should match");
				} else {
					logger.info("name match fails");
					statusTracker(br,driver, "Fail",
							"The first and last name doesnt match",
							" doesnt Match", "Should match");
				}

				// Validation of current service monthly charge and $ sign
				String CurrSer = driver.findElement(
						By.xpath("//*[@class='sub-header black-header']/span"))
						.getText();
				logger.info(CurrSer);
				String strfind = "$";
				int iSuccess = CurrSer.indexOf(strfind);
				logger.info("{}",iSuccess);

				if (iSuccess == 0) {
					logger.info("$ not present");
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
				String per = "per";
				int iSpace = CurrSer.indexOf(per);
				int iEndAmount = iSpace - 1;
				logger.info("{}",iSpace);
				String sAmount = CurrSer.substring(iStartAmount, iEndAmount);
				logger.info(sAmount);
				if (sAmount.equals(ctotal)) {
					logger.info("Pass");
					statusTracker(br,driver, 
							"Pass",
							"Current service monthly charges should match as per the user",
							"Amount" + ctotal + " matches",
							"Amount should match");
				} else {
					logger.info("Fail");
					statusTracker(br,driver, 
							"Fail",
							"Current service monthly charges should match as per the user",
							"Amount" + ctotal + " doesnt match",
							"Amount should match");
				}
				

			
					scrollToElementByName("upgrade_inet",driver);	
					driver.findElement(By.name("upgrade_inet")).click();
					Thread.sleep(2000);
					scrollToElementByName("upgrade_phone",driver);
					driver.findElement(By.name("upgrade_phone")).click();
					Thread.sleep(2000);
					
					 //to take screenshot and save in file
					try{
			               if (isElementPresent(".//*[contains(text(),'No thanks')]/div",driver))
			                      {
			                         //JS closing Feedback
			                         logger.info("Closing feedback Pop-up");
			                         click_element(".//*[contains(text(),'No thanks')]/div)",driver);
			                                             Thread.sleep(20000);
			                 }   else
			                         logger.info("No Feedback Pop-ups found");
			               
			                  
			                  if (isElementPresent(".//*[contains(@id,'lpInviteLayer')]/div",driver))
			                  {
			                         //JS closing chat box
			                         logger.info("Closing chat Pop-up");
			                         click_element(".//*[contains(@id,'lpInviteLayer')]/div/a[2]/img",driver);
			                         Thread.sleep(20000);
			                  }      else
			                         logger.info("No chat Pop-ups found");
			               } catch (Exception e) {
			                         exceptionHandler(br, e, driver);
			               }
					File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
					File targetFile = new File(spath +"//Test_Results//NewImages//"+ Page_Phone + screen_count + ".png");
					FileUtils.copyFile(screenshot, targetFile);		
					logger.info("copied file into New Images folder"+targetFile);
					
				
					if(url.contains("beta"))
	                    
	                {
	                env = "Beta";
	                Image_compare(br,env,Page_Phone,spath,screen_count,driver);
	                //Image_compare(br,driver, spath+"//Test_Results//StandardImages_Beta//RT_Internet_EBF//RT_Internet_EBF_012_1.png",spath+"//Test_Results//NewImage//RT_Internet_EBF_012_1.png");
	               Thread.sleep(5000);
	               logger.info("Beta Environment");
	               }
	               else
	               {
	            	env = "Prod" ;
	                Image_compare(br,env,Page_Phone,spath,screen_count,driver);   
	               //Image_compare(br,driver, spath+"//Test_Results//StandardImages_Prod//RT_Internet_EBF//RT_Internet_EBF_012_1.png",spath+"//Test_Results//NewImage//RT_Internet_EBF_012_1.png");
	               Thread.sleep(5000);
	               logger.info("Prod Environment");
	               
	               }
					screen_count++;
					
					Tv_lob_verify(br,driver);
				Thread.sleep(2000);
				// Validate the Your Services section header displays current
				// LOBs on account
				String CurrSer1 = driver.findElement(
						By.xpath("//*[@class='sub-header black-header']/span"))
						.getText();
				if ((CurrSer1
						.contains("You currently have Internet, Phone.")))

				{
					System.out
							.println(" current service LOBs  display in Your current service section header");
					statusTracker(br,driver, 
							"Pass",
							"Internet is in Your current service section header",
							"Internet  is displayed in Your current service section header",
							"Internet should displayed in Your current service section header");
				} else {
					System.out
							.println(" current service LOBs is not  display in Your current service section header");
					statusTracker(br,driver, 
							"Fail",
							"Internet is in Your current service section header",
							"Internet  is not displayed in Your current service section header",
							"Internet should displayed in Your current service section header");
				}

				// Validation of continue button (Enabled)
				{
					((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1200)");
					Thread.sleep(6000);		
					logger.info("Aashish isEnabled"+Isavailable(".//*[@id='js-main-form']/nav/a",driver));
					
					
						if (Isavailable(".//*[@id='js-main-form']/nav/a",driver)) {
						logger.info("Pass");
						statusTracker(br,driver, "Pass",
								"Continue button on service page", "Enabled",
								"should be Enabled");
					} else {
						logger.info("Fail");
						statusTracker(br,driver, "fail",
								"Continue button on service page", "Disabled",
								"should be Enabled");
					}
					Thread.sleep(3000);

					// Selected continue button
					scrollToElementByCSSSelector("span.arrow",driver);
					driver.findElement(By.cssSelector("span.arrow")).click();
					logger.info("clicked continue button on page 1");
					Thread.sleep(8000);
					statusTracker(br,driver, "Pass",
							"Continue button on service page clicked",
							"Continue button on service page is clicked",
							"Continue button on service page should be clicked");

					if (return_text(".//*[@class='left']/h2/strong", driver).trim()
							.equals("Internet Plan"))
						statusTracker(br,driver, 
								"Pass",
								"Click the Continue Button",
								"User is navigated to the Internet Configuration page",
								"User should navigate to the Internet Configuration page.");
					else
						statusTracker(br,driver, 
								"Fail",
								"Click the Continue Button",
								"User is NOT navigated to the Internet Configuration page",
								"User should navigate to the Internet Configuration page.");

					 //to take screenshot and save in file
					try{
			               if (isElementPresent(".//*[contains(text(),'No thanks')]/div",driver))
			                      {
			                         //JS closing Feedback
			                         logger.info("Closing feedback Pop-up");
			                         click_element(".//*[contains(text(),'No thanks')]/div)",driver);
			                                             Thread.sleep(20000);
			                 }   else
			                         logger.info("No Feedback Pop-ups found");
			               
			                  
			                  if (isElementPresent(".//*[contains(@id,'lpInviteLayer')]/div",driver))
			                  {
			                         //JS closing chat box
			                         logger.info("Closing chat Pop-up");
			                         click_element(".//*[contains(@id,'lpInviteLayer')]/div/a[2]/img",driver);
			                         Thread.sleep(20000);
			                  }      else
			                         logger.info("No chat Pop-ups found");
			               } catch (Exception e) {
			                         exceptionHandler(br, e, driver);
			               }
					screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
					targetFile = new File(spath +"//Test_Results//NewImages//"+ Page_Phone + screen_count + ".png");
					FileUtils.copyFile(screenshot, targetFile);		
					logger.info("copied file into New Images folder"+targetFile);
					
					if(url.contains("beta"))
	                    
	                {
	                env = "Beta";
	                Image_compare(br,env,Page_Phone,spath,screen_count,driver);
	                //Image_compare(br,driver, spath+"//Test_Results//StandardImages_Beta//RT_Internet_EBF//RT_Internet_EBF_012_1.png",spath+"//Test_Results//NewImage//RT_Internet_EBF_012_1.png");
	               Thread.sleep(5000);
	               logger.info("Beta Environment");
	               }
	               else
	               {
	            	env = "Prod" ;
	                Image_compare(br,env,Page_Phone,spath,screen_count,driver);   
	               //Image_compare(br,driver, spath+"//Test_Results//StandardImages_Prod//RT_Internet_EBF//RT_Internet_EBF_012_1.png",spath+"//Test_Results//NewImage//RT_Internet_EBF_012_1.png");
	               Thread.sleep(5000);
	               logger.info("Prod Environment");
	               
	               }
					screen_count++;
					
					
				}
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
