package CRH_EBF_Phone;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.WebDriverEventListener;
 
public class EventHandler extends CommonFunctions implements WebDriverEventListener{
	static int count=0;
	String brow;
	
	public EventHandler(String br) {
		this.brow= br;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void afterChangeValueOf(WebElement arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterClickOn(WebElement arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				logger.info("Entered bfr find ele");		
				
				if(count==0 && Isavailable(".//*[contains(text(),'No thanks')]",  driver)){	
					driver.findElement(By.xpath(".//*[contains(text(),'No thanks')]")).click();	
					logger.info("Counter "+count);
					//statusTracker(brow,"Pass", "FOUND NO THANKS POP UP", "Found", "Should find once popped up");	
					logger.info("Found No thanks buton");
						
					logger.info("Clicked on DeclineButton");
					count++;
					logger.info("Increment count "+count);
					statusTracker(brow,driver,"Pass", "Clicked on NO THANKS POP UP", "Clicked", "Should Click");
					logger.info("executed statustracker **************");}
	}

	@Override
	public void afterNavigateBack(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterNavigateForward(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterNavigateTo(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterScript(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeChangeValueOf(WebElement arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeClickOn(WebElement arg0, WebDriver driver) {
		// TODO Auto-generated method stub
		if(count==0 && Isavailable (".//*[contains(text(),'No thanks')]",  driver)){	
			driver.findElement(By.xpath(".//*[contains(text(),'No thanks')]")).click();	
			logger.info("Counter "+count);
			//statusTracker(brow,"Pass", "FOUND NO THANKS POP UP", "Found", "Should find once popped up");	
			logger.info("Found No thanks buton");
			//driver.findElement(By.className("declineButton")).click();		
			logger.info("Clicked on DeclineButton");
			count++;
			logger.info("Increment count "+count);
			//statusTracker(brow,"Pass", "Clicked on NO THANKS POP UP", "Clicked", "Should Click");
			logger.info("executed statustracker **************");
		}
		else{
			Actions actions = new Actions(driver);
			actions.moveToElement(arg0);
			actions.perform();  

		}
	}

	@Override
	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		logger.info("Entered bfr find ele");		

	       

		if(count==0 && Isavailable(".//*[contains(text(),'No thanks')]",  driver)){	
			driver.findElement(By.xpath(".//*[contains(text(),'No thanks')]")).click();	
			logger.info("Counter "+count);
			//statusTracker(brow,"Pass", "FOUND NO THANKS POP UP", "Found", "Should find once popped up");	
			logger.info("Found No thanks buton");
				
			logger.info("Clicked on DeclineButton");
			count++;
			logger.info("Increment count "+count);
			//statusTracker(brow,"Pass", "Clicked on NO THANKS POP UP", "Clicked", "Should Click");
			logger.info("executed statustracker **************");
		}
		
/*
		if(Isavailable("//*[@class='modal-button-close']", driver)){
			logger.info("Session will expire ");
			driver.findElement(By.className("modal-button-close")).click();
			statusTracker(brow,"Pass", "Session Expire: Clicked on OK", "Clicked", "Should Click");
			logger.info("Clicked on Sesion Expire Window");
		}*/
	 
		
	}
	
	@Override
	public void beforeNavigateBack(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeNavigateForward(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeNavigateTo(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeScript(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onException(Throwable arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void execute(String br,WebDriver paramDriver, String url, int loc)
            throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getTestCaseName() {
		return "";
	}

	

}
