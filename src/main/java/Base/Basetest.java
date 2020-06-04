package Base;
import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;

import com.epam.reportportal.message.ReportPortalMessage;

import io.github.bonigarcia.wdm.config.DriverManagerType;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
public class Basetest implements all_xpaths{
	
	public static  WebDriver driver;
    static String url;
	private static final Logger logger = LogManager.getLogger(Basetest.class);

	// Method to Lauch Browser 
	 
 
		 public static void launchBrowser(String browser) throws IOException {		
			 try{	
				if (browser.equalsIgnoreCase("IE")) {
					
			System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+"/drivers/IEDriverServer.exe");
					// create IE instance
					/*System.setProperty("webdriver.ie.driver",System.getProperty(prop.getProperty("IE")));*/
					driver = new InternetExplorerDriver();
					driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
					logger.info("IE Browser Opened Sucessfully");
				} else if (browser.equalsIgnoreCase("Chrome")) {
					
					System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/drivers/chromedriver.exe");
					// create Chrome instance
				    ChromeDriverManager.getInstance(DriverManagerType.CHROME).setup();
				   driver = new ChromeDriver();
					driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
					logger.info("Chrome Browser Opened Sucessfully");
				}
				else if(browser.equalsIgnoreCase("Firefox")){
					System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"/drivers/geckodriver.exe");
					// create Firefox instance
				    driver = new FirefoxDriver();
					driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
					logger.info("Firefox Browser Opened Sucessfully");
				}
			 }catch(Exception e){
				 System.out.println("Failed to launch Browser.");
				 logger.info("Failed to Open Browser ");
			 }
			 
		
		 }
	//Method to launch application URL
		public static void sendURL(String url) {
			
			driver.navigate().to(url);
			driver.manage().window().maximize();
			logger.info("Passing URL ");
		}
		//Method to  Close  Browser 
		public static void quitBrowser(){
			try{
				driver.close();
				//driver.quit();
				logger.info("Browser Quit Sucessfully");
				
			}catch(Exception e){
				System.out.println("Failed to Quite Browser.");
				logger.info("Failed to Quit Browser ");
			}
			
		}
		
		//Method to perform click operation
		public static void click(String contactus){
			
				driver.findElement(By.xpath(contactus)).click();
				logger.info("Click Operation Performed Sucessfully");
			
		}
		
		//Method to perform sending value to a Textbox
		public static void sendValue(String locator, String testdata) {

			try {			
				driver.findElement(By.xpath(locator)).clear();
				driver.findElement(By.xpath(locator)).sendKeys(testdata);
				logger.info("Data is Passed Sucessfully to the field");
			} catch (NoSuchElementException e) {
				System.out.println("Unable to locate and pass the data");
				logger.info("Unable to locate and pass the data");
			}
		}
		
		// Take screenshots
		public static void onTestFailure() {
			   
			 ReportPortalMessage message = null;
			    try {
			    	TakesScreenshot ts = (TakesScreenshot)driver;
			    	File srcFile = ts.getScreenshotAs(OutputType.FILE);
			    	java.util.Date d= new java.util.Date();
			    	 org.apache.commons.io.FileUtils.copyFile(srcFile, new File("./ScreenShots/"+d.toString().replace(":", "_")+".png"));
			    	/*String rp_message = "test message for ReportPortal";
			        message = new ReportPortalMessage(srcFile, rp_message);*/
			    } catch (IOException e) {
			        e.printStackTrace();
			    }
			    logger.error(message);
		   
		}
		
}
