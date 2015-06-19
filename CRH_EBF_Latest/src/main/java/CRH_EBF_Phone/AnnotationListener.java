package CRH_EBF_Phone;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.util.Locale;
import java.util.Set;

import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.read.biff.BiffException;

import org.openqa.selenium.WebDriver;
import org.testng.IAnnotationTransformer2;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.annotations.IConfigurationAnnotation;
import org.testng.annotations.IDataProviderAnnotation;
import org.testng.annotations.IFactoryAnnotation;
import org.testng.annotations.ITestAnnotation;
public class AnnotationListener extends CommonFunctions implements ITestListener{
	@Override
	public void onStart(ITestContext arg0) {
		File dir1 = new File(".");
		try {
			spath = dir1.getCanonicalPath();
			spath = spath.replaceAll("////", "////////");
			Load_Properties_File(spath);
			inputfile=spath+path_config.getProperty("inputSheetEBF");
			data11 = new File(inputfile);
			ws11 = new WorkbookSettings();
			ws11.setLocale(new Locale("er", "ER"));
			wb11 = Workbook.getWorkbook(data11, ws11);
			sheet11 = wb11.getSheet("Phone");
			gr=sheet11.getCell(4,3).getContents();
	        
		} catch (IOException e) {
			logger.info(e.getMessage());;
		} catch (BiffException e) {
			logger.info(e.getMessage());;
		}
	
		ITestNGMethod m[] = arg0.getAllTestMethods();
		if(gr.equalsIgnoreCase("No")) {
			for(ITestNGMethod m1 : m) {
				if("RT_Phone".equals(m1.getMethodName())) {
					m1.setInvocationCount(0);
				}
			}
		} else {
			for(ITestNGMethod m1 : m) {
				if("RT_Phone_001".equals(m1.getMethodName())) {
					m1.setInvocationCount(0);
				}
			}
		}
		
	}
	@Override
	public void onTestStart(ITestResult arg0) {
		
	}
	@Override
	public void onTestSuccess(ITestResult arg0) {
		
	}
	@Override
	public void onTestFailure(ITestResult arg0) {
		
	}
	@Override
	public void onTestSkipped(ITestResult arg0) {
		
	}
	@Override
	public void onFinish(ITestContext arg0) {
		
	}
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		
	}
	@Override
	public void execute(String br, WebDriver paramDriver, String url, int loc)
			throws Exception {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String getTestCaseName() {
		// TODO Auto-generated method stub
		return null;
	}

}
