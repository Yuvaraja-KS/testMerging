package CRH_EBF_Phone;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.read.biff.BiffException;

import org.openqa.selenium.WebDriver;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.apache.log4j.xml.DOMConfigurator;

import CRH_EBF_Phone.Result_bean;

@Listeners(AnnotationListener.class)
public class CRH_EBF_Phone_test extends CommonFunctions {
	
	public int loc;
	int Test_called = 0;
	static int first_row;
	static int LastRow;
	static int numberOfTestCases;
	
	static ArrayList<Result_bean> result_FF = new ArrayList<Result_bean>();
	static ArrayList<Result_bean> result_Chrome = new ArrayList<Result_bean>();
	static ArrayList<Result_bean> result_IE = new ArrayList<Result_bean>();
	static ArrayList<Result_bean> result_IE10 = new ArrayList<Result_bean>();
	static ArrayList<Result_bean> result_IE11 = new ArrayList<Result_bean>();
	static ArrayList<Result_bean> result_Common = new ArrayList<Result_bean>();
	@BeforeClass
	public void Reader() throws IOException, BiffException,InterruptedException
	{
		
		DOMConfigurator.configure("Regression_EBF.xml");
		/*
		File dir1 = new File(".");
		spath = dir1.getCanonicalPath();
		spath = spath.replaceAll("////", "////////");
		logger.info(""+"Path "+spath);
		Load_Properties_File(spath);
	
		inputfile=spath+path_config.getProperty("inputSheetEBF");
		*/
		outputfile=spath+path_config.getProperty("resultSheetPhone");
		logger.info(""+"Path "+spath);
		
		//computer_name folder changes -ankita
        String computerName=InetAddress.getLocalHost().getHostName();
        System.out.println(computerName);
        logger.info("Computer Name~~~~~~~~~~~"+computerName);
        newFolderPCName=computerName + "_Test_Results";
        File dir = new File(spath+"//Test_Results//"+newFolderPCName);
        dir.mkdir();
        outputfile=outputfile.replaceAll("Test_Results", "Test_Results//"+newFolderPCName);
      //computer_name folder changes -ankita
		
		logger.info(""+"inputfile "+inputfile+" outputfile "+outputfile);
		/*
		data11 = new File(inputfile);
		
		
		ws11 = new WorkbookSettings();
		ws11.setLocale(new Locale("er", "ER"));
		wb11 = Workbook.getWorkbook(data11, ws11);
		sheet11 = wb11.getSheet("Phone");
		gr=sheet11.getCell(4,3).getContents();
		*/
		Grid_Status=gr;
		Sheet_name = sheet11.getName();
		
		no_of_browsers=sheet11.getCell(5,3).getContents();
        no_of_browsers=no_of_browsers.substring(0,1);
        
		first_row=Row_locator_full_scan_validation("CHILD TEST CASE",inputfile,"Phone")+1;
		LastRow=sheet11.getRows();
		logger.info(""+"first_row "+first_row);
		int counter = 0;
		for( int im=first_row;im<LastRow;im++)
		{
			String tc1= sheet11.getCell(3, im).getContents();
			logger.info(""+"TC1 "+tc1+" name "+sheet11.getCell(0, im).getContents());
			logger.info(""+"TC1 "+tc1+" im varialble "+im);
			if(tc1.equalsIgnoreCase("Y"))
			{
				if(first_tc == 0) {
					first_tc=im;
				}
				
				counter++;
			}
			
		}
		numberOfTestCases = counter;
		//Auto launch grid config changes -venki
	       if(gr.equalsIgnoreCase("Yes"))
           {

                 String new_dir= spath + "//Supporting_Lib";
                 String new_dir1= spath +"//Resource//Browser_Drivers";
                 Runtime.getRuntime().exec("cmd.exe /c cd \""+new_dir+"\"& start cmd.exe /k \"java -jar selenium-server-standalone-2.45.0.jar -role hub\" ");
                 Thread.sleep(10000);
                 Runtime.getRuntime().exec("cmd.exe /c cd \""+new_dir1+"\"& start cmd.exe /k \"java -Dwebdriver.chrome.driver="+new_dir1+"\\\\chromedriver.exe -Dwebdriver.ie.driver="+new_dir1+"\\\\IEDriverServer.exe -jar selenium-server-standalone-2.45.0.jar -role webdriver -hub http://localhost:4444/grid/register -port 5556 -browser browserName=firefox,maxInstances="+ counter +" -browser browserName=chrome,maxInstances="+ counter +" -browser browserName=iexplore,maxInstances=0 -maxSession "+ (counter * Integer.parseInt(no_of_browsers)) +"\" ");
                 logger.info("counter - "+counter + " Sessions - " + counter * Integer.parseInt(no_of_browsers));
                 Thread.sleep(15000);
           }
	     //Auto launch grid config changes -venki
		
		for(int c=0;c<10;c++)
		{
			total[c]=0;
			counter_result_sheet[c]=10;
			counter_result_initial[c]=9;
			logger.info(""+"RO initialized");
			ro[c]=10;
			l_browser[c]=0;
			pass_br_wise[c]=0;
			no_run[c]=0;
			 black[c]=0;
			 arrcount[c]=0;
		}
		//computer_name folder changes -ankita
        File Pass_a = new File(spath + "//" + "//Test_Results"+"//"+newFolderPCName+"//"+"CRH_EBF_Phone_Pass_Screenshots////");
        deleteFolder(Pass_a);
        File Fail_a = new File(spath + "//" + "//Test_Results"+"//"+newFolderPCName+"//"+"CRH_EBF_Phone_Fail_Screenshots////");
        deleteFolder(Fail_a);
        File Exception_a = new File(spath + "//"+ "//Test_Results"+"//"+newFolderPCName+"//"+"CRH_EBF_Phone_Exception_Screenshots////");
        deleteFolder(Exception_a);
       File BC_NewImage = new File(spath + "//"+ "//Test_Results"+"//"+computerName+"_BC_New_Images");
        deleteFolder(BC_NewImage);

      //computer_name folder changes -ankita

	}
	
	
	
	
	@DataProvider(parallel=true)
	public String[][] getData() throws IOException, BiffException{
		logger.info("Getting inside");
		
		int col_num = Column_locator_scan_validation("CHILD TEST CASE",inputfile,"Phone");
		int counter = 0;
		
		no_of_browsers=sheet11.getCell(5,3).getContents();
		logger.info(no_of_browsers);
		no_of_browsers=no_of_browsers.substring(0, 1);
		if(gr.equals("Yes"))
		{			
			logger.info("no_of_browsers "+no_of_browsers);			

			String[][] data = new String[(LastRow - first_row) * Integer.parseInt(no_of_browsers)][3];
			
			if(no_of_browsers.contains("1"))
			{
				for(int i = first_row; i < LastRow; i++) {
					data[counter][0] = "FF";
					data[counter][1] = Integer.toString(i);
					data[counter++][2] = sheet11.getCell(col_num, i).getContents();
				}
				return data;
			}
			if(no_of_browsers.contains("2"))
			{
				Object data1[][]={{"FF"},{"chrome"}};
				logger.info("First Row - " + first_row);
				logger.info("Last Row - " + LastRow);
				for(int j = 0; j < data1.length; j++) {
					for(int i = first_row; i < LastRow; i++) {
						data[counter][0] = data1[j][0].toString();
						data[counter][1] = Integer.toString(i);
						data[counter++][2] = sheet11.getCell(col_num, i).getContents();
					}
				}
				
				return data;
			}
			if(no_of_browsers.contains("3"))
			{
				Object data1[][]={{"FF"},{"chrome"},{"IE"}};

				for(int j = 0; j < data1.length; j++) {
					for(int i = first_row; i < LastRow; i++) {
						data[counter][0] = data1[j][0].toString();
						data[counter][1] = Integer.toString(i);
						data[counter++][2] = sheet11.getCell(col_num, i).getContents();
					}
				}
				
				return data;
			}
			if(no_of_browsers.contains("4"))
			{
				Object data1[][]={{"FF"},{"chrome"},{"IE10"},{"IE11"}};

				for(int j = 0; j < data1.length; j++) {
					for(int i = first_row; i < LastRow; i++) {
						data[counter][0] = data1[j][0].toString();
						data[counter][1] = Integer.toString(i);
						data[counter++][2] = sheet11.getCell(col_num, i).getContents();
					}
				}
				
				return data;
			}
			if(no_of_browsers.contains("5"))
			{
				Object data1[][]={{"FF"},{"chrome"},{"IE"},{"IE10"},{"IE11"}};

				for(int j = 0; j < data1.length; j++) {
					for(int i = first_row; i < LastRow; i++) {
						data[counter][0] = data1[j][0].toString();
						data[counter][1] = Integer.toString(i);
						data[counter++][2] = sheet11.getCell(col_num, i).getContents();
					}
				}
				
				return data;
			}
			
			
		}
		else if(gr.equals("No"))
		{
			logger.info("Grid option is NO");
			//Object data[][]={{" "}};
			String[][] data = {{" "," "," "}};
			return data;
			
		}
		return null;
	}
	
	@DataProvider(parallel=false)
	public String[][] getData1() throws IOException, BiffException{
		String[][] data = new String[LastRow - first_row][3];
		int counter = 0;
		int testcase_col_num = Column_locator_scan_validation("CHILD TEST CASE",inputfile,"Phone");
		int browser_col_num = Column_locator_scan_validation("Browser",inputfile,"Phone");
		for(int i = first_row; i < LastRow; i++) {
			data[counter][0] = sheet11.getCell(browser_col_num, i).getContents();
			data[counter][1] = Integer.toString(i);
			data[counter++][2] = sheet11.getCell(testcase_col_num, i).getContents();
		}
		return data;
	}
	
	
	
	@Test(dataProvider="getData",priority=1)
	public void RT_Phone(String br, String location, String testCase) {
		
		//loc=7;
		loc = Integer.parseInt(location);
		logger.info("Browser is - " + br);
		//logger.info("Location is - " + location);
		//logger.info("Test Case is - " + testCase);
		
		String exec1 = sheet11.getCell(3, loc).getContents();
		logger.info(exec1+sheet11.getCell(0, loc).getContents());
		
		if(exec1.equalsIgnoreCase("N") || exec1.equalsIgnoreCase("NA") || testCase.equals(""))  {
			throw new SkipException("Skipping tests because value is set has N.");
		}
		else{
		
			Phone_Validation  a = new Phone_Validation ();
	
			try {
				
				logger.info("Value of br in main is "+br);
				
				if(gr.equalsIgnoreCase("Yes") && !br.equals("")) {			
					Test_called++;
					logger.info("Test_called in main test_a is"+Test_called );
					a.print(inputfile,outputfile+"_"+br+".xls",spath, true, br,loc,Test_called);
				}
				else if(gr.equals("No") && br.equals(" ") && !br.equals("NA")) {
					Test_called++;
					logger.info("GRID IS NO In MAIN!");
					for(int loc_var = first_row; loc_var < LastRow; loc_var++) {
						a.print(inputfile,outputfile+".xls",spath, true, br,loc_var,Test_called);
					}
					
				}
				logger.info("loca value in test1 is "+loc);
				
			} catch (Exception e) {
				logger.info("Error: There are issues regarding the IO files. Please verify and try again");
				logger.info(e.getMessage());
				
			} finally {
				writeReport(br);
			}
		}
		
	}
	
	@Test(dataProvider="getData1",priority=2)
	public void RT_Phone_001(String br, String location, String testCase) {
		logger.info("Grid is no");
		loc = Integer.parseInt(location);
		logger.info("Browser is - " + br);
		String exec1 = sheet11.getCell(3, loc).getContents();
		logger.info(exec1+sheet11.getCell(0, loc).getContents());
		
		if(exec1.equalsIgnoreCase("N") || exec1.equalsIgnoreCase("NA") || testCase.equals(""))  {
			throw new SkipException("Skipping tests because value is set has N.");
		}
		else{
		
			Phone_Validation  a = new Phone_Validation ();
	
			try {
				
				logger.info("Value of br in main is "+br);
				if(gr.equals("No")) {
					Test_called++;
					logger.info("GRID IS NO In MAIN!");
					a.print(inputfile,outputfile+".xls",spath, true, br,loc,Test_called);
					
				}
				logger.info("loca value in test1 is "+loc);
				
			} catch (Exception e) {
				logger.info("Error: There are issues regarding the IO files. Please verify and try again");
				logger.info(e.getMessage());
				
			} finally {
				writeReport(br);
			}
		}
	}
	/*
	@Test(dataProvider="getData",priority=2)
	public void RT_Phone_002 ( String br) {
		
		loc=8;
		
		System.out.println("Am here in loc 8");
		String exec1 = sheet11.getCell(3, loc).getContents();
		logger.info(exec1+sheet11.getCell(0, loc).getContents());
		if(exec1.equalsIgnoreCase("N") || exec1.equalsIgnoreCase("NA"))  {
			throw new SkipException("Skipping tests because value is set has N.");
		}
		else{
		
			Phone_Validation  a = new Phone_Validation ();
	
		try {
		
			
			
			logger.info("Value of br in main is "+br);
			
			if(gr.equalsIgnoreCase("Yes") && !br.equals(""))
			{			
				Test_called++;
				logger.info("Test_called in main test_a is"+Test_called );
			a.print(inputfile,outputfile+"_"+br+".xls",spath, true, br,loc,Test_called);
			}
			else if(gr.equals("No") && br.equals(" ") && !br.equals("NA"))
			{Test_called++;
				logger.info("GRID IS NO In MAIN!");
				a.print(inputfile,outputfile+".xls",spath, true, br,loc,Test_called);
				
			}
			logger.info("loca value in test1 is "+loc);
			
			} catch (Exception e) {
			logger.info("Error: There are issues regarding the IO files. Please verify and try again");
			logger.info(e.getMessage());
		
			}}
		
		
	
		
	}
	@Test(dataProvider="getData",priority=3)
	public void RT_Phone_003 ( String br) {
		
		loc=9;
		
		System.out.println("Am here in loc 9");
		String exec1 = sheet11.getCell(3, loc).getContents();
		logger.info(exec1+sheet11.getCell(0, loc).getContents());
		if(exec1.equalsIgnoreCase("N") || exec1.equalsIgnoreCase("NA"))  {
			throw new SkipException("Skipping tests because value is set has N.");
		}
		else{
		
			Phone_Validation  a = new Phone_Validation ();
	
		try {
		
			
			
			logger.info("Value of br in main is "+br);
			
			if(gr.equalsIgnoreCase("Yes") && !br.equals(""))
			{			
				Test_called++;
				logger.info("Test_called in main test_a is"+Test_called );
			a.print(inputfile,outputfile+"_"+br+".xls",spath, true, br,loc,Test_called);
			}
			else if(gr.equals("No") && br.equals(" ") && !br.equals("NA"))
			{Test_called++;
				logger.info("GRID IS NO In MAIN!");
				a.print(inputfile,outputfile+".xls",spath, true, br,loc,Test_called);
				
			}
			logger.info("loca value in test1 is "+loc);
			
			} catch (Exception e) {
			logger.info("Error: There are issues regarding the IO files. Please verify and try again");
			logger.info(e.getMessage());
		
			}}
		
		
	
		
	}
	
	@Test(dataProvider="getData",priority=4)
	public void RT_Phone_004 ( String br) {
		
		loc=10;
		
		System.out.println("Am here in loc 10");
		String exec1 = sheet11.getCell(3, loc).getContents();
		logger.info(exec1+sheet11.getCell(0, loc).getContents());
		if(exec1.equalsIgnoreCase("N") || exec1.equalsIgnoreCase("NA"))  {
			throw new SkipException("Skipping tests because value is set has N.");
		}
		else{
		
			Phone_Validation  a = new Phone_Validation ();
	
		try {
		
			
			
			logger.info("Value of br in main is "+br);
			
			if(gr.equalsIgnoreCase("Yes") && !br.equals(""))
			{			
				Test_called++;
				logger.info("Test_called in main test_a is"+Test_called );
			a.print(inputfile,outputfile+"_"+br+".xls",spath, true, br,loc,Test_called);
			}
			else if(gr.equals("No") && br.equals(" ") && !br.equals("NA"))
			{Test_called++;
				logger.info("GRID IS NO In MAIN!");
				a.print(inputfile,outputfile+".xls",spath, true, br,loc,Test_called);
				
			}
			logger.info("loca value in test1 is "+loc);
			
			} catch (Exception e) {
			logger.info("Error: There are issues regarding the IO files. Please verify and try again");
			logger.info(e.getMessage());
		
			}}
		
		
	
		
	}
	
	@Test(dataProvider="getData",priority=5)
	public void RT_Phone_005 ( String br) {
		
		loc=11;
		
		System.out.println("Am here in loc 11");
		String exec1 = sheet11.getCell(3, loc).getContents();
		logger.info(exec1+sheet11.getCell(0, loc).getContents());
		if(exec1.equalsIgnoreCase("N") || exec1.equalsIgnoreCase("NA"))  {
			throw new SkipException("Skipping tests because value is set has N.");
		}
		else{
		
			Phone_Validation  a = new Phone_Validation ();
	
		try {
		
			
			
			logger.info("Value of br in main is "+br);
			
			if(gr.equalsIgnoreCase("Yes") && !br.equals(""))
			{			
				Test_called++;
				logger.info("Test_called in main test_a is"+Test_called );
			a.print(inputfile,outputfile+"_"+br+".xls",spath, true, br,loc,Test_called);
			}
			else if(gr.equals("No") && br.equals(" ") && !br.equals("NA"))
			{Test_called++;
				logger.info("GRID IS NO In MAIN!");
				a.print(inputfile,outputfile+".xls",spath, true, br,loc,Test_called);
				
			}
			logger.info("loca value in test1 is "+loc);
			
			} catch (Exception e) {
			logger.info("Error: There are issues regarding the IO files. Please verify and try again");
			logger.info(e.getMessage());
		
			}}
		
		
	
		
	}
	@Test(dataProvider="getData",priority=6)
	public void RT_Phone_006 ( String br) {
		
		loc=12;
		
		System.out.println("Am here in loc 12");
		String exec1 = sheet11.getCell(3, loc).getContents();
		logger.info(exec1+sheet11.getCell(0, loc).getContents());
		if(exec1.equalsIgnoreCase("N") || exec1.equalsIgnoreCase("NA"))  {
			throw new SkipException("Skipping tests because value is set has N.");
		}
		else{
		
			Phone_Validation  a = new Phone_Validation ();
	
		try {
		
			
			
			logger.info("Value of br in main is "+br);
			
			if(gr.equalsIgnoreCase("Yes") && !br.equals(""))
			{			
				Test_called++;
				logger.info("Test_called in main test_a is"+Test_called );
			a.print(inputfile,outputfile+"_"+br+".xls",spath, true, br,loc,Test_called);
			}
			else if(gr.equals("No") && br.equals(" ") && !br.equals("NA"))
			{Test_called++;
				logger.info("GRID IS NO In MAIN!");
				a.print(inputfile,outputfile+".xls",spath, true, br,loc,Test_called);
				
			}
			logger.info("loca value in test1 is "+loc);
			
			} catch (Exception e) {
			logger.info("Error: There are issues regarding the IO files. Please verify and try again");
			logger.info(e.getMessage());
		
			}}
		
		
	
		
	}
	@Test(dataProvider="getData",priority=7)
	public void RT_Phone_007 ( String br) {
		
		loc=13;
		
		System.out.println("Am here in loc 13");
		String exec1 = sheet11.getCell(3, loc).getContents();
		logger.info(exec1+sheet11.getCell(0, loc).getContents());
		if(exec1.equalsIgnoreCase("N") || exec1.equalsIgnoreCase("NA"))  {
			throw new SkipException("Skipping tests because value is set has N.");
		}
		else{
		
			Phone_Validation  a = new Phone_Validation ();
	
		try {
		
			
			
			logger.info("Value of br in main is "+br);
			
			if(gr.equalsIgnoreCase("Yes") && !br.equals(""))
			{			
				Test_called++;
				logger.info("Test_called in main test_a is"+Test_called );
			a.print(inputfile,outputfile+"_"+br+".xls",spath, true, br,loc,Test_called);
			}
			else if(gr.equals("No") && br.equals(" ") && !br.equals("NA"))
			{Test_called++;
				logger.info("GRID IS NO In MAIN!");
				a.print(inputfile,outputfile+".xls",spath, true, br,loc,Test_called);
				
			}
			logger.info("loca value in test1 is "+loc);
			
			} catch (Exception e) {
			logger.info("Error: There are issues regarding the IO files. Please verify and try again");
			logger.info(e.getMessage());
		
			}}
		
		
	
		
	}
	@Test(dataProvider="getData",priority=8)
	public void RT_Phone_008 ( String br) {
		
		loc=14;
		
		System.out.println("Am here in loc 14");
		String exec1 = sheet11.getCell(3, loc).getContents();
		logger.info(exec1+sheet11.getCell(0, loc).getContents());
		if(exec1.equalsIgnoreCase("N") || exec1.equalsIgnoreCase("NA"))  {
			throw new SkipException("Skipping tests because value is set has N.");
		}
		else{
		
			Phone_Validation  a = new Phone_Validation ();
	
		try {
		
			
			
			logger.info("Value of br in main is "+br);
			
			if(gr.equalsIgnoreCase("Yes") && !br.equals(""))
			{			
				Test_called++;
				logger.info("Test_called in main test_a is"+Test_called );
			a.print(inputfile,outputfile+"_"+br+".xls",spath, true, br,loc,Test_called);
			}
			else if(gr.equals("No") && br.equals(" ") && !br.equals("NA"))
			{Test_called++;
				logger.info("GRID IS NO In MAIN!");
				a.print(inputfile,outputfile+".xls",spath, true, br,loc,Test_called);
				
			}
			logger.info("loca value in test1 is "+loc);
			
			} catch (Exception e) {
			logger.info("Error: There are issues regarding the IO files. Please verify and try again");
			logger.info(e.getMessage());
		
			}}
		
		
	
		
	}
	@Test(dataProvider="getData",priority=9)
	public void RT_Phone_009 ( String br) {
		
		loc=15;
		
		System.out.println("Am here in loc 15");
		String exec1 = sheet11.getCell(3, loc).getContents();
		logger.info(exec1+sheet11.getCell(0, loc).getContents());
		if(exec1.equalsIgnoreCase("N") || exec1.equalsIgnoreCase("NA"))  {
			throw new SkipException("Skipping tests because value is set has N.");
		}
		else{
		
			Phone_Validation  a = new Phone_Validation ();
	
		try {
		
			
			
			logger.info("Value of br in main is "+br);
			
			if(gr.equalsIgnoreCase("Yes") && !br.equals(""))
			{			
				Test_called++;
				logger.info("Test_called in main test_a is"+Test_called );
			a.print(inputfile,outputfile+"_"+br+".xls",spath, true, br,loc,Test_called);
			}
			else if(gr.equals("No") && br.equals(" ") && !br.equals("NA"))
			{Test_called++;
				logger.info("GRID IS NO In MAIN!");
				a.print(inputfile,outputfile+".xls",spath, true, br,loc,Test_called);
				
			}
			logger.info("loca value in test1 is "+loc);
			
			} catch (Exception e) {
			logger.info("Error: There are issues regarding the IO files. Please verify and try again");
			logger.info(e.getMessage());
		
			}}
		
		
	
		
	}
	@Test(dataProvider="getData",priority=10)
	public void RT_Phone_010 ( String br) {
		
		loc=16;
		
		System.out.println("Am here in loc 16");
		String exec1 = sheet11.getCell(3, loc).getContents();
		logger.info(exec1+sheet11.getCell(0, loc).getContents());
		if(exec1.equalsIgnoreCase("N") || exec1.equalsIgnoreCase("NA"))  {
			throw new SkipException("Skipping tests because value is set has N.");
		}
		else{
		
			Phone_Validation  a = new Phone_Validation ();
	
		try {
		
			
			
			logger.info("Value of br in main is "+br);
			
			if(gr.equalsIgnoreCase("Yes") && !br.equals(""))
			{			
				Test_called++;
				logger.info("Test_called in main test_a is"+Test_called );
			a.print(inputfile,outputfile+"_"+br+".xls",spath, true, br,loc,Test_called);
			}
			else if(gr.equals("No") && br.equals(" ") && !br.equals("NA"))
			{Test_called++;
				logger.info("GRID IS NO In MAIN!");
				a.print(inputfile,outputfile+".xls",spath, true, br,loc,Test_called);
				
			}
			logger.info("loca value in test1 is "+loc);
			
			} catch (Exception e) {
			logger.info("Error: There are issues regarding the IO files. Please verify and try again");
			logger.info(e.getMessage());
		
			}}
		
		
	
		
	}
	@Test(dataProvider="getData",priority=11)
	public void RT_Phone_011 ( String br) {
		
		loc=17;
		
		System.out.println("Am here in loc 17");
		String exec1 = sheet11.getCell(3, loc).getContents();
		logger.info(exec1+sheet11.getCell(0, loc).getContents());
		if(exec1.equalsIgnoreCase("N") || exec1.equalsIgnoreCase("NA"))  {
			throw new SkipException("Skipping tests because value is set has N.");
		}
		else{
		
			Phone_Validation  a = new Phone_Validation ();
	
		try {
		
			
			
			logger.info("Value of br in main is "+br);
			
			if(gr.equalsIgnoreCase("Yes") && !br.equals(""))
			{			
				
				logger.info("entered.....");
				Test_called++;
				logger.info("Test_called in main test_a is"+Test_called );
			a.print(inputfile,outputfile+"_"+br+".xls",spath, true, br,loc,Test_called);
			}
			else if(gr.equals("No") && br.equals(" ") && !br.equals("NA"))
			{Test_called++;
				logger.info("GRID IS NO In MAIN!");
				a.print(inputfile,outputfile+".xls",spath, true, br,loc,Test_called);
				
			}
			logger.info("loca value in test1 is "+loc);
			
			} catch (Exception e) {
			logger.info("Error: There are issues regarding the IO files. Please verify and try again");
			logger.info(e.getMessage());
		
			}}
		
		
	
		
	}
	@Test(dataProvider="getData",priority=12)
	public void RT_Phone_012 ( String br) {
		
		loc=18;
		
		System.out.println("Am here in loc 9");
		String exec1 = sheet11.getCell(3, loc).getContents();
		logger.info(exec1+sheet11.getCell(0, loc).getContents());
		if(exec1.equalsIgnoreCase("N") || exec1.equalsIgnoreCase("NA"))  {
			throw new SkipException("Skipping tests because value is set has N.");
		}
		else{
		
			Phone_Validation  a = new Phone_Validation ();
	
		try {
		
			
			
			logger.info("Value of br in main is "+br);
			
			if(gr.equalsIgnoreCase("Yes") && !br.equals(""))
			{			
				Test_called++;
				logger.info("Test_called in main test_a is"+Test_called );
			a.print(inputfile,outputfile+"_"+br+".xls",spath, true, br,loc,Test_called);
			}
			else if(gr.equals("No") && br.equals(" ") && !br.equals("NA"))
			{Test_called++;
				logger.info("GRID IS NO In MAIN!");
				a.print(inputfile,outputfile+".xls",spath, true, br,loc,Test_called);
				
			}
			logger.info("loca value in test1 is "+loc);
			
			} catch (Exception e) {
			logger.info("Error: There are issues regarding the IO files. Please verify and try again");
			logger.info(e.getMessage());
		
			}}
		
		
	
		
	}
	@Test(dataProvider="getData",priority=13)
	public void RT_Phone_013 ( String br) {
		
		loc=19;
		
		System.out.println("Am here in loc 9");
		String exec1 = sheet11.getCell(3, loc).getContents();
		logger.info(exec1+sheet11.getCell(0, loc).getContents());
		if(exec1.equalsIgnoreCase("N") || exec1.equalsIgnoreCase("NA"))  {
			throw new SkipException("Skipping tests because value is set has N.");
		}
		else{
		
			Phone_Validation  a = new Phone_Validation ();
	
		try {
		
			
			
			logger.info("Value of br in main is "+br);
			
			if(gr.equalsIgnoreCase("Yes") && !br.equals(""))
			{			
				Test_called++;
				logger.info("Test_called in main test_a is"+Test_called );
			a.print(inputfile,outputfile+"_"+br+".xls",spath, true, br,loc,Test_called);
			}
			else if(gr.equals("No") && br.equals(" ") && !br.equals("NA"))
			{Test_called++;
				logger.info("GRID IS NO In MAIN!");
				a.print(inputfile,outputfile+".xls",spath, true, br,loc,Test_called);
				
			}
			logger.info("loca value in test1 is "+loc);
			
			} catch (Exception e) {
			logger.info("Error: There are issues regarding the IO files. Please verify and try again");
			logger.info(e.getMessage());
		
			}}
		
		
	
		
	}
	
	@Test(dataProvider="getData",priority=14)
	public void RT_Phone_014 ( String br) {
		
		loc=20;
		
		System.out.println("Am here in loc 9");
		String exec1 = sheet11.getCell(3, loc).getContents();
		logger.info(exec1+sheet11.getCell(0, loc).getContents());
		if(exec1.equalsIgnoreCase("N") || exec1.equalsIgnoreCase("NA"))  {
			throw new SkipException("Skipping tests because value is set has N.");
		}
		else{
		
			Phone_Validation  a = new Phone_Validation ();
	
		try {
		
			
			
			logger.info("Value of br in main is "+br);
			
			if(gr.equalsIgnoreCase("Yes") && !br.equals(""))
			{			
				Test_called++;
				logger.info("Test_called in main test_a is"+Test_called );
			a.print(inputfile,outputfile+"_"+br+".xls",spath, true, br,loc,Test_called);
			}
			else if(gr.equals("No") && br.equals(" ") && !br.equals("NA"))
			{Test_called++;
				logger.info("GRID IS NO In MAIN!");
				a.print(inputfile,outputfile+".xls",spath, true, br,loc,Test_called);
				
			}
			logger.info("loca value in test1 is "+loc);
			
			} catch (Exception e) {
			logger.info("Error: There are issues regarding the IO files. Please verify and try again");
			logger.info(e.getMessage());
		
			}}
		
		
	
		
	}
	
	@Test(dataProvider="getData",priority=15)
	public void RT_Phone_015 ( String br) {
		
		loc=21;
		
		System.out.println("Am here in loc 9");
		String exec1 = sheet11.getCell(3, loc).getContents();
		logger.info(exec1+sheet11.getCell(0, loc).getContents());
		if(exec1.equalsIgnoreCase("N") || exec1.equalsIgnoreCase("NA"))  {
			throw new SkipException("Skipping tests because value is set has N.");
		}
		else{
		
			Phone_Validation  a = new Phone_Validation ();
	
		try {
		
			
			
			logger.info("Value of br in main is "+br);
			
			if(gr.equalsIgnoreCase("Yes") && !br.equals(""))
			{			
				Test_called++;
				logger.info("Test_called in main test_a is"+Test_called );
			a.print(inputfile,outputfile+"_"+br+".xls",spath, true, br,loc,Test_called);
			}
			else if(gr.equals("No") && br.equals(" ") && !br.equals("NA"))
			{Test_called++;
				logger.info("GRID IS NO In MAIN!");
				a.print(inputfile,outputfile+".xls",spath, true, br,loc,Test_called);
				
			}
			logger.info("loca value in test1 is "+loc);
			
			} catch (Exception e) {
			logger.info("Error: There are issues regarding the IO files. Please verify and try again");
			logger.info(e.getMessage());
		
			}}
		
		
	
		
	}
	
	@Test(dataProvider="getData",priority=16)
	public void RT_Phone_016 ( String br) {
		
		loc=22;
		
		System.out.println("Am here in loc 9");
		String exec1 = sheet11.getCell(3, loc).getContents();
		logger.info(exec1+sheet11.getCell(0, loc).getContents());
		if(exec1.equalsIgnoreCase("N") || exec1.equalsIgnoreCase("NA"))  {
			throw new SkipException("Skipping tests because value is set has N.");
		}
		else{
		
			Phone_Validation  a = new Phone_Validation ();
	
		try {
		
			
			
			logger.info("Value of br in main is "+br);
			
			if(gr.equalsIgnoreCase("Yes") && !br.equals(""))
			{			
				Test_called++;
				logger.info("Test_called in main test_a is"+Test_called );
			a.print(inputfile,outputfile+"_"+br+".xls",spath, true, br,loc,Test_called);
			}
			else if(gr.equals("No") && br.equals(" ") && !br.equals("NA"))
			{Test_called++;
				logger.info("GRID IS NO In MAIN!");
				a.print(inputfile,outputfile+".xls",spath, true, br,loc,Test_called);
				
			}
			logger.info("loca value in test1 is "+loc);
			
			} catch (Exception e) {
			logger.info("Error: There are issues regarding the IO files. Please verify and try again");
			logger.info(e.getMessage());
		
			}}
		
		
	
		
	}
	*/
	
	//Report writing method	- added by Shivendu
	
	void writeReport(String br) {
		//logger.info("Test Case Name is - " + testCaseName);
		try {
			if(gr.equalsIgnoreCase("Yes")) {
				Collections.sort(result_FF, Result_bean.TestCaseNameComparator);
				Collections.sort(result_Chrome, Result_bean.TestCaseNameComparator);
				Collections.sort(result_IE, Result_bean.TestCaseNameComparator);
				Collections.sort(result_IE10, Result_bean.TestCaseNameComparator);
				Collections.sort(result_IE11, Result_bean.TestCaseNameComparator);
				
				switch(browserValueCalculator(br)) {
					case 1:
						writeToExcel(outputfile+"_"+br+".xls", result_FF);
						break;
						
					case 2:
						writeToExcel(outputfile+"_"+br+".xls", result_Chrome);
						break;
						
					case 3:
						writeToExcel(outputfile+"_"+br+".xls", result_IE);
						break;
						
					case 4:
						writeToExcel(outputfile+"_"+br+".xls", result_IE10);
						break;
						
					case 5:
						writeToExcel(outputfile+"_"+br+".xls", result_IE11);
						break;
						
					default:
						logger.info("Appropriate result not generated");
				}
			} else {
				for(Result_bean rb : result_FF) {
					result_Common.add(rb);
				}
				for(Result_bean rb : result_Chrome) {
					result_Common.add(rb);
				}
				for(Result_bean rb : result_IE) {
					result_Common.add(rb);
				}
				for(Result_bean rb : result_IE10) {
					result_Common.add(rb);
				}
				for(Result_bean rb : result_IE11) {
					result_Common.add(rb);
				}
				Collections.sort(result_Common, Result_bean.TestCaseNameComparator);
				writeToExcel(outputfile+".xls", result_Common);
			}
		} catch (Exception e) {
			logger.info("Error occurred while writing to excel - " + e.getMessage());
		}
	}
	
//Auto launch grid config changes -venki
@AfterClass
public void closeCMD() throws IOException
{
	   logger.info("THis is after class");
       if(gr.equalsIgnoreCase("Yes"))
       Runtime.getRuntime().exec("taskkill /IM cmd.exe");
                            
}
//Auto launch grid config changes -venki

	@Override
	public void execute(String br, WebDriver paramDriver, String url, int loc)
			throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	
	public String getTestCaseName() {
		return "";
	}

	
	
}