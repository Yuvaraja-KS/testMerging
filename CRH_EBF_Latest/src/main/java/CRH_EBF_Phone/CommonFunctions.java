package CRH_EBF_Phone;

import org.monte.media.FormatKeys.MediaType;
import org.monte.media.avi.AVIReader;
import org.monte.media.Buffer;
import org.monte.media.math.Rational;
import org.monte.media.avi.AVIWriter;
import org.monte.media.Format;
import org.monte.screenrecorder.ScreenRecorder;

import static org.monte.media.FormatKeys.EncodingKey;
import static org.monte.media.FormatKeys.FrameRateKey;
import static org.monte.media.FormatKeys.MediaTypeKey;
import static org.monte.media.VideoFormatKeys.*;

import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.text.*;
import java.util.*;
import java.util.NoSuchElementException;

import jxl.read.biff.BiffException;
import jxl.write.Formula;
import jxl.write.Number;
import jxl.write.WritableCell;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableWorkbook;
import jxl.format.*;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.write.Label;
import jxl.write.WritableSheet;

import java.io.File;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.URL;
import java.text.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.format.*;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.write.Label;
import jxl.write.WritableSheet;

import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.seleniumhq.jetty7.servlet.ServletContextHandler.Decorator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;







import CRH_EBF_Packages.EBF_Packages_Test;
import CRH_EBF_Phone.Result_bean;

import com.thoughtworks.selenium.Selenium;

import org.monte.media.FormatKeys.MediaType;
import org.monte.media.FormatKeys.MediaType;
import org.monte.media.math.Rational;
import org.monte.media.Format;
import org.monte.screenrecorder.ScreenRecorder;

import static org.monte.media.FormatKeys.EncodingKey;
import static org.monte.media.FormatKeys.FrameRateKey;
import static org.monte.media.FormatKeys.KeyFrameIntervalKey;
import static org.monte.media.FormatKeys.MIME_AVI;
import static org.monte.media.FormatKeys.MediaTypeKey;
import static org.monte.media.FormatKeys.MimeTypeKey;
import static org.monte.media.VideoFormatKeys.*;

import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;


public abstract class CommonFunctions {
	public static String pass_screenshot;
	private ScreenRecorder screenRecorder;
	public static Logger logger = LoggerFactory.getLogger(CommonFunctions.class);
	public static String newFolderPCName;
	public static String result_array[][] = new String[100][10000];
	//ArrayList<Result_bean> a = new ArrayList<Result_bean>();
	public static Map br_specific = new HashMap<String, List<Result_bean>>();
	public static int counter_browser = 0, k_browser = 0;
	public static String Grid_Status;
	public String TestCompleted = "No";
	public static int first_tc;
	public static int counter_result_sheet[] = new int[10];
	public static int ro[]=new int [10];
	public static int counter_result_initial[] = new int[10];
	public static int counter_result_final[] = new int[10];
	public static int pass_br_wise[] = new int[10];
	public static int no_run[] = new int[10];
	public static int total[] = new int[10];
	public static String browser[] = new String[20];
	public String input_sheet="CRH_ABF_Input_Sheet";
	public String browserused;
	public static int arrcount[] = new int[10];
	public static int l_browser[] = new int[10];
	public static String result[] = new String[150];
	public static String result_scenario[] = new String[150];
	public static String result_actual[] = new String[150];
	public static String result_expected[] = new String[150];
	public static int first = 0;
	public String path;
	public static WebDriver drive;
	public String path1;
	public static int screenshot = 1;
	public static int int_screenshot = 1;
	public String StoreAddress1 = "";
	public String StoreAddress2 = "";
	public String StoreAddress3 = "";
	public String Equip_text = "";
	public String ECKOptionSelected = "";
	public double InstallationFees = 0.0;
	public double Overall_oneTimeCharges = 0.0;
	public String Page_TV, Page_Phone;
	public String itemname[] = new String[15];
	public String itemcost[] = new String[15];
	public String itemname_mon[] = new String[15];
	public String itemcost_mon[] = new String[15];
	public String new_itemname_mon[] = new String[15];
	public String new_itemcost_mon[] = new String[15];
	public int carttotal;
	public String mon_total;
	DecimalFormat df = new DecimalFormat("#0.00");
	public String Page_Internet;
	
	public static int black[] = new int[10];
	public static File dir1;
	public static String spath,fname,offer_rel1,offer_com ;
	public static int Test_counter=0;
	public static String inputfile;
	public static String outputfile;
	public static Properties path_config;
	public static File data11;
	public static File data;
	public static WorkbookSettings ws11;
	public static Workbook wb11;
	public static Sheet sheet11 ;
	public static String gr,Sheet_name;
	public static String address1;
	public static String zipcode;
	 public static FileInputStream file_Stream;
	 public static String no_of_browsers;
	 
	 
	public String FirstChoiceDate = "";
	public String FirstChoiceTime = "";
	public String SecondChoiceDate = "";
	public String SecondChoiceTime = "";

	public int mon_total_items;
	public int new_mon_total_items;
	public String Rev_onetime_ChargesOption[] = new String[10];
	public String Rev_onetime_ChargesCost[] = new String[10];

	public String Overall_Path = "";
	public static boolean pass_screenshot_required;

	public abstract void execute(String br, WebDriver paramDriver, String url, int loc)
			throws Exception;

    public abstract String getTestCaseName();
    
	public String getStatus() {
		String b = "Fail";
		if (this.result.equals("Pass"))
			b = "Pass";
		return b;
	}

	public String randomNO(int max, int min) {
		int Max = max;
		int Min = min;
		double random1 = Min + (int) (Math.random() * ((Max - Min) + 1));
		int random2 = (int) random1;
		String s1 = new Integer(random2).toString();
		return (s1);

	}

	public boolean Button_enabled(String fxp) {

		return (drive.findElement(By.xpath(fxp)).isEnabled());

	}

	public boolean isElementPresent(String xp, WebDriver driver) {

		try {
			if (driver.findElement(By.xpath(xp)).isDisplayed())
				;
			return true;
		} catch (Exception e) {
			logger.info(""+"I am inside exception");
			return false;
		}
	}

	public boolean isElementPresent_1(String xp, WebDriver driver) {

		try {
			driver.findElement(By.xpath(xp));
			return true;
		} catch (Exception e) {
			logger.info("I am inside exception");
			return false;
		}
	}

	public int return_size(String fxp, WebDriver driver) {
		List<WebElement> myli = driver.findElements(By.xpath(fxp));
		return myli.size();
	}

	public void click_CSS_Element(String fxp, WebDriver driver) {
		driver.findElement(By.cssSelector(fxp)).click();
	}

	public void return_text_CSS_Element(String fxp, WebDriver driver) {
		driver.findElement(By.cssSelector(fxp)).getText();
	}

	public void select_list_CSS(String fxp, WebDriver driver, String index) {
		driver.findElement(By.cssSelector(fxp)).sendKeys(index);
	}

	public void select_list_xpath(String fxp, WebDriver driver, String index) {
		driver.findElement(By.xpath(fxp)).sendKeys(index);
	}
	
	

	 
    //RJ Billling
    
    
    public void Billing_Page(String br, WebDriver driver) throws InterruptedException
    { 
    
  //***********************Billing page starts****************************
    
	
	driver.switchTo().frame(1);
	
	//Validate the sections displayed in the Billing page - Contact
	   if ((driver.findElement(By.xpath(".//*[@id='verify_form']/div[1]/h4/span"))).getText().equalsIgnoreCase("Enter Your Contact Information")) 
		{			
	    logger.info("Validated the section displayed in the Billing page : Contact");	
	    statusTracker( br,driver, "Pass", "Validated the section displayed in the Billing page : Contact",
				"Validated the section displayed in the Billing page : Contact", "Validated the sections should display in the Billing page : Contact");
	    } 
	    else {
	    statusTracker(br,driver, "Fail", "Validated the section is NOT displayed in the Billing page : Contact",
				"Validated the section is NOT displayed in the Billing page : Contact", "Validated the sections should display in the Billing page : Contact");
		}    		    
	   Thread.sleep(1000); 
	   

		//Validate the sections displayed in the Billing page - PIN
	   if ((driver.findElement(By.xpath(".//*[@id='verify_form']/div[2]/h4/span"))).getText().equalsIgnoreCase("Create a PIN for Your Account")) 
		{			
	    logger.info("Validated the section displayed in the Billing page : PIN");	
	    statusTracker(br,driver, "Pass", "Validated the section displayed in the Billing page : PIN",
				"Validated the section displayed in the Billing page : PIN", "Validated the sections should display in the Billing page : PIN");
	    } 
	    else {
	    statusTracker(br,driver, "Fail", "Validated the section is NOT displayed in the Billing page : PIN",
				"Validated the section is NOT displayed in the Billing page : PIN", "Validated the sections should display in the Billing page : PIN");
		}    
	   Thread.sleep(1000); 
	   
	   
	   
		//Validate the sections displayed in the Billing page - Credit Check
	   if ((driver.findElement(By.xpath(".//*[@id='verify_form']/div[4]/h4/span[1]"))).getText().equalsIgnoreCase("Enter Your Information for Credit Check")) 
		{			
	    logger.info("Validated the section displayed in the Billing page : Credit Check");	
	    statusTracker(br,driver, "Pass", "Validated the section displayed in the Billing page : Credit Check",
				"Validated the section displayed in the Billing page : Credit Check", "Validated the sections should display in the Billing page : Credit Check");
	    } 
	    else {
	    statusTracker(br,driver, "Fail", "Validated the section is NOT displayed in the Billing page : Credit Check",
				"Validated the section is NOT displayed in the Billing page : Credit Check", "Validated the sections should display in the Billing page : Credit Check");
		}    
	
	   Thread.sleep(1000); 
	   
	
	
	driver.findElement(By.cssSelector("#first-name")).sendKeys("RAYMOND");
	logger.info("Not hidden");
	field_statustracker(br, ".//*[@id='first-name']","Enter First Name","First Name is Entered", driver);
	Thread.sleep(2000);

	driver.findElement(By.xpath("//*[@id='last-name']")).sendKeys("MLNNXZ");
	field_statustracker(br, ".//*[@id='last-name']","Enter Last Name","Last Name is Entered", driver);
  	Thread.sleep(2000);


	driver.findElement(By.id("phone")).sendKeys("466-666-4663");
  	Thread.sleep(2000);
  	field_statustracker(br, ".//*[@id='phone']","Enter Phone Number","Phone Number is Entered", driver);
  	Thread.sleep(1000);
   
  	driver.findElement(By.id("email")).sendKeys("rahul@gmail.com");
  	Thread.sleep(2000);
  	field_statustracker(br, ".//*[@id='email']","Enter Email Address","Email Address is Entered", driver);
  	Thread.sleep(1000);
  	
  	driver.findElement(By.id("email-confirm")).sendKeys("rahul@gmail.com");
  	Thread.sleep(1000);
  	field_statustracker(br, ".//*[@id='email-confirm']","Enter Email Address","Email Address is Entered", driver);
  	Thread.sleep(1000);
   
  	// Check box
  	 click_element(".//*[@id='special-offer']",driver);
	 Thread.sleep(1000);
   
   
	 
	 driver.findElement(By.id("PIN")).sendKeys("1234");
	 Thread.sleep(1000);
	 field_statustracker(br, ".//*[@id='PIN']","Enter Your PIN","Your PIN is Entered", driver);
	 Thread.sleep(1000);
	  	
	 driver.findElement(By.id("PIN-confirm")).sendKeys("1234");
     Thread.sleep(2000);
	 field_statustracker(br, ".//*[@id='PIN-confirm']","Enter Confirm Your PIN","Confirm Your PIN is Entered", driver);
	 Thread.sleep(1000);
	 
	 
	 //radio button
	 
	 click_element(".//*[@id='opt-out']",driver);
	 Thread.sleep(2000);
	 
	// Check box
  	 //click_element(".//*[@id='credit-check']",driver);
	 //Thread.sleep(2000);
	 
	// Continue
  	 click_element(".//*[@id='iframe-content']/section/nav/a",driver);
	 Thread.sleep(15000);		
	 driver.switchTo().frame(1);
	//driver.switchTo().frame(driver.findElement(By.xpath(".//*[@id='iframe-content']")));
	 
	  //Billing Payment	 - 
	 JavascriptExecutor jsxE = (JavascriptExecutor)driver;

	 jsxE.executeScript("window.scrollBy(0,0)", "");

	 Thread.sleep(4000);


	 driver.findElement(By.xpath(".//*[@id='name']")).sendKeys("IVEY");
	 Thread.sleep(2000);
	 field_statustracker(br, ".//*[@id='name']","Enter Cardholder's Name","Cardholder's Name is Entered", driver);
	 Thread.sleep(2000);
	 
	 driver.findElement(By.xpath(".//*[@id='card-number']")).sendKeys("4111111111111111");
	 Thread.sleep(2000);
	 field_statustracker(br, ".//*[@id='card-number']","Enter Card Number","Card Number is Entered", driver);
	 Thread.sleep(1000);
	 
	 driver.findElement(By.xpath(".//*[@id='ex-date']")).sendKeys("10/2016");
	 Thread.sleep(2000);
	 field_statustracker(br, ".//*[@id='ex-date']","Enter Expiration Date","Expiration Date is Entered", driver);
	 Thread.sleep(1000);    
 
	 
	 //Check box - Same Service address
  	 click_element(".//*[@id='same-as-service2']",driver);
	 Thread.sleep(2000);  		 
	 
	 //Check box tc
  	 click_element(" .//*[@id='rec-terms']",driver);
	 Thread.sleep(2000);  
	// Continue - Payment
	  click_element("  .//*[@id='iframe-content']/nav/a/span",driver);
	  Thread.sleep(12000);	
	 
	  
    }	
  
    
    
    
    public void Billing_Page_Yellow(String br,WebDriver driver) throws InterruptedException
    {   
    
    
  //***********************Billing page starts****************************
    
	driver.switchTo().frame(2);
	
	
	//Validate the sections displayed in the Billing page - Contact
	   if ((driver.findElement(By.xpath(".//*[@id='verify_form']/div[1]/h4/span"))).getText().equalsIgnoreCase("Enter Your Contact Information")) 
		{			
	    logger.info("Validated the section displayed in the Billing page : Contact");	
	    statusTracker(br,driver, "Pass", "Validated the section displayed in the Billing page : Contact",
				"Validated the section displayed in the Billing page : Contact", "Validated the sections should display in the Billing page : Contact");
	    } 
	    else {
	    statusTracker(br,driver, "Fail", "Validated the section is NOT displayed in the Billing page : Contact",
				"Validated the section is NOT displayed in the Billing page : Contact", "Validated the sections should display in the Billing page : Contact");
		}    		    
	   Thread.sleep(1000); 
	   

		//Validate the sections displayed in the Billing page - PIN
	   if ((driver.findElement(By.xpath(".//*[@id='verify_form']/div[2]/h4/span"))).getText().equalsIgnoreCase("Create a PIN for Your Account")) 
		{			
	    logger.info("Validated the section displayed in the Billing page : PIN");	
	    statusTracker(br,driver, "Pass", "Validated the section displayed in the Billing page : PIN",
				"Validated the section displayed in the Billing page : PIN", "Validated the sections should display in the Billing page : PIN");
	    } 
	    else {
	    statusTracker(br,driver, "Fail", "Validated the section is NOT displayed in the Billing page : PIN",
				"Validated the section is NOT displayed in the Billing page : PIN", "Validated the sections should display in the Billing page : PIN");
		}    
	   Thread.sleep(1000); 
	   
	   
	   
		//Validate the sections displayed in the Billing page - Credit Check
	   if ((driver.findElement(By.xpath(".//*[@id='verify_form']/div[4]/h4/span[1]"))).getText().equalsIgnoreCase("Enter Your Information for Credit Check")) 
		{			
	    logger.info("Validated the section displayed in the Billing page : Credit Check");	
	    statusTracker(br,driver, "Pass", "Validated the section displayed in the Billing page : Credit Check",
				"Validated the section displayed in the Billing page : Credit Check", "Validated the sections should display in the Billing page : Credit Check");
	    } 
	    else {
	    statusTracker(br,driver, "Fail", "Validated the section is NOT displayed in the Billing page : Credit Check",
				"Validated the section is NOT displayed in the Billing page : Credit Check", "Validated the sections should display in the Billing page : Credit Check");
		}    
	
	   Thread.sleep(1000); 
	   
	
	
	driver.findElement(By.cssSelector("#first-name")).sendKeys("GARY");
	logger.info("Not hidden");
	field_statustracker(br, ".//*[@id='first-name']","Enter First Name","First Name is Entered", driver);
	Thread.sleep(2000);

	driver.findElement(By.xpath("//*[@id='last-name']")).sendKeys("RLFPFH");
	field_statustracker(br, ".//*[@id='last-name']","Enter Last Name","Last Name is Entered", driver);
  	Thread.sleep(1000);


	driver.findElement(By.id("phone")).sendKeys("466-666-4663");
  	Thread.sleep(2000);
  	field_statustracker(br, ".//*[@id='phone']","Enter Phone Number","Phone Number is Entered", driver);
  	Thread.sleep(1000);
   
  	driver.findElement(By.id("email")).sendKeys("rahul@gmail.com");
  	Thread.sleep(2000);
  	field_statustracker(br, ".//*[@id='email']","Enter Email Address","Email Address is Entered", driver);
  	Thread.sleep(1000);
  	
  	driver.findElement(By.id("email-confirm")).sendKeys("rahul@gmail.com");
  	Thread.sleep(1000);
  	field_statustracker(br, ".//*[@id='email-confirm']","Enter Email Address","Email Address is Entered", driver);
  	Thread.sleep(1000);
   
  	// Check box
  	 click_element(".//*[@id='special-offer']",driver);
	 Thread.sleep(1000);
   
   
	 
	 driver.findElement(By.id("PIN")).sendKeys("1234");
	 Thread.sleep(1000);
	 field_statustracker(br, ".//*[@id='PIN']","Enter Your PIN","Your PIN is Entered", driver);
	 Thread.sleep(1000);
	  	
	 driver.findElement(By.id("PIN-confirm")).sendKeys("1234");
     Thread.sleep(2000);
	 field_statustracker(br, ".//*[@id='PIN-confirm']","Enter Confirm Your PIN","Confirm Your PIN is Entered", driver);
	 Thread.sleep(1000);
	 
	 
	 //driver.findElement(By.id("ssn")).sendKeys("666-66-6238");
	 //Thread.sleep(2000);
	 //field_statustracker(br, ".//*[@id='ssn']","Enter Your Social Security Number","Your Social Security Number is Entered", driver);
	 //Thread.sleep(1000);
	 
	 //driver.findElement(By.id("dob")).sendKeys("03/28/1964");
	 //Thread.sleep(1000);
	// field_statustracker(br, ".//*[@id='dob']","Enter Your Date of Birth","Your Date of Birth is Entered", driver);
	 //Thread.sleep(1000);
	 //radio button
	 click_element(".//*[@id='opt-out']",driver);
	 Thread.sleep(2000);
	 
	// Check box
  	 //click_element(".//*[@id='credit-check']",driver);
	 //Thread.sleep(2000);
	 
	// Continue
  	 click_element(".//*[@id='iframe-content']/section/nav/a",driver);
	 Thread.sleep(15000);		
	 
	 

		//Verify that Make your initial payment section is displayed 	    
     if (Isavailable(".//*[@id='payment_form']/div[1]",driver)) 
		{			
  logger.info("Validated that the Make your initial payment section is displayed");	
  statusTracker(br,driver, "Pass", "Validated that the Make your initial payment section is displayed",
				"Validated that the Make your initial payment section is displayed", "Validated that the Make your initial payment section should be displayed");
	    } 
  else {
  statusTracker(br,driver, "Fail", "Validated that the Make your initial payment section is NOT displayed",
	"Validated that the Make your initial payment section is NOT displayed", "Validated that the Make your initial payment section should be displayed");
		}		
  Thread.sleep(2000);	        



      
//  verify the mandatory fields displayed under initial payment section :  Cardholder's Name	   
       if ((driver.findElement(By.xpath(".//*[@id='cc']/fieldset[1]/label"))).getText().equalsIgnoreCase("Cardholder's Name:")) 
       {			
	         logger.info("Validated the mandatory fields displayed under initial payment section is : Cardholder's Name");	
	         statusTracker(br,driver, "Pass", "Validated the mandatory fields displayed under initial payment section is : Cardholder's Name",
						"Validated the mandatory fields displayed under initial payment section is : Cardholder's Name", "Validated the mandatory fields displayed under initial payment section should be : Cardholder's Name");
			    } 
	         else {
	         statusTracker(br,driver, "Fail", "Validated the mandatory fields displayed under initial payment section is NOT : Cardholder's Name",
			"Validated the mandatory fields displayed under initial payment section is NOT : Cardholder's Name", "Validated the mandatory fields displayed under initial payment section should be : Cardholder's Name");
				}		
            Thread.sleep(2000);	   
  
  
            
      //  verify the mandatory fields displayed under initial payment section : Card Number	   
                    if ((driver.findElement(By.xpath(".//*[@id='cc']/div[1]/fieldset/label"))).getText().equalsIgnoreCase("Card Number:")) 
                    {			
            	         logger.info("Validated the mandatory fields displayed under initial payment section is : Card Number");	
            	         statusTracker(br,driver, "Pass", "Validated the mandatory fields displayed under initial payment section is : Card Number",
            						"Validated the mandatory fields displayed under initial payment section is : Card Number", "Validated the mandatory fields displayed under initial payment section should be : Card Number");
            			    } 
            	         else {
            	         statusTracker(br,driver, "Fail", "Validated the mandatory fields displayed under initial payment section is NOT : Card Number",
            			"Validated the mandatory fields displayed under initial payment section is NOT : Card Number", "Validated the mandatory fields displayed under initial payment section should be : Card Number");
            				}		
                         Thread.sleep(1000);	  
                         
        //  verify the mandatory fields displayed under initial payment section : Expiration Date	   
           if ((driver.findElement(By.xpath(".//*[@id='cc']/fieldset[2]/label"))).getText().equalsIgnoreCase("Expiration Date:")) 
                         {			
           logger.info("Validated the mandatory fields displayed under initial payment section is : Expiration Date");	
           statusTracker(br,driver, "Pass", "Validated the mandatory fields displayed under initial payment section is : Expiration Date",
                	"Validated the mandatory fields displayed under initial payment section is : Expiration Date", "Validated the mandatory fields displayed under initial payment section should be : Expiration Date");
                 			    } 
            else {
           statusTracker(br,driver, "Fail", "Validated the mandatory fields displayed under initial payment section is NOT : Expiration Date",
                 "Validated the mandatory fields displayed under initial payment section is NOT : Expiration Date", "Validated the mandatory fields displayed under initial payment section should be : Expiration Date");
                 				}		
           Thread.sleep(1000);	                               
                         


           //Billing Payment	 
			 driver.findElement(By.xpath(".//*[@id='name']")).sendKeys("IVEY");
			 Thread.sleep(2000);
			 field_statustracker(br, ".//*[@id='name']","Enter Cardholder's Name","Cardholder's Name is Entered", driver);
			 Thread.sleep(2000);
			 
			 driver.findElement(By.xpath(".//*[@id='card-number']")).sendKeys("4111111111111111");
			 Thread.sleep(2000);
			 field_statustracker(br, ".//*[@id='card-number']","Enter Card Number","Card Number is Entered", driver);
			 Thread.sleep(1000);
			 
			 driver.findElement(By.xpath(".//*[@id='ex-date']")).sendKeys("10/2016");
			 Thread.sleep(2000);
			 field_statustracker(br, ".//*[@id='ex-date']","Enter Expiration Date","Expiration Date is Entered", driver);
			 Thread.sleep(1000);	    
	    
	    

//Validate the field displayed in the Billing address section has Street Address 
      
      if ((driver.findElement(By.xpath(".//*[@id='cc']/div[2]/fieldset[1]/label"))).getText().equalsIgnoreCase("Street Address:")) 
      {			
   logger.info("Validated the field displayed in the Billing address section has Street Address");	
   statusTracker(br,driver, "Pass", "Validated the field displayed in the Billing address section has Street Address",
	             "Validated the field displayed in the Billing address section has Street Address", "Validated the field displayed in the Billing address section should have Street Address");
			    } 
   else {
   statusTracker(br,driver, "Fail", "Validated the field displayed in the Billing address section does NOT have Street Address",
              "Validated the field displayed in the Billing address section does NOT have Street Address", "Validated the field displayed in the Billing address section should have Street Address");
				}		
   Thread.sleep(1000);	          
                      
         
    
   
//Validate the field displayed in the Billing address section has Apt., Suite, or Floor: 
     
     if ((driver.findElement(By.xpath(".//*[@id='cc']/div[2]/fieldset[2]/label"))).getText().equalsIgnoreCase("Apt., Suite, or Floor:")) 
     {			
  logger.info("Validated the field displayed in the Billing address section has Apt., Suite, or Floor");	
  statusTracker(br,driver, "Pass", "Validated the field displayed in the Billing address section has Apt., Suite, or Floor",
             "Validated the field displayed in the Billing address section has Apt., Suite, or Floor", "Validated the field displayed in the Billing address section should have Apt., Suite, or Floor");
			    } 
  else {
  statusTracker(br,driver, "Fail", "Validated the field displayed in the Billing address section does NOT have Apt., Suite, or Floor",
             "Validated the field displayed in the Billing address section does NOT have Apt., Suite, or Floor", "Validated the field displayed in the Billing address section should have Apt., Suite, or Floor");
				}		
  Thread.sleep(1000);	          
                                   
         
         
//Validate the field displayed in the Billing address section has City 
  
  if ((driver.findElement(By.xpath(".//*[@id='cc']/div[2]/fieldset[3]/label"))).getText().equalsIgnoreCase("City:")) 
  {			
logger.info("Validated the field displayed in the Billing address section has City");	
statusTracker(br,driver, "Pass", "Validated the field displayed in the Billing address section has City",
          "Validated the field displayed in the Billing address section has City", "Validated the field displayed in the Billing address section should have City");
		    } 
else {
statusTracker(br,driver, "Fail", "Validated the field displayed in the Billing address section does NOT have City",
          "Validated the field displayed in the Billing address section does NOT have City", "Validated the field displayed in the Billing address section should have City");
			}		
Thread.sleep(1000);	            
         
         
//Validate the field displayed in the Billing address section has State 

if ((driver.findElement(By.xpath(".//*[@id='cc']/div[2]/fieldset[4]/label"))).getText().equalsIgnoreCase("State:")) 
{			
logger.info("Validated the field displayed in the Billing address section has State");	
statusTracker(br,driver, "Pass", "Validated the field displayed in the Billing address section has State",
       "Validated the field displayed in the Billing address section has State", "Validated the field displayed in the Billing address section should have State");
	    } 
else {
statusTracker(br,driver, "Fail", "Validated the field displayed in the Billing address section does NOT have State",
       "Validated the field displayed in the Billing address section does NOT have State", "Validated the field displayed in the Billing address section should have State");
		}		
Thread.sleep(1000);             
         
         
         
//Validate the field displayed in the Billing address section has ZIP Code 

if ((driver.findElement(By.xpath(".//*[@id='cc']/div[2]/fieldset[5]/label"))).getText().equalsIgnoreCase("ZIP Code:")) 
{			
logger.info("Validated the field displayed in the Billing address section has ZIP Code");	
statusTracker(br,driver, "Pass", "Validated the field displayed in the Billing address section has ZIP Code",
       "Validated the field displayed in the Billing address section has ZIP Code", "Validated the field displayed in the Billing address section should have ZIP Code");
	    } 
else {
statusTracker(br,driver, "Fail", "Validated the field displayed in the Billing address section does NOT have StaZIP Code",
    "Validated the field displayed in the Billing address section does NOT have ZIP Code", "Validated the field displayed in the Billing address section should have ZIP Code");
		}		
Thread.sleep(1000);             
             
           
//Check box - Payment
click_element(".//*[@id='same-as-service2']",driver);
Thread.sleep(1000); 


//Continue - Payment
	 click_element(".//*[@id='iframe-content']/nav/a",driver);
	 Thread.sleep(12000);								 

   
    } 
    
    
    
    
   
    public void Billing_Page_Yellow_COD(String br,WebDriver driver) throws InterruptedException
    {   


	driver.switchTo().frame(2);
	
	
	//Validate the sections displayed in the Billing page - Contact
	   if ((driver.findElement(By.xpath(".//*[@id='verify_form']/div[1]/h4/span"))).getText().equalsIgnoreCase("Enter Your Contact Information")) 
		{			
	    logger.info("Validated the section displayed in the Billing page : Contact");	
	    statusTracker(br,driver, "Pass", "Validated the section displayed in the Billing page : Contact",
				"Validated the section displayed in the Billing page : Contact", "Validated the sections should display in the Billing page : Contact");
	    } 
	    else {
	    statusTracker(br,driver, "Fail", "Validated the section is NOT displayed in the Billing page : Contact",
				"Validated the section is NOT displayed in the Billing page : Contact", "Validated the sections should display in the Billing page : Contact");
		}    		    
	   Thread.sleep(1000); 
	   

		//Validate the sections displayed in the Billing page - PIN
	   if ((driver.findElement(By.xpath(".//*[@id='verify_form']/div[2]/h4/span"))).getText().equalsIgnoreCase("Create a PIN for Your Account")) 
		{			
	    logger.info("Validated the section displayed in the Billing page : PIN");	
	    statusTracker(br,driver, "Pass", "Validated the section displayed in the Billing page : PIN",
				"Validated the section displayed in the Billing page : PIN", "Validated the sections should display in the Billing page : PIN");
	    } 
	    else {
	    statusTracker(br,driver, "Fail", "Validated the section is NOT displayed in the Billing page : PIN",
				"Validated the section is NOT displayed in the Billing page : PIN", "Validated the sections should display in the Billing page : PIN");
		}    
	   Thread.sleep(1000); 
	   
	   
	   
		//Validate the sections displayed in the Billing page - Credit Check
	   if (Isavailable(".//*[@id='verify_form']/div[4]/h4/span[1]",driver))
	   {
	   String temp=driver.findElement(By.xpath(".//*[@id='verify_form']/div[4]/h4/span[1]")).getText();
	   logger.info(temp);
	   if ((driver.findElement(By.xpath(".//*[@id='verify_form']/div[4]/h4/span[1]"))).getText().equalsIgnoreCase("Enter Your Information for Credit Check")) 
		{			
	    logger.info("Validated the section displayed in the Billing page : Credit Check");	
	    statusTracker(br,driver, "Pass", "Validated the section displayed in the Billing page : Credit Check",
				"Validated the section displayed in the Billing page : Credit Check", "Validated the sections should display in the Billing page : Credit Check");
	    } }
	    else {
	    	logger.info("not available");
	    statusTracker(br,driver, "Fail", "Validated the section is NOT displayed in the Billing page : Credit Check",
				"Validated the section is NOT displayed in the Billing page : Credit Check", "Validated the sections should display in the Billing page : Credit Check");
		}    
	
	   Thread.sleep(1000); 
	   
	
	
	driver.findElement(By.cssSelector("#first-name")).sendKeys("GARY");
	logger.info("Not hidden");
	field_statustracker(br, ".//*[@id='first-name']","Enter First Name","First Name is Entered", driver);
	Thread.sleep(2000);

	driver.findElement(By.xpath("//*[@id='last-name']")).sendKeys("RLFPFH");
	field_statustracker(br, ".//*[@id='last-name']","Enter Last Name","Last Name is Entered", driver);
  	Thread.sleep(1000);


	driver.findElement(By.id("phone")).sendKeys("466-666-4663");
  	Thread.sleep(2000);
  	field_statustracker(br, ".//*[@id='phone']","Enter Phone Number","Phone Number is Entered", driver);
  	Thread.sleep(1000);
   
  	driver.findElement(By.id("email")).sendKeys("rahul@gmail.com");
  	Thread.sleep(2000);
  	field_statustracker(br, ".//*[@id='email']","Enter Email Address","Email Address is Entered", driver);
  	Thread.sleep(1000);
  	
  	driver.findElement(By.id("email-confirm")).sendKeys("rahul@gmail.com");
  	Thread.sleep(1000);
  	field_statustracker(br, ".//*[@id='email-confirm']","Enter Email Address","Email Address is Entered", driver);
  	Thread.sleep(1000);
   
  	// Check box
  	 click_element(".//*[@id='special-offer']",driver);
	 Thread.sleep(1000);
   
   
	 
	 driver.findElement(By.id("PIN")).sendKeys("1234");
	 Thread.sleep(1000);
	 field_statustracker(br, ".//*[@id='PIN']","Enter Your PIN","Your PIN is Entered", driver);
	 Thread.sleep(1000);
	  	
	 driver.findElement(By.id("PIN-confirm")).sendKeys("1234");
     Thread.sleep(2000);
	 field_statustracker(br, ".//*[@id='PIN-confirm']","Enter Confirm Your PIN","Confirm Your PIN is Entered", driver);
	 Thread.sleep(1000);
	 
	 
	// driver.findElement(By.id("ssn")).sendKeys("666-66-6238");
	 //Thread.sleep(2000);
	 //field_statustracker(br, ".//*[@id='ssn']","Enter Your Social Security Number","Your Social Security Number is Entered", driver);
	 //Thread.sleep(1000);
	 
	 //driver.findElement(By.id("dob")).sendKeys("03/28/1964");
	 //Thread.sleep(1000);
	 //field_statustracker(br, ".//*[@id='dob']","Enter Your Date of Birth","Your Date of Birth is Entered", driver);
	// Thread.sleep(1000);
	 
	//radio button
		 click_element(".//*[@id='opt-out']",driver);
		 Thread.sleep(2000);
	// Check box
  	 //click_element(".//*[@id='credit-check']",driver);
	 //Thread.sleep(2000);
	 
	// Continue
  	 click_element(".//*[@id='iframe-content']/section/nav/a",driver);
	 Thread.sleep(15000);		
	 

	    
//Validate that user is displayed with Select Your Payment method 
	 
	 click_element(".//*[@id='delivery']",driver);
	 Thread.sleep(10000);  

if (Isavailable(".//*[@id='payment-method']/h4/span",driver)) 
{			
logger.info("Verifed that user is displayed with Select Your Payment method");	
statusTracker(br,driver, "Pass", "Verifed that user is displayed with Select Your Payment method",
		"Verifed that user is displayed with Select Your Payment method", "Verified that user should be displayed with Select Your Payment method");
} 
else {
statusTracker(br,driver, "Fail", "Verifed that user is NOT displayed with Select Your Payment method",
		"Verifed that user is NOT displayed with Select Your Payment method", "Verified that user should be displayed with Select Your Payment method");
}	            

Thread.sleep(2000);



//**************shd swich **************


//Validate the 2 options with radio buttons displayed under Select Your Payment method section

if ((driver.findElement(By.xpath(".//*[@id='payment-method']/fieldset[1]/div/label"))).getText().equalsIgnoreCase("Pay by credit card now.")) 
{			
 logger.info("Validated the option with radio button : Pay by credit card now is displayed under Select Your Payment method section");	
 statusTracker(br,driver, "Pass", "Validated the option with radio button : Pay by credit card now is displayed under Select Your Payment method section",
			"Validated the option with radio button : Pay by credit card now is displayed under Select Your Payment method section", "Validated the option with radio button : Pay by credit card now should be displayed under Select Your Payment method section");
    } 
 else {
 statusTracker(br,driver, "Fail", "Validated the option with radio button : Pay by credit card now is NOT displayed under Select Your Payment method section",
"Validated the option with radio button : Pay by credit card now is NOT displayed under Select Your Payment method section", "Validated the option with radio button : Pay by credit card now should be displayed under Select Your Payment method section");
	}		
 Thread.sleep(2000);	             


 if ((driver.findElement(By.xpath(".//*[@id='payment-method']/fieldset[2]/div/label"))).getText().equalsIgnoreCase("Pay upon delivery.")) 
 {			
     logger.info("Validated the option with radio button : Pay upon delivery now is displayed under Select Your Payment method section");	
     statusTracker(br,driver, "Pass", "Validated the option with radio button : Pay upon delivery now is displayed under Select Your Payment method section",
				"Validated the option with radio button : Pay upon delivery now is displayed under Select Your Payment method section", 
				"Validated the option with radio button : Pay upon delivery now should be displayed under Select Your Payment method section");
	    } 
     else {
     statusTracker(br,driver, "Fail", "Validated the option with radio button : Pay upon delivery now is NOT displayed under Select Your Payment method section",
	"Validated the option with radio button : Pay upon delivery now is NOT displayed under Select Your Payment method section", 
	"Validated the option with radio button : Pay upon delivery now should be displayed under Select Your Payment method section");
		}		
     Thread.sleep(4000);	   
     
     
     

	 //Radio Button  - User opts for COD
     click_element(".//*[@id='payment-method']/h4/span",driver);
     Thread.sleep(4000);

     
     click_element(".//*[@id='cc-card']",driver);
     Thread.sleep(4000);

     if (Isavailable(".//*[@id='delivery']",driver)) 
     {
		 logger.info("COD option available");
		 statusTracker(br,driver, "Pass", "COD option available",
					"COD option available", "COD option shold be available");
	}
		else
	{
		 logger.info("textbox is not present!");
		 statusTracker(br,driver, "Fail", "COD option NOT available",
					"COD option NOT available", "COD option shold be available");
	}
	Thread.sleep(2000);
     

	//	click_element(".//*[@class='radio radio-delivery']",driver);
    //  driver.findElement(By.xpath(".//*[@id='delivery']")).click();


		click_element(".//*[@id='delivery']",driver);
	    Thread.sleep(12000);                   
	    logger.info("User opts for COD");	
        statusTracker(br,driver, "Pass", "User opts for COD",
					"User opts for COD", "User should opt for COD");
		   

//Validate on choosing COD option user is displayed with Continue button
        
        if (Isavailable(".//*[@id='iframe-content']/nav/a",driver)) 
			{			
		    logger.info("Validated on choosing COD option user is displayed with Continue button");	
		    statusTracker(br,driver, "Pass", "Validated on choosing COD option user is displayed with Continue button",
					"Validated on choosing COD option user is displayed with Continue button", "Validated on choosing COD option user should be displayed with Continue button");
		    } 
		    else {
		    statusTracker(br,driver, "Fail", "Validated on choosing COD option user is NOT displayed with Continue button",
					"Validated on choosing COD option user is NOT displayed with Continue button", "Validated on choosing COD option user should be displayed with Continue button");
			}	            
         
         Thread.sleep(2000);

         
         //User clicks on Continue button	    	        
	        
	    	click_element(".//*[@id='iframe-content']/nav/a",driver);
			Thread.sleep(10000);               
			logger.info("User clicks on Continue button");	
	        statusTracker(br,driver, "Pass", "User clicks on Continue button",
						"User clicks on Continue button", "User should be able to click on Continue button");

    
    }
    
    
    

    
    
//EOC RJ Billing    
	
	
	
	
	//RJ
	
// validationofTWClogo
	
	

    public void Common_Elements_TWClogo(String br,WebDriver driver) throws Exception {
	
	logger.info("*******Before Click*********");
	logger.info(driver.getWindowHandle());
	String parentWin = driver.getWindowHandle();
	                    
	driver.findElement(By.xpath(".//*[@class='img desktop']")).click();
	
	
	Thread.sleep(10000);
	logger.info("*******AFter Click*********");
	Set<String> Win = driver.getWindowHandles();
	Iterator<String> Itr = Win.iterator();

	String MainWin = Itr.next();
	String TabWin = Itr.next();
	driver.switchTo().window(TabWin);

	String subWinTitle = "Cable TV, High Speed Internet & Home Phone Service | Time Warner Cable";
	Thread.sleep(5000);
	String subActitle = driver.getTitle();

	logger.info(subActitle);
	Thread.sleep(8000);

	if (subWinTitle.equals(subActitle)) {
		statusTracker(br,driver, "Pass",
				"TWC Logo is clickable and opens in new tab",
				"Clickable and opens in new tab",
				"Should be Clickable and should open in new tab");
	} else {
		statusTracker(br,driver, "Fail",
				"TWC Logo is clickable and opens in new tab",
				"Its NOT clickable",
				"Should be Clickable and should open in new tab");
	}

	Thread.sleep(5000);
	driver.switchTo().window(parentWin);
	Thread.sleep(5000);
	driver.switchTo().window(parentWin);
	String parWinTitle = "Current Services | Time Warner Cable";
	String parActitle = driver.getTitle();

    }	
    
    
    /*
	// Validation of User Name
	public void Phone_Username(WebDriver driver,int loc) throws Exception
	{
	String UserName = driver.findElement(By.xpath(".//*[@id='your_services']/div[7]/header/div[1]/ul/li[1]/div/em")).getText();
	File data = new File(this.path);
	WorkbookSettings ws = new WorkbookSettings();
	ws.setLocale(new Locale("er", "ER"));
	arrcount = 0;
	logger.info("chheck1");
	Workbook wb = Workbook.getWorkbook(data, ws);
	Sheet sheet2 = wb.getSheet(0);
	String Uname = sheet2.getCell(9, loc).getContents();
	
	if (UserName.equals(Uname)) {
		logger.info("The username matches");
		statusTracker(br,driver, "Pass", "The first and last name", "Matches",
				"Should match");
	} else {
		logger.info("name match fails");
		statusTracker(br,driver, "Fail",
				"The first and last name doesnt match",
				"Doesnt Match", "Should match");
	}
	}
	
	
	
	// Validation of sign out
	
	public void Phone_Signout(WebDriver driver) throws Exception {
	
	String Expected_str = "Sign Out";
	if (driver
			.findElement(
					By.xpath(".//*[@id='your_services']/div[7]/header/div[1]/ul/li[1]/div/a"))
			.getText().equals(Expected_str))

	{
		logger.info("Pass");
		statusTracker(br,driver, "Pass", "Signout is displayed",
				"Sign out present", "Sign out should be displayed");
	} else {
		logger.info("Fail");
		statusTracker(br,driver, "Fail", "Signout is displayed",
				"Sign out not displayed",
				"Sign out should be displayed");
	}
	
	}	
	*/

	
	
	//EOC RJ
	
	
	
	
	

	public String orderprocess() throws Exception {
		Thread.sleep(1000);
		do {

		} while ((drive.findElements(By.xpath("//div[10]")).size() != 0));
		// while(selenium.isVisible("css=#progress > div > p"));
		if ((drive.findElements(By.id("id=modalContinueButton")).size() != 0)
				&& (drive.findElement(By.id("id=modalContinueButton"))
						.isDisplayed())) {
			return "Fail";
		} else if (!((drive.findElements(
				By.id("css=div.validation-summary-errors > ul > li")).size() != 0))) {
			// selenium.click("id=modalContinueButton");
			logger.info("sssswewewew");
			return "Pass";
		} else {
			return "Fail";
		}
	}

	public String orderprocess(String error_region) throws Exception {
		Thread.sleep(1000);
		do {

		} while ((drive.findElements(By.xpath("//div[9]")).size() != 0));
		// while(selenium.isVisible("css=#progress > div > p"));
		if ((drive.findElements(By.id("id=modalContinueButton")).size() != 0)
				&& (drive.findElement(By.id("id=modalContinueButton"))
						.isDisplayed())) {
			return "Fail";
		} else if (!((drive.findElements(By.id(error_region)).size() != 0))) {
			// selenium.click("id=modalContinueButton");
			logger.info("sssswewewew");
			return "Pass";
		} else {
			return "Fail";
		}
	}
	
	public void statusTracker( String br, WebDriver driver, String r, String rscenario,
            String ractual, String rexpected) {
		Result_bean rb = new Result_bean();
		rb.setBrowser(br);
		rb.setTestCase(getTestCaseName());
		rb.setResult(r);
		//rb.setResult_actual(ractual);
		rb.setResult_expected(rexpected);
		rb.setResult_scenario(rscenario);

		logger.info("Get R*" + rb.getResult());
		// Optimized statustracker code starts	--Shivendu
		String imagename = "";
		Date dNow;
		SimpleDateFormat ft = new SimpleDateFormat("'_'MMMM_dd'_'hh.mma");
		
		if (r.equals("Fail")) {
			imagename = spath+ "//" + "//Test_Results"+"//"+newFolderPCName+ "////"
					+ "CRH_EBF_Phone_Fail_Screenshots//"+br+"////" + Page_Phone
					+ "_Int_Fail";
		} else if (pass_screenshot_required == true) {
			imagename =spath+ "//" + "//Test_Results"+"//"+newFolderPCName + "////" + "CRH_EBF_Phone_Pass_Screenshots//"+br+"////"
					+ Page_Phone+"_Int_Pass";
		} else {
			rb.setResult_actual(ractual + " : No screenshot required");
		}
		if(imagename != "") {
			dNow = new Date();
			logger.info(ft.format(dNow));

			int_screenshot++;
			imagename = imagename + (int_screenshot-1) + ft.format(dNow) + ".png";
			logger.info("imagename - " + imagename);
			try {
				File scrFile1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(scrFile1, new File(imagename));
			} catch (Exception e) {
				imagename = "Unable to capture screenshot";
			}
			rb.setResult_actual(ractual + " Refer screenshot: " + imagename);
		}
		switch(browserValueCalculator(br)) {
			case 1:	CRH_EBF_Phone_test.result_FF.add(rb);
				break;
			case 2:	CRH_EBF_Phone_test.result_Chrome.add(rb);
				break;
			case 3:	CRH_EBF_Phone_test.result_IE.add(rb);
				break;
			case 4:	CRH_EBF_Phone_test.result_IE10.add(rb);
				break;
			case 5:	CRH_EBF_Phone_test.result_IE11.add(rb);
				break;
			default:	logger.info("Browser " + (br.equals("") ? "NULL" : br) + " can not generate results");
				break;
		}
		// Optimized statustracker code ends	--Shivendu
	}


	public String exceptionHandler(String br, Exception ex, WebDriver driver) {
		String s = "";
		String name = "image";
		try {
			throw ex;
		} catch (NullPointerException e) {
			s = "Selenium is trying to access an object which is not present";
			statusTracker(br,driver, "Fail", " ", s, "");
		} catch (Exception e) {
			String Folder_name = "Phone_";
			//computer_name folder changes -ankita
			String imagename = spath+"//"+ "//Test_Results" +"//"+newFolderPCName+"//"+"CRH_EBF_Phone_Exception_Screenshots//"+br+"////"
					+ Page_Phone + "_Ext_Exception";
			SimpleDateFormat ft = new SimpleDateFormat("'_'MMMM dd'_'hh.mma");
			Date dNow = new Date();
			imagename = imagename + screenshot + ft.format(dNow) + ".png";
			// imagename=imagename+screenshot+".png";
			screenshot++;

			try {
				File scrFile1 = ((TakesScreenshot) driver)
						.getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(scrFile1, new File(imagename));
				// seleniu.captureEntirePageScreenshot(imagename, "");
			} catch (Exception f) {
				imagename = "Unable to capture a screenshot";
			}

			if (e.getMessage().contains("ids.eng.rr.com")) {
				logger.info("loop1_exception");
				s = "IDMS issue";
			} else if (e.getMessage().contains("sso-hrndva")) {
				logger.info("loop1a_exception");
				s = "SSO Gateway issue";
			}

			else if (e.getMessage().contains("not found")) {
				// logger.info("loop2_exception");
				// logger.info("I called excption handler");
				// logger.info(ex.getMessage());
				statusTracker(br,driver,  "Fail", "", e.getMessage(),
						"Element should be displayed");
				s = "Selenium has stopped because an element was not found - "
						+ e.getMessage();
				// driver.quit();
				first = 0;
			} else if (e.getMessage().contains("terminal")
					|| driver.getCurrentUrl().contains("Terminal")) {
				// logger.info("loop3_exception");
				s = "Terminal error page has stopped execution";
				driver.quit();
				first = 0;
			} else if (driver.getCurrentUrl().contains("CLAReconcile.aspx")) {
				// logger.info("loop4_exception");
				s = "There was an error in the Reconciliation. Please retry";
				driver.quit();
				first = 0;
			} else if (driver.getCurrentUrl().contains("ids.eng.rr.com")) {
				// logger.info("loop5_exception");
				s = "IDMS issue has prevented the page from proceeding further";
				driver.quit();
				first = 0;
			} else if (driver.getCurrentUrl().contains("erminal")) {
				// logger.info("loop6_exception");
				s = "Terminal error page has prevented the automation from proceeding further";
				driver.quit();
				first = 0;
			} else if ((driver.findElements(By.id("css=h1")).size() != 0)
					&& (driver.findElements(By.id("id=imgLogo")).size() != 0)) {
				// logger.info("loop7_exception");
				s = "Top Error has prevented the page from proceeding further";
				driver.quit();
				first = 0;
			} else {
				// logger.info("loop8_exception");
				s = "The browser has taken too long to respond or an intermediate error has occurred "
						+ e.getMessage();

				// logger.info(e.getMessage());
				// driver.quit();
				// first=0;
				statusTracker(br,driver,  "Fail", " ", s, " ");

			}
			// s=s+" Refer to screenshot: "+imagename;
			// statusTracker(br,driver,  br,"Fail"," ",s," ");
		}
		name = name + screenshot;
		screenshot += 1;
		return s;
	}
	
 	public void deleteFolder(File folder)
 	{
	    File[] files = folder.listFiles();
	    if(files!=null) { //some JVMs return null for empty dirs
	        for(File f: files) {
	            if(f.isDirectory())
	            {
	                deleteFolder(f);
	            } else {
	                f.delete();
	            }
	        }
	    }
	    folder.delete();
	}
	
	public String return_text(String fxp, WebDriver driver) {
		WebElement dropDownListBox = driver.findElement(By.xpath(fxp));
        Actions actions = new Actions(driver);
		actions.moveToElement(dropDownListBox);
		actions.perform();

		String str = driver.findElement(By.xpath(fxp)).getText();
		return str;
	}

	public String return_text_CSS(String fxp, WebDriver driver) {
		String str = driver.findElement(By.cssSelector(fxp)).getText();
		return str;
	}

	public void click_element(String fxp, WebDriver driver) {
		WebElement dropDownListBox = driver.findElement(By.xpath(fxp));
        Actions actions = new Actions(driver);
		actions.moveToElement(dropDownListBox);
		actions.perform();

		driver.findElement(By.xpath(fxp)).click();

	}
	public void setUp(int loc, String br, String name1) throws Exception {

		try {
			if (first == 0) {
				logger.info("set up is called");
				WebDriver driver=null;
				File URL = new File(this.path);
				WorkbookSettings ws = new WorkbookSettings();
				ws.setLocale(new Locale("er", "ER"));
				Workbook wb_url = Workbook.getWorkbook(URL, ws);
				Sheet sheet_url = wb_url.getSheet("Phone");
				String Sheet_name = sheet_url.getName();
				String url = sheet_url.getCell(1,3).getContents();
				String b = sheet_url.getCell(Col_locator_full_scan_input_sheet("Browser", path,Sheet_name), loc).getContents();
				logger.info(url);
				
				
				if (Grid_Status.equalsIgnoreCase("No")) {
					br = sheet_url.getCell(2, loc).getContents();
					
				}
				logger.info("Grid_Status " + Grid_Status + " br " + br);
				
				logger.info(url);
				
					DesiredCapabilities capabilities = null;
					
					String video=sheet_url.getCell(5, loc).getContents();
                    if(video.equalsIgnoreCase("Y"))
                           startRecording();   

					 wb_url.close();
				if (br.equalsIgnoreCase("IE")) {

					String currentdir = System.getProperty("user.dir");
					File dir1 = new File(".");

					logger.info("Current dir : "
							+ dir1.getCanonicalPath());
					logger.info("helosss");
					
					logger.info("************IE********************");
					logger.info("Current dir : "
							+ dir1.getCanonicalPath());
					String spath = dir1.getCanonicalPath();
					spath = spath.replaceAll("////", "////////");
					spath = spath + "//" + "Resource" + "//"
							+ "Browser_Drivers";
					logger.info("spath is ---" + spath);

					logger.info("************IE**************");

					File file = new File(spath + "//IEDriverServer.exe");
					System.setProperty("webdriver.ie.driver",
							file.getAbsolutePath());
					capabilities = DesiredCapabilities.internetExplorer();
					capabilities.setPlatform(Platform.ANY);
					capabilities.setBrowserName("iexplore");

					capabilities.setCapability("browserstack.ie.enablePopups",
							"false");
				
					System.out
							.println("************capabilities**************");
					if (Grid_Status.equalsIgnoreCase("No")) {
						driver = new InternetExplorerDriver();
						logger.info("************IE**************");
					}

					
				} else if (br.equalsIgnoreCase("SF")) {
					if (Grid_Status.equalsIgnoreCase("No")) {
						driver = new SafariDriver();
					}
				} else if (br.equalsIgnoreCase("chrome")) {
					logger.info("went inside chrome");
					
					logger.info("i went inside this loop of chrome");
					String currentdir = System.getProperty("user.dir");
					File dir1 = new File(".");

					capabilities = DesiredCapabilities.chrome();
					capabilities.setBrowserName("chrome");
					capabilities.setPlatform(Platform.ANY);
					ChromeOptions options = new ChromeOptions();

					options.addArguments("--disable-popup-blocking");
					capabilities.setCapability(ChromeOptions.CAPABILITY,
							options);
					options.addArguments("test-type");
					logger.info("last loop of chrome");
					
					if (Grid_Status.equalsIgnoreCase("No")) {
						logger.info("Current dir : "
								+ dir1.getCanonicalPath());
						String spath = dir1.getCanonicalPath();
						spath = spath.replaceAll("////", "////////");
						spath = spath + "//" + "Resource" + "//"
								+ "Browser_Drivers";
						logger.info("spath is ---" + spath);
						System.setProperty("webdriver.chrome.driver", spath
								+ "//chromedriver.exe");
						capabilities = DesiredCapabilities.chrome();
						driver = new ChromeDriver(capabilities);
					}

				} else {
					logger.info(""+"Fire fox browser started");
					logger.info(""+"i went inside this loop of firefox");
					capabilities = DesiredCapabilities.firefox();
					capabilities.setBrowserName("firefox");
					capabilities.setPlatform(Platform.ANY);

					FirefoxProfile profile = new FirefoxProfile();
					profile.setPreference("plugin.state.flash", 0);
					capabilities.setCapability(FirefoxDriver.PROFILE, profile);

					if (Grid_Status.equalsIgnoreCase("No")
							) {
						logger.info(""+"In loop of firefox driver and grid status false");
												driver = new FirefoxDriver();
					}
				}
				logger.info(""+"Before grid remote");
				if (Grid_Status.equalsIgnoreCase("Yes")) {
					logger.info("grid id true ---");
					driver = new RemoteWebDriver(new URL(
							"http://localhost:4444/wd/hub"), capabilities);
					logger.info("br : " + br);

					logger.info("grid id true 2---");
				}

				logger.info(""+"helo");
				

				wb_url.close();
				
				EventFiringWebDriver eventDriver = new EventFiringWebDriver(
						driver);
				EventHandler handler = new EventHandler(br);
				eventDriver.register(handler);
				drive = eventDriver;
				
				//	drive = driver;
				logger.info("Just reached end of setup");
	 
				execute(br, drive, url, loc);

					if(video.equalsIgnoreCase("Y"))
                                         stopRecording();

			}
			

		} catch (Exception e) {
			drive.quit();
		}
	}

	public void startRecording() throws Exception
	{    
	       System.out.println("Check222");
	          File file = new File("." + File.separator + "Test_Results" + File.separator + "Recordings");
	       if(!file.exists()) {
	          file.mkdir();
	       }
	       Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	       int width = screenSize.width;
	       int height = screenSize.height;
	                     
	       Rectangle captureSize = new Rectangle(0,0, width, height);
	       String vName = this.getClass().getName();            
	     GraphicsConfiguration gc = GraphicsEnvironment
	        .getLocalGraphicsEnvironment()
	        .getDefaultScreenDevice()
	        .getDefaultConfiguration();
	    this.screenRecorder = new SpecializedScreenRecorder(gc, captureSize,
	        new Format(MediaTypeKey, MediaType.FILE, MimeTypeKey, MIME_AVI),
	        new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
	             CompressorNameKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
	             DepthKey, 24, FrameRateKey, Rational.valueOf(15),
	             QualityKey, 1.0f,
	             KeyFrameIntervalKey, 15 * 60),
	        new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, "black",
	             FrameRateKey, Rational.valueOf(30)),
	        null, file, vName);
	      
	   this.screenRecorder.start();
	  
	}



	public void stopRecording() throws Exception
	{
	       
	  this.screenRecorder.stop();
	}


	public void tear() {
		try {
			drive.quit();
		} catch (Exception e) {
			logger.info("Browser has already been closed");
			// logger.info(e);
		}
	}

	public static void printarray(String[] list, String name) {
		System.out.print("now printing " + name);
		for (int i = 0; i < list.length; i++) {
			logger.info(list[i]);
		}
	}

	/*
	 * public void typeWithFullKeyEvents(String locator, String string, boolean
	 * reset) { char[] chars = string.toCharArray();
	 * 
	 * StringBuffer sb = new StringBuffer(this.selenium.getValue(locator)); for
	 * (int i = 0; i < chars.length; i++) { char aChar = chars[i]; String key =
	 * Character.toString(aChar); sb.append(aChar);
	 * this.selenium.keyDown(locator, key);
	 * 
	 * this.selenium.keyPress(locator, key); this.selenium.keyUp(locator, key);
	 * } }
	 */

	//public int obj_run(CommonFunctions r, int c, WritableSheet sheet1,
//			String testname, int loc, String br, Map br_specific)
	public int obj_run(CommonFunctions r, int c, WritableSheet sheet1,
		String testname, int loc, String br, Map br_specific)
				throws Exception {
			
			logger.info("Obj run is called");
	        sheet1.setColumnView(3, 73);
	        WritableFont TableFormat2 = new WritableFont(WritableFont.ARIAL, 10,
	                     WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE,
	                     Colour.RED);
	        WritableFont TableFormat3 = new WritableFont(WritableFont.ARIAL, 10,
	                     WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE,
	                     Colour.BLACK);
	        WritableFont TableFormat4 = new WritableFont(WritableFont.ARIAL, 9,
	                     WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE,
	                     Colour.BLACK);
	        
	        WritableFont TableFormat5 = new WritableFont(WritableFont.ARIAL, 9,
	                     WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE,
	                     Colour.ORANGE);
	        WritableFont TableFormat_status = new WritableFont(WritableFont.ARIAL,
	                     10, WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE,
	                      Colour.WHITE);
	        

	        WritableCellFormat tableFormatBackground3 = new WritableCellFormat();
	        WritableCellFormat tableFormatBackground2 = new WritableCellFormat();
	        WritableCellFormat tableFormatBackground4 = new WritableCellFormat();
	        WritableCellFormat tableFormatBackground5 = new WritableCellFormat();
	        WritableCellFormat tableFormatBackground_status_pass = new WritableCellFormat();
	        WritableCellFormat tableFormatBackground_status_fail = new WritableCellFormat();
	        WritableCellFormat tableFormatBackground_status_cpass = new WritableCellFormat();
	        WritableCellFormat tableFormatBackground_testname = new WritableCellFormat();
	        // WritableCellFormat tableFormatBackground_status_exception = new
	        // WritableCellFormat();
	        tableFormatBackground2.setFont(TableFormat2);
	        tableFormatBackground3.setFont(TableFormat3);
	        tableFormatBackground4.setFont(TableFormat4);
	        tableFormatBackground5.setFont(TableFormat5);
	        tableFormatBackground_testname.setFont(TableFormat4);
	        tableFormatBackground_testname
	                     .setVerticalAlignment(VerticalAlignment.CENTRE);
	        tableFormatBackground_status_fail
	                     .setVerticalAlignment(VerticalAlignment.CENTRE);
	        tableFormatBackground_status_pass
	                     .setVerticalAlignment(VerticalAlignment.CENTRE);
	        tableFormatBackground_status_cpass.setVerticalAlignment(VerticalAlignment.CENTRE);
	        // tableFormatBackground_testname.setAlignment(Alignment.JUSTIFY);
	        tableFormatBackground_status_pass.setFont(TableFormat_status);
	        tableFormatBackground_status_pass.setAlignment(Alignment.CENTRE);
	        tableFormatBackground_status_pass.setBackground(Colour.GREEN);
	        tableFormatBackground_status_fail.setFont(TableFormat_status);
	        tableFormatBackground_status_fail.setBackground(Colour.RED);
	        tableFormatBackground_status_fail.setAlignment(Alignment.CENTRE);
	        tableFormatBackground_status_pass.setBorder(Border.ALL,
	                     BorderLineStyle.THIN);
	        tableFormatBackground_status_fail.setBorder(Border.ALL,
	                     BorderLineStyle.THIN);
	        
	        tableFormatBackground_status_cpass.setFont(TableFormat_status);
	        tableFormatBackground_status_cpass.setAlignment(Alignment.CENTRE);
	        tableFormatBackground_status_cpass.setBackground(Colour.ORANGE);
	        tableFormatBackground_status_cpass.setBorder(Border.ALL, BorderLineStyle.THIN);
	        
	        

	        tableFormatBackground3.setWrap(true);
	        tableFormatBackground2.setWrap(true);
	        tableFormatBackground4.setWrap(true);
	        tableFormatBackground_testname.setWrap(true);
	        tableFormatBackground2.setBorder(Border.ALL, BorderLineStyle.THIN);
	        tableFormatBackground3.setBorder(Border.ALL, BorderLineStyle.THIN);
	        tableFormatBackground4.setBorder(Border.ALL, BorderLineStyle.THIN);
	        tableFormatBackground_status_pass.setBorder(Border.ALL,
	                     BorderLineStyle.THIN);
	        tableFormatBackground_testname.setBorder(Border.ALL,
	                     BorderLineStyle.THIN);
	        tableFormatBackground4.setBackground(Colour.LIGHT_TURQUOISE);
	        DecimalFormat df = new DecimalFormat("#0.00");
	        // int j=getarrcount();
	        long st = System.currentTimeMillis();
	        int pass;
	        r.setUp(loc,br, testname);
	        logger.info("Set Up over!!********************");
	        long et = System.currentTimeMillis();
	        double diff = et - st;
	        diff /= 1000.0D;
	        Label lbl;
	        // sheet1.addCell(lbl);
	        String yash = df.format(diff);
	        diff = Double.parseDouble(yash);
	        //logger.info(arrcount);

	        // *****************VALUES fetched in
	        // OBJ_RUN*******************************
	        // *****************VALUES fetched in
	        // OBJ_RUN*******************************
	        
	        logger.info("VALUES fetched in OBJ_RUN");

	        // values

	        int i_browser = 0;
	        while (browser[i_browser] != null) {
	               if (browser[i_browser].equals(br)) {
	                     for (int i = 0; i < l_browser[i_browser]; i++) {
	                            // logger.info("Value of Browser 1 "
	                            // + browser[i_browser]);
	                            // logger.info("result "
	                            // + result_array[i_browser * 4][i]);
	                            // logger.info("result scenerio "
	                            // + result_array[(i_browser * 4) + 1][i]);
	                            // logger.info("result actual "
	                            // + result_array[(i_browser * 4) + 2][i]);
	                            // logger.info("result expected "
	                            // + result_array[(i_browser * 4) + 3][i]);
	                     }
	                     break;
	               }
	               i_browser++;
	        }

	        // values

	        // ***************retrieving values****************************

	        // **********storing values*****************************

	        i_browser = 0;
	        while (browser[i_browser] != null) {
	               logger.info("Inside while obj_run");
	               if (browser[i_browser].equals(br)) {
	                     logger.info("Inside obj_run If");
	                     pass = 1;
	                     logger.info("browser[" + (i_browser + 1)
	                                   + "] in OBJ_RUN " + browser[i_browser]);
	                     System.out
	                                   .println("OBJ_res Start  $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ Start OBJ_res");
	                     logger.info("br in OBJ_RUN " + br);
	                     logger.info("l_browser" + l_browser[i_browser]);
	                     logger.info("i_browser "+i_browser);
	                     //ro[i_browser]++;
	                     logger.info("RO****************************ro is "+ro[i_browser]);
	                     for (int jo = 0; jo < l_browser[i_browser]; jo++) {
	                            logger.info("Iteration number "+jo);
	                            logger.info("Browser : "+br);
	                            logger.info("result_array[0][jo] "
	                                          + result_array[i_browser * 4][jo]);
	                            logger.info("result_array[1][jo] "
	                                          + result_array[(i_browser * 4) + 1][jo]);
	                            logger.info("result_array[2][jo] "
	                                          + result_array[(i_browser * 4) + 2][jo]);
	                            logger.info("result_array[3][jo] "
	                                          + result_array[(i_browser * 4) + 3][jo]);
	                     /*     
	                            if(Test_called>3)
	                            {
	                                   lbl = new Label(c, ro[i_browser] + jo, "",
	                                                 tableFormatBackground_testname);
	                                   sheet1.addCell(lbl);
	                                   lbl = new Label(c, ro[i_browser]+ jo, "",
	                                                 tableFormatBackground_testname);
	                                   sheet1.addCell(lbl);
	                                   lbl = new Label(c, ro[i_browser]+ jo, "",
	                                                 tableFormatBackground_testname);
	                                   sheet1.addCell(lbl);
	                                   lbl = new Label(c, ro[i_browser]+ jo, "",
	                                                 tableFormatBackground_testname);
	                                   sheet1.addCell(lbl);
	                            }
	                            */
	                            

	                            if (result_array[(i_browser * 4) + 0][jo].equals("Fail")) {
	                                   pass= 0;

	                                   if (jo == 0) {
	                                          lbl = new Label(c, ro[i_browser]+ jo, testname,
	                                                        tableFormatBackground_testname);
	                                          sheet1.addCell(lbl);
	                                   }
	                                   logger.info("Print stuff");
	                                   lbl = new Label(c + 1, ro[i_browser]+ jo,
	                                                 result_array[(i_browser * 4) + 1][jo]);
	                                   logger.info("Print stuff1");
	                                   sheet1.addCell(lbl);
	                                   logger.info("Print stuff2");
	                                   logger.info(result_array[1][jo]);
	                                   lbl = new Label(c + 2, ro[i_browser]+ jo,
	                                                 result_array[(i_browser * 4) + 0][jo],
	                                                 tableFormatBackground_status_fail);
	                                   sheet1.addCell(lbl);
	                                   logger.info(result_array[2][jo]);
	                                   logger.info("Print stuff3");
	                                   String tt = (result_array[(i_browser * 4) + 2][jo]).substring(0,(result_array[(i_browser * 4) + 2][jo]).indexOf("Refer screenshot: "));
	                                   logger.info("TT :"+tt);

	                                   //Code to Hyperlink Starts
	                                   if(tt.length()<=255 && pass_screenshot.equalsIgnoreCase("Y")){
	                                	   logger.info("Print stuff4");
	                                //Code to Hyperlink Starts
	                                logger.info(result[jo]);
	                                String p="";
	                                logger.info("Before adding");
	                                String str=(result_array[(i_browser * 4) + 2][jo])+"]";
	                             p = str.substring(str.indexOf("C:"), str.indexOf("]"));
	                             logger.info("p:"+p);
	                             String textActual= str.substring(0,str.indexOf("C:")-1);
	                             String scn= "HYPERLINK(\""+p+"\","+"\""+textActual+"\")";
	                                Formula link = new Formula(c + 3,ro[i_browser]+ jo ,scn);
	                                sheet1.addCell(link);
	                                WritableCell cell = sheet1.getWritableCell(c + 3 , ro[i_browser]+ jo); 
	                                cell.setCellFormat(tableFormatBackground2);
	                                //Code to Hyperlink ends
	                                }
	                                   else{
	                                   lbl = new Label(c + 3, ro[i_browser]+ jo,
	                                                 result_array[(i_browser * 4) + 2][jo],
	                                                 tableFormatBackground2);
	                                   sheet1.addCell(lbl);
	                            }
	                                   lbl = new Label(c + 4, ro[i_browser]+ jo,
	                                                 result_array[(i_browser * 4) + 3][jo],
	                                                 tableFormatBackground3);

	                                   sheet1.addCell(lbl);
	                                   logger.info(result_array[3][jo]);
	                            }
	                            
	                            
	                            else if (result_array[(i_browser * 4) + 0][jo].equals("C-Pass")) {
	                                   pass= 0;

	                                   if (jo == 0) {
	                                          lbl = new Label(c, ro[i_browser]+ jo, testname,
	                                                        tableFormatBackground_testname);
	                                          sheet1.addCell(lbl);
	                                   }
	                                   logger.info("Print stuff");
	                                   lbl = new Label(c + 1, ro[i_browser]+ jo,
	                                                 result_array[(i_browser * 4) + 1][jo]);
	                                   logger.info("Print stuff1");
	                                   sheet1.addCell(lbl);
	                                   logger.info("Print stuff2");
	                                   logger.info(result_array[1][jo]);
	                                   lbl = new Label(c + 2, ro[i_browser]+ jo,
	                                                 result_array[(i_browser * 4) + 0][jo],
	                                                 tableFormatBackground_status_cpass);
	                                   sheet1.addCell(lbl);
	                                   logger.info(result_array[2][jo]);
	                                   if(!pass_screenshot.equalsIgnoreCase("Y")){
	                                          //Code to Hyperlink Starts
	                         logger.info(result[jo]);
	                         String p="";
	                         logger.info("Before adding");
	                         String str=(result_array[(i_browser * 4) + 2][jo])+"]";
	                      p = str.substring(str.indexOf("C:") , str.indexOf("]"));
	                      logger.info("p:"+p);
	                      String textActual= str.substring(0,str.indexOf("C:")-1);
	                      String scn= "HYPERLINK(\""+p+"\","+"\""+textActual+"\")";
	                         Formula link = new Formula(c + 3,ro[i_browser]+ jo ,scn);
	                         sheet1.addCell(link);
	                         WritableCell cell = sheet1.getWritableCell(c + 3 , ro[i_browser]+ jo); 
	                         cell.setCellFormat(tableFormatBackground3);
	                         //Code to Hyperlink ends
	                                   }
	                                   else
	                                   {
	                                   lbl = new Label(c + 3, ro[i_browser]+ jo,
	                                                 result_array[(i_browser * 4) + 2][jo],
	                                                 tableFormatBackground5);
	                                   sheet1.addCell(lbl);
	                            }
	                                   lbl = new Label(c + 4, ro[i_browser]+ jo,
	                                                 result_array[(i_browser * 4) + 3][jo],
	                                                 tableFormatBackground3);

	                                   sheet1.addCell(lbl);
	                                   logger.info(result_array[3][jo]);
	                            }
	                            
	                            else if (result_array[(i_browser * 4) + 0][jo].equals("")) {
	                                   if (jo == 0) {
	                                          lbl = new Label(c, ro[i_browser]+ jo, testname,
	                                                        tableFormatBackground_testname);
	                                          sheet1.addCell(lbl);
	                                   }
	                                   lbl = new Label(c + 1, ro[i_browser]+ jo,
	                                                 result_array[(i_browser * 4) + 1][jo],
	                                                 tableFormatBackground4);
	                                   sheet1.addCell(lbl);
	                                   lbl = new Label(c + 2, ro[i_browser]+ jo,
	                                                 result_array[(i_browser * 4) + 0][jo],
	                                                 tableFormatBackground4);
	                                   sheet1.addCell(lbl);
	                                   logger.info("inside null-JS");
	                               //NAN comment to chk result sheet    if(pass_screenshot.equalsIgnoreCase("Y") && result_actual[jo].contains("C:")){
	                                	   if(pass_screenshot.equalsIgnoreCase("Y") && (result_array[(i_browser * 4) + 2][jo]).contains("C:")){
	                                	   
	                         //Code to Hyperlink Starts
	                         logger.info(result_array[(i_browser * 4) + 2][jo]);
	                         String p="";
	                         logger.info("Before adding");
	                         String str=(result_array[(i_browser * 4) + 2][jo])+"]";
	                      p = str.substring(str.indexOf("C:"), str.indexOf("]"));
	                      logger.info("p:"+p);
	                      String textActual= str.substring(0,str.indexOf("C:")-1);
	                      String scn= "HYPERLINK(\""+p+"\","+"\""+textActual+"\")";
	                         Formula link = new Formula(c + 3,ro[i_browser]+ jo ,scn);
	                          sheet1.addCell(link);
	                         WritableCell cell = sheet1.getWritableCell(c + 3 , ro[i_browser]+ jo); 
	                         cell.setCellFormat(tableFormatBackground3);
	                         //Code to Hyperlink ends
	                                          }
	                                   else{
	                                   lbl = new Label(c + 3, ro[i_browser]+ jo,
	                                                 result_array[(i_browser * 4) + 2][jo],
	                                                 tableFormatBackground4);
	                                   sheet1.addCell(lbl);
	                            }
	                                   lbl = new Label(c + 4, ro[i_browser]+ jo,
	                                                 result_array[(i_browser * 4) + 3][jo],
	                                                 tableFormatBackground4);
	                                   sheet1.addCell(lbl);
	                            } else {

	                                   if (jo == 0) {
	                                          lbl = new Label(c, ro[i_browser]+ jo, testname,
	                                                        tableFormatBackground_testname);
	                                          sheet1.addCell(lbl);

	                                   }
	                                   // logger.info(testname);
	                                   lbl = new Label(c + 1, ro[i_browser]+ jo,
	                                                 result_array[(i_browser * 4) + 1][jo],
	                                                 tableFormatBackground3);
	                                   sheet1.addCell(lbl);
	                                   // logger.info(result_scenario[jo]);
	                                   lbl = new Label(c + 2, ro[i_browser]+ jo,
	                                                 result_array[(i_browser * 4) + 0][jo],
	                                                 tableFormatBackground_status_pass);
	                                   sheet1.addCell(lbl);
	                                   // logger.info(result_actual[jo]);
	                                   logger.info("inside else-JS");
	                                   if(pass_screenshot.equalsIgnoreCase("Y") && (result_array[(i_browser * 4) + 2][jo]).contains("C:")){
	                         //Code to Hyperlink Starts
	                         logger.info(result_actual[jo]);
	                         String p="";
	                         logger.info("Before adding");
	                         String str=(result_array[(i_browser * 4) + 2][jo])+"]";
	                      p = str.substring(str.indexOf("C:"), str.indexOf("]"));
	                      logger.info("p:"+p);
	                      String textActual= str.substring(0,str.indexOf("C:")-1);
	                      String scn= "HYPERLINK(\""+p+"\","+"\""+textActual+"\")";
	                         Formula link = new Formula(c + 3,ro[i_browser]+ jo ,scn);
	                          sheet1.addCell(link);
	                         WritableCell cell = sheet1.getWritableCell(c + 3 , ro[i_browser]+ jo); 
	                         cell.setCellFormat(tableFormatBackground3);
	                         //Code to Hyperlink ends
	                                          }
	                                   else
	                                   {lbl = new Label(c + 3, ro[i_browser]+ jo,
	                                                 result_array[(i_browser * 4) + 2][jo],
	                                                 tableFormatBackground3);
	                                   sheet1.addCell(lbl);}
	                                   lbl = new Label(c + 4, ro[i_browser]+ jo,
	                                                 result_array[(i_browser * 4) + 3][jo],
	                                                 tableFormatBackground3);
	                                   sheet1.addCell(lbl);
	                                   // logger.info(result[jo]);

	                            }
	                            System.out
	                                          .println("OBJ_res EBD $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ END OBJ_res");

	                     }
	                     
	                     pass_br_wise[i_browser]+=pass;
	                     lbl = new Label(c, ro[i_browser]+ l_browser[i_browser], "",
	                                   tableFormatBackground_testname);
	                     sheet1.addCell(lbl);
	                     //ro[i_browser] =ro[i_browser]+ (arrcount +3);
	                     logger.info("arrcount end of obj run "+arrcount);
	                     //ro[i_browser]+=arrcount+1;
	                     ro[i_browser] =ro[i_browser]+ l_browser[i_browser]+1;
	                     logger.info("RO wen obj run ends : +br :"+ro[i_browser]+" "+br);
	                     if(loc!=first_tc)
	                     {
	                            ro[i_browser] =ro[i_browser]+ 0;  
	                            counter_result_sheet[i_browser]++;
	                            
	                     }
	                                          break;
	               }
	               // **********storing values*****************************

	               i_browser++;

	        }

	        // obj duped

	        // lbl = new Label(c + 1,ro+arrcount,
	        // "The total time for completing this operation: " + diff +
	        // " seconds");

	        /*
	        * if (r.getStatus() == "Fail") { lbl = new Label(c + 2, ro,
	        * r.getFailMsg()); sheet1.addCell(lbl); lbl = new Label(c, ro,
	        * testname); sheet1.addCell(lbl); lbl = new Label(c + 3, ro,
	        * r.getPassMsg()); sheet1.addCell(lbl); return 0; }
	        */

	        // lbl = new Label(c + 1,ro+arrcount,
	        // "The total time for completing this operation: " + diff +
	        // " seconds");
	 

	//values

	//***************retrieving values****************************

	//**********storing values*****************************

	i_browser = 0;
	while (browser[i_browser] != null) {
	logger.info("Inside while obj_run");
	if (browser[i_browser].equals(br))
	        {
	        arrcount[i_browser] = 0;
	        
	        break;
	        }
	 i_browser++;
	 }
	        logger.info("Returning value in obj_run start");
	        
	        int return_value = 0;
	        
	        /*while (browser[i_browser] != null) {
	               if (browser[i_browser].equals(br)) {
	                     return_value = pass[i_browser];
	                     break;
	               }
	               i_browser++;
	        }
	*/
	        logger.info("Returning value in obj_run **" + return_value);
	        return return_value;
	 }

	public static int obj_norun(CommonFunctions r, int c, WritableSheet sheet1,
			String testname) throws Exception {
		/*
		 * DecimalFormat df = new DecimalFormat("#0.00");
		 * 
		 * Label lbl = new Label(c + 3, ro, "No Run"); sheet1.addCell(lbl);
		 * 
		 * lbl = new Label(c + 1, ro, "Test case was not selected to execute");
		 * sheet1.addCell(lbl); lbl = new Label(c, ro, testname);
		 * sheet1.addCell(lbl); ro+=2;
		 */
		return 1;
	}

	public void firstrun(String br,WebDriver driver, String username, String pwd,
			 String ctotal, String Uname, String serAddress)
			throws InterruptedException {
		logger.info("First run is called");
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@href='#buyflow-current']")).click();
		driver.findElement(By.name("username")).sendKeys(username);
		statusTracker(br,driver,"Pass", "User enters TWC username ",
				"User name displays", "should be able to enter the userId");
		driver.findElement(By.name("password")).sendKeys(pwd);
		statusTracker(br,driver,"Pass", "User enters TWC password ",
				"Password is entered and masked",
				"should be able to enter the password");
		
		Thread.sleep(2000);
		

		
		JavascriptExecutor jsx = (JavascriptExecutor)driver;
		jsx.executeScript("window.scrollBy(0,450)", "");

		
		int g = 0;
		try {
			do {
			driver.findElement(By.xpath(".//*[@value='Sign In']")).click();
				//click_element(".//*[@id='initialAddrForm']/div[2]/div/div/div/div/button", driver);
				g++;
				logger.info("Log-in itteration is" + " " + g);
				Thread.sleep(30000);

			} while (isElementPresent("//div[@class='error-module']", driver));
		} catch (Exception e) {
			exceptionHandler(br,e, driver);

		}
		logger.info(" Logged in");
		statusTracker(br,driver,"Pass", "User selects login button",
				"Login: Your Services page appears", "should be able to Login");

	}
	public void Phone_lob_click(String br,WebDriver driver) {
		driver.findElement(By.name("select_phone")).click();
	}

	public void click_PrivateListening(String br,WebDriver driver)
			throws InterruptedException {
		Thread.sleep(9000);
		click_element("//*[@class='content-wrap']/div[3]/header/ul/li[1]/a",
				driver);
		Thread.sleep(2000);
		click_element("//*[@class='content-wrap']/div[3]/header/ul/li[1]/a",
				driver);
		Thread.sleep(2000);
		click_element("//*[@id='1-29SM']", driver);
		Thread.sleep(9000);
		logger.info("shikha funcrion ended");
	}

	public void click_VoiceMail(String br,WebDriver driver) throws InterruptedException {
		click_element("//*[@class='content-wrap']/div[4]/header/ul/li[1]/a",
				driver);
		Thread.sleep(2000);
		click_element("//*[@class='content-wrap']/div[4]/header/ul/li[1]/a",
				driver);
		Thread.sleep(2000);
		click_element("//*[@id='1-29SB']", driver);
	}

	public void click_GlobalPenny(String br,WebDriver driver) throws InterruptedException {
		click_element("//*[@class='content-wrap']/div[6]/header/ul/li[1]/a",
				driver);
		Thread.sleep(2000);
		click_element("//*[@class='content-wrap']/div[6]/header/ul/li[1]/a",
				driver);
		Thread.sleep(2000);
		click_element("//*[@id='12-1BZU']", driver);
	}



	public void field_statustracker(String br,String xp, String tc, String Actual,
			WebDriver driver) {

		String value = driver.findElement(By.xpath(xp)).getAttribute("value");

		logger.info("Value is" + value);
		if (value.equals("")) {
			statusTracker(br,driver,"Fail", tc, Actual, "Date should be Entered");
			logger.info("failed");
		} else {
			statusTracker(br,driver,"Pass", tc, Actual, "Date should be Entered");
			logger.info("passed");
		}
	}

	public void TV_lob_click(WebDriver driver)

	{
		driver.findElement(By.name("select_tv")).click();
	}

	public void Internet_lob_click(WebDriver driver) {
		driver.findElement(By.name("select_inet")).click();
	}

	public void Phone_lob_click(WebDriver driver) {
		driver.findElement(By.name("select_phone")).click();
	}

	public void TV_Internet_lob_click(WebDriver driver) {
		driver.findElement(By.name("select_tv")).click();
		driver.findElement(By.name("select_internet")).click();
	}

	public void TV_Phone_lob_click(WebDriver driver) {
		driver.findElement(By.name("select_phone")).click();
		driver.findElement(By.name("select_tv")).click();
	}

	public void Internet_Phone_lob_click(WebDriver driver) {
		driver.findElement(By.name("select_phone")).click();
		driver.findElement(By.name("select_internet")).click();
	}

	// *****************************************************Verification
	// functions******************************************************************
	// changes made ##########################################
	public void Tv_lob_verify(String br,WebDriver driver) throws InterruptedException

	{
		if (return_text(
				"//*[@class='text parbase twc-plain-text starting-at-text-1']",
				driver).equalsIgnoreCase("starting at"))

		{
			statusTracker(br,driver, "Pass", "'Starting at' price present for new TV_LOB",
					"'Starting at ' Present", "Should be present");
		} else {
			statusTracker(br,driver, "Fail", "'Starting at' price present for new TV_LOB",
					"'Starting at ' Not Present", "Should be present");
		}

		String price = driver.findElement(
				By.xpath("//*[@class='services']/li[1]/div[3]/div")).getText();
		int index_start = price.indexOf("$");
		logger.info(Integer.toString(index_start));

		int index_end = index_start + 5;
		logger.info(Integer.toString(index_end));
		String start_amount = price.substring(index_start, index_end);
		Double Decimal_Amount = Double.parseDouble(start_amount
				.replace("$", "")) / 100;
		logger.info(start_amount);

		if (start_amount.equalsIgnoreCase("$1999")) {
			statusTracker(br,driver, "Pass", "'Starting at' price present for new TV_LOB",
					"Starting at price $" + Decimal_Amount + " Present",
					"Should be present");
		} else {
			statusTracker(br,driver, "Fail", "'Starting at' price present for new TV_LOB",
					"Starting at price $" + Decimal_Amount + " Not Present",
					"Should be present");
		}

		Thread.sleep(3000);
		driver.findElement(By.cssSelector("span.no-arrow")).click();

		Thread.sleep(10000);

		if (return_text(".//*[@class='modal-title']", driver).equalsIgnoreCase(
				"Features by TV Plan")) {
			statusTracker(br,driver, "Pass", "Compare TV plan is clicked",
					"compare TV plan page is displayed", "Should be displayed");
		} else {
			statusTracker(br,driver, "Fail", "Compare TV plan is clicked",
					"compare TV plan page is not displayed",
					"Should be displayed");
		}

		Thread.sleep(4000);

		click_element("//*[@class='modal-button-close']", driver);

		if (return_text(
				"//*[@class='text parbase twc-plain-text header-text']", driver)
				.equalsIgnoreCase("Your Current Services")) {
			statusTracker(br,driver, "Pass", "Compare  TV plan is closed",
					"compare TV plan page closed", "Should be closed");
		} else {
			statusTracker(br,driver, "Fail", "Compare  TV plan is closed",
					"compare TV plan page is not closed", "Should be closed");
		}
		Thread.sleep(4000);

	}

	public void Internet_lob_verify(String br,WebDriver driver)
			throws InterruptedException {
		if (return_text(
				"//*[@class='text parbase twc-plain-text starting-at-text-internet']",
				driver).equalsIgnoreCase("starting at"))

		{
			statusTracker(br,driver, "Pass",
					"'Starting at' price present for new Internet_LOB",
					"'Starting at'Present", "Should be present");
		} else {
			statusTracker(br,driver, "Fail",
					"'Starting at' price present for new Internet_LOB",
					"'Starting at'Not Present", "Should be present");
		}

		String price = driver.findElement(
				By.xpath("//*[@class='services']/li[1]/div[3]/div")).getText();
		int index_start = price.indexOf("$");
		logger.info(Integer.toString(index_start));

		int index_end = index_start + 5;
		logger.info(Integer.toString(index_end));
		String start_amount = price.substring(index_start, index_end);
		Double Decimal_Amount = Double.parseDouble(start_amount
				.replace("$", "")) / 100;
		logger.info(start_amount);

		if (start_amount.equalsIgnoreCase("$1499")) {
			statusTracker(br,driver, "Pass",
					"'Starting at' price present for new Internet_LOB",
					"'Starting at price " + Decimal_Amount + " Present",
					"Should be present");
		} else {
			statusTracker(br,driver, "Fail",
					"'Starting at' price present for new Internet_LOB",
					"'Starting at price " + Decimal_Amount + " Not Present",
					"Should be present");
		}

		driver.findElement(By.cssSelector("span.no-arrow")).click();

		if (return_text("//*[@class='modal-title']", driver).equalsIgnoreCase(
				"Internet Plans at a Glance")) {
			statusTracker(br,driver, "Pass", "Compare Internet plans is clicked",
					"compare Internet plans page is displayed",
					"Should be displayed");
		} else {
			statusTracker(br,driver, "Fail", "Compare Internet plans is clicked",
					"compare Internet plans page is not displayed",
					"Should be displayed");
		}
		Thread.sleep(5000);
		click_element("//*[@class='modal-button-close']", driver);

		if (return_text(
				"//*[@class='text parbase twc-plain-text header-text']", driver)
				.equalsIgnoreCase("Your Current Services")) {
			statusTracker(br,driver, "Pass", "Compare  Internet plans is closed",
					"compare Internet plans closed", "Should be closed");
		} else {
			statusTracker(br,driver, "Fail", "Compare  Internet plans is closed",
					"compare Internet plans page is not closed",
					"Should be closed");
		}
		Thread.sleep(5000);
	}

	public void Phone_lob_verify(String br,WebDriver driver)

	{
		if (return_text(
				"//*[@class='text parbase starting-at-text-phone twc-plain-text']",
				driver).equalsIgnoreCase("starting at"))

		{
			statusTracker(br,driver, "Pass",
					"'Starting at' price present for new Phone_LOB",
					"'Starting at'Present", "Should be present");
		} else {
			statusTracker(br,driver, "Fail",
					"'Starting at' price present for new Phone_LOB",
					"'Starting at' Not Present", "Should be present");
		}

		String price = driver.findElement(
				By.xpath("//*[@class='services']/li[2]/div[3]/div")).getText();
		int index_start = price.indexOf("$");
		logger.info(Integer.toString(index_start));

		int index_end = index_start + 5;
		logger.info(Integer.toString(index_end));
		String start_amount = price.substring(index_start, index_end);
		Double Decimal_Amount = Double.parseDouble(start_amount
				.replace("$", "")) / 100;
		logger.info(start_amount);

		{
			if (start_amount.equalsIgnoreCase("$1000")) {
				statusTracker(br,driver, "Pass",
						"'Starting at' price present for new Phone_LOB",
						+Decimal_Amount + " Present", "Should be present");

			} else {
				statusTracker(br,driver, "Fail",
						"'Starting at' price present for new Phone_LOB",
						+Decimal_Amount + " Present", "Should be present");
			}

		}

	}

	// **********************LOB Combinations************************need to be
	// added

	public void Tv_Phone_lob_verify(String br,WebDriver driver)
			throws InterruptedException {

		if (return_text(
				"//*[@class='text parbase twc-plain-text starting-at-text-1']",
				driver).equalsIgnoreCase("starting at"))

		{
			statusTracker(br,driver, "Pass", "'Starting at' price present for new TV_LOB",
					"'Starting at'Present", "Should be present");
		} else {
			statusTracker(br,driver, "Fail", "'Starting at' price present for new TV_LOB",
					"'Starting at'Not Present", "Should be present");
		}

		String price = driver.findElement(
				By.xpath("//*[@class='services']/li[1]/div[3]/div")).getText();
		int index_start = price.indexOf("$");
		logger.info(Integer.toString(index_start));

		int index_end = index_start + 5;
		logger.info(Integer.toString(index_end));
		String start_amount = price.substring(index_start, index_end);
		Double Decimal_Amount = Double.parseDouble(start_amount
				.replace("$", "")) / 100;
		logger.info(start_amount);

		{
			if (start_amount.equalsIgnoreCase("$1999")) {
				statusTracker(br,driver, "Pass",
						"'Starting at' price present for new Tv_LOB",
						"'Starting at price " + Decimal_Amount + " Present",
						"Should be present");
			} else {
				statusTracker(br,driver, 
						"Fail",
						"'Starting at' price present for new Tv_LOB",
						"'Starting at price " + Decimal_Amount + " Not Present",
						"Should be present");
			}

			driver.findElement(By.cssSelector("span.no-arrow")).click();

			if (return_text("//*[@class='modal-title']", driver)
					.equalsIgnoreCase("Features by TV Plan")) {
				statusTracker(br,driver, "Pass", "Compare TV plans is clicked",
						"compare TV plans page is displayed",
						"Should be displayed");
			} else {
				statusTracker(br,driver, "Fail", "Compare TV plans is clicked",
						"compare TV plans page is not displayed",
						"Should be displayed");
			}
			Thread.sleep(5000);
			click_element("//*[@class='modal-button-close']", driver);

			if (return_text(
					"//*[@class='text parbase twc-plain-text header-text']",
					driver).equalsIgnoreCase("Your Current Services")) {
				statusTracker(br,driver, "Pass", "Compare  TV plans is closed",
						"compare TV plans closed", "Should be closed");
			} else {
				statusTracker(br,driver, "Fail", "Compare  TV plans is closed",
						"compare  TV plans page is not closed",
						"Should be closed");
			}
			Thread.sleep(4000);
		}

		{
			if (return_text(
					"//*[@class='text parbase starting-at-text-phone twc-plain-text']",
					driver).equalsIgnoreCase("starting at"))

			{
				statusTracker(br,driver, "Pass",
						"'Starting at' price present for new Phone_LOB",
						"'Starting at'Present", "Should be present");
			} else {
				statusTracker(br,driver, "Fail",
						"'Starting at' price present for new Phone_LOB",
						"'Starting at' Not Present", "Should be present");
			}

			String price_1 = driver.findElement(
					By.xpath("//*[@class='services']/li[2]/div[3]/div"))
					.getText();
			int index_start_1 = price.indexOf("$");
			logger.info(Integer.toString(index_start_1));

			int index_end_1 = index_start_1 + 5;
			logger.info(Integer.toString(index_end_1));
			String start_amount_1 = price_1.substring(index_start_1,
					index_end_1);
			Double Decimal_Amount_1 = Double.parseDouble(start_amount_1
					.replace("$", "")) / 100;
			logger.info(start_amount_1);

			{
				if (start_amount_1.equalsIgnoreCase("$1000")) {
					statusTracker(br,driver, "Pass",
							"'Starting at' price present for new Phone_LOB",
							"'Starting at price $1000' Present",
							"Should be present");

				} else {
					statusTracker(br,driver, "Fail",
							"'Starting at' price present for new Phone_LOB",
							"'Starting at price $1000' Not Present",
							"Should be present");
				}
			}
		}

	}

	public void Tv_Internet_lob_verify(String br,WebDriver driver)
			throws InterruptedException {
		if (return_text(
				"//*[@class='text parbase twc-plain-text starting-at-text-1']",
				driver).equalsIgnoreCase("starting at"))

		{
			statusTracker(br,driver, "Pass", "'Starting at' price present for new Tv_LOB",
					"'Starting at'Present", "Should be present");
		} else {
			statusTracker(br,driver, "Fail", "'Starting at' price present for new Tv_LOB",
					"'Starting at'Not Present", "Should be present");
		}

		String price = driver.findElement(
				By.xpath("//*[@class='services']/li[1]/div[3]/div")).getText();
		int index_start = price.indexOf("$");
		logger.info(Integer.toString(index_start));

		int index_end = index_start + 5;
		logger.info(Integer.toString(index_end));
		String start_amount = price.substring(index_start, index_end);
		Double Decimal_Amount = Double.parseDouble(start_amount
				.replace("$", "")) / 100;
		logger.info(start_amount);

		{
			if (start_amount.equalsIgnoreCase("$1999")) {
				statusTracker(br,driver, "Pass",
						"'Starting at' price present for new Tv_LOB",
						"'Starting at price $1999' Present",
						"Should be present");
			} else {
				statusTracker(br,driver, "Fail",
						"'Starting at' price present for new Tv_LOB",
						"'Starting at price $1999' Not Present",
						"Should be present");
			}

			driver.findElement(By.cssSelector("span.no-arrow")).click();

			if (return_text("//*[@class='modal-title']", driver)
					.equalsIgnoreCase("Features by TV Plan")) {
				statusTracker(br,driver, "Pass", "Compare TV plans is clicked",
						"compare Features by TV plans page is displayed",
						"Should be displayed");
			} else {
				statusTracker(br,driver, "Fail", "Compare TV plans is clicked",
						"compare TV plans page is not displayed",
						"Should be displayed");
			}
			Thread.sleep(5000);
			click_element("//*[@class='modal-button-close']", driver);

			if (return_text(
					"//*[@class='text parbase twc-plain-text header-text']",
					driver).equalsIgnoreCase("Your Current Services")) {
				statusTracker(br,driver, "Pass", "Compare  TV plans is closed",
						"compare TV plans closed", "Should be closed");
			} else {
				statusTracker(br,driver, "Fail", "Compare  TV plans is closed",
						"compare TV plans page is not closed",
						"Should be closed");
			}
			Thread.sleep(5000);

		}
		if (return_text(
				"//*[@class='text parbase twc-plain-text starting-at-text-internet']",
				driver).equalsIgnoreCase("starting at"))

		{
			statusTracker(br,driver, "Pass",
					"'Starting at' price present for new Internet_LOB",
					"'Starting at'Present", "Should be present");
		} else {
			statusTracker(br,driver, "Fail",
					"'Starting at' price present for new Internet_LOB",
					"'Starting at'Not Present", "Should be present");
		}

		String price_1 = driver.findElement(
				By.xpath("//*[@class='services']/li[2]/div[3]/div")).getText();
		int index_start_1 = price.indexOf("$");
		logger.info(Integer.toString(index_start_1));

		int index_end_1 = index_start_1 + 5;
		logger.info(Integer.toString(index_end_1));
		String start_amount_1 = price_1.substring(index_start_1, index_end_1);
		Double Decimal_Amount_1 = Double.parseDouble(start_amount_1.replace(
				"$", "")) / 100;
		logger.info(start_amount_1);

		{
			if (start_amount_1.equalsIgnoreCase("$1499")) {
				statusTracker(br,driver, "Pass",
						"'Starting at' price present for new Internet_LOB",
						"Starting at price " + Decimal_Amount_1 + " Present",
						"Should be present");
			} else {
				statusTracker(br,driver, "Fail",
						"'Starting at' price present for new Internet_LOB",
						"Starting at price " + Decimal_Amount_1
								+ " Not Present", "Should be present");
			}

			driver.findElement(By.cssSelector("span.no-arrow")).click();

			if (return_text("//*[@class='modal-title']", driver)
					.equalsIgnoreCase("Internet Plans at a Glance")) {
				statusTracker(br,driver, "Pass", "Compare Internet plans is clicked",
						"compare Internet plans page is displayed",
						"Should be displayed");
			} else {
				statusTracker(br,driver, "Fail", "Compare Internet plans is clicked",
						"compare Internet plans page is not displayed",
						"Should be displayed");
			}
			Thread.sleep(5000);
			click_element("//*[@class='modal-button-close']", driver);

			if (return_text(
					"//*[@class='text parbase twc-plain-text header-text']",
					driver).equalsIgnoreCase("Your Current Services")) {
				statusTracker(br,driver, "Pass", "Compare  Internet plans is closed",
						"compare Internet plans closed", "Should be closed");
			} else {
				statusTracker(br,driver, "Fail", "Compare  Internet plans is closed",
						"compare Internet plans page is not closed",
						"Should be closed");
			}
			Thread.sleep(5000);
		}
	}

	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Change made in
	// Internet_phone_lob~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	public void Internet_Phone_lob_verify(String br,WebDriver driver)
			throws InterruptedException {
		if (return_text(
				"//*[@class='text parbase twc-plain-text starting-at-text-internet']",
				driver).equalsIgnoreCase("starting at")) {
			statusTracker(br,driver, "Pass",
					"'Starting at' price present for new Internet_LOB",
					"'Starting at'Present", "Should be present");
		} else {
			statusTracker(br,driver, "Fail",
					"'Starting at' price present for new Internet_LOB",
					"'Starting at'Not Present", "Should be present");
		}

		String price = driver.findElement(
				By.xpath("//*[@class='services']/li[1]/div[3]/div")).getText();
		int index_start = price.indexOf("$");
		logger.info(Integer.toString(index_start));

		int index_end = index_start + 5;
		logger.info(Integer.toString(index_end));
		String start_amount = price.substring(index_start, index_end);
		Double Decimal_Amount = Double.parseDouble(start_amount
				.replace("$", "")) / 100;
		logger.info(start_amount);

		{
			if (start_amount.equalsIgnoreCase("$1499")) {
				statusTracker(br,driver, "Pass",
						"'Starting at' price present for new Internet_LOB",
						+Decimal_Amount + "Present", "Should be present");
			} else {
				statusTracker(br,driver, "Fail",
						"'Starting at' price present for new Internet_LOB",
						+Decimal_Amount + "Present", "Should be present");
			}

			Thread.sleep(2000);
			driver.findElement(
					By.xpath("//*[@id='js-main-form']/ul/li[1]/div[2]/div[2]/a/span[1]"))
					.click();
			// driver.findElement(By.cssSelector("span.no-arrow")).click();
			Thread.sleep(10000);

			if (return_text("//*[@class='modal-title']", driver)
					.equalsIgnoreCase("Internet Plans at a Glance")) {
				statusTracker(br,driver, "Pass", "Compare Internet plans is clicked",
						"compare Internet plans page is displayed",
						"Should be displayed");
			} else {
				statusTracker(br,driver, "Fail", "Compare Internet plans is clicked",
						"compare Internet plans page is not displayed",
						"Should be displayed");
			}
			Thread.sleep(5000);
			click_element("//*[@class='modal-button-close']", driver);
			Thread.sleep(3000);
			if (return_text(
					"//*[@class='text parbase twc-plain-text header-text']",
					driver).equalsIgnoreCase("Your Current Services")) {
				statusTracker(br,driver, "Pass", "Compare  Internet plans is closed",
						"compare Internet plans closed", "Should be closed");
			} else {
				statusTracker(br,driver, "Fail", "Compare  Internet plans is closed",
						"compare Internet plans page is not closed",
						"Should be closed");
			}
			Thread.sleep(5000);
		}
		{
			if (return_text(
					"//*[@class='text parbase starting-at-text-phone twc-plain-text']",
					driver).equalsIgnoreCase("starting at")) {
				statusTracker(br,driver, "Pass",
						"'Starting at' price present for new Phone_LOB",
						"'Starting at'Present", "Should be present");
			} else {
				statusTracker(br,driver, "Fail",
						"'Starting at' price present for new Phone_LOB",
						"'Starting at' Not Present", "Should be present");
			}

			String price_1 = driver.findElement(
					By.xpath("//*[@class='services']/li[1]/div[3]/div"))
					.getText();
			int index_start_1 = price_1.indexOf("$");
			logger.info(Integer.toString(index_start_1));

			int index_end_1 = index_start_1 + 5;
			logger.info(Integer.toString(index_end_1));
			String start_amount_1 = price_1.substring(index_start_1,
					index_end_1);
			Double Decimal_Amount_1 = Double.parseDouble(start_amount_1
					.replace("$", "")) / 100;
			logger.info(start_amount_1);

			{
				if (start_amount_1.equalsIgnoreCase("$1000")) {
					statusTracker(br,driver, "Pass",
							"'Starting at' price present for new Phone_LOB",
							+Decimal_Amount_1 + "Present", "Should be present");
				} else {
					statusTracker(br,driver, "Fail",
							"'Starting at' price present for new Phone_LOB",
							+Decimal_Amount_1 + "Present", "Should be present");
				}
			}
		}
	}

	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Till
	// here~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	// ************************************************************ LOS
	// Verifications****************************************************************************************************************************

	public void Tv_los_verify(String br,String Tv_plan, String Tv_service,
			WebDriver driver) {
		if (return_text("//*[@class='current services']/li/div[2]/h4", driver)
				.equals(Tv_service)) {
			if (return_text("//*[@class='current services']/li/div[2]/h5",
					driver).equals(Tv_plan))

			{
				statusTracker(br,driver, "Pass",
						"check for TV_los plan in current service",
						"Plan matches ", "Plan Should Match");
			} else {
				statusTracker(br,driver, "Fail",
						"check for TV_los plan in current service",
						"Plan doesnt match", "Plan Should Match");
			}
		}
	}

	public void Internet_los_verify(String br,String Internet_plan,
			String Internet_service, WebDriver driver) {

		if (return_text("//*[@class='current services']/li/div[2]/h4", driver)
				.equals(Internet_service)) {
			if (return_text("//*[@class='current services']/li/div[2]/h5",
					driver).equals(Internet_plan))

			{
				statusTracker(br,driver, "Pass",
						"check for Internet_los plan in current service",
						"Plan matches ", "Plan Should Match");
			} else {
				statusTracker(br,driver, "Fail",
						"check for Internet_los plan in current service",
						"Plan doesnt match", "Plan Should Match");
			}
		}
	}

	public void Phone_los_verify(String br,String Phone_plan, String Phone_service,
			WebDriver driver) {

		if (return_text("//*[@class='current services']/li/div[2]/h4", driver)
				.equals(Phone_service)) {
			if (return_text(".//*[@class='current services']/li/div[2]/h5",
					driver).equals(Phone_plan))

			{
				statusTracker(br,driver, "Pass",
						"check for Phone_los plan in current service",
						"Plan matches ", "Plan Should Match");
			} else {
				statusTracker(br,driver, "Fail",
						"check for Phone_los plan in current service",
						"Plan doesnt match", "Plan Should Match");
			}

		}

	}

	public void Internet_Phone_los_verify(String br,String Internet_plan,
			String Internet_service, String Phone_plan, String Phone_service,
			WebDriver driver) {

		if (return_text("//*[@class='current services']/li[1]/div[2]/h4",
				driver).equals(Internet_service)) {
			if (return_text(".//*[@class='current services']/li[1]/div[2]/h5",
					driver).equals(Internet_plan))

			{
				statusTracker(br,driver, "Pass",
						"check for Internet_los plan in current service",
						"Plan matches ", "Plan Should Match");
			} else {
				statusTracker(br,driver, "Fail",
						"check forInternet_los plan in current service",
						"Plan doesnt match", "Plan Should Match");
			}
		}

		if (return_text("//*[@class='current services']/li[2]/div[2]/h4",
				driver).equals(Phone_service)) {
			if (return_text(".//*[@class='current services']/li[2]/div[2]/h5",
					driver).equals(Phone_plan))

			{
				statusTracker(br,driver, "Pass",
						"check for Phone_los plan in current service",
						"Plan matches ", "Plan Should Match");
			} else {
				statusTracker(br,driver, "Fail",
						"check for Phone_los plan in current service",
						"Plan doesnt match", "Plan Should Match");
			}

		}

	}

	public void TV_Internet_verify(String br,String Tv_plan, String Tv_service,
			String Internet_plan, String Internet_service, WebDriver driver) {

		if (return_text("//*[@class='current services']/li[1]/div[2]/h4",
				driver).equals(Tv_service)) {
			if (return_text(".//*[@class='current services']/li[1]/div[2]/h5",
					driver).equals(Tv_plan))

			{
				statusTracker(br,driver, "Pass",
						"check for TV_los plan in current service",
						"Plan matches ", "Plan Should Match");
			} else {
				statusTracker(br,driver, "Fail",
						"check for TV_los plan in current service",
						"Plan doesnt match", "Plan Should Match");
			}
		}

		if (return_text("//*[@class='current services']/li[2]/div[2]/h4",
				driver).equals(Internet_service)) {
			if (return_text(".//*[@class='current services']/li[2]/div[2]/h5",
					driver).equals(Internet_plan))

			{
				statusTracker(br,driver, "Pass",
						"check for Phone_los plan in current service",
						"Plan matches ", "Plan Should Match");
			} else {
				statusTracker(br,driver, "Fail",
						"check for Phone_los plan in current service",
						"Plan doesnt match", "Plan Should Match");
			}

		}

	}

	public void Tv_Phone_verify(String br,String Tv_plan, String Tv_service,
			String Phone_plan, String Phone_service, WebDriver driver) {

		if (return_text("//*[@class='current services']/li[1]/div[2]/h4",
				driver).equals(Tv_service)) {
			if (return_text(".//*[@class='current services']/li[1]/div[2]/h5",
					driver).equals(Tv_plan))

			{
				statusTracker(br,driver, "Pass",
						"check for TV_los plan in current service",
						"Plan matches ", "Plan Should Match");
			} else {
				statusTracker(br,driver, "Fail",
						"check for TV_los plan in current service",
						"Plan doesnt match", "Plan Should Match");
			}
		}

		if (return_text("//*[@class='current services']/li[2]/div[2]/h4",
				driver).equals(Phone_service)) {
			if (return_text(".//*[@class='current services']/li[2]/div[2]/h5",
					driver).equals(Phone_plan))

			{
				statusTracker(br,driver, "Pass",
						"check for Phone_los plan in current service",
						"Plan matches ", "Plan Should Match");
			} else {
				statusTracker(br,driver, "Fail",
						"check for Phone_los plan in current service",
						"Plan doesnt match", "Plan Should Match");
			}

		}

	}

	public void Tv_Internet_phone(String br,String Tv_plan, String Tv_service,
			String Internet_plan, String Internet_service, String Phone_plan,
			String Phone_service, WebDriver driver) {
		if (return_text("//*[@class='current services']/li[1]/div[2]/h4",
				driver).equals(Tv_service)) {
			if (return_text(".//*[@class='current services']/li[1]/div[2]/h5",
					driver).equals(Tv_plan))

			{
				statusTracker(br,driver, "Pass",
						"check for TV_los plan in current service",
						"Plan matches ", "Plan Should Match");
			} else {
				statusTracker(br,driver, "Fail",
						"check for TV_los plan in current service",
						"Plan doesnt match", "Plan Should Match");
			}
		}

		if (return_text("//*[@class='current services']/li[2]/div[2]/h4",
				driver).equals(Internet_service)) {
			if (return_text(".//*[@class='current services']/li[2]/div[2]/h5",
					driver).equals(Internet_plan))

			{
				statusTracker(br,driver, "Pass",
						"check for Phone_los plan in current service",
						"Plan matches ", "Plan Should Match");
			} else {
				statusTracker(br,driver, "Fail",
						"check for Phone_los plan in current service",
						"Plan doesnt match", "Plan Should Match");
			}

		}

		if (return_text("//*[@class='current services']/li[3]/div[2]/h4",
				driver).equals(Phone_service)) {
			if (return_text(".//*[@class='current services']/li[3]/div[2]/h5",
					driver).equals(Phone_plan))

			{
				statusTracker(br,driver, "Pass",
						"check for Phone_los plan in current service",
						"Plan matches ", "Plan Should Match");
			} else {
				statusTracker(br,driver, "Fail",
						"check for Phone_los plan in current service",
						"Plan doesnt match", "Plan Should Match");
			}

		}

	}

	// ///---------------------------------------------shikha code ended

	// Nithin Updated - Start
	/*
	 * public void TV_ReviewOrder_ECKInstallationOptions(String ECKOptionName,
	 * double oneTimeCharges) { InstallationFees = 0.0; StoreAddress1 ="";
	 * StoreAddress2 =""; StoreAddress3 =""; Equip_text ="";
	 * ECKOptionSelected=""; ECKOptionSelected = ECKOptionName;
	 * 
	 * logger.info("Review - ECKOptionSelected : "+ECKOptionSelected);
	 * 
	 * if(ECKOptionName.equals("Store")) { StoreAddress1 = (return_text(
	 * "//form[@id='js-main-form']/div/div[2]/section/div/div/div/div[1]"
	 * ,drive).replace("See Map", "")).trim(); StoreAddress2 = (return_text(
	 * "//form[@id='js-main-form']/div/div[2]/section/div/div/div/div[2]"
	 * ,drive).replace("See Map", "")).trim(); StoreAddress3 = (return_text(
	 * "//form[@id='js-main-form']/div/div[2]/section/div/div/div/div[3]",
	 * drive).replace("See Map", "")).trim();
	 * 
	 * if(!StoreAddress1.equals(""))
	 * statusTracker(br,driver, " ","Address 1: ",StoreAddress1," "); else
	 * statusTracker(br,driver, "Fail","Address 1: ","Address 1 is Not Displayed"," ");
	 * 
	 * if(!StoreAddress2.equals(""))
	 * statusTracker(br,driver, " ","Address 2: ",StoreAddress2," "); else
	 * statusTracker(br,driver, "Fail","Address 2: ","Address 2 is Not Displayed"," ");
	 * 
	 * if(!StoreAddress3.equals(""))
	 * statusTracker(br,driver, " ","Address 3: ",StoreAddress3," "); else
	 * statusTracker(br,driver, "Fail","Address 3: ","Address 3 is Not Displayed"," ");
	 * 
	 * //For the Store Pick option, the Value Free is verified.
	 * if((return_text(".//*[@id='section-pickup']/header/label/span[1]",
	 * drive).trim()).equals("Free"))
	 * statusTracker(br,driver, "Pass","For the Store Pick there is NO processing fees"
	 * ,return_text(".//*[@id='section-pickup']/header/label/span[1]",
	 * drive)+" is displayed.","No Processing Fee for the Store Pickup"); else
	 * statusTracker
	 * ("Fail","For the Store Pick there is NO processing fees",return_text
	 * (".//*[@id='section-pickup']/header/label/span[1]",
	 * drive)+" is displayed."
	 * ,"Processing Fee for the Store Pickup Must be always Free");
	 * 
	 * InstallationFees = 0.0;
	 * 
	 * //For the Store Pick option, the One Time Charges Text is verified.
	 * if((return_text(".//*[@class='services-table']/tbody/tr[1]/td[1]",
	 * drive).trim()).equals("Easy Connect Pick-up Fee")) statusTracker(br,driver, "Pass",
	 * "For the Store Pick option, the One Time Charges Text to be verified"
	 * ,return_text(".//*[@class='services-table']/tbody/tr[1]/td[1]",
	 * drive)+" is displayed.","One Time Charges Text is as Expected"); else
	 * statusTracker
	 * ("Fail","For the Store Pick option, the One Time Charges Text to be verified"
	 * ,return_text(".//*[@class='services-table']/tbody/tr[1]/td[1]",
	 * drive)+" is displayed.","One Time Charges Text is NOT as Expected");
	 * 
	 * if (InstallationFees == Double.parseDouble(return_text(
	 * ".//*[@class='services-table']/tbody/tr[1]/td[2]", drive).replace("$",
	 * "").trim())) statusTracker(br,driver, "Pass",
	 * "For the Store Pick option, the One Time Charges charges to be verified"
	 * ,return_text(".//*[@class='services-table']/tbody/tr[1]/td[2]",
	 * drive)+" is displayed.","One Time Charges VALUE is as Expected"); else
	 * statusTracker(br,driver, "Fail",
	 * "For the Store Pick option, the One Time Charges charges  to be verified"
	 * ,return_text(".//*[@class='services-table']/tbody/tr[1]/td[2]",
	 * drive)+" is displayed.","One Time Charges VALUE is NOT as Expected");
	 * 
	 * } else if (ECKOptionName.equals("Mail")) { //Hard coded the text, as the
	 * contents will not modify
	 * if(return_text(".//*[@id='section-mail']/section/div/div/div/div[1]/ul/li"
	 * , drive).equals("TV Equipment Easy Connect Kit"))
	 * statusTracker(br,driver, "Pass","Mail Option Content Validation"
	 * ,return_text(".//*[@id='section-mail']/section/div/div/div/div[1]/ul/li",
	 * drive)," TV Equipment Text is correct under Mail option"); else
	 * statusTracker(br,driver, "Fail","Mail Option Content Validation",return_text(
	 * ".//*[@id='section-mail']/section/div/div/div/div[1]/ul/li",
	 * drive)," TV Equipment Text is NOT correct under Mail option");
	 * 
	 * InstallationFees = Double.parseDouble((return_text(
	 * ".//*[@id='section-mail']/header/label/span[1]", drive).replace("$",
	 * "")).trim());
	 * logger.info("Installation Fees : "+InstallationFees);
	 * 
	 * //For the Mail option, the One Time Charges Text is verified.
	 * if((return_text(".//*[@class='services-table']/tbody/tr[1]/td[1]",
	 * drive).trim()).equals("Easy Connect S & H Fee")) statusTracker(br,driver, "Pass",
	 * "For the Mail option, the One Time Charges Text to be verified"
	 * ,return_text(".//*[@class='services-table']/tbody/tr[1]/td[1]",
	 * drive)+" is displayed.","One Time Charges Text is as Expected"); else
	 * statusTracker
	 * ("Fail","For the Mail option, the One Time Charges Text to be verified"
	 * ,return_text(".//*[@class='services-table']/tbody/tr[1]/td[1]",
	 * drive)+" is displayed.","One Time Charges Text is NOT as Expected");
	 * 
	 * if (InstallationFees == Double.parseDouble(return_text(
	 * ".//*[@class='services-table']/tbody/tr[1]/td[2]", drive).replace("$",
	 * "").trim()) ) statusTracker(br,driver, "Pass",
	 * "For the Mail option, the One Time Charges charges to be verified"
	 * ,return_text(".//*[@class='services-table']/tbody/tr[1]/td[2]",
	 * drive)+" is displayed.","One Time Charges VALUE is as Expected"); else
	 * statusTracker
	 * ("Fail","For the Mail option, the One Time Charges charges to be verified"
	 * ,return_text(".//*[@class='services-table']/tbody/tr[1]/td[2]",
	 * drive)+" is displayed.","One Time Charges VALUE is NOT as Expected"); }
	 * else if(ECKOptionName.equals("TechInstall")) {
	 * 
	 * InstallationFees = Double.parseDouble((return_text(
	 * ".//*[@id='section-schedule']/header/label/span[1]", drive).replace("$",
	 * "")).trim());
	 * logger.info("Installation Fees : "+InstallationFees);
	 * 
	 * //For the TechInstall option, the One Time Charges Text is verified.
	 * if((return_text(".//*[@class='services-table']/tbody/tr[1]/td[1]",
	 * drive).trim()).equals("Service Installation Fee")) statusTracker(br,driver, "Pass",
	 * "For the Tech Install option, the One Time Charges Text to be verified"
	 * ,return_text(".//*[@class='services-table']/tbody/tr[1]/td[1]",
	 * drive)+" is displayed.","One Time Charges Text is as Expected"); else
	 * statusTracker(br,driver, "Fail",
	 * "For the Tech Install option, the One Time Charges Text to be verified"
	 * ,return_text(".//*[@class='services-table']/tbody/tr[1]/td[1]",
	 * drive)+" is displayed.","One Time Charges Text is NOT as Expected");
	 * 
	 * if (InstallationFees == Double.parseDouble(return_text(
	 * ".//*[@class='services-table']/tbody/tr[1]/td[2]", drive).replace("$",
	 * "").trim()) ) statusTracker(br,driver, "Pass",
	 * "For the Tech Install option, the One Time Charges charges to be verified"
	 * ,return_text(".//*[@class='services-table']/tbody/tr[1]/td[2]",
	 * drive)+" is displayed.","One Time Charges VALUE is as Expected"); else
	 * statusTracker(br,driver, "Fail",
	 * "For the Tech Install option, the One Time Charges charges to be verified"
	 * ,return_text(".//*[@class='services-table']/tbody/tr[1]/td[2]",
	 * drive)+" is displayed.","One Time Charges VALUE is NOT as Expected");
	 * 
	 * 
	 * } else {
	 * 
	 * }
	 * 
	 * Overall_oneTimeCharges = oneTimeCharges + InstallationFees; if
	 * (Overall_oneTimeCharges == Double.parseDouble(return_text(
	 * ".//*[@title='One Time Charges']/tfoot/tr/td[2]", drive).replace("$",
	 * "").trim())) statusTracker(br,driver, "Pass",
	 * "The One Time Charges + ECK Fees is same as displayed in the Review Order page"
	 * ,return_text(".//*[@title='One Time Charges']/tfoot/tr/td[2]",
	 * drive)+" is displayed."
	 * ,"One Time Charges VALUE : "+Overall_oneTimeCharges+" is as Expected");
	 * else statusTracker(br,driver, "Fail",
	 * "The One Time Charges + ECK Fees is same as displayed in the Review Order page"
	 * ,return_text(".//*[@title='One Time Charges']/tfoot/tr/td[2]",
	 * drive)+" is displayed."
	 * ,"One Time Charges VALUE : "+Overall_oneTimeCharges
	 * +" is NOT as Expected"); }
	 */

	/*
	 * public void TV_OrderSummary_DetailsValidation(String Cust_Name, String
	 * Cust_ServiceAddress) { String Actual_ServiceAddress = ""; String
	 * Expected_ServiceAddress = "";
	 * logger.info("Calling OrderSummary_DetailsValidation");
	 * logger.info
	 * ("Order Summary - ECKOptionSelected : "+ECKOptionSelected);
	 * logger.info
	 * ("Order Summary - Overall_oneTimeCharges : "+Overall_oneTimeCharges);
	 * System
	 * .out.println("Order Summary - Cust_ServiceAddress : "+Cust_ServiceAddress
	 * );
	 * 
	 * if (ECKOptionSelected.equals("Store")) { logger.info(return_text(
	 * ".//*[@class='services-table']/tbody/tr[1]/td[1]", drive).trim());
	 * if((return_text(".//*[@class='services-table']/tbody/tr[1]/td[1]",
	 * drive).trim()).equals("Easy Connect Pick-up Fee")) statusTracker(br,driver, "Pass",
	 * "For the Store Pick option, the One Time Charges Text to be verified in the Order Summary Page"
	 * ,return_text(".//*[@class='services-table']/tbody/tr[1]/td[1]",
	 * drive)+" is displayed.","One Time Charges Text is as Expected"); else
	 * statusTracker
	 * ("Fail","For the Store Pick option, the One Time Charges Text to be verified"
	 * ,return_text(".//*[@class='services-table']/tbody/tr[1]/td[1]",
	 * drive)+" is displayed.","One Time Charges Text is NOT as Expected");
	 * 
	 * if (InstallationFees == Double.parseDouble(return_text(
	 * ".//*[@class='services-table']/tbody/tr[1]/td[2]", drive).replace("$",
	 * "").trim())) statusTracker(br,driver, "Pass",
	 * "For the Store Pick option, the One Time Charges charges to be verified in the Order Summary Page"
	 * ,return_text(".//*[@class='services-table']/tbody/tr[1]/td[2]",
	 * drive)+" is displayed.","One Time Charges VALUE is as Expected"); else
	 * statusTracker(br,driver, "Fail",
	 * "For the Store Pick option, the One Time Charges charges  to be verified in the Order Summary Page"
	 * ,return_text(".//*[@class='services-table']/tbody/tr[1]/td[2]",
	 * drive)+" is displayed.","One Time Charges VALUE is NOT as Expected");
	 * 
	 * if(StoreAddress1.equals(return_text(".//*[@class='three-col']/li[1]",
	 * drive).trim())) statusTracker(br,driver, "Pass",
	 * "Both Addresses 1 in Review & Summary Order page should be same"
	 * ,return_text(".//*[@class='three-col']/li[1]",
	 * drive),"Both Addresses 1 in Review & Summary Order page are same"); else
	 * statusTracker
	 * ("Fail","Both Addresses 1 in Review & Summary Order page should be same"
	 * ,return_text(".//*[@class='three-col']/li[1]",
	 * drive),"Both Addresses 1 in Review & Summary Order page are NOT same");
	 * 
	 * if(StoreAddress2.equals(return_text(".//*[@class='three-col']/li[2]",
	 * drive).trim())) statusTracker(br,driver, "Pass",
	 * "Both Addresses 2 in Review & Summary Order page should be same"
	 * ,return_text(".//*[@class='three-col']/li[2]",
	 * drive),"Both Addresses 2 in Review & Summary Order page are same"); else
	 * statusTracker
	 * ("Fail","Both Addresses 2 in Review & Summary Order page should be same"
	 * ,return_text(".//*[@class='three-col']/li[2]",
	 * drive),"Both Addresses 2 in Review & Summary Order page are NOT same");
	 * 
	 * if(StoreAddress3.equals(return_text(".//*[@class='three-col']/li[3]",
	 * drive).trim())) statusTracker(br,driver, "Pass",
	 * "Both Addresses 3 in Review & Summary Order page should be same"
	 * ,return_text(".//*[@class='three-col']/li[3]",
	 * drive),"Both Addresses 3 in Review & Summary Order page are same"); else
	 * statusTracker
	 * ("Fail","Both Addresses 3 in Review & Summary Order page should be same"
	 * ,return_text(".//*[@class='three-col']/li[3]",
	 * drive),"Both Addresses 3 in Review & Summary Order page are NOT same");
	 * 
	 * Equip_text= return_text(".//*[@class='rtf']/ul/li", drive).trim(); } else
	 * if (ECKOptionSelected.equals("Mail")) { Equip_text=
	 * return_text(".//*[@class='col rtf']/ul/li", drive).trim(); } else if
	 * (ECKOptionSelected.equals("TechInstall")) {
	 * 
	 * } else {
	 * 
	 * } logger.info("Equip Text : "+Equip_text); if
	 * (ECKOptionSelected.equals("Store") || ECKOptionSelected.equals("Mail")) {
	 * 
	 * if(Equip_text.equals("TV Equipment Easy Connect Kit"))
	 * statusTracker(br,driver, "Pass"
	 * ,"Order Summary Page - "+ECKOptionSelected+" Option Content Validation"
	 * ,Equip_text
	 * ," TV Equipment Text is correct under "+ECKOptionSelected+" option");
	 * else statusTracker(br,driver, "Fail","Order Summary Page - "+ECKOptionSelected+
	 * " Option Content Validation"
	 * ,Equip_text," TV Equipment Text is NOT correct under "
	 * +ECKOptionSelected+" option"); } if (Overall_oneTimeCharges ==
	 * Double.parseDouble
	 * (return_text(".//*[@title='One Time Charges']/tfoot/tr/td[2]",
	 * drive).replace("$", "").trim())) statusTracker(br,driver, "Pass",
	 * "The One Time Charges + ECK Fees is same as displayed in the Order Summary page"
	 * ,return_text(".//*[@title='One Time Charges']/tfoot/tr/td[2]",
	 * drive)+" is displayed."
	 * ,"One Time Charges VALUE : "+Overall_oneTimeCharges+" is as Expected");
	 * else statusTracker(br,driver, "Fail",
	 * "The One Time Charges + ECK Fees is same as displayed in the Order Summary page"
	 * ,return_text(".//*[@title='One Time Charges']/tfoot/tr/td[2]",
	 * drive)+" is displayed."
	 * ,"One Time Charges VALUE : "+Overall_oneTimeCharges
	 * +" is NOT as Expected");
	 * 
	 * //Validating the Service Address Expected_ServiceAddress = Cust_Name +
	 * " " +Cust_ServiceAddress; Actual_ServiceAddress =
	 * return_text(".//*[@class='last']", drive).trim();
	 * 
	 * logger.info("Expected_ServiceAddress : "+Expected_ServiceAddress);
	 * logger.info("Actual_ServiceAddress : "+ Actual_ServiceAddress);
	 * 
	 * if (Expected_ServiceAddress.equals(Actual_ServiceAddress))
	 * statusTracker(br,driver, "Pass"
	 * ,"Order Summary Page - Validating Service Address",Actual_ServiceAddress
	 * ,"Service Address is same as the Customer Details tagged to the account"
	 * ); else
	 * statusTracker(br,driver, "Fail","Order Summary Page - Validating Service Address"
	 * ,Actual_ServiceAddress
	 * ,"Service Address is NOT same as the Customer Details tagged to the account"
	 * );
	 * 
	 * //Selecting the check box for the Terms & Conditions
	 * logger.info("befor the click");
	 * drive.findElement(By.xpath(".//*[@name='order-choose-TWC']")).click();
	 * logger.info("Checkbox clicked...."); }
	 */

	// // End of TV methods
	// start of phone methods
	/*
	 * public void Phone_ReviewOrder_ECKInstallationOptions(String
	 * ECKOptionName, double oneTimeCharges) throws InterruptedException {
	 * InstallationFees = 0.0; Equip_text =""; ECKOptionSelected="";
	 * ECKOptionSelected = ECKOptionName;
	 * 
	 * logger.info("Review - ECKOptionSelected : "+ECKOptionSelected);
	 * 
	 * if(ECKOptionName.equals("TechInstall")) {
	 * 
	 * InstallationFees = Double.parseDouble((return_text(
	 * ".//*[@id='section-schedule']/header/label/span[1]", drive).replace("$",
	 * "")).trim());
	 * logger.info("Installation Fees : "+InstallationFees);
	 * 
	 * //For the TechInstall option, the One Time Charges Text is verified.
	 * if((return_text(".//*[@class='services-table']/tbody/tr[1]/td[1]",
	 * drive).trim()).equals("Service Installation Fee")) statusTracker(br,driver, "Pass",
	 * "For the Tech Install option, the One Time Charges Text to be verified"
	 * ,return_text(".//*[@class='services-table']/tbody/tr[1]/td[1]",
	 * drive)+" is displayed.","One Time Charges Text is as Expected"); else
	 * statusTracker(br,driver, "Fail",
	 * "For the Tech Install option, the One Time Charges Text to be verified"
	 * ,return_text(".//*[@class='services-table']/tbody/tr[1]/td[1]",
	 * drive)+" is displayed.","One Time Charges Text is NOT as Expected");
	 * 
	 * if (InstallationFees == Double.parseDouble(return_text(
	 * ".//*[@class='services-table']/tbody/tr[1]/td[2]", drive).replace("$",
	 * "").trim()) ) statusTracker(br,driver, "Pass",
	 * "For the Tech Install option, the One Time Charges charges to be verified"
	 * ,return_text(".//*[@class='services-table']/tbody/tr[1]/td[2]",
	 * drive)+" is displayed.","One Time Charges VALUE is as Expected"); else
	 * statusTracker(br,driver, "Fail",
	 * "For the Tech Install option, the One Time Charges charges to be verified"
	 * ,return_text(".//*[@class='services-table']/tbody/tr[1]/td[2]",
	 * drive)+" is displayed.","One Time Charges VALUE is NOT as Expected");
	 * 
	 * Overall_oneTimeCharges = oneTimeCharges + InstallationFees; if
	 * (Overall_oneTimeCharges == Double.parseDouble(return_text(
	 * ".//*[@title='One Time Charges']/tfoot/tr/td[2]", drive).replace("$",
	 * "").trim())) statusTracker(br,driver, "Pass",
	 * "The One Time Charges + ECK Fees is same as displayed in the Review Order page"
	 * ,return_text(".//*[@title='One Time Charges']/tfoot/tr/td[2]",
	 * drive)+" is displayed."
	 * ,"One Time Charges VALUE : "+Overall_oneTimeCharges+" is as Expected");
	 * else statusTracker(br,driver, "Fail",
	 * "The One Time Charges + ECK Fees is same as displayed in the Review Order page"
	 * ,return_text(".//*[@title='One Time Charges']/tfoot/tr/td[2]",
	 * drive)+" is displayed."
	 * ,"One Time Charges VALUE : "+Overall_oneTimeCharges
	 * +" is NOT as Expected");
	 * 
	 * DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy"); Date date =
	 * new Date();
	 * logger.info("Current Date 1: "+dateFormat.format(date));
	 * 
	 * int DD_Value = Integer.parseInt(dateFormat.format(date).substring(3,5));
	 * logger.info("DD Value : "+DD_Value);
	 * 
	 * select_Firstchoice_Date(DD_Value); Thread.sleep(10000);
	 * select_Secondchoice_Date(DD_Value); } }
	 * 
	 * public void Phone_OrderSummary_DetailsValidation(String Cust_Name, String
	 * Cust_ServiceAddress) throws ParseException, InterruptedException { String
	 * Actual_ServiceAddress = ""; String Expected_ServiceAddress = ""; String
	 * FirstDateTime = ""; String SecondDateTime = "";
	 * 
	 * logger.info("Calling OrderSummary_DetailsValidation");
	 * logger.info
	 * ("Order Summary - ECKOptionSelected : "+ECKOptionSelected);
	 * logger.info
	 * ("Order Summary - Cust_ServiceAddress : "+Cust_ServiceAddress);
	 * 
	 * if (ECKOptionSelected.equals("TechInstall")) {
	 * if((return_text(".//*[@class='paragraphMerge installationLOB1']/p/strong[1]"
	 * , drive).trim()).equals("Phone") &&
	 * (return_text(".//*[@class='paragraphMerge installationLOB1']/p/strong[2]"
	 * , drive).trim()).equals("Installation Preferences:")) {
	 * //logger.info("Phone Text 1 : "+return_text(
	 * ".//*[@class='paragraphMerge installationLOB1']/p/strong[1]",
	 * drive).trim()); //logger.info("Phone Text 2 : "+return_text(
	 * ".//*[@class='paragraphMerge installationLOB1']/p/strong[2]",
	 * drive).trim()); statusTracker(br,driver, "Pass",
	 * "The Phone Text details in the Order Summary page to be verified"
	 * ,"The Phone Text details is verified."
	 * ,"The Phone Text details is as Expected."); } else statusTracker(br,driver, "Fail",
	 * "The Phone Text details in the Order Summary page to be verified"
	 * ,"The Phone Text details is verified & text is NOT appropriate."
	 * ,"The Phone Text details is NOT as Expected.");
	 * 
	 * logger.info("First Date & Time : "+return_text(
	 * ".//*[@class='paragraphMerge firstVisitSchedule1']/p",
	 * drive).replace(":00", "").trim());
	 * logger.info("Second Date & Time : "
	 * +return_text(".//*[@class='firstVisitSchedule2 paragraphMerge']/p",
	 * drive).replace(":00", "").trim());
	 * 
	 * FirstDateTime = OrderSummary_DateTimeFormat(FirstChoiceDate) + " - " +
	 * FirstChoiceTime; logger.info("FirstDateTime : "+FirstDateTime);
	 * logger.info("Actual Text :"+return_text(
	 * ".//*[@class='paragraphMerge firstVisitSchedule1']/p", drive));
	 * 
	 * if (FirstDateTime.equals(return_text(
	 * ".//*[@class='paragraphMerge firstVisitSchedule1']/p",
	 * drive).replace(":00", "").replace("Your First Choice:", "").trim()))
	 * statusTracker
	 * ("Pass","Order Summary Page - Validation First Install Date & Time Details."
	 * ,return_text(".//*[@class='paragraphMerge firstVisitSchedule1']/p",
	 * drive).replace(":00", "").replace("Your First Choice:", "").trim(),
	 * "First Install Date & Time Details are same, as per the Review Order page"
	 * ); else statusTracker(br,driver, "Fail",
	 * "Order Summary Page - Validation First Install Date & Time Details."
	 * ,return_text(".//*[@class='paragraphMerge firstVisitSchedule1']/p",
	 * drive).replace(":00", "").replace("Your First Choice:", "").trim(),
	 * "First Install Date & Time Details are NOT same, as per the Review Order page"
	 * );
	 * 
	 * SecondDateTime = OrderSummary_DateTimeFormat(SecondChoiceDate) + " - " +
	 * SecondChoiceTime; logger.info("SecondDateTime : "+SecondDateTime);
	 * if (SecondDateTime.equals(return_text(
	 * ".//*[@class='firstVisitSchedule2 paragraphMerge']/p",
	 * drive).replace(":00", "").replace("Your Second Choice:", "").trim()))
	 * statusTracker
	 * ("Pass","Order Summary Page - Validation Second Install Date & Time Details."
	 * ,return_text(".//*[@class='firstVisitSchedule2 paragraphMerge']/p",
	 * drive).replace(":00", "").replace("Your Second Choice:", "").trim(),
	 * "Second Install Date & Time Details are same, as per the Review Order page"
	 * ); else statusTracker(br,driver, "Fail",
	 * "Order Summary Page - Validation Second Install Date & Time Details."
	 * ,return_text(".//*[@class='firstVisitSchedule2 paragraphMerge']/p",
	 * drive).replace(":00", "").replace("Your Second Choice:", "").trim(),
	 * "Second Install Date & Time Details are NOT same, as per the Review Order page"
	 * ); }
	 * 
	 * if (Overall_oneTimeCharges == Double.parseDouble(return_text(
	 * ".//*[@title='One Time Charges']/tfoot/tr/td[2]", drive).replace("$",
	 * "").trim())) statusTracker(br,driver, "Pass",
	 * "The One Time Charges + ECK Fees is same as displayed in the Order Summary page"
	 * ,return_text(".//*[@title='One Time Charges']/tfoot/tr/td[2]",
	 * drive)+" is displayed."
	 * ,"One Time Charges VALUE : "+Overall_oneTimeCharges+" is as Expected");
	 * else statusTracker(br,driver, "Fail",
	 * "The One Time Charges + ECK Fees is same as displayed in the Order Summary page"
	 * ,return_text(".//*[@title='One Time Charges']/tfoot/tr/td[2]",
	 * drive)+" is displayed."
	 * ,"One Time Charges VALUE : "+Overall_oneTimeCharges
	 * +" is NOT as Expected");
	 * 
	 * 
	 * //Validating the Service Address Expected_ServiceAddress = Cust_Name +
	 * " " +Cust_ServiceAddress; Actual_ServiceAddress =
	 * return_text(".//*[@class='last']", drive).trim();
	 * 
	 * logger.info("Expected_ServiceAddress : "+Expected_ServiceAddress);
	 * logger.info("Actual_ServiceAddress : "+ Actual_ServiceAddress);
	 * 
	 * if (Expected_ServiceAddress.equals(Actual_ServiceAddress))
	 * statusTracker(br,driver, "Pass"
	 * ,"Order Summary Page - Validating Service Address",Actual_ServiceAddress
	 * ,"Service Address is same as the Customer Details tagged to the account"
	 * ); else
	 * statusTracker(br,driver, "Fail","Order Summary Page - Validating Service Address"
	 * ,Actual_ServiceAddress
	 * ,"Service Address is NOT same as the Customer Details tagged to the account"
	 * );
	 * 
	 * 
	 * OrderSummary_ChkBrowserBackButton(); Thread.sleep(15000);
	 * 
	 * //Selecting the check box for the Terms & Conditions
	 * logger.info("befor the click");
	 * drive.findElement(By.xpath(".//*[@name='order-choose-TWC']")).click();
	 * logger.info("Checkbox clicked...."); }
	 */
	
	 public String Select_DropDown_Index(WebDriver driver, String fxp, int Index)
				throws InterruptedException

			{
			WebElement dropDownListBox = driver.findElement(By.xpath(fxp));
		    Actions actions = new Actions(driver);
			actions.moveToElement(dropDownListBox);
			actions.perform();                 

			Select clickThis = new Select(dropDownListBox);
			Thread.sleep(2000);
			clickThis.selectByIndex(Index);
			Thread.sleep(2000);
			
			logger.info("Time Value.................. : "+clickThis.getOptions().get(Index).getText());
			return clickThis.getOptions().get(Index).getText().trim();
			}
	 public void select_Firstchoice_Date(String br,int DDValue,WebDriver drive)
				throws InterruptedException {
			FirstChoiceDate = "";
			FirstChoiceTime = "";
			int index = 0;

			logger.info("select_Firstchoice_Date....1 :" + DDValue);
			drive.findElement(By.xpath(".//input[@id='first-choice-date1']"))
					.click();

			Thread.sleep(5000);
			
			if (DDValue > 25)
			drive.findElement(By.xpath(".//*[@class='calendar-button-month calendar-button-next']"))
						.click();

			Thread.sleep(6000);

			List<WebElement> mylifirst = drive.findElements(By
					.xpath(".//*[@class='day']"));
			Thread.sleep(5000);
			logger.info("List size : " + mylifirst.size());

			for (int i = 0; i < mylifirst.size(); i++) {
				if (i >= 7) {
					mylifirst.get(i).click();
					index = i;
					break;
				}
			}

			FirstChoiceDate = mylifirst.get(index).getAttribute("rel");
			Thread.sleep(3000);
			logger.info("FirstChoiceDate is " + FirstChoiceDate);
			// logger.info("FirstChoiceDate attribute is "+drive.findElement(By.xpath(".//*[@id='first-choice-date1']")).getAttribute("value"));

			if (!FirstChoiceDate.equals(""))
				statusTracker(br,drive, "Pass", "First Install Date is entered.", "",
						"First Install Date is : " + FirstChoiceDate + "");
			else
				statusTracker(br,drive, "Fail", "First Install Date is NOT entered.", "",
						"First Install Date is Blank");

			
			
			Thread.sleep(3000);
			FirstChoiceTime = Select_DropDown_Index(drive, ".//*[@id='first-choice-time1']", 2);
			
			if (!FirstChoiceTime.equals(""))
				statusTracker(br,drive, "Pass", "First Install Time is entered.", "",
						"First Install Time is : " + FirstChoiceTime + "");
			else
				statusTracker(br,drive, "Fail", "First Install Time is NOT entered.", "",
						"First Install Time is Blank");

			

			logger.info("FirstChoiceTime is " + FirstChoiceTime);
		}
	 
	 
	
	/* public void select_Firstchoice_Date(String br,int DDValue)
				throws InterruptedException {
			FirstChoiceDate = "";
			FirstChoiceTime = "";
			int index = 0;

			logger.info("select_Firstchoice_Date....1 :" + DDValue);
			drive.findElement(By.xpath(".//*[@id='first-choice-date1']"))
					.click();

			Thread.sleep(5000);
			
			if (DDValue > 25)
				
			drive.findElement(By.xpath(".//*[@class='calendar-button-month calendar-button-next']")).click();

			Thread.sleep(6000);

			List<WebElement> mylifirst = drive.findElements(By
					.xpath(".//*[@class='day']"));
			Thread.sleep(5000);
			logger.info("List size : " + mylifirst.size());

			for (int i = 0; i < mylifirst.size(); i++) {
				if (i >= 8) {
					mylifirst.get(i).click();
					index = i;
					break;
				}
			}

			
			List<WebElement> mylifirst = drive.findElements(By
					.xpath(".//*[@class='calendar-month-dates clearfix']/div"));
			Thread.sleep(2000);
			for (int i = 0; i < mylifirst.size(); i++) {
				if (mylifirst.get(i).getAttribute("class").equals("day out") ){
					mylifirst.get(i).click();
					index = i;
					break;
				}
			}
			FirstChoiceDate = mylifirst.get(index).getAttribute("rel");
			Thread.sleep(3000);
			logger.info("FirstChoiceDate is " + FirstChoiceDate);
			// logger.info("FirstChoiceDate attribute is "+drive.findElement(By.xpath(".//*[@id='first-choice-date1']")).getAttribute("value"));

			if (!FirstChoiceDate.equals(""))
				statusTracker(br,driver, "Pass", "First Install Date is entered.", "",
						"First Install Date is : " + FirstChoiceDate + "");
			else
				statusTracker(br,driver, "Fail", "First Install Date is NOT entered.", "",
						"First Install Date is Blank");

			
			Thread.sleep(3000);
			FirstChoiceTime = Select_DropDown_Index(drive, ".//*[@id='first-choice-time1']", 2);
			
			if (!FirstChoiceTime.equals(""))
				statusTracker(br,driver, "Pass", "First Install Time is entered.", "",
						"First Install Time is : " + FirstChoiceTime + "");
			else
				statusTracker(br,driver, "Fail", "First Install Time is NOT entered.", "",
						"First Install Time is Blank");


			logger.info("FirstChoiceTime is " + FirstChoiceTime);
		}
	 
	 
	 

	 public void select_Secondchoice_Date(String br,int DDValue)
				throws InterruptedException {
			SecondChoiceDate = "";
			SecondChoiceTime = "";
			int index = 0;

			logger.info("select_Secondchoice_Date....1 : " + DDValue);
			drive.findElement(By.xpath(".//*[@id='second-choice-date1']"))
					.click();
			
			Thread.sleep(6000);

			//if (DDValue > 25)
				//drive.findElement(
						//By.xpath(".//*[@class='calendar-button-month calendar-button-next']"))
						//.click();

			Thread.sleep(5000);
			
			/*
			 * List<WebElement> mylisecond = drive.findElements(By
					.xpath(".//*[@class='day']"));
			Thread.sleep(2000);
			for (int i = 0; i < mylisecond.size(); i++) {
				if (i >= 9) {
					mylisecond.get(i).click();
					index = i;
					break;
				}
			}
			SecondChoiceDate = mylisecond.get(index).getAttribute("rel");
			
			List<WebElement> mylisecond = drive.findElements(By
					.xpath(".//*[@class='calendar-month-dates clearfix']/div"));
			Thread.sleep(2000);
			for (int i = 0; i < mylisecond.size(); i++) {
				if (mylisecond.get(i).getAttribute("class").equals("day out") && !(mylisecond.get(i).getAttribute("rel").equals(FirstChoiceDate))) {
					mylisecond.get(i).click();
					index = i;
					break;
				}
			}
			SecondChoiceDate = mylisecond.get(index).getAttribute("rel");
			Thread.sleep(3000);
			logger.info("SecondChoiceDate is " + SecondChoiceDate);
			// logger.info("SecondChoiceDate attribute is "+drive.findElement(By.xpath(".//*[@id='second-choice-date1']")).getAttribute("value"));
			if (!SecondChoiceDate.equals(""))
				statusTracker(br,driver, "Pass", "Second Install Date is entered.", "",
						"Second Install Date is : " + SecondChoiceDate + "");
			else
				statusTracker(br,driver, "Fail", "Second Install Date is NOT entered.", "",
						"Second Install Date is Blank");

	
			
			Thread.sleep(3000);
			SecondChoiceTime = Select_DropDown_Index(drive, ".//*[@id='second-choice-time1']", 2);

			if (!SecondChoiceTime.equals(""))
				statusTracker(br,driver, "Pass", "Second Install Time is entered.", "",
						"Second Install Time is : " + SecondChoiceTime + "");
			else
				statusTracker(br,driver, "Fail", "Second Install Time is NOT entered.", "",
						"Second Install Time is Blank");

			logger.info("SecondChoicetime is " + SecondChoiceTime);
		}
	 */
	 
	 public void select_Secondchoice_Date(String br,int DDValue,WebDriver drive)
				throws InterruptedException {
			SecondChoiceDate = "";
			SecondChoiceTime = "";
			int index = 0;

			logger.info("select_Secondchoice_Date....1 : " + DDValue);
			drive.findElement(By.xpath(".//input[@id='second-choice-date1']"))
					.click();
			
			Thread.sleep(6000);

			if (DDValue > 25)
				drive.findElement(
						By.xpath(".//*[@class='calendar-button-month calendar-button-next']"))
						.click();

			Thread.sleep(5000);
			List<WebElement> mylisecond = drive.findElements(By
					.xpath(".//*[@class='day']"));
			Thread.sleep(2000);
			for (int i = 0; i < mylisecond.size(); i++) {
				if (i >= 8) {
					mylisecond.get(i).click();
					index = i;
					break;
				}
			}
			SecondChoiceDate = mylisecond.get(index).getAttribute("rel");
			Thread.sleep(3000);
			logger.info("SecondChoiceDate is " + SecondChoiceDate);
			// logger.info("SecondChoiceDate attribute is "+drive.findElement(By.xpath(".//*[@id='second-choice-date1']")).getAttribute("value"));
			if (!SecondChoiceDate.equals(""))
				statusTracker(br,drive, "Pass", "Second Install Date is entered.", "",
						"Second Install Date is : " + SecondChoiceDate + "");
			else
				statusTracker(br,drive, "Fail", "Second Install Date is NOT entered.", "",
						"Second Install Date is Blank");

		
			
			Thread.sleep(3000);
			SecondChoiceTime = Select_DropDown_Index(drive, ".//*[@id='second-choice-time1']", 2);

			if (!SecondChoiceTime.equals(""))
				statusTracker(br,drive, "Pass", "Second Install Time is entered.", "",
						"Second Install Time is : " + SecondChoiceTime + "");
			else
				statusTracker(br,drive, "Fail", "Second Install Time is NOT entered.", "",
						"Second Install Time is Blank");

			
			logger.info("SecondChoicetime is " + SecondChoiceTime);
		}
	 

	public String OrderSummary_DateTimeFormat(String FirstSecondDate)
			throws ParseException {
		DateFormat formatter;
		Date date;
		formatter = new SimpleDateFormat("MM/dd/yyyy");
		date = formatter.parse(FirstSecondDate);
		return new SimpleDateFormat("EEEE").format(date) + ", "
				+ new SimpleDateFormat("MMM").format(date) + " "
				+ new SimpleDateFormat("dd").format(date) + ", "
				+ new SimpleDateFormat("YYYY").format(date);
	}

	public void OrderSummary_ChkBrowserBackButton(String br,WebDriver drive) throws InterruptedException {
		logger.info("OrderSummary_ChkBrowserBackButton");

		String TitlebeforeBackclk = "";
		String TitleafterBackclk = "";

		logger.info("2.Present title - " + drive.getTitle());
		TitlebeforeBackclk = drive.getTitle();

		Thread.sleep(1000);

		drive.navigate().back();

		logger.info("3.Present title - " + drive.getTitle());
		TitleafterBackclk = drive.getTitle();

		Thread.sleep(5000);

		if (TitleafterBackclk.equals(TitlebeforeBackclk)) {
			statusTracker(br,drive, 
					"Pass",
					"Click on the Browser Back button.",
					"Page still remiains in Order Summary only.",
					"Upon clicking the browser back button, the page still remains in the Order Summary page only.");
		} else {
			statusTracker(br,drive, 
					"Fail",
					"Click on the Browser Back button.",
					"Page still NOT remiains in Order Summary.",
					"Upon clicking the browser back button, the page still remains in the Order Summary page only.");
		}
	}

	// end of the phone method
	// Nithin Updated - End

	// Shikha: Phone( your
	// number)***********************************************************************

	public void click_PrivateListening(WebDriver driver)
			throws InterruptedException {
		Thread.sleep(9000);
		click_element("//*[@class='content-wrap']/div[3]/header/ul/li[1]/a",
				driver);
		Thread.sleep(2000);
		click_element("//*[@class='content-wrap']/div[3]/header/ul/li[1]/a",
				driver);
		Thread.sleep(2000);
		click_element("//*[@id='1-29SM']", driver);
		Thread.sleep(9000);
		logger.info("shikha funcrion ended");
	}

	public void click_VoiceMail(WebDriver driver) throws InterruptedException {
		click_element("//*[@class='content-wrap']/div[4]/header/ul/li[1]/a",
				driver);
		Thread.sleep(2000);
		click_element("//*[@class='content-wrap']/div[4]/header/ul/li[1]/a",
				driver);
		Thread.sleep(2000);
		click_element("//*[@id='1-29SB']", driver);
	}

	public void click_GlobalPenny(WebDriver driver) throws InterruptedException {
		click_element("//*[@class='content-wrap']/div[6]/header/ul/li[1]/a",
				driver);
		Thread.sleep(2000);
		click_element("//*[@class='content-wrap']/div[6]/header/ul/li[1]/a",
				driver);
		Thread.sleep(2000);
		click_element("//*[@id='12-1BZU']", driver);
	}

	public void click_International(String br,WebDriver driver)
			throws InterruptedException {
		click_element("//*[@class='content-wrap']/div[7]/header/ul/li[1]/a",
				driver);
		Thread.sleep(2000);
		click_element("//*[@class='content-wrap']/div[7]/header/ul/li[1]/a",
				driver);
		Thread.sleep(2000);
		click_element("//*[@id='1-29S0']", driver);
	}

	public void field_statusTracker(String br, String xp, String tc, String Actual,
			WebDriver driver) {

		String value = driver.findElement(By.xpath(xp)).getAttribute("value");

		logger.info("Value is" + value);
		if (value.equals("")) {
			statusTracker(br,driver, "Fail", tc, Actual, "Date should be Entered");
			logger.info("failed");
		} else {
			statusTracker(br,driver, "Pass", tc, Actual, "Date should be Entered");
			logger.info("passed");
		}
	}

	public void transfer_number(String br, WebDriver driver) throws InterruptedException {
		// Click Feature options

		click_PrivateListening(driver);
		Thread.sleep(8000);
		config_page_Cart_result_updater(br,driver);
		page_Cart_One_Time_charge_updater(br,driver);
		Thread.sleep(2000);

		click_VoiceMail(driver);
		Thread.sleep(2000);
		config_page_Cart_result_updater(br,driver);
		page_Cart_One_Time_charge_updater(br,driver);
		Thread.sleep(2000);

		click_GlobalPenny(driver);
		Thread.sleep(8000);
		config_page_Cart_result_updater(br,driver);
		page_Cart_One_Time_charge_updater(br,driver);
		Thread.sleep(3000);

		// click International plan option
		click_International(br,driver);
		Thread.sleep(2000);
		config_page_Cart_result_updater(br,driver);
		page_Cart_One_Time_charge_updater(br,driver);
		Thread.sleep(3000);

		// Compare Plan Page check
		driver.findElement(
				By.xpath("//*[@class='modal modalGeneric js-modal-initialized']"))
				.click();
		logger.info("two");

		Thread.sleep(10000);

		String modal_title = driver.findElement(
				By.xpath("//*[@class='modal-title']")).getText();
		if (modal_title.equalsIgnoreCase("International Calling Rates")) {
			statusTracker(br,driver, "Pass", "Click on Compare Plan link",
					"Compare Plan link is clicked",
					"Compare plan link should be clicked");
			logger.info("tHREE" + "");
		} else {
			statusTracker(br,driver, "Fail", "Click on Compare Plan link",
					"Compare Plan link is not clicked",
					"Compare plan link should be clicked");
		}

		driver.findElement(By.xpath("//*[@class='modal-button-close']"))
				.click();
		Thread.sleep(5000);

		String Act_config = driver
				.findElement(
						By.xpath("//*[@class='text parbase sectionHeader twc-plain-text']"))
				.getText();
		if (Act_config
				.equalsIgnoreCase("Select Optional Features & Calling Plans")) {
			statusTracker(br,driver, "Pass", "Click on close button of Compare Plan",
					"Compare Plan gets closed",
					"Compare plan should get closed");
		} else {
			statusTracker(br,driver, "Fail", "Click on close button of Compare Plan",
					"Compare Plan does not gets closed",
					"Compare plan should get closed");
		}

		Thread.sleep(5000);

		// Click Continue to next plan
		click_element(
				"//*[@id='content']/div[2]/div[2]/div/div[2]/div/div[2]/div/div/div[1]/div/section/div/div[9]/a",
				driver);
		Thread.sleep(7000);
		if (driver.findElement(By.id("js-phoneNumber-new")).isDisplayed()
				&& driver.findElement(By.id("js-phoneNumber-transfer"))
						.isDisplayed())

		{
			Thread.sleep(2000);
			statusTracker(br,driver, 
					"Pass",
					"Check for Add new number and transfer existing number options",
					"Both options are present",
					"BOth options should be present");
		} else {
			statusTracker(br,driver, 
					"Fail",
					"Check for Add new number and transfer existing number options",
					"Just one options is present",
					"Both options should be present");
		}

		click_element("//*[@id='js-phoneNumber-transfer']", driver);
		Thread.sleep(5000);
		if (driver.findElement(
				By.xpath("//*[@class='transfer-number general-form']"))
				.isDisplayed()) {
			statusTracker(br,driver, "Pass",
					"Transfer number general form gets displayed",
					"Transfer number general form is displayed",
					"Transfer number general form should be displayed");
		} else {
			statusTracker(br,driver, "Fail",
					"Transfer number general form gets displayed",
					"Transfer number general form is not displayed",
					"Transfer number general form should be displayed");
		}

		logger.info("started");

		// for currentProvider

		Thread.sleep(2000);
		WebElement mywe_select_pro = driver.findElement(By
				.xpath("//*[@id='currentProvider']"));
		logger.info("first");
		mywe_select_pro.click();
		Thread.sleep(2000);
		logger.info("second");
		List<WebElement> my_li = mywe_select_pro.findElements(By
				.tagName("option"));
		// logger.info("my_li is "+my_li);
		int size_drop = my_li.size();

		// mywe_select_pro.sendKeys(my_li.get(2).getText());

		for (int i = 0; i < size_drop; i++) {
			if (my_li.get(i).getText().equals("CIMCO")) {
				my_li.get(i).sendKeys("CIMCO");
				field_statustracker(br, "//*[@id='currentProvider']",
						"Select Current Provider ",
						"Current Provider is Selected", driver);
				break;
			}

		}

		Thread.sleep(4000);

		// For current-provider-state

		WebElement mywe_select_pro_1 = driver.findElement(By
				.xpath("//*[@id='current-provider-state']"));

		logger.info("first");
		Thread.sleep(2000);
		mywe_select_pro_1.click();
		logger.info("second");
		Thread.sleep(2000);
		List<WebElement> my_li_1 = mywe_select_pro_1.findElements(By
				.tagName("option"));

		int size_drop_1 = my_li_1.size();
		for (int i = 0; i < size_drop_1; i++) {
			if (my_li_1.get(i).getText().equals("Hawaii")) {
				my_li_1.get(i).sendKeys("Hawaii");
				field_statustracker(br, "//*[@id='current-provider-state']",
						"Select Current Provider State",
						"Current Provider state is Selected", driver);
				break;
			}
		}

		driver.findElement(By.xpath("//*[@id='phone-number']")).sendKeys(
				"123-876-7678");
		Thread.sleep(2000);
		field_statustracker(br, "//*[@id='phone-number']", "Enter Phone Number",
				"Phone number is Entered", driver);
		Thread.sleep(2000);
		driver.findElement(By.id("account-number")).sendKeys("23456745");
		Thread.sleep(2000);
		field_statustracker(br, "//*[@id='account-number']",
				"Enter Account Number", "Account Number is Entered", driver);
		Thread.sleep(2000);
		driver.findElement(By.id("account-name")).sendKeys("Dani");
		field_statustracker(br, "//*[@id='account-name']", "Account Name",
				"Account Name is Entered", driver);
		Thread.sleep(2000);
		driver.findElement(By.id("security-code")).sendKeys("3433");
		field_statustracker(br, "//*[@id='security-code']", "Enter Security Code",
				"Security Code is Entered", driver);
		Thread.sleep(2000);
		driver.findElement(By.id("address")).sendKeys("4th cross");
		field_statustracker(br, "//*[@id='address']", "Enter Address",
				"Address is Entered", driver);
		Thread.sleep(2000);
		driver.findElement(By.id("apt-type")).sendKeys("#10");
		field_statustracker(br, "//*[@id='apt-type']", "Enter apt type",
				"Apt Type is Entered", driver);
		Thread.sleep(2000);
		driver.findElement(By.id("city")).sendKeys("nyc");
		field_statustracker(br, "//*[@id='city']", "Enter City", "City is Entered",
				driver);
		Thread.sleep(2000);
		driver.findElement(By.id("zip-code")).sendKeys("23456");
		field_statustracker(br, "//*[@id='zip-code']", "Enter Zip-Code",
				"Zip Code is Entered", driver);
		Thread.sleep(2000);

		WebElement mywe_select_pro_2 = driver.findElement(By
				.xpath("//*[@id='current-provider-state-billing']"));
		mywe_select_pro_2.click();
		List<WebElement> my_li_2 = mywe_select_pro_2.findElements(By
				.tagName("option"));

		int size_drop_2 = my_li_2.size();

		for (int i = 0; i < size_drop_2; i++) {
			if (my_li_2.get(i).getText().equals("Alaska")) {
				my_li_2.get(i).sendKeys("Alaska");
				field_statustracker(br, 
						"//*[@id='current-provider-state-billing']",
						"Select Current Provider Billing State",
						"Billing provider state is Entered", driver);
				break;
			}

		}

		logger.info("**********************************");

		Thread.sleep(1000);

		driver.findElement(By.cssSelector("form > div.continue > a")).click();
		Thread.sleep(5000);
		logger.info("Continue clicked");
		
		// enter first name

		driver.findElement(By.xpath("//*[@id='tpv-choose-TWC']")).click();

		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='full-name1']")).sendKeys(
				"Wideband");
		field_statustracker(br, "//*[@id='full-name1']", " Enter Full Name",
				"Full Name of user is Entered", driver);
		Thread.sleep(5000);

		WebElement my_select_birthmonth = driver.findElement(By
				.xpath("//*[@id='birth-month']"));
		my_select_birthmonth.click();
		List<WebElement> my_li_bm = my_select_birthmonth.findElements(By
				.tagName("option"));

		int size_drop_bm = my_li_bm.size();
		logger.info(Integer.toString(size_drop_bm));
		for (int i = 0; i < size_drop_bm; i++) {
			if (my_li_bm.get(i).getText().equals("June")) {
				my_li_bm.get(i).sendKeys("June");
				field_statustracker(br, "//*[@id='birth-month']", "Select Month",
						"Month is Selected", driver);
				break;
			}

		}
		Thread.sleep(2000);

		WebElement my_select_birthday = driver.findElement(By
				.xpath("//*[@id='birth-date']"));
		my_select_birthday.click();
		List<WebElement> my_li_bd = my_select_birthday.findElements(By
				.tagName("option"));

		int size_drop_bd = my_li_bd.size();
		logger.info(Integer.toString(size_drop_bd));

		for (int i = 0; i < size_drop_bd; i++) {
			if (my_li_bd.get(i).getText().equals("5")) {
				my_li_bd.get(i).sendKeys("5");
				field_statustracker(br, "//*[@id='birth-date']",
						"Birth date is selected", "Birth Date is Entered",
						driver);
				break;
			}

		}
		Thread.sleep(2000);
		WebElement my_select_birthyear = driver.findElement(By
				.xpath("//*[@id='birth-year']"));
		my_select_birthyear.click();
		List<WebElement> my_li_by = my_select_birthyear.findElements(By
				.tagName("option"));

		int size_drop_by = my_li_by.size();
		logger.info(Integer.toString(size_drop_by));
		for (int i = 0; i < size_drop_by; i++) {
			if (my_li_by.get(i).getText().equals("1950")) {
				my_li_by.get(i).sendKeys("1950");
				field_statustracker(br, "//*[@id='birth-year']", "Select Year",
						"Birth year is selected", driver);
				break;
			}

		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='full-name2']")).sendKeys(
				"Wideband");
		field_statustracker(br, "//*[@id='full-name2']", "Enter Full Name",
				"Full Name is Entered", driver);

		Thread.sleep(2000);
		driver.findElement(By.cssSelector("span.arrow")).click();
		logger.info("clicked continue button on config page");

		Thread.sleep(8000);
		logger.info("review page");
	}

	public void transfer_number_1(String br,WebDriver driver) throws InterruptedException {
		// Click Feature options

		click_PrivateListening(driver);
		Thread.sleep(8000);
		config_page_Cart_result_updater_1(br,driver);
		page_Cart_One_Time_charge_updater_1(br,driver);
		Thread.sleep(2000);

		click_VoiceMail(driver);
		Thread.sleep(2000);
		config_page_Cart_result_updater_1(br,driver);
		page_Cart_One_Time_charge_updater_1(br,driver);
		Thread.sleep(2000);

		click_GlobalPenny(driver);
		Thread.sleep(8000);
		config_page_Cart_result_updater_1(br,driver);
		page_Cart_One_Time_charge_updater_1(br,driver);
		Thread.sleep(3000);

		// click International plan option
		click_International(br,driver);
		Thread.sleep(2000);
		config_page_Cart_result_updater_1(br,driver);
		page_Cart_One_Time_charge_updater_1(br,driver);
		Thread.sleep(3000);

		// Compare Plan Page check
		driver.findElement(
				By.xpath("//*[@class='modal modalGeneric js-modal-initialized']"))
				.click();
		logger.info("two");

		Thread.sleep(10000);

		String modal_title = driver.findElement(
				By.xpath("//*[@class='modal-title']")).getText();
		if (modal_title.equalsIgnoreCase("International Calling Rates")) {
			statusTracker(br,driver, "Pass", "Click on Compare Plan link",
					"Compare Plan link is clicked",
					"Compare plan link should be clicked");
			logger.info("tHREE" + "");
		} else {
			statusTracker(br,driver, "Fail", "Click on Compare Plan link",
					"Compare Plan link is not clicked",
					"Compare plan link should be clicked");
		}

		driver.findElement(By.xpath("//*[@class='modal-button-close']"))
				.click();
		Thread.sleep(5000);

		String Act_config = driver
				.findElement(
						By.xpath("//*[@class='text parbase sectionHeader twc-plain-text']"))
				.getText();
		if (Act_config
				.equalsIgnoreCase("Select Optional Features & Calling Plans")) {
			statusTracker(br,driver, "Pass", "Click on close button of Compare Plan",
					"Compare Plan gets closed",
					"Compare plan should get closed");
		} else {
			statusTracker(br,driver, "Fail", "Click on close button of Compare Plan",
					"Compare Plan does not gets closed",
					"Compare plan should get closed");
		}

		Thread.sleep(5000);

		// Click Continue to next plan
		click_element(".//*[@class='content-wrap']/div[9]/a", driver);
		Thread.sleep(7000);
		if (driver.findElement(By.id("js-phoneNumber-new")).isDisplayed()
				&& driver.findElement(By.id("js-phoneNumber-transfer"))
						.isDisplayed())

		{
			Thread.sleep(2000);
			statusTracker(br,driver, 
					"Pass",
					"Check for Add new number and transfer existing number options",
					"Both options are present",
					"BOth options should be present");
		} else {
			statusTracker(br,driver, 
					"Fail",
					"Check for Add new number and transfer existing number options",
					"Just one options is present",
					"Both options should be present");
		}

		click_element("//*[@id='js-phoneNumber-transfer']", driver);
		Thread.sleep(5000);
		if (driver.findElement(
				By.xpath("//*[@class='transfer-number general-form']"))
				.isDisplayed()) {
			statusTracker(br,driver, "Pass",
					"Transfer number general form gets displayed",
					"Transfer number general form is displayed",
					"Transfer number general form should be displayed");
		} else {
			statusTracker(br,driver, "Fail",
					"Transfer number general form gets displayed",
					"Transfer number general form is not displayed",
					"Transfer number general form should be displayed");
		}

		logger.info("started");

		// for currentProvider

		Thread.sleep(2000);
		WebElement mywe_select_pro = driver.findElement(By
				.xpath("//*[@id='currentProvider']"));
		logger.info("first");
		mywe_select_pro.click();
		Thread.sleep(2000);
		logger.info("second");
		List<WebElement> my_li = mywe_select_pro.findElements(By
				.tagName("option"));
		// logger.info("my_li is "+my_li);
		int size_drop = my_li.size();

		// mywe_select_pro.sendKeys(my_li.get(2).getText());

		for (int i = 0; i < size_drop; i++) {
			if (my_li.get(i).getText().equals("CIMCO")) {
				my_li.get(i).sendKeys("CIMCO");
				field_statustracker(br, "//*[@id='currentProvider']",
						"Select Current Provider ",
						"Current Provider is Selected", driver);
				break;
			}

		}

		Thread.sleep(4000);

		// For current-provider-state

		WebElement mywe_select_pro_1 = driver.findElement(By
				.xpath("//*[@id='current-provider-state']"));

		logger.info("first");
		Thread.sleep(2000);
		mywe_select_pro_1.click();
		logger.info("second");
		Thread.sleep(2000);
		List<WebElement> my_li_1 = mywe_select_pro_1.findElements(By
				.tagName("option"));

		int size_drop_1 = my_li_1.size();
		for (int i = 0; i < size_drop_1; i++) {
			if (my_li_1.get(i).getText().equals("Hawaii")) {
				my_li_1.get(i).sendKeys("Hawaii");
				field_statustracker(br, "//*[@id='current-provider-state']",
						"Select Current Provider State",
						"Current Provider state is Selected", driver);
				break;
			}
		}

		driver.findElement(By.xpath("//*[@id='phone-number']")).sendKeys(
				"123-876-7678");
		Thread.sleep(2000);
		field_statustracker(br, "//*[@id='phone-number']", "Enter Phone Number",
				"Phone number is Entered", driver);
		Thread.sleep(2000);
		driver.findElement(By.id("account-number")).sendKeys("23456745");
		Thread.sleep(2000);
		field_statustracker(br, "//*[@id='account-number']",
				"Enter Account Number", "Account Number is Entered", driver);
		Thread.sleep(2000);
		driver.findElement(By.id("account-name")).sendKeys("Dani");
		field_statustracker(br, "//*[@id='account-name']", "Account Name",
				"Account Name is Entered", driver);
		Thread.sleep(2000);
		driver.findElement(By.id("security-code")).sendKeys("3433");
		field_statustracker(br, "//*[@id='security-code']", "Enter Security Code",
				"Security Code is Entered", driver);
		Thread.sleep(2000);
		driver.findElement(By.id("address")).sendKeys("4th cross");
		field_statustracker(br, "//*[@id='address']", "Enter Address",
				"Address is Entered", driver);
		Thread.sleep(2000);
		driver.findElement(By.id("apt-type")).sendKeys("#10");
		field_statustracker(br, "//*[@id='apt-type']", "Enter apt type",
				"Apt Type is Entered", driver);
		Thread.sleep(2000);
		driver.findElement(By.id("city")).sendKeys("nyc");
		field_statustracker(br, "//*[@id='city']", "Enter City", "City is Entered",
				driver);
		Thread.sleep(2000);
		driver.findElement(By.id("zip-code")).sendKeys("23456");
		field_statustracker(br, "//*[@id='zip-code']", "Enter Zip-Code",
				"Zip Code is Entered", driver);
		Thread.sleep(2000);

		WebElement mywe_select_pro_2 = driver.findElement(By
				.xpath("//*[@id='current-provider-state-billing']"));
		mywe_select_pro_2.click();
		List<WebElement> my_li_2 = mywe_select_pro_2.findElements(By
				.tagName("option"));

		int size_drop_2 = my_li_2.size();

		for (int i = 0; i < size_drop_2; i++) {
			if (my_li_2.get(i).getText().equals("Alaska")) {
				my_li_2.get(i).sendKeys("Alaska");
				field_statustracker(br, 
						"//*[@id='current-provider-state-billing']",
						"Select Current Provider Billing State",
						"Billing provider state is Entered", driver);
				break;
			}

		}

		logger.info("**********************************");

		Thread.sleep(1000);

		driver.findElement(By.cssSelector("form > div.continue > a")).click();
		Thread.sleep(5000);
		logger.info("Continue clicked");
		// enter first name

		driver.findElement(By.xpath("//*[@id='tpv-choose-TWC']")).click();

		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='full-name1']")).sendKeys(
				"Wideband");
		field_statustracker(br, "//*[@id='full-name1']", " Enter Full Name",
				"Full Name of user is Entered", driver);
		Thread.sleep(5000);

		WebElement my_select_birthmonth = driver.findElement(By
				.xpath("//*[@id='birth-month']"));
		my_select_birthmonth.click();
		List<WebElement> my_li_bm = my_select_birthmonth.findElements(By
				.tagName("option"));

		int size_drop_bm = my_li_bm.size();
		logger.info(Integer.toString(size_drop_bm));
		for (int i = 0; i < size_drop_bm; i++) {
			if (my_li_bm.get(i).getText().equals("June")) {
				my_li_bm.get(i).sendKeys("June");
				field_statustracker(br, "//*[@id='birth-month']", "Select Month",
						"Month is Selected", driver);
				break;
			}

		}
		Thread.sleep(2000);

		WebElement my_select_birthday = driver.findElement(By
				.xpath("//*[@id='birth-date']"));
		my_select_birthday.click();
		List<WebElement> my_li_bd = my_select_birthday.findElements(By
				.tagName("option"));

		int size_drop_bd = my_li_bd.size();
		logger.info(Integer.toString(size_drop_bd));

		for (int i = 0; i < size_drop_bd; i++) {
			if (my_li_bd.get(i).getText().equals("5")) {
				my_li_bd.get(i).sendKeys("5");
				field_statustracker(br, "//*[@id='birth-date']",
						"Birth date is selected", "Birth Date is Entered",
						driver);
				break;
			}

		}
		Thread.sleep(2000);
		WebElement my_select_birthyear = driver.findElement(By
				.xpath("//*[@id='birth-year']"));
		my_select_birthyear.click();
		List<WebElement> my_li_by = my_select_birthyear.findElements(By
				.tagName("option"));

		int size_drop_by = my_li_by.size();
		logger.info(Integer.toString(size_drop_by));
		for (int i = 0; i < size_drop_by; i++) {
			if (my_li_by.get(i).getText().equals("1950")) {
				my_li_by.get(i).sendKeys("1950");
				field_statustracker(br, "//*[@id='birth-year']", "Select Year",
						"Birth year is selected", driver);
				break;
			}

		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='full-name2']")).sendKeys(
				"Wideband");
		field_statustracker(br, "//*[@id='full-name2']", "Enter Full Name",
				"Full Name is Entered", driver);

		Thread.sleep(2000);
		driver.findElement(By.cssSelector("span.arrow")).click();
		logger.info("clicked continue button on config page");

		Thread.sleep(8000);
		logger.info("review page");
	}

	// functions adeed by manju - Old one

	/*
	 * public void config_page_Cart_result_updater(WebDriver driver) throws
	 * InterruptedException { logger.info("Manju function is called");
	 * int jk; logger.info("line 1"); // String itemname[]=new
	 * String[15]; logger.info("line 2");
	 * 
	 * logger.info("line 3"); List<WebElement> myli4=
	 * driver.findElements(By.xpath(
	 * "//html/body/section/div[2]/div[2]/div/div/div/div/div[2]/section/div/div/section/div/table/tbody/tr"
	 * )); logger.info("line 4"); carttotal=myli4.size();
	 * logger.info("line 5");
	 * logger.info("cartaotl is "+carttotal); for
	 * (jk=0;jk<carttotal;jk++) {
	 * 
	 * 
	 * itemname[jk]=driver.findElement(By.xpath(
	 * "//html/body/section/div[2]/div[2]/div/div/div/div/div[2]/section/div/div/section/div/table/tbody/tr["
	 * +(jk+1)+"]/td[1]")).getText(); itemcost[jk]=driver.findElement(By.xpath(
	 * "//html/body/section/div[2]/div[2]/div/div/div/div/div[2]/section/div/div/section/div/table/tbody/tr["
	 * +(jk+1)+"]/td[2]")).getText();
	 * logger.info(" eqipment cost is:"+itemcost[jk]);
	 * logger.info(" eqipment name is:"+itemname[jk]);
	 * statusTracker(br,driver, " ","cart details",
	 * "eqipment name is: "+itemname[jk]+" and item cost is: "
	 * +itemcost[jk],"selected eqipment should be added to cart"); if
	 * ((itemcost[jk]).trim().equals("Free")) { itemcost[jk]="0"; }
	 * 
	 * }
	 * 
	 * int equipandtotal=0; for(int m=0;m<carttotal;m++) {
	 * 
	 * String temp=itemcost[m].replaceAll("[^0-9]","");
	 * equipandtotal+=Integer.parseInt(temp);
	 * 
	 * }
	 * 
	 * String equipandtotalstring=String.valueOf(equipandtotal);
	 * equipandtotalstring
	 * =equipandtotalstring.substring(0,equipandtotalstring.length
	 * ()-2)+"."+equipandtotalstring.substring(equipandtotalstring.length()-2);
	 * equipandtotalstring="$"+equipandtotalstring;
	 * logger.info("equipandtotalstring is "+equipandtotalstring);
	 * 
	 * 
	 * if(driver.findElement(By.xpath(
	 * "//html/body/section/div[2]/div[2]/div/div/div/div/div[2]/section/div/table/tbody/tr/td[2]"
	 * )).isDisplayed()) {
	 * if(equipandtotalstring.equals(driver.findElement(By.xpath(
	 * "//html/body/section/div[2]/div[2]/div/div/div/div/div[2]/section/div/table/tbody/tr/td[2]"
	 * )).getText())) { statusTracker(br,driver, "Pass",
	 * "Verify if the Eqipment added to the cart adds up to the total"
	 * ,"The euipment added to the cart adds up to the total"
	 * ,"The items added to the cart  total"); } else { statusTracker(br,driver, "Fail",
	 * "Verify if the items added to the cart adds up to the total"
	 * ,"The items added to the cart does not add up to the total. Actual: "
	 * +driver.findElement(By.xpath(
	 * "//html/body/section/div[2]/div[2]/div/div/div/div/div/div[2]/section/div/table/tbody/tr/td[2]"
	 * )).getText() +" Expected: "+equipandtotalstring,
	 * "The items added to the cart does not add up to the total"); } } else {
	 * if(equipandtotalstring.equals(driver.findElement(By.xpath(
	 * "//html/body/section/div[2]/div[2]/div/div/div/div/div/div[2]/section/div/table/tbody/tr/td[2]"
	 * )).getText())) { logger.info("ENtered inside the else3a loop");
	 * statusTracker
	 * ("Pass","Verify if the Euipment added to the cart adds up to the total"
	 * ,"The items added to the cart adds up to the total"
	 * ,"The items added to the cart  add up to the total"); } else {
	 * statusTracker
	 * ("Fail","Verify if the items added to the cart adds up to the total"
	 * ,"The items added to the cart does not add up to the total. Actual: "
	 * +driver.findElement(By.xpath(
	 * "//html/body/section/div[2]/div[2]/div/div/div/div/div[2]/section/div/table/tbody/tr/td[2]"
	 * )).getText() +" Expected: "+equipandtotalstring,
	 * "The items added to the cart does not add up to the total"); } }
	 * 
	 * Thread.sleep(4000);
	 * 
	 * 
	 * 
	 * 
	 * }
	 */

	public void page_Cart_One_Time_charge_updater(String br,WebDriver driver)
			throws InterruptedException {
		int mon_total_items = return_size(
				".//*[@id='content']/div[2]/div[2]/div/div[1]/div/div/div[2]/section/div[2]/section/table/tbody/tr",
				driver);
		logger.info(Integer.toString(mon_total_items));

		for (int i = 1; i <= mon_total_items; i++)

		{
			itemname_mon[i] = return_text(
					"//*[@id='content']/div[2]/div[2]/div/div[1]/div/div/div[2]/section/div[2]/section/table/tbody/tr["
							+ i + "]/td[1]", driver);
			itemcost_mon[i] = return_text(
					"//*[@id='content']/div[2]/div[2]/div/div[1]/div/div/div[2]/section/div[2]/section/table/tbody/tr["
							+ i + "]/td[2]", driver);
			logger.info(" Service cost is:" + itemcost_mon[i]);
			logger.info(" Serivce name is:" + itemname_mon[i]);
			statusTracker(br,driver, " ", "cart details", "Service name is: "
					+ itemname_mon[i] + " and Service cost is: "
					+ itemcost_mon[i],
					"selected service should be updated in one time charge section");
		}
		mon_total = return_text(
				"//*[@id='content']/div[2]/div[2]/div/div[1]/div/div/div[2]/section/table/tbody/tr/td[2]",
				driver);
		statusTracker(br,driver, " ", "cart details", "Monthly one time charges is "
				+ mon_total, "one time charge should be updated in cart");
	}

	

	// *****************************************************************
	// Internet LOB****************************************

	public void I_will_use_my_modem(WebDriver driver)
			throws InterruptedException {
		logger.info("CLick on i will use my modem arrow");
		driver.findElement(
				By.xpath("//*[@id='js-main-form']/div[2]/div[3]/header/ul/li[1]/a"))
				.click();
		Thread.sleep(2000);
		driver.findElement(
				By.xpath("//*[@id='js-main-form']/div[2]/div[3]/header/ul/li[1]/a"))
				.click();
		logger.info("Click on Radio_I WILL USE MY MODEM");
		driver.findElement(By.xpath("//*[@id='1-29PI']")).click();
		logger.info("Radio I WILL USE MY MODEM Clicked ");
	}

	public void HomeWiFi_InternetModem(WebDriver driver)
			throws InterruptedException {
		logger.info("CLick on HomeWiFi_InternetModem arrow");
		driver.findElement(
				By.xpath("//*[@id='js-main-form']/div[2]/div[2]/header/ul/li[1]/a"))
				.click();
		Thread.sleep(2000);
		driver.findElement(
				By.xpath("//*[@id='js-main-form']/div[2]/div[2]/header/ul/li[1]/a"))
				.click();
		logger.info("Click on Radio_HomeWiFi_InternetModem");
		driver.findElement(By.xpath("//*[@id='1-29P7']")).click();
		logger.info("Radio HomeWiFi_InternetModem Clicked ");

	}

	public void InternetModem(WebDriver driver) throws InterruptedException {
		logger.info("CLick on InternetModem arrow");
		driver.findElement(
				By.xpath("//*[@id='js-main-form']/div[2]/div[1]/header/ul/li[1]/a"))
				.click();
		Thread.sleep(2000);
		driver.findElement(
				By.xpath("//*[@id='js-main-form']/div[2]/div[1]/header/ul/li[1]/a"))
				.click();
		logger.info("Click on Radio_InternetModem");
		driver.findElement(By.xpath("//*[@id='1-29OW']")).click();
		logger.info("Radio InternetModem Clicked ");

	}

	// Latest
	public void Internet_ReviewOrder_ChkMonthlyCharges(String br,WebDriver drive) {
		logger.info("rpage 1");
		String reviewcartname[] = new String[10];
		String reviewcartcost[] = new String[10];
		int reviewcartoptions = 0;
		for (int i = 2; i < carttotal + 2; i++) {

			if (isElementPresent(
					"//*[@id='content']/div[3]/div[2]/div[2]/div/div/div/div/div[1]/table/tbody/tr["
							+ i + "]/td[1]", drive)) {
				reviewcartoptions++;
				logger.info(i + " yess");
			}
		}

		for (int i = 1; i <= reviewcartoptions; i++) {
			reviewcartname[i - 1] = return_text(
					"//*[@id='content']/div[3]/div[2]/div[2]/div/div/div/div/div[1]/table/tbody/tr["
							+ (i + 1) + "]/td[1]", drive);

			System.out
					.println("name "
							+ return_text(
									"//section[@id='content']/div[3]/div[2]/div[2]/div/div/div/div/div[1]/table/tbody/tr["
											+ (i + 1) + "]/td[1]", drive));
			reviewcartcost[i - 1] = return_text(
					"//*[@id='content']/div[3]/div[2]/div[2]/div/div/div/div/div[1]/table/tbody/tr["
							+ (i + 1) + "]/td[2]", drive);
			if (reviewcartcost[i - 1].length() > 10) {
				int index = reviewcartcost[i - 1].indexOf(" ");
				logger.info("index: " + index);
				reviewcartcost[i - 1] = reviewcartcost[i - 1].substring(0,
						index);
			}
			// section[@id='content']/div[3]/div[2]/div[2]/div/div/div/div/div[1]/table/tbody/tr["+(i+1)+"]/td[2]
			System.out
					.println("cost in Review Your New Services is : "
							+ return_text(
									"//section[@id='content']/div[3]/div[2]/div[2]/div/div/div/div/div[1]/table/tbody/tr["
											+ (i + 1) + "]/td[2]", drive));

		}
		int judge = -1;
		logger.info("rpage 4");
		for (int i = 0; i < reviewcartoptions; i++) {
			logger.info("Item Details : " + itemname[i] + " - "
					+ itemcost[i]);
			logger.info("Review Details : " + reviewcartname[i] + " - "
					+ reviewcartcost[i]);
			if (itemname[i].equals(reviewcartname[i])
					&& itemcost[i].equals(reviewcartcost[i])) {
				// judge=0;
				logger.info("rpage 4.2");
			} else {
				logger.info("rpage 4.3");
				// i=100;
				judge = i;
				i = 100;
			}

		}
		logger.info("rpage 5: " + judge);
		if (judge >= 0)
			statusTracker(br,drive, 
					"Fail",
					"Verify if the review order section is in sync with the items chosen",
					"Items are not proper. Item: " + judge
							+ " is incorrect. Expected: " + itemname[judge]
							+ " " + itemcost[judge] + " Actual: "
							+ reviewcartname[judge] + " "
							+ reviewcartcost[judge],
					"Items should be the same as chosen");

		else
			statusTracker(br,drive, 
					"Pass",
					"Verify if the review order section is in sync with the items chosen",
					"Items are as chosen from the cart",
					"Items should be the same as chosen");
		int cartcost[] = new int[10];
		int total = 0;
		String strtotal;
		logger.info("k-2");
		for (int i = 0; i < reviewcartoptions; i++) {
			logger.info("1 " + reviewcartcost[i]);
			String temp = reviewcartcost[i].replaceAll("[^0-9]", "");

			logger.info("1.5 " + temp);
			cartcost[i] = Integer.parseInt(temp);
			logger.info("2" + cartcost[i]);
			total += cartcost[i];
		}
		logger.info("total value is " + total);
		strtotal = String.valueOf(total);
		logger.info("strtotal is " + strtotal);
		strtotal = strtotal.substring(0, strtotal.length() - 2) + "."
				+ strtotal.substring(strtotal.length() - 2);
		logger.info("strtotal1 after convertion is " + strtotal);
		strtotal = "$" + strtotal;
		logger.info("strtotal with $ is " + strtotal);
		logger.info("k0");

		if (strtotal
				.equals(return_text(
						"//*[@id='content']/div[3]/div[2]/div[2]/div/div/div/div/div[1]/table/tfoot/tr/td[2]",
						drive))) {
			statusTracker(br,drive, 
					"Pass",
					"In the Review Order page, verify if the total cost is equal to the cost displayed in the Cart",
					"The totals are the same", "The totals should be the same");
		} else {
			statusTracker(br,drive, 
					"Fail",
					"In the Review Order page, verify if the total cost is equal to the cost displayed in the Cart",
					"The totals are not the same Actual: "
							+ return_text(
									"//*[@id='content']/div[3]/div[2]/div[2]/div/div/div/div/div[1]/table/tfoot/tr/td[2]",
									drive) + " Expected: " + strtotal,
					"The totals should be the same");
		}
	}

	public void Internet_ReviewOrder_ChkOneTimeCharges(String br,WebDriver drive) {
		System.out
				.println("Internet_ReviewOrder_ChkOneTimeCharges - Validating OneTime Charges : "
						+ mon_total_items);
		int Rev_OneTime_CartOptions = 0;

		for (int i = 1; i < mon_total_items + 2; i++) {
			if (isElementPresent(
					".//*[@id='content']/div[3]/div[2]/div[2]/div/div/div/div/div[2]/table/tbody/tr["
							+ i + "]/td[1]", drive)) {
				Rev_OneTime_CartOptions++;
			}
		}
		logger.info("Rev_OneTime_CartOptions : "
				+ Rev_OneTime_CartOptions);
		for (int i = 1; i <= Rev_OneTime_CartOptions; i++) {
			Rev_onetime_ChargesOption[i - 1] = return_text(
					".//*[@id='content']/div[3]/div[2]/div[2]/div/div/div/div/div[2]/table/tbody/tr["
							+ i + "]/td[1]", drive);
			Rev_onetime_ChargesCost[i - 1] = return_text(
					".//*[@id='content']/div[3]/div[2]/div[2]/div/div/div/div/div[2]/table/tbody/tr["
							+ i + "]/td[2]", drive);
			if (Rev_onetime_ChargesCost[i - 1].length() > 10) {
				int index = Rev_onetime_ChargesCost[i - 1].indexOf(" ");
				logger.info("index: " + index);
				Rev_onetime_ChargesCost[i - 1] = Rev_onetime_ChargesCost[i - 1]
						.substring(0, index);
			}
			System.out
					.println("Review_One Time Details Name : "
							+ return_text(
									".//*[@id='content']/div[3]/div[2]/div[2]/div/div/div/div/div[2]/table/tbody/tr["
											+ i + "]/td[1]", drive));
			System.out
					.println("Review_One Time Details Cost : "
							+ return_text(
									".//*[@id='content']/div[3]/div[2]/div[2]/div/div/div/div/div[2]/table/tbody/tr["
											+ i + "]/td[2]", drive));
		}
		int judge = -1;
		logger.info("Review_One Time Charges - 4");
		for (int i = 1; i < Rev_OneTime_CartOptions; i++) {
			logger.info("Review Item Details : " + itemname_mon[i]
					+ " - " + itemcost_mon[i]);
			logger.info("Review Details : "
					+ Rev_onetime_ChargesOption[i] + " - "
					+ Rev_onetime_ChargesCost[i]);
			if (itemname_mon[i].equals(Rev_onetime_ChargesOption[i])
					&& itemcost_mon[i].equals(Rev_onetime_ChargesCost[i])) {
				// judge=0;
				logger.info("One Time Charges - 4.2");
			} else {
				logger.info("One Time Charges - 4.3");
				// i=100;
				judge = i + 1;
				i = 100;
			}

		}
		logger.info("One Time Charges - 5 : " + judge);
		if (judge >= 0)
			statusTracker(br,drive, 
					"Fail",
					"Verify if the review order One Time Charges section is in sync with the items chosen",
					"Items are not proper. Item: " + judge
							+ " is incorrect. Expected: " + itemname_mon[judge]
							+ " " + itemcost_mon[judge] + " Actual: "
							+ Rev_onetime_ChargesOption[judge] + " "
							+ Rev_onetime_ChargesCost[judge],
					"Items should be the same as chosen");
		else
			statusTracker(br,drive, 
					"Pass",
					"Verify if the review order One Time Charges section is in sync with the items chosen",
					"Items are as chosen from the cart",
					"Items should be the same as chosen");
	}

	public void Internet_OrderSummary_ChkMonthlyCharges(String br,WebDriver drive) {
		logger.info("spage 1");
		String summarycartname[] = new String[10];
		String summarycartcost[] = new String[10];
		int summarycartoptions = 0;
		for (int i = 2; i < carttotal + 2; i++) {

			if (isElementPresent(
					"//*[@id='content']/div[3]/div[2]/div[2]/div/div/div/div[1]/div/div/div[1]/table/tbody/tr["
							+ i + "]/td[1]", drive)) {
				summarycartoptions++;
				logger.info(i + " yess");
			}
		}

		for (int i = 1; i <= summarycartoptions; i++) {
			summarycartname[i - 1] = return_text(
					"//*[@id='content']/div[3]/div[2]/div[2]/div/div/div/div[1]/div/div/div[1]/table/tbody/tr["
							+ (i + 1) + "]/td[1]", drive);

			System.out
					.println("name "
							+ return_text(
									"//*[@id='content']/div[3]/div[2]/div[2]/div/div/div/div[1]/div/div/div[1]/table/tbody/tr["
											+ (i + 1) + "]/td[1]", drive));
			summarycartcost[i - 1] = return_text(
					"//*[@id='content']/div[3]/div[2]/div[2]/div/div/div/div[1]/div/div/div[1]/table/tbody/tr["
							+ (i + 1) + "]/td[2]", drive);
			if (summarycartcost[i - 1].length() > 10) {
				int index = summarycartcost[i - 1].indexOf(" ");
				logger.info("index: " + index);
				summarycartcost[i - 1] = summarycartcost[i - 1].substring(0,
						index);
			}
			// section[@id='content']/div[3]/div[2]/div[2]/div/div/div/div/div[1]/table/tbody/tr["+(i+1)+"]/td[2]
			System.out
					.println("cost in summary Your New Services is : "
							+ return_text(
									"//*[@id='content']/div[3]/div[2]/div[2]/div/div/div/div[1]/div/div/div[1]/table/tbody/tr["
											+ (i + 1) + "]/td[2]", drive));

		}
		int judge = -1;
		logger.info("spage 4");
		for (int i = 0; i < summarycartoptions; i++) {
			logger.info("Item Details : " + itemname[i] + " - "
					+ itemcost[i]);
			logger.info("summary Details : " + summarycartname[i]
					+ " - " + summarycartcost[i]);
			if (itemname[i].equals(summarycartname[i])
					&& itemcost[i].equals(summarycartcost[i])) {
				// judge=0;
				logger.info("spage 4.2");
			} else {
				logger.info("spage 4.3");
				// i=100;
				judge = i;
				i = 100;
			}

		}
		logger.info("spage 5: " + judge);
		if (judge >= 0)
			statusTracker(br,drive, 
					"Fail",
					"Verify if the summary order section is in sync with the Review Order Page",
					"Items are not proper. Item: " + judge
							+ " is incorrect. Expected: " + itemname[judge]
							+ " " + itemcost[judge] + " Actual: "
							+ summarycartname[judge] + " "
							+ summarycartcost[judge],
					"Items should be same as it was in the Review Order Page");

		else
			statusTracker(br,drive, 
					"Pass",
					"Verify if the summary order section is in sync with the Review Order Page",
					"Items are same as it was in the Review Order Page",
					"Items should be same as it was in the Review Order Page");
		int cartcost[] = new int[10];
		int total = 0;
		String strtotal;
		logger.info("s-2");
		for (int i = 0; i < summarycartoptions; i++) {
			logger.info("s-1 " + summarycartcost[i]);
			String temp = summarycartcost[i].replaceAll("[^0-9]", "");

			logger.info("s-1.5 " + temp);
			cartcost[i] = Integer.parseInt(temp);
			logger.info("s-2" + cartcost[i]);
			total += cartcost[i];
		}
		logger.info("total value is " + total);
		strtotal = String.valueOf(total);
		logger.info("strtotal is " + strtotal);
		strtotal = strtotal.substring(0, strtotal.length() - 2) + "."
				+ strtotal.substring(strtotal.length() - 2);
		logger.info("strtotal1 after convertion is " + strtotal);
		strtotal = "$" + strtotal;
		logger.info("strtotal with $ is " + strtotal);
		logger.info("k0");

		if (strtotal
				.equals(return_text(
						".//*[@id='content']/div[3]/div[2]/div[2]/div/div/div/div[1]/div/div/div[1]/table/tfoot/tr/td[2]",
						drive))) {
			statusTracker(br,drive, 
					"Pass",
					"In Order Summary page, verify if the total cost is equal to the cost displayed in the Review Order page",
					"The totals are the same", "The totals should be the same");
		} else {
			statusTracker(br,drive, 
					"Fail",
					"Verify if the total cost is equal to the cost displayed in the Review Order page",
					"The totals are not the same Actual: "
							+ return_text(
									".//*[@id='content']/div[3]/div[2]/div[2]/div/div/div/div[1]/div/div/div[1]/table/tfoot/tr/td[2]",
									drive) + " Expected: " + strtotal,
					"The totals should be the same");
		}
	}

	public void Internet_OrderSummary_ChkOneTimeCharges(String br,WebDriver drive) {
		System.out
				.println("Internet_OrderSummary_ChkOneTimeCharges- Validating OneTime Charges : "
						+ mon_total_items);
		String Sum_onetime_ChargesOption[] = new String[10];
		String Sum_onetime_ChargesCost[] = new String[10];
		int Sum_OneTime_CartOptions = 0;

		for (int i = 1; i < mon_total_items + 2; i++) {
			if (isElementPresent(
					".//*[@id='content']/div[3]/div[2]/div[2]/div/div/div/div[1]/div/div/div[2]/table/tbody/tr["
							+ i + "]/td[1]", drive)) {
				Sum_OneTime_CartOptions++;
			}
		}
		logger.info("Sum_OneTime_CartOptions : "
				+ Sum_OneTime_CartOptions);
		for (int i = 1; i <= Sum_OneTime_CartOptions; i++) {
			Sum_onetime_ChargesOption[i - 1] = return_text(
					".//*[@id='content']/div[3]/div[2]/div[2]/div/div/div/div[1]/div/div/div[2]/table/tbody/tr["
							+ i + "]/td[1]", drive);
			Sum_onetime_ChargesCost[i - 1] = return_text(
					".//*[@id='content']/div[3]/div[2]/div[2]/div/div/div/div[1]/div/div/div[2]/table/tbody/tr["
							+ i + "]/td[2]", drive);
			if (Sum_onetime_ChargesCost[i - 1].length() > 10) {
				int index = Sum_onetime_ChargesCost[i - 1].indexOf(" ");
				logger.info("index: " + index);
				Sum_onetime_ChargesCost[i - 1] = Sum_onetime_ChargesCost[i - 1]
						.substring(0, index);
			}
			System.out
					.println("Summary_One Time Details Name : "
							+ return_text(
									".//*[@id='content']/div[3]/div[2]/div[2]/div/div/div/div[1]/div/div/div[2]/table/tbody/tr["
											+ i + "]/td[1]", drive));
			System.out
					.println("Summary_One Time Details Cost : "
							+ return_text(
									".//*[@id='content']/div[3]/div[2]/div[2]/div/div/div/div[1]/div/div/div[2]/table/tbody/tr["
											+ i + "]/td[2]", drive));
		}
		int judge = -1;
		logger.info("Summary_One Time Charges - 4");
		for (int i = 0; i < Sum_OneTime_CartOptions; i++) {
			logger.info("Review Item Details : "
					+ Rev_onetime_ChargesOption[i] + " - "
					+ Rev_onetime_ChargesCost[i]);
			logger.info("Summary Details : "
					+ Sum_onetime_ChargesOption[i] + " - "
					+ Sum_onetime_ChargesCost[i]);
			if (Rev_onetime_ChargesOption[i]
					.equals(Sum_onetime_ChargesOption[i])
					&& Rev_onetime_ChargesCost[i]
							.equals(Sum_onetime_ChargesCost[i])) {
				// judge=0;
				logger.info("Summary One Time Charges - 4.2");
			} else {
				logger.info("Summary One Time Charges - 4.3");
				// i=100;
				judge = i + 1;
				i = 100;
			}

		}
		logger.info("One Time Charges - 5 : " + judge);
		if (judge >= 0) {
			statusTracker(br,drive, 
					"Fail",
					"Verify if the Summary order One Time Charges section is in sync with the Review Order Page",
					"Items are not proper. Item: " + judge
							+ " is incorrect. Expected: "
							+ Rev_onetime_ChargesOption[judge] + " "
							+ Rev_onetime_ChargesCost[judge] + " Actual: "
							+ Sum_onetime_ChargesOption[judge] + " "
							+ Sum_onetime_ChargesCost[judge],
					"Items should be the same as chosen");

		} else
			statusTracker(br,drive, 
					"Pass",
					"Verify if the Summary order One Time Charges section is in sync with the Review Order Page",
					"Items are same as chosen in the Review Order Page",
					"Items should be the same as chosen");
	}

	public void Internet_ReviewOrder_ECKInstallationOptions(String br,
			String ECKOptionName, double oneTimeCharges,WebDriver drive)
			throws InterruptedException {
		InstallationFees = 0.0;
		StoreAddress1 = "";
		StoreAddress2 = "";
		StoreAddress3 = "";
		Equip_text = "";
		ECKOptionSelected = "";
		ECKOptionSelected = ECKOptionName;

		logger.info("Review - ECKOptionSelected : " + ECKOptionSelected);

		if (ECKOptionName.equals("Store")) {
			StoreAddress1 = (return_text(
					"//form[@id='js-main-form']/div/div[2]/section/div/div/div/div[1]",
					drive).replace("See Map", "")).trim();
			StoreAddress2 = (return_text(
					"//form[@id='js-main-form']/div/div[2]/section/div/div/div/div[2]",
					drive).replace("See Map", "")).trim();
			StoreAddress3 = (return_text(
					"//form[@id='js-main-form']/div/div[2]/section/div/div/div/div[3]",
					drive).replace("See Map", "")).trim();

			if (!StoreAddress1.equals(""))
				statusTracker(br,drive, " ", "Address 1: ", StoreAddress1, " ");
			else
				statusTracker(br,drive, "Fail", "Address 1: ",
						"Address 1 is Not Displayed", " ");

			if (!StoreAddress2.equals(""))
				statusTracker(br,drive, " ", "Address 2: ", StoreAddress2, " ");
			else
				statusTracker(br,drive, "Fail", "Address 2: ",
						"Address 2 is Not Displayed", " ");

			if (!StoreAddress3.equals(""))
				statusTracker(br,drive, " ", "Address 3: ", StoreAddress3, " ");
			else
				statusTracker(br,drive, "Fail", "Address 3: ",
						"Address 3 is Not Displayed", " ");

			// For the Store Pick option, the Value Free is verified.
			if ((return_text(".//*[@id='section-pickup']/header/label/span[1]",
					drive).trim()).equals("Free"))
				statusTracker(br,drive, 
						"Pass",
						"For the Store Pick there is NO processing fees",
						return_text(
								".//*[@id='section-pickup']/header/label/span[1]",
								drive)
								+ " is displayed.",
						"No Processing Fee for the Store Pickup");
			else
				statusTracker(br,drive, 
						"Fail",
						"For the Store Pick there is NO processing fees",
						return_text(
								".//*[@id='section-pickup']/header/label/span[1]",
								drive)
								+ " is displayed.",
						"Processing Fee for the Store Pickup Must be always Free");

			InstallationFees = 0.0;

			// For the Store Pick option, the One Time Charges Text is verified.
			if ((return_text(".//*[@class='services-table']/tbody/tr[1]/td[1]",
					drive).trim()).equals("Easy Connect Pick-up Fee"))
				statusTracker(br,drive, 
						"Pass",
						"For the Store Pick option, the One Time Charges Text to be verified",
						return_text(
								".//*[@class='services-table']/tbody/tr[1]/td[1]",
								drive)
								+ " is displayed.",
						"One Time Charges Text is as Expected");
			else
				statusTracker(br,drive, 
						"Fail",
						"For the Store Pick option, the One Time Charges Text to be verified",
						return_text(
								".//*[@class='services-table']/tbody/tr[1]/td[1]",
								drive)
								+ " is displayed.",
						"One Time Charges Text is NOT as Expected");

			if (InstallationFees == Double.parseDouble(return_text(
					".//*[@class='services-table']/tbody/tr[1]/td[2]", drive)
					.replace("$", "").trim()))
				statusTracker(br,drive, 
						"Pass",
						"For the Store Pick option, the One Time Charges charges to be verified",
						return_text(
								".//*[@class='services-table']/tbody/tr[1]/td[2]",
								drive)
								+ " is displayed.",
						"One Time Charges VALUE is as Expected");
			else
				statusTracker(br,drive, 
						"Fail",
						"For the Store Pick option, the One Time Charges charges  to be verified",
						return_text(
								".//*[@class='services-table']/tbody/tr[1]/td[2]",
								drive)
								+ " is displayed.",
						"One Time Charges VALUE is NOT as Expected");

		} else if (ECKOptionName.equals("Mail")) {
			// Hard coded the text, as the contents will not modify
			if (return_text(
					".//*[@id='section-mail']/section/div/div/div/div[1]/ul/li",
					drive).equals("Internet Modem Easy Connect Kit"))
				statusTracker(br,drive, 
						"Pass",
						"Mail Option Content Validation",
						return_text(
								".//*[@id='section-mail']/section/div/div/div/div[1]/ul/li",
								drive),
						" Internet Modem Text is correct under Mail option");
			else
				statusTracker(br,drive, 
						"Fail",
						"Mail Option Content Validation",
						return_text(
								".//*[@id='section-mail']/section/div/div/div/div[1]/ul/li",
								drive),
						" Internet Modem Text is NOT correct under Mail option");

			InstallationFees = Double.parseDouble((return_text(
					".//*[@id='section-mail']/header/label/span[1]", drive)
					.replace("$", "")).trim());
			logger.info("Installation Fees : " + InstallationFees);

			// For the Mail option, the One Time Charges Text is verified.
			if ((return_text(".//*[@class='services-table']/tbody/tr[1]/td[1]",
					drive).trim()).equals("Easy Connect S & H Fee"))
				statusTracker(br,drive, 
						"Pass",
						"For the Mail option, the One Time Charges Text to be verified",
						return_text(
								".//*[@class='services-table']/tbody/tr[1]/td[1]",
								drive)
								+ " is displayed.",
						"One Time Charges Text is as Expected");
			else
				statusTracker(br,drive, 
						"Fail",
						"For the Mail option, the One Time Charges Text to be verified",
						return_text(
								".//*[@class='services-table']/tbody/tr[1]/td[1]",
								drive)
								+ " is displayed.",
						"One Time Charges Text is NOT as Expected");

			if (InstallationFees == Double.parseDouble(return_text(
					".//*[@class='services-table']/tbody/tr[1]/td[2]", drive)
					.replace("$", "").trim()))
				statusTracker(br,drive, 
						"Pass",
						"For the Mail option, the One Time Charges charges to be verified",
						return_text(
								".//*[@class='services-table']/tbody/tr[1]/td[2]",
								drive)
								+ " is displayed.",
						"One Time Charges VALUE is as Expected");
			else
				statusTracker(br,drive, 
						"Fail",
						"For the Mail option, the One Time Charges charges to be verified",
						return_text(
								".//*[@class='services-table']/tbody/tr[1]/td[2]",
								drive)
								+ " is displayed.",
						"One Time Charges VALUE is NOT as Expected");
		} else if (ECKOptionName.equals("TechInstall")) {
			InstallationFees = Double.parseDouble((return_text(
					".//*[@id='section-schedule']/header/label/span[1]", drive)
					.replace("$", "")).trim());
			logger.info("Installation Fees : " + InstallationFees);

			// For the TechInstall option, the One Time Charges Text is
			// verified.
			if ((return_text(".//*[@class='services-table']/tbody/tr[1]/td[1]",
					drive).trim()).equals("Service Installation Fee"))
				statusTracker(br,drive, 
						"Pass",
						"For the Tech Install option, the One Time Charges Text to be verified",
						return_text(
								".//*[@class='services-table']/tbody/tr[1]/td[1]",
								drive)
								+ " is displayed.",
						"One Time Charges Text is as Expected");
			else
				statusTracker(br,drive, 
						"Fail",
						"For the Tech Install option, the One Time Charges Text to be verified",
						return_text(
								".//*[@class='services-table']/tbody/tr[1]/td[1]",
								drive)
								+ " is displayed.",
						"One Time Charges Text is NOT as Expected");

			if (InstallationFees == Double.parseDouble(return_text(
					".//*[@class='services-table']/tbody/tr[1]/td[2]", drive)
					.replace("$", "").trim()))
				statusTracker(br,drive, 
						"Pass",
						"For the Tech Install option, the One Time Charges charges to be verified",
						return_text(
								".//*[@class='services-table']/tbody/tr[1]/td[2]",
								drive)
								+ " is displayed.",
						"One Time Charges VALUE is as Expected");
			else
				statusTracker(br,drive, 
						"Fail",
						"For the Tech Install option, the One Time Charges charges to be verified",
						return_text(
								".//*[@class='services-table']/tbody/tr[1]/td[2]",
								drive)
								+ " is displayed.",
						"One Time Charges VALUE is NOT as Expected");

			Overall_oneTimeCharges = oneTimeCharges + InstallationFees;
			if (Overall_oneTimeCharges == Double.parseDouble(return_text(
					".//*[@title='One Time Charges']/tfoot/tr/td[2]", drive)
					.replace("$", "").trim()))
				statusTracker(br,drive, 
						"Pass",
						"The One Time Charges + ECK Fees is same as displayed in the Review Order page",
						return_text(
								".//*[@title='One Time Charges']/tfoot/tr/td[2]",
								drive)
								+ " is displayed.", "One Time Charges VALUE : "
								+ Overall_oneTimeCharges + " is as Expected");
			else
				statusTracker(br,drive, 
						"Fail",
						"The One Time Charges + ECK Fees is same as displayed in the Review Order page",
						return_text(
								".//*[@title='One Time Charges']/tfoot/tr/td[2]",
								drive)
								+ " is displayed.", "One Time Charges VALUE : "
								+ Overall_oneTimeCharges
								+ " is NOT as Expected");

			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
			Date date = new Date();
			logger.info("Current Date 1: " + dateFormat.format(date));

			int DD_Value = Integer.parseInt(dateFormat.format(date).substring(
					3, 5));
			logger.info("DD Value : " + DD_Value);

			select_Firstchoice_Date( br,DD_Value,drive); 
			Thread.sleep(10000);
			select_Secondchoice_Date( br,DD_Value,drive);
		} else {

		}

		Overall_oneTimeCharges = oneTimeCharges + InstallationFees;
		if (Overall_oneTimeCharges == Double.parseDouble(return_text(
				".//*[@title='One Time Charges']/tfoot/tr/td[2]", drive)
				.replace("$", "").trim()))
			statusTracker(br,drive, 
					"Pass",
					"The One Time Charges + ECK Fees is same as displayed in the Review Order page",
					return_text(
							".//*[@title='One Time Charges']/tfoot/tr/td[2]",
							drive)
							+ " is displayed.", "One Time Charges VALUE : "
							+ Overall_oneTimeCharges + " is as Expected");
		else
			statusTracker(br,drive, 
					"Fail",
					"The One Time Charges + ECK Fees is same as displayed in the Review Order page",
					return_text(
							".//*[@title='One Time Charges']/tfoot/tr/td[2]",
							drive)
							+ " is displayed.", "One Time Charges VALUE : "
							+ Overall_oneTimeCharges + " is NOT as Expected");
	}

	public void Internet_OrderSummary_DetailsValidation(String br,String Cust_Name,
			String Cust_ServiceAddress,WebDriver drive) throws ParseException,
			InterruptedException {
		String Actual_ServiceAddress = "";
		String Expected_ServiceAddress = "";
		String FirstDateTime = "";
		String SecondDateTime = "";
		logger.info("Calling Internet OrderSummary_DetailsValidation");
		logger.info("Order Summary - ECKOptionSelected : "
				+ ECKOptionSelected);
		logger.info("Order Summary - Overall_oneTimeCharges : "
				+ Overall_oneTimeCharges);
		logger.info("Order Summary - Cust_ServiceAddress : "
				+ Cust_ServiceAddress);

		if (ECKOptionSelected.equals("Store")) {
			logger.info(return_text(
					".//*[@class='services-table']/tbody/tr[1]/td[1]", drive)
					.trim());
			if ((return_text(".//*[@class='services-table']/tbody/tr[1]/td[1]",
					drive).trim()).equals("Easy Connect Pick-up Fee"))
				statusTracker(br,drive, 
						"Pass",
						"For the Store Pick option, the One Time Charges Text to be verified in the Order Summary Page",
						return_text(
								".//*[@class='services-table']/tbody/tr[1]/td[1]",
								drive)
								+ " is displayed.",
						"One Time Charges Text is as Expected");
			else
				statusTracker(br,drive, 
						"Fail",
						"For the Store Pick option, the One Time Charges Text to be verified",
						return_text(
								".//*[@class='services-table']/tbody/tr[1]/td[1]",
								drive)
								+ " is displayed.",
						"One Time Charges Text is NOT as Expected");

			if (InstallationFees == Double.parseDouble(return_text(
					".//*[@class='services-table']/tbody/tr[1]/td[2]", drive)
					.replace("$", "").trim()))
				statusTracker(br,drive, 
						"Pass",
						"For the Store Pick option, the One Time Charges charges to be verified in the Order Summary Page",
						return_text(
								".//*[@class='services-table']/tbody/tr[1]/td[2]",
								drive)
								+ " is displayed.",
						"One Time Charges VALUE is as Expected");
			else
				statusTracker(br,drive, 
						"Fail",
						"For the Store Pick option, the One Time Charges charges  to be verified in the Order Summary Page",
						return_text(
								".//*[@class='services-table']/tbody/tr[1]/td[2]",
								drive)
								+ " is displayed.",
						"One Time Charges VALUE is NOT as Expected");

			if (StoreAddress1.equals(return_text(
					".//*[@class='three-col']/li[1]", drive).trim()))
				statusTracker(br,drive, 
						"Pass",
						"Both Addresses 1 in Review & Summary Order page should be same",
						return_text(".//*[@class='three-col']/li[1]", drive),
						"Both Addresses 1 in Review & Summary Order page are same");
			else
				statusTracker(br,drive, 
						"Fail",
						"Both Addresses 1 in Review & Summary Order page should be same",
						return_text(".//*[@class='three-col']/li[1]", drive),
						"Both Addresses 1 in Review & Summary Order page are NOT same");

			if (StoreAddress2.equals(return_text(
					".//*[@class='three-col']/li[2]", drive).trim()))
				statusTracker(br,drive, 
						"Pass",
						"Both Addresses 2 in Review & Summary Order page should be same",
						return_text(".//*[@class='three-col']/li[2]", drive),
						"Both Addresses 2 in Review & Summary Order page are same");
			else
				statusTracker(br,drive, 
						"Fail",
						"Both Addresses 2 in Review & Summary Order page should be same",
						return_text(".//*[@class='three-col']/li[2]", drive),
						"Both Addresses 2 in Review & Summary Order page are NOT same");

			if (StoreAddress3.equals(return_text(
					".//*[@class='three-col']/li[3]", drive).trim()))
				statusTracker(br,drive, 
						"Pass",
						"Both Addresses 3 in Review & Summary Order page should be same",
						return_text(".//*[@class='three-col']/li[3]", drive),
						"Both Addresses 3 in Review & Summary Order page are same");
			else
				statusTracker(br,drive, 
						"Fail",
						"Both Addresses 3 in Review & Summary Order page should be same",
						return_text(".//*[@class='three-col']/li[3]", drive),
						"Both Addresses 3 in Review & Summary Order page are NOT same");

			Equip_text = return_text(".//*[@class='rtf']/ul/li", drive).trim();
		} else if (ECKOptionSelected.equals("Mail")) {
			Equip_text = return_text(".//*[@class='col rtf']/ul/li", drive)
					.trim();
		} else if (ECKOptionSelected.equals("TechInstall")) {
			if ((return_text(
					".//*[@class='paragraphMerge installationLOB1']/p/strong[1]",
					drive).trim()).equals("Internet")
					&& (return_text(
							".//*[@class='paragraphMerge installationLOB1']/p/strong[2]",
							drive).trim()).equals("Installation Preferences:")) {
				// logger.info("Phone Text 1 : "+return_text(".//*[@class='paragraphMerge installationLOB1']/p/strong[1]",
				// drive).trim());
				// logger.info("Phone Text 2 : "+return_text(".//*[@class='paragraphMerge installationLOB1']/p/strong[2]",
				// drive).trim());
				statusTracker(br,drive, 
						"Pass",
						"The Internet Text details in the Order Summary page to be verified",
						"The Internet Text details is verified.",
						"The Internet Text details is as Expected.");
			} else
				statusTracker(br,drive, 
						"Fail",
						"The Internet Text details in the Order Summary page to be verified",
						"The Internet Text details is verified & text is NOT appropriate.",
						"The Internet Text details is NOT as Expected.");

			System.out
					.println("First Date & Time : "
							+ return_text(
									".//*[@class='paragraphMerge firstVisitSchedule1']/p",
									drive).replace(":00", "").trim());
			System.out
					.println("Second Date & Time : "
							+ return_text(
									".//*[@class='firstVisitSchedule2 paragraphMerge']/p",
									drive).replace(":00", "").trim());

			FirstDateTime = OrderSummary_DateTimeFormat(FirstChoiceDate)
					+ " - " + FirstChoiceTime;
			logger.info("FirstDateTime : " + FirstDateTime);
			System.out
					.println("Actual Text :"
							+ return_text(
									".//*[@class='paragraphMerge firstVisitSchedule1']/p",
									drive));

			if (FirstDateTime.equals(return_text(
					".//*[@class='paragraphMerge firstVisitSchedule1']/p",
					drive).replace(":00", "").replace("Your First Choice:", "")
					.trim()))
				statusTracker(br,drive, 
						"Pass",
						"Order Summary Page - Validation First Install Date & Time Details.",
						return_text(
								".//*[@class='paragraphMerge firstVisitSchedule1']/p",
								drive).replace(":00", "")
								.replace("Your First Choice:", "").trim(),
						"First Install Date & Time Details are same, as per the Review Order page");
			else
				statusTracker(br,drive, 
						"Fail",
						"Order Summary Page - Validation First Install Date & Time Details.",
						return_text(
								".//*[@class='paragraphMerge firstVisitSchedule1']/p",
								drive).replace(":00", "")
								.replace("Your First Choice:", "").trim(),
						"First Install Date & Time Details are NOT same, as per the Review Order page");

			SecondDateTime = OrderSummary_DateTimeFormat(SecondChoiceDate)
					+ " - " + SecondChoiceTime;
			logger.info("SecondDateTime : " + SecondDateTime);
			if (SecondDateTime.equals(return_text(
					".//*[@class='firstVisitSchedule2 paragraphMerge']/p",
					drive).replace(":00", "")
					.replace("Your Second Choice:", "").trim()))
				statusTracker(br,drive, 
						"Pass",
						"Order Summary Page - Validation Second Install Date & Time Details.",
						return_text(
								".//*[@class='firstVisitSchedule2 paragraphMerge']/p",
								drive).replace(":00", "")
								.replace("Your Second Choice:", "").trim(),
						"Second Install Date & Time Details are same, as per the Review Order page");
			else
				statusTracker(br,drive, 
						"Fail",
						"Order Summary Page - Validation Second Install Date & Time Details.",
						return_text(
								".//*[@class='firstVisitSchedule2 paragraphMerge']/p",
								drive).replace(":00", "")
								.replace("Your Second Choice:", "").trim(),
						"Second Install Date & Time Details are NOT same, as per the Review Order page");
		} else {

		}
		logger.info("Equip Text : " + Equip_text);
		if (ECKOptionSelected.equals("Store")
				|| ECKOptionSelected.equals("Mail")) {
			if (Equip_text.equals("Internet Modem Easy Connect Kit"))
				statusTracker(br,drive, "Pass", "Order Summary Page - "
						+ ECKOptionSelected + " Option Content Validation",
						Equip_text,
						" Internet Equipment Text is correct under "
								+ ECKOptionSelected + " option");
			else
				statusTracker(br,drive, "Fail", "Order Summary Page - "
						+ ECKOptionSelected + " Option Content Validation",
						Equip_text,
						" Internet Equipment Text is NOT correct under "
								+ ECKOptionSelected + " option");
		}
		if (Overall_oneTimeCharges == Double.parseDouble(return_text(
				".//*[@title='One Time Charges']/tfoot/tr/td[2]", drive)
				.replace("$", "").trim()))
			statusTracker(br,drive, 
					"Pass",
					"The One Time Charges + ECK Fees is same as displayed in the Order Summary page",
					return_text(
							".//*[@title='One Time Charges']/tfoot/tr/td[2]",
							drive)
							+ " is displayed.", "One Time Charges VALUE : "
							+ Overall_oneTimeCharges + " is as Expected");
		else
			statusTracker(br,drive, 
					"Fail",
					"The One Time Charges + ECK Fees is same as displayed in the Order Summary page",
					return_text(
							".//*[@title='One Time Charges']/tfoot/tr/td[2]",
							drive)
							+ " is displayed.", "One Time Charges VALUE : "
							+ Overall_oneTimeCharges + " is NOT as Expected");

		// Validating the Service Address
		Expected_ServiceAddress = Cust_Name + " " + Cust_ServiceAddress;
		Actual_ServiceAddress = return_text(".//*[@class='last']", drive)
				.trim();

		logger.info("Expected_ServiceAddress : "
				+ Expected_ServiceAddress);
		logger.info("Actual_ServiceAddress : " + Actual_ServiceAddress);

		if (Expected_ServiceAddress.equals(Actual_ServiceAddress))
			statusTracker(br,drive, "Pass",
					"Order Summary Page - Validating Service Address",
					Actual_ServiceAddress,
					"Service Address is same as the Customer Details tagged to the account");
		else
			statusTracker(br,drive, "Fail",
					"Order Summary Page - Validating Service Address",
					Actual_ServiceAddress,
					"Service Address is NOT same as the Customer Details tagged to the account");

		OrderSummary_ChkBrowserBackButton(br,drive);
		Thread.sleep(15000);

		// Selecting the check box for the Terms & Conditions
		logger.info("befor the click");
		drive.findElement(By.xpath(".//*[@name='order-choose-TWC']")).click();
		logger.info("Checkbox clicked....");
	}

	public void Internet_Capture_ReviewOrder_UponChangeinECK() {
		logger.info("Array Output before : 1 :");

		for (int i = 0; i < Rev_onetime_ChargesOption.length; i++) {
			System.out.print(Rev_onetime_ChargesOption[i] + ", ");
		}
		logger.info("Array Output before : 2 : ");
		for (int i = 0; i < Rev_onetime_ChargesCost.length; i++) {
			System.out.print(Rev_onetime_ChargesCost[i] + ", ");
		}

		System.out
				.println("Nithin_Internet_ReviewOrder_ChkOneTimeCharges - Validating OneTime Charges : "
						+ mon_total_items
						+ " - Option Selected : "
						+ ECKOptionSelected);
		int Rev_OneTime_CartOptions = 0;

		for (int i = 1; i < mon_total_items + 2; i++) {
			logger.info("Entering FORRRRRRRRRRRRRRRRRRRRR");
			logger.info("oooooooo : "
					+ isElementPresent(
							".//*[@class='services-table']/tbody/tr[" + i
									+ "]/td[1]", drive));
			logger.info("mmmmmmmm : "
					+ return_text(".//*[@class='services-table']/tbody/tr[" + i
							+ "]/td[1]", drive));
			if (isElementPresent(".//*[@class='services-table']/tbody/tr[" + i
					+ "]/td[1]", drive))
				Rev_OneTime_CartOptions++;
		}
		logger.info("Rev_OneTime_CartOptions : "
				+ Rev_OneTime_CartOptions);
		for (int i = 0; i < Rev_OneTime_CartOptions; i++) {
			Rev_onetime_ChargesOption[i] = return_text(
					".//*[@class='services-table']/tbody/tr[" + (i + 1)
							+ "]/td[1]", drive);

			Rev_onetime_ChargesCost[i] = return_text(
					".//*[@class='services-table']/tbody/tr[" + (i + 1)
							+ "]/td[2]", drive);

			if (Rev_onetime_ChargesCost[i].length() > 10) {
				int index = Rev_onetime_ChargesCost[i].indexOf(" ");
				logger.info("index: " + index);
				Rev_onetime_ChargesCost[i] = Rev_onetime_ChargesCost[i]
						.substring(0, index);
			}
			logger.info("Review_One Time Details Name : "
					+ return_text(".//*[@class='services-table']/tbody/tr["
							+ (i + 1) + "]/td[1]", drive));
			logger.info("Review_One Time Details Cost : "
					+ return_text(".//*[@class='services-table']/tbody/tr["
							+ (i + 1) + "]/td[2]", drive));
		}

		logger.info("Array Output after : 1 :");

		for (int i = 0; i < Rev_onetime_ChargesOption.length; i++) {
			System.out.print(Rev_onetime_ChargesOption[i] + ", ");
		}
		logger.info("Array Output after : 2 : ");
		for (int i = 0; i < Rev_onetime_ChargesCost.length; i++) {
			System.out.print(Rev_onetime_ChargesCost[i] + ", ");
		}

	}

	public boolean Isavailable(String fxp, WebDriver driver) {
		boolean xy = true;

		try {
			if (driver.findElement(By.xpath(fxp)) != null) {
				WebElement element = driver.findElement(By.xpath(fxp));
			    Actions actions = new Actions(driver);
				actions.moveToElement(element);
				actions.perform();         

				logger.info("gone inside",true);
			//	logger.info(true);
				xy = true;
			}
		} catch (Exception e) {
			logger.info(e.getMessage());
			logger.info(",",false);
			xy = false;
		}
		return xy;
	}

	public void TV_Equipment_Click(String br,WebDriver drive) {
		if (Isavailable(".//*[@name='customize_tv']", drive)) {
			drive.findElement(By.xpath(".//*[@name='customize_tv']")).click();
			statusTracker(br,drive, "Pass",
					"TV Equipment Select Checkbox should be displayed",
					"TV Equipment Select Checkbox is displayed",
					"TV Equipment Select Checkbox should be displayed");
		} else
			statusTracker(br,drive, "Fail",
					"TV Equipment Select Checkbox should be displayed",
					"TV Equipment Select Checkbox is NOT displayed",
					"TV Equipment Select Checkbox should be displayed");
	}

	public void Internet_Equipment_Click(String br,WebDriver drive) {
		if (Isavailable(".//*[@name='customize_inet']", drive)) {
			drive.findElement(By.xpath(".//*[@name='customize_inet']")).click();
			statusTracker(br,drive, "Pass",
					"Internet Equipment Select Checkbox should be displayed",
					"Internet Equipment Select Checkbox is displayed",
					"Internet Equipment Select Checkbox should be displayed");
		} else
			statusTracker(br,drive, "Fail",
					"Internet Equipment Select Checkbox should be displayed",
					"Internet Equipment Select Checkbox is NOT displayed",
					"Internet Equipment Select Checkbox should be displayed");
	}

	public void Customization_TV_OpenChannel() {
		drive.findElement(
				By.xpath(".//*[@class='tv-customize-accordion']/div[2]/header/ul/li[1]/a"))
				.click();
	}
	
	
	
	
	//RJ
	
	public void config_page_Cart_result_updater_abf(String br,WebDriver driver)
			throws InterruptedException {
		
	int jk;

	List<WebElement> myli4 = driver.findElements(By.xpath(".//*[@id='content']/div[3]/div[2]/div/div[1]/div/div/div/div/section/div[1]/table[1]/tbody/tr/td[2]"));
	List<WebElement> myli5 = driver.findElements(By.xpath("	.//*[@class='charges']/div"));
	
	logger.info("Validated the mini cart Monthly charges total is displayed on the right railing on the Internet plan");
	statusTracker(br,driver, 
			"Pass",
			"Validated the mini cart Monthly charges total is displayed on the right railing on the Internet plan",
			"Validated the mini cart Monthly charges total is displayed on the right railing on the Internet plan",
			"Mini cart Monthly charges total should be displayed on the right railing on the Internet plan");
		carttotal = myli5.size();
		
		logger.info("carttotal is " + carttotal);
		for (jk = 0; jk < carttotal; jk++) 
		{
			                                
			                                
itemname[jk] = driver.findElement(By.xpath("//*[@id='content']/div[3]/div[2]/div/div[1]/div/div/div/div/section/div[1]/div["+ (jk + 1) + "]/header/ul/li[2]/h6")).getText();
                                                               
itemcost[jk] = driver.findElement(By.xpath("//*[@id='content']/div[3]/div[2]/div/div[1]/div/div/div/div/section/div[1]/div["+ (jk + 1) + "]/header/ul/li[3]")).getText();
			logger.info(" eqipment cost is:" + itemcost[jk]);
			logger.info(" eqipment name is:" + itemname[jk]);
			statusTracker(br,driver, "Pass", "cart details", "eqipment name is: "
					+ itemname[jk] + " and item cost is: " + itemcost[jk],
					"selected eqipment should be added to cart");
			if ((itemcost[jk]).trim().equals("Free") || (itemcost[jk]).trim().equals("Included")||(itemcost[jk]).trim().equals("I don't want a box")) {
				itemcost[jk] = "0";
			}

		}

		int equipandtotal = 0;
		for (int m = 0; m < carttotal; m++) {

			String temp = itemcost[m].replaceAll("[^0-9]", "");
			equipandtotal += Integer.parseInt(temp);

		}

		String equipandtotalstring = String.valueOf(equipandtotal);
		equipandtotalstring = equipandtotalstring.substring(0,
				equipandtotalstring.length() - 2)
				+ "."
				+ equipandtotalstring
						.substring(equipandtotalstring.length() - 2);
		equipandtotalstring = "$" + equipandtotalstring;
		logger.info("equipandtotalstring is " + equipandtotalstring);

	if (driver.findElement(      
		By.xpath(".//*[@id='content']/div[3]/div[2]/div/div[1]/div/div/div/div/section/div[1]/table[2]/tbody/tr/td[2]")).isDisplayed()) {
				statusTracker(br,driver, 
						"Pass",
						"Validated the mini cart Monthly charges is displayed",
						"Validated the mini cart Monthly charges is displayed",
						"Mini cart Monthly charges should be displayed");
			} else {
				statusTracker(br,driver, 
						"Fail",
						"Validated the mini cart Monthly charges is NOT displayed",
						"Validated the mini cart Monthly charges is NOT displayed",
						"Mini cart Monthly charges should be displayed");
			}
		}



	//eoc RJ
	
	

	public void config_page_Cart_result_updater(String br, WebDriver driver)
			throws InterruptedException {
		logger.info("Manju function is called");
		int jk;
		logger.info("line 1");
		// String itemname[]=new String[15];
		logger.info("line 2");

		logger.info("line 3");
		List<WebElement> myli4 = driver
				.findElements(By
						.xpath("//html/body/section/div[2]/div[2]/div/div/div/div/div[2]/section/div/div/section/div/table/tbody/tr"));
		logger.info("line 4");
		carttotal = myli4.size();
		logger.info("line 5");
		logger.info("cartaotl is " + carttotal);
		for (jk = 0; jk < carttotal; jk++) {

			itemname[jk] = driver
					.findElement(
							By.xpath("//html/body/section/div[2]/div[2]/div/div/div/div/div[2]/section/div/div/section/div/table/tbody/tr["
									+ (jk + 1) + "]/td[1]")).getText();
			itemcost[jk] = driver
					.findElement(
							By.xpath("//html/body/section/div[2]/div[2]/div/div/div/div/div[2]/section/div/div/section/div/table/tbody/tr["
									+ (jk + 1) + "]/td[2]")).getText();
			logger.info(" eqipment cost is:" + itemcost[jk]);
			logger.info(" eqipment name is:" + itemname[jk]);
			statusTracker(br,driver, " ", "cart details", "eqipment name is: "
					+ itemname[jk] + " and item cost is: " + itemcost[jk],
					"selected eqipment should be added to cart");
			if ((itemcost[jk]).trim().equals("Free")) {
				itemcost[jk] = "0";
			}

		}

		int equipandtotal = 0;
		for (int m = 0; m < carttotal; m++) {

			String temp = itemcost[m].replaceAll("[^0-9]", "");
			equipandtotal += Integer.parseInt(temp);

		}

		String equipandtotalstring = String.valueOf(equipandtotal);
		equipandtotalstring = equipandtotalstring.substring(0,
				equipandtotalstring.length() - 2)
				+ "."
				+ equipandtotalstring
						.substring(equipandtotalstring.length() - 2);
		equipandtotalstring = "$" + equipandtotalstring;
		logger.info("equipandtotalstring is " + equipandtotalstring);

		if (driver.findElement(
				By.xpath(".//*[@id='content']/div[3]/div[2]/div/div[1]/div/div/div/div/section/div[1]/table[2]/tbody/tr/td[2]"))
				.isDisplayed()) {
		if (equipandtotalstring.equals(driver.findElement(
				By.xpath(".//*[@id='content']/div[3]/div[2]/div/div[1]/div/div/div/div/section/div[1]/table[2]/tbody/tr/td[2]"))
							.getText())) {
				statusTracker(br,driver, 
						"Pass",
						"Verify if the Eqipment added to the cart adds up to the total",
						"The euipment added to the cart adds up to the total",
						"The items added to the cart  total");
			} else {
				statusTracker(br,driver, 
						"Fail",
						"Verify if the items added to the cart adds up to the total",
						"The items added to the cart does not add up to the total. Actual: "
								+ driver.findElement(
										By.xpath("//html/body/section/div[2]/div[2]/div/div/div/div/div/div[2]/section/div/table/tbody/tr/td[2]"))
										.getText() + " Expected: "
								+ equipandtotalstring,
						"The items added to the cart does not add up to the total");
			}
		} else {
			if (equipandtotalstring
					.equals(driver
							.findElement(
									By.xpath(".//*[@id='content']/div[3]/div[2]/div/div[1]/div/div/div/div/section/div[1]/table[2]/tbody/tr/td[2]"))
							.getText())) {
				logger.info("ENtered inside the else3a loop");
				statusTracker(br,driver, 
						"Pass",
						"Verify if the Euipment added to the cart adds up to the total",
						"The items added to the cart adds up to the total",
						"The items added to the cart  add up to the total");
			} else {
				statusTracker(br,driver, 
						"Fail",
						"Verify if the items added to the cart adds up to the total",
						"The items added to the cart does not add up to the total. Actual: "
								+ driver.findElement(
										By.xpath(".//*[@id='content']/div[3]/div[2]/div/div[1]/div/div/div/div/section/div[1]/table[2]/tbody/tr/td[2]"))
										.getText() + " Expected: "
								+ equipandtotalstring,
						"The items added to the cart does not add up to the total");
			}
		}

		Thread.sleep(4000);

	}

	
	//rj
	
	
	
	
	public void config_page_Cart_result_updater_1(String br,WebDriver driver)
			throws InterruptedException {
		logger.info("Manju function is called");
		int jk;
		logger.info("line 1");
		// String itemname[]=new String[15];
		logger.info("line 2");

		logger.info("line 3");
		List<WebElement> myli4 = driver
				.findElements(By
						.xpath(".//*[@id='content']/div[3]/div[2]/div/div[1]/div/div/div/div[2]/section/div[1]/div/section/div/table/tbody/tr"));
		logger.info("line 4");
		carttotal = myli4.size();
		logger.info("line 5");
		logger.info("cartaotl is " + carttotal);
		for (jk = 0; jk < carttotal; jk++) {

	itemname[jk] = driver.findElement(
			By.xpath("//*[@id='content']/div[3]/div[2]/div/div[1]/div/div/div/div[2]/section/div[1]/div/section/div/table/tbody/tr["+ (jk + 1) + "]/td[1]")).getText();
	itemcost[jk] = driver.findElement(
		    By.xpath("//*[@id='content']/div[3]/div[2]/div/div[1]/div/div/div/div[2]/section/div[1]/div/section/div/table/tbody/tr["
									+ (jk + 1) + "]/td[2]")).getText();
			logger.info(" eqipment cost is:" + itemcost[jk]);
			logger.info(" eqipment name is:" + itemname[jk]);
			statusTracker(br,driver, " ", "cart details", "eqipment name is: "
					+ itemname[jk] + " and item cost is: " + itemcost[jk],
					"selected eqipment should be added to cart");
			if ((itemcost[jk]).trim().equals("Free")) {
				itemcost[jk] = "0";
			}

		}

		int equipandtotal = 0;
		for (int m = 0; m < carttotal; m++) {

			String temp = itemcost[m].replaceAll("[^0-9]", "");
			equipandtotal += Integer.parseInt(temp);

		}

		String equipandtotalstring = String.valueOf(equipandtotal);
		equipandtotalstring = equipandtotalstring.substring(0,
				equipandtotalstring.length() - 2)
				+ "."
				+ equipandtotalstring
						.substring(equipandtotalstring.length() - 2);
		equipandtotalstring = "$" + equipandtotalstring;
		logger.info("equipandtotalstring is " + equipandtotalstring);

		if (driver
				.findElement(
						By.xpath("//*[@id='content']/div[3]/div[2]/div/div[1]/div/div/div/div[2]/section/div[1]/table/tbody/tr/td[2]"))
				.isDisplayed()) {
			if (equipandtotalstring
					.equals(driver
							.findElement(
									By.xpath("//*[@id='content']/div[3]/div[2]/div/div[1]/div/div/div/div[2]/section/div[1]/table/tbody/tr/td[2]"))
							.getText())) {
				statusTracker(br,driver, 
						"Pass",
						"Verify if the Equipment added/removed to the cart adds up to the total",
						"The equipment added to the cart adds up to the total",
						"The items added to the cart  total");
			} else {
				statusTracker(br,driver, 
						"Fail",
						"Verify if the items added/removed to the cart adds up to the total",
						"The items added to the cart does not add up to the total. Actual: "
								+ driver.findElement(
										By.xpath("html/body/section/div[3]/div[2]/div/div[1]/div/div/div/div[2]/section/div[1]/table/tbody/tr/td[2]"))
										.getText() + " Expected: "
								+ equipandtotalstring,
						"The items added to the cart does not add up to the total");
			}
		}
		Thread.sleep(4000);
	}

	public void page_Cart_One_Time_charge_updater_1(String br,WebDriver driver)
			throws InterruptedException {
		int mon_total_items = return_size(
				".//*[@id='content']/div[3]/div[2]/div/div[1]/div/div/div/div[2]/section/div[2]/section/table/tbody/tr",
				driver);
		logger.info("mon_total_items : " + mon_total_items);

		for (int i = 1; i <= mon_total_items; i++) {
			itemname_mon[i] = return_text(
					".//*[@id='content']/div[3]/div[2]/div/div[1]/div/div/div/div[2]/section/div[2]/section/table/tbody/tr["
							+ i + "]/td[1]", driver);
			itemcost_mon[i] = return_text(
					".//*[@id='content']/div[3]/div[2]/div/div[1]/div/div/div/div[2]/section/div[2]/section/table/tbody/tr["
							+ i + "]/td[2]", driver);
			if ((itemcost_mon[i]).trim().equals("Free")||(itemcost_mon[i]).trim().equals("Included"))
			{
				
				itemcost_mon[i]="0";
			}
			logger.info(" Service cost is:" + itemcost_mon[i]);
			logger.info(" Serivce name is:" + itemname_mon[i]);
			statusTracker(br,driver, " ", "cart details", "Service name is: "
					+ itemname_mon[i] + " and Service cost is: "
					+ itemcost_mon[i],
					"selected service should be updated in one time charge section");
		}
		mon_total = return_text(
				"//*[@id='content']/div[3]/div[2]/div/div[1]/div/div/div/div[2]/section/table/tbody/tr/td[2]",
				driver);
		statusTracker(br,driver, " ", "cart details", "Monthly one time charges is "
				+ mon_total, "one time charge should be updated in cart");
	}


	public void page_Cart_One_Time_charge_updater_ValidateSportsChannel(String br,
			WebDriver driver) throws InterruptedException {
		int mon_total_items = return_size(
				".//*[@id='content']/div[3]/div[2]/div/div[1]/div/div/div/div[2]/section/div[2]/section/table/tbody/tr",
				driver);
		logger.info("mon_total_items : " + mon_total_items);

		for (int i = 1; i <= mon_total_items; i++) {
			itemname_mon[i - 1] = return_text(
					".//*[@id='content']/div[3]/div[2]/div/div[1]/div/div/div/div[2]/section/div[2]/section/table/tbody/tr["
							+ i + "]/td[1]", driver);
			itemcost_mon[i - 1] = return_text(
					".//*[@id='content']/div[3]/div[2]/div/div[1]/div/div/div/div[2]/section/div[2]/section/table/tbody/tr["
							+ i + "]/td[2]", driver);
			logger.info(" Service cost is:" + itemcost_mon[i - 1]);
			logger.info(" Serivce name is:" + itemname_mon[i - 1]);
			statusTracker(br,driver, " ", "cart details", "Service name is: "
					+ itemname_mon[i - 1] + " and Service cost is: "
					+ itemcost_mon[i - 1],
					"selected service should be updated in one time charge section");
		}
		mon_total = return_text(
				"//*[@id='content']/div[3]/div[2]/div/div[1]/div/div/div/div[2]/section/table/tbody/tr/td[2]",
				driver);
		statusTracker(br,driver, " ", "cart details", "Monthly one time charges is "
				+ mon_total, "one time charge should be updated in cart");
	}

	public void page_Cart_One_Time_charge_updater_ValidateSportsChannel_AllChkedData(String br,
			WebDriver driver) throws InterruptedException {
		new_mon_total_items = return_size(
				".//*[@id='content']/div[3]/div[2]/div/div[1]/div/div/div[2]/section/div[2]/section/table/tbody/tr",
				driver);
		logger.info("new_mon_total_items : " + new_mon_total_items);

		for (int i = 1; i <= new_mon_total_items; i++) {
			new_itemname_mon[i - 1] = return_text(
					".//*[@id='content']/div[3]/div[2]/div/div[1]/div/div/div[2]/section/div[2]/section/table/tbody/tr["
							+ i + "]/td[1]", driver);
			new_itemcost_mon[i - 1] = return_text(
					".//*[@id='content']/div[3]/div[2]/div/div[1]/div/div/div[2]/section/div[2]/section/table/tbody/tr["
							+ i + "]/td[2]", driver);
			logger.info(" Chk_Service cost is:"
					+ new_itemname_mon[i - 1]);
			logger.info(" Chk_Serivce name is:"
					+ new_itemcost_mon[i - 1]);
			statusTracker(br,driver, " ", "cart details", "Service name is: "
					+ new_itemname_mon[i - 1] + " and Service cost is: "
					+ new_itemcost_mon[i - 1],
					"selected service should be updated in one time charge section");
		}
	}

	public void Customization_TV_addPremiumChannels(String br,WebDriver drive)
			throws InterruptedException {
		logger.info("Premium Channels");
		Thread.sleep(2000);
		System.out
				.println("Premium one : "
						+ Isavailable(
								".//*[@id='1-3CEN9-1-2AW3-1']/td[1]/input",
								drive));

		// HBO Channel
		if (Isavailable(".//*[@id='1-3CEN9-1-2AW3-1']/td[1]/input", drive)) {
			statusTracker(br,drive, 
					"Pass",
					"Under the Premium Channel the HBO Channel is available for the selection",
					"HBO Channel must be available", "HBO Channel is displayed");
			drive.findElement(
					By.xpath(".//*[@id='1-3CEN9-1-2AW3-1']/td[1]/input"))
					.click();
			Thread.sleep(5000);

			if (Isavailable(".//*[@id='1-3CEN9-1-2AW3-1']/td[5]/a", drive)) {
				drive.findElement(
						By.xpath(".//*[@id='1-3CEN9-1-2AW3-1']/td[5]/a"))
						.click();
				statusTracker(br,drive, 
						"Pass",
						"Under the Premium Channel the HBO Channel, the long description is able to expand",
						"HBO Channel Description must be displayed",
						"HBO Channel Description is displayed");
				Thread.sleep(2000);

				drive.findElement(
						By.xpath(".//*[@id='1-3CEN9-1-2AW3-1']/td[5]/a"))
						.click();
				statusTracker(br,drive, 
						"Pass",
						"Under the Premium Channel the HBO Channel, the long description is able to Collapse",
						"HBO Channel Description must Collapsed",
						"HBO Channel Description is collapsed");
				Thread.sleep(2000);
			}

			// logger.info("Text 1: "+return_text(".//*[@id='1-3CEN9-1-2AW3-1']/td[4]",
			// drive));
			// logger.info("Text 2: "+return_text(".//*[@id='1-3CEN9-1-2AW3-1']/td[6]/div",
			// drive));
			// logger.info("Text 3: "+return_text(".//*[@id='1-3CEN9-1-2AW3-1']/td[4]",
			// drive).subSequence(0,
			// (return_text(".//*[@id='1-3CEN9-1-2AW3-1']/td[4]",
			// drive).trim().length()-1)));

			String price = drive.findElement(
					By.xpath(".//*[@id='1-3CEN9-1-2AW3-1']/td[6]/div"))
					.getText();
			int index_start = price.indexOf("$");
			logger.info(Integer.toString(index_start));

			int index_end = index_start + 5;
			logger.info(Integer.toString(index_end));
			String start_amount = price.substring(index_start, index_end);
			Double Decimal_Amount = Double.parseDouble(start_amount.replace(
					"$", "")) / 100;
			// logger.info("Decimal_Amount : "+Decimal_Amount);
			// logger.info("Month Details : "+return_text(".//*[@id='1-3CEN9-1-2AW3-1']/td[6]/div/span",
			// drive));

			if (return_text(".//*[@id='1-3CEN9-1-2AW3-1']/td[6]/div/span",
					drive).trim().equals("per Month"))
				statusTracker(br,drive, 
						"Pass",
						"For Premium Channel, HBO is displayed with the Per Month Price",
						"per Month must be displayed for the HBO Channel",
						"per Month is displayed for the HBO Channel");
			else
				statusTracker(br,drive, 
						"Fail",
						"For Premium Channel, HBO is displayed with the Per Month Price",
						"per Month must be displayed for the HBO Channel",
						"per Month is NOT displayed for the HBO Channel");

			Thread.sleep(5000);
			config_page_Cart_result_updater_1(br,drive);
			Thread.sleep(5000);

			if (itemname[0].equals(return_text(
					".//*[@id='1-3CEN9-1-2AW3-1']/td[4]", drive).subSequence(
					0,
					(return_text(".//*[@id='1-3CEN9-1-2AW3-1']/td[4]", drive)
							.trim().length() - 1)))
					&& itemcost[0].replace("$", "").equals(
							Decimal_Amount.toString()))
				statusTracker(br,drive, 
						"Pass",
						"For Premium Channel, HBO Price is Updated in the Cart as chosen",
						itemname[0] + " - " + itemcost[0]
								+ " must be displayed for the HBO Channel",
						"HBO Channel price must be displayed as chosen");
			else
				statusTracker(br,drive, 
						"Fail",
						"For Premium Channel, HBO Price is Updated in the Cart as chosen",
						itemname[0] + " - " + itemcost[0]
								+ " must be displayed for the HBO Channel",
						"HBO Channel price is NOT be displayed as chosen");

		} else
			statusTracker(br,drive, 
					"Fail",
					"Under the Premium Channel the HBO Channel is selected/displayed",
					"HBO Channel is NOT selected/displayed",
					"HBO Channel is selected/displayed");

		statusTracker(br,drive, " ",
				"Adding one more Premium Channel - Showtime Unlimited", " ",
				" ");

		// Showtime Unlimited Channel
		if (Isavailable(".//*[@id='1-3CEN9-1-2AWP-3']/td[1]/input", drive)) {
			statusTracker(br,drive, 
					"Pass",
					"Under the Premium Channel the Showtime Unlimited is available for the selection",
					"Showtime Unlimited Channel must be available",
					"Showtime Unlimited Channel is displayed");
			drive.findElement(
					By.xpath(".//*[@id='1-3CEN9-1-2AWP-3']/td[1]/input"))
					.click();
			Thread.sleep(5000);

			if (Isavailable(".//*[@id='1-3CEN9-1-2AXB-4']/td[5]/a", drive)) {
				drive.findElement(
						By.xpath(".//*[@id='1-3CEN9-1-2AXB-4']/td[5]/a"))
						.click();
				statusTracker(br,drive, 
						"Pass",
						"Under the Premium Channel the Showtime Unlimited Channel, the long description is able to expand",
						"Showtime Unlimited Channel Description must be displayed",
						"Showtime Unlimited Channel Description is displayed");
				Thread.sleep(2000);

				drive.findElement(
						By.xpath(".//*[@id='1-3CEN9-1-2AXB-4']/td[5]/a"))
						.click();
				statusTracker(br,drive, 
						"Pass",
						"Under the Premium Channel the Showtime Unlimited Channel, the long description is able to Collapse",
						"Showtime Unlimited Channel Description must Collapsed",
						"Showtime Unlimited Channel Description is collapsed");
				Thread.sleep(2000);
			}

			// logger.info("Text 1: "+return_text(".//*[@id='1-3CEN9-1-2AW3-1']/td[4]",
			// drive));
			// logger.info("Text 2: "+return_text(".//*[@id='1-3CEN9-1-2AW3-1']/td[6]/div",
			// drive));

			String price = drive.findElement(
					By.xpath(".//*[@id='1-3CEN9-1-2AXB-4']/td[6]/div"))
					.getText();
			int index_start = price.indexOf("$");
			logger.info(Integer.toString(index_start));

			int index_end = index_start + 5;
			logger.info(Integer.toString(index_end));
			String start_amount = price.substring(index_start, index_end);
			Double Decimal_Amount = Double.parseDouble(start_amount.replace(
					"$", "")) / 100;
			// logger.info("Decimal_Amount : "+Decimal_Amount);
			// logger.info("Month Details : "+return_text(".//*[@id='1-3CEN9-1-2AW3-1']/td[6]/div/span",
			// drive));

			if (return_text(".//*[@id='1-3CEN9-1-2AXB-4']/td[6]/div/span",
					drive).trim().equals("per Month"))
				statusTracker(br,drive, 
						"Pass",
						"For Premium Channel, Showtime Unlimited is displayed with the Per Month Price",
						"per Month must be displayed for the Showtime Unlimited Channel",
						"per Month is displayed for the Showtime Unlimited Channel");
			else
				statusTracker(br,drive, 
						"Fail",
						"For Premium Channel, Showtime Unlimited is displayed with the Per Month Price",
						"per Month must be displayed for the Showtime Unlimited Channel",
						"per Month is NOT displayed for the Showtime Unlimited Channel");

			Thread.sleep(8000);
			config_page_Cart_result_updater_1(br,drive);
			Thread.sleep(5000);

			if (itemname[1].equals(return_text(
					".//*[@id='1-3CEN9-1-2AWP-3']/td[4]", drive).subSequence(
					0,
					(return_text(".//*[@id='1-3CEN9-1-2AWP-3']/td[4]", drive)
							.trim().length() - 1)))
					&& itemcost[0].replace("$", "").equals(
							Decimal_Amount.toString()))
				statusTracker(br,drive, 
						"Pass",
						"For Premium Channel, Showtime Unlimited Price is Updated in the Cart as chosen",
						itemname[1]
								+ " - "
								+ itemcost[1]
								+ " must be displayed for the Showtime Unlimited Channel",
						"Showtime Unlimited Channel price must be displayed as chosen");
			else
				statusTracker(br,drive, 
						"Fail",
						"For Premium Channel, Showtime Unlimited Price is Updated in the Cart as chosen",
						itemname[1]
								+ " - "
								+ itemcost[1]
								+ " must be displayed for the Showtime Unlimited Channel",
						"Showtime Unlimited Channel price is NOT be displayed as chosen");

		} else
			statusTracker(br,drive, 
					"Fail",
					"Under the Premium Channel the Showtime Unlimited Channel is selected/displayed",
					"Showtime Unlimited Channel is NOT selected/displayed",
					"Showtime Unlimited Channel is selected/displayed");

		statusTracker(br,drive, " ",
				"Removing the Added Premium Channel - Showtime Unlimited", " ",
				" ");

		// Showtime Unlimited Channel
		if (Isavailable(".//*[@id='1-3CEN9-1-2AWP-3']/td[1]/input", drive)) {
			statusTracker(br,drive, 
					"Pass",
					"Under the Premium Channel the Showtime Unlimited is available for De-selection",
					"Showtime Unlimited Channel must be available",
					"Showtime Unlimited Channel is displayed");
			drive.findElement(
					By.xpath(".//*[@id='1-3CEN9-1-2AWP-3']/td[1]/input"))
					.click();
			Thread.sleep(5000);

			String price = drive.findElement(
					By.xpath(".//*[@id='1-3CEN9-1-2AXB-4']/td[6]/div"))
					.getText();
			int index_start = price.indexOf("$");
			logger.info(Integer.toString(index_start));

			int index_end = index_start + 5;
			logger.info(Integer.toString(index_end));
			String start_amount = price.substring(index_start, index_end);
			Double Decimal_Amount = Double.parseDouble(start_amount.replace(
					"$", "")) / 100;

			Thread.sleep(8000);
			config_page_Cart_result_updater_1(br,drive);
			Thread.sleep(5000);

			if (itemname[1].equals(return_text(
					".//*[@id='1-3CEN9-1-2AWP-3']/td[4]", drive).subSequence(
					0,
					(return_text(".//*[@id='1-3CEN9-1-2AWP-3']/td[4]", drive)
							.trim().length() - 1)))
					&& itemcost[1].replace("$", "").equals(
							Decimal_Amount.toString()))
				statusTracker(br,drive, 
						"Fail",
						"For Premium Channel, Showtime Unlimited Price is NOT Removed from the cart",
						"Showtime Unlimited Channel is  displayed in the Cart",
						"Showtime Unlimited Channel price is NOT displayed");
			else
				statusTracker(br,drive, 
						"Pass",
						"For Premium Channel, Showtime Unlimited Price is Removed from the cart",
						"Showtime Unlimited Channel must be NOT be displayed in the Cart",
						"Showtime Unlimited Channel price is NOT displayed");

		} else
			statusTracker(br,drive, 
					"Fail",
					"Under the Premium Channel the Showtime Unlimited Channel is selected/displayed",
					"Showtime Unlimited Channel is NOT selected/displayed",
					"Showtime Unlimited Channel is selected/displayed");

	}

	public void Validation_CurrentService_Vs_Channels(String br, WebDriver drive)
			throws InterruptedException {
		logger.info("Validation_CurrentService_Vs_Channels");

		String[] Current_Service_Details = new String[6];
		drive.findElement(
				By.xpath(".//*[@id='content']/div[3]/div[2]/div/div[1]/div/div/div[1]/header/ul/li[2]/a"))
				.click();
		Thread.sleep(1000);
		int li_cur_size = return_size(
				".//*[@id='content']/div[3]/div[2]/div/div[1]/div/div/div[1]/section/div[1]/section/div/ul/li",
				drive);
		logger.info("# of current service present : " + li_cur_size);
		drive.findElement(
				By.xpath(".//*[@id='content']/div[3]/div[2]/div/div[1]/div/div/div[1]/section/div[1]/header/ul/li[1]/a"))
				.click();
		Thread.sleep(1000);
		for (int i = 1; i < li_cur_size; i++) {
			Current_Service_Details[i - 1] = return_text(
					"//*[@class='content-wrap']/ul/li[" + (i + 1) + "]", drive);
			logger.info("Values : " + i + " - "
					+ Current_Service_Details[i - 1]);
			logger.info((String) return_text(
					".//*[@id='1-3CEN9-1-2AWE-2']/td[4]", drive).subSequence(
					0,
					(return_text(".//*[@id='1-3CEN9-1-2AWE-2']/td[4]", drive)
							.trim().length() - 1)));
			
			//logger.info( return_text(".//*[@id='1-3CEN9-1-2AWE-2']/td[4]", drive).subSequence(0, (return_text(".//*[@id='1-3CEN9-1-2AWE-2']/td[4]", drive).trim().length()-1)));
			
			if (Current_Service_Details[i - 1].contains(return_text(
					".//*[@id='1-3CEN9-1-2AWE-2']/td[4]", drive).subSequence(
					0,
					(return_text(".//*[@id='1-3CEN9-1-2AWE-2']/td[4]", drive)
							.trim().length() - 1)))) {
				if (return_text(".//*[@id='1-3CEN9-1-2AWE-2']/td[6]/div/em",
						drive).equals("Current Service"))
					statusTracker(br,drive, 
							"Pass",
							"Verify Current Service will display instead of monthly pricing.",
							"Current Service is displayed instead of monthly pricing for the Channel - "
									+ return_text(
											".//*[@id='1-3CEN9-1-2AWE-2']/td[6]/div/em",
											drive),
							"Current Service should display instead of monthly pricing.");
				else
					statusTracker(br,drive, 
							"Fail",
							"Verify Current Service will display instead of monthly pricing.",
							"Current Service is NOT display instead of monthly pricing for the Channel - "
									+ return_text(
											".//*[@id='1-3CEN9-1-2AWE-2']/td[6]/div/em",
											drive),
							"Current Service should display instead of monthly pricing.");
			}
		}

	}

	public void Customization_TV_addAdultChannels(String br, WebDriver drive) throws InterruptedException {
		logger.info("Adult Channels");
		Thread.sleep(2000);
		logger.info("Adult one : "
				+ Isavailable(
						".//*[@class='tab-nav-wrap mobile-hidden']/ul/li[5]/a",
						drive));
		Thread.sleep(2000);
		drive.findElement(
				By.xpath(".//*[@class='tab-nav-wrap mobile-hidden']/ul/li[5]/a"))
				.click();
		Thread.sleep(5000);

		if (return_text(
				".//*[@class='adultAlaCartChannels collapsible-channels']/div/h4",
				drive).trim().equals("Adult Channels"))
			statusTracker(br,drive, "Pass", "Verify the Adult Channels section",
					"Adult Channels tab is displayed",
					"Adult Channels tab Should be displayed");
		else
			statusTracker(br,drive, "Fail", "Verify the Adult Channels section",
					"Adult Channels tab is NOT displayed",
					"Adult Channels tab Should be displayed");

		// Hustler Channel
		if (Isavailable(".//*[@id='1-3R1FP-1-3R141-1']/td[1]/input", drive)) {
			statusTracker(br,drive, 
					"Pass",
					"Under the Adult Channel the Hustler Channel is available for the selection",
					"Hustler Channel must be available",
					"Hustler Channel is displayed");
			drive.findElement(
					By.xpath(".//*[@id='1-3R1FP-1-3R141-1']/td[1]/input"))
					.click();
			Thread.sleep(5000);

			if (Isavailable(".//*[@id='1-3R1FP-1-3R141-1']/td[5]/a", drive)) {
				drive.findElement(
						By.xpath(".//*[@id='1-3R1FP-1-3R141-1']/td[5]/a"))
						.click();
				statusTracker(br,drive, 
						"Pass",
						"Under the Adult Channel the Hustler Channel, the long description is able to expand",
						"Hustler Channel Description must be displayed",
						"Hustler Channel Description is displayed");
				Thread.sleep(3000);

				drive.findElement(
						By.xpath(".//*[@id='1-3R1FP-1-3R141-1']/td[5]/a"))
						.click();
				statusTracker(br,drive, 
						"Pass",
						"Under the Adult Channel the Hustler Channel, the long description is able to Collapse",
						"Hustler Channel Description must Collapsed",
						"Hustler Channel Description is collapsed");
				Thread.sleep(2000);

			}

			String price = drive.findElement(
					By.xpath(".//*[@id='1-3R1FP-1-3R141-1']/td[6]/div"))
					.getText();
			int index_start = price.indexOf("$");
			logger.info(Integer.toString(index_start));

			int index_end = index_start + 5;
			logger.info(Integer.toString(index_end));
			String start_amount = price.substring(index_start, index_end);
			Double Decimal_Amount = Double.parseDouble(start_amount.replace(
					"$", "")) / 100;

			if (return_text(".//*[@id='1-3R1FP-1-3R141-1']/td[6]/div/span",
					drive).trim().equals("per Month"))
				statusTracker(br,drive, 
						"Pass",
						"For Adult Channel, Hustler is displayed with the Per Month Price",
						"per Month must be displayed for the Hustler Channel",
						"per Month is displayed for the Hustler Channel");
			else
				statusTracker(br,drive, 
						"Fail",
						"For Adult Channel, Hustler is displayed with the Per Month Price",
						"per Month must be displayed for the Hustler Channel",
						"per Month is NOT displayed for the Hustler Channel");

			Thread.sleep(8000);
			config_page_Cart_result_updater_1(br,drive);
			Thread.sleep(5000);

			if (itemname[0].equals(return_text(
					".//*[@id='1-3R1FP-1-3R141-1']/td[4]", drive).trim())
					&& itemcost[0].replace("$", "").equals(
							Decimal_Amount.toString()))
				statusTracker(br,drive, 
						"Pass",
						"For Adult Channel, Hustler Price is Updated in the Cart as chosen",
						itemname[0] + " - " + itemcost[0]
								+ " must be displayed for the Hustler Channel",
						"Hustler Channel price must be displayed as chosen");
			else
				statusTracker(br,drive, 
						"Fail",
						"For Adult Channel, Hustler Price is Updated in the Cart as chosen",
						itemname[0] + " - " + itemcost[0]
								+ " must be displayed for the Hustler Channel",
						"Hustler Channel price is NOT be displayed as chosen");

		} else
			statusTracker(br,drive, 
					"Fail",
					"Under the Adult Channel the Hustler Channel is selected/displayed",
					"Hustler Channel is NOT selected/displayed",
					"Hustler Channel is selected/displayed");

		statusTracker(br,drive, " ", "Adding one more Adult Channel - Penthouse", " ",
				" ");

		// Penthouse Channel
		if (Isavailable(".//*[@id='1-3R1FP-1-3R14W-2']/td[1]/input", drive)) {
			statusTracker(br,drive, 
					"Pass",
					"Under the Adult Channel the Penthouse Channel is available for the selection",
					"Penthouse Channel must be available",
					"Penthouse Channel is displayed");
			drive.findElement(
					By.xpath(".//*[@id='1-3R1FP-1-3R14W-2']/td[1]/input"))
					.click();
			Thread.sleep(5000);

			if (Isavailable(".//*[@id='1-3R1FP-1-3R14W-2']/td[5]/a", drive)) {
				drive.findElement(
						By.xpath(".//*[@id='1-3R1FP-1-3R14W-2']/td[5]/a"))
						.click();
				statusTracker(br,drive, 
						"Pass",
						"Under the Adult Channel the Penthouse Channel, the long description is able to expand",
						"Penthouse Channel Description must be displayed",
						"Penthouse Channel Description is displayed");
				Thread.sleep(3000);

				drive.findElement(
						By.xpath(".//*[@id='1-3R1FP-1-3R14W-2']/td[5]/a"))
						.click();
				statusTracker(br,drive, 
						"Pass",
						"Under the Adult Channel the Penthouse Channel, the long description is able to Collapse",
						"Penthouse Channel Description must Collapsed",
						"Penthouse Channel Description is collapsed");
				Thread.sleep(2000);
			}

			String price = drive.findElement(
					By.xpath(".//*[@id='1-3R1FP-1-3R14W-2']/td[6]/div"))
					.getText();
			int index_start = price.indexOf("$");
			logger.info(Integer.toString(index_start));

			int index_end = index_start + 5;
			logger.info(Integer.toString(index_end));
			String start_amount = price.substring(index_start, index_end);
			Double Decimal_Amount = Double.parseDouble(start_amount.replace(
					"$", "")) / 100;

			if (return_text(".//*[@id='1-3R1FP-1-3R14W-2']/td[6]/div/span",
					drive).trim().equals("per Month"))
				statusTracker(br,drive, 
						"Pass",
						"For Adult Channel, Penthouse is displayed with the Per Month Price",
						"per Month must be displayed for the Penthouse Channel",
						"per Month is displayed for the Penthouse Channel");
			else
				statusTracker(br,drive, 
						"Fail",
						"For Adult Channel, Penthouse is displayed with the Per Month Price",
						"per Month must be displayed for the Penthouse Channel",
						"per Month is NOT displayed for the Penthouse Channel");

			Thread.sleep(8000);
			config_page_Cart_result_updater_1(br,drive);
			Thread.sleep(5000);

			if (itemname[1].equals(return_text(
					".//*[@id='1-3R1FP-1-3R14W-2']/td[4]", drive).trim())
					&& itemcost[1].replace("$", "").equals(
							Decimal_Amount.toString()))
				statusTracker(br,drive, 
						"Pass",
						"For Adult Channel, Penthouse Price is Updated in the Cart as chosen",
						itemname[1]
								+ " - "
								+ itemcost[1]
								+ " must be displayed for the Penthouse Channel",
						"Penthouse Channel price must be displayed as chosen");
			else
				statusTracker(br,drive, 
						"Fail",
						"For Adult Channel, Penthouse Price is Updated in the Cart as chosen",
						itemname[1]
								+ " - "
								+ itemcost[1]
								+ " must be displayed for the Penthouse Channel",
						"Penthouse Channel price is NOT be displayed as chosen");

		} else
			statusTracker(br,drive, 
					"Fail",
					"Under the Adult Channel the Penthouse Channel is selected/displayed",
					"Penthouse Channel is NOT selected/displayed",
					"Penthouse Channel is selected/displayed");

		statusTracker(br,drive, " ", "Removing the Added Adult Channel - Penthouse", " ",
				" ");

		// Penthouse Channel
		if (Isavailable(".//*[@id='1-3R1FP-1-3R14W-2']/td[1]/input", drive)) {
			statusTracker(br,drive, 
					"Pass",
					"Under the Adult Channel the Penthouse is available for the De-selection",
					"Penthouse Channel must be available",
					"Penthouse Channel is displayed");
			drive.findElement(
					By.xpath(".//*[@id='1-3R1FP-1-3R14W-2']/td[1]/input"))
					.click();
			Thread.sleep(2000);

			String price = drive.findElement(
					By.xpath(".//*[@id='1-3R1FP-1-3R14W-2']/td[6]/div"))
					.getText();
			int index_start = price.indexOf("$");
			logger.info(Integer.toString(index_start));

			int index_end = index_start + 5;
			logger.info(Integer.toString(index_end));
			String start_amount = price.substring(index_start, index_end);
			Double Decimal_Amount = Double.parseDouble(start_amount.replace(
					"$", "")) / 100;

			Thread.sleep(8000);
			config_page_Cart_result_updater_1(br,drive);
			Thread.sleep(5000);

			if (itemname[1].equals(return_text(
					".//*[@id='1-3R1FP-1-3R14W-2']/td[4]", drive).subSequence(
					0,
					(return_text(".//*[@id='1-3R1FP-1-3R14W-2']/td[4]", drive)
							.trim().length() - 1)))
					&& itemcost[1].replace("$", "").equals(
							Decimal_Amount.toString()))
				statusTracker(br,drive, 
						"Fail",
						"For Adult Channel, Penthouse Price is NOT Removed from the cart",
						"Penthouse Channel is  displayed in the Cart",
						"Penthouse Channel price is NOT displayed");
			else
				statusTracker(br,drive, 
						"Pass",
						"For Adult Channel, Penthouse Price is Removed from the cart",
						"Penthouse Channel must be NOT be displayed in the Cart",
						"Penthouse Channel price is NOT displayed");
		} else
			statusTracker(br,drive, 
					"Fail",
					"Under the Adult Channel the Penthouse Channel is selected/displayed",
					"Penthouse Channel is NOT selected/displayed",
					"Penthouse Channel is selected/displayed");
	}

	public void Customization_TV_addInternationalPackages(String br, WebDriver drive)
			throws InterruptedException {
		logger.info("Internet Packages");
		Thread.sleep(2000);
		logger.info("Int Packages one : "
				+ Isavailable(
						".//*[@class='tab-nav-wrap mobile-hidden']/ul/li[4]/a",
						drive));
		Thread.sleep(2000);
		drive.findElement(
				By.xpath(".//*[@class='tab-nav-wrap mobile-hidden']/ul/li[4]/a"))
				.click();
		Thread.sleep(5000);

		if (return_text(".//*[@class='collapsible-channels alaCarte']/div/h4",
				drive).trim().equals("International Channels"))
			statusTracker(br,drive, "Pass", "Verify the International Channels section",
					"International Channels tab is displayed",
					"International Channels tab Should be displayed");
		else
			statusTracker(br,drive, "Fail", "Verify the International Channels section",
					"International Channels tab is NOT displayed",
					"International Channels tab Should be displayed");

		// Filipino Pass Plus Package
		if (Isavailable(".//*[@id='1-3H4H2-1-1YJMZ-1']/td[1]/input", drive)) {
			statusTracker(br,drive, 
					"Pass",
					"Under the International Package the Filipino Pass Plus Package is available for the selection",
					"Filipino Pass Plus Package must be available",
					"Filipino Pass Plus Package is displayed");
			drive.findElement(
					By.xpath(".//*[@id='1-3H4H2-1-1YJMZ-1']/td[1]/input"))
					.click();
			Thread.sleep(5000);

			if (Isavailable(".//*[@id='1-3H4H2-1-1YJMZ-1']/td[5]/a", drive)) {
				drive.findElement(
						By.xpath(".//*[@id='1-3H4H2-1-1YJMZ-1']/td[5]/a"))
						.click();
				statusTracker(br,drive, 
						"Pass",
						"Under the International Package the Filipino Pass Plus Package, the long description is able to expand",
						"Filipino Pass Plus Package Description must be displayed",
						"Filipino Pass Plus Package Description is displayed");
				Thread.sleep(3000);

				drive.findElement(
						By.xpath(".//*[@id='1-3H4H2-1-1YJMZ-1']/td[5]/a"))
						.click();
				statusTracker(br,drive, 
						"Pass",
						"Under the International Package the Filipino Pass Plus Package, the long description is able to Collapse",
						"Filipino Pass Plus Package Description must Collapsed",
						"Filipino Pass Plus Package Description is collapsed");
				Thread.sleep(2000);

			}

			String price = drive.findElement(
					By.xpath(".//*[@id='1-3H4H2-1-1YJMZ-1']/td[6]/div"))
					.getText();
			int index_start = price.indexOf("$");
			logger.info(Integer.toString(index_start));

			int index_end = index_start + 5;
			logger.info(Integer.toString(index_end));
			String start_amount = price.substring(index_start, index_end);
			Double Decimal_Amount = Double.parseDouble(start_amount.replace(
					"$", "")) / 100;

			if (return_text(".//*[@id='1-3H4H2-1-1YJMZ-1']/td[6]/div/span",
					drive).trim().equals("per Month"))
				statusTracker(br,drive, 
						"Pass",
						"For International Package, Filipino Pass Plus is displayed with the Per Month Price",
						"per Month must be displayed for the Filipino Pass Plus Package",
						"per Month is displayed for the Filipino Pass Plus Package");
			else
				statusTracker(br,drive, 
						"Fail",
						"For International Package, Filipino Pass Plus is displayed with the Per Month Price",
						"per Month must be displayed for the Filipino Pass Plus Package",
						"per Month is NOT displayed for the Filipino Pass Plus Package");

			Thread.sleep(8000);
			config_page_Cart_result_updater_1(br,drive);
			Thread.sleep(5000);

			if (itemname[0].equals(return_text(
					".//*[@id='1-3H4H2-1-1YJMZ-1']/td[4]", drive).trim())
					&& itemcost[0].replace("$", "").equals(
							Decimal_Amount.toString()))
				statusTracker(br,drive, 
						"Pass",
						"For International Package, Filipino Pass Plus Price is Updated in the Cart as chosen",
						itemname[0]
								+ " - "
								+ itemcost[0]
								+ " must be displayed for the Filipino Pass Plus Package",
						"Filipino Pass Plus Package price must be displayed as chosen");
			else
				statusTracker(br,drive, 
						"Fail",
						"For International Package, Filipino Pass Plus Price is Updated in the Cart as chosen",
						itemname[0]
								+ " - "
								+ itemcost[0]
								+ " must be displayed for the Filipino Pass Plus Package",
						"Filipino Pass Plus Package price is NOT be displayed as chosen");

		} else
			statusTracker(br,drive, 
					"Fail",
					"Under the International Package the Filipino Pass Plus Package is selected/displayed",
					"Filipino Pass Plus Package is NOT selected/displayed",
					"Filipino Pass Plus Package is selected/displayed");

		statusTracker(br,drive, " ",
				"Adding one more International Packages - Hindi Passport", " ",
				" ");

		// Hindi Passport Package
		if (Isavailable(".//*[@id='1-3H4H2-1-1YJP3-2']/td[1]/input", drive)) {
			statusTracker(br,drive, 
					"Pass",
					"Under the International Package the Hindi Passport Package is available for the selection",
					"Hindi Passport Package must be available",
					"Hindi Passport Package is displayed");
			drive.findElement(
					By.xpath(".//*[@id='1-3H4H2-1-1YJP3-2']/td[1]/input"))
					.click();
			Thread.sleep(5000);

			if (Isavailable(".//*[@id='1-3H4H2-1-1YJP3-2']/td[5]/a", drive)) {
				drive.findElement(
						By.xpath(".//*[@id='1-3H4H2-1-1YJP3-2']/td[5]/a"))
						.click();
				statusTracker(br,drive, 
						"Pass",
						"Under the International Package the Hindi Passport Package, the long description is able to expand",
						"Hindi Passport Package Description must be displayed",
						"Hindi Passport Package Description is displayed");
				Thread.sleep(3000);

				drive.findElement(
						By.xpath(".//*[@id='1-3H4H2-1-1YJP3-2']/td[5]/a"))
						.click();
				statusTracker(br,drive, 
						"Pass",
						"Under the International Package the Hindi Passport Package, the long description is able to Collapse",
						"Hindi Passport Package Description must Collapsed",
						"Hindi Passport Package Description is collapsed");
				Thread.sleep(2000);
			}

			String price = drive.findElement(
					By.xpath(".//*[@id='1-3H4H2-1-1YJP3-2']/td[6]/div"))
					.getText();
			int index_start = price.indexOf("$");
			logger.info(Integer.toString(index_start));

			int index_end = index_start + 5;
			logger.info(Integer.toString(index_end));
			String start_amount = price.substring(index_start, index_end);
			Double Decimal_Amount = Double.parseDouble(start_amount.replace(
					"$", "")) / 100;

			if (return_text(".//*[@id='1-3H4H2-1-1YJP3-2']/td[6]/div/span",
					drive).trim().equals("per Month"))
				statusTracker(br,drive, 
						"Pass",
						"For International Package, Hindi Passport is displayed with the Per Month Price",
						"per Month must be displayed for the Hindi Passport Package",
						"per Month is displayed for the Hindi Passport Package");
			else
				statusTracker(br,drive, 
						"Fail",
						"For International Package, Hindi Passport is displayed with the Per Month Price",
						"per Month must be displayed for the Hindi Passport Package",
						"per Month is NOT displayed for the Hindi Passport Package");

			Thread.sleep(8000);
			config_page_Cart_result_updater_1(br,drive);
			Thread.sleep(5000);

			if (itemname[1].equals(return_text(
					".//*[@id='1-3H4H2-1-1YJP3-2']/td[4]", drive).trim())
					&& itemcost[1].replace("$", "").equals(
							Decimal_Amount.toString()))
				statusTracker(br,drive, 
						"Pass",
						"For International Package, Hindi Passport Price is Updated in the Cart as chosen",
						itemname[1]
								+ " - "
								+ itemcost[1]
								+ " must be displayed for the Hindi Passport Package",
						"Hindi Passport Package price must be displayed as chosen");
			else
				statusTracker(br,drive, 
						"Fail",
						"For International Package, Hindi Passport Price is Updated in the Cart as chosen",
						itemname[1]
								+ " - "
								+ itemcost[1]
								+ " must be displayed for the Hindi Passport Package",
						"Hindi Passport Package price is NOT be displayed as chosen");

		} else
			statusTracker(br,drive, 
					"Fail",
					"Under the International Package the Hindi Passport Package is selected/displayed",
					"Hindi Passport Package is NOT selected/displayed",
					"Hindi Passport Package is selected/displayed");

		statusTracker(br,drive, " ",
				"Removing the Added International Package - Hindi Passport",
				" ", " ");

		// Hindi Passport Package
		if (Isavailable(".//*[@id='1-3H4H2-1-1YJP3-2']/td[1]/input", drive)) {
			statusTracker(br,drive, 
					"Pass",
					"Under the International Package the Hindi Passport is available for the De-selection",
					"Hindi Passport Package must be available",
					"Hindi Passport Package is displayed");
			drive.findElement(
					By.xpath(".//*[@id='1-3H4H2-1-1YJP3-2']/td[1]/input"))
					.click();
			Thread.sleep(2000);

			String price = drive.findElement(
					By.xpath(".//*[@id='1-3H4H2-1-1YJP3-2']/td[6]/div"))
					.getText();
			int index_start = price.indexOf("$");
			logger.info(Integer.toString(index_start));

			int index_end = index_start + 5;
			logger.info(Integer.toString(index_end));
			String start_amount = price.substring(index_start, index_end);
			Double Decimal_Amount = Double.parseDouble(start_amount.replace(
					"$", "")) / 100;

			Thread.sleep(8000);
			config_page_Cart_result_updater_1(br,drive);
			Thread.sleep(5000);

			if (itemname[1].equals(return_text(
					".//*[@id='1-3H4H2-1-1YJP3-2']/td[4]", drive).subSequence(
					0,
					(return_text(".//*[@id='1-3H4H2-1-1YJP3-2']/td[4]", drive)
							.trim().length() - 1)))
					&& itemcost[1].replace("$", "").equals(
							Decimal_Amount.toString()))
				statusTracker(br,drive, 
						"Fail",
						"For International Package, Hindi Passport Price is NOT Removed from the cart",
						"Hindi Passport Package is  displayed in the Cart",
						"Hindi Passport Package price is NOT displayed");
			else
				statusTracker(br,drive, 
						"Pass",
						"For International Package, Hindi Passport Price is Removed from the cart",
						"Hindi Passport Package must be NOT be displayed in the Cart",
						"Hindi Passport Package price is NOT displayed");
		} else
			statusTracker(br,drive, 
					"Fail",
					"Under the International Package the Hindi Passport Package is selected/displayed",
					"Hindi Passport Package is NOT selected/displayed",
					"Hindi Passport Package is selected/displayed");
	}

	public void Customization_TV_addInternationalChannels(String br, WebDriver drive)
			throws InterruptedException {
		logger.info("International Channels");
		Thread.sleep(2000);
		logger.info("Int Channels one : "
				+ Isavailable(
						".//*[@class='tab-nav-wrap mobile-hidden']/ul/li[4]/a",
						drive));
		Thread.sleep(2000);
		drive.findElement(
				By.xpath(".//*[@class='tab-nav-wrap mobile-hidden']/ul/li[4]/a"))
				.click();
		Thread.sleep(5000);

		if (return_text(".//*[@class='collapsible-channels alaCarte']/div/h4",
				drive).trim().equals("International Channels"))
			statusTracker(br,drive, "Pass", "Verify the International Channels section",
					"International Channels tab is displayed",
					"International Channels tab Should be displayed");
		else
			statusTracker(br,drive, "Fail", "Verify the International Channels section",
					"International Channels tab is NOT displayed",
					"International Channels tab Should be displayed");

		// DW Channel
		if (Isavailable(".//*[@id='1-3H4H2-1-2B7G-3']/td[1]/input", drive)) {
			statusTracker(br,drive, 
					"Pass",
					"Under the International Channel the DW Channel is available for the selection",
					"DW Channel must be available", "DW Channel is displayed");
			drive.findElement(
					By.xpath(".//*[@id='1-3H4H2-1-2B7G-3']/td[1]/input"))
					.click();
			Thread.sleep(5000);

			if (Isavailable(".//*[@id='1-3H4H2-1-2B7G-3']/td[5]/a", drive)) {
				drive.findElement(
						By.xpath(".//*[@id='1-3H4H2-1-2B7G-3']/td[5]/a"))
						.click();
				statusTracker(br,drive, 
						"Pass",
						"Under the International Channel the DW Channel, the long description is able to expand",
						"DW Channel Description must be displayed",
						"DW Channel Description is displayed");
				Thread.sleep(3000);

				drive.findElement(
						By.xpath(".//*[@id='1-3H4H2-1-2B7G-3']/td[5]/a"))
						.click();
				statusTracker(br,drive, 
						"Pass",
						"Under the International Channel the DW Channel, the long description is able to Collapse",
						"DW Channel Description must Collapsed",
						"DW Channel Description is collapsed");
				Thread.sleep(2000);
			}
			String price = drive.findElement(
					By.xpath(".//*[@id='1-3H4H2-1-2B7G-3']/td[6]/div"))
					.getText();
			int index_start = price.indexOf("$");
			logger.info(Integer.toString(index_start));

			int index_end = index_start + 5;
			logger.info(Integer.toString(index_end));
			String start_amount = price.substring(index_start, index_end);
			Double Decimal_Amount = Double.parseDouble(start_amount.replace(
					"$", "")) / 100;
			if (return_text(".//*[@id='1-3H4H2-1-2B7G-3']/td[6]/div/span",
					drive).trim().equals("per Month"))
				statusTracker(br,drive, 
						"Pass",
						"For International Channel, DW is displayed with the Per Month Price",
						"per Month must be displayed for the DW Channel",
						"per Month is displayed for the DW Channel");
			else
				statusTracker(br,drive, 
						"Fail",
						"For International Channel, DW is displayed with the Per Month Price",
						"per Month must be displayed for the DW Channel",
						"per Month is NOT displayed for the DW Channel");

			Thread.sleep(8000);
			config_page_Cart_result_updater_1(br,drive);
			Thread.sleep(5000);

			if (itemname[0].equals(return_text(
					".//*[@id='1-3H4H2-1-2B7G-3']/td[4]", drive).trim())
					&& itemcost[0].replace("$", "").equals(
							Decimal_Amount.toString()))
				statusTracker(br,drive, 
						"Pass",
						"For International Channel, DW Price is Updated in the Cart as chosen",
						itemname[0] + " - " + itemcost[0]
								+ " must be displayed for the DW Channel",
						"DW Channel price must be displayed as chosen");
			else
				statusTracker(br,drive, 
						"Fail",
						"For International Channel, DW Price is Updated in the Cart as chosen",
						itemname[0] + " - " + itemcost[0]
								+ " must be displayed for the DW Channel",
						"DW Channel price is NOT be displayed as chosen");

		} else
			statusTracker(br,drive, 
					"Fail",
					"Under the International Channel the DW Channel is selected/displayed",
					"DW Channel is NOT selected/displayed",
					"DW Channel is selected/displayed");

		statusTracker(br,drive, " ",
				"Adding one more International Channels - TV5 Monde", " ", " ");

		// TV5 Monde Channel
		if (Isavailable(".//*[@id='1-3H4H2-1-2B8O-4']/td[1]/input", drive)) {
			statusTracker(br,drive, 
					"Pass",
					"Under the International Channel the TV5 Monde Channel is available for the selection",
					"TV5 Monde Channel must be available",
					"TV5 Monde Channel is displayed");
			drive.findElement(
					By.xpath(".//*[@id='1-3H4H2-1-2B8O-4']/td[1]/input"))
					.click();
			Thread.sleep(5000);

			if (Isavailable(".//*[@id='1-3H4H2-1-2B8O-4']/td[5]/a", drive)) {
				drive.findElement(
						By.xpath(".//*[@id='1-3H4H2-1-2B8O-4']/td[5]/a"))
						.click();
				statusTracker(br,drive, 
						"Pass",
						"Under the International Channel the TV5 Monde Channel, the long description is able to expand",
						"TV5 Monde Channel Description must be displayed",
						"TV5 Monde Channel Description is displayed");
				Thread.sleep(3000);

				drive.findElement(
						By.xpath(".//*[@id='1-3H4H2-1-2B8O-4']/td[5]/a"))
						.click();
				statusTracker(br,drive, 
						"Pass",
						"Under the International Channel the TV5 Monde Channel, the long description is able to Collapse",
						"TV5 Monde Channel Description must Collapsed",
						"TV5 Monde Channel Description is collapsed");
				Thread.sleep(2000);
			}

			String price = drive.findElement(
					By.xpath(".//*[@id='1-3H4H2-1-2B8O-4']/td[6]/div"))
					.getText();
			int index_start = price.indexOf("$");
			logger.info(Integer.toString(index_start));

			int index_end = index_start + 5;
			logger.info(Integer.toString(index_end));
			String start_amount = price.substring(index_start, index_end);
			Double Decimal_Amount = Double.parseDouble(start_amount.replace(
					"$", "")) / 100;

			if (return_text(".//*[@id='1-3H4H2-1-2B8O-4']/td[6]/div/span",
					drive).trim().equals("per Month"))
				statusTracker(br,drive, 
						"Pass",
						"For International Channel, TV5 Monde is displayed with the Per Month Price",
						"per Month must be displayed for the TV5 Monde Channel",
						"per Month is displayed for the TV5 Monde Channel");
			else
				statusTracker(br,drive, 
						"Fail",
						"For International Channel, TV5 Monde is displayed with the Per Month Price",
						"per Month must be displayed for the TV5 Monde Channel",
						"per Month is NOT displayed for the TV5 Monde Channel");

			Thread.sleep(8000);
			config_page_Cart_result_updater_1(br,drive);
			Thread.sleep(5000);

			if (itemname[1].equals(return_text(
					".//*[@id='1-3H4H2-1-2B8O-4']/td[4]", drive).trim())
					&& itemcost[1].replace("$", "").equals(
							Decimal_Amount.toString()))
				statusTracker(br,drive, 
						"Pass",
						"For International Channel, TV5 Monde Price is Updated in the Cart as chosen",
						itemname[1]
								+ " - "
								+ itemcost[1]
								+ " must be displayed for the TV5 Monde Channel",
						"TV5 Monde Channel price must be displayed as chosen");
			else
				statusTracker(br,drive, 
						"Fail",
						"For International Channel, TV5 Monde Price is Updated in the Cart as chosen",
						itemname[1]
								+ " - "
								+ itemcost[1]
								+ " must be displayed for the TV5 Monde Channel",
						"TV5 Monde Channel price is NOT be displayed as chosen");

		} else
			statusTracker(br,drive, 
					"Fail",
					"Under the International Channel the TV5 Monde Channel is selected/displayed",
					"TV5 Monde Channel is NOT selected/displayed",
					"TV5 Monde Channel is selected/displayed");

		statusTracker(br,drive, " ",
				"Removing the Added International Channel - TV5 Monde", " ",
				" ");

		// TV5 Monde Channel
		if (Isavailable(".//*[@id='1-3H4H2-1-2B8O-4']/td[1]/input", drive)) {
			statusTracker(br,drive, 
					"Pass",
					"Under the International Channel the TV5 Monde is available for the De-selection",
					"TV5 Monde Channel must be available",
					"TV5 Monde Channel is displayed");
			drive.findElement(
					By.xpath(".//*[@id='1-3H4H2-1-2B8O-4']/td[1]/input"))
					.click();
			Thread.sleep(2000);

			String price = drive.findElement(
					By.xpath(".//*[@id='1-3H4H2-1-2B8O-4']/td[6]/div"))
					.getText();
			int index_start = price.indexOf("$");
			logger.info(Integer.toString(index_start));

			int index_end = index_start + 5;
			logger.info(Integer.toString(index_end));
			String start_amount = price.substring(index_start, index_end);
			Double Decimal_Amount = Double.parseDouble(start_amount.replace(
					"$", "")) / 100;

			Thread.sleep(8000);
			config_page_Cart_result_updater_1(br,drive);
			Thread.sleep(5000);

			if (itemname[1].equals(return_text(
					".//*[@id='1-3H4H2-1-2B8O-4']/td[4]", drive).subSequence(
					0,
					(return_text(".//*[@id='1-3H4H2-1-2B8O-4']/td[4]", drive)
							.trim().length() - 1)))
					&& itemcost[1].replace("$", "").equals(
							Decimal_Amount.toString()))
				statusTracker(br,drive, 
						"Fail",
						"For International Channel, TV5 Monde Price is NOT Removed from the cart",
						"TV5 Monde Channel is  displayed in the Cart",
						"TV5 Monde Channel price is NOT displayed");
			else
				statusTracker(br,drive, 
						"Pass",
						"For International Channel, TV5 Monde Price is Removed from the cart",
						"TV5 Monde Channel must be NOT be displayed in the Cart",
						"TV5 Monde Channel price is NOT displayed");
		} else
			statusTracker(br,drive, 
					"Fail",
					"Under the International Channel the TV5 Monde Channel is selected/displayed",
					"TV5 Monde Channel is NOT selected/displayed",
					"TV5 Monde Channel is selected/displayed");
	}

	public void Customization_TV_addVarietyChannels(String br, WebDriver drive)
			throws InterruptedException {
		logger.info("Variety Channels");
		Thread.sleep(2000);
		logger.info("Variety Channels one : "
				+ Isavailable(
						".//*[@class='tab-nav-wrap mobile-hidden']/ul/li[4]/a",
						drive));
		Thread.sleep(2000);
		drive.findElement(
				By.xpath(".//*[@class='tab-nav-wrap mobile-hidden']/ul/li[3]/a"))
				.click();
		Thread.sleep(5000);

		if (return_text(
				".//*[@class='collapsible-channels varietyChannels']/div/h4",
				drive).trim().equals("More Entertainment for Everyone"))
			statusTracker(br,drive, "Pass", "Verify the Variety Channels section",
					"Variety Channels tab is displayed",
					"Variety Channels tab Should be displayed");
		else
			statusTracker(br,drive, "Fail", "Verify the Variety Channels section",
					"Variety Channels tab is NOT displayed",
					"Variety Channels tab Should be displayed");

		// Disney On Demand Channel
		if (Isavailable(".//*[@id='1-3QU7U-1-2BHG-1']/td[1]/input", drive)) {
			statusTracker(br,drive, 
					"Pass",
					"Under the Variety Channel the Disney On Demand Channel is available for the selection",
					"Disney On Demand Channel must be available",
					"Disney On Demand Channel is displayed");
			drive.findElement(
					By.xpath(".//*[@id='1-3QU7U-1-2BHG-1']/td[1]/input"))
					.click();
			Thread.sleep(5000);

			if (Isavailable(".//*[@id='1-3QU7U-1-2BHG-1']/td[5]/a", drive)) {
				drive.findElement(
						By.xpath(".//*[@id='1-3QU7U-1-2BHG-1']/td[5]/a"))
						.click();
				statusTracker(br,drive, 
						"Pass",
						"Under the Variety Channel the Disney On Demand Channel, the long description is able to expand",
						"Disney On Demand Channel Description must be displayed",
						"Disney On Demand Channel Description is displayed");
				Thread.sleep(3000);

				drive.findElement(
						By.xpath(".//*[@id='1-3QU7U-1-2BHG-1']/td[5]/a"))
						.click();
				statusTracker(br,drive, 
						"Pass",
						"Under the Variety Channel the Disney On Demand Channel, the long description is able to Collapse",
						"Disney On Demand Channel Description must Collapsed",
						"Disney On Demand Channel Description is collapsed");
				Thread.sleep(2000);
			}
			String price = drive.findElement(
					By.xpath(".//*[@id='1-3QU7U-1-2BHG-1']/td[6]/div"))
					.getText();
			int index_start = price.indexOf("$");
			logger.info(Integer.toString(index_start));

			int index_end = index_start + 5;
			logger.info(Integer.toString(index_end));
			String start_amount = price.substring(index_start, index_end);
			Double Decimal_Amount = Double.parseDouble(start_amount.replace(
					"$", "")) / 100;
			if (return_text(".//*[@id='1-3QU7U-1-2BHG-1']/td[6]/div/span",
					drive).trim().equals("per Month"))
				statusTracker(br,drive, 
						"Pass",
						"For Variety Channel, Disney On Demand is displayed with the Per Month Price",
						"per Month must be displayed for the Disney On Demand Channel",
						"per Month is displayed for the Disney On Demand Channel");
			else
				statusTracker(br,drive, 
						"Fail",
						"For Variety Channel, Disney On Demand is displayed with the Per Month Price",
						"per Month must be displayed for the Disney On Demand Channel",
						"per Month is NOT displayed for the Disney On Demand Channel");

			Thread.sleep(8000);
			config_page_Cart_result_updater_1(br,drive);
			Thread.sleep(5000);

			if (itemname[0].equals(return_text(
					".//*[@id='1-3QU7U-1-2BHG-1']/td[4]", drive).trim())
					&& itemcost[0].replace("$", "").equals(
							Decimal_Amount.toString()))
				statusTracker(br,drive, 
						"Pass",
						"For Variety Channel, Disney On Demand Price is Updated in the Cart as chosen",
						itemname[0]
								+ " - "
								+ itemcost[0]
								+ " must be displayed for the Disney On Demand Channel",
						"Disney On Demand Channel price must be displayed as chosen");
			else
				statusTracker(br,drive, 
						"Fail",
						"For Variety Channel, Disney On Demand Price is Updated in the Cart as chosen",
						itemname[0]
								+ " - "
								+ itemcost[0]
								+ " must be displayed for the Disney On Demand Channel",
						"Disney On Demand Channel price is NOT be displayed as chosen");

		} else
			statusTracker(br,drive, 
					"Fail",
					"Under the Variety Channel the Disney On Demand Channel is selected/displayed",
					"Disney On Demand Channel is NOT selected/displayed",
					"Disney On Demand Channel is selected/displayed");

		statusTracker(br,drive, " ", "Adding one more Variety Channels - TWC Movie Pass",
				" ", " ");

		// TWC Movie Pass Channel
		if (Isavailable(".//*[@id='1-3QU7U-1-3QU01-4']/td[1]/input", drive)) {
			statusTracker(br,drive, 
					"Pass",
					"Under the Variety Channel the TWC Movie Pass Channel is available for the selection",
					"TWC Movie Pass Channel must be available",
					"TWC Movie Pass Channel is displayed");
			drive.findElement(
					By.xpath(".//*[@id='1-3QU7U-1-3QU01-4']/td[1]/input"))
					.click();
			Thread.sleep(5000);

			if (Isavailable(".//*[@id='1-3QU7U-1-3QU01-4']/td[5]/a", drive)) {
				drive.findElement(
						By.xpath(".//*[@id='1-3QU7U-1-3QU01-4']/td[5]/a"))
						.click();
				statusTracker(br,drive, 
						"Pass",
						"Under the Variety Channel the TWC Movie Pass Channel, the long description is able to expand",
						"TWC Movie Pass Channel Description must be displayed",
						"TWC Movie Pass Channel Description is displayed");
				Thread.sleep(3000);

				drive.findElement(
						By.xpath(".//*[@id='1-3QU7U-1-3QU01-4']/td[5]/a"))
						.click();
				statusTracker(br,drive, 
						"Pass",
						"Under the Variety Channel the TWC Movie Pass Channel, the long description is able to Collapse",
						"TWC Movie Pass Channel Description must Collapsed",
						"TWC Movie Pass Channel Description is collapsed");
				Thread.sleep(2000);
			}

			String price = drive.findElement(
					By.xpath(".//*[@id='1-3QU7U-1-3QU01-4']/td[6]/div"))
					.getText();
			int index_start = price.indexOf("$");
			logger.info(Integer.toString(index_start));

			int index_end = index_start + 5;
			logger.info(Integer.toString(index_end));
			String start_amount = price.substring(index_start, index_end);
			Double Decimal_Amount = Double.parseDouble(start_amount.replace(
					"$", "")) / 100;

			if (return_text(".//*[@id='1-3QU7U-1-3QU01-4']/td[6]/div/span",
					drive).trim().equals("per Month"))
				statusTracker(br,drive, 
						"Pass",
						"For Variety Channel, TWC Movie Pass is displayed with the Per Month Price",
						"per Month must be displayed for the TWC Movie Pass Channel",
						"per Month is displayed for the TWC Movie Pass Channel");
			else
				statusTracker(br,drive, 
						"Fail",
						"For Variety Channel, TWC Movie Pass is displayed with the Per Month Price",
						"per Month must be displayed for the TWC Movie Pass Channel",
						"per Month is NOT displayed for the TWC Movie Pass Channel");

			Thread.sleep(8000);
			config_page_Cart_result_updater_1(br,drive);
			Thread.sleep(5000);

			if (itemname[1].equals(return_text(
					".//*[@id='1-3QU7U-1-3QU01-4']/td[4]", drive).trim())
					&& itemcost[1].replace("$", "").equals(
							Decimal_Amount.toString()))
				statusTracker(br,drive, 
						"Pass",
						"For Variety Channel, TWC Movie Pass Price is Updated in the Cart as chosen",
						itemname[1]
								+ " - "
								+ itemcost[1]
								+ " must be displayed for the TWC Movie Pass Channel",
						"TWC Movie Pass Channel price must be displayed as chosen");
			else
				statusTracker(br,drive, 
						"Fail",
						"For Variety Channel, TWC Movie Pass Price is Updated in the Cart as chosen",
						itemname[1]
								+ " - "
								+ itemcost[1]
								+ " must be displayed for the TWC Movie Pass Channel",
						"TWC Movie Pass Channel price is NOT be displayed as chosen");

		} else
			statusTracker(br,drive, 
					"Fail",
					"Under the Variety Channel the TWC Movie Pass Channel is selected/displayed",
					"TWC Movie Pass Channel is NOT selected/displayed",
					"TWC Movie Pass Channel is selected/displayed");

		statusTracker(br,drive, " ",
				"Removing the Added Variety Channel - TWC Movie Pass", " ", " ");

		// TWC Movie Pass Channel
		if (Isavailable(".//*[@id='1-3QU7U-1-3QU01-4']/td[1]/input", drive)) {
			statusTracker(br,drive, 
					"Pass",
					"Under the Variety Channel the TWC Movie Pass is available for the De-selection",
					"TWC Movie Pass Channel must be available",
					"TWC Movie Pass Channel is displayed");
			drive.findElement(
					By.xpath(".//*[@id='1-3QU7U-1-3QU01-4']/td[1]/input"))
					.click();
			Thread.sleep(2000);

			String price = drive.findElement(
					By.xpath(".//*[@id='1-3QU7U-1-3QU01-4']/td[6]/div"))
					.getText();
			int index_start = price.indexOf("$");
			logger.info(Integer.toString(index_start));

			int index_end = index_start + 5;
			logger.info(Integer.toString(index_end));
			String start_amount = price.substring(index_start, index_end);
			Double Decimal_Amount = Double.parseDouble(start_amount.replace(
					"$", "")) / 100;

			Thread.sleep(8000);
			config_page_Cart_result_updater_1(br,drive);
			Thread.sleep(5000);

			if (itemname[1].equals(return_text(
					".//*[@id='1-3QU7U-1-3QU01-4']/td[4]", drive).subSequence(
					0,
					(return_text(".//*[@id='1-3QU7U-1-3QU01-4']/td[4]", drive)
							.trim().length() - 1)))
					&& itemcost[1].replace("$", "").equals(
							Decimal_Amount.toString()))
				statusTracker(br,drive, 
						"Fail",
						"For Variety Channel, TWC Movie Pass Price is NOT Removed from the cart",
						"TWC Movie Pass Channel is  displayed in the Cart",
						"TWC Movie Pass Channel price is NOT displayed");
			else
				statusTracker(br,drive, 
						"Pass",
						"For Variety Channel, TWC Movie Pass Price is Removed from the cart",
						"TWC Movie Pass Channel must be NOT be displayed in the Cart",
						"TWC Movie Pass Channel price is NOT displayed");
		} else
			statusTracker(br,drive, 
					"Fail",
					"Under the Variety Channel the TWC Movie Pass Channel is selected/displayed",
					"TWC Movie Pass Channel is NOT selected/displayed",
					"TWC Movie Pass Channel is selected/displayed");
	}

	public void Customization_TV_addSportsChannels_OneTimePricing(String br, WebDriver drive) throws InterruptedException {
		logger.info("Sports Channels - OneTime");
		Thread.sleep(2000);
		logger.info("Sports Channels one : "
				+ Isavailable(
						".//*[@class='tab-nav-wrap mobile-hidden']/ul/li[2]/a",
						drive));
		Thread.sleep(2000);
		drive.findElement(
				By.xpath(".//*[@class='tab-nav-wrap mobile-hidden']/ul/li[2]/a"))
				.click();
		Thread.sleep(5000);

		if (return_text(".//*[@class='sports sports-channels']/div/h4[1]",
				drive).trim().equals("Seasonal Sports Packages"))
			statusTracker(br,drive, "Pass", "Verify the Sports Channels section",
					"Sports Channels tab is displayed",
					"Sports Channels tab Should be displayed");
		else
			statusTracker(br,drive, "Fail", "Verify the Sports Channels section",
					"Sports Channels tab is NOT displayed",
					"Sports Channels tab Should be displayed");

		// MLS Direct Kick Channel
		if (drive.findElement(By.xpath("//input[@id='1-2BNH']")).isEnabled())
			statusTracker(br,drive, 
					"Fail",
					"Verify the MLS Direct Kick Channels - One time price is Disabled, if the checkbox is Not selected",
					"MLS Direct Kick Channels - One Time Price is NOT disabled",
					"MLS Direct Kick Channels - One time Price should be disabled");
		else
			statusTracker(br,drive, 
					"Pass",
					"Verify the MLS Direct Kick Channels - One time price is Disabled, if the checkbox is Not selected",
					"MLS Direct Kick Channels - One Time Price is disabled",
					"MLS Direct Kick Channels - One time Price should be disabled");

		if (Isavailable("//input[@data-name='MLS Direct Kick']", drive)) {
			statusTracker(br,drive, 
					"Pass",
					"Under the  Channel the MLS Direct Kick Channel is available for selection",
					"MLS Direct Kick Channel must be available",
					"MLS Direct Kick Channel is displayed");
			drive.findElement(By.xpath("//input[@data-name='MLS Direct Kick']"))
					.click();
			Thread.sleep(5000);

			if (Isavailable(
					".//*[@class='sports js-table-expander-initialized']/tbody/tr[2]/td[6]/a",
					drive)) {
				drive.findElement(
						By.xpath(".//*[@class='sports js-table-expander-initialized']/tbody/tr[2]/td[6]/a"))
						.click();
				statusTracker(br,drive, 
						"Pass",
						"Under the Sports Channel the MLS Direct Kick Channel, the long description is able to expand",
						"MLS Direct Kick Channel Description must be displayed",
						"MLS Direct Kick Channel Description is displayed");
				Thread.sleep(3000);

				drive.findElement(
						By.xpath(".//*[@class='sports js-table-expander-initialized']/tbody/tr[2]/td[6]/a"))
						.click();
				statusTracker(br,drive, 
						"Pass",
						"Under the Sports Channel the MLS Direct Kick Channel, the long description is able to Collapse",
						"MLS Direct Kick Channel Description must Collapsed",
						"MLS Direct Kick Channel Description is collapsed");
				Thread.sleep(2000);
			}
			String price1 = drive
					.findElement(By.xpath("//label[@for='1-2BNH']")).getText()
					.trim();

			int index_start = price1.indexOf("$");
			int index_end = index_start + 5;
			String start_amount = price1.substring(index_start, index_end);
			Double Decimal_Amount = Double.parseDouble(start_amount.replace(
					"$", "")) / 100;

			Thread.sleep(8000);
			page_Cart_One_Time_charge_updater_ValidateSportsChannel(br,drive);
			page_Cart_One_Time_charge_updater_ValidateSportsChannel_AllChkedData(br,drive);
			Thread.sleep(5000);

			String actual_ChannelName = return_text(
					".//*[@class='sports js-table-expander-initialized']/tbody/tr[2]/td[5]",
					drive).trim();
			String only_ChannelName = actual_ChannelName
					.subSequence(0, actual_ChannelName.indexOf("Season"))
					.toString().trim();

			if (itemname_mon[0].equals(only_ChannelName)
					&& itemcost_mon[0].replace("$", "").equals(
							df.format(Decimal_Amount)))
				statusTracker(br,drive, 
						"Pass",
						"For Sports Channel, MLS Direct Kick Price is Updated in the Cart as chosen",
						itemname_mon[0]
								+ " - "
								+ itemcost_mon[0]
								+ " must be displayed for the MLS Direct Kick Channel",
						"MLS Direct Kick Channel price must be displayed as chosen");
			else
				statusTracker(br,drive, 
						"Fail",
						"For Sports Channel, MLS Direct Kick Price is Updated in the Cart as chosen",
						itemname_mon[0]
								+ " - "
								+ itemcost_mon[0]
								+ " must be displayed for the MLS Direct Kick Channel",
						"MLS Direct Kick Channel price is NOT be displayed as chosen");
		} else
			statusTracker(br,drive, 
					"Fail",
					"Under the Sports Channel the MLS Direct Kick Channel is NOT selected/displayed",
					"MLS Direct Kick Channel is NOT selected/displayed",
					"MLS Direct Kick Channel is selected/displayed");

		statusTracker(br,drive, " ", "Adding one more Sports Channels - NBA League Pass",
				" ", " ");

		// NBA League Pass Channel
		if (drive.findElement(By.xpath("//input[@id='1-2BNS']")).isEnabled())
			statusTracker(br,drive, 
					"Fail",
					"Verify the NBA League Pass Channels - One time price is Disabled, if the checkbox is Not selected",
					"NBA League Pass Channels - One Time Price is NOT disabled",
					"NBA League Pass Channels - One time Price should be disabled");
		else
			statusTracker(br,drive, 
					"Pass",
					"Verify the MLS Direct Kick Channels - One time price is Disabled, if the checkbox is Not selected",
					"MLS Direct Kick Channels - One Time Price is disabled",
					"MLS Direct Kick Channels - One time Price should be disabled");

		if (Isavailable("//input[@data-name='NBA League Pass']", drive)) {
			statusTracker(br,drive, 
					"Pass",
					"Under the  Channel the NBA League Pass Channel is available for selection",
					"NBA League Pass Channel must be available",
					"NBA League Pass Channel is displayed");
			drive.findElement(By.xpath("//input[@data-name='NBA League Pass']"))
					.click();
			Thread.sleep(5000);

			if (Isavailable(
					".//*[@class='sports js-table-expander-initialized']/tbody/tr[4]/td[6]/a",
					drive)) {
				drive.findElement(
						By.xpath(".//*[@class='sports js-table-expander-initialized']/tbody/tr[4]/td[6]/a"))
						.click();
				statusTracker(br,drive, 
						"Pass",
						"Under the Sports Channel the NBA League Pass Channel, the long description is able to expand",
						"NBA League Pass Channel Description must be displayed",
						"NBA League Pass Channel Description is displayed");
				Thread.sleep(3000);

				drive.findElement(
						By.xpath(".//*[@class='sports js-table-expander-initialized']/tbody/tr[4]/td[6]/a"))
						.click();
				statusTracker(br,drive, 
						"Pass",
						"Under the Sports Channel the NBA League Pass Channel, the long description is able to Collapse",
						"NBA League Pass Channel Description must Collapsed",
						"NBA League Pass Channel Description is collapsed");
				Thread.sleep(2000);
			}
			String price2 = drive
					.findElement(By.xpath("//label[@for='1-2BNS']")).getText()
					.trim();

			int index_start = price2.indexOf("$");
			int index_end = index_start + 5;
			String start_amount = price2.substring(index_start, index_end);
			Double Decimal_Amount = Double.parseDouble(start_amount.replace(
					"$", "")) / 100;

			Thread.sleep(8000);
			page_Cart_One_Time_charge_updater_ValidateSportsChannel(br,drive);
			page_Cart_One_Time_charge_updater_ValidateSportsChannel_AllChkedData(br,drive);
			Thread.sleep(5000);

			String actual_ChannelName = return_text(
					".//*[@class='sports js-table-expander-initialized']/tbody/tr[4]/td[5]",
					drive).trim();
			String only_ChannelName = actual_ChannelName
					.subSequence(0, actual_ChannelName.indexOf("Season"))
					.toString().trim();

			if (itemname_mon[1].equals(only_ChannelName)
					&& itemcost_mon[1].replace("$", "").equals(
							df.format(Decimal_Amount)))
				statusTracker(br,drive, 
						"Pass",
						"For Sports Channel, NBA League Pass Price is Updated in the Cart as chosen",
						itemname_mon[1]
								+ " - "
								+ itemcost_mon[1]
								+ " must be displayed for the NBA League Pass Channel",
						"NBA League Pass Channel price must be displayed as chosen");
			else
				statusTracker(br,drive, 
						"Fail",
						"For Sports Channel, NBA League Pass Price is Updated in the Cart as chosen",
						itemname_mon[1]
								+ " - "
								+ itemcost_mon[1]
								+ " must be displayed for the NBA League Pass Channel",
						"NBA League Pass Channel price is NOT be displayed as chosen");

		} else
			statusTracker(br,drive, 
					"Fail",
					"Under the Sports Channel the NBA League Pass Channel is NOT selected/displayed",
					"NBA League Pass Channel is NOT selected/displayed",
					"NBA League Pass Channel is selected/displayed");

		statusTracker(br,drive, " ",
				"Removing the Added Sports Channel - NBA League Pass", " ", " ");

		// NBA League Pass Channel
		if (Isavailable("//input[@data-name='NBA League Pass']", drive)) {
			statusTracker(br,drive, 
					"Pass",
					"Under the Sports Channel the NBA League Pass is available for De-selection",
					"NBA League Pass Channel must be available",
					"NBA League Pass Channel is displayed");
			drive.findElement(By.xpath("//input[@data-name='NBA League Pass']"))
					.click();
			Thread.sleep(5000);

			String price3 = drive.findElement(
					By.xpath("//label[@for='1-2BNS']")).getText();

			int index_start = price3.indexOf("$");
			int index_end = index_start + 5;
			String start_amount = price3.substring(index_start, index_end);
			Double Decimal_Amount = Double.parseDouble(start_amount.replace(
					"$", "")) / 100;

			Thread.sleep(8000);
			page_Cart_One_Time_charge_updater_ValidateSportsChannel(br,drive);
			Thread.sleep(5000);

			if (mon_total_items == new_mon_total_items)
				statusTracker(br,drive, 
						"Fail",
						"For Sports Channel, NBA League Pass Price is Removed from the cart",
						"NBA League Pass Channel is  displayed in the Cart",
						"NBA League Pass Channel price is NOT displayed");
			else
				statusTracker(br,drive, 
						"Pass",
						"For Sports Channel, NBA League Pass Price is Removed from the cart",
						"NBA League Pass Channel must be NOT be displayed in the Cart",
						"NBA League Pass Channel price is NOT displayed");

		} else
			statusTracker(br,drive, 
					"Fail",
					"Under the Sports Channel the NBA League Pass Channel is selected/displayed",
					"NBA League Pass Channel is NOT selected/displayed",
					"NBA League Pass Channel is selected/displayed");
	}

	public void Select_DropDown(WebDriver driver, String fxp, String option)
			throws InterruptedException

	{
		WebElement dropDownListBox = driver.findElement(By.xpath(fxp));
        Actions actions = new Actions(driver);
		actions.moveToElement(dropDownListBox);
		actions.perform();                 

		Select clickThis = new Select(dropDownListBox);
		Thread.sleep(5000);
		clickThis.selectByVisibleText(option);
		Thread.sleep(5000);
	}
	
	public void Customization_TV_addSportsChannels_InstallmentPricing(String br, WebDriver drive) throws InterruptedException {
		logger.info("Sports Channels - Installment");
		Thread.sleep(2000);
		logger.info("Sports Channels one : "
				+ Isavailable(
						".//*[@class='tab-nav-wrap mobile-hidden']/ul/li[2]/a",
						drive));
		Thread.sleep(2000);
		drive.findElement(
				By.xpath(".//*[@class='tab-nav-wrap mobile-hidden']/ul/li[2]/a"))
				.click();
		Thread.sleep(5000);

		if (return_text(".//*[@class='sports sports-channels']/div/h4[1]",
				drive).trim().equals("Seasonal Sports Packages"))
			statusTracker(br,drive, "Pass", "Verify the Sports Channels section",
					"Sports Channels tab is displayed",
					"Sports Channels tab Should be displayed");
		else
			statusTracker(br,drive, "Fail", "Verify the Sports Channels section",
					"Sports Channels tab is NOT displayed",
					"Sports Channels tab Should be displayed");

		// MLS Direct Kick Channel
		if (!drive.findElement(By.xpath(".//*[@id='1-2BNH2']")).isEnabled() && !drive.findElement(By.xpath(".//*[@id='1-2BNH2']")).isSelected())
			statusTracker(br,drive, 
					"Pass",
					"Verify the MLS Direct Kick Channels - Installment price is Disabled & Not selected",
					"MLS Direct Kick Channels - Installment Price is disabled & Not selected",
					"MLS Direct Kick Channels - Installment Price should be disabled & Not selected");
		else
			statusTracker(br,drive, 
				"Fail",
				"Verify the MLS Direct Kick Channels - Installment price is Disabled & Not selected",
				"MLS Direct Kick Channels - Installment Price is NOT disabled & selected",
				"MLS Direct Kick Channels - Installment Price should be disabled & Not selected");

		if (Isavailable("//input[@data-name='MLS Direct Kick']", drive)) {
			statusTracker(br,drive, 
					"Pass",
					"Under the  Channel the MLS Direct Kick Channel is available for selection",
					"MLS Direct Kick Channel must be available",
					"MLS Direct Kick Channel is displayed");
			drive.findElement(By.xpath("//input[@data-name='MLS Direct Kick']"))
					.click();
			Thread.sleep(5000);

			if (Isavailable(
					".//*[@class='sports js-table-expander-initialized']/tbody/tr[2]/td[6]/a",
					drive)) {
				drive.findElement(
						By.xpath(".//*[@class='sports js-table-expander-initialized']/tbody/tr[2]/td[6]/a"))
						.click();
				statusTracker(br,drive, 
						"Pass",
						"Under the Sports Channel the MLS Direct Kick Channel, the long description is able to expand",
						"MLS Direct Kick Channel Description must be displayed",
						"MLS Direct Kick Channel Description is displayed");
				Thread.sleep(3000);

				drive.findElement(
						By.xpath(".//*[@class='sports js-table-expander-initialized']/tbody/tr[2]/td[6]/a"))
						.click();
				statusTracker(br,drive, 
						"Pass",
						"Under the Sports Channel the MLS Direct Kick Channel, the long description is able to Collapse",
						"MLS Direct Kick Channel Description must Collapsed",
						"MLS Direct Kick Channel Description is collapsed");
				Thread.sleep(2000);
			}
			
			drive.findElement(By.xpath(".//*[@id='1-2BNH2']")).click();
			Thread.sleep(2000);
			
			String price1 = drive
					.findElement(By.xpath("//label[@for='1-2BNH2']")).getText()
					.trim();

			int index_start = price1.indexOf("$");
			int index_end = index_start + 5;
			String start_amount = price1.substring(index_start, index_end);
			Double Decimal_Amount = Double.parseDouble(start_amount.replace(
					"$", "")) / 100;

			Thread.sleep(8000);
			page_Cart_One_Time_charge_updater_ValidateSportsChannel(br,drive);
			page_Cart_One_Time_charge_updater_ValidateSportsChannel_AllChkedData(br,drive);
			Thread.sleep(5000);

			String actual_ChannelName = return_text(
					".//*[@class='sports js-table-expander-initialized']/tbody/tr[2]/td[5]",
					drive).trim();
			String only_ChannelName = actual_ChannelName
					.subSequence(0, actual_ChannelName.indexOf("Season"))
					.toString().trim();

			if (itemname_mon[0].equals(only_ChannelName)
					&& itemcost_mon[0].replace("$", "").replace("†", "").replace("‡", "").trim().equals(
							df.format(Decimal_Amount)))
				statusTracker(br,drive, 
						"Pass",
						"For Sports Channel, MLS Direct Kick Price is Updated in the Cart as chosen",
						itemname_mon[0]
								+ " - "
								+ itemcost_mon[0]
								+ " must be displayed for the MLS Direct Kick Channel",
						"MLS Direct Kick Channel price must be displayed as chosen");
			else
				statusTracker(br,drive, 
						"Fail",
						"For Sports Channel, MLS Direct Kick Price is Updated in the Cart as chosen",
						itemname_mon[0]
								+ " - "
								+ itemcost_mon[0]
								+ " must be displayed for the MLS Direct Kick Channel",
						"MLS Direct Kick Channel price is NOT be displayed as chosen");
		} else
			statusTracker(br,drive, 
					"Fail",
					"Under the Sports Channel the MLS Direct Kick Channel is NOT selected/displayed",
					"MLS Direct Kick Channel is NOT selected/displayed",
					"MLS Direct Kick Channel is selected/displayed");

		statusTracker(br,drive, " ", "Adding one more Sports Channels - NBA League Pass",
				" ", " ");

		// NBA League Pass Channel
		if (!drive.findElement(By.xpath("//input[@id='1-2BNS2']")).isEnabled() && !drive.findElement(By.xpath(".//*[@id='1-2BNS2']")).isSelected())
			statusTracker(br,drive, 
					"Pass",
					"Verify the NBA League Pass Channels - Installment price is Disabled & Not selected",
					"NBA League Pass Channels - Installment Price is disabled & Not selected",
					"NBA League Pass Channels - Installment Price should be disabled & Not selected");
		else
			statusTracker(br,drive, 
				"Fail",
				"Verify the NBA League Pass Channels - Installment price is Disabled & Not selected",
				"NBA League Pass Channels - Installment Price is NOT disabled & selected",
				"NBA League Pass Channels - Installment Price should be disabled & Not selected");
		
		if (Isavailable("//input[@data-name='NBA League Pass']", drive)) {
			statusTracker(br,drive, 
					"Pass",
					"Under the  Channel the NBA League Pass Channel is available for selection",
					"NBA League Pass Channel must be available",
					"NBA League Pass Channel is displayed");
			drive.findElement(By.xpath("//input[@data-name='NBA League Pass']"))
					.click();
			Thread.sleep(5000);

			if (Isavailable(
					".//*[@class='sports js-table-expander-initialized']/tbody/tr[4]/td[6]/a",
					drive)) {
				drive.findElement(
						By.xpath(".//*[@class='sports js-table-expander-initialized']/tbody/tr[4]/td[6]/a"))
						.click();
				statusTracker(br,drive, 
						"Pass",
						"Under the Sports Channel the NBA League Pass Channel, the long description is able to expand",
						"NBA League Pass Channel Description must be displayed",
						"NBA League Pass Channel Description is displayed");
				Thread.sleep(3000);

				drive.findElement(
						By.xpath(".//*[@class='sports js-table-expander-initialized']/tbody/tr[4]/td[6]/a"))
						.click();
				statusTracker(br,drive, 
						"Pass",
						"Under the Sports Channel the NBA League Pass Channel, the long description is able to Collapse",
						"NBA League Pass Channel Description must Collapsed",
						"NBA League Pass Channel Description is collapsed");
				Thread.sleep(2000);
			}
			
			drive.findElement(By.xpath(".//*[@id='1-2BNS2']")).click();
			Thread.sleep(2000);
			
			String price2 = drive
					.findElement(By.xpath("//label[@for='1-2BNS2']")).getText().replace("*", "")
					.trim();

			int index_start = price2.indexOf("$");
			int index_end = index_start + 5;
			String start_amount = price2.substring(index_start, index_end);
			Double Decimal_Amount = Double.parseDouble(start_amount.replace(
					"$", "")) / 100;

			Thread.sleep(8000);
			page_Cart_One_Time_charge_updater_ValidateSportsChannel(br,drive);
			page_Cart_One_Time_charge_updater_ValidateSportsChannel_AllChkedData(br,drive);
			Thread.sleep(5000);

			String actual_ChannelName = return_text(
					".//*[@class='sports js-table-expander-initialized']/tbody/tr[4]/td[5]",
					drive).trim();
			String only_ChannelName = actual_ChannelName
					.subSequence(0, actual_ChannelName.indexOf("Season"))
					.toString().trim();

			if (itemname_mon[1].equals(only_ChannelName)
					&& itemcost_mon[1].replace("$", "").replace("†", "").replace("‡", "").trim().equals(
							df.format(Decimal_Amount)))
				statusTracker(br,drive, 
						"Pass",
						"For Sports Channel, NBA League Pass Price is Updated in the Cart as chosen",
						itemname_mon[1]
								+ " - "
								+ itemcost_mon[1]
								+ " must be displayed for the NBA League Pass Channel",
						"NBA League Pass Channel price must be displayed as chosen");
			else
				statusTracker(br,drive, 
						"Fail",
						"For Sports Channel, NBA League Pass Price is Updated in the Cart as chosen",
						itemname_mon[1]
								+ " - "
								+ itemcost_mon[1]
								+ " must be displayed for the NBA League Pass Channel",
						"NBA League Pass Channel price is NOT be displayed as chosen");

		} else
			statusTracker(br,drive, 
					"Fail",
					"Under the Sports Channel the NBA League Pass Channel is NOT selected/displayed",
					"NBA League Pass Channel is NOT selected/displayed",
					"NBA League Pass Channel is selected/displayed");

		statusTracker(br,drive, " ",
				"Removing the Added Sports Channel - NBA League Pass", " ", " ");

		// NBA League Pass Channel
		if (Isavailable("//input[@data-name='NBA League Pass']", drive)) {
			statusTracker(br,drive, 
					"Pass",
					"Under the Sports Channel the NBA League Pass is available for De-selection",
					"NBA League Pass Channel must be available",
					"NBA League Pass Channel is displayed");
			drive.findElement(By.xpath("//input[@data-name='NBA League Pass']"))
					.click();
			Thread.sleep(5000);
			
			drive.findElement(By.xpath(".//*[@id='1-2BNS2']")).click();
			Thread.sleep(2000);

			String price3 = drive.findElement(
					By.xpath("//label[@for='1-2BNS2']")).getText();

			int index_start = price3.indexOf("$");
			int index_end = index_start + 5;
			String start_amount = price3.substring(index_start, index_end);
			Double Decimal_Amount = Double.parseDouble(start_amount.replace(
					"$", "")) / 100;

			Thread.sleep(8000);
			page_Cart_One_Time_charge_updater_ValidateSportsChannel(br,drive);
			Thread.sleep(5000);

			if (mon_total_items == new_mon_total_items)
				statusTracker(br,drive, 
						"Fail",
						"For Sports Channel, NBA League Pass Price is Removed from the cart",
						"NBA League Pass Channel is  displayed in the Cart",
						"NBA League Pass Channel price is NOT displayed");
			else
				statusTracker(br,drive, 
						"Pass",
						"For Sports Channel, NBA League Pass Price is Removed from the cart",
						"NBA League Pass Channel must be NOT be displayed in the Cart",
						"NBA League Pass Channel price is NOT displayed");

		} else
			statusTracker(br,drive, 
					"Fail",
					"Under the Sports Channel the NBA League Pass Channel is selected/displayed",
					"NBA League Pass Channel is NOT selected/displayed",
					"NBA League Pass Channel is selected/displayed");
	}
	
	// function added by shikha 
	
	

public void Phone_Equipment_Click(String br, WebDriver drive) {
              if (Isavailable(".//*[@name='customize_phone']", drive)) {
                     drive.findElement(By.xpath(".//*[@name='customize_phone']")).click();
                     statusTracker(br,drive, "Pass",
                                  "Phone Equipment Select Checkbox should be displayed",
                                  "Phone Equipment Select Checkbox is displayed",
                                  "Phone Equipment Select Checkbox should be displayed");
              } else
                     statusTracker(br,drive, "Fail",
                                  "Phone Equipment Select Checkbox should be displayed",
                                  "Phone Equipment Select Checkbox is NOT displayed",
                                  "Phone Equipment Select Checkbox should be displayed");
       }
public void Image_compare(String br, String environment,String Page_Phone, String Overall_Path,int Screen_Count,WebDriver driver) throws IOException{


  	 logger.info("Image  ");
   	String computerName1=InetAddress.getLocalHost().getHostName();
   	String Folder_Name=computerName1+"_BC_New_Images";
  	//Time section
       int day, month, year;
        int second, minute, hour;
        int match_count=0, unmatch_count=0 ;
        GregorianCalendar date = new GregorianCalendar();
        Long start = System.currentTimeMillis();
        
        day = date.get(Calendar.DAY_OF_MONTH);
        month = date.get(Calendar.MONTH);
        year = date.get(Calendar.YEAR);
  	 second = date.get(Calendar.SECOND);
        minute = date.get(Calendar.MINUTE);
        hour = date.get(Calendar.HOUR);
        logger.info("overlall in image.." + Overall_Path);
      String New = Overall_Path+"//Test_Results//NewImages";
      logger.info(New);
      File comp = new File(New);
     
//      logger.info(listOfFiles[0].getName());
      String count = Integer.toString(Screen_Count);
      String name = Page_Phone.concat(count) ; 
      logger.info("File " + name);
      	 
      logger.info("comparison started");
      logger.info("**********"+  "comparision started time is  "+hour+" : "+minute+" : "+second);
  	logger.info("Success");
  	//String name1 = name.replace(".jpg",".png");
	   File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File output_image = new File(Overall_Path +"//Test_Results//"+Folder_Name+ "//BRH_EBF_Phone//"+br+"//"+name+".png");
		FileUtils.copyFile(screenshot, output_image);		
		logger.info("copied file into New Images folder"+output_image);
     	File input_image=new File (Overall_Path+"//For_Image_Comparison//"+environment+"//BRH_EBF_Phone//"+br+"//"+name+".png");
     	logger.info("Master Image Name : "+input_image);
  //	File output_image=new File(New+"//"+name+".png");
  	logger.info("New Image Name : "+output_image);
  	logger.info("Image Saved");

  	BufferedImage biA = ImageIO.read(input_image);
  	logger.info("1");
  	DataBuffer dbA = biA.getData().getDataBuffer();
  	logger.info("2");
  	int sizeA = dbA.getSize();
  	logger.info("sizeA : "+sizeA);
  	logger.info("size File A " +sizeA);

  	BufferedImage biB = ImageIO.read(output_image);
  	DataBuffer dbB = biB.getData().getDataBuffer();
  	int sizeB = dbB.getSize();
  	logger.info("size File B "+sizeB);
  	logger.info("comparision started_phae1");
        second = date.get(Calendar.SECOND);
        minute = date.get(Calendar.MINUTE);
        hour = date.get(Calendar.HOUR);
  	 logger.info("**********"+  "comparision started  phase time is  "+hour+" : "+minute+" : "+second);

  	 int flag=1;
  	 if(sizeA == sizeB)
  {
  	
  	for(int i=0; i<sizeA; i++)
  	{
  	if(dbA.getElem(i) != dbB.getElem(i))
  	{
  		
  		 
  	//	logger.info("The element does not match");
  		
  		String fail_ele=dbA.toString();
  		//logger.info(+dbA.getElem(i));
  		//logger.info(+dbB.getElem(i));
  		unmatch_count++;
  		//logger.info(fail_ele);
  		flag=0;
  		
  		//break;
  	}
  	else
  	{
  		match_count++;
  	}

  	}
  	
  	
  		if (match_count>0){
  			logger.info(" size is same and pixels is  matched: so test result is pass");
  			int total_count = unmatch_count + match_count;
  			logger.info("Total elements : " +total_count );
  			logger.info("unmatch_count : " +unmatch_count );
  			logger.info("match_count : " +match_count );
  		   logger.info("",(float)match_count/(float)total_count);
  			float match_percentage = (((float)match_count/(float)total_count)*100) ; 
  			logger.info("Percentage of match : " + match_percentage);
  			if (match_percentage >=95.0000){
  			statusTracker(br,driver, 
  					"Pass",
  					"Image comparison",
  					"Size of Master Image and Input Image are same \n Size of Master image : "+sizeA+"\n Size of Input image : "+sizeB+"\n Percentage of match is above 95% \n Match Percentage :"+match_percentage,
  					"Size of Master Image and Input Image should be same and Match percentage should be above 95%");
  			    }
  			else
  			{
  				statusTracker(br,driver, 
  						"Fail",
  						"Image comparison",
  						"Size of Master Image and Input Image are same \n Size of Master image : "+sizeA+"\n Size of Input image : "+sizeB+"\n But Percentage of match is below 95% \n Match Percentage :"+match_percentage,
  						"Size of Master Image and Input Image should be same and Match percentage should be above 95%");
  				
  			}
  				
  			}
  			
  	else
  	{
  		logger.info("size is same , but  pixels is not  matched: so test result is fail");
  		statusTracker(br,driver, 
  				"Fail",
  				"Image comparison",
  				"Size of Master Image and Size of Input Image are same \n Size of Master image : "+sizeA+"\n Size of Input image : "+sizeB+"\n But none of the pixels is matched",
  				"Size of Master Image and Input Image should be same and Match percentage should be above 95%");
  	}

  }

  else
  {
  	logger.info("size is not same: so test result is fail");
  	statusTracker(br,driver, 
  			"Fail",
  			"Image comparison",
  			"Size of Master Image and Size of Input Image are not same \n Size of Master image : "+sizeA+"\n Size of Input image : "+sizeB,
  			"Size of Master Image and Input Image should be same");
  }
  	
  second = date.get(Calendar.SECOND);
  minute = date.get(Calendar.MINUTE);
  hour = date.get(Calendar.HOUR);
  //logger.info("**********"+  "comparision ended time is  "+hour+" : "+minute+" : "+second);
  Long end = System.currentTimeMillis();
  logger.info("the end time is"+end);
  float total = end - start;
  float total_sec=total/1000;
  float Total_min=total_sec/60;
  logger.info("Test execution time ******: " + Total_min + " Minutes.");
  logger.info("comparision ended");

  	
  }
public static int Col_locator_full_scan_input_sheet(String Keyword,
		String f_file1, String Sheet) throws IOException, BiffException {
	// String Sum_onetime_ChargesOption[] = new String[10];
	File ex = new File(f_file1);
	Workbook w = Workbook.getWorkbook(ex);
	//logger.info("Sheet name*****************************" + Sheet);
	Sheet s = w.getSheet(Sheet);
	//logger.info("beta....");
	int totalcount = 0;
	String dummy = "a";
	int ij = 1;
	int cn = 0;
	do {
		if (dummy != null && dummy.length() > 0) {
			dummy = s.getCell(0, ij).getContents();
			ij++;
			try {
				dummy = s.getCell(0, ij).getContents();
			} catch (Exception e) {
				cn = 1;
			}
			totalcount++;
		} else {
			cn = 1;
		}
	} while (cn == 0);

	// logger.info("total number of rows--------------->" +
	// totalcount);

	int rowNum = s.getRows();
	// logger.info("***********" +rowNum);
	int colNum = s.getColumns();

	String[][] data = new String[colNum][rowNum];
	int col_index = 0;
//logger.info("Sheet-------------------" +Sheet+ "col value" + colNum + "row value" + rowNum);

	for (int i = 0; i < colNum; i++) {
		for (int j = 0; j < rowNum; j++) {

			Cell cell = s.getCell(i, j);
			String value = cell.getContents();
			data[i][j] = value;
		//	value=value.replaceAll("(Y/N) ", "");
			//logger.info("Keyword" +Keyword);
			//logger.info("value"+value);
			if (Keyword.trim().contentEquals(value.replace("\n",""))) {
				col_index = i;

				int colval = i + 1;
				col_index = colval - 1;
				//logger.info("Row Keyword ---> " + Keyword);
				//logger.info("column index " + col_index);
				// return row_index;

			}

		}
	}
	return col_index;

}
public void afterClickOn(WebElement arg0, WebDriver arg1) {
	// TODO Auto-generated method stub
	
}

public void afterFindBy(By by, WebElement element, WebDriver driver) {
	// TODO Auto-generated method stub
	
}

public void afterNavigateBack(WebDriver arg0) {
	// TODO Auto-generated method stub
	
}

public void afterNavigateForward(WebDriver arg0) {
	// TODO Auto-generated method stub
	
}

public void afterNavigateTo(String arg0, WebDriver arg1) {
	// TODO Auto-generated method stub
	
}

public void afterScript(String arg0, WebDriver arg1) {
	// TODO Auto-generated method stub
	
}

public void beforeChangeValueOf(WebElement arg0, WebDriver arg1) {
	// TODO Auto-generated method stub
	
}

public void beforeClickOn(WebElement arg0, WebDriver driver) {
	// TODO Auto-generated method stub
	
}

public void beforeFindBy(By by, WebElement element, WebDriver driver) {
	// TODO Auto-generated method stub
	
}

public void beforeNavigateBack(WebDriver arg0) {
	// TODO Auto-generated method stub
	
}

public void beforeNavigateForward(WebDriver arg0) {
	// TODO Auto-generated method stub
	
}

public void beforeNavigateTo(String arg0, WebDriver arg1) {
	// TODO Auto-generated method stub
	
}

public void beforeScript(String arg0, WebDriver arg1) {
	// TODO Auto-generated method stub
	
}

public void onException(Throwable arg0, WebDriver arg1) {
	// TODO Auto-generated method stub
	
}

public void afterChangeValueOf(WebElement arg0, WebDriver arg1) {
	// TODO Auto-generated method stub
	
}

public static int Row_locator_full_scan_validation(String Keyword,
		String f_file1, String sheet_name) throws IOException, BiffException {
	// String Sum_onetime_ChargesOption[] = new String[10];
	File ex = new File(f_file1);
	Workbook w = Workbook.getWorkbook(ex);
	Sheet s = w.getSheet(sheet_name);

	int totalcount = 0;
	String dummy = "a";
	int ij = 1;
	int cn = 0;
	do {
		if (dummy != null && dummy.length() > 0) {
			dummy = s.getCell(0, ij).getContents();
			ij++;
			try {
				dummy = s.getCell(0, ij).getContents();
			} catch (Exception e) {
				cn = 1;
			}
			totalcount++;
		} else {
			cn = 1;
		}
	} while (cn == 0);

//	logger.info(""+"total number of rows--------------->" + totalcount);

	int rowNum = s.getRows();
	// logger.info(""+"***********" +rowNum);
	int colNum = s.getColumns();

	String[][] data = new String[colNum][rowNum];
	int row_index = 0;

	for (int i = 0; i < colNum; i++) {
		for (int j = 0; j < rowNum; j++) {

			Cell cell = s.getCell(i, j);
			String value = cell.getContents();
			data[i][j] = value;
			if (Keyword.trim().contentEquals(value.trim())) {
				row_index = j;

				int rowval = j + 1;
				row_index = rowval - 1;
			//	logger.info(""+"Row Keyword ---> " + Keyword);
			//	logger.info(""+"Row Locator ---> " + rowval);
				// return row_index;

			}

		}
	}
	return row_index;

}


/*  Method to find the column number of a particular keyword -- Added by Shivendu */

public static int Column_locator_scan_validation(String Keyword,
		String f_file1, String sheet_name) throws IOException, BiffException {
	File ex = new File(f_file1);
	Workbook w = Workbook.getWorkbook(ex);
	Sheet s = w.getSheet(sheet_name);

	int rowNum = s.getRows();
	int colNum = s.getColumns();

	int col_index = 0;
	boolean flag = false;

	for (int i = 0; i < colNum; i++) {
		for (int j = 0; j < rowNum; j++) {

			Cell cell = s.getCell(i, j);
			String value = cell.getContents();
			if (Keyword.trim().contentEquals(value.trim())) {
				col_index = i;
				flag = true;
				break;
			}

		}
		if(flag) {
			break;
		}
	}
	return col_index;
}

/*  Method to find the unique number for a particular browser -- Added by Shivendu */

static int browserValueCalculator(String br) {
	if(br.equalsIgnoreCase("FF"))
		return 1;
	if(br.equalsIgnoreCase("chrome"))
		return 2;
	if(br.equalsIgnoreCase("IE"))
		return 3;
	if(br.equalsIgnoreCase("IE10"))
		return 4;
	if(br.equalsIgnoreCase("IE11"))
		return 5;
	else
		return 0;
}

/*  Method to get passScrShot value for the test case -- Added by Shivendu */

static String getPassScreenshot(String testCase) {
	if(testCase.equalsIgnoreCase("RT_Phone_001"))
		return RT_Phone_001.passScrShot;
	if(testCase.equalsIgnoreCase("RT_Phone_002"))
		return RT_Phone_002.passScrShot;
	if(testCase.equalsIgnoreCase("RT_Phone_003"))
		return RT_Phone_003.passScrShot;
	if(testCase.equalsIgnoreCase("RT_Phone_004"))
		return RT_Phone_004.passScrShot;
	if(testCase.equalsIgnoreCase("RT_Phone_005"))
		return RT_Phone_005.passScrShot;
	if(testCase.equalsIgnoreCase("RT_Phone_006"))
		return RT_Phone_006.passScrShot;
	if(testCase.equalsIgnoreCase("RT_Phone_007"))
		return RT_Phone_007.passScrShot;
	if(testCase.equalsIgnoreCase("RT_Phone_008"))
		return RT_Phone_008.passScrShot;
	if(testCase.equalsIgnoreCase("RT_Phone_009"))
		return RT_Phone_009.passScrShot;
	if(testCase.equalsIgnoreCase("RT_Phone_010"))
		return RT_Phone_010.passScrShot;
	if(testCase.equalsIgnoreCase("RT_Phone_011"))
		return RT_Phone_011.passScrShot;
	if(testCase.equalsIgnoreCase("RT_Phone_012"))
		return RT_Phone_012.passScrShot;
	if(testCase.equalsIgnoreCase("RT_Phone_014"))
		return RT_Phone_014.passScrShot;
	if(testCase.equalsIgnoreCase("RT_Phone_015"))
		return RT_Phone_015.passScrShot;
	if(testCase.equalsIgnoreCase("RT_Phone_016"))
		return RT_Phone_016.passScrShot;
	else
		return "";
}

/*  Method to write report in excel sheet -- Added by Shivendu */

static void writeToExcel(String output, ArrayList<Result_bean> result) throws Exception {
	int counter_result_initial = 10;
	int counter_result_final;
	
	File data = new File(output);
	WritableWorkbook workbook;
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
	//String notinit = "Test set was not initiated";
	long st = 0L, et = 0L;
	double diff = 0.0D;
	double diff1 = 0.0D;
	
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
    
    workbook = Workbook.createWorkbook(data);
	sheet1 = workbook.createSheet("Results", 0);
	
    
	try {
		
	    sheet1.setColumnView(0, 11);
		sheet1.setColumnView(1, 30);
		sheet1.setColumnView(2, 20);
		sheet1.setColumnView(3, 73);
		sheet1.setColumnView(4, 40);
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
		tfb_spaceline.setBackground(Colour.PALETTE_BLACK);
		tfb1_heading.setBorder(Border.RIGHT, BorderLineStyle.THICK);
		tfb1_heading.setBorder(Border.TOP, BorderLineStyle.THICK);
		tfb1_heading.setBorder(Border.BOTTOM, BorderLineStyle.THICK);
		tfb_spaceline_black.setBackground(Colour.PALETTE_BLACK);
		
		
		
		
		tfb.setBackground(Colour.GREY_25_PERCENT);
		sheet1.mergeCells(0,0,4,0);
		sheet1.mergeCells(0,1,1,8);
		sheet1.mergeCells(2,1,3,1);
		sheet1.mergeCells(2,8,3,8);
		sheet1.mergeCells(4,1,4,8);
		
		lbl = new Label(0, 0, "EBF Regression - Phone - TEST RESULTS", tfb1_heading);
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
		
		tfb_spaceline.setBackground(Colour.PALETTE_BLACK);
		
		et = System.currentTimeMillis();
		diff = et - st;
		diff /= 60000.0D;
		diff1 += diff;
		//lbl = new Label(1, 3, notinit);
		//sheet1.addCell(lbl);
		lbl = new Label(2,3, "Accounts Executed:", tfb1_summary);
		sheet1.addCell(lbl);
		lbl = new Label(2,4, "Accounts Passed: ", tfb1_summary);
		sheet1.addCell(lbl);
		lbl = new Label(2,5, "Accounts Failed: ", tfb1_summary);
		sheet1.addCell(lbl);
		lbl = new Label(2,6, "Accounts Not Executed: ", tfb1_summary);
		sheet1.addCell(lbl);
		
		WritableFont TableFormat2 = new WritableFont(WritableFont.ARIAL, 10,
				WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE,
				Colour.RED);
		WritableFont TableFormat3 = new WritableFont(WritableFont.ARIAL, 10,
				WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE,
				Colour.BLACK);
		WritableFont TableFormat4 = new WritableFont(WritableFont.ARIAL, 9,
				WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE,
				Colour.BLACK);
		
		WritableFont TableFormat5 = new WritableFont(WritableFont.ARIAL, 9,
				WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE,
				Colour.ORANGE);
		WritableFont TableFormat_status = new WritableFont(WritableFont.ARIAL,
				10, WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE,
				Colour.WHITE);
		

		WritableCellFormat tableFormatBackground3 = new WritableCellFormat();
		WritableCellFormat tableFormatBackground2 = new WritableCellFormat();
		WritableCellFormat tableFormatBackground4 = new WritableCellFormat();
		WritableCellFormat tableFormatBackground5 = new WritableCellFormat();
		WritableCellFormat tableFormatBackground_status_pass = new WritableCellFormat();
		WritableCellFormat tableFormatBackground_status_fail = new WritableCellFormat();
		WritableCellFormat tableFormatBackground_status_cpass = new WritableCellFormat();
		WritableCellFormat tableFormatBackground_testname = new WritableCellFormat();
		// WritableCellFormat tableFormatBackground_status_exception = new
		// WritableCellFormat();
		tableFormatBackground2.setFont(TableFormat2);
		tableFormatBackground3.setFont(TableFormat3);
		tableFormatBackground4.setFont(TableFormat4);
		tableFormatBackground5.setFont(TableFormat5);
		tableFormatBackground_testname.setFont(TableFormat4);
		tableFormatBackground_testname
				.setVerticalAlignment(VerticalAlignment.CENTRE);
		tableFormatBackground_status_fail
				.setVerticalAlignment(VerticalAlignment.CENTRE);
		tableFormatBackground_status_pass
				.setVerticalAlignment(VerticalAlignment.CENTRE);
		tableFormatBackground_status_cpass.setVerticalAlignment(VerticalAlignment.CENTRE);
		// tableFormatBackground_testname.setAlignment(Alignment.JUSTIFY);
		tableFormatBackground_status_pass.setFont(TableFormat_status);
		tableFormatBackground_status_pass.setAlignment(Alignment.CENTRE);
		tableFormatBackground_status_pass.setBackground(Colour.GREEN);
		tableFormatBackground_status_fail.setFont(TableFormat_status);
		tableFormatBackground_status_fail.setBackground(Colour.RED);
		tableFormatBackground_status_fail.setAlignment(Alignment.CENTRE);
		tableFormatBackground_status_pass.setBorder(Border.ALL,
				BorderLineStyle.THIN);
		tableFormatBackground_status_fail.setBorder(Border.ALL,
				BorderLineStyle.THIN);
		
		tableFormatBackground_status_cpass.setFont(TableFormat_status);
		tableFormatBackground_status_cpass.setAlignment(Alignment.CENTRE);
		tableFormatBackground_status_cpass.setBackground(Colour.ORANGE);
		tableFormatBackground_status_cpass.setBorder(Border.ALL, BorderLineStyle.THIN);
		
		

		tableFormatBackground3.setWrap(true);
		tableFormatBackground2.setWrap(true);
		tableFormatBackground4.setWrap(true);
		tableFormatBackground_testname.setWrap(true);
		tableFormatBackground2.setBorder(Border.ALL, BorderLineStyle.THIN);
		tableFormatBackground3.setBorder(Border.ALL, BorderLineStyle.THIN);
		tableFormatBackground4.setBorder(Border.ALL, BorderLineStyle.THIN);
		tableFormatBackground_status_pass.setBorder(Border.ALL,
				BorderLineStyle.THIN);
		tableFormatBackground_testname.setBorder(Border.ALL,
				BorderLineStyle.THIN);
		tableFormatBackground4.setBackground(Colour.LIGHT_TURQUOISE);
		//DecimalFormat df = new DecimalFormat("#0.00");
		
		if (diff1 != 0.0D) {
			String yash = df.format(diff1);
			diff1 = Double.parseDouble(yash);
			lbl = new Label(2,7, "Total Time: ", tfb1_summary);
			sheet1.addCell(lbl);
			
			lbl = new Label(3,7, diff1 + " minutes(ms)",tfb1_summary);
			sheet1.addCell(lbl);
		}
		int numberOfExecutedTestCases = 0, numberOfFailedTestCases = 0;
		boolean flag;
		int c = 0, r = counter_result_initial;
		String testCase = "";
		for(Result_bean rb : result) {
			if(!testCase.equals(rb.getTestCase())) {
				flag = false;
				numberOfExecutedTestCases++;
				counter_result_final = r;
				logger.info("counter_result_initial - " + counter_result_initial);
				logger.info("counter_result_final - " + counter_result_final);
				if(testCase != "") {
					if(flag) {
						numberOfFailedTestCases++;
					}
					
					sheet1.mergeCells(0, counter_result_initial, 0, counter_result_final - 1);
					sheet1.mergeCells(0, counter_result_final, 4, counter_result_final);
					
					Label lbl_spaceline = new Label(0, counter_result_final, "", tfb_spaceline);
					sheet1.addCell(lbl_spaceline);
					r++;
					counter_result_initial = r;
				}
				testCase = rb.getTestCase();
				
				lbl = new Label(c, r, rb.getTestCase(),	tableFormatBackground_testname);
				sheet1.addCell(lbl);
			}
			lbl = new Label(c + 1, r, rb.getResult_scenario(), tableFormatBackground3);
			sheet1.addCell(lbl);
			if(rb.getResult().equalsIgnoreCase("fail")) {
				lbl = new Label(c + 2, r, rb.getResult(), tableFormatBackground_status_fail);
				flag = true;
			} else {
				lbl = new Label(c + 2, r, rb.getResult(), tableFormatBackground_status_pass);
			}
			sheet1.addCell(lbl);
			logger.info("Check");
			//logger.info(Class.forName(rb.getTestCase()).getDeclaredMethod("getPassScreenshot").invoke(Class.forName(rb.getTestCase()).getClass()).equals(null) ? "NULL" : Class.forName(rb.getTestCase()).getDeclaredMethod("getPassScreenshot").invoke(Class.forName(rb.getTestCase()).getClass()).toString());
			String passScreenShot = getPassScreenshot(rb.getTestCase());//RT_Phone_001.passScrShot;//Class.forName(rb.getTestCase()).getDeclaredField("passScrShot").get(null).toString();
			logger.info("passScreenShot - " + passScreenShot);
			if(passScreenShot.equalsIgnoreCase("Y") && (rb.getResult_expected() != " ") && rb.getResult_actual().contains("\\")) {
				//Code to Hyperlink Starts
				String str = rb.getResult_actual();
				String p[] = str.split(" Refer screenshot: ");
				//logger.info("p:"+p);
				logger.info("p1:"+p[1]);
				logger.info("p0:"+p[0]);
				logger.info("p[0]"+p[0].replaceAll("\n", ""));
				//String textActual= str.substring(0, str.indexOf("C:") - 1);
				//String scn= "HYPERLINK(\"" + p + "\"," + "\"" + textActual + "\")";
				String scn= "HYPERLINK(\"" + p[1] + "\"," + "\"" + p[0].replaceAll("\n", "") + "\")";
				logger.info("Hyperlink string - " + scn);
				Formula link = new Formula(c + 3, r, scn);
				sheet1.addCell(link);
				WritableCell cell = sheet1.getWritableCell(c + 3 , r);
				cell.setCellFormat(tableFormatBackground3);
				//Code to Hyperlink ends
			}
			else {
				lbl = new Label(c + 3, r, rb.getResult_actual(), tableFormatBackground5);
				sheet1.addCell(lbl);
			}
			//lbl = new Label(c + 3, r, rb.getResult_actual(), tableFormatBackground3);
			//sheet1.addCell(lbl);
			lbl = new Label(c + 4, r, rb.getResult_expected(), tableFormatBackground3);
			sheet1.addCell(lbl);
			r++;
		}
		sheet1.mergeCells(0, counter_result_initial, 0, r - 1);
		sheet1.mergeCells(0, r, 4, r);
		
		Label lbl_spaceline = new Label(0, r, "", tfb_spaceline);
		sheet1.addCell(lbl_spaceline);
		
		Number nmbr = new Number(3, 3, numberOfExecutedTestCases,tfb1_summary);
		sheet1.addCell(nmbr);
		nmbr = new Number(3, 4, numberOfExecutedTestCases - numberOfFailedTestCases,tfb1_summary);
		sheet1.addCell(nmbr);
		nmbr = new Number(3, 5, numberOfFailedTestCases,tfb1_summary);
		sheet1.addCell(nmbr);
		nmbr = new Number(3, 6, CRH_EBF_Phone_test.numberOfTestCases - numberOfExecutedTestCases,tfb1_summary);
		sheet1.addCell(nmbr);
	} catch (Exception e) {
		lbl = new Label(3, 0, "Intermediate error has occured which has stopped execution");
		sheet1.addCell(lbl);
		lbl = new Label(3, 1, e.getMessage());
		sheet1.addCell(lbl);
	} finally {
		workbook.write();
		workbook.close();
	}
	
}



public void Phone_TWClogo(String br,WebDriver driver) throws Exception {
	
	logger.info("*******Before Click*********");
	logger.info(driver.getWindowHandle());
	String parentWin = driver.getWindowHandle();
	Thread.sleep(5000);
	driver.findElement(By.xpath(".//*[@class='img desktop']")).click();
	
	
	Thread.sleep(10000);
	logger.info("*******AFter Click*********");
	Set<String> Win = driver.getWindowHandles();
	Iterator<String> Itr = Win.iterator();

	String MainWin = Itr.next();
	String TabWin = Itr.next();
	driver.switchTo().window(TabWin);

	String subWinTitle = "Cable TV, High Speed Internet & Home Phone Service | Time Warner Cable";
	Thread.sleep(5000);
	String subActitle = driver.getTitle();

	logger.info(subActitle);
	Thread.sleep(8000);

	if (subWinTitle.equals(subActitle)) {
		statusTracker(br,driver,"Pass",
				"TWC Logo is clickable and opens in new tab",
				"Clickable and opens in new tab",
				"Should be Clickable and should open in new tab");
	} else {
		statusTracker(br,driver,"Fail",
				"TWC Logo is clickable and opens in new tab",
				"Its NOT clickable",
				"Should be Clickable and should open in new tab");
	}

	Thread.sleep(5000);
	driver.switchTo().window(parentWin);
	Thread.sleep(5000);
	driver.switchTo().window(parentWin);
	String parWinTitle = "Current Services | Time Warner Cable";
	String parActitle = driver.getTitle();

	if (parWinTitle.equals(parActitle)) {
		statusTracker(br,driver,
				"Pass",
				"User navigates to the parent window: current service page",
				"Navigates to parent page",
				"Should be able to navigate back to parent page");
	} else {
		statusTracker(br,driver,
				"Fail",
				"User navigates to the parent window: current service page",
				"Doesnt navigates to parent page",
				"Should be able to navigate back to parent page");
	}

	Thread.sleep(10000);
	
}
	
public void Phone_Username(String br,WebDriver driver,int loc) throws Exception
{
String UserName = driver.findElement(By.xpath(".//*[@class='headerUsername']/em")).getText();

logger.info("portal name"  +UserName);

File data = new File(this.path);
WorkbookSettings ws = new WorkbookSettings();
ws.setLocale(new Locale("er", "ER"));
logger.info("chheck1");
Workbook wb = Workbook.getWorkbook(data, ws);
Sheet sheet2 = wb.getSheet("Phone");
String Uname = sheet2.getCell(9, loc).getContents();

logger.info("sheet name"  +Uname);

if (UserName.trim().equalsIgnoreCase(Uname.trim())) {
	logger.info("The username matches");
	statusTracker(br,driver,"Pass", "The first and last name", "Matches",
			"Should match");
} else {
	logger.info("name match fails");
	statusTracker(br,driver,"Fail",
			"The first and last name doesnt match",
			"Doesnt Match", "Should match");
}
}


// Validation of sign out

public void Phone_Signout(String br,WebDriver driver) throws Exception {

String Expected_str = "Sign Out";
logger.info("---------sig---------------------"+driver.findElement(By.xpath(".//*[@class='text logout parbase twc-plain-text']")).getText());
if (driver
		.findElement(
				By.xpath(".//*[@class='text logout parbase twc-plain-text']"))
		.getText().equals(Expected_str))

{
	logger.info("Pass");
	statusTracker(br,driver,"Pass", "Signout is displayed",
			"Sign out present", "Sign out should be displayed");
} else {
	logger.info("Fail");
	statusTracker(br,driver,"Fail", "Signout is displayed",
			"Sign out not displayed",
			"Sign out should be displayed");
}

}	


//eod RJ


public static void Load_Properties_File(String spath) throws IOException {
	
	spath = spath + "//" + "Resource//" + "Properties_Files//";
	path_config = new Properties();
	file_Stream = new FileInputStream(spath + "properties_Path//"
			+ "path_config.properties");
	path_config.load(file_Stream);
}

}