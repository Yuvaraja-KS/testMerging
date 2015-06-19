//File Name: RT_Phone_008
//Author: Rahul Jadow
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

import com.thoughtworks.selenium.Selenium;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.io.File;
import java.io.IOException;
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
import jxl.read.biff.BiffException;
public class RT_Phone_008 extends CommonFunctions {



	String table, tns[];
	String tlimit, username, pwd, ctotal, Uname, Tv_plan, Internet_plan,
			Phone_plan, current_service;
	int tncount;
	String serAddress, Internet_service, Tv_service, Phone_service,
			str_Browser;

	static String testCaseName, passScrShot;

	public String getTestCaseName() {
		return testCaseName;
	}

	public static String getPassScreenshot() {
		return passScrShot;
	}
	
	public RT_Phone_008() {
		testCaseName = this.getClass().getSimpleName();
		try {
			passScrShot = sheet11.getCell(4, Row_locator_full_scan_validation(testCaseName,inputfile,"Phone")).getContents();
		} catch (BiffException e) {
			logger.info(e.getMessage());
		} catch (IOException e) {
			logger.info(e.getMessage());
		}
	}

	public RT_Phone_008(String s) {
		testCaseName = this.getClass().getSimpleName();
		try {
			passScrShot = sheet11.getCell(4, Row_locator_full_scan_validation(testCaseName,inputfile,"Phone")).getContents();
		} catch (BiffException e) {
			logger.info(e.getMessage());
		} catch (IOException e) {
			logger.info(e.getMessage());
		}
		this.path = s;
		//this.path1 = phone;
		logger.info("add Phone is intialized");
	}

	public void execute(String br,WebDriver driver,String url, int loc)throws Exception {
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
		Workbook wb1 = Workbook.getWorkbook(data1, ws1);*/

		try {
			String tv = "", inet = "", phone = "";
			Sheet sheet2 = wb.getSheet("Phone");
			String Sheet_name = sheet2.getName();
			Page_Phone="RT_Phone_008_";
			str_Browser = sheet2.getCell(Col_locator_full_scan_input_sheet("Browser", path,Sheet_name), loc).getContents();
			 
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
		 
			Page_TV = " Page_1_Current Service ";

		
			String int_plan = tv = sheet2.getCell(15, loc).getContents();
			String int_eqipment = sheet2.getCell(18, loc).getContents();
			String phone_plan = sheet2.getCell(19, loc).getContents();
			inet = sheet2.getCell(12, loc).getContents();
			phone = sheet2.getCell(13, loc).getContents();
			String cost_current_sevice_input = sheet2.getCell(8, loc)
					.getContents();
			if (first == 0) {
				logger.info("trying to open the url");
				driver.manage().window().maximize();
				driver.get(url);
				logger.info("Chek if url opened");
			}
			try {
				if (first == 0)
					firstrun(br,driver, username, pwd,  ctotal, Uname,
							serAddress);

			
				
				//Add Phone - Validate LOS Selections
				
				
				click_element(".//*[@value='select_phone']",driver);
				statusTracker(br,driver,"Pass", "Phone LOB is selected","Phone LOB is selected", "Phone LOB Should be clickable");
				Thread.sleep(5000);
				 
				
				
			
				if(url.contains("beta"))
					 
				 {String env ="Beta";
				 Image_compare(br,env,Page_Phone,spath,screen_count,driver);

				Thread.sleep(25000);
				logger.info("Beta Environment");
				 }
				 else
				 {
					 String env ="Prod";
					 Image_compare(br,env,Page_Phone,spath,screen_count,driver);

				Thread.sleep(25000);
				logger.info("Prod Environment");
				
				 }
				screen_count++;
				
				
				Thread.sleep(5000);
				//continue          
				click_element("//*[@class='js-next-button blue-button']/span",driver);   
				logger.info("clicked.............");
				Thread.sleep(8000);
						
					 
						
				
	//Select your Phone plan page
						
				if (driver.findElement(By.xpath("//*[@class='left']/h2")).isDisplayed())
					if (driver.findElement(By.xpath("//*[@class='active first']/div/div")).isDisplayed())
						if (driver.findElement(By.xpath("//*[@class='step-list']/li[2]/div/div")).isDisplayed())
							if (driver.findElement(By.xpath(".//*[@class='step-list']/li[3]/div/div")).isDisplayed())
								if (driver.findElement(By.xpath(".//*[@class='step-list']/li[4]/div/div")).isDisplayed())
										{
											logger.info(" Select a Phone Plan Page is open");
										}
						
				Thread.sleep(4000);
						
				if (driver.findElement(By.xpath(".//*[@class='active']/span")).isDisplayed())
						{
							logger.info("Secondary Bar is present!");
							statusTracker(br,driver,"Pass", "Check for service address","Matches", "Should match");
						}
						
									 
							 
	//Current Services module is closed and displays price in $
							 
							 
				String CurrSer =driver.findElement(By.xpath(".//*[@class='price last']/sup")).getText();
				logger.info("price is");  
				logger.info(CurrSer);
				logger.info("Testing.....01");
				String strfind="$";
				int iSuccess = CurrSer.indexOf(strfind);
				logger.info("",iSuccess);
							    
							    if(iSuccess<0)
								    {
								    logger.info("price is not present");
								    statusTracker(br,driver,"Fail", "$ sign present in current service monthly charges", "$ not present", "$ should be present");
								    }

							    else
								    {
								    logger.info("$ present");
								    statusTracker(br,driver,"Pass", "$ sign present in current service monthly charges", "$ present", "$ should be present");
								    }	


								    int iStartAmount= iSuccess+1;
								    String per= " ";


								    int iSpace=CurrSer.indexOf(per);
								    int iEndAmount=iSpace-1;
								    logger.info("",iSpace);
								 
								    String sAmount = CurrSer.substring(1,CurrSer.length());
									logger.info("s amount" +sAmount);
									    
								    //String sAmount = CurrSer.substring(iStartAmount,iEndAmount);
								 
								    
								    if(sAmount.equals(ctotal))
									    {
									    logger.info("Pass");
									    statusTracker(br,driver,"Pass", "Current service monthly charges should match as per the user", "Amount matches", "Amount should match");
									    }	
								    
								    else
									    {
									    logger.info("Fail");
									    statusTracker(br,driver,"Fail", "Current service monthly charges should match as per the user", "Amount doesnt match", "Amount should match");
									    }
						   
								    
								    // Current services expand
								    click_element(".//*[@class='miniCart']/div/header/ul/li[2]/a",driver);
									 
			
				 
				 
				 
								  //Validating  of Internet LOB under current services
				 
				 
				String CurrSer1 =driver.findElement(By.xpath(".//*[@class='miniCart']/div/section/div[1]/header/ul/li[2]/h6")).getText();
				
										   
										   if ((CurrSer1.equalsIgnoreCase("Internet")))
											 
											   {
												   logger.info(" right sequence");
												   statusTracker(br,driver,"Pass", "Internet LOB under current services", " Internet LOB is under current services", " Internet LOB should be under current services");
											   }
											   else
											   {
												   logger.info("wrong sequence");
												   statusTracker(br,driver,"Fail", "Internet LOB under current services", "Internet LOB is not under current services", "Internet LOB should be under current services");
												   
											   }
									
										   
										   
	// Validate information under Internet LOB
										   
										   
										   click_element(".//*[@class='miniCart']/div/section/div[1]/header/ul/li[2]/h6",driver);
										   Thread.sleep(4000);
										   logger.info("");
										   String interServ=driver.findElement(By.xpath(".//*[@class='miniCart']/div/section/div[1]/section/div/ul/li[1]")).getText();
										   String interServ2=driver.findElement(By.xpath(".//*[@class='miniCart']/div/section/div[1]/section/div/ul/li[2]")).getText();
										   if ((interServ.equalsIgnoreCase("Standard Internet")))
											   if((interServ2.equalsIgnoreCase("TWC Modem")))
												   
											   {
												   logger.info("Right sequence");
												   statusTracker(br,driver,"Pass", "Information under Internet LOB", "Information is correct under Internet LOB", "Information should be correct under Internet LOB");
											   }
											   else
											   {
												   logger.info("Wrong sequence");
												   statusTracker(br,driver,"Fail", "Information under Internet LOB", "Information is not correct under Internet LOB", "Information should be correct under Internet LOB");
												   
											   }
										  
										 //close dropdown
										   
										   click_element(".//*[@class='miniCart']/div/section/div[1]/header/ul/li[2]/h6",driver);
										   Thread.sleep(4000);
										   
										   
                                          //Collapse Current service section
										   
										   click_element("//*[@class='checkout-plans']/div/div[1]/header/ul/li[2]/h3",driver);
										   statusTracker(br,driver,"Pass", "Collapse Current service section", "Current service section is collapsed", "Current service section should be collapsed");
										   Thread.sleep(4000);
						 	
										   //Verify that all Phone plans available in the market display for the new TV customer
										   logger.info("validating Phone plans");

										   if ((driver.findElement(By.xpath("//*[@class='checkout-plans']/div/div[1]/header/ul/li[2]/h3")).isDisplayed()))
														{
															logger.info("Phone Plan are Present");
															statusTracker(br,driver,"Pass", "All Phone Plan are Present ", "Phone Plan Present", "Phone Plan should be Present");
														}   
														
											else
													{
															logger.info("Phone plans not present");
															statusTracker(br,driver,"fail", "Phone Plan is Present and in correct order", "Phone Plan is not Present", "Phone Plan should not be Present");
													}
									
  
									
									
									List<WebElement> myli=driver.findElements(By.xpath(".//*[@class='checkout-plans']/div[2]/div/div/div/div/header"));
									int count1=myli.size();
									logger.info(" my list size "+ myli.size());
									logger.info("count=" +count1);
									String plan[]=new String[count1];
									String channels[]=new String[count1];
									String cost2[]=new String[count1];
									String cost[]=new String[count1];
									for(int i=1;i<=count1;i++)
									{                                         
										plan[i-1]=driver.findElement(By.xpath("//*[@class='checkout-plans']/div/div["+i+"]/header/ul/li[2]/h3")).getText();
										
										cost2[i-1]=driver.findElement(By.xpath("//*[@class='checkout-plans']/div/div["+i+"]/header/ul/li[4]")).getText();
										cost[i-1]=cost2[i-1].substring(0,cost2[i-1].length()-26)+"."+cost2[i-1].substring(cost2[i-1].length()-26);			
										logger.info("plan name is "+plan[i-1]);
									     statusTracker(br,driver," ","Plan name",plan[i-1]," ");
							
										logger.info("cost is "+cost[i-1]);
										statusTracker(br,driver," ","Cost",cost[i-1]," ");				
									}
							
									 Thread.sleep(5000);
										   
									 click_element("//*[@data-enrichedname='Home Phone National']/li[1]/a",driver);
										   //click_element("//*[@class='collapsible page-collapsible two-rows js-expander-initialized']/header/ul/li[1]/a",driver); //dropdown1
										   Thread.sleep(5000);
										   
			
				
				
			//validate customization page
            
            click_element("//*[@class='checkoutCTA']/a",driver); //select
            Thread.sleep(8000);
            
            if(driver.findElement(By.xpath(".//*[@class='left']/h2")).getText().equalsIgnoreCase("Customize Your Phone Service"))
            {   
                logger.info("customization page opens");
                statusTracker(br,driver,"Pass","It opens phone customization page", "It opens phone customization page", "It should open phone customization page");
                             }
            else
            {   logger.info("customization page does not open");
                statusTracker(br,driver,"Fail","It does not open phone customization page", "It opens phone customization page", "It should open phone customization page");
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
