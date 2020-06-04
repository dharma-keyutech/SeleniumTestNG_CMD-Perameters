package Regression;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
/*import org.testng.Assert;
*/import org.testng.annotations.Test;



import Base.Basetest;
import Base.all_xpaths;

public class Click_contactus_passData extends Basetest  implements all_xpaths{
	// Logs to display in Consoul at Reportportal
	private static final Logger logger = LogManager.getLogger(Click_contactus_passData.class);
	
	public static String BrowserName=System.getProperty("Browsername");
	@Test(groups={"Regression"})
	public static void EmailUs() throws IOException, InterruptedException{
	
	// To read The Property File 
			Properties prop=new Properties();
			FileInputStream ip= new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/data.properties");
			prop.load(ip);
		// Send a mail From Contactus
			
	    try {
	    	
	    	// launching Browser
	    	
			launchBrowser(BrowserName);
			
			// PAssing Url 
			
			sendURL(prop.getProperty("BaseUrl"));
			 
			// Performing Click  Operation on Element
			
			click(Contactus);
			logger.info("Clicking");
			
			// Passing the Values To required Fields 
			
			   sendValue(Name, prop.getProperty("yourname"));
			   logger.info("Sending User Name");
			   
			   sendValue(Phone, prop.getProperty("phoneno"));
			    logger.info("Sending User Phno");
			   
			    sendValue(Email,prop.getProperty("emailid"));
			     logger.info("Sending User Mail ID");
			    
			     sendValue(Message, prop.getProperty(""));
			      logger.info("Passing user message ");
			      Thread.sleep(5000);
			
			   // Performing Click  Operation on Element 
			      click(SendMessageBtn);  
			      logger.info("Clicked on submit Sucessfully");
			      
			      
		} catch (Exception e) {
			

				   /* logger.error("Test Fail", e);*/
				    onTestFailure();
				    driver.quit();
				   Assert.fail("");
					
				}

		       Basetest.quitBrowser();
		       
	}
		
		      
		       
		      
		       
		       
	
	
	}
	

