
//File Name: RT_Internet_009
//Author: PRADEEP   
//Description of test case: Add Internet LOS Selection
//Date of creation(D/M/Y): 3/19/2014
//Name and date(D/M/Y) of modification: RAHUL JADOW (6/6/2014)
//Modification description: Close Mini cart Within Current Services, select close button on LOB(s)


package CRH_Internet;

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
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;

public class RT_Internet_013 extends CommonFunctions {

	String table, tns[];
	String tlimit, username, pwd, ctotal, Uname, Tv_plan, Internet_plan,
			Phone_plan, current_service;
	int tncount;
	String serAddress, Internet_service, Tv_service, Phone_service;

	public RT_Internet_013() {
	}

	public RT_Internet_013(String s) {
		this.path = s;
		logger.info("Add Internet 013 is intialized");
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
			Page_Phone = "RT_Internet_013_";

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
				
				logger.info("Aashish 1");
				if (first == 0)
					firstrun(br, driver, username, pwd,ctotal, Uname,
							serAddress);

				// If Internet is not active on the account, select to add
				// Internet
				logger.info("Aashish 2");
				click_element(".//*[@value='customize_inet']", driver);
				Thread.sleep(2000);
				logger.info("Aashish 3");

				// Select Continue Button so that User navigated to the Internet
				// Configuration page
				click_element("//*[@id='js-main-form']/nav/a/span", driver);
				statusTracker(br,driver, "Pass", "clck on Continue button",
						"'Continue button is clicked",
						"should click continue button");
				Thread.sleep(2000);

				logger.info("Aashish 4");


				// Verify that plan(s) name, speed in Mbps, price, and duration
				// on the plan upgrade page are correct
				int count1 = return_size(".//*[@class='plans']/div", driver);
				logger.info("count" + count1);
				statusTracker(br,driver, "", "Plans Present", "", "");
				String plan[] = new String[count1];
				String speed[] = new String[count1];
				String cost[] = new String[count1];
				for (int i = 1; i <= count1; i++) {
					plan[i - 1] = return_text(
							"html/body/section/div[3]/div[2]/div/div[2]/div[1]/div[2]/div/div/div/div["
									+ i + "]/header/ul/li[2]", driver);
					speed[i - 1] = return_text(
							"html/body/section/div[3]/div[2]/div/div[2]/div[1]/div[2]/div/div/div/div["
									+ i + "]/header/ul/li[3]", driver);
					cost[i - 1] = return_text(
							"html/body/section/div[3]/div[2]/div/div[2]/div[1]/div[2]/div/div/div/div["
									+ i + "]/header/ul/li[4]", driver);

					logger.info("Plan name "
							+ return_text(
									"html/body/section/div[3]/div[2]/div/div[2]/div[1]/div[2]/div/div/div/div["
											+ i + "]/header/ul/li[2]", driver));
					statusTracker(br,driver, 
							"Pass",
							"Plan name",
							return_text(
									"html/body/section/div[3]/div[2]/div/div[2]/div[1]/div[2]/div/div/div/div["
											+ i + "]/header/ul/li[2]", driver),
							"Plan name should be diaplayed");
					logger.info("Speed "
							+ return_text(
									"html/body/section/div[3]/div[2]/div/div[2]/div[1]/div[2]/div/div/div/div["
											+ i + "]/header/ul/li[3]", driver));
					statusTracker(br,driver, 
							"Pass",
							"Speed",
							return_text(
									"html/body/section/div[3]/div[2]/div/div[2]/div[1]/div[2]/div/div/div/div["
											+ i + "]/header/ul/li[3]", driver),
							"Speed should be diaplayed");
					logger.info("Cost "
							+ return_text(
									"html/body/section/div[3]/div[2]/div/div[2]/div[1]/div[2]/div/div/div/div["
											+ i + "]/header/ul/li[4]", driver));
					statusTracker(br,driver, 
							"Pass",
							"Cost",
							return_text(
									"html/body/section/div[3]/div[2]/div/div[2]/div[1]/div[2]/div/div/div/div["
											+ i + "]/header/ul/li[4]", driver),
							"Cost should be diaplayed");
				}

				Sheet sheet3 = wb.getSheet("RT_Internet_013");
				int totalcount = 0;
				String dummy = "a";
				int ij = 3;
				int cn = 0;
				do {
					if (dummy != null && dummy.length() > 0) {
						dummy = sheet3.getCell(0, ij).getContents();
						ij++;
						try {
							dummy = sheet3.getCell(0, ij).getContents();
						} catch (Exception e) {
							cn = 1;
						}
						totalcount++;
					} else {
						cn = 1;
					}
				} while (cn == 0);

				String plan1[] = new String[totalcount];
				String speed1[] = new String[totalcount];
				String cost1[] = new String[totalcount];
				logger.info("mf" + totalcount);
				for (int i = 0; i < totalcount; i++) {
					plan1[i] = sheet3.getCell(0, (i + 3)).getContents();
					speed1[i] = sheet3.getCell(1, (i + 3)).getContents();
					cost1[i] = sheet3.getCell(2, (i + 3)).getContents();
					logger.info("Plan "
							+ sheet3.getCell(0, (i + 3)).getContents());
					logger.info("Speed "
							+ sheet3.getCell(1, (i + 3)).getContents());
					logger.info("Cost "
							+ sheet3.getCell(2, (i + 3)).getContents());
				}

				for (int i = 1; i <= count1; i++) {
					speed[i - 1] = speed[i - 1].replaceAll("[^\\d]", "");
					speed[i - 1] = speed[i - 1] + "Mbps";
					logger.info(speed[i - 1]);

					cost[i - 1] = cost[i - 1].substring(0, 15);
					cost[i - 1] = cost[i - 1].replaceAll("[^\\d]", "");
					cost[i - 1] = cost[i - 1].substring(0,
							cost[i - 1].length() - 2)
							+ "."
							+ cost[i - 1].substring(cost[i - 1].length() - 2);
					logger.info(cost[i - 1]);
				}
				logger.info("count countina " + count1 + totalcount);
				if (count1 == totalcount) {
					statusTracker(br,driver, 
							"Pass",
							"Verify if the plan options present in the portal is the same as given from the input file",
							"Count in the portal is the same as given",
							"Count should be the same");
					int cover = 0;
					for (int i = 0; i < count1; i++) {
						logger.info(plan[i] + plan1[i] + speed[i]
								+ speed1[i] + cost[i] + cost1[i]);

						if (plan[i].equals(plan1[i])
								&& speed[i].equals(speed1[i])
								&& cost[i].equals(cost1[i])) {
							cover = 0;
						} else {
							cover = 1;
							i = count1;
						}
					}
					if (cover == 1)
						statusTracker(br,driver, 
								"Fail",
								"Verify if the plan, speed and the cost is similar to the details given",
								"The plan details are not as expected",
								"The details should be as expected");
					else
						statusTracker(br,driver, 
								"Pass",
								"Verify if the plan, speed and the cost is similar to the details given",
								"The plan details are as expected",
								"The details should be as expected");
				} else
					statusTracker(br,driver, 
							"Fail",
							"Verify if the options present in the portal is the same as given",
							"Count is not proper in the portal: " + count1,
							"Count should be the same");

				
				
				
				
				
				
				
				
				
				

				driver.quit();

			}

			catch (Exception e) {
				logger.info("Error in app is : " + e.getMessage());
				exceptionHandler(br, e, driver);

			}
		} finally {
			wb.close();
			driver.close();

		}

	
		
		
	}

}
