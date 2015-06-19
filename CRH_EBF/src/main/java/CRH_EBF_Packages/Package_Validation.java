package CRH_EBF_Packages;

import com.thoughtworks.selenium.Selenium;

import java.io.File;
//import java.io.PrintStream;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.openqa.jetty.http.SSORealm;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.format.UnderlineStyle;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public  class Package_Validation extends CommonFunctions {
	
	
	public void execute(String br, WebDriver paramDriver, String url, int loc,String Overall_Path,String env)
			throws Exception	{	}

	public void print(String path, String output,String Overall_Path,
			boolean firstpage,String br,int loc,int Test_called) throws Exception {
		  
		  logger.info("RESULTS"+output);
		  logger.info("inp"+path);
	logger.info(" Test_called value inside validation"+Test_called);
	logger.info("^^^^^^^^^^^ Br  and loc value validation is ^^^^^^^^^" +br+" "+loc);
	File data1 = new File(path);
	WorkbookSettings ws1 = new WorkbookSettings();
	File data;
	
	ws1.setLocale(new Locale("er", "ER"));
	Workbook wb1 = Workbook.getWorkbook(data1, ws1); 
	Sheet sheet2 = wb1.getSheet("Packages");
//	Grid_Status=sheet2.getCell(4,3).getContents();
	
	//Grid_Status="No";
	logger.info("validation called");
	WritableWorkbook workbook=null;;
	WritableWorkbook copy=null;;
	WritableSheet sheet1;
	WritableFont TableFormat;
	WritableFont TableFormat1;
	WritableFont TableFormat_summary;
	WritableFont TableFormat1_heading;
	WritableFont TableFormat1_spaceline;
	WritableCellFormat tfb;
	WritableCellFormat tfb1;
	WritableCellFormat tfb1_heading ;
	WritableCellFormat tfb_spaceline;
	WritableCellFormat tfb_spaceline_black;
	WritableCellFormat tfb1_summary ;
	Label lbl;
	

	DecimalFormat df = new DecimalFormat("#0.0");
	String notinit = "Test set was not initiated";
	long st = 0L, et = 0L;
	double diff = 0.0D;
	

	TableFormat = new WritableFont(WritableFont.ARIAL, 9,
			WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE, Colour.BLACK);
	
	TableFormat1 = new WritableFont(WritableFont.ARIAL, 10,
			WritableFont.BOLD, false , UnderlineStyle.NO_UNDERLINE,
			Colour.WHITE);
	 TableFormat_summary = new WritableFont(WritableFont.ARIAL, 10,
			WritableFont.NO_BOLD, false , UnderlineStyle.NO_UNDERLINE,
			Colour.RED);
	 TableFormat1_heading = new WritableFont(WritableFont.TAHOMA, 11,
			WritableFont.BOLD, false , UnderlineStyle.NO_UNDERLINE,
			Colour.WHITE);
TableFormat1_spaceline = new WritableFont(WritableFont.TAHOMA, 11,
			WritableFont.BOLD, false , UnderlineStyle.NO_UNDERLINE,
			Colour.WHITE);
	 tfb = new WritableCellFormat();
	 tfb1 = new WritableCellFormat();
	 tfb1_heading = new WritableCellFormat();
	 tfb_spaceline = new WritableCellFormat();
	 tfb_spaceline_black = new WritableCellFormat();
    tfb1_summary = new WritableCellFormat();
	
	  Workbook workbook_rest_testcase;
	  //WritableWorkbook copy=null;
	  int brinst=2;
    //checking for browser values
	  System.out.println("JS Check " + no_of_browsers);
    /*if(!(no_of_browsers.contains("N")))
//    brinst=(Integer.parseInt(no_of_browsers.replaceAll("[^0-9.]", "")))+1;
  	  brinst=(Integer.parseInt(no_of_browsers.substring(0))+1);
    System.out.println("brinst "+brinst);*/

    if(!(no_of_browsers.contains("N")))
    	brinst=(Integer.parseInt(no_of_browsers.substring(0))+1);

	  
      if(Test_called<brinst)
      {
      	
      /*	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date(et);
			System.out.println("date+time is "+dateFormat.format(date)); //2014/08/06 15:59:48
			String ini=dateFormat.format(date).toString();
			System.out.println("ini "+ini);
			//11-18
			ini=ini.substring(11, 18).replaceAll("[^0-9]", "");
			System.out.println("ini "+ini);
			St_time=Integer.parseInt(ini);
			System.out.println("St_time "+St_time);
			logger.info("St_time +br ",St_time+" "+br);
			*/
      	 diff1 = 0.0D;
		data = new File(output);
		 workbook = Workbook.createWorkbook(data);
		sheet1 = workbook.createSheet("Results", 0);
		// workbook.close();
      }
      else
      {
      	 data = new File(output);
			Workbook workbook1 = Workbook.getWorkbook(data);

           copy = Workbook.createWorkbook(data, workbook1);

           sheet1 = copy.getSheet("Results"); 
      		
      }
		 
		
			
			// logger.info("validation called1");

	
	


	
	

		  
		  // workbook_rest_testcase = Workbook.getWorkbook(data);
			// copy = Workbook.createWorkbook(data, workbook_rest_testcase);
			// sheet1 = copy.getSheet("Results"); 



			
			
		
	// sheet1 = workbook.createSheet("Results", 0);
		TableFormat = new WritableFont(WritableFont.ARIAL, 9,
				WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE, Colour.BLACK);
		
		TableFormat1 = new WritableFont(WritableFont.ARIAL, 10,
				WritableFont.BOLD, false , UnderlineStyle.NO_UNDERLINE,
				Colour.WHITE);
		 TableFormat_summary = new WritableFont(WritableFont.ARIAL, 10,
				WritableFont.NO_BOLD, false , UnderlineStyle.NO_UNDERLINE,
				Colour.RED);
		 TableFormat1_heading = new WritableFont(WritableFont.TAHOMA, 11,
				WritableFont.BOLD, false , UnderlineStyle.NO_UNDERLINE,
				Colour.WHITE);
	 TableFormat1_spaceline = new WritableFont(WritableFont.TAHOMA, 11,
				WritableFont.BOLD, false , UnderlineStyle.NO_UNDERLINE,
				Colour.WHITE);
		 tfb = new WritableCellFormat();
		 tfb1 = new WritableCellFormat();
		 tfb1_heading = new WritableCellFormat();
		 tfb_spaceline = new WritableCellFormat();
		 tfb_spaceline_black = new WritableCellFormat();
	      tfb1_summary = new WritableCellFormat();

	// logger.info("validation called2");
	try {

		if (firstpage) {
			logger.info("Initial time is ",System.currentTimeMillis());
			logger.info("Browser ",br);
			logger.info("validation called3");
			if (loc==first_tc)
			{
				
				
			sheet1.setColumnView(0, 11);
			sheet1.setColumnView(1, 30);
			sheet1.setColumnView(2, 20);
			sheet1.setColumnView(4, 40);
			// sheet1.setColumnView(3, 60);
			tfb.setFont(TableFormat);
			tfb1_heading.setFont(TableFormat1);
			tfb.setAlignment(Alignment.RIGHT);
			tfb.setBorder(Border.NONE,BorderLineStyle.NONE);
			tfb1.setFont(TableFormat1);
			tfb1_summary.setFont(TableFormat);
			tfb1_summary.setBorder(Border.ALL, BorderLineStyle.MEDIUM);
			tfb1_summary.setAlignment(Alignment.CENTRE);
			tfb1.setBackground(Colour.INDIGO);
			tfb1_heading.setBackground(Colour.DARK_RED);
			tfb1_heading.setBorder(Border.ALL, BorderLineStyle.THICK);
			tfb1.setBorder(Border.ALL, BorderLineStyle.THIN);
			tfb1.setAlignment(Alignment.CENTRE);
			tfb1_heading.setAlignment(Alignment.CENTRE);
			
			tfb_spaceline.setFont(TableFormat1_spaceline);
		//	tfb_spaceline.setBorder(Border.ALL, BorderLineStyle.THICK);
			tfb_spaceline.setBackground(Colour.PALETTE_BLACK);
			tfb1_heading.setBorder(Border.RIGHT, BorderLineStyle.THICK);
			tfb1_heading.setBorder(Border.TOP, BorderLineStyle.THICK);
			tfb1_heading.setBorder(Border.BOTTOM, BorderLineStyle.THICK);
			tfb_spaceline_black.setBackground(Colour.PALETTE_BLACK);
			
			
			
		//	tfb_spaceline.setBackground(Colour.BLACK);
			
			tfb.setBackground(Colour.GREY_25_PERCENT);
			sheet1.mergeCells(0,0,4,0);
			sheet1.mergeCells(0,1,1,8);
			sheet1.mergeCells(2,1,3,1);
			sheet1.mergeCells(2,8,3,8);
			sheet1.mergeCells(4,1,4,8);
			
			lbl = new Label(0, 0, "EBF BUYFLOW REGRESSION HARNESS - PACKAGE REGRESSION - TEST RESULTS", tfb1_heading);
			sheet1.addCell(lbl);
			lbl = new Label(2,1, "", tfb);
			sheet1.addCell(lbl);
			lbl = new Label(0,1, "", tfb);
			sheet1.addCell(lbl);
			lbl = new Label(2,8, "", tfb);
			sheet1.addCell(lbl);
			lbl = new Label(4,1, "", tfb);
			sheet1.addCell(lbl);
			
			//lbl = new Label(0,0, "", tfb1_heading);
			//sheet1.addCell(lbl);
			
			sheet1.mergeCells(2,2,3,2);
			lbl = new Label(2, 2, "Execution Summary", tfb1);
			sheet1.addCell(lbl);
			tfb.setFont(TableFormat);
			lbl = new Label(0, 9, "Test Case",
					tfb1);
			sheet1.addCell(lbl);
			lbl = new Label(1, 9, "Test Scenario", tfb1);
			sheet1.addCell(lbl);

			lbl = new Label(2, 9, "Status", tfb1);
			sheet1.addCell(lbl);
			lbl = new Label(3, 9, "Actual Result", tfb1);
			sheet1.addCell(lbl);
			lbl = new Label(4, 9, "Expected Result", tfb1);
			sheet1.addCell(lbl);
			
			}
			tfb_spaceline.setBackground(Colour.PALETTE_BLACK);
			int i = 0;
			
			

			/*File Pass_a=new File (Overall_Path+"//"+"Test_Results"+"//"+"CRH_ABF_Phone_Pass_Screenshots");
	        deleteFolder(Pass_a);
	        File Fail_a=new File (Overall_Path+"//"+"Test_Results"+"//"+"CRH_ABF_Phone_Fail_Screenshots");
	        deleteFolder(Fail_a);
	        File Exception_a=new File (Overall_Path+"//"+"Test_Results"+"//"+"CRH_ABF_Phone_Exception_Screenshots");
	        deleteFolder(Exception_a);*/
	        System.out.println("overrrrr"+Overall_Path);
	        
			logger.info("validation called4");
			logger.info("*******check1.1");
			logger.info("*******check1");
				logger.info("*******check2");
			 File data11 = new File(path);
				logger.info("*******check3");
				WorkbookSettings ws11 = new WorkbookSettings();
				logger.info("*******check4");
				ws11.setLocale(new Locale("er", "ER"));
				logger.info("*******check5");
				Workbook wb11 = Workbook.getWorkbook(data11, ws11);
			//	Sheet sheet2 = wb1.getSheet(0);
				logger.info("*******check6");
				Sheet sheet11 = wb11.getSheet("Packages");
				logger.info("*******check7");
				int LastRow=sheet11.getRows();
				logger.info("*******check8");
				logger.info("Sep1---> number of rows "+LastRow);
				
				
		    
			//do {
				
				
				
			//	Map br_specific= new HashMap<String, List<Result_bean>>();
				
				// logger.info("validation called5");

				// String exec1 = sheet2.getCell(4, loc).getContents();
				// String name1 = sheet2.getCell(8,loc).getContents();

				// logger.info("location");

				// data1 = new File(path);
				
				logger.info("location_b");
				 data1 = new File(path);
				 logger.info("pathh 123"+path);
				 logger.info("overall 123 "+Overall_Path);
				 ws1 = new WorkbookSettings();
				
				ws1.setLocale(new Locale("er", "ER"));
				 wb1 = Workbook.getWorkbook(data1, ws1); 
				 sheet2 = wb1.getSheet("Packages");
				 String Sheet_name = sheet2.getName();
				  //to read the environment
					String env = sheet2.getCell(2,2).getContents();
					
					String exec1 = sheet2.getCell(Col_locator_full_scan_input_sheet("Execute (Y/N)", path,Sheet_name), loc).getContents();
					logger.info("EXEc1"+exec1);
			        String name1 = sheet2.getCell(Col_locator_full_scan_input_sheet("CHILD TEST CASE",path,Sheet_name),loc).getContents();
			        pass_screenshot=sheet2.getCell(Col_locator_full_scan_input_sheet("Pass Screenshot Option(Y/N)",path,Sheet_name),loc).getContents();
			        System.out.println("pathh 234"+path);
				logger.info("location_a");
				String gr=sheet2.getCell(4,3).getContents();
				logger.info("Grid status "+gr);
				if(gr.equalsIgnoreCase("No"))
				br= sheet2.getCell(2, loc).getContents();
				logger.info("br valueis^^^^^^^^^:"+br);	
					if(pass_screenshot.equalsIgnoreCase("Y"))
					{
						pass_screenshot_required=true;
					}
					else
					{
						pass_screenshot_required=false;
					}
				// logger.info("name 1 is :"+name1);
				// Page_Internet=name1+"_";
				// logger.info(Page_Internet);
				// logger.info("exe11 is"+exec1);
				// logger.info("loc is " +loc);
				
					
					
				wb1.close();

				// logger.info("location1");
				logger.info("location_C");
				logger.info("exec1 "+exec1+" loc "+loc);
				if ((exec1.equals("Y")) || (exec1.equals("y"))) {
					logger.info("location_d");
					int i_browser=0;
					while(browser[i_browser]!=null)
					{
						if(browser[i_browser].equals(br))
						{
							logger.info("location_2");
							counter_result_initial[i_browser]=counter_result_sheet[i_browser];
							logger.info("Beginning of d test case counter_result_initial[i_browser] is "+counter_result_initial[i_browser]);
							l_browser[i_browser]=0;
							break;
						}
						i_browser++;
					}
					
					logger.info("location_f");
					int pass=0;
					
					
					// logger.info("cat_addtv");
					
					st = System.currentTimeMillis();
					logger.info("Initial Time and br :",st);
					logger.info("Starting execution!!");
					System.out.println("Initial Time "+st);
					
								 
					if (loc == Row_locator_full_scan_validation("RT_Package_001",path,"Packages"))
						pass +=obj_run(new RT_Package_001(path), 0,
								sheet1, name1, loc,Overall_Path,br_specific,br,env);
					if (loc == Row_locator_full_scan_validation("RT_Package_002",path,"Packages"))
						pass += obj_run(new RT_Package_002(path), 0,
								sheet1, name1, loc,Overall_Path,br_specific,br,env);
					if (loc == Row_locator_full_scan_validation("RT_Package_003",path,"Packages"))
						pass += obj_run(new RT_Package_003(path), 0,
								sheet1, name1, loc,Overall_Path,br_specific,br,env);
					if (loc == Row_locator_full_scan_validation("RT_Package_004",path,"Packages"))
						pass += obj_run(new RT_Package_004(path), 0,
								sheet1, name1, loc,Overall_Path,br_specific,br,env);
					if (loc == Row_locator_full_scan_validation("RT_Package_005",path,"Packages"))
						pass += obj_run(new RT_Package_005(path), 0,
								sheet1, name1, loc,Overall_Path,br_specific,br,env);
					if (loc == Row_locator_full_scan_validation("RT_Package_006",path,"Packages"))
						pass += obj_run(new RT_Package_006(path), 0,
								sheet1, name1, loc,Overall_Path,br_specific,br,env);
					if (loc == Row_locator_full_scan_validation("RT_Package_007",path,"Packages"))
						pass += obj_run(new RT_Package_007(path), 0,
								sheet1, name1, loc,Overall_Path,br_specific,br,env);
					if (loc == Row_locator_full_scan_validation("RT_Package_008",path,"Packages"))
						pass += obj_run(new RT_Package_008(path), 0,
								sheet1, name1, loc,Overall_Path,br_specific,br,env);
					if (loc == Row_locator_full_scan_validation("RT_Package_011",path,"Packages"))
						pass += obj_run(new RT_Package_011(path), 0,
								sheet1, name1, loc,Overall_Path,br_specific,br,env);
					if (loc == Row_locator_full_scan_validation("RT_Package_012",path,"Packages"))
						pass += obj_run(new RT_Package_012(path), 0,
								sheet1, name1, loc,Overall_Path,br_specific,br,env);
				 
					  i_browser=0;
					  logger.info("Validation******* after obj_run");
						while(browser[i_browser]!=null)
						{
							if(browser[i_browser].equals(br))
							{
								logger.info("RESULT_SHEET VALUE AFTER OBJ_RUN= FINAL counter_result_sheet: "+counter_result_sheet[i_browser]);
								counter_result_final[i_browser]=counter_result_sheet[i_browser];
								counter_result_initial[i_browser]++;
								//counter_result_final[i_browser]++;
								break;
							}
							i_browser++;
						}
						
						  logger.info("Validation******* after obj_run2");
						
							
							  i_browser=0;
							  logger.info("browser[i_browser] "+browser[i_browser]);
							  logger.info("Validation******* after obj_run23");
							  i_browser=0;
							  while(browser[i_browser]!=null)
							  {
								if(browser[i_browser].equals(br))
									{
								/*	if(loc!=20)
									{
										logger.info("NOT INITIAL");
										counter_result_final[i_browser]=counter_result_final[i_browser];
									}
									*/
									logger.info(" Merging testname cell ");
									logger.info("br "+br);
									logger.info("counter_result_initial[i_browser] "+counter_result_initial[i_browser]);
									logger.info("counter_result_final[i_browser] "+ (counter_result_final[i_browser]));
									logger.info("i_browser n loc respectively  "+i_browser+" "+loc);
									sheet1.mergeCells(0,counter_result_initial[i_browser],0,((counter_result_final[i_browser]-1)));
									}
								i_browser++;
							}
						//tfb_spaceline.setBackground(Colour.BLACK);
					
					//	lbl = new Label(0, counter_result_final, "", tfb_spaceline);
					//	sheet1.addCell(lbl);
					//	tfb1.setBackground(Colour.BLACK);
							 logger.info("Validation******* after obj_run234");
							i_browser=0;
							//int black;
							while(browser[i_browser]!=null)
							{
								if(browser[i_browser].equals(br))
								{
									//counter_result_final[i_browser]=counter_result_final[i_browser]+1;
									logger.info("Validation "+i_browser+" browser "+browser[i_browser]);
									logger.info("Merging 0 ,"+counter_result_final[i_browser] +",4,"+ counter_result_final[i_browser]);
								/*	if(loc==20)
									{
										counter_result_final[i_browser]=	counter_result_final[i_browser];
									}
								*/	
										sheet1.mergeCells(0,(counter_result_final[i_browser]),4,(counter_result_final[i_browser]));
										//		black[bl]=counter_result_final[i_browser];
										//			bl++;
										//black=counter_result_final[i_browser];
										Label lbl_spaceline = new Label(0, (counter_result_final[i_browser]), "", tfb_spaceline);
										sheet1.addCell(lbl_spaceline);
										counter_result_sheet[i_browser]=counter_result_final[i_browser];
										total[i_browser]++;
										break;
								}
								i_browser++;
							}
							
							logger.info("Validation******* after obj_run2345");
						
							 logger.info("Validation******* after obj_run23456");
						/*	i_browser=0;
							while(browser[i_browser]!=null)
							{
								if(browser[i_browser].equals(br))
								{		
								
								//	total[i_browser]++;
									break;
								}
								i_browser++;
							}
							*/
							
							 
							 
							 
							 
							 
							 
					et = System.currentTimeMillis();
					System.out.println("end time "+et);
					diff = et - st;
					diff /= 60000.0D;
					diff1 += diff;
					logger.info("Final time and br is  ",et+" "+br + "loc " + loc);
					System.out.println("total time difference when loc is "+loc+" is "+diff1);
					//logger.info("Browser ",br);
					 logger.info("Validation******* after obj_run27");
				}

				else {
					int i_browser=0;
					while(browser[i_browser]!=null)
					{
						if(browser[i_browser].equals(br))
						{		
						
							no_run[i_browser]++;
							break;
						}
						i_browser++;
					}
				 }
				i++;
			//	loc++;

			//} while (loc < LastRow);

			logger.info("Catalyst is complete");
		} else {
			logger.info("Check for entering this loop");
			lbl = new Label(1, 3, notinit);
			sheet1.addCell(lbl);
		}
		
		{
	  
			logger.info("check1");
			logger.info("Test completed yes or NO inside validation is"+TestCompleted);
			//copy.write();
			//copy.close();
			//tear();
			logger.info("Workbook closed: LS");
			}
		
		} catch (Exception e) {
		lbl = new Label(3, 0,
				"Intermediate error has occured which has stopped execution");
		sheet1.addCell(lbl);
		lbl = new Label(3, 1, e.getMessage());
		sheet1.addCell(lbl);
	} finally {
		
		
		
		/*
		 DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date(et);
			System.out.println("enddate+time is "+dateFormat.format(date)); //2014/08/06 15:59:48
			String ini=dateFormat.format(date).toString();
			System.out.println("ini "+ini);
			//11-18
			ini=ini.substring(11, 18).replaceAll("[^0-9]", "");
			System.out.println("ini "+ini);
			end_time=Integer.parseInt(ini);
			System.out.println("end_time "+end_time);
			logger.info("end_time +br ",end_time+ " "+br);
			
			Long tt = end_time-St_time;
			logger.info("TOTAL TIME IS ",tt);
			*/
		//Label lbl_spaceline = new Label(0, black, "", tfb_spaceline);
	//	sheet1.addCell(lbl_spaceline);
	
	//	lbl = new Label(0,1, "", tfb);
	//	sheet1.addCell(lbl);
		
		
		logger.info("Validation******* after obj_run28");
		 
		lbl = new Label(2,3, "Accounts Executed:", tfb1_summary);
		sheet1.addCell(lbl);
		lbl = new Label(2,4, "Accounts Passed: ", tfb1_summary);
		sheet1.addCell(lbl);
		lbl = new Label(2,5, "Accounts Failed: ", tfb1_summary);
		sheet1.addCell(lbl);
		lbl = new Label(2,6, "Accounts Not Executed: ", tfb1_summary);
		sheet1.addCell(lbl);
		
		/*
		Number nmbr = new Number(3, 4, pass,tfb1_summary);
		sheet1.addCell(nmbr);
		logger.info("#####################################################");
		logger.info("total"+total);
		logger.info("pass"+pass);
		nmbr = new Number(3, 5, total - pass,tfb1_summary);
		logger.info("nmbr is "+nmbr);
		logger.info("#####################################################");
		sheet1.addCell(nmbr);
		nmbr = new Number(3, 3, total,tfb1_summary);
		sheet1.addCell(nmbr);
		// no_run=26-total;
		nmbr = new Number(3, 6, no_run,tfb1_summary);
		sheet1.addCell(nmbr);
*/
		if (diff1 != 0.0D) {
			String yash = df.format(diff1);
			diff1 = Double.parseDouble(yash);
			lbl = new Label(2,7, "Total Time: ", tfb1_summary);
			sheet1.addCell(lbl);
		int	i_browser=0;
			while(browser[i_browser]!=null)
			{
				if(browser[i_browser].equals(br))
				{
					if (total[i_browser] == 0)
						diff1 = 0.0D;
					break;
				}
				i_browser++;
			}
			lbl = new Label(3,7, diff1 + " minutes(ms)",tfb1_summary);
			sheet1.addCell(lbl);
			
			while(browser[i_browser]!=null)
			{
				if(browser[i_browser].equals(br))
				{
					logger.info("#####################################################");
						Number nmbr = new Number(3, 4, pass_br_wise[i_browser],tfb1_summary);
					sheet1.addCell(nmbr);
					break;
				}
				i_browser++;
			}
			
			
			
			
			
			 logger.info("Validation******* after obj_run29");
			 i_browser=0;
				while(browser[i_browser]!=null)
				{
					if(browser[i_browser].equals(br))
					{
				
				logger.info("total"+total[i_browser]);
				//logger.info("pass"+pass);
				Number nmbr = new Number(3, 5, total[i_browser] - pass_br_wise[i_browser],tfb1_summary);
				logger.info("nmbr is "+nmbr);
				
				sheet1.addCell(nmbr);
			nmbr = new Number(3, 3, total[i_browser],tfb1_summary);
			sheet1.addCell(nmbr);
			nmbr = new Number(3, 6, no_run[i_browser],tfb1_summary);
			sheet1.addCell(nmbr);
			break;
				}
				i_browser++;
				}
				// no_run=26-total;
				
			}
		
		logger.info("#####################################################");
		logger.info("Workbook closed: LS");
	    if(Test_called<brinst)
      {
	    	logger.info("Test_caled value inside IF part : "+Test_called +"  and br value  :"+ br);
	    	workbook.write();
	    	workbook.close();
      }
	    else
	    {
	    	logger.info("Test_caled value inside ELSE part : "+Test_called +"  and br value  :"+ br);
	    	copy.write();
	    	copy.close();
	    }
	    //Failure assertion changes -sruthy
	       logger.info("JS Browser is " +br);
	       int i_browser = 0;
	       logger.info("JS " + browser[i_browser] +" " + l_browser[i_browser]);
	       while (browser[i_browser] != null) {
	       if (browser[i_browser].equals(br))
	       for (int jo = 0; jo < l_browser[i_browser]; jo++){
	              logger.info("Array iteration " + result_array[i_browser * 4][jo]);
	       if(result_array[i_browser * 4][jo].contains("Fail"))
	       {
	              logger.info("Failure assertion for " + result_array[i_browser * 4][jo] + br + Test_called );
	              Assert.fail("Expected and Actual result does not match " );
	       }
	       }
	       i_browser++;
	       }
	       //Failure assertion changes -sruthy

		//tear();

	}
}
			}