//File Name: RT_Phone_005
//Author: Raveena Singh
//Description of test case: Customer is eligible to upgrade Phone LOB
//Date of creation(D/M/Y): 11/3/2014
//Name and date(D/M/Y) of modification: Pradeep Shetty / 9/6/2014
//Modification description:
//  a) change the all the xpath�s to unique property 
//  b) Removed all the unwanted print statements & comments.
//  c) Added comments to the steps wherever needed.
//  d) Updated Status tracked if change needed
//  e) Updated as per jagdeesh@Buyflow review comments


package CRH_EBF_Phone;

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

public class RT_Phone_005 extends CommonFunctions {

       

                           String table, tns[];
                           String tlimit, username, pwd, ctotal, Uname, Tv_plan, Internet_plan,Phone_plan, current_service;
                           int tncount;
                           String serAddress, Internet_service, Tv_service, Phone_service;

                           static String testCaseName, passScrShot;

                       	public String getTestCaseName() {
                       		return testCaseName;
                       	}

                    	public static String getPassScreenshot() {
                    		return passScrShot;
                    	}
                    	
       public RT_Phone_005()
       {
   		testCaseName = this.getClass().getSimpleName();
		try {
			passScrShot = sheet11.getCell(4, Row_locator_full_scan_validation(testCaseName,inputfile,"Phone")).getContents();
		} catch (BiffException e) {
			logger.info(e.getMessage());
		} catch (IOException e) {
			logger.info(e.getMessage());
		}
       }

       public RT_Phone_005(String s) 
       {
   		testCaseName = this.getClass().getSimpleName();
		try {
			passScrShot = sheet11.getCell(4, Row_locator_full_scan_validation(testCaseName,inputfile,"Phone")).getContents();
		} catch (BiffException e) {
			logger.info(e.getMessage());
		} catch (IOException e) {
			logger.info(e.getMessage());
		}
                           this.path = s;
                       //    this.path1 = internet;
                           logger.info("add Phone is intialized");
       }

       public boolean Isavailable(String fxp, WebDriver driver) 
       {
                      boolean xy = true;
                         try {
                           if (driver.findElement(By.xpath(fxp)) != null) 
                           {
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

       public void execute(String br,WebDriver driver,String url, int loc)throws Exception {
              // logger.info("execute is called");
    	   					int screen_count = 1;
                           File data = new File(this.path);
                           WorkbookSettings ws = new WorkbookSettings();
                           ws.setLocale(new Locale("er", "ER"));
                           //arrcount = 0;
                           logger.info("chheck1");
                           Workbook wb = Workbook.getWorkbook(data, ws);
              
                          /* File data1 = new File(this.path1);
                           WorkbookSettings ws1 = new WorkbookSettings();
                           ws1.setLocale(new Locale("er", "ER"));
                           Workbook wb1 = Workbook.getWorkbook(data1, ws1);*/

                         try {
                        	 Page_Phone="RT_Phone_005_";
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

               

                         if (first == 0) {
                           logger.info("trying to open the url");
                           driver.manage().window().maximize();
                           driver.get(url);
                           logger.info("Chek if url opened");
                           // statusTracker(br,driver,"Pass", " ", " ", " ");
                         }

              try 
                           {
                           if(first==0)
                             firstrun(br,driver,username,pwd,ctotal,Uname,serAddress);
                             logger.info("I went to next step");
                           
   
                            //validation of twc logo 
                            Phone_TWClogo(br,driver);
             				Thread.sleep(8000);
             				
             				 //Validation of User Name
             				Phone_Username(br,driver,loc);
             				Thread.sleep(8000);
             	
                  
//Validation of current service monthly charge and $ sign
                                                                     
                                                                     
                                                                     
                                                                    String CurrSer =driver.findElement(By.xpath("//*[@class='sub-header black-header']/span")).getText();
                                                                    logger.info(CurrSer);
                                                                    String strfind="$";
                                                                    int iSuccess = CurrSer.indexOf(strfind);
                                                                    logger.info("",iSuccess);
                                                                    
                                                                    if(iSuccess==0)
                                                                                    {
                                                                                    logger.info("$ not present");
                                                                                    statusTracker(br,driver,"Fail", "$ sign present in current service monthly charges", "$ not present", "$ should be present");
                                                                                    }

                                                                    else
                                                                                    {
                                                                                    logger.info("$ present");
                                                                                    statusTracker(br,driver,"Pass", "$ sign present in current service monthly charges", "$ present", "$ should be present");
                                                                                    }          


                                                                                    int iStartAmount= iSuccess+1;
                                                                                    String per= "per";


                                                                                    int iSpace=CurrSer.indexOf(per);
                                                                                    int iEndAmount=iSpace-1;
                                                                                    logger.info("",iSpace);
                                                                                
                                                                                    String sAmount = CurrSer.substring(iStartAmount,iEndAmount);
                                                                                    logger.info(sAmount);
                                                                                    
                                                                                    if(sAmount.equals(ctotal))
                                                                                                    {
                                                                                                    logger.info("Pass");
                                                                                                    statusTracker(br,driver,"Pass", "current service monthly charges should match as per the user", "Amount matches", "Amount should match");
                                                                                                    }          
                                                                                    
                                                                                    else
                                                                                                    {
                                                                                                    logger.info("Fail");
                                                                                                    statusTracker(br,driver,"Fail", "current service monthly charges should match as per the user", "Amount doesnt match", "Amount should match");
                                                                                                    }
                                                   
                                             // Validate Internet as your Current service
                                                                                    
                                              Internet_los_verify(br,Internet_plan, Internet_service,driver);
                                               Thread.sleep(5000);
                                                  
                                               
                                               // Validate TV & Phone LOB
                                              // Tv_Phone_lob_verify(br,driver);
                                               Thread.sleep(5000);
                                      
                                                                                    

                               				// Eligible to add new LOB-Phone
                                               
                                               click_element(".//*[@name='select_phone']",
                                  						driver);
                               				//click_element(".//*[@class='services']/li[2]/div[3]/label/input",driver);
                               					
                               				Thread.sleep(2000);
                               				if ((driver.findElement(By
                               						.xpath("//*[@id='js-main-form']/nav/a")).isEnabled())) {
                               					logger.info("pass1");
                               					statusTracker(br,driver,"Pass", "Customer eligible to add new LOB-Phone",
                               							"Customer is eligible to add new LOB-Phone", "Customer should be eligible to add new LOB-Phone");
                               				} else {
                               					logger.info("fail1");
                               					statusTracker(br,driver,"Fail", "Customer eligible to add new LOB-Phone",
                               							"Customer is not eligible to add new LOB-Phone", "Customer should be eligible to add new LOB-Phone");
                               				}
                            	
                            			
                            				if(url.contains("beta"))
                           					 
                           				 {String env ="Beta";
                           				Image_compare(br,env,Page_Phone,spath,screen_count,driver);

                           				Thread.sleep(15000);
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
                               				
               				    		 // CLick on continue button to navigate to the next page
               							driver.findElement(By.xpath("//*[@class='button-nav ']/a")).click();
               					
               							Thread.sleep(8000);

               							if (return_text(".//*[@class='left']/h2",driver).trim().equals("Choose Your Phone Plan"))
               								statusTracker(br,driver,"Pass",
               										"Click the Continue Button",
               										"User is navigated to the Phone Customization page",
               										"User should navigate to the Phone Customization page.");
               							else
               								statusTracker(br,driver,"Fail",
               										"Click the Continue Button",
               										"User is NOT navigated to the Phone Customization page",
               										"User should navigate to the Phone Customization");                                          
                                                                                    
                                                                  		
                                                                                    driver.quit();                              			 
                                                                                    		
                                                  }            
                                              
                                                                                                    catch (Exception e)
                                                                                                    {
                                                                                                                exceptionHandler(br,e, driver);
                                                                                                      
                                                                                                    }
                                                }
                                                                                                    finally {
                                                                                                      wb.close();
                                                                                               
                                                                                                      driver.close();
                                                                                                     
                                                                                                    }
                                                                                                  
                                                                                                }
  }

