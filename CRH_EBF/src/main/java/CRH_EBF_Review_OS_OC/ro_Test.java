package CRH_EBF_Review_OS_OC;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.util.Properties;

import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.read.biff.BiffException;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Locale;

import org.testng.SkipException;


public class ro_Test extends CommonFunctions{
	
	
	int Test_counter=0;
    int loc;
	
	int Test_called = 0;
 //String gr;
	
	//loc=7;

//logger.info("Current dir : " + dir1.getCanonicalPath());
		
	//@Parameters("browser")
	@BeforeClass
	public void Reader() throws IOException, BiffException, InterruptedException
	{
		DOMConfigurator.configure("Regression_EBF.xml");
		dir1 = new File(".");
		spath = dir1.getCanonicalPath();
		spath = spath.replaceAll("////", "////////");
		logger.info("Path "+spath);
		Load_Properties_File(spath);
		inputfile=spath+path_config.getProperty("inputSheetEBF");
		outputfile=spath+path_config.getProperty("resultSheetROOS");
		
		//computer_name folder changes �ankita
        String computerName=InetAddress.getLocalHost().getHostName();
        System.out.println(computerName);
        logger.info("Computer Name~~~~~~~~~~~"+computerName);
        newFolderPCName=computerName + "_Test_Results";
        File dir = new File(spath+"//Test_Results//"+newFolderPCName);
        dir.mkdir();
        outputfile=outputfile.replaceAll("Test_Results", "Test_Results//"+newFolderPCName);

//computer_name folder changes -ankita

        
		data11 = new File(inputfile);
		ws11 = new WorkbookSettings();
		ws11.setLocale(new Locale("er", "ER"));
		wb11 = Workbook.getWorkbook(data11, ws11);
		sheet11 = wb11.getSheet("Review_OS_OC");
		gr=sheet11.getCell(4,3).getContents();
		Grid_Status=gr;
		Sheet_name = sheet11.getName();
		//Auto launch grid config changes -JS Start
        if(gr.equalsIgnoreCase("Yes"))
     {

           String new_dir= spath + "//Supporting_Lib";
           String new_dir1= spath +"//Resource//Browser_Drivers";
           Runtime.getRuntime().exec("cmd.exe /c cd \""+new_dir+"\"& start cmd.exe /k \"java -jar selenium-server-standalone-2.45.0.jar -role hub\" ");
           Thread.sleep(10000);
           Runtime.getRuntime().exec("cmd.exe /c cd \""+new_dir1+"\"& start cmd.exe /k \"java -Dwebdriver.chrome.driver="+new_dir1+"//chromedriver.exe -Dwebdriver.ie.driver="+new_dir1+"//IEDriverServer.exe -jar selenium-server-standalone-2.45.0.jar -role webdriver -hub http://localhost:4444/grid/register -port 5556 -browser browserName=firefox,maxInstances=3 -browser browserName=chrome,maxInstances=3 -browser browserName=iexplore,maxInstances=3\" ");
           Thread.sleep(15000);
     }
      //Auto launch grid config changes -JS end
        

		for(int c=0;c<10;c++)
		{
			total[c]=0;
			counter_result_sheet[c]=10;
			counter_result_initial[c]=9;
			logger.info("RO initialized");
			ro[c]=10;
			l_browser[c]=0;
			pass_br_wise[c]=0;
			no_run[c]=0;
			 black[c]=0;
			 arrcount[c]=0;
		}
		
int first_row=Row_locator_full_scan("CHILD TEST CASE",inputfile,"Review_OS_OC");
		
		int LastRow=sheet11.getRows();
		logger.info(""+"Last_row "+LastRow);
		logger.info(""+"first_row "+first_row);
		for( int im=first_row;im<LastRow;im++)
		{
			String tc1= sheet11.getCell(3, im).getContents();
			logger.info(""+"TC1 "+tc1+" im varialble "+im+" "+sheet11.getCell(0, im).getContents());
			if(tc1.equalsIgnoreCase("Y"))
			{
				first_tc=im;
				logger.info("first_tc: "+first_tc);
				break;
			}
			
		}
		
		
		
		logger.info("spath..." +spath);
		
		
		File Pass_a = new File(spath+ "//" + "//Test_Results"+"//"+newFolderPCName+"//"+"CRH_EBF_Review_OS_OC_Pass_Screenshots////");
		logger.info("pass a :" +Pass_a);
	deleteFolder(Pass_a);
		File Fail_a = new File(spath+ "//" + "//Test_Results"+"//"+newFolderPCName+"//"+"CRH_EBF_Review_OS_OC_Fail_Screenshots////");
		deleteFolder(Fail_a);
		File Exception_a = new File(spath+ "//" + "//Test_Results"+"//"+newFolderPCName+"//"+"CRH_EBF_Review_OS_OC_Exception_Screenshots////");
		deleteFolder(Exception_a);
		// to create a folder for saving the images
		File BC_NewImage = new File(spath + "//"+ "//Test_Results"+"//"+computerName+"_BC_New_Images");
        deleteFolder(BC_NewImage);

		
	}
	

	@DataProvider(parallel=true)
	public Object[][] getData() throws IOException, BiffException{
		logger.info("Getting inside");
		
		no_of_browsers=sheet11.getCell(5,3).getContents();	
		no_of_browsers=no_of_browsers.substring(0, 1);
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
			logger.info("Grid option is NO");
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
	public  void RT_RO_OS_001_test ( String br) throws Exception {
	  loc=7;
	        
		String exec1 = sheet11.getCell(3, loc).getContents();
		logger.info(sheet11.getCell(0, loc).getContents()+" "+exec1);
		if(exec1.equalsIgnoreCase("N") || exec1.equalsIgnoreCase("NA") ) {
			throw new SkipException("Skipping tests because value is set has N.");
		}
		else{
		
		logger.info("RT_RO_OS_001 is called");
		logger.info("Test 1 is called");
		logger.info(""+loc);
	
		try {
			RO_OS_Validation a = new RO_OS_Validation();
				logger.info("BR of test 1 and loc  is "+br+" "+loc);
				logger.info("loc2:"+loc);
						
				if(gr.equalsIgnoreCase("Yes") && !br.equals(" "))
				{		
					 logger.info("loc3:"+loc);
					Test_called++;
					logger.info("Test_called in main RT_Package_001 is"+Test_called );
					// logger.info("loc:",loc);
					Load_Properties_File(spath);
				//	 logger.info("loc:",loc);
					a.print(inputfile,outputfile+"_"+br+".xls",spath, true, br,loc,Test_called);
						
					
				
				}
				else if(gr.equals("No") && br.equals(" ") && !br.equals("NA"))
				{
					Test_called++;
					logger.info("GRID IS NO In MAIN!");
					//br=sheet11.getCell(2,loc).getContents();
					//Load_Properties_File(spath);
					a.print(inputfile,outputfile+".xls",spath, true, br,loc,Test_called);
						
				
				}
				
				logger.info("loca value in test1 is "+loc);
				
				TestCompleted="Yes";
				logger.info("Test completed yes or NO"+TestCompleted);
				
				
				
		} catch (Exception e) {
			System.out
					.println("Error: There are issues regarding the IO files. Please verify and try again");
			logger.info(e.getMessage());
		}
		}
  }
  

	
	
  @Test(dataProvider="getData",priority=2)
	public  void RT_RO_OS_002_test ( String br) throws Exception {
	  loc=8;

		String exec1 = sheet11.getCell(3, loc).getContents();
		logger.info(sheet11.getCell(0, loc).getContents()+" "+exec1);
		if(exec1.equalsIgnoreCase("N") || exec1.equalsIgnoreCase("NA") ) {
			throw new SkipException("Skipping tests because value is set has N.");
		}
		else{
		
		logger.info("RT_RO_OS_002 is called");
		logger.info("Test 1 is called");
		 RO_OS_Validation a = new RO_OS_Validation();
	
		try {
				logger.info("BR of test 1 and loc  is "+br+" "+loc);
				
						
				if(gr.equalsIgnoreCase("Yes") && !br.equals(""))
				{			
					Test_called++;
					logger.info("Test_called in main RT_Package_001 is"+Test_called );
					Load_Properties_File(spath);					
					a.print(inputfile,outputfile+"_"+br+".xls",spath, true, br,loc,Test_called);
						
					
				
				}
				else if(gr.equals("No") && br.equals(" ") && !br.equals("NA"))
				{
					Test_called++;
					logger.info("GRID IS NO In MAIN!");
					//br=sheet11.getCell(2,loc).getContents();
					//Load_Properties_File(spath);
					a.print(inputfile,outputfile+".xls",spath, true, br,loc,Test_called);
						
				
				}
				
				logger.info("loca value in test1 is "+loc);
				
				TestCompleted="Yes";
				logger.info("Test completed yes or NO"+TestCompleted);
				
				
				
		} catch (Exception e) {
			System.out
					.println("Error: There are issues regarding the IO files. Please verify and try again");
			logger.info(e.getMessage());
		}
		}
}       


		
		//Test_counter++;
		
	
  @Test(dataProvider="getData",priority=3)
 	public  void RT_RO_OS_003_test ( String br) throws Exception {
 	  loc=9;

 	 RO_OS_Validation a = new RO_OS_Validation();
     

		String exec1 = sheet11.getCell(3, loc).getContents();
		logger.info(sheet11.getCell(0, loc).getContents()+" "+exec1);
		if(exec1.equalsIgnoreCase("N") || exec1.equalsIgnoreCase("NA") ) {
			throw new SkipException("Skipping tests because value is set has N.");
		}
		else{
		
		logger.info("RT_RO_OS_003 is called");
		logger.info("Test 1 is called");
		
	
		try {
				logger.info("BR of test 1 and loc  is "+br+" "+loc);
				
						
				if(gr.equalsIgnoreCase("Yes") && !br.equals(""))
				{			
					Test_called++;
					logger.info("Test_called in main RT_Package_001 is"+Test_called );
					Load_Properties_File(spath);					
					a.print(inputfile,outputfile+"_"+br+".xls",spath, true, br,loc,Test_called);
						
					
				
				}
				else if(gr.equals("No") && br.equals(" ") && !br.equals("NA"))
				{
					Test_called++;
					logger.info("GRID IS NO In MAIN!");
					//br=sheet11.getCell(2,loc).getContents();
					//Load_Properties_File(spath);
					a.print(inputfile,outputfile+".xls",spath, true, br,loc,Test_called);
						
				
				}
				
				logger.info("loca value in test1 is "+loc);
				
				TestCompleted="Yes";
				logger.info("Test completed yes or NO"+TestCompleted);
				
				
				
		} catch (Exception e) {
			System.out
					.println("Error: There are issues regarding the IO files. Please verify and try again");
			logger.info(e.getMessage());
		}
		}
 }       


 		
 		//Test_counter++;
 		
  @Test(dataProvider="getData",priority=4)
 	public  void RT_RO_OS_004_test ( String br) throws Exception {
 	  loc=10;

 	 RO_OS_Validation a = new RO_OS_Validation();
     

		String exec1 = sheet11.getCell(3, loc).getContents();
		logger.info(sheet11.getCell(0, loc).getContents()+" "+exec1);
		if(exec1.equalsIgnoreCase("N") || exec1.equalsIgnoreCase("NA") ) {
			throw new SkipException("Skipping tests because value is set has N.");
		}
		else{
		
		logger.info("RT_RO_OS_004 is called");
		logger.info("Test 1 is called");
		
	
		try {
				logger.info("BR of test 1 and loc  is "+br+" "+loc);
				
						
				if(gr.equalsIgnoreCase("Yes") && !br.equals(""))
				{			
					Test_called++;
					logger.info("Test_called in main RT_Package_001 is"+Test_called );
					Load_Properties_File(spath);					
					a.print(inputfile,outputfile+"_"+br+".xls",spath, true, br,loc,Test_called);
						
					
				
				}
				else if(gr.equals("No") && br.equals(" ") && !br.equals("NA"))
				{
					Test_called++;
					logger.info("GRID IS NO In MAIN!");
					//br=sheet11.getCell(2,loc).getContents();
					//Load_Properties_File(spath);
					a.print(inputfile,outputfile+".xls",spath, true, br,loc,Test_called);
						
				
				}
				
				logger.info("loca value in test1 is "+loc);
				
				TestCompleted="Yes";
				logger.info("Test completed yes or NO"+TestCompleted);
				
				
				
		} catch (Exception e) {
			System.out
					.println("Error: There are issues regarding the IO files. Please verify and try again");
			logger.info(e.getMessage());
		}
		}
 }       


 		
 		//Test_counter++;
 	
  @Test(dataProvider="getData",priority=5)
	public  void RT_RO_OS_005_test ( String br) throws Exception {
	  loc=11;
	  RO_OS_Validation a = new RO_OS_Validation();
	     

		String exec1 = sheet11.getCell(3, loc).getContents();
		logger.info(sheet11.getCell(0, loc).getContents()+" "+exec1);
		if(exec1.equalsIgnoreCase("N") || exec1.equalsIgnoreCase("NA") ) {
			throw new SkipException("Skipping tests because value is set has N.");
		}
		else{
		
		logger.info("RT_RO_OS_005 is called");
		logger.info("Test 1 is called");
		
	
		try {
				logger.info("BR of test 1 and loc  is "+br+" "+loc);
				
						
				if(gr.equalsIgnoreCase("Yes") && !br.equals(""))
				{			
					Test_called++;
					logger.info("Test_called in main RT_Package_001 is"+Test_called );
					Load_Properties_File(spath);					
					a.print(inputfile,outputfile+"_"+br+".xls",spath, true, br,loc,Test_called);
						
					
				
				}
				else if(gr.equals("No") && br.equals(" ") && !br.equals("NA"))
				{
					Test_called++;
					logger.info("GRID IS NO In MAIN!");
					//br=sheet11.getCell(2,loc).getContents();
					//Load_Properties_File(spath);
					a.print(inputfile,outputfile+".xls",spath, true, br,loc,Test_called);
						
				
				}
				
				logger.info("loca value in test1 is "+loc);
				
				TestCompleted="Yes";
				logger.info("Test completed yes or NO"+TestCompleted);
				
				
				
		} catch (Exception e) {
			System.out
					.println("Error: There are issues regarding the IO files. Please verify and try again");
			logger.info(e.getMessage());
		}
		}
}       


		
		//Test_counter++;
		
  @Test(dataProvider="getData",priority=6)
	public  void RT_RO_OS_006_test ( String br) throws Exception {
	  loc=12;

	  RO_OS_Validation a = new RO_OS_Validation();
	     

		String exec1 = sheet11.getCell(3, loc).getContents();
		logger.info(sheet11.getCell(0, loc).getContents()+" "+exec1);
		if(exec1.equalsIgnoreCase("N") || exec1.equalsIgnoreCase("NA") ) {
			throw new SkipException("Skipping tests because value is set has N.");
		}
		else{
		
		logger.info("RT_RO_OS_006 is called");
		logger.info("Test 1 is called");
		
	
		try {
				logger.info("BR of test 1 and loc  is "+br+" "+loc);
				
						
				if(gr.equalsIgnoreCase("Yes") && !br.equals(""))
				{			
					Test_called++;
					logger.info("Test_called in main RT_Package_001 is"+Test_called );
					Load_Properties_File(spath);					
					a.print(inputfile,outputfile+"_"+br+".xls",spath, true, br,loc,Test_called);
						
					
				
				}
				else if(gr.equals("No") && br.equals(" ") && !br.equals("NA"))
				{
					Test_called++;
					logger.info("GRID IS NO In MAIN!");
					//br=sheet11.getCell(2,loc).getContents();
					//Load_Properties_File(spath);
					a.print(inputfile,outputfile+".xls",spath, true, br,loc,Test_called);
						
				
				}
				
				logger.info("loca value in test1 is "+loc);
				
				TestCompleted="Yes";
				logger.info("Test completed yes or NO"+TestCompleted);
				
				
				
		} catch (Exception e) {
			System.out
					.println("Error: There are issues regarding the IO files. Please verify and try again");
			logger.info(e.getMessage());
		}
		}
}       


		
		//Test_counter++;
  @Test(dataProvider="getData",priority=7)
	public  void RT_RO_OS_007_test ( String br) throws Exception {
	  loc=13;

	  RO_OS_Validation a = new RO_OS_Validation();
	     

		String exec1 = sheet11.getCell(3, loc).getContents();
		logger.info(sheet11.getCell(0, loc).getContents()+" "+exec1);
		if(exec1.equalsIgnoreCase("N") || exec1.equalsIgnoreCase("NA") ) {
			throw new SkipException("Skipping tests because value is set has N.");
		}
		else{
		
		logger.info("RT_RO_OS_007 is called");
		logger.info("Test 1 is called");
		
	
		try {
				logger.info("BR of test 1 and loc  is "+br+" "+loc);
				
						
				if(gr.equalsIgnoreCase("Yes") && !br.equals(""))
				{			
					Test_called++;
					logger.info("Test_called in main RT_Package_001 is"+Test_called );
					Load_Properties_File(spath);					
					a.print(inputfile,outputfile+"_"+br+".xls",spath, true, br,loc,Test_called);
						
					
				
				}
				else if(gr.equals("No") && br.equals(" ") && !br.equals("NA"))
				{
					Test_called++;
					logger.info("GRID IS NO In MAIN!");
					//br=sheet11.getCell(2,loc).getContents();
					//Load_Properties_File(spath);
					a.print(inputfile,outputfile+".xls",spath, true, br,loc,Test_called);
						
				
				}
				
				logger.info("loca value in test1 is "+loc);
				
				TestCompleted="Yes";
				logger.info("Test completed yes or NO"+TestCompleted);
				
				
				
		} catch (Exception e) {
			System.out
					.println("Error: There are issues regarding the IO files. Please verify and try again");
			logger.info(e.getMessage());
		}
		}
}       


		
		//Test_counter++;
		
  @Test(dataProvider="getData",priority=8)
	public  void RT_RO_OS_008_test ( String br) throws Exception {
	  loc=14;
	  RO_OS_Validation a = new RO_OS_Validation();
	     

		String exec1 = sheet11.getCell(3, loc).getContents();
		logger.info(sheet11.getCell(0, loc).getContents()+" "+exec1);
		if(exec1.equalsIgnoreCase("N") || exec1.equalsIgnoreCase("NA") ) {
			throw new SkipException("Skipping tests because value is set has N.");
		}
		else{
		
		logger.info("RT_RO_OS_008 is called");
		logger.info("Test 1 is called");
		
	
		try {
				logger.info("BR of test 1 and loc  is "+br+" "+loc);
				
						
				if(gr.equalsIgnoreCase("Yes") && !br.equals(""))
				{			
					Test_called++;
					logger.info("Test_called in main RT_Package_001 is"+Test_called );
					Load_Properties_File(spath);					
					a.print(inputfile,outputfile+"_"+br+".xls",spath, true, br,loc,Test_called);
						
					
				
				}
				else if(gr.equals("No") && br.equals(" ") && !br.equals("NA"))
				{
					Test_called++;
					logger.info("GRID IS NO In MAIN!");
					//br=sheet11.getCell(2,loc).getContents();
					//Load_Properties_File(spath);
					a.print(inputfile,outputfile+".xls",spath, true, br,loc,Test_called);
						
				
				}
				
				logger.info("loca value in test1 is "+loc);
				
				TestCompleted="Yes";
				logger.info("Test completed yes or NO"+TestCompleted);
				
				
				
		} catch (Exception e) {
			System.out
					.println("Error: There are issues regarding the IO files. Please verify and try again");
			logger.info(e.getMessage());
		}
		}
	  }
	 
       
 
		//Test_counter++;
		
  @Test(dataProvider="getData",priority=9)
	public  void RT_RO_OS_009_test ( String br) throws Exception {
	  loc=15;

	  RO_OS_Validation a = new RO_OS_Validation();
	     

		String exec1 = sheet11.getCell(3, loc).getContents();
		logger.info(sheet11.getCell(0, loc).getContents()+" "+exec1);
		if(exec1.equalsIgnoreCase("N") || exec1.equalsIgnoreCase("NA") ) {
			throw new SkipException("Skipping tests because value is set has N.");
		}
		else{
		
		logger.info("RT_RO_OS_009 is called");
		logger.info("Test 1 is called");
		
	
		try {
				logger.info("BR of test 1 and loc  is "+br+" "+loc);
				
						
				if(gr.equalsIgnoreCase("Yes") && !br.equals(""))
				{			
					Test_called++;
					logger.info("Test_called in main RT_Package_001 is"+Test_called );
					Load_Properties_File(spath);					
					a.print(inputfile,outputfile+"_"+br+".xls",spath, true, br,loc,Test_called);
						
					
				
				}
				else if(gr.equals("No") && br.equals(" ") && !br.equals("NA"))
				{
					Test_called++;
					logger.info("GRID IS NO In MAIN!");
					//br=sheet11.getCell(2,loc).getContents();
					//Load_Properties_File(spath);
					a.print(inputfile,outputfile+".xls",spath, true, br,loc,Test_called);
						
				
				}
				
				logger.info("loca value in test1 is "+loc);
				
				TestCompleted="Yes";
				logger.info("Test completed yes or NO"+TestCompleted);
				
				
				
		} catch (Exception e) {
			System.out
					.println("Error: There are issues regarding the IO files. Please verify and try again");
			logger.info(e.getMessage());
		}
		}

}       


		
		//Test_counter++;
		
  @Test(dataProvider="getData",priority=10)
	public  void RT_RO_OS_010_test ( String br) throws Exception {
	  loc=16;
	  RO_OS_Validation a = new RO_OS_Validation();
	     

		String exec1 = sheet11.getCell(3, loc).getContents();
		logger.info(sheet11.getCell(0, loc).getContents()+" "+exec1);
		if(exec1.equalsIgnoreCase("N") || exec1.equalsIgnoreCase("NA") ) {
			throw new SkipException("Skipping tests because value is set has N.");
		}
		else{
		
		logger.info("RT_RO_OS_010 is called");
		logger.info("Test 1 is called");
		
	
		try {
				logger.info("BR of test 1 and loc  is "+br+" "+loc);
				
						
				if(gr.equalsIgnoreCase("Yes") && !br.equals(""))
				{			
					Test_called++;
					logger.info("Test_called in main RT_Package_001 is"+Test_called );
					Load_Properties_File(spath);					
					a.print(inputfile,outputfile+"_"+br+".xls",spath, true, br,loc,Test_called);
						
					
				
				}
				else if(gr.equals("No") && br.equals(" ") && !br.equals("NA"))
				{
					Test_called++;
					logger.info("GRID IS NO In MAIN!");
					//br=sheet11.getCell(2,loc).getContents();
					//Load_Properties_File(spath);
					a.print(inputfile,outputfile+".xls",spath, true, br,loc,Test_called);
						
				
				}
				
				logger.info("loca value in test1 is "+loc);
				
				TestCompleted="Yes";
				logger.info("Test completed yes or NO"+TestCompleted);
				
				
				
		} catch (Exception e) {
			System.out
					.println("Error: There are issues regarding the IO files. Please verify and try again");
			logger.info(e.getMessage());
		}
		}
}       


		
		//Test_counter++;
		
  @Test(dataProvider="getData",priority=11)
	public  void RT_RO_OS_011_test ( String br) throws Exception {
	  loc=17;

	  RO_OS_Validation a = new RO_OS_Validation();
	     

		String exec1 = sheet11.getCell(3, loc).getContents();
		logger.info(sheet11.getCell(0, loc).getContents()+" "+exec1);
		if(exec1.equalsIgnoreCase("N") || exec1.equalsIgnoreCase("NA") ) {
			throw new SkipException("Skipping tests because value is set has N.");
		}
		else{
		
		logger.info("RT_RO_OS_011 is called");
		logger.info("Test 1 is called");
		
	
		try {
				logger.info("BR of test 1 and loc  is "+br+" "+loc);
				
						
				if(gr.equalsIgnoreCase("Yes") && !br.equals(""))
				{			
					Test_called++;
					logger.info("Test_called in main RT_Package_001 is"+Test_called );
					Load_Properties_File(spath);					
					a.print(inputfile,outputfile+"_"+br+".xls",spath, true, br,loc,Test_called);
						
					
				
				}
				else if(gr.equals("No") && br.equals(" ") && !br.equals("NA"))
				{
					Test_called++;
					logger.info("GRID IS NO In MAIN!");
					//br=sheet11.getCell(2,loc).getContents();
					//Load_Properties_File(spath);
					a.print(inputfile,outputfile+".xls",spath, true, br,loc,Test_called);
						
				
				}
				
				logger.info("loca value in test1 is "+loc);
				
				TestCompleted="Yes";
				logger.info("Test completed yes or NO"+TestCompleted);
				
				
				
		} catch (Exception e) {
			System.out
					.println("Error: There are issues regarding the IO files. Please verify and try again");
			logger.info(e.getMessage());
		}
		}
}       


		
		//Test_counter++;
		
  @Test(dataProvider="getData",priority=12)
	public  void RT_RO_OS_012_test ( String br) throws Exception {
	  loc=18;

	  RO_OS_Validation a = new RO_OS_Validation();
	     

		String exec1 = sheet11.getCell(3, loc).getContents();
		logger.info(sheet11.getCell(0, loc).getContents()+" "+exec1);
		if(exec1.equalsIgnoreCase("N") || exec1.equalsIgnoreCase("NA") ) {
			throw new SkipException("Skipping tests because value is set has N.");
		}
		else{
		
		logger.info("RT_RO_OS_012 is called");
		logger.info("Test 1 is called");
		
	
		try {
				logger.info("BR of test 1 and loc  is "+br+" "+loc);
				
						
				if(gr.equalsIgnoreCase("Yes") && !br.equals(""))
				{			
					Test_called++;
					logger.info("Test_called in main RT_Package_001 is"+Test_called );
					Load_Properties_File(spath);					
					a.print(inputfile,outputfile+"_"+br+".xls",spath, true, br,loc,Test_called);
						
					
				
				}
				else if(gr.equals("No") && br.equals(" ") && !br.equals("NA"))
				{
					Test_called++;
					logger.info("GRID IS NO In MAIN!");
					//br=sheet11.getCell(2,loc).getContents();
					//Load_Properties_File(spath);
					a.print(inputfile,outputfile+".xls",spath, true, br,loc,Test_called);
						
				
				}
				
				logger.info("loca value in test1 is "+loc);
				
				TestCompleted="Yes";
				logger.info("Test completed yes or NO"+TestCompleted);
				
				
				
		} catch (Exception e) {
			System.out
					.println("Error: There are issues regarding the IO files. Please verify and try again");
			logger.info(e.getMessage());
		}
		}
}       


		
		//Test_counter++;
		
  @Test(dataProvider="getData",priority=13)
	public  void RT_RO_OS_013_test ( String br) throws Exception {
	  loc=19;

	  RO_OS_Validation a = new RO_OS_Validation();
	     

		String exec1 = sheet11.getCell(3, loc).getContents();
		logger.info(sheet11.getCell(0, loc).getContents()+" "+exec1);
		if(exec1.equalsIgnoreCase("N") || exec1.equalsIgnoreCase("NA") ) {
			throw new SkipException("Skipping tests because value is set has N.");
		}
		else{
		
		logger.info("RT_RO_OS_013 is called");
		logger.info("Test 1 is called");
		
	
		try {
				logger.info("BR of test 1 and loc  is "+br+" "+loc);
				
						
				if(gr.equalsIgnoreCase("Yes") && !br.equals(""))
				{			
					Test_called++;
					logger.info("Test_called in main RT_Package_001 is"+Test_called );
					Load_Properties_File(spath);					
					a.print(inputfile,outputfile+"_"+br+".xls",spath, true, br,loc,Test_called);
						
					
				
				}
				else if(gr.equals("No") && br.equals(" ") && !br.equals("NA"))
				{
					Test_called++;
					logger.info("GRID IS NO In MAIN!");
					//br=sheet11.getCell(2,loc).getContents();
					//Load_Properties_File(spath);
					a.print(inputfile,outputfile+".xls",spath, true, br,loc,Test_called);
						
				
				}
				
				logger.info("loca value in test1 is "+loc);
				
				TestCompleted="Yes";
				logger.info("Test completed yes or NO"+TestCompleted);
				
				
				
		} catch (Exception e) {
			System.out
					.println("Error: There are issues regarding the IO files. Please verify and try again");
			logger.info(e.getMessage());
		}
		}
}       

//Auto launch grid config changes -JS Start
@AfterClass
public void closeCMD() throws IOException
{
       
       logger.info("THis is after class");
       if(gr.equalsIgnoreCase("Yes"))
       Runtime.getRuntime().exec("taskkill /IM cmd.exe");
                            
}
//Auto launch grid config changes -JS end

		
		
		
@Override
public void execute(String br,WebDriver paramDriver, String url, int loc,
		String Overall_Path, String env) throws Exception {
	// TODO Auto-generated method stub
	
}
}