//File Name: RT_RO_OS_009
//Author: 
//Description of test case: Order Summary  - In Store Pickup
//Date of creation(D/M/Y): 11/3/2014
//Name and date(D/M/Y) of modification: Raveena Singh  09/06/2014

//Name and date(D/M/Y) of modification: RAHUL JADOW (27/6/2014)
//Modification description: Failure updates
 
package CRH_EBF_Review_OS_OC;

import java.io.File;
import java.util.List;
import java.util.Locale;

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



public class RT_RO_OS_009 extends CommonFunctions{
	
	String table, tns[];
	String tlimit, username, pwd, ctotal, Uname, Tv_plan, Internet_plan,
			Phone_plan, current_service;
	int tncount;
	String serAddress, Internet_service, Tv_service, Phone_service,
			str_Browser;
	
	public RT_RO_OS_009() {
	}

	public RT_RO_OS_009(String s) {
		this.path = s;
		//this.path1 = internet;
		logger.info("RO_OS_009 is intialized");
	}

	@Override
	public void execute(String br,WebDriver driver, String url, int loc,String Overall_Path,String env) throws Exception {
		// logger.info("execute is called");
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
		/*	int tv1 = 0, inet1 = 0, phone1 = 0;
			int val = 1;
			int tlim = Integer.parseInt(tlimit);
			tlim *= 60;
			tlimit = Integer.toString(tlim);
			tlimit = tlimit + "000";*/
			Page_TV = " Page_1_Current Service ";
			Page_Phone="RT_RO_OS_009_";
			// manju variable
	/*		String tv_equipment = sheet2.getCell(17, loc).getContents();
			String tv_equipment2 = sheet2.getCell(20, loc).getContents();
			String int_equipment = sheet2.getCell(18, loc).getContents();*/
			String equipment[]= new String[40];
			
		//	String phone_equipment = sheet2.getCell(19, loc).getContents();
	/*		inet = sheet2.getCell(12, loc).getContents();
			phone = sheet2.getCell(13, loc).getContents();*/
			String cost_current_sevice_input = sheet2.getCell(Col_locator_full_scan_input_sheet("C-TOTAL", path,Sheet_name), loc)
					.getContents();
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
			Thread.sleep(4000);	
				
			//driver.findElement(By.xpath("//*[@name='customize_tv']")).click();
			driver.findElement(By.xpath("//*[@name='upgrade_tv']")).click();
			driver.findElement(By.xpath("//*[@name='select_inet']")).click();
			driver.findElement(By.xpath("//*[@name='select_phone']")).click();
						
				
			//driver.findElement(By.xpath("//*[@id='js-main-form']/nav/a")).click();
			 click_element(".//*[@class='js-next-button blue-button']", driver);
			Thread.sleep(4000);
			//Thread.sleep(4000);
			
			/*driver.findElement(By.xpath("//*[@class='plans']/div[1]/header/ul/li[5]/div/a")).click();
			Thread.sleep(8000);
			//Thread.sleep(4000);
			
			
			driver.findElement(By.xpath(".//*[@class='tv-equipment']/form/div[2]/header/ul/li[1]/a")).click();
			
			 WebElement dropDownListBox = driver.findElement(By.xpath("//*[@data-name='HD Box']"));
            Select clickThis = new Select(dropDownListBox);
            Thread.sleep(2000);
            clickThis.selectByVisibleText("3");
            Thread.sleep(2000);*/
            
			driver.findElement(By.xpath("//*[@data-enrichedname='Standard TV']/li[5]/div/a")).click();
			
			// config_page_Cart_result_updater_TV_Package(driver);
			Thread.sleep(8000);
			driver.findElement(By.xpath(".//*[@class='js-next-button blue-button right']")).click();

            //driver.findElement(By.xpath(".//*[@id='content']/div[3]/div[2]/div/div[2]/div/nav/a[2]/span")).click();//continue
            Thread.sleep(15000);
            
		  //selecting internet plan
            logger.info("selecting internet plan!");
            driver.findElement(By.xpath(".//*[@data-enrichedname='Ultimate 50']/li[5]/div/a")).click();
            Thread.sleep(6000);
            
          //  config_page_Cart_result_updater_Internet_Package(driver);
            driver.findElement(By.xpath(".//*[@class='js-next-button blue-button right']")).click();//continue
            Thread.sleep(4000);
           
            logger.info("selecting phone plan!");
            driver.findElement(By.xpath("//*[@data-enrichedname='Home Phone National']/li[5]/div/a")).click();//select phone plan!
        	Thread.sleep(8000);
        	logger.info("********1******************");
        	
        	//PRivate listing
            driver.findElement(By.xpath("//*[@data-shortname='Private Listing']")).click();
            Thread.sleep(4000);
            
            logger.info("********2******************");
            driver.findElement(By.xpath(".//*[@class='js-next-button blue-button right']")).click();
        	Thread.sleep(4000);
            
        	logger.info("********3******************");
            driver.findElement(By.xpath(".//*[@class='js-next-button blue-button']")).click();
        	Thread.sleep(4000);
            
        	logger.info("********name******************");
        	Thread.sleep(5000);
            //enter username
            driver.findElement(By.xpath("//*[@id='full-name1']")).sendKeys(Uname);
        	Thread.sleep(8000);
        	//Thread.sleep(4000);
        	logger.info("********month******************");
           //enter month 
           /* WebElement dropDownListBox1 = driver.findElement(By.xpath("//*[@id='birth-month']"));
            Select clickThis1 = new Select(dropDownListBox1);
            Thread.sleep(2000);
            clickThis.selectByVisibleText("January");
            Thread.sleep(2000);
            logger.info("********day******************");
            //enter day
            WebElement dropDownListBox2 = driver.findElement(By.xpath("//*[@id='birth-date']"));
            Select clickThis2 = new Select(dropDownListBox2);
            Thread.sleep(2000);
            clickThis.selectByVisibleText("5");
            Thread.sleep(2000);
            logger.info("********year******************");
            //enter year
            WebElement dropDownListBox3 = driver.findElement(By.xpath("//*[@id='birth-year']"));
            Select clickThis3 = new Select(dropDownListBox3);
            Thread.sleep(2000);
            clickThis.selectByVisibleText("1991");
            Thread.sleep(2000);
           */
        	Select_DropDown(driver,"//*[@id='birth-month']", "January");
        	Thread.sleep(2000);
        	Select_DropDown(driver,"//*[@id='birth-date']", "5");
        	Thread.sleep(2000);
        	Select_DropDown(driver,"//*[@id='birth-year']", "1991");
        	
        	Thread.sleep(4000);
        	
            driver.findElement(By.xpath("//*[@id='full-name2']")).sendKeys(Uname);
        	Thread.sleep(4000);
           // config_page_Cart_result_updater_Phone_Package(br,driver);
            Thread.sleep(3000);
            driver.findElement(By.xpath(".//*[@id='order-choose-TWC']")).click();
            Thread.sleep(3000);
           // driver.findElement(By.xpath(".//*[@class='js-next-button blue-button']")).click();
            Thread.sleep(4000);
            
           /* String store_pickup1=driver.findElement(By.xpath("//*[@class='clearfix three-col']/div[1]")).getText();
            String store_pickup2=driver.findElement(By.xpath("//*[@class='clearfix three-col']/div[2]")).getText();
			String store_pickup3=driver.findElement(By.xpath("//*[@class='clearfix three-col']/div[3]")).getText();
			*/
			
			String store_pickup1 = (return_text(
					"//*[@class='clearfix three-col']/div[1]",
					driver).replace("See Map", "")).trim();
			String store_pickup2 = (return_text(
					"//*[@class='clearfix three-col']/div[2]",
					driver).replace("See Map", "")).trim();
			/*String store_pickup3 = (return_text(
					"//*[@class='clearfix three-col']/div[3]",
					driver).replace("See Map", "")).trim();
*/
			
			
			
			
			
			Thread.sleep(4000);
			
			
			
			
			logger.info("1st store pickup address: \n"+ store_pickup1);
			
			logger.info("2nd store pickup address: \n"+ store_pickup2);
			
			//logger.info("3rd store pickup address: \n"+ store_pickup3);
			
			
			String total_monthly_charges=driver.findElement(By.xpath("//*[@title='Monthly Charges']/tfoot/tr/td[2]")).getText();
            
            String one_time_charges=driver.findElement(By.xpath("//*[@title='One Time Charges']/tfoot/tr/td[2]")).getText();
            
            
            String Easy_Connect_Pick_up_Fee=driver.findElement(By.xpath("//*[@class='services-table']/tbody/tr[1]/td[2]")).getText();
            
            String Phone_Activation_Fee=driver.findElement(By.xpath("//*[@class='services-table']/tbody/tr[3]/td[2]")).getText();
            
            
            
            //no service address on RO page!
       //     String service_address=driver.findElement(By.xpath("")).getText();
           
            Thread.sleep(3000);
            driver.findElement(By.xpath("//*[@class='js-next-button blue-button']")).click();
			int flag=0;
			Thread.sleep(4000);
			
		//	  driver.findElement(By.xpath("//*[@id='content']/div[3]/div[2]/div[2]/div/nav/a")).click();
				
	             Thread.sleep(12000);
	 			
					
					
				if(driver.findElement(By.xpath(".//*[@class='sub-header']")).getText().equalsIgnoreCase("Your Order Summary"))	
				{
					logger.info("Order summary page opened!!");
					statusTracker(br,driver,"Pass","Order summary page opened!!!!!","Order summary page opened!!!!!","Order summary page should open!!! ");
				}
				else
				{
					logger.info("Order summary page does not open!!");
					statusTracker(br,driver,"Pass","Order summary page does not open!!!!!","Order summary page does not open!!!!!","Order summary page should open!!! ");
				
				}
			
				Thread.sleep(4000);
				
				 //Image_compare changes -JS Start
					Image_compare(br,env,Page_Phone,Overall_Path,screen_count,driver);
                   screen_count++;
                 //Image_compare changes -JS End
				
			String str,str1;
			
			
			//for TV
			logger.info("*******************for TV Plan********************************************");
			int r,index;
			
			if(driver.findElement(By.xpath("//*[@class='services-table']/tbody/tr[1]/th")).getText().equalsIgnoreCase("TV"))
			{
			logger.info("TV Found!!!!!!!!!!!!!!!!!!!!!!!!!");
			for(int i=0;i<carttotal;i++)
			{
				r=i+2;
				str=driver.findElement(By.xpath("//*[@class='monthly-charges module']/table/tbody/tr["+r+"]/td[1]")).getText();
			//	str1=driver.findElement(By.xpath("//*[@class='services-table']/tbody/tr["+r+"]/td[2]")).getText();
				
				logger.info(str);
				Thread.sleep(4000);
				if(itemname1[i].equalsIgnoreCase(str))
						{
					flag=1;
					continue;
						}
				else
				{
					flag=0;break;
				}
				
			}//for
			
			if (flag==1)
			{
				statusTracker(br,driver,"Pass", "All the tv services added is matching", "All the tv services added is matching", "All the tv services added should match");
				}
			else
			{
				statusTracker(br,driver,"Fail", "All the tv services added is not matching", "All the tv services added is not matching", "All the tv services added should match");
				
			}
			
			logger.info("***********TV price!*****************************************************");
			for(int i=0;i<carttotal;i++)
			{
				r=i+2;
				//str=driver.findElement(By.xpath("//*[@class='monthly-charges module']/table/tbody/tr["+r+"]/td[1]")).getText();
				str1=driver.findElement(By.xpath("//*[@class='services-table']/tbody/tr["+r+"]/td[2]")).getText();
				logger.info("reading "+(i+1)+"th value: "+ str1);
				logger.info(str1);
				Thread.sleep(4000);
				logger.info(itemcost1[i]);
				if(itemcost1[i]!="0")
				 {
				 index=str1.indexOf(" ");
				  str1=str1.substring(0,index);
					str1=str1.replaceAll("[^0-9]","");
					str1="$"+str1;
					logger.info("printing str1");
					logger.info(str1);
					logger.info("check stoped");
					logger.info(itemcost1[i]);
					
					if(("$"+(itemcost1[i].replaceAll("[^0-9]",""))).trim().equalsIgnoreCase(str1.trim()))
					{
						logger.info("Price and time matches!!");
						statusTracker(br,driver,"Pass", "Price and time matches", "Price and time is matching", "Price and time should match");
					    
					}
					else
					{
						logger.info("Price and time does not match!!!!");
						statusTracker(br,driver,"Fail", "Price and time does not match!!!!", "Price and time does not match!!!!", "Price and time should match");
					
					}
					
				 }//end of if(itemcost[i]!="0")
				else if(itemcost1[i]=="0")
				{
					logger.info("enters condition for free or included!!");
					
				if(itemcost1_Free[i].equalsIgnoreCase("Free"))
				{
					logger.info("enters block for free!!");
					logger.info("itemcost1_Free[i]= "+ itemcost1_Free[i]);
					if(itemcost1_Free[i].trim().equalsIgnoreCase(str1.trim()))
					{
						logger.info("Price and time matches(Free)!!");
						statusTracker(br,driver,"Pass", "Price and time matches(Free)", "Price and time is matching(Free)", "Price and time should match(Free)");
					}
					else
					{
						logger.info("Price and time does not match(Free)!!!!");
						statusTracker(br,driver,"Fail", "Price and time does not match(Free)!!!!", "Price and time does not match(Free)!!!!", "Price and time should match (Free)");
					
					}
				}
				else if(itemcost1_Included[i].equalsIgnoreCase("Included"))
					
				{
					logger.info("enters block for included!!");
					logger.info("itemcost1_Included[i]= "+ itemcost1_Included[i]);
					if(itemcost1_Included[i].trim().equalsIgnoreCase(str1.trim()))
					{
						logger.info("Price and time matches(Included)!!");
						statusTracker(br,driver,"Pass", "Price and time matches(Included)", "Price and time is matching(Included)", "Price and time should match(Included)");
					}
					else
					{
						logger.info("Price and time does not match(Included)!!!!");
						statusTracker(br,driver,"Fail", "Price and time does not match(Included)!!!!", "Price and time does not match(Included)!!!!", "Price and time should match (Included)");
					
					}
				}//else if
				}//(i==0)	
					
			}//forloop		
			}//TV
			
			
			
				
			//validating for Internet
		logger.info("*INTERNET Plan***************************************************************");	
	if(driver.findElement(By.xpath(".//*[@class='services-table']/tbody/tr[4]/th")).getText().equalsIgnoreCase("Internet"))
	 {
			
			        for(int i=0;i<carttotal1;i++)
			           {
				          logger.info(driver.findElement(By.xpath("//*[@class='monthly-charges module']/table/tbody/tr["+(5+i)+"]/td[1]")).getText());
				           if(itemname2[i].equalsIgnoreCase(driver.findElement(By.xpath("//*[@class='monthly-charges module']/table/tbody/tr["+(5+i)+"]/td[1]")).getText()))
					        	{
					                flag=1;
					                continue;
						        }
				           else
				               {
					              flag=0;break;
				               }
				
				
			          }
			   if (flag==1)
			   {
				statusTracker(br,driver,"Pass", "All the Internet services added is matching", "All the Internet services added is matching", "All the Internet services added should match");
			   }
			   else
			   {
				statusTracker(br,driver,"Fail", "All the Internet services added is not matching", "All the Internet services added is not matching", "All the Internet services added should match");
				
			   }
			
			logger.info("INTERNET Pricing!*****************************************************");
			logger.info("cartotal1 is0 "+carttotal1);
			    for(int i=0;i<carttotal1;i++)
			      {
				      r=i+5;
				      str1=driver.findElement(By.xpath("//*[@class='services-table']/tbody/tr["+r+"]/td[2]")).getText();
				    //*[@class='services-table']/tbody/tr["+r+"]/td[2]"
				    logger.info("reading "+(i+1)+"th value: "+ str1);
				logger.info(str1);
				Thread.sleep(4000);
				logger.info(itemcost2[i]);
				if(itemcost2[i]!="0")
				 {
				 index=str1.indexOf(" ");
				  str1=str1.substring(0,index);
				//	str1=str1.replaceAll("[^0-9]","");
				//	str1="$"+str1;
					logger.info("printing str1");
					logger.info(str1);
					logger.info("check stoped");
					logger.info(itemcost2[i]);
					
					if((itemcost2[i].trim()).equalsIgnoreCase(str1.trim()))
					{
						logger.info("Price and time matches!!");
						statusTracker(br,driver,"Pass", "Price and time matches", "Price and time is matching", "Price and time should match");
					    
					}
					else
					{
						logger.info("Price and time does not match!!!!");
						statusTracker(br,driver,"Fail", "Price and time does not match!!!!", "Price and time does not match!!!!", "Price and time should match");
					
					}
					
				 }//end of if(itemcost[i]!="0")
				else if(itemcost2[i]=="0")
				{
					logger.info("enters condition for free or included!!");
					
				if(itemcost2_Free[i].equalsIgnoreCase("Free"))
				{
					logger.info("enters block for free!!");
					logger.info("itemcost2_Free[i]= "+ itemcost2_Free[i]);
					if(itemcost2_Free[i].trim().equalsIgnoreCase(str1.trim()))
					{
						logger.info("Price and time matches(Free)!!");
						statusTracker(br,driver,"Pass", "Price and time matches(Free)", "Price and time is matching(Free)", "Price and time should match(Free)");
					}
					else
					{
						logger.info("Price and time does not match(Free)!!!!");
						statusTracker(br,driver,"Fail", "Price and time does not match(Free)!!!!", "Price and time does not match(Free)!!!!", "Price and time should match (Free)");
					
					}
				}
				else if(itemcost2_Included[i].equalsIgnoreCase("Included"))
					
				{
					logger.info("enters block for included!!");
					logger.info("itemcost1_Included[i]= "+ itemcost2_Included[i]);
					if(itemcost2_Included[i].trim().equalsIgnoreCase(str1.trim()))
					{
						logger.info("Price and time matches(Included)!!");
						statusTracker(br,driver,"Pass", "Price and time matches(Included)", "Price and time is matching(Included)", "Price and time should match(Included)");
					}
					else
					{
						logger.info("Price and time does not match(Included)!!!!");
						statusTracker(br,driver,"Fail", "Price and time does not match(Included)!!!!", "Price and time does not match(Included)!!!!", "Price and time should match (Included)");
					
					}
				}//else if
				}//(i==0)	
					
			}//forloop	
	 }//internet	
			//valodating for Phone
			logger.info("*PHONE PlAN**********************************************");
			if(driver.findElement(By.xpath(".//*[@class='services-table']/tbody/tr[7]/th")).getText().equalsIgnoreCase("Phone"))
			  {
			
			        for(int i=0;i<carttotal2;i++)
			           		{
			        	   		if(itemname3[i].equalsIgnoreCase(driver.findElement(By.xpath("//*[@class='monthly-charges module']/table/tbody/tr["+(8+i)+"]/td[1]")).getText()))
			        	   			{
			        	   				flag=1;
			        	   				continue;
			        	   			}
			        	   		else
			        	   			{
			        	   			flag=0;break;
			        	   			}
			           		}
			           if (flag==1)
			           {
			        	   statusTracker(br,driver,"Pass", "All the Phone services added is matching", "All the Phone services added is matching", "All the Phone services added should match");
			           }
			           else
			           {
			        	   statusTracker(br,driver,"Fail", "All the Phone services added is not matching", "All the Phone services added is not matching", "All the Phone services added should match");
				
			           }
			
			
			Thread.sleep(4000);
			logger.info("PHONE PRICE!!***************************************************");
			for(int i=0;i<carttotal2;i++)
			{
				r=i+8;
				//str=driver.findElement(By.xpath("//*[@class='monthly-charges module']/table/tbody/tr["+r+"]/td[1]")).getText();
				str1=driver.findElement(By.xpath("//*[@class='services-table']/tbody/tr["+r+"]/td[2]")).getText();
				
				logger.info("reading "+(i+1)+"th value: "+ str1);
				logger.info(str1);
				Thread.sleep(4000);
				logger.info(itemcost3[i]);
				if(itemcost3[i]!="0")
				 {
				 index=str1.indexOf(" ");
				  str1=str1.substring(0,index);
					str1=str1.replaceAll("[^0-9]","");
					str1="$"+str1;
					logger.info("printing str1");
					logger.info(str1);
					logger.info("check stoped");
					logger.info(itemcost3[i]);
					
					if(("$"+(itemcost3[i].replaceAll("[^0-9]",""))).trim().equalsIgnoreCase(str1.trim()))
					{
						logger.info("Price and time matches!!");
						statusTracker(br,driver,"Pass", "Price and time matches", "Price and time is matching", "Price and time should match");
					    
					}
					else
					{
						logger.info("Price and time does not match!!!!");
						statusTracker(br,driver,"Fail", "Price and time does not match!!!!", "Price and time does not match!!!!", "Price and time should match");
					
					}
					
				 }//end of if(itemcost[i]!="0")
				
				else if(itemcost3[i]=="0")
				{
					logger.info("enters condition for free or included!!");
					
				if(itemcost3_Free[i].equalsIgnoreCase("Free"))
				{
					logger.info("enters block for free!!");
					logger.info("itemcost3_Free[i]= "+ itemcost3_Free[i]);
					if(itemcost3_Free[i].trim().equalsIgnoreCase(str1.trim()))
					{
						logger.info("Price and time matches(Free)!!");
						statusTracker(br,driver,"Pass", "Price and time matches(Free)", "Price and time is matching(Free)", "Price and time should match(Free)");
					}
					else
					{
						logger.info("Price and time does not match(Free)!!!!");
						statusTracker(br,driver,"Fail", "Price and time does not match(Free)!!!!", "Price and time does not match(Free)!!!!", "Price and time should match (Free)");
					
					}
				}
				else if(itemcost3_Included[i].equalsIgnoreCase("Included"))
					
				{
					logger.info("enters block for included!!");
					logger.info("itemcost3_Included[i]= "+ itemcost3_Included[i]);
					if(itemcost3_Included[i].trim().equalsIgnoreCase(str1.trim()))
					{
						logger.info("Price and time matches(Included)!!");
						statusTracker(br,driver,"Pass", "Price and time matches(Included)", "Price and time is matching(Included)", "Price and time should match(Included)");
					}
					else
					{
						logger.info("Price and time does not match(Included)!!!!");
						statusTracker(br,driver,"Fail", "Price and time does not match(Included)!!!!", "Price and time does not match(Included)!!!!", "Price and time should match (Included)");
					
					}
				}//else if
				}//(i==0)	
					
			}//forloop
			  }//phone
			Thread.sleep(4000);
			
			//verifying total monthly charges!
			logger.info("************************verifying total monthly charges!**********************");
       if(driver.findElement(By.xpath("//*[@class='monthly-charges module']/table/tfoot/tr/td[2]")).getText().equalsIgnoreCase(total_monthly_charges)) 
       {
    	   logger.info("Monthly total matching!");
    	   statusTracker(br,driver,"Pass", "Monthly total matching", "Monthly total matching", "Monthly total should match");
       }
       else
       {
    	   logger.info("Monthly total not matching!");
    	   statusTracker(br,driver,"Fail", "Monthly total not matching", "Monthly total not matching", "Monthly total should match");
     
       }
          
       
       //validating fee
       
       Thread.sleep(4000);
             
     //verifying current one time charges!
		logger.info("************************verifying current one time charges!**********************");
  if(driver.findElement(By.xpath("//*[@title='One Time Charges']/tfoot/tr/td[2]")).getText().equalsIgnoreCase(one_time_charges)) 
  {
	   logger.info("one_time_charges total matching!");
	   statusTracker(br,driver,"Pass", "one_time_charges total matching", "one_time_charges total matching", "one_time_charges total should match");
  }
  else
  {
	   logger.info("one_time_charges total not matching!");
	   statusTracker(br,driver,"Fail", "one_time_charges total not matching", "one_time_charges total not matching", "one_time_charges total should match");

  }      
             
             
  //verifying fees!
	logger.info("************************verifying Easy_Connect_Pick_up_Fee fees!**********************");
if(driver.findElement(By.xpath("//*[@class='services-table']/tbody/tr[1]/td[2]")).getText().equalsIgnoreCase(Easy_Connect_Pick_up_Fee)) 
{
 logger.info("Easy_Connect_Pick_up_Fee total matching!");
 statusTracker(br,driver,"Pass", "Easy_Connect_Pick_up_Fee total matching", "Easy_Connect_Pick_up_Fee total matching", "Easy_Connect_Pick_up_Fee total should match");
}
else
{
 logger.info("Easy_Connect_Pick_up_Fee total not matching!");
 statusTracker(br,driver,"Fail", "Easy_Connect_Pick_up_Fee total not matching", "Easy_Connect_Pick_up_Fee total not matching", "Easy_Connect_Pick_up_Fee total should match");

}                  
             
             
logger.info("************************verifying Phone_Activation_Fee fees!**********************");
if(driver.findElement(By.xpath("//*[@class='services-table']/tbody/tr[3]/td[2]")).getText().equalsIgnoreCase(Phone_Activation_Fee)) 
{
 logger.info("Phone_Activation_Fee total matching!");
 statusTracker(br,driver,"Pass", "Phone_Activation_Fee total matching", "Phone_Activation_Fee total matching", "Phone_Activation_Fee total should match");
}
else
{
 logger.info("Phone_Activation_Fee total not matching!");
 statusTracker(br,driver,"Fail", "Phone_Activation_Fee total not matching", "Phone_Activation_Fee total not matching", "Phone_Activation_Fee total should match");
}                  
                  
             
//validating pick up addresses!!             
 logger.info("validating pick up addresses!!");            
 logger.info("***********************store pick up address1***************");
 
 //String store_pickup1 = (return_text(
//	"//*[@class='clearfix three-col']/div[1]",
//	driver).replace("See Map", "")).trim();
 
 
 if(driver.findElement(By.xpath("//*[@class='three-col']/li[1]")).getText().equalsIgnoreCase(store_pickup1)) 
 {
  logger.info("store_pickup1 total matching!");
  statusTracker(br,driver,"Pass", "store_pickup1 total matching", "store_pickup1 total matching", "store_pickup1 total should match");
 }
 else
 {
  logger.info("store_pickup1 total not matching!");
  statusTracker(br,driver,"Fail", "store_pickup1 total not matching", "store_pickup1 total not matching", "store_pickup1 total should match");
 }     
 
 
 
 
    //2         
 logger.info("***********************store pick up address2***************");            
 if(driver.findElement(By.xpath("//*[@class='three-col']/li[2]")).getText().equalsIgnoreCase(store_pickup2)) 
 {
  logger.info("store_pickup1 total matching!");
  statusTracker(br,driver,"Pass", "store_pickup2 total matching", "store_pickup2 total matching", "store_pickup2 total should match");
 }
 else
 {
  logger.info("store_pickup2 total not matching!");
  statusTracker(br,driver,"Fail", "store_pickup2 total not matching", "store_pickup2 total not matching", "store_pickup2 total should match");
 }     
           
 
 
 //3 
 /*     
logger.info("***********************store pick up address3***************");            
if(driver.findElement(By.xpath("//*[@class='three-col']/li[3]")).getText().equalsIgnoreCase(store_pickup3)) 
{
 logger.info("store_pickup3 total matching!");
 statusTracker("Pass", "store_pickup3 total matching", "store_pickup3 total matching", "store_pickup3 total should match");
}
else
{
 logger.info("store_pickup3 total not matching!");
 statusTracker("Fail", "store_pickup3 total not matching", "store_pickup3 total not matching", "store_pickup3 total should match");
} 
 */


//String servAddr=driver.findElement(By.xpath("//*[@class='last']")).getText();

/*String servAddr = (return_text(
		"//*[@class='last']",
		driver).replace(Uname,"")).trim();*/

String servAddr = driver.findElement(By.xpath(".//*[@class='location']")).getText().trim();
logger.info(" service address :   "+ servAddr);
logger.info(" service address from sheet is :   "+ serAddress);

if(servAddr.trim().equalsIgnoreCase(serAddress.trim()))
{
	 logger.info("service address is matching!");
	 statusTracker(br,driver,"Pass", "service address is matching", "service address is matching", "service address should match");
	}
	else
	{
	 logger.info("service address is not matching!");
	 statusTracker(br,driver,"Fail", "service address is not matching", "service address is not matching", "service address should match");
	} 
//*RAVZ*// validating each equipment is shown only once.


List<WebElement> myli=driver.findElements(By.xpath("//*[@id='content']/div[3]/div[2]/div[2]/div/div/div/div[2]/div[1]/div/div[3]/ul/li"));
int count1=myli.size();
flag=1;


logger.info("validating each equipment is shown only once.!!!!!!!!!!!!!!!!!!!!");
for(int k=0;k<count1;k++)
{
	equipment[k]= driver.findElement(By.xpath("//*[@class='order-details details-block']/div[1]/div[3]/ul/li["+(k+1)+"]")).getText();
	
	if(k>0)
	{
		for(int j=0;j<k;j++)
		{
		  for(int l=j+1;l<k;l++)
		   {
			 if(equipment[j]==equipment[l])
			  {
				flag=0;
				break;
			   }
			else
			  {
			 	flag=1;
				continue;
			  }
		   }//l loop
		if (flag==0)
		{
			break;
		}
		}//j loop
	}//if(k>0)
	
	if (flag==0)
		{
			break;
				
		}	
}//for k
if (flag==1)
{
	 logger.info("Only single copy of equipment is displayed!!!!!!!!!!!!!!!!!!!");
	 statusTracker(br,driver,"Pass", "Only single copy of equipment is displayed!", "Only single copy of equipment is displayed!", "Only single copy of equipment is displayed!");
	}
	else
	{
	 logger.info("Only single copy of equipment is not displayed!!");
	 statusTracker(br,driver,"Fail", "Only single copy of equipment is not displayed", "Only single copy of equipment is not displayed", "Only single copy of equipment should be displayed");
	}




















if(driver.findElement(By.xpath("//*[@class='referral-txtbox']")).isDisplayed())
{
	 logger.info("textbox is present!");
	 statusTracker(br,driver,"Pass", "textbox is present", "textbox is present", "textbox should be present");
}
	else
{
	 logger.info("textbox is not present!");
	 statusTracker(br,driver,"Fail", "textbox is not present", "textbox is not present", "textbox should be present");
}

driver.findElement(By.xpath("//*[@id='order-choose-TWC']")).click();

if(driver.findElement(By.xpath("//*[@id='order-choose-TWC']")).isSelected())
{
	logger.info("T&C checkbox selected successfully!!");
}


							
				
}
			
			catch (Exception e)
            {
                        exceptionHandler(br,e, driver);
              
            }
}
            finally {
              wb.close();
      //        wb1.close();
              driver.close();
             
            }
          
        }

	private String substring(int i, int index) {
		// TODO Auto-generated method stub
		return null;
	}
}
