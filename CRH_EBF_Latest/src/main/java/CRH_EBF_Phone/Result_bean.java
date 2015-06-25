package CRH_EBF_Phone;

import java.util.Comparator;

public class Result_bean {

	public  String browser;
	public  String testCase;
	public  String result ;//= new String[20000];
	public  String result_scenario;// = new String[20000];
	public  String result_actual;// = new String[20000];
	public  String result_expected ;//= new String[20000];
	
	Result_bean()
	{
		this.browser=browser;
		this.testCase=testCase;
		this.result=result;
		this.result_scenario=result_scenario;
		this.result_actual=result_actual;
		this.result_expected=result_expected;
		
	}

	public String getBrowser() {
		return browser;
	}

	public void setBrowser(String browser) {
		this.browser = browser;
	}

	public String getTestCase() {
		return testCase;
	}

	public void setTestCase(String testCase) {
		this.testCase = testCase;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getResult_scenario() {
		return result_scenario;
	}

	public void setResult_scenario(String result_scenario) {
		this.result_scenario = result_scenario;
	}

	public String getResult_actual() {
		return result_actual;
	}

	public void setResult_actual(String result_actual) {
		this.result_actual = result_actual;
	}

	public String getResult_expected() {
		return result_expected;
	}

	public void setResult_expected(String result_expected) {
		this.result_expected = result_expected;
	}
	
	public static Comparator<Result_bean> TestCaseNameComparator = new Comparator<Result_bean>() {
		
		public int compare(Result_bean r1, Result_bean r2) {
			String testCase1 = r1.getTestCase().toUpperCase();
			String testCase2 = r2.getTestCase().toUpperCase();
			
			//ascending order
			return testCase1.compareTo(testCase2);
		}
	};

}
