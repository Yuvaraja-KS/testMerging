package CRH_EBF_Review_OS_OC;

import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.*;
import java.util.*;

import jxl.read.biff.BiffException;
import jxl.write.Formula;
import jxl.write.WritableCell;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.format.*;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.write.Label;
import jxl.write.WritableSheet;

import java.net.InetAddress;
import java.net.URL;

import javax.imageio.ImageIO;

import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.*;
import org.openqa.selenium.interactions.Actions;
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;





import org.testng.Assert;
import org.monte.media.FormatKeys.MediaType;
import org.monte.media.math.Rational;
import org.monte.media.Format;
import org.monte.screenrecorder.ScreenRecorder;

import CRH_EBF_Packages.RT_Package_006;

import CRH_EBF_TV.Result_bean;

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


public abstract class CommonFunctions {
	public static String pass_screenshot;
	public static Logger logger = LoggerFactory.getLogger(CommonFunctions.class);
	public static boolean pass_screenshot_required;
    public String browserused;
    public static String spath;
    public static File dir1;
    public static FileInputStream file_Stream;
	public static Properties path_config;
    public static int first_tc;
    private ScreenRecorder screenRecorder;
    public static String inputfile,outputfile;
    public static File data11;
    public static WorkbookSettings ws11;
    public static Workbook wb11;
    public Sheet sheet11 ;
    public static String gr;
    public static String no_of_browsers;
    public String Sheet_name;  
  //  public static int Test_called = 0;
   
    public static String newFolderPCName;
    public static String result[] = new String[20000];
    public static String result_scenario[] = new String[20000];
    public static String result_actual[] = new String[20000];
    public static String result_expected[] = new String[20000];

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
    public String Page_TV;
    public String Page_Phone= "RO_OS";
    public String itemname[] = new String[15];
    public String itemcost[] = new String[15];
    public String itemname1[] = new String[15];
    public String itemcost1[] = new String[15];
    public String itemname2[] = new String[15];
    public String itemcost2[] = new String[15];
    public String itemname3[] = new String[15];
    public String itemcost3[] = new String[15];
    public String itemname_mon[] = new String[15];
    public String itemcost_mon[] = new String[15];
    public String new_itemname_mon[] = new String[15];
    public String new_itemcost_mon[] = new String[15];
    public int carttotal;
    public int carttotal1;
    public String input_sheet="CRH_EBF_Input_Sheet.xls";
	public String TestCompleted = "No";
    public String mon_total;
    DecimalFormat df = new DecimalFormat("#0.00");
    public String Page_Internet;

    public String FirstChoiceDate = "";
    public String FirstChoiceTime = "";
    public String SecondChoiceDate = "";
    public String SecondChoiceTime = "";
    
	

    public int mon_total_items;
    public int new_mon_total_items;
    public String Rev_onetime_ChargesOption[] = new String[10];
    public String Rev_onetime_ChargesCost[] = new String[10];
    public int carttotal2;
    public String path2;
    public String path3;
    public String path4;

    public String Overall_Path =" ";
    public String itemcost1_Free[]=new String[15];
    public String itemcost1_Included[]=new String[15];
    public String itemcost2_Free[]=new String[15];
    public String itemcost2_Included[]=new String[15];
    public String itemcost3_Free[]=new String[15];
    public String itemcost3_Included[]=new String[15];
    public Double RO_TotalOneTimeCharges = 0.00;
    public String FirstDateTime = ""; 
    public String SecondDateTime = "";
    

    public String FirstChoiceDate1 = "";
    public String FirstChoiceTime1 = "";
    public String SecondChoiceDate1 = "";
    public String SecondChoiceTime1 = "";
    
    public static int arrcount[] = new int[10];
	public static String Grid_Status;
    public static int total[] = new int[10];
    public static int counter_result_sheet[] = new int[10];
    public static int counter_result_initial[] = new int[10];
    public static int ro[]=new int [10];
    public static int l_browser[] = new int[10];
    public static int pass_br_wise[] = new int[10];
    public static int no_run[] = new int[10];
    public static int black[] = new int[10];
    public static String browser[] = new String[20];
    public static int counter_result_final[] = new int[10];
    ArrayList<Result_bean> a = new ArrayList<Result_bean>();
	public static Map br_specific = new HashMap<String, List<Result_bean>>();
	public static int counter_browser = 0, k_browser = 0;
	public static String result_array[][] = new String[100][10000];
	
	
	
	
	
    
    public abstract void execute(String br,WebDriver paramDriver, String url, int loc,String Overall_Path,String env)
            throws Exception;
       // Package data declaration
        public Double RO_TotalMonthlyCharges = 0.00;
        public Double OS_TotalMonthlyCharges = 0.00;
        public Double PackageAmount= 0.00;
        DecimalFormat dateformat = new DecimalFormat("#0.00");
       // Package data declaration ended

    public String getStatus() {
        String b = "Fail";
        if (this.result.equals("Pass"))
            b = "Pass";
        return b;
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
            logger.info("I am inside exception");
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
    
    
    
    
    
    
    //Rj
    
// validationofTWClogo
    
    

    public void Phone_TWClogo(String br,WebDriver driver) throws Exception {
    
    logger.info("*******Before Click*********");
    logger.info(driver.getWindowHandle());
    String parentWin = driver.getWindowHandle();
    click_element(".//*[@id='your_services']/div[7]/header/div[1]/a/div[1]/div", driver);
    
    
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
    
    
    // Validation of User Name
    public void Phone_Username(String br,WebDriver driver,int loc) throws Exception
    {
    String UserName = driver.findElement(By.xpath(".//*[@id='your_services']/div[7]/header/div[1]/ul/li[1]/div/em")).getText();
    File data = new File(this.path);
    WorkbookSettings ws = new WorkbookSettings();
    ws.setLocale(new Locale("er", "ER"));
  //  arrcount = 0;
    logger.info("chheck1");
    Workbook wb = Workbook.getWorkbook(data, ws);
    Sheet sheet2 = wb.getSheet("Review_OS_OC");
    String Sheet_name = sheet2.getName();
    logger.info("started.................");
    String Uname = sheet2.getCell(Col_locator_full_scan_input_sheet("ACCOUNT NAME", path,Sheet_name), loc).getContents();
    logger.info("dsfsfsf"+Uname);
    
    if (UserName.equals(Uname)) {
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
    if (driver
            .findElement(
                    By.xpath(".//*[@id='your_services']/div[7]/header/div[1]/ul/li[1]/div/a"))
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
    
    //eoc RJ
    

    
    
    

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
     rb.setResult(r);
     rb.setResult_actual(ractual);
     rb.setResult_expected(rexpected);
     rb.setResult_scenario(rscenario);

     logger.info("Get R*" + rb.getResult());

     // Storing browser
     // names****************************************************
     int flag = 1;
     if (counter_browser == 0) {
            browser[counter_browser] = br;
            counter_browser++;
     } else {

            int ij = 0;
            logger.info("browser[i] " + browser[ij]);
            while (browser[ij] != null) {
                  logger.info("browser[ij]!=null");
                  if (browser[ij].equals(br)) {
                         flag = 0;
                         break;
                  }
                  ij++;
            }
            if (flag == 1) {
                  browser[ij] = br;
                  counter_browser++;
            }

     }
     // Storing browser
     // names****************************************************

     int i_browser = 0;
     while (browser[i_browser] != null) {
            if (browser[i_browser].equals(br)) {
                  counter_result_sheet[i_browser]++;
                  logger.info("COUNTER RESULT SHEET VALUE ******** "+counter_result_sheet[i_browser]+"br "+br);
                  break;
            }
            i_browser++;
     }
     
     
     
     
     i_browser = 0;
     while (browser[i_browser] != null) {
            if (browser[i_browser].equals(br)) {
     String imagename = spath+ "//" + "//Test_Results"+"//"+newFolderPCName+ "////"
                  + "CRH_EBF_Review_OS_OC_Fail_Screenshots//"+br+"////" + Page_Phone
                  + "_Int_Fail";
     
     
     // logger.info( "path image name2 is "+imagename);
     // imagename=imagename+"//"+"Fail_Screenshots";
     /*
     * String imagename = path; int i=imagename.length();
     * logger.info("reached1: "+i); for
     * (;imagename.charAt(i-1)=='//';i--) { logger.info(i+":"); }
     * logger.info("reached2: "+imagename +"  " +i);
     * imagename=imagename.substring(0,i+2)+"ScreenCapture";
     * logger.info("reached3"); imagename=imagename+"_Int_Exception";
     */
     // String imagename = "ScreenCap_Int_Exception";
     Date dNow;
     SimpleDateFormat ft = new SimpleDateFormat("'_'MMMM dd'_'hh.mma");
     result[arrcount[i_browser]] = r;
     if (!(r.equals("Fail")))
            result_actual[arrcount[i_browser]] = ractual;
     result_expected[arrcount[i_browser]] = rexpected;
     result_scenario[arrcount[i_browser]] = rscenario;
     if (r.equals("Fail")) {
         
         //logger.info("Test scenario failed here");
         //Assert.fail("Expected and Actual result does not match for the scenario " +rscenario +" \n Expected result is : "+rexpected +" \n Actual result is : " +ractual );

            dNow = new Date();
            logger.info(ft.format(dNow));
            imagename = imagename + int_screenshot + ft.format(dNow) + ".png";
            int_screenshot++;
            try {
                  File scrFile1 = ((TakesScreenshot) driver)
                                .getScreenshotAs(OutputType.FILE);
                  FileUtils.copyFile(scrFile1, new File(imagename));
                  // selenium.captureEntirePageScreenshot(imagename, "");
            } catch (Exception e) {
                  imagename = "Unable to capture screenshot";
            }
            result_actual[arrcount[i_browser]] = ractual + " Refer screenshot: "
                         + imagename;
     }

     // //added new function

     if (r.equalsIgnoreCase("pass")) {

            if (pass_screenshot_required == true) {
                  String imagename_1 =spath+ "//" + "//Test_Results"+"//"+newFolderPCName + "////" + "CRH_EBF_Review_OS_OC_Pass_Screenshots//"+br+"////"
                                              + Page_Phone+"_Int_Pass";
                  System.out.println("pRINTING NAME " + imagename_1);
                  // logger.info( "path image name2 is "+imagename_1);

                  dNow = new Date();
                  logger.info(ft.format(dNow));
                  imagename_1 = imagename_1 + int_screenshot + ft.format(dNow)
                                + ".png";
                  int_screenshot++;
                  try {
                	  System.out.println("Check 1");
                	
                	  
                         File scrFile1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
                         System.out.println("Check 2");
                         FileUtils.copyFile(scrFile1, new File(imagename_1));
                         System.out.println("Check 3");
                         // selenium.captureEntirePageScreenshot(imagename, "");
                  } catch (Exception e) {
                         imagename_1 = "Unable to capture screenshot";
                  }
                  result_actual[arrcount[i_browser]] = ractual + " Refer screenshot: "
                                + imagename_1;
            } else {
                  result_actual[arrcount[i_browser]] = ractual
                                + " : No screenshot required ";
            }
     }
     logger.info("storing done******");
     break;
            }
            i_browser++;
     }
     
     
     
     
     
     
     i_browser = 0;
     while (browser[i_browser] != null) {
            if (browser[i_browser].equals(br)) {
                  logger.info("COUNTER RESULT SHEET VALUE ******** "+counter_result_sheet[i_browser]+"br "+br);    
            logger.info(  "result_actual"+result_actual[arrcount[i_browser]] );
            logger.info(  "result_expected" +result_expected[arrcount[i_browser]]  );
            logger.info(  "result_scenario"+ result_scenario[arrcount[i_browser]] ); 
            logger.info("result "+     result[arrcount[i_browser]] );
                  break;
            }
            i_browser++;
     }
     
     
     // br_specific.put(br, rb.getResult());
     // br_specific.put(br, rb.getResult_actual());
     // br_specific.put(br, rb.getResult_expected());
     // br_specific.put(br, rb.getResult_scenario());
     logger.info("RB ... if..." + br_specific);
     // logger.info("br value "+br);

     if (br_specific.containsKey(br)) {
            logger.info("Br key added***** " + br);
            ;
            logger.info("RB ... if..." + br_specific);
            /*
            * if(br.equals("firefox")) { a.add(rb); br_specific.put(br,a); }
            * else { br_specific.put(br,b); b.add(rb);
            * 
             * }
            */
            System.out
                         .println("*******************Firfox*****************************");
            

     } else {
            
            a.add(rb);
            

     }

     // storing values
     i_browser = 0;
     while (browser[i_browser] != null) {
            if (browser[i_browser].equals(br)) {
                  logger.info("COUNTER RESULT SHEET VALUE ******** "+counter_result_sheet[i_browser]+"br "+br+" arrcount "+arrcount);   
                  result_array[i_browser * 4][l_browser[i_browser]] = a.get(
                                arrcount[i_browser]).getResult();
                  logger.info(result_array[i_browser * 4][l_browser[i_browser]]);
                  result_array[(i_browser * 4) + 1][l_browser[i_browser]] = a
                                .get(arrcount[i_browser]).getResult_scenario();
                  logger.info(result_array[(i_browser * 4) + 1][l_browser[i_browser]]);
                  result_array[(i_browser * 4) + 2][l_browser[i_browser]] = a
                                .get(arrcount[i_browser]).getResult_actual();
                  result_array[(i_browser * 4) + 2][l_browser[i_browser]] =result_actual[arrcount[i_browser]];
                  logger.info(result_array[(i_browser * 4) + 2][l_browser[i_browser]]);
                  result_array[(i_browser * 4) + 3][l_browser[i_browser]] = a
                                .get(arrcount[i_browser]).getResult_expected();
                  logger.info(result_array[(i_browser * 4) + 3][l_browser[i_browser]]);
                  l_browser[i_browser]++;
                  break;
            }

            i_browser++;

     }

     // storing values



     logger.info("The set of keys are!@#$%^&* "
                  + br_specific.keySet());
     Set<String> keys = br_specific.keySet();
     logger.info("Values **** rb.getResult()**= "
                  + br_specific.get(rb.getResult()) + "n");
     logger.info(rb.getResult());

     
     i_browser = 0;
     while (browser[i_browser] != null) {
            if (browser[i_browser].equals(br)) {
     arrcount[i_browser]++;
     
     
     logger.info("STATUS TRACKER OVER**************");
     logger.info("arrcount is " + arrcount+" br"+br);
     
     
     break;
            }

            i_browser++;

     }
}



	public String exceptionHandler(String br,Exception ex, WebDriver driver) {
		String s = "";
		String name = "image";
		try {
			throw ex;
		} catch (NullPointerException e) {
			s = "Selenium is trying to access an object which is not present";
			statusTracker(br,driver,"Fail", " ", s, "");
		} catch (Exception e) {

			String imagename = spath+ "//" + "//Test_Results"+"//"+newFolderPCName+"////CRH_EBF_Review_OS_OC_Exception_Screenshots//"+br+"////"+Page_Phone+ "_Int_Exception";
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

				s = "IDMS issue";
			} else if (e.getMessage().contains("sso-hrndva")) {

				s = "SSO Gateway issue";
			}

			else if (e.getMessage().contains("not found")) {
				statusTracker(br,driver,"Fail", "", e.getMessage(),
						"Element should be displayed");
				s = "Selenium has stopped because an element was not found - "
						+ e.getMessage();

				first = 0;
			} else if (e.getMessage().contains("terminal")
					|| driver.getCurrentUrl().contains("Terminal")) {

				s = "Terminal error page has stopped execution";
				driver.quit();
				first = 0;
			} else if (driver.getCurrentUrl().contains("CLAReconcile.aspx")) {

				s = "There was an error in the Reconciliation. Please retry";
				driver.quit();
				first = 0;
			} else if (driver.getCurrentUrl().contains("ids.eng.rr.com")) {

				s = "IDMS issue has prevented the page from proceeding further";
				driver.quit();
				first = 0;
			} else if (driver.getCurrentUrl().contains("erminal")) {

				s = "Terminal error page has prevented the automation from proceeding further";
				driver.quit();
				first = 0;
			} else if ((driver.findElements(By.id("css=h1")).size() != 0)
					&& (driver.findElements(By.id("id=imgLogo")).size() != 0)) {

				s = "Top Error has prevented the page from proceeding further";
				driver.quit();
				first = 0;
			} else {

				s = "The browser has taken too long to respond or an intermediate error has occurred "
						+ e.getMessage();

				statusTracker(br,driver,"Fail", " ", s, " ");

			}
		}
		name = name + screenshot;
		screenshot += 1;
		return s;
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
		WebElement element = driver.findElement(By.xpath(fxp));
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		// actions.click();
		actions.perform();
		driver.findElement(By.xpath(fxp)).click();

	}
	

    public void setUp(int loc,String Overall_Path,String env,String br,String name1) throws Exception {

    	logger.info("^^^^^^^^^^^ Br value set up is ^^^^^^^^^" + br);
		try {
			if (first == 0) {
				logger.info("set up is called");
				logger.info("Overall_Path"+Overall_Path);
				WebDriver driver;
				driver = null;
				
				File URL = new File(this.path);
				System.out.println("Sruthy check " +path);
				WorkbookSettings ws = new WorkbookSettings();
				ws.setLocale(new Locale("er", "ER"));
				Workbook wb_url = Workbook.getWorkbook(URL, ws);
				Sheet sheet_url = wb_url.getSheet("Review_OS_OC");
				logger.info("name1 " + name1);

			/*	int row_region = Row_locator_full_scan(br, name1, path,
						"Packages");
				int col_address = Column_locator_fullscan("Username", path,
						"Packages") - 1;
				int col_zipcode = Column_locator_fullscan("Password", path,
						"Packages") - 1;
				logger.info("row_region " + row_region);
				logger.info("col_username " + col_address);
				logger.info("col_password " + col_zipcode);

				username = sheet_url.getCell(col_address, row_region - 1)
						.getContents();
				// address2= sheet2.getCell(5,loc).getContents();
				password = sheet_url.getCell(col_zipcode, row_region - 1)
						.getContents();
				logger.info("username " + username);
				logger.info("password " + password);

				// **************************************************
*/
				
				String url = sheet_url.getCell(1, 3).getContents();
				Grid_Status = sheet_url.getCell(4, 3).getContents();
				logger.info("url " + url);
				logger.info("Grid_Status " + Grid_Status);
				if (Grid_Status.equalsIgnoreCase("No")) {
					br = sheet_url.getCell(2, loc).getContents();
					// br="IE";
				}
				logger.info("Grid_Status " + Grid_Status + " br " + br);
				// WebDriver driver;
				logger.info(url);
			
				String browser;
				DesiredCapabilities capabilities = null;
				
//Video recording - JS Start
String video=sheet_url.getCell(5, loc).getContents();
                                  if(video.equalsIgnoreCase("Y"))
                                         startRecording();   
//Video recording - JS End
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
					logger.info("Fire fox browser started");
					logger.info("i went inside this loop of firefox");
					capabilities = DesiredCapabilities.firefox();
					capabilities.setBrowserName("firefox");
					capabilities.setPlatform(Platform.ANY);

					FirefoxProfile profile = new FirefoxProfile();
					profile.setPreference("plugin.state.flash", 0);
					capabilities.setCapability(FirefoxDriver.PROFILE, profile);

					if (Grid_Status.equalsIgnoreCase("No")
							) {
						System.out
								.println("In loop of firefox driver and grid status false");
						driver = new FirefoxDriver();
					}
				}
				logger.info("Before grid remote");
				if (Grid_Status.equalsIgnoreCase("Yes")) {
					logger.info("grid id true ---");
					driver = new RemoteWebDriver(new URL(
							"http://localhost:4444/wd/hub"), capabilities);
					logger.info("br : " + br);

					logger.info("grid id true 2---");
				}

				logger.info("helo");
				driver.get(url);

				wb_url.close();
				logger.info("Just reached end of setup");
					
			EventFiringWebDriver eventDriver = new EventFiringWebDriver(
						driver);
				EventHandler handler = new EventHandler(br);
				eventDriver.register(handler);
				drive = eventDriver;
				logger.info("Just reached end of setup");
				// execute(drive, url, loc);
				//execute(br, drive, url, loc);
				
				execute(br,driver, url, loc,Overall_Path,env);
				

				//Video recording - JS Start
				if(video.equalsIgnoreCase("Y"))
                                stopRecording();
				//Video recording - JS End
			}

		} catch (Exception e) 
		{
			drive.quit();
		}
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
  //new RT_Package_006(path), 0,sheet1, name1, loc,Overall_Path,br_specific,br,env


    public int obj_run(CommonFunctions r, int c, WritableSheet sheet1,
 			String testname, int loc,String Overallpath, String env, String br, Map br_specific)
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
        r.setUp(loc,Overallpath,env, br, testname);
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

    // //////// added code shikha
    // Shikha//*****************************************************click
    // functions******************************************************************
    public void firstrun(String br,WebDriver driver, String username, String pwd,
             String ctotal, String Uname, String serAddress)
            throws InterruptedException {
        logger.info("First run is called");

        click_element(".//*[@href='#buyflow-current']", driver);
        driver.findElement(By.name("username")).sendKeys(username);
        statusTracker(br,driver,"Pass", "User enters TWC username ",
                "User name displays", "should be able to enter the userId");
        driver.findElement(By.name("password")).sendKeys(pwd);
        statusTracker(br,driver,"Pass", "User enters TWC password ",
                "Password is entered and masked",
                "should be able to enter the password");
        int g = 0;
        try {
            do {
            	click_element(".//*[@value='Sign In']", driver);
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
    
    //Column locator
    
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

    // end column locator
    
    public void TV_lob_click(WebDriver driver) {

        
		scrollToElementByName("select_tv",driver);
		driver.findElement(By.name("select_tv")).click();
	}

	public void Internet_lob_click(WebDriver driver)  {
		scrollToElementByName("select_inet",driver);
		driver.findElement(By.name("select_inet")).click();
	}

	public void Phone_lob_click(WebDriver driver){
		scrollToElementByName("select_phone",driver);
		driver.findElement(By.name("select_phone")).click();
	}

	public void TV_Internet_lob_click(WebDriver driver) {
		scrollToElementByName("select_tv",driver);
		driver.findElement(By.name("select_tv")).click();
		scrollToElementByName("select_internet",driver);
		driver.findElement(By.name("select_internet")).click();
	}

	public void TV_Phone_lob_click(WebDriver driver) {
		scrollToElementByName("select_phone",driver);
		driver.findElement(By.name("select_phone")).click();
		scrollToElementByName("select_tv",driver);
		driver.findElement(By.name("select_tv")).click();
	}

	public void Internet_Phone_lob_click(WebDriver driver) {
		scrollToElementByName("select_phone",driver);
		driver.findElement(By.name("select_phone")).click();
		scrollToElementByName("select_internet",driver);
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
            statusTracker(br,driver,"Pass", "'Starting at' price present for new TV_LOB",
                    "'Starting at ' Present", "Should be present");
        } else {
            statusTracker(br,driver,"Fail", "'Starting at' price present for new TV_LOB",
                    "'Starting at ' Not Present", "Should be present");
        }

        String price = driver.findElement(
                By.xpath("//*[@class='services']/li[1]/div[3]/div")).getText();
        int index_start = price.indexOf("$");
        logger.info("{}",index_start);

        int index_end = index_start + 5;
        logger.info("{}",index_end);
        String start_amount = price.substring(index_start, index_end);
        Double Decimal_Amount = Double.parseDouble(start_amount
                .replace("$", "")) / 100;
        logger.info(start_amount);

        if (start_amount.equalsIgnoreCase("$1999")) {
            statusTracker(br,driver,"Pass", "'Starting at' price present for new TV_LOB",
                    "Starting at price $" + Decimal_Amount + " Present",
                    "Should be present");
        } else {
            statusTracker(br,driver,"Fail", "'Starting at' price present for new TV_LOB",
                    "Starting at price $" + Decimal_Amount + " Not Present",
                    "Should be present");
        }

        Thread.sleep(3000);
        scrollToElementByCSSSelector("span.no-arrow",driver);
        driver.findElement(By.cssSelector("span.no-arrow")).click();

        Thread.sleep(10000);

        if (return_text(".//*[@class='modal-title']", driver).equalsIgnoreCase(
                "Features by TV Plan")) {
            statusTracker(br,driver,"Pass", "Compare TV plan is clicked",
                    "compare TV plan page is displayed", "Should be displayed");
        } else {
            statusTracker(br,driver,"Fail", "Compare TV plan is clicked",
                    "compare TV plan page is not displayed",
                    "Should be displayed");
        }

        Thread.sleep(4000);

        click_element("//*[@class='modal-button-close']", driver);

        if (return_text(
                "//*[@class='text parbase twc-plain-text header-text']", driver)
                .equalsIgnoreCase("Your Current Services")) {
            statusTracker(br,driver,"Pass", "Compare  TV plan is closed",
                    "compare TV plan page closed", "Should be closed");
        } else {
            statusTracker(br,driver,"Fail", "Compare  TV plan is closed",
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
            statusTracker(br,driver,"Pass",
                    "'Starting at' price present for new Internet_LOB",
                    "'Starting at'Present", "Should be present");
        } else {
            statusTracker(br,driver,"Fail",
                    "'Starting at' price present for new Internet_LOB",
                    "'Starting at'Not Present", "Should be present");
        }

        String price = driver.findElement(
                By.xpath("//*[@class='services']/li[1]/div[3]/div")).getText();
        int index_start = price.indexOf("$");
        logger.info("{}",index_start);

        int index_end = index_start + 5;
        logger.info("{}",index_end);
        String start_amount = price.substring(index_start, index_end);
        Double Decimal_Amount = Double.parseDouble(start_amount
                .replace("$", "")) / 100;
        logger.info(start_amount);

        if (start_amount.equalsIgnoreCase("$1499")) {
            statusTracker(br,driver,"Pass",
                    "'Starting at' price present for new Internet_LOB",
                    "'Starting at price " + Decimal_Amount + " Present",
                    "Should be present");
        } else {
            statusTracker(br,driver,"Fail",
                    "'Starting at' price present for new Internet_LOB",
                    "'Starting at price " + Decimal_Amount + " Not Present",
                    "Should be present");
        }
        scrollToElementByCSSSelector("span.no-arrow",driver);
        driver.findElement(By.cssSelector("span.no-arrow")).click();

        if (return_text("//*[@class='modal-title']", driver).equalsIgnoreCase(
                "Internet Plans at a Glance")) {
            statusTracker(br,driver,"Pass", "Compare Internet plans is clicked",
                    "compare Internet plans page is displayed",
                    "Should be displayed");
        } else {
            statusTracker(br,driver,"Fail", "Compare Internet plans is clicked",
                    "compare Internet plans page is not displayed",
                    "Should be displayed");
        }
        Thread.sleep(5000);
        click_element("//*[@class='modal-button-close']", driver);

        if (return_text(
                "//*[@class='text parbase twc-plain-text header-text']", driver)
                .equalsIgnoreCase("Your Current Services")) {
            statusTracker(br,driver,"Pass", "Compare  Internet plans is closed",
                    "compare Internet plans closed", "Should be closed");
        } else {
            statusTracker(br,driver,"Fail", "Compare  Internet plans is closed",
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
            statusTracker(br,driver,"Pass",
                    "'Starting at' price present for new Phone_LOB",
                    "'Starting at'Present", "Should be present");
        } else {
            statusTracker(br,driver,"Fail",
                    "'Starting at' price present for new Phone_LOB",
                    "'Starting at' Not Present", "Should be present");
        }

        String price = driver.findElement(
                By.xpath("//*[@class='services']/li[2]/div[3]/div")).getText();
        int index_start = price.indexOf("$");
        logger.info("{}",index_start);

        int index_end = index_start + 5;
        logger.info("{}",index_end);
        String start_amount = price.substring(index_start, index_end);
        Double Decimal_Amount = Double.parseDouble(start_amount
                .replace("$", "")) / 100;
        logger.info(start_amount);

        {
            if (start_amount.equalsIgnoreCase("$1000")) {
                statusTracker(br,driver,"Pass",
                        "'Starting at' price present for new Phone_LOB",
                        +Decimal_Amount + " Present", "Should be present");

            } else {
                statusTracker(br,driver,"Fail",
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
            statusTracker(br,driver,"Pass", "'Starting at' price present for new TV_LOB",
                    "'Starting at'Present", "Should be present");
        } else {
            statusTracker(br,driver,"Fail", "'Starting at' price present for new TV_LOB",
                    "'Starting at'Not Present", "Should be present");
        }

        String price = driver.findElement(
                By.xpath("//*[@class='services']/li[1]/div[3]/div")).getText();
        int index_start = price.indexOf("$");
        logger.info("{}",index_start);

        int index_end = index_start + 5;
        logger.info("{}",index_end);
        String start_amount = price.substring(index_start, index_end);
        Double Decimal_Amount = Double.parseDouble(start_amount
                .replace("$", "")) / 100;
        logger.info(start_amount);

        {
            if (start_amount.equalsIgnoreCase("$1999")) {
                statusTracker(br,driver,"Pass",
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
            scrollToElementByCSSSelector("span.no-arrow",driver);
            driver.findElement(By.cssSelector("span.no-arrow")).click();

            if (return_text("//*[@class='modal-title']", driver)
                    .equalsIgnoreCase("Features by TV Plan")) {
                statusTracker(br,driver,"Pass", "Compare TV plans is clicked",
                        "compare TV plans page is displayed",
                        "Should be displayed");
            } else {
                statusTracker(br,driver,"Fail", "Compare TV plans is clicked",
                        "compare TV plans page is not displayed",
                        "Should be displayed");
            }
            Thread.sleep(5000);
            click_element("//*[@class='modal-button-close']", driver);

            if (return_text(
                    "//*[@class='text parbase twc-plain-text header-text']",
                    driver).equalsIgnoreCase("Your Current Services")) {
                statusTracker(br,driver,"Pass", "Compare  TV plans is closed",
                        "compare TV plans closed", "Should be closed");
            } else {
                statusTracker(br,driver,"Fail", "Compare  TV plans is closed",
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
                statusTracker(br,driver,"Pass",
                        "'Starting at' price present for new Phone_LOB",
                        "'Starting at'Present", "Should be present");
            } else {
                statusTracker(br,driver,"Fail",
                        "'Starting at' price present for new Phone_LOB",
                        "'Starting at' Not Present", "Should be present");
            }

            String price_1 = driver.findElement(
                    By.xpath("//*[@class='services']/li[2]/div[3]/div"))
                    .getText();
            int index_start_1 = price.indexOf("$");
            logger.info("{}",index_start_1);

            int index_end_1 = index_start_1 + 5;
            logger.info("{}",index_end_1);
            String start_amount_1 = price_1.substring(index_start_1,
                    index_end_1);
            Double Decimal_Amount_1 = Double.parseDouble(start_amount_1
                    .replace("$", "")) / 100;
            logger.info(start_amount_1);

            {
                if (start_amount_1.equalsIgnoreCase("$1000")) {
                    statusTracker(br,driver,"Pass",
                            "'Starting at' price present for new Phone_LOB",
                            "'Starting at price $1000' Present",
                            "Should be present");

                } else {
                    statusTracker(br,driver,"Fail",
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
        	 statusTracker(br,driver,"Pass", "'Starting at' price present for new Tv_LOB",
                    "'Starting at'Present", "Should be present");
        } else {
        	 statusTracker(br,driver,"Fail", "'Starting at' price present for new Tv_LOB",
                    "'Starting at'Not Present", "Should be present");
        }

        String price = driver.findElement(
                By.xpath("//*[@class='services']/li[1]/div[3]/div")).getText();
        int index_start = price.indexOf("$");
        logger.info("{}",index_start);

        int index_end = index_start + 5;
        logger.info("{}",index_end);
        String start_amount = price.substring(index_start, index_end);
        Double Decimal_Amount = Double.parseDouble(start_amount
                .replace("$", "")) / 100;
        logger.info(start_amount);

        {
            if (start_amount.equalsIgnoreCase("$1999")) {
            	 statusTracker(br,driver,"Pass",
                        "'Starting at' price present for new Tv_LOB",
                        "'Starting at price $1999' Present",
                        "Should be present");
            } else {
            	 statusTracker(br,driver,"Fail",
                        "'Starting at' price present for new Tv_LOB",
                        "'Starting at price $1999' Not Present",
                        "Should be present");
            }
            scrollToElementByCSSSelector("span.no-arrow",driver);
            driver.findElement(By.cssSelector("span.no-arrow")).click();

            if (return_text("//*[@class='modal-title']", driver)
                    .equalsIgnoreCase("Features by TV Plan")) {
            	 statusTracker(br,driver,"Pass", "Compare TV plans is clicked",
                        "compare Features by TV plans page is displayed",
                        "Should be displayed");
            } else {
            	 statusTracker(br,driver,"Fail", "Compare TV plans is clicked",
                        "compare TV plans page is not displayed",
                        "Should be displayed");
            }
            Thread.sleep(5000);
            click_element("//*[@class='modal-button-close']", driver);

            if (return_text(
                    "//*[@class='text parbase twc-plain-text header-text']",
                    driver).equalsIgnoreCase("Your Current Services")) {
            	 statusTracker(br,driver,"Pass", "Compare  TV plans is closed",
                        "compare TV plans closed", "Should be closed");
            } else {
            	 statusTracker(br,driver,"Fail", "Compare  TV plans is closed",
                        "compare TV plans page is not closed",
                        "Should be closed");
            }
            Thread.sleep(5000);

        }
        if (return_text(
                "//*[@class='text parbase twc-plain-text starting-at-text-internet']",
                driver).equalsIgnoreCase("starting at"))

        {
        	 statusTracker(br,driver,"Pass",
                    "'Starting at' price present for new Internet_LOB",
                    "'Starting at'Present", "Should be present");
        } else {
        	 statusTracker(br,driver,"Fail",
                    "'Starting at' price present for new Internet_LOB",
                    "'Starting at'Not Present", "Should be present");
        }

        String price_1 = driver.findElement(
                By.xpath("//*[@class='services']/li[2]/div[3]/div")).getText();
        int index_start_1 = price.indexOf("$");
        logger.info("{}",index_start_1);

        int index_end_1 = index_start_1 + 5;
        logger.info("{}",index_end_1);
        String start_amount_1 = price_1.substring(index_start_1, index_end_1);
        Double Decimal_Amount_1 = Double.parseDouble(start_amount_1.replace(
                "$", "")) / 100;
        logger.info(start_amount_1);

        {
            if (start_amount_1.equalsIgnoreCase("$1499")) {
            	 statusTracker(br,driver,"Pass",
                        "'Starting at' price present for new Internet_LOB",
                        "Starting at price " + Decimal_Amount_1 + " Present",
                        "Should be present");
            } else {
            	 statusTracker(br,driver,"Fail",
                        "'Starting at' price present for new Internet_LOB",
                        "Starting at price " + Decimal_Amount_1
                                + " Not Present", "Should be present");
            }
            scrollToElementByCSSSelector("span.no-arrow",driver);
            driver.findElement(By.cssSelector("span.no-arrow")).click();

            if (return_text("//*[@class='modal-title']", driver)
                    .equalsIgnoreCase("Internet Plans at a Glance")) {
            	 statusTracker(br,driver,"Pass", "Compare Internet plans is clicked",
                        "compare Internet plans page is displayed",
                        "Should be displayed");
            } else {
            	 statusTracker(br,driver,"Fail", "Compare Internet plans is clicked",
                        "compare Internet plans page is not displayed",
                        "Should be displayed");
            }
            Thread.sleep(5000);
            click_element("//*[@class='modal-button-close']", driver);

            if (return_text(
                    "//*[@class='text parbase twc-plain-text header-text']",
                    driver).equalsIgnoreCase("Your Current Services")) {
            	 statusTracker(br,driver,"Pass", "Compare  Internet plans is closed",
                        "compare Internet plans closed", "Should be closed");
            } else {
            	 statusTracker(br,driver,"Fail", "Compare  Internet plans is closed",
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
        	 statusTracker(br,driver,"Pass",
                    "'Starting at' price present for new Internet_LOB",
                    "'Starting at'Present", "Should be present");
        } else {
        	 statusTracker(br,driver,"Fail",
                    "'Starting at' price present for new Internet_LOB",
                    "'Starting at'Not Present", "Should be present");
        }

        String price = driver.findElement(
                By.xpath("//*[@class='services']/li[1]/div[3]/div")).getText();
        int index_start = price.indexOf("$");
        logger.info("{}",index_start);

        int index_end = index_start + 5;
        logger.info("{}",index_end);
        String start_amount = price.substring(index_start, index_end);
        Double Decimal_Amount = Double.parseDouble(start_amount
                .replace("$", "")) / 100;
        logger.info(start_amount);

        {
            if (start_amount.equalsIgnoreCase("$1499")) {
            	 statusTracker(br,driver,"Pass",
                        "'Starting at' price present for new Internet_LOB",
                        +Decimal_Amount + "Present", "Should be present");
            } else {
            	 statusTracker(br,driver,"Fail",
                        "'Starting at' price present for new Internet_LOB",
                        +Decimal_Amount + "Present", "Should be present");
            }

            Thread.sleep(2000);
            /*
            driver.findElement(
                    By.xpath("//*[@ class='compare_internet_plans cta']/a/span[1]"))
                    .click();
            // driver.findElement(By.cssSelector("span.no-arrow")).click();
            Thread.sleep(10000);

            if (return_text("//*[@class='modal-title']", driver)
                    .equalsIgnoreCase("Internet Plans at a Glance")) {
            	 statusTracker(br,driver,"Pass", "Compare Internet plans is clicked",
                        "compare Internet plans page is displayed",
                        "Should be displayed");
            } else {
            	 statusTracker(br,driver,"Fail", "Compare Internet plans is clicked",
                        "compare Internet plans page is not displayed",
                        "Should be displayed");
            }
            Thread.sleep(5000);
            click_element("//*[@class='modal-button-close']", driver);
            */
            Thread.sleep(3000);
            if (return_text(
                    "//*[@class='text parbase twc-plain-text header-text']",
                    driver).equalsIgnoreCase("Your Current Services")) {
            	 statusTracker(br,driver,"Pass", "Compare  Internet plans is closed",
                        "compare Internet plans closed", "Should be closed");
            } else {
            	 statusTracker(br,driver,"Fail", "Compare  Internet plans is closed",
                        "compare Internet plans page is not closed",
                        "Should be closed");
            }
            Thread.sleep(5000);
        }
        {
            if (return_text(
                    "//*[@class='text parbase starting-at-text-phone twc-plain-text']",
                    driver).equalsIgnoreCase("starting at")) {
            	 statusTracker(br,driver,"Pass",
                        "'Starting at' price present for new Phone_LOB",
                        "'Starting at'Present", "Should be present");
            } else {
            	 statusTracker(br,driver,"Fail",
                        "'Starting at' price present for new Phone_LOB",
                        "'Starting at' Not Present", "Should be present");
            }

            String price_1 = driver.findElement(
                    By.xpath("//*[@class='services']/li[2]/div[3]/div"))
                    .getText();
            int index_start_1 = price_1.indexOf("$");
            logger.info("{}",index_start_1);

            int index_end_1 = index_start_1 + 5;
            logger.info("{}",index_end_1);
            String start_amount_1 = price_1.substring(index_start_1,
                    index_end_1);
            Double Decimal_Amount_1 = Double.parseDouble(start_amount_1
                    .replace("$", "")) / 100;
            logger.info(start_amount_1);

            {
                if (start_amount_1.equalsIgnoreCase("$1000")) {
                	 statusTracker(br,driver,"Pass",
                            "'Starting at' price present for new Phone_LOB",
                            +Decimal_Amount_1 + "Present", "Should be present");
                } else {
                	 statusTracker(br,driver,"Fail",
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
            	 statusTracker(br,driver,"Pass",
                        "check for TV_los plan in current service",
                        "Plan matches ", "Plan Should Match");
            } else {
            	 statusTracker(br,driver,"Fail",
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
            	 statusTracker(br,driver,"Pass",
                        "check for Internet_los plan in current service",
                        "Plan matches ", "Plan Should Match");
            } else {
            	 statusTracker(br,driver,"Fail",
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
            	 statusTracker(br,driver,"Pass",
                        "check for Phone_los plan in current service",
                        "Plan matches ", "Plan Should Match");
            } else {
            	 statusTracker(br,driver,"Fail",
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
            	 statusTracker(br,driver,"Pass",
                        "check for Internet_los plan in current service",
                        "Plan matches ", "Plan Should Match");
            } else {
            	 statusTracker(br,driver,"Fail",
                        "check forInternet_los plan in current service",
                        "Plan doesnt match", "Plan Should Match");
            }
        }

        if (return_text("//*[@class='current services']/li[2]/div[2]/h4",
                driver).equals(Phone_service)) {
            if (return_text(".//*[@class='current services']/li[2]/div[2]/h5",
                    driver).equals(Phone_plan))

            {
            	 statusTracker(br,driver,"Pass",
                        "check for Phone_los plan in current service",
                        "Plan matches ", "Plan Should Match");
            } else {
            	 statusTracker(br,driver,"Fail",
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
            	 statusTracker(br,driver,"Pass",
                        "check for TV_los plan in current service",
                        "Plan matches ", "Plan Should Match");
            } else {
            	 statusTracker(br,driver,"Fail",
                        "check for TV_los plan in current service",
                        "Plan doesnt match", "Plan Should Match");
            }
        }

        if (return_text("//*[@class='current services']/li[2]/div[2]/h4",
                driver).equals(Internet_service)) {
            if (return_text(".//*[@class='current services']/li[2]/div[2]/h5",
                    driver).equals(Internet_plan))

            {
            	 statusTracker(br,driver,"Pass",
                        "check for Phone_los plan in current service",
                        "Plan matches ", "Plan Should Match");
            } else {
            	 statusTracker(br,driver,"Fail",
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
            	 statusTracker(br,driver,"Pass",
                        "check for TV_los plan in current service",
                        "Plan matches ", "Plan Should Match");
            } else {
            	 statusTracker(br,driver,"Fail",
                        "check for TV_los plan in current service",
                        "Plan doesnt match", "Plan Should Match");
            }
        }

        if (return_text("//*[@class='current services']/li[2]/div[2]/h4",
                driver).equals(Phone_service)) {
            if (return_text(".//*[@class='current services']/li[2]/div[2]/h5",
                    driver).equals(Phone_plan))

            {
            	 statusTracker(br,driver,"Pass",
                        "check for Phone_los plan in current service",
                        "Plan matches ", "Plan Should Match");
            } else {
            	 statusTracker(br,driver,"Fail",
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
            	 statusTracker(br,driver,"Pass",
                        "check for TV_los plan in current service",
                        "Plan matches ", "Plan Should Match");
            } else {
            	 statusTracker(br,driver,"Fail",
                        "check for TV_los plan in current service",
                        "Plan doesnt match", "Plan Should Match");
            }
        }

        if (return_text("//*[@class='current services']/li[2]/div[2]/h4",
                driver).equals(Internet_service)) {
            if (return_text(".//*[@class='current services']/li[2]/div[2]/h5",
                    driver).equals(Internet_plan))

            {
            	 statusTracker(br,driver,"Pass",
                        "check for Phone_los plan in current service",
                        "Plan matches ", "Plan Should Match");
            } else {
            	 statusTracker(br,driver,"Fail",
                        "check for Phone_los plan in current service",
                        "Plan doesnt match", "Plan Should Match");
            }

        }

        if (return_text("//*[@class='current services']/li[3]/div[2]/h4",
                driver).equals(Phone_service)) {
            if (return_text(".//*[@class='current services']/li[3]/div[2]/h5",
                    driver).equals(Phone_plan))

            {
            	 statusTracker(br,driver,"Pass",
                        "check for Phone_los plan in current service",
                        "Plan matches ", "Plan Should Match");
            } else {
                statusTracker(br,driver,"Fail",
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
     * statusTracker(" ","Address 1: ",StoreAddress1," "); else
     * statusTracker("Fail","Address 1: ","Address 1 is Not Displayed"," ");
     * 
     * if(!StoreAddress2.equals(""))
     * statusTracker(" ","Address 2: ",StoreAddress2," "); else
     * statusTracker("Fail","Address 2: ","Address 2 is Not Displayed"," ");
     * 
     * if(!StoreAddress3.equals(""))
     * statusTracker(" ","Address 3: ",StoreAddress3," "); else
     * statusTracker("Fail","Address 3: ","Address 3 is Not Displayed"," ");
     * 
     * //For the Store Pick option, the Value Free is verified.
     * if((return_text(".//*[@id='section-pickup']/header/label/span[1]",
     * drive).trim()).equals("Free"))
     * statusTracker("Pass","For the Store Pick there is NO processing fees"
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
     * drive).trim()).equals("Easy Connect Pick-up Fee")) statusTracker("Pass",
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
     * "").trim())) statusTracker("Pass",
     * "For the Store Pick option, the One Time Charges charges to be verified"
     * ,return_text(".//*[@class='services-table']/tbody/tr[1]/td[2]",
     * drive)+" is displayed.","One Time Charges VALUE is as Expected"); else
     * statusTracker("Fail",
     * "For the Store Pick option, the One Time Charges charges  to be verified"
     * ,return_text(".//*[@class='services-table']/tbody/tr[1]/td[2]",
     * drive)+" is displayed.","One Time Charges VALUE is NOT as Expected");
     * 
     * } else if (ECKOptionName.equals("Mail")) { //Hard coded the text, as the
     * contents will not modify
     * if(return_text(".//*[@id='section-mail']/section/div/div/div/div[1]/ul/li"
     * , drive).equals("TV Equipment Easy Connect Kit"))
     * statusTracker("Pass","Mail Option Content Validation"
     * ,return_text(".//*[@id='section-mail']/section/div/div/div/div[1]/ul/li",
     * drive)," TV Equipment Text is correct under Mail option"); else
     * statusTracker("Fail","Mail Option Content Validation",return_text(
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
     * drive).trim()).equals("Easy Connect S & H Fee")) statusTracker("Pass",
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
     * "").trim()) ) statusTracker("Pass",
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
     * drive).trim()).equals("Service Installation Fee")) statusTracker("Pass",
     * "For the Tech Install option, the One Time Charges Text to be verified"
     * ,return_text(".//*[@class='services-table']/tbody/tr[1]/td[1]",
     * drive)+" is displayed.","One Time Charges Text is as Expected"); else
     * statusTracker("Fail",
     * "For the Tech Install option, the One Time Charges Text to be verified"
     * ,return_text(".//*[@class='services-table']/tbody/tr[1]/td[1]",
     * drive)+" is displayed.","One Time Charges Text is NOT as Expected");
     * 
     * if (InstallationFees == Double.parseDouble(return_text(
     * ".//*[@class='services-table']/tbody/tr[1]/td[2]", drive).replace("$",
     * "").trim()) ) statusTracker("Pass",
     * "For the Tech Install option, the One Time Charges charges to be verified"
     * ,return_text(".//*[@class='services-table']/tbody/tr[1]/td[2]",
     * drive)+" is displayed.","One Time Charges VALUE is as Expected"); else
     * statusTracker("Fail",
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
     * "").trim())) statusTracker("Pass",
     * "The One Time Charges + ECK Fees is same as displayed in the Review Order page"
     * ,return_text(".//*[@title='One Time Charges']/tfoot/tr/td[2]",
     * drive)+" is displayed."
     * ,"One Time Charges VALUE : "+Overall_oneTimeCharges+" is as Expected");
     * else statusTracker("Fail",
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
     * drive).trim()).equals("Easy Connect Pick-up Fee")) statusTracker("Pass",
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
     * "").trim())) statusTracker("Pass",
     * "For the Store Pick option, the One Time Charges charges to be verified in the Order Summary Page"
     * ,return_text(".//*[@class='services-table']/tbody/tr[1]/td[2]",
     * drive)+" is displayed.","One Time Charges VALUE is as Expected"); else
     * statusTracker("Fail",
     * "For the Store Pick option, the One Time Charges charges  to be verified in the Order Summary Page"
     * ,return_text(".//*[@class='services-table']/tbody/tr[1]/td[2]",
     * drive)+" is displayed.","One Time Charges VALUE is NOT as Expected");
     * 
     * if(StoreAddress1.equals(return_text(".//*[@class='three-col']/li[1]",
     * drive).trim())) statusTracker("Pass",
     * "Both Addresses 1 in Review & Summary Order page should be same"
     * ,return_text(".//*[@class='three-col']/li[1]",
     * drive),"Both Addresses 1 in Review & Summary Order page are same"); else
     * statusTracker
     * ("Fail","Both Addresses 1 in Review & Summary Order page should be same"
     * ,return_text(".//*[@class='three-col']/li[1]",
     * drive),"Both Addresses 1 in Review & Summary Order page are NOT same");
     * 
     * if(StoreAddress2.equals(return_text(".//*[@class='three-col']/li[2]",
     * drive).trim())) statusTracker("Pass",
     * "Both Addresses 2 in Review & Summary Order page should be same"
     * ,return_text(".//*[@class='three-col']/li[2]",
     * drive),"Both Addresses 2 in Review & Summary Order page are same"); else
     * statusTracker
     * ("Fail","Both Addresses 2 in Review & Summary Order page should be same"
     * ,return_text(".//*[@class='three-col']/li[2]",
     * drive),"Both Addresses 2 in Review & Summary Order page are NOT same");
     * 
     * if(StoreAddress3.equals(return_text(".//*[@class='three-col']/li[3]",
     * drive).trim())) statusTracker("Pass",
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
     * statusTracker("Pass"
     * ,"Order Summary Page - "+ECKOptionSelected+" Option Content Validation"
     * ,Equip_text
     * ," TV Equipment Text is correct under "+ECKOptionSelected+" option");
     * else statusTracker("Fail","Order Summary Page - "+ECKOptionSelected+
     * " Option Content Validation"
     * ,Equip_text," TV Equipment Text is NOT correct under "
     * +ECKOptionSelected+" option"); } if (Overall_oneTimeCharges ==
     * Double.parseDouble
     * (return_text(".//*[@title='One Time Charges']/tfoot/tr/td[2]",
     * drive).replace("$", "").trim())) statusTracker("Pass",
     * "The One Time Charges + ECK Fees is same as displayed in the Order Summary page"
     * ,return_text(".//*[@title='One Time Charges']/tfoot/tr/td[2]",
     * drive)+" is displayed."
     * ,"One Time Charges VALUE : "+Overall_oneTimeCharges+" is as Expected");
     * else statusTracker("Fail",
     * "The One Time Charges + ECK Fees is same as displayed in the Order Summary page"
     * ,return_text(".//*[@title='One Time Charges']/tfoot/tr/td[2]",
     * drive)+" is displayed."
     * ,"One Time Charges VALUE : "+Overall_oneTimeCharges
     * +" is NOT as Expected");
     * 
     * //Validating the Service Address Expected_ServiceAddress = Cust_Name +
     * " " +Cust_ServiceAddress.replace("Service Address: ", ""); Actual_ServiceAddress =
     * return_text(".//*[@class='last']", drive).trim();
     * 
     * logger.info("Expected_ServiceAddress : "+Expected_ServiceAddress);
     * logger.info("Actual_ServiceAddress : "+ Actual_ServiceAddress);
     * 
     * if (Expected_ServiceAddress.equals(Actual_ServiceAddress))
     * statusTracker("Pass"
     * ,"Order Summary Page - Validating Service Address",Actual_ServiceAddress
     * ,"Service Address is same as the Customer Details tagged to the account"
     * ); else
     * statusTracker("Fail","Order Summary Page - Validating Service Address"
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
     * drive).trim()).equals("Service Installation Fee")) statusTracker("Pass",
     * "For the Tech Install option, the One Time Charges Text to be verified"
     * ,return_text(".//*[@class='services-table']/tbody/tr[1]/td[1]",
     * drive)+" is displayed.","One Time Charges Text is as Expected"); else
     * statusTracker("Fail",
     * "For the Tech Install option, the One Time Charges Text to be verified"
     * ,return_text(".//*[@class='services-table']/tbody/tr[1]/td[1]",
     * drive)+" is displayed.","One Time Charges Text is NOT as Expected");
     * 
     * if (InstallationFees == Double.parseDouble(return_text(
     * ".//*[@class='services-table']/tbody/tr[1]/td[2]", drive).replace("$",
     * "").trim()) ) statusTracker("Pass",
     * "For the Tech Install option, the One Time Charges charges to be verified"
     * ,return_text(".//*[@class='services-table']/tbody/tr[1]/td[2]",
     * drive)+" is displayed.","One Time Charges VALUE is as Expected"); else
     * statusTracker("Fail",
     * "For the Tech Install option, the One Time Charges charges to be verified"
     * ,return_text(".//*[@class='services-table']/tbody/tr[1]/td[2]",
     * drive)+" is displayed.","One Time Charges VALUE is NOT as Expected");
     * 
     * Overall_oneTimeCharges = oneTimeCharges + InstallationFees; if
     * (Overall_oneTimeCharges == Double.parseDouble(return_text(
     * ".//*[@title='One Time Charges']/tfoot/tr/td[2]", drive).replace("$",
     * "").trim())) statusTracker("Pass",
     * "The One Time Charges + ECK Fees is same as displayed in the Review Order page"
     * ,return_text(".//*[@title='One Time Charges']/tfoot/tr/td[2]",
     * drive)+" is displayed."
     * ,"One Time Charges VALUE : "+Overall_oneTimeCharges+" is as Expected");
     * else statusTracker("Fail",
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
     * drive).trim()); statusTracker("Pass",
     * "The Phone Text details in the Order Summary page to be verified"
     * ,"The Phone Text details is verified."
     * ,"The Phone Text details is as Expected."); } else statusTracker("Fail",
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
     * ); else statusTracker("Fail",
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
     * ); else statusTracker("Fail",
     * "Order Summary Page - Validation Second Install Date & Time Details."
     * ,return_text(".//*[@class='firstVisitSchedule2 paragraphMerge']/p",
     * drive).replace(":00", "").replace("Your Second Choice:", "").trim(),
     * "Second Install Date & Time Details are NOT same, as per the Review Order page"
     * ); }
     * 
     * if (Overall_oneTimeCharges == Double.parseDouble(return_text(
     * ".//*[@title='One Time Charges']/tfoot/tr/td[2]", drive).replace("$",
     * "").trim())) statusTracker("Pass",
     * "The One Time Charges + ECK Fees is same as displayed in the Order Summary page"
     * ,return_text(".//*[@title='One Time Charges']/tfoot/tr/td[2]",
     * drive)+" is displayed."
     * ,"One Time Charges VALUE : "+Overall_oneTimeCharges+" is as Expected");
     * else statusTracker("Fail",
     * "The One Time Charges + ECK Fees is same as displayed in the Order Summary page"
     * ,return_text(".//*[@title='One Time Charges']/tfoot/tr/td[2]",
     * drive)+" is displayed."
     * ,"One Time Charges VALUE : "+Overall_oneTimeCharges
     * +" is NOT as Expected");
     * 
     * 
     * //Validating the Service Address Expected_ServiceAddress = Cust_Name +
     * " " +Cust_ServiceAddress.replace("Service Address: ", ""); Actual_ServiceAddress =
     * return_text(".//*[@class='last']", drive).trim();
     * 
     * logger.info("Expected_ServiceAddress : "+Expected_ServiceAddress);
     * logger.info("Actual_ServiceAddress : "+ Actual_ServiceAddress);
     * 
     * if (Expected_ServiceAddress.equals(Actual_ServiceAddress))
     * statusTracker("Pass"
     * ,"Order Summary Page - Validating Service Address",Actual_ServiceAddress
     * ,"Service Address is same as the Customer Details tagged to the account"
     * ); else
     * statusTracker("Fail","Order Summary Page - Validating Service Address"
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

    

    public String OrderSummary_DateTimeFormat(String FirstSecondDate)
            throws ParseException {
        DateFormat formatter;
        Date date;
        formatter = new SimpleDateFormat("MM/dd/yyyy");
        date = formatter.parse(FirstSecondDate);
        return new SimpleDateFormat("EEEE").format(date) + ", "
                + new SimpleDateFormat("MMM").format(date) + " "
                + new SimpleDateFormat("d").format(date) + ", "
                + new SimpleDateFormat("YYYY").format(date);
    }

    public void OrderSummary_ChkBrowserBackButton(String br, WebDriver drive) throws InterruptedException {
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
        click_element("//*[@data-shortname='Private Listing']", driver);
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
        click_element("//*[@data-shortname='Voicemail']", driver);
    }

    public void click_GlobalPenny(WebDriver driver) throws InterruptedException {
        click_element("//*[@class='content-wrap']/div[6]/header/ul/li[1]/a",
                driver);
        Thread.sleep(2000);
        click_element("//*[@class='content-wrap']/div[6]/header/ul/li[1]/a",
                driver);
        Thread.sleep(2000);
        click_element("//*[@data-shortname='Global Penny Phone Plan']", driver);
    }

    public void click_International(WebDriver driver)
            throws InterruptedException {
        click_element("//*[@class='content-wrap']/div[7]/header/ul/li[1]/a",
                driver);
        Thread.sleep(2000);
        click_element("//*[@class='content-wrap']/div[7]/header/ul/li[1]/a",
                driver);
        Thread.sleep(2000);
        click_element("//*[@data-shortname='International OnePrice®']", driver);
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

    public void transfer_number(String br,WebDriver driver) throws InterruptedException {
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
        click_International(driver);
        Thread.sleep(2000);
        config_page_Cart_result_updater(br,driver);
        page_Cart_One_Time_charge_updater(br,driver);
        Thread.sleep(3000);

        // Compare Plan Page check
        click_element("//*[@class='modal modalGeneric js-modal-initialized']", driver);
        logger.info("two");

        Thread.sleep(10000);

        String modal_title = driver.findElement(
                By.xpath("//*[@class='modal-title']")).getText();
        if (modal_title.equalsIgnoreCase("International Calling Rates")) {
        	  statusTracker(br,driver,"Pass", "Click on Compare Plan link",
                    "Compare Plan link is clicked",
                    "Compare plan link should be clicked");
            logger.info("tHREE" + "");
        } else {
        	  statusTracker(br,driver,"Fail", "Click on Compare Plan link",
                    "Compare Plan link is not clicked",
                    "Compare plan link should be clicked");
        }

        click_element("//*[@class='modal-button-close']", driver);
        Thread.sleep(5000);

        String Act_config = driver
                .findElement(
                        By.xpath("//*[@class='text parbase sectionHeader twc-plain-text']"))
                .getText();
        if (Act_config
                .equalsIgnoreCase("Select Optional Features & Calling Plans")) {
        	  statusTracker(br,driver,"Pass", "Click on close button of Compare Plan",
                    "Compare Plan gets closed",
                    "Compare plan should get closed");
        } else {
        	  statusTracker(br,driver,"Fail", "Click on close button of Compare Plan",
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
        	  statusTracker(br,driver,"Pass",
                    "Transfer number general form gets displayed",
                    "Transfer number general form is displayed",
                    "Transfer number general form should be displayed");
        } else {
        	  statusTracker(br,driver,"Fail",
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
                 field_statustracker(br,"//*[@id='currentProvider']",
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
                 field_statustracker(br,"//*[@id='current-provider-state']",
                        "Select Current Provider State",
                        "Current Provider state is Selected", driver);
                break;
            }
        }

        driver.findElement(By.xpath("//*[@id='phone-number']")).sendKeys(
                "123-876-7678");
        Thread.sleep(2000);
         field_statustracker(br,"//*[@id='phone-number']", "Enter Phone Number",
                "Phone number is Entered", driver);
        Thread.sleep(2000);
        driver.findElement(By.id("account-number")).sendKeys("23456745");
        Thread.sleep(2000);
        field_statustracker(br,"//*[@id='account-number']",
                "Enter Account Number", "Account Number is Entered", driver);
        Thread.sleep(2000);
        driver.findElement(By.id("account-name")).sendKeys("Dani");
         field_statustracker(br,"//*[@id='account-name']", "Account Name",
                "Account Name is Entered", driver);
        Thread.sleep(2000);
        driver.findElement(By.id("security-code")).sendKeys("3433");
         field_statustracker(br,"//*[@id='security-code']", "Enter Security Code",
                "Security Code is Entered", driver);
        Thread.sleep(2000);
        driver.findElement(By.id("address")).sendKeys("4th cross");
         field_statustracker(br,"//*[@id='address']", "Enter Address",
                "Address is Entered", driver);
        Thread.sleep(2000);
        driver.findElement(By.id("apt-type")).sendKeys("#10");
         field_statustracker(br,"//*[@id='apt-type']", "Enter apt type",
                "Apt Type is Entered", driver);
        Thread.sleep(2000);
        driver.findElement(By.id("city")).sendKeys("nyc");
         field_statustracker(br,"//*[@id='city']", "Enter City", "City is Entered",
                driver);
        Thread.sleep(2000);
        driver.findElement(By.id("zip-code")).sendKeys("23456");
         field_statustracker(br,"//*[@id='zip-code']", "Enter Zip-Code",
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
        scrollToElementByCSSSelector("form > div.continue > a",driver);
        driver.findElement(By.cssSelector("form > div.continue > a")).click();
        Thread.sleep(5000);
        logger.info("Continue clicked");
        // enter first name

        click_element("//*[@id='tpv-choose-TWC']", driver);

        Thread.sleep(5000);
        
        driver.findElement(By.xpath("//*[@id='full-name1']")).sendKeys(
                "Wideband");
         field_statustracker(br,"//*[@id='full-name1']", " Enter Full Name",
                "Full Name of user is Entered", driver);
        Thread.sleep(5000);

        WebElement my_select_birthmonth = driver.findElement(By
                .xpath("//*[@id='birth-month']"));
        my_select_birthmonth.click();
        List<WebElement> my_li_bm = my_select_birthmonth.findElements(By
                .tagName("option"));

        int size_drop_bm = my_li_bm.size();
        logger.info("{}",size_drop_bm);
        for (int i = 0; i < size_drop_bm; i++) {
            if (my_li_bm.get(i).getText().equals("June")) {
                my_li_bm.get(i).sendKeys("June");
                 field_statustracker(br,"//*[@id='birth-month']", "Select Month",
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
        logger.info("{}",size_drop_bd);

        for (int i = 0; i < size_drop_bd; i++) {
            if (my_li_bd.get(i).getText().equals("5")) {
                my_li_bd.get(i).sendKeys("5");
                 field_statustracker(br,"//*[@id='birth-date']",
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
        logger.info("",size_drop_by);
        for (int i = 0; i < size_drop_by; i++) {
            if (my_li_by.get(i).getText().equals("1950")) {
                my_li_by.get(i).sendKeys("1950");
                 field_statustracker(br,"//*[@id='birth-year']", "Select Year",
                        "Birth year is selected", driver);
                break;
            }

        }
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='full-name2']")).sendKeys(
                "Wideband");
         field_statustracker(br,"//*[@id='full-name2']", "Enter Full Name",
                "Full Name is Entered", driver);

        Thread.sleep(2000);
        scrollToElementByCSSSelector("span.arrow",driver);
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
        click_International(driver);
        Thread.sleep(2000);
        config_page_Cart_result_updater_1(br,driver);
        page_Cart_One_Time_charge_updater_1(br,driver);
        Thread.sleep(3000);

        // Compare Plan Page check
        click_element("//*[@class='modal modalGeneric js-modal-initialized']", driver);
        logger.info("two");

        Thread.sleep(10000);

        String modal_title = driver.findElement(
                By.xpath("//*[@class='modal-title']")).getText();
        if (modal_title.equalsIgnoreCase("International Calling Rates")) {
        	  statusTracker(br,driver,"Pass", "Click on Compare Plan link",
                    "Compare Plan link is clicked",
                    "Compare plan link should be clicked");
            logger.info("tHREE" + "");
        } else {
        	  statusTracker(br,driver,"Fail", "Click on Compare Plan link",
                    "Compare Plan link is not clicked",
                    "Compare plan link should be clicked");
        }

        click_element("//*[@class='modal-button-close']", driver);
        Thread.sleep(5000);

        String Act_config = driver
                .findElement(
                        By.xpath("//*[@class='text parbase sectionHeader twc-plain-text']"))
                .getText();
        if (Act_config
                .equalsIgnoreCase("Select Optional Features & Calling Plans")) {
        	  statusTracker(br,driver,"Pass", "Click on close button of Compare Plan",
                    "Compare Plan gets closed",
                    "Compare plan should get closed");
        } else {
        	  statusTracker(br,driver,"Fail", "Click on close button of Compare Plan",
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
        	  statusTracker(br,driver,"Pass",
                    "Transfer number general form gets displayed",
                    "Transfer number general form is displayed",
                    "Transfer number general form should be displayed");
        } else {
        	  statusTracker(br,driver,"Fail",
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
                 field_statustracker(br,"//*[@id='currentProvider']",
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
                 field_statustracker(br,"//*[@id='current-provider-state']",
                        "Select Current Provider State",
                        "Current Provider state is Selected", driver);
                break;
            }
        }

        driver.findElement(By.xpath("//*[@id='phone-number']")).sendKeys(
                "123-876-7678");
        Thread.sleep(2000);
         field_statustracker(br,"//*[@id='phone-number']", "Enter Phone Number",
                "Phone number is Entered", driver);
        Thread.sleep(2000);
        driver.findElement(By.id("account-number")).sendKeys("23456745");
        Thread.sleep(2000);
         field_statustracker(br,"//*[@id='account-number']",
                "Enter Account Number", "Account Number is Entered", driver);
        Thread.sleep(2000);
        driver.findElement(By.id("account-name")).sendKeys("Dani");
         field_statustracker(br,"//*[@id='account-name']", "Account Name",
                "Account Name is Entered", driver);
        Thread.sleep(2000);
        driver.findElement(By.id("security-code")).sendKeys("3433");
         field_statustracker(br,"//*[@id='security-code']", "Enter Security Code",
                "Security Code is Entered", driver);
        Thread.sleep(2000);
        driver.findElement(By.id("address")).sendKeys("4th cross");
         field_statustracker(br,"//*[@id='address']", "Enter Address",
                "Address is Entered", driver);
        Thread.sleep(2000);
        driver.findElement(By.id("apt-type")).sendKeys("#10");
         field_statustracker(br,"//*[@id='apt-type']", "Enter apt type",
                "Apt Type is Entered", driver);
        Thread.sleep(2000);
        driver.findElement(By.id("city")).sendKeys("nyc");
         field_statustracker(br,"//*[@id='city']", "Enter City", "City is Entered",
                driver);
        Thread.sleep(2000);
        driver.findElement(By.id("zip-code")).sendKeys("23456");
         field_statustracker(br,"//*[@id='zip-code']", "Enter Zip-Code",
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
        scrollToElementByCSSSelector("form > div.continue > a",driver);
        driver.findElement(By.cssSelector("form > div.continue > a")).click();
        Thread.sleep(5000);
        logger.info("Continue clicked");
        // enter first name

        click_element("//*[@id='tpv-choose-TWC']", driver);

        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id='full-name1']")).sendKeys(
                "Wideband");
         field_statustracker(br,"//*[@id='full-name1']", " Enter Full Name",
                "Full Name of user is Entered", driver);
        Thread.sleep(5000);

        WebElement my_select_birthmonth = driver.findElement(By
                .xpath("//*[@id='birth-month']"));
        my_select_birthmonth.click();
        List<WebElement> my_li_bm = my_select_birthmonth.findElements(By
                .tagName("option"));

        int size_drop_bm = my_li_bm.size();
        logger.info("{}",size_drop_bm);
        for (int i = 0; i < size_drop_bm; i++) {
            if (my_li_bm.get(i).getText().equals("June")) {
                my_li_bm.get(i).sendKeys("June");
                 field_statustracker(br,"//*[@id='birth-month']", "Select Month",
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
        logger.info("{}",size_drop_bd);

        for (int i = 0; i < size_drop_bd; i++) {
            if (my_li_bd.get(i).getText().equals("5")) {
                my_li_bd.get(i).sendKeys("5");
                 field_statustracker(br,"//*[@id='birth-date']",
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
        logger.info("",size_drop_by);
        for (int i = 0; i < size_drop_by; i++) {
            if (my_li_by.get(i).getText().equals("1950")) {
                my_li_by.get(i).sendKeys("1950");
                 field_statustracker(br,"//*[@id='birth-year']", "Select Year",
                        "Birth year is selected", driver);
                break;
            }

        }
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='full-name2']")).sendKeys(
                "Wideband");
         field_statustracker(br,"//*[@id='full-name2']", "Enter Full Name",
                "Full Name is Entered", driver);

        Thread.sleep(2000);
        scrollToElementByCSSSelector("span.arrow",driver);
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
     * statusTracker(" ","cart details",
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
     * )).getText())) { statusTracker("Pass",
     * "Verify if the Eqipment added to the cart adds up to the total"
     * ,"The euipment added to the cart adds up to the total"
     * ,"The items added to the cart  total"); } else { statusTracker("Fail",
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
        logger.info("{}",mon_total_items);

        for (int i = 1; i <= mon_total_items; i++)

        {
            itemname_mon[i] = return_text(
                    "//*[@id='content']/div[2]/div[2]/div/div[1]/div/div/div[2]/section/div/div[2]/section/table/tbody/tr["
                            + i + "]/td[1]", driver);
            itemcost_mon[i] = return_text(
                    "//*[@id='content']/div[2]/div[2]/div/div[1]/div/div/div[2]/section/div/div[2]/section/table/tbody/tr["
                            + i + "]/td[2]", driver);
            logger.info(" Service cost is:" + itemcost_mon[i]);
            logger.info(" Serivce name is:" + itemname_mon[i]);
            statusTracker(br,driver," ", "cart details", "Service name is: "
                    + itemname_mon[i] + " and Service cost is: "
                    + itemcost_mon[i],
                    "selected service should be updated in one time charge section");
        }
        mon_total = return_text(
                "//*[@id='content']/div[2]/div[2]/div/div[1]/div/div/div/div[2]/section/table/tbody/tr/td[2]",
                driver);
        statusTracker(br,driver," ", "cart details", "Monthly one time charges is "
                + mon_total, "one time charge should be updated in cart");
    }

   

    // *****************************************************************
    // Internet LOB****************************************

    public void I_will_use_my_modem(WebDriver driver)
            throws InterruptedException {
        logger.info("CLick on i will use my modem arrow");
        click_element(".//*[@class='modem-options']/div[3]/header/ul/li[1]/a", driver);
        Thread.sleep(2000);
        click_element(".//*[@class='modem-options']/div[3]/header/ul/li[1]/a", driver);
        logger.info("Click on Radio_I WILL USE MY MODEM");
        click_element("//*[@data-name='My Own Modem']", driver);
        logger.info("Radio I WILL USE MY MODEM Clicked ");
    }

    public void HomeWiFi_InternetModem(WebDriver driver)
            throws InterruptedException {
        logger.info("CLick on HomeWiFi_InternetModem arrow");
        click_element("//*[@class='modem-options']/div[2]/header/ul/li[1]/a", driver);
        Thread.sleep(2000);
        click_element("//*[@class='modem-options']/div[2]/header/ul/li[1]/a", driver);
        logger.info("Click on Radio_HomeWiFi_InternetModem");
        click_element("//*[@data-name='Home WiFi and Wireless Gateway']", driver);
        logger.info("Radio HomeWiFi_InternetModem Clicked ");

    }

    public void InternetModem(WebDriver driver) throws InterruptedException {
        logger.info("CLick on InternetModem arrow");
        click_element("//*[@class='modem-options']/div[1]/header/ul/li[1]/a", driver);
        Thread.sleep(2000);
        click_element("//*[@class='modem-options']/div[1]/header/ul/li[1]/a", driver);
        logger.info("Click on Radio_InternetModem");
        click_element("//*[@data-name='Internet Modem']", driver);
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
                    ".//*[@class='monthly-charges module']/table/tbody/tr["
                            + i + "]/td[1]", drive)) {
                reviewcartoptions++;
                logger.info(i + " yess");
            }
        }

        for (int i = 1; i <= reviewcartoptions; i++) {
            reviewcartname[i - 1] = return_text(
                    ".//*[@class='monthly-charges module']/table/tbody/tr["
                            + (i + 1) + "]/td[1]", drive);

            System.out
                    .println("name "
                            + return_text(
                                    ".//*[@class='monthly-charges module']/table/tbody/tr["
                                            + (i + 1) + "]/td[1]", drive));
            reviewcartcost[i - 1] = return_text(
                    ".//*[@class='monthly-charges module']/table/tbody/tr["
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
                                    ".//*[@class='monthly-charges module']/table/tbody/tr["
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
      
                logger.info("rpage 4.2");
            } else {
                logger.info("rpage 4.3");
      
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
                        "//*[@class='monthly-charges module']/table/tfoot/tr/td[2]",
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
                                    "//*[@class='monthly-charges module']/table/tfoot/tr/td[2]",
                                    drive) + " Expected: " + strtotal,
                    "The totals should be the same");
        }
    }

    public void Internet_ReviewOrder_ChkOneTimeCharges(String br) {
        System.out
                .println("Internet_ReviewOrder_ChkOneTimeCharges - Validating OneTime Charges : "
                        + mon_total_items);
        int Rev_OneTime_CartOptions = 0;

        for (int i = 1; i < mon_total_items + 2; i++) {
            if (isElementPresent(
                    ".//*[@class='service-details serviceDetails']/div/div[2]/table/tbody/tr["
                            + i + "]/td[1]", drive)) {
                Rev_OneTime_CartOptions++;
            }
        }
        logger.info("Rev_OneTime_CartOptions : "
                + Rev_OneTime_CartOptions);
        for (int i = 1; i <= Rev_OneTime_CartOptions; i++) {
            Rev_onetime_ChargesOption[i - 1] = return_text(
                    ".//*[@class='service-details serviceDetails']/div/div[2]/table/tbody/tr["
                            + i + "]/td[1]", drive);
            Rev_onetime_ChargesCost[i - 1] = return_text(
                    ".//*[@class='service-details serviceDetails']/div/div[2]/table/tbody/tr["
                            + i + "]/td[2]", drive);
            logger.info("Rev_onetime_ChargesCost------------>" +Rev_onetime_ChargesCost[i - 1]);
            if (Rev_onetime_ChargesCost[i - 1].length() > 10) {
                int index = Rev_onetime_ChargesCost[i - 1].indexOf(" ");
                logger.info("index: " + index);
                Rev_onetime_ChargesCost[i - 1] = Rev_onetime_ChargesCost[i - 1]
                        .substring(0, index);
            }
            System.out
                    .println("Review_One Time Details Name : "
                            + return_text(
                                    ".//*[@class='service-details serviceDetails']/div/div[2]/table/tbody/tr["
                                            + i + "]/td[1]", drive));
            System.out
                    .println("Review_One Time Details Cost : "
                            + return_text(
                                    ".//*[@class='service-details serviceDetails']/div/div[2]/table/tbody/tr["
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

    public void Internet_OrderSummary_ChkMonthlyCharges(String br) {
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
       
                logger.info("spage 4.2");
            } else {
                logger.info("spage 4.3");
    
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

    public void Internet_OrderSummary_ChkOneTimeCharges(String br) {
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
          
                logger.info("Summary One Time Charges - 4.2");
            } else {
                logger.info("Summary One Time Charges - 4.3");
          
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
            String ECKOptionName, double oneTimeCharges, WebDriver drive)
            throws InterruptedException {
        InstallationFees = 0.0;
        StoreAddress1 = "";
        StoreAddress2 = "";
        StoreAddress3 = "";
        Equip_text = "";
        ECKOptionSelected = "";
        ECKOptionSelected = ECKOptionName;

        logger.info("Review - ECKOptionSelected : " + ECKOptionSelected);
        logger.info("----------------code reached here------>>>>>1");

        if (ECKOptionName.equals("Store")) {
        	logger.info("----------------code reached here------>>>>>2");
            StoreAddress1 = (return_text(
                    "//form[@id='js-main-form']/div/div[2]/section/div/div/div/div[1]",
                    drive).replace("See Map", "")).trim();
            StoreAddress2 = (return_text(
                    "//form[@id='js-main-form']/div/div[2]/section/div/div/div/div[2]",
                    drive).replace("See Map", "")).trim();
            /*StoreAddress3 = (return_text(
                    "//form[@id='js-main-form']/div/div[2]/section/div/div/div/div[3]",
                    drive).replace("See Map", "")).trim();*/

            if (!StoreAddress1.equals(""))
                statusTracker(br,drive," ", "Address 1: ", StoreAddress1, " ");
            else
                statusTracker(br,drive,"Fail", "Address 1: ",
                        "Address 1 is Not Displayed", " ");

            if (!StoreAddress2.equals(""))
                statusTracker(br,drive," ", "Address 2: ", StoreAddress2, " ");
            else
                statusTracker(br,drive,"Fail", "Address 2: ",
                        "Address 2 is Not Displayed", " ");

            /*if (!StoreAddress3.equals(""))
                statusTracker(" ", "Address 3: ", StoreAddress3, " ");
            else
                statusTracker("Fail", "Address 3: ",
                        "Address 3 is Not Displayed", " ");*/

            // For the Store Pick option, the Value Free is verified.
            if ((return_text(".//*[@class='collapsible active js-expander-initialized']/header/label/span[1]",
                    drive).trim()).equals("Free"))
                statusTracker(br,drive,
                        "Pass",
                        "For the Store Pick there is NO processing fees",
                        return_text(
                                ".//*[@class='collapsible active js-expander-initialized']/header/label/span[1]",
                                drive)
                                + " is displayed.",
                        "No Processing Fee for the Store Pickup");
            else
                statusTracker(br,drive,
                        "Fail",
                        "For the Store Pick there is NO processing fees",
                        return_text(
                                ".//*[@class='collapsible active js-expander-initialized']/header/label/span[1]",
                                drive)
                                + " is displayed.",
                        "Processing Fee for the Store Pickup Must be always Free");

            InstallationFees = 0.0;

            // For the Store Pick option, the One Time Charges Text is verified.
            if ((return_text(".//*[@class='services-table']/tbody/tr[1]/td[1]",
                    drive).trim()).equals("Easy Connect Pick-up Fee"))
                statusTracker(br,drive,
                        "Pass",
                        "For the Store Pick option, the One Time Charges Text to be verified : Easy Connect Pick-up Fee",
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


            if(return_text(".//*[@class='collapsible active js-expander-initialized']/header/label/span[1]",
                         drive).trim().equals("Free"))
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


        }
        
        else if (ECKOptionName.equals("Mail")) {
        	logger.info("------------->>>>>>Code should come inside----->>>1");
            // Hard coded the text, as the contents will not modify
            if (return_text(
                    ".//*[@class='two-col']/div[1]/ul/li",
                    drive).equals("Internet Modem"))
            	
                statusTracker(br,drive,
                        "Pass",
                        "Mail Option Content Validation",
                        return_text(
                                ".//*[@class='two-col']/div[1]/ul/li",
                                drive),
                        " Internet Modem Text is correct under Mail option");
            
            else
                statusTracker(br,drive,
                        "Fail",
                        "Mail Option Content Validation",
                        return_text(
                                ".//*[@class='two-col']/div[1]/ul/li",
                                drive),
                        " Internet Modem Text is NOT correct under Mail option");
            logger.info("------------->>>>>>Code should come inside----->>>2");
            
           String InstallationFees_free = return_text(
                    ".//*[@id='section-mail']/header/label/span[1]", drive).trim();
          if(InstallationFees_free.equalsIgnoreCase("FREE"))
          {
        	  logger.info("Free : no need to check");
          }
          else
          {
            
           InstallationFees = Double.parseDouble((return_text(
                    ".//*[@id='section-mail']/header/label/span[1]", drive).replace("$", "")).trim());
            logger.info("Installation Fees : " + InstallationFees_free);

            // For the Mail option, the One Time Charges Text is verified.
            if ((return_text(".//*[@class='services-table']/tbody/tr[1]/td[1]",
                    drive).trim()).equals("Easy Connect Pick-up Fee"))
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
                                + " is not displayed.",
                        "One Time Charges Text is NOT as Expected");
/* NAN
            if (InstallationFees == Double.parseDouble(return_text(
                    ".//*[@class='services-table']/tbody/tr[1]/td[2]", drive)
                    .replace("$", "").trim()))
                statusTracker(
                        "Pass",
                        "For the Mail option, the One Time Charges charges to be verified",
                        return_text(
                                ".//*[@class='services-table']/tbody/tr[1]/td[2]",
                                drive)
                                + " is displayed.",
                        "One Time Charges VALUE is as Expected");
            else
                statusTracker(
                        "Fail",
                        "For the Mail option, the One Time Charges charges to be verified",
                        return_text(
                                ".//*[@class='services-table']/tbody/tr[1]/td[2]",
                                drive)
                                + " is displayed.",
                        "One Time Charges VALUE is NOT as Expected");
                        
NAN*/
        } 
        }
          else if (ECKOptionName.equals("TechInstall")) {
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

            select_Firstchoice_Date(br,DD_Value,drive);
            Thread.sleep(10000);
            select_Secondchoice_Date(br,DD_Value,drive);
            Thread.sleep(10000);
           
            
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

        if (ECKOptionSelected.equals("Store")) 
        {
            logger.info(return_text(".//*[@class='services-table']/tbody/tr[1]/td[1]", drive).trim());
           if ((return_text(".//*[@class='services-table']/tbody/tr[1]/td[1]",drive).trim()).equals("Easy Connect Pick-up Fee"))
       //	   if   ((return_text(".//*[@class='services-table']/tbody/tr[1]/td[1]",drive).trim()).equals("Easy Connect S & H Fee"))
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
                        "For the Store Pick option, the One Time Charges Text to be verified in the Order Summary Page",
                        return_text(
                                ".//*[@class='services-table']/tbody/tr[1]/td[1]",
                                drive)
                                + " is displayed.",
                        "One Time Charges Text is NOT as Expected");
            
           
           
      //      if (InstallationFees == Double.parseDouble(return_text( ".//*[@class='services-table']/tbody/tr[1]/td[2]", drive).replace("$", "").trim())
     //       ||	
          if  ((return_text(".//*[@class='services-table']/tbody/tr[1]/td[2]",drive).trim()).equals("Free"))
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

            /*if (StoreAddress3.equals(return_text(
                    ".//*[@class='three-col']/li[3]", drive).trim()))
                statusTracker(
                        "Pass",
                        "Both Addresses 3 in Review & Summary Order page should be same",
                        return_text(".//*[@class='three-col']/li[3]", drive),
                        "Both Addresses 3 in Review & Summary Order page are same");
            else
                statusTracker(
                        "Fail",
                        "Both Addresses 3 in Review & Summary Order page should be same",
                        return_text(".//*[@class='three-col']/li[3]", drive),
                        "Both Addresses 3 in Review & Summary Order page are NOT same");*/

            Equip_text = return_text(".//*[@class='rtf']/ul/li", drive).trim();
        } else if (ECKOptionSelected.equals("Mail")) {
            Equip_text = return_text(".//*[@class='col rtf']/ul/li", drive)
                    .trim();
            Thread.sleep(3000);
            
        } else if (ECKOptionSelected.equals("TechInstall")) {
            if ((return_text(
                    ".//*[@class='paragraphMerge installationLOB1']/p/strong[1]",
                    drive).trim()).equals("Internet")
                    
              && (return_text(".//*[@class='paragraphMerge installationLOB1']/p/strong[2]",
                            drive).trim()).equals("Installation Preferences:"))
            
           {
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
        	
            if (Equip_text.equals("Internet Modem Easy Connect Kit")
            	|| (Equip_text.equals("Internet Modem")))
            	
                statusTracker(br,drive,"Pass", "Order Summary Page - "
                        + ECKOptionSelected + " Option Content Validation",
                        Equip_text,
                        " Internet Equipment Text is correct under "
                                + ECKOptionSelected + " option");
            else
                statusTracker(br,drive,"Fail", "Order Summary Page - "
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
        //Expected_ServiceAddress = (Cust_Name + " " + Cust_ServiceAddress.replace("Service Address: ", "")).trim();
        Expected_ServiceAddress =Cust_ServiceAddress;
        Actual_ServiceAddress = return_text(".//*[@class='location']", drive).trim();

        logger.info("Expected_ServiceAddress : "
                + Expected_ServiceAddress);
        logger.info("Actual_ServiceAddress : " + Actual_ServiceAddress);

        if (Expected_ServiceAddress.equalsIgnoreCase(Actual_ServiceAddress))
            statusTracker(br,drive,"Pass",
                    "Order Summary Page - Validating Service Address",
                    Actual_ServiceAddress,
                    "Service Address is same as the Customer Details tagged to the account");
        else
            statusTracker(br,drive,"Fail",
                    "Order Summary Page - Validating Service Address",
                    Actual_ServiceAddress,
                    "Service Address is NOT same as the Customer Details tagged to the account");

        OrderSummary_ChkBrowserBackButton(br, drive);
        Thread.sleep(15000);

        // Selecting the check box for the Terms & Conditions
        logger.info("befor the click");
        click_element(".//*[@name='order-choose-TWC']", drive);
        logger.info("Checkbox clicked....");
    }

    
    public void Internet_Capture_ReviewOrder_UponChangeinECK(WebDriver drive) {
        logger.info("Array Output before : 1 :");

        for (int i = 0; i < Rev_onetime_ChargesOption.length; i++) {
            System.out.print(Rev_onetime_ChargesOption[i] + ", ");
        }
        logger.info("Array Output before : 2 : ");
        for (int i = 0; i < Rev_onetime_ChargesCost.length; i++) {
            System.out.print(Rev_onetime_ChargesCost[i] + ", ");
        }

        System.out
                .println("Internet_ReviewOrder_ChkOneTimeCharges - Validating OneTime Charges : "
                        + mon_total_items
                        + " - Option Selected : "
                        + ECKOptionSelected);
        int Rev_OneTime_CartOptions = 0;

        for (int i = 1; i < mon_total_items + 2; i++) {
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
        	click_element(".//*[@name='customize_tv']", drive);
            statusTracker(br,drive,"Pass",
                    "TV Equipment Select Checkbox should be displayed",
                    "TV Equipment Select Checkbox is displayed",
                    "TV Equipment Select Checkbox should be displayed");
        } else
            statusTracker(br,drive,"Fail",
                    "TV Equipment Select Checkbox should be displayed",
                    "TV Equipment Select Checkbox is NOT displayed",
                    "TV Equipment Select Checkbox should be displayed");
    }

    public void Internet_Equipment_Click(String br,WebDriver drive) {
        if (Isavailable(".//*[@name='customize_inet']", drive)) {
            drive.findElement(By.xpath(".//*[@name='customize_inet']")).click();
            statusTracker(br,drive,"Pass",
                    "Internet Equipment Select Checkbox should be displayed",
                    "Internet Equipment Select Checkbox is displayed",
                    "Internet Equipment Select Checkbox should be displayed");
        } else
            statusTracker(br,drive,"Fail",
                    "Internet Equipment Select Checkbox should be displayed",
                    "Internet Equipment Select Checkbox is NOT displayed",
                    "Internet Equipment Select Checkbox should be displayed");
    }

    public void Customization_TV_OpenChannel() {
        drive.findElement(
                By.xpath(".//*[@class='tv-customize-accordion']/div[2]/header/ul/li[1]/a"))
                .click();
    }

    public void config_page_Cart_result_updater(String br,WebDriver driver)
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
            statusTracker(br,driver," ", "cart details", "eqipment name is: "
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
                        By.xpath("//html/body/section/div[2]/div[2]/div/div/div/div/div[2]/section/div/table/tbody/tr/td[2]"))
                .isDisplayed()) {
            if (equipandtotalstring
                    .equals(driver
                            .findElement(
                                    By.xpath("//html/body/section/div[2]/div[2]/div/div/div/div/div[2]/section/div/table/tbody/tr/td[2]"))
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
                                    By.xpath("//html/body/section/div[2]/div[2]/div/div/div/div/div/div[2]/section/div/table/tbody/tr/td[2]"))
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
                                        By.xpath("//html/body/section/div[2]/div[2]/div/div/div/div/div[2]/section/div/table/tbody/tr/td[2]"))
                                        .getText() + " Expected: "
                                + equipandtotalstring,
                        "The items added to the cart does not add up to the total");
            }
        }

        Thread.sleep(4000);

    }
/*
    public void config_page_Cart_result_updater_1(WebDriver driver)
            throws InterruptedException {
        logger.info("Manju function is called");
        int jk;
        logger.info("line 1");
        // String itemname[]=new String[15];
        logger.info("line 2");

        logger.info("line 3");
        List<WebElement> myli4 = driver
                .findElements(By
                        .xpath("//*[@id='content']/div[3]/div[2]/div/div[1]/div/div/div[2]/section/div[1]/div/section/div/table/tbody/tr"));
        logger.info("line 4");
        carttotal = myli4.size();
        logger.info("line 5");
        logger.info("cartaotl is " + carttotal);
        for (jk = 0; jk < carttotal; jk++) {

            itemname[jk] = driver
                    .findElement(
                            By.xpath("//*[@id='content']/div[3]/div[2]/div/div[1]/div/div/div[2]/section/div[1]/div/section/div/table/tbody/tr["
                                    + (jk + 1) + "]/td[1]")).getText();
            itemcost[jk] = driver
                    .findElement(
                            By.xpath("//*[@id='content']/div[3]/div[2]/div/div[1]/div/div/div[2]/section/div[1]/div/section/div/table/tbody/tr["
                                    + (jk + 1) + "]/td[2]")).getText();
            logger.info(" eqipment cost is:" + itemcost[jk]);
            logger.info(" eqipment name is:" + itemname[jk]);
            statusTracker(" ", "cart details", "eqipment name is: "
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
                        By.xpath("//*[@id='content']/div[3]/div[2]/div/div[1]/div/div/div[2]/section/div[1]/table/tbody/tr/td[2]"))
                .isDisplayed()) {
            if (equipandtotalstring
                    .equals(driver
                            .findElement(
                                    By.xpath("//*[@id='content']/div[3]/div[2]/div/div[1]/div/div/div[2]/section/div[1]/table/tbody/tr/td[2]"))
                            .getText())) {
                statusTracker(
                        "Pass",
                        "Verify if the Equipment added/removed to the cart adds up to the total",
                        "The equipment added to the cart adds up to the total",
                        "The items added to the cart  total");
            } else {
                statusTracker(
                        "Fail",
                        "Verify if the items added/removed to the cart adds up to the total",
                        "The items added to the cart does not add up to the total. Actual: "
                                + driver.findElement(
                                        By.xpath("//html/body/section/div[2]/div[2]/div/div/div/div/div/div[2]/section/div/table/tbody/tr/td[2]"))
                                        .getText() + " Expected: "
                                + equipandtotalstring,
                        "The items added to the cart does not add up to the total");
            }
        }
        Thread.sleep(4000);
    }
*/

    
    
    //Rj
    
    public void config_page_Cart_result_updater_1(String br,WebDriver driver)
            throws InterruptedException {
        int jk;

//    List<WebElement> myli4 = driver.findElements(By.xpath("//*[@id='content']/div[3]/div[2]/div/div[1]/div/div/div[2]/section/div[1]/div/section/div/table/tbody/tr"));
    List<WebElement> myli4 = driver.findElements(By.xpath(".//*[@class='charges']/div/section/div/table/tbody/tr"));
        carttotal = myli4.size();
        logger.info("cartaotl is " + carttotal);
        for (jk = 0; jk < carttotal; jk++) {
                                            
                                          
itemname[jk] = driver.findElement(By.xpath(".//*[@class='charges']/div/section/div/table/tbody/tr["
        + (jk + 1) + "]/td[1]")).getText();
                                                                
itemcost[jk] = driver.findElement(By.xpath(".//*[@class='charges']/div/section/div/table/tbody/tr["
                                    + (jk + 1) + "]/td[2]")).getText();
            logger.info(" eqipment cost is:" + itemcost[jk]);
            logger.info(" eqipment name is:" + itemname[jk]);
            statusTracker(br,driver," ", "cart details", "eqipment name is: "
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

        if (driver
                .findElement(      
                        By.xpath(".//*[@class='services new-services-cart-module']/section/div[1]/table/tbody/tr/td[2]"))
                .isDisplayed()) {
            if (equipandtotalstring
                    .equals(driver
                            .findElement(
                                    By.xpath(".//*[@class='services new-services-cart-module']/section/div[1]/table/tbody/tr/td[2]"))
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
                                        By.xpath(".//*[@class='services new-services-cart-module']/section/div[1]/table/tbody/tr/td[2]"))
                                        .getText() + " Expected: "
                                + equipandtotalstring,
                        "The items added to the cart does not add up to the total");
            }
        }
        Thread.sleep(4000);
    }



public void page_Cart_One_Time_charge_updater_1(String br,WebDriver driver)
            throws InterruptedException {
        
    //    int mon_total_items = return_size(".//*[@id='content']/div[3]/div[2]/div/div[1]/div/div/div[2]/section/div[2]/section/table/tbody/tr",driver);
        
        int mon_total_items = return_size(".//*[@id='content']/div[3]/div[2]/div/div[1]/div/div/div/div[2]/section/div[2]/section/table/tbody/tr",driver);
        
        
        logger.info("mon_total_items : " + mon_total_items);

        for (int i = 1; i <= mon_total_items; i++) {
                                   
        itemname_mon[i] = return_text("//*[@id='content']/div[3]/div[2]/div/div[1]/div/div/div/div[2]/section/div[2]/section/table/tbody/tr["
                            + i + "]/td[1]", driver);
        
                                  
        itemcost_mon[i] = return_text("//*[@id='content']/div[3]/div[2]/div/div[1]/div/div/div/div[2]/section/div[2]/section/table/tbody/tr["
                            + i + "]/td[2]", driver);
        
            if ((itemcost_mon[i]).trim().equals("Free")||(itemcost_mon[i]).trim().equals("Included"))
            {
                
                itemcost_mon[i]="0";
            }
            logger.info(" Service cost is:" + itemcost_mon[i]);
            logger.info(" Serivce name is:" + itemname_mon[i]);
            statusTracker(br,driver," ", "cart details", "Service name is: "
                    + itemname_mon[i] + " and Service cost is: "
                    + itemcost_mon[i],
                    "selected service should be updated in one time charge section");
        }
        
        
        mon_total = return_text(".//*[@class='services new-services-cart-module']/section/table/tbody/tr/td[2]",driver);
        statusTracker(br,driver," ", "cart details", "Monthly one time charges is "
                + mon_total, "one time charge should be updated in cart");
    }



//EOC Rj
    
    
    
    
    
    
    
    
/*    
    public void config_page_Cart_result_updater_1(WebDriver driver)
            throws InterruptedException {
        Thread.sleep(5000);
        logger.info("Manju function is called");
        int jk;
        logger.info("line 1");
        // String itemname[]=new String[15];
        logger.info("line 2");

        logger.info("line 3");
        List<WebElement> myli4 = driver
                .findElements(By
                        .xpath("//*[@id='content']/div[3]/div[2]/div/div[1]/div/div/div[2]/section/div[1]/div/section/div/table/tbody/tr"));
        logger.info("line 4");
        carttotal = myli4.size();
        logger.info("line 5");
        logger.info("cartaotl is " + carttotal);
        for (jk = 0; jk < carttotal; jk++) {

            itemname[jk] = driver
                    .findElement(
                            By.xpath("//*[@id='content']/div[3]/div[2]/div/div[1]/div/div/div[2]/section/div[1]/div/section/div/table/tbody/tr["
                                    + (jk + 1) + "]/td[1]")).getText();
            itemcost[jk] = driver
                    .findElement(
                            By.xpath("//*[@id='content']/div[3]/div[2]/div/div[1]/div/div/div[2]/section/div[1]/div/section/div/table/tbody/tr["
                                    + (jk + 1) + "]/td[2]")).getText();
            logger.info(" eqipment cost is:" + itemcost[jk]);
            logger.info(" eqipment name is:" + itemname[jk]);
            statusTracker(" ", "cart details", "eqipment name is: "
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
                        By.xpath("//*[@id='content']/div[3]/div[2]/div/div[1]/div/div/div[2]/section/div[1]/table/tbody/tr/td[2]"))
                .isDisplayed()) {
            if (equipandtotalstring
                    .equals(driver
                            .findElement(
                                    By.xpath("//*[@id='content']/div[3]/div[2]/div/div[1]/div/div/div[2]/section/div[1]/table/tbody/tr/td[2]"))
                            .getText())) {
                statusTracker(
                        "Pass",
                        "Verify if the Equipment added/removed to the cart adds up to the total",
                        "The equipment added to the cart adds up to the total",
                        "The items added to the cart  total");
            } else {
                statusTracker(
                        "Fail",
                        "Verify if the items added/removed to the cart adds up to the total",
                        "The items added to the cart does not add up to the total. Actual: "
                                + driver.findElement(
                                        By.xpath("//html/body/section/div[2]/div[2]/div/div/div/div/div/div[2]/section/div/table/tbody/tr/td[2]"))
                                        .getText() + " Expected: "
                                + equipandtotalstring,
                        "The items added to the cart does not add up to the total");
            }
        }
        Thread.sleep(4000);
    }


    public void page_Cart_One_Time_charge_updater_1(WebDriver driver)
            throws InterruptedException {
        Thread.sleep(4000);
        int mon_total_items = return_size(
                ".//*[@id='content']/div[3]/div[2]/div/div[1]/div/div/div[2]/section/div[2]/section/table/tbody/tr",
                driver);
        logger.info("mon_total_items : " + mon_total_items);

        for (int i = 1; i <= mon_total_items; i++) {
            itemname_mon[i] = return_text(
                    ".//*[@id='content']/div[3]/div[2]/div/div[1]/div/div/div[2]/section/div[2]/section/table/tbody/tr["
                            + i + "]/td[1]", driver);
            itemcost_mon[i] = return_text(
                    ".//*[@id='content']/div[3]/div[2]/div/div[1]/div/div/div[2]/section/div[2]/section/table/tbody/tr["
                            + i + "]/td[2]", driver);
            logger.info(" Service cost is:" + itemcost_mon[i]);
            logger.info(" Serivce name is:" + itemname_mon[i]);
            statusTracker(" ", "cart details", "Service name is: "
                    + itemname_mon[i] + " and Service cost is: "
                    + itemcost_mon[i],
                    "selected service should be updated in one time charge section");
        }
        mon_total = return_text(
                "//*[@id='content']/div[3]/div[2]/div/div[1]/div/div/div[2]/section/table/tbody/tr/td[2]",
                driver);
        statusTracker(" ", "cart details", "Monthly one time charges is "
                + mon_total, "one time charge should be updated in cart");
    }
*/    
    
    

    public void page_Cart_One_Time_charge_updater_ValidateSportsChannel(String br,
            WebDriver driver) throws InterruptedException {
        int mon_total_items = return_size(
                ".//*[@id='content']/div[3]/div[2]/div/div[1]/div/div/div[2]/section/div[2]/section/table/tbody/tr",
                driver);
        logger.info("mon_total_items : " + mon_total_items);

        for (int i = 1; i <= mon_total_items; i++) {
            itemname_mon[i - 1] = return_text(
                    ".//*[@id='content']/div[3]/div[2]/div/div[1]/div/div/div[2]/section/div[2]/section/table/tbody/tr["
                            + i + "]/td[1]", driver);
            itemcost_mon[i - 1] = return_text(
                    ".//*[@id='content']/div[3]/div[2]/div/div[1]/div/div/div[2]/section/div[2]/section/table/tbody/tr["
                            + i + "]/td[2]", driver);
            logger.info(" Service cost is:" + itemcost_mon[i - 1]);
            logger.info(" Serivce name is:" + itemname_mon[i - 1]);
            statusTracker(br,driver," ", "cart details", "Service name is: "
                    + itemname_mon[i - 1] + " and Service cost is: "
                    + itemcost_mon[i - 1],
                    "selected service should be updated in one time charge section");
        }
        mon_total = return_text(
                "//*[@id='content']/div[3]/div[2]/div/div[1]/div/div/div[2]/section/table/tbody/tr/td[2]",
                driver);
        statusTracker(br,driver," ", "cart details", "Monthly one time charges is "
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
            statusTracker(br,driver," ", "cart details", "Service name is: "
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

                click_element(".//*[@id='1-3CEN9-1-2AW3-1']/td[5]/a", drive);
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
            logger.info("{}",index_start);

            int index_end = index_start + 5;
            logger.info("{}",index_end);
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

        statusTracker(br,drive," ",
                "Adding one more Premium Channel - Showtime Unlimited", " ",
                " ");

        // Showtime Unlimited Channel
        if (Isavailable(".//*[@id='1-3CEN9-1-2AWP-3']/td[1]/input", drive)) {
            statusTracker(br,drive,
                    "Pass",
                    "Under the Premium Channel the Showtime Unlimited is available for the selection",
                    "Showtime Unlimited Channel must be available",
                    "Showtime Unlimited Channel is displayed");
            click_element(".//*[@id='1-3CEN9-1-2AWP-3']/td[1]/input", drive);
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

                click_element(".//*[@id='1-3CEN9-1-2AXB-4']/td[5]/a", drive);
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
            logger.info("{}",index_start);

            int index_end = index_start + 5;
            logger.info("{}",index_end);
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

        statusTracker(br,drive," ",
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
            logger.info("{}",index_start);

            int index_end = index_start + 5;
            logger.info("{}",index_end);
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

    public void Validation_CurrentService_Vs_Channels(String br,WebDriver drive)
            throws InterruptedException {
        logger.info("Validation_CurrentService_Vs_Channels");

        String[] Current_Service_Details = new String[6];
        click_element(".//*[@id='content']/div[3]/div[2]/div/div[1]/div/div/div[1]/header/ul/li[2]/a", drive);
        Thread.sleep(1000);
        int li_cur_size = return_size(
                ".//*[@id='content']/div[3]/div[2]/div/div[1]/div/div/div[1]/section/div[1]/section/div/ul/li",
                drive);
        logger.info("# of current service present : " + li_cur_size);
        click_element(".//*[@id='content']/div[3]/div[2]/div/div[1]/div/div/div[1]/section/div[1]/header/ul/li[1]/a", drive);
        Thread.sleep(1000);
        for (int i = 1; i < li_cur_size; i++) {
            Current_Service_Details[i - 1] = return_text(
                    "//*[@class='content-wrap']/ul/li[" + (i + 1) + "]", drive);
            logger.info("Values : " + i + " - "
                    + Current_Service_Details[i - 1]);
           /* logger.info(return_text(
                    ".//*[@id='1-3CEN9-1-2AWE-2']/td[4]", drive).subSequence(
                    0,
                    (return_text(".//*[@id='1-3CEN9-1-2AWE-2']/td[4]", drive)
                            .trim().length() - 1)));*/
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

    public void Customization_TV_addAdultChannels(String br,WebDriver drive) throws InterruptedException {
        logger.info("Adult Channels");
        Thread.sleep(2000);
        logger.info("Adult one : "
                + Isavailable(
                        ".//*[@class='tab-nav-wrap mobile-hidden']/ul/li[5]/a",
                        drive));
        Thread.sleep(2000);
        click_element(".//*[@class='tab-nav-wrap mobile-hidden']/ul/li[5]/a", drive);
        Thread.sleep(5000);

        if (return_text(
                ".//*[@class='adultAlaCartChannels collapsible-channels']/div/h4",
                drive).trim().equals("Adult Channels"))
            statusTracker(br,drive,"Pass", "Verify the Adult Channels section",
                    "Adult Channels tab is displayed",
                    "Adult Channels tab Should be displayed");
        else
            statusTracker(br,drive,"Fail", "Verify the Adult Channels section",
                    "Adult Channels tab is NOT displayed",
                    "Adult Channels tab Should be displayed");

        // Hustler Channel
        if (Isavailable(".//*[@id='1-3R1FP-1-3R141-1']/td[1]/input", drive)) {
            statusTracker(br,drive,
                    "Pass",
                    "Under the Adult Channel the Hustler Channel is available for the selection",
                    "Hustler Channel must be available",
                    "Hustler Channel is displayed");
            click_element(".//*[@id='1-3R1FP-1-3R141-1']/td[1]/input", drive);
            Thread.sleep(5000);

            if (Isavailable(".//*[@id='1-3R1FP-1-3R141-1']/td[5]/a", drive)) {
            	click_element(".//*[@id='1-3R1FP-1-3R141-1']/td[5]/a", drive);
                statusTracker(br,drive,
                        "Pass",
                        "Under the Adult Channel the Hustler Channel, the long description is able to expand",
                        "Hustler Channel Description must be displayed",
                        "Hustler Channel Description is displayed");
                Thread.sleep(3000);

                click_element(".//*[@id='1-3R1FP-1-3R141-1']/td[5]/a", drive);
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
            logger.info("{}",index_start);

            int index_end = index_start + 5;
            logger.info("{}",index_end);
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

        statusTracker(br,drive," ", "Adding one more Adult Channel - Penthouse", " ",
                " ");

        // Penthouse Channel
        if (Isavailable(".//*[@id='1-3R1FP-1-3R14W-2']/td[1]/input", drive)) {
            statusTracker(br,drive,
                    "Pass",
                    "Under the Adult Channel the Penthouse Channel is available for the selection",
                    "Penthouse Channel must be available",
                    "Penthouse Channel is displayed");
            click_element(".//*[@id='1-3R1FP-1-3R14W-2']/td[1]/input", drive);
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

                click_element(".//*[@id='1-3R1FP-1-3R14W-2']/td[5]/a", drive);
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
            logger.info("{}",index_start);

            int index_end = index_start + 5;
            logger.info("{}",index_end);
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

        statusTracker(br,drive," ", "Removing the Added Adult Channel - Penthouse", " ",
                " ");

        // Penthouse Channel
        if (Isavailable(".//*[@id='1-3R1FP-1-3R14W-2']/td[1]/input", drive)) {
            statusTracker(br,drive,
                    "Pass",
                    "Under the Adult Channel the Penthouse is available for the De-selection",
                    "Penthouse Channel must be available",
                    "Penthouse Channel is displayed");
            click_element(".//*[@id='1-3R1FP-1-3R14W-2']/td[1]/input", drive);
            Thread.sleep(2000);

            String price = drive.findElement(
                    By.xpath(".//*[@id='1-3R1FP-1-3R14W-2']/td[6]/div"))
                    .getText();
            int index_start = price.indexOf("$");
            logger.info("{}",index_start);

            int index_end = index_start + 5;
            logger.info("{}",index_end);
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

    public void Customization_TV_addInternationalPackages(String br,WebDriver drive)
            throws InterruptedException {
        logger.info("Internet Packages");
        Thread.sleep(2000);
        logger.info("Int Packages one : "
                + Isavailable(
                        ".//*[@class='tab-nav-wrap mobile-hidden']/ul/li[4]/a",
                        drive));
        Thread.sleep(2000);
        click_element(".//*[@class='tab-nav-wrap mobile-hidden']/ul/li[4]/a", drive);
        Thread.sleep(5000);

        if (return_text(".//*[@class='collapsible-channels alaCarte']/div/h4",
                drive).trim().equals("International Channels"))
            statusTracker(br,drive,"Pass", "Verify the International Channels section",
                    "International Channels tab is displayed",
                    "International Channels tab Should be displayed");
        else
            statusTracker(br,drive,"Fail", "Verify the International Channels section",
                    "International Channels tab is NOT displayed",
                    "International Channels tab Should be displayed");

        // Filipino Pass Plus Package
        if (Isavailable(".//*[@id='1-3H4H2-1-1YJMZ-1']/td[1]/input", drive)) {
            statusTracker(br,drive,
                    "Pass",
                    "Under the International Package the Filipino Pass Plus Package is available for the selection",
                    "Filipino Pass Plus Package must be available",
                    "Filipino Pass Plus Package is displayed");
            click_element(".//*[@id='1-3H4H2-1-1YJMZ-1']/td[1]/input", drive);
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

                click_element(".//*[@id='1-3H4H2-1-1YJMZ-1']/td[5]/a", drive);
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
            logger.info("{}",index_start);

            int index_end = index_start + 5;
            logger.info("{}",index_end);
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

        statusTracker(br,drive," ",
                "Adding one more International Packages - Hindi Passport", " ",
                " ");

        // Hindi Passport Package
        if (Isavailable(".//*[@id='1-3H4H2-1-1YJP3-2']/td[1]/input", drive)) {
            statusTracker(br,drive,
                    "Pass",
                    "Under the International Package the Hindi Passport Package is available for the selection",
                    "Hindi Passport Package must be available",
                    "Hindi Passport Package is displayed");
            click_element(".//*[@id='1-3H4H2-1-1YJP3-2']/td[1]/input", drive);
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

                click_element(".//*[@id='1-3H4H2-1-1YJP3-2']/td[5]/a", drive);
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
            logger.info("{}",index_start);

            int index_end = index_start + 5;
            logger.info("{}",index_end);
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

        statusTracker(br,drive," ",
                "Removing the Added International Package - Hindi Passport",
                " ", " ");

        // Hindi Passport Package
        if (Isavailable(".//*[@id='1-3H4H2-1-1YJP3-2']/td[1]/input", drive)) {
            statusTracker(br,drive,
                    "Pass",
                    "Under the International Package the Hindi Passport is available for the De-selection",
                    "Hindi Passport Package must be available",
                    "Hindi Passport Package is displayed");
            click_element(".//*[@id='1-3H4H2-1-1YJP3-2']/td[1]/input", drive);
            Thread.sleep(2000);

            String price = drive.findElement(
                    By.xpath(".//*[@id='1-3H4H2-1-1YJP3-2']/td[6]/div"))
                    .getText();
            int index_start = price.indexOf("$");
            logger.info("{}",index_start);

            int index_end = index_start + 5;
            logger.info("{}",index_end);
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

    public void Customization_TV_addInternationalChannels(String br,WebDriver drive)
            throws InterruptedException {
        logger.info("International Channels");
        Thread.sleep(2000);
        logger.info("Int Channels one : "
                + Isavailable(
                        ".//*[@class='tab-nav-wrap mobile-hidden']/ul/li[4]/a",
                        drive));
        Thread.sleep(2000);
        click_element(".//*[@class='tab-nav-wrap mobile-hidden']/ul/li[4]/a", drive);
        Thread.sleep(5000);

        if (return_text(".//*[@class='collapsible-channels alaCarte']/div/h4",
                drive).trim().equals("International Channels"))
            statusTracker(br,drive,"Pass", "Verify the International Channels section",
                    "International Channels tab is displayed",
                    "International Channels tab Should be displayed");
        else
            statusTracker(br,drive,"Fail", "Verify the International Channels section",
                    "International Channels tab is NOT displayed",
                    "International Channels tab Should be displayed");

        // DW Channel
        if (Isavailable(".//*[@id='1-3H4H2-1-2B7G-3']/td[1]/input", drive)) {
            statusTracker(br,drive,
                    "Pass",
                    "Under the International Channel the DW Channel is available for the selection",
                    "DW Channel must be available", "DW Channel is displayed");
            click_element(".//*[@id='1-3H4H2-1-2B7G-3']/td[1]/input", drive);
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

                click_element(".//*[@id='1-3H4H2-1-2B7G-3']/td[5]/a", drive);
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
            logger.info("{}",index_start);

            int index_end = index_start + 5;
            logger.info("{}",index_end);
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

        statusTracker(br,drive," ",
                "Adding one more International Channels - TV5 Monde", " ", " ");

        // TV5 Monde Channel
        if (Isavailable(".//*[@id='1-3H4H2-1-2B8O-4']/td[1]/input", drive)) {
            statusTracker(br,drive,
                    "Pass",
                    "Under the International Channel the TV5 Monde Channel is available for the selection",
                    "TV5 Monde Channel must be available",
                    "TV5 Monde Channel is displayed");
            click_element(".//*[@id='1-3H4H2-1-2B8O-4']/td[1]/input", drive);
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

                click_element(".//*[@id='1-3H4H2-1-2B8O-4']/td[5]/a", drive);
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
            logger.info("{}",index_start);

            int index_end = index_start + 5;
            logger.info("{}",index_end);
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

        statusTracker(br,drive," ",
                "Removing the Added International Channel - TV5 Monde", " ",
                " ");

        // TV5 Monde Channel
        if (Isavailable(".//*[@id='1-3H4H2-1-2B8O-4']/td[1]/input", drive)) {
            statusTracker(br,drive,
                    "Pass",
                    "Under the International Channel the TV5 Monde is available for the De-selection",
                    "TV5 Monde Channel must be available",
                    "TV5 Monde Channel is displayed");
            click_element(".//*[@id='1-3H4H2-1-2B8O-4']/td[1]/input", drive);
            Thread.sleep(2000);

            String price = drive.findElement(
                    By.xpath(".//*[@id='1-3H4H2-1-2B8O-4']/td[6]/div"))
                    .getText();
            int index_start = price.indexOf("$");
            logger.info("{}",index_start);

            int index_end = index_start + 5;
            logger.info("{}",index_end);
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

    public void Customization_TV_addVarietyChannels(String br,WebDriver drive)
            throws InterruptedException {
        logger.info("Variety Channels");
        Thread.sleep(2000);
        logger.info("Variety Channels one : "
                + Isavailable(
                        ".//*[@class='tab-nav-wrap mobile-hidden']/ul/li[4]/a",
                        drive));
        Thread.sleep(2000);
        click_element(".//*[@class='tab-nav-wrap mobile-hidden']/ul/li[3]/a", drive);
        Thread.sleep(5000);

        if (return_text(
                ".//*[@class='collapsible-channels varietyChannels']/div/h4",
                drive).trim().equals("More Entertainment for Everyone"))
            statusTracker(br,drive,"Pass", "Verify the Variety Channels section",
                    "Variety Channels tab is displayed",
                    "Variety Channels tab Should be displayed");
        else
            statusTracker(br,drive,"Fail", "Verify the Variety Channels section",
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

                click_element(".//*[@id='1-3QU7U-1-2BHG-1']/td[5]/a", drive);
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
            logger.info("{}",index_start);

            int index_end = index_start + 5;
            logger.info("{}",index_end);
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

        statusTracker(br,drive," ", "Adding one more Variety Channels - TWC Movie Pass",
                " ", " ");

        // TWC Movie Pass Channel
        if (Isavailable(".//*[@id='1-3QU7U-1-3QU01-4']/td[1]/input", drive)) {
            statusTracker(br,drive,
                    "Pass",
                    "Under the Variety Channel the TWC Movie Pass Channel is available for the selection",
                    "TWC Movie Pass Channel must be available",
                    "TWC Movie Pass Channel is displayed");
            click_element(".//*[@id='1-3QU7U-1-3QU01-4']/td[1]/input", drive);
            Thread.sleep(5000);

            if (Isavailable(".//*[@id='1-3QU7U-1-3QU01-4']/td[5]/a", drive)) {
            	click_element(".//*[@id='1-3QU7U-1-3QU01-4']/td[5]/a", drive);
                statusTracker(br,drive,
                        "Pass",
                        "Under the Variety Channel the TWC Movie Pass Channel, the long description is able to expand",
                        "TWC Movie Pass Channel Description must be displayed",
                        "TWC Movie Pass Channel Description is displayed");
                Thread.sleep(3000);

                click_element(".//*[@id='1-3QU7U-1-3QU01-4']/td[5]/a", drive);
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
            logger.info("{}",index_start);

            int index_end = index_start + 5;
            logger.info("{}",index_end);
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

        statusTracker(br,drive," ",
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
            logger.info("{}",index_start);

            int index_end = index_start + 5;
            logger.info("{}",index_end);
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

    public void Customization_TV_addSportsChannels_OneTimePricing(String br,WebDriver drive) throws InterruptedException {
        logger.info("Sports Channels - OneTime");
        Thread.sleep(2000);
        logger.info("Sports Channels one : "
                + Isavailable(
                        ".//*[@class='tab-nav-wrap mobile-hidden']/ul/li[2]/a",
                        drive));
        Thread.sleep(2000);
        click_element(".//*[@class='tab-nav-wrap mobile-hidden']/ul/li[2]/a", drive);
        Thread.sleep(5000);

        if (return_text(".//*[@class='sports sports-channels']/div/h4[1]",
                drive).trim().equals("Seasonal Sports Packages"))
            statusTracker(br,drive,"Pass", "Verify the Sports Channels section",
                    "Sports Channels tab is displayed",
                    "Sports Channels tab Should be displayed");
        else
            statusTracker(br,drive,"Fail", "Verify the Sports Channels section",
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

                click_element(".//*[@class='sports js-table-expander-initialized']/tbody/tr[2]/td[6]/a", drive);
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

        statusTracker(br,drive," ", "Adding one more Sports Channels - NBA League Pass",
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

                click_element(".//*[@class='sports js-table-expander-initialized']/tbody/tr[4]/td[6]/a", drive);
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

        statusTracker(br,drive," ",
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
    
    public void Customization_TV_addSportsChannels_InstallmentPricing(String br,WebDriver drive) throws InterruptedException {
        logger.info("Sports Channels - Installment");
        Thread.sleep(2000);
        logger.info("Sports Channels one : "
                + Isavailable(
                        ".//*[@class='tab-nav-wrap mobile-hidden']/ul/li[2]/a",
                        drive));
        Thread.sleep(2000);
        click_element(".//*[@class='tab-nav-wrap mobile-hidden']/ul/li[2]/a", drive);
        Thread.sleep(5000);

        if (return_text(".//*[@class='sports sports-channels']/div/h4[1]",
                drive).trim().equals("Seasonal Sports Packages"))
            statusTracker(br,drive,"Pass", "Verify the Sports Channels section",
                    "Sports Channels tab is displayed",
                    "Sports Channels tab Should be displayed");
        else
            statusTracker(br,drive,"Fail", "Verify the Sports Channels section",
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
            click_element("//input[@data-name='MLS Direct Kick']", drive);
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

                click_element(".//*[@class='sports js-table-expander-initialized']/tbody/tr[2]/td[6]/a", drive);
                statusTracker(br,drive,
                        "Pass",
                        "Under the Sports Channel the MLS Direct Kick Channel, the long description is able to Collapse",
                        "MLS Direct Kick Channel Description must Collapsed",
                        "MLS Direct Kick Channel Description is collapsed");
                Thread.sleep(2000);
            }
            
            click_element(".//*[@id='1-2BNH2']", drive);
            Thread.sleep(2000);
            scrollToElement("//label[@for='1-2BNH2']",drive);
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

        statusTracker(br,drive," ", "Adding one more Sports Channels - NBA League Pass",
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

                click_element(".//*[@class='sports js-table-expander-initialized']/tbody/tr[4]/td[6]/a", drive);
                statusTracker(br,drive,
                        "Pass",
                        "Under the Sports Channel the NBA League Pass Channel, the long description is able to Collapse",
                        "NBA League Pass Channel Description must Collapsed",
                        "NBA League Pass Channel Description is collapsed");
                Thread.sleep(2000);
            }
            
            click_element(".//*[@id='1-2BNS2']", drive);
            Thread.sleep(2000);
            scrollToElement("//label[@for='1-2BNS2']",drive);
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

        statusTracker(br,drive," ",
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
            
            click_element(".//*[@id='1-2BNS2']", drive);
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


// Pacage funation started
///------------------ package phone function



public void click_PrivateListening_Package(WebDriver driver) throws InterruptedException
{
    Thread.sleep(9000);
    click_element("//*[@id='content']/div[3]/div[2]/div/div[2]/div/div[2]/div/div/div[1]/div/section/div/div[3]/header/ul/li[4]/label", driver);
    Thread.sleep(2000);
    click_element("//*[@id='content']/div[3]/div[2]/div/div[2]/div/div[2]/div/div/div[1]/div/section/div/div[3]/header/ul/li[4]/label", driver);
    //Thread.sleep(2000);
    click_element("//*[@id='1-29SM']", driver);
    Thread.sleep(9000);
    logger.info("shikha funcrion ended");
}


public void click_VoiceMail_Package(WebDriver driver) throws InterruptedException
{
    click_element("//*[@id='content']/div[2]/div[2]/div/div[2]/div/div[2]/div/div/div[1]/div/section/div/div[4]/header/ul/li[1]/a", driver);
    Thread.sleep(2000);
    click_element("//*[@id='content']/div[2]/div[2]/div/div[2]/div/div[2]/div/div/div[1]/div/section/div/div[4]/header/ul/li[1]/a", driver);
    Thread.sleep(2000);
    click_element("//*[@id='1-29SB']", driver);
}

public void click_GlobalPenny_Package(WebDriver driver)throws InterruptedException
{
    click_element(".//*[@id='content']/div[3]/div[2]/div/div[2]/div/div[2]/div/div/div[1]/div/section/div/div[6]/header/ul/li[4]/label", driver);
    Thread.sleep(2000);
    click_element(".//*[@id='content']/div[3]/div[2]/div/div[2]/div/div[2]/div/div/div[1]/div/section/div/div[6]/header/ul/li[4]/label", driver);
    Thread.sleep(2000);
    click_element("//*[@id='12-1BZU']", driver);
}

public void click_International_Package(WebDriver driver)throws InterruptedException
{
    click_element(".//*[@id='content']/div[3]/div[2]/div/div[2]/div/div[2]/div/div/div[1]/div/section/div/div[7]/header/ul/li[4]/label", driver);
    Thread.sleep(2000);
    click_element(".//*[@id='content']/div[3]/div[2]/div/div[2]/div/div[2]/div/div/div[1]/div/section/div/div[7]/header/ul/li[4]/label", driver);
    Thread.sleep(2000);
    click_element("//*[@id='1-29S0']", driver);
}




public void transfer_number_Package(String br,WebDriver driver) throws InterruptedException
    {
//Click Feature options      

        click_PrivateListening_Package(driver);
        Thread.sleep(8000);
        config_page_Cart_result_updater_Phone_Package(br,driver);
        page_Cart_One_Time_charge_updater_Package (br,driver);
        Thread.sleep(2000);
        
       //click_VoiceMail(driver);
        //Thread.sleep(2000);
        // config_page_Cart_result_updater_Phone_Package(driver);
        //page_Cart_One_Time_charge_updater (driver);
        Thread.sleep(2000);
        
        click_GlobalPenny_Package(driver);
        Thread.sleep(8000);
         config_page_Cart_result_updater_Phone_Package(br,driver);
          page_Cart_One_Time_charge_updater_Package (br,driver);
          Thread.sleep(3000);
        
        
        //click International plan option    
          //click_International_Package(driver);
          //Thread.sleep(2000);
          //config_page_Cart_result_updater_Phone_Package(driver);
         // page_Cart_One_Time_charge_updater_Package (driver);
          //Thread.sleep(3000);
          
        
        
        
      
//Compare Plan Page check          
          click_element("//*[@class='modal modalGeneric js-modal-initialized']", driver);
      logger.info("two");
      
      Thread.sleep(10000);
      scrollToElement("//*[@class='modal-title']",driver);
      String modal_title=driver.findElement(By.xpath("//*[@class='modal-title']")).getText();
      if(modal_title.equalsIgnoreCase("International Calling Rates"))
      {
          statusTracker(br,driver,"Pass", "Click on Compare Plan link", "Compare Plan link is clicked", "Compare plan link should be clicked");
          logger.info("tHREE"+ "");
      }
      else
      {
          statusTracker(br,driver,"Fail", "Click on Compare Plan link", "Compare Plan link is not clicked", "Compare plan link should be clicked"); 
      }
      scrollToElement("//*[@class='modal-button-close']",driver);
      driver.findElement(By.xpath("//*[@class='modal-button-close']")).click();
      Thread.sleep(5000);
      
      String Act_config=driver.findElement(By.xpath("//*[@class='text parbase sectionHeader twc-plain-text']")).getText();
      if(Act_config.equalsIgnoreCase("Select Optional Features & Calling Plans"))
      {
          statusTracker(br,driver,"Pass", "Click on close button of Compare Plan", "Compare Plan gets closed", "Compare plan should get closed");
      }
      else
      {
          statusTracker(br,driver,"Fail", "Click on close button of Compare Plan", "Compare Plan does not gets closed", "Compare plan should get closed"); 
      } 
      
      Thread.sleep(5000);
      

//Click Continue to next plan
      click_element("//*[@id='content']/div[3]/div[2]/div/div[2]/div/div[2]/div/div/div[1]/div/section/div/div[9]/a", driver);
      Thread.sleep(7000);
      if(driver.findElement(By.id("js-phoneNumber-new")).isDisplayed() && driver.findElement(By.id("js-phoneNumber-transfer")).isDisplayed())
      
                   {
                    Thread.sleep(2000);    
                 statusTracker(br,driver,"Pass", "Check for Add new number and transfer existing number options", "Both options are present", "BOth options should be present");
                   }
                else
                 {
                 statusTracker(br,driver,"Fail", "Check for Add new number and transfer existing number options", "Just one options is present", "Both options should be present");
                 }
      
      click_element("//*[@id='js-phoneNumber-transfer']", driver);
      Thread.sleep(5000);    
      if(driver.findElement(By.xpath("//*[@class='transfer-number general-form']")).isDisplayed())
                 {
                 statusTracker(br,driver,"Pass", "Transfer number general form gets displayed", "Transfer number general form is displayed", "Transfer number general form should be displayed");
                 }
                   else
                   { 
                 statusTracker(br,driver,"Fail", "Transfer number general form gets displayed", "Transfer number general form is not displayed", "Transfer number general form should be displayed");
                 }                   
            
      logger.info("started");
            
            
// for currentProvider
            
        Thread.sleep(2000);
        WebElement mywe_select_pro=driver.findElement(By.xpath("//*[@id='currentProvider']"));
        logger.info("first");
        mywe_select_pro.click();
        Thread.sleep(2000);
        logger.info("second");
        List<WebElement> my_li=mywe_select_pro.findElements(By.tagName("option"));
        //logger.info("my_li is "+my_li);
        int size_drop=my_li.size();
        
        //mywe_select_pro.sendKeys(my_li.get(2).getText());
        
        
        
        for ( int i=0; i<size_drop; i++)
        {
            if(my_li.get(i).getText().equals("CIMCO"))
            {
                my_li.get(i).sendKeys("CIMCO");    
              field_statustracker(br,"//*[@id='currentProvider']","Select Current Provider ","Current Provider is Selected", driver);
             break;
            }
            
        }

            Thread.sleep(4000);
            
              
// For current-provider-state
              
                            
              
               WebElement mywe_select_pro_1=driver.findElement(By.xpath("//*[@id='current-provider-state']"));
               
            logger.info("first");
            Thread.sleep(2000);
            mywe_select_pro_1.click();
            logger.info("second");
            Thread.sleep(2000);
            List<WebElement> my_li_1=mywe_select_pro_1.findElements(By.tagName("option"));
            
            int size_drop_1=my_li_1.size();
            for ( int i=0; i<size_drop_1; i++)
            {
                if(my_li_1.get(i).getText().equals("Hawaii"))                    
                {
                my_li_1.get(i).sendKeys("Hawaii");    
                 field_statustracker(br,"//*[@id='current-provider-state']","Select Current Provider State","Current Provider state is Selected", driver);
                break;
                }                        
            }
              
                            
            
            driver.findElement(By.xpath("//*[@id='phone-number']")).sendKeys("123-876-7678");
            Thread.sleep(2000);
               field_statustracker(br,"//*[@id='phone-number']","Enter Phone Number","Phone number is Entered", driver);
              Thread.sleep(2000);
              driver.findElement(By.id("account-number")).sendKeys("23456745");
              Thread.sleep(2000);
               field_statustracker(br,"//*[@id='account-number']","Enter Account Number","Account Number is Entered", driver);
              Thread.sleep(2000);
              driver.findElement(By.id("account-name")).sendKeys("Dani");
               field_statustracker(br,"//*[@id='account-name']","Account Name","Account Name is Entered",driver);
              Thread.sleep(2000);
              driver.findElement(By.id("security-code")).sendKeys("3433");
               field_statustracker(br,"//*[@id='security-code']","Enter Security Code","Security Code is Entered", driver);
              Thread.sleep(2000);
              driver.findElement(By.id("address")).sendKeys("4th cross");
               field_statustracker(br,"//*[@id='address']","Enter Address","Address is Entered", driver);
              Thread.sleep(2000);
              driver.findElement(By.id("apt-type")).sendKeys("#10");
               field_statustracker(br,"//*[@id='apt-type']","Enter apt type","Apt Type is Entered", driver);
              Thread.sleep(2000);
              driver.findElement(By.id("city")).sendKeys("nyc");
               field_statustracker(br,"//*[@id='city']","Enter City","City is Entered", driver);
              Thread.sleep(2000);
              driver.findElement(By.id("zip-code")).sendKeys("23456");
               field_statustracker(br,"//*[@id='zip-code']","Enter Zip-Code","Zip Code is Entered", driver);                      
              Thread.sleep(4000);
              
            WebElement mywe_select_pro_2=driver.findElement(By.xpath("//*[@id='current-provider-state-billing']"));            
            mywe_select_pro_2.click();
            List<WebElement> my_li_2=mywe_select_pro_2.findElements(By.tagName("option"));
            
            int size_drop_2=my_li_2.size();
            
            for ( int i=0; i<size_drop_2; i++)
            {
                if(my_li_2.get(i).getText().equals("Alaska"))
                {
                my_li_2.get(i).sendKeys("Alaska");    
                //field_statustracker("//*[@id='current-provider-state-billing']","Select Current Provider Billing State","Billing provider state is Entered", driver);
                break;
                }
                
            }      
            
            logger.info("**********************************");
              
            Thread.sleep(1000);
              
            scrollToElementByCSSSelector("form > div.continue > a",driver);
              driver.findElement(By.cssSelector("form > div.continue > a")).click();    
              Thread.sleep(5000);
              logger.info("Continue clicked");
//enter first name              
              
              click_element("//*[@id='tpv-choose-TWC']", driver);
              
              Thread.sleep(5000);
              driver.findElement(By.xpath("//*[@id='full-name1']")).sendKeys("Wideband");
              //field_statustracker("//*[@id='full-name1']"," Enter Full Name","Full Name of user is Entered",driver);
              Thread.sleep(5000);
              
               WebElement my_select_birthmonth = driver.findElement(By.xpath("//*[@id='birth-month']"));            
               my_select_birthmonth.click();
             List<WebElement> my_li_bm=my_select_birthmonth.findElements(By.tagName("option"));
                
             int size_drop_bm = my_li_bm.size();
             logger.info("{}",size_drop_bm);
             for ( int i=0; i<size_drop_bm; i++)
                {
                    if(my_li_bm.get(i).getText().equals("June"))
                    {
                    my_li_bm.get(i).sendKeys("June");    
                    //field_statustracker("//*[@id='birth-month']","Select Month","Month is Selected", driver);
                    break;
                    }
                    
                }      
             Thread.sleep(2000);
              
              
                WebElement my_select_birthday = driver.findElement(By.xpath("//*[@id='birth-date']"));            
                  my_select_birthday.click();
                List<WebElement> my_li_bd=my_select_birthday.findElements(By.tagName("option"));
                    
                int size_drop_bd = my_li_bd.size();
                logger.info("{}",size_drop_bd);
                    
                for ( int i=0; i<size_drop_bd; i++)
                    {
                        if(my_li_bd.get(i).getText().equals("5"))
                        {
                        my_li_bd.get(i).sendKeys("5");
                        //field_statustracker("//*[@id='birth-date']","Birth date is selected","Birth Date is Entered", driver);
                        break;
                        }
                        
                    } 
                    Thread.sleep(2000);              
                    WebElement my_select_birthyear = driver.findElement(By.xpath("//*[@id='birth-year']"));            
                      my_select_birthyear.click();
                    List<WebElement> my_li_by=my_select_birthyear.findElements(By.tagName("option"));
                        
                    int size_drop_by = my_li_by.size();
                    logger.info("",size_drop_by);
                    for ( int i=0; i<size_drop_by; i++)
                      {
                        if(my_li_by.get(i).getText().equals("1950"))
                        {
                        my_li_by.get(i).sendKeys("1950");
                        //field_statustracker("//*[@id='birth-year']","Select Year","Birth year is selected", driver);
                        break;
                        }
                            
                        } 
                        Thread.sleep(2000);
                        driver.findElement(By.xpath("//*[@id='full-name2']")).sendKeys("Wideband");
                        //field_statustracker("//*[@id='full-name2']","Enter Full Name","Full Name is Entered", driver);
                        
                        Thread.sleep(2000);
                        scrollToElementByCSSSelector("span.arrow",driver);
                        driver.findElement(By.cssSelector("span.arrow")).click(); 
                        logger.info("clicked continue button on config page");
                        
                        Thread.sleep(8000);
                        logger.info("review page");                    
              }

public void config_page_Cart_result_updater_TV_Package(String br,WebDriver driver) throws InterruptedException
{
    //Validation of status TV LOB    
         //click_element(".//*[@class='charges']//div[1]/header/ul/li[1]/a",driver);
        logger.info("Manju function is called");
           int jk;
           logger.info("line 1");
    // String itemname[]=new String[15];
           logger.info("line 2");

             logger.info("line 3");
           List<WebElement> myli4= driver.findElements(By.xpath("//*[@class='charges']/div[1]/section/div/table/tbody/tr/td[1]"));
           logger.info("line 4");
           carttotal=myli4.size();
           logger.info("line 5");
           logger.info("cartaotl is "+carttotal);
           for (jk=0;jk<carttotal;jk++)
           {

                  
                  itemname1[jk]=driver.findElement(By.xpath("//*[@class='charges']/div[1]/section/div/table/tbody/tr["+(jk+1)+"]/td[1]")).getText(); 
                  itemcost1[jk]=driver.findElement(By.xpath("//*[@class='charges']/div[1]/section/div/table/tbody/tr["+(jk+1)+"]/td[2]")).getText();
                  logger.info(" eqipment cost is:"+itemcost1[jk]);
                  logger.info(" eqipment name is:"+itemname1[jk]);
                  statusTracker(br,driver," ","cart details", "eqipment name is: "+itemname1[jk]+" and item cost is: "+itemcost1[jk],"selected eqipment should be added to cart");
                  if ((itemcost1[jk]).trim().equals("Free") || (itemcost1[jk]).trim().equals("Included") )
                  {
                        itemcost1[jk]="0";
                  }
                        
           }
           
           int equipandtotal=0;
               for(int m=0;m<carttotal;m++)
               {
                  
                  String temp=itemcost1[m].replaceAll("[^0-9]","");
                  equipandtotal+=Integer.parseInt(temp);
                  
               }
               
               String equipandtotalstring=String.valueOf(equipandtotal);
               if (!return_text(".//*[@class='charges']/div[1]/header/ul/li[3]",driver).equals("Included"))
               {
               equipandtotalstring=equipandtotalstring.substring(0,equipandtotalstring.length()-2)+"."+equipandtotalstring.substring(equipandtotalstring.length()-2);
               }
               equipandtotalstring="$"+equipandtotalstring;
               logger.info("equipandtotalstring is "+equipandtotalstring);
               
               
               if(driver.findElement(By.xpath(".//*[@class='charges']/div[1]/header/ul/li[3]")).isDisplayed())
               {
                   if (return_text(".//*[@class='charges']/div[1]/header/ul/li[3]",driver).equals("Included"))
                   {

                   if (equipandtotalstring.equals("$0"))
                   {
                       
                       statusTracker(br,driver,"Pass","Verify toatl price is displayed as incuded","The euipment added to the cart are updated and included in package","The items added to the cart  total"); 
                       
                   }
                   
                   }

                   if(equipandtotalstring.equals(driver.findElement(By.xpath("//*[@class='charges']/div[1]/header/ul/li[3]")).getText()))
                  {
                         statusTracker(br,driver,"Pass","Verify if the Eqipment added to the cart adds up to the total","The euipment added to the cart adds up to the total","The items added to the cart  total");
                  }
                  else
                  {
                         //statusTracker("Fail","Verify if the items added to the cart adds up to the total","The items added to the cart does not add up to the total. Actual: "+driver.findElement(By.xpath("//html/body/section/div[2]/div[2]/div/div/div/div/div/div[2]/section/div/table/tbody/tr/td[2]")).getText() +" Expected: "+equipandtotalstring,"The items added to the cart does not add up to the total");
                  }
               }

               Thread.sleep(4000);
               
               
               //validation of Interner LOB
               
               click_element(".//*[@class='charges']//div[2]/header/ul/li[1]/a",driver);
               
               List<WebElement> myli5= driver.findElements(By.xpath("//*[@class='charges']/div[2]/section/div/table/tbody/tr/td[1]"));
               logger.info("line 4");
               carttotal1=myli5.size();
               logger.info("line 5");
               logger.info("cartaotl1 is "+carttotal1);
               itemname2[jk]="";
               itemcost2[jk]="";
               for (jk=0;jk<carttotal1;jk++)
               {

                      
                      itemname2[jk]=driver.findElement(By.xpath("//*[@class='charges']/div[2]/section/div/table/tbody/tr["+(jk+1)+"]/td[1]")).getText(); 
                      itemcost2[jk]=driver.findElement(By.xpath("//*[@class='charges']/div[2]/section/div/table/tbody/tr["+(jk+1)+"]/td[2]")).getText();
                      logger.info(" eqipment cost is:"+itemcost2[jk]);
                      logger.info(" eqipment name is:"+itemname2[jk]);
                      statusTracker(br,driver," ","cart details", "eqipment name is: "+itemname2[jk]+" and item cost is: "+itemcost2[jk],"selected eqipment should be added to cart");
                      if ((itemcost2[jk]).trim().equals("Free") || (itemcost2[jk]).trim().equals("Included") )
                      {
                            itemcost2[jk]="0";
                      }
                            
               }
               
               int equipandtotal1=0;
                   for(int m=0;m<carttotal1;m++)
                   {
                      
                      String temp=itemcost2[m].replaceAll("[^0-9]","");
                      equipandtotal1+=Integer.parseInt(temp);
                      
                   }
                   
                   String equipandtotalstring1=String.valueOf(equipandtotal1);
                   if (!return_text(".//*[@class='charges']/div[2]/header/ul/li[3]",driver).equals("Included"))
                   {
                   equipandtotalstring1=equipandtotalstring1.substring(0,equipandtotalstring1.length()-2)+"."+equipandtotalstring1.substring(equipandtotalstring1.length()-2);
                   }
                   equipandtotalstring1="$"+equipandtotalstring1;
                   logger.info("equipandtotalstring1 is "+equipandtotalstring1);
                   
                   
                   if((driver.findElement(By.xpath(".//*[@class='charges']/div[2]/header/ul/li[3]")).isDisplayed()))
                   {
                      
                      if (return_text(".//*[@class='charges']/div[2]/header/ul/li[3]",driver).equals("Included"))
                      { 
                       if (equipandtotalstring1.equals("$0"))
                       {
                           
                           statusTracker(br,driver,"Pass","Verify toatl price is displayed as incuded","The euipment added to the cart are updated and included in package","The items added to the cart  total"); 
                           
                       }
                      }
                          
                       if(equipandtotalstring1.equals(driver.findElement(By.xpath(".//*[@class='charges']/div[2]/header/ul/li[3]")).getText()))
                      {
                             statusTracker(br,driver,"Pass","Verify if the Eqipment added to the cart adds up to the total","The euipment added to the cart adds up to the total","The items added to the cart  total");
                      }
                      else
                      {
                             //statusTracker("Fail","Verify if the items added to the cart adds up to the total","The items added to the cart does not add up to the total. Actual: "+driver.findElement(By.xpath("//html/body/section/div[2]/div[2]/div/div/div/div/div/div[2]/section/div/table/tbody/tr/td[2]")).getText() +" Expected: "+equipandtotalstring,"The items added to the cart does not add up to the total");
                      }
                   }

                   Thread.sleep(4000);
                   
                   
                   
                   //validation of phone lob
                   
                   click_element(".//*[@class='charges']/div[3]/header/ul/li[1]/a",driver);
                   
                   
                   List<WebElement> myli6= driver.findElements(By.xpath("//*[@class='charges']/div[3]/section/div/table/tbody/tr/td[1]"));
                   logger.info("line 4");
                   carttotal2=myli6.size();
                   logger.info("line 5");
                   logger.info("cartaot2 is "+carttotal2);
                   itemname3[jk]="";
                   itemcost3[jk]="";
                   for (jk=0;jk<carttotal2;jk++)
                   {

                          
                          itemname3[jk]=driver.findElement(By.xpath("//*[@class='charges']/div[3]/section/div/table/tbody/tr["+(jk+1)+"]/td[1]")).getText(); 
                          itemcost3[jk]=driver.findElement(By.xpath("//*[@class='charges']/div[3]/section/div/table/tbody/tr["+(jk+1)+"]/td[2]")).getText();
                          logger.info(" eqipment cost is:"+itemcost3[jk]);
                          logger.info(" eqipment name is:"+itemname3[jk]);
                          statusTracker(br,driver," ","cart details", "eqipment name is: "+itemname3[jk]+" and item cost is: "+itemcost3[jk],"selected eqipment should be added to cart");
                          if ((itemcost3[jk]).trim().equals("Free") || (itemcost3[jk]).trim().equals("Included") )
                          {
                                itemcost3[jk]="0";
                          }
                                
                   }
                   logger.info("section1");
                   
                   int equipandtotal2=0;
                       for(int m=0;m<carttotal2;m++)
                       {
                          
                          String temp=itemcost3[m].replaceAll("[^0-9]","");
                          equipandtotal2+=Integer.parseInt(temp);
                          
                       }
                       
                       String equipandtotalstring2=String.valueOf(equipandtotal2);
                       logger.info("section2");
                       if (!return_text(".//*[@class='charges']/div[3]/header/ul/li[3]",driver).equals("Included"))
                       {
                       equipandtotalstring2=equipandtotalstring2.substring(0,equipandtotalstring2.length()-2)+"."+equipandtotalstring2.substring(equipandtotalstring2.length()-2);
                       }
                       logger.info("section3");
                       equipandtotalstring2="$"+equipandtotalstring2;
                       logger.info("section4");
                       logger.info("equipandtotalstring2 is "+equipandtotalstring2);
                       
                       
                       if((driver.findElement(By.xpath(".//*[@class='charges']/div[3]/header/ul/li[3]")).isDisplayed()))
                           
                       {
                         if (return_text(".//*[@class='charges']/div[3]/header/ul/li[3]",driver).equals("Included")) 
                         {  
                             if (equipandtotalstring2.equals("$0"))
                             {
                                 
                                 statusTracker(br,driver,"Pass","Verify toatl price is displayed as incuded","The euipment added to the cart are updated and included in package","The items added to the cart  total"); 
                                 
                             }
                         }
                         else
                         {
                             if(equipandtotalstring2.equals(driver.findElement(By.xpath(".//*[@class='charges']/div[3]/header/ul/li[3]")).getText()))
                           {
                                  statusTracker(br,driver,"Pass","Verify if the Eqipment added to the cart adds up to the total","The euipment added to the cart adds up to the total","The items added to the cart  total");
                           }
                           else
                           {
                                 // statusTracker(br,driver,"Fail","Verify if the items added to the cart adds up to the total","The items added to the cart does not add up to the total. Actual: "+driver.findElement(By.xpath("//html/body/section/div[2]/div[2]/div/div/div/div/div/div[2]/section/div/table/tbody/tr/td[2]")).getText() +" Expected: "+equipandtotalstring,"The items added to the cart does not add up to the total");
                           }
                         }
                         
                       }

                       Thread.sleep(4000);
                       
               
           
         
}

public void config_page_Cart_result_updater_Phone_Package(String br,WebDriver driver) throws InterruptedException
{
    //Validation of status TV LOB
    
     click_element(".//*[@class='charges']//div[1]/header/ul/li[1]/a",driver);
    logger.info("Manju function is called");
       int jk;
       logger.info("line 1");
// String itemname[]=new String[15];
       logger.info("line 2");

         logger.info("line 3");
       List<WebElement> myli4= driver.findElements(By.xpath("//*[@class='charges']/div[1]/section/div/table/tbody/tr/td[1]"));
       logger.info("line 4");
       carttotal=myli4.size();
       logger.info("line 5");
       logger.info("cartaotl is "+carttotal);
     //RAVZ code starts here******************************
       for(int m=0;m<carttotal;m++)
       {
           itemcost1_Free[m]="0";
           itemcost1_Included[m]="0";
       }
     //RAVZ code ends here******************************
       for (jk=0;jk<carttotal;jk++)
       {

              
              itemname1[jk]=driver.findElement(By.xpath("//*[@class='charges']/div[1]/section/div/table/tbody/tr["+(jk+1)+"]/td[1]")).getText(); 
              itemcost1[jk]=driver.findElement(By.xpath("//*[@class='charges']/div[1]/section/div/table/tbody/tr["+(jk+1)+"]/td[2]")).getText();
              logger.info(" eqipment cost is:"+itemcost1[jk]);
              logger.info(" eqipment name is:"+itemname1[jk]);
              statusTracker(br,driver," ","cart details", "eqipment name is: "+itemname1[jk]+" and item cost is: "+itemcost1[jk],"selected eqipment should be added to cart");
              
            //RAVZ code starts here******************************
              if ((itemcost1[jk]).trim().equals("Free") || (itemcost1[jk]).trim().equals("Included") )
              {
                  
                   if ( itemcost1[jk].trim().equals("Free"))
                   {
                       itemcost1_Free[jk]="Free";
                   }
                   if ( itemcost1[jk].trim().equals("Included"))
                   {
                       itemcost1_Included[jk]="Included";
                   }
                   itemcost1[jk]="0";
              }
            //RAVZ code ends here******************************       
       }
       
       int equipandtotal=0;
           for(int m=0;m<carttotal;m++)
           {
              
              String temp=itemcost1[m].replaceAll("[^0-9]","");
              equipandtotal+=Integer.parseInt(temp);
              
           }
           
           String equipandtotalstring=String.valueOf(equipandtotal);
           if (!return_text(".//*[@class='charges']/div[1]/header/ul/li[3]",driver).equals("Included"))
           {
           equipandtotalstring=equipandtotalstring.substring(0,equipandtotalstring.length()-2)+"."+equipandtotalstring.substring(equipandtotalstring.length()-2);
           }
           equipandtotalstring="$"+equipandtotalstring;
           logger.info("equipandtotalstring is "+equipandtotalstring);
           
           
           if(driver.findElement(By.xpath(".//*[@class='charges']/div[1]/header/ul/li[3]")).isDisplayed())
           {
               if (return_text(".//*[@class='charges']/div[1]/header/ul/li[3]",driver).equals("Included"))
               {

               if (equipandtotalstring.equals("$0"))
               {
                   
                   statusTracker(br,driver,"Pass","Verify toatl price is displayed as incuded","The euipment added to the cart are updated and included in package","The items added to the cart  total"); 
                   
               }
               
               }

               if(equipandtotalstring.equals(driver.findElement(By.xpath("//*[@class='charges']/div[1]/header/ul/li[3]")).getText()))
              {
                     statusTracker(br,driver,"Pass","Verify if the Eqipment added to the cart adds up to the total","The euipment added to the cart adds up to the total","The items added to the cart  total");
              }
              else
              {
                     //statusTracker("Fail","Verify if the items added to the cart adds up to the total","The items added to the cart does not add up to the total. Actual: "+driver.findElement(By.xpath("//html/body/section/div[2]/div[2]/div/div/div/div/div/div[2]/section/div/table/tbody/tr/td[2]")).getText() +" Expected: "+equipandtotalstring,"The items added to the cart does not add up to the total");
              }
           }

           Thread.sleep(4000);
           
           
           //validation of Interner LOB
           
           click_element(".//*[@class='charges']//div[2]/header/ul/li[1]/a",driver);
           
           List<WebElement> myli5= driver.findElements(By.xpath("//*[@class='charges']/div[2]/section/div/table/tbody/tr/td[1]"));
           logger.info("line 4");
           carttotal1=myli5.size();
           //RAVZ code starts here******************************
           for(int m=0;m<carttotal1;m++)
           {
               itemcost2_Free[m]="0";
               itemcost2_Included[m]="0";
           }
           //RAVZ code ends here******************************
           logger.info("line 5");
           logger.info("cartaotl is "+carttotal1);
           itemname2[jk]="";
           itemcost2[jk]="";
           for (jk=0;jk<carttotal1;jk++)
           {

                  
                  itemname2[jk]=driver.findElement(By.xpath("//*[@class='charges']/div[2]/section/div/table/tbody/tr["+(jk+1)+"]/td[1]")).getText(); 
                  itemcost2[jk]=driver.findElement(By.xpath("//*[@class='charges']/div[2]/section/div/table/tbody/tr["+(jk+1)+"]/td[2]")).getText();
                  logger.info(" eqipment cost is:"+itemcost2[jk]);
                  logger.info(" eqipment name is:"+itemname2[jk]);
                  statusTracker(br,driver," ","cart details", "eqipment name is: "+itemname2[jk]+" and item cost is: "+itemcost2[jk],"selected eqipment should be added to cart");
                 
                //RAVZ code starts here******************************
                  if ((itemcost2[jk]).trim().equals("Free") || (itemcost2[jk]).trim().equals("Included") )
                  {
                      if ( itemcost2[jk].trim().equals("Free"))
                      {
                          itemcost2_Free[jk]="Free";
                      }
                      if ( itemcost2[jk].trim().equals("Included"))
                      {
                          itemcost2_Included[jk]="Included";
                      } 
                      itemcost2[jk]="0";
                        
                  }
                //RAVZ code ends here******************************        
           }
           
           int equipandtotal1=0;
               for(int m=0;m<carttotal1;m++)
               {
                  
                  String temp=itemcost2[m].replaceAll("[^0-9]","");
                  equipandtotal1+=Integer.parseInt(temp);
                  
               }
               
               String equipandtotalstring1=String.valueOf(equipandtotal1);
               if (!return_text(".//*[@class='charges']/div[2]/header/ul/li[3]",driver).equals("Included"))
               {
               equipandtotalstring1=equipandtotalstring1.substring(0,equipandtotalstring1.length()-2)+"."+equipandtotalstring1.substring(equipandtotalstring1.length()-2);
               }
               equipandtotalstring1="$"+equipandtotalstring1;
               logger.info("equipandtotalstring1 is "+equipandtotalstring1);
               
               
               if((driver.findElement(By.xpath(".//*[@class='charges']/div[2]/header/ul/li[3]")).isDisplayed()))
               {
                  
                  if (return_text(".//*[@class='charges']/div[2]/header/ul/li[3]",driver).equals("Included"))
                  { 
                   if (equipandtotalstring1.equals("$0"))
                   {
                       
                       statusTracker(br,driver,"Pass","Verify toatl price is displayed as incuded","The euipment added to the cart are updated and included in package","The items added to the cart  total"); 
                       
                   }
                  }
                      
                   if(equipandtotalstring1.equals(driver.findElement(By.xpath(".//*[@class='charges']/div[2]/header/ul/li[3]")).getText()))
                  {
                         statusTracker(br,driver,"Pass","Verify if the Eqipment added to the cart adds up to the total","The euipment added to the cart adds up to the total","The items added to the cart  total");
                  }
                  else
                  {
                         //statusTracker("Fail","Verify if the items added to the cart adds up to the total","The items added to the cart does not add up to the total. Actual: "+driver.findElement(By.xpath("//html/body/section/div[2]/div[2]/div/div/div/div/div/div[2]/section/div/table/tbody/tr/td[2]")).getText() +" Expected: "+equipandtotalstring,"The items added to the cart does not add up to the total");
                  }
               }

               Thread.sleep(4000);
               
               
               
               //validation of phone lob
               
               //click_element(".//*[@class='charges']/div[3]/header/ul/li[1]/a",driver);
               
               
               List<WebElement> myli6= driver.findElements(By.xpath("//*[@class='charges']/div[3]/section/div/table/tbody/tr/td[1]"));
               logger.info("line 4");
               carttotal2=myli6.size();
               //RAVZ code starts here****************************** 
               for(int m=0;m<carttotal2;m++)
               {
                   itemcost3_Free[m]="0";
                   itemcost3_Included[m]="0";
               }
               //RAVZ code ends here****************************** 
               
               logger.info("line 5");
               logger.info("cartaot2 is "+carttotal2);
               itemname3[jk]="";
               itemcost3[jk]="";
               for (jk=0;jk<carttotal2;jk++)
               {

                      
                      itemname3[jk]=driver.findElement(By.xpath("//*[@class='charges']/div[3]/section/div/table/tbody/tr["+(jk+1)+"]/td[1]")).getText(); 
                      itemcost3[jk]=driver.findElement(By.xpath("//*[@class='charges']/div[3]/section/div/table/tbody/tr["+(jk+1)+"]/td[2]")).getText();
                      logger.info(" eqipment cost is:"+itemcost3[jk]);
                      logger.info(" eqipment name is:"+itemname3[jk]);
                      statusTracker(br,driver," ","cart details", "eqipment name is: "+itemname3[jk]+" and item cost is: "+itemcost3[jk],"selected eqipment should be added to cart");
                    
                      //RAVZ code starts here****************************** 
                      if ((itemcost3[jk]).trim().equals("Free") || (itemcost3[jk]).trim().equals("Included") )
                      {
                          if ( itemcost3[jk].trim().equals("Free"))
                          {
                              itemcost3_Free[jk]="Free";
                          }
                          if ( itemcost3[jk].trim().equals("Included"))
                          {
                              itemcost3_Included[jk]="Included";
                          } 
                          itemcost3[jk]="0";
                      }
                      //RAVZ code ends here******************************         
               }
               logger.info("section1");
               
               int equipandtotal2=0;
                   for(int m=0;m<carttotal2;m++)
                   {
                      
                      String temp=itemcost3[m].replaceAll("[^0-9]","");
                      equipandtotal2+=Integer.parseInt(temp);
                      
                   }
                   
                   String equipandtotalstring2=String.valueOf(equipandtotal2);
                   logger.info("section2");
                   if (!return_text(".//*[@class='charges']/div[3]/header/ul/li[3]",driver).equals("Included"))
                   {
                   equipandtotalstring2=equipandtotalstring2.substring(0,equipandtotalstring2.length()-2)+"."+equipandtotalstring2.substring(equipandtotalstring2.length()-2);
                   }
                   logger.info("section3");
                   equipandtotalstring2="$"+equipandtotalstring2;
                   logger.info("section4");
                   logger.info("equipandtotalstring2 is "+equipandtotalstring2);
                   
                   
                   if((driver.findElement(By.xpath(".//*[@class='charges']/div[3]/header/ul/li[3]")).isDisplayed()))
                       
                   {
                     if (return_text(".//*[@class='charges']/div[3]/header/ul/li[3]",driver).equals("Included")) 
                     {  
                         if (equipandtotalstring2.equals("$0"))
                         {
                             
                             statusTracker(br,driver,"Pass","Verify toatl price is displayed as incuded","The euipment added to the cart are updated and included in package","The items added to the cart  total"); 
                             
                         }
                     }
                     else
                     {
                         if(equipandtotalstring2.equals(driver.findElement(By.xpath(".//*[@class='charges']/div[3]/header/ul/li[3]")).getText()))
                       {
                              statusTracker(br,driver,"Pass","Verify if the Eqipment added to the cart adds up to the total","The euipment added to the cart adds up to the total","The items added to the cart  total");
                       }
                       else
                       {
                             // statusTracker(br,driver,"Fail","Verify if the items added to the cart adds up to the total","The items added to the cart does not add up to the total. Actual: "+driver.findElement(By.xpath("//html/body/section/div[2]/div[2]/div/div/div/div/div/div[2]/section/div/table/tbody/tr/td[2]")).getText() +" Expected: "+equipandtotalstring,"The items added to the cart does not add up to the total");
                       }
                     }
                     
                   }

                   Thread.sleep(4000);
                   
           
         
}

public void config_page_Cart_result_updater_Internet_Package(String br,WebDriver driver) throws InterruptedException
{

    //Validation of status TV LOB
    
         click_element(".//*[@class='charges']//div[1]/header/ul/li[1]/a",driver);
        logger.info("Manju function is called");
           int jk;
           logger.info("line 1");
    // String itemname[]=new String[15];
           logger.info("line 2");

             logger.info("line 3");
           List<WebElement> myli4= driver.findElements(By.xpath("//*[@class='charges']/div[1]/section/div/table/tbody/tr/td[1]"));
           logger.info("line 4");
           carttotal=myli4.size();
           logger.info("line 5");
           logger.info("cartaotl is "+carttotal);
           for (jk=0;jk<carttotal;jk++)
           {

                  
                  itemname1[jk]=driver.findElement(By.xpath("//*[@class='charges']/div[1]/section/div/table/tbody/tr["+(jk+1)+"]/td[1]")).getText(); 
                  itemcost1[jk]=driver.findElement(By.xpath("//*[@class='charges']/div[1]/section/div/table/tbody/tr["+(jk+1)+"]/td[2]")).getText();
                  logger.info(" eqipment cost is:"+itemcost1[jk]);
                  logger.info(" eqipment name is:"+itemname1[jk]);
                  statusTracker(br,driver," ","cart details", "eqipment name is: "+itemname1[jk]+" and item cost is: "+itemcost1[jk],"selected eqipment should be added to cart");
                  if ((itemcost1[jk]).trim().equals("Free") || (itemcost1[jk]).trim().equals("Included") )
                  {
                        itemcost1[jk]="0";
                  }
                        
           }
           
           int equipandtotal=0;
               for(int m=0;m<carttotal;m++)
               {
                  
                  String temp=itemcost1[m].replaceAll("[^0-9]","");
                  equipandtotal+=Integer.parseInt(temp);
                  
               }
               
               String equipandtotalstring=String.valueOf(equipandtotal);
               if (!return_text(".//*[@class='charges']/div[1]/header/ul/li[3]",driver).equals("Included"))
               {
               equipandtotalstring=equipandtotalstring.substring(0,equipandtotalstring.length()-2)+"."+equipandtotalstring.substring(equipandtotalstring.length()-2);
               }
               equipandtotalstring="$"+equipandtotalstring;
               logger.info("equipandtotalstring is "+equipandtotalstring);
               
               
               if(driver.findElement(By.xpath(".//*[@class='charges']/div[1]/header/ul/li[3]")).isDisplayed())
               {
                   if (return_text(".//*[@class='charges']/div[1]/header/ul/li[3]",driver).equals("Included"))
                   {

                   if (equipandtotalstring.equals("$0"))
                   {
                       
                       statusTracker(br,driver,"Pass","Verify toatl price is displayed as incuded","The euipment added to the cart are updated and included in package","The items added to the cart  total"); 
                       
                   }
                   
                   }

                   if(equipandtotalstring.equals(driver.findElement(By.xpath("//*[@class='charges']/div[1]/header/ul/li[3]")).getText()))
                  {
                         statusTracker(br,driver,"Pass","Verify if the Eqipment added to the cart adds up to the total","The euipment added to the cart adds up to the total","The items added to the cart  total");
                  }
                  else
                  {
                         //statusTracker("Fail","Verify if the items added to the cart adds up to the total","The items added to the cart does not add up to the total. Actual: "+driver.findElement(By.xpath("//html/body/section/div[2]/div[2]/div/div/div/div/div/div[2]/section/div/table/tbody/tr/td[2]")).getText() +" Expected: "+equipandtotalstring,"The items added to the cart does not add up to the total");
                  }
               }

               Thread.sleep(4000);
               
               
               //validation of Interner LOB
               
              // click_element(".//*[@class='charges']//div[2]/header/ul/li[1]/a",driver);
               
               List<WebElement> myli5= driver.findElements(By.xpath("//*[@class='charges']/div[2]/section/div/table/tbody/tr/td[1]"));
               logger.info("line 4");
               carttotal1=myli5.size();
               logger.info("line 5");
               logger.info("cartaotl is "+carttotal1);
               itemname2[jk]="";
               itemcost2[jk]="";
               for (jk=0;jk<carttotal1;jk++)
               {

                      
                      itemname2[jk]=driver.findElement(By.xpath("//*[@class='charges']/div[2]/section/div/table/tbody/tr["+(jk+1)+"]/td[1]")).getText(); 
                      itemcost2[jk]=driver.findElement(By.xpath("//*[@class='charges']/div[2]/section/div/table/tbody/tr["+(jk+1)+"]/td[2]")).getText();
                      logger.info(" eqipment cost is:"+itemcost2[jk]);
                      logger.info(" eqipment name is:"+itemname2[jk]);
                      statusTracker(br,driver," ","cart details", "eqipment name is: "+itemname2[jk]+" and item cost is: "+itemcost2[jk],"selected eqipment should be added to cart");
                      if ((itemcost2[jk]).trim().equals("Free") || (itemcost2[jk]).trim().equals("Included") )
                      {
                            itemcost2[jk]="0";
                      }
                            
               }
               
               int equipandtotal1=0;
                   for(int m=0;m<carttotal1;m++)
                   {
                      
                      String temp=itemcost2[m].replaceAll("[^0-9]","");
                      equipandtotal1+=Integer.parseInt(temp);
                      
                   }
                   
                   String equipandtotalstring1=String.valueOf(equipandtotal1);
                   if (!return_text(".//*[@class='charges']/div[2]/header/ul/li[3]",driver).equals("Included"))
                   {
                   equipandtotalstring1=equipandtotalstring1.substring(0,equipandtotalstring1.length()-2)+"."+equipandtotalstring1.substring(equipandtotalstring1.length()-2);
                   }
                   equipandtotalstring1="$"+equipandtotalstring1;
                   logger.info("equipandtotalstring1 is "+equipandtotalstring1);
                   
                   
                   if((driver.findElement(By.xpath(".//*[@class='charges']/div[2]/header/ul/li[3]")).isDisplayed()))
                   {
                      
                      if (return_text(".//*[@class='charges']/div[2]/header/ul/li[3]",driver).equals("Included"))
                      { 
                       if (equipandtotalstring1.equals("$0"))
                       {
                           
                           statusTracker(br,driver,"Pass","Verify toatl price is displayed as incuded","The euipment added to the cart are updated and included in package","The items added to the cart  total"); 
                           
                       }
                      }
                          
                       if(equipandtotalstring1.equals(driver.findElement(By.xpath(".//*[@class='charges']/div[2]/header/ul/li[3]")).getText()))
                      {
                             statusTracker(br,driver,"Pass","Verify if the Eqipment added to the cart adds up to the total","The euipment added to the cart adds up to the total","The items added to the cart  total");
                      }
                      else
                      {
                             //statusTracker("Fail","Verify if the items added to the cart adds up to the total","The items added to the cart does not add up to the total. Actual: "+driver.findElement(By.xpath("//html/body/section/div[2]/div[2]/div/div/div/div/div/div[2]/section/div/table/tbody/tr/td[2]")).getText() +" Expected: "+equipandtotalstring,"The items added to the cart does not add up to the total");
                      }
                   }

                   Thread.sleep(4000);
                   
                   
                   
                   //validation of phone lob
                   
                   click_element(".//*[@class='charges']/div[3]/header/ul/li[1]/a",driver);
                   
                   
                   List<WebElement> myli6= driver.findElements(By.xpath("//*[@class='charges']/div[3]/section/div/table/tbody/tr/td[1]"));
                   logger.info("line 4");
                   carttotal2=myli6.size();
                   logger.info("line 5");
                   logger.info("cartaot2 is "+carttotal2);
                   itemname3[jk]="";
                   itemcost3[jk]="";
                   for (jk=0;jk<carttotal2;jk++)
                   {

                          
                          itemname3[jk]=driver.findElement(By.xpath("//*[@class='charges']/div[3]/section/div/table/tbody/tr["+(jk+1)+"]/td[1]")).getText(); 
                          itemcost3[jk]=driver.findElement(By.xpath("//*[@class='charges']/div[3]/section/div/table/tbody/tr["+(jk+1)+"]/td[2]")).getText();
                          logger.info(" eqipment cost is:"+itemcost3[jk]);
                          logger.info(" eqipment name is:"+itemname3[jk]);
                          statusTracker(br,driver," ","cart details", "eqipment name is: "+itemname3[jk]+" and item cost is: "+itemcost3[jk],"selected eqipment should be added to cart");
                          if ((itemcost3[jk]).trim().equals("Free") || (itemcost3[jk]).trim().equals("Included") )
                          {
                                itemcost3[jk]="0";
                          }
                                
                   }
                   logger.info("section1");
                   
                   int equipandtotal2=0;
                       for(int m=0;m<carttotal2;m++)
                       {
                          
                          String temp=itemcost3[m].replaceAll("[^0-9]","");
                          equipandtotal2+=Integer.parseInt(temp);
                          
                       }
                       
                       String equipandtotalstring2=String.valueOf(equipandtotal2);
                       logger.info("section2");
                       if (!return_text(".//*[@class='charges']/div[3]/header/ul/li[3]",driver).equals("Included"))
                       {
                       equipandtotalstring2=equipandtotalstring2.substring(0,equipandtotalstring2.length()-2)+"."+equipandtotalstring2.substring(equipandtotalstring2.length()-2);
                       }
                       logger.info("section3");
                       equipandtotalstring2="$"+equipandtotalstring2;
                       logger.info("section4");
                       logger.info("equipandtotalstring2 is "+equipandtotalstring2);
                       
                       
                       if((driver.findElement(By.xpath(".//*[@class='charges']/div[3]/header/ul/li[3]")).isDisplayed()))
                           
                       {
                         if (return_text(".//*[@class='charges']/div[3]/header/ul/li[3]",driver).equals("Included")) 
                         {  
                             if (equipandtotalstring2.equals("$0"))
                             {
                                 
                                 statusTracker(br,driver,"Pass","Verify toatl price is displayed as incuded","The euipment added to the cart are updated and included in package","The items added to the cart  total"); 
                                 
                             }
                         }
                         else
                         {
                             if(equipandtotalstring2.equals(driver.findElement(By.xpath(".//*[@class='charges']/div[3]/header/ul/li[3]")).getText()))
                           {
                                  statusTracker(br,driver,"Pass","Verify if the Eqipment added to the cart adds up to the total","The euipment added to the cart adds up to the total","The items added to the cart  total");
                           }
                           else
                           {
                                 // statusTracker(br,driver,"Fail","Verify if the items added to the cart adds up to the total","The items added to the cart does not add up to the total. Actual: "+driver.findElement(By.xpath("//html/body/section/div[2]/div[2]/div/div/div/div/div/div[2]/section/div/table/tbody/tr/td[2]")).getText() +" Expected: "+equipandtotalstring,"The items added to the cart does not add up to the total");
                           }
                         }
                         
                       }                 
               
                   Thread.sleep(4000);
                   
           
         
}

public void page_Cart_One_Time_charge_updater_Package (String br,WebDriver driver) throws InterruptedException
{
       
       int mon_total_items= return_size(".//*[@id='content']/div[3]/div[2]/div/div[1]/div/div/div[2]/section/div[2]/section/table/tbody/tr",driver);
       logger.info("{}",mon_total_items);
       
       for (int i=1; i<=mon_total_items;i++)
       
       {
              itemname_mon[i]=return_text(".//*[@id='content']/div[3]/div[2]/div/div[1]/div/div/div[2]/section/div[2]/section/table/tbody/tr["+i+"]/td[1]",driver);
              itemcost_mon[i]=return_text(".//*[@id='content']/div[3]/div[2]/div/div[1]/div/div/div[2]/section/div[2]/section/table/tbody/tr["+i+"]/td[2]",driver);
              /*
              if (itemcost_mon[i].equals("Free"))
              {
                  itemcost_mon[i]="0";
              }
              */
              logger.info(" Service cost is:"+itemcost_mon[i]);
              logger.info(" Serivce name is:"+itemname_mon[i]);
              statusTracker(br,driver," ","cart details", "Service name is: "+itemname_mon[i]+" and Service cost is: "+itemcost_mon[i],"selected service should be updated in one time charge section");
       }
       mon_total = return_text (".//*[@id='content']/div[3]/div[2]/div/div[1]/div/div/div[2]/section/table/tbody/tr/td[2]",driver);
       statusTracker(br,driver," ","cart details", "Total one time charges is "+mon_total,"Total one time charge should be updated in cart");
}

// package review order section
public void Package_ReviewOrder_TV_ChkMonthlyCharges(String br,WebDriver drive) 
    {
        logger.info("TV Check");
        String reviewcartname1[] = new String[10];
        String reviewcartcost1[] = new String[10];
        int reviewcartoptions1 = 0;
        for (int i = 0; i < carttotal; i++) {

            if (isElementPresent(
                    ".//*[@title='Monthly Charges']/tbody/tr["+(i+3)+"]", drive)) {
                reviewcartoptions1++;
                
            }
        }
        logger.info("reviewcartoptions1 : "+reviewcartoptions1);
        for (int i = 1; i <= reviewcartoptions1; i++) {
            reviewcartname1[i - 1] = return_text(
                    ".//*[@title='Monthly Charges']/tbody/tr["+ (i+2) +"]/td[1]", drive);

            System.out
                    .println("name "
                            + return_text(
                                    ".//*[@title='Monthly Charges']/tbody/tr["+ (i+2) +"]/td[1]", drive));
            reviewcartcost1[i - 1] = return_text(
                    ".//*[@title='Monthly Charges']/tbody/tr["+ (i+2) +"]/td[2]", drive);
            if (reviewcartcost1[i - 1].length() > 10) {
                int index = reviewcartcost1[i - 1].indexOf(" ");
                logger.info("index: " + index);
                reviewcartcost1[i - 1] = reviewcartcost1[i - 1].substring(0,
                        index);
            }
            if ((reviewcartcost1[i-1]).trim().equals("Free") || (reviewcartcost1[i-1]).trim().equals("Included") )
            {
                reviewcartcost1[i-1]="0";
            }
        }
        int judge = -1;
        logger.info("rpage 4");
        for (int i = 0; i < reviewcartoptions1; i++) {
            logger.info("Item Details : " + itemname1[i] + " - "
                    + itemcost1[i]);
            logger.info("Review Details : " + reviewcartname1[i] + " - "
                    + reviewcartcost1[i]);
            if (itemname1[i].equals(reviewcartname1[i])
                    && itemcost1[i].equals(reviewcartcost1[i])) {
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
        {
            statusTracker(br,drive,
                    "Fail",
                    "Verify if the TV Details under the review order section is in sync with the items chosen",
                    "Items are not proper. Item: " + judge
                            + " is incorrect. Expected: " + itemname1[judge]
                            + " " + itemcost1[judge] + " Actual: "
                            + reviewcartname1[judge] + " "
                            + reviewcartcost1[judge],
                    "Items should be the same as chosen");
        }
        else
            statusTracker(br,drive,
                    "Pass",
                    "Verify if the TV Details under the review order section is in sync with the items chosen",
                    "Items are as chosen from the cart",
                    "Items should be the same as chosen"); 
        
        logger.info("TV Check Completed");
        
        for (int i = 0; i < reviewcartoptions1; i++)
            RO_TotalMonthlyCharges += Double.parseDouble(reviewcartcost1[i].replace("$", ""));
    
    }


    public void Package_ReviewOrder_Internet_ChkMonthlyCharges(String br) 
    {
        logger.info("Internet Check");
        String reviewcartname2[] = new String[10];
        String reviewcartcost2[] = new String[10];
        int reviewcartoptions2 = 0;
        for (int i = 0; i < carttotal1; i++) {

            if (isElementPresent(
                    ".//*[@title='Monthly Charges']/tbody/tr["+(i+6)+"]", drive)) {
                reviewcartoptions2++;
                
            }
        }
        logger.info("reviewcartoptions2 : "+reviewcartoptions2);
        for (int i = 1; i <= reviewcartoptions2; i++) {
            reviewcartname2[i - 1] = return_text(
                    ".//*[@title='Monthly Charges']/tbody/tr["+ (i+5) +"]/td[1]", drive);

            System.out
                    .println("name "
                            + return_text(
                                    ".//*[@title='Monthly Charges']/tbody/tr["+ (i+5) +"]/td[1]", drive));
            reviewcartcost2[i - 1] = return_text(
                    ".//*[@title='Monthly Charges']/tbody/tr["+ (i+5) +"]/td[2]", drive);
            if (reviewcartcost2[i - 1].length() > 10) {
                int index = reviewcartcost2[i - 1].indexOf(" ");
                logger.info("index: " + index);
                reviewcartcost2[i - 1] = reviewcartcost2[i - 1].substring(0,
                        index);
            }
            if ((reviewcartcost2[i-1]).trim().equals("Free") || (reviewcartcost2[i-1]).trim().equals("Included") )
            {
                reviewcartcost2[i-1]="0";
            }
        }
        int judge = -1;
        logger.info("rpage 4");
        for (int i = 0; i < reviewcartoptions2; i++) {
            logger.info("Item Details : " + itemname2[i] + " - "
                    + itemcost2[i]);
            logger.info("Review Details : " + reviewcartname2[i] + " - "
                    + reviewcartcost2[i]);
            if (itemname2[i].equals(reviewcartname2[i])
                    && itemcost2[i].equals(reviewcartcost2[i])) {
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
                    "Verify if the Internet Details under the review order section is in sync with the items chosen",
                    "Items are not proper. Item: " + judge
                            + " is incorrect. Expected: " + itemname2[judge]
                            + " " + itemcost2[judge] + " Actual: "
                            + reviewcartname2[judge] + " "
                            + reviewcartcost2[judge],
                    "Items should be the same as chosen");

        else
            statusTracker(br,drive,
                    "Pass",
                    "Verify if the Internet Details under the review order section is in sync with the items chosen",
                    "Items are as chosen from the cart",
                    "Items should be the same as chosen");
        logger.info("Internet Check Completed");
        
        for (int i = 0; i < reviewcartoptions2; i++)
            RO_TotalMonthlyCharges += Double.parseDouble(reviewcartcost2[i].replace("$", ""));
    }
    
    public void Package_ReviewOrder_Phone_ChkMonthlyCharges(String br,WebDriver drive) 
    {
        logger.info("Phone Check");
        String reviewcartname3[] = new String[10];
        String reviewcartcost3[] = new String[10];
        int reviewcartoptions3 = 0;
        for (int i = 0; i < carttotal2; i++) {

            if (isElementPresent(
                    ".//*[@title='Monthly Charges']/tbody/tr["+(i+9)+"]", drive)) {
                reviewcartoptions3++;
                
            }
        }
        logger.info("reviewcartoptions3 : "+reviewcartoptions3);
        for (int i = 1; i <= reviewcartoptions3; i++) {
            reviewcartname3[i - 1] = return_text(
                    ".//*[@title='Monthly Charges']/tbody/tr["+ (i+8) +"]/td[1]", drive);

            System.out
                    .println("name "
                            + return_text(
                                    ".//*[@title='Monthly Charges']/tbody/tr["+ (i+8) +"]/td[1]", drive));
            reviewcartcost3[i - 1] = return_text(
                    ".//*[@title='Monthly Charges']/tbody/tr["+ (i+8) +"]/td[2]", drive);
            if (reviewcartcost3[i - 1].length() > 10) {
                int index = reviewcartcost3[i - 1].indexOf(" ");
                logger.info("index: " + index);
                reviewcartcost3[i - 1] = reviewcartcost3[i - 1].substring(0,
                        index);
            }
            if ((reviewcartcost3[i-1]).trim().equals("Free") || (reviewcartcost3[i-1]).trim().equals("Included") )
            {
                reviewcartcost3[i-1]="0";
            }
        }
        int judge = -1;
        logger.info("rpage 4");
        for (int i = 0; i < reviewcartoptions3; i++) {
            logger.info("Item Details : " + itemname3[i] + " - "
                    + itemcost3[i]);
            logger.info("Review Details : " + reviewcartname3[i] + " - "
                    + reviewcartcost3[i]);
            if (itemname3[i].equals(reviewcartname3[i])
                    && itemcost3[i].equals(reviewcartcost3[i])) {
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
                    "Verify if the Phone Details under the review order section is in sync with the items chosen",
                    "Items are not proper. Item: " + judge
                            + " is incorrect. Expected: " + itemname3[judge]
                            + " " + itemcost3[judge] + " Actual: "
                            + reviewcartname3[judge] + " "
                            + reviewcartcost3[judge],
                    "Items should be the same as chosen");

        else
            statusTracker(br,drive,
                    "Pass",
                    "Verify if the Phone Details under the review order section is in sync with the items chosen",
                    "Items are as chosen from the cart",
                    "Items should be the same as chosen");
        
        for (int i = 0; i < reviewcartoptions3; i++)
            RO_TotalMonthlyCharges += Double.parseDouble(reviewcartcost3[i].replace("$", ""));
        
        RO_TotalMonthlyCharges = RO_TotalMonthlyCharges + PackageAmount;
        logger.info("Phone Check Completed : "+RO_TotalMonthlyCharges);
        
        if (dateformat.format(RO_TotalMonthlyCharges).toString()
                .equals(return_text(
                        "//*[@id='content']/div[3]/div[2]/div[2]/div/div/div/div/div[1]/table/tfoot/tr/td[2]",
                        drive).replace("$", ""))) {
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
                                    drive) + " Expected: $" + dateformat.format(RO_TotalMonthlyCharges),
                    "The totals should be the same");
        }
    }
    
    public void Package_ReviewOrder_ChkOneTimeCharges(String br) {
        System.out
                .println("Package_ReviewOrder_ChkOneTimeCharges - Validating OneTime Charges : "
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
                logger.info("One Time Charges - 4.2");
            } else {
                logger.info("One Time Charges - 4.3");
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
    
    public void Package_OrderSummary_DetailsValidation(String br,String Cust_Name, String Cust_ServiceAddress,WebDriver drive) throws ParseException,InterruptedException 
    {
        String Actual_ServiceAddress = "";
          String Expected_ServiceAddress = "";
          String FirstDateTime = "";
        String SecondDateTime = "";
          logger.info("Calling Package_OrderSummary_DetailsValidation");
          logger.info("Order Summary - ECKOptionSelected : "+ECKOptionSelected);
          logger.info("Order Summary - Overall_oneTimeCharges : "+Overall_oneTimeCharges);
          logger.info("Order Summary - Cust_ServiceAddress : "+Cust_ServiceAddress);
          
          if (ECKOptionSelected.equals("Store"))
          {
              logger.info(return_text(".//*[@class='services-table']/tbody/tr[1]/td[1]", drive).trim());
              if((return_text(".//*[@class='services-table']/tbody/tr[1]/td[1]", drive).trim()).equals("Easy Connect Pick-up Fee"))
                    statusTracker(br,drive,"Pass","For the Store Pick option, the One Time Charges Text to be verified in the Order Summary Page",return_text(".//*[@class='services-table']/tbody/tr[1]/td[1]", drive)+" is displayed.","One Time Charges Text is as Expected");
                else
                    statusTracker(br,drive,"Fail","For the Store Pick option, the One Time Charges Text to be verified",return_text(".//*[@class='services-table']/tbody/tr[1]/td[1]", drive)+" is displayed.","One Time Charges Text is NOT as Expected");
                
                if (InstallationFees == Double.parseDouble(return_text(".//*[@class='services-table']/tbody/tr[1]/td[2]", drive).replace("$", "").trim()))
                    statusTracker(br,drive,"Pass","For the Store Pick option, the One Time Charges charges to be verified in the Order Summary Page",return_text(".//*[@class='services-table']/tbody/tr[1]/td[2]", drive)+" is displayed.","One Time Charges VALUE is as Expected");
                else
                    statusTracker(br,drive,"Fail","For the Store Pick option, the One Time Charges charges  to be verified in the Order Summary Page",return_text(".//*[@class='services-table']/tbody/tr[1]/td[2]", drive)+" is displayed.","One Time Charges VALUE is NOT as Expected");
                
                if(StoreAddress1.equals(return_text(".//*[@class='three-col']/li[1]", drive).trim()))
                      statusTracker(br,drive,"Pass","Both Addresses 1 in Review & Summary Order page should be same",return_text(".//*[@class='three-col']/li[1]", drive),"Both Addresses 1 in Review & Summary Order page are same");
                  else
                      statusTracker(br,drive,"Fail","Both Addresses 1 in Review & Summary Order page should be same",return_text(".//*[@class='three-col']/li[1]", drive),"Both Addresses 1 in Review & Summary Order page are NOT same");
            
                if(StoreAddress2.equals(return_text(".//*[@class='three-col']/li[2]", drive).trim()))
                      statusTracker(br,drive,"Pass","Both Addresses 2 in Review & Summary Order page should be same",return_text(".//*[@class='three-col']/li[2]", drive),"Both Addresses 2 in Review & Summary Order page are same");
                  else
                      statusTracker(br,drive,"Fail","Both Addresses 2 in Review & Summary Order page should be same",return_text(".//*[@class='three-col']/li[2]", drive),"Both Addresses 2 in Review & Summary Order page are NOT same");
                
                /*if(StoreAddress3.equals(return_text(".//*[@class='three-col']/li[3]", drive).trim()))
                      statusTracker(br,driver,br,"Pass","Both Addresses 3 in Review & Summary Order page should be same",return_text(".//*[@class='three-col']/li[3]", drive),"Both Addresses 3 in Review & Summary Order page are same");
                  else
                      statusTracker(br,driver,br,"Fail","Both Addresses 3 in Review & Summary Order page should be same",return_text(".//*[@class='three-col']/li[3]", drive),"Both Addresses 3 in Review & Summary Order page are NOT same");*/
                
                Equip_text= return_text(".//*[@class='rtf']/ul/li", drive).trim();
          }
          else if (ECKOptionSelected.equals("Mail"))
          {
              Equip_text= return_text(".//*[@class='col rtf']/ul/li", drive).trim();
          }
          else if (ECKOptionSelected.equals("TechInstall"))
          {
              if ((return_text(
                    ".//*[@class='paragraphMerge installationLOB1']/p/strong[1]",
                    drive).trim()).equals("TV Internet Phone")
                    && (return_text(
                            ".//*[@class='paragraphMerge installationLOB1']/p/strong[2]",
                            drive).trim()).equals("Installation Preferences:")) {
                statusTracker(br,drive,
                        "Pass",
                        "The Package Text details in the Order Summary page to be verified",
                        "The Package Text details is verified.",
                        "The Package Text details is as Expected.");
            } else
                statusTracker(br,drive,
                        "Fail",
                        "The Package Text details in the Order Summary page to be verified",
                        "The Package Text details is verified & text is NOT appropriate.",
                        "The Package Text details is NOT as Expected.");

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
          }
          else
          {
              
          }
          logger.info("Equip Text : "+Equip_text);
          if (ECKOptionSelected.equals("Store") || ECKOptionSelected.equals("Mail"))
          {
              if(Equip_text.equals("Internet Modem Easy Connect Kit"))
                      statusTracker(br,drive,"Pass","Order Summary Page - "+ECKOptionSelected+" Option Content Validation",Equip_text," Internet Equipment Text is correct under "+ECKOptionSelected+" option");
                else
                    statusTracker(br,drive,"Fail","Order Summary Page - "+ECKOptionSelected+" Option Content Validation",Equip_text," Internet Equipment Text is NOT correct under "+ECKOptionSelected+" option");
            }
          if (Overall_oneTimeCharges == Double.parseDouble(return_text(".//*[@title='One Time Charges']/tfoot/tr/td[2]", drive).replace("$", "").trim()))
                statusTracker(br,drive,"Pass","The One Time Charges + ECK Fees is same as displayed in the Order Summary page",return_text(".//*[@title='One Time Charges']/tfoot/tr/td[2]", drive)+" is displayed.","One Time Charges VALUE : "+Overall_oneTimeCharges+" is as Expected");
            else
      
          //Validating the Service Address
          Expected_ServiceAddress = Cust_Name + " " +Cust_ServiceAddress.replace("Service Address: ", "");
          Actual_ServiceAddress = return_text(".//*[@class='last']", drive).trim();
              
          logger.info("Expected_ServiceAddress : "+Expected_ServiceAddress);
          logger.info("Actual_ServiceAddress : "+ Actual_ServiceAddress);
          
          if (Expected_ServiceAddress.equals(Actual_ServiceAddress))
              statusTracker(br,drive,"Pass","Order Summary Page - Validating Service Address",Actual_ServiceAddress,"Service Address is same as the Customer Details tagged to the account");
          else
              statusTracker(br,drive,"Fail","Order Summary Page - Validating Service Address",Actual_ServiceAddress,"Service Address is NOT same as the Customer Details tagged to the account");
          
          OrderSummary_ChkBrowserBackButton(br, drive);
        Thread.sleep(15000);

        // Selecting the check box for the Terms & Conditions
        logger.info("befor the click");
        click_element(".//*[@name='order-choose-TWC']", drive);
        logger.info("Checkbox clicked....");
    }
    
    public void Package_OrderSummary_TV_ChkMonthlyCharges(String br, WebDriver drive) 
    {
        logger.info("TV Check");
        String summarycartname1[] = new String[10];
        String summaryrcartcost1[] = new String[10];
        int summarycartoptions1 = 0;
        for (int i = 0; i < carttotal; i++) {

            if (isElementPresent(
                    ".//*[@title='Monthly Charges']/tbody/tr["+(i+3)+"]", drive)) {
                summarycartoptions1++;
                
            }
        }
        logger.info("summarycartoptions1 : "+summarycartoptions1);
        for (int i = 1; i <= summarycartoptions1; i++) {
            summarycartname1[i - 1] = return_text(
                    ".//*[@title='Monthly Charges']/tbody/tr["+ (i+2) +"]/td[1]", drive);

            System.out
                    .println("name "
                            + return_text(
                                    ".//*[@title='Monthly Charges']/tbody/tr["+ (i+2) +"]/td[1]", drive));
            summaryrcartcost1[i - 1] = return_text(
                    ".//*[@title='Monthly Charges']/tbody/tr["+ (i+2) +"]/td[2]", drive);
            if (summaryrcartcost1[i - 1].length() > 10) {
                int index = summaryrcartcost1[i - 1].indexOf(" ");
                logger.info("index: " + index);
                summaryrcartcost1[i - 1] = summaryrcartcost1[i - 1].substring(0,
                        index);
            }
            if ((summaryrcartcost1[i-1]).trim().equals("Free") || (summaryrcartcost1[i-1]).trim().equals("Included") )
            {
                summaryrcartcost1[i-1]="0";
            }
        }
        int judge = -1;
        logger.info("rpage 4");
        for (int i = 0; i < summarycartoptions1; i++) {
            logger.info("Item Details : " + itemname1[i] + " - "
                    + itemcost1[i]);
            logger.info("Summary Details : " + summarycartname1[i] + " - "
                    + summaryrcartcost1[i]);
            if (itemname1[i].equals(summarycartname1[i])
                    && itemcost1[i].equals(summaryrcartcost1[i])) {
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
        {
            statusTracker(br,drive,
                    "Fail",
                    "Verify if the TV Details under the Summary order section is in sync with the items chosen",
                    "Items are not proper. Item: " + judge
                            + " is incorrect. Expected: " + itemname1[judge]
                            + " " + itemcost1[judge] + " Actual: "
                            + summarycartname1[judge] + " "
                            + summaryrcartcost1[judge],
                    "Items should be the same as chosen");
        }
        else
            statusTracker(br,drive,
                    "Pass",
                    "Verify if the TV Details under the Summary order section is in sync with the items chosen",
                    "Items are as chosen from the cart",
                    "Items should be the same as chosen"); 
        
        logger.info("TV Check Completed");
        
        for (int i = 0; i < summarycartoptions1; i++)
            OS_TotalMonthlyCharges += Double.parseDouble(summaryrcartcost1[i].replace("$", ""));
    
    }
    
    public void Package_OrderSummary_Internet_ChkMonthlyCharges(String br, WebDriver driver) 
    {
        logger.info("Internet Check");
        String summarycartname2[] = new String[10];
        String summarycartcost2[] = new String[10];
        int summarycartoptions2 = 0;
        for (int i = 0; i < carttotal1; i++) {

            if (isElementPresent(
                    ".//*[@title='Monthly Charges']/tbody/tr["+(i+6)+"]", drive)) {
                summarycartoptions2++;
                
            }
        }
        logger.info("summarycartoptions2 : "+summarycartoptions2);
        for (int i = 1; i <= summarycartoptions2; i++) {
            summarycartname2[i - 1] = return_text(
                    ".//*[@title='Monthly Charges']/tbody/tr["+ (i+5) +"]/td[1]", drive);

            System.out
                    .println("name "
                            + return_text(
                                    ".//*[@title='Monthly Charges']/tbody/tr["+ (i+5) +"]/td[1]", drive));
            summarycartcost2[i - 1] = return_text(
                    ".//*[@title='Monthly Charges']/tbody/tr["+ (i+5) +"]/td[2]", drive);
            if (summarycartcost2[i - 1].length() > 10) {
                int index = summarycartcost2[i - 1].indexOf(" ");
                logger.info("index: " + index);
                summarycartcost2[i - 1] = summarycartcost2[i - 1].substring(0,
                        index);
            }
            if ((summarycartcost2[i-1]).trim().equals("Free") || (summarycartcost2[i-1]).trim().equals("Included") )
            {
                summarycartcost2[i-1]="0";
            }
        }
        int judge = -1;
        logger.info("rpage 4");
        for (int i = 0; i < summarycartoptions2; i++) {
            logger.info("Item Details : " + itemname2[i] + " - "
                    + itemcost2[i]);
            logger.info("Review Details : " + summarycartname2[i] + " - "
                    + summarycartcost2[i]);
            if (itemname2[i].equals(summarycartname2[i])
                    && itemcost2[i].equals(summarycartcost2[i])) {
                logger.info("rpage 4.2");
            } else {
                logger.info("rpage 4.3");
                judge = i;
                i = 100;
            }
        }
        logger.info("rpage 5: " + judge);
        if (judge >= 0)
            statusTracker(br,drive,
                    "Fail",
                    "Verify if the Internet Details under the Summary order section is in sync with the items chosen",
                    "Items are not proper. Item: " + judge
                            + " is incorrect. Expected: " + itemname2[judge]
                            + " " + itemcost2[judge] + " Actual: "
                            + summarycartname2[judge] + " "
                            + summarycartcost2[judge],
                    "Items should be the same as chosen");

        else
            statusTracker(br,drive,
                    "Pass",
                    "Verify if the Internet Details under the Summary order section is in sync with the items chosen",
                    "Items are as chosen from the cart",
                    "Items should be the same as chosen");
        logger.info("Internet Check Completed");
        
        for (int i = 0; i < summarycartoptions2; i++)
            OS_TotalMonthlyCharges += Double.parseDouble(summarycartcost2[i].replace("$", ""));
    }
    
    
    
    
    public void Package_OrderSummary_Phone_ChkMonthlyCharges(String br, WebDriver driver) 
    {
        logger.info("Phone Check");
        String summarycartname3[] = new String[10];
        String summarycartcost3[] = new String[10];
        int summarycartoptions3  = 0;
        for (int i = 0; i < carttotal2; i++) {

            if (isElementPresent(
                    ".//*[@title='Monthly Charges']/tbody/tr["+(i+9)+"]", drive)) {
                summarycartoptions3 ++;
                
            }
        }
        logger.info("summarycartoptions3  : "+summarycartoptions3 );
        for (int i = 1; i <= summarycartoptions3 ; i++) {
            summarycartname3[i - 1] = return_text(
                    ".//*[@title='Monthly Charges']/tbody/tr["+ (i+8) +"]/td[1]", drive);

            System.out
                    .println("name "
                            + return_text(
                                    ".//*[@title='Monthly Charges']/tbody/tr["+ (i+8) +"]/td[1]", drive));
            summarycartcost3[i - 1] = return_text(
                    ".//*[@title='Monthly Charges']/tbody/tr["+ (i+8) +"]/td[2]", drive);
            if (summarycartcost3[i - 1].length() > 10) {
                int index = summarycartcost3[i - 1].indexOf(" ");
                logger.info("index: " + index);
                summarycartcost3[i - 1] = summarycartcost3[i - 1].substring(0,
                        index);
            }
            if ((summarycartcost3[i-1]).trim().equals("Free") || (summarycartcost3[i-1]).trim().equals("Included") )
            {
                summarycartcost3[i-1]="0";
            }
        }
        int judge = -1;
        logger.info("rpage 4");
        for (int i = 0; i < summarycartoptions3 ; i++) {
            logger.info("Item Details : " + itemname3[i] + " - "
                    + itemcost3[i]);
            logger.info("Review Details : " + summarycartname3[i] + " - "
                    + summarycartcost3[i]);
            if (itemname3[i].equals(summarycartname3[i])
                    && itemcost3[i].equals(summarycartcost3[i])) {
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
                    "Verify if the Phone Details under the Summary order section is in sync with the items chosen",
                    "Items are not proper. Item: " + judge
                            + " is incorrect. Expected: " + itemname3[judge]
                            + " " + itemcost3[judge] + " Actual: "
                            + summarycartname3[judge] + " "
                            + summarycartcost3[judge],
                    "Items should be the same as chosen");

        else
            statusTracker(br,drive,
                    "Pass",
                    "Verify if the Phone Details under the Summary order section is in sync with the items chosen",
                    "Items are as chosen from the cart",
                    "Items should be the same as chosen");
        
        for (int i = 0; i < summarycartoptions3 ; i++)
            OS_TotalMonthlyCharges += Double.parseDouble(summarycartcost3[i].replace("$", ""));
        
        OS_TotalMonthlyCharges = OS_TotalMonthlyCharges + PackageAmount;
        logger.info("Phone Check Completed : "+RO_TotalMonthlyCharges);
        
        if (dateformat.format(OS_TotalMonthlyCharges).toString()
                .equals(return_text(
                        ".//*[@class='services-table']/tfoot/tr/td[2]",
                        drive).replace("$", ""))) {
            statusTracker(br,drive,
                    "Pass",
                    "In the Summary Order page, verify if the total cost is equal to the cost displayed in the Cart",
                    "The totals are the same", "The totals should be the same");
        } else {
            statusTracker(br,drive,
                    "Fail",
                    "In the Summary Order page, verify if the total cost is equal to the cost displayed in the Cart",
                    "The totals are not the same Actual: "
                            + return_text(
                                    ".//*[@class='services-table']/tfoot/tr/td[2]",
                                    drive) + " Expected: $" + dateformat.format(OS_TotalMonthlyCharges),
                    "The totals should be the same");
        }
    }
    public void Package_OrderSummary_ChkOneTimeCharges(String br, WebDriver drive) {
        System.out
                .println("Package_OrderSummary_ChkOneTimeCharges- Validating OneTime Charges : "
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
                logger.info("Summary One Time Charges - 4.2");
            } else {
                logger.info("Summary One Time Charges - 4.3");
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

    
    public void Package_I_will_use_my_modem(String br,WebDriver driver)
            throws InterruptedException {
        logger.info("Package - CLick on i will use my modem arrow");
        click_element("//*[@id='js-main-form']/div[2]/div[2]/header/ul/li[1]/a", driver);
        Thread.sleep(2000);
        click_element("//*[@id='js-main-form']/div[2]/div[2]/header/ul/li[1]/a", driver);
        logger.info("Click on Radio_I WILL USE MY MODEM");
        click_element("//*[@id='1-29PI']", driver);
        logger.info("Radio I WILL USE MY MODEM Clicked ");
    }
    
    public void Package_HomeWiFi_InternetModem(WebDriver driver) throws InterruptedException
    {
        logger.info("Package - CLick on HomeWiFi_InternetModem arrow");
        click_element(".//*[@id='js-main-form']/div[2]/div[1]/header/ul/li[1]/a", driver);
        Thread.sleep(2000);
        click_element(".//*[@id='js-main-form']/div[2]/div[1]/header/ul/li[1]/a", driver);
        logger.info("Click on Radio_HomeWiFi_InternetModem");
        click_element("//*[@id='1-29P7']", driver);
        logger.info("Radio HomeWiFi_InternetModem Clicked ");
    }
    
    public void Package_Validate_AlreadyIncludedServices(String br,String InternetServType, WebDriver drive)
    {
        if (InternetServType.equals("Home WiFi"))
        {
            
            Double Decimal_Amount = Double.parseDouble(return_text(".//*[@id='js-main-form']/div[2]/div[1]/header/ul/li[3]", drive).replace("per Month", "").replace("$", "").trim()) / 100;
            logger.info("Name : "+return_text(".//*[@id='js-main-form']/div[2]/div[1]/header/ul/li[2]/h3", drive).trim());
            logger.info("Cost : "+Decimal_Amount);
            logger.info("itemname2[1] : "+itemname2[1]);
            logger.info("itemcost2[1] : "+itemcost2[1].replace("$", "").trim());
            if(itemname2[1].equals(return_text(".//*[@id='js-main-form']/div[2]/div[1]/header/ul/li[2]/h3", drive).trim()) &&  itemcost2[1].replace("$", "").trim().equals(Decimal_Amount.toString()))
            {
                logger.info("Pass");
                statusTracker(br,drive,
                        "Pass",
                        "Verify the Included Internet Services Name & Cost pertaining to the Home WiFi and Internet Modem",
                        "Name & Cost of the Internet Service is same as in the Cart",
                        "Name & Cost of the Internet Service must be same as in the Cart");
                
                logger.info("Radio : "+drive.findElement(By.xpath(".//*[@id='1-29P7']")).isSelected());
                
                if(drive.findElement(By.xpath(".//*[@id='1-29P7']")).isSelected())
                    statusTracker(br,drive,
                            "Pass",
                            "Verify the Included Internet Services [Home WiFi and Internet Modem] is selected by default.",
                            "Internet Services [Home WiFi and Internet Modem] is selected by default.",
                            "Internet Services [Home WiFi and Internet Modem] must be selected by default.");
                else
                    statusTracker(br,drive,
                            "Pass",
                            "Verify the Included Internet Services [Home WiFi and Internet Modem] is selected by default.",
                            "Internet Services [Home WiFi and Internet Modem] is NOT selected by default.",
                            "Internet Services [Home WiFi and Internet Modem] must be selected by default.");
            }
            else
            {
                logger.info("Fail");
                statusTracker(br,drive,
                        "Fail",
                        "Verify the Included Internet Services Name & Cost pertaining to the Home WiFi and Internet Modem",
                        "Name & Cost of the Internet Service is NOT same as in the Cart",
                        "Name & Cost of the Internet Service must be same as in the Cart");
            }
        }
        else if (InternetServType.equals("Internet Modem"))
        {
            
        }
            
            
    }
    
// ----------------------------------------new common function added (4/4/14)--------------------------------------------------//
    
    
    

    public void Package_service_check(String br,WebDriver driver) throws InterruptedException, BiffException, IOException
    {
        
        File data_internet = new File(this.path3);
        WorkbookSettings ws_internet = new WorkbookSettings();
        ws_internet.setLocale(new Locale("er", "ER"));
        Workbook wb_internet = Workbook.getWorkbook(data_internet, ws_internet);
      
        Sheet sheet_internet =wb_internet.getSheet(0);
        int totalcount=0;
        String dummy="a";
        int ij=3;
        int cn=0;
        do
        {
            if(dummy !=null && dummy.length()>0 )
            {
               dummy=sheet_internet.getCell(0, ij).getContents();
               ij++;
               try{
               dummy=sheet_internet.getCell(0, ij).getContents();
               }
               catch(Exception e)
               {
                   cn=1;
               }
               totalcount++;
            }
            else
            {
                cn=1;
            }
        }while(cn==0);
        
        
        String Package_name_input[]=new String[totalcount];
        String Tv_plan_input[]=new String[totalcount];
        String Internet_plan_input[]=new String[totalcount];
        String Phone_Plan_input[]=new String[totalcount];
        String Starting_price_input[]=new String[totalcount];
        
        logger.info("Total count of packages in input sheet = "+totalcount);
        Thread.sleep(5000);
        int jk,count = 0;
        String Package_name[]=new String[300];
        String Package_cost[]=new String[300];
        String Tv_plan[]=new String[300];
        String Internet_plan[]=new String[300];
        String Phone_plan[]=new String[300];
        String Target_Tv;
        String Target_int;
        String Target_phone;
        if(Isavailable("//*[@id='content']/div[3]/div[3]/div[1]/div/div/div[2]/div/div[3]/div[1]/ul/li[5]/div/ul/li[1]/h5", driver))
                {        
                   Target_Tv=driver.findElement(By.xpath("//*[@id='content']/div[3]/div[3]/div[1]/div/div/div[2]/div/div[3]/div[1]/ul/li[5]/div/ul/li[1]/h5")).getText().replaceAll(" ", "");
                }
        else 
            Target_Tv="";
        if(Isavailable("//*[@id='content']/div[3]/div[3]/div[1]/div/div/div[2]/div/div[3]/div[1]/ul/li[5]/div/ul/li[2]/h5", driver))
          Target_int=driver.findElement(By.xpath("//*[@id='content']/div[3]/div[3]/div[1]/div/div/div[2]/div/div[3]/div[1]/ul/li[5]/div/ul/li[2]/h5")).getText().replaceAll(" ", "");
        else
            Target_int="";
    
        if(Isavailable("//*[@id='content']/div[3]/div[3]/div[1]/div/div/div[2]/div/div[3]/div[1]/ul/li[5]/div/ul/li[3]/h5", driver))                    
             Target_phone=driver.findElement(By.xpath("//*[@id='content']/div[3]/div[3]/div[1]/div/div/div[2]/div/div[3]/div[1]/ul/li[5]/div/ul/li[3]/h5")).getText().replaceAll(" ", "");
        else
            Target_phone="";
        String cost_target=driver.findElement(By.xpath("//*[@id='content']/div[3]/div[3]/div[1]/div/div/div[2]/div/div[3]/div[1]/ul/li[5]/div/div[2]/div")).getText();
        
        
        
        
        List<WebElement> myli4 = driver.findElements(By.xpath("//*[@class='packages-list']/li"));
        int total = myli4.size();
        logger.info("No of packages are = " + total);
        int i;
        
            
                
                
                
                for(jk=1,i=0;i<totalcount;i++,jk++)
                {
                count=jk+1;
                
                
                logger.info("*****************");
                logger.info("Count = " + count);
                logger.info("*****************");
                
                    
if(jk==2 || jk==5|| jk==8|| jk==11||jk==14)
   {
    if(Isavailable(".//*[@id='content']/div[3]/div[3]/div[1]/div/div/div[2]/div/div[3]/div[1]/ul/li["+(jk+4)+"]/div/div[1]", driver))
        
        
                {
    if(Isavailable(".//*[@id='content']/div[3]/div[3]/div[1]/div/div/div[2]/div/div[3]/div[1]/ul/li["+(jk+4)+"]/div/ul/li[1]/h5", driver) && Isavailable(".//*[@id='content']/div[3]/div[3]/div[1]/div/div/div[2]/div/div[3]/div[1]/ul/li["+(jk+4)+"]/div/ul/li[2]/h5", driver))
                {
        
        Package_name[jk] = driver.findElement(By.xpath("html/body/section/div[3]/div[3]/div[1]/div/div/div[2]/div/div[3]/div[1]/ul/li["+(jk+4)+"]/div/div[1]")).getText();
        
        statusTracker(br,driver," ", "Package Name", Package_name[jk] , "");
        Package_cost[jk] = driver.findElement(By.xpath("html/body/section/div[3]/div[3]/div[1]/div/div/div[2]/div/div[3]/div[1]/ul/li["+(jk+4)+"]/div/div[2]/div")).getText();
        
        
    //    int index_start = Package_cost[jk].indexOf("$");
    //    int index_end = Package_cost[jk].indexOf(" ");
    //    String start_amount =Package_cost[jk].substring(index_start, index_end);
    //    Double Decimal_Amount = Double.parseDouble(start_amount
    //            .replace("$", "")) / 100;
        
        
        statusTracker(br,driver," ", "Package Cost", Package_cost[jk] , "");
        
        Tv_plan[jk]=driver.findElement(By.xpath(".//*[@id='content']/div[3]/div[3]/div[1]/div/div/div[2]/div/div[3]/div[1]/ul/li["+(jk+4)+"]/div/ul/li[1]/h5")).getText();
        statusTracker(br,driver," ", "TV Plan",Tv_plan[jk], "");
                                    
        Internet_plan[jk]=driver.findElement(By.xpath(".//*[@id='content']/div[3]/div[3]/div[1]/div/div/div[2]/div/div[3]/div[1]/ul/li["+(jk+4)+"]/div/ul/li[2]/h5")).getText();
        
        statusTracker(br,driver," ", "Internet Plan", Internet_plan[jk], "");
        logger.info(" Package cost is:" + Package_cost[jk]);
        logger.info(" Package name is:" + Package_name[jk]);
        logger.info(" TV plan is:" + Tv_plan[jk]);
        logger.info(" Internet Plan is:" +Internet_plan[jk]);
        
        Package_name_input[i]=sheet_internet.getCell(0, (i+3)).getContents();
        Tv_plan_input[i]=sheet_internet.getCell(1, (i+3)).getContents();
        Internet_plan_input[i]=sheet_internet.getCell(2, (i+3)).getContents();
        
        logger.info("Package_name_input:  "+sheet_internet.getCell(0, (i+3)).getContents());
        logger.info("Tv_name:  "+sheet_internet.getCell(1, (i+3)).getContents());
        logger.info("Internet_plan:  "+sheet_internet.getCell(2, (i+3)).getContents());
        
        if(Isavailable(".//*[@id='content']/div[3]/div[3]/div[1]/div/div/div[2]/div/div[3]/div[1]/ul/li["+(jk+4)+"]/div/ul/li[3]/h5", driver))
        {
                
                Phone_plan[jk]=driver.findElement(By.xpath(".//*[@id='content']/div[3]/div[3]/div[1]/div/div/div[2]/div/div[3]/div[1]/ul/li["+(jk+4)+"]/div/ul/li[3]/h5")).getText();
                statusTracker(br,driver," ", "Phone Plan", Phone_plan[jk], "");
                logger.info(" Phone plan is:" + Phone_plan[jk]);
                Phone_Plan_input[i]=sheet_internet.getCell(3, (i+3)).getContents();
                Starting_price_input[i]=sheet_internet.getCell(4, (i+3)).getContents();
            
            
            
                logger.info("Phone_Plan:  "+sheet_internet.getCell(3, (i+3)).getContents());
                logger.info("Starting_price:  "+sheet_internet.getCell(4, (i+3)).getContents());
         
           
                if(jk>1 && cost_target.replaceAll(" ", "").equals(Package_cost[jk].replaceAll(" ", ""))&&Tv_plan[jk].replaceAll(" ", "").equals(Target_Tv)&&Internet_plan[jk].replaceAll(" ", "").equals(Target_int)&&Phone_plan[jk].replaceAll(" ", "").equals(Target_phone)) 
                    {
                        count=count-2;
                        logger.info("Count=" +count);
                        statusTracker(br,driver,"", "No Of Packages","Count=" +count, "");
                        break;
                    }
                    else
                     {
                     if(Tv_plan[jk].replaceAll(" ", "").equalsIgnoreCase(Tv_plan_input[i].replaceAll(" ", "")) && Internet_plan[jk].toString().replaceAll(" ","").equalsIgnoreCase(Internet_plan_input[i].toString().replaceAll(" ","").trim()) && Phone_plan[jk].toString().replaceAll(" ","").equalsIgnoreCase(Phone_Plan_input[i].toString().replaceAll(" ","").trim())|| Tv_plan[jk].replaceAll(" ", "").equalsIgnoreCase("") && Internet_plan[jk].equalsIgnoreCase(""))
                    {
                    logger.info("Pass");
                    statusTracker(br,driver,"Pass","Verify if the plan, Package name is similar to the details given","The plan details are as expected","The details should be as expected");
                    }
                    else
                    {logger.info("Fail");
                    statusTracker(br,driver,"Fail","Verify if the plan, Package name is similar to the details given","The plan details are not as expected","The details should be as expected");
                    }
                }}
                else
                {
                     if(jk>1 && cost_target.replaceAll(" ", "").equals(Package_cost[jk].replaceAll(" ", ""))&&Tv_plan[jk].replaceAll(" ", "").equals(Target_Tv)&&Internet_plan[jk].replaceAll(" ", "").equals(Target_int)) 
                        {
                            count=count-2;
                            logger.info("Count=" +count);
                            statusTracker(br,driver,"", "No Of Packages","Count=" +count, "");
                            break;
                        }
                        else
                         {
                         if(Tv_plan[jk].replaceAll(" ", "").equalsIgnoreCase(Tv_plan_input[i].replaceAll(" ", "")) && Internet_plan[jk].toString().replaceAll(" ","").equalsIgnoreCase(Internet_plan_input[i].toString().replaceAll(" ","").trim()) || Tv_plan[jk].replaceAll(" ", "").equalsIgnoreCase("") && Internet_plan[jk].equalsIgnoreCase(""))
                        {
                        logger.info("Pass");
                        statusTracker(br,driver,"Pass","Verify if the plan, Package name is similar to the details given","The plan details are as expected","The details should be as expected");
                        }
                        else
                        {logger.info("Fail");
                        statusTracker(br,driver,"Fail","Verify if the plan, Package name is similar to the details given","The plan details are not as expected","The details should be as expected");
                        }    
                }}}

                else
                    continue;
                }
    
    click_element("html/body/section/div[3]/div[3]/div[1]/div/div/div[2]/div/a[2]", driver);
    Thread.sleep(8000);
            
   }
                    
      else    
      {
          if(Isavailable(".//*[@id='content']/div[3]/div[3]/div[1]/div/div/div[2]/div/div[3]/div[1]/ul/li["+(jk+4)+"]/div/div[1]", driver))
          {
          if(Isavailable(".//*[@id='content']/div[3]/div[3]/div[1]/div/div/div[2]/div/div[3]/div[1]/ul/li["+(jk+4)+"]/div/ul/li[1]/h5", driver) && Isavailable(".//*[@id='content']/div[3]/div[3]/div[1]/div/div/div[2]/div/div[3]/div[1]/ul/li["+(jk+4)+"]/div/ul/li[2]/h5", driver))
            {
                     Package_name[jk] = driver.findElement(By.xpath("html/body/section/div[3]/div[3]/div[1]/div/div/div[2]/div/div[3]/div[1]/ul/li["+(jk+4)+"]/div/div[1]")).getText();
                    
                    statusTracker(br,driver," ", "Package Name", Package_name[jk] , "");
                    Package_cost[jk] = driver.findElement(By.xpath("html/body/section/div[3]/div[3]/div[1]/div/div/div[2]/div/div[3]/div[1]/ul/li["+(jk+4)+"]/div/div[2]/div")).getText();
                    
                    
                //    int index_start = Package_cost[jk].indexOf("$");
                //    int index_end = Package_cost[jk].indexOf(" ");
                //    String start_amount =Package_cost[jk].substring(index_start, index_end);
                //    Double Decimal_Amount = Double.parseDouble(start_amount
                //            .replace("$", "")) / 100;
                    
                    
                    statusTracker(br,driver," ", "Package Cost", Package_cost[jk] , "");
                    
                    Tv_plan[jk]=driver.findElement(By.xpath(".//*[@id='content']/div[3]/div[3]/div[1]/div/div/div[2]/div/div[3]/div[1]/ul/li["+(jk+4)+"]/div/ul/li[1]/h5")).getText();
                    statusTracker(br,driver," ", "TV Plan",Tv_plan[jk], "");
                                                
                    Internet_plan[jk]=driver.findElement(By.xpath(".//*[@id='content']/div[3]/div[3]/div[1]/div/div/div[2]/div/div[3]/div[1]/ul/li["+(jk+4)+"]/div/ul/li[2]/h5")).getText();
                    
                    statusTracker(br,driver," ", "Internet Plan", Internet_plan[jk], "");
                    logger.info(" Package cost is:" + Package_cost[jk]);
                    logger.info(" Package name is:" + Package_name[jk]);
                    logger.info(" TV plan is:" + Tv_plan[jk]);
                    logger.info(" Internet Plan is:" +Internet_plan[jk]);
                    
                    Package_name_input[i]=sheet_internet.getCell(0, (i+3)).getContents();
                    Tv_plan_input[i]=sheet_internet.getCell(1, (i+3)).getContents();
                    Internet_plan_input[i]=sheet_internet.getCell(2, (i+3)).getContents();
                    
                    logger.info("Package_name_input:  "+sheet_internet.getCell(0, (i+3)).getContents());
                    logger.info("Tv_name:  "+sheet_internet.getCell(1, (i+3)).getContents());
                    logger.info("Internet_plan:  "+sheet_internet.getCell(2, (i+3)).getContents());
                    
                    if(Isavailable(".//*[@id='content']/div[3]/div[3]/div[1]/div/div/div[2]/div/div[3]/div[1]/ul/li["+(jk+4)+"]/div/ul/li[3]/h5", driver))
                    {
                            //String Target_phone=driver.findElement(By.xpath("//*[@id='content']/div[3]/div[3]/div[1]/div/div/div[2]/div/div[3]/div[1]/ul/li[5]/div/ul/li[3]/h5")).getText().replaceAll(" ", "");
                            Phone_plan[jk]=driver.findElement(By.xpath(".//*[@id='content']/div[3]/div[3]/div[1]/div/div/div[2]/div/div[3]/div[1]/ul/li["+(jk+4)+"]/div/ul/li[3]/h5")).getText();
                            statusTracker(br,driver," ", "Phone Plan", Phone_plan[jk], "");
                            logger.info(" Phone plan is:" + Phone_plan[jk]);
                            Phone_Plan_input[i]=sheet_internet.getCell(3, (i+3)).getContents();
                            Starting_price_input[i]=sheet_internet.getCell(4, (i+3)).getContents();
                        
                        
                        
                            logger.info("Phone_Plan:  "+sheet_internet.getCell(3, (i+3)).getContents());
                            logger.info("Starting_price:  "+sheet_internet.getCell(4, (i+3)).getContents());
                     
                       
                            if(jk>1 && cost_target.replaceAll(" ", "").equals(Package_cost[jk].replaceAll(" ", ""))&&Tv_plan[jk].replaceAll(" ", "").equals(Target_Tv)&&Internet_plan[jk].replaceAll(" ", "").equals(Target_int)&&Phone_plan[jk].replaceAll(" ", "").equals(Target_phone)) 
                                {
                                    count=count-2;
                                    logger.info("final Count= "+count);
                                    statusTracker(br,driver,"", "No Of Packages","Count=" +count, "");
                                    break;
                                }
                                else
                                 {
                                 if(Tv_plan[jk].replaceAll(" ", "").equalsIgnoreCase(Tv_plan_input[i].replaceAll(" ", "")) && Internet_plan[jk].toString().replaceAll(" ","").equalsIgnoreCase(Internet_plan_input[i].toString().replaceAll(" ","").trim()) && Phone_plan[jk].toString().replaceAll(" ","").equalsIgnoreCase(Phone_Plan_input[i].toString().replaceAll(" ","").trim()))
                                {
                                logger.info("Pass");
                                statusTracker(br,driver,"Pass","Verify if the plan, Package name is similar to the details given","The plan details are as expected","The details should be as expected");
                                }
                                else
                                {logger.info("Fail");
                                statusTracker(br,driver,"Fail","Verify if the plan, Package name is similar to the details given","The plan details are not as expected","The details should be as expected");
                                }
                            }}
                            else
                            {
                                 if(jk>1 && cost_target.replaceAll(" ", "").equals(Package_cost[jk].replaceAll(" ", ""))&&Tv_plan[jk].replaceAll(" ", "").equals(Target_Tv)&&Internet_plan[jk].replaceAll(" ", "").equals(Target_int)) 
                                    {
                                        count=count-2;
                                        logger.info("Final Count=" +count);
                                        statusTracker(br,driver,"", "No Of Packages","Count=" +count, "");
                                        break;
                                    }
                                    else
                                     {
                                    if(Tv_plan[jk].replaceAll(" ", "").equalsIgnoreCase(Tv_plan_input[i].replaceAll(" ", "")) && Internet_plan[jk].toString().replaceAll(" ","").equalsIgnoreCase(Internet_plan_input[i].toString().replaceAll(" ","").trim()) || Tv_plan[jk].replaceAll(" ", "").equalsIgnoreCase("") && Internet_plan[jk].equalsIgnoreCase(""))
                                    {
                                    logger.info("Pass");
                                    statusTracker(br,driver,"Pass","Verify if the plan, Package name is similar to the details given","The plan details are as expected","The details should be as expected");
                                    }
                                    else
                                    {logger.info("Fail");
                                    statusTracker(br,driver,"Fail","Verify if the plan, Package name is similar to the details given","The plan details are not as expected","The details should be as expected");
                                    }    
                            }}}
            
                            else
                                continue;
                          }
                          }
                }
                
                
                //Nithin RO OS module

    
    }

    public void transfer_number_2_MultipleLOB_Combination(String br,WebDriver driver)
            throws InterruptedException {
        // Click Feature options

        click_PrivateListening(driver);
        Thread.sleep(8000);
        //config_page_Cart_result_updater_TV_Phone(driver);
        page_Cart_One_Time_charge_updater_1(br,driver);
        //Thread.sleep(2000);

        click_VoiceMail(driver);
        Thread.sleep(2000);
        //config_page_Cart_result_updater_TV_Phone(driver);
        //page_Cart_One_Time_charge_updater_1(driver);
        Thread.sleep(2000);

        click_GlobalPenny(driver);
        Thread.sleep(8000);
        //config_page_Cart_result_updater_TV_Phone(driver);
        //page_Cart_One_Time_charge_updater_1(driver);
        Thread.sleep(3000);

        // click International plan option
        click_International(driver);
        Thread.sleep(2000);
        //config_page_Cart_result_updater_TV_Phone(driver);
        //page_Cart_One_Time_charge_updater_1(driver);
        Thread.sleep(3000);

        // Compare Plan Page check
        click_element("//*[@class='modal modalGeneric js-modal-initialized']", driver);
        Thread.sleep(10000);

        String modal_title = driver.findElement(
                By.xpath("//*[@class='modal-title']")).getText();
        if (modal_title.equalsIgnoreCase("International Calling Rates")) {
   statusTracker(br,driver,"Pass", "Click on Compare Plan link",
                    "Compare Plan link is clicked",
                    "Compare plan link should be clicked");
            logger.info("tHREE" + "");
        } else {
            statusTracker(br,driver,"Fail", "Click on Compare Plan link",
                    "Compare Plan link is not clicked",
                    "Compare plan link should be clicked");
        }

        click_element("//*[@class='modal-button-close']", driver);
        Thread.sleep(5000);

        String Act_config = driver
                .findElement(
                        By.xpath("//*[@class='text parbase sectionHeader twc-plain-text']"))
                .getText();
        if (Act_config
                .equalsIgnoreCase("Select Optional Features & Calling Plans")) {
            statusTracker(br,driver,"Pass", "Click on close button of Compare Plan",
                    "Compare Plan gets closed",
                    "Compare plan should get closed");
        } else {
            statusTracker(br,driver,"Fail", "Click on close button of Compare Plan",
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
            statusTracker(br,driver,"Pass",
                    "Transfer number general form gets displayed",
                    "Transfer number general form is displayed",
                    "Transfer number general form should be displayed");
        } else {
            statusTracker(br,driver,"Fail",
                    "Transfer number general form gets displayed",
                    "Transfer number general form is not displayed",
                    "Transfer number general form should be displayed");
        }

        logger.info("started");

        // for currentProvider
        Select_DropDown(driver, ".//*[@id='currentProvider']", "Blue Casa");
		statusTracker(br,driver," ", "Select Current provider", "Selected", "");
		  
		Select_DropDown(driver, ".//*[@id='current-provider-state']", "Florida");
		statusTracker(br,driver," ", "Select Current provider State", "Selected", "");
          

        // For current-provider-state
        driver.findElement(By.xpath("//*[@id='phone-number']")).sendKeys(
                "123-876-7678");
        Thread.sleep(2000);
         field_statustracker(br,"//*[@id='phone-number']", "Enter Phone Number",
                "Phone number is Entered", driver);
        Thread.sleep(2000);
        driver.findElement(By.id("account-number")).sendKeys("23456745");
        Thread.sleep(2000);
         field_statustracker(br,"//*[@id='account-number']",
                "Enter Account Number", "Account Number is Entered", driver);
        Thread.sleep(2000);
        driver.findElement(By.id("account-name")).sendKeys("Dani");
         field_statustracker(br,"//*[@id='account-name']", "Account Name",
                "Account Name is Entered", driver);
        Thread.sleep(2000);
        driver.findElement(By.id("security-code")).sendKeys("3433");
         field_statustracker(br,"//*[@id='security-code']", "Enter Security Code",
                "Security Code is Entered", driver);
        Thread.sleep(2000);
        driver.findElement(By.id("address")).sendKeys("4th cross");
         field_statustracker(br,"//*[@id='address']", "Enter Address",
                "Address is Entered", driver);
        Thread.sleep(2000);
        driver.findElement(By.id("apt-type")).sendKeys("#10");
         field_statustracker(br,"//*[@id='apt-type']", "Enter apt type",
                "Apt Type is Entered", driver);
        Thread.sleep(2000);
        driver.findElement(By.id("city")).sendKeys("nyc");
         field_statustracker(br,"//*[@id='city']", "Enter City", "City is Entered",
                driver);
        Thread.sleep(2000);
        driver.findElement(By.id("zip-code")).sendKeys("23456");
         field_statustracker(br,"//*[@id='zip-code']", "Enter Zip-Code",
                "Zip Code is Entered", driver);
        Thread.sleep(2000);
        

        Select_DropDown(driver, ".//*[@id='current-provider-state-billing']", "Idaho");
		statusTracker(br,driver," ", "Select Current provider state", "Selected", "");
		Thread.sleep(5000);
		  

        driver.findElement(By.cssSelector("form > div.continue > a")).click();
        Thread.sleep(5000);
        logger.info("Continue clicked");
        
        
      //select drop down 
		  click_element("//*[@id='tpv-choose-TWC']", driver);
		  driver.findElement(By.xpath(".//*[@id='full-name1']")).sendKeys("Account");
		  statusTracker(br,driver," ", "First Name", "Entered", "");
		  Thread.sleep(2000);
		  Select_DropDown(driver, ".//*[@id='birth-month']", "March");
		  
		  statusTracker(br,driver," ", "Birth-Month", "Selected", "");
		  Select_DropDown(driver, ".//*[@id='birth-date']", "11");
		  statusTracker(br,driver," ", "Birth-Day", "Selected", "");
		  Select_DropDown(driver, ".//*[@id='birth-year']", "1946");
		  statusTracker(br,driver," ", "Birth-Year", "Selected", "");
		  Thread.sleep(2000);
		  driver.findElement(By.xpath(".//*[@id='full-name2']")).sendKeys("Account");
		  statusTracker(br,driver," ", "First full name", "Entered", "");
		  
		  click_element(".//*[@class='arrow']", driver);
		  Thread.sleep(10000);

        logger.info("review page");
    }
    
    
    
    public void config_page_Cart_result_updater_TV_Phone(String br,WebDriver driver)
            throws InterruptedException {
        // Validation of status TV LOB
        logger.info("TV Start.....");
        click_element(".//*[@class='charges']//div[1]/header/ul/li[1]/a",
                driver);
        logger.info("Manju function is called");
        int jk;
        logger.info("line 1");
        // String itemname[]=new String[15];
        logger.info("line 2");

        logger.info("line 3");
        List<WebElement> myli4 = driver
                .findElements(By
                        .xpath("//*[@class='charges']/div[1]/section/div/table/tbody/tr/td[1]"));
        logger.info("line 4");
        carttotal = myli4.size();
        logger.info("line 5");
        logger.info("cartaotl is " + carttotal);
        for (jk = 0; jk < carttotal; jk++) {

            itemname1[jk] = driver
                    .findElement(
                            By.xpath("//*[@class='charges']/div[1]/section/div/table/tbody/tr["
                                    + (jk + 1) + "]/td[1]")).getText();
            itemcost1[jk] = driver
                    .findElement(
                            By.xpath("//*[@class='charges']/div[1]/section/div/table/tbody/tr["
                                    + (jk + 1) + "]/td[2]")).getText();
            logger.info(" eqipment cost is:" + itemcost1[jk]);
            logger.info(" eqipment name is:" + itemname1[jk]);
            statusTracker(br,driver," ", "cart details", "eqipment name is: "
                    + itemname1[jk] + " and item cost is: " + itemcost1[jk],
                    "selected eqipment should be added to cart");
            if ((itemcost1[jk]).trim().equals("Free")
                    || (itemcost1[jk]).trim().equals("Included")) {
                itemcost1[jk] = "0";
            }

        }

        int equipandtotal = 0;
        for (int m = 0; m < carttotal; m++) {

            String temp = itemcost1[m].replaceAll("[^0-9]", "");
            equipandtotal += Integer.parseInt(temp);

        }

        String equipandtotalstring = String.valueOf(equipandtotal);
        if (!return_text(".//*[@class='charges']/div[1]/header/ul/li[3]",
                driver).equals("Included")) {
            equipandtotalstring = equipandtotalstring.substring(0,
                    equipandtotalstring.length() - 2)
                    + "."
                    + equipandtotalstring.substring(equipandtotalstring
                            .length() - 2);
        }
        equipandtotalstring = "$" + equipandtotalstring;
        logger.info("equipandtotalstring is " + equipandtotalstring);

        if (driver.findElement(
                By.xpath(".//*[@class='charges']/div[1]/header/ul/li[3]"))
                .isDisplayed()) {
            if (return_text(".//*[@class='charges']/div[1]/header/ul/li[3]",
                    driver).equals("Included")) {

                if (equipandtotalstring.equals("$0")) {

                    statusTracker(br,driver,
                            "Pass",
                            "Verify toatl price is displayed as incuded",
                            "The euipment added to the cart are updated and included in package",
                            "The items added to the cart  total");

                }

            }

            if (equipandtotalstring.equals(driver.findElement(
                    By.xpath("//*[@class='charges']/div[1]/header/ul/li[3]"))
                    .getText())) {
                statusTracker(br,driver,
                        "Pass",
                        "Verify if the Eqipment added to the cart adds up to the total",
                        "The euipment added to the cart adds up to the total",
                        "The items added to the cart  total");
            } else {
                // statusTracker("Fail","Verify if the items added to the cart adds up to the total","The items added to the cart does not add up to the total. Actual: "+driver.findElement(By.xpath("//html/body/section/div[2]/div[2]/div/div/div/div/div/div[2]/section/div/table/tbody/tr/td[2]")).getText()
                // +" Expected: "+equipandtotalstring,"The items added to the cart does not add up to the total");
            }
        }

        Thread.sleep(4000);
        logger.info("TV End.....");

        // validation of phone lob
        logger.info("Phone Start.....");
        // click_element(".//*[@class='charges']/div[3]/header/ul/li[1]/a",driver);

        List<WebElement> myli6 = driver
                .findElements(By
                        .xpath("//*[@class='charges']/div[2]/section/div/table/tbody/tr/td[1]"));
        logger.info("line 4");
        carttotal2 = myli6.size();
        logger.info("line 5");
        logger.info("cartaot2 is " + carttotal2);
        itemname3[jk] = "";
        itemcost3[jk] = "";
        for (jk = 0; jk < carttotal2; jk++) {

            itemname3[jk] = driver
                    .findElement(
                            By.xpath("//*[@class='charges']/div[2]/section/div/table/tbody/tr["
                                    + (jk + 1) + "]/td[1]")).getText();
            itemcost3[jk] = driver
                    .findElement(
                            By.xpath("//*[@class='charges']/div[2]/section/div/table/tbody/tr["
                                    + (jk + 1) + "]/td[2]")).getText();
            logger.info(" eqipment cost is:" + itemcost3[jk]);
            logger.info(" eqipment name is:" + itemname3[jk]);
            statusTracker(br,driver," ", "cart details", "eqipment name is: "
                    + itemname3[jk] + " and item cost is: " + itemcost3[jk],
                    "selected eqipment should be added to cart");
            if ((itemcost3[jk]).trim().equals("Free")
                    || (itemcost3[jk]).trim().equals("Included")) {
                itemcost3[jk] = "0";
            }

        }
        logger.info("section1");

        int equipandtotal2 = 0;
        for (int m = 0; m < carttotal2; m++) {

            String temp = itemcost3[m].replaceAll("[^0-9]", "");
            equipandtotal2 += Integer.parseInt(temp);

        }

        String equipandtotalstring2 = String.valueOf(equipandtotal2);
        logger.info("section2");
        if (!return_text(".//*[@class='charges']/div[2]/header/ul/li[3]",
                driver).equals("Included")) {
            equipandtotalstring2 = equipandtotalstring2.substring(0,
                    equipandtotalstring2.length() - 2)
                    + "."
                    + equipandtotalstring2.substring(equipandtotalstring2
                            .length() - 2);
        }
        logger.info("section3");
        equipandtotalstring2 = "$" + equipandtotalstring2;
        logger.info("section4");
        logger.info("equipandtotalstring2 is " + equipandtotalstring2);

        if ((driver.findElement(By
                .xpath(".//*[@class='charges']/div[2]/header/ul/li[3]"))
                .isDisplayed()))

        {
            if (return_text(".//*[@class='charges']/div[2]/header/ul/li[3]",
                    driver).equals("Included")) {
                if (equipandtotalstring2.equals("$0")) {

                    statusTracker(br,driver,
                            "Pass",
                            "Verify toatl price is displayed as incuded",
                            "The euipment added to the cart are updated and included in package",
                            "The items added to the cart  total");

                }
            } else {
                if (equipandtotalstring2
                        .equals(driver
                                .findElement(
                                        By.xpath(".//*[@class='charges']/div[2]/header/ul/li[3]"))
                                .getText())) {
                    statusTracker(br,driver,
                            "Pass",
                            "Verify if the Eqipment added to the cart adds up to the total",
                            "The euipment added to the cart adds up to the total",
                            "The items added to the cart  total");
                } else {
                    // statusTracker(br,driver,"Fail","Verify if the items added to the cart adds up to the total","The items added to the cart does not add up to the total. Actual: "+driver.findElement(By.xpath("//html/body/section/div[2]/div[2]/div/div/div/div/div/div[2]/section/div/table/tbody/tr/td[2]")).getText()
                    // +" Expected: "+equipandtotalstring,"The items added to the cart does not add up to the total");
                }
            }

        }

        Thread.sleep(4000);
        logger.info("Phone Start.....");
    }
    
    
    public void ReviewOrder_TV_ChkMonthlyCharges(String br, WebDriver drive) {
    	 logger.info("TV Check");
         String reviewcartname1[] = new String[10];
         String reviewcartcost1[] = new String[10];
         int reviewcartoptions1 = 0;
         for (int i = 0; i < carttotal; i++) {

             if (isElementPresent(".//*[@title='Monthly Charges']/tbody/tr["
                     + (i + 2) + "]", drive)) {
                 reviewcartoptions1++;

             }
         }
         logger.info("reviewcartoptions1 : " + reviewcartoptions1);
         for (int i = 1; i <= reviewcartoptions1; i++) {
             reviewcartname1[i - 1] = return_text(
                     ".//*[@title='Monthly Charges']/tbody/tr[" + (i + 1)
                             + "]/td[1]", drive);

             logger.info("name "
                     + return_text(".//*[@title='Monthly Charges']/tbody/tr["
                             + (i + 1) + "]/td[1]", drive));
             reviewcartcost1[i - 1] = return_text(
                     ".//*[@title='Monthly Charges']/tbody/tr[" + (i + 1)
                             + "]/td[2]", drive);
             if (reviewcartcost1[i - 1].length() > 10) {
                 int index = reviewcartcost1[i - 1].indexOf(" ");
                 logger.info("index: " + index);
                 reviewcartcost1[i - 1] = reviewcartcost1[i - 1].substring(0,
                         index);
             }
             if ((reviewcartcost1[i - 1]).trim().equals("Free")
                     || (reviewcartcost1[i - 1]).trim().equals("Included")) {
                 reviewcartcost1[i - 1] = "0";
             }
         }
         int judge = -1;
         logger.info("rpage 4");
         for (int i = 0; i < reviewcartoptions1; i++) {
             logger.info("Item Details : " + itemname1[i] + " - "
                     + itemcost1[i]);
             logger.info("Review Details : " + reviewcartname1[i] + " - "
                     + reviewcartcost1[i]);
             if (itemname1[i].equals(reviewcartname1[i])
                     && itemcost1[i].equals(reviewcartcost1[i])) {
                 logger.info("rpage 4.2");
             } else {
                 logger.info("rpage 4.3");
                 judge = i;
                 i = 100;
             }

         }
         logger.info("rpage 5: " + judge);
         if (judge >= 0) {
             statusTracker(br,drive,
                     "Fail",
                     "Verify if the TV Details under the review order section is in sync with the items chosen",
                     "Items are not proper. Item: " + judge
                             + " is incorrect. Expected: " + itemname1[judge]
                             + " " + itemcost1[judge] + " Actual: "
                             + reviewcartname1[judge] + " "
                             + reviewcartcost1[judge],
                     "Items should be the same as chosen");
         } else
             statusTracker(br,drive,
                     "Pass",
                     "Verify if the TV Details under the review order section is in sync with the items chosen",
                     "Items are as chosen from the cart",
                     "Items should be the same as chosen");

         logger.info("TV Check Completed");

         for (int i = 0; i < reviewcartoptions1; i++)
             RO_TotalMonthlyCharges += Double.parseDouble(reviewcartcost1[i]
                     .replace("$", ""));

     }

     
     public void ReviewOrder_Phone_ChkMonthlyCharges(String br, WebDriver drive) {
         logger.info("Phone Check");
         String reviewcartname3[] = new String[10];
         String reviewcartcost3[] = new String[10];
         int reviewcartoptions3 = 0;
         for (int i = 0; i < carttotal2; i++) {

             if (isElementPresent(".//*[@title='Monthly Charges']/tbody/tr["
                     + (i + 4) + "]", drive)) {
                 reviewcartoptions3++;

             }
         }
         logger.info("reviewcartoptions3 : " + reviewcartoptions3);
         for (int i = 1; i <= reviewcartoptions3; i++) {
             reviewcartname3[i - 1] = return_text(
                     ".//*[@title='Monthly Charges']/tbody/tr[" + (i + 3)
                             + "]/td[1]", drive);

             logger.info("name "
                     + return_text(".//*[@title='Monthly Charges']/tbody/tr["
                             + (i + 3) + "]/td[1]", drive));
             reviewcartcost3[i - 1] = return_text(
                     ".//*[@title='Monthly Charges']/tbody/tr[" + (i + 3)
                             + "]/td[2]", drive);
             if (reviewcartcost3[i - 1].length() > 10) {
                 int index = reviewcartcost3[i - 1].indexOf(" ");
                 logger.info("index: " + index);
                 reviewcartcost3[i - 1] = reviewcartcost3[i - 1].substring(0,
                         index);
             }
             if ((reviewcartcost3[i - 1]).trim().equals("Free")
                     || (reviewcartcost3[i - 1]).trim().equals("Included")) {
                 reviewcartcost3[i - 1] = "0";
             }
         }
         int judge = -1;
         logger.info("rpage 4");
         for (int i = 0; i < reviewcartoptions3; i++) {
             logger.info("Item Details : " + itemname3[i] + " - "
                     + itemcost3[i]);
             logger.info("Review Details : " + reviewcartname3[i] + " - "
                     + reviewcartcost3[i]);
             if (itemname3[i].equals(reviewcartname3[i])
                     && itemcost3[i].equals(reviewcartcost3[i])) {
                 logger.info("rpage 4.2");
             } else {
                 logger.info("rpage 4.3");
                 judge = i;
                 i = 100;
             }

         }
         logger.info("rpage 5: " + judge);
         if (judge >= 0)
             statusTracker(br,drive,
                     "Fail",
                     "Verify if the Phone Details under the review order section is in sync with the items chosen",
                     "Items are not proper. Item: " + judge
                             + " is incorrect. Expected: " + itemname3[judge]
                             + " " + itemcost3[judge] + " Actual: "
                             + reviewcartname3[judge] + " "
                             + reviewcartcost3[judge],
                     "Items should be the same as chosen");

         else
             statusTracker(br,drive,
                     "Pass",
                     "Verify if the Phone Details under the review order section is in sync with the items chosen",
                     "Items are as chosen from the cart",
                     "Items should be the same as chosen");

         for (int i = 0; i < reviewcartoptions3; i++)
             RO_TotalMonthlyCharges += Double.parseDouble(reviewcartcost3[i]
                     .replace("$", ""));

         RO_TotalMonthlyCharges = RO_TotalMonthlyCharges + PackageAmount;
         logger.info("Phone Check Completed : " + RO_TotalMonthlyCharges);

         if (df
                 .format(RO_TotalMonthlyCharges)
                 .toString()
                 .equals(return_text(
                         "//*[@id='content']/div[3]/div[2]/div[2]/div/div/div/div/div[1]/table/tfoot/tr/td[2]",
                         drive).replace("$", ""))) {
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
                                     drive) + " Expected: $"
                             + dateformat.format(RO_TotalMonthlyCharges),
                     "The totals should be the same");
         }
     }
     
     
    public void Validate_Visit_Options(String br, WebDriver drive) throws InterruptedException {
        if (Isavailable(".//a[@data-lob='TV']", drive))
            statusTracker(br,drive,"Pass",
                    "Edit link should be displayed next to the TV LOB",
                    "Edit Link is displayed", "Edit link should be present");
        else
            statusTracker(br,drive,"Fail",
                    "Edit link should be displayed next to the TV LOB",
                    "Edit Link is NOT displayed", "Edit link should be present");

        if (Isavailable(".//a[@data-lob='Phone']", drive))
            statusTracker(br,drive,"Pass",
                    "Edit link should be displayed next to the Phone LOB",
                    "Edit Link is displayed", "Edit link should be present");
        else
            statusTracker(br,drive,"Fail",
                    "Edit link should be displayed next to the Phone LOB",
                    "Edit Link is NOT displayed", "Edit link should be present");

        boolean Appointment = Isavailable(".//*[@id='appointment']", drive);
        boolean Visit1 = Isavailable(".//*[@id='num-visits1']", drive);
        boolean Visit2 = Isavailable(".//*[@id='num-visits2']", drive);

        if (Appointment == true)
            statusTracker(br,drive,
                    "Pass",
                    "Appointment for a technician radio button should be displayed",
                    "Appointment should be present", "Appointment is displayed");
        else
            statusTracker(br,drive,
                    "Fail",
                    "Appointment for a technician radio button should be displayed",
                    "Appointment should be present",
                    "Appointment is NOT displayed");

        if (Visit1 == true && Visit2 == true)
            statusTracker(br,drive,"Pass",
                    "One & Two Visit radio buttons should be displayed",
                    "One & Two Visit options should be present",
                    "One & Two Visit options are displayed");
        else
            statusTracker(br,drive,"Fail",
                    "One & Two Visit radio buttons should be displayed",
                    "One & Two Visit options should be present",
                    "One & Two Visit options are NOT displayed");
        
        logger.info("Visit.........."+drive.findElement(By.xpath(".//*[@id='num-visits1']")).isSelected());
        
        if (drive.findElement(By.xpath(".//*[@id='num-visits1']")).isSelected())
            statusTracker(br,drive,"Pass",
                    "One Visit radio button should be selected by default",
                    "One Visit options should be selected",
                    "One Visit option is selected");
        else
            statusTracker(br,drive,"Fail",
                    "One Visit radio button should be selected by default",
                    "One Visit options should be selected",
                    "One Visit option is NOT selected");

        logger.info("Visit Value : "+return_text(".//*[@id='section-schedule']/header/label/span[1]", drive));
        if (return_text(".//*[@id='section-schedule']/header/label/span[1]", drive)
                .equals("$14.95"))
            statusTracker(br,drive,"Pass", "One Visit value should be $14.95",
                    "One Visit value should be correct",
                    "One Visit value is appropriate");
        else
            statusTracker(br,drive,"Fail", "One Visit value should be $14.95",
                    "One Visit value should be correct",
                    "One Visit value is NOT appropriate");

        if ((return_text(".//*[@class='services-table']/tbody/tr[1]/td[1]",
                drive).trim()).equals("Service Installation Fee"))
            statusTracker(br,drive,
                    "Pass",
                    "For the One Visit Install option, the Text to be verified",
                    return_text(
                            ".//*[@class='services-table']/tbody/tr[1]/td[1]",
                            drive)
                            + " is displayed.",
                    "One Visit Install Text is as Expected");
        else
            statusTracker(br,drive,
                    "Fail",
                    "For the One Visit Install option, the Text to be verified",
                    return_text(
                            ".//*[@class='services-table']/tbody/tr[1]/td[1]",
                            drive)
                            + " is displayed.",
                    "One Visit Install Text is NOT as Expected");

        if ((return_text(".//*[@class='services-table']/tbody/tr[1]/td[2]",
                drive).replace("$", "").trim().equals("14.95")))
            statusTracker(br,drive,
                    "Pass",
                    "For the One Visit Install option, the One One Visit Charges to be verified",
                    return_text(
                            ".//*[@class='services-table']/tbody/tr[1]/td[2]",
                            drive)
                            + " is displayed.",
                    "One One Visit Charges VALUE is as Expected");
        else
            statusTracker(br,drive,
                    "Fail",
                    "For the One Visit Install option, the One One Visit Charges to be verified",
                    return_text(
                            ".//*[@class='services-table']/tbody/tr[1]/td[2]",
                            drive)
                            + " is displayed.",
                    "One One Visit Charges VALUE is NOT as Expected");

        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date date = new Date();
        logger.info("Current Date 1: " + dateFormat.format(date));

        int DD_Value = Integer
                .parseInt(dateFormat.format(date).substring(3, 5));
        logger.info("DD Value : " + DD_Value);

        select_Firstchoice_Date(br,DD_Value,drive);
        Thread.sleep(10000);
        select_Secondchoice_Date(br,DD_Value,drive);
        Thread.sleep(10000);
        
    }
    
    public void ReviewOrder_ChkOneTimeCharges(String br, WebDriver drive) {
        System.out
                .println("Package_ReviewOrder_ChkOneTimeCharges - Validating OneTime Charges : "
                        + mon_total_items);
        int Rev_OneTime_CartOptions = 0;

        for (int i = 1; i < mon_total_items + 6; i++) {
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
                logger.info("One Time Charges - 4.2");
            } else {
                logger.info("One Time Charges - 4.3");
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
        
        
        for (int i = 0; i < Rev_OneTime_CartOptions; i++)
            RO_TotalOneTimeCharges += Double.parseDouble(Rev_onetime_ChargesCost[i]
                    .replace("$", ""));
        
        logger.info("RO_TotalOneTimeCharges : " + RO_TotalOneTimeCharges +" - "+return_text(
                ".//*[@title='One Time Charges']/tfoot/tr/td[2]",
                drive).replace("$", ""));
        
        RO_TotalOneTimeCharges = RO_TotalOneTimeCharges + Double.parseDouble(mon_total.replace("$", ""));

        if (df
                .format(RO_TotalOneTimeCharges)
                .toString()
                .equals(return_text(
                        ".//*[@title='One Time Charges']/tfoot/tr/td[2]",
                        drive).replace("$", ""))) {
            statusTracker(br,drive,
                    "Pass",
                    "In the Review Order page, verify if the total One Time cost is equal to the cost displayed in the One Time Cart",
                    "The totals are the same", "The totals should be the same");
        } else {
            statusTracker(br,drive,
                    "Fail",
                    "In the Review Order page, verify if the total One Time cost is equal to the cost displayed in the One Time Cart",
                    "The totals are not the same Actual: "
                            + return_text(
                                    ".//*[@title='One Time Charges']/tfoot/tr/td[2]",
                                    drive) + " Expected: $"
                            + dateformat.format(RO_TotalOneTimeCharges),
                    "The totals should be the same");
        }

    }    
    public void OrderSummary_TV_ChkMonthlyCharges(String br) {
        logger.info("TV Check");
        String summarycartname1[] = new String[10];
        String summaryrcartcost1[] = new String[10];
        int summarycartoptions1 = 0;
        for (int i = 0; i < carttotal; i++) {

            if (isElementPresent(".//*[@title='Monthly Charges']/tbody/tr["
                    + (i + 2) + "]", drive)) {
                summarycartoptions1++;

            }
        }
        logger.info("summarycartoptions1 : " + summarycartoptions1);
        for (int i = 1; i <= summarycartoptions1; i++) {
            summarycartname1[i - 1] = return_text(
                    ".//*[@title='Monthly Charges']/tbody/tr[" + (i + 1)
                            + "]/td[1]", drive);

            logger.info("name "
                    + return_text(".//*[@title='Monthly Charges']/tbody/tr["
                            + (i + 1) + "]/td[1]", drive));
            summaryrcartcost1[i - 1] = return_text(
                    ".//*[@title='Monthly Charges']/tbody/tr[" + (i + 1)
                            + "]/td[2]", drive);
            if (summaryrcartcost1[i - 1].length() > 10) {
                int index = summaryrcartcost1[i - 1].indexOf(" ");
                logger.info("index: " + index);
                summaryrcartcost1[i - 1] = summaryrcartcost1[i - 1].substring(
                        0, index);
            }
            if ((summaryrcartcost1[i - 1]).trim().equals("Free")
                    || (summaryrcartcost1[i - 1]).trim().equals("Included")) {
                summaryrcartcost1[i - 1] = "0";
            }
        }
        int judge = -1;
        logger.info("rpage 4");
        for (int i = 0; i < summarycartoptions1; i++) {
            logger.info("Item Details : " + itemname1[i] + " - "
                    + itemcost1[i]);
            logger.info("Summary Details : " + summarycartname1[i]
                    + " - " + summaryrcartcost1[i]);
            if (itemname1[i].equals(summarycartname1[i])
                    && itemcost1[i].equals(summaryrcartcost1[i])) {
                logger.info("rpage 4.2");
            } else {
                logger.info("rpage 4.3");
                judge = i;
                i = 100;
            }

        }
        logger.info("rpage 5: " + judge);
        if (judge >= 0) {
            statusTracker(br,drive,
                    "Fail",
                    "Verify if the TV Details under the Summary order section is in sync with the items chosen",
                    "Items are not proper. Item: " + judge
                            + " is incorrect. Expected: " + itemname1[judge]
                            + " " + itemcost1[judge] + " Actual: "
                            + summarycartname1[judge] + " "
                            + summaryrcartcost1[judge],
                    "Items should be the same as chosen");
        } else
            statusTracker(br,drive,
                    "Pass",
                    "Verify if the TV Details under the Summary order section is in sync with the items chosen",
                    "Items are as chosen from the cart",
                    "Items should be the same as chosen");

        logger.info("TV Check Completed");

        for (int i = 0; i < summarycartoptions1; i++)
            OS_TotalMonthlyCharges += Double.parseDouble(summaryrcartcost1[i]
                    .replace("$", ""));
    }
    

    public void OrderSummary_Phone_ChkMonthlyCharges(String br, WebDriver drive) {
        logger.info("Phone Check");
        String summarycartname3[] = new String[10];
        String summarycartcost3[] = new String[10];
        int summarycartoptions3 = 0;
        for (int i = 0; i < carttotal2; i++) {

            if (isElementPresent(".//*[@title='Monthly Charges']/tbody/tr["
                    + (i + 4) + "]", drive)) {
                summarycartoptions3++;

            }
        }
        logger.info("summarycartoptions3  : " + summarycartoptions3);
        for (int i = 1; i <= summarycartoptions3; i++) {
            summarycartname3[i - 1] = return_text(
                    ".//*[@title='Monthly Charges']/tbody/tr[" + (i + 3)
                            + "]/td[1]", drive);

            logger.info("name "
                    + return_text(".//*[@title='Monthly Charges']/tbody/tr["
                            + (i + 3) + "]/td[1]", drive));
            summarycartcost3[i - 1] = return_text(
                    ".//*[@title='Monthly Charges']/tbody/tr[" + (i + 3)
                            + "]/td[2]", drive);
            if (summarycartcost3[i - 1].length() > 10) {
                int index = summarycartcost3[i - 1].indexOf(" ");
                logger.info("index: " + index);
                summarycartcost3[i - 1] = summarycartcost3[i - 1].substring(0,
                        index);
            }
            if ((summarycartcost3[i - 1]).trim().equals("Free")
                    || (summarycartcost3[i - 1]).trim().equals("Included")) {
                summarycartcost3[i - 1] = "0";
            }
        }
        int judge = -1;
        logger.info("rpage 4");
        for (int i = 0; i < summarycartoptions3; i++) {
            logger.info("Item Details : " + itemname3[i] + " - "
                    + itemcost3[i]);
            logger.info("Review Details : " + summarycartname3[i]
                    + " - " + summarycartcost3[i]);
            if (itemname3[i].equals(summarycartname3[i])
                    && itemcost3[i].equals(summarycartcost3[i])) {
                logger.info("rpage 4.2");
            } else {
                logger.info("rpage 4.3");
                judge = i;
                i = 100;
            }

        }
        logger.info("rpage 5: " + judge);
        if (judge >= 0)
            statusTracker(br,drive,
                    "Fail",
                    "Verify if the Phone Details under the Summary order section is in sync with the items chosen",
                    "Items are not proper. Item: " + judge
                            + " is incorrect. Expected: " + itemname3[judge]
                            + " " + itemcost3[judge] + " Actual: "
                            + summarycartname3[judge] + " "
                            + summarycartcost3[judge],
                    "Items should be the same as chosen");

        else
            statusTracker(br,drive,
                    "Pass",
                    "Verify if the Phone Details under the Summary order section is in sync with the items chosen",
                    "Items are as chosen from the cart",
                    "Items should be the same as chosen");

        for (int i = 0; i < summarycartoptions3; i++)
            OS_TotalMonthlyCharges += Double.parseDouble(summarycartcost3[i]
                    .replace("$", ""));

        OS_TotalMonthlyCharges = OS_TotalMonthlyCharges + PackageAmount;
        logger.info("Phone Check Completed : " + RO_TotalMonthlyCharges);

        if (dateformat
                .format(OS_TotalMonthlyCharges)
                .toString()
                .equals(return_text(
                        ".//*[@class='services-table']/tfoot/tr/td[2]", drive)
                        .replace("$", ""))) {
            statusTracker(br,drive,
                    "Pass",
                    "In the Summary Order page, verify if the total cost is equal to the cost displayed in the Cart",
                    "The totals are the same", "The totals should be the same");
        } else {
            statusTracker(br,drive,
                    "Fail",
                    "In the Summary Order page, verify if the total cost is equal to the cost displayed in the Cart",
                    "The totals are not the same Actual: "
                            + return_text(
                                    ".//*[@class='services-table']/tfoot/tr/td[2]",
                                    drive) + " Expected: $"
                            + dateformat.format(OS_TotalMonthlyCharges),
                    "The totals should be the same");
        }
    }

    public void OrderSummary_DetailsValidation(String br,String Cust_Name,
            String Cust_ServiceAddress, WebDriver drive) throws ParseException,
            InterruptedException {
        String Actual_ServiceAddress = "";
        String Expected_ServiceAddress = "";
        String FirstDateTime = "";
        String SecondDateTime = "";
        logger.info("Calling  OrderSummary_DetailsValidation");
        logger.info("Order Summary - Cust_ServiceAddress : "
                + Cust_ServiceAddress);

        if ((return_text(
                ".//*[@class='paragraphMerge installationLOB1']/p/strong[1]",
                drive).trim()).equals("TV Phone")
                && (return_text(
                        ".//*[@class='paragraphMerge installationLOB1']/p/strong[2]",
                        drive).trim()).equals("Installation Preferences:")) {
            statusTracker(br,drive,
                    "Pass",
                    "The LOB Text details in the Order Summary page to be verified",
                    "The LOB Text details is verified.",
                    "The LOB Text details is as Expected.");
        } else
            statusTracker(br,drive,
                    "Fail",
                    "The LOB Text details in the Order Summary page to be verified",
                    "The LOB Text details is verified & text is NOT appropriate.",
                    "The LOB Text details is NOT as Expected.");

        logger.info("First Date & Time : "
                + return_text(
                        ".//*[@class='paragraphMerge firstVisitSchedule1']/p",
                        drive).replace(":00", "").trim());
        logger.info("Second Date & Time : "
                + return_text(
                        ".//*[@class='firstVisitSchedule2 paragraphMerge']/p",
                        drive).replace(":00", "").trim());

        FirstDateTime = OrderSummary_DateTimeFormat(FirstChoiceDate) + " - "
                + FirstChoiceTime;
        logger.info("FirstDateTime : " + FirstDateTime);
        logger.info("Actual Text :"
                + return_text(
                        ".//*[@class='paragraphMerge firstVisitSchedule1']/p",
                        drive));

        if (FirstDateTime.equals(return_text(
                ".//*[@class='paragraphMerge firstVisitSchedule1']/p", drive)
                .replace(":00", "").replace("Your First Choice:", "").trim()))
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

        SecondDateTime = OrderSummary_DateTimeFormat(SecondChoiceDate) + " - "
                + SecondChoiceTime;
        logger.info("SecondDateTime : " + SecondDateTime);
        if (SecondDateTime.equals(return_text(
                ".//*[@class='firstVisitSchedule2 paragraphMerge']/p", drive)
                .replace(":00", "").replace("Your Second Choice:", "").trim()))
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

        if (RO_TotalOneTimeCharges == Double.parseDouble(return_text(
                ".//*[@title='One Time Charges']/tfoot/tr/td[2]", drive)
                .replace("$", "").trim()))
            statusTracker(br,drive,
                    "Pass",
                    "The One Time Charges + Visit Fees is same as displayed in the Order Summary page",
                    return_text(
                            ".//*[@title='One Time Charges']/tfoot/tr/td[2]",
                            drive)
                            + " is displayed.", "One Time Charges VALUE : "
                            + Overall_oneTimeCharges + " is as Expected");
        else
            statusTracker(br,drive,
                    "Fail",
                    "The One Time Charges + Visit Fees is same as displayed in the Order Summary page",
                    return_text(
                            ".//*[@title='One Time Charges']/tfoot/tr/td[2]",
                            drive)
                            + " is displayed.", "One Time Charges VALUE : "
                            + Overall_oneTimeCharges + " is NOT as Expected");

        // Validating the Service Address
        Expected_ServiceAddress = Cust_Name + " "
                + Cust_ServiceAddress.replace("Service Address: ", "");
        Actual_ServiceAddress = return_text(".//*[@class='last']", drive)
                .trim();

        logger.info("Expected_ServiceAddress : "
                + Expected_ServiceAddress);
        logger.info("Actual_ServiceAddress : " + Actual_ServiceAddress);

        if (Expected_ServiceAddress.equals(Actual_ServiceAddress))
            statusTracker(br,drive,"Pass",
                    "Order Summary Page - Validating Service Address",
                    Actual_ServiceAddress,
                    "Service Address is same as the Customer Details tagged to the account");
        else
            statusTracker(br,drive,"Fail",
                    "Order Summary Page - Validating Service Address",
                    Actual_ServiceAddress,
                    "Service Address is NOT same as the Customer Details tagged to the account");

        OrderSummary_ChkBrowserBackButton(br,drive);
        Thread.sleep(15000);

        // Selecting the check box for the Terms & Conditions
        logger.info("befor the click");
        click_element(".//*[@name='order-choose-TWC']", drive);
        logger.info("Checkbox clicked....");
    }
///// Package phone function ended
    
    
    
    public void Validating_OrderSummary_DateDetails(String br, WebDriver drive) throws ParseException
    {
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

            SecondDateTime = OrderSummary_DateTimeFormat(SecondChoiceDate) + " - " + SecondChoiceTime;
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

      
                              
                              // Selecting the check box for the Terms & Conditions
            click_element(".//*[@name='order-choose-TWC']", drive);
                              logger.info("Selected the check box Terms & Conditions");
                              statusTracker(br,drive,"Pass",
                                      "Selected the check box Terms & Conditions",
                                      "Selected the check box Terms & Conditions",
                                      "Check box Terms & Conditions should be selected");
    }
    
    
    
    public void select_Firstchoice_Date1(String br,int DDValue, WebDriver drive)
            throws InterruptedException {
        
        logger.info("select_Firstchoice_Date1.....................");
        FirstChoiceDate1 = "";
        FirstChoiceTime1 = "";
        int index = 0;

        logger.info("select_Firstchoice_Date V2....2 :" + DDValue);
        click_element(".//*[@id='first-choice-date2']", drive);
        
        Thread.sleep(2000);
        
        if (DDValue > 25)
        	click_element(".//*[@class='calendar-button-month calendar-button-next']", drive);
        Thread.sleep(1000);
        List<WebElement> mylifirst1 = drive.findElements(By.xpath(".//*[@class='day']"));
        logger.info("List size : " + mylifirst1.size());

        for (int i = 0; i < mylifirst1.size(); i++) {
            if (i > 8) {
                mylifirst1.get(i).click();
                index = i;
                break;
            }
        }

        FirstChoiceDate1 = mylifirst1.get(index).getAttribute("rel");
        Thread.sleep(1000);
        logger.info("FirstChoiceDate1 V2 is " + FirstChoiceDate1);
        //logger.info("FirstChoiceDate attribute is "+drive.findElement(By.xpath(".//*[@id='first-choice-date1']")).getAttribute("value"));

        if (!FirstChoiceDate1.equals(""))
            statusTracker(br,drive,"Pass", "First Install Date V2 is entered.", "",
                    "First Install Date V2 is : " + FirstChoiceDate1 + "");
        else
            statusTracker(br,drive,"Fail", "First Install Date V2 is NOT entered.", "",
                    "First Install Date V2 is Blank");
        
     
        
        FirstChoiceTime1 = Select_DropDown_Index(drive, ".//*[@id='first-choice-time2']", 1);

        if (!FirstChoiceTime1.equals(""))
            statusTracker(br,drive,"Pass", "First Install Time V2 is entered.", "",
                    "First Install Time V2 is : " + FirstChoiceTime1 + "");
        else
            statusTracker(br,drive,"Fail", "First Install Time V2 is NOT entered.", "",
                    "First Install Time V2 is Blank");


        logger.info("FirstChoiceTime1 is " + FirstChoiceTime1);
    }
    
    
    public void select_Secondchoice_Date1(String br,int DDValue, WebDriver drive)
            throws InterruptedException {
        
        logger.info("select_Secondchoice_Date1.....................");
        SecondChoiceDate1 = "";
        SecondChoiceTime1 = "";
        int index = 0;

        logger.info("select_Secondchoice_Date V2....2 : " + DDValue);
        click_element(".//*[@id='second-choice-date2']", drive);
        Thread.sleep(3000);
        
        if (DDValue > 25)
        	click_element(".//*[@class='calendar-button-month calendar-button-next']", drive);
        Thread.sleep(2000);
        List<WebElement> mylisecond1 = drive.findElements(By.xpath(".//*[@class='day']"));
        for (int i = 0; i < mylisecond1.size(); i++) {
            if (i > 9) {
                mylisecond1.get(i).click();
                index = i;
                break;
            }
        }
        
        SecondChoiceDate1 = mylisecond1.get(index).getAttribute("rel");
        Thread.sleep(1000);
        logger.info("SecondChoiceDate V2 is " + SecondChoiceDate1);
        // logger.info("SecondChoiceDate attribute is "+drive.findElement(By.xpath(".//*[@id='second-choice-date1']")).getAttribute("value"));
        if (!SecondChoiceDate1.equals(""))
            statusTracker(br,drive,"Pass", "Second Install Date V2 is entered.", "",
                    "Second Install Date V2 is : " + SecondChoiceDate1 + "");
        else
            statusTracker(br,drive,"Fail", "Second Install Date V2 is NOT entered.", "",
                    "Second Install Date V2 is Blank");
        Thread.sleep(2000);
    
        SecondChoiceTime1 = Select_DropDown_Index(drive, ".//*[@id='second-choice-time2']", 1);
        
        if (!SecondChoiceTime1.equals(""))
            statusTracker(br,drive,"Pass", "Second Install Time V2 is entered.", "",
                    "Second Install Time V2 is : " + SecondChoiceTime1 + "");
        else
            statusTracker(br,drive,"Fail", "Second Install Time V2 is NOT entered.", "",
                    "Second Install Time V2 is Blank");

        logger.info("SecondChoicetime1 is " + SecondChoiceTime1);
    }
    
    
    
    
    public void select_Firstchoice_Date(String br,int DDValue, WebDriver drive)
            throws InterruptedException {
        FirstChoiceDate = "";
        FirstChoiceTime = "";
        int index = 0;

        logger.info("select_Firstchoice_Date....1 :" + DDValue);
      
        click_element(".//*[@id='first-choice-date1']", drive);

        
        
        Thread.sleep(2000);
        
        if (DDValue > 25)
        	click_element(".//*[@class='calendar-button-month calendar-button-next']", drive);

        Thread.sleep(3000);

        List<WebElement> mylifirst = drive.findElements(By
                .xpath(".//*[@class='day']"));
        Thread.sleep(3000);
        logger.info("List size : " + mylifirst.size());

        for (int i = 0; i < mylifirst.size(); i++) {
            if (i > 8) {
                mylifirst.get(i).click();
                index = i;
                break;
            }
        }

        FirstChoiceDate = mylifirst.get(index).getAttribute("rel");
        Thread.sleep(2000);
        logger.info("FirstChoiceDate is " + FirstChoiceDate);
        // logger.info("FirstChoiceDate attribute is "+drive.findElement(By.xpath(".//*[@id='first-choice-date1']")).getAttribute("value"));

        if (!FirstChoiceDate.equals(""))
            statusTracker(br,drive,"Pass", "First Install Date is entered.", "",
                    "First Install Date is : " + FirstChoiceDate + "");
        else
            statusTracker(br,drive,"Fail", "First Install Date is NOT entered.", "",
                    "First Install Date is Blank");

        
        Thread.sleep(2000);
        FirstChoiceTime = Select_DropDown_Index(drive, ".//*[@id='first-choice-time1']", 2);
        
        if (!FirstChoiceTime.equals(""))
            statusTracker(br,drive,"Pass", "First Install Time is entered.", "",
                    "First Install Time is : " + FirstChoiceTime + "");
        else
            statusTracker(br,drive,"Fail", "First Install Time is NOT entered.", "",
                    "First Install Time is Blank");


        logger.info("FirstChoiceTime is " + FirstChoiceTime);
    }

    public void select_Secondchoice_Date(String br,int DDValue, WebDriver drive)
            throws InterruptedException {
        SecondChoiceDate = "";
        SecondChoiceTime = "";
        int index = 0;

        logger.info("select_Secondchoice_Date....1 : " + DDValue);
        click_element(".//*[@id='second-choice-date1']", drive);
        
        Thread.sleep(3000);

        if (DDValue > 25)
        	click_element(".//*[@class='calendar-button-month calendar-button-next']", drive);

        Thread.sleep(3000);
        List<WebElement> mylisecond = drive.findElements(By
                .xpath(".//*[@class='day']"));
        Thread.sleep(2000);
        for (int i = 0; i < mylisecond.size(); i++) {
            if (i > 9) {
                mylisecond.get(i).click();
                index = i;
                break;
            }
        }
        SecondChoiceDate = mylisecond.get(index).getAttribute("rel");
        Thread.sleep(2000);
        logger.info("SecondChoiceDate is " + SecondChoiceDate);
        // logger.info("SecondChoiceDate attribute is "+drive.findElement(By.xpath(".//*[@id='second-choice-date1']")).getAttribute("value"));
        if (!SecondChoiceDate.equals(""))
            statusTracker(br,drive,"Pass", "Second Install Date is entered.", "",
                    "Second Install Date is : " + SecondChoiceDate + "");
        else
            statusTracker(br,drive,"Fail", "Second Install Date is NOT entered.", "",
                    "Second Install Date is Blank");


        
        Thread.sleep(1000);
        SecondChoiceTime = Select_DropDown_Index(drive, ".//*[@id='second-choice-time1']", 2);

        if (!SecondChoiceTime.equals(""))
            statusTracker(br,drive,"Pass", "Second Install Time is entered.", "",
                    "Second Install Time is : " + SecondChoiceTime + "");
        else
            statusTracker(br,drive,"Fail", "Second Install Time is NOT entered.", "",
                    "Second Install Time is Blank");

        logger.info("SecondChoicetime is " + SecondChoiceTime);
    }
    
    
    
    public void select_Firstchoice_Date_new(String br,int DDValue, WebDriver drive)
    		throws InterruptedException {
    	FirstChoiceDate = "";
    	FirstChoiceTime = "";
    	int index = 0;

    	logger.info("select_Firstchoice_Date....1 :" + DDValue);
    	click_element(".//*[@id='first-choice-date1']", drive);

    	Thread.sleep(5000);
    	
    	if (DDValue > 25)
    		click_element(".//*[@class='calendar-button-month calendar-button-next']", drive);
    	Thread.sleep(6000);

    	List<WebElement> mylifirst = drive.findElements(By
    			.xpath(".//*[@class='day']"));
    	
    	Thread.sleep(5000);
    	logger.info("List size : " + mylifirst.size());
    	int kl=(DDValue+3)%30;
    	int lm=kl+33;
    	int mn=0;
    for (int i = 0; i < mylifirst.size(); i++) {
    		
    		
    		if (i >= (7+kl)) {
    		if(	mylifirst.get(i).isEnabled())
    		{
    			logger.info(mylifirst.get(i)+" is enabled ");
    			mn++;
    		}
    		else if(!(mylifirst.get(i).isEnabled()))
    		{
    			logger.info(mylifirst.get(i)+" is disabled ");
    		}
    		}
    	if(mn==lm)
    	{
    		if(	!mylifirst.get(i).isEnabled())
    		{
    			statusTracker(br,drive,"Pass","Verify current date+33 is disabled for selection", "current date+33 is disabled for selection", "current date+33 should be disabled for selection");
    		}
    	
    		break;
    	}
    }
    		
    		

    	
    	
    	for (int i = 0; i < mylifirst.size(); i++) {
    		
    		
    		if (i >= (7+kl)) {
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
    		statusTracker(br,drive,"Pass", "First Install Date is entered.", "",
    				"First Install Date is : " + FirstChoiceDate + "");
    	else
    		statusTracker(br,drive,"Fail", "First Install Date is NOT entered.", "",
    				"First Install Date is Blank");

    	/*WebElement firsttime = drive.findElement(By
    			.xpath(".//*[@id='first-choice-time1']"));
    	List<WebElement> li_firsttime = firsttime.findElements(By
    			.tagName("option"));

    	int a = 0;
    	for (WebElement count : li_firsttime) {

    		logger.info(count.getText());
    		count.click();
    		a++;

    		if (a == 3) {
    			FirstChoiceTime = count.getText();
    			break;
    		}
    	}*/
    	
    	Thread.sleep(3000);
    	FirstChoiceTime = Select_DropDown_Index(drive, ".//*[@id='first-choice-time1']", 2);
    	
    	if (!FirstChoiceTime.equals(""))
    		statusTracker(br,drive,"Pass", "First Install Time is entered.", "",
    				"First Install Time is : " + FirstChoiceTime + "");
    	else
    		statusTracker(br,drive,"Fail", "First Install Time is NOT entered.", "",
    				"First Install Time is Blank");

    	/*
    	 * WebElement select_firstdatetime=drive.findElement(By.xpath(
    	 * ".//*[@id='first-choice-time1']")); select_firstdatetime.click();
    	 * List<WebElement>
    	 * li_firstdatetime=select_firstdatetime.findElements(By
    	 * .tagName("option")); //int
    	 * size_drop_firsttime=li_firstdatetime.size();
    	 * li_firstdatetime.get(2).click(); FirstChoiceTime =
    	 * li_firstdatetime.get(2).getText().trim();
    	 * li_firstdatetime.get(2).sendKeys(FirstChoiceTime);
    	 */

    	logger.info("FirstChoiceTime is " + FirstChoiceTime);
    }


    public void select_Secondchoice_Date_new(String br,int DDValue, WebDriver drive)
    		throws InterruptedException {
    	SecondChoiceDate = "";
    	SecondChoiceTime = "";
    	int index = 0;

    	logger.info("select_Secondchoice_Date....1 : " + DDValue);
    	click_element(".//*[@id='second-choice-date1']", drive);
    	
    	Thread.sleep(6000);

    	if (DDValue > 25)
    		click_element(".//*[@class='calendar-button-month calendar-button-next']", drive);
    	Thread.sleep(5000);
    	List<WebElement> mylisecond = drive.findElements(By
    			.xpath(".//*[@class='day']"));
    	Thread.sleep(2000);
    	logger.info("----->>size-------->>> :" + mylisecond );
    	for (int i = 0; i < mylisecond.size(); i++) {
    		if (i >= 8) {
    			mylisecond.get(i+5).click();
    			index = i;
    			break;
    		}
    	}
    	logger.info("-------->>value of index is:-------->" + index);
    	SecondChoiceDate = mylisecond.get(index).getAttribute("rel");
    	Thread.sleep(3000);
    	logger.info("SecondChoiceDate is " + SecondChoiceDate);
    	// logger.info("SecondChoiceDate attribute is "+drive.findElement(By.xpath(".//*[@id='second-choice-date1']")).getAttribute("value"));
    	if (!SecondChoiceDate.equals(""))
    		statusTracker(br,drive,"Pass", "Second Install Date is entered.", "",
    				"Second Install Date is : " + SecondChoiceDate + "");
    	else
    		statusTracker(br,drive,"Fail", "Second Install Date is NOT entered.", "",
    				"Second Install Date is Blank");

    	/*WebElement secondtime = drive.findElement(By
    			.xpath(".//*[@id='second-choice-time1']"));
    	List<WebElement> li_secondtime = secondtime.findElements(By
    			.tagName("option"));

    	int b = 0;
    	for (WebElement count : li_secondtime) {

    		logger.info(count.getText());
    		count.click();
    		b++;

    		if (b == 3) {
    			SecondChoiceTime = count.getText();
    			break;
    		}
    	}*/
    	
    	Thread.sleep(3000);
    	SecondChoiceTime = Select_DropDown_Index(drive, ".//*[@id='second-choice-time1']", 2);

    	if (!SecondChoiceTime.equals(""))
    		statusTracker(br,drive,"Pass", "Second Install Time is entered.", "",
    				"Second Install Time is : " + SecondChoiceTime + "");
    	else
    		statusTracker(br,drive,"Fail", "Second Install Time is NOT entered.", "",
    				"Second Install Time is Blank");

    	/*
    	 * WebElement select_seconddatetime=drive.findElement(By.xpath(
    	 * ".//*[@id='second-choice-time1']")); select_seconddatetime.click();
    	 * List<WebElement>
    	 * li_seconddatetime=select_seconddatetime.findElements(
    	 * By.tagName("option")); //int
    	 * size_drop_secondtime=li_seconddatetime.size();
    	 * li_seconddatetime.get(2).click(); SecondChoiceTime =
    	 * li_seconddatetime.get(2).getText().trim();
    	 * li_seconddatetime.get(2).sendKeys(SecondChoiceTime);
    	 */
    	logger.info("SecondChoicetime is " + SecondChoiceTime);
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
	         
	       String New = Overall_Path+"//Test_Results//NewImages";
	       logger.info(New);
	       File comp = new File(New);
	      
//	       logger.info(listOfFiles[0].getName());
	       String count = Integer.toString(Screen_Count);
	       String name = Page_Phone.concat(count) ; 
	       logger.info("File " + name);
	       	 
	       logger.info("comparison started");
	       logger.info("**********"+  "comparision started time is  "+hour+" : "+minute+" : "+second);
	   	logger.info("Success");
	   	//String name1 = name.replace(".jpg",".png");
		   File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			File output_image = new File(Overall_Path +"//Test_Results//"+Folder_Name+ "//CRH_EBF_RO_OS_Regression//"+br+"//"+name+".png");
			FileUtils.copyFile(screenshot, output_image);		
			logger.info("copied file into New Images folder"+output_image);
	      	File input_image=new File (Overall_Path+"//For_Image_Comparison//"+environment+"//CRH_EBF_RO_OS_Regression//"+br+"//"+name+".png");
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
    
	   public static int Row_locator_full_scan_validation(String Keyword,
				String f_file1, String sheet_name) throws IOException,
				BiffException {
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

			// logger.info("total number of rows--------------->" +
			// totalcount);

			int rowNum = s.getRows();
			// logger.info("***********" +rowNum);
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
						// logger.info("Row Keyword ---> " + Keyword);
						// logger.info("Row Locator ---> " + rowval);
						// return row_index;

					}

				}
			}
			return row_index;

		}
	   
	   public static int Row_locator_full_scan(String Keyword, String f_file1,
               String sheet_name) throws IOException, BiffException {
        // String Sum_onetime_ChargesOption[] = new String[10];
        File ex = new File(f_file1);
        Workbook w = Workbook.getWorkbook(ex);
        Sheet s = w.getSheet(sheet_name);

        int totalcount = 0;
        String dummy = "a";
        int ij = 0;
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

        logger.info("total number of rows--------------->" + totalcount);

        int rowNum = s.getRows();
        // logger.info("***********" +rowNum);
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
                            row_index = rowval;
                            logger.info("Row Keyword ---> " + Keyword);
                            logger.info("Row Locator ---> " + rowval);
                            // return row_index;

                     }

               }
        }
        return row_index;

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
		//Video recording - JS Start
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
//Video recording - JS End

public static void scrollToElement(String fxp, WebDriver driver){
	
	WebElement element = driver.findElement(By.xpath(fxp));
    Actions actions = new Actions(driver);
	actions.moveToElement(element);
	actions.perform();         


}
public static void scrollToElementByName(String n, WebDriver driver){
	
	WebElement element = driver.findElement(By.name(n));
    Actions actions = new Actions(driver);
	actions.moveToElement(element);
	actions.perform();         


}
public static void scrollToElementByCSSSelector(String xp, WebDriver driver){
	
	WebElement element = driver.findElement(By.cssSelector(xp));
    Actions actions = new Actions(driver);
	actions.moveToElement(element);
	actions.perform();         


}

public static void scrollToElementByLinkText(String xp, WebDriver driver){
	
	WebElement element = driver.findElement(By.linkText(xp));
    Actions actions = new Actions(driver);
	actions.moveToElement(element);
	actions.perform();         


}
}
