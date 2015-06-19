package CRH_Internet;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.util.Locale;
import java.util.Properties;

import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.read.biff.BiffException;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class EBF_Internet_Test extends CommonFunctions {

	//File dir1,dir_offer1,dir_offer2,Offer1,Offer2;
	//File[] files_offer1,files_offer2;
	//String spath,fname,offer_rel1,offer_com ;
	//public static Properties path_config;
	//public static FileInputStream file_Stream;
	public int loc;
	int Test_called = 0;
	
	@BeforeClass
	public void Reader() throws IOException, BiffException, InterruptedException
	{
		DOMConfigurator.configure("Regression_EBF.xml");
		dir1 = new File(".");
		spath = dir1.getCanonicalPath();
		spath = spath.replaceAll("////", "////////");
		logger.info(""+"Path "+spath);
		Load_Properties_File(spath);
	
		inputfile=spath+path_config.getProperty("inputSheetEBF");
		outputfile=spath+path_config.getProperty("resultSheetInternet");
		
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
		sheet11 = wb11.getSheet("Internet");
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
		int first_row=Row_locator_full_scan_validation("CHILD TEST CASE",inputfile,"Internet")+1;
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

		File Pass_a = new File(spath + "//" + "//Test_Results"+"//"+newFolderPCName+"//CRH_EBF_Internet_Pass_Screenshots");
        deleteFolder(Pass_a);
        File Fail_a = new File(spath + "//" + "//Test_Results"+"//"+newFolderPCName+"//CRH_EBF_Internet_Fail_Screenshots");
        deleteFolder(Fail_a);
        File Exception_a = new File(spath+ "//" + "//Test_Results"+"//"+newFolderPCName+"//CRH_EBF_Internet_Exception_Screenshots//");
        logger.info("deleting a");
        deleteFolder(Exception_a);
        File BC_NewImage = new File(spath + "//"+ "//Test_Results"+"//"+computerName+"_BC_New_Images");
        deleteFolder(BC_NewImage);

    	}
	
	@DataProvider(parallel=true)
	public Object[][] getData() throws IOException, BiffException{
		logger.info("Getting inside1");
		
        no_of_browsers=sheet11.getCell(5,3).getContents();
        no_of_browsers=no_of_browsers.substring(0,1); 

		if(gr.equals("Yes"))
		{
			
			logger.info("no_of_browsers "+no_of_browsers);
			
			
			
			if(no_of_browsers.contains("1"))
			{
				Object data[][]={{"FF"}};
				return data;
			}
			if(no_of_browsers.contains("2"))
			{
				Object data[][]={{"FF"},{"chrome"}};
				return data;
			}
			else if(no_of_browsers.contains("3"))
			{
				Object data[][]={{"FF"},{"chrome"},{"IE"}};
				return data;
			}
			else if(no_of_browsers.contains("4"))
			{
				Object data[][]={{"FF"},{"chrome"},{"IE10"},{"IE11"}};
				return data;
			}
			else if(no_of_browsers.contains("5"))
			{
				Object data[][]={{"FF"},{"chrome"},{"IE"},{"IE10"},{"IE11"}};
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
		logger.info("load properties is called");
		spath = spath + "//" + "Resource//" + "Properties_Files//";
		
		path_config = new Properties();
		file_Stream = new FileInputStream(spath + "properties_Path//"
				+ "path_config.properties");
		path_config.load(file_Stream);
		logger.info("load properties is ended");
	}
	
	@Test(dataProvider="getData",priority=1)
	public  void RT_Internet_001 ( String br) {
		DOMConfigurator.configure("Regression_EBF.xml");
		logger.info("Test 1 is called");
		loc=7;
		logger.info("Test 1 is called");
		
		String exec1 = sheet11.getCell(3, loc).getContents();
		logger.info(sheet11.getCell(0, loc).getContents()+" "+exec1);
		
		if(exec1.equalsIgnoreCase("N") || exec1.equalsIgnoreCase("NA") ) {
			throw new SkipException("Skipping tests because value is set has N.");
		}else
		{
				try {
	
					logger.info("BR of test1 and loc  is "+br+" "+loc);
					Internet_Validation a = new Internet_Validation();
					logger.info("Value of gr in main is "+gr);
			
			
			if(gr.equalsIgnoreCase("Yes") && !br.equals(""))
			{			
				Test_called++;
				logger.info("Test_called in main test_b is"+Test_called );
				a.print(inputfile,outputfile+"_"+br+".xls",
						spath, true,br,loc,Test_called);
							
			}
			else if(gr.equals("No") && br.equals(" ") && !br.equals("NA"))
			{
				Test_called++;
				logger.info("GRID IS NO In MAIN!");
				//TestCompleted="Yes";
				a.print(inputfile,outputfile+".xls",
						 spath, true,br,loc,Test_called);
			
			}
			logger.info("loca value in test1 is "+loc);
			//loc++;
			TestCompleted="Yes";
			logger.info("Test completed yes or NO"+TestCompleted);
				}
			 catch (Exception e) {
					System.out
							.println("Error: There are issues regarding the IO files. Please verify and try again");
					logger.info(e.getMessage());
			 }}}
	
@Test(dataProvider="getData",priority=2)
	
	public  void RT_Internet_002 ( String br) throws Exception
	{
	DOMConfigurator.configure("Regression_EBF.xml");
	logger.info("Test 1 is called");
	loc=8;
	logger.info("Test 1 is called");
	
	String exec1 = sheet11.getCell(3, loc).getContents();
	logger.info(sheet11.getCell(0, loc).getContents()+" "+exec1);
	
	if(exec1.equalsIgnoreCase("N") || exec1.equalsIgnoreCase("NA") ) {
		throw new SkipException("Skipping tests because value is set has N.");
	}else
	{
			try {

				logger.info("BR of test1 and loc  is "+br+" "+loc);
				Internet_Validation a = new Internet_Validation();
				logger.info("Value of gr in main is "+gr);
		
		
		if(gr.equalsIgnoreCase("Yes") && !br.equals(""))
		{			
			Test_called++;
			logger.info("Test_called in main test_b is"+Test_called );
			a.print(inputfile,outputfile+"_"+br+".xls",
					spath, true,br,loc,Test_called);
						
		}
		else if(gr.equals("No") && br.equals(" ") && !br.equals("NA"))
		{
			Test_called++;
			logger.info("GRID IS NO In MAIN!");
			//TestCompleted="Yes";
			a.print(inputfile,outputfile+".xls",
					 spath, true,br,loc,Test_called);
		
		}
		logger.info("loca value in test1 is "+loc);
		//loc++;
		TestCompleted="Yes";
		logger.info("Test completed yes or NO"+TestCompleted);
			}
		 catch (Exception e) {
				System.out
						.println("Error: There are issues regarding the IO files. Please verify and try again");
				logger.info(e.getMessage());
		 }}}

@Test(dataProvider="getData",priority=3)

public  void RT_Internet_003 ( String br) throws Exception
{
	DOMConfigurator.configure("Regression_EBF.xml");
	logger.info("Test 1 is called");
	loc=9;
	logger.info("Test 1 is called");
	
	String exec1 = sheet11.getCell(3, loc).getContents();
	logger.info(sheet11.getCell(0, loc).getContents()+" "+exec1);
	
	if(exec1.equalsIgnoreCase("N") || exec1.equalsIgnoreCase("NA") ) {
		throw new SkipException("Skipping tests because value is set has N.");
	}else
	{
			try {

				logger.info("BR of test1 and loc  is "+br+" "+loc);
				Internet_Validation a = new Internet_Validation();
				logger.info("Value of gr in main is "+gr);
		
		
		if(gr.equalsIgnoreCase("Yes") && !br.equals(""))
		{			
			Test_called++;
			logger.info("Test_called in main test_b is"+Test_called );
			a.print(inputfile,outputfile+"_"+br+".xls",
					spath, true,br,loc,Test_called);
						
		}
		else if(gr.equals("No") && br.equals(" ") && !br.equals("NA"))
		{
			Test_called++;
			logger.info("GRID IS NO In MAIN!");
			//TestCompleted="Yes";
			a.print(inputfile,outputfile+".xls",
					 spath, true,br,loc,Test_called);
		
		}
		logger.info("loca value in test1 is "+loc);
		//loc++;
		TestCompleted="Yes";
		logger.info("Test completed yes or NO"+TestCompleted);
			}
		 catch (Exception e) {
				System.out
						.println("Error: There are issues regarding the IO files. Please verify and try again");
				logger.info(e.getMessage());
		 }}}


@Test(dataProvider="getData",priority=4)

public  void RT_Internet_004 ( String br) throws Exception
{
	DOMConfigurator.configure("Regression_EBF.xml");
	logger.info("Test 1 is called");
	loc=10;
	logger.info("Test 1 is called");
	
	String exec1 = sheet11.getCell(3, loc).getContents();
	logger.info(sheet11.getCell(0, loc).getContents()+" "+exec1);
	
	if(exec1.equalsIgnoreCase("N") || exec1.equalsIgnoreCase("NA") ) {
		throw new SkipException("Skipping tests because value is set has N.");
	}else
	{
			try {

				logger.info("BR of test1 and loc  is "+br+" "+loc);
				Internet_Validation a = new Internet_Validation();
				logger.info("Value of gr in main is "+gr);
		
		
		if(gr.equalsIgnoreCase("Yes") && !br.equals(""))
		{			
			Test_called++;
			logger.info("Test_called in main test_b is"+Test_called );
			a.print(inputfile,outputfile+"_"+br+".xls",
					spath, true,br,loc,Test_called);
						
		}
		else if(gr.equals("No") && br.equals(" ") && !br.equals("NA"))
		{
			Test_called++;
			logger.info("GRID IS NO In MAIN!");
			//TestCompleted="Yes";
			a.print(inputfile,outputfile+".xls",
					 spath, true,br,loc,Test_called);
		
		}
		logger.info("loca value in test1 is "+loc);
		//loc++;
		TestCompleted="Yes";
		logger.info("Test completed yes or NO"+TestCompleted);
			}
		 catch (Exception e) {
				System.out
						.println("Error: There are issues regarding the IO files. Please verify and try again");
				logger.info(e.getMessage());
		 }}}

@Test(dataProvider="getData",priority=5)

public  void RT_Internet_006 ( String br) throws Exception
{
	DOMConfigurator.configure("Regression_EBF.xml");
	logger.info("Test 1 is called");
	loc=12;
	logger.info("Test 1 is called");
	
	String exec1 = sheet11.getCell(3, loc).getContents();
	logger.info(sheet11.getCell(0, loc).getContents()+" "+exec1);
	
	if(exec1.equalsIgnoreCase("N") || exec1.equalsIgnoreCase("NA") ) {
		throw new SkipException("Skipping tests because value is set has N.");
	}else
	{
			try {

				logger.info("BR of test1 and loc  is "+br+" "+loc);
				Internet_Validation a = new Internet_Validation();
				logger.info("Value of gr in main is "+gr);
		
		
		if(gr.equalsIgnoreCase("Yes") && !br.equals(""))
		{			
			Test_called++;
			logger.info("Test_called in main test_b is"+Test_called );
			a.print(inputfile,outputfile+"_"+br+".xls",
					spath, true,br,loc,Test_called);
						
		}
		else if(gr.equals("No") && br.equals(" ") && !br.equals("NA"))
		{
			Test_called++;
			logger.info("GRID IS NO In MAIN!");
			//TestCompleted="Yes";
			a.print(inputfile,outputfile+".xls",
					 spath, true,br,loc,Test_called);
		
		}
		logger.info("loca value in test1 is "+loc);
		//loc++;
		TestCompleted="Yes";
		logger.info("Test completed yes or NO"+TestCompleted);
			}
		 catch (Exception e) {
				System.out
						.println("Error: There are issues regarding the IO files. Please verify and try again");
				logger.info(e.getMessage());
		 }}}

@Test(dataProvider="getData",priority=6)

public  void RT_Internet_007 ( String br) throws Exception
{
	DOMConfigurator.configure("Regression_EBF.xml");
	logger.info("Test 1 is called");
	loc=13;
	logger.info("Test 1 is called");
	
	String exec1 = sheet11.getCell(3, loc).getContents();
	logger.info(sheet11.getCell(0, loc).getContents()+" "+exec1);
	
	if(exec1.equalsIgnoreCase("N") || exec1.equalsIgnoreCase("NA") ) {
		throw new SkipException("Skipping tests because value is set has N.");
	}else
	{
			try {

				logger.info("BR of test1 and loc  is "+br+" "+loc);
				Internet_Validation a = new Internet_Validation();
				logger.info("Value of gr in main is "+gr);
		
		
		if(gr.equalsIgnoreCase("Yes") && !br.equals(""))
		{			
			Test_called++;
			logger.info("Test_called in main test_b is"+Test_called );
			a.print(inputfile,outputfile+"_"+br+".xls",
					spath, true,br,loc,Test_called);
						
		}
		else if(gr.equals("No") && br.equals(" ") && !br.equals("NA"))
		{
			Test_called++;
			logger.info("GRID IS NO In MAIN!");
			//TestCompleted="Yes";
			a.print(inputfile,outputfile+".xls",
					 spath, true,br,loc,Test_called);
		
		}
		logger.info("loca value in test1 is "+loc);
		//loc++;
		TestCompleted="Yes";
		logger.info("Test completed yes or NO"+TestCompleted);
			}
		 catch (Exception e) {
				System.out
						.println("Error: There are issues regarding the IO files. Please verify and try again");
				logger.info(e.getMessage());
		 }}}

@Test(dataProvider="getData",priority=7)

public  void RT_Internet_008 ( String br) throws Exception
{DOMConfigurator.configure("Regression_EBF.xml");
logger.info("Test 1 is called");
loc=14;
logger.info("Test 1 is called");

String exec1 = sheet11.getCell(3, loc).getContents();
logger.info(sheet11.getCell(0, loc).getContents()+" "+exec1);

if(exec1.equalsIgnoreCase("N") || exec1.equalsIgnoreCase("NA") ) {
	throw new SkipException("Skipping tests because value is set has N.");
}else
{
		try {

			logger.info("BR of test1 and loc  is "+br+" "+loc);
			Internet_Validation a = new Internet_Validation();
			logger.info("Value of gr in main is "+gr);
	
	
	if(gr.equalsIgnoreCase("Yes") && !br.equals(""))
	{			
		Test_called++;
		logger.info("Test_called in main test_b is"+Test_called );
		a.print(inputfile,outputfile+"_"+br+".xls",
				spath, true,br,loc,Test_called);
					
	}
	else if(gr.equals("No") && br.equals(" ") && !br.equals("NA"))
	{
		Test_called++;
		logger.info("GRID IS NO In MAIN!");
		//TestCompleted="Yes";
		a.print(inputfile,outputfile+".xls",
				 spath, true,br,loc,Test_called);
	
	}
	logger.info("loca value in test1 is "+loc);
	//loc++;
	TestCompleted="Yes";
	logger.info("Test completed yes or NO"+TestCompleted);
		}
	 catch (Exception e) {
			System.out
					.println("Error: There are issues regarding the IO files. Please verify and try again");
			logger.info(e.getMessage());
	 }}}

@Test(dataProvider="getData",priority=8)

public  void RT_Internet_009 ( String br) throws Exception
{DOMConfigurator.configure("Regression_EBF.xml");
logger.info("Test 1 is called");
loc=15;
logger.info("Test 1 is called");

String exec1 = sheet11.getCell(3, loc).getContents();
logger.info(sheet11.getCell(0, loc).getContents()+" "+exec1);

if(exec1.equalsIgnoreCase("N") || exec1.equalsIgnoreCase("NA") ) {
	throw new SkipException("Skipping tests because value is set has N.");
}else
{
		try {

			logger.info("BR of test1 and loc  is "+br+" "+loc);
			Internet_Validation a = new Internet_Validation();
			logger.info("Value of gr in main is "+gr);
	
	
	if(gr.equalsIgnoreCase("Yes") && !br.equals(""))
	{			
		Test_called++;
		logger.info("Test_called in main test_b is"+Test_called );
		a.print(inputfile,outputfile+"_"+br+".xls",
				spath, true,br,loc,Test_called);
					
	}
	else if(gr.equals("No") && br.equals(" ") && !br.equals("NA"))
	{
		Test_called++;
		logger.info("GRID IS NO In MAIN!");
		//TestCompleted="Yes";
		a.print(inputfile,outputfile+".xls",
				 spath, true,br,loc,Test_called);
	
	}
	logger.info("loca value in test1 is "+loc);
	//loc++;
	TestCompleted="Yes";
	logger.info("Test completed yes or NO"+TestCompleted);
		}
	 catch (Exception e) {
			System.out
					.println("Error: There are issues regarding the IO files. Please verify and try again");
			logger.info(e.getMessage());
	 }}}

@Test(dataProvider="getData",priority=9)

public  void RT_Internet_010 ( String br) throws Exception
{DOMConfigurator.configure("Regression_EBF.xml");
logger.info("Test 1 is called");
loc=16;
logger.info("Test 1 is called");

String exec1 = sheet11.getCell(3, loc).getContents();
logger.info(sheet11.getCell(0, loc).getContents()+" "+exec1);

if(exec1.equalsIgnoreCase("N") || exec1.equalsIgnoreCase("NA") ) {
	throw new SkipException("Skipping tests because value is set has N.");
}else
{
		try {

			logger.info("BR of test1 and loc  is "+br+" "+loc);
			Internet_Validation a = new Internet_Validation();
			logger.info("Value of gr in main is "+gr);
	
	
	if(gr.equalsIgnoreCase("Yes") && !br.equals(""))
	{			
		Test_called++;
		logger.info("Test_called in main test_b is"+Test_called );
		a.print(inputfile,outputfile+"_"+br+".xls",
				spath, true,br,loc,Test_called);
					
	}
	else if(gr.equals("No") && br.equals(" ") && !br.equals("NA"))
	{
		Test_called++;
		logger.info("GRID IS NO In MAIN!");
		//TestCompleted="Yes";
		a.print(inputfile,outputfile+".xls",
				 spath, true,br,loc,Test_called);
	
	}
	logger.info("loca value in test1 is "+loc);
	//loc++;
	TestCompleted="Yes";
	logger.info("Test completed yes or NO"+TestCompleted);
		}
	 catch (Exception e) {
			System.out
					.println("Error: There are issues regarding the IO files. Please verify and try again");
			logger.info(e.getMessage());
	 }}}

@Test(dataProvider="getData",priority=10)

public  void RT_Internet_012 ( String br) throws Exception
{DOMConfigurator.configure("Regression_EBF.xml");
logger.info("Test 1 is called");
loc=18;
logger.info("Test 1 is called");

String exec1 = sheet11.getCell(3, loc).getContents();
logger.info(sheet11.getCell(0, loc).getContents()+" "+exec1);

if(exec1.equalsIgnoreCase("N") || exec1.equalsIgnoreCase("NA") ) {
	throw new SkipException("Skipping tests because value is set has N.");
}else
{
		try {

			logger.info("BR of test1 and loc  is "+br+" "+loc);
			Internet_Validation a = new Internet_Validation();
			logger.info("Value of gr in main is "+gr);
	
	
	if(gr.equalsIgnoreCase("Yes") && !br.equals(""))
	{			
		Test_called++;
		logger.info("Test_called in main test_b is"+Test_called );
		a.print(inputfile,outputfile+"_"+br+".xls",
				spath, true,br,loc,Test_called);
					
	}
	else if(gr.equals("No") && br.equals(" ") && !br.equals("NA"))
	{
		Test_called++;
		logger.info("GRID IS NO In MAIN!");
		//TestCompleted="Yes";
		a.print(inputfile,outputfile+".xls",
				 spath, true,br,loc,Test_called);
	
	}
	logger.info("loca value in test1 is "+loc);
	//loc++;
	TestCompleted="Yes";
	logger.info("Test completed yes or NO"+TestCompleted);
		}
	 catch (Exception e) {
			System.out
					.println("Error: There are issues regarding the IO files. Please verify and try again");
			logger.info(e.getMessage());
	 }}}


@AfterClass
public void closeCMD() throws IOException
{
       
       logger.info("THis is after class");
       if(gr.equalsIgnoreCase("Yes"))
       Runtime.getRuntime().exec("taskkill /IM cmd.exe");
                            
}

@Override
public void execute(String br, WebDriver paramDriver, String url, int loc)
		throws Exception {
	// TODO Auto-generated method stub
	
}
	
}
