package CRH_EBF_TV;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;



import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Properties;

import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.read.biff.BiffException;

import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.apache.log4j.xml.DOMConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;





public class TV_Test  extends CommonFunctions{
	


	
public int loc;
int Test_called = 0;
	
	@BeforeClass
	public void Reader() throws IOException, BiffException,InterruptedException
	{
		
		DOMConfigurator.configure("Regression_EBF.xml");
		
		dir1 = new File(".");
		spath = dir1.getCanonicalPath();
		spath = spath.replaceAll("////", "////////");
		logger.info(""+"Path "+spath);
		Load_Properties_File(spath);
	
		inputfile=spath+path_config.getProperty("inputSheetEBF");
		outputfile=spath+path_config.getProperty("resultSheetTV");
		
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
		
		data11 = new File(inputfile);
		
		
		ws11 = new WorkbookSettings();
		ws11.setLocale(new Locale("er", "ER"));
		wb11 = Workbook.getWorkbook(data11, ws11);
		sheet11 = wb11.getSheet("TV");
		gr=sheet11.getCell(4,3).getContents();
		Grid_Status=gr;
		Sheet_name = sheet11.getName();
		
		//Auto launch grid config changes -venki
	       if(gr.equalsIgnoreCase("Yes"))
           {

                 String new_dir= spath + "//Supporting_Lib";
                 String new_dir1= spath +"//Resource//Browser_Drivers";
                 Runtime.getRuntime().exec("cmd.exe /c cd \""+new_dir+"\"& start cmd.exe /k \"java -jar selenium-server-standalone-2.45.0.jar -role hub\" ");
                 Thread.sleep(10000);
                 Runtime.getRuntime().exec("cmd.exe /c cd \""+new_dir1+"\"& start cmd.exe /k \"java -Dwebdriver.chrome.driver="+new_dir1+"//chromedriver.exe -Dwebdriver.ie.driver="+new_dir1+"//IEDriverServer.exe -jar selenium-server-standalone-2.45.0.jar -role webdriver -hub http://localhost:4444/grid/register -port 5556 -browser browserName=firefox,maxInstances=1 -browser browserName=chrome,maxInstances=1 -browser browserName=iexplore,maxInstances=1 -maxSession 3\" ");
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
		int first_row=Row_locator_full_scan_validation("CHILD TEST CASE",inputfile,"TV")+1;
		int LastRow=sheet11.getRows();
		logger.info(""+"first_row "+first_row);
		for( int im=first_row;im<LastRow;im++)
		{
			String tc1= sheet11.getCell(3, im).getContents();
			logger.info(""+"TC1 "+tc1+" name "+sheet11.getCell(0, im).getContents());
			logger.info(""+"TC1 "+tc1+" im varialble "+im);
			if(tc1.equalsIgnoreCase("Y"))
			{
				first_tc=im;
				break;
			}
			
		}
		//computer_name folder changes -ankita
        File Pass_a = new File(spath + "//" + "//Test_Results"+"//"+newFolderPCName+"//"+"CRH_EBF_TV_Pass_Screenshots////");
        deleteFolder(Pass_a);
        File Fail_a = new File(spath + "//" + "//Test_Results"+"//"+newFolderPCName+"//"+"CRH_EBF_TV_Fail_Screenshots////");
        deleteFolder(Fail_a);
        File Exception_a = new File(spath + "//"+ "//Test_Results"+"//"+newFolderPCName+"//"+"CRH_EBF_TV_Exception_Screenshots////");
        deleteFolder(Exception_a);
        File BC_NewImage = new File(spath + "//"+ "//Test_Results"+"//"+computerName+"_BC_New_Images");
        deleteFolder(BC_NewImage);

      //computer_name folder changes -ankita

	}
	
	
	
	
	@DataProvider(parallel=true)
	public Object[][] getData() throws IOException, BiffException{
		logger.info("Getting inside");
		
		
		no_of_browsers=sheet11.getCell(5,3).getContents();
		logger.info(no_of_browsers);
		no_of_browsers=no_of_browsers.substring(0, 1);
		if(gr.equals("Yes"))
		{
			
			logger.info("no_of_browsers "+no_of_browsers);
			
			
			if(no_of_browsers.contains("1"))
			{
		final Object data[][]={{"FF"}};
		return data;
				
			}
			if(no_of_browsers.contains("2"))
			{
				final	Object data[][]={{"FF"},{"chrome"}};
				return data;
				
			}
			else if(no_of_browsers.contains("3"))
			{
				final	Object data[][]={{"FF"},{"chrome"},{"IE"}};
				return data;
			}
			else if(no_of_browsers.contains("4"))
			{
				final	Object data[][]={{"FF"},{"chrome"},{"IE10"},{"IE11"}};
				return data;
			}
			else if(no_of_browsers.contains("5"))
			{
				final	Object data[][]={{"FF"},{"chrome"},{"IE"},{"IE10"},{"IE11"}};
				return data;
			}
			
			
		}
		else if(gr.equals("No"))
		{
			
			Object data[][]={{" "}};
			return data;
			
		}
	return null;
	}
	
	
	
	
	public static void Load_Properties_File(String spath) throws IOException {
		spath = spath + "//" + "Resource//" + "Properties_Files//";
		path_config = new Properties();
		file_Stream = new FileInputStream(spath + "properties_Path//"
				+ "path_config.properties");
		path_config.load(file_Stream);
	}
	
	@Test(dataProvider="getData",priority=1)
	public void RT_TV_001 ( String br) {
		
		loc=7;
		
	
		String exec1 = sheet11.getCell(3, loc).getContents();
		logger.info(exec1+sheet11.getCell(0, loc).getContents());
		if(exec1.equalsIgnoreCase("N") || exec1.equalsIgnoreCase("NA"))  {
			throw new SkipException("Skipping tests because value is set has N.");
		}
		else{
		
			TV_Validation a = new TV_Validation();
	
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
	
	@Test(dataProvider="getData",priority=2)
	public void RT_TV_002 ( String br) {
		
		loc=8;
		
		
		String exec1 = sheet11.getCell(3, loc).getContents();
		logger.info(exec1+sheet11.getCell(0, loc).getContents());
		if(exec1.equalsIgnoreCase("N") || exec1.equalsIgnoreCase("NA"))  {
			throw new SkipException("Skipping tests because value is set has N.");
		}
		else{
		
			TV_Validation a = new TV_Validation();
	
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
	public void RT_TV_003 ( String br) {
		
		loc=9;
		
		
		String exec1 = sheet11.getCell(3, loc).getContents();
		logger.info(exec1+sheet11.getCell(0, loc).getContents());
		if(exec1.equalsIgnoreCase("N") || exec1.equalsIgnoreCase("NA"))  {
			throw new SkipException("Skipping tests because value is set has N.");
		}
		else{
		
			TV_Validation a = new TV_Validation();
	
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
	public void RT_TV_004 ( String br) {
		
		loc=10;
		
		
		String exec1 = sheet11.getCell(3, loc).getContents();
		logger.info(exec1+sheet11.getCell(0, loc).getContents());
		if(exec1.equalsIgnoreCase("N") || exec1.equalsIgnoreCase("NA"))  {
			throw new SkipException("Skipping tests because value is set has N.");
		}
		else{
		
			TV_Validation a = new TV_Validation();
	
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
	public void RT_TV_005 ( String br) {
		
		loc=11;
		
		
		String exec1 = sheet11.getCell(3, loc).getContents();
		logger.info(exec1+sheet11.getCell(0, loc).getContents());
		if(exec1.equalsIgnoreCase("N") || exec1.equalsIgnoreCase("NA"))  {
			throw new SkipException("Skipping tests because value is set has N.");
		}
		else{
		
			TV_Validation a = new TV_Validation();
	
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
	public void RT_TV_006 ( String br) {
		
		loc=12;
		
		
		String exec1 = sheet11.getCell(3, loc).getContents();
		logger.info(exec1+sheet11.getCell(0, loc).getContents());
		if(exec1.equalsIgnoreCase("N") || exec1.equalsIgnoreCase("NA"))  {
			throw new SkipException("Skipping tests because value is set has N.");
		}
		else{
		
			TV_Validation a = new TV_Validation();
	
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
	public void RT_TV_007 ( String br) {
		
		loc=13;
		
		
		String exec1 = sheet11.getCell(3, loc).getContents();
		logger.info(exec1+sheet11.getCell(0, loc).getContents());
		if(exec1.equalsIgnoreCase("N") || exec1.equalsIgnoreCase("NA"))  {
			throw new SkipException("Skipping tests because value is set has N.");
		}
		else{
		
			TV_Validation a = new TV_Validation();
	
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
	public void RT_TV_008 ( String br) {
		
		loc=14;
		
		
		String exec1 = sheet11.getCell(3, loc).getContents();
		logger.info(exec1+sheet11.getCell(0, loc).getContents());
		if(exec1.equalsIgnoreCase("N") || exec1.equalsIgnoreCase("NA"))  {
			throw new SkipException("Skipping tests because value is set has N.");
		}
		else{
		
			TV_Validation a = new TV_Validation();
	
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
	public void RT_TV_009 ( String br) {
		
		loc=15;
		
		
		String exec1 = sheet11.getCell(3, loc).getContents();
		logger.info(exec1+sheet11.getCell(0, loc).getContents());
		if(exec1.equalsIgnoreCase("N") || exec1.equalsIgnoreCase("NA"))  {
			throw new SkipException("Skipping tests because value is set has N.");
		}
		else{
		
			TV_Validation a = new TV_Validation();
	
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
	public void RT_TV_010 ( String br) {
		
		loc=16;
		
		
		String exec1 = sheet11.getCell(3, loc).getContents();
		logger.info(exec1+sheet11.getCell(0, loc).getContents());
		if(exec1.equalsIgnoreCase("N") || exec1.equalsIgnoreCase("NA"))  {
			throw new SkipException("Skipping tests because value is set has N.");
		}
		else{
		
			TV_Validation a = new TV_Validation();
	
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
	public void RT_TV_011 ( String br) {
		
		loc=17;
		
		
		String exec1 = sheet11.getCell(3, loc).getContents();
		logger.info(exec1+sheet11.getCell(0, loc).getContents());
		if(exec1.equalsIgnoreCase("N") || exec1.equalsIgnoreCase("NA"))  {
			throw new SkipException("Skipping tests because value is set has N.");
		}
		else{
		
			TV_Validation a = new TV_Validation();
	
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
	@Test(dataProvider="getData",priority=12)
	public void RT_TV_012 ( String br) {
		
		loc=18;
		
		
		String exec1 = sheet11.getCell(3, loc).getContents();
		logger.info(exec1+sheet11.getCell(0, loc).getContents());
		if(exec1.equalsIgnoreCase("N") || exec1.equalsIgnoreCase("NA"))  {
			throw new SkipException("Skipping tests because value is set has N.");
		}
		else{
		
			TV_Validation a = new TV_Validation();
	
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
	public void RT_TV_013 ( String br) {
		
		loc=19;
		
		
		String exec1 = sheet11.getCell(3, loc).getContents();
		logger.info(exec1+sheet11.getCell(0, loc).getContents());
		if(exec1.equalsIgnoreCase("N") || exec1.equalsIgnoreCase("NA"))  {
			throw new SkipException("Skipping tests because value is set has N.");
		}
		else{
		
			TV_Validation a = new TV_Validation();
	
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
	public void RT_TV_014 ( String br) {
		
		loc=20;
		
		
		String exec1 = sheet11.getCell(3, loc).getContents();
		logger.info(exec1+sheet11.getCell(0, loc).getContents());
		if(exec1.equalsIgnoreCase("N") || exec1.equalsIgnoreCase("NA"))  {
			throw new SkipException("Skipping tests because value is set has N.");
		}
		else{
		
			TV_Validation a = new TV_Validation();
	
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
	public void RT_TV_015 ( String br) {
		
		loc=21;
		
		
		String exec1 = sheet11.getCell(3, loc).getContents();
		logger.info(exec1+sheet11.getCell(0, loc).getContents());
		if(exec1.equalsIgnoreCase("N") || exec1.equalsIgnoreCase("NA"))  {
			throw new SkipException("Skipping tests because value is set has N.");
		}
		else{
		
			TV_Validation a = new TV_Validation();
	
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
	public void RT_TV_016 ( String br) {
		
		loc=22;
		
		
		String exec1 = sheet11.getCell(3, loc).getContents();
		logger.info(exec1+sheet11.getCell(0, loc).getContents());
		if(exec1.equalsIgnoreCase("N") || exec1.equalsIgnoreCase("NA"))  {
			throw new SkipException("Skipping tests because value is set has N.");
		}
		else{
		
			TV_Validation a = new TV_Validation();
	
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
	
	@Test(dataProvider="getData",priority=17)
	public void RT_TV_017 ( String br) {
		
		loc=23;
		
		
		String exec1 = sheet11.getCell(3, loc).getContents();
		logger.info(exec1+sheet11.getCell(0, loc).getContents());
		if(exec1.equalsIgnoreCase("N") || exec1.equalsIgnoreCase("NA"))  {
			throw new SkipException("Skipping tests because value is set has N.");
		}
		else{
		
			TV_Validation a = new TV_Validation();
	
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
	
	@Test(dataProvider="getData",priority=18)
	public void RT_TV_018 ( String br) {
		
		loc=24;
		
		
		String exec1 = sheet11.getCell(3, loc).getContents();
		logger.info(exec1+sheet11.getCell(0, loc).getContents());
		if(exec1.equalsIgnoreCase("N") || exec1.equalsIgnoreCase("NA"))  {
			throw new SkipException("Skipping tests because value is set has N.");
		}
		else{
		
			TV_Validation a = new TV_Validation();
	
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
	
	@Test(dataProvider="getData",priority=19)
	public void RT_TV_019 ( String br) {
		
		loc=25;
		
		
		String exec1 = sheet11.getCell(3, loc).getContents();
		logger.info(exec1+sheet11.getCell(0, loc).getContents());
		if(exec1.equalsIgnoreCase("N") || exec1.equalsIgnoreCase("NA"))  {
			throw new SkipException("Skipping tests because value is set has N.");
		}
		else{
		
			TV_Validation a = new TV_Validation();
	
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
	
	@Test(dataProvider="getData",priority=20)
	public void RT_TV_020 ( String br) {
		
		loc=26;
		
		
		String exec1 = sheet11.getCell(3, loc).getContents();
		logger.info(exec1+sheet11.getCell(0, loc).getContents());
		if(exec1.equalsIgnoreCase("N") || exec1.equalsIgnoreCase("NA"))  {
			throw new SkipException("Skipping tests because value is set has N.");
		}
		else{
		
			TV_Validation a = new TV_Validation();
	
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
	@Test(dataProvider="getData",priority=21)
	public void RT_TV_021 ( String br) {
		
		loc=27;
		
		
		String exec1 = sheet11.getCell(3, loc).getContents();
		logger.info(exec1+sheet11.getCell(0, loc).getContents());
		if(exec1.equalsIgnoreCase("N") || exec1.equalsIgnoreCase("NA"))  {
			throw new SkipException("Skipping tests because value is set has N.");
		}
		else{
		
			TV_Validation a = new TV_Validation();
	
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
	
	@Test(dataProvider="getData",priority=22)
	public void RT_TV_022 ( String br) {
		
		loc=28;
		
		
		String exec1 = sheet11.getCell(3, loc).getContents();
		logger.info(exec1+sheet11.getCell(0, loc).getContents());
		if(exec1.equalsIgnoreCase("N") || exec1.equalsIgnoreCase("NA"))  {
			throw new SkipException("Skipping tests because value is set has N.");
		}
		else{
		
			TV_Validation a = new TV_Validation();
	
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
	
	@Test(dataProvider="getData",priority=23)
	public void RT_TV_023 ( String br) {
		
		loc=29;
		
		
		String exec1 = sheet11.getCell(3, loc).getContents();
		logger.info(exec1+sheet11.getCell(0, loc).getContents());
		if(exec1.equalsIgnoreCase("N") || exec1.equalsIgnoreCase("NA"))  {
			throw new SkipException("Skipping tests because value is set has N.");
		}
		else{
		
			TV_Validation a = new TV_Validation();
	
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
	
	@Test(dataProvider="getData",priority=24)
	public void RT_TV_024 ( String br) {
		
		loc=30;
		
		
		String exec1 = sheet11.getCell(3, loc).getContents();
		logger.info(exec1+sheet11.getCell(0, loc).getContents());
		if(exec1.equalsIgnoreCase("N") || exec1.equalsIgnoreCase("NA"))  {
			throw new SkipException("Skipping tests because value is set has N.");
		}
		else{
		
			TV_Validation a = new TV_Validation();
	
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
	
	@Test(dataProvider="getData",priority=25)
	public void RT_TV_025 ( String br) {
		
		loc=31;
		
		
		String exec1 = sheet11.getCell(3, loc).getContents();
		logger.info(exec1+sheet11.getCell(0, loc).getContents());
		if(exec1.equalsIgnoreCase("N") || exec1.equalsIgnoreCase("NA"))  {
			throw new SkipException("Skipping tests because value is set has N.");
		}
		else{
		
			TV_Validation a = new TV_Validation();
	
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
	
	@Test(dataProvider="getData",priority=26)
	public void RT_TV_026 ( String br) {
		
		loc=32;
		
		
		String exec1 = sheet11.getCell(3, loc).getContents();
		logger.info(exec1+sheet11.getCell(0, loc).getContents());
		if(exec1.equalsIgnoreCase("N") || exec1.equalsIgnoreCase("NA"))  {
			throw new SkipException("Skipping tests because value is set has N.");
		}
		else{
		
			TV_Validation a = new TV_Validation();
	
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
	
	@Test(dataProvider="getData",priority=27)
	public void RT_TV_027 ( String br) {
		
		loc=33;
		
		
		String exec1 = sheet11.getCell(3, loc).getContents();
		logger.info(exec1+sheet11.getCell(0, loc).getContents());
		if(exec1.equalsIgnoreCase("N") || exec1.equalsIgnoreCase("NA"))  {
			throw new SkipException("Skipping tests because value is set has N.");
		}
		else{
		
			TV_Validation a = new TV_Validation();
	
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
	@Test(dataProvider="getData",priority=28)
	public void RT_TV_028 ( String br) {
		
		loc=34;
		
		
		String exec1 = sheet11.getCell(3, loc).getContents();
		logger.info(exec1+sheet11.getCell(0, loc).getContents());
		if(exec1.equalsIgnoreCase("N") || exec1.equalsIgnoreCase("NA"))  {
			throw new SkipException("Skipping tests because value is set has N.");
		}
		else{
		
			TV_Validation a = new TV_Validation();
	
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
	
	
}